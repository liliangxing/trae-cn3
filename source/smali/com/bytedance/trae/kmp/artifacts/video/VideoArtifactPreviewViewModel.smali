# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "VideoArtifactPreviewViewModel.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$Companion;
.field public static final PREPARATION_ERROR_CODE:I
.field private static final VIDEO_MIME_TYPE:Ljava/lang/String;
.field private final _state:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private closed:Z
.field private latestSeekGeneration:I
.field private lease:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;
.field private pendingSeekAfterPlaybackStarted:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
.field private playRequested:Z
.field private playbackCompleted:Z
.field private player:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
.field private final playerListener:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;
.field private playerWindowReady:Z
.field private prepareJob:Lkotlinx/coroutines/Job;
.field private final prepareOriginal:Lkotlin/jvm/functions/Function1;
.field private final request:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
.field private final state:Lkotlinx/coroutines/flow/StateFlow;


.method public static synthetic $r8$lambda$bjGPNaEdpOp2BpXeqKFdIHEU6Z0(int  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  long  boolean)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->seekPlayer$lambda$1(I Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; J Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$sbvPXOZr_zEQ1Idns9K06L2Wtw0(long  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->seekPlayer$lambda$1$lambda$0(J Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->Companion Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->$stable I
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest  kotlin.jvm.functions.Function1)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, request
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, prepareOriginal
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/lifecycle/ViewModel;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->request Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->prepareOriginal Lkotlin/jvm/functions/Function1;
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Preparing;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Preparing;
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    invoke-direct v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->prepare()V
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;
    invoke-direct v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;)V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playerListener Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;
    return-void 
.end method

.method public static final synthetic access$getLatestSeekGeneration$p(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->latestSeekGeneration I
    return v0
.end method

.method public static final synthetic access$getPrepareOriginal$p(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->prepareOriginal Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public static final synthetic access$get_state$p(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$handleReady(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceResult$Ready  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->handleReady(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$seekAfterPlaybackStartedIfNeeded(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->seekAfterPlaybackStartedIfNeeded()V
    return-void 
.end method

.method public static final synthetic access$setLatestSeekGeneration$p(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->latestSeekGeneration I
    return-void 
.end method

.method public static final synthetic access$setPendingSeekAfterPlaybackStarted$p(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$PendingSeek)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->pendingSeekAfterPlaybackStarted Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    return-void 
.end method

.method public static final synthetic access$setPlaybackCompleted$p(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playbackCompleted Z
    return-void 
.end method

.method public static final synthetic access$updateReady(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->updateReady(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private final handleReady(com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceResult$Ready  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    iget-boolean v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->closed Z
    if-nez v1, +036h
    invoke-virtual/range v18, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;->getLocalUri()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModelKt;->access$isLocalMediaSource(Ljava/lang/String;)Z
    move-result v1
    if-nez v1, +003h
    goto +2ah
    invoke-virtual/range v18, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;->getLease()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->lease Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    invoke-virtual/range v18, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;->getLocalUri()Ljava/lang/String;
    move-result-object v3
    const-wide/16 v4, 0
    const-wide/16 v6, 0
    const-wide/16 v8, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 254
    const/16 v16, 0
    move-object v2, v15
    move-object v0, v15
    move-object/from16 v15, v16
    invoke-direct/range v2 ... v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;-><init>(Ljava/lang/String; J J J Z Z F Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v1, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    invoke-virtual/range v18, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;->getLease()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;->release()V
    move-object/from16 v0, v17
    iget-boolean v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->closed Z
    if-nez v1, +00dh
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;
    const/4 v3, -1
    invoke-direct v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;-><init>(I)V
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final prepare()void
    .registers 9
    # ins_size=1
    iget-boolean v0, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->closed Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->prepareJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    invoke-direct v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->releaseResources()V
    iget-object v0, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Preparing;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Preparing;
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    move-object v0, v8
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;
    invoke-direct v0, v8, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$prepare$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->prepareJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final releasePlayer()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    const/4 v1, 0
    if-eqz v0, +005h
    invoke-interface v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->setListener(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->release()V
    iput-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playerWindowReady Z
    iput-boolean v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playRequested Z
    iput-boolean v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playbackCompleted Z
    iput-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->pendingSeekAfterPlaybackStarted Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    iget v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->latestSeekGeneration I
    add-int/lit8 v0, v0, 1
    iput v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->latestSeekGeneration I
    return-void 
.end method

.method private final releaseResources()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->releasePlayer()V
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->lease Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;->release()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->lease Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;
    return-void 
.end method

.method private final seekAfterPlaybackStartedIfNeeded()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->pendingSeekAfterPlaybackStarted Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    if-nez v0, +003h
    return-void 
    const/4 v1, 0
    iput-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->pendingSeekAfterPlaybackStarted Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->getPositionMs()J
    move-result-wide v1
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;->getGeneration()I
    move-result v0
    invoke-direct v3, v1, v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->seekPlayer(J I)V
    return-void 
.end method

.method private final seekPlayer(long  int)void
    .registers 6
    # ins_size=4
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda1;
    invoke-direct v1, v5, v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda1;-><init>(I Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; J)V
    invoke-interface v0, v3, v4, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->seek(J Lkotlin/jvm/functions/Function1;)I
    return-void 
.end method

.method private static final seekPlayer$lambda$1(int  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  long  boolean)kotlin.Unit
    .registers 5
    # ins_size=5
    if-eqz v4, +00eh
    iget v4, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->latestSeekGeneration I
    if-ne v0, v4, +00ah
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda0;-><init>(J)V
    invoke-direct v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->updateReady(Lkotlin/jvm/functions/Function1;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final seekPlayer$lambda$1$lambda$0(long  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 18
    # ins_size=3
    const-string v0, "it"
    move-object/from16 v1, v17
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    const-wide/16 v3, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 251
    const/4 v14, 0
    move-wide v5, v15
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method private final startPlaybackIfReady()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    if-nez v0, +003h
    return-void 
    iget-boolean v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playerWindowReady Z
    if-eqz v1, +00dh
    iget-boolean v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playRequested Z
    if-eqz v1, +003h
    goto +7h
    const/4 v1, 1
    iput-boolean v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playRequested Z
    invoke-interface v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->play()V
    return-void 
.end method

.method private final updateReady(kotlin.jvm.functions.Function1)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v3, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-interface v1, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final attachPlayer(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, player
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->closed Z
    if-nez v0, +036h
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    instance-of v0, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    if-nez v0, +003h
    goto +2ah
    iget-boolean v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playerWindowReady Z
    invoke-direct v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->releasePlayer()V
    iput-boolean v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playerWindowReady Z
    iput-object v3, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playerListener Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;
    invoke-interface v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->setListener(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string/jumbo v1, null cannot be cast to non-null type com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState.Ready
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getPlaybackSpeed()F
    move-result v0
    invoke-interface v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->setSpeed(F)V
    invoke-direct v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->startPlaybackIfReady()V
    return-void 
    invoke-interface v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->release()V
    return-void 
.end method

.method public final close()void
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->closed Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->closed Z
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->prepareJob Lkotlinx/coroutines/Job;
    if-eqz v1, +006h
    const/4 v2, 0
    invoke-static v1, v2, v0, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    invoke-direct v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->releaseResources()V
    return-void 
.end method

.method public final detachPlayer(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, player
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    if-eq v0, v2, +003h
    return-void 
    invoke-direct v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->releasePlayer()V
    return-void 
.end method

.method public final getRequest()com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->request Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    return-object v0
.end method

.method public final getState()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final onAction(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewAction)void
    .registers 24
    # ins_size=2
    move-object/from16 v0, v22
    move-object/from16 v1, v23
    const-string v2, "action"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$Reload;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$Reload;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +006h
    invoke-direct/range v22, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->prepare()V
    return-void 
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    instance-of v3, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    const/4 v4, 0
    if-eqz v3, +006h
    check-cast v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-object v5, v2
    goto +2h
    move-object v5, v4
    if-nez v5, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$Reload;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$Reload;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +180h
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$TogglePlayback;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$TogglePlayback;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    const/4 v3, 0
    const/16 v19, 1
    if-eqz v2, +048h
    invoke-virtual v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isPlaying()Z
    move-result v1
    if-eqz v1, +00bh
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    if-eqz v1, +16bh
    invoke-interface v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->pause()V
    goto/16 +166h
    iget-boolean v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playbackCompleted Z
    if-eqz v1, +02ch
    iput-boolean v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playbackCompleted Z
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->pendingSeekAfterPlaybackStarted Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    iget v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->latestSeekGeneration I
    add-int/lit8 v1, v1, 1
    iput v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->latestSeekGeneration I
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v6, 0
    const-wide/16 v7, 0
    const-wide/16 v9, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 251
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    if-eqz v1, +005h
    invoke-interface v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->stop()V
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    if-eqz v1, +134h
    invoke-interface v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->play()V
    goto/16 +12fh
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$OpenSpeedMenu;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$OpenSpeedMenu;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +01dh
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v6, 0
    const-wide/16 v7, 0
    const-wide/16 v9, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 1
    const/16 v17, 127
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto/16 +10ch
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +01dh
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v6, 0
    const-wide/16 v7, 0
    const-wide/16 v9, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 127
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto/16 +0e9h
    instance-of v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;
    const-wide/16 v6, 0
    if-eqz v2, +025h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;->getPositionMs()J
    move-result-wide v3
    invoke-static v3, v4, v6, v7, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v11
    const/4 v6, 0
    const-wide/16 v7, 0
    const-wide/16 v9, 0
    const/4 v13, 1
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 231
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v1
    invoke-interface v2, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto/16 +0c0h
    instance-of v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SeekTo;
    if-eqz v2, +085h
    invoke-virtual v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getDurationMs()J
    move-result-wide v8
    cmp-long v2, v8, v6
    if-lez v2, +013h
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SeekTo;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SeekTo;->getPositionMs()J
    move-result-wide v6
    const-wide/16 v8, 0
    invoke-virtual v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getDurationMs()J
    move-result-wide v10
    invoke-static/range v6 ... v11, Lkotlin/ranges/RangesKt;->coerceIn(J J J)J
    move-result-wide v1
    goto +bh
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SeekTo;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SeekTo;->getPositionMs()J
    move-result-wide v1
    invoke-static v1, v2, v6, v7, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v1
    iget-boolean v6, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playbackCompleted Z
    if-eqz v6, +00dh
    invoke-virtual v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getDurationMs()J
    move-result-wide v6
    cmp-long v6, v1, v6
    if-gez v6, +005h
    move/from16 v20, v19
    goto +3h
    move/from16 v20, v3
    iget-object v15, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v6, 0
    const-wide/16 v7, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 235
    const/16 v21, 0
    move-wide v9, v1
    move-object v4, v15
    move/from16 v15, v16
    move/from16 v16, v17
    move/from16 v17, v18
    move-object/from16 v18, v21
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v5
    invoke-interface v4, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    if-eqz v20, +020h
    iput-boolean v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playbackCompleted Z
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    iget v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->latestSeekGeneration I
    add-int/lit8 v4, v4, 1
    iput v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->latestSeekGeneration I
    invoke-direct v3, v1, v2, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;-><init>(J I)V
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->pendingSeekAfterPlaybackStarted Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    if-eqz v1, +005h
    invoke-interface v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->stop()V
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    if-eqz v1, +04ah
    invoke-interface v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->play()V
    goto +45h
    const/4 v3, 0
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->pendingSeekAfterPlaybackStarted Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;
    iget v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->latestSeekGeneration I
    add-int/lit8 v3, v3, 1
    iput v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->latestSeekGeneration I
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->seekPlayer(J I)V
    goto +38h
    instance-of v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;
    if-eqz v2, +02fh
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->player Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;
    if-eqz v2, +00ch
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;
    invoke-virtual v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;->getSpeed()F
    move-result v3
    invoke-interface v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;->setSpeed(F)V
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v6, 0
    const-wide/16 v7, 0
    const-wide/16 v9, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;->getSpeed()F
    move-result v15
    const/16 v16, 0
    const/16 v17, 63
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v1
    invoke-interface v2, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +7h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    return-void 
.end method

.method protected onCleared()void
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->close()V
    return-void 
.end method

.method public final onPlayerCreationFailed()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->releaseResources()V
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->_state Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;
    const/4 v2, -1
    invoke-direct v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;-><init>(I)V
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final onPlayerWindowReady()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->playerWindowReady Z
    invoke-direct v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->startPlaybackIfReady()V
    return-void 
.end method

.method public final saveToMediaLibrary(kotlin.jvm.functions.Function1)void
    .registers 11
    # ins_size=2
    const-string/jumbo v0, onComplete
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    goto +2h
    move-object v0, v2
    if-nez v0, +00eh
    new-instance v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    const/4 v1, 0
    const-string v2, "Video is not ready"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;-><init>(Z Ljava/lang/String;)V
    invoke-interface v10, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    move-object v1, v9
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;
    invoke-direct v1, v10, v0, v9, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$saveToMediaLibrary$1;-><init>(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v6, v1
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
