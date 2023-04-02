package com.example.Annoreco.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.Annoreco.entity.Annorecuser;
import com.example.Annoreco.mapper.AnnorecuserMapper;
import com.example.Annoreco.service.AnnorecuserService;
import com.example.Annoreco.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2023-03-28
 */
@Service
public class AnnorecuserServiceImpl extends ServiceImpl<AnnorecuserMapper, Annorecuser> implements AnnorecuserService, CustomUserDetailsService {

    @Autowired
    private AnnorecuserMapper annorecuserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Annorecuser annorecuser = annorecuserMapper.selectOne(new QueryWrapper<Annorecuser>().eq("name", username));
        if (annorecuser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new User(annorecuser.getName(), annorecuser.getPassword(), Collections.emptyList());
    }

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public AnnorecuserServiceImpl(@Lazy UserDetailsService userDetailsService, @Lazy PasswordEncoder passwordEncoder, @Lazy AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Annorecuser login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            QueryWrapper<Annorecuser> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username);
            return this.getOne(wrapper);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("用户名或密码不正确");
        }
    }

    @Override
    public Annorecuser register(Annorecuser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.save(user);
        return user;
    }
}
