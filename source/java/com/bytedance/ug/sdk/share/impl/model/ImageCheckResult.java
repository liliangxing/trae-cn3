package com.bytedance.ug.sdk.share.impl.model;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class ImageCheckResult {
    private String mFilePath;
    private String mHiddenStr;
    private boolean mIsFromVideo;
    private String mQrScan;

    public ImageCheckResult(String str, String str2, String str3, boolean z) {
        this.mFilePath = str;
        this.mQrScan = str2;
        this.mHiddenStr = str3;
        this.mIsFromVideo = z;
    }

    public String getQrScan() {
        return this.mQrScan;
    }

    public String getHiddenStr() {
        return this.mHiddenStr;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public boolean isFromVideo() {
        return this.mIsFromVideo;
    }

    public String getCommand() {
        if (TextUtils.isEmpty(this.mQrScan)) {
            return !TextUtils.isEmpty(this.mHiddenStr) ? this.mHiddenStr : "";
        }
        return this.mQrScan;
    }
}
