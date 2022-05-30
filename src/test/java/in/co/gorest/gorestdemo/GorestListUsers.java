package in.co.gorest.gorestdemo;

import in.co.gorest.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GorestListUsers extends Testbase {
    @Test
    public void test001() {
        Response response = given()
                .when()
                .get("/users");
        response.then().statusCode(200);

//        1.Total records are 20
        List<Integer> totalrecords = response.then().extract().path("");
        System.out.println("Total value is : " + totalrecords.size());

//        2.id 3265 has name = "Mandakini Butt"
        List<String> name = response.then().extract().path("findAll{it.id==3253}.name");
        System.out.println("Name value is : " + name);

//       3.id 3269 has email = "menon_balamani@mclaughlin.com"
        List<String> email = response.then().extract().path("findAll{it.id==3269}.email");
        System.out.println("Email value is : " + email);

//        4.All ID has status = "active"
        List<String> AllId = response.then().extract().path("findAll{it.status=='active'}.id");
        System.out.println("Status value is : " + AllId);

//      5.id 3269 has gender = "female"
        List<String> gender = response.then().extract().path("findAll{it.id==3269}.gender");
        System.out.println("Gender value is : " + gender);

//        6.id 3271 has gender = "male"
        List<String> gendermale = response.then().extract().path("findAll{it.id==3271}.gender");
        System.out.println("Gender value is : " + gendermale);

        response.prettyPrint();

    }
}