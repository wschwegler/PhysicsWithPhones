package com.example.llnlphysicsengine_android_jetcompose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.llnlphysicsengine_android_jetcompose.data.Sensor
import com.example.llnlphysicsengine_android_jetcompose.data.SensorsRepo
import com.example.llnlphysicsengine_android_jetcompose.ui.theme.Blue
import com.example.llnlphysicsengine_android_jetcompose.ui.theme.LLNLPhysicsEngineAndroidJetComposeTheme

/**
 * Displays the home screen of the application.
 *
 * @param navController the navigation controller used for navigating to different screens.
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    val generalSensors = remember { SensorsRepo.getGeneralSensors() }
    val acousticSensors = remember { SensorsRepo.getAcousticSensors() }
    LLNLPhysicsEngineAndroidJetComposeTheme(darkTheme = false) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Physics Engine",
                            style = MaterialTheme.typography.titleLarge
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(route = "AudioSpectrogram") }) {
                            Icon(
                                Icons.Filled.Info,
                                "Info",
                                modifier = Modifier.background(Blue),
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color(0xFF275BA7),
                        titleContentColor = Color.White,
                    ),
                    actions = {
                        IconButton(onClick = { navController.navigate(route = "AudioSpectrogram")}) {
                            Icon(
                                Icons.Filled.Settings,
                                contentDescription = "Settings",
                                tint = Color.White
                            )
                        }
                    }
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LazyColumn(contentPadding = PaddingValues(all = 15.dp)) {
                        stickyHeader {
                            Text(
                                text = "General",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colorScheme.background),
                                style = MaterialTheme.typography.headlineMedium,
                                color = MaterialTheme.colorScheme.onBackground

                            )
                        }
                        items(generalSensors) { sensor ->
                            SensorItem(sensor = sensor, navController = navController)
                        }
                        stickyHeader {
                            Text(
                                text = "Acoustic",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colorScheme.background),
                                style = MaterialTheme.typography.headlineMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        items(acousticSensors) { sensor ->
                            SensorItem(sensor = sensor, navController = navController)
                        }
                    }
                }
            }
        )
    }
}

/**
 * Displays an item representing a sensor.
 *
 * @param sensor the sensor to display.
 * @param navController the navigation controller used for navigating to different screens.
 */
@Composable
fun SensorItem(sensor: Sensor, navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { navController.navigate(route = sensor.screen) }
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = sensor.image),
            contentDescription = null,
            modifier = Modifier.size(50.dp),

        )
        Column {
            Box{
                Text(text = sensor.title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary
            )
                Spacer(modifier = Modifier.padding(30.dp))
                Text(text = sensor.subTitle,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.BottomStart),
                    color = MaterialTheme.colorScheme.secondary
                )}
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Arrow",
            tint = Color.LightGray,
            modifier = Modifier.size(25.dp)
        )
    }
}

/**
 * Preview function for the HomeScreen composable.
 */
@Preview
@Composable
fun PrevHome() {
    val navController = rememberNavController()
    HomeScreen(navController)
}
