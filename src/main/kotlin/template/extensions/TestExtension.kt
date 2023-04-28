package template.extensions

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.annotation.KordPreview
import template.TEST_SERVER_ID

@OptIn(KordPreview::class)
class TestExtension : Extension() {
    override val name = "test"

    override suspend fun setup() {
        publicSlashCommand(::EchoSlashArgs) {
            name = "echo"
            description = "Echos out text back - test command"

            guild(TEST_SERVER_ID)  // Otherwise it'll take an hour to update

            action {
                // Because of the DslMarker annotation KordEx uses, we need to grab Kord explicitly
                val kord = this@TestExtension.kord
                val ctx = this
                respond {
                    content = "**${ctx.member?.asMember()?.displayName}** says: ${arguments.echoReturn}"
                }
            }
        }
    }

    inner class EchoSlashArgs : Arguments() {
        // Coalesced strings are not currently supported by slash commands
        val echoReturn by defaultingString {
            name = "echo"

            defaultValue = "Hello, world!"
            description = "Echos back with the string here."
        }
    }
}
