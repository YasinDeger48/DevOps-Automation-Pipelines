package com.devops.integrationTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IntegrationTests {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testFindById() {
        UserModel user = new UserModel(1L, "Yasin Değer");
        userService.save(user);

        UserModel foundUser = userService.findById(1L);
        assertNotNull(foundUser);
        assertEquals("Yasin Değer", foundUser.getName());
    }

    @Test
    public void testFindById2() {
        UserModel user = new UserModel(2L, "Yasin DEGER");
        userService.save(user);

        UserModel foundUser = userService.findById(2L);
        assertNotNull(foundUser);
        assertEquals("Yasin DEGER", foundUser.getName());
    }
}
