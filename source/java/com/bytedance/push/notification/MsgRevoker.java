package com.bytedance.push.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.IAccountService;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.push.PushBody;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.interfaze.IPushMsgShowInterceptor;
import com.bytedance.push.interfaze.IRevokeEventInterceptor;
import com.bytedance.push.model.LocalRevokeCache;
import com.bytedance.push.safe.IPassThoughMsgCache;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.bytedance.push.settings.SettingsManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.app.MessageAppHooks;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MsgRevoker {
    private final IPushMsgShowInterceptor mInterceptor;

    public MsgRevoker(IPushMsgShowInterceptor iPushMsgShowInterceptor) {
        this.mInterceptor = iPushMsgShowInterceptor;
    }

    public synchronized boolean tryRevoke(final Context context, final int i, final PushBody pushBody) {
        List<LocalRevokeCache> currentRevokeCacheList = getCurrentRevokeCacheList(context);
        if (pushBody.revokeId <= 0) {
            LocalRevokeCache shouldBeRevoke = shouldBeRevoke(pushBody, currentRevokeCacheList);
            if (shouldBeRevoke != null) {
                onRevokeEvent(pushBody, null, i, shouldBeRevoke.sender);
            }
            return shouldBeRevoke != null;
        }
        addRevokeListToLocalSettings(context, pushBody, currentRevokeCacheList, i);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.push.notification.MsgRevoker.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z = true;
                boolean z2 = MsgRevoker.this.mInterceptor != null && MsgRevoker.this.mInterceptor.onReceiveRevokeMsg(context, i, pushBody);
                if (!MsgRevoker.this.doRevoke(context, pushBody) && !z2) {
                    z = false;
                }
                if (z) {
                    IPassThoughMsgCache iPassThoughMsgCache = (IPassThoughMsgCache) UgBusFramework.getService(IPassThoughMsgCache.class);
                    PushBody revokedMsg = iPassThoughMsgCache.getRevokedMsg(pushBody.revokeId);
                    int msgFrom = iPassThoughMsgCache.getMsgFrom(revokedMsg);
                    if (msgFrom == 0) {
                        msgFrom = i;
                    }
                    MsgRevoker.this.onRevokeEvent(revokedMsg, pushBody, msgFrom, i);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRevokeEvent(final PushBody pushBody, final PushBody pushBody2, final int i, final int i2) {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.notification.MsgRevoker.2
            @Override // java.lang.Runnable
            public void run() {
                long j;
                MessageAppHooks.PushHook service = UgBusFramework.getService(MessageAppHooks.PushHook.class);
                IAccountService service2 = UgBusFramework.getService(IAccountService.class);
                if (service != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        PushBody pushBody3 = pushBody;
                        if (pushBody3 != null) {
                            j = pushBody3.f84id;
                        } else {
                            PushBody pushBody4 = pushBody2;
                            j = pushBody4 != null ? pushBody4.revokeId : 0L;
                        }
                        jSONObject.put("from_rule_id", j);
                        jSONObject.put("to_rule_id", "");
                        jSONObject.put("from_push_channel", i);
                        jSONObject.put("to_push_channel", i2);
                        jSONObject.put("withdraw_type", 1);
                        PushBody pushBody5 = pushBody;
                        jSONObject.put("from_group_id", pushBody5 != null ? pushBody5.groupId : 0);
                        jSONObject.put("user_id", service2.getSecUid());
                        PushBody pushBody6 = pushBody;
                        String str = ViewVisibleBridge.INVISIBLE;
                        jSONObject.put("is_self", PushMsgHandler.hasLoggedInBefore(pushBody6 != null ? pushBody6.targetSecUid : ViewVisibleBridge.INVISIBLE) ? "1" : ViewVisibleBridge.INVISIBLE);
                        if (!TextUtils.isEmpty(service2.getSecUid())) {
                            str = "1";
                        }
                        jSONObject.put("is_login", str);
                        IRevokeEventInterceptor iRevokeEventInterceptor = PushSupporter.get().getConfiguration().revokeEventInterceptor;
                        if (iRevokeEventInterceptor != null) {
                            iRevokeEventInterceptor.intercept(jSONObject, pushBody, pushBody2);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    service.onEventV3("push_withdraw", jSONObject);
                }
            }
        });
    }

    private List<LocalRevokeCache> getCurrentRevokeCacheList(Context context) {
        long millis = TimeUnit.DAYS.toMillis(1L);
        ArrayList arrayList = new ArrayList();
        List<LocalRevokeCache> revokeRidList = ((LocalFrequencySettings) SettingsManager.obtain(context, LocalFrequencySettings.class)).getRevokeRidList();
        long currentTimeMillis = ToolUtils.currentTimeMillis();
        if (revokeRidList != null) {
            for (LocalRevokeCache localRevokeCache : revokeRidList) {
                if (localRevokeCache != null && localRevokeCache.receiveTimeStamp + millis > currentTimeMillis) {
                    arrayList.add(localRevokeCache);
                }
            }
        }
        return arrayList;
    }

    private LocalRevokeCache shouldBeRevoke(PushBody pushBody, List<LocalRevokeCache> list) {
        if (list == null) {
            return null;
        }
        for (LocalRevokeCache localRevokeCache : list) {
            if (localRevokeCache != null && localRevokeCache.revokeId == pushBody.f84id) {
                return localRevokeCache;
            }
        }
        return null;
    }

    private void addRevokeListToLocalSettings(Context context, PushBody pushBody, List<LocalRevokeCache> list, int i) {
        if (list != null) {
            for (LocalRevokeCache localRevokeCache : list) {
                if (localRevokeCache != null && localRevokeCache.revokeId == pushBody.revokeId) {
                    return;
                }
            }
        }
        LocalRevokeCache localRevokeCache2 = new LocalRevokeCache();
        localRevokeCache2.rid = pushBody.f84id;
        localRevokeCache2.revokeId = pushBody.revokeId;
        localRevokeCache2.sender = i;
        localRevokeCache2.receiveTimeStamp = ToolUtils.currentTimeMillis();
        list.add(localRevokeCache2);
        ((LocalFrequencySettings) SettingsManager.obtain(context, LocalFrequencySettings.class)).setRevokeRidList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doRevoke(Context context, PushBody pushBody) {
        boolean z;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            int i = (int) (pushBody.revokeId % 2147483647L);
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            if (activeNotifications != null) {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (statusBarNotification != null && statusBarNotification.getId() == i) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            notificationManager.cancel("app_notify", i);
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
