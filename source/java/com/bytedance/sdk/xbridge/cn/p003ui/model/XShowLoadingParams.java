package com.bytedance.sdk.xbridge.cn.p003ui.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XShowLoadingParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/model/XShowLoadingParams;", "", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class XShowLoadingParams {
    private String text;

    public static /* synthetic */ XShowLoadingParams copy$default(XShowLoadingParams xShowLoadingParams, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = xShowLoadingParams.text;
        }
        return xShowLoadingParams.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final XShowLoadingParams copy(String text) {
        return new XShowLoadingParams(text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof XShowLoadingParams) && Intrinsics.areEqual(this.text, ((XShowLoadingParams) other).text);
    }

    public int hashCode() {
        String str = this.text;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "XShowLoadingParams(text=" + this.text + ')';
    }

    public XShowLoadingParams(String str) {
        this.text = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }
}
