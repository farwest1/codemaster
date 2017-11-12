package com.moeller.decenc.interfaces;

import com.moeller.decenc.domain.model.Version;
import com.moeller.decenc.domain.service.VersionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Bernd on 12.11.2017.
 *
 * Package com.moeller.decenc.interfaces
 */

@Controller
public class ConfigController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);

  private VersionService versionService;

  @Autowired
  public ConfigController(VersionService versionService){
    this.versionService = versionService;
  }


  @RequestMapping("/config")
  public String config(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    LOGGER.info("GET config called");
    model.addAttribute("name", name);
    model.addAttribute("version", versionService.getVersion());
    return "config";
  }

  @RequestMapping(value = "/config", params={"save"},method = RequestMethod.POST)
  public String setVersion(final Version version){

    LOGGER.info("Post config called");
    versionService.setVersion(version);
    return "config";
  }
}
