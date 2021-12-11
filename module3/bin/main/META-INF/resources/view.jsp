
<%@page import="site.hadef.database3.service.GenderLocalServiceUtil"%>
<%@page import="site.hadef.database3.model.Gender"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<%
	List<Gender> genders = GenderLocalServiceUtil.getGenders(-1, -1);
	for(Gender gender:genders){
%>
	<h1><%=gender.getGenderId()+StringPool.DASH+StringPool.SPACE+gender.getGenderName() %></h1>
<%
}
%>