package in.co.gorest.gorestdemo;

import in.co.gorest.model.RecordPojo;
import in.co.gorest.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GorestUpdateUser extends Testbase {
    @Test
    public void updateUser() {
        RecordPojo recordPojo = new RecordPojo();
        recordPojo.setName("Tenali Ramakrishna");
        recordPojo.setGender("male");
        recordPojo.setEmail("tenali.ramakrishna51581@gmail.com");
        recordPojo.setStatus("active");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac")
                .pathParam("id",4164)
                .body(recordPojo)
                .when()
                .patch("/users/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}