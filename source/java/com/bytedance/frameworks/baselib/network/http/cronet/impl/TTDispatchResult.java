package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class TTDispatchResult {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Exception mDispatchException;
    public final DispatchState mDispatchState;
    public final String mEpoch;
    public final String mEtag;
    public final String mFinalUrl;
    public final String mOriginalUrl;
    public final String mTTNetOriginHost;

    /* loaded from: classes2.dex */
    public enum DispatchState {
        SUCCESS,
        INVALID_ORIGIN_URL,
        CRONET_NOT_INIT,
        TIMEOUT,
        INVALID_FINAL_URL,
        WRONG_FORMAT,
        OKHTTP_DISPATCH_FAILED,
        NOT_REACHED
    }

    public TTDispatchResult(String str, DispatchState dispatchState, Exception exc) {
        this.mOriginalUrl = str;
        this.mFinalUrl = str;
        this.mEpoch = "0";
        this.mEtag = "0";
        this.mDispatchState = dispatchState;
        this.mDispatchException = exc;
        this.mTTNetOriginHost = "";
    }

    public TTDispatchResult(String str, String str2, String str3, String str4, DispatchState dispatchState, String str5) {
        this.mOriginalUrl = str;
        this.mFinalUrl = str2;
        if (!TextUtils.isEmpty(str3)) {
            this.mEpoch = str3;
        } else {
            this.mEpoch = "0";
        }
        if (!TextUtils.isEmpty(str4)) {
            this.mEtag = str4;
        } else {
            this.mEtag = "0";
        }
        if (!TextUtils.isEmpty(str5)) {
            this.mTTNetOriginHost = str5;
        } else {
            this.mTTNetOriginHost = "";
        }
        this.mDispatchState = dispatchState;
        this.mDispatchException = null;
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

    public DispatchState getDispatchState() {
        return this.mDispatchState;
    }

    public Exception getDispatchException() {
        return this.mDispatchException;
    }
}
