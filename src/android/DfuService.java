package de.einfachhans.DfuUpdate;

import android.app.Activity;
import no.nordicsemi.android.dfu.DfuBaseService;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import org.jetbrains.annotations.Nullable;



@Override
public Intent registerReceiver(@Nullable BroadcastReceiver receiver, IntentFilter filter) {

    if (Build.VERSION.SDK_INT >= 34 && getApplicationInfo().targetSdkVersion >= 34) {
      return super.registerReceiver(receiver, filter, Context.RECEIVER_EXPORTED);
    } else {
      return super.registerReceiver(receiver, filter);
    }

}


public class DfuService extends DfuBaseService {

    @Override
    protected Class<? extends Activity> getNotificationTarget() {
        return NotificationActivity.class;
    }
}
