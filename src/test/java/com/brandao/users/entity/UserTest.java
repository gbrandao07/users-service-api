package com.brandao.users.entity;

import com.brandao.users.entity.types.SexType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void given_ValidUser_should_returnIsValid() {

        User user = new User(
                "1a2b3c",
                "444 444 000 01",
                "gustavob@test.com",
                "Gustavo B",
                SexType.MALE,
                29,
                "somelink.com/doc01.png"
        );

        assertEquals(true, user.isValid());
    }

    @Test
    public void given_NotValidUser_should_returnIsNotValid() {

        User user = new User(
                "1a2b3c",
                "444 444 000 01",
                "gustavob@test.com",
                "",
                SexType.MALE,
                29,
                "somelink.com/doc01.png"
        );

        assertEquals(false, user.isValid());
    }
}
