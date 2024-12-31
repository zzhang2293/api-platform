package com.zz.apiinterface.controller;


import com.zz.apiclientsdk.model.User;
import com.zz.apiinterface.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/")
    public String getNameByGet(String name){

        return "your name is: " + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name){
        return "your name is: " + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request){
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        String actualKey;
        // todo check from database
        if (!accessKey.equals("zz")){
            throw new RuntimeException("no auth");
        }
        if (Long.parseLong(nonce) > 10000){
            throw new RuntimeException("no auth");
        }
        // todo 实际情况是从服务器中拿secret key
        String serverSign = SignUtils.genSign(body, "abcdefgh");
        if (!sign.equals(serverSign)){
            throw new RuntimeException("no auth");
        }
        return "POST your name is " + user.getUsername();
    }
}
