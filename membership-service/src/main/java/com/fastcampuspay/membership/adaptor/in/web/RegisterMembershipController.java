package com.fastcampuspay.membership.adaptor.in.web;

import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.domain.Membership;
import com.fastcampuspay.membership.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;


    @PostMapping("/membership/register")
    public Membership registerMembership(@RequestBody RegisterMembershipRequest request) {

        RegisterMembershipCommand command =
                RegisterMembershipCommand.builder().name(request.getName()).address(request.getAddress())
                        .email(request.getEmail()).isValid(true).isCorp(request.isCorp()).build();

        return registerMembershipUseCase.registerMembership(command);
    }
}