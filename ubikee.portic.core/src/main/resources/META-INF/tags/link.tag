<%@ tag body-content="empty"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<%@ attribute name="mssg" required="true"%>
<%@ attribute name="url" required="true"%>
<%@ attribute name="action" required="false"%>
<a href="${url}?action=${action}">${mssg}</a>