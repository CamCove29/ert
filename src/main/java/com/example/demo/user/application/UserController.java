package com.example.demo.user.application;

import com.example.demo.lista_reproducción.domain.Playlist;
import com.example.demo.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/playlists")
    public ResponseEntity<List<Playlist>> getPlaylists(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getAllPlayListsByUserId(userId));
    }

    @PostMapping("/{userId}/playlist")
    public ResponseEntity<Void> addPlaylist(@PathVariable Integer userId, @RequestBody Playlist playlist) {
        userService.createPlayList(userId, playlist);
        return ResponseEntity.ok().build();
    }

}

/*
GET /users/{user_id}/playlists
POST /users/{user_id}/playlists
 */



