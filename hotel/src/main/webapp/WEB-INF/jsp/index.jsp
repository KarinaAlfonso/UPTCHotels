<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Main Menu</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

  <div class="topnav">
    <div class="nav-left">
      <a href="${pageContext.request.contextPath}/">UPTCHotels</a>
    </div>
    <div class="nav-right">
      <a href="#">SOBRE NOSOTROS</a>
      <a href="#">CONTACTO</a>
    </div>
  </div>

  <div class="select">
    <h2>Selecciona una opción</h2>

    <form action="${pageContext.request.contextPath}/hotels/form" method="get">
      <button type="submit" class="btn">Registrar Hotel</button>
    </form>

    <form action="${pageContext.request.contextPath}/bookings/form" method="get">
      <button type="submit" class="btn">Registrar reserva</button>
    </form>
  </div>

  <div class="footer">
    <p>&copy; 2025 UPTCHotels - Todos los derechos reservados</p>
  </div>

</body>
</html>
