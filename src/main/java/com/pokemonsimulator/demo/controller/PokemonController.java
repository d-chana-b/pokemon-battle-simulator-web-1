package com.pokemonsimulator.demo.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.pokemonsimulator.demo.model.Move;
import com.pokemonsimulator.demo.model.Pokemon;
import com.pokemonsimulator.demo.service.MoveService;
import com.pokemonsimulator.demo.service.PokemonService;
import com.pokemonsimulator.demo.utilities.FileUploadUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PokemonController {
    
     // inject the pokemon service here
     @Autowired
     PokemonService pokemonService;

     @Autowired
     MoveService moveService;
 
     @GetMapping("/admin/pokemonlist")
     public String pokemonList(Model model) {
 
         model.addAttribute("pokemonList", pokemonService.getAllPokemon());
 
         return "pokemon-home-page";
     }
 
     @GetMapping("/admin/pokemon/add")
     public String showPokemonForm(Model model) {
 
         // when requesting to this url, this method will give a model object to the page
         // of this return method
 
         model.addAttribute("pokemon", new Pokemon());
         List<String> types = Arrays.asList("Normal", "Fire", "Water", "Grass", "Electric", "Psychic", "Ice", "Dark",
                 "Dragon", "Fighting", "Flying", "Poison", "Ground", "Rock", "Bug", "Ghost", "Steel");
         model.addAttribute("types", types);
         // none
 
         return "addpokemon";
     }
 
     // @modelattribute use for binding a method parameter or method return value to
     // a named model attribute, and then exposes it to a web view
     // @RequestParam is used to read html form data provided by a user and bind it
     // to the request parameter
     @PostMapping("/admin/pokemon/add")
     public String addPokemon(@ModelAttribute("pokemon") Pokemon pokemon,
             @RequestParam("image") MultipartFile multipartFile, RedirectAttributes redirectAttributes)
             throws IOException {
 
         String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
         pokemon.setImageName(fileName); // the image name and save the name only to the database
 
         // and the image file will stored in the file system
         String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/assets/pokemonImages";
 
         // utility class to handle file uploading
         FileUploadUtil.saveFile(multipartFile, uploadDir);
         pokemonService.savePokemon(pokemon);
         redirectAttributes.addFlashAttribute("success","Pokemon added succesfully.");
 
         return "redirect:/admin/pokemon/add";
     }
 
     @GetMapping("/admin/pokemon/update/{id}")
     public String updatePokemonDetails(@PathVariable Long id, Model model) {
         Optional<Pokemon> pokemon = pokemonService.getPokemonById(id);
         List<String> types = Arrays.asList("Normal", "Fire", "Water", "Grass", "Electric", "Psychic", "Ice", "Dark",
                 "Dragon", "Fighting", "Flying", "Poison", "Ground", "Rock", "Bug", "Ghost", "Steel");
         model.addAttribute("types", types);
 
         if (pokemon.isPresent()) {
             model.addAttribute("pokemon", pokemon.get());
             return "addpokemon";
         } else {
             return "404";
         }
     }
 
     @GetMapping("/admin/pokemon/pokemon-details/{id}")
     public String viewPokemonDetails(Model model, @PathVariable Long id){
         model.addAttribute("pokemon", pokemonService.getPokemonById(id).get());
         model.addAttribute("moves", moveService.getAllMoves());
         return "pokemondetails";
     }

     @GetMapping("/admin/pokemon/pokemon-details/add-move")
     public String addMoveToPokemon(@RequestParam("pokemonId") Long pokemonid,@RequestParam("moveId") Long moveid){
        
        Optional<Pokemon> pokemon = pokemonService.getPokemonById(pokemonid);
        Optional<Move> move = moveService.getMoveById(moveid);

        //problem here is naooveride lang ung laman
        //gawa ka code pang check if present later on
        pokemonService.addMove(pokemon.get(), move.get());
        return "redirect:/admin/pokemon/pokemon-details/"+pokemonid;//to redirect to the page of the current pokemon
     }
}
