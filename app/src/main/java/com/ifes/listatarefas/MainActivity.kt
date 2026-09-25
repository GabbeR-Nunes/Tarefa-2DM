package com.ifes.listatarefas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifes.listatarefas.ui.theme.ListaTarefasTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle

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
    var tarefa by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var tarefaConcluida by remember { mutableStateOf(false) }
    var mensagem by remember { mutableStateOf("Nenhuma tarefa salva") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberVectorPainter(Icons.Filled.CheckCircle),
                contentDescription = "Logo do aplicativo",
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Lista de Tarefas",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Cadastre uma tarefa e acompanhe seu status.",
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = tarefa,
                onValueChange = { tarefa = it },
                label = { Text("Nome da tarefa") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = descricao,
                onValueChange = { descricao = it },
                label = { Text("Descrição") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = tarefaConcluida,
                    onCheckedChange = { tarefaConcluida = it }
                )

                Text(text = "Tarefa concluída")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    mensagem = if (tarefa.isNotBlank() && descricao.isNotBlank()) {
                        if (tarefaConcluida) {
                            "Tarefa salva como concluída"
                        } else {
                            "Tarefa salva como pendente"
                        }
                    } else {
                        "Preencha todos os campos"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Salvar tarefa")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Informações da tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = if (tarefa.isBlank()) {
                            "Tarefa: não informada"
                        } else {
                            "Tarefa: $tarefa"
                        }
                    )

                    Text(
                        text = if (descricao.isBlank()) {
                            "Descrição: não informada"
                        } else {
                            "Descrição: $descricao"
                        }
                    )

                    Text(
                        text = if (tarefaConcluida) {
                            "Status: concluída"
                        } else {
                            "Status: pendente"
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = mensagem,
                        color = Color(0xFF1B5E20),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}