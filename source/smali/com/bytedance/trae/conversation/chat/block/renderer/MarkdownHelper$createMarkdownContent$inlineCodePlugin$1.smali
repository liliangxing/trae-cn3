# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1;
.super Lio/noties/markwon/AbstractMarkwonPlugin;
.source "MarkdownHelper.kt"


.method public static synthetic $r8$lambda$Z6530MnqXlpMCQ3yGlp2sVO2YsM(io.noties.markwon.MarkwonConfiguration  io.noties.markwon.RenderProps)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1;->configureSpansFactory$lambda$0(Lio/noties/markwon/MarkwonConfiguration; Lio/noties/markwon/RenderProps;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lio/noties/markwon/AbstractMarkwonPlugin;-><init>()V
    return-void 
.end method

.method private static final configureSpansFactory$lambda$0(io.noties.markwon.MarkwonConfiguration  io.noties.markwon.RenderProps)java.lang.Object
    .registers 3
    # ins_size=2
    const-string v0, "<unused var>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/InlineCodeSpan;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/InlineCodeSpan;-><init>()V
    return-object v1
.end method

.method public configureSpansFactory(io.noties.markwon.MarkwonSpansFactory$Builder)void
    .registers 4
    # ins_size=2
    const-string v0, "builder"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-class v0, Lorg/commonmark/node/Code;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$$ExternalSyntheticLambda0;-><init>()V
    invoke-interface v3, v0, v1, Lio/noties/markwon/MarkwonSpansFactory$Builder;->setFactory(Ljava/lang/Class; Lio/noties/markwon/SpanFactory;)Lio/noties/markwon/MarkwonSpansFactory$Builder;
    return-void 
.end method

.method public configureVisitor(io.noties.markwon.MarkwonVisitor$Builder)void
    .registers 4
    # ins_size=2
    const-string v0, "builder"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-class v0, Lorg/commonmark/node/Code;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$configureVisitor$1;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$configureVisitor$1;
    check-cast v1, Lio/noties/markwon/MarkwonVisitor$NodeVisitor;
    invoke-interface v3, v0, v1, Lio/noties/markwon/MarkwonVisitor$Builder;->on(Ljava/lang/Class; Lio/noties/markwon/MarkwonVisitor$NodeVisitor;)Lio/noties/markwon/MarkwonVisitor$Builder;
    return-void 
.end method
