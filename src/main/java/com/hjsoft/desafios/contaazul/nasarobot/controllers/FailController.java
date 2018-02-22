/**
 *  This controller handles errors.
 *  Returning the desired error format string.
 *
 * @author hjotha
 */
package com.hjsoft.desafios.contaazul.nasarobot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Control failures.
 */
@RestController
public class FailController extends AbstractErrorController {

    private static final String ERROR_PATH = "/error";

    /**
     *  Check documentation for Spring AbstractErrorController
     *
     *  @param errorAttributes Exception attributes
     */
    @Autowired
    public FailController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    /**
     * This method receives the error request and returns the suitable
     * format for error response.
     * If the requested path is / it returns the valid path for requests.
     *
     * @param request the current error request.
     * @return The status code and body of response.
     */
    @RequestMapping(ERROR_PATH)
    public ResponseEntity<?> handleErrors(HttpServletRequest request) {

        // get status
        HttpStatus status = getStatus(request);

        // get exception attributes
        Map<String, Object> errorAttributes = getErrorAttributes(request, false);

        String errorFormat;

        // if asking for the root, return the valid one.
        if (status == HttpStatus.NOT_FOUND && errorAttributes.get("path").equals("/")) {
            errorFormat = "Invalid path, the only valid path is /rest/mars/{command}\n";
        } else {
            // else return format <errorcode> <error description>
            errorFormat = String.format("%s %s\n", errorAttributes.get("status"), errorAttributes.get("error"));
        }

        return ResponseEntity.status(status).body(errorFormat);
    }

    /**
     * Gets the error path string.
     *
     * @return the error path.
     */
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}