package com.bytedance.push.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.helper.EnsureExceptionHelper;
import com.bytedance.push.interfaze.IPushNotificationManagerService;
import com.bytedance.push.interfaze.IRequestNotificationPermissionCallback;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.notification.NotificationChannelSerializable;
import com.bytedance.push.settings.notification.NotificationMonitorSettingsModel;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AnrOptManager;
import com.ss.android.message.util.ToolUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushNotificationManager implements IPushNotificationManagerService, MethodInvokeProxy, Observer {
    private Context mContext;
    private boolean mEnableMonitorChannelCreate;
    private boolean mEnableMonitorNotificationShow;
    private boolean mHarmonOs4CategoryAndImportance;
    private boolean mHasPoppedNotificationPermissionPopup;
    private IRequestNotificationPermissionCallback mIRequestNotificationPermissionCallback;
    private boolean mIsAndroid13;
    private boolean mIsTarget33;
    private boolean mNeedHookNotificationManager;
    private List<NotificationChannelRecord> mNotificationChannelRecordsNeedToCreateAfterAllowPopUp;
    private Map<String, NotificationChannelSerializable> mNotificationChannelSerializableMap;
    private final String TAG = "PushNotificationManager";
    private final int OS_API_33 = 33;
    private final int PERMISSION_STATUS_UNKNOWN = 0;
    private final int PERMISSION_STATUS_REQUESTING = 1;
    private final int PERMISSION_STATUS_GRANTED = 1;
    private final int PERMISSION_STATUS_DENIED = 3;
    private int mNotificationPermissionStatus = 0;
    private final Object notificationChannelSerializableMapLock = new Object();
    private final AtomicBoolean mHasHookNotificationManager = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class NotificationManagerHandler implements InvocationHandler {
        private Object mBase;
        private MethodInvokeProxy mMethodInvokeProxy;

        public NotificationManagerHandler(Object obj, MethodInvokeProxy methodInvokeProxy) {
            this.mBase = obj;
            this.mMethodInvokeProxy = methodInvokeProxy;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return this.mMethodInvokeProxy.proxyMethodInvoke(this.mBase, method, objArr);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static class NotificationChannelRecord {
        private Object[] args;
        private Object base;
        private Method method;

        public NotificationChannelRecord(Object obj, Method method, Object[] objArr) {
            this.base = obj;
            this.method = method;
            this.args = objArr;
        }

        public void invoke() {
            try {
                this.method.invoke(this.base, this.args);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.push.interfaze.IPushNotificationManagerService
    public void init(Context context) {
        this.mContext = context;
        this.mIsTarget33 = context.getApplicationInfo().targetSdkVersion >= 33;
        this.mIsAndroid13 = Build.VERSION.SDK_INT >= 33;
        this.mNotificationChannelRecordsNeedToCreateAfterAllowPopUp = new ArrayList();
        if (this.mIsAndroid13) {
            AppStatusObserverForChildProcess.getIns().addObserver(this);
        }
        AnrOptManager.postRunnable(new Runnable() { // from class: com.bytedance.push.notification.PushNotificationManager.1
            @Override // java.lang.Runnable
            public void run() {
                PushNotificationManager.this.initConfig();
                if (PushNotificationManager.this.mNeedHookNotificationManager) {
                    Logger.m268d("PushNotificationManager", "start hook NotificationManager");
                    PushNotificationManager.this.hookNotificationManager();
                    NotificationShowMonitor.inst().init();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initConfig() {
        this.mEnableMonitorChannelCreate = ((PushOnlineSettings) SettingsManager.obtain(this.mContext, PushOnlineSettings.class)).enableMonitorChannelCreate();
        this.mHarmonOs4CategoryAndImportance = ((PushOnlineSettings) SettingsManager.obtain(this.mContext, PushOnlineSettings.class)).getNotificationSettings().enableHarmonyOs4ImportanceAndCategory;
        this.mHasPoppedNotificationPermissionPopup = getLocalSettings().hasPoppedNotificationPermissionPopup();
        boolean z = NotificationMonitorSettingsModel.getIns().enableMonitorNotificationShow;
        this.mEnableMonitorNotificationShow = z;
        this.mNeedHookNotificationManager = this.mIsAndroid13 || this.mEnableMonitorChannelCreate || z || this.mHarmonOs4CategoryAndImportance;
    }

    private LocalSettings getLocalSettings() {
        return (LocalSettings) SettingsManager.obtain(this.mContext, LocalSettings.class);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (!((Boolean) obj).booleanValue() && this.mIsAndroid13 && this.mIsTarget33 && getLocalSettings().needPopNotificationPermissionPopupAfterForeground() && dynamicRequestNotificationPermission()) {
            getLocalSettings().setNeedPopNotificationPermissionPopupAfterForeground(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hookNotificationManager() {
        try {
            if (this.mHasHookNotificationManager.getAndSet(true)) {
                return;
            }
            Class<?> cls = Class.forName("android.app.NotificationManager");
            Field declaredField = cls.getDeclaredField("sService");
            declaredField.setAccessible(true);
            cls.getDeclaredMethod("getService", new Class[0]).invoke(null, new Object[0]);
            declaredField.set(null, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName("android.app.INotificationManager")}, new NotificationManagerHandler(declaredField.get(null), this)));
            Logger.m268d("PushNotificationManager", "success hook NotificationManager");
        } catch (Throwable th) {
            Logger.m271e("PushNotificationManager", "error when hook NotificationManager:" + th.getMessage());
            EnsureExceptionHelper.ensureNotReachHere(th, "error when hook NotificationManager");
        }
    }

    private boolean dynamicRequestNotificationPermission() {
        if (ContextCompat.checkSelfPermission(this.mContext, IPushNotificationManagerService.PERMISSTION_POST_NOTIFICATIONS) == 0) {
            Logger.m268d("PushNotificationManager", "dynamicRequestNotificationPermission:cur has permission, do nothing");
            return false;
        }
        if (ActivityLifecycleObserver.getIns().isBackGround()) {
            Logger.m268d("PushNotificationManager", "dynamicRequestNotificationPermission:cur is in background,do nothing");
            return false;
        }
        Activity topActivity = ActivityLifecycleObserver.getIns().getTopActivity();
        if (topActivity != null) {
            Logger.m268d("PushNotificationManager", "dynamicRequestNotificationPermission:cur not has permission, start request permission");
            ActivityCompat.requestPermissions(topActivity, new String[]{IPushNotificationManagerService.PERMISSTION_POST_NOTIFICATIONS}, IPushNotificationManagerService.REQUEST_CODE_POST_NOTIFICATIONS);
            return true;
        }
        Logger.m268d("PushNotificationManager", "dynamicRequestNotificationPermission:topActivity is null,do nothing");
        return false;
    }

    @Override // com.bytedance.push.notification.MethodInvokeProxy
    public Object proxyMethodInvoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        Logger.m268d("PushNotificationManager", "proxyMethodInvoke:" + method.getName());
        if (Build.VERSION.SDK_INT >= 26) {
            if (TextUtils.equals(method.getName(), IPushNotificationManagerService.METHD_NAME_CREATE_NOTIFICATION_CHANNELS)) {
                if (this.mEnableMonitorChannelCreate) {
                    try {
                        Object obj2 = objArr[1];
                        for (NotificationChannel notificationChannel : (List) obj2.getClass().getDeclaredMethod("getList", new Class[0]).invoke(obj2, new Object[0])) {
                            Logger.m268d("PushNotificationManager", "create channel:" + notificationChannel.getId() + " " + ((Object) notificationChannel.getName()));
                            PushSupporter.get().getMonitor().monitorNotificationCreate(notificationChannel);
                        }
                    } catch (Throwable th) {
                        Logger.m272e("PushNotificationManager", "error when parse notification channel ", th);
                    }
                }
                if (this.mIsAndroid13) {
                    boolean autoRequestNotificationPermission = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.autoRequestNotificationPermission();
                    if (this.mIsTarget33) {
                        if (autoRequestNotificationPermission && !dynamicRequestNotificationPermission()) {
                            getLocalSettings().setNeedPopNotificationPermissionPopupAfterForeground(true);
                        }
                    } else if (autoRequestNotificationPermission) {
                        Logger.m268d("PushNotificationManager", "app allow request notification permission automatically, do nothing");
                    } else if (ToolUtils.areNotificationsEnabled(this.mContext) != 1 && !ToolUtils.hasCreatedNotificationChannel(this.mContext) && !this.mHasPoppedNotificationPermissionPopup) {
                        Logger.m268d("PushNotificationManager", "app not has popped notification permission popup,so block channel create until app allow popup permission request");
                        try {
                            Object obj3 = objArr[1];
                            List<NotificationChannel> list = (List) obj3.getClass().getDeclaredMethod("getList", new Class[0]).invoke(obj3, new Object[0]);
                            synchronized (this.notificationChannelSerializableMapLock) {
                                if (this.mNotificationChannelSerializableMap == null) {
                                    this.mNotificationChannelSerializableMap = getLocalSettings().getNeedToCreateChannelsAfterAllowPopup();
                                }
                                for (NotificationChannel notificationChannel2 : list) {
                                    Logger.m268d("PushNotificationManager", "add <" + notificationChannel2.getId() + "," + ((Object) notificationChannel2.getName()) + "> to cache after app allow pop permission request window");
                                    if (!this.mNotificationChannelSerializableMap.containsKey(notificationChannel2.getId())) {
                                        this.mNotificationChannelSerializableMap.put(notificationChannel2.getId(), new NotificationChannelSerializable(notificationChannel2));
                                    }
                                }
                                getLocalSettings().setNeedToCreateChannelsAfterAllowPopup(this.mNotificationChannelSerializableMap);
                            }
                        } catch (Throwable th2) {
                            Logger.m272e("PushNotificationManager", "error when parse notification channel ", th2);
                        }
                        return null;
                    }
                }
            } else if (TextUtils.equals(method.getName(), IPushNotificationManagerService.METHOD_NAME_NOTIFY_NOTIFICATION) && (this.mEnableMonitorNotificationShow || this.mHarmonOs4CategoryAndImportance)) {
                try {
                    if (!NotificationShowMonitor.inst().onNotificationShow((String) objArr[2], ((Integer) objArr[3]).intValue(), (Notification) objArr[4])) {
                        return null;
                    }
                } catch (Throwable th3) {
                    Logger.m272e("PushNotificationManager", "try  call monitor empty method in proxy error: ", th3);
                }
            }
        }
        return method.invoke(obj, objArr);
    }

    @Override // com.bytedance.push.interfaze.IPushNotificationManagerService
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 61519 || strArr == null || strArr.length <= 0 || !TextUtils.equals(strArr[0], IPushNotificationManagerService.PERMISSTION_POST_NOTIFICATIONS)) {
            return;
        }
        if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
            Logger.m268d("PushNotificationManager", "user granted post notification permission");
            this.mNotificationPermissionStatus = 1;
            IRequestNotificationPermissionCallback iRequestNotificationPermissionCallback = this.mIRequestNotificationPermissionCallback;
            if (iRequestNotificationPermissionCallback != null) {
                iRequestNotificationPermissionCallback.onPermissionGranted();
                return;
            }
            return;
        }
        Logger.m268d("PushNotificationManager", "user denied post notification permission");
        this.mNotificationPermissionStatus = 3;
        IRequestNotificationPermissionCallback iRequestNotificationPermissionCallback2 = this.mIRequestNotificationPermissionCallback;
        if (iRequestNotificationPermissionCallback2 != null) {
            iRequestNotificationPermissionCallback2.onPermissionDenied();
        }
    }

    @Override // com.bytedance.push.interfaze.IPushNotificationManagerService
    public boolean requestNotificationPermission() {
        return requestNotificationPermission(null);
    }

    @Override // com.bytedance.push.interfaze.IPushNotificationManagerService
    public boolean requestNotificationPermission(IRequestNotificationPermissionCallback iRequestNotificationPermissionCallback) {
        if (!this.mIsAndroid13) {
            Logger.m278w("PushNotificationManager", "cur is not android13，needn't invoke requestNotificationPermission");
            return false;
        }
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.autoRequestNotificationPermission()) {
            Logger.m278w("PushNotificationManager", "autoRequestNotificationPermission is true, request permission automatically，needn't invoke requestNotificationPermission");
            return false;
        }
        this.mIRequestNotificationPermissionCallback = iRequestNotificationPermissionCallback;
        if (this.mIsTarget33) {
            return dynamicRequestNotificationPermission();
        }
        if (this.mHasPoppedNotificationPermissionPopup) {
            Logger.m268d("PushNotificationManager", "has popped notification permission popup,do nothing");
            return false;
        }
        this.mHasPoppedNotificationPermissionPopup = true;
        synchronized (this.notificationChannelSerializableMapLock) {
            if (this.mNotificationChannelSerializableMap == null) {
                this.mNotificationChannelSerializableMap = getLocalSettings().getNeedToCreateChannelsAfterAllowPopup();
            }
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
            if (this.mNotificationChannelSerializableMap.size() > 0) {
                Logger.m268d("PushNotificationManager", "create channel of mNotificationChannelSerializableMap for popup");
                Iterator<Map.Entry<String, NotificationChannelSerializable>> it = this.mNotificationChannelSerializableMap.entrySet().iterator();
                while (it.hasNext()) {
                    notificationManager.createNotificationChannel(it.next().getValue().getNotificationChannel());
                }
            } else {
                Logger.m268d("PushNotificationManager", "create default channel for popup");
                PushSupporter.get().getNotificationService().createDefaultChannel(this.mContext);
            }
            getLocalSettings().setHasPoppedNotificationPermissionPopup(true);
            return true;
        }
    }
}
