package com.app.MyMovies.security;

//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    /*@GetMapping("/auth")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        System.out.println(principal);
        return Collections.singletonMap("username", principal.getAttribute("login"));
    }
*/

}
