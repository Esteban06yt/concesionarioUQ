# 🚗 Tu Carro UQ — Concesionario
 
Sistema de gestión de concesionario de vehículos desarrollado con **JavaFX** como proyecto académico para la asignatura de Programación Orientada a Objetos en la **Universidad del Quindío**.
 
---
 
## 📋 Descripción
 
**Tu Carro UQ** permite gestionar de forma integral las operaciones de un concesionario automotriz. El sistema contempla tres roles de usuario: Administrador, Empleado y Cliente, cada uno con sus propias funcionalidades y vistas diferenciadas.
 
---
 
## 🚀 Funcionalidades
 
### 👤 Administrador
- Inicio de sesión con selección de rol
- Recuperación de contraseña mediante pregunta de seguridad
- Gestión completa de empleados (agregar, actualizar, eliminar, listar)
### 🛠️ Empleado
- Gestión de vehículos asignados (agregar, actualizar, eliminar)
- Gestión de clientes asignados (agregar, actualizar, eliminar)
- Registro y administración de transacciones (ventas y alquileres)
- Visualización de tablas de vehículos, clientes y transacciones
### 🧑‍💼 Cliente
- Consulta del historial de transacciones
- Visualización de ventas y alquileres asociados
---
 
## 🏗️ Arquitectura
 
El proyecto sigue un patrón en capas con separación entre modelo, controlador de negocio y controlador de vista.
 
```
src/
├── main/
│   ├── java/co/edu/uniquindio/poo/
│   │   ├── Controller/          # Controladores de negocio
│   │   │   ├── Personacontroller.java
│   │   │   ├── TransaccionController.java
│   │   │   └── VehiculoController.java
│   │   ├── model/               # Entidades del dominio
│   │   │   ├── Persona, Cliente, Empleado, Administrador
│   │   │   ├── Vehiculo y subclases (Moto, Sedan, SUV, Bus, etc.)
│   │   │   ├── Transaccion, Venta, Alquiler
│   │   │   └── Enums: Estado, Transmision
│   │   ├── viewcontroller/      # Controladores JavaFX
│   │   └── application/         # Punto de entrada (App.java)
│   └── resources/               # Vistas FXML e imágenes
└── test/                        # Pruebas JUnit 5
```
 
---
 
## 🚘 Jerarquía de Vehículos
 
El sistema soporta una amplia variedad de tipos de vehículos organizados por tipo de carrocería y combustible:
 
```
Vehiculo (abstracto)
├── VehiculoGasolina → Moto, Deportivo, Camion, Pickup, Camioneta, SUV, Bus, Van, Sedan
├── VehiculoDiesel   → (mismos tipos)
├── VehiculoElectrico → (mismos tipos + autonomia/tiempoCarga)
└── VehiculoHibrido  → (mismos tipos + enchufable/hibridoLigero)
```
 
---
 
## 👥 Jerarquía de Personas
 
```
Persona (abstracta)
├── Cliente      → listatransacciones[]
├── Empleado     → listatransacciones[], listavehiculos[], listaclientes[]
└── Administrador → listaempleados[]
```
 
---
 
## 🔄 Transacciones
 
```
Transaccion
├── Venta    → metodopago, garantia
└── Alquiler → fechaDevolucion, duracionalquiler
```
 
Cada transacción se asocia automáticamente al cliente, empleado y vehículo correspondientes al momento de su creación.
 
---
 
## 🛠️ Tecnologías
 
| Tecnología | Versión | Uso |
|---|---|---|
| Java | 11 | Lenguaje principal |
| JavaFX | 13 | Interfaz gráfica |
| Maven | 3.8+ | Gestión de dependencias |
| JUnit Jupiter | 5.11.3 | Pruebas unitarias |
 
---
 
## ⚙️ Configuración y Ejecución
 
### Requisitos
- Java 11+
- Maven 3.8+
### Clonar e iniciar
```bash
git clone <url-del-repositorio>
cd concesionario
mvn javafx:run
```
 
### Ejecutar pruebas
```bash
mvn test
```
 
---
 
## 👤 Credenciales por defecto
 
| Rol | Correo | Contraseña |
|---|---|---|
| Administrador | `Pedrosisi@gmail.com` | `12345678` |
| Administrador (rápido) | `a` | `a` |
| Empleado | `Paco213@gmail.com` | `0000` |
| Cliente | `Juanito@gmail.com` | `1234` |
 
---
 
## 🧪 Pruebas
 
Las pruebas unitarias están en `src/test/java/` y cubren:
 
- `AdministradorTest` — CRUD de empleados desde el administrador
- `ConcesionarioTest` — CRUD de transacciones con verificación de asociaciones automáticas
- `EmpleadoTest` — CRUD de vehículos y clientes del empleado
- `VehiculoTest` — CRUD de transacciones en el vehículo
---

## 👨‍💻 Autor

**Mateo Mejia** - [@MateoMB2805](https://github.com/MateoMB2805)
**Esteban Polanco** - [@Esteban06yt](https://github.com/Esteban06yt)
**Juan David** — [@Juanda2312](https://github.com/Juanda2312)  
Universidad del Quindío · Ingeniería de Sistemas · Programación Orientada a Objetos
