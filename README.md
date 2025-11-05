# Pet Store App

Aplicación Android para una tienda de mascotas, desarrollada con Kotlin y Jetpack Compose. Permite a los usuarios interactuar como clientes o vendedores, facilitando la gestión de productos, compras y ventas en un entorno de e-commerce para mascotas.

Repositorio: [https://github.com/Marco-Villanueva20/Pet-Store](https://github.com/Marco-Villanueva20/Pet-Store)

## Tabla de Contenidos

- [Pet Store App](#pet-store-app)
  - [Tabla de Contenidos](#tabla-de-contenidos)
  - [Descripción](#descripción)
  - [Características Principales](#características-principales)
  - [Arquitectura](#arquitectura)
  - [Tecnologías Utilizadas](#tecnologías-utilizadas)
  - [Instalación y Configuración](#instalación-y-configuración)
  - [Uso de la Aplicación](#uso-de-la-aplicación)
  - [Estado del Proyecto](#estado-del-proyecto)
  - [Contribuciones](#contribuciones)
  - [Licencia](#licencia)

## Descripción

Pet Store es una aplicación móvil Android diseñada para conectar a clientes y vendedores en el mercado de productos para mascotas. Los usuarios pueden seleccionar su rol al iniciar la app, accediendo a funcionalidades específicas como inicio de sesión, registro y futuras operaciones de compra/venta. La app está construida siguiendo las mejores prácticas de desarrollo Android, utilizando Jetpack Compose para una interfaz moderna y responsiva.

## Características Principales

*   **Selección de Tipo de Usuario:**
    *   Pantalla inicial que permite elegir entre "Cliente" o "Vendedor" con imágenes representativas.

*   **Funcionalidades de Cliente:**
    *   **Inicio de Sesión:**
        *   Formulario con campos para correo electrónico y contraseña.
        *   Validación en tiempo real: formato de email (debe contener '@') y longitud mínima de contraseña (6 caracteres).
        *   Opción para mostrar/ocultar la contraseña con icono de ojo.
        *   Botón de "Iniciar Sesión" (lógica de autenticación no implementada aún).
        *   Opción de inicio de sesión con Google (interfaz preparada, pero no funcional).
    *   **Registro de Nuevos Clientes:**
        *   Pantalla con campos para nombres completos, correo, contraseña y confirmar contraseña.
        *   Enlace desde la pantalla de login para navegar al registro.
        *   Campos de contraseña con toggle para visibilidad (parcialmente implementado en UI, sin lógica completa).

*   **Funcionalidades de Vendedor:**
    *   **Inicio de Sesión:**
        *   Similar al de cliente: validaciones de email y contraseña, toggle de visibilidad.
        *   Botón de "Iniciar Sesión" (sin lógica implementada).
        *   Enlace para "Regístrate" (pantalla de registro vacía).
    *   **Registro de Nuevos Vendedores:**
        *   Pantalla preparada pero sin contenido implementado.

*   **Navegación:**
    *   Uso de Jetpack Navigation Compose para transiciones entre pantallas.
    *   Top y Bottom App Bars simples con título "Pet Store".

*   **Componentes Reutilizables:**
    *   Campo de texto personalizado (`CampoTexto`) con soporte para passwords, errores y iconos.

## Arquitectura

La aplicación sigue el patrón de arquitectura **MVVM (Model-View-ViewModel)**, dividido en capas claras:

- **UI Layer:** Contiene las pantallas (Screens) y ViewModels. Las pantallas están en `ui/`, y manejan la composición con Jetpack Compose. Los ViewModels gestionan el estado UI y lógica de negocio básica.
- **Domain Layer:** Define los estados UI (UIState) en `domain/`, como `ClienteUIState`, `VendedorUIState`, etc. Representan el estado de las pantallas.
- **Data Layer:** Actualmente vacía (`data/`), preparada para repositorios, APIs o bases de datos locales en futuras implementaciones.

Estructura de paquetes:
- `pe.softmaps.petstore/`
  - `data/` (cliente/, vendedor/) - Para datos y lógica de acceso.
  - `domain/` (cliente/, vendedor/) - Estados y lógica de dominio.
  - `ui/` (cliente/, vendedor/, common/, navegacion/, theme/, tipousuario/) - Pantallas, ViewModels y componentes compartidos.

## Tecnologías Utilizadas

*   **Lenguaje de Programación:** Kotlin (v2.0.0)
*   **Plataforma:** Android
*   **UI Toolkit:** Jetpack Compose (BOM v2025.04.00)
    *   Compose UI, Material 3, Material Icons Extended, Compose Tooling.
*   **Gestión de Dependencias y Build:**
    *   Gradle (Android Gradle Plugin v8.8.0)
    *   Gradle Kotlin DSL
    *   Gradle Version Catalog (`gradle/libs.versions.toml`)
*   **Componentes de Arquitectura de Android Jetpack:**
    *   Lifecycle (ViewModel, Lifecycle Runtime KTX)
    *   Navigation (Navigation Compose v2.8.9)
    *   Activity (Activity Compose v1.10.1)
    *   Core KTX (v1.16.0)
*   **Pruebas:**
    *   JUnit (v4.13.2)
    *   AndroidX Test (JUnit v1.2.1, Espresso v3.6.1)
*   **SDK de Android:**
    *   `compileSdk`: 35
    *   `minSdk`: 24
    *   `targetSdk`: 35
*   **Recursos:**
    *   Imágenes en `res/drawable-nodpi/` para iconos de login, tipos de usuario, etc.
    *   Strings, colores, dimens y temas en `res/values/`.

## Instalación y Configuración

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/Marco-Villanueva20/Pet-Store.git
    ```

2.  **Abrir en Android Studio:**
    *   Inicia Android Studio (versión recomendada: Arctic Fox o superior).
    *   Selecciona "Open an Existing Project".
    *   Navega al directorio clonado y selecciónalo.

3.  **Sincronización con Gradle:**
    *   Android Studio sincronizará automáticamente las dependencias desde `build.gradle.kts` y `gradle/libs.versions.toml`.
    *   Requiere conexión a internet para descargar librerías.

4.  **Configurar Emulador o Dispositivo:**
    *   **Emulador:** Crea un AVD en `Tools > AVD Manager` con API 24+.
    *   **Dispositivo Físico:** Habilita "Opciones de desarrollador" y "Depuración por USB".

5.  **Ejecutar la aplicación:**
    *   Selecciona el emulador/dispositivo y presiona "Run 'app'".

## Uso de la Aplicación

1.  **Selección de Tipo de Usuario:**
    *   Al abrir la app, elige "Cliente" o "Vendedor" tocando la imagen correspondiente.

2.  **Inicio de Sesión como Cliente:**
    *   Ingresa email y contraseña.
    *   Usa el icono de ojo para ver/ocultar contraseña.
    *   Presiona "Iniciar Sesión" (sin autenticación real aún).
    *   Para registrarte, toca "Regístrate" y completa los campos.

3.  **Inicio de Sesión como Vendedor:**
    *   Similar al cliente, pero registro no implementado.

4.  **Navegación:**
    *   Usa los botones para moverte entre pantallas.

## Estado del Proyecto

- **Implementado:** Selección de usuario, pantallas de login y registro (UI completa, validaciones básicas, navegación).
- **Preparado pero no funcional:** Inicio de sesión con Google, lógica de autenticación, registro completo para vendedores.
- **Pendiente:** Integración con backend (API para login/registro), gestión de productos, carrito de compras, etc.
- **Pruebas:** Básicas con JUnit y Espresso, pero no exhaustivas.
- **Versión:** 1.0 (inicial, en desarrollo).

## Contribuciones

¡Las contribuciones son bienvenidas! Para contribuir:

*   Reporta issues o sugiere features en el [repositorio](https://github.com/Marco-Villanueva20/Pet-Store/issues).
*   Abre un Pull Request con cambios detallados.
*   Sigue convenciones de Kotlin y Compose (usa ViewModels para estado, separa capas).

Si hay guías específicas, revisa `CONTRIBUTING.md` (no presente aún).

## Licencia

Este proyecto no tiene licencia especificada. Contacta a los mantenedores para detalles sobre uso y distribución.

---

*README actualizado con contexto completo del proyecto.*
