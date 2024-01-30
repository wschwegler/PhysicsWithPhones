package com.example.llnlphysicsengine_android_jetcompose

/**
 * Represents a screen in the application.
 *
 * @param route The route associated with the screen.
 */
sealed class Screen(val route: String) {
    object HomeScreen : Screen("HomeScreen")
    object Accelerometer : Screen("Accelerometer")
    object Gyroscope : Screen("Gyroscope")
    object Magnetometer : Screen("Magnetometer")
    object Barometer : Screen("Barometer")
    object GPS : Screen("GPS")
    object DecibelMeter : Screen("DecibelMeter")
    object AudioOscilloscope : Screen("AudioOscilloscope")
    object AudioSpectrogram : Screen("AudioSpectrogram")
}
