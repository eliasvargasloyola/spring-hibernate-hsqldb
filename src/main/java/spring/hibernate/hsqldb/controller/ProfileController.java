package spring.hibernate.hsqldb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @GetMapping("/profiles")
    public ResponseEntity<String> getProfiles() {
        return new ResponseEntity<String>("{\"message\":\"Ready to ok\"}", HttpStatus.OK);
    }

}
