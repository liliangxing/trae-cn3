package com.bytedance.trae.push.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.push.BDPush;
import com.bytedance.push.BDPushConfiguration;
import com.bytedance.push.PushBody;
import com.bytedance.push.interfaze.IRequestNotificationPermissionCallback;
import com.bytedance.push.interfaze.ISupport;
import com.bytedance.push.notification.PushActivity;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.applog.api.OnGetAppLogIdListener;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.PermissionRationaleDialog;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.IAccountStatusListener;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.push.api.IPushService;
import com.bytedance.trae.push.api.TraeNotificationBody;
import com.bytedance.trae.utils.AppUtils;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* compiled from: IPushServiceImpl.kt */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J*\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\rH\u0016J&\u0010!\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0'H\u0016J\u0006\u0010)\u001a\u00020\bJ\u0018\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010-J\u0010\u0010.\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J$\u0010/\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u000100J\u0010\u0010\u0016\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u000101J\u0006\u00102\u001a\u000203R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u00065"}, d2 = {"Lcom/bytedance/trae/push/impl/IPushServiceImpl;", "Lcom/bytedance/trae/push/api/IPushService;", "<init>", "()V", "callback", "com/bytedance/trae/push/impl/IPushServiceImpl$callback$1", "Lcom/bytedance/trae/push/impl/IPushServiceImpl$callback$1;", "initAndStart", "", "asyncStartPush", "tryStartPush", "notifySessionIdChanged", "getBDPushConfigurationHost", "", "requestNotificationPermissionIfNeededAfterAndroid13", "showNotificationPermissionDialog", "isNotificationPermissionGranted", "", "openSystemNotificationSetting", "applyRedBadgeCount", "count", "", "requestNotificationPermission", "trackClickPush", "context", "Landroid/content/Context;", "pushModel", "isFromNotification", "extra", "Lorg/json/JSONObject;", "onPushClick", PraiseDialogConstant.FROM, "getPushContentType", "showNotification", "intent", "Landroid/content/Intent;", "body", "Lcom/bytedance/trae/push/api/TraeNotificationBody;", "getPushActivityClazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "requestOpNotificationPermission", "requestHwNotificationPermission", ReportConst.KEY_SCENE, "requestResultCallback", "Lcom/bytedance/common/push/interfaze/RequestResultCallback;", "requestMiRemoveVoipNotification", "showNotificationInternal", "Lcom/bytedance/android/service/manager/push/notification/NotificationBody;", "Lcom/bytedance/push/interfaze/IRequestNotificationPermissionCallback;", "getSupportService", "Lcom/bytedance/push/interfaze/ISupport;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IPushServiceImpl implements IPushService {
    private static final long REQUEST_PERMISSION_INTERVAL = 172800000;
    private static final String TAG = "IPushServiceImpl";
    private final IPushServiceImpl$callback$1 callback = new IRequestNotificationPermissionCallback() { // from class: com.bytedance.trae.push.impl.IPushServiceImpl$callback$1
        @Override // com.bytedance.push.interfaze.IRequestNotificationPermissionCallback
        public void onPermissionGranted() {
            FLogger.INSTANCE.mo428i("IPushServiceImpl", "Notification permission granted");
        }

        @Override // com.bytedance.push.interfaze.IRequestNotificationPermissionCallback
        public void onPermissionDenied() {
            FLogger.INSTANCE.mo428i("IPushServiceImpl", "Notification permission denied");
            PushHelper.INSTANCE.setLastRequestNotificationPermissionTimestamp(System.currentTimeMillis());
        }
    };

    /* compiled from: IPushServiceImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccountStatus.values().length];
            try {
                iArr[AccountStatus.LOGGED_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AccountStatus.LOGGED_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.trae.push.api.IPushService
    public void initAndStart() {
        BDPush.getPushService().onAttachBaseContext(AppHost.Companion.getApplication());
        BDPush.getPushService().initOnApplication(new BDPushConfiguration(getBDPushConfigurationHost()));
        if (AppUtils.isMainProcess(AppHost.Companion.getApplication())) {
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            boolean z = false;
            if (iLoginService != null && iLoginService.isTraeLoggedIn()) {
                z = true;
            }
            if (z) {
                tryStartPush();
            }
            ILoginService iLoginService2 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            if (iLoginService2 != null) {
                ILoginService.DefaultImpls.registerAccountStatusChangeListener$default(iLoginService2, new IAccountStatusListener() { // from class: com.bytedance.trae.push.impl.IPushServiceImpl$$ExternalSyntheticLambda0
                    @Override // com.bytedance.trae.login.api.IAccountStatusListener
                    public final void onAccountStatusChanged(AccountStatus accountStatus, String str) {
                        IPushServiceImpl.initAndStart$lambda$0(IPushServiceImpl.this, accountStatus, str);
                    }
                }, null, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAndStart$lambda$0(IPushServiceImpl iPushServiceImpl, AccountStatus accountStatus, String str) {
        Intrinsics.checkNotNullParameter(accountStatus, "status");
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        int i = WhenMappings.$EnumSwitchMapping$0[accountStatus.ordinal()];
        if (i == 1) {
            iPushServiceImpl.tryStartPush();
            iPushServiceImpl.notifySessionIdChanged();
        } else {
            if (i != 2) {
                return;
            }
            iPushServiceImpl.notifySessionIdChanged();
        }
    }

    @Override // com.bytedance.trae.push.api.IPushService
    public void asyncStartPush() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new IPushServiceImpl$asyncStartPush$1(this, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryStartPush() {
        String deviceId = IApplog.Companion.getDeviceId();
        String installId = IApplog.Companion.getInstallId();
        String ssid = IApplog.Companion.getSsid();
        if (deviceId.length() > 0) {
            BDPush.getPushService().start(deviceId, installId, ssid);
            PushEventManager.INSTANCE.reportPushEventWhenColdStart();
        } else {
            IApplog.Companion.addGetAppLogIdListener(new OnGetAppLogIdListener() { // from class: com.bytedance.trae.push.impl.IPushServiceImpl$tryStartPush$1
                public void onGetId(String did, String iid, String ssid2) {
                    Intrinsics.checkNotNullParameter(did, CommonConstants.KEY_DEVICE_ID);
                    Intrinsics.checkNotNullParameter(iid, "iid");
                    Intrinsics.checkNotNullParameter(ssid2, "ssid");
                    IApplog.Companion.removeDidListener(this);
                    BDPush.getPushService().start(did, iid, ssid2);
                    PushEventManager.INSTANCE.reportPushEventWhenColdStart();
                }
            });
        }
    }

    private final void notifySessionIdChanged() {
        FrontierSessionUpdater.INSTANCE.notifySessionIdChanged();
    }

    private final String getBDPushConfigurationHost() {
        return AppHost.Companion.isOversea() ? "https://ug-normal.trae.ai" : "https://api.trae.cn";
    }

    private final void requestNotificationPermissionIfNeededAfterAndroid13() {
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("requestNotificationPermissionIfNeededAfterAndroid13 called, isPushInit=");
        com.bytedance.push.interfaze.IPushService pushService = BDPush.getPushService();
        fLogger.mo428i(TAG, sb.append(pushService != null ? Boolean.valueOf(pushService.isPushInit()) : null).append(", notificationEnabled=").append(PushHelper.INSTANCE.isNotificationEnabled(AppHost.Companion.getApplication())).append(", permanentlyDenied=").append(PushHelper.INSTANCE.isNotificationPermissionPermanentlyDenied()).toString());
        com.bytedance.push.interfaze.IPushService pushService2 = BDPush.getPushService();
        boolean z = false;
        if (pushService2 != null && pushService2.isPushInit()) {
            z = true;
        }
        if (!z || PushHelper.INSTANCE.isNotificationEnabled(AppHost.Companion.getApplication()) || PushHelper.INSTANCE.isNotificationPermissionPermanentlyDenied()) {
            return;
        }
        long lastRequestNotificationPermissionTimestamp = PushHelper.INSTANCE.getLastRequestNotificationPermissionTimestamp();
        long currentTimeMillis = System.currentTimeMillis() - lastRequestNotificationPermissionTimestamp;
        FLogger.INSTANCE.mo428i(TAG, "requestNotificationPermission interval check: elapsed=" + currentTimeMillis + ", required=172800000");
        if (lastRequestNotificationPermissionTimestamp <= 0 || currentTimeMillis > REQUEST_PERMISSION_INTERVAL) {
            try {
                FLogger.INSTANCE.mo428i(TAG, "Try request Notification Permission After Android13");
                showNotificationPermissionDialog();
            } catch (Exception e) {
                FLogger.INSTANCE.mo426e(TAG, "requestNotificationPermissionIfNeededAfterAndroid13 e : " + e.getMessage());
            }
        }
    }

    private final void showNotificationPermissionDialog() {
        Activity currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        PermissionRationaleDialog.Companion.showForNotification(currentActivity, com.bytedance.trae.common_ui.R.drawable.trae_ic_permission_notification, C0882R.string.trae_permission_notification_title, C0882R.string.trae_permission_notification_message, C0882R.string.trae_permission_allow, C0882R.string.trae_permission_deny, C0882R.string.trae_permission_deny_permanently, new Function0() { // from class: com.bytedance.trae.push.impl.IPushServiceImpl$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit showNotificationPermissionDialog$lambda$1;
                showNotificationPermissionDialog$lambda$1 = IPushServiceImpl.showNotificationPermissionDialog$lambda$1(IPushServiceImpl.this);
                return showNotificationPermissionDialog$lambda$1;
            }
        }, new Function0() { // from class: com.bytedance.trae.push.impl.IPushServiceImpl$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit showNotificationPermissionDialog$lambda$2;
                showNotificationPermissionDialog$lambda$2 = IPushServiceImpl.showNotificationPermissionDialog$lambda$2();
                return showNotificationPermissionDialog$lambda$2;
            }
        }, new Function0() { // from class: com.bytedance.trae.push.impl.IPushServiceImpl$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit showNotificationPermissionDialog$lambda$3;
                showNotificationPermissionDialog$lambda$3 = IPushServiceImpl.showNotificationPermissionDialog$lambda$3();
                return showNotificationPermissionDialog$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNotificationPermissionDialog$lambda$1(IPushServiceImpl iPushServiceImpl) {
        PushHelper.INSTANCE.setLastRequestNotificationPermissionTimestamp(System.currentTimeMillis());
        com.bytedance.push.interfaze.IPushService pushService = BDPush.getPushService();
        if (pushService != null) {
            pushService.requestNotificationPermission(iPushServiceImpl.callback);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNotificationPermissionDialog$lambda$2() {
        PushHelper.INSTANCE.setLastRequestNotificationPermissionTimestamp(System.currentTimeMillis());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNotificationPermissionDialog$lambda$3() {
        PushHelper.INSTANCE.setNotificationPermissionPermanentlyDenied(true);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.push.api.IPushService
    public boolean isNotificationPermissionGranted() {
        return PushHelper.INSTANCE.isNotificationEnabled(AppHost.Companion.getApplication());
    }

    @Override // com.bytedance.trae.push.api.IPushService
    public void openSystemNotificationSetting() {
        PushHelper.INSTANCE.openSysPushSettingPage(AppHost.Companion.getApplication());
    }

    @Override // com.bytedance.trae.push.api.IPushService
    public void applyRedBadgeCount(int count) {
        PushServiceManager.get().getIRedBadgeExternalService().applyCount(AppHost.Companion.getApplication(), count);
    }

    @Override // com.bytedance.trae.push.api.IPushService
    public void requestNotificationPermission() {
        FLogger.INSTANCE.mo428i(TAG, "requestNotificationPermission called, SDK_INT=" + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= 33) {
            requestNotificationPermissionIfNeededAfterAndroid13();
        } else {
            if (!DeviceUtils.isOppo() || Build.VERSION.SDK_INT >= 33) {
                return;
            }
            requestOpNotificationPermission();
        }
    }

    @Override // com.bytedance.trae.push.api.IPushService
    public void trackClickPush(Context context, String pushModel, boolean isFromNotification, JSONObject extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extra, "extra");
        if (pushModel == null) {
            return;
        }
        PushBody pushBody = new PushBody(new JSONObject(pushModel));
        JSONObject jSONObject = pushBody.eventExtra;
        if (jSONObject != null) {
            extra.put("ttpush_event_extra", jSONObject);
        }
        BDPush.getPushService().trackClickPush(context, pushBody, isFromNotification, extra);
    }

    @Override // com.bytedance.trae.push.api.IPushService
    public void onPushClick(String pushModel, int from) {
        if (pushModel == null) {
            return;
        }
        PushEventManager.INSTANCE.onPushClick(new PushBody(new JSONObject(pushModel)), from);
    }

    @Override // com.bytedance.trae.push.api.IPushService
    public String getPushContentType() {
        return PushEventManager.INSTANCE.getPushContentType();
    }

    @Override // com.bytedance.trae.push.api.IPushService
    public boolean showNotification(Context context, Intent intent, TraeNotificationBody body) {
        return showNotificationInternal(context, intent, body != null ? PushUtilsKt.transToNotificationBody(body) : null);
    }

    @Override // com.bytedance.trae.push.api.IPushService
    public Class<? extends Activity> getPushActivityClazz() {
        return PushActivity.class;
    }

    public final void requestOpNotificationPermission() {
        com.bytedance.push.interfaze.IPushService pushService = BDPush.getPushService();
        boolean z = false;
        if (pushService != null && pushService.isPushInit()) {
            z = true;
        }
        if (z) {
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new IPushServiceImpl$requestOpNotificationPermission$1(null), 2, (Object) null);
        }
    }

    public final void requestHwNotificationPermission(String scene, RequestResultCallback requestResultCallback) {
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        BDPush.getPushService().requestHwNotificationPermission(scene, requestResultCallback);
    }

    public final boolean requestMiRemoveVoipNotification(Context context) {
        return BDPush.getPushService().requestMiRemoveVoipNotification(context);
    }

    public final boolean showNotificationInternal(Context context, Intent intent, NotificationBody body) {
        return BDPush.getPushService().showNotification(context, intent, body);
    }

    public final boolean requestNotificationPermission(IRequestNotificationPermissionCallback callback) {
        return BDPush.getPushService().requestNotificationPermission(callback);
    }

    public final ISupport getSupportService() {
        ISupport supportService = BDPush.getPushService().getSupportService();
        Intrinsics.checkNotNullExpressionValue(supportService, "getSupportService(...)");
        return supportService;
    }
}
