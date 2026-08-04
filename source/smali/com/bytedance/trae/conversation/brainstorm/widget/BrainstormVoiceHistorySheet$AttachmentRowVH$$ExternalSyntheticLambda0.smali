# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
.field public final synthetic f$3:Ljava/util/List;
.field public final synthetic f$4:Ljava/lang/String;


.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$AttachmentRowVH  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment  java.util.List  java.lang.String)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;->f$3 Ljava/util/List;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;->f$4 Ljava/lang/String;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;->f$3 Ljava/util/List;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;->f$4 Ljava/lang/String;
    move-object v5, v7
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->$r8$lambda$ESV1WHcj3K9ggRRLYtXz_QzjCw8(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method
