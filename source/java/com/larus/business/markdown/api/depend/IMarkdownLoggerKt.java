package com.larus.business.markdown.api.depend;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: IMarkdownLogger.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"markdownLoggerDelegate", "Lcom/larus/business/markdown/api/depend/IMarkdownLogger;", "getMarkdownLoggerDelegate", "()Lcom/larus/business/markdown/api/depend/IMarkdownLogger;", "markdownLoggerDelegate$delegate", "Lkotlin/Lazy;", "markdown-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class IMarkdownLoggerKt {
    private static final Lazy markdownLoggerDelegate$delegate = LazyKt.lazy(new Function0<IMarkdownLogger>() { // from class: com.larus.business.markdown.api.depend.IMarkdownLoggerKt$markdownLoggerDelegate$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IMarkdownLogger m2810invoke() {
            try {
                Object newInstance = Class.forName("com.larus.business.markdown.impl.common.utils.MarkdownLogger").newInstance();
                if (newInstance instanceof IMarkdownLogger) {
                    return (IMarkdownLogger) newInstance;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    });

    public static final IMarkdownLogger getMarkdownLoggerDelegate() {
        return (IMarkdownLogger) markdownLoggerDelegate$delegate.getValue();
    }
}
