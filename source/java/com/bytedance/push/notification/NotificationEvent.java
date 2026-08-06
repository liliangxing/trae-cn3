package com.bytedance.push.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.push.BaseJson;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationEvent extends BaseJson {
    public static final int NOTIFICATION_TYPE_FORE_GROUND = 2;
    public static final int NOTIFICATION_TYPE_FROM_OTHERS_APP = 3;
    public static final int NOTIFICATION_TYPE_NORMAL = 1;
    public List<String> mBlackFiledList;
    private ComponentName mComponentName;
    private Notification mNotification;
    private int mNotificationType;
    public String mOpPkg;
    private String mStack;
    private String mTargetNotificationReg;
    private final String TAG = "NotificationEvent";
    private boolean mIsValidNotification = true;
    private boolean mIsTargetNotification = false;
    private long mClientTime = System.currentTimeMillis();

    public NotificationEvent(Notification notification, int i, List<String> list) {
        this.mNotification = notification;
        this.mNotificationType = i;
        this.mBlackFiledList = list;
    }

    public NotificationEvent(Notification notification, int i, ComponentName componentName, List<String> list) {
        this.mNotification = notification;
        this.mNotificationType = i;
        this.mComponentName = componentName;
        this.mBlackFiledList = list;
    }

    public NotificationEvent setIsValidNotification(boolean z) {
        this.mIsValidNotification = z;
        return this;
    }

    public NotificationEvent setTargetNotification(boolean z) {
        this.mIsTargetNotification = z;
        return this;
    }

    public boolean isTargetNotification() {
        return this.mIsTargetNotification;
    }

    public NotificationEvent setBlackFiledList(List<String> list) {
        this.mBlackFiledList = list;
        return this;
    }

    public NotificationEvent setTargetNotificationReg(String str) {
        this.mTargetNotificationReg = str;
        return this;
    }

    public NotificationEvent setStack(String str) {
        this.mStack = str;
        return this;
    }

    public NotificationEvent setOpPkg(String str) {
        this.mOpPkg = str;
        return this;
    }

    public Map<String, Object> parseNotificationFields() throws IllegalAccessException {
        Field[] declaredFields = this.mNotification.getClass().getDeclaredFields();
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("\n");
        for (Field field : declaredFields) {
            if (!Modifier.isFinal(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                if (TextUtils.equals(field.getName(), "extras")) {
                    Bundle bundle = this.mNotification.extras;
                    if (bundle != null) {
                        for (String str : bundle.keySet()) {
                            List<String> list = this.mBlackFiledList;
                            if (list != null && list.contains(str)) {
                                Logger.m268d("NotificationEvent", String.format("filter filed extras.%s", str));
                            } else {
                                Object[] objArr = new Object[3];
                                objArr[0] = str;
                                objArr[1] = bundle.get(str);
                                objArr[2] = bundle.get(str) != null ? bundle.get(str).getClass() : "null";
                                sb.append(String.format("extra.%s:%s:%s\n", objArr));
                                hashMap.put(String.format("extra.%s", str), bundle.get(str));
                            }
                        }
                    }
                } else {
                    List<String> list2 = this.mBlackFiledList;
                    if (list2 == null || !list2.contains(field.getName())) {
                        sb.append(String.format("%s:%s:%s\n", field.getName(), field.get(this.mNotification), field.getType()));
                        hashMap.put(field.getName(), field.get(this.mNotification));
                    } else {
                        Logger.m268d("NotificationEvent", String.format("filter filed %s", field.getName()));
                    }
                }
            }
        }
        Logger.m268d("NotificationEvent", sb.toString());
        return hashMap;
    }

    public JSONObject toJson() {
        String str;
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "client_time", this.mClientTime);
        add(jSONObject, "notification_type", this.mNotificationType);
        ComponentName componentName = this.mComponentName;
        if (componentName == null) {
            add(jSONObject, "component", "null");
        } else {
            add(jSONObject, "component", componentName.toShortString());
        }
        if (!TextUtils.isEmpty(this.mTargetNotificationReg)) {
            add(jSONObject, "target_text_reg", this.mTargetNotificationReg);
        }
        if (!TextUtils.isEmpty(this.mOpPkg)) {
            add(jSONObject, "op_pkg", this.mOpPkg);
        }
        NotificationManager notificationManager = (NotificationManager) AppProvider.getApp().getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(this.mNotification.getChannelId());
            if (notificationChannel == null) {
                add(jSONObject, "channel_is_open", false);
            } else {
                add(jSONObject, "channel_is_open", notificationChannel.getImportance() > 0);
                add(jSONObject, "channel_importance", notificationChannel.getImportance());
            }
        }
        add(jSONObject, "push_is_open", ToolUtils.areNotificationsEnabled(AppProvider.getApp()) > 0);
        add(jSONObject, "is_valid", this.mIsValidNotification);
        add(jSONObject, "is_target_notification", this.mIsTargetNotification);
        add(jSONObject, ReportConst.KEY_STACK, this.mStack);
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(AppProvider.getApp()));
        try {
            HashSet hashSet = new HashSet();
            for (Map.Entry<String, Object> entry : parseNotificationFields().entrySet()) {
                if (entry.getValue() == null) {
                    str = "null";
                } else if (entry.getValue() instanceof PendingIntent) {
                    PendingIntent pendingIntent = (PendingIntent) entry.getValue();
                    str = NotificationShowMonitor.inst().getContentIntentFromPendingIntent(pendingIntent);
                    if (!TextUtils.isEmpty(str)) {
                        hashSet.add(pendingIntent);
                    } else {
                        str = String.valueOf(entry.getValue());
                    }
                } else {
                    str = String.valueOf(entry.getValue());
                }
                add(jSONObject, entry.getKey(), str);
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                NotificationShowMonitor.inst().removeContentIntent((PendingIntent) it.next());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
