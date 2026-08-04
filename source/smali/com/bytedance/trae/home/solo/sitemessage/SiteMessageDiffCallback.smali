# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;
.super Landroidx/recyclerview/widget/DiffUtil$Callback;
.source "SiteMessageAdapter.kt"

.field private final newList:Ljava/util/List;
.field private final oldList:Ljava/util/List;


.method public constructor <init>(java.util.List  java.util.List)void
    .registers 4
    # ins_size=3
    const-string v0, "oldList"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newList"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/recyclerview/widget/DiffUtil$Callback;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;->oldList Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;->newList Ljava/util/List;
    return-void 
.end method

.method public areContentsTheSame(int  int)boolean
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;->oldList Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;->newList Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public areItemsTheSame(int  int)boolean
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;->oldList Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;->newList Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v3
    if-ne v2, v3, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method public getNewListSize()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;->newList Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public getOldListSize()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageDiffCallback;->oldList Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method
