package commands

import commands.models.BotCommand
import dbshit.Save
import dbshit.Service
import kotlinx.coroutines.runBlocking
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import util.CommandData
import util.reply
import util.startTyping

@Suppress("DuplicatedCode")
object Save: BotCommand {
    override val help: String = "save shit to db"
    override val commandString: String = "save !message"

    override fun command(data: CommandData, event: MessageReceivedEvent) {
        val message = event.message
        message.channel.startTyping()
        val msg = data.argsContent["message"] ?: "Something fucked up"
        val author = event.author.idLong
        val toSave = Save(msg, author)
        runBlocking { Service.insert(toSave) }
        message.reply("Saved: $toSave")
    }
}