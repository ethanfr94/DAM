package com.example.reto2025_mobile.Views

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reto2025_mobile.Componentes.ActividadesTopAppBar
import com.example.reto2025_mobile.Componentes.BottomAppBar
import com.example.reto2025_mobile.Componentes.Fotos
import com.example.reto2025_mobile.Componentes.Mapa
import com.example.reto2025_mobile.Componentes.PerfilTopAppBar
import com.example.reto2025_mobile.Componentes.Pic
import com.example.reto2025_mobile.Componentes.Usuario
import com.example.reto2025_mobile.R
import com.example.reto2025_mobile.data.Actividad
import com.example.reto2025_mobile.data.Profesor
import com.example.reto2025_mobile.ui.theme.Purple40

@Composable
fun PerfilView(
    navController: NavController
) {
    Scaffold(
        topBar = { PerfilTopAppBar(navController) },
        bottomBar = { BottomAppBar(navController = navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn {
                    item {
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .height(200.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFD0E8F2))
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Perfil",
                                    modifier = Modifier.size(100.dp),
                                    tint = Color.Gray
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFD0E8F2))
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${Usuario.nombre} ${Usuario.apellidos}",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFD0E8F2))

                        ) {
                            Text(
                                text = "Id: ${Usuario.uuid}",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(8.dp)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "DNI: ${Usuario.dni}",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(8.dp)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "EMAIL: ${Usuario.correo}",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFD0E8F2))
                        ) {
                            if (Usuario.rol == "ADM") {
                                Text(
                                    text = "ADMINISTRADOR",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(8.dp)
                                )
                            } else if (Usuario.rol == "PROF") {
                                Text(
                                    text = "PROFESOR",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(8.dp)
                                )
                            } else if (Usuario.rol == "ED") {
                                Text(
                                    text = "EQUIPO DIRECTIVO",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                    }
                    item {
                        if (Usuario.esJefeDep == true) {
                            Card(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(0xFFD0E8F2))
                            ) {
                                Text(
                                    text = "JEFE DE DEPARTAMENTO",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                    }
                    item {
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFD0E8F2))
                        ) {
                            Text(
                                text = "DEPARTAMENTO: ${Usuario.depart?.nombre}",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
    BackHandler {
        navController.navigate("home")
    }
}
