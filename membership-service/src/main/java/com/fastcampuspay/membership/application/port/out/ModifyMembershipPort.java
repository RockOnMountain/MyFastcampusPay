package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adaptor.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.domain.Membership;

public interface ModifyMembershipPort {

    MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp);
}
