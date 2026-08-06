package com.bytedance.praisedialoglib.request;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.praisedialoglib.manager.PraiseDialogCfgManager;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class GetDialogEnableThread implements Runnable {
    public static final String PATH_GET_DIALOG_ENABLE = "/zebra/praise";
    private static final int SHOW_DIALOG = 0;
    private static final String TAG = "GetDialogEnableThread";
    private static final int UNKNOWN = -1;
    private IGetDialogEnableListener mListener;
    private String mUid;

    /* loaded from: classes4.dex */
    public interface IGetDialogEnableListener {
        void onFailed(int i, String str);

        void onSucceed(String str);
    }

    public GetDialogEnableThread(String str, IGetDialogEnableListener iGetDialogEnableListener) {
        this.mUid = str;
        this.mListener = iGetDialogEnableListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.mUid);
            String host = PraiseDialogCfgManager.getInstance().getHost();
            if (TextUtils.isEmpty(host)) {
                return;
            }
            String executePost = PraiseDialogCfgManager.getInstance().executePost(20480, host + PATH_GET_DIALOG_ENABLE, hashMap);
            Log.d(TAG, "response is " + executePost);
            if (TextUtils.isEmpty(executePost)) {
                this.mListener.onFailed(-1, "http response is null");
                return;
            }
            JSONObject jSONObject = new JSONObject(executePost);
            int optInt = jSONObject.optInt("errCode");
            jSONObject.optString("message");
            String optString = jSONObject.optString("data");
            if (jSONObject.optInt("dialogShow", -1) == 0) {
                this.mListener.onSucceed(optString);
            } else {
                this.mListener.onFailed(optInt, optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.mListener.onFailed(-1, "meet exception");
        }
    }
}
