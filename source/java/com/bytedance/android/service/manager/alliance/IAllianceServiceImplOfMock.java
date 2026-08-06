package com.bytedance.android.service.manager.alliance;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.push.depths.RiskDeviceFilterConfig;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IAllianceServiceImplOfMock implements IAllianceService {
    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void doAfterProcessIsolationProtected(Runnable runnable) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onApplicationInit(String str, Context context) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onAttachBaseContext(Application application) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onBackgroundProcessAlive(String str) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onEventV3(boolean z, String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onEventV3WithHttp(boolean z, String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onInitOnProcessIsolationProtectedMode() {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onMainProcessStart() {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onSmpProcessStart(Context context, Object obj, String str, SmpProcessInitCallback smpProcessInitCallback) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void onWorkerApplicationStart() {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void reportEventByHttpNow(Context context, String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void startClientAccountRetryTask(String str) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void updateSettings(Context context, JSONObject jSONObject) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public void wakeUpTargetPartner(JSONObject jSONObject) {
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public IsSupportWakeUp isSupportWakeUp(Context context) {
        Log.w("IAllianceService", "cur isSupportWakeUp method is empty impl in IAllianceServiceImplOfMockClass");
        return null;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean verifySign(String str, String str2) {
        Log.w("IAllianceService", "cur verifySign method is empty impl in IAllianceServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean allowStartOthersProcessFromSmp() {
        Log.w("IAllianceService", "cur allowStartOthersProcessFromSmp method is empty impl in IAllianceServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean allowSyncInSmpWhenProcessIsolate() {
        Log.w("IAllianceService", "cur allowSyncInSmpWhenProcessIsolate method is empty impl in IAllianceServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean hasWaked() {
        Log.w("IAllianceService", "cur hasWaked method is empty impl in IAllianceServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean depthsInMainProcess(Context context) {
        Log.w("IAllianceService", "cur depthsInMainProcess method is empty impl in IAllianceServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public ICommonInstrumentation getInstrumentationService() {
        Log.w("IAllianceService", "cur getInstrumentationService method is empty impl in IAllianceServiceImplOfMockClass");
        return new ICommonInstrumentationImplOfMock();
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean isRiskDevice(Context context, boolean z) {
        Log.w("IAllianceService", "cur isRiskDevice method is empty impl in IAllianceServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public boolean isStartByAlliance(Context context) {
        Log.w("IAllianceService", "cur isStartByAlliance method is empty impl in IAllianceServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.alliance.IAllianceService
    public String isRiskDevice(Context context, RiskDeviceFilterConfig riskDeviceFilterConfig) {
        Log.w("IAllianceService", "cur isRiskDevice method is empty impl in IAllianceServiceImplOfMockClass");
        return "";
    }
}
