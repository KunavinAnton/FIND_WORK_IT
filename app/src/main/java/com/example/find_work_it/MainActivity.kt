package com.example.find_work_it

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.find_work_it.ui.theme.FIND_WORK_ITTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FIND_WORK_ITTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun StartScreen(){
    val constraints = ConstraintSet{
        val logo = createRefFor("logo")
        val text = createRefFor("text")
        val blockHH = createRefFor("blockHH")

        val guideLineTop = createGuidelineFromTop(0.3f)

        constrain(logo){
            top.linkTo(guideLineTop)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }
        constrain(text){
            top.linkTo(logo.bottom, margin = 8.dp)
            start.linkTo(logo.start)
            end.linkTo(logo.end)
        }
        constrain(blockHH){
            bottom.linkTo(parent.bottom, margin = 108.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()){
        val logo = painterResource(id = R.drawable.logo2)
        val logoHH = painterResource(id = R.drawable.logo2)
        Image(painter = logo,
            contentDescription = "AppLogo",
            Modifier.size(128.dp, 128.dp).layoutId("logo"))
        Text(text = "Поиск работы в IT",
            fontSize = 20.sp, fontFamily = FontFamily.Default,
            fontWeight = FontWeight.SemiBold, modifier = Modifier.layoutId("text"))
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(268.dp).layoutId("blockHH")){
            Image(painter = logoHH, contentDescription = "LogoHH",
                modifier = Modifier.size(28.dp, 28.dp))
            Text(text = "Подборка вакансий осуществляется на основе сайта hh.ru",
                fontSize = 12.sp, fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FIND_WORK_ITTheme {
        StartScreen()
    }
}