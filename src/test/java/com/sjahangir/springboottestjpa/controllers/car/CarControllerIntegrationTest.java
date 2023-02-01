package com.sjahangir.springboottestjpa.controllers.car;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjahangir.springboottestjpa.SpringBootTestJpaApplication;
import com.sjahangir.springboottestjpa.models.car.Car;
import com.sjahangir.springboottestjpa.services.car.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CarController.class)
@AutoConfigureMockMvc
public class CarControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CarService carService;

    @Test
    public void test_whenInputInvalidReturn400() throws Exception {
        Car car = new Car();
        car.setMake("Audi");
        car.setModel("A3");
        String carString = objectMapper.writeValueAsString(car);

        mockMvc.perform(post("/cars")
                .contentType("application/json")
                .content(carString))
                .andExpect(status().isCreated());
    }
}
