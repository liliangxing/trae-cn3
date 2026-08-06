package com.bytedance.ug.sdk.share.impl.network.model;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.apm.constant.ReportProtocal;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class SignInfo implements Serializable {
    private static final int CONTINUE_SHARE = 0;
    private static final int DISCONTINUE_SHARE = 1;

    @SerializedName(ReportProtocal.KEY_LOG_ID)
    private String mLogId;

    @SerializedName("signature")
    private String mSignature;

    @SerializedName(StrategyConstants.STRATEGY)
    private int mStrategy = 0;

    public String getSignature() {
        return this.mSignature;
    }

    public void setSignature(String str) {
        this.mSignature = str;
    }

    public int getStrategy() {
        return this.mStrategy;
    }

    public void setStrategy(int i) {
        this.mStrategy = i;
    }

    public String getLogId() {
        return this.mLogId;
    }

    public void setLogId(String str) {
        this.mLogId = str;
    }

    public boolean continueShare() {
        return this.mStrategy == 0;
    }
}
