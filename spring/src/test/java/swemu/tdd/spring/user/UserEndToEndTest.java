package swemu.tdd.spring.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserEndToEndTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("find by email should return the user with that email")
    void findByEmail() throws Exception {
        var userJson = "{ \"name\": \"John Doe\", \"email\": \"john.doe@gmail.com\" }";
        mockMvc.perform(put("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson));

        mockMvc.perform(get("/users").queryParam("email", "john.doe@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(content().json(userJson));

    }
}
