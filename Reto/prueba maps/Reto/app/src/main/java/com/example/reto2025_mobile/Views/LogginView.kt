package com.example.reto2025_mobile.Views

import android.content.Context
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.reto2025_mobile.API.RetrofitServiceFactory
import com.example.reto2025_mobile.R
import com.example.reto2025_mobile.ViewModel.ProfesorLoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.format.TextStyle

@Composable
fun LogginView(
    navController: NavHostController,
    profesorLoginViewModel: ProfesorLoginViewModel = viewModel()
) {
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var login by remember { mutableStateOf(true) }
    val context = LocalContext.current
    val loginResult by profesorLoginViewModel.loginResult.observeAsState()
    val errorMessage by profesorLoginViewModel.errorMessage.observeAsState()
    val isLoading by profesorLoginViewModel.isLoading.observeAsState(false)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp)
                .padding(top = 50.dp),  // Mantén un padding horizontal fijo
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top  // Mantén los elementos alineados en la parte superior
        ) {
            // Imagen
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de la App",
                modifier = Modifier
                    .size(300.dp)
                    .padding(top = 220.dp)// Aumenta el tamaño de la imagen sin afectar el layout
            )



            // Campo de Usuario
            OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                label = { Text("Correo electrónico") },
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Icono de usuario") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp), // Margen uniforme vertical
                shape = RoundedCornerShape(12.dp), // Bordes más suaves

            )

// Campo de Contraseña
            OutlinedTextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text("Contraseña") },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Icono de contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp), // Margen uniforme vertical
                shape = RoundedCornerShape(12.dp), // Bordes más suaves
                //colors = TextFieldDefaults.outlinedTextFieldColors(

            )

            // Botón de acceso
            Button(
                onClick = { profesorLoginViewModel.login(user, pass) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),  // Padding superior para el botón
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5D8B11),  // Verde moderno
                    contentColor = Color.White  // Texto blanco
                )
            ) {
                Text(
                    text = "Acceder",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Indicador de carga
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
            } else if (login) {
                errorMessage?.let {
                    Text(
                        text = it,
                        color = Color.Red,
                        textAlign = TextAlign.Justify,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }

                loginResult?.let {
                    login = false
                    navController.navigate("home")
                }
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))
            Text(
                text = "¿Olvidaste tu contraseña?",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF8BC34A),
                modifier = Modifier.clickable {
                    // Acción de redirección aquí
                }
            )
        }
    }
    BackHandler {
        // Manejo del botón de retroceso
    }
}