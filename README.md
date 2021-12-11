# Liferay-7.1-External-database-configuration


Inside your tomcat prepare the following:
<br><br>
1- Add this in server.xml
```
<Resource
		name="jdbc/db1"
		auth="Container"
		type="javax.sql.DataSource"
		factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
		driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/db1?useUnicode=true&amp;characterEncoding=UTF-8&amp;useFastDateParsing=false"
		username="root"
		password=""
		maxActive="20"
		maxIdle="5"
		maxWait="10000"
	/>
	<Resource
		name="jdbc/db2"
		auth="Container"
		type="javax.sql.DataSource"
		factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
		driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/db2?useUnicode=true&amp;characterEncoding=UTF-8&amp;useFastDateParsing=false"
		username="root"
		password=""
		maxActive="20"
		maxIdle="5"
		maxWait="10000"
	/>
  ```
  <br><br><br>
  2-context.xml
   ```
  <ResourceLink name="jdbc/db1" global="jdbc/db1" type="javax.sql.DataSource"/>
	<ResourceLink name="jdbc/db2" global="jdbc/db2" type="javax.sql.DataSource"/>
   ```
   <br><br><br>
  3-Configure portal-ext.properties
   ```
  include-and-override=portal-developer.properties
  jdbc.external.driverClassName=com.mysql.jdbc.Driver
  jdbc.external.url=jdbc:mysql://localhost/db3?characterEncoding=UTF-8&dontTrackOpenResources=true&holdResultsOpenOverStatementClose=true&useFastDateParsing=false&useUnicode=true
  jdbc.external.username=database_username
  jdbc.external.password=database_password
  ```
