package com.practice.jpa.web.controller.impl;

import com.practice.jpa.web.controller.RDBMSController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class RDBMSControllerImplTest {

    @InjectMocks
    RDBMSController rdbmsController = new RDBMSControllerImpl();

    MockMvc mockMvc;

    @BeforeEach
    private void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(rdbmsController).build();
    }

    @DisplayName("")
    @Test
    void api() throws Exception {
        mockMvc.perform(get("/api/rdbms/{models}", "member"))
                .andExpect(status().isOk());
    }


}