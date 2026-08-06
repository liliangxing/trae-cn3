package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.OpInstallOptionsHelper;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;
import com.bytedance.bdinstall.service.IInstallService;
import com.bytedance.bdinstall.service.ServiceManager;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class OpInstallServiceImpl implements IInstallService, OpInstallOptionsHelper.OnDataChangedListener {
    private IBDInstallApi mBDInstallApi;
    private CallbackCenter mCallbackCenter;
    private InstallInfo mInstallInfo;

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean activeManually() {
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void changeUriRuntimeAndReInstall(Env env) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void clearAndSetEnv(Env env) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public Env getCurEnv() {
        return null;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean getHeader(JSONObject jSONObject) {
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean isNewUserFirstLaunch() {
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public JSONObject loadOrGetHeader() {
        return null;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void resetAndReInstall(Context context, Env env, long j, OnResetListener onResetListener) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setAccount(Account account) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void start() {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateHeader(Context context, Map<String, String> map, boolean z, boolean z2) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateMemoryHeader(Context context, Map<String, Object> map) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpInstallServiceImpl(IBDInstallApi iBDInstallApi) {
        this.mBDInstallApi = iBDInstallApi;
        DrLog.m139d("OTHER PROCESS IMPL");
    }

    public void setCallbackCenter(CallbackCenter callbackCenter) {
        this.mCallbackCenter = callbackCenter;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void init(InstallOptions installOptions, Env env) {
        OpInstallOptionsHelper opInstallOptionsHelper = new OpInstallOptionsHelper(installOptions.getContext());
        opInstallOptionsHelper.setInstallOptions(installOptions);
        opInstallOptionsHelper.startObserver(installOptions.getContext(), this);
        Cdid.get(installOptions);
        ServiceManager.registerService(DeviceTokenService.class, new CpDeviceTokenServiceImpl(installOptions), String.valueOf(installOptions.getAid()));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setInstallInfo(InstallInfo installInfo) {
        this.mInstallInfo = installInfo;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public InstallInfo getInstallInfo() {
        InstallInfo installInfo = this.mInstallInfo;
        if (installInfo == null) {
            return null;
        }
        return installInfo.m433clone();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public String getDid() {
        InstallInfo installInfo = this.mInstallInfo;
        if (installInfo == null) {
            return null;
        }
        return installInfo.getDid();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void registerLifeCycleListener(Application application) {
        throw new IllegalStateException("BdInstall process is wrong");
    }

    @Override // com.bytedance.bdinstall.OpInstallOptionsHelper.OnDataChangedListener
    public void onInstallInfoChanged(InstallInfo installInfo, String str) {
        DrLog.m139d("install info changed : " + installInfo);
        this.mBDInstallApi.setInstallInfo(installInfo);
        CallbackCenter callbackCenter = this.mCallbackCenter;
        if (callbackCenter != null) {
            callbackCenter.postEvent(new InstallFinishEvent(installInfo));
        }
    }
}
