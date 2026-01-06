package com.Auth.Auth_Service.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDTO {
    String message;
    int status;
    String error;
}
