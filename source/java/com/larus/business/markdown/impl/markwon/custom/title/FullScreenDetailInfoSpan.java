package com.larus.business.markdown.impl.markwon.custom.title;

import android.text.NoCopySpan;
import com.larus.business.markdown.api.FullScreenDetailType;
import com.larus.business.markdown.api.IFullScreenDetailSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullScreenDetailInfoSpan.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/custom/title/FullScreenDetailInfoSpan;", "Landroid/text/NoCopySpan;", "Lcom/larus/business/markdown/api/IFullScreenDetailSpan;", "info", "", "content", "copyContent", "type", "Lcom/larus/business/markdown/api/FullScreenDetailType;", "isCompleted", "", "isPreview", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/business/markdown/api/FullScreenDetailType;ZZ)V", "getContent", "()Ljava/lang/String;", "getCopyContent", "getInfo", "()Z", "getType", "()Lcom/larus/business/markdown/api/FullScreenDetailType;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class FullScreenDetailInfoSpan implements NoCopySpan, IFullScreenDetailSpan {
    private final String content;
    private final String copyContent;
    private final String info;
    private final boolean isCompleted;
    private final boolean isPreview;
    private final FullScreenDetailType type;

    public FullScreenDetailInfoSpan(String info, String content, String copyContent, FullScreenDetailType type, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(copyContent, "copyContent");
        Intrinsics.checkNotNullParameter(type, "type");
        this.info = info;
        this.content = content;
        this.copyContent = copyContent;
        this.type = type;
        this.isCompleted = z;
        this.isPreview = z2;
    }

    public /* synthetic */ FullScreenDetailInfoSpan(String str, String str2, String str3, FullScreenDetailType fullScreenDetailType, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, fullScreenDetailType, z, (i & 32) != 0 ? false : z2);
    }

    @Override // com.larus.business.markdown.api.IFullScreenDetailSpan
    public String getInfo() {
        return this.info;
    }

    @Override // com.larus.business.markdown.api.IFullScreenDetailSpan
    public String getContent() {
        return this.content;
    }

    @Override // com.larus.business.markdown.api.IFullScreenDetailSpan
    public String getCopyContent() {
        return this.copyContent;
    }

    @Override // com.larus.business.markdown.api.IFullScreenDetailSpan
    public FullScreenDetailType getType() {
        return this.type;
    }

    @Override // com.larus.business.markdown.api.IFullScreenDetailSpan
    /* renamed from: isCompleted, reason: from getter */
    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    @Override // com.larus.business.markdown.api.IFullScreenDetailSpan
    /* renamed from: isPreview, reason: from getter */
    public boolean getIsPreview() {
        return this.isPreview;
    }
}
