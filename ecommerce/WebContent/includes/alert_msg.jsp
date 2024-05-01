<%@page import="com.mypackage.model.Message"%>   

 
<%
Message messg = (Message) session.getAttribute("message");
if (messg != null) {
%>
<div class="alert <%=messg.getCssClass()%>" role="alert" id="alert">
	<%=messg.getMessage()%>
</div>
<%
session.removeAttribute("message");
}
%>
<script type="text/javascript">
	setTimeout(function() {
		$('#alert').alert('close');
	}, 5000);
</script>