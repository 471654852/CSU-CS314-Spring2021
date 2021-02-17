package com.tco.requests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFindRequest {

    private FindRequest conf;

    @BeforeEach
    public void createConfigurationForTestCases() {
        conf = new FindRequest();
        conf.buildResponse();
    }

    @Test
    @DisplayName("Request type is \"find\"")
    public void testType() {
        String type = conf.getRequestType();
        assertEquals("find", type);
    }

    // @Test
    // @DisplayName("Features includes \"config\"")
    // public void testFeatures(){
    //     assertTrue(conf.validFeature("config"));
    // }

    // @Test
    // @DisplayName("Team name is t16 404 Brain Not Found")
    // public void testServerName() {
    //     String name = conf.getServerName();
    //     assertEquals("t16 404 Brain Not Found", name);
    // }
}
