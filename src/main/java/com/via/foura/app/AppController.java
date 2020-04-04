package com.via.foura.app;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author himadri
 * 
 * This app error controller is the entry point for home page and default error page.
 * if user enters a non existing path.
 * 
 */
@Controller
public class AppController implements ErrorController {

	static final String ERROR_PATH = "/error";
	static final String HOME_PATH = "/home";

	@RequestMapping({ "/", HOME_PATH })
	public String home() {
		return "home"; // home.html landing page will be rendered
	}

	@RequestMapping(value = ERROR_PATH)
	public String defaultErrorHandler() {
		return "404"; // In case of an error, this custom error page (404.html) will be rendered.
	}

	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
