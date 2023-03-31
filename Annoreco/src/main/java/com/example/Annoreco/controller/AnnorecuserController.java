package com.example.Annoreco.controller;


import com.example.Annoreco.entity.Annorecuser;
import com.example.Annoreco.service.AnnorecuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-03-28
 */
@RestController
@RequestMapping("/annorecuser")
public class AnnorecuserController {
    @Autowired
    private AnnorecuserService userService;

    @PostMapping("/login")
    public ResponseEntity<Annorecuser> login(@RequestParam String username, @RequestParam String password) {
        Annorecuser user = userService.login(username, password);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<Annorecuser> register(@RequestBody Annorecuser user) {
        Annorecuser result = userService.register(user);
        return ResponseEntity.ok(result);
    }
}

