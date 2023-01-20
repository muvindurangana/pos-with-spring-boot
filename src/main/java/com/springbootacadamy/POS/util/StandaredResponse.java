package com.springbootacadamy.POS.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandaredResponse {
    private int code;
    private String message;
    private Object data;
}
