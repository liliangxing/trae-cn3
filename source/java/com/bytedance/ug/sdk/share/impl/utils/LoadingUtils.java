package com.bytedance.ug.sdk.share.impl.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.p008ui.IShareProgressView;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LoadingUtils {
    private static int mDelayLoadingTime = -1;
    private static Handler mHandler;
    private static IShareProgressView mProgressDialog;

    public static void showProgressDialog(final ShareContent shareContent) {
        if (mDelayLoadingTime < 0) {
            mDelayLoadingTime = ShareConfigManager.getInstance().getImageDownloadLoadingDelay();
        }
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
        }
        mHandler.postDelayed(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.utils.LoadingUtils.1
            @Override // java.lang.Runnable
            public void run() {
                Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
                if (topActivity == null) {
                    return;
                }
                try {
                    if (LoadingUtils.mProgressDialog == null) {
                        ShareContent shareContent2 = ShareContent.this;
                        if (shareContent2 != null) {
                            IShareProgressView unused = LoadingUtils.mProgressDialog = shareContent2.getShareProgressView();
                        }
                        if (LoadingUtils.mProgressDialog == null) {
                            IShareProgressView unused2 = LoadingUtils.mProgressDialog = ShareConfigManager.getInstance().getShareProgressView(topActivity);
                        }
                    }
                    if (LoadingUtils.mProgressDialog == null || LoadingUtils.mProgressDialog.isShowing()) {
                        return;
                    }
                    LoadingUtils.mProgressDialog.show();
                } catch (Exception e) {
                    Logger.m465e(e.toString());
                }
            }
        }, mDelayLoadingTime);
    }

    public static void dismissProgressDialog() {
        Handler handler = mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            mHandler.post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.utils.LoadingUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (LoadingUtils.mProgressDialog != null && LoadingUtils.mProgressDialog.isShowing()) {
                                LoadingUtils.mProgressDialog.dismiss();
                            }
                        } catch (Exception e) {
                            Logger.m465e(e.toString());
                        }
                    } finally {
                        IShareProgressView unused = LoadingUtils.mProgressDialog = null;
                    }
                }
            });
        }
    }
}
