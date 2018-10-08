package eInvoice.dewdrops.invoice_resource_endpoint;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

public class EINVOICE_12229_DeleteWithInfo extends EINVOICE_12167_UpdateFilterWithCreateFilterInput {
	@Test()
	public  void Filter_Deletion() throws JSONException   {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.Delete_Info_Api);
	    String createIssuePayLaod = TestUtil.generatePayLoadString("Delete_Info");
	    JSONObject existingPreferenceObject = new JSONObject(createIssuePayLaod);
		JSONArray result = existingPreferenceObject.getJSONArray("businessEntity");
		JSONObject result1 = result.getJSONObject(0);
		JSONObject result2 = (JSONObject) result1.get("entityData");
		result2.put("filterId",res1);
		result2.put("filterName",entityid);
	    String finalJson = ((Object) existingPreferenceObject).toString();
	    //System.out.println("finalJson2 --> : " + finalJson);
	    Response res2=Webservices.POSTRequestWithHeader(url,finalJson,userId, tenantid, trackingNumber);
	    TestUtil.verifyResponse(res2);
		Reporter.log("Response "+res2.asString(),true);
		Reporter.log("Status Code "+res2.statusCode(),true);
		assertEquals(res2.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res2.jsonPath().get("businessEntity.entityData.modifiedBy"), Arrays.asList(userId));
}
	
	@Test()
	public  void Filter_Deletion_Invalid() throws JSONException   {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.Delete_Info_Api);
	    String createIssuePayLaod = TestUtil.generatePayLoadString("Delete_Info");
	    JSONObject existingPreferenceObject = new JSONObject(createIssuePayLaod);
		JSONArray result = existingPreferenceObject.getJSONArray("businessEntity");
		JSONObject result1 = result.getJSONObject(0);
		JSONObject result2 = (JSONObject) result1.get("entityData");
		result2.put("filterId",trackingNumber);
		result2.put("filterName",entityid);
		//System.out.println(entityid);
	    String finalJson = ((Object) existingPreferenceObject).toString();
	    //System.out.println("Delete with Invalid Data --> : " + finalJson);
	    Response res2=Webservices.POSTRequestWithHeader(url,finalJson,userId, tenantid, trackingNumber);
	    TestUtil.verifyResponse(res2);
		Reporter.log("Response "+res2.asString(),true);
		Reporter.log("Status Code "+res2.statusCode(),true);
		assertEquals(res2.statusCode(), TestUtil.RESPONSE_CODE_400);
		assertNotEquals(res2.jsonPath().get("businessEntity.entityData.modifiedBy"), Arrays.asList(userId));
}
}
