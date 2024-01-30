package com.example.llnlphysicsengine_android_jetcompose.data

import androidx.annotation.DrawableRes
import com.example.llnlphysicsengine_android_jetcompose.R

/**
 * Represents a sensor.
 *
 * @param title the title of the sensor.
 * @param subTitle the subtitle or description of the sensor.
 * @param image the drawable resource ID representing the sensor's image.
 * @param screen the screen associated with the sensor.
 */
data class Sensor(
    val title: String,
    val subTitle: String,
    @DrawableRes val image: Int,
    val screen: String
)

/**
 * Repository for accessing sensor data.
 */
object SensorsRepo {
    /**
     * Retrieves a list of general sensors.
     *
     * @return the list of general sensors.
     */
    fun getGeneralSensors(): List<Sensor> = generalSensors()

    /**
     * Retrieves a list of acoustic sensors.
     *
     * @return the list of acoustic sensors.
     */
    fun getAcousticSensors(): List<Sensor> = acousticSensors()

    private val generalTitle = listOf(
        "Accelerometer",
        "Gyroscope",
        "Magnetometer",
        "Barometer",
        "GPS"
    )

    private val generalSubTitle = listOf(
        "3-Axis Acceleration Data",
        "3-Axis Rotation Data",
        "3-Axis Magnetic Field Data",
        "Pressure and Relative Altitude",
        "Lat/Long and Other Data"
    )

    private val generalImage = listOf(
        R.drawable.accelerometericon,
        R.drawable.gyroscopeicon,
        R.drawable.magnetometer,
        R.drawable.barometer,
        R.drawable.gps
    )

    private val generalScreen = listOf(
        "Accelerometer",
        "Gyroscope",
        "Magnetometer",
        "Barometer",
        "GPS"
    )

    private val acousticTitle = listOf(
        "Decibel Meter",
        "Audio Oscilloscope",
        "Audio Spectrogram"
    )

    private val acousticSubTitle = listOf(
        "Sound Levels",
        "Visualized Amplitude Data",
        "FFT Analysis and Spectrum"
    )

    private val acousticImage = listOf(
        R.drawable.decibelmeter,
        R.drawable.audiooscilloscope,
        R.drawable.audiospectrometericon
    )

    private val acousticScreen = listOf(
        "DecibelMeter",
        "AudioOscilloscope",
        "AudioSpectrogram"
    )

    private fun generalSensors(): List<Sensor> {
        val sensors = mutableListOf<Sensor>()
        for ((index, sensor) in generalTitle.withIndex()) {
            sensors.add(Sensor(sensor, generalSubTitle[index], generalImage[index], generalScreen[index]))
        }
        return sensors
    }

    private fun acousticSensors(): List<Sensor> {
        val sensors = mutableListOf<Sensor>()
        for ((index, sensor) in acousticTitle.withIndex()) {
            sensors.add(Sensor(sensor, acousticSubTitle[index], acousticImage[index], acousticScreen[index]))
        }
        return sensors
    }
}
