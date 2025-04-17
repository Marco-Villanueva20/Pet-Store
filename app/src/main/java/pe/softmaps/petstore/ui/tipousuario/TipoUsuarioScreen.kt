package pe.softmaps.petstore.ui.tipousuario

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import pe.softmaps.petstore.R


@Composable
fun TipoUsuarioScreen(
    onClickVendedor: () -> Unit,
    onClickCliente: () -> Unit
) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TipoUsuarioItem(
            imageId = R.drawable.tipo_vendedor,
            nombreId = R.string.vendedor,
            onClickTipoUsuario = onClickVendedor
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.medium_padding)))
        TipoUsuarioItem(
            imageId = R.drawable.tipo_cliente,
            nombreId = R.string.cliente,
            onClickTipoUsuario = onClickCliente
        )
    }
}

@Composable
fun TipoUsuarioItem(
    @DrawableRes imageId: Int,
    @StringRes nombreId: Int,
    onClickTipoUsuario: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(dimensionResource(R.dimen.tipo_usuario_size)),
    ) {
        Image(
            painter = painterResource(imageId),
            modifier = Modifier.size(dimensionResource(R.dimen.tipo_usuario_size)),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Spacer(Modifier.height(dimensionResource(R.dimen.small_padding)))
        Button(
            onClick = { onClickTipoUsuario() },
            modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = stringResource(nombreId))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TipoUsuarioScreenPreview() {
    TipoUsuarioScreen(
        onClickVendedor = {},
        onClickCliente = {}
    )
}