package com.edu.onetex.html;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlTagImageData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/edu/onetex/html/HtmlTagImageData;", "", "()V", "conversion", "", "getConversion", "()D", "setConversion", "(D)V", "height", "getHeight", "setHeight", "src", "", "getSrc", "()Ljava/lang/String;", "setSrc", "(Ljava/lang/String;)V", "width", "getWidth", "setWidth", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class HtmlTagImageData {
    private double conversion;
    private double height;
    private String src = "";
    private double width;

    public final String getSrc() {
        return this.src;
    }

    public final void setSrc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.src = str;
    }

    public final double getWidth() {
        return this.width;
    }

    public final void setWidth(double d) {
        this.width = d;
    }

    public final double getHeight() {
        return this.height;
    }

    public final void setHeight(double d) {
        this.height = d;
    }

    public final double getConversion() {
        return this.conversion;
    }

    public final void setConversion(double d) {
        this.conversion = d;
    }
}
