package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "", "mode", "", "(Ljava/lang/Integer;)V", "enable", "", "getEnable", "()Z", "isReportOnly", "getMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "useResult", "getUseResult", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ArgusSwitch {
    public static final int OFF = 0;
    public static final int ON = 2;
    public static final int REPORT_ONLY = 1;
    private final boolean enable;
    private final boolean isReportOnly;
    private final Integer mode;
    private final boolean useResult;

    public ArgusSwitch(Integer num) {
        this.mode = num;
        boolean z = false;
        this.enable = (num != null && num.intValue() == 2) || (num != null && num.intValue() == 1);
        this.useResult = num != null && num.intValue() == 2;
        if (num != null && num.intValue() == 1) {
            z = true;
        }
        this.isReportOnly = z;
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getUseResult() {
        return this.useResult;
    }

    /* renamed from: isReportOnly, reason: from getter */
    public final boolean getIsReportOnly() {
        return this.isReportOnly;
    }
}
