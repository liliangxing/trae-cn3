package io.noties.markwon.core.spans.codeblock;

import android.text.NoCopySpan;
import com.larus.business.markdown.api.model.ICodeCopyInfoSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeCopyInfoSpan.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\r¨\u0006\u000e"}, d2 = {"Lio/noties/markwon/core/spans/codeblock/CodeCopyInfoSpan;", "Landroid/text/NoCopySpan;", "Lcom/larus/business/markdown/api/model/ICodeCopyInfoSpan;", "codeInfo", "", "code", "isCompleted", "", "isShare", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getCode", "()Ljava/lang/String;", "getCodeInfo", "()Z", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class CodeCopyInfoSpan implements NoCopySpan, ICodeCopyInfoSpan {
    private final String code;
    private final String codeInfo;
    private final boolean isCompleted;
    private final boolean isShare;

    public CodeCopyInfoSpan(String codeInfo, String code, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(codeInfo, "codeInfo");
        Intrinsics.checkNotNullParameter(code, "code");
        this.codeInfo = codeInfo;
        this.code = code;
        this.isCompleted = z;
        this.isShare = z2;
    }

    @Override // com.larus.business.markdown.api.model.ICodeCopyInfoSpan
    public String getCodeInfo() {
        return this.codeInfo;
    }

    @Override // com.larus.business.markdown.api.model.ICodeCopyInfoSpan
    public String getCode() {
        return this.code;
    }

    @Override // com.larus.business.markdown.api.model.ICodeCopyInfoSpan
    /* renamed from: isCompleted, reason: from getter */
    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    @Override // com.larus.business.markdown.api.model.ICodeCopyInfoSpan
    /* renamed from: isShare, reason: from getter */
    public boolean getIsShare() {
        return this.isShare;
    }
}
