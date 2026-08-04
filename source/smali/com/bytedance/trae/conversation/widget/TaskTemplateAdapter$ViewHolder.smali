# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "TaskTemplateAdapter.kt"

.field private final binding:Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;
.field private final onItemClick:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$3rH8Z51aOEO3q9bblgm5rXqgb8k(int  com.bytedance.trae.conversation.network.TaskTemplateRepository$TaskTemplateModel  com.bytedance.trae.conversation.widget.TaskTemplateAdapter$ViewHolder  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;->bind$lambda$0(I Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel; Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.databinding.TraeItemTaskTemplateBinding  kotlin.jvm.functions.Function1)void
    .registers 4
    # ins_size=3
    const-string v0, "binding"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onItemClick"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    check-cast v0, Landroid/view/View;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;->onItemClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method private static final bind$lambda$0(int  com.bytedance.trae.conversation.network.TaskTemplateRepository$TaskTemplateModel  com.bytedance.trae.conversation.widget.TaskTemplateAdapter$ViewHolder  android.view.View)void
    .registers 5
    # ins_size=4
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/InputTracker;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->getId()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v1, v0, Lcom/bytedance/trae/conversation/tracker/InputTracker;->trackShowcaseClick(I Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;->onItemClick Lkotlin/jvm/functions/Function1;
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
.end method

.method public final bind(com.bytedance.trae.conversation.network.TaskTemplateRepository$TaskTemplateModel  int)void
    .registers 5
    # ins_size=3
    const-string v0, "item"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;->tvTitle Landroid/widget/TextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->getTitle()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->getIcon()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    move v0, v1
    if-eqz v0, +019h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;->ivIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;->ivIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;->getIcon()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    goto +ah
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;->ivIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    const/16 v1, 8
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v1, v4, v3, v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder$$ExternalSyntheticLambda0;-><init>(I Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel; Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
