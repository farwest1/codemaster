package com.moeller.decenc.interfaces;

import com.moeller.decenc.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Created by Bernd on 22.10.2017.
 *
 * Package com.moeller.decenc.interfaces
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class DecodeControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup(){
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void encode() throws Exception{
    mockMvc.perform(
        get("/encode?tobeencoded=123"))
        .andExpect(status().is(200))
        .andExpect(content().string("MTIz"));
  }

  @Test
  public void decode() throws Exception{
    mockMvc.perform(
        get("/decode?tobedecoded=MTIz"))
        .andExpect(status().is(200))
        .andExpect(content().string("123"));
  }

}
