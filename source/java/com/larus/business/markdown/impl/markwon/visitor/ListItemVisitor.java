package com.larus.business.markdown.impl.markwon.visitor;

import com.larus.business.markdown.api.model.BlockQuoteConfig;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.Prop;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.factory.ListItemSpanFactory2;
import io.noties.markwon.core.listblock.ListBlockExtKt;
import io.noties.markwon.span.SpanCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Document;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;

/* compiled from: ListItemVisitor.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/visitor/ListItemVisitor;", "Lio/noties/markwon/MarkwonVisitor$NodeVisitor;", "Lorg/commonmark/node/ListItem;", "isMarkdownListBlockOptimized", "", "listItemSpaceHeight", "", "blockQuoteConfig", "Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "(ZLjava/lang/Integer;Lcom/larus/business/markdown/api/model/BlockQuoteConfig;)V", "Ljava/lang/Integer;", "visit", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "listItem", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ListItemVisitor implements MarkwonVisitor.NodeVisitor<ListItem> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BlockQuoteConfig blockQuoteConfig;
    private final boolean isMarkdownListBlockOptimized;
    private final Integer listItemSpaceHeight;

    public ListItemVisitor() {
        this(false, null, null, 7, null);
    }

    public ListItemVisitor(boolean z, Integer num, BlockQuoteConfig blockQuoteConfig) {
        this.isMarkdownListBlockOptimized = z;
        this.listItemSpaceHeight = num;
        this.blockQuoteConfig = blockQuoteConfig;
    }

    public /* synthetic */ ListItemVisitor(boolean z, Integer num, BlockQuoteConfig blockQuoteConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : blockQuoteConfig);
    }

    @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
    public void visit(MarkwonVisitor visitor, ListItem listItem) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Intrinsics.checkNotNullParameter(listItem, "listItem");
        boolean z = false;
        boolean z2 = listItem.extraInfoMap.get("start_self") == null;
        Integer num = this.listItemSpaceHeight;
        if (num != null) {
            int intValue = num.intValue();
            if (listItem.getPrevious() != null || (!(listItem.parent.parent instanceof Document) && listItem.parent.getPrevious() != null)) {
                visitor.ensureNewLine();
                int length = visitor.length();
                visitor.builder().append((char) 8203);
                visitor.setSpans(length, SpanCompat.INSTANCE.newLineHeightSpan(intValue));
                visitor.ensureNewLine();
            }
        }
        int length2 = visitor.length();
        Node node = (Node) listItem;
        visitor.visitChildren(node);
        Prop<Integer> prop = CoreProps.BULLET_LIST_ITEM_LEVEL;
        RenderProps renderProps = visitor.renderProps();
        Companion companion = INSTANCE;
        prop.set(renderProps, Integer.valueOf(companion.listLevel(node)));
        CoreProps.LIST_ITEM_REAL_LEVEL.set(visitor.renderProps(), Integer.valueOf(this.isMarkdownListBlockOptimized ? companion.listRealLevel(node) : 0));
        OrderedList orderedList = listItem.parent;
        Intrinsics.checkNotNullExpressionValue(orderedList, "listItem.parent");
        CoreProps.LIST_ITEM_REAL_SELF.set(visitor.renderProps(), Boolean.valueOf(z2));
        SpannableBuilder spannableBuilder = null;
        if (orderedList instanceof OrderedList) {
            Object obj = listItem.extraInfoMap.get("order_number");
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            int intValue2 = num2 != null ? num2.intValue() : orderedList.getStartNumber();
            CoreProps.LIST_ITEM_TYPE.set(visitor.renderProps(), CoreProps.ListItemType.ORDERED);
            CoreProps.ORDERED_LIST_ITEM_NUMBER.set(visitor.renderProps(), Integer.valueOf(intValue2));
            orderedList.setStartNumber(intValue2 + 1);
        } else {
            CoreProps.LIST_ITEM_TYPE.set(visitor.renderProps(), CoreProps.ListItemType.BULLET);
        }
        int length3 = visitor.builder().length();
        if (listItem.firstChild instanceof ListBlock) {
            while (length2 < length3 && (visitor.builder().charAt(length2) == 8203 || visitor.builder().charAt(length2) == '\n')) {
                length2++;
            }
            if (length2 >= length3) {
                return;
            }
        }
        BlockQuoteConfig blockQuoteConfig = this.blockQuoteConfig;
        if (blockQuoteConfig != null && blockQuoteConfig.getEnableNewQuoteStyle()) {
            z = true;
        }
        if (z) {
            SpanFactory spanFactory = visitor.configuration().spansFactory().get(listItem.getClass());
            ListItemSpanFactory2 listItemSpanFactory2 = spanFactory instanceof ListItemSpanFactory2 ? (ListItemSpanFactory2) spanFactory : null;
            if (listItemSpanFactory2 != null) {
                SpannableBuilder builder = visitor.builder();
                MarkwonConfiguration configuration = visitor.configuration();
                Intrinsics.checkNotNullExpressionValue(configuration, "visitor.configuration()");
                RenderProps renderProps2 = visitor.renderProps();
                Intrinsics.checkNotNullExpressionValue(renderProps2, "visitor.renderProps()");
                spannableBuilder = builder.setSpan(listItemSpanFactory2.getSpans(configuration, renderProps2, this.blockQuoteConfig, node), length2);
            }
            if (spannableBuilder == null) {
                visitor.setSpansForNodeOptional((MarkwonVisitor) node, length2);
            }
        } else {
            visitor.setSpansForNodeOptional((MarkwonVisitor) node, length2);
        }
        if (visitor.hasNext(node)) {
            visitor.ensureNewLine();
        }
    }

    /* compiled from: ListItemVisitor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/visitor/ListItemVisitor$Companion;", "", "()V", "listLevel", "", "node", "Lorg/commonmark/node/Node;", "listRealLevel", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int listLevel(Node node) {
            int i = 0;
            for (Node node2 = node.parent; node2 != null; node2 = node2.parent) {
                if (node2 instanceof ListItem) {
                    i++;
                }
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int listRealLevel(Node node) {
            Node node2;
            Node node3 = node.parent;
            int i = 0;
            while (true) {
                Node node4 = node3;
                node2 = node;
                node = node4;
                if (node instanceof Document) {
                    break;
                }
                if (node instanceof ListItem) {
                    i++;
                }
                Intrinsics.checkNotNullExpressionValue(node, "parent");
                node3 = node.parent;
            }
            return node2 instanceof ListBlock ? i + (ListBlockExtKt.getIndent((ListBlock) node2) / Parsing.CODE_BLOCK_INDENT) : i;
        }
    }
}
