package fr.leroideskiwis.galacticdiscord.discord.commands.home;

import fr.leroideskiwis.galacticdiscord.discord.PlayerManager;
import fr.leroideskiwis.galacticdiscord.discord.commands.Command;
import fr.leroideskiwis.galacticdiscord.discord.commands.CommandArgument;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class HomeAddCommand implements Command {

    public PlayerManager playerManager;
    public HomeAddCommand(){
        this.playerManager = new PlayerManager();
    }

    @Override
    public String description() {
        return "tamer";
    }

    @Override
    public List<CommandArgument> arguments() {
        return List.of();
    }

    @Override
    public String example() {
        return "baseadd damn";
    }

    @Override
    public boolean hasPermission(MessageReceivedEvent event) {
        return true;
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        if(!playerManager.contains(event.getAuthor()))
        {
            event.getChannel().sendMessage("not exist").queue();
            playerManager.createPlayer(event.getAuthor());
        }
        else event.getChannel().sendMessage("exists").queue();
        return false;
    }
}
