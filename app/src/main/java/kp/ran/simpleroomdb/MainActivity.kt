package kp.ran.simpleroomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kp.ran.simpleroomdb.ui.theme.SimpleRoomDBTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = TempleDatabase.getInstance(applicationContext)
        val templedao = db.templedao()
        val repository = Repository(templedao)

        val viewModel = TempleViewModel(repository)



        setContent {
            SimpleRoomDBTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val scope = rememberCoroutineScope()
                   Column {

                       var templeName by remember{ mutableStateOf("") }
                       var templeLocation by remember{ mutableStateOf("") }
                       var MainGod by remember{ mutableStateOf("") }

                       OutlinedTextField(value =templeName , onValueChange ={templeName=it}
                       , placeholder = { Text(text = "temple name")})
                       OutlinedTextField(value =templeLocation , onValueChange ={templeLocation=it}
                           , placeholder = { Text(text = "temple Location ")})
                       OutlinedTextField(value = MainGod , onValueChange ={MainGod=it}, placeholder = { Text(text = "MainGod name")})


                       Button(onClick = {
                           scope.launch {
                               viewModel.insert(Temple(0,templeName,templeLocation,MainGod))
                               templeName=""
                               templeLocation=""
                               MainGod=""
                           }
                       }) {
                           Text(text = "add Temple")
                       }
                   }
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleRoomDBTheme {
        Greeting("Android")
    }
}