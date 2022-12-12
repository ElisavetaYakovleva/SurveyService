package Survey.controllers;

import Survey.models.User;
import Survey.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная");
        return "home";
    }
}



   /* @GetMapping("/")
    public String mainPage(
            @AuthenticationPrincipal User user,
            Authentication authentication,
            @RequestParam(name = "typeId", required = false) Integer typeId,
            Model model) {

        String auth = user.getAuthorities().toString();


        model.addAttribute("authority", auth);
        model.addAttribute("types", typeService.getAllTypes());
        model.addAttribute("typeId", typeId);
        model.addAttribute("title", "Каталог");
        Iterable<Clothes> clothes = clothesRepository.findAll();
        model.addAttribute("clothes", clothes);


        if (typeId == null) {
            model.addAttribute("clothes", clothes);
        }
        else{
            model.addAttribute("clothes", clothesService.getAllItemsByTypeId(typeId));
        }

        return "index";
    }*/

 //   @Controller
//    public class ItemsController {

//        @GetMapping("/page/{id}")
//        public String clothesPage(
//                @AuthenticationPrincipal User user,
//                @PathVariable(value="id") int id,
//                Model model) {
//
//            Clothes item = clothesService.getItemById(id);
//
//            model.addAttribute("item", item);
//            model.addAttribute("itemId", id);
//            model.addAttribute("item_type", typeService.getTypeById(item.getTypeId()));
//            model.addAttribute("types", typeService.getAllTypes());
//
//            Optional<Clothes> clothes = Optional.ofNullable(clothesRepository.findById(id));
//            ArrayList<Clothes> res = new ArrayList<>();
//            clothes.ifPresent(res::add);
//            model.addAttribute("clothes", res);
//
//            return "item-desc";
//        }


    /*private int getUserId(Authentication authentication) {
        if (authentication == null)
            return 0;
        else
            return ((User)userService.loadUserByUsername(authentication.getName())).getId();
    }*/



