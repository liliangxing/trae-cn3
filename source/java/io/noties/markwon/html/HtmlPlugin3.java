package io.noties.markwon.html;

import android.text.Spanned;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.html.HtmlPlugin;
import io.noties.markwon.html.customdata.CustomDataBlockParser;
import io.noties.markwon.html.customdata.CustomDataWidgetExtKt;
import io.noties.markwon.html.customdata.ICustomDataSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.parser.block.BlockParserFactory;

/* compiled from: HtmlPlugin3.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u001a\u0010\u0011\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u0016\u0010 \u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lio/noties/markwon/html/HtmlPlugin3;", "Lio/noties/markwon/html/HtmlPlugin;", "printLog", "Lio/noties/markwon/html/IPrintLog;", "(Lio/noties/markwon/html/IPrintLog;)V", "additionBlockTags", "", "", "justProcessedTextView", "Landroid/widget/TextView;", "reuseCharSequence", "", "tagNames", "", "afterSetText", "", "textView", "beforeRender", "node", "Lorg/commonmark/node/Node;", "beforeSetText", "markdown", "Landroid/text/Spanned;", "configureParser", "builder", "Lorg/commonmark/parser/Parser$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "getMsg", "span", "", "message", "spanToString", "spans", "", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "Companion", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HtmlPlugin3 extends HtmlPlugin {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DATA_INLINE = "data-inline";
    private static final String LOG_TAG = "custom-data-hp";
    private static final String TABLE_CELL_CLASS_NAME = "org.commonmark.ext.gfm.tables.TableCell";
    private final Set<String> additionBlockTags;
    private TextView justProcessedTextView;
    private final IPrintLog printLog;
    private CharSequence reuseCharSequence;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HtmlPlugin3() {
        this(r0, 1, r0);
        IPrintLog iPrintLog = null;
    }

    public HtmlPlugin3(IPrintLog iPrintLog) {
        this.printLog = iPrintLog;
        this.additionBlockTags = new LinkedHashSet();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ HtmlPlugin3(IPrintLog iPrintLog, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iPrintLog);
        if ((i & 1) != 0) {
            iPrintLog = null;
        }
    }

    @Override // io.noties.markwon.html.HtmlPlugin
    public HtmlPlugin additionBlockTags(Set<String> tagNames) {
        Intrinsics.checkParameterIsNotNull(tagNames, "tagNames");
        this.additionBlockTags.addAll(tagNames);
        HtmlPlugin additionBlockTags = super.additionBlockTags(tagNames);
        Intrinsics.checkExpressionValueIsNotNull(additionBlockTags, "super.additionBlockTags(tagNames)");
        return additionBlockTags;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureParser(Parser.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        super.configureParser(builder);
        BlockParserFactory factory = new CustomDataBlockParser.Factory();
        factory.getCustomBlockTags().addAll(this.additionBlockTags);
        builder.customBlockParserFactory(factory);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeRender(CharSequence reuseCharSequence, Node node) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        super.beforeRender(reuseCharSequence, node);
        this.reuseCharSequence = reuseCharSequence;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned markdown) {
        List<ICustomDataSpan> arrayList;
        ICustomDataSpan[] iCustomDataSpanArr;
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        Intrinsics.checkParameterIsNotNull(markdown, "markdown");
        super.beforeSetText(textView, markdown);
        IPrintLog iPrintLog = this.printLog;
        if (iPrintLog != null) {
            iPrintLog.m2593d(LOG_TAG, "beforeSetText markdown: " + ((Object) markdown));
        }
        this.justProcessedTextView = textView;
        CharSequence text = textView.getText();
        IPrintLog iPrintLog2 = this.printLog;
        if (iPrintLog2 != null) {
            iPrintLog2.m2593d(LOG_TAG, "beforeSetText currText: " + text);
        }
        Spanned spanned = (Spanned) (!(text instanceof Spanned) ? null : text);
        if (spanned == null || (iCustomDataSpanArr = (ICustomDataSpan[]) spanned.getSpans(0, text.length(), ICustomDataSpan.class)) == null || (arrayList = ArraysKt.toMutableList(iCustomDataSpanArr)) == null) {
            arrayList = new ArrayList<>();
        }
        IPrintLog iPrintLog3 = this.printLog;
        if (iPrintLog3 != null) {
            iPrintLog3.m2593d(LOG_TAG, "beforeSetText currSpans: " + spanToString(arrayList));
        }
        Object[] spans = markdown.getSpans(0, markdown.length(), ICustomDataSpan.class);
        Intrinsics.checkExpressionValueIsNotNull(spans, "markdown.getSpans(0, mar…stomDataSpan::class.java)");
        List<ICustomDataSpan> mutableList = ArraysKt.toMutableList(spans);
        IPrintLog iPrintLog4 = this.printLog;
        if (iPrintLog4 != null) {
            iPrintLog4.m2593d(LOG_TAG, "beforeSetText newSpans: " + spanToString(mutableList));
        }
        for (ICustomDataSpan iCustomDataSpan : arrayList) {
            if (!mutableList.remove(iCustomDataSpan)) {
                iCustomDataSpan.onDetach(textView);
                IPrintLog iPrintLog5 = this.printLog;
                if (iPrintLog5 != null) {
                    Intrinsics.checkExpressionValueIsNotNull(iCustomDataSpan, "span");
                    iPrintLog5.m2593d(LOG_TAG, getMsg(iCustomDataSpan, "span.onDetach"));
                }
            } else {
                IPrintLog iPrintLog6 = this.printLog;
                if (iPrintLog6 != null) {
                    Intrinsics.checkExpressionValueIsNotNull(iCustomDataSpan, "span");
                    iPrintLog6.m2593d(LOG_TAG, getMsg(iCustomDataSpan, "reuse span"));
                }
                iCustomDataSpan.onReuse(textView, markdown);
            }
        }
        for (ICustomDataSpan iCustomDataSpan2 : mutableList) {
            IPrintLog iPrintLog7 = this.printLog;
            if (iPrintLog7 != null) {
                Intrinsics.checkExpressionValueIsNotNull(iCustomDataSpan2, "span");
                iPrintLog7.m2593d(LOG_TAG, getMsg(iCustomDataSpan2, "new span beforeAttach"));
            }
            iCustomDataSpan2.beforeAttach(textView, markdown);
        }
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void afterSetText(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        super.afterSetText(textView);
        this.reuseCharSequence = null;
        ViewParent parent = textView.getParent();
        ViewGroup viewGroup = (ViewGroup) (parent instanceof ViewGroup ? parent : null);
        if (viewGroup != null) {
            CustomDataWidgetExtKt.clearWidgetCache(viewGroup);
        }
        CharSequence text = textView.getText();
        if (text instanceof Spanned) {
            for (ICustomDataSpan iCustomDataSpan : (ICustomDataSpan[]) ((Spanned) text).getSpans(0, text.length(), ICustomDataSpan.class)) {
                iCustomDataSpan.afterAttach(textView);
            }
        }
    }

    @Override // io.noties.markwon.html.HtmlPlugin, io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        builder.mo2586on(HtmlBlock.class, new MarkwonVisitor.NodeVisitor<HtmlBlock>() { // from class: io.noties.markwon.html.HtmlPlugin3$configureVisitor$1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public final void visit(MarkwonVisitor markwonVisitor, HtmlBlock htmlBlock) {
                Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                Intrinsics.checkParameterIsNotNull(htmlBlock, "htmlBlock");
                HtmlPlugin3.this.visitHtml(markwonVisitor, htmlBlock.getLiteral());
            }
        }).mo2586on(HtmlInline.class, new MarkwonVisitor.NodeVisitor<HtmlInline>() { // from class: io.noties.markwon.html.HtmlPlugin3$configureVisitor$2
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public final void visit(MarkwonVisitor markwonVisitor, HtmlInline htmlInline) {
                Class<?> cls;
                Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                Intrinsics.checkParameterIsNotNull(htmlInline, "htmlInline");
                Node node = htmlInline.parent;
                if (Intrinsics.areEqual((node == null || (cls = node.getClass()) == null) ? null : cls.getName(), "org.commonmark.ext.gfm.tables.TableCell")) {
                    String literal = htmlInline.getLiteral();
                    if (literal != null && StringsKt.startsWith$default(literal, "<data-inline", false, 2, (Object) null)) {
                        return;
                    }
                    String literal2 = htmlInline.getLiteral();
                    if (literal2 != null && StringsKt.startsWith$default(literal2, "</data-inline", false, 2, (Object) null)) {
                        return;
                    }
                }
                HtmlPlugin3.this.visitHtml(markwonVisitor, htmlInline.getLiteral());
            }
        });
    }

    private final String getMsg(Object span, String message) {
        return "span[" + span + "]:" + message;
    }

    private final String spanToString(List<ICustomDataSpan> spans) {
        StringBuffer stringBuffer = new StringBuffer("{");
        Iterator<ICustomDataSpan> it = spans.iterator();
        while (it.hasNext()) {
            stringBuffer.append("span: " + it.next().toString());
        }
        stringBuffer.append("}");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "stringBuffer.toString()");
        return stringBuffer2;
    }

    /* compiled from: HtmlPlugin3.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/html/HtmlPlugin3$Companion;", "", "()V", "DATA_INLINE", "", "LOG_TAG", "TABLE_CELL_CLASS_NAME", "create", "Lio/noties/markwon/html/HtmlPlugin3;", "configure", "Lio/noties/markwon/html/HtmlPlugin$HtmlConfigure;", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HtmlPlugin3 create() {
            return new HtmlPlugin3(null);
        }

        public final HtmlPlugin3 create(HtmlPlugin.HtmlConfigure configure) {
            Intrinsics.checkParameterIsNotNull(configure, "configure");
            HtmlPlugin3 create = create();
            configure.configureHtml(create);
            return create;
        }
    }
}
