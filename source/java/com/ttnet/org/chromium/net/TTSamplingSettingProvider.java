package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("cronet")
/* loaded from: classes7.dex */
public abstract class TTSamplingSettingProvider {

    /* loaded from: classes7.dex */
    public static class TTSlaSamplingSetting {
        public TTEventLogSamplingRule mEventLogSamplingRule;
        public int mHostAid;
        public int mSdkAid;
        public TTSlaSamplingRule mSlaSamplingRule;

        public int getHostAid() {
            return this.mHostAid;
        }

        public int getSdkAid() {
            return this.mSdkAid;
        }

        public TTSlaSamplingRule getSlaSamplingRule() {
            return this.mSlaSamplingRule;
        }

        public TTEventLogSamplingRule getEventLogSamplingRule() {
            return this.mEventLogSamplingRule;
        }
    }

    /* loaded from: classes7.dex */
    public static class TTSlaSamplingRule {
        public boolean mEnableApiAllUpload;
        public boolean mEnableBaseApiAll;
        public String[] mHostPatternWhiteList;
        public String[] mPathContainWhiteList;
        public String[] mPathEqualWhiteList;
        public String[] mPathPrefixWhiteList;
        public String[] mPathRegexWhiteList;
        public String[] mUrlRegexBlackList;
        public String[] mUrlRegexWhiteList;

        public boolean isEnableBaseApiAll() {
            return this.mEnableBaseApiAll;
        }

        public boolean isEnableApiAllUpload() {
            return this.mEnableApiAllUpload;
        }

        public String[] getUrlRegexBlackList() {
            return this.mUrlRegexBlackList;
        }

        public String[] getPathEqualWhiteList() {
            return this.mPathEqualWhiteList;
        }

        public String[] getPathContainWhiteList() {
            return this.mPathContainWhiteList;
        }

        public String[] getPathPrefixWhiteList() {
            return this.mPathPrefixWhiteList;
        }

        public String[] getPathRegexWhiteList() {
            return this.mPathRegexWhiteList;
        }

        public String[] getUrlRegexWhiteList() {
            return this.mUrlRegexWhiteList;
        }

        public String[] getHostPatternWhiteList() {
            return this.mHostPatternWhiteList;
        }
    }

    /* loaded from: classes7.dex */
    public static class TTEventLogSamplingRule {
        public String[] mEventLogTypeWhiteList;

        public String[] getEventLogTypeWhiteList() {
            return this.mEventLogTypeWhiteList;
        }
    }
}
