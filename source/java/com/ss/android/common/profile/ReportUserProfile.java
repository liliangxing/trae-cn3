package com.ss.android.common.profile;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.NetworkUtils;
import com.ss.android.common.applog.UserProfileHelper;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ReportUserProfile implements Runnable {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());
    private String apiKey;
    private final UserProfileHelper.UserProfileCallback callback;
    private Context context;
    private String data;
    private String url;

    public ReportUserProfile(String str, String str2, String str3, UserProfileHelper.UserProfileRetryCallback userProfileRetryCallback, Context context) {
        this.url = str;
        this.apiKey = str2;
        this.data = str3;
        this.callback = userProfileRetryCallback;
        this.context = context;
        userProfileRetryCallback.setRunnable(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!NetworkUtils.isNetworkAvailable(this.context)) {
                reportFail(0);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("X-APIKEY", this.apiKey);
            NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
            reqContext.addCommonParams = true;
            NetworkClient.getDefault().post(this.url, this.data.getBytes(), hashMap, reqContext);
            reportSuccess();
        } catch (Throwable th) {
            th.printStackTrace();
            reportFail(1);
        }
    }

    private void reportFail(final int i) {
        mHandler.post(new Runnable() { // from class: com.ss.android.common.profile.ReportUserProfile.1
            @Override // java.lang.Runnable
            public void run() {
                if (ReportUserProfile.this.callback != null) {
                    ReportUserProfile.this.callback.onFail(i);
                }
            }
        });
    }

    private void reportSuccess() {
        mHandler.post(new Runnable() { // from class: com.ss.android.common.profile.ReportUserProfile.2
            @Override // java.lang.Runnable
            public void run() {
                ReportUserProfile.this.callback.onSuccess();
            }
        });
    }
}
