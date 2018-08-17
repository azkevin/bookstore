# Bookstore

A simple bookstore application built using Java EE, Apache Derby, Apache Tomcat, Apache Axis, and Jersey.

## Setup

1. Install [Eclipse IDE for Java EE Developers](https://www.eclipse.org/downloads/packages/) and [Apache Tomcat 8.5](https://tomcat.apache.org/download-80.cgi) as a zip. Add the Tomcat server to the Eclipse using the New Server Wizard.

2. Under the Git Repositories view in Eclipse, select "Clone a Git repository. Enter this repository's URL under the URI field and press Next.

3. Right click "Bookstore [master]" and select "Import Projects..". Only select Bookstore\TabsVsSpaces, and Bookstore\TabsVsSpacesClient (if you want to use the SOAP and REST services) and press Finish.

4. Change the value of "url" in [TabsVsSpaces\WebContent\META-INF\context.xml](/TabsVsSpaces/WebContent/META-INF/context.xml) to the absolute path found in your workspace.

That is, 

```
url="jdbc:derby:XXX\TabsVsSpaces\WebContent\TabsVsSpaces_DB;create=true"/>

```

5. Under the Servers view, right click the Tomcat server and select Add and Remove. Add the "TabsVsSpaces" resource.

6. Start the server, and go to http://localhost:8080/TabsVsSpaces/ to confirm it is running.

The data is populated from the [TabsVsSpacesCreateTables.sql file](/TabsVsSpacesCreateTables.sql), and deleted from the [TabsVsSpacesDropTables.sql file](/TabsVsSpacesDropTables.sql)

## Web Services

### SOAP

To access the SOAP Web Service, invoke an HTTP POST request at the following endpoint:
- http://localhost:8080/TabsVsSpaces/services/SOAP_TVS

If TabsVsSpaces_Test is also running on the server, a test client can be accessed at the following link:
- http://localhost:8080/TabsVsSpaces_Test/sampleSOAP_TVSProxy/TestClient.jsp?endpoint=http://localhost:11230/TabsVsSpaces/services/SOAP_TVS

## Credit

This project was made for EECS4413, an e-commerce software development class at York University.

Created by:
- Kevin Arindaeng
- Shagun Kazan
- Akshaykumar Patel