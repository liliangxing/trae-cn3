# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;
.super Ljava/lang/Object;
.source "PreviewWebViewActivity.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic createIntent$default(com.bytedance.trae.conversation.products.PreviewWebViewActivity$Companion  android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)android.content.Intent
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 4
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v10
    and-int/lit8 v10, v13, 8
    if-eqz v10, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    and-int/lit8 v10, v13, 16
    if-eqz v10, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;->createIntent(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v7
    return-object v7
.end method

.method public static synthetic start$default(com.bytedance.trae.conversation.products.PreviewWebViewActivity$Companion  android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 4
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v10
    and-int/lit8 v10, v13, 8
    if-eqz v10, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    and-int/lit8 v10, v13, 16
    if-eqz v10, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final createIntent(android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String)android.content.Intent
    .registers 8
    # ins_size=6
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;
    invoke-direct v0, v3, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_url"
    invoke-virtual v0, v1, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_title"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_chat_session_id"
    invoke-virtual v0, v4, v6, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_cli_type"
    invoke-virtual v0, v4, v7, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    instance-of v3, v3, Landroid/app/Activity;
    if-nez v3, +007h
    const/high16 v3, 268435456
    invoke-virtual v0, v3, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    return-object v0
.end method

.method public final start(android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=6
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;->createIntent(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v3
    instance-of v4, v2, Lcom/bytedance/trae/conversation/ConversationActivity;
    if-eqz v4, +006h
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/conversation/ConversationActivity;
    goto +15h
    instance-of v4, v2, Landroid/content/ContextWrapper;
    const/4 v5, 0
    if-eqz v4, +010h
    move-object v4, v2
    check-cast v4, Landroid/content/ContextWrapper;
    invoke-virtual v4, Landroid/content/ContextWrapper;->getBaseContext()Landroid/content/Context;
    move-result-object v4
    instance-of v6, v4, Lcom/bytedance/trae/conversation/ConversationActivity;
    if-eqz v6, +005h
    check-cast v4, Lcom/bytedance/trae/conversation/ConversationActivity;
    goto +2h
    move-object v4, v5
    if-eqz v4, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/conversation/ConversationActivity;->getPreviewWebViewLauncher()Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v2
    invoke-virtual v2, v3, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    goto +4h
    invoke-virtual v2, v3, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method
