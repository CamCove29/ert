package com.example.demo.user.domain;


import com.example.demo.events.EmailService;
import com.example.demo.lista_reproducción.domain.Playlist;
import com.example.demo.lista_reproducción.infrastructure.PlaylistRepository;
import com.example.demo.user.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;





@RestController
@RequestMapping("/users")
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaylistRepository playListRepository;
    @Autowired
    private EmailService emailService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<Playlist> getAllPlayListsByUserId(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return user.getListasDeReproduccion();
        }
        return new ArrayList<>();
    }

    @PostMapping("/{userId}/playlists")
    public String createPlayList(@PathVariable int userId, @RequestBody Playlist playList) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            playList.setUser(user);
            playListRepository.save(playList);
            sendPlaylistCreationEmail(user);
            return "Playlist created and email sent";
        }
        return "User not found";
    }

    private void sendPlaylistCreationEmail(User user) {
        String subject = "Playlist Created Successfully";
        String text = "Dear " + user.getNombre() + ",\n\nYour playlist has been created successfully.";
        emailService.sendEmail(user.getEmail(), subject, text);
    }

    public User findByEmail(String username) {
        User usuario;
        usuario = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no autorizado"));
        return usuario;
    }

    @Bean(name = "UserDetailsService")
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return (UserDetails) user;
        };
    }
}





