package com.harshmali.gateway.controllers;


import com.harshmali.gateway.model.AuthResponse;
import com.nimbusds.openid.connect.sdk.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthController {

    @GetMapping("login")
    public ResponseEntity<AuthResponse>login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient oktaclient,
            @AuthenticationPrincipal OidcUser oidcUser,
            Model model

    ){
        AuthResponse authresponse= new AuthResponse();
        authresponse.setUserId(oidcUser.getEmail());
        authresponse.setAccessToken(oktaclient.getAccessToken().getTokenValue());
        authresponse.setRefreshToken(oktaclient.getRefreshToken().getTokenValue());
        authresponse.setExpireAt(oktaclient.getAccessToken().getExpiresAt().getEpochSecond());

        List<String>myauthorities=new ArrayList<>();
        Collection<? extends GrantedAuthority> authorities= oidcUser.getAuthorities();
        for(GrantedAuthority a: authorities){
            myauthorities.add(a.toString());
        }
        authresponse.setAuthorities(myauthorities);
        return new ResponseEntity<>(authresponse, HttpStatus.OK);

    }
}
