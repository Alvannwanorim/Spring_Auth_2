package com.alvan.springauth.users;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    
    @GetMapping
    public ResponseEntity<String> sayHello(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
    String username = ((UserDetails)principal).getUsername();
    System.out.println();
    return ResponseEntity.ok(username);
    } else {
    // String username = principal.toString();
    return ResponseEntity.ok("username not found");
    }
        
    }

}
