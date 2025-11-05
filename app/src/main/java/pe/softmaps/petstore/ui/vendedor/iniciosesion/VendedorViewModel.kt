package pe.softmaps.petstore.ui.vendedor

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import pe.softmaps.petstore.domain.vendedor.VendedorUIState

class VendedorViewModel:ViewModel() {
    private val _uiState = MutableStateFlow(VendedorUIState())
    var uiState = _uiState.asStateFlow()
        private set

    fun onValuechangeCorreo(correo: String){
        _uiState.value = _uiState.value.copy(correo = correo)
    }
    fun isErrorCorreo(): Boolean{
        return _uiState.value.correo.isNotEmpty() && !_uiState.value.correo.contains("@")
    }
    fun onValuechangeContrasena(contrasena: String){
        _uiState.value = _uiState.value.copy(contrasena = contrasena)
    }
    fun isErrorContrasena(): Boolean{
        return _uiState.value.contrasena.length in 1 until 6
    }
    fun toggleMostrarPass(){
        _uiState.value = _uiState.value.copy(mostrarContrasena = !_uiState.value.mostrarContrasena)
    }
}