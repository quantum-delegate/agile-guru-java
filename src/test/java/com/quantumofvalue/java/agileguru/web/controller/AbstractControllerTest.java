package com.quantumofvalue.java.agileguru.web.controller;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.quantumofvalue.java.agileguru.test.config.ControllerTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes  = {ControllerTestConfig.class})
@ActiveProfiles("test")
public class AbstractControllerTest {
	
}
