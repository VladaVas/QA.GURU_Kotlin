package org.example.kotlin.general

import java.util.Properties

object Config {
    private val DEFAULT_PROP_FILE = "/example.properties"

    val get: Props by lazy {
        val fileName = System.getProperty("env_config", DEFAULT_PROP_FILE)

        val properties = Properties().apply {
            val stream = Config::class.java.getResourceAsStream(fileName)
                ?: throw IllegalStateException("Properties file '$fileName' not found")
            stream.use { load(it) }
        }

        Props(
            browserName = required(properties, "browser.name"),
            browserVersion = required(properties, "browser.version"),
            frontendUrl = required(properties, "frontend.url"),
            backendUrl = required(properties, "backend.url"),
            backendApiVersion = required(properties, "backend.api.version"),
            moonHost = required(properties, "moon.host"),
        )
    }

    private fun required(props: Properties, key: String): String {
        return props.getProperty(key)
            ?: throw IllegalStateException("Missing required property: $key")
    }

    data class Props(
        val browserName: String,
        val browserVersion: String,
        val frontendUrl: String,
        val backendUrl: String,
        val backendApiVersion: String,
        val moonHost: String,
    )
}