package com.bytedance.common.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DeviceKeyReceiver extends BroadcastReceiver {
    private static Set<IMultiTaskListener> multiTaskListenerSet = new HashSet();
    private static DeviceKeyReceiver deviceKeyReceiver = new DeviceKeyReceiver();
    private static final AtomicBoolean mHasRegister = new AtomicBoolean(false);
    private final String TAG = "DeviceKeyReceiver";
    private final String REASON_MULTI_TASK_MI = "fs_gesture";
    private final String REASON_MULTI_TASK = "recentapps";
    private final String REASON_HOMEKEY = "homekey";
    private final String ACTION_MULTI_TASK = "android.intent.action.CLOSE_SYSTEM_DIALOGS";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IMultiTaskListener {
        void enterMultiTask();

        void onPressHomeKey();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("reason");
            Logger.d("DeviceKeyReceiver", "onReceive:" + action + " reason:" + stringExtra);
            if (TextUtils.equals(action, "android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                int i = 0;
                if (TextUtils.equals(stringExtra, "fs_gesture") || TextUtils.equals(stringExtra, "recentapps")) {
                    Object[] array = multiTaskListenerSet.toArray();
                    int length = array.length;
                    while (i < length) {
                        ((IMultiTaskListener) array[i]).enterMultiTask();
                        i++;
                    }
                    return;
                }
                if (TextUtils.equals(stringExtra, "homekey")) {
                    Object[] array2 = multiTaskListenerSet.toArray();
                    int length2 = array2.length;
                    while (i < length2) {
                        ((IMultiTaskListener) array2[i]).onPressHomeKey();
                        i++;
                    }
                }
            }
        }
    }

    public static void registerMultiTaskListener(IMultiTaskListener iMultiTaskListener) {
        if (mHasRegister.compareAndSet(false, true)) {
            PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(AppProvider.getApp(), deviceKeyReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
        multiTaskListenerSet.add(iMultiTaskListener);
    }

    public static void unregisterMultiTaskListener(IMultiTaskListener iMultiTaskListener) {
        multiTaskListenerSet.remove(iMultiTaskListener);
    }
}
