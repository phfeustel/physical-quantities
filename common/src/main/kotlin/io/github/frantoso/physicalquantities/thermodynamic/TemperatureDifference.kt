@file:Suppress("NonAsciiCharacters", "ObjectPropertyName")

package io.github.frantoso.physicalquantities.thermodynamic

import io.github.frantoso.physicalquantities.core.QuantityBase
import io.github.frantoso.physicalquantities.core.SimpleDifference
import io.github.frantoso.physicalquantities.utils.RawType

/**
 * A class to hold a type and unit safe temperature difference value in Degrees (°).
 * This class is needed to add to or subtract from a [Temperature] instance.
 * @param value The raw value.
 */
class TemperatureDifference private constructor(
    value: Number,
) : SimpleDifference<TemperatureDifference>(value, BASE_SYMBOL) {
    /**
     * Gets the raw value in degrees (°).
     */
    val degrees: RawType get() = value

    /**
     * Copies this object.
     * @return Returns a copy of this object.
     */
    override fun copy(): QuantityBase = TemperatureDifference(value)

    companion object {
        /**
         * Converts a number holding a temperature value to a [Temperature] instance.
         * @param value The number to interpret as Kelvin.
         * @return Returns a [Temperature] instance.
         */
        fun fromDegrees(value: Number): TemperatureDifference = TemperatureDifference(value)

        const val BASE_SYMBOL = "°"
    }
}

/**
 * Converts a number holding a °Celsius value to a [Temperature] instance.
 */
val Number.Degrees: TemperatureDifference get() = TemperatureDifference.fromDegrees(this)

/**
 * Converts a number holding a °Celsius value to a [Temperature] instance.
 */
@Suppress("unused")
val Number.`°`: TemperatureDifference get() = Degrees
