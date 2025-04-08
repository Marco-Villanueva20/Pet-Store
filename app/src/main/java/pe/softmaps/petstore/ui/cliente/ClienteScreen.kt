package pe.softmaps.petstore.ui.cliente

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import pe.softmaps.petstore.R

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
    var contrasena by remember { mutableStateOf("") }

    Text(text = "Iniciar Sesión como Cliente")
    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))
    Image(painter = painterResource(R.drawable.ic_cliente), contentDescription = null)
    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))
    CampoTexto(value = correo,
        label = "Correo",
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        onValueChange = { textoEscrito ->
            correo = textoEscrito
        }
    )
    Spacer(Modifier.height(dimensionResource(R.dimen.small_padding)))
    CampoTexto(
        value = contrasena,
        label = "Contraseña",
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = { },
        onValueChange = {
            contrasena = it
        })
    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))
    Button(onClick = {}) {
        Text(text = "Iniciar Sesión")
    }
    Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))
    Row {
        IconButton(onClick = {}) {
            Image(painter = painterResource(R.drawable.ic_google_login),
                contentDescription = null, modifier = Modifier.size(32.dp))
        }
    }
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
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
    TextField(
        value = value,
        label = { Text(text = label) },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = true,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        onValueChange = onValueChange,
    )
}
