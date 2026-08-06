package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.business.markdown.api.citation.ICitationHandler;
import com.larus.business.markdown.api.depend.LinkResolverWithStyle;
import com.larus.business.markdown.api.model.BgListItemConfig;
import com.larus.business.markdown.api.model.BlockQuoteConfig;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.ListConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import com.larus.business.markdown.impl.C1327R;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.business.markdown.impl.common.utils.MarkdownSettings;
import com.larus.business.markdown.impl.common.utils.MarkdownUnitExtKt;
import com.larus.business.markdown.impl.markwon.custom.title.MarkwonCustomTitleManager;
import com.larus.business.markdown.impl.markwon.custom.title.TableTitleSpanFactory;
import com.larus.business.markdown.impl.markwon.parser.HeadingParserFactory2;
import com.larus.business.markdown.impl.markwon.visitor.BlockQuoteVisitor;
import com.larus.business.markdown.impl.markwon.visitor.ListItemVisitor;
import com.larus.business.markdown.impl.markwon.visitor.SoftLineBreakVisitor;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.BlockHandlerDef;
import io.noties.markwon.LinkResolver;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.core.CorePlugin2;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.core.factory.BgListItemSpanFactory;
import io.noties.markwon.core.factory.BlockQuoteSpanFactory;
import io.noties.markwon.core.factory.CustomLinkSpanFactory;
import io.noties.markwon.core.factory.HeadingSpanFactory2;
import io.noties.markwon.core.factory.ListItemSpanFactory2;
import io.noties.markwon.core.factory.ThematicBreakSpanFactory2;
import io.noties.markwon.core.listblock.ListBlockParserV2;
import io.noties.markwon.core.spans.SpaceSpan;
import io.noties.markwon.core.spans.codeblock.CodeBlockSpanFactory2;
import io.noties.markwon.ext.tables.TableTitle;
import io.noties.markwon.scrollable.ScrollBarTheme;
import io.noties.markwon.span.SpanCompat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.internal.DocumentParser;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.Parser;

