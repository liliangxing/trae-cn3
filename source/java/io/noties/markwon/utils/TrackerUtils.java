package io.noties.markwon.utils;

import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.core.CoreProps;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
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
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* compiled from: TrackerUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\bH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/noties/markwon/utils/TrackerUtils;", "", "()V", "nodeClassNameMap", "", "", "nodeNameMap", "Ljava/lang/Class;", "Lorg/commonmark/node/Node;", "addTracker", "", "node", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "needTracker", "", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TrackerUtils {
    public static final TrackerUtils INSTANCE = new TrackerUtils();
    private static final Map<Class<? extends Node>, String> nodeNameMap = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ThematicBreak.class, "thematic"), TuplesKt.to(Heading.class, "heading"), TuplesKt.to(FencedCodeBlock.class, "code_block"), TuplesKt.to(IndentedCodeBlock.class, "code_block"), TuplesKt.to(HtmlBlock.class, "html"), TuplesKt.to(HtmlInline.class, "html"), TuplesKt.to(LinkReferenceDefinition.class, "link_ref_def"), TuplesKt.to(Paragraph.class, "paragraph"), TuplesKt.to(BlockQuote.class, "block_quote"), TuplesKt.to(OrderedList.class, "list"), TuplesKt.to(BulletList.class, "list"), TuplesKt.to(ListItem.class, "list_item"), TuplesKt.to(Code.class, "inline_code"), TuplesKt.to(Emphasis.class, "emphasis"), TuplesKt.to(StrongEmphasis.class, "strong"), TuplesKt.to(Link.class, "link"), TuplesKt.to(Image.class, "image"), TuplesKt.to(Text.class, "text")});
    private static final Map<String, String> nodeClassNameMap = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("org.commonmark.ext.gfm.tables.TableBlock", "table"), TuplesKt.to("org.commonmark.ext.gfm.tables.TableCell", "table_cell"), TuplesKt.to("org.commonmark.ext.gfm.tables.TableBody", "table_body"), TuplesKt.to("org.commonmark.ext.gfm.tables.TableCell", "table_row"), TuplesKt.to("org.commonmark.ext.gfm.tables.TableHead", "table_header")});

    private TrackerUtils() {
    }

    private final boolean needTracker(Node node) {
        return (node instanceof ListBlock) || Intrinsics.areEqual(node.getClass().getName(), "org.commonmark.ext.gfm.tables.TableBlock");
    }

    public final void addTracker(Node node, MarkwonVisitor visitor) {
        Integer num;
        Intrinsics.checkParameterIsNotNull(node, "node");
        Intrinsics.checkParameterIsNotNull(visitor, "visitor");
        if (needTracker(node)) {
            HashMap hashMap = (HashMap) CoreProps.RENDER_NODE_INFO.get(visitor.renderProps());
            Class<?> cls = node.getClass();
            String str = nodeNameMap.get(cls);
            if (str == null) {
                str = nodeClassNameMap.get(cls.getName());
            }
            if (str == null) {
                str = cls.getSimpleName();
                Intrinsics.checkExpressionValueIsNotNull(str, "clazz.simpleName");
            }
            if (hashMap == null || (num = (Integer) hashMap.get(str)) == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            if (hashMap != null) {
            }
        }
    }
}
