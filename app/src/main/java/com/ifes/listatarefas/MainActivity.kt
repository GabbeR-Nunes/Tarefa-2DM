package com.ifes.listatarefas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifes.listatarefas.ui.theme.ListaTarefasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaTarefasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListaTarefas()
                }
            }
        }
    }
}

@Composable
fun ListaTarefas() {
    var tarefa1 by remember { mutableStateOf("") }
    var mensagem by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Lista de Tarefas",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = tarefa1,
            onValueChange = { tarefa1 = it },
            label = { Text("Tarefa1") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                mensagem = if (tarefa1.isNotBlank()) {
                    "Tarefa salva: $tarefa1"
                } else {
                    "Nenhuma tarefa inserida"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar Tarefas")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = mensagem,
            fontSize = 20.sp
        )
    }
}