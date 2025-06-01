# Your Online Wallet (YOW)

[![GitHub Stars](https://img.shields.io/github/stars/Pablo-r-stack/Your-Online-Wallet.svg)](https://github.com/Pablo-r-stack/Your-Online-Wallet/stargazers)
[![GitHub Issues](https://img.shields.io/github/issues/Pablo-r-stack/Your-Online-Wallet.svg)](https://github.com/Pablo-r-stack/Your-Online-Wallet/issues)
[![Current Version](https://img.shields.io/badge/version-1.0.0-green.svg)](https://github.com/Pablo-r-stack/Your-Online-Wallet)
[![Live Demo](https://img.shields.io/badge/demo-offline-lightgrey.svg)](https://github.com/Pablo-r-stack/Your-Online-Wallet)
[![Figma Design](https://img.shields.io/badge/Figma-Design-blue?logo=figma)](https://www.figma.com/design/OER4zN4FbHUT4gT0oYJRUj/YOW?node-id=0-1&p=f&t=Ce7Yb0Lb0nL8GXgI-0)



**YOW** es una aplicación web de billetera digital que permite a los usuarios mayores de 18 años realizar pagos en línea, transferencias entre cuentas, ingresar dinero desde tarjetas de crédito o débito y visualizar el historial de movimientos, todo a través de una interfaz intuitiva y segura.

![Vista previa de YOW](public/yow-readme.png)

---

## ☕ Acerca de:

Este proyecto fue desarrollado en el marco del programa de simulaciones laborales de **No Country**, con fines educativos y de práctica en un entorno cooperativo similar al laboral.

---

## 🚀 Funcionalidades

- **Registro y Autenticación**: Sistema de registro y login con autenticación JWT.
- **Pagos en Línea**: Realiza pagos de servicios de forma rápida y segura.
- **Transferencias**: Envía dinero de una cuenta a otra dentro de la plataforma.
- **Ingreso de Dinero**: Añade fondos desde tarjetas de crédito o débito.
- **Historial de Movimientos**: Visualiza todas tus transacciones realizadas.
- **Diseño Responsivo**: Interfaz adaptada para dispositivos desktop y móviles.
- **Seguridad Básica**: Protección de la información del usuario mediante buenas prácticas de seguridad.

---

## 🛠️ Tecnologías Utilizadas

### Backend

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)](https://www.postman.com/)
[![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)](https://jwt.io/)
[![MVC](https://img.shields.io/badge/MVC-architecture-blue?style=for-the-badge)]()
[![REST API](https://img.shields.io/badge/REST-API-green?style=for-the-badge)]()


- **Java** con **Spring Boot**
- **MySQL** como base de datos relacional
- **Postman** para pruebas de API
- **JWT** para autenticación y autorización
- **Arquitectura MVC** y **API RESTful**

### Frontend


[![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
[![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)](https://reactjs.org/)
[![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite&logoColor=white)](https://vitejs.dev/)
[![TailwindCSS](https://img.shields.io/badge/TailwindCSS-06B6D4?style=for-the-badge&logo=tailwind-css&logoColor=white)](https://tailwindcss.com/)
[![Figma](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white)](https://figma.com/)

- **JavaScript** con **React**
- **TailwindCSS** para estilos rápidos y responsivos
- **Figma** para diseño UI/UX

---

## 🧑‍💻 Equipo de Desarrollo

**Comisión**: C16-48-N-JAVA

- **Team Leader**: Alejandro Domínguez
- **Backend Developers**:
  - Juan Daniel Pacheco Pérez
  - José Miguel Ramírez González
- **Frontend Developers**:
  - Facundo Rubén Medina
  - Pablo Ramiro Velasco (FRONTEND DEV / UI/UX / PM)

---

## ⚙️ Instalación y Uso

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/Pablo-r-stack/Your-Online-Wallet.git

2. **Backend**:

   - Navega al directorio del backend:

     ```bash
     cd Your-Online-Wallet/backend
     ```

   - Configura la base de datos MySQL y ajusta las credenciales en el archivo `application.properties`.

   - Ejecuta la aplicación con Maven:

     ```bash
     mvn spring-boot:run
     ```

3. **Frontend**:

   - Navega al directorio del frontend:

     ```bash
     cd Your-Online-Wallet/frontend
     ```

   - Instala las dependencias:

     ```bash
     npm install
     ```

   - Configurar API URL (src/auth/constans) -> puedes reemplazar esto por un .env:

     ```
     export const API_URL= 'http://localhost:8080'
     ```

   - Inicia la aplicación:

     ```bash
     npm run dev
     ```

4. **Accede a la aplicación**:

   - Abre tu navegador y visita `http://localhost:3000` para interactuar con la interfaz de usuario.