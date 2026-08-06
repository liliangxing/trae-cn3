package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan;

import com.larus.business.markdown.api.extplugin.code.ICustomCodeHandler;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockLineNumberInfo;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockScrollableInfo;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockSpan2Info;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockSpanInfoKt;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.scrollable.HorizontalScrollable;
import io.noties.markwon.scrollable.ScrollBarTheme;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* compiled from: CodeBlockSpanFactory3.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00130\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/CodeBlockSpanFactory3;", "Lio/noties/markwon/SpanFactory;", "titleBgColor", "", "cornerRadius", "", "enableScroll", "", "enableLineNumber", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "screenWidth", "lineNumberColor", "codeTextColor", "borderWidth", "borderColor", "enableBackground", "getPayload", "Lkotlin/Function0;", "", "", "", "customCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "contentMaxWidth", "isFinish", "(IFZZLio/noties/markwon/scrollable/ScrollBarTheme;IIIFIZLkotlin/jvm/functions/Function0;Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;ILkotlin/jvm/functions/Function0;)V", "getSpans", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "node", "Lorg/commonmark/node/Node;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CodeBlockSpanFactory3 implements SpanFactory {
    private final int borderColor;
    private final float borderWidth;
    private final int codeTextColor;
    private final int contentMaxWidth;
    private final float cornerRadius;
    private final ICustomCodeHandler customCodeHandler;
    private final boolean enableBackground;
    private final boolean enableLineNumber;
    private final boolean enableScroll;
    private final Function0<Map<String, Object>> getPayload;
    private final Function0<Boolean> isFinish;
    private final int lineNumberColor;
    private final int screenWidth;
    private final ScrollBarTheme scrollBarTheme;
    private final int titleBgColor;

    /* JADX WARN: Multi-variable type inference failed */
    public CodeBlockSpanFactory3(int i, float f, boolean z, boolean z2, ScrollBarTheme scrollBarTheme, int i2, int i3, int i4, float f2, int i5, boolean z3, Function0<? extends Map<String, ? extends Object>> function0, ICustomCodeHandler iCustomCodeHandler, int i6, Function0<Boolean> function02) {
        Intrinsics.checkNotNullParameter(scrollBarTheme, "scrollBarTheme");
        Intrinsics.checkNotNullParameter(function0, "getPayload");
        Intrinsics.checkNotNullParameter(function02, "isFinish");
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
        this.getPayload = function0;
        this.customCodeHandler = iCustomCodeHandler;
        this.contentMaxWidth = i6;
        this.isFinish = function02;
    }

    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration configuration, RenderProps props) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(props, "props");
        return getSpans(configuration, props, null);
    }

    public final Object getSpans(MarkwonConfiguration configuration, RenderProps props, Node node) {
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
        return new CustomCodeSpan((Map) this.getPayload.invoke(), (String) props.get(CoreProps.CODE_BLOCK_CODE), (String) props.get(CoreProps.CODE_BLOCK_INFO), (Integer) props.get(CodeBlockSpanInfoKt.getCODE_BLOCK_START_INDEX()), (Integer) props.get(CodeBlockSpanInfoKt.getCODE_BLOCK_END_INDEX()), this.contentMaxWidth, this.customCodeHandler, ((Boolean) this.isFinish.invoke()).booleanValue());
    }
}
