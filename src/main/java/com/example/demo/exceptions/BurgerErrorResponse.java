package com.example.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BurgerErrorResponse {

    private String message;

    private Integer status;

    private Long timestamp;
}
