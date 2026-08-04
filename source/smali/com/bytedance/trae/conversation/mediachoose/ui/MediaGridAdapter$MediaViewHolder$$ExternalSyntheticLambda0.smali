# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Z
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;


.method public synthetic constructor <init>(boolean  com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$MediaViewHolder  com.bytedance.trae.conversation.mediachoose.model.MediaItem)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda0;->f$0 Z
    iput-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 5
    # ins_size=2
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda0;->f$0 Z
    iget-object v1, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->$r8$lambda$rGQIF1YTFSh0tQWrmyHXm2uLaVQ(Z Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder; Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem; Landroid/view/View;)V
    return-void 
.end method
