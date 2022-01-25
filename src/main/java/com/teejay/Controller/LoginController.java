package com.teejay.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.teejay.Model.User;
import com.teejay.Service.LoginService;
import com.teejay.Utils.TeejayUtils;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("/teejay")
public class LoginController {

  @Autowired
  LoginService loginService;

  @Autowired
  TeejayUtils teejayUtils;

  /**
   * Method to test some of the api calls.
   * 
   * @param no params
   * 
   * @throws Exception
   */
  @RequestMapping(value = "/test", produces = "application/json", method = RequestMethod.GET)
  public List getLtptest() throws Exception {
    try {
		return loginService.dbTest();
    } catch (Exception e) {
      // TODO: handle exception
      throw new Exception();
    }

  }

  /*
   * Method to login to the system
   * 
   * @param String loginId
   * 
   * @param String password
   * 
   * @return List<User>
   */
  @RequestMapping(value = "/login/{loginId}/{password}", produces = "application/json", method = RequestMethod.POST)
  public User doLogin(@PathVariable String loginId, @PathVariable String password) throws Exception {

    try {
      return loginService.doLogin(loginId, password);
    } catch (Exception e) {
      // TODO: handle exception
      throw new Exception();
    }

  }

  /*
   * Method to signup to the system and it will enter a record in the database
   * 
   * @param User user
   * 
   * @return User
   */
  @RequestMapping(value = "/signup", produces = "application/json", method = RequestMethod.POST)
  public ResponseEntity < User > signup(@RequestBody User user) throws Exception {
    try {
      user = teejayUtils.userMapper(user);
      user = loginService.doSignup(user);
      return new ResponseEntity < > (user, HttpStatus.OK);
    } catch (Exception e) {
      // TODO: handle exception
      throw new Exception();

    }

  }

}