package com.webstore;


import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Runner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class WebstoreIntegrationTest {
}
