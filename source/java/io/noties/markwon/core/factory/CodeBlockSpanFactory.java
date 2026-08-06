package io.noties.markwon.core.factory;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.spans.CodeBlockSpan;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CodeBlockSpanFactory implements SpanFactory {
    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new CodeBlockSpan(markwonConfiguration.theme());
    }
}
