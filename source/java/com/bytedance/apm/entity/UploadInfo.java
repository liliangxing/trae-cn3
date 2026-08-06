package com.bytedance.apm.entity;

/* loaded from: classes3.dex */
public class UploadInfo {
    public static final long DEFAULT_SEND_DURATION = 600000;
    public String mKey;
    public long mLastSendTime;
    public boolean mUploading = false;

    public UploadInfo(String str, long j) {
        this.mKey = str;
        this.mLastSendTime = j;
    }

    public void setUploading(boolean z) {
        this.mUploading = z;
    }
}
