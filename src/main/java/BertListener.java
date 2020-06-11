import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class BertListener extends ListenerAdapter {

    private final static String BERT_TAG = "BaconBurritoPop";
    private final static String BERT_DISCRIMINATOR = "3386";

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) {
            return;
        }

        System.out.println("We received a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay());

        String message = event.getMessage().getContentRaw();

        switch(message) {
            case "!annoybert":
                User user = event.getJDA().getUserByTag(BERT_TAG, BERT_DISCRIMINATOR);

                user.openPrivateChannel().queue((channel) -> {
                    channel.sendMessage("I'm here to annoy you, Bert.").queue();
                });

            case "!bert":
                event.getChannel().sendMessage("bert statistics: ").queue();


        }
    }

    @Override
    public void onUserActivityStart(UserActivityStartEvent event) {
        System.out.println("User activity started: member " +
                event.getMember() + " active at times " +
                event.getNewActivity().getTimestamps());
    }

    @Override
    public void onUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event) {
        System.out.println("User activity started: member " +
                event.getMember() + " status change event: " +
                event.getNewOnlineStatus());
    }
}
