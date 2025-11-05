package pe.softmaps.petstore.ui.cliente

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pe.softmaps.petstore.R
import pe.softmaps.petstore.ui.common.CampoTexto

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ClienteScreen(
    onNavigateRegistro: ()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FormularioLoginCliente(onNavigateRegistro)
    }
}

@Composable
fun FormularioLoginCliente(onNavigateRegistro: ()->Unit ,viewModel: ClienteViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Text(text = "Iniciar Sesión como Cliente",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold)
    Spacer(
        Modifier.height(dimensionResource(R.dimen.medium_padding))
    )
    Image(
        painter = painterResource(R.drawable.ic_cliente),
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
        leadingIcon = { Icon(Icons.Filled.Email, contentDescription = null) },
        isError = viewModel.isErrorCorreo(),
        errorMessage = "Correo inválido"
    )
    Spacer(Modifier.height(dimensionResource(R.dimen.small_padding)))

    CampoTexto(
        value = uiState.contrasena,
        onValueChange = { viewModel.onValuechangeContrasena(it) },
        label = "Contraseña",
        placeholder = "Ingresa tu contraseña",
        isPassword = true,
        passwordVisible = uiState.mostrarPass,
        onPasswordToggle = { viewModel.toggleMostrarPass() },
        leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
        isError = viewModel.isErrorContrasena(),
        errorMessage = "Mínimo 6 caracteres"
    )

    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))

    Button(onClick = {}) {
        Text(text = "Iniciar Sesión")
    }
    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))
    Row(
        modifier = Modifier
            .height(60.dp)
            .width(100.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {}) {
            Image(
                painter = painterResource(R.drawable.ic_google_login),
                contentDescription = null, modifier = Modifier.size(32.dp)
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                end = dimensionResource(
                    R.dimen.large_padding
                )
            ), horizontalAlignment = Alignment.End
    ) {
        Text(text = "¿No tienes una cuenta?")
        Spacer(Modifier.height(dimensionResource(R.dimen.small_padding)))
        Text(text = "Regístrate", color = Color.Cyan, modifier = Modifier.clickable { onNavigateRegistro() })
    }
}

