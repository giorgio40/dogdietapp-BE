package com.example.dogdietappbe.controllers;

import com.example.dogdietappbe.models.LoginCreds;
import com.example.dogdietappbe.models.User;
import com.example.dogdietappbe.models.UserMinimum;
import com.example.dogdietappbe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OpenController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenStore tokenStore;

//    @PostMapping(value = "/register",
//            consumes = {"application/json"},
//            produces = {"application/json"})
//    public ResponseEntity<?> addSelf(
//            HttpServletRequest httpServletRequest,
//            @Valid
//            @RequestBody
//                    UserMinimum newminuser)
//            throws
//            Exception
//    {
//        // Create the user
//        User newuser = new User();
//
//        newuser.setUsername(newminuser.getUsername());
//        newuser.setPassword(newminuser.getPassword());
//        newuser.setEmail(newminuser.getEmail());
//
//        newuser = userService.save(newuser);
//
//        // set the location header for the newly created resource
//        // The location comes from a different controller!
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newUserURI = ServletUriComponentsBuilder.fromUriString(httpServletRequest.getServerName() + ":" + httpServletRequest.getLocalPort() +
//                        "/users/{userId}")
//                .buildAndExpand(newuser.getUserid())
//                .toUri();
//        responseHeaders.setLocation(newUserURI);
//
//        // return the access token
//        RestTemplate restTemplate = new RestTemplate();
//        String requestURI = "http://localhost" + ":" + httpServletRequest.getLocalPort() + "/api/login";
//
//        List<MediaType> acceptableMediaTypes = new ArrayList<>();
//        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.setAccept(acceptableMediaTypes);
//        headers.setBasicAuth(System.getenv("OAUTHCLIENTID"),
//                System.getenv("OAUTHCLIENTSECRET"));
//
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("grant_type",
//                "password");
//        map.add("scope",
//                "read write trust");
//        map.add("username",
//                newminuser.getUsername());
//        map.add("password",
//                newminuser.getPassword());
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map,
//                headers);
//
//        String theToken = restTemplate.postForObject(requestURI,
//                request,
//                String.class);
//
//        return new ResponseEntity<>(theToken,
//                responseHeaders,
//                HttpStatus.CREATED);
//    }

//    @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
//    public ResponseEntity<?> loginSelf(HttpServletRequest req, @Valid @RequestBody LoginCreds creds)
//    {
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI userUri = ServletUriComponentsBuilder.fromUriString(req.getServerName() + ":" + req.getLocalPort() +
//                "/users/user/{userid}").buildAndExpand(userService.findUserByUsername(creds.getUsername()).getUserid()).toUri();
//        responseHeaders.setLocation(userUri);
//
//        RestTemplate restTemplate = new RestTemplate();
//        String requestURI = "http://localhost" + ":" + req.getLocalPort() + "/oauth/token";
//
//        List<MediaType> acceptableMediaTypes = new ArrayList<>();
//        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.setAccept(acceptableMediaTypes);
//        headers.setBasicAuth(System.getenv("OAUTHCLIENTID"),
//                System.getenv("OAUTHCLIENTSECRET"));
//
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("grant_type",
//                "password");
//        map.add("scope",
//                "read write trust");
//        map.add("username",
//                creds.getUsername());
//        map.add("password",
//                creds.getPassword());
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map,
//                headers);
//
//        String theToken = restTemplate.postForObject(requestURI,
//                request,
//                String.class);
//
//        return new ResponseEntity<>(theToken, responseHeaders, HttpStatus.OK);
//    }

    /**
     * Logout self response entity.
     *
     * @param req the req
     * @return the response entity
     */
    @GetMapping(value = {"/oauth/revoke-token", "/logout"})
    public ResponseEntity<?> logoutSelf(HttpServletRequest req)
    {
        String authHeader = req.getHeader("Authorization");
        if( authHeader != null)
        {
            String tokenVal = authHeader.replace("Bearer", "").trim();
            OAuth2AccessToken token = tokenStore.readAccessToken(tokenVal);
            tokenStore.removeAccessToken(token);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Return no favicon.
     */
    @ApiIgnore
    @GetMapping("favicon.ico")
    public void returnNoFavicon() {}

}
