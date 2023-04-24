package com.example.demo.ControllersPackage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAOPackage.UsersDao;
import com.example.demo.SecurityPackg.loginuser;
import com.example.demo.ServicePackg.myUsersConfigClass;
import com.example.demo.ServicePackg.servicePackage;
import com.example.demo.modelPackage.UsersModel;
//@CrossOrigin(origins= {"*"}, maxAge = 2400, allowCredentials = "false" )
@RestController
public class SecController {
	@Autowired
	private myUsersConfigClass uses;

	private AuthenticationManager manager;

	@Autowired
	private servicePackage myservice;

	@PostMapping(value = "/adduser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsersModel> saveuser(@RequestBody UsersModel Umodel) {
		System.out.println("string " + Umodel);
		ModelMapper model = new ModelMapper();
		model.typeMap(UsersModel.class, UsersDao.class).addMappings(mymapper -> {
			mymapper.map(mysource -> mysource.getMemberID(), UsersDao::setStringone);
			mymapper.map(mysource -> mysource.getFname(), UsersDao::setStringtwo);
			mymapper.map(mysource -> mysource.getSname(), UsersDao::setStringfour);
			mymapper.map(mysource -> mysource.getPwrd(), UsersDao::setStringseven);
			mymapper.map(mysource -> mysource.getEmail(), UsersDao::setStringten);
			mymapper.map(mysource -> mysource.getAuth(), UsersDao::setStringtwelve);
			mymapper.map(mysource -> mysource.getEna(), UsersDao::setStringfiften);
			mymapper.map(mysource -> mysource.getUname(), UsersDao::setStringthree);
		});
		UsersDao udao = model.map(Umodel, UsersDao.class);
		if (udao != null) {

			System.out.println(" the we are " + udao);
			myservice.savemyuser(udao);

		}

		return null;
	}

	
	  @PostMapping( value="/login" )
	public ResponseEntity<?> customelogin(@RequestParam  String username, @RequestParam String password) {

		  System.out.println(username+"  "+password);
		try {
			UserDetails userDetails = uses.loadUserByUsername(username);
			System.out.println("hhhhhhhhh");
			UsernamePasswordAuthenticationToken mytoken = new UsernamePasswordAuthenticationToken(userDetails, password,
					userDetails.getAuthorities());
			Authentication authenticate = manager.authenticate(mytoken);
			SecurityContextHolder.getContext().setAuthentication(authenticate);
		//	HttpSession ses = customerequest.getSession(true);
		//	ses.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				//	SecurityContextHolder.getContext());

			return ResponseEntity.ok().build();
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

	}
     
	  
	  @GetMapping(value = "/dummy")
	  public void testmethod() {
		  System.out.println("hitting my method");
		  
	  }
	  
	  
}
