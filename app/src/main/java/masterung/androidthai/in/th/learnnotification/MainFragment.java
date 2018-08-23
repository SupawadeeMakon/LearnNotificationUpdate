package masterung.androidthai.in.th.learnnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Notification Controller
        notificationController();

    }

    private void notificationController() {
        Button button = getView().findViewById(R.id.btnStartNotification);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ShowNotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(),
                        (int) System.currentTimeMillis(), intent, 0);
                Uri uri = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
                Notification notification = new Notification.Builder(getActivity())
                        .setContentTitle("Show Title on Notification")
                        .setContentText("Show Text on Notification")
                        .setSmallIcon(R.drawable.ic_action_alert)
                        .setSound(uri)
                        .setContentIntent(pendingIntent).build();
                NotificationManager notificationManager = (NotificationManager) getActivity()
                        .getSystemService(Context.NOTIFICATION_SERVICE);
                notification.flags |= Notification.FLAG_AUTO_CANCEL;
                notificationManager.notify(0, notification);



            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}
