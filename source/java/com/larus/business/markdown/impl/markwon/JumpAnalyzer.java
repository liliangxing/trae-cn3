package com.larus.business.markdown.impl.markwon;

import android.text.SpannableStringBuilder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.android.SystemUtils;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.extplugin.latex.ILatexPlugin;
import com.larus.business.markdown.api.extplugin.latex.ILatexPluginKt;
import com.larus.business.markdown.api.model.MarkdownContent;
import com.larus.business.markdown.api.view.text.JumpListener;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* compiled from: JumpAnalyzer.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J2\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J:\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u0006*\u00020\u001cH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/JumpAnalyzer;", "", "()V", "lastBuilder", "Landroid/text/SpannableStringBuilder;", "lastMessageId", "", "lastNode", "Lorg/commonmark/node/Node;", "analysisJump", "", "content", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "stream", "", "messageId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/larus/business/markdown/api/view/text/JumpListener;", "analysisJumpContent", "preContent", "currContent", "preNode", "currNode", "analysisNode", "count", "", "clear", "toHex", "", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class JumpAnalyzer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int INVALID = Integer.MIN_VALUE;
    public static final String TAG = "JumpAnalyzer";
    private static final Map<Class<? extends Node>, String> map;
    private SpannableStringBuilder lastBuilder;
    private String lastMessageId;
    private Node lastNode;

    /* compiled from: JumpAnalyzer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000b\u001a\u00020\f*\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000eJ\n\u0010\u000f\u001a\u00020\u0006*\u00020\nJ\u0011\u0010\u0010\u001a\u00020\u0006*\u00020\nH\u0000¢\u0006\u0002\b\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/JumpAnalyzer$Companion;", "", "()V", "INVALID", "", "TAG", "", "map", "", "Ljava/lang/Class;", "Lorg/commonmark/node/Node;", "compare", "", "other", "compare$markdown_impl_release", "getReportName", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "name$markdown_impl_release", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getReportName(Node node) {
            Intrinsics.checkNotNullParameter(node, "<this>");
            String str = (String) JumpAnalyzer.map.get(node.getClass());
            return str == null ? name$markdown_impl_release(node) : str;
        }

        public final String name$markdown_impl_release(Node node) {
            Intrinsics.checkNotNullParameter(node, "<this>");
            String simpleName = node.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "this::class.java.simpleName");
            String lowerCase = simpleName.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        }

        public final boolean compare$markdown_impl_release(Node node, Node node2) {
            Intrinsics.checkNotNullParameter(node, "<this>");
            Intrinsics.checkNotNullParameter(node2, "other");
            return Intrinsics.areEqual(node.getClass(), node2.getClass());
        }
    }

    static {
        Map<Class<? extends Node>, String> emptyMap;
        Map<Class<? extends Node>, String> mutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ThematicBreak.class, "thematic"), TuplesKt.to(Heading.class, "heading"), TuplesKt.to(FencedCodeBlock.class, "code_block"), TuplesKt.to(IndentedCodeBlock.class, "code_block"), TuplesKt.to(HtmlBlock.class, "html"), TuplesKt.to(HtmlInline.class, "html"), TuplesKt.to(LinkReferenceDefinition.class, "link_ref_def"), TuplesKt.to(Paragraph.class, "paragraph"), TuplesKt.to(TableBlock.class, "table"), TuplesKt.to(TableCell.class, "table_cell"), TuplesKt.to(TableBody.class, "table_body"), TuplesKt.to(TableRow.class, "table_row"), TuplesKt.to(TableHead.class, "table_header"), TuplesKt.to(BlockQuote.class, "block_quote"), TuplesKt.to(OrderedList.class, "list"), TuplesKt.to(BulletList.class, "list"), TuplesKt.to(ListItem.class, "list_item"), TuplesKt.to(Code.class, "inline_code"), TuplesKt.to(Emphasis.class, "emphasis"), TuplesKt.to(StrongEmphasis.class, "strong"), TuplesKt.to(Link.class, "link"), TuplesKt.to(Image.class, LynxResourceModule.IMAGE_TYPE), TuplesKt.to(Text.class, "text")});
        ILatexPlugin latexPluginDelegate = ILatexPluginKt.getLatexPluginDelegate();
        if (latexPluginDelegate == null || (emptyMap = latexPluginDelegate.getNodeReportMap()) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        mutableMapOf.putAll(emptyMap);
        map = mutableMapOf;
    }

    public final void clear() {
        this.lastBuilder = null;
        this.lastNode = null;
        this.lastMessageId = null;
    }

    public final void analysisJump(MarkdownContent content, boolean stream, String messageId, JumpListener listener) {
        SpannableStringBuilder markdown;
        Node node;
        SpannableStringBuilder spannableStringBuilder;
        if (content == null || (markdown = content.getMarkdown()) == null) {
            return;
        }
        MarkwonContent markwonContent = content instanceof MarkwonContent ? (MarkwonContent) content : null;
        if (markwonContent == null || (node = markwonContent.getNode()) == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = this.lastBuilder;
        Node node2 = this.lastNode;
        if (Intrinsics.areEqual(messageId, this.lastMessageId) && spannableStringBuilder2 != null && node2 != null) {
            int i = 0;
            while (true) {
                spannableStringBuilder = spannableStringBuilder2;
                if (!(spannableStringBuilder.length() > 0) || i >= 3 || !StringsKt.endsWith$default(spannableStringBuilder, "⚫", false, 2, (Object) null)) {
                    break;
                }
                spannableStringBuilder2.delete(spannableStringBuilder2.length() - 1, spannableStringBuilder2.length());
                i++;
            }
            while (true) {
                if (!(spannableStringBuilder.length() > 0)) {
                    break;
                }
                char charAt = spannableStringBuilder2.charAt(spannableStringBuilder2.length() - 1);
                if (!CharsKt.isWhitespace(charAt) && charAt != 65532) {
                    break;
                } else {
                    spannableStringBuilder2.delete(spannableStringBuilder2.length() - 1, spannableStringBuilder2.length());
                }
            }
            analysisJumpContent(spannableStringBuilder2, markdown, node2, node, listener);
        }
        if (stream) {
            this.lastBuilder = markdown;
            this.lastNode = node;
            this.lastMessageId = messageId;
            return;
        }
        clear();
    }

    private final void analysisJumpContent(SpannableStringBuilder preContent, SpannableStringBuilder currContent, Node preNode, Node currNode, JumpListener listener) {
        if (preContent.length() == 0) {
            return;
        }
        if (currContent.length() < preContent.length()) {
            int length = preContent.length() - currContent.length();
            IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
            if (markdownLoggerDelegate != null) {
                markdownLoggerDelegate.mo2528d(TAG, "==>jump, length=" + length);
            }
            if (length != INVALID) {
                analysisNode("", "", preNode, currNode, length, listener);
                return;
            }
            return;
        }
        int length2 = preContent.length();
        for (int i = 0; i < length2; i++) {
            char charAt = currContent.charAt(i);
            char charAt2 = preContent.charAt(i);
            if (charAt != charAt2) {
                int length3 = currContent.length() - preContent.length();
                IMarkdownLogger markdownLoggerDelegate2 = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
                if (markdownLoggerDelegate2 != null) {
                    markdownLoggerDelegate2.mo2528d(TAG, "==>jump, pre=[" + charAt2 + "][" + toHex(charAt2) + "],curr=[" + charAt + "][" + toHex(charAt) + "],length=" + length3 + " \n preContent=" + ((Object) preContent) + " -> curContent=" + ((Object) currContent));
                }
                JumpRecord.INSTANCE.logHit$markdown_impl_release(preContent, currContent);
                if (length3 != INVALID) {
                    String spannableStringBuilder = preContent.toString();
                    Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "preContent.toString()");
                    String spannableStringBuilder2 = currContent.toString();
                    Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "currContent.toString()");
                    analysisNode(spannableStringBuilder, spannableStringBuilder2, preNode, currNode, length3, listener);
                    return;
                }
            }
        }
    }

    private final void analysisNode(String preContent, String currContent, Node preNode, Node currNode, int count, JumpListener listener) {
        String str;
        Node node;
        JumpRecord.INSTANCE.logTree$markdown_impl_release(preNode, currNode);
        Node node2 = preNode;
        while (node2.lastChild != null) {
            node2 = node2.lastChild;
            Intrinsics.checkNotNullExpressionValue(node2, "temp.lastChild");
        }
        String reportName = INSTANCE.getReportName(node2);
        Node node3 = currNode;
        while (true) {
            if (preNode == null || node3 == null) {
                break;
            }
            Companion companion = INSTANCE;
            if (!companion.compare$markdown_impl_release(node3, preNode)) {
                str = companion.getReportName(node3);
                break;
            }
            preNode = preNode.lastChild;
            node3 = node3.lastChild;
            if (preNode == null && node3 != null) {
                Node node4 = node3.parent;
                if (node4 != null && (node = node4.firstChild) != null) {
                    str = companion.getReportName(node);
                }
            }
        }
        str = null;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            while (true) {
                if ((currNode != null ? currNode.lastChild : null) == null) {
                    break;
                } else {
                    currNode = currNode.lastChild;
                }
            }
            if (currNode == null || (str = INSTANCE.getReportName(currNode)) == null) {
                str = SystemUtils.UNKNOWN;
            }
        }
        if (listener != null) {
            listener.onJump(reportName, str, preContent, currContent, count);
        }
        IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
        if (markdownLoggerDelegate != null) {
            markdownLoggerDelegate.mo2531i(TAG, "==>analysis, pre=" + reportName + ",curr=" + str);
        }
    }

    private final String toHex(char c) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            StringBuilder sb = new StringBuilder("\\u");
            String num = Integer.toString(c, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            obj = Result.constructor-impl(sb.append(StringsKt.padStart(num, 4, '0')).toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }
}
