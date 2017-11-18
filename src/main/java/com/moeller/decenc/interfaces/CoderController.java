package com.moeller.decenc.interfaces;

import com.moeller.decenc.domain.service.CoderService;
import oracle.jrockit.jfr.events.RequestableEventEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Bernd on 18.11.2017.
 *
 * Package com.moeller.decenc.interfaces
 */
@Controller
public class CoderController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CoderController.class);

  private CoderService coderService;

  @Autowired
  public CoderController(CoderService coderService){
    this.coderService = coderService;
  }

  @ModelAttribute("codeData")
  public CodeData codeData(){
    return new CodeData();
  }

  @RequestMapping(value = "/coder", method = RequestMethod.GET)
  public String coder(Model model){
    return "coder";
  }

  @RequestMapping(value = "/coder", method = RequestMethod.POST)
  public String encode(){
    return "coder";
  }

}
