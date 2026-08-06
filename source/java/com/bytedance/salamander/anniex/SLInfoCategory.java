package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorEventTypingsInfoJsbPerfEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/salamander/anniex/SLInfoCategory;", "", "()V", "jsb_name", "", "getJsb_name", "()Ljava/lang/String;", "setJsb_name", "(Ljava/lang/String;)V", "jsb_protocol_version", "", "getJsb_protocol_version", "()I", "setJsb_protocol_version", "(I)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class SLInfoCategory {
    private String jsb_name = "";
    private int jsb_protocol_version = -1;

    public String getJsb_name() {
        return this.jsb_name;
    }

    public void setJsb_name(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jsb_name = str;
    }

    public int getJsb_protocol_version() {
        return this.jsb_protocol_version;
    }

    public void setJsb_protocol_version(int i) {
        this.jsb_protocol_version = i;
    }
}
