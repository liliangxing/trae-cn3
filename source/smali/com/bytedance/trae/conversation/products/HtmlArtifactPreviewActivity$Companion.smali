# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$Companion;
.super Ljava/lang/Object;
.source "HtmlArtifactPreviewActivity.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic start$default(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$Companion  android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 25
    # ins_size=14
    move/from16 v0, v23
    and-int/lit8 v1, v0, 2
    const-string v2, ""
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v13
    and-int/lit8 v3, v0, 4
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v14
    and-int/lit8 v4, v0, 8
    if-eqz v4, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v15
    and-int/lit8 v5, v0, 16
    if-eqz v5, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v6, v0, 32
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v7, v0, 64
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v18
    and-int/lit16 v8, v0, 128
    if-eqz v8, +005h
    const-wide/16 v8, 0
    goto +3h
    move-wide/from16 v8, v19
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v0, v0, 512
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v22
    move-object v13, v11
    move-object v14, v12
    move-object v15, v1
    move-object/from16 v16, v3
    move-object/from16 v17, v4
    move-object/from16 v18, v5
    move-object/from16 v19, v6
    move-object/from16 v20, v7
    move-wide/from16 v21, v8
    move-object/from16 v23, v10
    move-object/from16 v24, v2
    invoke-virtual/range v13 ... v24, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final start(android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  java.lang.String)void
    .registers 14
    # ins_size=12
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatSessionId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, turnId
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "path"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliId"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "realPath"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_chat_session_id"
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_turn_id"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_cli_type"
    invoke-virtual v0, v4, v6, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_path"
    invoke-virtual v0, v4, v7, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_message_id"
    invoke-virtual v0, v4, v8, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_conversation_id"
    invoke-virtual v0, v4, v9, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_created_time"
    invoke-virtual v0, v4, v10, v11, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    const-string v4, "extra_cli_id"
    invoke-virtual v0, v4, v12, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_real_path"
    invoke-virtual v0, v4, v13, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method
