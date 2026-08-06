package com.facebook.net;

import android.net.Uri;
import com.bytedance.ttnet.http.RequestContext;
import java.util.List;

/* loaded from: classes6.dex */
public class FrescoRequestContext extends RequestContext {
    private final List<Uri> mBackupUris;
    private final int mRetryCount;

    public FrescoRequestContext() {
        this.mBackupUris = null;
        this.mRetryCount = 0;
    }

    public FrescoRequestContext(List<Uri> list) {
        this.mBackupUris = list;
        this.mRetryCount = 0;
    }

    public FrescoRequestContext(List<Uri> list, int i) {
        this.mBackupUris = list;
        this.mRetryCount = i;
    }

    public List<Uri> getBackupUris() {
        return this.mBackupUris;
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }
}
