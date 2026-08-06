package com.bytedance.android.service.manager.alliance;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import com.bytedance.push.depths.RiskDeviceFilterConfig;
import org.json.JSONObject;

@ExternalService
/* loaded from: classes3.dex */
public interface IAllianceService {
    public static final String CONTENT_TYPE_BADGE = "badge";
    public static final String CONTENT_TYPE_LOCAL_PUSH = "local_push";
    public static final String LAUNCH_FROM_SIGNAL = "signal";
    public static final String PATH_GET_COMPOSE = "get_compose";
    public static final String PATH_POST_COMPOSE = "post_compose";

    boolean allowStartOthersProcessFromSmp();

    boolean allowSyncInSmpWhenProcessIsolate();

    boolean depthsInMainProcess(Context context);

    void doAfterProcessIsolationProtected(Runnable runnable);

    ICommonInstrumentation getInstrumentationService();

    boolean hasWaked();

    String isRiskDevice(Context context, RiskDeviceFilterConfig riskDeviceFilterConfig);

    boolean isRiskDevice(Context context, boolean z);

    boolean isStartByAlliance(Context context);

    IsSupportWakeUp isSupportWakeUp(Context context);

    void onApplicationInit(String str, Context context);

    void onAttachBaseContext(Application application);

    void onBackgroundProcessAlive(String str);

    void onEventV3(boolean z, String str, JSONObject jSONObject);

    void onEventV3WithHttp(boolean z, String str, JSONObject jSONObject);

    void onInitOnProcessIsolationProtectedMode();

    void onMainProcessStart();

    void onSmpProcessStart(Context context, Object obj, String str, SmpProcessInitCallback smpProcessInitCallback);

    void onWorkerApplicationStart();

    void reportEventByHttpNow(Context context, String str, JSONObject jSONObject);

    void startClientAccountRetryTask(String str);

    void updateSettings(Context context, JSONObject jSONObject);

    boolean verifySign(String str, String str2);

    void wakeUpTargetPartner(JSONObject jSONObject);
}
