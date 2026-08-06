package com.larus.business.markdown.impl.markwon.visitor;

import android.text.style.ForegroundColorSpan;
import com.larus.business.markdown.api.model.BlockQuoteConfig;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import com.larus.business.markdown.impl.markwon.custom.quote.CustomBlockQuoteSpan;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.core.MarkwonTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Node;

/* compiled from: BlockQuoteVisitor.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/visitor/BlockQuoteVisitor;", "Lio/noties/markwon/MarkwonVisitor$NodeVisitor;", "Lorg/commonmark/node/BlockQuote;", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "(Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;)V", "visit", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "blockQuote", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class BlockQuoteVisitor implements MarkwonVisitor.NodeVisitor<BlockQuote> {
    private final CustomMarkDownInfo customMarkDownInfo;

    public BlockQuoteVisitor(CustomMarkDownInfo customMarkDownInfo) {
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        this.customMarkDownInfo = customMarkDownInfo;
    }

    @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
    public void visit(MarkwonVisitor visitor, BlockQuote blockQuote) {
        Integer blockMargin;
        Integer lineCornerRadius;
        Integer textColorInQuote;
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Intrinsics.checkNotNullParameter(blockQuote, "blockQuote");
        Node node = (Node) blockQuote;
        visitor.blockStart(node);
        int length = visitor.length();
        visitor.visitChildren(node);
        BlockQuoteConfig blockQuoteConfig = this.customMarkDownInfo.getBlockQuoteConfig();
        if (blockQuoteConfig != null && (textColorInQuote = blockQuoteConfig.getTextColorInQuote()) != null) {
            visitor.builder().setSpan(new ForegroundColorSpan(textColorInQuote.intValue()), length);
        }
        MarkwonTheme theme = visitor.configuration().theme();
        Intrinsics.checkNotNullExpressionValue(theme, "visitor.configuration().theme()");
        BlockQuoteConfig blockQuoteConfig2 = this.customMarkDownInfo.getBlockQuoteConfig();
        int i = 0;
        int intValue = (blockQuoteConfig2 == null || (lineCornerRadius = blockQuoteConfig2.getLineCornerRadius()) == null) ? 0 : lineCornerRadius.intValue();
        BlockQuoteConfig blockQuoteConfig3 = this.customMarkDownInfo.getBlockQuoteConfig();
        if (blockQuoteConfig3 != null && (blockMargin = blockQuoteConfig3.getBlockMargin()) != null) {
            i = blockMargin.intValue();
        }
        visitor.builder().setSpan(new CustomBlockQuoteSpan(theme, intValue, i), length);
        visitor.blockEnd(node);
    }
}
