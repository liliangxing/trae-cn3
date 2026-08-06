package io.noties.markwon.ext.tables;

import io.noties.markwon.ext.tables.CustomTableBlockParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.text.TextContentRenderer;

/* compiled from: CustomTablesExtension.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/noties/markwon/ext/tables/CustomTablesExtension;", "Lorg/commonmark/parser/Parser$ParserExtension;", "Lorg/commonmark/renderer/html/HtmlRenderer$HtmlRendererExtension;", "Lorg/commonmark/renderer/text/TextContentRenderer$TextContentRendererExtension;", "()V", "tablesExtension", "Lorg/commonmark/ext/gfm/tables/TablesExtension;", "extend", "", "parserBuilder", "Lorg/commonmark/parser/Parser$Builder;", "rendererBuilder", "Lorg/commonmark/renderer/html/HtmlRenderer$Builder;", "Lorg/commonmark/renderer/text/TextContentRenderer$Builder;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class CustomTablesExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension, TextContentRenderer.TextContentRendererExtension {
    private final TablesExtension tablesExtension;

    public CustomTablesExtension() {
        TablesExtension create = TablesExtension.create();
        Intrinsics.checkNotNull(create, "null cannot be cast to non-null type org.commonmark.ext.gfm.tables.TablesExtension");
        this.tablesExtension = create;
    }

    public void extend(Parser.Builder parserBuilder) {
        Intrinsics.checkNotNullParameter(parserBuilder, "parserBuilder");
        parserBuilder.customBlockParserFactory(new CustomTableBlockParser.Factory());
    }

    public void extend(HtmlRenderer.Builder rendererBuilder) {
        Intrinsics.checkNotNullParameter(rendererBuilder, "rendererBuilder");
        this.tablesExtension.extend(rendererBuilder);
    }

    public void extend(TextContentRenderer.Builder rendererBuilder) {
        Intrinsics.checkNotNullParameter(rendererBuilder, "rendererBuilder");
        this.tablesExtension.extend(rendererBuilder);
    }
}
