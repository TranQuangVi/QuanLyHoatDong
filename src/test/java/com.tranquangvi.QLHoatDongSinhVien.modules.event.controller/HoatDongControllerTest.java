package com.tranquangvi.QLHoatDongSinhVien.modules.event.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.controller.CustomUtils;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.controller.HoatDongController;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.HoatDongDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.HoatDongMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.HoatDongService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;

@Transactional
public class HoatDongControllerTest {
    private static final String ENDPOINT_URL = "/api/hoat-dong";

    @InjectMocks
    private HoatDongController hoatdongController;

    @Mock
    private HoatDongService hoatdongService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(hoatdongController)
                .build();
    }



    @Test
    public void getById() throws Exception {
        Mockito.when(hoatdongService.findById(ArgumentMatchers.anyString()))
                .thenReturn(HoatDongBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));

        Mockito.verify(hoatdongService, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(hoatdongService);
    }




    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(hoatdongService).deleteById(ArgumentMatchers.anyString());

        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(HoatDongBuilder.getIds())))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(hoatdongService, Mockito.times(1))
                .deleteById(Mockito.anyString());
        Mockito.verifyNoMoreInteractions(hoatdongService);
    }
}
