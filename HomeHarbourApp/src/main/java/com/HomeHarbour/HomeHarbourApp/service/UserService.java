package com.HomeHarbour.HomeHarbourApp.service;

import com.HomeHarbour.HomeHarbourApp.dto.ProfileUpdateRequestDto;
import com.HomeHarbour.HomeHarbourApp.dto.UserDto;
import com.HomeHarbour.HomeHarbourApp.entity.User;

public interface UserService {
    User getUserById(Long id);

    UserDto getMyProfile();

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);
}
