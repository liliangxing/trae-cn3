# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "MediaGridAdapter.kt"

.field private final binding:Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;
.field private final onCameraClick:Lkotlin/jvm/functions/Function0;


.method public static synthetic $r8$lambda$y1R-vAlDIHFADjXje8jv9XoxKio(com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$CameraViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;->bind$lambda$0(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.databinding.TraeMediaChooseItemCameraBinding  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=3
    const-string v0, "binding"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onCameraClick"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;->getRoot()Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    move-result-object v0
    check-cast v0, Landroid/view/View;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;->onCameraClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method private static final bind$lambda$0(com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$CameraViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;->onCameraClick Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final bind()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;->getRoot()Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
