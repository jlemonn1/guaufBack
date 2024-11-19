# 🐾 Guauf Backend

Este proyecto constituye el backend del sistema de gestión de mascotas **Guauf**, diseñado para registrar información sobre mascotas y sus dueños, permitiendo el registro mediante códigos QR. Desarrollado con **Spring Boot**, este backend incluye funcionalidades como la creación de registros, actualización de datos, y gestión de imágenes.

---

## 📂 Estructura del proyecto

```
src/
├── com/example/animales/
│   ├── entity/
│   │   └── Datos.java  # Entidad que representa los datos de la mascota y su dueño
│   ├── controller/
│   │   └── DatosController.java  # Controlador REST para gestionar la API
│   ├── service/
│       └── DatosService.java  # Lógica de negocio
```

---

## 🔧 Configuración e instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/guauf-backend.git
cd guauf-backend
```

### 2. Configurar la base de datos

Este proyecto utiliza **MariaDB** o **MySQL** como base de datos. Asegúrate de tener una instancia configurada y actualiza el archivo `application.properties` con los detalles de conexión.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/guauf
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

### 3. Ejecutar la aplicación

Compila y ejecuta el backend con:

```bash
./mvnw spring-boot:run
```

La API estará disponible en `http://localhost:8080/api/datos`.

---

## 📖 Endpoints principales

### **Crear un nuevo registro**

**POST** `/api/datos/nuevo`  
Crea un registro vacío con el estado `registrado` como `false`.

**Respuesta:**  
```json
{
  "id": 1,
  "registrado": false,
  "nombreMascota": null,
  "nombre": null,
  ...
}
```

---

### **Obtener datos por ID**

**GET** `/api/datos/{id}`  
Obtiene la información completa de un registro por su ID.

---

### **Actualizar datos**

**PUT** `/api/datos/actualizar/{id}`  
Actualiza un registro no registrado y marca el estado como `registrado: true`.

**Parámetros:**  
- `foto` (opcional): Imagen de la mascota.
- Otros campos opcionales: `nombreMascota`, `raza`, `infoMascota`, `nombre`, `numero`, `direccion`, `infoDueno`, `whatsapp`.

---

### **Eliminar un registro**

**DELETE** `/api/datos/remove/{id}`  
Elimina un registro por su ID.

---

### **Resetear datos**

**PUT** `/api/datos/flush/{id}`  
Resetea todos los campos de un registro a valores vacíos y marca `registrado` como `false`.

---

## ✨ Mejoras futuras

1. Implementar autenticación para restringir ciertos endpoints.
2. Optimización para manejar imágenes de manera más eficiente.
3. Implementar validación avanzada en los datos.

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si tienes ideas o mejoras, no dudes en crear un **issue** o enviar un **pull request**.