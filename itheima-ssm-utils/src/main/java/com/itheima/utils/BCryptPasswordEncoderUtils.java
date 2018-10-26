package com.itheima.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="120927";
        String pw=encodePassword(password);
//        $2a$10$Htlge6t8Ef0iW.U4PGPJmOwwg8M8zgHBPEPR/qxGIWdXKbqFGr3vy
//        $2a$10$RPmHwiTPqKY3x4tP5REy3eNe60o7bu9YMhJBvMCR9LsmdC/iuyYhK
        System.out.println(pw);
    }
}
