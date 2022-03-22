import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {



    @Override
    public String getBotUsername() {
        return System.getenv("BOT_NAME");
    }

    @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN");
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getChannelPost().getText());
        System.out.println(update.getChannelPost().getChatId());
        System.out.println(update.getChannelPost().getChat());
        System.out.println(update.getChannelPost().getCaption());
        if(update.getMessage() != null && update.getMessage().hasText()){
            String chatId = update.getMessage().getChatId().toString();
            try {
                this.execute(new SendMessage(chatId, "HI" + update.getMessage().getText()));
            } catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
    }
}

