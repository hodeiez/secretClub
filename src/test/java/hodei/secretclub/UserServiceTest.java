package hodei.secretclub;


import hodei.secretclub.models.User;
import hodei.secretclub.repositories.RoleRepository;
import hodei.secretclub.repositories.UserRepository;
import hodei.secretclub.services.UserService;
import org.junit.Before;
import org.junit.Rule;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Hodei Eceiza
 * Date: 4/18/2021
 * Time: 01:00
 * Project: secretClub
 * Copyright: MIT
 */

//@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;
    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private User user;

    @Before
    public void setUp() {

        userServiceUnderTest = new UserService(mockUserRepository,
                mockRoleRepository,
                mockBCryptPasswordEncoder);
        user = User.builder()
                .id(1)
                .name("tester")
                .email("test@test.com")
                .build();
/*
        Mockito.when(mockUserRepository.save(any()))
                .thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(anyString()))
                .thenReturn(user);

 */
    }

    @Test
    public void testFindUserByEmail() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        final User result = userServiceUnderTest.findUserByEmail(email);
/*
        // Verify the results
        assertEquals(email, result.getEmail());

 */
    }

    @Test
    public void testSaveUser() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        User result = userServiceUnderTest.saveUser(User.builder().build());
/*
        // Verify the results
        assertEquals(email, result.getEmail());

 */
    }
}
