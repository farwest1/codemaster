package com.moeller.decenc.interfaces;

import com.moeller.decenc.domain.service.CoderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bernd on 18.11.2017.
 *
 * Package com.moeller.decenc.interfaces
 */
@Controller
@RequestMapping("/coder")
public class CoderController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CoderController.class);

  private CoderService coderService;


  @Autowired
  public CoderController(CoderService coderService){
    this.coderService = coderService;
  }


  @GetMapping
  public String coder(Model model){
    CodeData codeData = new CodeData();
    codeData.setPlainData("1234");
    model.addAttribute("codeData", codeData);
    return "coder";
  }

  @PostMapping
  public String encode( CodeData codeData){
    LOGGER.debug("encode data...");
    codeData.setCodedData(coderService.encode(codeData.getPlainData()));
    return "coder";
  }

}
