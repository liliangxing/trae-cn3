package com.bytedance.security.android.aopcheck.settings;

import android.os.Build;
import android.util.Log;
import com.bytedance.news.common.settings.api.RequestService;
import com.bytedance.news.common.settings.api.Response;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.open.douyin.settings.C0130f;
import com.bytedance.security.android.aopcheck.env.AOPEnvironment;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.agilelogger.ALog;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SettingsRequestServiceImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/security/android/aopcheck/settings/SettingsRequestServiceImpl;", "Lcom/bytedance/news/common/settings/api/RequestService;", "()V", "executeSettingGet", "", "isApiSuccess", "", "o", "Lorg/json/JSONObject;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/news/common/settings/api/Response;", "Companion", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsRequestServiceImpl implements RequestService {
    private static final String TAG = "SettingsRequestService";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String BASE_URL = "https://is.snssdk.com/";
    private static final INetworkApi ttnetClient = (INetworkApi) RetrofitUtils.createSsService("https://is.snssdk.com/", INetworkApi.class);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0022 A[Catch: all -> 0x0077, JSONException -> 0x0089, TryCatch #2 {JSONException -> 0x0089, all -> 0x0077, blocks: (B:3:0x000b, B:5:0x0015, B:12:0x0022, B:15:0x003e, B:17:0x0046), top: B:2:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response request() {
        boolean z;
        JSONObject optJSONObject;
        Response response = new Response();
        try {
            String executeSettingGet = executeSettingGet();
            String str = executeSettingGet;
            if (str != null && str.length() != 0) {
                z = false;
                if (!z) {
                    return response;
                }
                ALog.i(TAG, "Settings response: " + executeSettingGet);
                JSONObject jSONObject = new JSONObject(executeSettingGet);
                if (!isApiSuccess(jSONObject) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                    return response;
                }
                SettingsData settingsData = new SettingsData(optJSONObject.optJSONObject("settings").optJSONObject("sdk_key_mobius_sdk"), (JSONObject) null);
                Response response2 = new Response();
                response2.settingsData = settingsData;
                response2.vidInfo = optJSONObject.optJSONObject(C0130f.f134g);
                response2.ctxInfos = optJSONObject.optString("ctx_infos");
                response2.success = true;
                return response2;
            }
            z = true;
            if (!z) {
            }
        } catch (JSONException e) {
            ALog.e(TAG, "Cannot approach here" + e);
            return response;
        } catch (Throwable th) {
            ALog.e(TAG, "Cannot approach here" + th);
            return response;
        }
    }

    public final boolean isApiSuccess(JSONObject o) throws JSONException {
        return o != null && Intrinsics.areEqual("success", o.optString("message"));
    }

    private final String executeSettingGet() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(Constant.KEY_CALL_NAME, Constant.SETTING_NAME);
            JSONObject headerInfo = AOPEnvironment.INSTANCE.getHeaderInfo();
            String optString = headerInfo.optString(Constant.KEY_HOST_AID);
            Intrinsics.checkExpressionValueIsNotNull(optString, "header.optString(Constant.KEY_HOST_AID)");
            hashMap.put(Constant.KEY_HOST_AID, optString);
            String optString2 = headerInfo.optString(Constant.KEY_HOST_AID);
            Intrinsics.checkExpressionValueIsNotNull(optString2, "header.optString(Constant.KEY_HOST_AID)");
            hashMap.put(Constant.KEY_APP_ID, optString2);
            String optString3 = headerInfo.optString("device_id");
            Intrinsics.checkExpressionValueIsNotNull(optString3, "header.optString(Constant.KEY_DEVICE_ID)");
            hashMap.put("device_id", optString3);
            hashMap.put("device_platform", "android");
            hashMap.put(Constant.KEY_DEVICE_TYPE, SiteMessageParams.platform);
            String optString4 = headerInfo.optString(Constant.KEY_UPDATE_VERSION_CODE);
            Intrinsics.checkExpressionValueIsNotNull(optString4, "header.optString(Constant.KEY_UPDATE_VERSION_CODE)");
            hashMap.put(Constant.KEY_UPDATE_VERSION_CODE, optString4);
            String str = Build.VERSION.RELEASE;
            Intrinsics.checkExpressionValueIsNotNull(str, "Build.VERSION.RELEASE");
            hashMap.put(Constant.KEY_OS_VERSION, str);
            hashMap.put(Constant.KEY_OS_API, String.valueOf(Build.VERSION.SDK_INT));
            String str2 = Build.MODEL;
            Intrinsics.checkExpressionValueIsNotNull(str2, "Build.MODEL");
            hashMap.put(Constant.KEY_DEVICE_MODEL, str2);
            String str3 = Build.BRAND;
            Intrinsics.checkExpressionValueIsNotNull(str3, "Build.BRAND");
            hashMap.put(Constant.KEY_DEVICE_BRAND, str3);
            String str4 = Build.MANUFACTURER;
            Intrinsics.checkExpressionValueIsNotNull(str4, "Build.MANUFACTURER");
            hashMap.put(Constant.KEY_DEVICE_MANUFACTURER, str4);
            String optString5 = headerInfo.optString(Constant.KEY_APP_VERSION);
            Intrinsics.checkExpressionValueIsNotNull(optString5, "header.optString(Constant.KEY_APP_VERSION)");
            hashMap.put("version_code", optString5);
            String optString6 = headerInfo.optString(Constant.KEY_AOP_CHECK_SDK_VERSION);
            Intrinsics.checkExpressionValueIsNotNull(optString6, "header.optString(Constan…EY_AOP_CHECK_SDK_VERSION)");
            hashMap.put(Constant.KEY_AOP_CHECK_SDK_VERSION, optString6);
            String optString7 = headerInfo.optString(Constant.KEY_CHANNEL);
            Intrinsics.checkExpressionValueIsNotNull(optString7, "header.optString(Constant.KEY_CHANNEL)");
            hashMap.put(Constant.KEY_CHANNEL, optString7);
            String execGet = INSTANCE.execGet("service/settings/v3/", hashMap);
            Log.d("AopCheckSettingsRequest", "body=" + execGet);
            return execGet;
        } catch (Throwable th) {
            Log.d("AopCheckSettingsRequest", "exception: " + th.getMessage());
            th.printStackTrace();
            return null;
        }
    }

    /* compiled from: SettingsRequestServiceImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/security/android/aopcheck/settings/SettingsRequestServiceImpl$Companion;", "", "()V", "BASE_URL", "", "getBASE_URL", "()Ljava/lang/String;", "setBASE_URL", "(Ljava/lang/String;)V", "TAG", "ttnetClient", "Lcom/bytedance/ttnet/INetworkApi;", "kotlin.jvm.PlatformType", "execGet", "relativePath", "queryMap", "", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getBASE_URL() {
            return SettingsRequestServiceImpl.BASE_URL;
        }

        public final void setBASE_URL(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            SettingsRequestServiceImpl.BASE_URL = str;
        }

        public final String execGet(String relativePath, Map<String, String> queryMap) {
            Intrinsics.checkParameterIsNotNull(queryMap, "queryMap");
            if (SettingsRequestServiceImpl.ttnetClient == null) {
                return null;
            }
            try {
                return (String) SettingsRequestServiceImpl.ttnetClient.doGet(false, 10485760, relativePath, queryMap, new LinkedList(), (Object) null).execute().body();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
