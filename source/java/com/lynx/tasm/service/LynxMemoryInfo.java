package com.lynx.tasm.service;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes7.dex */
public class LynxMemoryInfo {
    public static final String TYPE_IMAGE = "image";
    private String address;
    private long completeDuration;
    private String config;
    private long fetchDuration;
    private long finishTimeStamp;
    private long height;
    private int isFlattenAnim;
    private int isSuccess;
    private float memoryCost;
    private String parentAddress;
    private String phase;
    private String resourceURL;
    private String sessionId;
    private long startTimeStamp;
    private String templateURL;
    private String type;
    private long viewHeight;
    private long viewWidth;
    private long width;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface LynxMemoryType {
    }

    public long getFetchDuration() {
        return this.fetchDuration;
    }

    public long getFinishTimeStamp() {
        return this.finishTimeStamp;
    }

    public long getCompleteDuration() {
        return this.completeDuration;
    }

    public long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getPhase() {
        return this.phase;
    }

    public String getTemplateURL() {
        return this.templateURL;
    }

    public String getType() {
        return this.type;
    }

    public float getMemoryCost() {
        return this.memoryCost;
    }

    public long getViewWidth() {
        return this.viewWidth;
    }

    public long getViewHeight() {
        return this.viewHeight;
    }

    public String getAddress() {
        return this.address;
    }

    public String getParentAddress() {
        return this.parentAddress;
    }

    public long getWidth() {
        return this.width;
    }

    public long getHeight() {
        return this.height;
    }

    public String getConfig() {
        return this.config;
    }

    public String getResourceURL() {
        return this.resourceURL;
    }

    public int getIsSuccess() {
        return this.isSuccess;
    }

    public int getIsFlattenAnim() {
        return this.isFlattenAnim;
    }

    private LynxMemoryInfo(Builder builder) {
        this.fetchDuration = 0L;
        this.finishTimeStamp = 0L;
        this.completeDuration = 0L;
        this.startTimeStamp = 0L;
        this.sessionId = "";
        this.phase = "";
        this.templateURL = "";
        this.type = "";
        this.memoryCost = 0.0f;
        this.viewWidth = 0L;
        this.viewHeight = 0L;
        this.address = "";
        this.parentAddress = "";
        this.width = 0L;
        this.height = 0L;
        this.config = "";
        this.resourceURL = "";
        this.isSuccess = 0;
        this.isFlattenAnim = 0;
        this.fetchDuration = builder.fetchDuration;
        this.finishTimeStamp = builder.finishTimeStamp;
        this.completeDuration = builder.completeDuration;
        this.startTimeStamp = builder.startTimeStamp;
        if (builder.sessionId != null) {
            this.sessionId = builder.sessionId;
        }
        if (builder.phase != null) {
            this.phase = builder.phase;
        }
        if (builder.templateURL != null) {
            this.templateURL = builder.templateURL;
        }
        if (builder.type != null) {
            this.type = builder.type;
        }
        this.memoryCost = builder.memoryCost;
        this.viewHeight = builder.viewHeight;
        this.viewWidth = builder.viewWidth;
        if (builder.address != null) {
            this.address = builder.address;
        }
        if (builder.parentAddress != null) {
            this.parentAddress = builder.parentAddress;
        }
        this.width = builder.width;
        this.height = builder.height;
        if (builder.config != null) {
            this.config = builder.config;
        }
        if (builder.resourceURL != null) {
            this.resourceURL = builder.resourceURL;
        }
        this.isSuccess = builder.isSuccess;
        this.isFlattenAnim = builder.isFlattenAnim;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        private long fetchDuration = 0;
        private long finishTimeStamp = 0;
        private long completeDuration = 0;
        private long startTimeStamp = 0;
        private String sessionId = "";
        private String phase = "";
        private String templateURL = "";
        private String type = "";
        private float memoryCost = 0.0f;
        private long viewWidth = -1;
        private long viewHeight = -1;
        private String address = "";
        private String parentAddress = "";
        private long width = -1;
        private long height = -1;
        private String config = "";
        private String resourceURL = "";
        private int isSuccess = 1;
        private int isFlattenAnim = 0;

        public Builder fetchDuration(long j) {
            this.fetchDuration = j;
            return this;
        }

        public Builder finishTimeStamp(long j) {
            this.finishTimeStamp = j;
            return this;
        }

        public Builder completeDuration(long j) {
            this.completeDuration = j;
            return this;
        }

        public Builder startTimeStamp(long j) {
            this.startTimeStamp = j;
            return this;
        }

        public Builder sessionId(String str) {
            this.sessionId = str;
            return this;
        }

        public Builder phase(String str) {
            this.phase = str;
            return this;
        }

        public Builder templateURL(String str) {
            if (TextUtils.isEmpty(str)) {
                this.templateURL = "";
            } else {
                this.templateURL = str;
            }
            return this;
        }

        public Builder type(String str) {
            this.type = str;
            return this;
        }

        public Builder memoryCost(float f) {
            this.memoryCost = f;
            return this;
        }

        public Builder viewWidth(long j) {
            this.viewWidth = j;
            return this;
        }

        public Builder viewHeight(long j) {
            this.viewHeight = j;
            return this;
        }

        public Builder address(String str) {
            this.address = str;
            return this;
        }

        public Builder parentAddress(String str) {
            this.parentAddress = str;
            return this;
        }

        public Builder width(long j) {
            this.width = j;
            return this;
        }

        public Builder height(long j) {
            this.height = j;
            return this;
        }

        public Builder config(String str) {
            this.config = str;
            return this;
        }

        public Builder resourceURL(String str) {
            this.resourceURL = str;
            return this;
        }

        public Builder isSuccess(int i) {
            this.isSuccess = i;
            return this;
        }

        public Builder isFlattenAnim(int i) {
            this.isFlattenAnim = i;
            return this;
        }

        public LynxMemoryInfo build() {
            return new LynxMemoryInfo(this);
        }
    }
}
