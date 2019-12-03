package spring.hibernate.hsqldb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.hibernate.hsqldb.domain.Profile;
import spring.hibernate.hsqldb.repository.ProfileRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    private ProfileRepository repository;

    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> getProfiles() {
        List<Profile> response = new ArrayList<>();
        repository.findAll().forEach(response::add);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
