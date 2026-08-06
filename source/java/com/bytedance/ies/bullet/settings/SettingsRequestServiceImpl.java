package com.bytedance.ies.bullet.settings;

import android.app.Application;
import android.os.Build;
import com.bytedance.ies.bullet.base.storage.LocalStorage;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.device.BulletDeviceUtils;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.settings.BulletSettingsConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsNetwork;
import com.bytedance.ies.bullet.service.base.settings.SettingsResponse;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.news.common.settings.api.RequestService;
import com.bytedance.news.common.settings.api.Response;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SettingsRequestServiceImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/settings/SettingsRequestServiceImpl;", "Lcom/bytedance/news/common/settings/api/RequestService;", "config", "Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;", "(Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;)V", "ctxInfo", "", "request", "Lcom/bytedance/news/common/settings/api/Response;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SettingsRequestServiceImpl implements RequestService {
    private static final String SETTINGS_TIME = "settings_time";
    private final BulletSettingsConfig config;
    private String ctxInfo;

    public SettingsRequestServiceImpl(BulletSettingsConfig bulletSettingsConfig) {
        Intrinsics.checkNotNullParameter(bulletSettingsConfig, "config");
        this.config = bulletSettingsConfig;
        this.ctxInfo = "";
    }

    @Override // com.bytedance.news.common.settings.api.RequestService
    public Response request() {
        String bodyString;
        JSONObject optJSONObject;
        BulletLogger.onLog$default(BulletLogger.INSTANCE, "SettingsRequestServiceImpl:startRequest", null, 2, null);
        Application application = BulletEnv.INSTANCE.getInstance().getApplication();
        StringBuilder sb = new StringBuilder(BulletSettingsConstant.url);
        sb.append("?aid=" + this.config.getAppInfo().getAppId());
        sb.append("&app_version=" + this.config.getAppInfo().getAppVersion());
        sb.append("&iid=" + this.config.getAppInfo().getInstallId());
        sb.append("&device_id=" + this.config.getAppInfo().getDid());
        sb.append("&channel=" + this.config.getAppInfo().getChannel());
        sb.append("&device_platform=android&version_code=9.0.0&caller_name=Bullet");
        sb.append("&ctx_infos=" + this.ctxInfo);
        if (application != null) {
            try {
                sb.append("&resolution=" + BulletDeviceUtils.INSTANCE.getScreenWidth(application) + '*' + BulletDeviceUtils.INSTANCE.getScreenHeight(application));
            } catch (Throwable th) {
                HybridLogger.e$default(HybridLogger.INSTANCE, "SettingsRequestServiceImpl", "exception happens when append resolution, e=" + th.getMessage(), null, null, 12, null);
            }
        }
        sb.append("&os_version=" + Build.VERSION.SDK_INT);
        sb.append("&device_type=" + BulletDeviceUtils.INSTANCE.getModel());
        String read = LocalStorage.INSTANCE.read("settings_time");
        if (read == null) {
            read = ViewVisibleBridge.INVISIBLE;
        }
        sb.append("&settings_time=" + read);
        BulletLogger.onLog$default(BulletLogger.INSTANCE, "SettingsRequestServiceImpl:startRequest:url = " + ((Object) sb), null, 2, null);
        IBulletSettingsNetwork network = this.config.getNetwork();
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "urlBuilder.toString()");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(XBridgeAPIRequestUtils.CONTENT_TYPE, "application/json");
        linkedHashMap.put("mimeType", "application/json");
        Unit unit = Unit.INSTANCE;
        SettingsResponse post = network.post(sb2, linkedHashMap, new LinkedHashMap());
        BulletLogger.onLog$default(BulletLogger.INSTANCE, "SettingsRequestServiceImpl:startRequest:result = " + post.getBodyString(), null, 2, null);
        Response response = new Response();
        response.success = false;
        try {
            Result.Companion companion = Result.Companion;
            if (post.getStatusCode() >= 200 && (bodyString = post.getBodyString()) != null) {
                JSONObject jSONObject = new JSONObject(bodyString);
                if (Intrinsics.areEqual(jSONObject.optString("message"), "success") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(\"data\")");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(ErrorType.SETTINGS);
                    if (optJSONObject2 != null) {
                        Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(\"settings\")");
                        response.settingsData = new SettingsData(optJSONObject2, null);
                        response.vidInfo = optJSONObject.optJSONObject("vid_info");
                        response.ctxInfos = optJSONObject.optString("ctx_infos");
                        String str = response.ctxInfos;
                        Intrinsics.checkNotNullExpressionValue(str, "response.ctxInfos");
                        this.ctxInfo = str;
                        response.settingsTime = optJSONObject.optLong("settings_time");
                        LocalStorage.INSTANCE.write("settings_time", String.valueOf(response.settingsTime));
                        response.success = true;
                    }
                }
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th2));
        }
        return response;
    }
}
