package com.example.gamestore.controller;

import com.example.gamestore.data.DemoData;
import com.example.gamestore.model.Company;
import com.example.gamestore.model.Game;
import com.example.gamestore.model.Review;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    @Autowired
    private DemoData demoData;

    @GetMapping("/games")
    public String getGames(Model model) {
        model.addAttribute("games", this.demoData.findAllGames());
        return "ListaIgara";
    }

    @GetMapping("/reviews")
    public String getReviews(Model model) {
        List<Review> sortedReviews = this.demoData.findAllReviews().stream()
                .sorted((r1, r2) -> r1.getGame().getTitle().compareToIgnoreCase(r2.getGame().getTitle()))
                .collect(Collectors.toList());
        model.addAttribute("reviews", sortedReviews);
        return "ListaReview";
    }

    @GetMapping("/game/action/{id}")
    public String gameDetails(@PathVariable Long id, Model model) {
        Game game = this.demoData.findGame(id);
        if (game == null) {
            return "redirect:/games";
        } else {
            model.addAttribute("game", game);
            model.addAttribute("reviews", this.demoData.findReviewsByGame(id));
            return "action";
        }
    }

    @PostMapping("/game/addReview/{id}")
    public String addReview(@PathVariable Long id,
                            @RequestParam String author,
                            @RequestParam String comment,
                            @RequestParam int rating,
                            Model model) {
        Game game = this.demoData.findGame(id);
        if (game == null) {
            return "redirect:/games";
        } else {
            // Kreiramo Review koristeći ispravna polja
            Review newReview = new Review(author, comment, (double) rating, game);
            this.demoData.saveReview(newReview);

            model.addAttribute("game", game);
            model.addAttribute("reviews", this.demoData.findReviewsByGame(id));
            return "action";
        }
    }


    @GetMapping("/companies")
    public String getCompanies(Model model) {
        model.addAttribute("companies", this.demoData.findAllCompanies());
        return "ListaCompanies";
    }

    @GetMapping("/company/add")
    public String addCompanyForm(Model model) {
        model.addAttribute("company", new Company());
        return "AddCompany";
    }

    @PostMapping("/company/add")
    public String addCompanySubmit(@ModelAttribute Company company) {
        this.demoData.saveCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/company/edit/{id}")
    public String editCompanyForm(@PathVariable Long id, Model model) {
        Company company = this.demoData.findCompany(id);
        if (company == null) {
            return "redirect:/companies";
        } else {
            model.addAttribute("company", company);
            return "EditCompany";
        }
    }

    @PostMapping("/company/update")
    public String updateCompany(@ModelAttribute Company updatedCompany) {
        Company company = this.demoData.findCompany(updatedCompany.getId());
        if (company != null) {
            company.setName(updatedCompany.getName());
        }
        return "redirect:/companies";
    }

    // API endpoints
    @GetMapping("/api/companies")
    @ResponseBody
    public List<Company> getCompaniesJson() {
        return this.demoData.findAllCompanies();
    }

    @GetMapping("/api/companies/{id}")
    @ResponseBody
    public Company getCompanyByIdJson(@PathVariable Long id) {
        return this.demoData.findCompany(id);
    }
}
