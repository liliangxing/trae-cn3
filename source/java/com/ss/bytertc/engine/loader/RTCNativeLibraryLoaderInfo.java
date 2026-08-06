package com.ss.bytertc.engine.loader;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class RTCNativeLibraryLoaderInfo {
    private static final String TAG = "RTCNativeLibraryLoaderInfo";
    private String mSdkVersion = "";
    private Long mLoadTimeStampMs = 0L;
    private String mLoaderClassName = "";
    private int mLoadTimes = 0;
    private boolean mIsLoadSuccess = false;

    public void setSdkVersion(String sdkVersion) {
        this.mSdkVersion = sdkVersion;
    }

    public void setLoadTimeStampMs(long loadTimeStampMs) {
        this.mLoadTimeStampMs = Long.valueOf(loadTimeStampMs);
    }

    public void setLoaderClassName(String loaderClassName) {
        this.mLoaderClassName = loaderClassName;
    }

    public void setLoadResult(boolean isLoadSuccess) {
        this.mIsLoadSuccess = isLoadSuccess;
    }

    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public long getLoadTimeStamp() {
        return this.mLoadTimeStampMs.longValue();
    }

    public String getLoaderClassName() {
        return this.mLoaderClassName;
    }

    public void loadLibrary() {
        this.mLoadTimes++;
    }

    public boolean isLoadSuccess() {
        return this.mIsLoadSuccess;
    }

    public String toString() {
        return "RTCNativeLibraryLoaderInfo{SdkVersion='" + this.mSdkVersion + "', LoadTimeStamp=" + this.mLoadTimeStampMs + ", LoaderClassName='" + this.mLoaderClassName + "', LoadTimes=" + this.mLoadTimes + ", IsLoadSuccess=" + this.mIsLoadSuccess + AbstractJsonLexerKt.END_OBJ;
    }
}
