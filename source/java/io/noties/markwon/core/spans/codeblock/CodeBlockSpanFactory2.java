package io.noties.markwon.core.spans.codeblock;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockLineNumberInfo;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockScrollableInfo;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockSpan2Info;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockSpanInfoKt;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.scrollable.HorizontalScrollable;
import io.noties.markwon.scrollable.ScrollBarTheme;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeBlockSpanFactory2.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lio/noties/markwon/core/spans/codeblock/CodeBlockSpanFactory2;", "Lio/noties/markwon/SpanFactory;", "titleBgColor", "", "cornerRadius", "", "enableScroll", "", "enableLineNumber", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "screenWidth", "lineNumberColor", "codeTextColor", "borderWidth", "borderColor", "enableBackground", "(IFZZLio/noties/markwon/scrollable/ScrollBarTheme;IIIFIZ)V", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CodeBlockSpanFactory2 implements SpanFactory {
    private final int borderColor;
    private final float borderWidth;
    private final int codeTextColor;
    private final float cornerRadius;
    private final boolean enableBackground;
    private final boolean enableLineNumber;
    private final boolean enableScroll;
    private final int lineNumberColor;
    private final int screenWidth;
    private final ScrollBarTheme scrollBarTheme;
    private final int titleBgColor;

    public CodeBlockSpanFactory2(int i, float f, boolean z, boolean z2, ScrollBarTheme scrollBarTheme, int i2, int i3, int i4, float f2, int i5, boolean z3) {
        Intrinsics.checkNotNullParameter(scrollBarTheme, "scrollBarTheme");
        this.titleBgColor = i;
        this.cornerRadius = f;
        this.enableScroll = z;
        this.enableLineNumber = z2;
        this.scrollBarTheme = scrollBarTheme;
        this.screenWidth = i2;
        this.lineNumberColor = i3;
        this.codeTextColor = i4;
        this.borderWidth = f2;
        this.borderColor = i5;
        this.enableBackground = z3;
    }

    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration configuration, RenderProps props) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(props, "props");
        if (this.enableLineNumber) {
            MarkwonTheme theme = configuration.theme();
            Intrinsics.checkNotNullExpressionValue(theme, "configuration.theme()");
            Integer num = (Integer) props.get(CodeBlockSpanInfoKt.getCODE_BLOCK_START_INDEX());
            Integer num2 = (Integer) props.get(CodeBlockSpanInfoKt.getCODE_BLOCK_END_INDEX());
            int i = this.titleBgColor;
            float f = this.cornerRadius;
            float f2 = this.borderWidth;
            int i2 = this.borderColor;
            boolean z = this.enableBackground;
            CodeBlockScrollableInfo codeBlockScrollableInfo = new CodeBlockScrollableInfo(this.enableScroll, (HorizontalScrollable) props.get(CodeBlockSpanInfoKt.getCODE_BLOCK_SCROLLABLE()), this.scrollBarTheme, this.codeTextColor);
            Map map = (Map) props.get(CodeBlockSpanInfoKt.getCODE_BLOCK_LINE_NUMBER_MAP());
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            int i3 = (Integer) props.get(CodeBlockSpanInfoKt.getCODE_BLOCK_MAX_LINE());
            if (i3 == null) {
                i3 = 0;
            }
            return new CodeBlockWithLineNumberScrollableSpan(theme, new CodeBlockSpan2Info(num, num2, i, f, f2, i2, z, codeBlockScrollableInfo, new CodeBlockLineNumberInfo(map, i3.intValue(), this.lineNumberColor)), this.screenWidth);
        }
        MarkwonTheme theme2 = configuration.theme();
        Intrinsics.checkNotNullExpressionValue(theme2, "configuration.theme()");
        return new CodeBlockSpan2(theme2, new CodeBlockSpan2Info((Integer) props.get(CodeBlockSpanInfoKt.getCODE_BLOCK_START_INDEX()), (Integer) props.get(CodeBlockSpanInfoKt.getCODE_BLOCK_END_INDEX()), this.titleBgColor, this.cornerRadius, this.borderWidth, this.borderColor, this.enableBackground, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null));
    }
}
