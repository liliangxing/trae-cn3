package com.bytedance.push.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.notification.INotificationMonitorService;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.notification.NotificationMonitorSettingsModel;
import com.bytedance.push.settings.notification.NotificationSettings;
import com.bytedance.push.settings.notification.TargetNotificationMonitorModel;
import com.bytedance.push.utils.DoubleReflectUtils;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.PatternUtils;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationShowMonitor extends BaseJson implements INotificationMonitorService {
    private static NotificationShowMonitor mNotificationShowMonitor;
    private long mLastMonitorNotificationFromOthersAppTimeStamp;
    private final String TAG = "PushMonitorShowService";
    private final String EVENT_NAME_BD_NOTIFICATION_MONITOR_EVENT = "bdpush_notification_event";
    private final String EVENT_NAME_BD_NOTIFICATION_INTERCEPT_EVENT = "bdpush_notification_intercept_event";
    private final int MAX_SIZE_TARGET_PKG_MAP = 10;
    private final Map<Object, String> mTargetPkgMap = new MaxSizeHashMap(10);
    private final AtomicBoolean mInit = new AtomicBoolean(false);
    private List<String> reportedHistory = new CopyOnWriteArrayList();

    public static NotificationShowMonitor inst() {
        if (mNotificationShowMonitor == null) {
            synchronized (NotificationShowMonitor.class) {
                if (mNotificationShowMonitor == null) {
                    mNotificationShowMonitor = new NotificationShowMonitor();
                }
            }
        }
        return mNotificationShowMonitor;
    }

    public void init() {
        if (this.mInit.getAndSet(true)) {
            return;
        }
        ThreadPlus.runOnChildThread(new RunnableC06221());
    }

    /* renamed from: com.bytedance.push.notification.NotificationShowMonitor$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    class RunnableC06221 implements Runnable {
        RunnableC06221() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToolUtils.isMainProcess(AppProvider.getApp())) {
                final NotificationMonitorSettingsModel ins = NotificationMonitorSettingsModel.getIns();
                if (ins.enableMonitorNotificationShow) {
                    NotificationShowMonitor.this.monitorNotificationFromOthersApp();
                    ActivityLifecycleObserver.getIns().addObserver(new Observer() { // from class: com.bytedance.push.notification.NotificationShowMonitor.1.1
                        @Override // java.util.Observer
                        public void update(Observable observable, Object obj) {
                            boolean booleanValue = ((Boolean) obj).booleanValue();
                            Logger.m268d("PushMonitorShowService", "[onAppStatusUpdate]isInBackGround:" + booleanValue);
                            if (booleanValue) {
                                return;
                            }
                            long currentTimeMillis = System.currentTimeMillis() - NotificationShowMonitor.this.mLastMonitorNotificationFromOthersAppTimeStamp;
                            if (currentTimeMillis < ins.minMonitorInterval) {
                                Logger.m268d("PushMonitorShowService", "[onAppStatusUpdate]not monitorNotificationFromOthersApp because frequency control,monitorInterval:" + currentTimeMillis + " minMonitorInterval:" + ins.minMonitorInterval);
                            } else {
                                PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.notification.NotificationShowMonitor.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NotificationShowMonitor.this.monitorNotificationFromOthersApp();
                                    }
                                });
                            }
                        }
                    });
                }
            }
        }
    }

    private String getNotificationIdStr(String str, int i, Notification notification) {
        try {
            Field accessibleField = DoubleReflectUtils.getAccessibleField(Notification.class, "creationTime");
            if (accessibleField != null) {
                return String.format("%s", Long.valueOf(((Long) accessibleField.get(notification)).longValue()));
            }
        } catch (Throwable th) {
            Logger.m272e("PushMonitorShowService", "[getNotificationIdStr]error when get creationTime ", th);
        }
        return String.format("%s-%s", str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void monitorNotificationFromOthersApp() {
        NotificationMonitorSettingsModel ins;
        long currentTimeMillis;
        boolean z;
        boolean z2;
        try {
            ins = NotificationMonitorSettingsModel.getIns();
            currentTimeMillis = System.currentTimeMillis() - this.mLastMonitorNotificationFromOthersAppTimeStamp;
        } catch (Throwable th) {
            Logger.m272e("PushMonitorShowService", "[monitorNotificationFromOthersApp]exception: ", th);
        }
        if (currentTimeMillis < ins.minMonitorInterval) {
            Logger.m268d("PushMonitorShowService", "[monitorNotificationFromOthersApp]not monitorNotificationFromOthersApp because frequency control,monitorInterval:" + currentTimeMillis + " minMonitorInterval:" + ins.minMonitorInterval);
            return;
        }
        this.mLastMonitorNotificationFromOthersAppTimeStamp = System.currentTimeMillis();
        Logger.m268d("PushMonitorShowService", "[monitorNotificationFromOthersApp]monitorNotificationFromOthersApp");
        NotificationManager notificationManager = (NotificationManager) AppProvider.getApp().getSystemService("notification");
        if (notificationManager == null) {
            return;
        }
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        if (activeNotifications == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int length = activeNotifications.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                break;
            }
            StatusBarNotification statusBarNotification = activeNotifications[i];
            Logger.m268d("PushMonitorShowService", "[onOthersAppNotification]cur statusBarNotification tag:" + statusBarNotification.getTag() + " id:" + statusBarNotification.getId());
            String tag = statusBarNotification.getTag();
            if (ins.groupTagList != null) {
                Iterator<String> it = ins.groupTagList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    String next = it.next();
                    if (PatternUtils.inputMatchRegText(tag, next)) {
                        Logger.m268d("PushMonitorShowService", "[monitorNotificationFromOthersApp]cur notification is group notification,do nothing curTag:" + tag + " groupTag:" + next);
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    i++;
                }
            }
            Notification notification = statusBarNotification.getNotification();
            String group = notification.getGroup();
            if (ins.groupNameList != null) {
                Iterator<String> it2 = ins.groupNameList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    String next2 = it2.next();
                    if (PatternUtils.inputMatchRegText(group, next2)) {
                        Logger.m268d("PushMonitorShowService", "[monitorNotificationFromOthersApp]cur notification is group notification,do nothing,curGroup:" + group + " groupName:" + next2);
                        break;
                    }
                }
                if (z) {
                    i++;
                }
            }
            String notificationIdStr = getNotificationIdStr(tag, statusBarNotification.getId(), notification);
            arrayList.add(notificationIdStr);
            if (this.reportedHistory.contains(notificationIdStr)) {
                Logger.m268d("PushMonitorShowService", "[monitorNotificationFromOthersApp]cur notification has reported,do nothing");
            } else {
                this.reportedHistory.add(notificationIdStr);
                onOthersAppNotification(statusBarNotification);
            }
            i++;
        }
        int size = this.reportedHistory.size();
        if (arrayList.size() == 0) {
            this.reportedHistory.clear();
        } else {
            z = this.reportedHistory.retainAll(arrayList);
        }
        Logger.m268d("PushMonitorShowService", "[monitorNotificationFromOthersApp]retainAllResult:" + z + " before retain size:" + size + " after retain size:" + this.reportedHistory.size());
    }

    public boolean onNotificationShow(String str, int i, Notification notification) {
        this.reportedHistory.add(getNotificationIdStr(str, i, notification));
        NotificationMonitorSettingsModel ins = NotificationMonitorSettingsModel.getIns();
        final NotificationEvent notificationEvent = new NotificationEvent(notification, 1, ins.blackFiledList);
        boolean isValidNotificationStyle = isValidNotificationStyle(notificationEvent, notification);
        notificationEvent.setIsValidNotification(isValidNotificationStyle).setStack(getStack());
        if (!isValidNotificationStyle || notificationEvent.isTargetNotification() || ins.reportValidNotification) {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.notification.NotificationShowMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject json = notificationEvent.toJson();
                    Logger.m268d("PushMonitorShowService", "[onNotificationShow]notificationEvent is " + json);
                    PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_notification_event", json);
                }
            });
        } else {
            Logger.m268d("PushMonitorShowService", "[onNotificationShow]not report cur notificationEvent because cur notification is valid and mNotificationMonitorSettingsModel.reportValidNotification is false");
        }
        return isValidNotificationStyle;
    }

    public void onOthersAppNotification(StatusBarNotification statusBarNotification) {
        NotificationManager notificationManager;
        Notification notification = statusBarNotification.getNotification();
        NotificationMonitorSettingsModel ins = NotificationMonitorSettingsModel.getIns();
        NotificationEvent notificationEvent = new NotificationEvent(notification, 3, ins.blackFiledList);
        try {
            String str = (String) DoubleReflectUtils.getAccessibleField(StatusBarNotification.class, "opPkg").get(statusBarNotification);
            notificationEvent.setOpPkg(str);
            Logger.m268d("PushMonitorShowService", "[onOthersAppNotification]opPkg:" + str);
        } catch (Throwable th) {
            Logger.m272e("PushMonitorShowService", "[onOthersAppNotification]error when get opPkg ", th);
        }
        boolean isValidNotificationStyle = isValidNotificationStyle(notificationEvent, notification);
        notificationEvent.setIsValidNotification(isValidNotificationStyle);
        if (!isValidNotificationStyle || notificationEvent.isTargetNotification() || ins.reportValidNotification) {
            JSONObject json = notificationEvent.toJson();
            Logger.m268d("PushMonitorShowService", "[onOthersAppNotification]notificationEvent is " + json);
            PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_notification_event", json);
        } else {
            Logger.m268d("PushMonitorShowService", "[onOthersAppNotification]not report cur notificationEvent because cur notification is valid and mNotificationMonitorSettingsModel.reportValidNotification is false");
        }
        if (isValidNotificationStyle || (notificationManager = (NotificationManager) AppProvider.getApp().getSystemService("notification")) == null) {
            return;
        }
        Logger.m268d("PushMonitorShowService", "[onOthersAppNotification]auto cancel cur invalid notification,tag:" + statusBarNotification.getTag() + " id:" + statusBarNotification.getId());
        notificationManager.cancel(statusBarNotification.getTag(), statusBarNotification.getId());
    }

    private boolean isEmptyNotification(Notification notification) {
        if (notification.extras == null) {
            return false;
        }
        return TextUtils.isEmpty(notification.extras.getString("android.title")) || TextUtils.isEmpty(notification.extras.getString("android.text"));
    }

    public boolean enableMonitorNotificationShow() {
        return NotificationMonitorSettingsModel.getIns().enableMonitorNotificationShow;
    }

    public boolean onForeGroundNotificationShow(ComponentName componentName, Notification notification) {
        NotificationMonitorSettingsModel ins = NotificationMonitorSettingsModel.getIns();
        this.reportedHistory.add(getNotificationIdStr("fore_ground", 0, notification));
        final NotificationEvent notificationEvent = new NotificationEvent(notification, 2, componentName, ins.blackFiledList);
        final boolean isValidNotificationStyle = isValidNotificationStyle(notificationEvent, notification);
        notificationEvent.setStack(getStack());
        if (!isValidNotificationStyle || notificationEvent.isTargetNotification() || ins.reportValidNotification) {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.notification.NotificationShowMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    notificationEvent.setIsValidNotification(isValidNotificationStyle);
                    JSONObject json = notificationEvent.toJson();
                    Logger.m268d("PushMonitorShowService", "[onForeGroundNotificationShow]notificationEvent is " + json);
                    PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_notification_event", json);
                }
            });
        } else {
            Logger.m268d("PushMonitorShowService", "[onForeGroundNotificationShow]not report cur notificationEvent because cur notification is valid and mNotificationMonitorSettingsModel.reportValidNotification is false");
        }
        if (ins.allowInterceptForegroundNotification) {
            return isValidNotificationStyle;
        }
        if (isValidNotificationStyle) {
            return true;
        }
        Logger.m278w("PushMonitorShowService", "[onForeGroundNotificationShow]cur foreground notification is invalid but  allowInterceptForegroundNotification is false,not intercept");
        return true;
    }

    public void onPendingIntent(Object obj, Intent intent) {
        ComponentName component;
        if (intent == null || obj == null) {
            return;
        }
        String str = intent.getPackage();
        if (TextUtils.isEmpty(str) && (component = intent.getComponent()) != null) {
            str = component.getPackageName();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mTargetPkgMap.put(obj, str);
    }

    boolean needInterceptNotificationForTargetText(NotificationEvent notificationEvent, Notification notification) {
        if (notification == null) {
            Logger.m271e("PushMonitorShowService", "[needInterceptNotificationForTargetText]not target notification because cur notification is null");
            return false;
        }
        List<TargetNotificationMonitorModel> list = NotificationMonitorSettingsModel.getIns().targetNotificationMonitorModelList;
        if (list != null && !list.isEmpty()) {
            if (notification.extras != null) {
                String string = notification.extras.getString("android.title");
                String string2 = notification.extras.getString("android.text");
                String string3 = notification.extras.getString("android.bigText");
                String string4 = notification.extras.getString("android.tickerText");
                if (Logger.debug()) {
                    Logger.m268d("PushMonitorShowService", "[needInterceptNotificationForTargetText]title:" + string + " text:" + string2 + " bigText:" + string3 + " tickerText:" + string4);
                }
                for (TargetNotificationMonitorModel targetNotificationMonitorModel : list) {
                    Logger.m268d("PushMonitorShowService", "[needInterceptNotificationForTargetText]try match text with targetTextMonitorModel:" + targetNotificationMonitorModel);
                    if (targetNotificationMonitorModel.matchTarget(string) || targetNotificationMonitorModel.matchTarget(string2) || targetNotificationMonitorModel.matchTarget(string3) || targetNotificationMonitorModel.matchTarget(string4)) {
                        Logger.m268d("PushMonitorShowService", "[needInterceptNotificationForTargetText]cur notification match the targetTextReg,targetTextReg:" + targetNotificationMonitorModel + " title:" + string + " text:" + string2 + " bigText:" + string3 + " tickerText:" + string4);
                        notificationEvent.setBlackFiledList(targetNotificationMonitorModel.blackFiledList);
                        notificationEvent.setTargetNotificationReg(targetNotificationMonitorModel.regText);
                        notificationEvent.setTargetNotification(true);
                        return targetNotificationMonitorModel.needIntercept;
                    }
                }
                Logger.m278w("PushMonitorShowService", "[needInterceptNotificationForTargetText]text not match any targetTextReg");
            } else {
                Logger.m278w("PushMonitorShowService", "[needInterceptNotificationForTargetText]not match target text because notification.extras is null");
            }
        } else {
            Logger.m278w("PushMonitorShowService", "[needInterceptNotificationForTargetText]not match target text because  mNotificationMonitorSettingsModel.targetTextRegList is empty");
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x025e, code lost:
    
        if (r5.toLowerCase().contains("decoratedmediacustomviewstyle") != false) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean isValidNotificationStyle(NotificationEvent notificationEvent, Notification notification) {
        NotificationChannel notificationChannel;
        int i = 0;
        if (notification == null) {
            Logger.m271e("PushMonitorShowService", "[isInvalidNotificationStyle]invalid null notification");
            onNotificationIntercept(notificationEvent, "notification is null");
            return false;
        }
        NotificationMonitorSettingsModel ins = NotificationMonitorSettingsModel.getIns();
        if (!TextUtils.isEmpty(notification.getGroup()) && ins.needInterceptGroup && ins.whiteGroupList != null && !ins.whiteGroupList.contains(notification.getGroup())) {
            Logger.m271e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because group is not null:" + notification.getGroup());
            onNotificationIntercept(notificationEvent, "notification has group");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < notification.when && ins.needInterceptTop) {
            Logger.m271e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because notification#when is in the feature,currentTimeMillis is " + currentTimeMillis + " notification#when is " + notification.when);
            onNotificationIntercept(notificationEvent, "notification want on top");
            return false;
        }
        if ((notification.flags & 2) != 0 && ins.needInterceptStick) {
            Logger.m271e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because notification is want on top with on_going flag,flag is " + notification.flags);
            onNotificationIntercept(notificationEvent, "notification want on going");
            return false;
        }
        if ((notification.flags & 16) == 0 && ins.needInterceptCancelError) {
            Logger.m271e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because notification is not auto_cancel, flag is " + notification.flags);
            onNotificationIntercept(notificationEvent, "notification not auto cancel");
            return false;
        }
        if (ins.needInterceptPendingIntentError) {
            try {
                String contentIntentFromPendingIntent = getContentIntentFromPendingIntent(notification.contentIntent);
                if (!TextUtils.isEmpty(contentIntentFromPendingIntent) && !TextUtils.equals(contentIntentFromPendingIntent, AppProvider.getApp().getPackageName())) {
                    onNotificationIntercept(notificationEvent, "target pendingIntent is others pkg");
                    Logger.m271e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because notification#contentIntent is invalid,targetPkg:" + contentIntentFromPendingIntent);
                    return false;
                }
            } catch (Throwable th) {
                Logger.m271e("PushMonitorShowService", "[isInvalidNotificationStyle]error when parse target intent " + th);
            }
        }
        if (ins.needInterceptStyleList != null && notification.extras != null) {
            String string = notification.extras.getString("android.template");
            if (!TextUtils.isEmpty(string) && ins.needInterceptStyleList.contains(string)) {
                Logger.m271e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because cur template is in  needInterceptStyleList, template is " + string);
                onNotificationIntercept(notificationEvent, "invalid notification style");
                return false;
            }
        }
        int i2 = 1;
        if (ins.interceptStack != null) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            for (List<String> list : ins.interceptStack) {
                if (list.size() > i2) {
                    int length = stackTrace.length;
                    int i3 = i;
                    int i4 = i3;
                    while (i3 < length) {
                        StackTraceElement stackTraceElement = stackTrace[i3];
                        if (i4 == list.size() - 1) {
                            break;
                        }
                        if (TextUtils.equals(stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName() + "#" + stackTraceElement.getLineNumber(), list.get(i4))) {
                            i4++;
                        } else if (i4 > 0) {
                            i4 = 0;
                        }
                        i3++;
                        i2 = 1;
                    }
                }
                i2 = 0;
                if (i2 != 0) {
                    onNotificationIntercept(notificationEvent, "intercept by stack");
                    Logger.m271e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because cur stack match the intercept stack");
                    return false;
                }
                i = 0;
                i2 = 1;
            }
        }
        try {
            NotificationSettings notificationSettings = ((PushOnlineSettings) SettingsManager.obtain(AppProvider.getApp(), PushOnlineSettings.class)).getNotificationSettings();
            if (notificationSettings.enableHarmonyOs4ImportanceAndCategory && Build.VERSION.SDK_INT >= 26 && RomVersionParamHelper.isGreaterThanHarmonyOs4() && notificationSettings.harmonyOs4ImportanceAndCategoryInterceptStrategy == 2) {
                String channelId = notification.getChannelId();
                NotificationManager notificationManager = (NotificationManager) AppProvider.getApp().getSystemService("notification");
                boolean z = notificationManager != null && (notificationChannel = notificationManager.getNotificationChannel(channelId)) != null && notificationChannel.getImportance() > 2 && notification.extras.getInt("push_sdk_harmony_os4_channel_importance_expectation", 5) < notificationChannel.getImportance();
                if (TextUtils.isEmpty(notification.category)) {
                    z = true;
                }
                String string2 = notification.extras.getString("android.template", "");
                if (!string2.toLowerCase().contains("mediastyle")) {
                }
                z = false;
                if (z) {
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        if (needInterceptNotificationForTargetText(notificationEvent, notification)) {
            Logger.m271e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because cur is match target reg");
            onNotificationIntercept(notificationEvent, "target reg notification");
            return false;
        }
        if (!ins.needInterceptEmptyNotification || !isEmptyNotification(notification)) {
            return true;
        }
        Logger.m271e("PushMonitorShowService", "[isInvalidNotificationStyle]notification is invalid because cur is empty notification,intercept it");
        onNotificationIntercept(notificationEvent, "empty notification");
        return false;
    }

    public String getContentIntentFromPendingIntent(PendingIntent pendingIntent) {
        try {
            return this.mTargetPkgMap.get(DoubleReflectUtils.getAccessibleField(IntentSender.class, "mTarget").get(pendingIntent.getIntentSender()));
        } catch (Throwable th) {
            Logger.m272e("PushMonitorShowService", "error when getContentIntentFromPendingIntent ", th);
            return null;
        }
    }

    public void removeContentIntent(PendingIntent pendingIntent) {
        try {
            this.mTargetPkgMap.remove(pendingIntent);
        } catch (Throwable th) {
            Logger.m272e("PushMonitorShowService", "error when removeContentIntent ", th);
        }
    }

    private void onNotificationIntercept(final NotificationEvent notificationEvent, final String str) {
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.notification.NotificationShowMonitor.4
            @Override // java.lang.Runnable
            public void run() {
                JSONObject json = notificationEvent.toJson();
                try {
                    json.put(ISignalReportConstants.KEY_REASON, str);
                } catch (Throwable th) {
                    Logger.m272e("PushMonitorShowService", "error when put reason to params ", th);
                }
                Logger.m268d("PushMonitorShowService", "[onNotificationIntercept]bdpush_notification_intercept_event params is " + json);
                PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_notification_intercept_event", json);
            }
        });
    }

    private String getStack() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            if (TextUtils.equals(stackTraceElement.getClassName(), "android.app.Service") && TextUtils.equals(stackTraceElement.getMethodName(), "startForeground")) {
                sb.append("android.app.Service#startForeground");
            } else if (TextUtils.equals(stackTraceElement.getClassName(), "android.app.NotificationManager") && TextUtils.equals(stackTraceElement.getMethodName(), "notifyAsUser")) {
                sb.append("android.app.NotificationManager#notifyAsUser");
            } else {
                if (z) {
                    sb.append(String.format(" <- %s#%s#%s", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
                }
            }
            z = true;
        }
        return sb.toString();
    }
}
