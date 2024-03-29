package com.fastcampuspay.membership.adaptor.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.application.port.out.ModifyMembershipPort;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;


    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {

        return membershipRepository.save(
                new MembershipJpaEntity(membershipName.getNameValue(), membershipEmail.getEmailValue(),
                        membershipAddress.getAddressValue(), membershipIsValid.isValidValue(),
                        membershipIsCorp.isCorp()));
    }


    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getById(Long.parseLong(membershipId.getMembershipIdValue()));
    }


    @Override
    public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId,
            Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp) {

        MembershipJpaEntity entity = membershipRepository.getById(Long.parseLong(membershipId.getMembershipIdValue()));
        entity.setName(membershipName.getNameValue());
        entity.setAddress(membershipAddress.getAddressValue());
        entity.setEmail(membershipEmail.getEmailValue());
        entity.setCorp(membershipIsCorp.isCorp());
        entity.setValid(membershipIsValid.isValidValue());

        return membershipRepository.save(entity);
    }
}
