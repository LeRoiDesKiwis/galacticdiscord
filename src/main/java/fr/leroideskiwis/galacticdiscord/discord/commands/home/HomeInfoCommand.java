package fr.leroideskiwis.galacticdiscord.discord.commands.home;

import fr.leroideskiwis.galacticdiscord.discord.commands.Command;
import fr.leroideskiwis.galacticdiscord.discord.commands.CommandArgument;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class HomeInfoCommand implements Command {
    @Override
    public String description() {
        return "get infos of your home";
    }

    @Override
    public List<CommandArgument> arguments() {
        return List.of();
    }

    @Override
    public String example() {
        return "";
    }

    @Override
    public boolean hasPermission(MessageReceivedEvent event) {
        return true;
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage("Not implemented yet.").queue();
        return false;
    }
}
