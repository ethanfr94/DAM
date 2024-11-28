package com.example.sesion2_05.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TitleBar(texto:String){
    Text(text=texto,
        fontSize = 25.sp,
        color = MaterialTheme.colorScheme.onPrimary,
        fontWeight = FontWeight.Bold)
}

@Composable
fun ActionButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Agregar"
        )
    }
}

@Composable
fun MainIconButton(icon: ImageVector, onClick:()->Unit){
    IconButton(onClick = onClick) {
        Icon(imageVector = icon, contentDescription =null
            ,tint=MaterialTheme.colorScheme.onPrimary )
    }
}