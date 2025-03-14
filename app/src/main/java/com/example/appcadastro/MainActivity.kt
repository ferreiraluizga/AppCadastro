package com.example.appcadastro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcadastro.ui.theme.AppCadastroTheme
import com.example.appcadastro.ui.theme.primaryBlue
import com.example.appcadastro.ui.theme.terciaryBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCadastroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    var name by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var curso by remember { mutableStateOf("") }
    var serie by remember { mutableStateOf("") }


    Column(
        Modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Avatar()
        Column(
            Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = { Text("Nome Completo") }
            )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = telefone,
                onValueChange = {telefone = it},
                label = { Text("Telefone") }
            )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = curso,
                onValueChange = {curso = it},
                label = { Text("Curso") }
            )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = serie,
                onValueChange = {serie = it},
                label = { Text("Série") }
            )
            Spacer(Modifier.height(24.dp))
            Button(
                onClick = { }
            ) {
                Text(text = "Enviar Dados")
            }
        }
    }
}

@Composable
fun Avatar() {
    Column(
        Modifier
            .height(320.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .height(200.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            terciaryBlue, primaryBlue
                        )
                    )
                )
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.avatar_image),
                contentDescription = "avatar image",
                Modifier
                    .offset(y = 50.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter)
                    .size(150.dp)
            )
        }
        Spacer(Modifier.height(65.dp))
        Text(
            text = "Cadastro de Alunos",
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}



// function for another view (pobably a view about user informations)
@Composable
fun AvatarImage() {
    Column(
        Modifier
            .height(250.dp)
            .width(200.dp)
    ) {
        Box(
            Modifier
                .height(100.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            terciaryBlue, primaryBlue
                        )
                    )
                )
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "avatar image",
                Modifier
                    .offset(y = 50.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter)
            )
        }
        Spacer(Modifier.height(50.dp))
        Column(
            Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Person Name",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Description of person",
                Modifier
                    .padding(top = 8.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}