package pe.softmaps.petstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pe.softmaps.petstore.ui.navegacion.PetStoreApp
import pe.softmaps.petstore.ui.theme.PetStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetStoreTheme {
                PetStoreApp()
            }
        }
    }
}
