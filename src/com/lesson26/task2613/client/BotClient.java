package com.lesson26.task2613.client;

import com.lesson26.task2613.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client {

     public class BotSocketThread extends SocketThread {

         @Override
         protected void clientMainLoop() throws IOException, ClassNotFoundException {
             BotClient.this.sendTextMessage(
                     "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
             super.clientMainLoop();
         }

         @Override
         protected void processIncomingMessage(String message) {
             ConsoleHelper.writeMessage(message);
             String[] info = message.split(":");
             if (info.length != 2) {
                 return;
             }
             String userName = info[0];
             String messageText = info[1].trim();


             Date calendar = new GregorianCalendar().getTime();
             SimpleDateFormat date = new SimpleDateFormat("d.MM.YYYY");
             SimpleDateFormat day = new SimpleDateFormat("d");
             SimpleDateFormat month = new SimpleDateFormat("MMMM");
             SimpleDateFormat year = new SimpleDateFormat("YYYY");
             SimpleDateFormat time = new SimpleDateFormat("H:mm:ss");
             SimpleDateFormat hour = new SimpleDateFormat("H");
             SimpleDateFormat minutes = new SimpleDateFormat("m");
             SimpleDateFormat seconds = new SimpleDateFormat("s");


             switch (messageText) {

                 case "дата":
                     sendTextMessage(String.format("Информация для %s: %s",userName, date.format(calendar)));
                     break;

                 case "день":
                     sendTextMessage(String.format("Информация для %s: %s",userName, day.format(calendar)));
                     break;

                 case "месяц":
                     sendTextMessage(String.format("Информация для %s: %s",userName, month.format(calendar)));
                     break;

                 case "год":
                     sendTextMessage(String.format("Информация для %s: %s",userName, year.format(calendar)));
                     break;

                 case "время":
                     sendTextMessage(String.format("Информация для %s: %s",userName, time.format(calendar)));
                     break;

                 case "час":
                     sendTextMessage(String.format("Информация для %s: %s",userName, hour.format(calendar)));
                     break;

                 case "минуты":
                     sendTextMessage(String.format("Информация для %s: %s",userName, minutes.format(calendar)));
                     break;

                 case "секунды":
                     sendTextMessage(String.format("Информация для %s: %s",userName, seconds.format(calendar)));
                     break;
             }

         }
     }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
         double X =  Math.random() * 100;
        return "date_bot_" + (int)X;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
