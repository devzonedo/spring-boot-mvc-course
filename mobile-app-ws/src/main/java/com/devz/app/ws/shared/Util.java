package com.devz.app.ws.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Util {
public String getGeneratedUserId(){
    return UUID.randomUUID().toString();
}
}
