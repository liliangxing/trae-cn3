package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan;

import android.content.Context;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.business.markdown.api.extplugin.code.ICustomCodeHandler;
import com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import com.larus.business.markdown.impl.C1327R;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.business.markdown.impl.common.utils.MarkdownUnitExtKt;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockSpanInfoKt;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView;
import com.larus.business.markdown.impl.markwon.custom.title.MarkwonCustomTitleManager;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.scrollable.HorizontalScrollable;
import io.noties.markwon.scrollable.ScrollBarTheme;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Node;

/* compiled from: ReplacementCodePlugin.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020'H\u0016J\u001e\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0,H\u0002J\u0018\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\tH\u0002R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R%\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001b¨\u00061"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/ReplacementCodePlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "context", "Landroid/content/Context;", "getPayload", "Lkotlin/Function0;", "", "", "", "customCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "contentMaxWidth", "", "isFinish", "", "(Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;ILkotlin/jvm/functions/Function0;)V", "getContentMaxWidth", "()I", "getContext", "()Landroid/content/Context;", "getCustomCodeHandler", "()Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "getCustomMarkDownInfo", "()Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "getGetPayload", "()Lkotlin/jvm/functions/Function0;", "afterSetText", "", "textView", "Landroid/widget/TextView;", "beforeSetText", "markdown", "Landroid/text/Spanned;", "configureSpansFactory", "builder", "Lio/noties/markwon/MarkwonSpansFactory$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "needRemoveView", "oldSpan", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeSpan;", "newSpans", "", "printLog", "span", "message", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ReplacementCodePlugin extends AbstractMarkwonPlugin {
    public static final String LOG_TAG = "";
    private final int contentMaxWidth;
    private final Context context;
    private final ICustomCodeHandler customCodeHandler;
    private final CustomMarkDownInfo customMarkDownInfo;
    private final Function0<Map<String, Object>> getPayload;
    private final Function0<Boolean> isFinish;

    public final CustomMarkDownInfo getCustomMarkDownInfo() {
        return this.customMarkDownInfo;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function0<Map<String, Object>> getGetPayload() {
        return this.getPayload;
    }

    public final ICustomCodeHandler getCustomCodeHandler() {
        return this.customCodeHandler;
    }

    public final int getContentMaxWidth() {
        return this.contentMaxWidth;
    }

    public final Function0<Boolean> isFinish() {
        return this.isFinish;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReplacementCodePlugin(CustomMarkDownInfo customMarkDownInfo, Context context, Function0<? extends Map<String, ? extends Object>> function0, ICustomCodeHandler iCustomCodeHandler, int i, Function0<Boolean> function02) {
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "getPayload");
        Intrinsics.checkNotNullParameter(function02, "isFinish");
        this.customMarkDownInfo = customMarkDownInfo;
        this.context = context;
        this.getPayload = function0;
        this.customCodeHandler = iCustomCodeHandler;
        this.contentMaxWidth = i;
        this.isFinish = function02;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        Integer blockBorderColor;
        Integer blockBorderWidth;
        Integer lineNumberColor;
        Integer cornerRadius;
        Integer titleBgColor;
        Intrinsics.checkNotNullParameter(builder, "builder");
        CodeBlockConfig codeBlockConfig = this.customMarkDownInfo.getCodeBlockConfig();
        int color = (codeBlockConfig == null || (titleBgColor = codeBlockConfig.getTitleBgColor()) == null) ? ContextCompat.getColor(this.context, C1327R.color.neutral_transparent_2) : titleBgColor.intValue();
        CodeBlockConfig codeBlockConfig2 = this.customMarkDownInfo.getCodeBlockConfig();
        float dp2pxFloat = (codeBlockConfig2 == null || (cornerRadius = codeBlockConfig2.getCornerRadius()) == null) ? MarkdownUnitExtKt.dp2pxFloat((Number) 12) : cornerRadius.intValue();
        CodeBlockConfig codeBlockConfig3 = this.customMarkDownInfo.getCodeBlockConfig();
        boolean enableScroll = codeBlockConfig3 != null ? codeBlockConfig3.getEnableScroll() : false;
        CodeBlockConfig codeBlockConfig4 = this.customMarkDownInfo.getCodeBlockConfig();
        boolean enableLineNumber = codeBlockConfig4 != null ? codeBlockConfig4.getEnableLineNumber() : false;
        ScrollBarTheme scrollBarTheme = new ScrollBarTheme(MarkdownDimensExtKt.getDp_120(), MarkdownDimensExtKt.getDp_4(), 0.0f, ContextCompat.getColor(this.context, C1327R.color.neutral_30));
        int i = this.context.getResources().getDisplayMetrics().widthPixels;
        CodeBlockConfig codeBlockConfig5 = this.customMarkDownInfo.getCodeBlockConfig();
        int color2 = (codeBlockConfig5 == null || (lineNumberColor = codeBlockConfig5.getLineNumberColor()) == null) ? ContextCompat.getColor(this.context, C1327R.color.neutral_30) : lineNumberColor.intValue();
        int color3 = ContextCompat.getColor(this.context, C1327R.color.neutral_100);
        CodeBlockConfig codeBlockConfig6 = this.customMarkDownInfo.getCodeBlockConfig();
        float dp2pxFloat2 = (codeBlockConfig6 == null || (blockBorderWidth = codeBlockConfig6.getBlockBorderWidth()) == null) ? MarkdownUnitExtKt.dp2pxFloat(Float.valueOf(0.5f)) : blockBorderWidth.intValue();
        CodeBlockConfig codeBlockConfig7 = this.customMarkDownInfo.getCodeBlockConfig();
        int intValue = (codeBlockConfig7 == null || (blockBorderColor = codeBlockConfig7.getBlockBorderColor()) == null) ? 0 : blockBorderColor.intValue();
        CodeBlockConfig codeBlockConfig8 = this.customMarkDownInfo.getCodeBlockConfig();
        builder.setFactory(FencedCodeBlock.class, new CodeBlockSpanFactory3(color, dp2pxFloat, enableScroll, enableLineNumber, scrollBarTheme, i, color2, color3, dp2pxFloat2, intValue, codeBlockConfig8 != null ? codeBlockConfig8.getEnableBlockBackground() : true, this.getPayload, this.customCodeHandler, this.contentMaxWidth, this.isFinish));
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        super.configureVisitor(builder);
        builder.mo2586on(FencedCodeBlock.class, new MarkwonVisitor.NodeVisitor() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.ReplacementCodePlugin$configureVisitor$1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public final void visit(MarkwonVisitor markwonVisitor, FencedCodeBlock fencedCodeBlock) {
                Intrinsics.checkNotNullParameter(markwonVisitor, "visitor");
                Intrinsics.checkNotNullParameter(fencedCodeBlock, "indentedCodeBlock");
                String info = fencedCodeBlock.getInfo();
                String info2 = info == null || info.length() == 0 ? "plaintext" : fencedCodeBlock.getInfo();
                Intrinsics.checkNotNullExpressionValue(info2, "info");
                SpannableBuilder spannableBuilder = null;
                if (StringsKt.startsWith$default(info2, DefaultMarkdownCodeView.MARKDOWN_CODE_STD_OUT, false, 2, (Object) null)) {
                    return;
                }
                String literal = fencedCodeBlock.getLiteral();
                CodeBlockConfig codeBlockConfig = ReplacementCodePlugin.this.getCustomMarkDownInfo().getCodeBlockConfig();
                if (codeBlockConfig != null && codeBlockConfig.getEnableLineNumber()) {
                    String substringBefore$default = StringsKt.substringBefore$default(info2, " ", (String) null, 2, (Object) null);
                    MarkwonCustomTitleManager markwonCustomTitleManager = MarkwonCustomTitleManager.INSTANCE;
                    int contentMaxWidth = ReplacementCodePlugin.this.getContentMaxWidth();
                    Intrinsics.checkNotNullExpressionValue(literal, "code");
                    markwonCustomTitleManager.visitCodeBlock(contentMaxWidth, markwonVisitor, substringBefore$default, literal, (Node) fencedCodeBlock, ReplacementCodePlugin.this.getContext(), ReplacementCodePlugin.this.getCustomMarkDownInfo(), ((Boolean) ReplacementCodePlugin.this.isFinish().invoke()).booleanValue());
                    return;
                }
                Node node = (Node) fencedCodeBlock;
                markwonVisitor.blockStart(node);
                int length = markwonVisitor.length();
                markwonVisitor.builder().append((char) 160);
                markwonVisitor.renderProps().set(CoreProps.CODE_BLOCK_CODE, literal);
                markwonVisitor.renderProps().set(CoreProps.CODE_BLOCK_INFO, info2);
                markwonVisitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_START_INDEX(), Integer.valueOf(length));
                markwonVisitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_END_INDEX(), Integer.valueOf(markwonVisitor.length()));
                CodeBlockConfig codeBlockConfig2 = ReplacementCodePlugin.this.getCustomMarkDownInfo().getCodeBlockConfig();
                if (codeBlockConfig2 != null && codeBlockConfig2.getEnableScroll()) {
                    HorizontalScrollable horizontalScrollable = new HorizontalScrollable(0.0f);
                    markwonVisitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_SCROLLABLE(), horizontalScrollable);
                    markwonVisitor.setSpans(length, horizontalScrollable);
                }
                SpanFactory spanFactory = markwonVisitor.configuration().spansFactory().get(fencedCodeBlock.getClass());
                CodeBlockSpanFactory3 codeBlockSpanFactory3 = spanFactory instanceof CodeBlockSpanFactory3 ? (CodeBlockSpanFactory3) spanFactory : null;
                if (codeBlockSpanFactory3 != null) {
                    SpannableBuilder builder2 = markwonVisitor.builder();
                    MarkwonConfiguration configuration = markwonVisitor.configuration();
                    Intrinsics.checkNotNullExpressionValue(configuration, "visitor.configuration()");
                    RenderProps renderProps = markwonVisitor.renderProps();
                    Intrinsics.checkNotNullExpressionValue(renderProps, "visitor.renderProps()");
                    spannableBuilder = builder2.setSpan(codeBlockSpanFactory3.getSpans(configuration, renderProps, node), length);
                }
                if (spannableBuilder == null) {
                    markwonVisitor.setSpansForNodeOptional((MarkwonVisitor) node, length);
                }
                markwonVisitor.blockEnd(node);
            }
        });
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned markdown) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        super.beforeSetText(textView, markdown);
        CharSequence text = textView.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        ICustomCodeSpan[] iCustomCodeSpanArr = spanned != null ? (ICustomCodeSpan[]) spanned.getSpans(0, text.length(), ICustomCodeSpan.class) : null;
        if (iCustomCodeSpanArr == null) {
            iCustomCodeSpanArr = new ICustomCodeSpan[0];
        }
        Object[] spans = markdown.getSpans(0, markdown.length(), ICustomCodeSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "markdown.getSpans(0, mar…stomCodeSpan::class.java)");
        List<ICustomCodeSpan> mutableList = ArraysKt.toMutableList(spans);
        for (ICustomCodeSpan iCustomCodeSpan : iCustomCodeSpanArr) {
            if (!mutableList.remove(iCustomCodeSpan)) {
                Intrinsics.checkNotNullExpressionValue(iCustomCodeSpan, "span");
                iCustomCodeSpan.onDetach(textView, needRemoveView(iCustomCodeSpan, mutableList));
            } else {
                Intrinsics.checkNotNullExpressionValue(iCustomCodeSpan, "span");
                iCustomCodeSpan.onReuse(markdown, iCustomCodeSpan);
                printLog(iCustomCodeSpan, "reuse span");
            }
        }
        for (ICustomCodeSpan iCustomCodeSpan2 : mutableList) {
            Intrinsics.checkNotNullExpressionValue(iCustomCodeSpan2, "span");
            printLog(iCustomCodeSpan2, "new span beforeAttach");
            iCustomCodeSpan2.beforeAttach(textView, markdown, this.customMarkDownInfo);
        }
    }

    private final boolean needRemoveView(ICustomCodeSpan oldSpan, List<ICustomCodeSpan> newSpans) {
        boolean z;
        Integer startIndex = oldSpan.getStartIndex();
        List<ICustomCodeSpan> list = newSpans;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((ICustomCodeSpan) it.next()).getStartIndex(), startIndex)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            return true;
        }
        printLog(oldSpan, "skip onDetach, reused by new span at same pos");
        return false;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void afterSetText(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        super.afterSetText(textView);
        CharSequence text = textView.getText();
        if (text instanceof Spanned) {
            ICustomCodeSpan[] iCustomCodeSpanArr = (ICustomCodeSpan[]) ((Spanned) text).getSpans(0, text.length(), ICustomCodeSpan.class);
            Intrinsics.checkNotNullExpressionValue(iCustomCodeSpanArr, "spans");
            for (ICustomCodeSpan iCustomCodeSpan : iCustomCodeSpanArr) {
                iCustomCodeSpan.afterAttach(textView);
            }
        }
    }

    private final void printLog(Object span, String message) {
        Log.d("", "span[" + span.hashCode() + "]:" + message);
    }
}
