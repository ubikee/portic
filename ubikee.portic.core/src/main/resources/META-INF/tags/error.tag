<%@ tag body-content="empty"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<%@ attribute name="title" required="false"%>
<%@ attribute name="errorView" required="true" type="com.irtve.plataforma.portal.core.view.ErrorView"%>
<%@ attribute name="width" required="false"%>

<table style="width:${width}; border: solid 1px;">
	<tr>
		<th style="font-size: 13px; text-decoration: underline;">${title}</th>
	</tr>
	<tr>
		<td style="border-bottom: solid 1px #dddddd; overflow: hidden">
			<c:forEach items="${errorView}" var="item">
			<table style="width: 100%; border-top: solid 1px #dddddd;">
				<tr>
					<td align="left">Class</td>
					<td style="width: 30px; height: 30px;">${item.sourceClass}</td>
				</tr>
				<tr>
					<td align="left">Message</td>
					<td align="left">${item.message}</td>
				</tr>
			</table>
			</c:forEach>
		</td>
	</tr>
</table>