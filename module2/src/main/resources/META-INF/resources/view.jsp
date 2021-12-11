
<%@page import="site.hadef.database2.service.RegionLocalServiceUtil"%>
<%@page import="site.hadef.database2.model.Region"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<%
	List<Region> registeredUsers = RegionLocalServiceUtil.getRegions(-1, -1);
	for(Region xuser:registeredUsers){
%>
	<h1><%=xuser.getId()+StringPool.DASH+StringPool.SPACE+xuser.getName() %></h1>
<%
}
%>