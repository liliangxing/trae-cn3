# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "DirectoryAdapter.kt"

.field private final ivArrow:Landroid/widget/ImageView;
.field private final ivIcon:Landroid/widget/ImageView;
.field private final progressBar:Landroid/widget/ProgressBar;
.field private final rbSelect:Landroid/widget/RadioButton;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
.field private final tvName:Landroid/widget/TextView;
.field private final viewIndent:Landroid/view/View;


.method public static synthetic $r8$lambda$CJluyy_O-G2LGSvZ3MuPk6y6mKI(com.bytedance.trae.conversation.devices.DirectoryAdapter  com.bytedance.trae.conversation.devices.DirectoryNode  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->bind$lambda$0(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Lcom/bytedance/trae/conversation/devices/DirectoryNode; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$daQcSn2GUkXGCpI9DnK-9ratwsQ(com.bytedance.trae.conversation.devices.DirectoryAdapter  com.bytedance.trae.conversation.devices.DirectoryNode  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->bind$lambda$1(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Lcom/bytedance/trae/conversation/devices/DirectoryNode; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.devices.DirectoryAdapter  android.view.View)void
    .registers 4
    # ins_size=3
    const-string v0, "itemView"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    invoke-direct v1, v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->iv_arrow I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    const-string v0, "findViewById(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->ivArrow Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->iv_icon I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->ivIcon Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_name I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->tvName Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->rb_select I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/RadioButton;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->rbSelect Landroid/widget/RadioButton;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->progress_loading I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ProgressBar;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->progressBar Landroid/widget/ProgressBar;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->view_indent I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->viewIndent Landroid/view/View;
    return-void 
.end method

.method private static final bind$lambda$0(com.bytedance.trae.conversation.devices.DirectoryAdapter  com.bytedance.trae.conversation.devices.DirectoryNode  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->access$getOnNodeClick$p(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;)Lkotlin/jvm/functions/Function1;
    move-result-object v0
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bind$lambda$1(com.bytedance.trae.conversation.devices.DirectoryAdapter  com.bytedance.trae.conversation.devices.DirectoryNode  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->access$getOnNodeSelect$p(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;)Lkotlin/jvm/functions/Function1;
    move-result-object v0
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 6
    # ins_size=2
    const-string v0, "node"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v1
    mul-int/lit8 v1, v1, 16
    int-to-float v1, v1
    mul-float/2addr v1, v0
    float-to-int v0, v1
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->viewIndent Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->width I
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->viewIndent Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->requestLayout()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->tvName Landroid/widget/TextView;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getName()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->ivIcon Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_device_folder I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isLoading()Z
    move-result v0
    const/4 v1, 0
    const/4 v2, 4
    if-eqz v0, +00dh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->ivArrow Landroid/widget/ImageView;
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->progressBar Landroid/widget/ProgressBar;
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    goto +2eh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getHasChildren()Z
    move-result v0
    const/16 v3, 8
    if-eqz v0, +01dh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->ivArrow Landroid/widget/ImageView;
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->progressBar Landroid/widget/ProgressBar;
    invoke-virtual v0, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->ivArrow Landroid/widget/ImageView;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded()Z
    move-result v1
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_chevron_down I
    goto +3h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->chevron_right_gray I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    goto +bh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->ivArrow Landroid/widget/ImageView;
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->progressBar Landroid/widget/ProgressBar;
    invoke-virtual v0, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->rbSelect Landroid/widget/RadioButton;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isSelected()Z
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/RadioButton;->setChecked(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->itemView Landroid/view/View;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, v5, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->rbSelect Landroid/widget/RadioButton;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v2, v1, v5, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    invoke-virtual v0, v2, Landroid/widget/RadioButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
