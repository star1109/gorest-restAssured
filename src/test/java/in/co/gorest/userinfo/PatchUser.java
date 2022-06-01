package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchUser extends TestBase {

    @Test
    public void patchUser() {

        UserPojo studentPojo = new UserPojo();
        studentPojo.setName("moon12345612");
        studentPojo.setEmail("richhjard123122@gmail.com");
        studentPojo.setStatus("active");
        studentPojo.setGender("male");


        Response response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac")
                .and()
                .body(studentPojo)
                .when()
                .patch("/3968")
                .then()
                .extract().response();
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
