import org.testng.annotations.Test;
import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class httpmethod {

    @Test
    void getUser() {
                 given()
                         .header("Content-Type", "application/json")
                         .header("x-api-key", "reqres-free-v1")
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }

    @Test()
    void createUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Shruti");
        data.put("job", "Trainer");
        given()
                .baseUri("https://reqres.in")
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body("{ \"name\": \"Shruti\", \"job\": \"Trainer\" }")
                .log().all()
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .statusCode(201); // Expecting 201
    }


    @Test
    void updateUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Shruti");
        data.put("job", "Senior Trainer");

        given()
                .contentType("application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(data)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("job", equalTo("Senior Trainer"))
                .log().all();
    }

    @Test
    void deleteUser() {
        given()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)  // 204 No Content is expected for DELETE
                .log().all();

        System.out.println("This are my testcases");

        System.out.println("This are my testcases222");

    }
}

//get
//https://reqres.in/api/users/2

//post
//https://reqres.in/api/users
//{
//    "name": "morpheus",
//    "job": "leader"
//}


//update
//https://reqres.in/api/users/2
//{
//    "name": "morpheus",
//    "job": "zion resident"
//}

//delete
//https://reqres.in/api/users/2


