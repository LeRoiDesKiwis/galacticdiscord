package fr.leroideskiwis.galacticdiscord.discord;

import fr.leroideskiwis.galacticdiscord.core.Location;
import fr.leroideskiwis.galacticdiscord.core.player.Home;
import fr.leroideskiwis.galacticdiscord.core.player.Player;
import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerManager {

    private final List<Player> players = new ArrayList<>();

    public Player createPlayer(User user){

        Player player = new Player(user, new Location(0, 0));
        players.add(player);
        return player;
    }

    public Optional<Player> getPlayerByUser(User user){
        return players.stream().filter(player -> player.isUser(user)).findAny();
    }

    public boolean contains(User user){
        return getPlayerByUser(user).isPresent();
    }

}
