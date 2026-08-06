package com.bytedance.ies.bullet.core.kit;

import android.net.Uri;
import kotlin.Metadata;

/* compiled from: Fallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/Fallback;", "", "()V", "fallback", "Landroid/net/Uri;", "getFallback", "()Landroid/net/Uri;", "setFallback", "(Landroid/net/Uri;)V", "fallbackReason", "", "getFallbackReason", "()Ljava/lang/String;", "setFallbackReason", "(Ljava/lang/String;)V", "prev", "getPrev", "setPrev", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class Fallback {
    private Uri fallback;
    private String fallbackReason;
    private Uri prev;

    public final Uri getPrev() {
        return this.prev;
    }

    public final void setPrev(Uri uri) {
        this.prev = uri;
    }

    public final Uri getFallback() {
        return this.fallback;
    }

    public final void setFallback(Uri uri) {
        this.fallback = uri;
    }

    public final String getFallbackReason() {
        return this.fallbackReason;
    }

    public final void setFallbackReason(String str) {
        this.fallbackReason = str;
    }
}
