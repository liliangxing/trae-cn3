package com.bytedance.bdturing.sms;

import android.app.Activity;
import android.util.Log;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.utils.Consts;
import com.bytedance.bdturing.utils.JsonUtils;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.wschannel.WsConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SmsUtils {
    public static void sendCode(String str, Activity activity, String str2, int i, int i2, int i3, int i4, BdTuringCallback bdTuringCallback) {
        sendCode(str, activity, str2, i, i2, i3, i4, null, bdTuringCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static void sendCode(final String str, final Activity activity, final String str2, final int i, final int i2, final int i3, final int i4, final Map<String, Object> map, final BdTuringCallback bdTuringCallback) {
        final JSONObject jSONObject = new JSONObject();
        final BdTuringConfig config = BdTuring.getInstance().getConfig();
        if (config == null) {
            Log.e("SmsUtils", "sendCode error BdTuringConfig is null");
            if (bdTuringCallback != null) {
                JSONObject jSONObject2 = new JSONObject();
                JsonUtils.putValue(jSONObject2, "errorMsg", "sendCode error BdTuringConfig is nul");
                bdTuringCallback.onFail(-1, jSONObject2);
                return;
            }
            return;
        }
        try {
            jSONObject.put("mobile", str2);
            jSONObject.put(Api.KEY_TICKET_APP_ID, Integer.parseInt(config.getAppId()));
            try {
                jSONObject.put(WsConstants.KEY_CHANNEL_ID, i);
                try {
                    jSONObject.put("scene", i2);
                    try {
                        jSONObject.put("code_type", i4);
                        jSONObject.put(Api.KEY_LANGUAGE, config.getLanguage());
                        jSONObject.put("ac", NetworkUtils.getNetworkAccessType(activity.getApplicationContext()));
                        jSONObject.put(Api.KEY_APP_NAME, config.getAppName());
                        jSONObject.put("channel", config.getChannel());
                        jSONObject.put("device_brand", Consts.DEVICE_BRAND);
                        jSONObject.put("device_id", config.getDeviceId());
                        jSONObject.put("device_platform", Consts.OS_NAME);
                        jSONObject.put(Api.KEY_DEVICE_TYPE, Consts.DEVICE_MODEL);
                        jSONObject.put("iid", config.getInstallId());
                        jSONObject.put(Api.KEY_DPI, "" + ((int) (UtilsKt.getDensity(activity.getApplicationContext()) * 160.0f)));
                        jSONObject.put("manifest_version_code", "" + UtilsKt.getManifestVersionCode(activity.getApplicationContext()));
                        jSONObject.put("openudid", config.getOpenUdid());
                        jSONObject.put("os_api", "" + Consts.OS_API_VERSION);
                        jSONObject.put("os_version", Consts.SYSTEM_VERSION);
                        jSONObject.put("resolution", UtilsKt.getResolution());
                        jSONObject.put("version_code", config.getAppVersionCode());
                        jSONObject.put("version_name", config.getAppVersion());
                        try {
                            jSONObject.put("event_type", i3);
                            if (map != null && map.size() > 0) {
                                for (String str3 : map.keySet()) {
                                    jSONObject.put(str3, map.get(str3));
                                }
                            }
                        } catch (JSONException e) {
                            e = e;
                            e.printStackTrace();
                            final HashMap hashMap = new HashMap();
                            hashMap.put("Content-Type", "application/json");
                            VerifyTaskHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.bdturing.sms.SmsUtils.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        JSONObject jSONObject3 = new JSONObject(new String(BdTuringConfig.this.getHttpClient().post(str, hashMap, jSONObject.toString().getBytes()), Charsets.UTF_8));
                                        int optInt = jSONObject3.optInt(AlogMonitor.ALOG_RESULT_CODE, -1);
                                        String optString = jSONObject3.optJSONObject("data").optString("decision");
                                        if (optInt == 0) {
                                            if ("PASS".equals(optString)) {
                                                bdTuringCallback.onSuccess(0, jSONObject3);
                                                return;
                                            } else {
                                                BdTuring.getInstance().showVerifyDialog(activity, new RiskInfoRequest(optString), new BdTuringCallback() { // from class: com.bytedance.bdturing.sms.SmsUtils.1.1
                                                    @Override // com.bytedance.bdturing.BdTuringCallback
                                                    public void onFail(int i5, JSONObject jSONObject4) {
                                                        bdTuringCallback.onFail(i5, jSONObject4);
                                                    }

                                                    @Override // com.bytedance.bdturing.BdTuringCallback
                                                    public void onSuccess(int i5, JSONObject jSONObject4) {
                                                        SmsUtils.sendCode(str, activity, str2, i, i2, i3, i4, map, bdTuringCallback);
                                                    }
                                                });
                                                return;
                                            }
                                        }
                                        bdTuringCallback.onFail(optInt, jSONObject3);
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                        bdTuringCallback.onFail(3, null);
                                    }
                                }
                            });
                        }
                    } catch (JSONException e2) {
                        e = e2;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    final Map hashMap2 = new HashMap();
                    hashMap2.put("Content-Type", "application/json");
                    VerifyTaskHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.bdturing.sms.SmsUtils.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                JSONObject jSONObject3 = new JSONObject(new String(BdTuringConfig.this.getHttpClient().post(str, hashMap2, jSONObject.toString().getBytes()), Charsets.UTF_8));
                                int optInt = jSONObject3.optInt(AlogMonitor.ALOG_RESULT_CODE, -1);
                                String optString = jSONObject3.optJSONObject("data").optString("decision");
                                if (optInt == 0) {
                                    if ("PASS".equals(optString)) {
                                        bdTuringCallback.onSuccess(0, jSONObject3);
                                        return;
                                    } else {
                                        BdTuring.getInstance().showVerifyDialog(activity, new RiskInfoRequest(optString), new BdTuringCallback() { // from class: com.bytedance.bdturing.sms.SmsUtils.1.1
                                            @Override // com.bytedance.bdturing.BdTuringCallback
                                            public void onFail(int i5, JSONObject jSONObject4) {
                                                bdTuringCallback.onFail(i5, jSONObject4);
                                            }

                                            @Override // com.bytedance.bdturing.BdTuringCallback
                                            public void onSuccess(int i5, JSONObject jSONObject4) {
                                                SmsUtils.sendCode(str, activity, str2, i, i2, i3, i4, map, bdTuringCallback);
                                            }
                                        });
                                        return;
                                    }
                                }
                                bdTuringCallback.onFail(optInt, jSONObject3);
                            } catch (JSONException e22) {
                                e22.printStackTrace();
                                bdTuringCallback.onFail(3, null);
                            }
                        }
                    });
                }
            } catch (JSONException e4) {
                e = e4;
                e.printStackTrace();
                final Map hashMap22 = new HashMap();
                hashMap22.put("Content-Type", "application/json");
                VerifyTaskHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.bdturing.sms.SmsUtils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            JSONObject jSONObject3 = new JSONObject(new String(BdTuringConfig.this.getHttpClient().post(str, hashMap22, jSONObject.toString().getBytes()), Charsets.UTF_8));
                            int optInt = jSONObject3.optInt(AlogMonitor.ALOG_RESULT_CODE, -1);
                            String optString = jSONObject3.optJSONObject("data").optString("decision");
                            if (optInt == 0) {
                                if ("PASS".equals(optString)) {
                                    bdTuringCallback.onSuccess(0, jSONObject3);
                                    return;
                                } else {
                                    BdTuring.getInstance().showVerifyDialog(activity, new RiskInfoRequest(optString), new BdTuringCallback() { // from class: com.bytedance.bdturing.sms.SmsUtils.1.1
                                        @Override // com.bytedance.bdturing.BdTuringCallback
                                        public void onFail(int i5, JSONObject jSONObject4) {
                                            bdTuringCallback.onFail(i5, jSONObject4);
                                        }

                                        @Override // com.bytedance.bdturing.BdTuringCallback
                                        public void onSuccess(int i5, JSONObject jSONObject4) {
                                            SmsUtils.sendCode(str, activity, str2, i, i2, i3, i4, map, bdTuringCallback);
                                        }
                                    });
                                    return;
                                }
                            }
                            bdTuringCallback.onFail(optInt, jSONObject3);
                        } catch (JSONException e22) {
                            e22.printStackTrace();
                            bdTuringCallback.onFail(3, null);
                        }
                    }
                });
            }
        } catch (JSONException e5) {
            e = e5;
        }
        final Map hashMap222 = new HashMap();
        hashMap222.put("Content-Type", "application/json");
        VerifyTaskHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.bdturing.sms.SmsUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject3 = new JSONObject(new String(BdTuringConfig.this.getHttpClient().post(str, hashMap222, jSONObject.toString().getBytes()), Charsets.UTF_8));
                    int optInt = jSONObject3.optInt(AlogMonitor.ALOG_RESULT_CODE, -1);
                    String optString = jSONObject3.optJSONObject("data").optString("decision");
                    if (optInt == 0) {
                        if ("PASS".equals(optString)) {
                            bdTuringCallback.onSuccess(0, jSONObject3);
                            return;
                        } else {
                            BdTuring.getInstance().showVerifyDialog(activity, new RiskInfoRequest(optString), new BdTuringCallback() { // from class: com.bytedance.bdturing.sms.SmsUtils.1.1
                                @Override // com.bytedance.bdturing.BdTuringCallback
                                public void onFail(int i5, JSONObject jSONObject4) {
                                    bdTuringCallback.onFail(i5, jSONObject4);
                                }

                                @Override // com.bytedance.bdturing.BdTuringCallback
                                public void onSuccess(int i5, JSONObject jSONObject4) {
                                    SmsUtils.sendCode(str, activity, str2, i, i2, i3, i4, map, bdTuringCallback);
                                }
                            });
                            return;
                        }
                    }
                    bdTuringCallback.onFail(optInt, jSONObject3);
                } catch (JSONException e22) {
                    e22.printStackTrace();
                    bdTuringCallback.onFail(3, null);
                }
            }
        });
    }

    public static void checkCode(final String str, String str2, int i, String str3, final CheckCodeCallback checkCodeCallback) {
        final JSONObject jSONObject = new JSONObject();
        final BdTuringConfig config = BdTuring.getInstance().getConfig();
        if (config == null) {
            Log.e("SmsUtils", "checkCode error BdTuringConfig is null");
            return;
        }
        try {
            jSONObject.put("mobile", str2);
            jSONObject.put(Api.KEY_TICKET_APP_ID, Integer.parseInt(config.getAppId()));
            jSONObject.put("scene", i);
            jSONObject.put(AlogMonitor.ALOG_RESULT_CODE, str3);
            jSONObject.put(Api.KEY_LANGUAGE, config.getLanguage());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        VerifyTaskHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.bdturing.sms.SmsUtils.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2;
                try {
                    jSONObject2 = new JSONObject(new String(BdTuringConfig.this.getHttpClient().post(str, hashMap, jSONObject.toString().getBytes()), Charsets.UTF_8));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    jSONObject2 = null;
                }
                checkCodeCallback.check(jSONObject2);
            }
        });
    }
}
