package fr.leroideskiwis.galacticdiscord.core.player;

import fr.leroideskiwis.galacticdiscord.database.Database;
import net.dv8tion.jda.api.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Player {

    private int xp;
    private int money;
    private Inventory inventory;
    private final User user;
    private final Home home;

    public Player(User user, Home home){
        this.user = user;
        this.home = home;
    }

    public void load(Database database) throws SQLException {
        PreparedStatement preparedStatement = database.prepareStatement("SELECT * FROM players WHERE id=?");
        preparedStatement.setString(1, user.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(!resultSet.next()){
            save(database);
            load(database);
            return;
        }
        this.xp = resultSet.getInt("xp");
        this.money = resultSet.getInt("money");
        preparedStatement.close();
        resultSet.close();

    }

    public void save(Database database) throws SQLException {
        PreparedStatement preparedStatement = database.prepareStatement("INSERT INTO players (id, xp, money) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE xp=VALUES(xp), money=VALUES(money)");
        preparedStatement.setString(1, user.getId());
        preparedStatement.setInt(2, xp);
        preparedStatement.setInt(3, money);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public Home createHomeFrom(Player player) {
        return home.createNewHomeFromHere(player);
    }
}
