package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adaptor.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.domain.Membership;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(Membership.MembershipId membershipId);
}
