# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/markdown/CMarkInjectParser;
.super Ljava/lang/Object;
.source "CMarkInjectParser.kt"

.implements Lio/noties/markwon/inject/IInjectParser;

.field public static final $stable:I
.field private static final CMARK_FEATURE_OPT_ENABLE_DATA_INLINE_BLOCK:I
.field private static final CMARK_FEATURE_OPT_ENABLE_FORMULA_BACKSLASH_TRUNC:I
.field private static final CMARK_FEATURE_OPT_ENABLE_HTML_INLINE:I
.field private static final CMARK_OPT_DEFAULT:I
.field private static final CMARK_OPT_STRIKETHROUGH_DOUBLE_TILDE:I
.field public static final INSTANCE:Lcom/bytedance/trae/init/markdown/CMarkInjectParser;
.field private static final basicFeatureOptions:I
.field private static final cmarkParser:Lcom/flow/cmark/adapter/CMarkParserNativeLib;
.field private static final extensions:Ljava/util/ArrayList;
.field private static final parserOptions:I
.field private static final unfinishedFeatureOptions:I


.method static constructor <clinit>()void
    .registers 9
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/markdown/CMarkInjectParser;
    invoke-direct v0, Lcom/bytedance/trae/init/markdown/CMarkInjectParser;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/markdown/CMarkInjectParser;->INSTANCE Lcom/bytedance/trae/init/markdown/CMarkInjectParser;
    new-instance v0, Lcom/flow/cmark/adapter/CMarkParserNativeLib;
    invoke-direct v0, Lcom/flow/cmark/adapter/CMarkParserNativeLib;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/markdown/CMarkInjectParser;->cmarkParser Lcom/flow/cmark/adapter/CMarkParserNativeLib;
    const-string/jumbo v1, strikethrough
    const-string/jumbo v2, tagfilter
    const-string/jumbo v3, table
    const-string/jumbo v4, tasklist
    const-string v5, "formula"
    const-string v6, "data-block"
    const-string v7, "data-inline"
    const-string v8, "html-parser"
    filled-new-array/range v1 ... v8, [Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/CollectionsKt;->arrayListOf([Ljava/lang/Object;)Ljava/util/ArrayList;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/init/markdown/CMarkInjectParser;->extensions Ljava/util/ArrayList;
    invoke-virtual v0, Lcom/flow/cmark/adapter/CMarkParserNativeLib;->cmarkGfmCoreExtensionsEnsureRegistered()V
    check-cast v1, Ljava/util/List;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    const/16 v3, 16384
    invoke-virtual v0, v3, v1, v2, Lcom/flow/cmark/adapter/CMarkParserNativeLib;->initCMarkParser(I Ljava/util/List; Ljava/util/Map;)V
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/init/markdown/CMarkInjectParser;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public parseMarkdown(java.lang.String)org.commonmark.node.Node
    .registers 3
    # ins_size=2
    const-string v0, "input"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/init/markdown/CMarkInjectParser;->parseMarkdown(Ljava/lang/String; Z)Lorg/commonmark/node/Node;
    move-result-object v2
    return-object v2
.end method

.method public parseMarkdown(java.lang.String  boolean)org.commonmark.node.Node
    .registers 4
    # ins_size=3
    const-string v0, "input"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v3, +005h
    const/16 v3, 24
    goto +3h
    const/16 v3, 56
    sget-object v0, Lcom/bytedance/trae/init/markdown/CMarkInjectParser;->cmarkParser Lcom/flow/cmark/adapter/CMarkParserNativeLib;
    invoke-virtual v0, v2, v3, Lcom/flow/cmark/adapter/CMarkParserNativeLib;->parseMarkdown(Ljava/lang/String; I)Lcom/flow/cmark/adapter/CMarkNodeJava;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/init/markdown/CMarkParserManager;->INSTANCE Lcom/bytedance/trae/init/markdown/CMarkParserManager;
    invoke-virtual v3, v2, Lcom/bytedance/trae/init/markdown/CMarkParserManager;->transformToMarkwonNode(Lcom/flow/cmark/adapter/CMarkNodeJava;)Lorg/commonmark/node/Node;
    move-result-object v2
    if-nez v2, +011h
    new-instance v2, Lorg/commonmark/node/Document;
    invoke-direct v2, Lorg/commonmark/node/Document;-><init>()V
    check-cast v2, Lorg/commonmark/node/Node;
    goto +8h
    new-instance v2, Lorg/commonmark/node/Document;
    invoke-direct v2, Lorg/commonmark/node/Document;-><init>()V
    check-cast v2, Lorg/commonmark/node/Node;
    return-object v2
    :try_start_0xc
.end method

.method public supportMultiThread()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method
