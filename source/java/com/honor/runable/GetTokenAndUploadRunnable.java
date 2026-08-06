package com.honor.runable;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.Logger;
import com.hihonor.push.sdk.HonorPushCallback;
import com.hihonor.push.sdk.HonorPushClient;
import com.honor.HonorPushAdapter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class GetTokenAndUploadRunnable implements Runnable {
    public static final String TAG = "HonorPush";
    private final Context mContext;
    private final int mPushType = HonorPushAdapter.getHonorPush();
    private String mToken;

    public GetTokenAndUploadRunnable(Context context) {
        this.mContext = context;
    }

    public GetTokenAndUploadRunnable(Context context, String str) {
        this.mContext = context;
        this.mToken = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(this.mToken)) {
                HonorPushClient.getInstance().getPushToken(new HonorPushCallback<String>() { // from class: com.honor.runable.GetTokenAndUploadRunnable.1
                    @Override // com.hihonor.push.sdk.HonorPushCallback
                    public void onSuccess(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            GetTokenAndUploadRunnable.this.doUploadToken(str);
                        } else {
                            Logger.e(GetTokenAndUploadRunnable.TAG, "get honor token is null");
                            GetTokenAndUploadRunnable.this.getTokenError("-1", "token is empty");
                        }
                    }

                    @Override // com.hihonor.push.sdk.HonorPushCallback
                    public void onFailure(int i, String str) {
                        Logger.e(GetTokenAndUploadRunnable.TAG, "get honor error,errorCode:" + i + " errorString:" + str);
                        GetTokenAndUploadRunnable.this.getTokenError("" + i, str);
                    }
                });
            }
        } catch (Throwable th) {
            Logger.e(TAG, "get honor token err: " + th.getLocalizedMessage() + " stack:" + Log.getStackTraceString(th));
            getTokenError("-1", th.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUploadToken(String str) {
        PushSupporter.thirdService().registerSenderSuccessAndUploadToken(this.mContext, this.mPushType, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTokenError(String str, String str2) {
        PushSupporter.monitor().monitorRegisterSenderFailed(this.mPushType, 102, str, str2);
    }
}
