# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;
.super Ljava/lang/Object;
.source "ChatAttachmentDialog.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic newInstance$default(com.bytedance.trae.conversation.widget.ChatAttachmentDialog$Companion  com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.widget.ChatAttachmentDialog
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 2
    const/4 v0, 0
    if-eqz v7, +003h
    move v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    const/4 v5, 0
    invoke-virtual v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;->newInstance(Lcom/bytedance/trae/conversation/widget/ChatMode; Z Z Ljava/lang/String;)Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;
    move-result-object v1
    return-object v1
.end method

.method public final newInstance(com.bytedance.trae.conversation.widget.ChatMode  boolean)com.bytedance.trae.conversation.widget.ChatAttachmentDialog
    .registers 6
    # ins_size=3
    const-string v0, "chatMode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "chat_mode"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/ChatMode;->name()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v4, show_skills
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method

.method public final newInstance(com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String)com.bytedance.trae.conversation.widget.ChatAttachmentDialog
    .registers 8
    # ins_size=5
    const-string v0, "chatMode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    const-string v2, "chat_mode"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/ChatMode;->name()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "is_local"
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    const-string v4, "is_ide"
    invoke-virtual v1, v4, v6, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    const-string v4, "ide_version"
    invoke-virtual v1, v4, v7, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
