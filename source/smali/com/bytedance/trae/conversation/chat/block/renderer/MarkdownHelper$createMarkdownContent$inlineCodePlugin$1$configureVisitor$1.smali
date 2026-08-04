# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$configureVisitor$1;
.super Ljava/lang/Object;
.source "MarkdownHelper.kt"

.implements Lio/noties/markwon/MarkwonVisitor$NodeVisitor;

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$configureVisitor$1;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$configureVisitor$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$configureVisitor$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$configureVisitor$1;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$configureVisitor$1;
    return-void 
.end method

.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final visit(io.noties.markwon.MarkwonVisitor  org.commonmark.node.Code)void
    .registers 7
    # ins_size=3
    const-string/jumbo v0, visitor
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "code"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v5, Lio/noties/markwon/MarkwonVisitor;->length()I
    move-result v0
    invoke-interface v5, Lio/noties/markwon/MarkwonVisitor;->builder()Lio/noties/markwon/SpannableBuilder;
    move-result-object v1
    const/16 v2, 160
    invoke-virtual v1, v2, Lio/noties/markwon/SpannableBuilder;->append(C)Lio/noties/markwon/SpannableBuilder;
    move-result-object v1
    invoke-virtual v6, Lorg/commonmark/node/Code;->getLiteral()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v6, Lio/noties/markwon/SpannableBuilder;->append(Ljava/lang/String;)Lio/noties/markwon/SpannableBuilder;
    move-result-object v6
    invoke-virtual v6, v2, Lio/noties/markwon/SpannableBuilder;->append(C)Lio/noties/markwon/SpannableBuilder;
    invoke-interface v5, Lio/noties/markwon/MarkwonVisitor;->builder()Lio/noties/markwon/SpannableBuilder;
    move-result-object v6
    invoke-interface v5, Lio/noties/markwon/MarkwonVisitor;->configuration()Lio/noties/markwon/MarkwonConfiguration;
    move-result-object v1
    invoke-virtual v1, Lio/noties/markwon/MarkwonConfiguration;->spansFactory()Lio/noties/markwon/MarkwonSpansFactory;
    move-result-object v1
    const-class v2, Lorg/commonmark/node/Code;
    invoke-interface v1, v2, Lio/noties/markwon/MarkwonSpansFactory;->require(Ljava/lang/Class;)Lio/noties/markwon/SpanFactory;
    move-result-object v1
    invoke-interface v5, Lio/noties/markwon/MarkwonVisitor;->configuration()Lio/noties/markwon/MarkwonConfiguration;
    move-result-object v2
    invoke-interface v5, Lio/noties/markwon/MarkwonVisitor;->renderProps()Lio/noties/markwon/RenderProps;
    move-result-object v3
    invoke-interface v1, v2, v3, Lio/noties/markwon/SpanFactory;->getSpans(Lio/noties/markwon/MarkwonConfiguration; Lio/noties/markwon/RenderProps;)Ljava/lang/Object;
    move-result-object v1
    invoke-interface v5, Lio/noties/markwon/MarkwonVisitor;->length()I
    move-result v5
    invoke-static v6, v1, v0, v5, Lio/noties/markwon/SpannableBuilder;->setSpans(Lio/noties/markwon/SpannableBuilder; Ljava/lang/Object; I I)V
    return-void 
.end method

.method public bridge synthetic visit(io.noties.markwon.MarkwonVisitor  org.commonmark.node.Node)void
    .registers 3
    # ins_size=3
    check-cast v2, Lorg/commonmark/node/Code;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$configureVisitor$1;->visit(Lio/noties/markwon/MarkwonVisitor; Lorg/commonmark/node/Code;)V
    return-void 
.end method
