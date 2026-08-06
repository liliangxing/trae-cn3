package io.noties.markwon.ext.tables;

import com.ss.android.update.UpdateDialogNewBase;
import io.noties.markwon.ext.tables.TableBlockParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.internal.TableHtmlNodeRenderer;
import org.commonmark.ext.gfm.tables.internal.TableTextContentNodeRenderer;
import org.commonmark.parser.Parser;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlNodeRendererFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.text.TextContentNodeRendererContext;
import org.commonmark.renderer.text.TextContentNodeRendererFactory;
import org.commonmark.renderer.text.TextContentRenderer;

/* compiled from: TablesExtension2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u000eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/ext/tables/TablesExtension2;", "Lorg/commonmark/parser/Parser$ParserExtension;", "Lorg/commonmark/renderer/html/HtmlRenderer$HtmlRendererExtension;", "Lorg/commonmark/renderer/text/TextContentRenderer$TextContentRendererExtension;", "tableOptions", "Lio/noties/markwon/ext/tables/TableOptions;", "(Lio/noties/markwon/ext/tables/TableOptions;)V", "extend", "", "parserBuilder", "Lorg/commonmark/parser/Parser$Builder;", "rendererBuilder", "Lorg/commonmark/renderer/html/HtmlRenderer$Builder;", "Lorg/commonmark/renderer/text/TextContentRenderer$Builder;", "Factory", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TablesExtension2 implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension, TextContentRenderer.TextContentRendererExtension {
    private final TableOptions tableOptions;

    public TablesExtension2(TableOptions tableOptions) {
        Intrinsics.checkParameterIsNotNull(tableOptions, "tableOptions");
        this.tableOptions = tableOptions;
    }

    public void extend(Parser.Builder parserBuilder) {
        Intrinsics.checkParameterIsNotNull(parserBuilder, "parserBuilder");
        parserBuilder.customBlockParserFactory(new Factory(this.tableOptions));
    }

    public void extend(HtmlRenderer.Builder rendererBuilder) {
        Intrinsics.checkParameterIsNotNull(rendererBuilder, "rendererBuilder");
        rendererBuilder.nodeRendererFactory(new HtmlNodeRendererFactory() { // from class: io.noties.markwon.ext.tables.TablesExtension2$extend$1
            /* renamed from: create, reason: merged with bridge method [inline-methods] */
            public final TableHtmlNodeRenderer m4217create(HtmlNodeRendererContext htmlNodeRendererContext) {
                return new TableHtmlNodeRenderer(htmlNodeRendererContext);
            }
        });
    }

    public void extend(TextContentRenderer.Builder rendererBuilder) {
        Intrinsics.checkParameterIsNotNull(rendererBuilder, "rendererBuilder");
        rendererBuilder.nodeRendererFactory(new TextContentNodeRendererFactory() { // from class: io.noties.markwon.ext.tables.TablesExtension2$extend$2
            /* renamed from: create, reason: merged with bridge method [inline-methods] */
            public final TableTextContentNodeRenderer m4218create(TextContentNodeRendererContext textContentNodeRendererContext) {
                return new TableTextContentNodeRenderer(textContentNodeRendererContext);
            }
        });
    }

    /* compiled from: TablesExtension2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/ext/tables/TablesExtension2$Factory;", "Lio/noties/markwon/ext/tables/TableBlockParser$Factory;", "tableOptions", "Lio/noties/markwon/ext/tables/TableOptions;", "(Lio/noties/markwon/ext/tables/TableOptions;)V", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Factory extends TableBlockParser.Factory {
        private final TableOptions tableOptions;

        public Factory(TableOptions tableOptions) {
            Intrinsics.checkParameterIsNotNull(tableOptions, "tableOptions");
            this.tableOptions = tableOptions;
        }

        @Override // io.noties.markwon.ext.tables.TableBlockParser.Factory
        public BlockStart tryStart(ParserState state, MatchedBlockParser matchedBlockParser) {
            Intrinsics.checkParameterIsNotNull(state, "state");
            Intrinsics.checkParameterIsNotNull(matchedBlockParser, "matchedBlockParser");
            CharSequence line = state.getLine();
            CharSequence paragraphContent = matchedBlockParser.getParagraphContent();
            if (paragraphContent == null) {
                return BlockStart.none();
            }
            StringBuilder sb = (StringBuilder) (!(paragraphContent instanceof StringBuilder) ? null : paragraphContent);
            if (sb == null) {
                return super.tryStart(state, matchedBlockParser);
            }
            String str = (String) CollectionsKt.last(StringsKt.split$default(paragraphContent, new String[]{UpdateDialogNewBase.TYPE}, false, 0, 6, (Object) null));
            String str2 = str;
            if (StringsKt.contains$default(str2, "|", false, 2, (Object) null)) {
                List<TableCell.Alignment> parseSeparator = TableBlockParser.parseSeparator(line.subSequence(state.getIndex(), line.length()));
                List<TableCell.Alignment> list = parseSeparator;
                if (!(list == null || list.isEmpty())) {
                    List<String> split = TableBlockParser.split(str2);
                    Intrinsics.checkExpressionValueIsNotNull(split, "TableBlockParser.split(paragraph)");
                    if (parseSeparator.size() >= split.size()) {
                        int length = sb.length();
                        int length2 = length - str.length();
                        if (length2 > 0 && paragraphContent.charAt(length2 - 1) == '\n') {
                            length2--;
                        }
                        sb.delete(length2, length);
                        return BlockStart.of(new BlockParser[]{(BlockParser) new TableBlockParser(parseSeparator, split, str, this.tableOptions.getGenerateExcelLiteral())}).atIndex(state.getIndex());
                    }
                }
            }
            return BlockStart.none();
        }
    }
}
