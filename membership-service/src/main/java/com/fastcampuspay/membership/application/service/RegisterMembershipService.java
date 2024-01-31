package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.membership.adaptor.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.adaptor.out.persistence.MembershipMapper;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;


    @Override
    public Membership registerMembership(RegisterMembershipCommand registerMembershipCommand) {

        MembershipJpaEntity membershipJpaEntity = registerMembershipPort.createMembership(
                new Membership.MembershipName(registerMembershipCommand.getName()),
                new Membership.MembershipEmail(registerMembershipCommand.getEmail()),
                new Membership.MembershipAddress(registerMembershipCommand.getAddress()),
                new Membership.MembershipIsValid(registerMembershipCommand.isValid()),
                new Membership.MembershipIsCorp(registerMembershipCommand.isCorp()));

        return membershipMapper.mapToDomainEntity(membershipJpaEntity);
    }
}
