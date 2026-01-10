package com.HomeHarbour.HomeHarbourApp.util;

 import com.HomeHarbour.HomeHarbourApp.entity.User;
 import org.springframework.security.core.context.SecurityContextHolder;

public class AppUtils {

    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

