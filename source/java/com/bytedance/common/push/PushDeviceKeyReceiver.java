package com.bytedance.common.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.common.push.interfaze.IDeviceKeyListener;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PushDeviceKeyReceiver extends BroadcastReceiver {
    private static volatile PushDeviceKeyReceiver sDeviceKeyReceiver;
    private final String TAG = "DeviceKeyReceiver";
    private final String REASON_MULTI_TASK = "recentapps";
    private final String REASON_MULTI_TASK_MI = "fs_gesture";
    private final String ACTION_MULTI_TASK = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
    private boolean hasRegisterReceiver = false;
    private Set<IDeviceKeyListener> mIDeviceKeyListeners = new HashSet();

    public static PushDeviceKeyReceiver getInstance() {
        if (sDeviceKeyReceiver == null) {
            synchronized (PushDeviceKeyReceiver.class) {
                if (sDeviceKeyReceiver == null) {
                    sDeviceKeyReceiver = new PushDeviceKeyReceiver();
                }
            }
        }
        return sDeviceKeyReceiver;
    }

    public void registerDeviceKeyListener(Context context, IDeviceKeyListener iDeviceKeyListener) {
        if (!this.hasRegisterReceiver) {
            this.hasRegisterReceiver = true;
            PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(context, this, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
        this.mIDeviceKeyListeners.add(iDeviceKeyListener);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("reason");
            Logger.d("DeviceKeyReceiver", "onReceive:" + action + " reason:" + stringExtra);
            if (TextUtils.equals(action, "android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                if (TextUtils.equals(stringExtra, "recentapps") || TextUtils.equals(stringExtra, "fs_gesture")) {
                    Logger.d("DeviceKeyReceiver", "update app status for multi task action");
                    Iterator<IDeviceKeyListener> it = this.mIDeviceKeyListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onMultiTask();
                    }
                }
            }
        }
    }
}
