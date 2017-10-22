package com.moeller.decenc.domain.model;

import java.util.UUID;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bernd on 21.10.2017.
 *
 * Package com.moeller.decenc.domain.model
 */

@XmlRootElement
public class Probe {

  public enum CalcType {
    BASE64,
    URLENCODE
  }
  private UUID id;
  private String inputText;
  private String resultText;
  private CalcType calcType;




  public String getInputText() {
    return inputText;
  }

  public void setInputText(String inputText) {
    this.inputText = inputText;
  }

  public String getResultText() {
    return resultText;
  }

  public void setResultText(String resultText) {
    this.resultText = resultText;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public CalcType getCalcType() {
    return calcType;
  }

  public void setCalcType(CalcType calcType) {
    this.calcType = calcType;
  }
}
