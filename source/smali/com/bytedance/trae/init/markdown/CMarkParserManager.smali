# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/markdown/CMarkParserManager;
.super Ljava/lang/Object;
.source "CMarkParserManager.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/init/markdown/CMarkParserManager;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/markdown/CMarkParserManager;
    invoke-direct v0, Lcom/bytedance/trae/init/markdown/CMarkParserManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/markdown/CMarkParserManager;->INSTANCE Lcom/bytedance/trae/init/markdown/CMarkParserManager;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final generateTableTitleLiteral(com.flow.cmark.adapter.CMarkNodeJava)kotlin.Pair
    .registers 16
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    const/4 v2, 0
    if-eqz v15, +005h
    iget-object v3, v15, Lcom/flow/cmark/adapter/CMarkNodeJava;->typeString Ljava/lang/String;
    goto +2h
    move-object v3, v2
    const-string/jumbo v4, table
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +0d2h
    iget-object v15, v15, Lcom/flow/cmark/adapter/CMarkNodeJava;->firstChild Lcom/flow/cmark/adapter/CMarkNodeJava;
    if-eqz v15, +0ceh
    iget-object v3, v15, Lcom/flow/cmark/adapter/CMarkNodeJava;->firstChild Lcom/flow/cmark/adapter/CMarkNodeJava;
    const/4 v4, 0
    move v5, v4
    const/16 v6, 10
    const/16 v7, 124
    if-eqz v3, +056h
    iget-object v8, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->firstChild Lcom/flow/cmark/adapter/CMarkNodeJava;
    if-eqz v8, +005h
    iget-object v8, v8, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    goto +2h
    move-object v8, v2
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v8
    const/16 v9, 9
    if-nez v8, +018h
    iget-object v8, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->prev Lcom/flow/cmark/adapter/CMarkNodeJava;
    if-nez v8, +005h
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    iget-object v8, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->content Ljava/lang/String;
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-direct v14, v3, v1, Lcom/bytedance/trae/init/markdown/CMarkParserManager;->getTableNodeContent(Lcom/flow/cmark/adapter/CMarkNodeJava; Ljava/lang/StringBuilder;)Lcom/flow/cmark/adapter/CMarkNodeJava;
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +1ah
    iget-object v8, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->prev Lcom/flow/cmark/adapter/CMarkNodeJava;
    if-nez v8, +005h
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    iget-object v8, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->content Ljava/lang/String;
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-direct v14, v3, v1, Lcom/bytedance/trae/init/markdown/CMarkParserManager;->getTableNodeContent(Lcom/flow/cmark/adapter/CMarkNodeJava; Ljava/lang/StringBuilder;)Lcom/flow/cmark/adapter/CMarkNodeJava;
    iget-object v7, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->next Lcom/flow/cmark/adapter/CMarkNodeJava;
    if-eqz v7, +005h
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    iget-object v7, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->next Lcom/flow/cmark/adapter/CMarkNodeJava;
    if-nez v7, +00ch
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    iget-object v7, v15, Lcom/flow/cmark/adapter/CMarkNodeJava;->next Lcom/flow/cmark/adapter/CMarkNodeJava;
    if-eqz v7, +005h
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    iget-object v3, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->next Lcom/flow/cmark/adapter/CMarkNodeJava;
    add-int/lit8 v5, v5, 1
    goto -59h
    iget-object v3, v15, Lcom/flow/cmark/adapter/CMarkNodeJava;->prev Lcom/flow/cmark/adapter/CMarkNodeJava;
    if-nez v3, +068h
    iget-object v3, v15, Lcom/flow/cmark/adapter/CMarkNodeJava;->typeString Ljava/lang/String;
    const-string/jumbo v8, table_header
    invoke-static v3, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    iget-object v3, v15, Lcom/flow/cmark/adapter/CMarkNodeJava;->firstChild Lcom/flow/cmark/adapter/CMarkNodeJava;
    goto +2h
    move-object v3, v2
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    const/4 v8, 1
    if-gt v8, v5, +050h
    move v9, v8
    if-eqz v3, +00ah
    iget-char v10, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->tableAlignment C
    const/16 v11, 108
    if-ne v10, v11, +004h
    move v10, v8
    goto +2h
    move v10, v4
    const/16 v11, 99
    const/16 v12, 58
    if-nez v10, +00dh
    if-eqz v3, +008h
    iget-char v10, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->tableAlignment C
    if-ne v10, v11, +004h
    move v10, v8
    goto +2h
    move v10, v4
    if-eqz v10, +005h
    invoke-virtual v0, v12, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    const-string v10, "---"
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    if-eqz v3, +00ah
    iget-char v10, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->tableAlignment C
    const/16 v13, 114
    if-ne v10, v13, +004h
    move v10, v8
    goto +2h
    move v10, v4
    if-nez v10, +00dh
    if-eqz v3, +008h
    iget-char v10, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->tableAlignment C
    if-ne v10, v11, +004h
    move v10, v8
    goto +2h
    move v10, v4
    if-eqz v10, +005h
    invoke-virtual v0, v12, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    if-eqz v3, +005h
    iget-object v3, v3, Lcom/flow/cmark/adapter/CMarkNodeJava;->next Lcom/flow/cmark/adapter/CMarkNodeJava;
    goto +2h
    move-object v3, v2
    if-eq v9, v5, +005h
    add-int/lit8 v9, v9, 1
    goto -4ch
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    iget-object v15, v15, Lcom/flow/cmark/adapter/CMarkNodeJava;->next Lcom/flow/cmark/adapter/CMarkNodeJava;
    goto/16 -0cch
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v15
    const-string/jumbo v0, toString(...)
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v15, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v15
    return-object v15
