package com.bytedance.android.service.manager.permission.boot;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.push.settings.permission.boot.BusinessCustomSysDialogConfig;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class IPermissionBootExternalServiceImplOfMock implements IPermissionBootExternalService {
    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public void initOnApplication() {
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public void onNotificationPermissionDialogClickResult(String str, String str2, int i, int i2, boolean z, String str3, int i3, JSONObject jSONObject) {
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public void onNotificationPermissionDialogRequestResultEvent(String str, String str2, int i, int i2, boolean z, String str3) {
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public void reportDefaultNotificationStatus() {
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public void requestNotificationPermissionByGoogleAlert(String str, View view, boolean z, boolean z2, boolean z3, RequestResultCallback requestResultCallback) {
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public PushPermissionBootShowResult tryShowPushPermissionBoot(PermissionBootRequestParam permissionBootRequestParam) {
        Log.w("IPermissionBootExternalService", "cur tryShowPushPermissionBoot method is empty impl in IPermissionBootExternalServiceImplOfMockClass");
        return null;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public boolean openSysPushSettingsPage(String str, Activity activity, ISysPermissionPageCallback iSysPermissionPageCallback) {
        Log.w("IPermissionBootExternalService", "cur openSysPushSettingsPage method is empty impl in IPermissionBootExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public boolean openSysPushSettingsPage(String str, Activity activity, LottieAnimatorModel lottieAnimatorModel, ISysPermissionPageCallback iSysPermissionPageCallback) {
        Log.w("IPermissionBootExternalService", "cur openSysPushSettingsPage method is empty impl in IPermissionBootExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public boolean sdkNeedRequestSettings() {
        Log.w("IPermissionBootExternalService", "cur sdkNeedRequestSettings method is empty impl in IPermissionBootExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public boolean shouldOpenSysPushSettingsByPushSdk(Context context) {
        Log.w("IPermissionBootExternalService", "cur shouldOpenSysPushSettingsByPushSdk method is empty impl in IPermissionBootExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public BusinessCustomSysAlertDialogStatus allowBusinessCustomSysAlertDialog(Context context) {
        Log.w("IPermissionBootExternalService", "cur allowBusinessCustomSysAlertDialog method is empty impl in IPermissionBootExternalServiceImplOfMockClass");
        return null;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public BusinessCustomSysDialogConfig getCustomSysDialogConfig(Context context) {
        Log.w("IPermissionBootExternalService", "cur getCustomSysDialogConfig method is empty impl in IPermissionBootExternalServiceImplOfMockClass");
        return null;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public GoogleCustomSysAlertDialogStatus allowGoogleCustomSysAlertDialog(Context context) {
        Log.w("IPermissionBootExternalService", "cur allowGoogleCustomSysAlertDialog method is empty impl in IPermissionBootExternalServiceImplOfMockClass");
        return null;
    }

    @Override // com.bytedance.android.service.manager.permission.boot.IPermissionBootExternalService
    public boolean requestNotificationPermissionByBusinessAlert(String str, View view, boolean z, IOriginSysDialog iOriginSysDialog) {
        Log.w("IPermissionBootExternalService", "cur requestNotificationPermissionByBusinessAlert method is empty impl in IPermissionBootExternalServiceImplOfMockClass");
        return false;
    }
}
