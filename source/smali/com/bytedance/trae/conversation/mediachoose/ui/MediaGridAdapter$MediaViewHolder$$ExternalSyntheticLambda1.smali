# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;
.field public final synthetic f$1:I
.field public final synthetic f$2:Z
.field public final synthetic f$3:Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$MediaViewHolder  int  boolean  com.bytedance.trae.conversation.mediachoose.model.MediaItem)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;
    iput v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1;->f$1 I
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1;->f$2 Z
    iput-object v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1;->f$3 Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;
    iget v1, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1;->f$1 I
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1;->f$2 Z
    iget-object v3, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1;->f$3 Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->$r8$lambda$YUSQSeenBahLld1qtC2QlVYnimw(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder; I Z Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem; Landroid/view/View;)V
    return-void 
.end method
