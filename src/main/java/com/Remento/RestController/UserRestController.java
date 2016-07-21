package com.Remento.RestController;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Remento.Service.UserService;

@Controller
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping ( value="/rest/idCheck", method = { RequestMethod.POST, RequestMethod.GET } )
	public ResponseEntity<Integer> idCheck (
			@RequestParam (value = "userId") String userId
			) {
		
		int req = 0;
		
		try {
			req = userService.idCheck(userId);
		} catch ( DataAccessException e ) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println( userId );
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return new ResponseEntity<Integer> ( req, header, HttpStatus.OK );
	}
	
}
