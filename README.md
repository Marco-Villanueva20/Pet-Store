# Pet Store App

Aplicación Android para una tienda de mascotas, desarrollada con Kotlin y Jetpack Compose. Permite a los usuarios interactuar como clientes o vendedores.

## Tabla de Contenidos

- [Características Principales](#características-principales)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Instalación y Configuración](#instalación-y-configuración)
- [Uso de la Aplicación](#uso-de-la-aplicación)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Características Principales

*   **Selección de Tipo de Usuario:**
    *   Al iniciar, la aplicación permite elegir entre un perfil de "Cliente" o "Vendedor".
*   **Funcionalidades de Cliente:**
    *   **Inicio de Sesión:**
        *   Formulario para ingresar con correo electrónico y contraseña.
        *   Validación de formato de correo electrónico.
        *   Validación de longitud mínima de contraseña (6 caracteres).
        *   Opción para mostrar/ocultar la contraseña.
    *   **(Potencial) Inicio de Sesión con Google:**
        *   Interfaz preparada para la integración con Google Sign-In (icono presente).
    *   **(Potencial) Registro de Nuevos Clientes:**
        *   Interfaz con enlace para registrarse (texto "Regístrate" presente).
*   **Funcionalidades de Vendedor:**
    *   Pantalla designada para vendedores (`VendedorScreen`).
    *   *Nota: Actualmente, la pantalla de vendedor está vacía y las funcionalidades específicas no están implementadas en el código visible.*

## Tecnologías Utilizadas

*   **Lenguaje de Programación:** Kotlin (v2.0.0)
*   **Plataforma:** Android
*   **UI Toolkit:** Jetpack Compose (BOM v2025.04.00)
    *   Compose UI, Material 3, Material Icons Extended, Compose Tooling.
*   **Gestión de Dependencias y Build:**
    *   Gradle (Android Gradle Plugin v8.8.0)
    *   Gradle Kotlin DSL
    *   Gradle Version Catalog
*   **Componentes de Arquitectura de Android Jetpack:**
    *   Lifecycle (ViewModel, Lifecycle Runtime KTX)
    *   Navigation (Navigation Compose)
    *   Activity (Activity Compose)
    *   Core KTX
*   **Pruebas:**
    *   JUnit
    *   AndroidX Test (JUnit, Espresso)
*   **SDK de Android:**
    *   `compileSdk`: 35
    *   `minSdk`: 24
    *   `targetSdk`: 35

## Instalación y Configuración

1.  **Clonar el repositorio:**
    ```bash
    git clone <URL-del-repositorio-del-proyecto>
    ```
    (Reemplaza `<URL-del-repositorio-del-proyecto>` con la URL real del repositorio)

2.  **Abrir en Android Studio:**
    *   Inicia Android Studio.
    *   Selecciona "Open an Existing Project" (Abrir un proyecto existente).
    *   Navega hasta el directorio donde clonaste el repositorio y selecciónalo.

3.  **Sincronización con Gradle:**
    *   Android Studio sincronizará automáticamente el proyecto y descargará las dependencias necesarias definidas en los archivos `build.gradle.kts` y `gradle/libs.versions.toml`.
    *   Asegúrate de tener una conexión a internet activa.

4.  **Configurar un Emulador o Dispositivo Android:**
    *   **Emulador:**
        *   En Android Studio, ve a `Tools > AVD Manager`.
        *   Crea un nuevo Dispositivo Virtual Android (AVD) compatible (API nivel 24 o superior).
    *   **Dispositivo Físico:**
        *   Habilita las "Opciones de desarrollador" y la "Depuración por USB" en tu dispositivo.
        *   Conecta el dispositivo a tu computadora.

5.  **Ejecutar la aplicación:**
    *   Selecciona el emulador o dispositivo como destino en Android Studio.
    *   Haz clic en el botón "Run 'app'" (icono de triángulo verde).

## Uso de la Aplicación

1.  **Selección de Tipo de Usuario:**
    *   Al abrir la app, se te pedirá que elijas si eres "Vendedor" o "Cliente".
    *   **Vendedor:** Te llevará a `VendedorScreen` (actualmente sin contenido funcional visible).
    *   **Cliente:** Te llevará a `ClienteScreen` para iniciar sesión.

2.  **Inicio de Sesión como Cliente (`ClienteScreen`):**
    *   Ingresa tu correo electrónico y contraseña.
    *   Utiliza el icono del ojo para mostrar/ocultar la contraseña.
    *   Presiona "Iniciar Sesión".
    *   Opcionalmente, puedes intentar usar el inicio de sesión con Google (si está implementado).
    *   Si no tienes cuenta, busca la opción "Regístrate" para crear una (si la pantalla de registro está implementada).

3.  **Pantalla de Vendedor (`VendedorScreen`):**
    *   Actualmente, esta pantalla no presenta funcionalidades implementadas.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar esta aplicación, por favor considera lo siguiente:

*   Reportar bugs y sugerir nuevas características a través de los Issues del repositorio.
*   Si deseas contribuir con código, por favor abre un Pull Request detallando los cambios realizados.
*   Asegúrate de seguir las convenciones de código y estilo del proyecto si existen.

(Si este proyecto tiene un archivo `CONTRIBUTING.md` o directrices específicas, por favor refiérete a ellas).

## Licencia

La licencia para este proyecto no ha sido especificada en el repositorio. Por favor, contacta a los mantenedores del proyecto para obtener más información sobre los términos de uso y distribución.

---

*Este README fue generado automáticamente y puede requerir ajustes o información adicional.*
