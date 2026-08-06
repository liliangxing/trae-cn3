package com.honor.runable;

import android.content.Context;
import com.bytedance.push.utils.Logger;
import com.hihonor.push.sdk.HonorPushCallback;
import com.hihonor.push.sdk.HonorPushClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HonorUnRegisterRunnable implements Runnable {
    private final String TAG = "HonorUnRegister";
    private final Context mContext;

    public HonorUnRegisterRunnable(Context context) {
        this.mContext = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            HonorPushClient.getInstance().deletePushToken(new HonorPushCallback<Void>() { // from class: com.honor.runable.HonorUnRegisterRunnable.1
                @Override // com.hihonor.push.sdk.HonorPushCallback
                public void onSuccess(Void r2) {
                    Logger.d("HonorUnRegister", "honor unregister success");
                }

                @Override // com.hihonor.push.sdk.HonorPushCallback
                public void onFailure(int i, String str) {
                    Logger.e("HonorUnRegister", "honor unregister failed,errorCode:errorCode" + i + " errorString:" + str);
                }
            });
            Logger.d("HonorUnRegister", "honor unregister success");
        } catch (Throwable th) {
            Logger.d("HonorUnRegister", "honor unregister failed", th);
        }
    }
}
