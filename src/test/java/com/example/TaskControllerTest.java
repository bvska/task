package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;


class TaskControllerTest {

    @Test
    public void whenCrateTask() {
       Task task = new Task();
       task.setTimestamp(LocalDateTime.now());
        given().log().body()
                .contentType("application/json").body(task)
                .when().post("/task")
                .then().log().body()
                .statusCode(HttpStatus.ACCEPTED.value());
    }

}
