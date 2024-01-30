package com.example.llnlphysicsengine_android_jetcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


/**
 * Handles the navigation between different screens in the application.
 *
 * @param navController The navigation controller responsible for managing the navigation flow.
 */
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.Accelerometer.route) {
            val accelerometerSensorState = rememberAccelerometerSensorState()
            AccelerometerSensorUI(accelerometerSensorState)
        }
        composable(route = Screen.Gyroscope.route) {
            // TODO: Add the content for the Gyroscope screen
        }
        composable(route = Screen.Magnetometer.route) {
            // TODO: Add the content for the Magnetometer screen
        }
        composable(route = Screen.Barometer.route) {
            // TODO: Add the content for the Barometer screen
        }
        composable(route = Screen.GPS.route) {
            // TODO: Add the content for the GPS screen
        }
        composable(route = Screen.DecibelMeter.route) {
            // TODO: Add the content for the DecibelMeter screen
        }
        composable(route = Screen.AudioOscilloscope.route) {
            // TODO: Add the content for the AudioOscilloscope screen
        }
        composable(route = Screen.AudioSpectrogram.route) {
            AudioSpectrogram()
        }
    }
}
