package io.noties.markwon.core.factory;

import android.text.style.ParagraphStyle;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.spans.ThematicBreakSpan;
import io.noties.markwon.span.SpanCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThematicBreakSpanFactory2.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/core/factory/ThematicBreakSpanFactory2;", "Lio/noties/markwon/SpanFactory;", "thematicBreakConfig", "Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "(Lcom/larus/business/markdown/api/model/ThematicBreakConfig;)V", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ThematicBreakSpanFactory2 implements SpanFactory {
    private final ThematicBreakConfig thematicBreakConfig;

    public ThematicBreakSpanFactory2(ThematicBreakConfig thematicBreakConfig) {
        this.thematicBreakConfig = thematicBreakConfig;
    }

    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration configuration, RenderProps props) {
        int dp_1;
        Integer height;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(props, "props");
        ThematicBreakConfig thematicBreakConfig = this.thematicBreakConfig;
        if (thematicBreakConfig == null || (height = thematicBreakConfig.getHeight()) == null) {
            dp_1 = MarkdownDimensExtKt.getDp_1();
        } else {
            dp_1 = height.intValue();
            if (dp_1 <= 0) {
                dp_1 = MarkdownDimensExtKt.getDp_1();
            }
        }
        return new ParagraphStyle[]{new ThematicBreakSpan(configuration.theme()), SpanCompat.INSTANCE.newLineHeightSpan(dp_1)};
    }
}
