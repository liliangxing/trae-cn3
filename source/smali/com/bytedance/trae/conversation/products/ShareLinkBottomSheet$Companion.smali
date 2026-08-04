# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;
.super Ljava/lang/Object;
.source "ShareLinkBottomSheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.products.ShareLinkBottomSheet$Companion  java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.products.ShareLinkBottomSheet
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 4
    if-eqz v0, +006h
    const-string v0, ""
    move-object v4, v0
    goto +2h
    move-object v4, v12
    and-int/lit8 v0, v17, 8
    if-eqz v0, +005h
    const/4 v0, 0
    move v5, v0
    goto +2h
    move v5, v13
    and-int/lit8 v0, v17, 16
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v6, v1
    goto +2h
    move-object v6, v14
    and-int/lit8 v0, v17, 32
    if-eqz v0, +004h
    move-object v7, v1
    goto +2h
    move-object v7, v15
    and-int/lit8 v0, v17, 64
    if-eqz v0, +004h
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v16
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    move-result-object v0
    return-object v0
.end method

.method public final getShareHost()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "https://share.traecontent.com/artifact/"
    goto +3h
    const-string v0, "https://share.traecontent.cn/artifact/"
    return-object v0
.end method

.method public final newInstance(java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.products.ShareLinkBottomSheet
    .registers 9
    # ins_size=8
    const-string v0, "chatSessionId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "artifactPath"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;-><init>()V
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$setChatSessionId$p(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Ljava/lang/String;)V
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$setArtifactPath$p(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Ljava/lang/String;)V
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$setConversationId$p(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Ljava/lang/String;)V
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$setLocal$p(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Z)V
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$setInitialShareUrl$p(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Ljava/lang/String;)V
    invoke-static v0, v7, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$setInitialShareId$p(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Ljava/lang/String;)V
    invoke-static v0, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$setMessageId$p(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Ljava/lang/String;)V
    return-object v0
.end method
