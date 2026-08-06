package com.bytedance.crash.protector;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ProtectorConfigBuilder {
    private String mScope;
    private String mAbi = null;
    private JSONArray mSignals = null;
    private JSONArray mBacktraces = null;
    private JSONObject mRegs = null;
    private int mMaxIgnoreDepth = -1;
    private int mMaxResumeCount = -1;
    private int mIntervalTimeMs = -1;
    private int mMinApiLevel = -1;
    private int mMaxApiLevel = -1;

    /* loaded from: classes3.dex */
    public enum AbiType {
        BOTH(0),
        ARM64_V8A(1),
        ARMEABI_V7A(2);

        private final int value;

        AbiType(int i) {
            this.value = i;
        }

        int getValue() {
            return this.value;
        }
    }

    public ProtectorConfigBuilder(String str) throws Exception {
        this.mScope = null;
        if (str == null || !CrashProtectorConfig.isValidScopeName(str)) {
            throw new IllegalArgumentException("invalid scope: " + str);
        }
        this.mScope = str;
    }

    public ProtectorConfigBuilder addSignal(String str) throws Exception {
        if (this.mSignals == null) {
            this.mSignals = new JSONArray();
        }
        if (CrashProtectorConfig.signalStringToNumber(str) == 0) {
            throw new IllegalArgumentException("invalid signal: " + str);
        }
        this.mSignals.put(str);
        return this;
    }

    public ProtectorConfigBuilder addFrame(String str) throws Exception {
        return addFrame(str, null, false);
    }

    public ProtectorConfigBuilder addFrame(String str, String str2) throws Exception {
        return addFrame(str, str2, false);
    }

    public ProtectorConfigBuilder addFrame(String str, String str2, boolean z) throws Exception {
        if (this.mBacktraces == null) {
            this.mBacktraces = new JSONArray();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("elf_name", str);
        if (str2 == null || str2.isEmpty()) {
            jSONObject.put("redacted_match", 1);
        } else {
            jSONObject.put("symbol_name", str2);
        }
        if (z) {
            jSONObject.put("return_from_current_stack", 1);
        }
        this.mBacktraces.put(jSONObject);
        return this;
    }

    public ProtectorConfigBuilder addRegister(String str, long j) throws Exception {
        if (this.mRegs == null) {
            this.mRegs = new JSONObject();
        }
        if (!CrashProtectorConfig.isValidRegLabel(str)) {
            throw new IllegalArgumentException("invalid register label: " + str);
        }
        this.mRegs.put(str, j);
        return this;
    }

    public ProtectorConfigBuilder setMaxIgnoreDepthBeforeMeetFirstMatch(int i) {
        this.mMaxIgnoreDepth = i;
        return this;
    }

    public ProtectorConfigBuilder setMaxResumeCount(int i) {
        this.mMaxResumeCount = i;
        return this;
    }

    public ProtectorConfigBuilder setIntervalTimeMs(int i) {
        this.mIntervalTimeMs = i;
        return this;
    }

    public ProtectorConfigBuilder setMinApiLevel(int i) {
        this.mMinApiLevel = i;
        return this;
    }

    public ProtectorConfigBuilder setMaxApiLevel(int i) {
        this.mMaxApiLevel = i;
        return this;
    }

    public ProtectorConfigBuilder setAbiType(AbiType abiType) {
        int value = abiType.getValue();
        if (value != AbiType.BOTH.value) {
            if (value != AbiType.ARM64_V8A.value) {
                if (value == AbiType.ARMEABI_V7A.value) {
                    this.mAbi = "armeabi-v7a";
                }
            } else {
                this.mAbi = "arm64-v8a";
            }
        } else {
            this.mAbi = "both";
        }
        return this;
    }

    public JSONObject build() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("scope", this.mScope);
        JSONArray jSONArray = this.mSignals;
        if (jSONArray == null || jSONArray.length() == 0) {
            throw new Exception("empty signals");
        }
        jSONObject.put("signals", this.mSignals);
        JSONArray jSONArray2 = this.mBacktraces;
        if (jSONArray2 == null || jSONArray2.length() == 0) {
            throw new Exception("empty backtraces");
        }
        jSONObject.put("backtraces", this.mBacktraces);
        JSONObject jSONObject2 = this.mRegs;
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            jSONObject.put("registers", this.mRegs);
        }
        int i = this.mMaxIgnoreDepth;
        if (i != -1) {
            jSONObject.put("max_ignore_depth_before_meet_first_match", i);
        }
        int i2 = this.mMaxResumeCount;
        if (i2 != -1) {
            jSONObject.put("max_resume_count", i2);
        }
        int i3 = this.mIntervalTimeMs;
        if (i3 != -1) {
            jSONObject.put("interval_time_ms", i3);
        }
        int i4 = this.mMinApiLevel;
        if (i4 != -1) {
            jSONObject.put("min_api_level", i4);
        }
        int i5 = this.mMaxApiLevel;
        if (i5 != -1) {
            jSONObject.put("max_api_level", i5);
        }
        String str = this.mAbi;
        if (str != null && !str.isEmpty()) {
            jSONObject.put("abi", this.mAbi);
        }
        return jSONObject;
    }
}