/* compiled from: MarkwonExt.kt */
@Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"com/larus/business/markdown/impl/markwon/MarkwonStruct$markwon$10", "Lio/noties/markwon/AbstractMarkwonPlugin;", "afterRender", "", "node", "Lorg/commonmark/node/Node;", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "configureConfiguration", "builder", "Lio/noties/markwon/MarkwonConfiguration$Builder;", "configureParser", "Lorg/commonmark/parser/Parser$Builder;", "configureSpansFactory", "Lio/noties/markwon/MarkwonSpansFactory$Builder;", "configureTheme", "Lio/noties/markwon/core/MarkwonTheme$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkwonStruct$markwon$10 extends AbstractMarkwonPlugin {
    final /* synthetic */ MarkwonStruct this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkwonStruct$markwon$10(MarkwonStruct markwonStruct) {
        this.this$0 = markwonStruct;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureTheme(MarkwonTheme.Builder builder) {
        Context context;
        int color;
        Context context2;
        int color2;
        Context context3;
        int color3;
        Context context4;
        int color4;
        Context context5;
        int color5;
        Integer bulletListItemColor;
        Integer orderedListItemColor;
        Integer blockMargin;
        Integer blockQuoteWidth;
        Integer blockQuoteColor;
        Integer blockMargin2;
        Integer codeTextColor;
        Integer codeBlockTextColor;
        Integer blockBackgroundColor;
        Integer backgroundColor;
        Integer height;
        Integer bgColor;
        Intrinsics.checkNotNullParameter(builder, "builder");
        Integer linkColor = this.this$0.getCustomMarkDownInfo().getLinkColor();
        if (linkColor != null) {
            color = linkColor.intValue();
        } else {
            context = this.this$0.context;
            color = ContextCompat.getColor(context, this.this$0.getCustomMarkDownInfo().getUseSubscribedColor() ? C1327R.color.additional_purple_premium_1 : C1327R.color.primary_50);
        }
        int i = 0;
        builder.linkColor(color).isLinkUnderlined(false).bulletWidth(18);
        Float textLineMulti = this.this$0.getCustomMarkDownInfo().getTextLineMulti();
        if (textLineMulti != null) {
            builder.textLineSpace(textLineMulti.floatValue());
        }
        Float blankLineMulti = this.this$0.getCustomMarkDownInfo().getBlankLineMulti();
        if (blankLineMulti != null) {
            builder.blankLineSpace(blankLineMulti.floatValue());
        }
        ThematicBreakConfig thematicBreakConfig = this.this$0.getCustomMarkDownInfo().getThematicBreakConfig();
        if (thematicBreakConfig == null || (bgColor = thematicBreakConfig.getBgColor()) == null) {
            context2 = this.this$0.context;
            color2 = ContextCompat.getColor(context2, C1327R.color.neutral_transparent_2);
        } else {
            color2 = bgColor.intValue();
        }
        builder.thematicBreakColor(color2);
        ThematicBreakConfig thematicBreakConfig2 = this.this$0.getCustomMarkDownInfo().getThematicBreakConfig();
        builder.thematicBreakHeight((thematicBreakConfig2 == null || (height = thematicBreakConfig2.getHeight()) == null) ? MarkdownDimensExtKt.getDp_1() : height.intValue());
        CodeBlockConfig codeBlockConfig = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        if (codeBlockConfig == null || (backgroundColor = codeBlockConfig.getBackgroundColor()) == null) {
            context3 = this.this$0.context;
            color3 = ContextCompat.getColor(context3, C1327R.color.neutral_transparent_1);
        } else {
            color3 = backgroundColor.intValue();
        }
        builder.codeBackgroundColor(color3);
        CodeBlockConfig codeBlockConfig2 = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        if (codeBlockConfig2 == null || (blockBackgroundColor = codeBlockConfig2.getBlockBackgroundColor()) == null) {
            context4 = this.this$0.context;
            color4 = ContextCompat.getColor(context4, C1327R.color.neutral_transparent_1);
        } else {
            color4 = blockBackgroundColor.intValue();
        }
        builder.codeBlockBackgroundColor(color4);
        CodeBlockConfig codeBlockConfig3 = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        if (codeBlockConfig3 != null && (codeBlockTextColor = codeBlockConfig3.getCodeBlockTextColor()) != null) {
            builder.codeBlockTextColor(codeBlockTextColor.intValue());
        }
        CodeBlockConfig codeBlockConfig4 = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        if (codeBlockConfig4 == null || (codeTextColor = codeBlockConfig4.getCodeTextColor()) == null) {
            context5 = this.this$0.context;
            color5 = ContextCompat.getColor(context5, C1327R.color.neutral_100);
        } else {
            color5 = codeTextColor.intValue();
        }
        builder.codeTextColor(color5);
        CodeBlockConfig codeBlockConfig5 = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        builder.codeBlockMargin((codeBlockConfig5 == null || (blockMargin2 = codeBlockConfig5.getBlockMargin()) == null) ? MarkdownUnitExtKt.dp2px((Number) 16) : blockMargin2.intValue());
        BlockQuoteConfig blockQuoteConfig = this.this$0.getCustomMarkDownInfo().getBlockQuoteConfig();
        builder.blockQuoteColor((blockQuoteConfig == null || (blockQuoteColor = blockQuoteConfig.getBlockQuoteColor()) == null) ? 0 : blockQuoteColor.intValue());
        BlockQuoteConfig blockQuoteConfig2 = this.this$0.getCustomMarkDownInfo().getBlockQuoteConfig();
        builder.blockQuoteWidth((blockQuoteConfig2 == null || (blockQuoteWidth = blockQuoteConfig2.getBlockQuoteWidth()) == null) ? 0 : blockQuoteWidth.intValue());
        BlockQuoteConfig blockQuoteConfig3 = this.this$0.getCustomMarkDownInfo().getBlockQuoteConfig();
        if (blockQuoteConfig3 != null && (blockMargin = blockQuoteConfig3.getBlockMargin()) != null) {
            builder.blockMargin(blockMargin.intValue());
        }
        if (this.this$0.getCustomMarkDownInfo().getListItemColor() != 0) {
            builder.listItemColor(this.this$0.getCustomMarkDownInfo().getListItemColor());
        }
        builder.disableLooseListMargin(!(this.this$0.getCustomMarkDownInfo().getListStyle() != null ? r0.getEnableListInLooseListMargin() : false));
        ListConfig listConfig = this.this$0.getCustomMarkDownInfo().getListConfig();
        builder.orderedListItemColor((listConfig == null || (orderedListItemColor = listConfig.getOrderedListItemColor()) == null) ? 0 : orderedListItemColor.intValue());
        ListConfig listConfig2 = this.this$0.getCustomMarkDownInfo().getListConfig();
        if (listConfig2 != null && (bulletListItemColor = listConfig2.getBulletListItemColor()) != null) {
            i = bulletListItemColor.intValue();
        }
        builder.bulletListItemColor(i);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
        LinkResolverWithStyle markdownLinkResolverV2;
        LinkResolverWithStyle linkResolverWithStyle;
        Intrinsics.checkNotNullParameter(builder, "builder");
        markdownLinkResolverV2 = this.this$0.getMarkdownLinkResolverV2();
        if (markdownLinkResolverV2 != null) {
            linkResolverWithStyle = markdownLinkResolverV2;
        } else {
            final MarkwonStruct markwonStruct = this.this$0;
            linkResolverWithStyle = new LinkResolver() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markwon$10$$ExternalSyntheticLambda0
                @Override // io.noties.markwon.LinkResolver
                public final void resolve(View view, String str) {
                    MarkwonStruct$markwon$10.configureConfiguration$lambda$4(MarkwonStruct.this, view, str);
                }
            };
        }
        builder.linkResolver(linkResolverWithStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configureConfiguration$lambda$4(MarkwonStruct markwonStruct, View view, String str) {
        Function3 markdownLinkResolver;
        Intrinsics.checkNotNullParameter(markwonStruct, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "link");
        markdownLinkResolver = markwonStruct.getMarkdownLinkResolver();
        if (markdownLinkResolver != null) {
            markdownLinkResolver.invoke(view, str, false);
        }
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        MarkdownSettings markdownSettings;
        MarkdownSettings markdownSettings2;
        ListItemSpanFactory2 listItemSpanFactory2;
        Context context;
        int color;
        Context context2;
        Context context3;
        Context context4;
        int color2;
        Context context5;
        Context context6;
        int color3;
        Context context7;
        Integer blockBorderColor;
        Integer blockBorderWidth;
        Integer lineNumberColor;
        Integer cornerRadius;
        Integer titleBgColor;
        Integer blockMargin;
        Integer lineCornerRadius;
        Intrinsics.checkNotNullParameter(builder, "builder");
        markdownSettings = this.this$0.getMarkdownSettings();
        ICitationHandler citationHandler = markdownSettings.getCitationHandler();
        markdownSettings2 = this.this$0.getMarkdownSettings();
        builder.setFactory(Link.class, new CustomLinkSpanFactory(citationHandler, markdownSettings2.getPrintLog()));
        builder.setFactory(ThematicBreak.class, new ThematicBreakSpanFactory2(this.this$0.getCustomMarkDownInfo().getThematicBreakConfig()));
        BlockQuoteConfig blockQuoteConfig = this.this$0.getCustomMarkDownInfo().getBlockQuoteConfig();
        int i = 0;
        if (!(blockQuoteConfig != null && blockQuoteConfig.getEnableNewQuoteStyle())) {
            BlockQuoteConfig blockQuoteConfig2 = this.this$0.getCustomMarkDownInfo().getBlockQuoteConfig();
            int intValue = (blockQuoteConfig2 == null || (lineCornerRadius = blockQuoteConfig2.getLineCornerRadius()) == null) ? 0 : lineCornerRadius.intValue();
            BlockQuoteConfig blockQuoteConfig3 = this.this$0.getCustomMarkDownInfo().getBlockQuoteConfig();
            builder.setFactory(BlockQuote.class, new BlockQuoteSpanFactory(intValue, (blockQuoteConfig3 == null || (blockMargin = blockQuoteConfig3.getBlockMargin()) == null) ? 0 : blockMargin.intValue()));
        }
        if (this.this$0.getCustomMarkDownInfo().getBgListItemConfig() != null) {
            BgListItemConfig bgListItemConfig = this.this$0.getCustomMarkDownInfo().getBgListItemConfig();
            Integer valueOf = bgListItemConfig != null ? Integer.valueOf(bgListItemConfig.getBgColor()) : null;
            BgListItemConfig bgListItemConfig2 = this.this$0.getCustomMarkDownInfo().getBgListItemConfig();
            Integer valueOf2 = bgListItemConfig2 != null ? Integer.valueOf(bgListItemConfig2.getBgMargin()) : null;
            BgListItemConfig bgListItemConfig3 = this.this$0.getCustomMarkDownInfo().getBgListItemConfig();
            Float bgRadius = bgListItemConfig3 != null ? bgListItemConfig3.getBgRadius() : null;
            BgListItemConfig bgListItemConfig4 = this.this$0.getCustomMarkDownInfo().getBgListItemConfig();
            listItemSpanFactory2 = new BgListItemSpanFactory(valueOf, valueOf2, bgRadius, bgListItemConfig4 != null ? bgListItemConfig4.getLeading() : null);
        } else {
            listItemSpanFactory2 = new ListItemSpanFactory2(this.this$0.getCustomMarkDownInfo().getListMarginInfo(), this.this$0.getCustomMarkDownInfo().getListStyle());
        }
        builder.setFactory(ListItem.class, listItemSpanFactory2);
        builder.setFactory(Heading.class, new HeadingSpanFactory2(this.this$0.getCustomMarkDownInfo().getDiffDp(), this.this$0.getCustomMarkDownInfo().getHeadingColor(), this.this$0.getCustomMarkDownInfo().getHeadingLevelTextSizeMap()));
        CodeBlockConfig codeBlockConfig = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        if (codeBlockConfig == null || (titleBgColor = codeBlockConfig.getTitleBgColor()) == null) {
            context = this.this$0.context;
            color = ContextCompat.getColor(context, C1327R.color.neutral_transparent_2);
        } else {
            color = titleBgColor.intValue();
        }
        int i2 = color;
        CodeBlockConfig codeBlockConfig2 = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        float dp2pxFloat = (codeBlockConfig2 == null || (cornerRadius = codeBlockConfig2.getCornerRadius()) == null) ? MarkdownUnitExtKt.dp2pxFloat((Number) 12) : cornerRadius.intValue();
        CodeBlockConfig codeBlockConfig3 = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        boolean enableScroll = codeBlockConfig3 != null ? codeBlockConfig3.getEnableScroll() : false;
        CodeBlockConfig codeBlockConfig4 = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        boolean enableLineNumber = codeBlockConfig4 != null ? codeBlockConfig4.getEnableLineNumber() : false;
        int dp_120 = MarkdownDimensExtKt.getDp_120();
        int dp_4 = MarkdownDimensExtKt.getDp_4();
        context2 = this.this$0.context;
        ScrollBarTheme scrollBarTheme = new ScrollBarTheme(dp_120, dp_4, 0.0f, ContextCompat.getColor(context2, C1327R.color.neutral_30));
        context3 = this.this$0.context;
        int i3 = context3.getResources().getDisplayMetrics().widthPixels;
        CodeBlockConfig codeBlockConfig5 = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        if (codeBlockConfig5 == null || (lineNumberColor = codeBlockConfig5.getLineNumberColor()) == null) {
            context4 = this.this$0.context;
            color2 = ContextCompat.getColor(context4, C1327R.color.neutral_30);
        } else {
            color2 = lineNumberColor.intValue();
        }
        int i4 = color2;
        context5 = this.this$0.context;
        int color4 = ContextCompat.getColor(context5, C1327R.color.neutral_100);
        CodeBlockConfig codeBlockConfig6 = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        float dp2pxFloat2 = (codeBlockConfig6 == null || (blockBorderWidth = codeBlockConfig6.getBlockBorderWidth()) == null) ? MarkdownUnitExtKt.dp2pxFloat(Float.valueOf(0.5f)) : blockBorderWidth.intValue();
        CodeBlockConfig codeBlockConfig7 = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        if (codeBlockConfig7 != null && (blockBorderColor = codeBlockConfig7.getBlockBorderColor()) != null) {
            i = blockBorderColor.intValue();
        }
        int i5 = i;
        CodeBlockConfig codeBlockConfig8 = this.this$0.getCustomMarkDownInfo().getCodeBlockConfig();
        builder.setFactory(FencedCodeBlock.class, new CodeBlockSpanFactory2(i2, dp2pxFloat, enableScroll, enableLineNumber, scrollBarTheme, i3, i4, color4, dp2pxFloat2, i5, codeBlockConfig8 != null ? codeBlockConfig8.getEnableBlockBackground() : true));
        TableConfig tableConfig = this.this$0.getCustomMarkDownInfo().getTableConfig();
        if (tableConfig != null) {
            color3 = tableConfig.getTableTitleBgColor();
        } else {
            context6 = this.this$0.context;
            color3 = ContextCompat.getColor(context6, C1327R.color.neutral_transparent_2);
        }
        float dp2pxFloat3 = MarkdownUnitExtKt.dp2pxFloat((Number) 8);
        context7 = this.this$0.context;
        builder.setFactory(TableTitle.class, new TableTitleSpanFactory(color3, dp2pxFloat3, ContextCompat.getColor(context7, C1327R.color.neutral_transparent_3_web)));
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin
    public void afterRender(Node node, MarkwonVisitor visitor) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        CorePlugin2.INSTANCE.setCommonLineHeight(visitor, this.this$0.getLoading());
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureParser(Parser.Builder builder) {
        MarkdownSettings markdownSettings;
        Intrinsics.checkNotNullParameter(builder, "builder");
        Set defaultBlockParserTypes = DocumentParser.getDefaultBlockParserTypes();
        Intrinsics.checkNotNullExpressionValue(defaultBlockParserTypes, "getDefaultBlockParserTypes()");
        Set mutableSet = CollectionsKt.toMutableSet(defaultBlockParserTypes);
        if (this.this$0.getLoading()) {
            mutableSet.remove(FencedCodeBlock.class);
        }
        mutableSet.remove(IndentedCodeBlock.class);
        mutableSet.remove(Heading.class);
        markdownSettings = this.this$0.getMarkdownSettings();
        if (markdownSettings.isMarkdownListBlockOptimized()) {
            mutableSet.remove(ListBlock.class);
            builder.customBlockParserFactory(new ListBlockParserV2.Factory());
        }
        builder.enabledBlockTypes(mutableSet);
        builder.customBlockParserFactory(new HeadingParserFactory2());
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        MarkdownSettings markdownSettings;
        Intrinsics.checkNotNullParameter(builder, "builder");
        super.configureVisitor(builder);
        markdownSettings = this.this$0.getMarkdownSettings();
        builder.mo2586on(ListItem.class, new ListItemVisitor(markdownSettings.isMarkdownListBlockOptimized(), this.this$0.getCustomMarkDownInfo().getListItemSpaceHeight(), this.this$0.getCustomMarkDownInfo().getBlockQuoteConfig()));
        builder.mo2586on(SoftLineBreak.class, new SoftLineBreakVisitor()).mo2586on(Emphasis.class, new MarkwonVisitor.NodeVisitor() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markwon$10$configureVisitor$1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public final void visit(MarkwonVisitor markwonVisitor, Emphasis emphasis) {
                Intrinsics.checkNotNullParameter(markwonVisitor, "visitor");
                Intrinsics.checkNotNullParameter(emphasis, "emphasis");
                int length = markwonVisitor.length();
                Node node = (Node) emphasis;
                markwonVisitor.visitChildren(node);
                markwonVisitor.setSpansForNodeOptional((MarkwonVisitor) node, length);
                Text text = emphasis.lastChild;
                Text text2 = text instanceof Text ? text : null;
                if (text2 != null) {
                    String literal = text2.getLiteral();
                    Intrinsics.checkNotNullExpressionValue(literal, "it.literal");
                    if (MarkwonExtKt.isLastCharacterChinese(literal)) {
                        int length2 = markwonVisitor.length();
                        markwonVisitor.builder().append((char) 160);
                        markwonVisitor.setSpans(length2, new SpaceSpan(MarkdownDimensExtKt.resDimensionPixelSize(C1327R.dimen.dp_3)));
                    }
                }
            }
        });
        final MarkwonStruct markwonStruct = this.this$0;
        builder.blockHandler(new BlockHandlerDef() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markwon$10$configureVisitor$2
            @Override // io.noties.markwon.BlockHandlerDef, io.noties.markwon.MarkwonVisitor.BlockHandler
            public void blockStart(MarkwonVisitor visitor, Node node) {
                Integer num;
                Intrinsics.checkNotNullParameter(visitor, "visitor");
                Intrinsics.checkNotNullParameter(node, "node");
                Function1<Node, Integer> paragraphTopSpaceHeightProvider = MarkwonStruct.this.getCustomMarkDownInfo().getParagraphTopSpaceHeightProvider();
                int intValue = (paragraphTopSpaceHeightProvider == null || (num = (Integer) paragraphTopSpaceHeightProvider.invoke(node)) == null) ? 0 : num.intValue();
                if (intValue <= 0) {
                    return;
                }
                visitor.ensureNewLine();
                int length = visitor.length();
                visitor.builder().append(" ");
                visitor.setSpans(length, SpanCompat.INSTANCE.newLineHeightSpan(intValue));
                visitor.ensureNewLine();
            }

            @Override // io.noties.markwon.BlockHandlerDef, io.noties.markwon.MarkwonVisitor.BlockHandler
            public void blockEnd(MarkwonVisitor visitor, Node node) {
                Integer paragraphSpaceHeight;
                int dp_16;
                Intrinsics.checkNotNullParameter(visitor, "visitor");
                Intrinsics.checkNotNullParameter(node, "node");
                Function1<Node, Integer> paragraphSpaceHeightProvider = MarkwonStruct.this.getCustomMarkDownInfo().getParagraphSpaceHeightProvider();
                if ((paragraphSpaceHeightProvider != null && (paragraphSpaceHeight = (Integer) paragraphSpaceHeightProvider.invoke(node)) != null) || (paragraphSpaceHeight = MarkwonStruct.this.getCustomMarkDownInfo().getParagraphSpaceHeight()) != null) {
                    dp_16 = paragraphSpaceHeight.intValue();
                } else {
                    dp_16 = MarkdownDimensExtKt.getDp_16();
                }
                if (dp_16 > 0 && visitor.hasNext(node) && !(node.next instanceof HtmlBlock)) {
                    visitor.ensureNewLine();
                    if (MarkwonStruct.this.getCustomMarkDownInfo().getNoBlockSpace()) {
                        return;
                    }
                    int length = visitor.length();
                    visitor.builder().append(" ");
                    visitor.setSpans(length, SpanCompat.INSTANCE.newLineHeightSpan(dp_16));
                    visitor.ensureNewLine();
                }
            }
        });
        final MarkwonStruct markwonStruct2 = this.this$0;
        builder.mo2586on(FencedCodeBlock.class, new MarkwonVisitor.NodeVisitor() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markwon$10$configureVisitor$3
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public final void visit(MarkwonVisitor markwonVisitor, FencedCodeBlock fencedCodeBlock) {
                String substringBefore$default;
                Context context;
                Intrinsics.checkNotNullParameter(markwonVisitor, "visitor");
                Intrinsics.checkNotNullParameter(fencedCodeBlock, "indentedCodeBlock");
                MarkwonCustomTitleManager markwonCustomTitleManager = MarkwonCustomTitleManager.INSTANCE;
                Integer maxContentWidth = MarkwonStruct.this.getMaxContentWidth();
                int intValue = maxContentWidth != null ? maxContentWidth.intValue() : 0;
                String info = fencedCodeBlock.getInfo();
                if (info == null || info.length() == 0) {
                    substringBefore$default = "plaintext";
                } else {
                    String info2 = fencedCodeBlock.getInfo();
                    Intrinsics.checkNotNullExpressionValue(info2, "indentedCodeBlock.info");
                    substringBefore$default = StringsKt.substringBefore$default(info2, " ", (String) null, 2, (Object) null);
                }
                String literal = fencedCodeBlock.getLiteral();
                Intrinsics.checkNotNullExpressionValue(literal, "indentedCodeBlock.literal");
                context = MarkwonStruct.this.context;
                markwonCustomTitleManager.visitCodeBlock(intValue, markwonVisitor, substringBefore$default, literal, (Node) fencedCodeBlock, context, MarkwonStruct.this.getCustomMarkDownInfo(), !MarkwonStruct.this.getLoading());
            }
        });
        final MarkwonStruct markwonStruct3 = this.this$0;
        builder.mo2586on(TableTitle.class, new MarkwonVisitor.NodeVisitor() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markwon$10$configureVisitor$4
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public final void visit(MarkwonVisitor markwonVisitor, TableTitle tableTitle) {
                Context context;
                Intrinsics.checkNotNullParameter(markwonVisitor, "visitor");
                Intrinsics.checkNotNullParameter(tableTitle, "tableTitle");
                MarkwonCustomTitleManager markwonCustomTitleManager = MarkwonCustomTitleManager.INSTANCE;
                context = MarkwonStruct.this.context;
                Integer maxContentWidth = MarkwonStruct.this.getMaxContentWidth();
                markwonCustomTitleManager.visitTableTitle(context, maxContentWidth != null ? maxContentWidth.intValue() : 0, markwonVisitor, tableTitle, MarkwonStruct.this.getCustomMarkDownInfo(), !MarkwonStruct.this.getLoading());
            }
        });
        BlockQuoteConfig blockQuoteConfig = this.this$0.getCustomMarkDownInfo().getBlockQuoteConfig();
        boolean z = false;
        if (blockQuoteConfig != null && blockQuoteConfig.getEnableNewQuoteStyle()) {
            z = true;
        }
        if (z) {
            builder.mo2586on(BlockQuote.class, new BlockQuoteVisitor(this.this$0.getCustomMarkDownInfo()));
        }
    }
}
