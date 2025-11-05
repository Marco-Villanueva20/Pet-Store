package pe.softmaps.petstore.ui.cliente

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pe.softmaps.petstore.domain.cliente.ClienteUIState

class ClienteViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(ClienteUIState())
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
        _uiState.update {current ->
            current.copy(mostrarPass = !current.mostrarPass)

        }
    }


}
