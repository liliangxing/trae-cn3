# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$Companion;
.super Ljava/lang/Object;
.source "CodeChangedListActivity.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic start$default(com.bytedance.trae.conversation.products.CodeChangedListActivity$Companion  android.content.Context  com.bytedance.trae.im.model.ChangedFileData  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  int  java.lang.Object)void
    .registers 25
    # ins_size=12
    move/from16 v0, v23
    and-int/lit8 v1, v0, 4
    const-string v2, ""
    if-eqz v1, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v16
    and-int/lit8 v1, v0, 8
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v17
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v18
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v19
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v20
    and-int/lit16 v0, v0, 128
    if-eqz v0, +006h
    const-wide/16 v0, 0
    move-wide v11, v0
    goto +3h
    move-wide/from16 v11, v21
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    invoke-virtual/range v3 ... v12, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$Companion;->start(Landroid/content/Context; Lcom/bytedance/trae/im/model/ChangedFileData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J)V
    return-void 
.end method

.method public final start(android.content.Context  com.bytedance.trae.im.model.ChangedFileData  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long)void
    .registers 12
    # ins_size=10
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "changedFileData"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatSessionId"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, turnId
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    invoke-virtual v0, v4, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_changed_file_data_json"
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_chat_session_id"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_turn_id"
    invoke-virtual v0, v4, v6, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_cli_type"
    invoke-virtual v0, v4, v7, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_message_id"
    invoke-virtual v0, v4, v8, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_conversation_id"
    invoke-virtual v0, v4, v9, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_created_time"
    invoke-virtual v0, v4, v10, v11, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    invoke-virtual v3, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method
