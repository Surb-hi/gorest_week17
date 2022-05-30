package in.co.gorest.gorestdemo;

import in.co.gorest.model.RecordPojo;
import in.co.gorest.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GorestCreateUser extends Testbase {
@Test
    public void createUser() {
    RecordPojo recordPojo=new RecordPojo();
    recordPojo.setName("Tenali Ramakrishna");
    recordPojo.setGender("female");
    recordPojo.setEmail("tenali.ramakrishna12345@gmail.com");
    recordPojo.setStatus("active");
    Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac")
                .body(recordPojo)
                .when()
                .post("/users");
    response.prettyPrint();
    response.then().statusCode(201);
    }
}
