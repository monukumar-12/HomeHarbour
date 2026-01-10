package com.HomeHarbour.HomeHarbourApp.dto;

import com.HomeHarbour.HomeHarbourApp.entity.User;
import com.HomeHarbour.HomeHarbourApp.entity.enums.Gender;
import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
