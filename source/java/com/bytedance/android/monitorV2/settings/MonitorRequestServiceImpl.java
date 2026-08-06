package com.bytedance.android.monitorV2.settings;

import android.os.Build;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.constant.MonitorGlobalSp;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.keva.Keva;
import com.bytedance.news.common.settings.api.RequestService;
import com.bytedance.news.common.settings.api.Response;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MonitorRequestServiceImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/MonitorRequestServiceImpl;", "Lcom/bytedance/news/common/settings/api/RequestService;", "()V", "TAG", "", "ctxInfo", "kevaRepo", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "value", "settingsStringLocalCache", "getSettingsStringLocalCache", "()Ljava/lang/String;", "setSettingsStringLocalCache", "(Ljava/lang/String;)V", "", "settingsTimeLocalCache", "getSettingsTimeLocalCache", "()J", "setSettingsTimeLocalCache", "(J)V", "url", "isFirstRequest", "", "request", "Lcom/bytedance/news/common/settings/api/Response;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MonitorRequestServiceImpl implements RequestService {
    private final String TAG = "MonitorRequestServiceImpl";
    private final String url = "https://is.snssdk.com/service/settings/v3/";
    private String ctxInfo = "";
    private final Keva kevaRepo = Keva.getRepo(MonitorRequestServiceImpl.class.getName());

    private final long getSettingsTimeLocalCache() {
        return MonitorGlobalSp.getLong(MonitorGlobalSp.MONITOR_APP_SETTINGS_TIME, 0L);
    }

    private final void setSettingsTimeLocalCache(long j) {
        MonitorGlobalSp.putLong(MonitorGlobalSp.MONITOR_APP_SETTINGS_TIME, j);
    }

    private final String getSettingsStringLocalCache() {
        return MonitorGlobalSp.getString(MonitorGlobalSp.MONITOR_APP_SETTINGS_RESPONSE, "{}");
    }

    private final void setSettingsStringLocalCache(String str) {
        MonitorGlobalSp.putString(MonitorGlobalSp.MONITOR_APP_SETTINGS_RESPONSE, str);
    }

    private final boolean isFirstRequest() {
        boolean z = this.kevaRepo.getBoolean("first_request", true);
        if (z) {
            this.kevaRepo.storeBoolean("first_request", false);
        }
        return z;
    }

    public Response request() {
        JSONObject jSONObject;
        String vidInfo;
        String settings;
        StringBuilder sb = new StringBuilder(this.url);
        sb.append("?aid=" + HybridMultiMonitor.getInstance().getHybridSettingManager().getInitConfig().getAid());
        sb.append("&iid=" + HybridMultiMonitor.getInstance().getHybridSettingManager().getInitConfig().getInstallId());
        sb.append("&device_id=" + HybridMultiMonitor.getInstance().getHybridSettingManager().getInitConfig().getDeviceId());
        sb.append("&device_brand=" + Build.BRAND);
        sb.append("&device_type=" + Build.MODEL);
        sb.append("&channel=" + HybridMultiMonitor.getInstance().getHybridSettingManager().getInitConfig().getChannel());
        sb.append("&device_platform=android");
        sb.append("&version_code=" + HybridMultiMonitor.getInstance().getHybridSettingManager().getInitConfig().getVersionCode());
        sb.append("&update_version_code=" + HybridMultiMonitor.getInstance().getHybridSettingManager().getInitConfig().getUpdateVersionCode());
        sb.append("&caller_name=hybrid_monitor");
        sb.append("&ctx_infos=" + this.ctxInfo);
        sb.append("&os_api=" + Build.VERSION.SDK_INT);
        sb.append("&os_version=" + Build.VERSION.RELEASE);
        sb.append("&settings_time=" + getSettingsTimeLocalCache());
        ISettingsApi iSettingsApi = (ISettingsApi) RetrofitUtils.createSsService(this.url, ISettingsApi.class);
        MonitorLog.m29i(this.TAG, "MonitorRequestServiceImpl:startRequest:url = " + ((Object) sb));
        boolean isFirstRequest = isFirstRequest();
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "urlBuilder.toString()");
        Call<String> doPost = iSettingsApi.doPost(sb2, CollectionsKt.listOf(new Header[]{new Header("Content-Type", "application/json"), new Header("mimeType", "application/json"), new Header("X-Tt-Request-Tag", "t=0;n=" + (isFirstRequest ? 1 : 0))}), new LinkedHashMap());
        Response response = new Response();
        response.success = false;
        try {
            Result.Companion companion = Result.Companion;
            SsResponse execute = doPost.execute();
            if (execute.isSuccessful()) {
                CharSequence charSequence = (CharSequence) execute.body();
                if (!(charSequence == null || charSequence.length() == 0)) {
                    SettingsResponse settingsResponse = (SettingsResponse) new Gson().fromJson((String) execute.body(), SettingsResponse.class);
                    MonitorLog.m29i(this.TAG, "MonitorRequestServiceImpl:response:message = " + settingsResponse.getMessage());
                    if (Intrinsics.areEqual(settingsResponse.getMessage(), "success") || Intrinsics.areEqual(settingsResponse.getMessage(), "demotion")) {
                        Data data = settingsResponse.getData();
                        if (data != null && (settings = data.getSettings()) != null) {
                            jSONObject = new JSONObject(settings);
                        } else {
                            MonitorRequestServiceImpl monitorRequestServiceImpl = this;
                            jSONObject = new JSONObject(getSettingsStringLocalCache());
                        }
                        response.settingsData = new SettingsData(jSONObject, (JSONObject) null);
                        Data data2 = settingsResponse.getData();
                        response.vidInfo = (data2 == null || (vidInfo = data2.getVidInfo()) == null) ? null : new JSONObject(vidInfo);
                        Data data3 = settingsResponse.getData();
                        response.ctxInfos = data3 != null ? data3.getCtxInfos() : null;
                        response.success = true;
                        Data data4 = settingsResponse.getData();
                        if (data4 != null) {
                            Long settingsTime = data4.getSettingsTime();
                            if (settingsTime != null) {
                                setSettingsTimeLocalCache(settingsTime.longValue());
                            }
                            String settings2 = data4.getSettings();
                            if (settings2 != null) {
                                setSettingsStringLocalCache(settings2);
                            }
                        }
                        String str = response.ctxInfos;
                        Intrinsics.checkNotNullExpressionValue(str, "response.ctxInfos");
                        this.ctxInfo = str;
                    }
                }
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        return response;
    }
}
