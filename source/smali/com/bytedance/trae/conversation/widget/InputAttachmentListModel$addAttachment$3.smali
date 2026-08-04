# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputAttachmentListModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $item:Lcom/bytedance/trae/conversation/widget/AttachmentItem;
.field final synthetic $uri:Landroid/net/Uri;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;


.method public static synthetic $r8$lambda$UNkOz8WS4lcQcUnzZLCmhrMrY7A(com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->invokeSuspend$lambda$0(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$frvsylWySKPHfNsC2ARmto9scEg(java.lang.String  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->invokeSuspend$lambda$1(Ljava/lang/String; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.conversation.widget.AttachmentItem  com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->$uri Landroid/net/Uri;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 18
    # ins_size=1
    move-object/from16 v0, v17
    const-wide/16 v1, 0
    const-wide/16 v3, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const-wide/16 v8, 0
    const/4 v10, 0
    sget-object v11, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Uploading Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 639
    const/16 v16, 0
    invoke-static/range v0 ... v16, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->copy$default(Lcom/bytedance/trae/conversation/widget/AttachmentItem; J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method private static final invokeSuspend$lambda$1(java.lang.String  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 19
    # ins_size=2
    move-object/from16 v14, v17
    move-object/from16 v0, v18
    const-wide/16 v1, 0
    const-wide/16 v3, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const-wide/16 v8, 0
    const/4 v10, 0
    sget-object v11, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Error Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    const/4 v12, 0
    const/4 v13, 0
    const/16 v15, 895
    const/16 v16, 0
    invoke-static/range v0 ... v16, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->copy$default(Lcom/bytedance/trae/conversation/widget/AttachmentItem; J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 7
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->$uri Landroid/net/Uri;
    invoke-direct v0, v1, v2, v3, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;-><init>(Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    iput-object v5, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +76h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->L$0 Ljava/lang/Object;
    move-object v4, v13
    check-cast v4, Lkotlinx/coroutines/CoroutineScope;
    iget-object v13, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v13
    iget-object v1, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    new-instance v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3$$ExternalSyntheticLambda0;
    invoke-direct v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v1, v13, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$updateItem(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    iget-object v1, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v3, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->$uri Landroid/net/Uri;
    iget-object v5, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getMimeType()Ljava/lang/String;
    move-result-object v5
    invoke-static v1, v3, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$uriToFile(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Ljava/lang/String;)Ljava/io/File;
    move-result-object v5
    if-nez v5, +029h
    iget-object v0, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->getApplication()Landroid/app/Application;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_file_invalid_format I
    invoke-virtual v0, v1, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3$$ExternalSyntheticLambda1;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String;)V
    invoke-static v1, v13, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$updateItem(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    invoke-static v13, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$get_uploadError$p(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v13
    invoke-virtual v13, v0, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    iget-object v1, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    new-instance v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3$3;
    iget-object v6, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->$uri Landroid/net/Uri;
    iget-object v7, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v9, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->$item Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    const/4 v10, 0
    move-object v3, v11
    move-object v8, v13
    invoke-direct/range v3 ... v10, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3$3;-><init>(Lkotlinx/coroutines/CoroutineScope; Ljava/io/File; Landroid/net/Uri; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lcom/bytedance/trae/conversation/widget/AttachmentItem; Lkotlin/coroutines/Continuation;)V
    check-cast v11, Lkotlin/jvm/functions/Function2;
    move-object v3, v12
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->label I
    invoke-static v1, v13, v11, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$uploadWithFakeProgress(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
.end method
