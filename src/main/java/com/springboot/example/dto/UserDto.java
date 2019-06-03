package com.springboot.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author null
 * @version 1.0
 * @title
 * @description
 * @createDate 6/3/19 4:06 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String userName;
    private LocalDate birthday;
}
