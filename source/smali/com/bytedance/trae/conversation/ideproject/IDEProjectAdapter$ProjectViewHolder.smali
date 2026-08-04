# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "IDEProjectAdapter.kt"

.field private final radioButton:Landroid/widget/RadioButton;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;
.field private final tvName:Landroid/widget/TextView;
.field private final tvPath:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$R4ZczJRZS2Zw_i5FCHJ5nHtANLQ(com.bytedance.trae.conversation.ideproject.IDEProjectAdapter$ProjectViewHolder  com.bytedance.trae.conversation.ideproject.IDEProjectAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->_init_$lambda$0(Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder; Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.ideproject.IDEProjectAdapter  android.view.View)void
    .registers 5
    # ins_size=3
    const-string v0, "itemView"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->this$0 Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;
    invoke-direct v2, v4, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->radio_project I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/RadioButton;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->radioButton Landroid/widget/RadioButton;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_project_name I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->tvName Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_project_path I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->tvPath Landroid/widget/TextView;
    new-instance v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder; Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;)V
    invoke-virtual v4, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.conversation.ideproject.IDEProjectAdapter$ProjectViewHolder  com.bytedance.trae.conversation.ideproject.IDEProjectAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->getAdapterPosition()I
    move-result v0
    const/4 v2, -1
    if-eq v0, v2, +017h
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->access$getItem(Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter; I)Lcom/bytedance/trae/conversation/network/ProjectItem;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/ProjectItem;->getProjectId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->setSelectedProjectId(Ljava/lang/String;)V
    invoke-static v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->access$getOnItemClick$p(Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;)Lkotlin/jvm/functions/Function1;
    move-result-object v1
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.network.ProjectItem)void
    .registers 7
    # ins_size=2
    const-string v0, "item"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->tvName Landroid/widget/TextView;
    sget-object v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->INSTANCE Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;
    iget-object v2, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->itemView Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    const-string v3, "getContext(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ProjectItem;->getFolderPath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ProjectItem;->getWorkspaceType()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v2, v3, v4, Lcom/bytedance/trae/conversation/ideproject/IDEProjectNameUtil;->getProjectName(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->tvPath Landroid/widget/TextView;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ProjectItem;->getFolderPath()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->radioButton Landroid/widget/RadioButton;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ProjectItem;->getProjectId()Ljava/lang/String;
    move-result-object v6
    iget-object v1, v5, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->this$0 Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;
    invoke-static v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->access$getSelectedProjectId$p(Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;)Ljava/lang/String;
    move-result-object v1
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    invoke-virtual v0, v6, Landroid/widget/RadioButton;->setChecked(Z)V
    return-void 
.end method
