# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
.super Ljava/lang/Object;
.source "MultiImagePreviewActivity.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic start$default(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$Companion  android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.util.ArrayList  int  java.lang.String  java.lang.String  long  int  java.lang.Object)void
    .registers 27
    # ins_size=13
    move/from16 v0, v25
    and-int/lit8 v1, v0, 2
    const-string v2, ""
    if-eqz v1, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v1, v0, 4
    if-eqz v1, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v1, v0, 8
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v1, v0, 32
    if-eqz v1, +005h
    const/4 v1, 0
    move v9, v1
    goto +3h
    move/from16 v9, v20
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v0, v0, 256
    if-eqz v0, +006h
    const-wide/16 v0, 0
    move-wide v12, v0
    goto +3h
    move-wide/from16 v12, v23
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v8, v19
    invoke-virtual/range v3 ... v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/ArrayList; I Ljava/lang/String; Ljava/lang/String; J)V
    return-void 
.end method

.method public static synthetic startWithImageIds$default(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$Companion  android.content.Context  java.util.ArrayList  int  java.util.ArrayList  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +007h
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->startWithImageIds(Landroid/content/Context; Ljava/util/ArrayList; I Ljava/util/ArrayList;)V
    return-void 
.end method

.method public static synthetic startWithLocalArtifacts$default(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$Companion  android.content.Context  java.util.ArrayList  int  java.util.ArrayList  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 4
    if-eqz v0, +005h
    const/4 v0, 0
    move v4, v0
    goto +2h
    move v4, v12
    and-int/lit8 v0, v17, 8
    if-eqz v0, +009h
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    move-object v5, v0
    goto +2h
    move-object v5, v13
    and-int/lit8 v0, v17, 16
    const-string v1, ""
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
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->startWithLocalArtifacts(Landroid/content/Context; Ljava/util/ArrayList; I Ljava/util/ArrayList; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic startWithLocalUris$default(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$Companion  android.content.Context  java.util.ArrayList  int  java.util.ArrayList  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +007h
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->startWithLocalUris(Landroid/content/Context; Ljava/util/ArrayList; I Ljava/util/ArrayList;)V
    return-void 
.end method

.method public static synthetic startWithRemoteResources$default(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$Companion  android.content.Context  java.util.ArrayList  int  java.util.ArrayList  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 8
    if-eqz v5, +007h
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->startWithRemoteResources(Landroid/content/Context; Ljava/util/ArrayList; I Ljava/util/ArrayList;)V
    return-void 
.end method

.method public final start(android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.util.ArrayList  int  java.lang.String  java.lang.String  long)void
    .registers 13
    # ins_size=11
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatSessionId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, turnId
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "paths"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_chat_session_id"
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_turn_id"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_cli_type"
    invoke-virtual v0, v4, v6, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_paths"
    invoke-virtual v0, v4, v7, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    const-string v4, "extra_current_index"
    invoke-virtual v0, v4, v8, Landroid/content/Intent;->putExtra(Ljava/lang/String; I)Landroid/content/Intent;
    const-string v4, "extra_message_id"
    invoke-virtual v0, v4, v9, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_conversation_id"
    invoke-virtual v0, v4, v10, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_created_time"
    invoke-virtual v0, v4, v11, v12, Landroid/content/Intent;->putExtra(Ljava/lang/String; J)Landroid/content/Intent;
    const-string v4, "extra_resolve_mode"
    const-string v5, "artifact"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method public final startWithImageIds(android.content.Context  java.util.ArrayList  int  java.util.ArrayList)void
    .registers 7
    # ins_size=5
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "imageIds"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayNames"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_paths"
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    const-string v4, "extra_display_names"
    invoke-virtual v0, v4, v6, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    const-string v4, "extra_current_index"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; I)Landroid/content/Intent;
    const-string v4, "extra_resolve_mode"
    const-string v5, "image_id"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method public final startWithLocalArtifacts(android.content.Context  java.util.ArrayList  int  java.util.ArrayList  java.lang.String  java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=8
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "artifactPaths"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayNames"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatSessionId"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_paths"
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    const-string v4, "extra_display_names"
    invoke-virtual v0, v4, v6, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    const-string v4, "extra_current_index"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; I)Landroid/content/Intent;
    const-string v4, "extra_chat_session_id"
    invoke-virtual v0, v4, v7, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_conversation_id"
    invoke-virtual v0, v4, v8, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_message_id"
    invoke-virtual v0, v4, v9, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_resolve_mode"
    const-string v5, "local_artifact"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method public final startWithLocalUris(android.content.Context  java.util.ArrayList  int  java.util.ArrayList)void
    .registers 7
    # ins_size=5
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "localUris"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayNames"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_paths"
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    const-string v4, "extra_display_names"
    invoke-virtual v0, v4, v6, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    const-string v4, "extra_current_index"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; I)Landroid/content/Intent;
    const-string v4, "extra_resolve_mode"
    const-string v5, "local_uri"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method public final startWithRemoteResources(android.content.Context  java.util.ArrayList  int  java.util.ArrayList)void
    .registers 7
    # ins_size=5
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resourceUris
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayNames"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_paths"
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    const-string v4, "extra_display_names"
    invoke-virtual v0, v4, v6, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String; Ljava/util/ArrayList;)Landroid/content/Intent;
    const-string v4, "extra_current_index"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; I)Landroid/content/Intent;
    const-string v4, "extra_resolve_mode"
    const-string v5, "remote_resource"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v0, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method
