package android.example.com.squawker.fcm;

import android.example.com.squawker.MyNotification;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class SquawkFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Map<String, String> data = remoteMessage.getData();
        String author = data.get("author");
        String authorKey = data.get("authorKey");
        String message = data.get("message");
        String date = data.get("date");

        MyNotification myNotification = new MyNotification(this);
        myNotification.displayNotification(author, message);

        Log.d(SquawkFirebaseMessagingService.class.getSimpleName(), author);
        Log.d(SquawkFirebaseMessagingService.class.getSimpleName(), message);

    }
}
