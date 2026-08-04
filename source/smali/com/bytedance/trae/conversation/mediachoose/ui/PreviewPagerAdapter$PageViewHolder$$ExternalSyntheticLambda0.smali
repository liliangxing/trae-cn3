# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/media/MediaPlayer$OnPreparedListener;

.field public final synthetic f$0:I
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
.field public final synthetic f$2:Landroid/widget/VideoView;


.method public synthetic constructor <init>(int  com.bytedance.trae.conversation.mediachoose.ui.PreviewPagerAdapter  android.widget.VideoView)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder$$ExternalSyntheticLambda0;->f$0 I
    iput-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder$$ExternalSyntheticLambda0;->f$2 Landroid/widget/VideoView;
    return-void 
.end method

.method public final onPrepared(android.media.MediaPlayer)void
    .registers 5
    # ins_size=2
    iget v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder$$ExternalSyntheticLambda0;->f$0 I
    iget-object v1, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder$$ExternalSyntheticLambda0;->f$2 Landroid/widget/VideoView;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->$r8$lambda$qzbMMxTXZkrVBZ_0YkCRcvCG3PM(I Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter; Landroid/widget/VideoView; Landroid/media/MediaPlayer;)V
    return-void 
.end method
