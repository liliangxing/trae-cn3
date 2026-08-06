package com.larus.business.markdown.api;

import kotlin.Metadata;

/* compiled from: IFullScreenDetailSpan.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/api/IFullScreenDetailSpan;", "", "content", "", "getContent", "()Ljava/lang/String;", "copyContent", "getCopyContent", "info", "getInfo", "isCompleted", "", "()Z", "isPreview", "type", "Lcom/larus/business/markdown/api/FullScreenDetailType;", "getType", "()Lcom/larus/business/markdown/api/FullScreenDetailType;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface IFullScreenDetailSpan {
    String getContent();

    String getCopyContent();

    String getInfo();

    FullScreenDetailType getType();

    boolean isCompleted();

    boolean isPreview();
}
