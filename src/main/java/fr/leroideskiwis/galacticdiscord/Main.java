package fr.leroideskiwis.galacticdiscord;

import fr.leroideskiwis.galacticdiscord.database.ConnectionData;
import fr.leroideskiwis.galacticdiscord.database.ConnectionDataBuilder;
import fr.leroideskiwis.galacticdiscord.database.Database;
import fr.leroideskiwis.galacticdiscord.listeners.InteractionsListener;
import fr.leroideskiwis.galacticdiscord.listeners.TestListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class Main {

    private final JDA jda;
    private Database database;

    public Main(String token) {
        //TODO json file
        /*this.database = new Database(new ConnectionDataBuilder()
                .withUser("kiwi")
                .withHost("localhost")
                .withDatabase("galacticdiscord")
                .withPassword("kiwi123")
                .build()
        );*/
        this.jda = JDABuilder.createDefault(token).enableIntents(GatewayIntent.MESSAGE_CONTENT).build();
        jda.addEventListener(new InteractionsListener(jda));
        jda.addEventListener(new TestListener(jda));
    }

    public static void main(String... args) throws LoginException, SQLException {
        System.setProperty( "file.encoding", "UTF-8" );
        new Main(args[0]);
    }

}
