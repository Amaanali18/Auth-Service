package com.Auth.Auth_Service.helpers;

import java.util.UUID;

public class userHelper {
    public static UUID parseUUID(String uuid){
        return UUID.fromString(uuid);
    }
}
