package com.example.demo.user.domain;


import com.example.demo.lista_reproducción.domain.Playlist;
import com.example.demo.lista_reproducción.infrastructure.PlaylistRepository;
import com.example.demo.user.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaylistRepository playListRepository;

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

//    public User loginUser(String email, String password) {
//        User user = userRepository.findByEmail(email);
//        if (user != null && user.getPassword().equals(password)) {
//            return user;
//        }
//        return null;
//    }

    public List<Playlist> getAllPlayListsByUserId(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return user.getListasDeReproduccion();
        }
        return new ArrayList<>();
    }

    public void createPlayList(int userId, Playlist playList) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            playList.setUser(user);
            playListRepository.save(playList);
        }
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







