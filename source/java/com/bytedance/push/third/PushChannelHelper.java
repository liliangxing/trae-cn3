package com.bytedance.push.third;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.permission.boot.IOriginSysDialog;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.push.Configuration;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.interfaze.ITokenService;
import com.bytedance.push.third.pushchannelsupport.AvalilablePushChannelSupportHelper;
import com.bytedance.push.third.pushchannelsupport.ConfigAvailableChannelSupportHelper;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushChannelHelper extends BaseChannelHelper {
    public static final int ADM_PUSH = 14;
    public static final int FCM_PUSH = 5;
    public static final int HONOR_PUSH = 22;
    public static final int HW_PUSH = 7;
    public static final int MATRIX_PUSH = 26;
    public static final int MI_PUSH = 1;
    public static final int MZ_PUSH = 8;
    public static final int OP_PUSH = 10;
    public static final int SMT_PUSH = 16;
    public static final int UM_PUSH = 6;
    public static final int UNKNOWN = -1;
    public static final int VV_PUSH = 11;
    private static volatile PushChannelHelper sPushChannelHelper;
    private final String TAG = "PushChannelHelper";
    private BasePushAdapter curSysPushAdapter;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public @interface PushType {
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public int getTryRegisterChannelId() {
        return 6;
    }

    public boolean isDirectOpenActivitySender(int i) {
        return i == 10 || i == 16 || i == 7 || i == 11 || i == 20 || i == 22 || i == 26;
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public boolean isNeedUnzip(int i) {
        return i == 11;
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public /* bridge */ /* synthetic */ JSONArray buildApplogHeader() {
        return super.buildApplogHeader();
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public /* bridge */ /* synthetic */ IPushAdapter getAdapterInstance(int i) {
        return super.getAdapterInstance(i);
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public /* bridge */ /* synthetic */ int getChannelId(String str) {
        return super.getChannelId(str);
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public /* bridge */ /* synthetic */ Set getChannels() {
        return super.getChannels();
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public /* bridge */ /* synthetic */ String getSenderNameById(int i) {
        return super.getSenderNameById(i);
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public /* bridge */ /* synthetic */ boolean hasSupportChannel(String str) {
        return super.hasSupportChannel(str);
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public /* bridge */ /* synthetic */ boolean isLocalSupportChannel(int i) {
        return super.isLocalSupportChannel(i);
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public /* bridge */ /* synthetic */ boolean needDisableWhenStrictMode(int i) {
        return super.needDisableWhenStrictMode(i);
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public /* bridge */ /* synthetic */ boolean requestNotificationPermissionBySysAlertForOp() {
        return super.requestNotificationPermissionBySysAlertForOp();
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public /* bridge */ /* synthetic */ void resetPushChannels() {
        super.resetPushChannels();
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public boolean isSysChannel(int i) {
        if (i == 7 || i == 10 || i == 11) {
            return true;
        }
        return (i == 1 && ToolUtils.isMiui()) || i == 22 || i == 26;
    }

    public static PushChannelHelper inst(Context context) {
        if (sPushChannelHelper == null) {
            synchronized (PushChannelHelper.class) {
                if (sPushChannelHelper == null) {
                    sPushChannelHelper = new PushChannelHelper(context);
                }
            }
        }
        return sPushChannelHelper;
    }

    private PushChannelHelper(Context context) {
        AppProvider.initApp((Application) context.getApplicationContext());
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    protected void initChannels() {
        if (this.mPushChannelMap.size() == 0) {
            super.initChannels();
            Application app = AppProvider.getApp();
            this.mPushChannelMap.put(1, new PushChannel(1, "com.xm.MiPushAdapter", "xm/MiPush", new ConfigAvailableChannelSupportHelper(app)));
            this.mPushChannelMap.put(6, new PushChannel(6, "com.um.UmPushAdapter", "um", new AvalilablePushChannelSupportHelper(app)));
            this.mPushChannelMap.put(7, new PushChannel(7, "com.hw.HWPushAdapter", "hw", new AvalilablePushChannelSupportHelper(app)));
            this.mPushChannelMap.put(8, new PushChannel(8, "com.mz.MzPushAdapter", "mz", new ConfigAvailableChannelSupportHelper(app)));
            this.mPushChannelMap.put(10, new PushChannel(10, "com.coloros.OpPushAdapter", "op", new ConfigAvailableChannelSupportHelper(app)));
            this.mPushChannelMap.put(11, new PushChannel(11, "com.vv.VvPushAdapter", "vv", new AvalilablePushChannelSupportHelper(app)));
            this.mPushChannelMap.put(16, new PushChannel(16, "com.smt.SmtPushAdapter", "SmtPush", new AvalilablePushChannelSupportHelper(app)));
            this.mPushChannelMap.put(5, new PushChannel(5, "com.fcm.FcmPushAdapter", "fcm", new AvalilablePushChannelSupportHelper(app)));
            this.mPushChannelMap.put(14, new PushChannel(14, "com.adm.push.AdmPushAdapter", "amazon", new AvalilablePushChannelSupportHelper(AppProvider.getApp())));
            this.mPushChannelMap.put(22, new PushChannel(22, "com.honor.HonorPushAdapter", "honorPush", new AvalilablePushChannelSupportHelper(app)));
            this.mPushChannelMap.put(23, new PushChannel(23, "com.um.mini.UmPushAdapter", "um_mini", new AvalilablePushChannelSupportHelper(app)));
            this.mPushChannelMap.put(26, new PushChannel(26, "com.matrix.MatrixPushAdapter", "matrix", new AvalilablePushChannelSupportHelper(app)));
        }
    }

    public static boolean isMiPushAvailable() {
        initAllowPushSet();
        return mAllowPushSet.contains(1);
    }

    public static boolean isUmPushAvailable() {
        initAllowPushSet();
        return mAllowPushSet.contains(6);
    }

    public static boolean isHWPushAvailable() {
        return mAllowPushSet.contains(7);
    }

    public static boolean isMZPushAvailable() {
        initAllowPushSet();
        return mAllowPushSet.contains(8);
    }

    @Deprecated
    public static boolean isAliYunPushAvailable() {
        initAllowPushSet();
        return false;
    }

    public static boolean isOpPushAvailable() {
        initAllowPushSet();
        return mAllowPushSet.contains(10);
    }

    public static boolean isVivoPushAvailable() {
        initAllowPushSet();
        return mAllowPushSet.contains(11);
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public void setPushTokenListener(IPushService.PushTokenCallback pushTokenCallback, int i) {
        IPushAdapter adapterInstance = inst(AppProvider.getApp()).getAdapterInstance(i);
        if (adapterInstance == null || !(adapterInstance instanceof ITokenService)) {
            return;
        }
        ((ITokenService) adapterInstance).setPushTokenListener(pushTokenCallback);
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public Pair<String, String> getPushConfig(int i, Configuration configuration) {
        Logger.m274i("PushChannelHelper", "[getPushConfig]pushType:" + i + " configuration:" + configuration + " mKeyConfiguration:" + ((Object) (configuration == null ? "null configuration" : configuration.mKeyConfiguration)));
        if (i == 1) {
            return configuration.mKeyConfiguration.getMiPushConfig();
        }
        if (i == 8) {
            return configuration.mKeyConfiguration.getMzPushConfig();
        }
        if (i == 10) {
            return configuration.mKeyConfiguration.getOpPushConfig();
        }
        if (i == 26) {
            return configuration.mKeyConfiguration.getMatrixPushConfig();
        }
        return null;
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public void requestNotificationPermissionByBusinessAlert(String str, RequestResultCallback requestResultCallback) {
        requestNotificationPermissionByBusinessAlert(str, null, true, requestResultCallback);
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public String getCurBusinessSysAlertTypeForCustomDialog() {
        Logger.m268d("PushChannelHelper", "[getCurBusinessSysAlertType]");
        int curBusinessSysAlertType = getCurBusinessSysAlertType(AppProvider.getApp(), true);
        return curBusinessSysAlertType != 7 ? curBusinessSysAlertType != 11 ? curBusinessSysAlertType != 22 ? "unknown" : "honor" : "vv" : "hms";
    }

    private int getCurBusinessSysAlertType(Context context, boolean z) {
        Object adapterInstance = getAdapterInstance(10);
        if (adapterInstance instanceof BasePushAdapter) {
            String isBusinessAlertDialogAvailable = ((BasePushAdapter) adapterInstance).isBusinessAlertDialogAvailable(context, z);
            Logger.m268d("PushChannelHelper", "[getCurBusinessSysAlertType]op businessAlertDialogAvailable:" + isBusinessAlertDialogAvailable);
            if (TextUtils.equals(isBusinessAlertDialogAvailable, "1")) {
                return 10;
            }
        }
        Object adapterInstance2 = inst(context).getAdapterInstance(22);
        if (adapterInstance2 instanceof BasePushAdapter) {
            String isBusinessAlertDialogAvailable2 = ((BasePushAdapter) adapterInstance2).isBusinessAlertDialogAvailable(context, z);
            Logger.m268d("PushChannelHelper", "[getCurBusinessSysAlertType]honor businessAlertDialogAvailable:" + isBusinessAlertDialogAvailable2);
            if (TextUtils.equals(isBusinessAlertDialogAvailable2, "1")) {
                return 22;
            }
        }
        Object adapterInstance3 = inst(context).getAdapterInstance(7);
        if (adapterInstance3 instanceof BasePushAdapter) {
            String isBusinessAlertDialogAvailable3 = ((BasePushAdapter) adapterInstance3).isBusinessAlertDialogAvailable(context, z);
            Logger.m268d("PushChannelHelper", "[getCurBusinessSysAlertType]hw businessAlertDialogAvailable:" + isBusinessAlertDialogAvailable3);
            if (TextUtils.equals(isBusinessAlertDialogAvailable3, "1")) {
                return 7;
            }
        }
        Object adapterInstance4 = inst(context).getAdapterInstance(11);
        if (!(adapterInstance4 instanceof BasePushAdapter)) {
            return -1;
        }
        String isBusinessAlertDialogAvailable4 = ((BasePushAdapter) adapterInstance4).isBusinessAlertDialogAvailable(context, z);
        Logger.m268d("PushChannelHelper", "[getCurBusinessSysAlertType]vv businessAlertDialogAvailable:" + isBusinessAlertDialogAvailable4);
        return TextUtils.equals(isBusinessAlertDialogAvailable4, "1") ? 11 : -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.push.third.BaseChannelHelper
    public synchronized void requestNotificationPermissionByBusinessAlert(final String str, View view, boolean z, final RequestResultCallback requestResultCallback) {
        Logger.m268d("PushChannelHelper", "[requestNotificationPermissionByBusinessAlert]customDialogView:" + view);
        Application app = AppProvider.getApp();
        boolean z2 = true;
        if (ToolUtils.areNotificationsEnabled(app) == 1) {
            Logger.m278w("PushChannelHelper", "[requestNotificationPermissionByBusinessAlert]return false because notification are enabled status");
            requestResultCallback.onRequestResult(false, "notification are enabled");
            return;
        }
        Application app2 = AppProvider.getApp();
        if (view == null) {
            z2 = false;
        }
        final int curBusinessSysAlertType = getCurBusinessSysAlertType(app2, z2);
        if (-1 == curBusinessSysAlertType) {
            Logger.m278w("PushChannelHelper", "[requestNotificationPermissionByBusinessAlert]return false because curBusinessSysAlertType is unknown");
            requestResultCallback.onRequestResult(false, "unknown curBusinessSysAlertType");
            return;
        }
        final IPushAdapter adapterInstance = inst(app).getAdapterInstance(curBusinessSysAlertType);
        if (adapterInstance instanceof BasePushAdapter) {
            try {
                BasePushAdapter basePushAdapter = (BasePushAdapter) adapterInstance;
                this.curSysPushAdapter = basePushAdapter;
                if (view == null) {
                    basePushAdapter.requestNotificationPermission(str, curBusinessSysAlertType, 0, requestResultCallback);
                } else {
                    PushServiceManager.get().getIPermissionBootExternalService().requestNotificationPermissionByBusinessAlert(str, view, z, new IOriginSysDialog() { // from class: com.bytedance.push.third.PushChannelHelper.1
                        public void showOriginSysDialog(Activity activity, RequestResultCallback requestResultCallback2) {
                            ((BasePushAdapter) adapterInstance).requestNotificationPermission(str, curBusinessSysAlertType, 1, requestResultCallback2);
                        }

                        public int getPushType() {
                            return ((BasePushAdapter) adapterInstance).getPushType();
                        }

                        public void onRequestResult(boolean z3, String str2) {
                            RequestResultCallback requestResultCallback2 = requestResultCallback;
                            if (requestResultCallback2 != null) {
                                requestResultCallback2.onRequestResult(z3, str2);
                            }
                        }

                        public void onUserAgree(boolean z3) {
                            RequestResultCallback requestResultCallback2 = requestResultCallback;
                            if (requestResultCallback2 != null) {
                                requestResultCallback2.onUserAgree(z3);
                            }
                        }

                        public void onUserReject() {
                            RequestResultCallback requestResultCallback2 = requestResultCallback;
                            if (requestResultCallback2 != null) {
                                requestResultCallback2.onUserReject();
                            }
                        }

                        public void onActivityResult(int i, int i2, Intent intent) {
                            ((BasePushAdapter) adapterInstance).onActivityResult(i, i2, intent);
                        }
                    });
                }
            } catch (Throwable th) {
                Logger.m271e("PushChannelHelper", "requestNotificationPermission error" + Log.getStackTraceString(th));
                requestResultCallback.onRequestResult(false, "exception:" + th.getLocalizedMessage());
            }
        } else {
            Logger.m278w("PushChannelHelper", "[requestNotificationPermissionByBusinessAlert]invalid  pushAdapter:" + adapterInstance);
            requestResultCallback.onRequestResult(false, "invalid  pushAdapter:" + adapterInstance);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.push.third.BaseChannelHelper
    public boolean requestHwNotificationPermission(String str, RequestResultCallback requestResultCallback) {
        Logger.m268d("PushChannelHelper", "[requestHwNotificationPermission]");
        Application app = AppProvider.getApp();
        IPushAdapter adapterInstance = inst(app).getAdapterInstance(7);
        if (adapterInstance != 0 && adapterInstance.isPushAvailable(app, 7) && (adapterInstance instanceof BasePushAdapter)) {
            Logger.m268d("PushChannelHelper", "[requestHwNotificationPermission]use hwPushAdapter");
            BasePushAdapter basePushAdapter = (BasePushAdapter) adapterInstance;
            this.curSysPushAdapter = basePushAdapter;
            return basePushAdapter.requestNotificationPermission(str, 7, 0, requestResultCallback);
        }
        Logger.m278w("PushChannelHelper", "requestHwNotificationPermission is not support on cur device");
        if (requestResultCallback != null) {
            requestResultCallback.onRequestResult(false, "requestHwNotificationPermission is not support on cur device");
        }
        return false;
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public boolean isSupportSystemPushPermissionDialog() {
        Application app = AppProvider.getApp();
        IPushAdapter adapterInstance = inst(app).getAdapterInstance(10);
        IPushAdapter adapterInstance2 = inst(app).getAdapterInstance(7);
        IPushAdapter adapterInstance3 = inst(app).getAdapterInstance(11);
        return (adapterInstance != null && adapterInstance.isPushAvailable(app, 10)) || (adapterInstance2 != null && adapterInstance2.isPushAvailable(app, 7)) || (adapterInstance3 != null && adapterInstance3.isPushAvailable(app, 11));
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public void onActivityResult(int i, int i2, Intent intent) {
        Logger.m268d("PushChannelHelper", "[onActivityResult]curSysPushAdapter:" + this.curSysPushAdapter);
        BasePushAdapter basePushAdapter = this.curSysPushAdapter;
        if (basePushAdapter != null) {
            basePushAdapter.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.bytedance.push.third.BaseChannelHelper
    public boolean requestMiRemoveVoipNotification(Context context) {
        IPushAdapter adapterInstance = inst(AppProvider.getApp()).getAdapterInstance(1);
        if (adapterInstance != null) {
            try {
                return adapterInstance.requestRemoveVoipNotification(context, 1);
            } catch (Throwable th) {
                Logger.m271e("PushChannelHelper", "requestMiRemoveVoipNotification error" + Log.getStackTraceString(th));
                return false;
            }
        }
        Logger.m271e("PushChannelHelper", "requestMiRemoveVoipNotification can't find adapter for type:1");
        return false;
    }
}
