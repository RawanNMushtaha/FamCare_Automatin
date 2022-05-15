/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;

/**
 *
 * @author HP
 */
public class TestRailManager {

    APIClient client;
    public static int PASSED = 1, FAILED = 5, Blocked = 2, UNTESTED = 3, RETEST = 4;//    static int testRunId = 59;
//    static int testCaseId = 3738;

    public TestRailManager() {
        client = new APIClient("https://gth.testrail.io");
        client.setUser("ibrahimht2000@gmail.com");
        client.setPassword("GTH@2021");
    }

    public void getResults() throws IOException, MalformedURLException, APIException {
        JSONObject c = (JSONObject) client.sendGet("get_case/2372");
        System.out.println(c.get("title"));

    }

    public void setResult(String testRunId, String testCaseID, int status) throws IOException, MalformedURLException, APIException {
        Map data = new HashMap();
        data.put("status_id", status);
//        data.put("comment", "This TestRailManager worked fine!");
        // JSONObject r = (JSONObject) client.sendPost("add_result_for_case/1/1", data);
        JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseID + "", data);
        System.out.println(r.toJSONString());

    }
}
