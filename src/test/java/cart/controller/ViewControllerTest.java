package cart.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ViewController.class)
class ViewControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Home을 반환한다.")
    void returns_home_view() throws Exception {
        // when & then
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andDo(print());
    }

    @Test
    @DisplayName("Admin을 반환한다.")
    void returns_admin_view() throws Exception {
        // when & then
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andDo(print());
    }

    @Test
    @DisplayName("Settings를 반환한다.")
    void returns_settings_view() throws Exception {
        // when & then
        mockMvc.perform(get("/settings"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andDo(print());
    }

    @Test
    @DisplayName("Cart를 반환한다.")
    void returns_cart_view() throws Exception {
        // when & then
        mockMvc.perform(get("/cart"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))
                .andDo(print());
    }
}