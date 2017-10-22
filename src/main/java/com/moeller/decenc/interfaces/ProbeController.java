package com.moeller.decenc.interfaces;

import com.moeller.decenc.domain.model.Probe;
import com.moeller.decenc.domain.model.Probe.CalcType;
import com.moeller.decenc.domain.service.CoderService;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bernd on 22.10.2017.
 *
 * Package com.moeller.decenc.interfaces
 */
@RestController
public class ProbeController {

  public static final Logger LOGGER = LoggerFactory.getLogger(ProbeController.class);

  @Autowired
  CoderService coderService;

  @RequestMapping(value = "/probe",
      method = RequestMethod.POST,
      consumes = "application/xml",
      produces = "application/xml")
  public ResponseEntity<Probe> addProbe(@RequestBody Probe probe, HttpServletResponse response, HttpServletRequest request){
    LOGGER.debug("new Probe added");
    return ResponseEntity.accepted().body(probe);
  }

  @RequestMapping(value = "/probe",
      method = RequestMethod.GET,
      produces = "application/xml")
  public ResponseEntity<Probe> dummyProbe(){
    Probe probe = new Probe();
    probe.setId(UUID.randomUUID());
    probe.setCalcType(CalcType.BASE64);
    probe.setInputText("123");
    probe.setResultText(coderService.encode("123"));
    return ResponseEntity.ok(probe);

  }

}
