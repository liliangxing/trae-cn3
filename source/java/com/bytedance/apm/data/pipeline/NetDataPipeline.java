package com.bytedance.apm.data.pipeline;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.data.BaseDataPipeline;
import com.bytedance.apm.data.type.ApiData;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.apm.util.ParseUtils;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NetDataPipeline extends BaseDataPipeline<ApiData> {
    private static final String TYPE_DOWNLOAD = "download";
    private static boolean sAttachNet = false;
    private static long sLaunchCollectExtraInfoTimeMs = 30000;
    private boolean isNetMonitorWithDisconnected;
    private boolean isNetWorkV2;
    private List<String> mAllowReportList;
    private List<Pattern> mAllowReportPatterns;
    private volatile List<String> mBlockReportList;
    private List<Pattern> mBlockReportPatterns;
    private double mEnableBaseApiAll;
    private boolean mEnableCancelErrorReport;
    private boolean mEnableHookNetSample;
    private volatile int mEnableReportApiError;
    private List<String> mImageHostAllowList;
    private INetSlaInnerListener mNetSlaListener;
    private int mReportSLA;
    private List<String> requestAllowHeader;
    private List<String> responseAllowHeader;

    private NetDataPipeline() {
        this.mEnableHookNetSample = true;
        this.isNetWorkV2 = true;
        this.mEnableCancelErrorReport = false;
    }

    public static NetDataPipeline getInstance() {
        return Holder.sInstance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class Holder {
        private static final NetDataPipeline sInstance = new NetDataPipeline();

        private Holder() {
        }
    }

    public void setNetSlaListener(INetSlaInnerListener iNetSlaInnerListener) {
        this.mNetSlaListener = iNetSlaInnerListener;
    }

    public void setNetMonitorWithDisconnected(boolean z) {
        this.isNetMonitorWithDisconnected = z;
    }

    @Override // com.bytedance.apm.data.BaseDataPipeline
    public void onRefresh(JSONObject jSONObject, boolean z) {
        JSONObject jsonObject = ParseUtils.getJsonObject(jSONObject, SlardarSettingsConsts.SETTING_NETWORK_IMAGE_MODULES);
        if (jsonObject != null) {
            JSONObject jsonObject2 = ParseUtils.getJsonObject(jsonObject, "network");
            if (jsonObject2 != null) {
                this.mBlockReportList = ParseUtils.parseList(jsonObject2, SlardarSettingsConsts.SETTING_NET_API_BLOCK_LIST);
                this.mBlockReportPatterns = ParseUtils.parsePatterns(jsonObject2, SlardarSettingsConsts.SETTING_NET_API_BLOCK_LIST);
                this.mAllowReportList = ParseUtils.parseMapList(jsonObject2, SlardarSettingsConsts.SETTING_NET_API_ALLOW_LIST);
                this.mAllowReportPatterns = ParseUtils.parseMapPatterns(jsonObject2, SlardarSettingsConsts.SETTING_NET_API_ALLOW_LIST);
                this.mReportSLA = jsonObject2.optInt(SlardarSettingsConsts.SETTING_NET_ENABLE_API_ALL_UPLOAD, 0);
                this.mEnableHookNetSample = jsonObject2.optBoolean(SlardarSettingsConsts.SETTING_NET_ENABLE_HOOK_NET_SAMPLE, true);
                this.mEnableReportApiError = jsonObject2.optInt(SlardarSettingsConsts.SETTING_NET_ENABLE_API_ERROR_UPLOAD, 1);
                this.mEnableCancelErrorReport = jsonObject2.optInt(SlardarSettingsConsts.SETTING_ENABLE_CANCEL_ERROR_REPORT) == 1;
                this.requestAllowHeader = ParseUtils.parseMapList(jsonObject2, SlardarSettingsConsts.SETTING_REQUEST_ALLOW_HEADER);
                this.responseAllowHeader = ParseUtils.parseMapList(jsonObject2, SlardarSettingsConsts.SETTING_RESPONSE_ALLOW_HEADER);
                this.mEnableBaseApiAll = jsonObject2.optDouble(SlardarSettingsConsts.SETTING_ENABLE_BASE_API_ALL, 0.0d);
            }
            JSONObject jsonObject3 = ParseUtils.getJsonObject(jsonObject, "image");
            if (jsonObject3 != null) {
                this.mImageHostAllowList = ParseUtils.parseMapList(jsonObject3, SlardarSettingsConsts.SETTING_IMAGE_ALLOW_LIST);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.data.BaseDataPipeline
    public boolean checkValid(ApiData apiData) {
        return (apiData == null || TextUtils.isEmpty(apiData.sendUrl)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.data.BaseDataPipeline
    public void hookBeforeRealHandle(ApiData apiData) {
        try {
            apiData.appendFront(!isBackground());
            if (isNeedNetInfo()) {
                apiData.appendLaunchTraceInfo();
            }
            apiData.appendConsumeType("ttnet");
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.data.BaseDataPipeline
    public void handleAfterReady(ApiData apiData) {
        handleNetSLA(apiData);
    }

    private boolean isMatchAllowURI(String str) {
        return ParseUtils.isMatch(str, this.mAllowReportList, this.mAllowReportPatterns);
    }

    private boolean isMatchBlackURI(String str) {
        return ParseUtils.isMatch(str, this.mBlockReportList, this.mBlockReportPatterns);
    }

    private boolean matchImagePattern(String str) {
        return ParseUtils.isHostEquals(str, this.mImageHostAllowList);
    }

    private boolean checkMatch(String str, JSONObject jSONObject) {
        if (matchImagePattern(str) || !(NetUtils.isNetworkAvailable(ApmContext.getContext()) || this.isNetMonitorWithDisconnected)) {
            return false;
        }
        return !isCancelErrorCode(jSONObject) || this.mEnableCancelErrorReport;
    }

    private boolean checkSample(String str, String str2, JSONObject jSONObject) {
        if (TextUtils.equals(str, "api_all")) {
            if (isEnableBaseApiAll()) {
                handleApiAllSample(str2, jSONObject);
                return true;
            }
            if (!isMatchBlackURI(str2)) {
                return handleApiAllSample(str2, jSONObject);
            }
        } else if (TextUtils.equals(str, "api_error") && this.mEnableReportApiError == 1) {
            return true;
        }
        return false;
    }

    private void handleNetSLA(ApiData apiData) {
        String str = apiData.sendUrl;
        String str2 = apiData.apiType;
        boolean z = !apiData.extJson.isNull(CommonKey.KEY_HIT_RULES);
        if (z || checkMatch(str, apiData.extJson)) {
            JSONObject packLog = apiData.packLog();
            JsonUtils.combineJson(packLog, apiData.extJson);
            if (packLog == null) {
                return;
            }
            boolean z2 = z || checkSample(str2, str, packLog);
            if (this.isNetWorkV2) {
                addNetWorkV2Info(packLog, apiData.apiType);
            }
            checkWhiteHeader(packLog);
            if (this.mNetSlaListener != null && "api_all".equals(str2) && !apiData.extJson.optBoolean(TYPE_DOWNLOAD, false)) {
                this.mNetSlaListener.deliver(str, apiData.extJson);
            }
            logSend(str2, str2, packLog, z2, true);
        }
    }

    private boolean isCancelErrorCode(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            String optString = jSONObject.optString(CommonServiceName.CRONET_INTERNAL_ERROR_CODE);
            if (CommonServiceName.CRONET_ERROR_CODE_CANCEL.equals(jSONObject.optString(CommonServiceName.CRONET_ERROR_CODE))) {
                return CommonServiceName.CRONET_INTERNAL_ERROR_CODE_CANCEL.equals(optString);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private void checkWhiteHeader(JSONObject jSONObject) {
        checkWhiteHeaderSetting(this.requestAllowHeader, jSONObject, SlardarSettingsConsts.EXT_REQUEST_HEADER);
        checkWhiteHeaderSetting(this.responseAllowHeader, jSONObject, SlardarSettingsConsts.EXT_RESPONSE_HEADER);
    }

    private void checkWhiteHeaderSetting(List<String> list, JSONObject jSONObject, String str) {
        if (list == null || jSONObject == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                String optString = jSONObject.optString(str);
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(optString);
                JSONObject jSONObject3 = new JSONObject();
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (list.contains(next)) {
                        jSONObject3.put(next, jSONObject2.opt(next));
                    }
                }
                jSONObject.put(str, jSONObject3.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void addNetWorkV2Info(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                if (TextUtils.equals(str, "api_all")) {
                    jSONObject.put(CommonKey.KEY_NET_LOG_TYPE, CommonServiceName.MONITOR_TYPE_API_ALL_V2);
                } else if (TextUtils.equals(str, "api_error")) {
                    jSONObject.put(CommonKey.KEY_NET_LOG_TYPE, CommonServiceName.MONITOR_TYPE_API_ERROR_V2);
                }
                if (isEnableBaseApiAll() && isEnableHookNetSample()) {
                    jSONObject.put(CommonServiceName.MONITOR_INJECT_TRACE_LOG, "01");
                } else if (getReportSLA() == 1 && isEnableHookNetSample()) {
                    jSONObject.put(CommonServiceName.MONITOR_INJECT_TRACE_LOG, "02");
                }
                double d = this.mEnableBaseApiAll;
                if (d != 0.0d) {
                    jSONObject.put(SlardarSettingsConsts.SETTING_ENABLE_BASE_API_ALL, d);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean handleApiSample(String str, String str2, JSONObject jSONObject) {
        if (TextUtils.equals(str, "api_all")) {
            return handleApiAllSample(str2, jSONObject);
        }
        return TextUtils.equals(str, "api_error") && this.mEnableReportApiError == 1;
    }

    private boolean handleApiAllSample(String str, JSONObject jSONObject) {
        int i = (isEnableBaseApiAll() || this.mReportSLA != 0 || isMatchAllowURI(str)) ? 1 : 0;
        boolean serviceSwitch = SamplerHelper.getServiceSwitch(CommonServiceName.MONITOR_TYPE_SMART_TRAFFIC);
        try {
            jSONObject.put(CommonKey.KEY_HIT_RULES, serviceSwitch ? i | 4 : i);
        } catch (JSONException unused) {
        }
        return i != 0 || serviceSwitch;
    }

    public boolean isEnableBaseApiAll() {
        return this.isNetWorkV2 && this.mEnableBaseApiAll != 0.0d;
    }

    public int getReportSLA() {
        return this.mReportSLA;
    }

    public boolean isNetWorkV2() {
        return this.isNetWorkV2;
    }

    public boolean isEnableHookNetSample() {
        return this.mEnableHookNetSample;
    }

    public NetSampleResult checkSample(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!isConfigReady()) {
            return NetSampleResult.UNKNOWN;
        }
        if (isEnableBaseApiAll() || this.mReportSLA != 0) {
            return NetSampleResult.HIT;
        }
        return NetSampleResult.NOT_HIT;
    }

    public static void setLaunchCollectExtraInfoTimeMs(long j) {
        sLaunchCollectExtraInfoTimeMs = j;
    }

    public static void setLaunchCollectExtraInfoFlag(boolean z) {
        sAttachNet = z;
    }

    public static boolean isNeedNetInfo() {
        return sAttachNet && ApmContext.getAppLaunchStartTimestamp() != 0 && System.currentTimeMillis() - ApmContext.getAppLaunchStartTimestamp() <= sLaunchCollectExtraInfoTimeMs;
    }
}
