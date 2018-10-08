package eInvoice.dewdrops.invoice_resource_endpoint;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;
import eInvoice.dewdrops.api.dewdrops_APIList;
import eInvoice.dewdrops.util.TestUtil;
import eInvoice.dewdrops.util.TestBase;
import eInvoice.dewdrops.util.URL;
import eInvoice.dewdrops.util.Webservices;
import io.restassured.response.Response;

public class EINVOICE_12409_Mailbox_Search  extends TestBase{
	
	@Test
	public void testinvoiceemailboxsearch_using_invoicenumber() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String Fieldname=reader.getCellData("emailbox", "fieldname",2 );
	  String value=reader.getCellData("emailbox", "value",2 );
	  String url=URL.getEndPoint(dewdrops_APIList.mailbox_search);
	  String createIssuePayLaod = TestUtil.generatePayLoadString("mailbox_search");
	  JSONObject js=new JSONObject(createIssuePayLaod);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
	  JSONObject js4=js3.getJSONObject(0);
	  JSONArray js5=js4.getJSONArray("criteria");
	  JSONObject js6=js5.getJSONObject(0);
	  js6.put("fieldName",Fieldname);
	  js6.put("value",value);
	  String finalJson = ((Object) js).toString();
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.invoiceNumber[0]"), value);
	  }
	@Test
	public void testinvoiceemailboxsearch_using_supplierName() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String Fieldname=reader.getCellData("emailbox", "fieldname",3 );
	  String value=reader.getCellData("emailbox", "value",3 );
	  String url=URL.getEndPoint(dewdrops_APIList.mailbox_search);
	  String createIssuePayLaod = TestUtil.generatePayLoadString("mailbox_search");
	  JSONObject js=new JSONObject(createIssuePayLaod);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
	  JSONObject js4=js3.getJSONObject(0);
	  JSONArray js5=js4.getJSONArray("criteria");
	  JSONObject js6=js5.getJSONObject(0);
	  js6.put("fieldName",Fieldname);
	  js6.put("value",value);
	  String finalJson = ((Object) js).toString();
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.supplierName[0]"), value);
	  }
	@Test
	public void testinvoiceemailboxsearch_using_docType() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String Fieldname=reader.getCellData("emailbox", "fieldname",4 );
	  String value=reader.getCellData("emailbox", "value",4 );
	  String url=URL.getEndPoint(dewdrops_APIList.mailbox_search);
	  String createIssuePayLaod = TestUtil.generatePayLoadString("mailbox_search");
	  JSONObject js=new JSONObject(createIssuePayLaod);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
	  JSONObject js4=js3.getJSONObject(0);
	  JSONArray js5=js4.getJSONArray("criteria");
	  JSONObject js6=js5.getJSONObject(0);
	  js6.put("fieldName",Fieldname);
	  js6.put("value",value.substring(0, 1));
	  String finalJson = ((Object) js).toString();
	  System.out.println(finalJson);
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.docType[0]"), Integer.parseInt(value.substring(0, 1)));
	  }

	@Test
	public void testinvoiceemailboxsearch_using_status() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String Fieldname=reader.getCellData("emailbox", "fieldname",5 );
	  String value=reader.getCellData("emailbox", "value",5 );
	  String url=URL.getEndPoint(dewdrops_APIList.mailbox_search);
	  String createIssuePayLaod = TestUtil.generatePayLoadString("mailbox_search");
	  JSONObject js=new JSONObject(createIssuePayLaod);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
	  JSONObject js4=js3.getJSONObject(0);
	  JSONArray js5=js4.getJSONArray("criteria");
	  JSONObject js6=js5.getJSONObject(0);
	  js6.put("fieldName",Fieldname);
	  js6.put("value",value.substring(0, 2));
	  String finalJson = ((Object) js).toString();
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.status[0]"), Integer.parseInt(value.substring(0, 2)));
	  }
	@Test
	public void testinvoiceemailboxsearch_using_ponumber() throws Exception {
	  String userId=TestUtil.getUserid();
      String tenantid=TestUtil.getTenantid();
	  int trackingNumber=TestUtil.randomTrackingNumber();
	  String Fieldname=reader.getCellData("emailbox", "fieldname",6 );
	  String value=reader.getCellData("emailbox", "value",6 );
	  String url=URL.getEndPoint(dewdrops_APIList.mailbox_search);
	  String createIssuePayLaod = TestUtil.generatePayLoadString("mailbox_search");
	  JSONObject js=new JSONObject(createIssuePayLaod);
	  JSONObject js2=js.getJSONObject("criteriaGroup");
	  JSONArray js3=(JSONArray) js2.getJSONArray("criteriaGroup");
	  JSONObject js4=js3.getJSONObject(0);
	  JSONArray js5=js4.getJSONArray("criteria");
	  JSONObject js6=js5.getJSONObject(0);
	  js6.put("fieldName",Fieldname);
	  js6.put("value",value);
	  String finalJson = ((Object) js).toString();
	  Response res=Webservices.POSTRequestWithHeader(url, finalJson, userId, tenantid, trackingNumber);
	  assertTrue(TestUtil.verifyResponse(res));
	  Reporter.log("responseResult1-> "+res.asString(),true);
	  assertEquals(res.jsonPath().get("result.purchaseOrderNumber[0]"), value);
	  }
	
}
