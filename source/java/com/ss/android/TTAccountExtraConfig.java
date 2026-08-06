package com.ss.android;

import com.ss.android.token.TTTokenManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTAccountExtraConfig {
    private InnerExceptionCatcher innerExceptionCatcher;
    private long mUpdateInfoInterval = 600000;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface InnerExceptionCatcher {
        void onException(Throwable th);
    }

    public long getUpdateInfoInterval() {
        return this.mUpdateInfoInterval;
    }

    public TTAccountExtraConfig setUpdateInfoInterval(long j) {
        this.mUpdateInfoInterval = j;
        return this;
    }

    public void setInnerExceptionCatcher(final InnerExceptionCatcher innerExceptionCatcher) {
        this.innerExceptionCatcher = innerExceptionCatcher;
        TTTokenManager.setExceptionCatcher(new TTTokenManager.IExceptionCatcher() { // from class: com.ss.android.TTAccountExtraConfig.1
            @Override // com.ss.android.token.TTTokenManager.IExceptionCatcher
            public void onException(Throwable th) {
                innerExceptionCatcher.onException(th);
            }
        });
    }

    public InnerExceptionCatcher getInnerExceptionCatcher() {
        return this.innerExceptionCatcher;
    }
}
