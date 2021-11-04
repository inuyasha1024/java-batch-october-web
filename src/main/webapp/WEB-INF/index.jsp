<%@ page import="com.siliconspectra.vo.User" %>
<html>
<body>

    <% User user = (User)request.getSession().getAttribute("user");%>
    <h1>Hello <%=user.getUsername()%> </h1>
</body>

</html>
