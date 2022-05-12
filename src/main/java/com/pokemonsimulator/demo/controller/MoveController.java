package com.pokemonsimulator.demo.controller;

import java.util.Arrays;
import java.util.List;


import com.pokemonsimulator.demo.model.Move;
import com.pokemonsimulator.demo.service.MoveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MoveController {

    @Autowired
    MoveService moveService;

    @GetMapping("/admin/moves") // movelist
    public String showMoves(Model model) {
        model.addAttribute("movelist",moveService.getAllMoves());
        return "move-home-page";
    }

    @GetMapping("/admin/moves/add")
    public String showMoveForm(Model model) {
        model.addAttribute("move", new Move());// this is the object(move) that bind to the postmapping model attribute
        List<String> moveTypes = Arrays.asList("Normal", "Fire", "Water", "Grass", "Electric", "Psychic", "Ice", "Dark",
                "Dragon", "Fighting", "Flying", "Poison", "Ground", "Rock", "Bug", "Ghost", "Steel");
        model.addAttribute("movetypes", moveTypes);
        List<String> moveCategories = Arrays.asList("Physical","Special","Status");
        model.addAttribute("movecategory",moveCategories);
        return "addmove";
    }

    @PostMapping("/admin/moves/add")
    public String addMove(@ModelAttribute("move") Move move) {

        moveService.saveMove(move);

        return "redirect:/admin/moves/add";
    }

}
