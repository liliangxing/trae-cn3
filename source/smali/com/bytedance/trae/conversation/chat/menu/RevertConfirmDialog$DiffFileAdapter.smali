# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "RevertConfirmDialog.kt"

.field private final items:Ljava/util/List;


.method public constructor <init>(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "items"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter;->items Ljava/util/List;
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter$ViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter$ViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.chat.menu.RevertConfirmDialog$DiffFileAdapter$ViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter;->items Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/DiffFileInfo;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter$ViewHolder;->getTvFilePath()Landroid/widget/TextView;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/im/service/DiffFileInfo;->getFilePath()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +004h
    const-string v3, ""
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter$ViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.chat.menu.RevertConfirmDialog$DiffFileAdapter$ViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_revert_file I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter$ViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter$ViewHolder;-><init>(Landroid/view/View;)V
    return-object v4
.end method
