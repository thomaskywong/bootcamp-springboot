package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.config.AppConfig;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl.DatabaseController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

// Test case for internal use. No public
// Only test @Controller for web side test

// @SpringBootTest // only test the web layer (web related components), mock @Service

// Inject the web layer related beans to spring context only.
// In this testing environment, @ComponentScan includes only @Controller, but NO @Service, @Configuration etc.
// @ComponentScan includes @Controller bean, @MockMvc beans, etc.
// specify DatabaseController.class to be tested
@WebMvcTest(DatabaseController.class)
class DatabaseControllerTests {

        @Autowired
        private MockMvc mockMvc; // similar to postman by brought by @WebMvcTest

        @Autowired
        private WebApplicationContext webApplicationContext;

        @Autowired
        @Qualifier(value = "config1")
        private AppConfig appConfig;

        // @Autowired // cannot autowired @Service in @WebMvnTest
        @MockBean // Mock there is @Service bean. Similar to @Mock
        private CatDatabaseService catDatabaseService;

        @Test // Simulate Postman
        void testGetCat() throws Exception {
                // Assumption
                Cat mockedReturnCat = new Cat("ABC", 3);

                // When
                // Mock Service getCat
                Mockito.when(catDatabaseService.getCatFromStaticMemory(1))
                                .thenReturn(mockedReturnCat);

                // Static Methods called with Class name
                mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cat/{idx}",
                                "1")) //
                                .andExpect(MockMvcResultMatchers.status()
                                                .isOk()) // show server status: 200 = OK, 404 = Error: path not found, 500 = IP not found or Port not found
                                .andExpect(MockMvcResultMatchers.content()
                                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                                .andExpect(MockMvcResultMatchers
                                                .jsonPath("$.name")
                                                .value("ABC")) //
                                .andExpect(MockMvcResultMatchers
                                                .jsonPath("$.age").value("3")) //
                                .andDo(MockMvcResultHandlers.print()); // similar to sysout, toString()

                // assert test
                // simulate get commend in postmen
                mockMvc.perform(get("/api/v1/cat/{idx}", "1")) //
                                .andExpect(status().isOk()) // show server status: 200 = OK, 404 = Error: path not found, 500 = IP not found or Port not found
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON_VALUE))
                                .andExpect(jsonPath("$.name").value("ABC")) //
                                .andExpect(jsonPath("$.age").value("3")) //
                                .andDo(print()); // similar to sysout, toString()



                // wrong path test
                // mockMvc.perform(get("/api/v1/cat2/{idx}", "1")) //
                // .andExpect(status().isNotFound()) // show server status: 404 = Error: path not found
                // .andDo(print()); // similar to sysout, toString()
        }

        @Test
        void testPostCat() throws Exception {

                Cat mockedCreatedCat = new Cat("EFG", 5);


                // Mock Service postCat
                // catDatabaseService.createCatToStaticMemory(idx, cat);
                Mockito.when(catDatabaseService.createCatToStaticMemory(1,
                                mockedCreatedCat)).thenReturn(mockedCreatedCat);



                // Object to String
                String contentString = new ObjectMapper()
                                .writeValueAsString(mockedCreatedCat);

                Objects.requireNonNull(contentString);

                // POST - @PathVariable
                mockMvc.perform(post("/api/v1/cat/{idx}", "1")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(contentString)) //
                                .andExpect(status().isOk()) // show server status: 200 = OK, 404 = Error: path not found, 500 = IP not found or Port not found
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON_VALUE))
                                .andExpect(jsonPath("$.name").value("EFG")) //
                                .andExpect(jsonPath("$.age").value("5")) //
                                .andDo(print()); // similar to sysout, toString()


                // suimulate post commend in postmen
                mockMvc.perform(post("/api/v1/cat/{idx}", "1")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content("{\"name\":\"EFG\",\"age\": 5}")) //
                                .andExpect(status().isOk()) // show server status: 200 = OK, 404 = Error: path not found, 500 = IP not found or Port not found
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON_VALUE))
                                .andExpect(jsonPath("$.name").value("EFG")) //
                                .andExpect(jsonPath("$.age").value("5")) //
                                .andDo(print()); // similar to sysout, toString()


        }

        @Test
        void testDeleteCat() throws Exception {

                // Mock Service DeleteCat
                // Boolean deleteCatFromStaticMemory(int index)
                Mockito.when(catDatabaseService.deleteCatFromStaticMemory(1))
                                .thenReturn(true);

                // suimulate delete commend in postmen
                mockMvc.perform(delete("/api/v1/cat/{idx}", "1"))
                                .andExpect(status().isOk()) // show server status: 200 = OK, 404 = Error: path not found, 500 = IP not found or Port not found
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON_VALUE))
                                .andExpect(content().string("true")) //
                                .andDo(print()); // similar to sysout, toString()
        }

        @Test
        void testputCat() throws Exception {

                Cat mockedCreatedCat = new Cat("HIJ", 6);

                // Mock Service putCat
                // Cat putCatToStaticMemory(int index, Cat cat)
                Mockito.when(catDatabaseService.putCatToStaticMemory(1,
                                mockedCreatedCat)).thenReturn(mockedCreatedCat);

                // suimulate put commend in postmen
                mockMvc.perform(put("/api/v1/cat/{idx}", "1")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content("{\"name\": \"HIJ\",\"age\": 6}"))
                                .andExpect(status().isOk()) // show server status: 200 = OK, 404 = Error: path not found, 500 = IP not found or Port not found
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON_VALUE))
                                .andExpect(jsonPath("$.name").value("HIJ"))
                                .andExpect(jsonPath("$.age").value("6"))
                                .andDo(print()); // similar to sysout, toString()
        }

        @Test
        void testpatchCat1() throws Exception {
                Cat mockedPatchCat = new Cat("Thomas", 6);

                // Mock Service patchCat
                // Cat patchCatToStaticMemory(int index, String name)
                Mockito.when(catDatabaseService.patchCatToStaticMemory(1,
                                "Thomas")).thenReturn(mockedPatchCat);

                // suimulate patch commend in postmen
                mockMvc.perform(patch("/api/v1/cat/{idx}/name/{name}", "1",
                                "Thomas")).andExpect(status().isOk()) // show server status: 200 = OK, 404 = Error: path not found, 500 = IP not found or Port not found
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON_VALUE))
                                .andExpect(jsonPath("$.name").value("Thomas"))
                                .andExpect(jsonPath("$.age").value("6"))
                                .andDo(print()); // similar to sysout, toString()
        }

        @Test
        void testpatchCat2() throws Exception {
                Cat mockedPatchCat = new Cat("Thomas", 10);

                // Mock Service putCat
                // Cat patchCatToStaticMemory(int index, String name)
                Mockito.when(catDatabaseService.patchCatToStaticMemory(1, 10))
                                .thenReturn(mockedPatchCat);

                // suimulate patch commend in postmen
                mockMvc.perform(patch("/api/v1/cat/{idx}/age/{age}", "1", "10"))
                                .andExpect(status().isOk()) // show server status: 200 = OK, 404 = Error: path not found, 500 = IP not found or Port not found
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON_VALUE))
                                .andExpect(jsonPath("$.name").value("Thomas"))
                                .andExpect(jsonPath("$.age").value("10"))
                                .andDo(print()); // similar to sysout, toString()
        }

        // For @RequestParam
        @Test
        void testGetCatByRequestParam() throws Exception {

                Cat mockedReturnCat = new Cat("ABC", 3);

                // When
                // Mock Service getCat
                Mockito.when(catDatabaseService.getCatFromStaticMemory(1))
                                .thenReturn(mockedReturnCat);

                // Get - @RequestParam(name = "idx") - URL"/cat/?idx=0"
                mockMvc.perform(get("/api/v1/cat").param("index", "1"))
                                .andExpect(status().isOk())// show server status: 200 = OK, 404 = Error: path not found, 500 = IP not found or Port not found
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.name").value("ABC"))
                                .andExpect(jsonPath("$.age").value("3"))
                                .andDo(print());


        }

    
}
