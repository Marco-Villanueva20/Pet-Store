package pe.softmaps.petstore.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import pe.softmaps.petstore.R

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