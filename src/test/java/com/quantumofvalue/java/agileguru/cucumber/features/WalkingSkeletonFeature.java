package com.quantumofvalue.java.agileguru.cucumber.features;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:com/quantumofvalue/java/agileguru/cucumber/features/WalkingSkeleton.feature",
        glue="com.quantumofvalue.java.agileguru.cucumber.stepdefinitions")
public class WalkingSkeletonFeature {
}
