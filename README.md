# 🏨 ReservasUQ — BookYourStay

Sistema de gestión de reservas de alojamientos desarrollado con **JavaFX** como proyecto académico para la asignatura de Programación Orientada a Objetos en la **Universidad del Quindío**.

---

## 📋 Descripción

**BookYourStay** permite a clientes buscar y reservar alojamientos (hoteles, casas y apartamentos), gestionar su cuenta y billetera virtual, y dejar reseñas. Los administradores pueden gestionar alojamientos, ofertas, servicios, habitaciones y consultar reportes de ganancias y ocupación.

---

## 🚀 Funcionalidades

### 👤 Cliente
- Registro e inicio de sesión con verificación por correo
- Recuperación de contraseña
- Explorar y filtrar alojamientos por nombre, tipo, ciudad y capacidad
- Reservar alojamientos y habitaciones de hotel
- Cancelar reservas con reembolso automático
- Recarga y consulta de billetera virtual
- Gestión de reseñas y valoraciones
- Notificaciones por correo electrónico con QR de factura

### 🛠️ Administrador
- Gestión completa de alojamientos (Hotel, Casa, Apartamento)
- Gestión de habitaciones por hotel
- Creación y edición de ofertas y descuentos
- Gestión de servicios por alojamiento
- Lista de clientes y control de cuentas
- Cancelación de reservas
- Reportes y estadísticas:
  - Alojamientos más populares por ciudad
  - Ganancias totales por alojamiento y tipo
  - Ocupación porcentual por rango de fechas
  - Promedio de valoraciones

---

## 🏗️ Arquitectura

El proyecto sigue un patrón en capas con el patrón **Factory** para la creación de alojamientos y **Singleton** para la sesión de usuario y el controlador principal.

```
src/
├── main/
│   ├── java/co/edu/uniquindio/reservasuq/
│   │   ├── controllers/       # Controladores JavaFX
│   │   ├── model/
│   │   │   ├── entities/      # Cliente, Reserva, Oferta, Resenia, Factura...
│   │   │   └── factory/       # Alojamiento, Hotel, Casa, Apartamento, Habitacion
│   │   ├── repositories/      # Persistencia por serialización
│   │   ├── services/          # Lógica de negocio
│   │   ├── config/            # Sesión, configuración de correo
│   │   └── utils/             # Persistencia, QR, envío de email, validación
│   └── resources/             # Vistas FXML
└── test/                      # Pruebas JUnit 5
```

---

## 🛠️ Tecnologías

| Tecnología | Versión | Uso |
|---|---|---|
| Java | 21 | Lenguaje principal |
| JavaFX | 21 | Interfaz gráfica |
| Maven | 3.8.5 | Gestión de dependencias |
| Lombok | 1.18.36 | Reducción de boilerplate |
| Simple Java Mail | 8.10.1 | Envío de correos |
| ZXing | 3.5.1 | Generación de códigos QR |
| JUnit 5 | 5.10.2 | Pruebas unitarias |

---

## ⚙️ Configuración y ejecución

### Requisitos
- Java 21 (Temurin recomendado)
- Maven 3.8+

### Clonar e iniciar
```bash
git clone https://github.com/Juanda2312/ReservasUq.git
cd ReservasUq
./mvnw javafx:run
```

### Ejecutar pruebas
```bash
./mvnw test
```

---

## 📁 Persistencia

Los datos se almacenan localmente mediante serialización de objetos Java en la carpeta `data/`:

```
data/
├── usuarios.data
├── alojamientos.data
├── reservas.data
└── ofertas.data
```

> La carpeta `data/` se crea automáticamente al iniciar la aplicación.

---

## 📧 Configuración de correo

El sistema envía notificaciones automáticas por Gmail. Las credenciales se configuran en:

```
src/main/java/co/edu/uniquindio/reservasuq/config/Correo.java
```

> ⚠️ Se recomienda usar una contraseña de aplicación de Google y **no** subir credenciales reales al repositorio.

---

## 👤 Credenciales de administrador por defecto

| Campo | Valor |
|---|---|
| Correo | `juandavidtapiero22@gmail.com` |
| Contraseña | `1234` |

---

## 📌 Diagrama de entidades principales

```
Usuario
├── Cliente  →  Billetera, Reservas[], Resenias[]
└── Administrador

Alojamiento (abstract)
├── Hotel      →  Habitacion[]
├── Casa
└── Apartamento

Reserva  →  Alojamiento, Cliente, Factura
Oferta   →  Alojamiento[]
Resenia  →  titulo, descripcion, valoracion
```

---

## 🧪 Pruebas

Las pruebas unitarias se encuentran en `src/test/java/` y cubren los principales casos de uso del servicio central (`EmpresaServicio`):

- Registro de clientes (validaciones de formato y duplicados)
- Creación de casas, apartamentos, hoteles y habitaciones
- Gestión de servicios y ofertas

---

## 👨‍💻 Autor

**Mateo Mejia** - [@MateoMB2805](https://github.com/MateoMB2805)
**Esteban Polanco** - [@Esteban06yt](https://github.com/Esteban06yt)
**Juan David** — [@Juanda2312](https://github.com/Juanda2312)  
Universidad del Quindío · Ingeniería de Sistemas · Programación Orientada a Objetos