.end method

.method private final generateTransformNode(com.flow.cmark.adapter.CMarkNodeJava)org.commonmark.node.Node
    .registers 6
    # ins_size=2
    iget-object v0, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->typeString Ljava/lang/String;
    if-eqz v0, +2b6h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    const-string/jumbo v2, text
    sparse-switch v1, +00002bbh
    goto/16 +2aah
    const-string v1, "html_inline"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +2a0h
    new-instance v0, Lorg/commonmark/node/HtmlInline;
    invoke-direct v0, Lorg/commonmark/node/HtmlInline;-><init>()V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    invoke-virtual v0, v5, Lorg/commonmark/node/HtmlInline;->setLiteral(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string v1, "paragraph"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +289h
    new-instance v5, Lorg/commonmark/node/Paragraph;
    invoke-direct v5, Lorg/commonmark/node/Paragraph;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string/jumbo v1, table_header
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +276h
    new-instance v5, Lorg/commonmark/ext/gfm/tables/TableHead;
    invoke-direct v5, Lorg/commonmark/ext/gfm/tables/TableHead;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string v1, "data-inline"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +264h
    new-instance v0, Lorg/commonmark/node/HtmlInline;
    invoke-direct v0, Lorg/commonmark/node/HtmlInline;-><init>()V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    invoke-virtual v0, v5, Lorg/commonmark/node/HtmlInline;->setLiteral(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string v1, "block_quote"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +24dh
    new-instance v5, Lorg/commonmark/node/BlockQuote;
    invoke-direct v5, Lorg/commonmark/node/BlockQuote;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string v1, "custom_inline"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +23bh
    new-instance v0, Lorg/commonmark/node/Text;
    invoke-direct v0, Lorg/commonmark/node/Text;-><init>()V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    invoke-virtual v0, v5, Lorg/commonmark/node/Text;->setLiteral(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string v1, "document"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +224h
    new-instance v5, Lorg/commonmark/node/Document;
    invoke-direct v5, Lorg/commonmark/node/Document;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string v1, "heading"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +212h
    new-instance v0, Lorg/commonmark/node/Heading;
    invoke-direct v0, Lorg/commonmark/node/Heading;-><init>()V
    iget v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->headingLevel I
    invoke-virtual v0, v5, Lorg/commonmark/node/Heading;->setLevel(I)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string v1, "custom_block"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +1fbh
    new-instance v0, Lorg/commonmark/node/Text;
    invoke-direct v0, Lorg/commonmark/node/Text;-><init>()V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    invoke-virtual v0, v5, Lorg/commonmark/node/Text;->setLiteral(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string/jumbo v1, thematic_break
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +1e3h
    new-instance v5, Lorg/commonmark/node/ThematicBreak;
    invoke-direct v5, Lorg/commonmark/node/ThematicBreak;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string v1, "data-block"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +1d1h
    new-instance v0, Lorg/commonmark/node/HtmlBlock;
    invoke-direct v0, Lorg/commonmark/node/HtmlBlock;-><init>()V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    invoke-virtual v0, v5, Lorg/commonmark/node/HtmlBlock;->setLiteral(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string/jumbo v1, table
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +1b9h
    new-instance v5, Lorg/commonmark/ext/gfm/tables/TableBlock;
    invoke-direct v5, Lorg/commonmark/ext/gfm/tables/TableBlock;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string v1, "image"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +1a7h
    new-instance v0, Lorg/commonmark/node/Image;
    invoke-direct v0, Lorg/commonmark/node/Image;-><init>()V
    iget-object v1, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->url Ljava/lang/String;
    invoke-virtual v0, v1, Lorg/commonmark/node/Image;->setDestination(Ljava/lang/String;)V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->title Ljava/lang/String;
    invoke-virtual v0, v5, Lorg/commonmark/node/Image;->setTitle(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    invoke-virtual v0, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +18dh
    new-instance v0, Lorg/commonmark/node/Text;
    invoke-direct v0, Lorg/commonmark/node/Text;-><init>()V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    invoke-virtual v0, v5, Lorg/commonmark/node/Text;->setLiteral(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string v1, "list"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +176h
    iget v0, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->listType I
    const/4 v1, 1
    if-ne v0, v1, +00ah
    new-instance v5, Lorg/commonmark/node/BulletList;
    invoke-direct v5, Lorg/commonmark/node/BulletList;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    goto +15h
    new-instance v0, Lorg/commonmark/node/OrderedList;
    invoke-direct v0, Lorg/commonmark/node/OrderedList;-><init>()V
    iget v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->listStartIndex I
    invoke-virtual v0, v5, Lorg/commonmark/node/OrderedList;->setStartNumber(I)V
    invoke-virtual v0, Lorg/commonmark/node/OrderedList;->getStartNumber()I
    move-result v5
    invoke-virtual v0, v5, Lorg/commonmark/node/OrderedList;->setOriginalStartNumber(I)V
    move-object v5, v0
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string v1, "link"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +14ah
    new-instance v0, Lorg/commonmark/node/Link;
    invoke-direct v0, Lorg/commonmark/node/Link;-><init>()V
    iget-object v1, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->url Ljava/lang/String;
    invoke-virtual v0, v1, Lorg/commonmark/node/Link;->setDestination(Ljava/lang/String;)V
    iget-object v1, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->firstChild Lcom/flow/cmark/adapter/CMarkNodeJava;
    const/4 v3, 0
    if-eqz v1, +005h
    iget-object v1, v1, Lcom/flow/cmark/adapter/CMarkNodeJava;->typeString Ljava/lang/String;
    goto +2h
    move-object v1, v3
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00bh
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->firstChild Lcom/flow/cmark/adapter/CMarkNodeJava;
    if-eqz v5, +004h
    iget-object v3, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    invoke-virtual v0, v3, Lorg/commonmark/node/Link;->setTitle(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string v1, "item"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +11bh
    new-instance v5, Lorg/commonmark/node/ListItem;
    invoke-direct v5, Lorg/commonmark/node/ListItem;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string v1, "emph"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +109h
    new-instance v5, Lorg/commonmark/node/Emphasis;
    invoke-direct v5, Lorg/commonmark/node/Emphasis;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string v1, "code"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0f7h
    new-instance v0, Lorg/commonmark/node/Code;
    invoke-direct v0, Lorg/commonmark/node/Code;-><init>()V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    invoke-virtual v0, v5, Lorg/commonmark/node/Code;->setLiteral(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string/jumbo v1, tasklist
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0dfh
    new-instance v0, Lio/noties/markwon/ext/tasklist/TaskListItem;
    iget-boolean v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->isDone Z
    invoke-direct v0, v5, Lio/noties/markwon/ext/tasklist/TaskListItem;-><init>(Z)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string v1, "code_block"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0cbh
    new-instance v0, Lorg/commonmark/node/FencedCodeBlock;
    invoke-direct v0, Lorg/commonmark/node/FencedCodeBlock;-><init>()V
    iget-object v1, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->codeLiteral Ljava/lang/String;
    invoke-virtual v0, v1, Lorg/commonmark/node/FencedCodeBlock;->setLiteral(Ljava/lang/String;)V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->codeLanguage Ljava/lang/String;
    invoke-virtual v0, v5, Lorg/commonmark/node/FencedCodeBlock;->setInfo(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string v1, "formula"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0afh
    new-instance v0, Lio/noties/markwon/onetex/LatexMathNode;
    invoke-direct v0, Lio/noties/markwon/onetex/LatexMathNode;-><init>()V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->formulaLiteral Ljava/lang/String;
    invoke-virtual v0, v5, Lio/noties/markwon/onetex/LatexMathNode;->latex(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string/jumbo v1, strong
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +097h
    new-instance v5, Lorg/commonmark/node/StrongEmphasis;
    invoke-direct v5, Lorg/commonmark/node/StrongEmphasis;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string/jumbo v1, strikethrough
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +084h
    new-instance v5, Lorg/commonmark/ext/gfm/strikethrough/Strikethrough;
    invoke-direct v5, Lorg/commonmark/ext/gfm/strikethrough/Strikethrough;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string/jumbo v1, table_cell
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +071h
    new-instance v0, Lorg/commonmark/ext/gfm/tables/TableCell;
    invoke-direct v0, Lorg/commonmark/ext/gfm/tables/TableCell;-><init>()V
    iget-char v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->tableAlignment C
    const/16 v1, 99
    if-eq v5, v1, +013h
    const/16 v1, 108
    if-eq v5, v1, +00ch
    const/16 v1, 114
    if-eq v5, v1, +005h
    sget-object v5, Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;->LEFT Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;
    goto +9h
    sget-object v5, Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;->RIGHT Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;
    goto +6h
    sget-object v5, Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;->LEFT Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;
    goto +3h
    sget-object v5, Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;->CENTER Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;
    invoke-virtual v0, v5, Lorg/commonmark/ext/gfm/tables/TableCell;->setAlignment(Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string v1, "html_block"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +43h
    new-instance v0, Lorg/commonmark/node/HtmlBlock;
    invoke-direct v0, Lorg/commonmark/node/HtmlBlock;-><init>()V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    invoke-virtual v0, v5, Lorg/commonmark/node/HtmlBlock;->setLiteral(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    const-string v1, "linebreak"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +2dh
    new-instance v5, Lorg/commonmark/node/SoftLineBreak;
    invoke-direct v5, Lorg/commonmark/node/SoftLineBreak;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string/jumbo v1, table_row
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +1bh
    new-instance v5, Lorg/commonmark/ext/gfm/tables/TableBody;
    invoke-direct v5, Lorg/commonmark/ext/gfm/tables/TableBody;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    const-string/jumbo v1, softbreak
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +9h
    new-instance v5, Lorg/commonmark/node/SoftLineBreak;
    invoke-direct v5, Lorg/commonmark/node/SoftLineBreak;-><init>()V
    check-cast v5, Lorg/commonmark/node/Node;
    return-object v5
    new-instance v0, Lorg/commonmark/node/Text;
    invoke-direct v0, Lorg/commonmark/node/Text;-><init>()V
    iget-object v5, v5, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    invoke-virtual v0, v5, Lorg/commonmark/node/Text;->setLiteral(Ljava/lang/String;)V
    check-cast v0, Lorg/commonmark/node/Node;
    return-object v0
    nop 
    sparse-switch-payload -7b5790eb -76817217 -6ae47e75 -5f727d07 -59b3c8cd -39f7812d -352a8969 -2860ae9a -236e1045 -1867645d 2eaded 2f90a0 317b13 32affa 32b09e 36452d 5faa95b 6903bce a44e0aa 232191e9 2a969a3f 2f677e02 335cd11b 34498327 490f084a 4a640a1c 4c9e601e 742fc96e 7d2fb1ad
.end method

.method private final getTableNodeContent(com.flow.cmark.adapter.CMarkNodeJava  java.lang.StringBuilder)com.flow.cmark.adapter.CMarkNodeJava
    .registers 6
    # ins_size=3
    const/4 v0, 0
    if-eqz v4, +005h
    iget-object v1, v4, Lcom/flow/cmark/adapter/CMarkNodeJava;->typeString Ljava/lang/String;
    goto +2h
    move-object v1, v0
    const-string/jumbo v2, text
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00ah
    iget-object v0, v4, Lcom/flow/cmark/adapter/CMarkNodeJava;->literal Ljava/lang/String;
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v4, v4, Lcom/flow/cmark/adapter/CMarkNodeJava;->next Lcom/flow/cmark/adapter/CMarkNodeJava;
    return-object v4
    if-eqz v4, +005h
    iget-object v1, v4, Lcom/flow/cmark/adapter/CMarkNodeJava;->firstChild Lcom/flow/cmark/adapter/CMarkNodeJava;
    goto +2h
    move-object v1, v0
    if-eqz v1, +007h
    invoke-direct v3, v1, v5, Lcom/bytedance/trae/init/markdown/CMarkParserManager;->getTableNodeContent(Lcom/flow/cmark/adapter/CMarkNodeJava; Ljava/lang/StringBuilder;)Lcom/flow/cmark/adapter/CMarkNodeJava;
    move-result-object v1
    goto -6h
    if-eqz v4, +004h
    iget-object v0, v4, Lcom/flow/cmark/adapter/CMarkNodeJava;->next Lcom/flow/cmark/adapter/CMarkNodeJava;
    return-object v0
.end method

.method public final transformToMarkwonNode(com.flow.cmark.adapter.CMarkNodeJava)org.commonmark.node.Node
    .registers 7
    # ins_size=2
    if-nez v6, +004h
    const/4 v6, 0
    return-object v6
    invoke-direct v5, v6, Lcom/bytedance/trae/init/markdown/CMarkParserManager;->generateTransformNode(Lcom/flow/cmark/adapter/CMarkNodeJava;)Lorg/commonmark/node/Node;
    move-result-object v0
    instance-of v1, v0, Lorg/commonmark/ext/gfm/tables/TableBlock;
    if-eqz v1, +034h
    move-object v1, v0
    check-cast v1, Lorg/commonmark/ext/gfm/tables/TableBlock;
    iget-object v2, v1, Lorg/commonmark/ext/gfm/tables/TableBlock;->firstChild Lorg/commonmark/node/Node;
    instance-of v2, v2, Lio/noties/markwon/ext/tables/TableTitle;
    if-nez v2, +02bh
    new-instance v2, Lio/noties/markwon/ext/tables/TableTitle;
    invoke-direct v2, Lio/noties/markwon/ext/tables/TableTitle;-><init>()V
    const-string/jumbo v3, table
    invoke-virtual v2, v3, Lio/noties/markwon/ext/tables/TableTitle;->setInfo(Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/init/markdown/CMarkParserManager;->INSTANCE Lcom/bytedance/trae/init/markdown/CMarkParserManager;
    invoke-direct v3, v6, Lcom/bytedance/trae/init/markdown/CMarkParserManager;->generateTableTitleLiteral(Lcom/flow/cmark/adapter/CMarkNodeJava;)Lkotlin/Pair;
    move-result-object v3
    invoke-virtual v3, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v2, v4, Lio/noties/markwon/ext/tables/TableTitle;->setLiteral(Ljava/lang/String;)V
    invoke-virtual v3, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-virtual v2, v3, Lio/noties/markwon/ext/tables/TableTitle;->setExcelLiteral(Ljava/lang/String;)V
    check-cast v2, Lorg/commonmark/node/Node;
    invoke-virtual v1, v2, Lorg/commonmark/ext/gfm/tables/TableBlock;->prependChild(Lorg/commonmark/node/Node;)V
    goto +24h
    instance-of v1, v0, Lorg/commonmark/ext/gfm/tables/TableHead;
    if-eqz v1, +009h
    move-object v1, v0
    check-cast v1, Lorg/commonmark/ext/gfm/tables/TableHead;
    iget-object v1, v1, Lorg/commonmark/ext/gfm/tables/TableHead;->firstChild Lorg/commonmark/node/Node;
    if-eqz v1, +00dh
    instance-of v1, v0, Lorg/commonmark/ext/gfm/tables/TableBody;
    if-eqz v1, +016h
    move-object v1, v0
    check-cast v1, Lorg/commonmark/ext/gfm/tables/TableBody;
    iget-object v1, v1, Lorg/commonmark/ext/gfm/tables/TableBody;->firstChild Lorg/commonmark/node/Node;
    if-nez v1, +00fh
    move-object v1, v0
    check-cast v1, Lorg/commonmark/node/CustomNode;
    new-instance v2, Lorg/commonmark/ext/gfm/tables/TableRow;
    invoke-direct v2, Lorg/commonmark/ext/gfm/tables/TableRow;-><init>()V
    check-cast v2, Lorg/commonmark/node/Node;
    invoke-virtual v1, v2, Lorg/commonmark/node/CustomNode;->appendChild(Lorg/commonmark/node/Node;)V
    iget-object v6, v6, Lcom/flow/cmark/adapter/CMarkNodeJava;->firstChild Lcom/flow/cmark/adapter/CMarkNodeJava;
    if-eqz v6, +037h
    instance-of v1, v0, Lorg/commonmark/ext/gfm/tables/TableHead;
    if-eqz v1, +00bh
    move-object v1, v0
    check-cast v1, Lorg/commonmark/ext/gfm/tables/TableHead;
    iget-object v1, v1, Lorg/commonmark/ext/gfm/tables/TableHead;->firstChild Lorg/commonmark/node/Node;
    instance-of v1, v1, Lorg/commonmark/ext/gfm/tables/TableRow;
    if-nez v1, +00fh
    instance-of v1, v0, Lorg/commonmark/ext/gfm/tables/TableBody;
    if-eqz v1, +01ah
    move-object v1, v0
    check-cast v1, Lorg/commonmark/ext/gfm/tables/TableBody;
    iget-object v1, v1, Lorg/commonmark/ext/gfm/tables/TableBody;->firstChild Lorg/commonmark/node/Node;
    instance-of v1, v1, Lorg/commonmark/ext/gfm/tables/TableRow;
    if-eqz v1, +011h
    move-object v1, v0
    check-cast v1, Lorg/commonmark/node/CustomNode;
    iget-object v1, v1, Lorg/commonmark/node/CustomNode;->firstChild Lorg/commonmark/node/Node;
    if-eqz v1, +013h
    invoke-virtual v5, v6, Lcom/bytedance/trae/init/markdown/CMarkParserManager;->transformToMarkwonNode(Lcom/flow/cmark/adapter/CMarkNodeJava;)Lorg/commonmark/node/Node;
    move-result-object v2
    invoke-virtual v1, v2, Lorg/commonmark/node/Node;->appendChild(Lorg/commonmark/node/Node;)V
    goto +ah
    if-eqz v0, +009h
    invoke-virtual v5, v6, Lcom/bytedance/trae/init/markdown/CMarkParserManager;->transformToMarkwonNode(Lcom/flow/cmark/adapter/CMarkNodeJava;)Lorg/commonmark/node/Node;
    move-result-object v1
    invoke-virtual v0, v1, Lorg/commonmark/node/Node;->appendChild(Lorg/commonmark/node/Node;)V
    iget-object v6, v6, Lcom/flow/cmark/adapter/CMarkNodeJava;->next Lcom/flow/cmark/adapter/CMarkNodeJava;
    goto -36h
    return-object v0
.end method
