package hodei.secretclub;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Hodei Eceiza
 * Date: 4/22/2021
 * Time: 13:18
 * Project: secretClub
 * Copyright: MIT
 */
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
    @Autowired
    private MockMvc mvc;
/* TESTING TESTING (not working, didnt write a proper test case
    @Test
    public void getResponse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/login").accept(MediaType.ALL)).andExpect(status().isOk());
    }

 */
}
