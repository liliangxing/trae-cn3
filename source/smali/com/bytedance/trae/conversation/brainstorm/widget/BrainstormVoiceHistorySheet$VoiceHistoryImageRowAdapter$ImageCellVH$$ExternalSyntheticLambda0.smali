# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
.field public final synthetic f$2:Ljava/util/List;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment  java.util.List)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH$$ExternalSyntheticLambda0;->f$2 Ljava/util/List;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH$$ExternalSyntheticLambda0;->f$2 Ljava/util/List;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->$r8$lambda$E6VFApBqiTeimXCL101wkNvhbYI(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List; Landroid/view/View;)V
    return-void 
.end method
