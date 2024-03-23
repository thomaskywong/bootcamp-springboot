package com.vtxlab.bootcamp.practisesbthymeleaf.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface CryptoOperation {

  @GetMapping(value = "/")
  String helloWorld(Model model);
  
}
