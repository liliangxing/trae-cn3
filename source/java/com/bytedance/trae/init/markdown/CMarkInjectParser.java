package com.bytedance.trae.init.markdown;

import com.flow.cmark.adapter.CMarkParserNativeLib;
import io.noties.markwon.inject.IInjectParser;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Document;
import org.commonmark.node.Node;

/* compiled from: CMarkInjectParser.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/init/markdown/CMarkInjectParser;", "Lio/noties/markwon/inject/IInjectParser;", "<init>", "()V", "cmarkParser", "Lcom/flow/cmark/adapter/CMarkParserNativeLib;", "CMARK_FEATURE_OPT_ENABLE_HTML_INLINE", "", "CMARK_FEATURE_OPT_ENABLE_DATA_INLINE_BLOCK", "CMARK_FEATURE_OPT_ENABLE_FORMULA_BACKSLASH_TRUNC", "basicFeatureOptions", "unfinishedFeatureOptions", "CMARK_OPT_DEFAULT", "CMARK_OPT_STRIKETHROUGH_DOUBLE_TILDE", "parserOptions", "extensions", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "supportMultiThread", "", "parseMarkdown", "Lorg/commonmark/node/Node;", "input", "finished", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CMarkInjectParser implements IInjectParser {
    public static final int $stable;
    private static final int CMARK_FEATURE_OPT_ENABLE_DATA_INLINE_BLOCK = 16;
    private static final int CMARK_FEATURE_OPT_ENABLE_FORMULA_BACKSLASH_TRUNC = 32;
    private static final int CMARK_FEATURE_OPT_ENABLE_HTML_INLINE = 8;
    private static final int CMARK_OPT_DEFAULT = 0;
    private static final int CMARK_OPT_STRIKETHROUGH_DOUBLE_TILDE = 16384;
    public static final CMarkInjectParser INSTANCE = new CMarkInjectParser();
    private static final int basicFeatureOptions = 24;
    private static final CMarkParserNativeLib cmarkParser;
    private static final ArrayList<String> extensions;
    private static final int parserOptions = 16384;
    private static final int unfinishedFeatureOptions = 56;

    public boolean supportMultiThread() {
        return false;
    }

    private CMarkInjectParser() {
    }

    static {
        CMarkParserNativeLib cMarkParserNativeLib = new CMarkParserNativeLib();
        cmarkParser = cMarkParserNativeLib;
        ArrayList<String> arrayListOf = CollectionsKt.arrayListOf(new String[]{"strikethrough", "tagfilter", "table", "tasklist", "formula", "data-block", "data-inline", "html-parser"});
        extensions = arrayListOf;
        cMarkParserNativeLib.cmarkGfmCoreExtensionsEnsureRegistered();
        cMarkParserNativeLib.initCMarkParser(16384, arrayListOf, MapsKt.emptyMap());
        $stable = 8;
    }

    public Node parseMarkdown(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return parseMarkdown(input, true);
    }

    public Node parseMarkdown(String input, boolean finished) {
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            Node transformToMarkwonNode = CMarkParserManager.INSTANCE.transformToMarkwonNode(cmarkParser.parseMarkdown(input, finished ? 24 : 56));
            return transformToMarkwonNode == null ? new Document() : transformToMarkwonNode;
        } catch (Throwable unused) {
            return new Document();
        }
    }
}
