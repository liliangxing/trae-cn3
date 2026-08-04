# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Z
.field public final synthetic f$1:Ljava/util/List;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;


.method public synthetic constructor <init>(boolean  java.util.List  com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$FileGroupViewHolder)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$$ExternalSyntheticLambda0;->f$0 Z
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$$ExternalSyntheticLambda0;->f$1 Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;
    return-void 
.end method

.method public final run()void
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$$ExternalSyntheticLambda0;->f$0 Z
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$$ExternalSyntheticLambda0;->f$1 Ljava/util/List;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;->$r8$lambda$n3cRJykfMksviEU-KhFgyqYes8c(Z Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;)V
    return-void 
.end method
