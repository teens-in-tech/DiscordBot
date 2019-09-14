package commands.models

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import util.CommandData

interface BotCommand {
    val help: String
    val commandString: String

    fun command(data: CommandData, event: MessageReceivedEvent)
}