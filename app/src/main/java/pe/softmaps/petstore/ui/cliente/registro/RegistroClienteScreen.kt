package pe.softmaps.petstore.ui.cliente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import pe.softmaps.petstore.R
import pe.softmaps.petstore.ui.common.FormularioRegistro

@Composable
fun RegistroClienteScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.small_padding)),
        modifier = Modifier.fillMaxSize()
    ) {
       FormularioRegistro("Cliente")
    }
}