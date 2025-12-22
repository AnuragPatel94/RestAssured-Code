Package RestAssuredProj;
  public class HTTP Request{
//GET Req.
@Test
   void getUser(){
      given()
     .when()
       .get("url")
     .then
       .status code(200)
       .body("page", equalTo(1))
       .log().all();}}

//POST Req.(data post using HashMap,org.json,POJO,gson)
@Test
   void createUser(){

HashMap data=new HashMap();
data.put("name","ABC")
data.put("doy","1994")
data.put("job","QA")
      given()
       .contentType("application/json")
       .body(data)
     .when()
       .get("url")
     .then
       .status code(201)
       .log().all();}}

//UPDATE Req.
@Test
   void updateUser(){

HashMap data=new HashMap();
data.put("name","ABC")
data.put("doy","1994")
data.put("job","SQA")
      given()
       .contentType("application/json")
       .body(data)
     .when()
       .get("url"+id)
     .then
       .status code(201)
       .log().all();}}


//WRITE PATH AND QUERY PARAMETERS

public class PATH&QUERY PARAMETERS{
//GET Req.
@Test
   void test queryandpathparameters(){
      given()
		.pathParam("mypath","pathvalue")
		.queryParam("name","value")
     .when()
       .get("url+{mypath}")
     .then
       .status code(200)
       .log().all();}}

//HANDLE COOKIES

public class cookiesDemo{
@Test
   void test cookies(){
      given()
     .when()
       .get("url")
     .then()
       .cookies("name","value")
       .log().all();}}
  

//MULTIPLE COOKIES
  void getCookieInfo() {
		
				Response res=given()
		                .when()
		                  .get("https://www.google.com/");
				               Map<String ,String>cookies_values=res.getCookies();
	                     for (String k:cookies_values.keySet()) {
		                   String cookie_value=res.getCookie(k);
		                   System.out.println(k+"   "+cookie_value);}


//VALIDATE RESPONSE DATA(JSON)
	  public class parsingJSONResponseData{
	  @Test
		  void testJSONResponse(){
			  given()
				.contentType(content-type.JSON)
			  .when()
				.get("url")
			  .then()
				  .status code(200)
				  .header("content-type","application/JSON;charset=utf-8")
				  .body("JSON Path",equalTo("value"));
		  }
				  
//VALIDATE HEADERS
  public class validateHeaders{
   @Test
    void testHeaders() {
		 given()
         .when()
		    .post("https://www.google.com/")
		 .then()
		   .header("Content-Type","text/html; charset=UTF-8")
           .header("Content-Encoding","gzip")
           .header("Server","gws");
			
	}

//HOW TO UPLOAD FILE
  public class fileuploadanddownload{
   @Test
    void test singlefileUpload() {File myfile=newfile("filepath")
		 given()
		    .multipart("file",myfile)
		    .content Type("multipart/from")
         .when()
		    .post("url")
		 .then()
		   .status code(200)
		   .body("fileName",equalTo("Test1"))
		   .log().all();
			
	}  


//HOW TO VALIDATE SCHEMA
  public class JSONSchemaValidation{
   @Test
    void test schemavalidation() {
		 given()
         .when()
		    .get("url")
		 .then()
		   .assertThat().body(JSONSchemaValidation.matchesJSONSchemaInclassPath("FileName"));
		   .log().all();
			
	}  


//HOW TO HANDLE AUTHENTICTION
  public class Authentication{
   @Test-1
    void test BasicAuth() {
		 given()
			.auth().basic("username","pswd")
			       .digest("username","pswd")
			       .preemptive("username","pswd")
         .when()
		    .get("url")
		 .then()
		   .statusCode(200)
		   .body("authenticated".equalTo(true));
		   .log().all();
			
	}  


  @Test-2
    void test BearerTokenAuth() {
	  string BrToken='Token'
		 given()
			.headrs("Authentication","Bearer"+BrToken")	     
         .when()
		    .get("url")
		 .then()
		   .statusCode(200)
		   .log().all();
			
	}  

  @Test-3 
 void test OAuth2Authentication() {
		 given()
			.auth()Oauth2("accessToken")	     
         .when()
		    .get("url")
		 .then()
		   .statusCode(200)
		   .log().all();
			
	}  



  @Test-4 
 void test APIAuthentication() {
		 given()
			.queryparam("api key","API")	     
         .when()
		    .get("url")
		 .then()
		   .statusCode(200)
		   .log().all();
			
	}  
		 
