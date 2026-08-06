package com.bytedance.praisedialoglib.request;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.praisedialoglib.manager.PraiseDialogCfgManager;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class GetXiaomiDeeplinkThread implements Runnable {
    public static boolean IS_REQUESTING = false;
    public static final String PATH_GET_XIAOMI_DEEPLINK = "/zebra/praise/url";
    private static final String TAG = "GetXiaomiDeeplinkThread";
    private static final int UNKNOWN = -1;
    private IGetXiaomiDeeplinkListener mListener;

    /* loaded from: classes4.dex */
    public interface IGetXiaomiDeeplinkListener {
        void onFailed(int i, String str);

        void onSucceed(String str);
    }

    public GetXiaomiDeeplinkThread(IGetXiaomiDeeplinkListener iGetXiaomiDeeplinkListener) {
        this.mListener = iGetXiaomiDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            HashMap hashMap = new HashMap();
            String host = PraiseDialogCfgManager.getInstance().getHost();
            if (TextUtils.isEmpty(host)) {
                return;
            }
            hashMap.put("package_name", PraiseDialogCfgManager.getInstance().getPackageName());
            hashMap.put("app_id", PraiseDialogCfgManager.getInstance().getAppId());
            hashMap.put("token", "WGzRHALelikNBSunxKOJhZyBWtAqZCEAcZYTuXzpLRX");
            hashMap.put("source", "window");
            String executePost = PraiseDialogCfgManager.getInstance().executePost(20480, host + PATH_GET_XIAOMI_DEEPLINK, hashMap);
            Log.d(TAG, "response is " + executePost);
            if (TextUtils.isEmpty(executePost)) {
                this.mListener.onFailed(-1, "http response is null");
                return;
            }
            JSONObject jSONObject = new JSONObject(executePost);
            int optInt = jSONObject.optInt("code");
            String optString = jSONObject.optString("message");
            if (optInt == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                String optString2 = optJSONObject != null ? optJSONObject.optString("deep_link") : "";
                if (!TextUtils.isEmpty(optString2)) {
                    this.mListener.onSucceed(optString2);
                    return;
                } else {
                    this.mListener.onFailed(optInt, optString);
                    return;
                }
            }
            this.mListener.onFailed(optInt, optString);
        } catch (Throwable th) {
            th.printStackTrace();
            this.mListener.onFailed(-1, "meet exception");
        }
    }
}
