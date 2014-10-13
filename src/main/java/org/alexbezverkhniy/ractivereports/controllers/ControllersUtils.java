package org.alexbezverkhniy.ractivereports.controllers;

import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alex Bezverkhniy on 10/9/14.
 */
public class ControllersUtils {
    public static String mapHtmlPage(HttpServletRequest request) {
        String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        if(restOfTheUrl.indexOf(".html") > 0) {
            return restOfTheUrl.replace(".html", "");
        } else {
            return restOfTheUrl+"/index.html";
        }
    }
}
