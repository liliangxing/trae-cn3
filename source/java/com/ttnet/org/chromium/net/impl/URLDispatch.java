package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes7.dex */
public class URLDispatch {
    public static final String KEY_EPOCH = "epoch";
    public static final String KEY_ETAG = "etag";
    public static final String KEY_FINAL_URL = "final_url";
    public static final String KEY_TTNET_ORIGIN_HOST = "ttnet_origin_host";
    private static final String TAG = "URLDispatch";
    private static final int TIME_OUT_MILLISECONDS = 300;
    private String mEpoch;
    private String mEtag;
    private String mFinalUrl;
    private MessageLoop mMessageLoop = new MessageLoop();
    private String mOriginalUrl;
    private String mTTNetOriginHost;

    public URLDispatch(String str) {
        this.mOriginalUrl = str;
    }

    public void waitResult(int i) throws IOException {
        MessageLoop messageLoop = this.mMessageLoop;
        if (i <= 0) {
            i = 300;
        }
        messageLoop.loop(i);
    }

    public void resume(Runnable runnable) {
        try {
            this.mMessageLoop.execute(runnable);
        } catch (RejectedExecutionException e) {
            Log.e(TAG, "Exception URLDispatch resume ", e);
        }
    }

    public void done() {
        this.mMessageLoop.quit();
    }

    public void setResult(String str, String str2, String str3, String str4) {
        this.mFinalUrl = str;
        this.mEtag = str2;
        this.mEpoch = str3;
        this.mTTNetOriginHost = str4;
    }

    public String getOriginalUrl() {
        return this.mOriginalUrl;
    }

    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    public String getEpoch() {
        return this.mEpoch;
    }

    public String getEtag() {
        return this.mEtag;
    }

    public String getTTNetOriginHost() {
        return this.mTTNetOriginHost;
    }
}
