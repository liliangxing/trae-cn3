package io.noties.markwon.core.factory;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.spans.BlockQuoteSpan;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BlockQuoteSpanFactory implements SpanFactory {
    private final int blockMargin;
    private final int lineCornerRadius;

    public BlockQuoteSpanFactory() {
        this(0, 0);
    }

    public BlockQuoteSpanFactory(int i, int i2) {
        this.lineCornerRadius = i;
        this.blockMargin = i2;
    }

    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        return new BlockQuoteSpan(markwonConfiguration.theme(), this.lineCornerRadius, this.blockMargin);
    }
}
