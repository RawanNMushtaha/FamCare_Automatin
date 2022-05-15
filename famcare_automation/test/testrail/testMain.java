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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author HP
 */
public class testMain {

    static APIClient client;
    static String testRunId = "59";
    static String testCaseId = "3738";

//    public testMain() {
//        client = new APIClient("https://gth.testrail.io");
//        client.setUser("ibrahimht2000@gmail.com");
//        client.setPassword("GTH@2021");
//    }
    public static void main(String[] args) {
        client = new APIClient("https://gth.testrail.io");
        client.setUser("ibrahimht2000@gmail.com");
        client.setPassword("GTH@2021");
        try {
            getResults();
        } catch (IOException | APIException ex) {
            Logger.getLogger(TestRailManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setResult(testRunId, testCaseId, TestRailManager.FAILED);
        } catch (IOException | APIException ex) {
            Logger.getLogger(testMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getResults() throws IOException, MalformedURLException, APIException {
        JSONObject c = (JSONObject) client.sendGet("get_case/2372");
        System.out.println(c.get("title"));

    }

    public static void setResult(String testRunId, String testID, int status) throws IOException, MalformedURLException, APIException {
        Map data = new HashMap();
        data.put("status_id", status);
//        data.put("comment", "This TestRailManager worked fine!");
        // JSONObject r = (JSONObject) client.sendPost("add_result_for_case/1/1", data);
        JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + testRunId + "/" + testID + "", data);
        System.out.println(r.toJSONString());

    }
}
