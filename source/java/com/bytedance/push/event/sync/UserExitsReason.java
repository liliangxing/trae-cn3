package com.bytedance.push.event.sync;

/* loaded from: classes4.dex */
public enum UserExitsReason {
    BACK("back"),
    HOME(ISignalReportConstants.EXITS_REASON_HOME);

    public String exitsReasonStr;

    UserExitsReason(String str) {
        this.exitsReasonStr = str;
    }
}
