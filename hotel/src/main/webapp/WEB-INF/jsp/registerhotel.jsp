<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Registrar Hotel</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="select">
  <h2>Registrar Hotel</h2>

  <form action="${pageContext.request.contextPath}/registrarHotel" method="post" class="form-container">
    <input type="text" name="name" placeholder="Nombre" required />
    <input type="text" name="address" placeholder="Dirección" required />
    <input type="text" name="phone" placeholder="Teléfono" required />
    <input type="text" name="city" placeholder="Ciudad" required />
    <input type="number" name="roomCapacity" placeholder="Capacidad" required />
    <select name="status" required>
      <option value="">-- Seleccione Estado --</option>
      <option value="activo">Activo</option>
      <option value="inactivo">Inactivo</option>
    </select>
    <button type="submit" class="btn">Guardar Hotel</button>
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
