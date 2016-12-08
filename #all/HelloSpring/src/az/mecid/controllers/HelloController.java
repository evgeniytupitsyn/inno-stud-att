package az.mecid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping(value = "/test.form",method = RequestMethod.GET)
    public String test(@RequestParam("name") String name, ModelMap model){
        model.addAttribute("name",name);
        return "hello";
    }
}
