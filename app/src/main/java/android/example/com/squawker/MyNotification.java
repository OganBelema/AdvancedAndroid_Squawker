package android.example.com.squawker;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.NotificationCompat;

public class MyNotification {

    private final Context context;

    private static final int NOTIFICATION_ID = 100;

    public MyNotification(Context context) {
        this.context = context;
    }

    public void displayNotification(String author, String message){
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, createNotification(author, message));
    }

    private Notification createNotification(String author, String message){
        NotificationCompat.Builder builder = new NotificationCompat
                .Builder(context.getApplicationContext());
        builder.setContentText(message);
        builder.setContentTitle(author);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setStyle(new NotificationCompat.BigTextStyle());
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();
    }


}
