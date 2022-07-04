package swemu.tdd.spring.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest({CalculatorController.class, FakeCalculator.class})
class CalculatorControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("add should return sum of operands")
    void add() throws Exception {
        mockMvc.perform(post("/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"values\": [ 5.0, 7.5 ] }"))
                .andExpect(content()
                        .json("{ \"value\": 12.5 }"));
    }
}
