package com.bytedance.ies.bullet.kit.web;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WebKitView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/WebLoadError;", "", "errorCode", "", "description", "", "failingUrl", "(ILjava/lang/CharSequence;Ljava/lang/CharSequence;)V", "getDescription", "()Ljava/lang/CharSequence;", "getErrorCode", "()I", "getFailingUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class WebLoadError extends Throwable {
    private final CharSequence description;
    private final int errorCode;
    private final CharSequence failingUrl;

    public /* synthetic */ WebLoadError(int i, CharSequence charSequence, CharSequence charSequence2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : charSequence, (i2 & 4) != 0 ? null : charSequence2);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final CharSequence getDescription() {
        return this.description;
    }

    public final CharSequence getFailingUrl() {
        return this.failingUrl;
    }

    public WebLoadError(int i, CharSequence charSequence, CharSequence charSequence2) {
        super("WebLoadError, errorCode: " + i + ", desc: " + ((Object) charSequence) + ", failingUrl: " + ((Object) charSequence2));
        this.errorCode = i;
        this.description = charSequence;
        this.failingUrl = charSequence2;
    }
}
