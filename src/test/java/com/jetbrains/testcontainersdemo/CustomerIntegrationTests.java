package com.jetbrains.testcontainersdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

public class CustomerIntegrationTests extends AbstractTest {

    @Autowired
    private CustomerDao customerDao;


//    testcontainers.reuse.enable: true  add in testcontainers file
    @Test
    void when_using_a_clean_db_this_should_be_empty() {
        List<Customer> customers = customerDao.findAll();
        assertThat(customers).hasSize(2);
    }

}
