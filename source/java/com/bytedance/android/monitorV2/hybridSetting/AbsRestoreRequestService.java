package com.bytedance.android.monitorV2.hybridSetting;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.constant.MonitorGlobalSp;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingResponse;
import com.bytedance.android.monitorV2.hybridSetting.localcache.LocalHybridSettingManager;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ConvertUtil;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsRestoreRequestService implements ISettingRequestService {
    protected HybridSettingInitConfig initConfig;
    private HybridSettingResponse sourceResponse;
    private String sourceResponseStr;
    protected String TAG = "ISettingRequestService";
    private long mLastFetchTime = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsRestoreRequestService(HybridSettingInitConfig hybridSettingInitConfig) {
        this.initConfig = hybridSettingInitConfig;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.ISettingRequestService
    public HybridSettingResponse stepOneFromLocal() {
        try {
            String string = MonitorGlobalSp.getString(MonitorGlobalSp.MONITOR_SETTING_RESPONSE, "");
            HybridSettingResponse resToResponseStepOne = ConvertUtil.resToResponseStepOne(string);
            this.mLastFetchTime = MonitorGlobalSp.getLong(MonitorGlobalSp.MONITOR_SETTING_RESPONSE_FETCH_TIME, 0L);
            saveSourceResponse(string, resToResponseStepOne);
            return resToResponseStepOne;
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
            return null;
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.ISettingRequestService
    public HybridSettingResponse stepTwo() {
        HybridSettingResponse hybridSettingResponse = null;
        try {
            if (TextUtils.isEmpty(this.sourceResponseStr) || this.sourceResponse == null) {
                return null;
            }
            HybridSettingResponse resToResponseStepTwo = ConvertUtil.resToResponseStepTwo(this.sourceResponseStr);
            hybridSettingResponse = this.sourceResponse;
            hybridSettingResponse.bidInfo = resToResponseStepTwo.bidInfo;
            return hybridSettingResponse;
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
            return hybridSettingResponse;
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.ISettingRequestService
    public long getLastFetchTime() {
        return MonitorGlobalSp.getLong(MonitorGlobalSp.MONITOR_SETTING_RESPONSE_FETCH_TIME, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HybridSettingResponse toSettingResponseStepOne(String str) {
        try {
            if (!isRequestSuccess(new JSONObject(str))) {
                return null;
            }
            MonitorLog.m26d(this.TAG, "monitor setting request: succeeded");
            String deviceId = this.initConfig.getDeviceId();
            HybridSettingResponse updateSetting = JsonOptConfig.isJsonOptEnable() ? LocalHybridSettingManager.updateSetting(str, deviceId) : ConvertUtil.resToResponseStepOne(str);
            if (!JsonOptConfig.isJsonOptEnable() || HybridMultiMonitor.isDebuggable()) {
                MonitorGlobalSp.putString(MonitorGlobalSp.MONITOR_SETTING_RESPONSE, str);
                if (!TextUtils.isEmpty(deviceId) && !"0".equals(deviceId)) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    this.mLastFetchTime = currentTimeMillis;
                    MonitorGlobalSp.putLong(MonitorGlobalSp.MONITOR_SETTING_RESPONSE_FETCH_TIME, currentTimeMillis);
                }
            }
            saveSourceResponse(str, updateSetting);
            return updateSetting;
        } catch (Throwable th) {
            ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
            return null;
        }
    }

    private static boolean isRequestSuccess(JSONObject jSONObject) {
        return jSONObject != null && JsonUtils.safeOptInt(jSONObject, "errno") == 200;
    }

    private void saveSourceResponse(String str, HybridSettingResponse hybridSettingResponse) {
        if (JsonOptConfig.isJsonOptEnable()) {
            return;
        }
        this.sourceResponseStr = str;
        this.sourceResponse = hybridSettingResponse;
    }
}
