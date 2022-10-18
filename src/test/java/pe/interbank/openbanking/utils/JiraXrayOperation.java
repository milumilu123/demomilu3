package pe.interbank.openbanking.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JiraXrayOperation {

    private static final String API_XRAY_AUTHENTICATE = "https://xray.cloud.getxray.app/api/v1/authenticate";
    private static final String API_XRAY_IMPORT_CUCUMBER_RESULT = "https://xray.cloud.getxray.app/api/v1/import/execution/cucumber";

    private static EnvironmentVariables envs = SystemEnvironmentVariables.createEnvironmentVariables();

    public static void importCucumberResult(String cucumberJsonFile){
        String jsonContent = getCucumberJsonContentAsString(cucumberJsonFile);
        String authenticateToken = getAuthenticateToken();

        RestAssured.useRelaxedHTTPSValidation();
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + authenticateToken)
                .body(jsonContent)
                .when().log().all()
                .post(API_XRAY_IMPORT_CUCUMBER_RESULT);
        response.prettyPeek();
        response.then().assertThat().statusCode(200);
    }

    public static String getAuthenticateToken(){
        String clientId = EnvironmentSpecificConfiguration.from(envs).getProperty("jira.xray.client-id");
        String clientSecret = EnvironmentSpecificConfiguration.from(envs).getProperty("jira.xray.client-secret");

        String authenticateBody = "{\n" +
                "  \"client_id\": \""+clientId+"\",\n" +
                "  \"client_secret\": \""+clientSecret+"\"\n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(authenticateBody)
                .when().log().all()
                .post(API_XRAY_AUTHENTICATE);
        response.prettyPeek();
        response.then().assertThat().statusCode(200);

        return response.asString().replace("\"", "");
    }

    public static String getCucumberJsonContentAsString(String cucumberJsonFile) {
        Path cucumberPath = Path.of(System.getProperty("user.dir") + cucumberJsonFile);
        try{
            return Files.readString(cucumberPath, StandardCharsets.UTF_8);
        }
        catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Something went wrong");
        }
    }

}
