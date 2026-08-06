package com.bytedance.android.service.manager.permission.boot;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.push.settings.permission.boot.BusinessCustomSysDialogConfig;
import org.json.JSONObject;

@ExternalService
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IPermissionBootExternalService {
    BusinessCustomSysAlertDialogStatus allowBusinessCustomSysAlertDialog(Context context);

    GoogleCustomSysAlertDialogStatus allowGoogleCustomSysAlertDialog(Context context);

    BusinessCustomSysDialogConfig getCustomSysDialogConfig(Context context);

    void initOnApplication();

    void onNotificationPermissionDialogClickResult(String str, String str2, int i, int i2, boolean z, String str3, int i3, JSONObject jSONObject);

    void onNotificationPermissionDialogRequestResultEvent(String str, String str2, int i, int i2, boolean z, String str3);

    boolean openSysPushSettingsPage(String str, Activity activity, ISysPermissionPageCallback iSysPermissionPageCallback);

    boolean openSysPushSettingsPage(String str, Activity activity, LottieAnimatorModel lottieAnimatorModel, ISysPermissionPageCallback iSysPermissionPageCallback);

    void reportDefaultNotificationStatus();

    boolean requestNotificationPermissionByBusinessAlert(String str, View view, boolean z, IOriginSysDialog iOriginSysDialog);

    void requestNotificationPermissionByGoogleAlert(String str, View view, boolean z, boolean z2, boolean z3, RequestResultCallback requestResultCallback);

    boolean sdkNeedRequestSettings();

    boolean shouldOpenSysPushSettingsByPushSdk(Context context);

    PushPermissionBootShowResult tryShowPushPermissionBoot(PermissionBootRequestParam permissionBootRequestParam);
}
