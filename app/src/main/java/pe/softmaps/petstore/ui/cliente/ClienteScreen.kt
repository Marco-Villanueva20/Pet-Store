package pe.softmaps.petstore.ui.cliente

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.softmaps.petstore.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ClienteScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FormularioLogin()
    }
}

@Composable
fun FormularioLogin() {
    var correo by remember { mutableStateOf("") }
    var contrasena = remember { TextFieldState() }

    Text(text = "Iniciar Sesión como Cliente")
    Spacer(
        Modifier.height(dimensionResource(R.dimen.medium_padding))
    )
    Image(painter = painterResource(R.drawable.ic_cliente), contentDescription = null)
    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))
    CampoTexto(
        value = correo,
        label = "Correo Electrónico",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        leadingIcon = {
            Icon(Icons.Filled.Email, contentDescription = null)
        }, onValueChange = { textoEscrito ->
            correo = textoEscrito
        }
    )
    Spacer(Modifier.height(dimensionResource(R.dimen.small_padding)))

    CampoTextoContrasena(
        state = contrasena,
        modifier = Modifier.padding(dimensionResource(R.dimen.small_padding)),
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
    label: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        label = { Text(text = label) },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = true,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(R.dimen.medium_padding)
            )
    )
}

@Composable
fun CampoTextoContrasena(
    state: TextFieldState,
    modifier: Modifier = Modifier,
) {
    var showPassword by remember { mutableStateOf(false) }
    BasicSecureTextField(
        state = state,
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.small_padding))
            .border(
                1.dp, Color.LightGray, RoundedCornerShape(dimensionResource(R.dimen.small_padding))
            )
            .padding(6.dp),
        textObfuscationMode = if (showPassword) TextObfuscationMode.Visible
        else TextObfuscationMode.RevealLastTyped,
        decorator = { innerTextField ->
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ){
                    // Icono izquierdo (candado)
                    Icon( Icons.Filled.Lock,
                        contentDescription = "Ícono de contraseña",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 8.dp)
                    )
                    Box(modifier = Modifier.weight(1f)) {
                        // Placeholder
                        if (state.text.isEmpty()) {
                            Text(
                                text = "Ingrese Contraseña",
                                color = Color.Gray
                            )
                        }
                        innerTextField()
                    }


                }
                // Icono derecho (ojo)
                Icon(if (showPassword) {
                    Icons.Filled.Visibility
                } else {
                    Icons.Filled.Lock
                }, contentDescription = "Toggle password visibility",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .requiredSize(48.dp)
                        .padding(16.dp)
                        .clickable { showPassword = !showPassword }
                )
            }
        }
    )
}

