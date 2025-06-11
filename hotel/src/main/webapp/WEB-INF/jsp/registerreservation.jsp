<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Registrar Reserva</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="select">
  <h2>Registrar Reserva</h2>


  <c:if test="${not empty mensaje}">
  <p style="color: green; text-align: center;">${mensaje}</p>
</c:if>

  <form action="${pageContext.request.contextPath}/registrarReserva" method="post" class="form-container">
    <input type="text" name="nombreHotel" placeholder="Nombre del Hotel" required />
    <input type="text" name="ciudad" placeholder="Ciudad" required />
    <input type="text" name="nombrePersona" placeholder="Nombre del Cliente" required />
    <input type="text" name="documento" placeholder="Documento" required />
    <input type="email" name="email" placeholder="Email" required />
    
    <label for="llegada">Fecha de Llegada:</label>
    <input type="date" id="llegada" name="llegada" required />

    <label for="salida">Fecha de Salida:</label>
    <input type="date" id="salida" name="salida" required />

    <input type="text" name="estadoReserva" placeholder="Estado (ej: Registered)" required />
    
    <button type="submit" class="btn">Guardar Reserva</button>
  </form>

  <form action="${pageContext.request.contextPath}/" method="get">
    <button type="submit" class="btn">Menú</button>
  </form>
</div>

<div class="footer">
  <p>&copy; 2025 UPTCHotels - Todos los derechos reservados</p>
</div>

</body>
</html>
