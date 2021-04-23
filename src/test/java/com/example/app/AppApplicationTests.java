package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class AppApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testOne() throws Exception {
        this.mockMvc.perform(get("/?h=1&w=1&d=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{areaBot:1.0,areaSide:1.0,areaFront:1.0,areaFull:4.0,volume:1.0}"));
    }

    @Test
    void testTwo() throws Exception {
        this.mockMvc.perform(get("/?h=5&w=5&d=5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{areaBot:25.0,areaSide:25.0,areaFront:25.0,areaFull:20.0,volume:125.0}"));
    }

    @Test
    void testThree() throws Exception {
        this.mockMvc.perform(get("/?h=10&w=20&d=30"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{areaBot:600.0,areaSide:300.0,areaFront:200.0,areaFull:90.0,volume:6000.0}"));
    }
}
