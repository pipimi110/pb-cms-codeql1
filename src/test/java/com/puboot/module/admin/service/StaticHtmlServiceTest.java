package com.puboot.module.admin.service;

import com.puboot.SpringbootApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class StaticHtmlServiceTest extends SpringbootApplicationTests {

    @Autowired
    StaticHtmlService staticHtmlService;

    @Test
    void createHtml() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        staticHtmlService.makeStaticSite(request, response, true);
    }
}