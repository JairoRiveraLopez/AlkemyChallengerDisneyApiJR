package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.web.controller;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service.impl.UserServiceImpl;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.ApiUser;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.web.security.AuthenticationRequest;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.web.security.AuthenticationResponse;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.web.security.JWTConfig.JWTUtil;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.web.security.services.ApiUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApiUserDetailsService apiUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> user() throws Exception{

        UserDetails userDetails = (UserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ApiUser user = new ApiUser();
        user.setName(userDetails.getUsername());

        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<ApiUser> createToken(@RequestBody ApiUser apiUser){
        return new ResponseEntity<>(userServiceImpl.save(apiUser), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) throws Exception {
            try {
                authenticationManager.authenticate(new
                        UsernamePasswordAuthenticationToken(request.getUsername(),
                        request.getPassword()));
            }catch (BadCredentialsException e) {
                throw new Exception("Incorrect", e);
            }
            final UserDetails userDetails =
                    apiUserDetailsService.loadUserByUsername(request.getUsername());

            final String jwt = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse((jwt)));
        }
    }
