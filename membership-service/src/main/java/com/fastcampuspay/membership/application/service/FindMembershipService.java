package com.fastcampuspay.membership.application.service;

import javax.transaction.Transactional;
import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.membership.adaptor.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.adaptor.out.persistence.MembershipMapper;
import com.fastcampuspay.membership.application.port.in.FindMembershipCommand;
import com.fastcampuspay.membership.application.port.in.FindMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;

    private final MembershipMapper membershipMapper;


    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity =
                findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
        return membershipMapper.mapToDomainEntity(entity);
    }
}