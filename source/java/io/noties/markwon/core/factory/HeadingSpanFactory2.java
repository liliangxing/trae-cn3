package io.noties.markwon.core.factory;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.core.spans.HeadingSpan2;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeadingSpanFactory2.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0001\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/noties/markwon/core/factory/HeadingSpanFactory2;", "Lio/noties/markwon/SpanFactory;", "diffDp", "", "headingColor", "headingLevelTextSizeMap", "", "", "(ILjava/lang/Integer;Ljava/util/Map;)V", "Ljava/lang/Integer;", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class HeadingSpanFactory2 implements SpanFactory {
    private final int diffDp;
    private final Integer headingColor;
    private final Map<Integer, Float> headingLevelTextSizeMap;

    public HeadingSpanFactory2(int i, Integer num, Map<Integer, Float> map) {
        this.diffDp = i;
        this.headingColor = num;
        this.headingLevelTextSizeMap = map;
    }

    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration configuration, RenderProps props) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(props, "props");
        MarkwonTheme theme = configuration.theme();
        Intrinsics.checkNotNullExpressionValue(theme, "configuration.theme()");
        Integer require = CoreProps.HEADING_LEVEL.require(props);
        Intrinsics.checkNotNullExpressionValue(require, "HEADING_LEVEL.require(props)");
        return new HeadingSpan2(theme, require.intValue(), this.diffDp, this.headingColor, this.headingLevelTextSizeMap);
    }
}
