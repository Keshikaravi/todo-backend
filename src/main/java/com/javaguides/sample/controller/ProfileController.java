package com.javaguides.sample.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaguides.sample.exception.ResourceNotFoundException;
import com.javaguides.sample.model.Profile;
import com.javaguides.sample.payload.ProfileUpload;
import com.javaguides.sample.repository.ProfileRepository;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/")
public class ProfileController {
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("profile")
    public List<Profile> getAllProfiles() {
        return this.profileRepository.findAll();
    }
    @GetMapping("/profile/{id}")
	public ResponseEntity<Profile> getProfileById(@PathVariable(value = "id") Long profileId )
			throws ResourceNotFoundException {
                Profile profile = profileRepository.findById(profileId)
				.orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + profileId));
		return ResponseEntity.ok().body(profile);
	}


//     @PostMapping("profile")
//     public Profile createProfile(@Valid @RequestBody Profile profile) {
//         return profileRepository.save(profile);
//     }

//@PostMapping("/upload")
//public String createProfile(@RequestParam("file")MultipartFile file) {
//	return "Success";
//	}

//@PostMapping("/upload")
//public String createProfile(@ModelAttribute ProfileUpload file) {
//	return "Success";
//}
//
//    @PostMapping("photo")
//    public ResponseEntity<?> createProfile(@ModelAttribute ProfileUpload file) throws IOException{
//        return ResponseEntity.ok(file);
//    }


@PostMapping("upload")
public ResponseEntity<?> createProfile(@ModelAttribute ProfileUpload file) throws IOException {
	Profile profile = new Profile(file.getFirstname(),file.getLastname(),file.getAge(),file.getMail(),file.getFile().getBytes());
	return ResponseEntity.ok(this.profileRepository.save(profile));
}


    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") Long profileId,
            @Validated @RequestBody Profile profileDetails) throws ResourceNotFoundException {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + profileId));
    
        profile.setFirstname(profileDetails.getFirstname());
        profile.setLastname(profileDetails.getLastname());
        profile.setAge(profileDetails.getAge());
        profile.setMail(profileDetails.getMail());
        profile.setPhoto(profileDetails.getPhoto());
        final Profile updatedProfile = profileRepository.save(profile);
        return ResponseEntity.ok(updatedProfile);
        }
    
        @DeleteMapping("/profile/{id}")
        public Map<String,Boolean> deleteProfile(@PathVariable(value = "id") Long profileId)
      
                throws ResourceNotFoundException {
            Profile profile = profileRepository.findById(profileId)
                    .orElseThrow(() -> new ResourceNotFoundException("profile not found for this id :: " +profileId));
    
           profileRepository.delete(profile);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }
}
