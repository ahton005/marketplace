package configs

import io.ktor.server.config.ApplicationConfig

data class CassandraConfig(
    val host: String = "localhost",
    val port: Int = 9042,
    val user: String = "cassandra",
    val pass: String = "cassandra",
    val keyspace: String = "test_keyspace",
    val testing: Boolean = false
) {
    constructor(config: ApplicationConfig) : this(
        host = config.property("$PATH.host").getString(),
        port = config.property("$PATH.port").getString().toInt(),
        user = config.property("$PATH.user").getString(),
        pass = config.property("$PATH.pass").getString(),
        keyspace = config.property("$PATH.keyspace").getString(),
        testing = config.property("$PATH.testing").getString().toBoolean()
    )

    companion object {
        const val PATH = "${ConfigPaths.repository}.cassandra"
    }
}
