import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws LoginException {

        String token = getBotToken();

        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(token);
        builder.addEventListeners(new BertListener());

        builder.build();
    }

    private static String getBotToken() {
        Properties prop = new Properties();
        String fileName = "bot.config";
        InputStream is = null;

        try {
            is = new FileInputStream(fileName);
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        try {
            prop.load(is);
        }
        catch (IOException ex) {
            System.out.println(ex);
        }

        return prop.getProperty("bot.token");
    }
}
