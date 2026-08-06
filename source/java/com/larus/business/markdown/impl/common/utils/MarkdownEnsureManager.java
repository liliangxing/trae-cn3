package com.larus.business.markdown.impl.common.utils;

import com.larus.business.markdown.api.MarkdownService;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkdownEnsureManager.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/impl/common/utils/MarkdownEnsureManager;", "Lcom/larus/business/markdown/api/depend/IMarkdownEnsureManager;", "()V", "ensureNotReachHere", "", "t", "", "msg", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkdownEnsureManager implements IMarkdownEnsureManager {
    @Override // com.larus.business.markdown.api.depend.IMarkdownEnsureManager
    public void ensureNotReachHere(Throwable t, String msg) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(msg, "msg");
        IMarkdownEnsureManager markdownEnsureManager = MarkdownService.INSTANCE.getMarkdownEnsureManager();
        if (markdownEnsureManager != null) {
            markdownEnsureManager.ensureNotReachHere(t, msg);
        }
    }
}
