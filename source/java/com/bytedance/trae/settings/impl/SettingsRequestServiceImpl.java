package com.bytedance.trae.settings.impl;

import android.os.Build;
import com.bytedance.news.common.settings.api.RequestService;
import com.bytedance.news.common.settings.api.Response;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.cache.CtxInfoManager;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: SettingsRequestServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl;", "Lcom/bytedance/news/common/settings/api/RequestService;", "<init>", "()V", "request", "Lcom/bytedance/news/common/settings/api/Response;", "buildRequestParams", "", "", "Companion", "SettingsApi", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SettingsRequestServiceImpl implements RequestService {
    private static final String SETTINGS_PATH = "service/settings/v3/";
    private static final String TAG = "Settings";

    /* compiled from: SettingsRequestServiceImpl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bb\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H'¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl$SettingsApi;", "", "fetchSettings", "Lcom/bytedance/retrofit2/Call;", "", "url", "params", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private interface SettingsApi {
        @GET
        Call<String> fetchSettings(@Url String url, @QueryMap Map<String, String> params);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0088 A[Catch: Exception -> 0x00ef, TryCatch #0 {Exception -> 0x00ef, blocks: (B:3:0x000c, B:5:0x0065, B:6:0x006b, B:8:0x007c, B:13:0x0088, B:16:0x0090, B:18:0x009d, B:20:0x00a9, B:22:0x00b4, B:23:0x00bc), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0090 A[Catch: Exception -> 0x00ef, TryCatch #0 {Exception -> 0x00ef, blocks: (B:3:0x000c, B:5:0x0065, B:6:0x006b, B:8:0x007c, B:13:0x0088, B:16:0x0090, B:18:0x009d, B:20:0x00a9, B:22:0x00b4, B:23:0x00bc), top: B:2:0x000c }] */
    @Override // com.bytedance.news.common.settings.api.RequestService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response request() {
        String body;
        String str;
        boolean z;
        Response response = new Response();
        try {
            String baseUrl = HostResolver.INSTANCE.getBaseUrl(HostType.SETTINGS);
            SsResponse<String> execute = ((SettingsApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "settings_v3", SettingsApi.class, null, baseUrl, null, false, 52, null)).fetchSettings(baseUrl + SETTINGS_PATH, buildRequestParams()).execute();
            body = execute.body();
            FLogger.INSTANCE.mo428i(TAG, "SettingsRequest: code=" + execute.code() + ", bodyLen=" + (body != null ? body.length() : 0));
            str = body;
        } catch (Exception e) {
            FLogger.INSTANCE.mo427e(TAG, "SettingsRequest: exception ", e);
            response.success = false;
        }
        if (str != null && str.length() != 0) {
            z = false;
            if (!z) {
                FLogger.INSTANCE.mo430w(TAG, "SettingsRequest: body is null or empty");
                return response;
            }
            JSONObject optJSONObject = new JSONObject(body).optJSONObject("data");
            if (optJSONObject == null) {
                SettingsRequestServiceImpl settingsRequestServiceImpl = this;
                FLogger.INSTANCE.mo430w(TAG, "SettingsRequest: data field is null");
                return response;
            }
            response.success = true;
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(ErrorType.SETTINGS);
            if (optJSONObject2 != null) {
                response.settingsData = new SettingsData(optJSONObject2, null);
            }
            response.vidInfo = optJSONObject.optJSONObject("vid_info");
            response.ctxInfos = optJSONObject.optString("ctx_infos", "");
            response.settingsTime = optJSONObject.optLong(CommonConstants.KEY_SETTINGS_TIME, 0L);
            FLogger.INSTANCE.mo428i(TAG, "SettingsRequest: success, settingsTime=" + response.settingsTime);
            return response;
        }
        z = true;
        if (!z) {
        }
    }

    private final Map<String, String> buildRequestParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonConstants.KEY_DID, IApplog.Companion.getDeviceId());
        linkedHashMap.put("iid", IApplog.Companion.getInstallId());
        linkedHashMap.put(CommonConstants.KEY_AID, String.valueOf(AppHost.Companion.getAppId()));
        linkedHashMap.put("app_version", AppHost.Companion.getVersionName());
        linkedHashMap.put("version_code", String.valueOf(AppHost.Companion.getVersionCode()));
        linkedHashMap.put("update_version_code", String.valueOf(AppHost.Companion.getUpdateVersionCode()));
        linkedHashMap.put("channel", AppHost.Companion.getBuildChannel());
        linkedHashMap.put(CommonConstants.KEY_DEVICE_PLATFORM, "android");
        linkedHashMap.put("device_brand", Build.BRAND);
        linkedHashMap.put("device_type", Build.MODEL);
        linkedHashMap.put(CommonConstants.KEY_OS_VERSION, Build.VERSION.RELEASE);
        linkedHashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        CtxInfoManager ctxInfoManager = CtxInfoManager.getInstance(AppHost.Companion.getApplication());
        String ctxInfo = ctxInfoManager.getCtxInfo();
        if (ctxInfo == null) {
            ctxInfo = "";
        }
        linkedHashMap.put("ctx_infos", ctxInfo);
        linkedHashMap.put(CommonConstants.KEY_SETTINGS_TIME, String.valueOf(ctxInfoManager.geSettingsTime()));
        return linkedHashMap;
    }
}
