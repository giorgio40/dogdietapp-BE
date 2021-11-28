package com.example.dogdietappbe.controllers;

import com.example.dogdietappbe.models.LoginCreds;
import com.example.dogdietappbe.models.User;
import com.example.dogdietappbe.models.UserMinimum;
import com.example.dogdietappbe.models.UserRoles;
import com.example.dogdietappbe.services.RoleService;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class OAUTHEndpoints {

    @Autowired
    private UserService userService;

    /**
     * A method in this controller adds a new user to the application with the role User so needs access to Role Services to do this.
     */
    @Autowired
    private RoleService roleService;

    /**
     * Connect to the Token store so the application can remove the token
     */
    @Autowired
    private TokenStore tokenStore;

    /**
     * This endpoint always anyone to create an account with the default role of USER. That role is hardcoded in this method.
     *
     * @param httpServletRequest the request that comes in for creating the new user
     * @param newminuser         A special minimum set of data that is needed to create a new user
     * @return The token access and other relevent data to token access. Status of CREATED. The location header to look up the new user.
     * @throws URISyntaxException we create some URIs during this method. If anything goes wrong with that creation, an exception is thrown.
     */

    /**
     * Removes the token for the signed on user. The signed user will lose access to the application. They would have to sign on again.
     *
     * <br>Example: <a href="http://localhost:2019/logout">http://localhost:2019/logout</a>
     *
     * @param request the Http request from which we find the authorization header which includes the token to be removed
     */
    // yes, both endpoints are mapped to the same Java method! So, either one will work.
    @GetMapping(value = {"/oauth/revoke-token", "/logout"},
            produces = "application/json")
    public ResponseEntity<?> logoutSelf(HttpServletRequest request)
    {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null)
        {
            // find the token
            String tokenValue = authHeader.replace("Bearer",
                            "")
                    .trim();
            // and remove it!
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
            tokenStore.removeAccessToken(accessToken);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}




