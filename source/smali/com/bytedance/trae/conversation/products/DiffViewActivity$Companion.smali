# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/DiffViewActivity$Companion;
.super Ljava/lang/Object;
.source "DiffViewActivity.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic start$default(com.bytedance.trae.conversation.products.DiffViewActivity$Companion  android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 17
    # ins_size=10
    and-int/lit8 v0, v15, 2
    const-string v1, ""
    if-eqz v0, +004h
    move-object v0, v1
    goto +2h
    move-object v0, v9
    and-int/lit8 v2, v15, 4
    if-eqz v2, +004h
    move-object v2, v1
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v15, 8
    if-eqz v3, +004h
    move-object v3, v1
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v15, 16
    if-eqz v4, +004h
    move-object v4, v1
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v15, 32
    if-eqz v5, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v15, 64
    if-eqz v6, +003h
    goto +2h
    move-object v1, v14
    move-object v9, v7
    move-object v10, v8
    move-object v11, v0
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    move-object v15, v5
    move-object/from16 v16, v1
    invoke-virtual/range v9 ... v16, Lcom/bytedance/trae/conversation/products/DiffViewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final start(android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=8
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskName
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatSessionId"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, turnId
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_task_name"
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_chat_session_id"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_turn_id"
    invoke-virtual v0, v4, v6, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_cli_type"
    invoke-virtual v0, v4, v7, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_conversation_id"
    invoke-virtual v0, v4, v8, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_message_id"
    invoke-virtual v0, v4, v9, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method
