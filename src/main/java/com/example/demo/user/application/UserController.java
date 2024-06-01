package com.example.demo.user.application;

import com.example.demo.user.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{user_id}/playlists")
    public ResponseEntity<List<Playlist>> getPlaylists(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getAllPlaylistsByusuario());
    }

    @PostMapping("{user_id}/playlist")
    public ResponseEntity<Void> addPlaylist(@PathVariable Integer userId, @RequestBody Playlist playlist) {
        userService.createPlaylist(userId, playlist);
        return ResponseEntity.ok().build();
    }

}

/*
GET /users/{user_id}/playlists
POST /users/{user_id}/playlists
 */