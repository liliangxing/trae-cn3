package com.bytedance.apm.event;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.util.FpsUtil;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FpsEvent extends PerfBaseEvent {
    private static final String KEY_REFRESH_RATE = "refresh_rate";
    private static final String PERF_FPS_MEASURE_KEY = "fps";
    private static final String SERVICE_NAME = "fps";
    private float fpsValue;
    private boolean mNeedUploadDeviceFpsInfo;
    private int refreshRate;
    private String scene;

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "fps";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return false;
    }

    public FpsEvent(float f, String str, int i, boolean z) {
        this.fpsValue = f;
        this.scene = str;
        this.refreshRate = i;
        this.mNeedUploadDeviceFpsInfo = z;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fps", this.fpsValue);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraStatus() {
        try {
            new JSONObject().put("scene", this.scene);
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getFilters() {
        try {
            JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson();
            perfFiltersJson.put("refresh_rate", this.refreshRate);
            if (this.mNeedUploadDeviceFpsInfo) {
                this.mNeedUploadDeviceFpsInfo = false;
                perfFiltersJson.put(CommonKey.KEY_DEVICE_MAX_REFRESH_RATE, FpsUtil.getDeviceMaxRefreshRate());
                perfFiltersJson.put(CommonKey.KEY_REFRESH_RATE_RESTRICTED, FpsUtil.isUsingMaxRefreshRate() ? false : true);
            }
            return perfFiltersJson;
        } catch (Throwable unused) {
            return null;
        }
    }
}
