# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TaskViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $query:Ljava/lang/String;
.field final synthetic $tasksSnapshot:Ljava/util/List;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


.method public static synthetic $r8$lambda$2aEKumZvdxXKNKc9BlFLYVJuWfs(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->invokeSuspend$lambda$2$lambda$0(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$PTBG9ZeeFpXlKMlyD1Ov0XttCkA(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.home.solo.task.TaskModel)java.util.List
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->invokeSuspend$lambda$2(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/home/solo/task/TaskModel;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$xwcj72WsicYCpXVMAqVW7SO9mC8(com.bytedance.trae.im.model.ParsedChatMessage)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->invokeSuspend$lambda$2$lambda$1(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(java.util.List  java.lang.String  com.bytedance.trae.home.solo.task.TaskViewModel  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->$tasksSnapshot Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->$query Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$2(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.home.solo.task.TaskModel)java.util.List
    .registers 3
    # ins_size=2
    invoke-static v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->access$getConversationDetailCacheRepository$p(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v2
    const/16 v0, 2000
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->loadCachedMessages(Ljava/lang/String; I)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda1;
    invoke-direct v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v1, v2, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda2;
    invoke-direct v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v1, v2, Lkotlin/sequences/SequencesKt;->mapNotNull(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v1
    invoke-static v1, Lkotlin/sequences/SequencesKt;->toList(Lkotlin/sequences/Sequence;)Ljava/util/List;
    move-result-object v1
    return-object v1
.end method

.method private static final invokeSuspend$lambda$2$lambda$0(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v0
    return v0
.end method

.method private static final invokeSuspend$lambda$2$lambda$1(com.bytedance.trae.im.model.ParsedChatMessage)java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;->userQueryText(Ljava/util/List;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->$tasksSnapshot Ljava/util/List;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->$query Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;-><init>(Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->label I
    if-nez v0, +017h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->$tasksSnapshot Ljava/util/List;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->$query Ljava/lang/String;
    iget-object v2, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;->this$0 Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda0;
    invoke-direct v3, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)V
    invoke-virtual v5, v0, v1, v3, Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;->search(Ljava/util/List; Ljava/lang/String; Lkotlin/jvm/functions/Function1;)Ljava/util/List;
    move-result-object v5
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
.end method
