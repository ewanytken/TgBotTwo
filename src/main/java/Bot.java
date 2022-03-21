import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Contact;
import com.pengrad.telegrambot.model.Update;

import java.util.List;

public class Bot  {

    private final TelegramBot bot = new TelegramBot("BOT_TOKEN");

    public void server() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private void process(Update update){
        String caption = update.channelPost().caption();
        System.out.println(caption);

        Contact contact = update.message().contact();
        System.out.println(contact);
    }
}

