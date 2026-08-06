package com.lynx.tasm.service;

import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxImageInfo {
    private final int errorCode;
    private final long finishTimeStamp;
    private final boolean hitMemoryCache;
    private final boolean isSuccess;
    private final WeakReference<LynxView> lynxView;
    private final int memoryCost;
    private final long startTimeStamp;
    private final String url;

    public long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public long getFinishTimeStamp() {
        return this.finishTimeStamp;
    }

    public boolean getIsSuccess() {
        return this.isSuccess;
    }

    public String getUrl() {
        return this.url;
    }

    public int getMemoryCost() {
        return this.memoryCost;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public LynxView getLynxView() {
        return this.lynxView.get();
    }

    public boolean getHitMemoryCache() {
        return this.hitMemoryCache;
    }

    private LynxImageInfo(Builder builder) {
        this.startTimeStamp = builder.startTimeStamp;
        this.finishTimeStamp = builder.finishTimeStamp;
        this.isSuccess = builder.isSuccess;
        this.url = builder.url;
        this.memoryCost = builder.memoryCost;
        this.errorCode = builder.errorCode;
        this.lynxView = new WeakReference<>(builder.lynxView);
        this.hitMemoryCache = builder.hitMemoryCache;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Builder {
        private long startTimeStamp = 0;
        private long finishTimeStamp = 0;
        private boolean isSuccess = false;
        private String url = null;
        private int memoryCost = 0;
        private int errorCode = 0;
        private LynxView lynxView = null;
        private boolean hitMemoryCache = false;

        public Builder startTimeStamp(long j) {
            this.startTimeStamp = j;
            return this;
        }

        public Builder finishTimeStamp(long j) {
            this.finishTimeStamp = j;
            return this;
        }

        public Builder isSuccess(boolean z) {
            this.isSuccess = z;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder memoryCost(int i) {
            this.memoryCost = i;
            return this;
        }

        public Builder errorCode(int i) {
            this.errorCode = i;
            return this;
        }

        public Builder lynxView(LynxView lynxView) {
            this.lynxView = lynxView;
            return this;
        }

        public Builder hitMemoryCache(boolean z) {
            this.hitMemoryCache = z;
            return this;
        }

        public LynxImageInfo build() {
            return new LynxImageInfo(this);
        }
    }
}
