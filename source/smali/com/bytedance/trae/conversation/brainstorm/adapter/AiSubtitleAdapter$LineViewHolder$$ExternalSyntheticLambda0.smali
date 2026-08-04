# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$LineViewHolder  com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$SubtitleLine)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->$r8$lambda$7b16sVPNraQA8QIJrZpfMBjvm7k(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder; Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;)V
    return-void 
.end method
