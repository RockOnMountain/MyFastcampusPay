package com.fastcampuspay.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/*
      Membership
      오염이 되면 안되는 클래스, 고객 정보, 핵심 도메인
   */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    private final String membershipId;
    private final String name;
    private final String email;
    private final String address;
    private final boolean isValid;
    private final boolean isCorp;


    public static Membership generateMember(MembershipId membershipId, MembershipName membershipName,
            MembershipEmail membershipEmail, MembershipAddress membershipAddress, MembershipIsValid membershipIsValid,
            MembershipIsCorp membershipIsCorp) {
        return new Membership(membershipId.membershipIdValue, membershipName.nameValue, membershipEmail.emailValue,
                membershipAddress.addressValue, membershipIsValid.isValidValue,
                membershipIsCorp.isCorp);
    }


    @Value
    public static class MembershipId {

        String membershipIdValue;


        public MembershipId(String value) {
            this.membershipIdValue = value;
        }
    }


    @Value
    public static class MembershipName {

        String nameValue;


        public MembershipName(String value) {
            this.nameValue = value;
        }
    }


    @Value
    public static class MembershipEmail {

        String emailValue;


        public MembershipEmail(String value) {
            this.emailValue = value;
        }
    }


    @Value
    public static class MembershipAddress {

        String addressValue;


        public MembershipAddress(String value) {
            this.addressValue = value;
        }
    }


    @Value
    public static class MembershipIsValid {

        boolean isValidValue;


        public MembershipIsValid(boolean value) {
            this.isValidValue = value;
        }
    }


    @Value
    public static class MembershipIsCorp {

        boolean isCorp;


        public MembershipIsCorp(boolean value) {
            this.isCorp = value;
        }
    }

}
