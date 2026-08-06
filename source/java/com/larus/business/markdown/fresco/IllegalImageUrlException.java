package com.larus.business.markdown.fresco;

import kotlin.Metadata;

/* compiled from: IllegalImageUrlException.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/business/markdown/fresco/IllegalImageUrlException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class IllegalImageUrlException extends IllegalArgumentException {
    private final String url;

    public IllegalImageUrlException(String str) {
        super(str);
        this.url = str;
    }

    public final String getUrl() {
        return this.url;
    }
}
