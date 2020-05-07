package fr.leroideskiwis.galacticdiscord.player;

import fr.leroideskiwis.galacticdiscord.database.Database;
import net.dv8tion.jda.api.entities.User;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Player {

    private int xp;
    private int money;
    private Inventory inventory;
    private User user;

    public Player(User user){
        this.user = user;
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
}
