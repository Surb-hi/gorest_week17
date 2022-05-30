package in.co.gorest.gorestdemo;

import in.co.gorest.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GorestDelateUser extends Testbase {
    @Test
    public void delateuser(){
        Response response=given()
                .pathParam("id", 4164)
                .when()
                .delete("/users/{id}");
        response.prettyPrint();
        response.then().statusCode(204);
        System.out.println("Data is delated");
    }
}
