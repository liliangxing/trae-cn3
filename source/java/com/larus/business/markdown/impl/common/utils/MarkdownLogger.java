package com.larus.business.markdown.impl.common.utils;

import com.larus.business.markdown.api.MarkdownService;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkdownLogger.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/business/markdown/impl/common/utils/MarkdownLogger;", "Lcom/larus/business/markdown/api/depend/IMarkdownLogger;", "()V", "d", "", "tag", "", "msg", "e", "tr", "", "i", "v", "w", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkdownLogger implements IMarkdownLogger {
    @Override // com.larus.business.markdown.api.depend.IMarkdownLogger
    /* renamed from: v */
    public void mo2532v(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IMarkdownLogger markdownLogger = MarkdownService.INSTANCE.getMarkdownLogger();
        if (markdownLogger != null) {
            markdownLogger.mo2532v(tag, msg);
        }
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownLogger
    /* renamed from: d */
    public void mo2528d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IMarkdownLogger markdownLogger = MarkdownService.INSTANCE.getMarkdownLogger();
        if (markdownLogger != null) {
            markdownLogger.mo2528d(tag, msg);
        }
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownLogger
    /* renamed from: i */
    public void mo2531i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IMarkdownLogger markdownLogger = MarkdownService.INSTANCE.getMarkdownLogger();
        if (markdownLogger != null) {
            markdownLogger.mo2531i(tag, msg);
        }
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownLogger
    /* renamed from: w */
    public void mo2533w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IMarkdownLogger markdownLogger = MarkdownService.INSTANCE.getMarkdownLogger();
        if (markdownLogger != null) {
            markdownLogger.mo2533w(tag, msg);
        }
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownLogger
    /* renamed from: w */
    public void mo2534w(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IMarkdownLogger markdownLogger = MarkdownService.INSTANCE.getMarkdownLogger();
        if (markdownLogger != null) {
            markdownLogger.mo2534w(tag, msg, tr);
        }
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownLogger
    /* renamed from: w */
    public void mo2535w(String tag, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IMarkdownLogger markdownLogger = MarkdownService.INSTANCE.getMarkdownLogger();
        if (markdownLogger != null) {
            markdownLogger.mo2535w(tag, tr);
        }
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownLogger
    /* renamed from: e */
    public void mo2529e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IMarkdownLogger markdownLogger = MarkdownService.INSTANCE.getMarkdownLogger();
        if (markdownLogger != null) {
            markdownLogger.mo2529e(tag, msg);
        }
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownLogger
    /* renamed from: e */
    public void mo2530e(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IMarkdownLogger markdownLogger = MarkdownService.INSTANCE.getMarkdownLogger();
        if (markdownLogger != null) {
            markdownLogger.mo2530e(tag, msg, tr);
        }
    }
}
