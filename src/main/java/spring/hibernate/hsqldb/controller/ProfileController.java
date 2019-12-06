package spring.hibernate.hsqldb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<Profile> getProfileById(@PathVariable(name = "profileId") Long profileId) {
        return new ResponseEntity<>(repository.findById(profileId).orElse(new Profile()), HttpStatus.OK);
    }

    @PostMapping("/profile")
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
        return new ResponseEntity<>(repository.save(profile), HttpStatus.CREATED);
    }

    @PatchMapping("/profile")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        return new ResponseEntity<>(repository.save(profile), HttpStatus.CREATED);
    }

    @DeleteMapping("/profile/{profileId}")
    public ResponseEntity<Object> deleteProfile(@PathVariable(name = "profileId") Long profileId) {
        repository.deleteById(profileId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
