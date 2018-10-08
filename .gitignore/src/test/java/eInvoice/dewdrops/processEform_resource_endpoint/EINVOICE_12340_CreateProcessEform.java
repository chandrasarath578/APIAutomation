package eInvoice.dewdrops.processEform_resource_endpoint;

import static org.testng.Assert.assertEquals;

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

public class EINVOICE_12340_CreateProcessEform {
	@Test()
	public  void Eform_Creation() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.createProcessEform);
	    String createIssuePayLaod = TestUtil.generatePayLoadString("CreateProcessEform");
	    Response res=Webservices.POSTRequestWithHeader(url, createIssuePayLaod,userId, tenantid, trackingNumber);
	    TestUtil.verifyResponse(res);
		Reporter.log("Response "+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.entityData.createdBy"), Arrays.asList(userId));

	
	}
	@Test()
	public  void Eform_Creation_Status_1() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.createProcessEform);
	    String createIssuePayLaod = TestUtil.generatePayLoadString("CreateProcessEform");
	    JSONObject js = new JSONObject(createIssuePayLaod);
	    JSONArray js1 = js.getJSONArray("businessEntity");
	    JSONObject js2 = js1.getJSONObject(0);
		JSONObject js3 = (JSONObject) js2.get("entityData");
		js3.put("status", 1);
		String finalJson = ((Object) js).toString();
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    TestUtil.verifyResponse(res);
		Reporter.log("Response "+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.entityData.createdBy"), Arrays.asList(userId));

	
	}
	@Test()
	public  void Eform_Creation_Status_2() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.createProcessEform);
	    String createIssuePayLaod = TestUtil.generatePayLoadString("CreateProcessEform");
	    JSONObject js = new JSONObject(createIssuePayLaod);
	    JSONArray js1 = js.getJSONArray("businessEntity");
	    JSONObject js2 = js1.getJSONObject(0);
		JSONObject js3 = (JSONObject) js2.get("entityData");
		js3.put("status", 2);
		String finalJson = ((Object) js).toString();
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    TestUtil.verifyResponse(res);
		Reporter.log("Response "+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_200);
		assertEquals(res.jsonPath().get("businessEntity.entityData.createdBy"), Arrays.asList(userId));

	
	}
	@Test()
	public  void Eform_Creation_Status_Invalid() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
	    String url=URL.getEndPoint(dewdrops_APIList.createProcessEform);
	    String createIssuePayLaod = TestUtil.generatePayLoadString("CreateProcessEform");
	    JSONObject js = new JSONObject(createIssuePayLaod);
	    JSONArray js1 = js.getJSONArray("businessEntity");
	    JSONObject js2 = js1.getJSONObject(0);
		JSONObject js3 = (JSONObject) js2.get("entityData");
		js3.put("status", 3);
		String finalJson = ((Object) js).toString();
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    TestUtil.verifyResponse(res);
		Reporter.log("Response "+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);
	}
	@Test()
	public  void Eform_Creation_ProcessCode_Invalid() throws JSONException  {
		String userId=TestUtil.getUserid();
		String tenantid=TestUtil.getTenantid();
		int trackingNumber=TestUtil.randomTrackingNumber();
		String entityId = TestUtil.randomentityId();
	    String url=URL.getEndPoint(dewdrops_APIList.createProcessEform);
	    String createIssuePayLaod = TestUtil.generatePayLoadString("CreateProcessEform");
	    JSONObject js = new JSONObject(createIssuePayLaod);
	    JSONArray js1 = js.getJSONArray("businessEntity");
	    JSONObject js2 = js1.getJSONObject(0);
		JSONObject js3 = (JSONObject) js2.get("entityData");
		js3.put("processCode", entityId);
		String finalJson = ((Object) js).toString();
	    Response res=Webservices.POSTRequestWithHeader(url, finalJson,userId, tenantid, trackingNumber);
	    TestUtil.verifyResponse(res);
		Reporter.log("Response "+res.asString(),true);
		Reporter.log("Status Code "+res.statusCode(),true);
		assertEquals(res.statusCode(), TestUtil.RESPONSE_CODE_400);	
	}
}
