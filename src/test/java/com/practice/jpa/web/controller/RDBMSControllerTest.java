package com.practice.jpa.web.controller;

import com.practice.jpa.web.controller.impl.RDBMSControllerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class RDBMSControllerTest {
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

    @DisplayName("")
    @Test
    void insert() throws Exception {
        mockMvc.perform(post("/api/rdbms/{models}", "member")
                        .param("rollback", "T")
                        .param("number", "10000"))
                .andExpect(status().isCreated());
    }

    @DisplayName("")
    @Test
    void update() throws Exception {
        mockMvc.perform(put("/api/rdbms/{models}", "member")
                        .param("rollback", "T"))
                .andExpect(status().isOk());
    }

    @DisplayName("")
    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/rdbms/{models}", "member")
                        .param("rollback", "T"))
                .andExpect(status().isOk());
    }
}