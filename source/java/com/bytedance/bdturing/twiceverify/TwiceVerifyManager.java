package com.bytedance.bdturing.twiceverify;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.ttnet.HttpClient;
import com.bytedance.bdturing.twiceverify.TwiceVerifyDepend;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.EcafRequest;
import com.bytedance.bdturing.verify.request.InfoVerifyRequest;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TwiceVerifyManager {
    public static final String PATH_VERIFY_AUTH_TICKET = "/passport/safe/verify_auth_ticket/";
    private static volatile TwiceVerifyManager sIns;
    private TwiceVerifyConfig config;
    private TwiceVerifyDepend mDepend;
    private AbstractRequest mRequest;
    private VerifyCallBack mVerifyCallBack;
    private TwiceVerifyDepend.TwiceVerifyCertVerifyCallback mVerifyCertCallback = new TwiceVerifyDepend.TwiceVerifyCertVerifyCallback() { // from class: com.bytedance.bdturing.twiceverify.TwiceVerifyManager.1
        @Override // com.bytedance.bdturing.twiceverify.TwiceVerifyDepend.TwiceVerifyCertVerifyCallback
        public void onSucc() {
            TwiceVerifyManager.this.mVerifyCallBack.onSuccess();
            TwiceVerifyManager.this.onDestroy();
        }

        @Override // com.bytedance.bdturing.twiceverify.TwiceVerifyDepend.TwiceVerifyCertVerifyCallback
        public void onVerifyAuthTicket(String str, String str2, Map<String, String> map) {
            String host = TwiceVerifyManager.this.getDepend() != null ? TwiceVerifyManager.this.getDepend().host() : "";
            String str3 = TextUtils.isEmpty(host) ? "" : host + TwiceVerifyManager.PATH_VERIFY_AUTH_TICKET;
            TwiceVerifyManager twiceVerifyManager = TwiceVerifyManager.this;
            twiceVerifyManager.requestVerifyAuthTicket(str3, twiceVerifyManager.addParams(str, str2, map));
            TwiceVerifyManager.this.onDestroy();
        }

        @Override // com.bytedance.bdturing.twiceverify.TwiceVerifyDepend.TwiceVerifyCertVerifyCallback
        public void onFailed(int i, String str) {
            TwiceVerifyManager.this.mVerifyCallBack.onError(i, str);
            TwiceVerifyManager.this.onDestroy();
        }
    };

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface VerifyCallBack {
        void onError(int i, String str);

        void onSuccess();
    }

    public static TwiceVerifyManager getInstance() {
        if (sIns == null) {
            synchronized (TwiceVerifyManager.class) {
                sIns = new TwiceVerifyManager();
            }
        }
        return sIns;
    }

    public void init(TwiceVerifyDepend twiceVerifyDepend) {
        this.mDepend = twiceVerifyDepend;
    }

    public void setConfig(TwiceVerifyConfig twiceVerifyConfig) {
        this.config = twiceVerifyConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startVerify(AbstractRequest abstractRequest, HashMap<String, String> hashMap, VerifyCallBack verifyCallBack) {
        this.mVerifyCallBack = verifyCallBack;
        if (abstractRequest instanceof InfoVerifyRequest) {
            if (getDepend() != null) {
                getDepend().showCertVerify(hashMap, this.mVerifyCertCallback);
                return;
            }
            VerifyCallBack verifyCallBack2 = this.mVerifyCallBack;
            if (verifyCallBack2 != null) {
                verifyCallBack2.onError(-1, "start showCertVerify fail TwiceVerifyDepend is null");
                return;
            }
            return;
        }
        if (abstractRequest instanceof EcafRequest) {
            if (getDepend() != null) {
                getDepend().showCertLiveVerify(hashMap, this.mVerifyCertCallback);
                return;
            }
            VerifyCallBack verifyCallBack3 = this.mVerifyCallBack;
            if (verifyCallBack3 != null) {
                verifyCallBack3.onError(-1, "start showCertLiveVerify fail TwiceVerifyDepend is null");
                return;
            }
            return;
        }
        this.mRequest = abstractRequest;
        Activity activity = abstractRequest.getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.setClass(activity, SettingsManager.INSTANCE.getH5loadRetryEnable() ? TwiceVerifyWebActivityV2.class : TwiceVerifyWebActivity.class);
            activity.startActivity(intent);
        } else {
            VerifyCallBack verifyCallBack4 = this.mVerifyCallBack;
            if (verifyCallBack4 != null) {
                verifyCallBack4.onError(-1, "start verify error activity is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestVerifyAuthTicket(String str, String str2) {
        try {
            HttpClient httpClient = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getHttpClient() : null;
            if (httpClient == null) {
                Log.e("TwiceVerifyManager", "requestVerifyAuthTicket error httpClient is Null");
                return;
            }
            JSONObject jSONObject = new JSONObject(new String(httpClient.post(str, null, str2.getBytes()), Charsets.UTF_8));
            String optString = jSONObject.optString("message");
            if (jSONObject.has("data") && !TextUtils.isEmpty(optString)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if ("success".equals(optString)) {
                    int optInt = optJSONObject.optInt("check_result");
                    if (optInt == 1) {
                        this.mVerifyCallBack.onSuccess();
                        return;
                    } else {
                        this.mVerifyCallBack.onError(optInt, "verify error");
                        return;
                    }
                }
                int optInt2 = optJSONObject.has("error_code") ? optJSONObject.optInt("error_code") : -2;
                if (optJSONObject.has("description")) {
                    optString = optJSONObject.optString("description");
                }
                this.mVerifyCallBack.onError(optInt2, optString);
                return;
            }
            this.mVerifyCallBack.onError(-2, "network error");
        } catch (Exception e) {
            this.mVerifyCallBack.onError(-2, "network error");
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String addParams(String str, String str2, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("auth_ticket", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("scene", str2);
            }
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean checkInit() {
        return this.mDepend != null;
    }

    public TwiceVerifyDepend getDepend() {
        return this.mDepend;
    }

    public TwiceVerifyConfig getConfig() {
        return this.config;
    }

    public VerifyCallBack getVerifyCallBack() {
        return this.mVerifyCallBack;
    }

    public AbstractRequest getRequest() {
        return this.mRequest;
    }

    public void onDestroy() {
        this.mVerifyCallBack = null;
        this.mRequest = null;
    }
}
