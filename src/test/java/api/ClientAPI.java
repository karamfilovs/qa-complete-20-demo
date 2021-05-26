package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.jsonpath.JsonPath;
import dto.Client;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class ClientAPI {
    private static final String BASE_URL = System.getProperty("url");
    private static final String BASE_PATH = "/RESTapi";
    private static final String CLIENTS_URL = "/clients";
    private static final String CLIENT_URL = "/client";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String EMAIL = System.getProperty("email");
    private static final String PASSWORD = System.getProperty("password");

    static {
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        RestAssured.authentication = RestAssured.preemptive().basic(EMAIL, PASSWORD);
    }

    public Response get(int id){
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(CLIENT_URL + "/" + id);
        System.out.println("RESPONSE:");
        response.prettyPrint();
        return  response;
    }

    public Response getAll(){
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(CLIENTS_URL);
        System.out.println("RESPONSE:");
        response.prettyPrint();
        return  response;
    }

    public Response create(Client client){
        Response response = RestAssured
                .given()
                .body(GSON.toJson(client))
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .post(CLIENT_URL);
        System.out.println("RESPONSE:");
        response.prettyPrint();
        return  response;
    }

    public Response delete(int id){
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .delete(CLIENT_URL + "/" + id);
        System.out.println("RESPONSE:");
        response.prettyPrint();
        return  response;
    }

    public void deleteAll(){
        List<Integer> ids = new ArrayList<>();
        //Get all client
        Response allClients = getAll();
        //Extract their ids
        ids = JsonPath.read(allClients.body().asString(), "$..id");
        //Delete all one by one using for each
        System.out.println("Ids for deletion:" + ids);
        ids.forEach(id -> delete(id));
    }



}
