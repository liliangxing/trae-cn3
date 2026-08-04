# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $ivOperationIcon:Lcom/facebook/drawee/view/SimpleDraweeView;
.field final synthetic $titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;


.method public static synthetic $r8$lambda$oPc9KO-vD0qdwrIXGNzTKycvUFo(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/view/View;)V
    return-void 
.end method

.method constructor <init>(com.bytedance.trae.common.widget.TraeTitleBar  com.facebook.drawee.view.SimpleDraweeView  com.bytedance.trae.home.solo.task.TaskFragment  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->$titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->$ivOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.home.solo.task.TaskFragment  android.view.View)void
    .registers 11
    # ins_size=2
    sget-object v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->Companion Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/CustomActivityRepository;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->getH5Url()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +03bh
    move-object v10, v2
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v10
    if-eqz v10, +003h
    goto +30h
    const-string/jumbo v10, task_manage
    invoke-static v10, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker;->trackHomeEntryClick(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->Companion Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    const-string/jumbo v9, requireContext(...)
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, ""
    sget-object v9, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->Companion Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/CustomActivityRepository;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->getShareUrl()Ljava/lang/String;
    move-result-object v4
    sget-object v9, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->Companion Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/network/CustomActivityRepository;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->getPostUrl()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/16 v7, 32
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;->start$default(Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 7
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->$titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iget-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->$ivOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v3, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-direct v0, v1, v2, v3, v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;-><init>(Lcom/bytedance/trae/common/widget/TraeTitleBar; Lcom/facebook/drawee/view/SimpleDraweeView; Lcom/bytedance/trae/home/solo/task/TaskFragment; Lkotlin/coroutines/Continuation;)V
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/String;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->invoke(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->label I
    if-nez v0, +03ch
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v3, Ljava/lang/String;
    if-eqz v3, +024h
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->$titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskOperationIconVisible(Z)V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->$ivOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-static v3, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v3
    invoke-virtual v0, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    const-string/jumbo v3, task_manage
    invoke-static v3, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker;->trackHomeEntryShow(Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->$ivOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    invoke-virtual v3, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +dh
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->$titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    const/4 v0, 0
    invoke-virtual v3, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskOperationIconVisible(Z)V
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1$1$1;->$ivOperationIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    const/4 v0, 0
    invoke-virtual v3, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
