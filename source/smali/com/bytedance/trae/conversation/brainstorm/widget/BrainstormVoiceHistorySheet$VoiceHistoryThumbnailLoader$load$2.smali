# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormVoiceHistorySheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $imageId:Ljava/lang/String;
.field final synthetic $resourceId:Ljava/lang/String;
.field final synthetic $row:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
.field final synthetic $source:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$source Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$resourceId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$imageId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$row Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$source Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$resourceId Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$imageId Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$row Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2fh
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v10
    check-cast v10, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2$url$1;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$imageId Ljava/lang/String;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$resourceId Ljava/lang/String;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$row Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    const/4 v8, 0
    move-object v3, v1
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2$url$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v9
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->label I
    invoke-static v10, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    check-cast v10, Ljava/lang/String;
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->access$getBoundImageSource$p(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;)Ljava/lang/String;
    move-result-object v0
    iget-object v1, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$source Ljava/lang/String;
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +02ch
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    goto +18h
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$source Ljava/lang/String;
    invoke-virtual v0, v3, v10, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->put(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$source Ljava/lang/String;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;->$resourceId Ljava/lang/String;
    if-eqz v4, +003h
    goto +2h
    move v2, v1
    invoke-static v0, v3, v10, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->access$loadPreviewUrl(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader; Ljava/lang/String; Ljava/lang/String; Z)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method
