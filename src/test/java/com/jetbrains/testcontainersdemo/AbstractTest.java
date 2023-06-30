package com.jetbrains.testcontainersdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.MySQLContainer;

public class AbstractTest {

    private static MySQLContainer mySQLContainer = (MySQLContainer) new MySQLContainer("mysql:8.0.33")
            .withReuse(true);
//            .withExposedPorts(3036);//wait for db to come up.

    @BeforeAll
    public static void setup()
    {
        mySQLContainer.start();
    }


    @AfterAll
    public static void shutdown()
    {
        mySQLContainer.stop();
    }

}
