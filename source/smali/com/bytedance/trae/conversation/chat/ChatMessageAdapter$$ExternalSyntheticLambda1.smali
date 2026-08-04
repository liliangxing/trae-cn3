# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/content/DialogInterface$OnClickListener;

.field public final synthetic f$0:Landroid/content/Context;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;


.method public synthetic constructor <init>(android.content.Context  java.lang.String  com.bytedance.trae.conversation.chat.ChatMessageAdapter)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda1;->f$0 Landroid/content/Context;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    return-void 
.end method

.method public final onClick(android.content.DialogInterface  int)void
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda1;->f$0 Landroid/content/Context;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    invoke-static v0, v1, v2, v4, v5, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->$r8$lambda$XBdfbBDTWWL7I75EoxeUSKtOlhE(Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Landroid/content/DialogInterface; I)V
    return-void 
.end method
