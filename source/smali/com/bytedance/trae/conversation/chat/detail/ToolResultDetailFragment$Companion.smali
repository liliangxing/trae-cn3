# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;
.super Ljava/lang/Object;
.source "ToolResultDetailFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.chat.detail.ToolResultDetailFragment$Companion  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.chat.detail.ToolResultDetailFragment
    .registers 20
    # ins_size=10
    and-int/lit8 v0, v18, 32
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v16
    and-int/lit8 v0, v18, 64
    if-eqz v0, +004h
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v17
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    move-object v7, v15
    invoke-virtual/range v2 ... v9, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;
    move-result-object v0
    return-object v0
.end method

.method public final newInstance(java.lang.String  java.lang.String)com.bytedance.trae.conversation.chat.detail.ToolResultDetailFragment
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    if-eqz v4, +007h
    const-string v2, "command"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +007h
    const-string v4, "output"
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method

.method public final newInstance(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.chat.detail.ToolResultDetailFragment
    .registers 11
    # ins_size=8
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    if-eqz v4, +007h
    const-string v2, "command"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +007h
    const-string v4, "output"
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v6, +007h
    const-string v4, "command_label"
    invoke-virtual v1, v4, v6, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v7, +007h
    const-string v4, "output_label"
    invoke-virtual v1, v4, v7, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v8, +008h
    const-string/jumbo v4, title
    invoke-virtual v1, v4, v8, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v9, +008h
    const-string/jumbo v4, warning_title
    invoke-virtual v1, v4, v9, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v10, +008h
    const-string/jumbo v4, warning_message
    invoke-virtual v1, v4, v10, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
