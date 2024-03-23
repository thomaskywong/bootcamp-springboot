package com.vtxlab.bootcamp.practisesbthymeleaf.controller.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.vtxlab.bootcamp.practisesbthymeleaf.controller.CryptoOperation;
import com.vtxlab.bootcamp.practisesbthymeleaf.model.Coin;

// Cannot use Thymeleaf template with @ResponseBody, since Thymeleaf does not use JSON
@Controller
@RequestMapping(value = "/api/v1")
public class CryptoController implements CryptoOperation{

  @Override
  public String helloWorld(Model model) {

    Coin c1 = new Coin(1, "bitcoin", 500.0);
    Coin c2 = new Coin(2, "ethereum", 200.0);
    Coin c3 = new Coin(3, "tether", 100.0);

    List<Coin> coins = new LinkedList<>(List.of(c1, c2, c3));
    
    model.addAttribute("coins", coins);

    // return name of html file (cryptocurency.html) under resources/template/ folder
    return "cryptocurrency";

  }
  
}
