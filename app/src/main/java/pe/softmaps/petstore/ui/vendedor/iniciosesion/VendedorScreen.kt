package pe.softmaps.petstore.ui.vendedor

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import pe.softmaps.petstore.R
import pe.softmaps.petstore.ui.common.CampoTexto

@Composable
fun VendedorScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormularioLoginVendedor()
    }

}

@Composable
fun FormularioLoginVendedor(viewModel: VendedorViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Text("Iniciar Sesión como Vendedor",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold)
    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))
    Image(
        painter = painterResource(R.drawable.login_vendedor),
        contentDescription = null,
        modifier = Modifier.size(dimensionResource(R.dimen.image_size))
    )
    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))
    CampoTexto(
        value = uiState.correo,
        onValueChange = { viewModel.onValuechangeCorreo(it) },
        label = "Correo Electrónico",
        placeholder = "usuario@ejemplo.com",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = null) },
        isError = viewModel.isErrorCorreo(),
        errorMessage = "El correo no es válido",
    )
    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))
    CampoTexto(
        value = uiState.contrasena,
        onValueChange = { viewModel.onValuechangeContrasena(it) },
        label = "Contraseña",
        placeholder = "Ingresa tu contraseña",
        isPassword = true,
        passwordVisible = uiState.mostrarContrasena,
        onPasswordToggle = { viewModel.toggleMostrarPass() },
        leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
        isError = viewModel.isErrorContrasena(),
        errorMessage = "La contraseña debe tener al menos 6 caracteres",
    )
    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))

    Button(onClick = {}) {
        Text(text = "Iniciar Sesión")
    }
    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = dimensionResource(R.dimen.large_padding)),
        horizontalAlignment = Alignment.End
    ) {
        Text("¿No tienes una cuenta?")
        Spacer(Modifier.height(dimensionResource(R.dimen.small_padding)))
        Text(text = "Regístrate", color = Color.Cyan)
    }
}
