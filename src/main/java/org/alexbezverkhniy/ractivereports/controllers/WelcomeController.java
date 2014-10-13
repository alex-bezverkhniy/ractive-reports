package org.alexbezverkhniy.ractivereports.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alex Bezverkhniy on 10/9/14.
 */
@Controller
public class WelcomeController {

    final static Logger log = LoggerFactory.getLogger(WelcomeController.class);

    @RequestMapping("/")
    public String index(){
        log.info("index");
        return "index";
    }

    @RequestMapping("/**/**.html")
    public String htmlPages(HttpServletRequest request){
        return ControllersUtils.mapHtmlPage(request);
    }

    @RequestMapping("layout")
    public String layout(){
        log.info("layout");
        return "layouts/default";
    }


}