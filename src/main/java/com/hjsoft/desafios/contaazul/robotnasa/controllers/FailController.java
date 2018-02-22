package com.hjsoft.desafios.contaazul.robotnasa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created on 1/11/2018.
 */
@RestController
public class FailController extends AbstractErrorController {

	private static final String ERROR_PATH = "/error";

    @Autowired
    public FailController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

	@RequestMapping(ERROR_PATH)
	public ResponseEntity<?> handleErrors(HttpServletRequest request) {

        HttpStatus status = getStatus(request);

        Map<String, Object> errorAttributes = getErrorAttributes(request, false);

        String errorFormat;

        if( status == HttpStatus.NOT_FOUND && errorAttributes.get("path").equals("/") )
        {
            errorFormat = "Invalid path, the only valid path is /rest/mars/{command}\n";
        }
        else
          errorFormat = String.format("%s %s\n", errorAttributes.get("status"), errorAttributes.get("error") );

        return ResponseEntity.status(status).body( errorFormat );
    }

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}