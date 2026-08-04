# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda9;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.ConversationViewModel)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda9;->f$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    return-void 
.end method

.method public final onRemoteUserMessage(java.lang.String  java.lang.String  com.google.gson.JsonElement  java.lang.Integer  java.lang.Long  boolean)void
    .registers 14
    # ins_size=7
    iget-object v0, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$$ExternalSyntheticLambda9;->f$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move v6, v13
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/ConversationViewModel;->$r8$lambda$v11wVcq9X9YD0uPN6GhyBPNO2J0(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Ljava/lang/Integer; Ljava/lang/Long; Z)V
    return-void 
.end method
