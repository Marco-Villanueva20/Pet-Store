package pe.softmaps.petstore.ui.navegacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.softmaps.petstore.ui.cliente.ClienteScreen
import pe.softmaps.petstore.ui.tipousuario.TipoUsuarioScreen
import pe.softmaps.petstore.ui.vendedor.VendedorScreen

enum class PetStoreScreen {
    TIPO_USUARIO,
    VENDEDOR_MAIN,
    CLIENTE_MAIN
}


@Composable
fun PetStoreApp() {
    val navController: NavHostController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            PetStoreTopAppBar()
        },
        bottomBar = {
            PetStoreBottomAppBar()
        }) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = PetStoreScreen.TIPO_USUARIO.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PetStoreScreen.TIPO_USUARIO.name) {
                TipoUsuarioScreen(onClickVendedor = { navController.navigate(PetStoreScreen.VENDEDOR_MAIN.name) },
                    onClickCliente = { navController.navigate(PetStoreScreen.CLIENTE_MAIN.name) })
            }
            composable(route = PetStoreScreen.VENDEDOR_MAIN.name) {
                VendedorScreen()
            }
            composable(route = PetStoreScreen.CLIENTE_MAIN.name) {
                ClienteScreen()
            }
        }
    }

}

@Composable
fun PetStoreTopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Pet Store")
    }
}

@Composable
fun PetStoreBottomAppBar(){
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Pet Store")
    }
}