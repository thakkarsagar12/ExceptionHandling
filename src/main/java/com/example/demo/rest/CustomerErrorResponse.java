package com.example.demo.rest;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
public class CustomerErrorResponse {

    private int status;

    private String message;

    private long timeStamp;


}
