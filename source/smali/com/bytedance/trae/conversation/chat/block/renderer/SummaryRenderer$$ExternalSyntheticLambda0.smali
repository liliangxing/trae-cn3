# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
.field public final synthetic f$1:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    check-cast v3, Ljava/lang/String;
    check-cast v4, Ljava/lang/Boolean;
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    invoke-static v0, v1, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->$r8$lambda$7jMVwzK8CrtfXnmvO_8TSJtCsKw(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Ljava/lang/String; Z)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
