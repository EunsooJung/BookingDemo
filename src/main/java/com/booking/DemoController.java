/**
 * Controller class:
 */
package com.booking;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author EUNSOO
 *
 */
@RestController
public class DemoController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello";
	}

}
