package pe.softmaps.petstore.domain.vendedor

data class VendedorUIState (
    val correo:String = "",
    val contrasena: String = "",
    val mostrarContrasena: Boolean = false
)