package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorSettingsHybridSettingsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/salamander/anniex/BidRegex;", "", "bid", "", "regex", "(Ljava/lang/String;Ljava/lang/String;)V", "getBid", "()Ljava/lang/String;", "setBid", "(Ljava/lang/String;)V", "getRegex", "setRegex", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class BidRegex {
    private String bid;
    private String regex;

    public String getBid() {
        return this.bid;
    }

    public void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.regex = str;
    }

    public BidRegex(String bid, String regex) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(regex, "regex");
        this.bid = "";
        this.regex = "";
        setBid(bid);
        setRegex(regex);
    }
}
