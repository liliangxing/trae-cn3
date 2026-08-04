# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4;
.super Ljava/lang/Object;
.source "GitRepoSelectBottomSheet.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic $tempSelectedRepo:Ljava/lang/String;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;


.method constructor <init>(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  java.lang.String)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4;->$tempSelectedRepo Ljava/lang/String;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 11
    # ins_size=2
    const/4 v0, 0
    if-eqz v10, +007h
    invoke-virtual v10, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v10
    goto +2h
    move-object v10, v0
    if-nez v10, +004h
    const-string v10, ""
    iget-object v1, v9, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getIvSearchClear$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Landroid/widget/ImageView;
    move-result-object v1
    const/4 v2, 1
    if-eqz v1, +017h
    move-object v3, v10
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v4, 0
    if-lez v3, +004h
    move v3, v2
    goto +2h
    move v3, v4
    if-eqz v3, +003h
    goto +3h
    const/16 v4, 8
    invoke-virtual v1, v4, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v1, v9, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getSearchJob$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Lkotlinx/coroutines/Job;
    move-result-object v1
    if-eqz v1, +005h
    invoke-static v1, v0, v2, v0, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v1, v9, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    move-object v2, v1
    check-cast v2, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v2, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4;->$tempSelectedRepo Ljava/lang/String;
    invoke-direct v2, v10, v6, v7, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v10
    invoke-static v1, v10, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$setSearchJob$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Lkotlinx/coroutines/Job;)V
    return-void 
.end method

.method public beforeTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    return-void 
.end method

.method public onTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    return-void 
.end method
