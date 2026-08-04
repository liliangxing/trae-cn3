# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "PreviewPagerAdapter.kt"

.field private final binding:Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;


.method public static synthetic $r8$lambda$qzbMMxTXZkrVBZ_0YkCRcvCG3PM(int  com.bytedance.trae.conversation.mediachoose.ui.PreviewPagerAdapter  android.widget.VideoView  android.media.MediaPlayer)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->bind$lambda$0(I Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter; Landroid/widget/VideoView; Landroid/media/MediaPlayer;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.mediachoose.ui.PreviewPagerAdapter  com.bytedance.trae.conversation.databinding.TraeMediaChooseItemPreviewPageBinding)void
    .registers 4
    # ins_size=3
    const-string v0, "binding"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v2
    check-cast v2, Landroid/view/View;
    invoke-direct v1, v2, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;
    return-void 
.end method

.method private static final bind$lambda$0(int  com.bytedance.trae.conversation.mediachoose.ui.PreviewPagerAdapter  android.widget.VideoView  android.media.MediaPlayer)void
    .registers 5
    # ins_size=4
    const/4 v0, 1
    invoke-virtual v4, v0, Landroid/media/MediaPlayer;->setLooping(Z)V
    invoke-static v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->access$getCurrentIndex$p(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;)I
    move-result v2
    if-ne v1, v2, +006h
    invoke-virtual v3, Landroid/widget/VideoView;->start()V
    goto +7h
    invoke-virtual v4, Landroid/media/MediaPlayer;->pause()V
    invoke-virtual v4, v0, Landroid/media/MediaPlayer;->seekTo(I)V
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.mediachoose.model.MediaItem  int)void
    .registers 6
    # ins_size=3
    const-string v0, "item"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v0
    const/4 v1, 0
    const/16 v2, 8
    if-eqz v0, +041h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;->videoView Landroid/widget/VideoView;
    invoke-virtual v0, v1, Landroid/widget/VideoView;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;->videoView Landroid/widget/VideoView;
    const-string/jumbo v1, videoView
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
    invoke-static v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->access$getVideoViews$p(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;)Landroid/util/SparseArray;
    move-result-object v1
    invoke-virtual v1, v5, v0, Landroid/util/SparseArray;->put(I Ljava/lang/Object;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getUri()Landroid/net/Uri;
    move-result-object v4
    invoke-virtual v0, v4, Landroid/widget/VideoView;->setVideoURI(Landroid/net/Uri;)V
    new-instance v4, Landroid/widget/MediaController;
    invoke-virtual v0, Landroid/widget/VideoView;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-direct v4, v1, Landroid/widget/MediaController;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v4, Landroid/widget/VideoView;->setMediaController(Landroid/widget/MediaController;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v1, v5, v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder$$ExternalSyntheticLambda0;-><init>(I Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter; Landroid/widget/VideoView;)V
    invoke-virtual v0, v1, Landroid/widget/VideoView;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V
    goto +1ah
    iget-object v5, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;->videoView Landroid/widget/VideoView;
    invoke-virtual v5, v2, Landroid/widget/VideoView;->setVisibility(I)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v5, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setVisibility(I)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getUri()Landroid/net/Uri;
    move-result-object v4
    invoke-virtual v5, v4, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    return-void 
.end method

.method public final stopVideo()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;->videoView Landroid/widget/VideoView;
    invoke-virtual v0, Landroid/widget/VideoView;->stopPlayback()V
    return-void 
.end method
