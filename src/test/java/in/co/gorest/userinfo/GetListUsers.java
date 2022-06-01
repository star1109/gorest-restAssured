package in.co.gorest.userinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetListUsers extends TestBase {

    @Test
    public void getAllUsersData()
    {
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();

    }



}
