# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputAttachmentListModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $itemUri:Landroid/net/Uri;
.field final synthetic $uploadBlock:Lkotlin/jvm/functions/Function2;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;


.method public static synthetic $r8$lambda$Mk6JgJRvG8ZQNkDqaDNn63N5ZPs(kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri  int)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->invokeSuspend$lambda$1(Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$m3swkqZLmd-sz9xraLj2ICruh-E(kotlin.jvm.internal.Ref$IntRef  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->invokeSuspend$updateDisplayedProgress$lambda$0(Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$itemUri Landroid/net/Uri;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$uploadBlock Lkotlin/jvm/functions/Function2;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public static final synthetic access$invokeSuspend$updateDisplayedProgress(kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->invokeSuspend$updateDisplayedProgress(Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$1(kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri  int)kotlin.Unit
    .registers 7
    # ins_size=6
    const/16 v0, 99
    invoke-static v6, v0, Ljava/lang/Math;->min(I I)I
    move-result v6
    iput v6, v1, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-static v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->invokeSuspend$updateDisplayedProgress(Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invokeSuspend$updateDisplayedProgress(kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri)void
    .registers 7
    # ins_size=5
    iget v0, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    const/16 v1, 30
    if-le v0, v1, +005h
    iget v2, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    goto +9h
    iget v3, v3, Lkotlin/jvm/internal/Ref$IntRef;->element I
    iget v2, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-static v3, v2, Ljava/lang/Math;->max(I I)I
    move-result v2
    iget v3, v4, Lkotlin/jvm/internal/Ref$IntRef;->element I
    if-le v2, v3, +00ch
    iput v2, v4, Lkotlin/jvm/internal/Ref$IntRef;->element I
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda0;
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/internal/Ref$IntRef;)V
    invoke-static v5, v6, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$updateItem(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final invokeSuspend$updateDisplayedProgress$lambda$0(kotlin.jvm.internal.Ref$IntRef  com.bytedance.trae.conversation.widget.AttachmentItem)com.bytedance.trae.conversation.widget.AttachmentItem
    .registers 19
    # ins_size=2
    move-object/from16 v0, v18
    const-wide/16 v1, 0
    const-wide/16 v3, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const-wide/16 v8, 0
    const/4 v10, 0
    const/4 v11, 0
    move-object/from16 v12, v17
    iget v12, v12, Lkotlin/jvm/internal/Ref$IntRef;->element I
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 1791
    const/16 v16, 0
    invoke-static/range v0 ... v16, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->copy$default(Lcom/bytedance/trae/conversation/widget/AttachmentItem; J J Ljava/lang/String; Landroid/net/Uri; Ljava/lang/String; J Z Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus; I Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v0
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 7
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$itemUri Landroid/net/Uri;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$uploadBlock Lkotlin/jvm/functions/Function2;
    invoke-direct v0, v1, v2, v3, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;-><init>(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)V
    iput-object v5, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 20
    # ins_size=2
    move-object/from16 v1, v18
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +019h
    if-ne v2, v4, +00fh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->L$0 Ljava/lang/Object;
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/Job;
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +06bh
    move-exception v0
    goto/16 +07bh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->L$0 Ljava/lang/Object;
    move-object v5, v2
    check-cast v5, Lkotlinx/coroutines/CoroutineScope;
    new-instance v2, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v2, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    new-instance v13, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v13, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    new-instance v14, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v14, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    const/4 v15, 0
    const/16 v16, 0
    new-instance v17, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$itemUri Landroid/net/Uri;
    const/4 v12, 0
    move-object/from16 v6, v17
    move-object v7, v2
    move-object v8, v13
    move-object v9, v14
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;-><init>(Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v8, v17
    check-cast v8, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    const/4 v10, 0
    move-object v6, v15
    move-object/from16 v7, v16
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v5
    iget-object v6, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    invoke-static v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$getFakeProgressJobs$p(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;)Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v6
    check-cast v6, Ljava/util/Map;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$itemUri Landroid/net/Uri;
    invoke-interface v6, v7, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$uploadBlock Lkotlin/jvm/functions/Function2;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$itemUri Landroid/net/Uri;
    new-instance v15, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;
    move-object v6, v15
    move-object v7, v13
    move-object v8, v2
    move-object v9, v14
    invoke-direct/range v6 ... v11, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri;)V
    iput-object v5, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->L$0 Ljava/lang/Object;
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->label I
    invoke-interface v12, v15, v1, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v0, +003h
    return-object v0
    move-object v2, v5
    invoke-static v2, v3, v4, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$getFakeProgressJobs$p(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;)Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$itemUri Landroid/net/Uri;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    move-object v2, v5
    invoke-static v2, v3, v4, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;->access$getFakeProgressJobs$p(Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;)Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v2
    iget-object v3, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->$itemUri Landroid/net/Uri;
    invoke-virtual v2, v3, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    throw v0
    :try_start_0x13
    :try_start_0x66
.end method
