package com.bytedance.bdturing.methods;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.ttnet.HttpClient;
import com.bytedance.bdturing.twiceverify.TwiceVerifyManager;
import com.bytedance.bdturing.utils.Consts;
import com.bytedance.bdturing.utils.UtilsKt;
import java.util.HashMap;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TwiceVerifyHandler implements IVerifyInnerHandler {
    public static final String CLOSE = "second_verify.close";
    public static final String FETCH = "second_verify.fetch";
    public static final String GET_SETTINGS = "bytedcert.getSettings";
    public static final String H5_AVAILABLE = "second_verify.h5_available";
    public static final String HIDE_LOADING = "second_verify.hideLoading";
    public static final String IS_SMS_AVAILABLE = "second_verify.isSmsAvailable";
    public static final String OPEN_SMS = "second_verify.openSms";
    public static final String SDK_INFO = "bytedcert.getSdkInfo";
    public static final String SHOW_LOADING = "second_verify.showLoading";
    public static final String TOAST = "second_verify.toast";
    private Activity mActivity;

    public void getSdkInfo(JsCallParser jsCallParser) {
    }

    public void onClose(int i, String str) {
    }

    public void onH5Available() {
    }

    public TwiceVerifyHandler(Activity activity) {
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putCommonParams(JSONObject jSONObject, BdTuringConfig bdTuringConfig, Activity activity) throws JSONException {
        if (bdTuringConfig != null) {
            if (!jSONObject.has(Api.KEY_APP_NAME)) {
                jSONObject.put(Api.KEY_APP_NAME, bdTuringConfig.getAppName());
            }
            if (!jSONObject.has("app_version")) {
                jSONObject.put("app_version", bdTuringConfig.getAppVersion());
            }
            if (!jSONObject.has("version_code")) {
                jSONObject.put("version_code", bdTuringConfig.getAppVersionCode());
            }
            if (!jSONObject.has("version_name")) {
                jSONObject.put("version_name", bdTuringConfig.getAppVersion());
            }
            if (!jSONObject.has("aid")) {
                jSONObject.put("aid", bdTuringConfig.getAppId());
            }
            if (!jSONObject.has("iid")) {
                jSONObject.put("iid", bdTuringConfig.getInstallId());
            }
            if (!jSONObject.has("device_id")) {
                jSONObject.put("device_id", bdTuringConfig.getDeviceId());
            }
            if (!jSONObject.has("device_model")) {
                jSONObject.put("device_model", bdTuringConfig.getDeviceModel());
            }
            if (!jSONObject.has("device_brand")) {
                jSONObject.put("device_brand", bdTuringConfig.getDeviceBrand());
            }
            if (!jSONObject.has("os_type")) {
                jSONObject.put("os_type", bdTuringConfig.getOsType());
            }
            if (!jSONObject.has("os_version")) {
                jSONObject.put("os_version", bdTuringConfig.getOsVersion());
            }
            if (!jSONObject.has("channel")) {
                jSONObject.put("channel", bdTuringConfig.getChannel());
            }
            if (!jSONObject.has("region") && bdTuringConfig.getRegionType() != null) {
                jSONObject.put("region", bdTuringConfig.getRegionType().getName());
            }
            if (!jSONObject.has("sdk_version")) {
                jSONObject.put("sdk_version", bdTuringConfig.getSdkVersion());
            }
            if (!jSONObject.has(Api.KEY_LANGUAGE)) {
                jSONObject.put(Api.KEY_LANGUAGE, bdTuringConfig.getLanguage());
            }
            if (!jSONObject.has("locale")) {
                jSONObject.put("locale", bdTuringConfig.getLocale());
            }
        }
        if (!jSONObject.has(OaidModel.KEY_TIME)) {
            jSONObject.put(OaidModel.KEY_TIME, System.currentTimeMillis());
        }
        if (!jSONObject.has("device_platform")) {
            jSONObject.put("device_platform", Consts.OS_NAME);
        }
        if (jSONObject.has("resolution")) {
            return;
        }
        jSONObject.put("resolution", UtilsKt.getResolution());
    }

    @Override // com.bytedance.bdturing.methods.IVerifyInnerHandler
    public void handle(JsCallParser jsCallParser) {
        char c;
        try {
            if (jsCallParser.mFuncName == null) {
                return;
            }
            String str = jsCallParser.mFuncName;
            switch (str.hashCode()) {
                case -440027648:
                    if (str.equals("bytedcert.getSdkInfo")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -433891794:
                    if (str.equals(CLOSE)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -431325456:
                    if (str.equals(FETCH)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -418116003:
                    if (str.equals(TOAST)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -294538015:
                    if (str.equals(H5_AVAILABLE)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -268991152:
                    if (str.equals(HIDE_LOADING)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 103102532:
                    if (str.equals(IS_SMS_AVAILABLE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 239578933:
                    if (str.equals(SHOW_LOADING)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 428780843:
                    if (str.equals("bytedcert.getSettings")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1807041893:
                    if (str.equals(OPEN_SMS)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    fetch(jsCallParser);
                    return;
                case 1:
                    JSONObject jSONObject = new JSONObject(jsCallParser.mParams);
                    onClose(jSONObject.optInt("status_code"), jSONObject.optString("message"));
                    return;
                case 2:
                    if (TwiceVerifyManager.getInstance().getDepend() != null) {
                        TwiceVerifyManager.getInstance().getDepend().dismissLoading();
                        return;
                    }
                    return;
                case 3:
                    showToast(new JSONObject(jsCallParser.mParams).optString("text"));
                    return;
                case 4:
                    showLoading(new JSONObject(jsCallParser.mParams).optString("text"));
                    return;
                case 5:
                    jsCallParser.response(1, null);
                    return;
                case 6:
                    JSONObject jSONObject2 = new JSONObject(jsCallParser.mParams);
                    openSms(jSONObject2.optString("phone_number"), jSONObject2.optString("sms_content"));
                    return;
                case 7:
                    getSettings(jsCallParser);
                    return;
                case '\b':
                    getSdkInfo(jsCallParser);
                    return;
                case '\t':
                    onH5Available();
                    return;
                default:
                    return;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getSettings(JsCallParser jsCallParser) {
        jsCallParser.response(1, BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getTheme(4) : null);
    }

    public void openSms(String str, String str2) {
        if (this.mActivity != null) {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            this.mActivity.startActivity(intent);
        }
    }

    public void showLoading(String str) {
        if (this.mActivity == null || TwiceVerifyManager.getInstance().getDepend() == null) {
            return;
        }
        TwiceVerifyManager.getInstance().getDepend().showLoading(this.mActivity, str);
    }

    public void showToast(String str) {
        Activity activity = this.mActivity;
        if (activity != null) {
            Toast.makeText(activity, str, 0).show();
        }
    }

    public void fetch(final JsCallParser jsCallParser) {
        try {
            final JSONObject jSONObject = new JSONObject(jsCallParser.mParams);
            VerifyTaskHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.bdturing.methods.TwiceVerifyHandler.1
                /* JADX WARN: Can't wrap try/catch for region: R(14:1|(3:37|38|(11:40|(2:(2:9|10)|6)|11|12|(1:14)(1:32)|15|(1:17)(5:(1:25)|26|(1:28)(1:31)|29|30)|18|19|20|21))|3|(0)|11|12|(0)(0)|15|(0)(0)|18|19|20|21|(1:(0))) */
                /* JADX WARN: Code restructure failed: missing block: B:33:0x00e8, code lost:
                
                    r1 = new java.lang.StringBuilder("data = ");
                 */
                /* JADX WARN: Code restructure failed: missing block: B:34:0x00cd, code lost:
                
                    r1 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:35:0x00ce, code lost:
                
                    com.bytedance.bdturing.LogUtil.m160d("BDFetch", "data = " + r0.toString());
                    r3.response(1, r0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:36:0x00e7, code lost:
                
                    throw r1;
                 */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0063 A[Catch: all -> 0x00cd, Exception -> 0x00e8, TRY_ENTER, TryCatch #4 {Exception -> 0x00e8, all -> 0x00cd, blocks: (B:14:0x0063, B:15:0x006e, B:17:0x008e, B:18:0x00c1, B:25:0x00a0, B:26:0x00a4, B:28:0x00aa, B:29:0x00ae, B:30:0x00b6, B:32:0x0068), top: B:12:0x0061 }] */
                /* JADX WARN: Removed duplicated region for block: B:17:0x008e A[Catch: all -> 0x00cd, Exception -> 0x00e8, TryCatch #4 {Exception -> 0x00e8, all -> 0x00cd, blocks: (B:14:0x0063, B:15:0x006e, B:17:0x008e, B:18:0x00c1, B:25:0x00a0, B:26:0x00a4, B:28:0x00aa, B:29:0x00ae, B:30:0x00b6, B:32:0x0068), top: B:12:0x0061 }] */
                /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[Catch: all -> 0x00cd, Exception -> 0x00e8, TryCatch #4 {Exception -> 0x00e8, all -> 0x00cd, blocks: (B:14:0x0063, B:15:0x006e, B:17:0x008e, B:18:0x00c1, B:25:0x00a0, B:26:0x00a4, B:28:0x00aa, B:29:0x00ae, B:30:0x00b6, B:32:0x0068), top: B:12:0x0061 }] */
                /* JADX WARN: Removed duplicated region for block: B:5:0x0043  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    JSONObject jSONObject2;
                    StringBuilder sb;
                    String str;
                    JSONObject jSONObject3 = new JSONObject();
                    String optString = jSONObject.optString("url");
                    String optString2 = jSONObject.optString("method");
                    String optString3 = jSONObject.optString("params");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    boolean optBoolean = jSONObject.optBoolean("needCommonParams");
                    if (optString3 != null) {
                        try {
                        } catch (Exception unused) {
                            jSONObject2 = null;
                        }
                        if (!optString3.isEmpty()) {
                            jSONObject2 = new JSONObject(optString3);
                            if (optBoolean) {
                                if (jSONObject2 == null) {
                                    try {
                                        jSONObject2 = new JSONObject();
                                    } catch (Exception unused2) {
                                    }
                                }
                                BdTuringConfig config = BdTuring.getInstance().getConfig();
                                TwiceVerifyHandler twiceVerifyHandler = TwiceVerifyHandler.this;
                                twiceVerifyHandler.putCommonParams(jSONObject2, config, twiceVerifyHandler.mActivity);
                            }
                            if (jSONObject2 == null) {
                                sb = UtilsKt.appendUrlParams(optString, jSONObject2);
                            } else {
                                sb = new StringBuilder(optString);
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                            HttpClient httpClient = BdTuring.getInstance().getConfig().getHttpClient();
                            if (!"get".equals(optString2)) {
                                str = new String(httpClient.get(sb.toString(), hashMap), Charsets.UTF_8);
                            } else {
                                StringBuilder convertJson2Form = optJSONObject != null ? UtilsKt.convertJson2Form(optJSONObject) : null;
                                str = new String(httpClient.post(sb.toString(), hashMap, (convertJson2Form != null ? convertJson2Form.toString() : "").getBytes()), Charsets.UTF_8);
                            }
                            jSONObject3.put(ApmTrafficStats.TTNET_RESPONSE, str);
                            StringBuilder sb2 = new StringBuilder("data = ");
                            LogUtil.m160d("BDFetch", sb2.append(jSONObject3.toString()).toString());
                            jsCallParser.response(1, jSONObject3);
                        }
                    }
                    jSONObject2 = null;
                    if (optBoolean) {
                    }
                    if (jSONObject2 == null) {
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("Content-Type", "application/x-www-form-urlencoded");
                    HttpClient httpClient2 = BdTuring.getInstance().getConfig().getHttpClient();
                    if (!"get".equals(optString2)) {
                    }
                    jSONObject3.put(ApmTrafficStats.TTNET_RESPONSE, str);
                    StringBuilder sb22 = new StringBuilder("data = ");
                    LogUtil.m160d("BDFetch", sb22.append(jSONObject3.toString()).toString());
                    jsCallParser.response(1, jSONObject3);
                }
            });
        } catch (Exception unused) {
        }
    }
}
