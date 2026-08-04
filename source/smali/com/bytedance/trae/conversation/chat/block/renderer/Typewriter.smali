# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
.super Ljava/lang/Object;
.source "Typewriter.kt"

.field private static final ACCEL_THRESHOLD:I
.field private static final BYTE_COUNT_PER_TICK:I
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$Companion;
.field private static final DECEL_THRESHOLD:I
.field private static final DEFAULT_DELAY_MS:J
.field private static final FAST_DELAY_MS:J
.field private static final SLOW_DELAY_MS:J
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;
.field private static final singleThread:Ljava/util/concurrent/ExecutorService;
.field private bridge cancelled:Z
.field private current:I
.field private end:I
.field private fullText:Ljava/lang/String;
.field private job:Lkotlinx/coroutines/Job;
.field private final onContentChanged:Lkotlin/jvm/functions/Function0;
.field private final onTick:Lkotlin/jvm/functions/Function2;
.field private remainingBytes:I


.method public static synthetic $r8$lambda$lSieg6vfmaZ73sPWL7SSexoxX30(java.lang.Runnable)java.lang.Thread
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->singleThread$lambda$1(Ljava/lang/Runnable;)Ljava/lang/Thread;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Ljava/util/concurrent/Executors;->newSingleThreadExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->singleThread Ljava/util/concurrent/ExecutorService;
    const-string/jumbo v2, singleThread
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Lkotlinx/coroutines/ExecutorsKt;->from(Ljava/util/concurrent/ExecutorService;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;
    move-result-object v0
    const/4 v2, 1
    invoke-static v1, v2, v1, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-virtual v0, v1, Lkotlinx/coroutines/ExecutorCoroutineDispatcher;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->scope Lkotlinx/coroutines/CoroutineScope;
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=3
    const-string v0, "onTick"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->onTick Lkotlin/jvm/functions/Function2;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->onContentChanged Lkotlin/jvm/functions/Function0;
    const-string v2, ""
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->fullText Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;-><init>(Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static final synthetic access$getCancelled$p(com.bytedance.trae.conversation.chat.block.renderer.Typewriter)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->cancelled Z
    return v0
.end method

.method public static final synthetic access$getEnd$p(com.bytedance.trae.conversation.chat.block.renderer.Typewriter)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->end I
    return v0
.end method

.method public static final synthetic access$getJob$p(com.bytedance.trae.conversation.chat.block.renderer.Typewriter)kotlinx.coroutines.Job
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->job Lkotlinx/coroutines/Job;
    return-object v0
.end method

.method public static final synthetic access$getOnContentChanged$p(com.bytedance.trae.conversation.chat.block.renderer.Typewriter)kotlin.jvm.functions.Function0
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->onContentChanged Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public static final synthetic access$getOnTick$p(com.bytedance.trae.conversation.chat.block.renderer.Typewriter)kotlin.jvm.functions.Function2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->onTick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public static final synthetic access$getRemainingBytes$p(com.bytedance.trae.conversation.chat.block.renderer.Typewriter)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->remainingBytes I
    return v0
.end method

.method public static final synthetic access$getScope$cp()kotlinx.coroutines.CoroutineScope
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->scope Lkotlinx/coroutines/CoroutineScope;
    return-object v0
.end method

.method public static final synthetic access$loop(com.bytedance.trae.conversation.chat.block.renderer.Typewriter  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->loop(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setEnd$p(com.bytedance.trae.conversation.chat.block.renderer.Typewriter  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->end I
    return-void 
.end method

.method public static final synthetic access$setFullText$p(com.bytedance.trae.conversation.chat.block.renderer.Typewriter  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->fullText Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setJob$p(com.bytedance.trae.conversation.chat.block.renderer.Typewriter  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->job Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final synthetic access$setRemainingBytes$p(com.bytedance.trae.conversation.chat.block.renderer.Typewriter  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->remainingBytes I
    return-void 
.end method

.method private final advanceCursor()int
    .registers 6
    # ins_size=1
    iget v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->current I
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->fullText Ljava/lang/String;
    iget v2, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->end I
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v3
    invoke-static v2, v3, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v2
    const/4 v3, 0
    if-ge v0, v2, +010h
    invoke-virtual v1, v0, Ljava/lang/String;->charAt(I)C
    move-result v4
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->utf8ByteSize(C)I
    move-result v4
    add-int/2addr v3, v4
    add-int/lit8 v0, v0, 1
    const/4 v4, 6
    if-lt v3, v4, -00eh
    iput v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->current I
    return v3
.end method

.method private final computeDelay()long
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->remainingBytes I
    div-int/lit8 v0, v0, 3
    const/16 v1, 80
    if-le v0, v1, +005h
    const-wide/16 v0, 15
    goto +ah
    const/16 v1, 20
    if-ge v0, v1, +005h
    const-wide/16 v0, 40
    goto +3h
    const-wide/16 v0, 25
    return-wide v0
.end method

.method private final loop(kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=2
    instance-of v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;
    if-eqz v0, +012h
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;->label I
    sub-int/2addr v9, v2
    iput v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;
    invoke-direct v0, v8, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +01fh
    if-eq v2, v4, +015h
    if-ne v2, v3, +00bh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v2
    goto +15h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +49h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v8
    iget v2, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->current I
    iget v5, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->end I
    if-ge v2, v5, +04fh
    invoke-direct v9, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->advanceCursor()I
    move-result v2
    iget v5, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->remainingBytes I
    sub-int/2addr v5, v2
    const/4 v2, 0
    invoke-static v5, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v5
    iput v5, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->remainingBytes I
    iget-object v5, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->fullText Ljava/lang/String;
    iget v6, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->current I
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v7
    invoke-static v6, v7, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v6
    invoke-virtual v5, v2, v6, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v5, substring(...)
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v5
    check-cast v5, Lkotlin/coroutines/CoroutineContext;
    new-instance v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;
    const/4 v7, 0
    invoke-direct v6, v9, v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function2;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;->label I
    invoke-static v5, v6, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    move-object v2, v9
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->computeDelay()J
    move-result-wide v5
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$1;->label I
    invoke-static v5, v6, v0, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v1, -066h
    return-object v1
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method

.method private static final singleThread$lambda$1(java.lang.Runnable)java.lang.Thread
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/Thread;
    const-string/jumbo v1, trae-typewriter
    invoke-direct v0, v2, v1, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable; Ljava/lang/String;)V
    const/4 v2, 1
    invoke-virtual v0, v2, Ljava/lang/Thread;->setDaemon(Z)V
    return-object v0
.end method

.method private final utf8ByteSize(char)int
    .registers 6
    # ins_size=2
    const/16 v0, 127
    const/4 v1, 1
    if-gt v5, v0, +003h
    goto +19h
    const/16 v0, 2047
    const/4 v2, 2
    if-gt v5, v0, +004h
    move v1, v2
    goto +12h
    const v0, 55296
    const/4 v3, 0
    if-gt v0, v5, +008h
    const v0, 57344
    if-ge v5, v0, +003h
    goto +2h
    move v1, v3
    if-eqz v1, +003h
    goto -11h
    const/4 v1, 3
    return v1
.end method

.method public final cancel()void
    .registers 8
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->cancelled Z
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$cancel$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$cancel$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final feed(java.lang.String)void
    .registers 9
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
