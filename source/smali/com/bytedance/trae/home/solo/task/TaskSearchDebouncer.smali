# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;
.super Ljava/lang/Object;
.source "TaskSearchDebouncer.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer$Companion;
.field public static final DEFAULT_DEBOUNCE_MS:J
.field private final debounceMs:J
.field private job:Lkotlinx/coroutines/Job;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;


.method public static synthetic $r8$lambda$fsgVET8FUpYEaVaX2VBHo7WmbiY()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->submit$lambda$0()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->Companion Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->$stable I
    return-void 
.end method

.method public constructor <init>(kotlinx.coroutines.CoroutineScope  long)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, scope
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->scope Lkotlinx/coroutines/CoroutineScope;
    iput-wide v3, v1, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->debounceMs J
    return-void 
.end method

.method public synthetic constructor <init>(kotlinx.coroutines.CoroutineScope  long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 2
    if-eqz v4, +004h
    const-wide/16 v2, 200
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;-><init>(Lkotlinx/coroutines/CoroutineScope; J)V
    return-void 
.end method

.method public static final synthetic access$getDebounceMs$p(com.bytedance.trae.home.solo.task.TaskSearchDebouncer)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->debounceMs J
    return-wide v0
.end method

.method public static synthetic submit$default(com.bytedance.trae.home.solo.task.TaskSearchDebouncer  java.lang.String  boolean  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 8
    if-eqz v12, +007h
    new-instance v10, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer$$ExternalSyntheticLambda0;
    invoke-direct v10, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer$$ExternalSyntheticLambda0;-><init>()V
    move-object v4, v10
    move-object v0, v6
    move-object v1, v7
    move v2, v8
    move-object v3, v9
    move-object v5, v11
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->submit(Ljava/lang/String; Z Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final submit$lambda$0()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final cancel()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->job Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->job Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final submit(java.lang.String  boolean  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function2)void
    .registers 15
    # ins_size=6
    const-string v0, "query"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onReset"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onPending"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onSearch"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->job Lkotlinx/coroutines/Job;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v10
    if-eqz v11, +028h
    move-object v11, v10
    check-cast v11, Ljava/lang/CharSequence;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-nez v11, +003h
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +19h
    invoke-interface v13, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    iget-object v3, v9, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v11, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer$submit$2;
    invoke-direct v11, v9, v14, v10, v2, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer$submit$2;-><init>(Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v11
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->job Lkotlinx/coroutines/Job;
    return-void 
    iput-object v2, v9, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->job Lkotlinx/coroutines/Job;
    invoke-interface v12, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method
