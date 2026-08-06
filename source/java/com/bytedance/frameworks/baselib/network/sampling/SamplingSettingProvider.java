package com.bytedance.frameworks.baselib.network.sampling;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public class SamplingSettingProvider {

    /* loaded from: classes2.dex */
    public static class SlaSamplingSetting {
        private SlaEventLogSamplingRule mEventLogSamplingRule;
        private int mHostAid;
        private SlaSamplingRule mSamplingRule;
        private int mSdkAid;

        public SlaSamplingSetting(int i, SlaSamplingRule slaSamplingRule, SlaEventLogSamplingRule slaEventLogSamplingRule) {
            this(i, 0, slaSamplingRule, slaEventLogSamplingRule);
        }

        public SlaSamplingSetting(int i, int i2, SlaSamplingRule slaSamplingRule, SlaEventLogSamplingRule slaEventLogSamplingRule) {
            this.mHostAid = i;
            this.mSdkAid = i2;
            this.mSamplingRule = slaSamplingRule;
            this.mEventLogSamplingRule = slaEventLogSamplingRule;
        }

        public int getHostAid() {
            return this.mHostAid;
        }

        public int getSdkAid() {
            return this.mSdkAid;
        }

        public SlaSamplingRule getSlaSamplingRule() {
            return this.mSamplingRule;
        }

        public SlaEventLogSamplingRule getSlaEventLogSamplingRule() {
            return this.mEventLogSamplingRule;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SlaSamplingSetting slaSamplingSetting = (SlaSamplingSetting) obj;
            return this.mHostAid == slaSamplingSetting.mHostAid && this.mSdkAid == slaSamplingSetting.mSdkAid && Objects.equals(this.mSamplingRule, slaSamplingSetting.mSamplingRule) && Objects.equals(this.mEventLogSamplingRule, slaSamplingSetting.mEventLogSamplingRule);
        }
    }

    /* loaded from: classes2.dex */
    public static class SlaSamplingRule {
        private boolean mEnableApiAllUpload;
        private boolean mEnableBaseApiAll;
        private String[] mHostPatternWhiteList;
        private String[] mPathContainWhiteList;
        private String[] mPathEqualWhiteList;
        private String[] mPathPrefixWhiteList;
        private String[] mPathRegexWhiteList;
        private String[] mUrlRegexBlackList;
        private String[] mUrlRegexWhiteList;

        public SlaSamplingRule(boolean z, boolean z2, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
            this.mEnableBaseApiAll = z;
            this.mEnableApiAllUpload = z2;
            this.mUrlRegexBlackList = strArr;
            this.mPathEqualWhiteList = strArr2;
            this.mPathContainWhiteList = strArr3;
            this.mPathPrefixWhiteList = strArr4;
            this.mPathRegexWhiteList = strArr5;
            this.mUrlRegexWhiteList = strArr6;
            this.mHostPatternWhiteList = strArr7;
        }

        public boolean getEnableBaseApiAll() {
            return this.mEnableBaseApiAll;
        }

        public boolean getEnableApiAllUpload() {
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

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SlaSamplingRule slaSamplingRule = (SlaSamplingRule) obj;
            return this.mEnableBaseApiAll == slaSamplingRule.mEnableBaseApiAll && this.mEnableApiAllUpload == slaSamplingRule.mEnableApiAllUpload && Arrays.equals(this.mUrlRegexBlackList, slaSamplingRule.mUrlRegexBlackList) && Arrays.equals(this.mPathEqualWhiteList, slaSamplingRule.mPathEqualWhiteList) && Arrays.equals(this.mPathContainWhiteList, slaSamplingRule.mPathContainWhiteList) && Arrays.equals(this.mPathPrefixWhiteList, slaSamplingRule.mPathPrefixWhiteList) && Arrays.equals(this.mPathRegexWhiteList, slaSamplingRule.mPathRegexWhiteList) && Arrays.equals(this.mUrlRegexWhiteList, slaSamplingRule.mUrlRegexWhiteList) && Arrays.equals(this.mHostPatternWhiteList, slaSamplingRule.mHostPatternWhiteList);
        }
    }

    /* loaded from: classes2.dex */
    public static class SlaEventLogSamplingRule {
        private String[] mEventLogTypeWhiteList;

        public SlaEventLogSamplingRule(String[] strArr) {
            this.mEventLogTypeWhiteList = strArr;
        }

        public String[] getEventLogTypeWhiteList() {
            return this.mEventLogTypeWhiteList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Arrays.equals(this.mEventLogTypeWhiteList, ((SlaEventLogSamplingRule) obj).mEventLogTypeWhiteList);
        }
    }
}
