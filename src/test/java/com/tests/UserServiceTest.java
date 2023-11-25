package com.tests;

import com.dragondevelopers.entity.Phone;
import com.dragondevelopers.entity.User;
import com.dragondevelopers.repository.UserRepository;
import com.dragondevelopers.service.Impl.UserImlp;
import com.dragondevelopers.service.UserService;
import com.dto.MessageDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserImlp userService;

    private User user;

    private MessageDTO message;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        user = new User();
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        List<Phone> phones = new ArrayList();
        phones.add(phone1);
        phones.add(phone2);
        user.setEmail("aaa@aaa.cl");
        user.setPhones(phones);

        message = new MessageDTO();
        message.setMensaje("aaaaaaa");

    }

    @Test
    void save() {
        when(userRepository.save(any(User.class))).thenReturn(user);
        assertNotNull(userService.save(new User()));
    }
}