package com.fastcampuspay.membership.adaptor.in.web;

import lombok.Data;

@Data
public class RegisterMembershipRequest {

    private String name;
    private String address;
    private String email;
    private boolean isCorp;
}
