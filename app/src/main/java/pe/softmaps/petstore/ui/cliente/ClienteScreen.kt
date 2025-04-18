package pe.softmaps.petstore.ui.cliente

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pe.softmaps.petstore.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ClienteScreen(

) {
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FormularioLogin()
    }
}

@Composable
fun FormularioLogin(viewModel: ClienteViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Text(text = "Iniciar Sesión como Cliente")
    Spacer(
        Modifier.height(dimensionResource(R.dimen.medium_padding))
    )
    Image(painter = painterResource(R.drawable.ic_cliente), contentDescription = null)
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
    Row {
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
        Text(text = "Regístrate", color = Color.Cyan)
    }
}

@Composable
fun CampoTexto(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    placeholder: String? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    onPasswordToggle: (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,// Texto que muestra el campo
        onValueChange = onValueChange,// Actualiza el texto
        modifier = modifier
            .fillMaxWidth()// Ocupa el ancho maximo
            .padding(horizontal = dimensionResource(R.dimen.medium_padding)), // Margen horizontal
        label = { if (label.isNotEmpty()) Text(label) }, // Texto flotante (label)
        placeholder = { // Texto gris dentro si está vacío
            if (placeholder != null && value.isEmpty()) {
                Text(placeholder, color = Color.Gray)
            }
        },
        isError = isError,// Activa estado de error (rojo)
        supportingText = {// Mensaje de ayuda o error abajo
            if (isError && !errorMessage.isNullOrEmpty()) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        },
        singleLine = true,// Solo una línea de texto
        // Si es password, aplicamos la transformación adecuada
        visualTransformation = when {
            isPassword && !passwordVisible ->
                PasswordVisualTransformation() // Oculta el texto
            else ->
                visualTransformation // Otro tipo de transformación
        },
        // Teclado especial para password si aplica
        keyboardOptions = if (isPassword) {
            keyboardOptions.copy(keyboardType = KeyboardType.Password)
        } else keyboardOptions,

        leadingIcon = leadingIcon,// Ícono al inicio si se pasa

        trailingIcon = {
            when {
                // Ojo para toggle de contraseña
                isPassword && onPasswordToggle != null -> {
                    IconButton(onClick = onPasswordToggle) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff,
                            contentDescription = "Mostrar u ocultar contraseña"
                        )
                    }
                }
                // Ícono genérico al final si no es password
                trailingIcon != null -> {
                    trailingIcon()
                }
            }
        }
    )
}