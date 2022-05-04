package HPMS.Billing;
import org.json.*;
import org.junit.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import HPMS.Billing.Billing;

import static org.junit.Assert.*;

public class BillingTest {

    @Test
    public void getJSON_is_sucess() throws IOException, InterruptedException {
        //DONE
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://happypets-2140724455.us-east-1.elb.amazonaws.com/api/billing"))
                .build();
        URI uri = request.uri();
        String val = uri.toString();
        assertTrue(val.equals("http://happypets-2140724455.us-east-1.elb.amazonaws.com/api/billing"));
    }


    @Test
    public void getCustomerID_test_is_success() throws IOException, InterruptedException {
        // creates billing instance- NOT DONE
        Billing tester = new Billing();
        String testResponse=  tester.getJSON();
        //testing if the values in getCustomerID are customerIDs
        ArrayList<Integer>testList = tester.getCustomerID(testResponse);


    }
    @Test
    public void find_test_is_success() throws IOException, InterruptedException {
        //DONE
        Billing tester= new Billing();
        ArrayList<JSONObject>mockArray = new ArrayList<JSONObject>();
        JSONObject mock = new JSONObject();
        JSONObject mock2 = new JSONObject();
        JSONObject mock3 = new JSONObject();
        mock.put ("customerID",1234);
        mock2.put("customerID",1111);
        mock3.put("CustomerID",4321);
        mockArray.add(mock);
        mockArray.add(mock2);
        mockArray.add(mock3);
        assertEquals(tester.find(2222,mockArray),null);
        assertEquals(tester.find(1234,mockArray),1234);


    }




    @Test
    public void verify_is_success() throws IOException, InterruptedException {
        // test if it returns false if fed an ID not in the Json
        //DONE
        Billing tester= new Billing();
        int nonOfficialID = 1111;
        boolean verifyTester= tester.verify(nonOfficialID);
        assertEquals(verifyTester,false);




    }

}