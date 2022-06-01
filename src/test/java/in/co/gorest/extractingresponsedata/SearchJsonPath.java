package in.co.gorest.extractingresponsedata;

import in.co.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPath extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response =  given()
                .when()
                .get("/users")
                .then().statusCode(200);

    }
    //1.Total records are 20
    @Test
    public void test001()
    {
        List<Object> list =  response.extract().path("length");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records is : " + list.size());
        System.out.println("------------------End of Test---------------------------");

    }

    //2.id 3826 has name = "Devesh Bandopadhyay"
    @Test
    public void test002()
    {
        String name = response.extract().path("[2].name");
        int id = response.extract().path("[2].id");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id " + id + "has name : " + name);
        System.out.println("------------------End of Test---------------------------");

    }

    //3. id 3826 has email = "bharadwaj_anaadi@mertz.info"
    @Test
    public void test003()
    {
        String email = response.extract().path("[2].email");
        int id = response.extract().path("[2].id");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id " + id + "has email : " + email);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. all id has status active
    @Test
    public void test005()
    {
        List<String> status = response.extract().path("findAll{it.status == 'active'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All id with status active are  : " +status);
        System.out.println("------------------End of Test---------------------------");
    }

    //id 3830 has gender male
    @Test
    public void test006()
    {
        String gender = response.extract().path("[0].gender");
        int id = response.extract().path("[0].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id " + id + " has gender : " + gender);
        System.out.println("------------------End of Test---------------------------");

    }

    //id 3827 has gender female
    @Test
    public void test007()
    {
        String gender = response.extract().path("[1].gender");
        int id = response.extract().path("[1].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id " + id + " has gender : " + gender);
        System.out.println("------------------End of Test---------------------------");

    }
}
