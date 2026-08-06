package com.lynx.tasm;

import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class LynxConfigInfo {
    private final String mCliVersion;
    private final boolean mCssAlignWithLegacyW3c;
    private final String mCustomData;
    private final boolean mEnableCSSParser;
    private final boolean mEnableLepusNG;
    private final String mLepusVersion;
    private final String mPageType;
    private final String mPageVersion;
    private final String mRadonMode;
    private final String mReactVersion;
    private final Set<String> mRegisteredComponent;
    private final String mTargetSdkVersion;
    private final String mTemplateUrl;
    private final ThreadStrategyForRendering mThreadStrategyForRendering;

    private LynxConfigInfo(Builder builder) {
        this.mPageVersion = builder.mPageVersion;
        this.mPageType = builder.mPageType;
        this.mCliVersion = builder.mCliVersion;
        this.mCustomData = builder.mCustomData;
        this.mTemplateUrl = builder.mTemplateUrl;
        this.mTargetSdkVersion = builder.mTargetSdkVersion;
        this.mLepusVersion = builder.mLepusVersion;
        this.mThreadStrategyForRendering = builder.mThreadStrategyForRendering;
        this.mEnableLepusNG = builder.mEnableLepusNG;
        this.mRadonMode = builder.mRadonMode;
        this.mReactVersion = builder.mReactVersion;
        this.mRegisteredComponent = builder.mRegisteredComponent;
        this.mCssAlignWithLegacyW3c = builder.mCssAlignWithLegacyW3c;
        this.mEnableCSSParser = builder.mEnableCSSParser;
    }

    public String getPageVersion() {
        return this.mPageVersion;
    }

    public String getPageType() {
        return this.mPageType;
    }

    public String getCliVersion() {
        return this.mCliVersion;
    }

    public String getCustomData() {
        return this.mCustomData;
    }

    public String getTemplateUrl() {
        return this.mTemplateUrl;
    }

    public String getTargetSdkVersion() {
        return this.mTargetSdkVersion;
    }

    public String getLepusVersion() {
        return this.mLepusVersion;
    }

    public ThreadStrategyForRendering getThreadStrategyForRendering() {
        return this.mThreadStrategyForRendering;
    }

    public boolean isEnableLepusNG() {
        return this.mEnableLepusNG;
    }

    public String getRadonMode() {
        return this.mRadonMode;
    }

    public String getReactVersion() {
        return this.mReactVersion;
    }

    public Set<String> getRegisteredComponent() {
        return this.mRegisteredComponent;
    }

    public boolean getCssAlignWithLegacyW3c() {
        return this.mCssAlignWithLegacyW3c;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pageVersion", this.mPageVersion);
            jSONObject.put("pageType", this.mPageType);
            jSONObject.put("cliVersion", this.mCliVersion);
            jSONObject.put("customData", this.mCustomData);
            jSONObject.put("templateUrl", this.mTemplateUrl);
            jSONObject.put("targetSdkVersion", this.mTargetSdkVersion);
            jSONObject.put("lepusVersion", this.mLepusVersion);
            jSONObject.put("isEnableLepusNG", this.mEnableLepusNG);
            jSONObject.put("radonMode", this.mRadonMode);
            jSONObject.put("reactVersion", this.mReactVersion);
            ThreadStrategyForRendering threadStrategyForRendering = this.mThreadStrategyForRendering;
            jSONObject.put("threadStrategyForRendering", threadStrategyForRendering != null ? threadStrategyForRendering.id() : 0);
            jSONObject.put("registeredComponent", this.mRegisteredComponent);
            jSONObject.put("cssAlignWithLegacyW3c", this.mCssAlignWithLegacyW3c);
            jSONObject.put("cssParser", this.mEnableCSSParser);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private String mPageVersion = "error";
        private String mPageType = "error";
        private String mCliVersion = "error";
        private String mCustomData = "error";
        private String mTemplateUrl = "error";
        private String mTargetSdkVersion = "error";
        private String mLepusVersion = "error";
        private ThreadStrategyForRendering mThreadStrategyForRendering = null;
        private boolean mEnableLepusNG = false;
        private String mRadonMode = "error";
        private String mReactVersion = "error";
        private Set<String> mRegisteredComponent = null;
        private boolean mCssAlignWithLegacyW3c = false;
        private boolean mEnableCSSParser = false;

        public LynxConfigInfo buildLynxConfigInfo() {
            return new LynxConfigInfo(this);
        }

        public Builder setPageVersion(String str) {
            this.mPageVersion = str;
            return this;
        }

        public Builder setPageType(String str) {
            this.mPageType = str;
            return this;
        }

        public Builder setCliVersion(String str) {
            this.mCliVersion = str;
            return this;
        }

        public Builder setCustomData(String str) {
            this.mCustomData = str;
            return this;
        }

        public Builder setTemplateUrl(String str) {
            this.mTemplateUrl = str;
            return this;
        }

        public Builder setTargetSdkVersion(String str) {
            this.mTargetSdkVersion = str;
            return this;
        }

        public Builder setLepusVersion(String str) {
            this.mLepusVersion = str;
            return this;
        }

        public Builder setThreadStrategyForRendering(ThreadStrategyForRendering threadStrategyForRendering) {
            this.mThreadStrategyForRendering = threadStrategyForRendering;
            return this;
        }

        public Builder setEnableLepusNG(boolean z) {
            this.mEnableLepusNG = z;
            return this;
        }

        public Builder setRadonMode(String str) {
            this.mRadonMode = str;
            return this;
        }

        public Builder setReactVersion(String str) {
            this.mReactVersion = str;
            return this;
        }

        public Builder setRegisteredComponent(Set<String> set) {
            this.mRegisteredComponent = set;
            return this;
        }

        public Builder setCssAlignWithLegacyW3c(boolean z) {
            this.mCssAlignWithLegacyW3c = z;
            return this;
        }

        public Builder setEnableCSSParser(boolean z) {
            this.mEnableCSSParser = z;
            return this;
        }
    }
}
