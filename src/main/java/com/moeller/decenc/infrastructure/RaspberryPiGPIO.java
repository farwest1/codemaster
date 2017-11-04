package com.moeller.decenc.infrastructure;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Bernd on 29.10.2017.
 *
 * Package com.moeller.decenc.infrastructure
 */
public class RaspberryPiGPIO {

  private static Logger LOGGER = LoggerFactory.getLogger(RaspberryPiGPIO.class);
  private GpioPinDigitalOutput outputPin;

  public GpioPinDigitalOutput getOutputPin() {
    return outputPin;
  }

  public void setOutputPin(GpioPinDigitalOutput outputPin) {
    this.outputPin = outputPin;
  }

  public void init(){
    // create gpio controller
    LOGGER.debug("Initialize Raspberry Pi GPIO");
    GpioController gpio = GpioFactory.getInstance();

    // provision gpio pin #01 as an output pin and turn off
    LOGGER.debug("Init GPIO_4 as output");
    this.outputPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.LOW);
    LOGGER.info("Raspberry PI Initialization done");
  }

}
