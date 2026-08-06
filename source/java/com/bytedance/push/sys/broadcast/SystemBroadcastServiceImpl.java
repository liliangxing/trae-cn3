package com.bytedance.push.sys.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.interfaze.ISystemBroadcastService;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SystemBroadcastServiceImpl extends BroadcastReceiver implements ISystemBroadcastService {
    private boolean mHasMonitorNotificationBarStatus;
    private final String TAG = "SystemBroadcastServiceImpl";
    private Map<String, Set<ISystemBroadcastService.IBroadcastReceiver>> mIBroadcastReceiverMap = new ConcurrentHashMap();

    @Override // com.bytedance.push.interfaze.ISystemBroadcastService
    public synchronized void addNotificationBarPullDownListener(ISystemBroadcastService.IBroadcastReceiver iBroadcastReceiver) {
        Set<ISystemBroadcastService.IBroadcastReceiver> set = this.mIBroadcastReceiverMap.get(iBroadcastReceiver);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(iBroadcastReceiver);
        this.mIBroadcastReceiverMap.put(ISystemBroadcastService.MIUI_NOTIFICATION_ACTION, set);
        if (this.mHasMonitorNotificationBarStatus) {
            return;
        }
        this.mHasMonitorNotificationBarStatus = true;
        IntentFilter intentFilter = new IntentFilter(ISystemBroadcastService.MIUI_NOTIFICATION_ACTION);
        Logger.m268d("SystemBroadcastServiceImpl", "register as : com.android.systemui.fsgesture");
        try {
            PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(AppProvider.getApp(), this, intentFilter);
        } catch (Throwable th) {
            Logger.m271e("SystemBroadcastServiceImpl", "addNotificationBarPullDownListener failed because exception:" + th.getLocalizedMessage());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        Bundle extras;
        Logger.m268d("SystemBroadcastServiceImpl", "onReceive:" + intent.getAction());
        if (TextUtils.equals(intent.getAction(), ISystemBroadcastService.MIUI_NOTIFICATION_ACTION) && (extras = intent.getExtras()) != null && TextUtils.equals(extras.getString(ISystemBroadcastService.KEY_TYPE_FROM), ISystemBroadcastService.VALUE_TYPE_FROM_STATUS_BAR_EXPANSION)) {
            boolean z = extras.getBoolean(ISystemBroadcastService.KEY_IS_ENTER);
            Logger.m268d("SystemBroadcastServiceImpl", "notification bar status changed,isEnter:" + z);
            if (z) {
                PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.sys.broadcast.SystemBroadcastServiceImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Set set = (Set) SystemBroadcastServiceImpl.this.mIBroadcastReceiverMap.get(ISystemBroadcastService.MIUI_NOTIFICATION_ACTION);
                        if (set != null) {
                            for (Object obj : set.toArray()) {
                                ((ISystemBroadcastService.IBroadcastReceiver) obj).onReceiveFromPushSystemBroadcastService(intent);
                            }
                        }
                    }
                });
            }
        }
    }
}
