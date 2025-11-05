package pe.softmaps.petstore.domain.cliente

data class ClienteUIState(
    val correo: String = "",
    val contrasena: String = "",
    val mostrarPass: Boolean = false
)
