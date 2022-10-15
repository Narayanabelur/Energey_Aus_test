package Api_testing_energy_australia;

import io.cucumber.java.en.*;
import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    String host = "https://eacp.energyaustralia.com.au";
    String baseUrl = "/codingtest/api/v1/festivals";
    String authKey = "RhZkZspPybwTvFjEdFySyPALOPSvMvgVo48ELoF4ebwr/LMPaC89qD6rd6QCCxp0WP5fin34Qr7VsYAedq0pEXO0Yuild/qogScCFBIdIIxmHlHvznvuTQgwXVSa";

    @Given("I call api {string}")
    public void iCallApi(String apiName) throws Exception {
//        HttpResponse <String> httpResponse = Unirest.get("https://eacp.energyaustralia.com.au/codingtest/api/v1/festivals").asString();
//        System.out.println( httpResponse.getHeaders().get("Content-Type"));
        // Host url
        String hostName = "https://eacp.energyaustralia.com.au/codingtest/api/v1/festivals";
        String x_rapidapi_key = "RhZkZspPybwTvFjEdFySyPALOPSvMvgVo48ELoF4ebwr/LMPaC89qD6rd6QCCxp0WP5fin34Qr7VsYAedq0pEXO0Yuild/qogScCFBIdIIxmHlHvznvuTQgwXVSa";

        HttpResponse <JsonNode> response = Unirest.get(hostName).header("x-rapidapi-key", x_rapidapi_key).asJson();
        if ( response.getStatus() == 200) {
            System.out.println("\t Response code: 200-Success");
        } else if (response.getStatus() == 429) {
            System.out.println("\t Request throttled. Try again");
        }
        System.out.println(response.getStatus());
        System.out.println(response.getHeaders().get("Content-Type"));
        //List contentType = response.getHeaders().get("Content-Type");

        //Prettifying
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);
    }



    @When("I see request {string}")
    public void iSeeRequest(String status) throws Exception {
        HttpResponse <JsonNode> response = callApi(host, baseUrl, authKey);
        if ( response.getStatus() == 200) {
            System.out.println("\t Response code: 200-Success");
        } else if (response.getStatus() == 429) {
            System.out.println("\t Request throttled. Try again");
        }
    }

    @Then("I should get status code {int}")
    public void iShouldGetStatusCode(int status) throws Exception {
        HttpResponse <JsonNode> response = callApi(host, baseUrl, authKey);
        assert response.getStatus() == status: "Unsuccessful request";
    }

    @Then("I should see {string} {string}")
    public void iShouldSee(String MusicFestival, String Name) throws Exception {
        HttpResponse <JsonNode> response = callApi(host, baseUrl, authKey);
        assert response.getStatus() == status: "Unsuccessful request";
    }

    @And ("I should see {string} band in {string}")
    public void iShouldSeeBandIn(String MusicFestival, String Name) throws Exception {
        HttpResponse <JsonNode> response = callApi(host, baseUrl, authKey);
        assert response.getStatus() == status: "Unsuccessful request";
        assert response.
    }

    @And ("I should see record label {Outerscope} in band {Squint-281}")
    public void iShouldSeeRecordLabel(String recLabel, String bandName) throws Exception {
        HttpResponse <JsonNode> response = callApi(host, baseUrl, authKey);
        assert response.getStatus() == status: "Unsuccessful request";
    }

    public HttpResponse <JsonNode> callApi(String host, String baseUrl, String authKey) throws Exception {
        String url = host + baseUrl;
        System.out.println("\t url" + url);
        return Unirest.get(url).header("authkey", authKey).asJson();
    }
}