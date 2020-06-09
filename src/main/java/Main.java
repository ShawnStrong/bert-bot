import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "NzE4OTA2OTY5ODU1MDk4OTgz.XtzuRg.421WHq3QhK4S0Y-dBkhgRuESeKI";
        builder.setToken(token);
        builder.addEventListeners(new BertListener());

        builder.build();
    }
}
