package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.membership.adaptor.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.adaptor.out.persistence.MembershipMapper;
import com.fastcampuspay.membership.application.port.in.ModifyMembershipCommand;
import com.fastcampuspay.membership.application.port.in.ModifyMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.ModifyMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;


    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {

        MembershipJpaEntity membershipJpaEntity =
                modifyMembershipPort.modifyMembership(new Membership.MembershipId(command.getMembershipId()),
                        new Membership.MembershipName(command.getName()),
                        new Membership.MembershipEmail(command.getEmail()),
                        new Membership.MembershipAddress(command.getAddress()),
                        new Membership.MembershipIsValid(command.isValid()),
                        new Membership.MembershipIsCorp(command.isCorp()));

        return membershipMapper.mapToDomainEntity(membershipJpaEntity);
    }
}
