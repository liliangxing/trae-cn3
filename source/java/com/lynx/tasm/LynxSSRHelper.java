package com.lynx.tasm;

import com.lynx.react.bridge.JavaOnlyArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxSSRHelper {
    private static final String CACHE_IDENTIFY = "from_ssr_cache";
    private SSRHydrateStatus mHydrateStatus = SSRHydrateStatus.UNDEFINED;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private enum SSRHydrateStatus {
        UNDEFINED,
        PENDING,
        STARTED,
        EXECUTING,
        FAILED,
        SUCCESSFUL
    }

    public void onLoadSSRDataStart() {
        this.mHydrateStatus = SSRHydrateStatus.PENDING;
    }

    public void onHydrateStart() {
        this.mHydrateStatus = SSRHydrateStatus.STARTED;
    }

    public void onHydrateExecuting() {
        this.mHydrateStatus = SSRHydrateStatus.EXECUTING;
    }

    public void onHydrateFinished() {
        this.mHydrateStatus = SSRHydrateStatus.SUCCESSFUL;
    }

    public void onErrorOccurred(int i, LynxError lynxError) {
        if (lynxError.getErrorCode() == 102) {
            this.mHydrateStatus = SSRHydrateStatus.FAILED;
        }
    }

    public boolean isHydrateStarted() {
        return this.mHydrateStatus == SSRHydrateStatus.STARTED;
    }

    public boolean isHydratePending() {
        return this.mHydrateStatus == SSRHydrateStatus.PENDING;
    }

    public JavaOnlyArray processEventParams(JavaOnlyArray javaOnlyArray) {
        if (javaOnlyArray == null) {
            javaOnlyArray = new JavaOnlyArray();
        }
        javaOnlyArray.pushString(CACHE_IDENTIFY);
        return javaOnlyArray;
    }

    public boolean shouldSendEventToSSR() {
        return this.mHydrateStatus == SSRHydrateStatus.PENDING || this.mHydrateStatus == SSRHydrateStatus.STARTED || this.mHydrateStatus == SSRHydrateStatus.EXECUTING || this.mHydrateStatus == SSRHydrateStatus.FAILED;
    }
}
