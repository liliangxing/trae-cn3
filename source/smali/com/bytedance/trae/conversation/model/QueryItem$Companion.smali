# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/model/QueryItem$Companion;
.super Ljava/lang/Object;
.source "QueryItem.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic attachment$default(com.bytedance.trae.conversation.model.QueryItem$Companion  java.lang.String  java.lang.String  long  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.model.QueryItem
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 4
    if-eqz v13, +004h
    const-wide/16 v9, 0
    move-wide v3, v9
    and-int/lit8 v9, v12, 8
    if-eqz v9, +003h
    const/4 v11, 0
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->attachment(Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v6
    return-object v6
.end method

.method public static synthetic image$default(com.bytedance.trae.conversation.model.QueryItem$Companion  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.model.QueryItem
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->image(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic imageUri$default(com.bytedance.trae.conversation.model.QueryItem$Companion  java.lang.String  java.lang.String  long  int  java.lang.Object)com.bytedance.trae.conversation.model.QueryItem
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    const-wide/16 v3, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->imageUri(Ljava/lang/String; Ljava/lang/String; J)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic plugin$default(com.bytedance.trae.conversation.model.QueryItem$Companion  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.model.QueryItem
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-virtual v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/model/QueryItem$Companion;->plugin(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/model/QueryItem;
    move-result-object v1
    return-object v1
.end method

.method public final attachment(java.lang.String  java.lang.String  long  java.lang.String)com.bytedance.trae.conversation.model.QueryItem
    .registers 14
    # ins_size=6
    const-string/jumbo v0, uri
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filename"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    if-eqz v13, +00fh
    move-object v1, v13
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +004h
    move-object v7, v13
    goto +2h
    move-object v7, v0
    new-instance v13, Lcom/bytedance/trae/conversation/model/AttachmentData;
    move-object v2, v13
    move-object v3, v9
    move-object v4, v10
    move-wide v5, v11
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/model/AttachmentData;-><init>(Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String;)V
    new-instance v9, Lcom/bytedance/trae/conversation/model/QueryItem;
    const-string v10, "attachment"
    invoke-direct v9, v10, v13, Lcom/bytedance/trae/conversation/model/QueryItem;-><init>(Ljava/lang/String; Ljava/lang/Object;)V
    return-object v9
.end method

.method public final image(java.lang.String  java.lang.String)com.bytedance.trae.conversation.model.QueryItem
    .registers 5
    # ins_size=3
    const-string/jumbo v0, uri
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    if-eqz v4, +00eh
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    move-object v4, v0
    new-instance v0, Lcom/bytedance/trae/conversation/model/ImageData;
    invoke-direct v0, v3, v4, Lcom/bytedance/trae/conversation/model/ImageData;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v3, Lcom/bytedance/trae/conversation/model/QueryItem;
    const-string v4, "image"
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/conversation/model/QueryItem;-><init>(Ljava/lang/String; Ljava/lang/Object;)V
    return-object v3
.end method

.method public final imageUri(java.lang.String  java.lang.String  long)com.bytedance.trae.conversation.model.QueryItem
    .registers 7
    # ins_size=5
    const-string/jumbo v0, uri
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filename"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/model/QueryItem;
    new-instance v1, Lcom/bytedance/trae/conversation/model/ImageUriData;
    invoke-direct v1, v3, v4, v5, v6, Lcom/bytedance/trae/conversation/model/ImageUriData;-><init>(Ljava/lang/String; Ljava/lang/String; J)V
    const-string v3, "image"
    invoke-direct v0, v3, v1, Lcom/bytedance/trae/conversation/model/QueryItem;-><init>(Ljava/lang/String; Ljava/lang/Object;)V
    return-object v0
.end method

.method public final plugin(java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.model.QueryItem
    .registers 18
    # ins_size=5
    const-string v0, "id"
    move-object v2, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    move-object v3, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/model/QueryItem;
    new-instance v12, Lcom/bytedance/trae/conversation/model/SlashCommandData;
    const-string v6, "plugin"
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 224
    const/4 v11, 0
    move-object v1, v12
    move-object/from16 v4, v16
    move-object/from16 v5, v17
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/conversation/model/SlashCommandData;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const-string/jumbo v1, slash_command
    invoke-direct v0, v1, v12, Lcom/bytedance/trae/conversation/model/QueryItem;-><init>(Ljava/lang/String; Ljava/lang/Object;)V
    return-object v0
.end method

.method public final skill(java.lang.String  java.lang.String)com.bytedance.trae.conversation.model.QueryItem
    .registers 16
    # ins_size=3
    const-string v0, "id"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/model/QueryItem;
    new-instance v12, Lcom/bytedance/trae/conversation/model/SlashCommandData;
    const/4 v4, 0
    const/4 v5, 0
    const-string/jumbo v6, skill
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 236
    const/4 v11, 0
    move-object v1, v12
    move-object v2, v14
    move-object v3, v15
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/conversation/model/SlashCommandData;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const-string/jumbo v14, slash_command
    invoke-direct v0, v14, v12, Lcom/bytedance/trae/conversation/model/QueryItem;-><init>(Ljava/lang/String; Ljava/lang/Object;)V
    return-object v0
.end method

.method public final text(java.lang.String)com.bytedance.trae.conversation.model.QueryItem
    .registers 4
    # ins_size=2
    const-string v0, "content"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/model/QueryItem;
    new-instance v1, Lcom/bytedance/trae/conversation/model/TextData;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/model/TextData;-><init>(Ljava/lang/String;)V
    const-string/jumbo v3, text
    invoke-direct v0, v3, v1, Lcom/bytedance/trae/conversation/model/QueryItem;-><init>(Ljava/lang/String; Ljava/lang/Object;)V
    return-object v0
.end method
