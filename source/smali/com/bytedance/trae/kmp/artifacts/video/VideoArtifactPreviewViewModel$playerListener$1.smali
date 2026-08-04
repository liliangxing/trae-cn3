# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;
.super Ljava/lang/Object;
.source "VideoArtifactPreviewViewModel.kt"

.implements Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;

.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;


.method public static synthetic $r8$lambda$2m53OQOawQXuY55lIeklIMjtxPQ(long  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->onMetadataLoaded$lambda$0(J Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$DroLhKLii2uELPrAt4tWVkmx-0o(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->onPlaybackResumed$lambda$4(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$GlhozjtmExCYMFunNM6DuZ_zl18(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->onPlaybackStarted$lambda$2(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$mpNe8m1UCWeQcF-zcbKmRbBVIDo(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->onPlaybackPaused$lambda$3(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pdjsL9Qgi_i53fAeL38nMAk7es0(boolean  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->onPlaybackCompleted$lambda$5(Z Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$xR964hkUbJDw4kWQGhnYNAZA7VE(long  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->onPlaybackPositionUpdated$lambda$1(J Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final onMetadataLoaded$lambda$0(long  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 18
    # ins_size=3
    const-string v0, "it"
    move-object/from16 v1, v17
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    const-wide/16 v3, 0
    move-wide v5, v15
    invoke-static v5, v6, v3, v4, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v3
    const-wide/16 v5, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 253
    const/4 v14, 0
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method private static final onPlaybackCompleted$lambda$5(boolean  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 17
    # ins_size=2
    const-string v0, "it"
    move-object/from16 v1, v16
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    const-wide/16 v3, 0
    invoke-virtual/range v16, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getDurationMs()J
    move-result-wide v5
    const-wide/16 v7, 0
    const/4 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 219
    const/4 v14, 0
    move v10, v15
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method private static final onPlaybackPaused$lambda$3(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 16
    # ins_size=1
    const-string v0, "it"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    const-wide/16 v3, 0
    const-wide/16 v5, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 223
    const/4 v14, 0
    move-object v1, v15
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v15
    return-object v15
.end method

.method private static final onPlaybackPositionUpdated$lambda$1(long  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 21
    # ins_size=4
    move-wide/from16 v0, v17
    const-string/jumbo v2, ready
    move-object/from16 v6, v20
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getDurationMs()J
    move-result-wide v2
    cmp-long v2, v0, v2
    if-gez v2, +008h
    const/4 v2, 0
    move-object/from16 v3, v19
    invoke-static v3, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$setPlaybackCompleted$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Z)V
    invoke-virtual/range v20, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isDragging()Z
    move-result v2
    if-eqz v2, +004h
    move-object v0, v6
    goto +29h
    const/4 v7, 0
    const-wide/16 v8, 0
    const-wide/16 v2, 0
    invoke-virtual/range v20, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getDurationMs()J
    move-result-wide v4
    invoke-static v4, v5, v0, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v4
    move-wide/from16 v0, v17
    invoke-static/range v0 ... v5, Lkotlin/ranges/RangesKt;->coerceIn(J J J)J
    move-result-wide v0
    const-wide/16 v10, 0
    const/4 v2, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 251
    const/16 v16, 0
    move-object/from16 v3, v20
    move-object v4, v7
    move-wide v5, v8
    move-wide v7, v0
    move-wide v9, v10
    move v11, v2
    invoke-static/range v3 ... v16, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v0
    return-object v0
.end method

.method private static final onPlaybackResumed$lambda$4(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 16
    # ins_size=1
    const-string v0, "it"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    const-wide/16 v3, 0
    const-wide/16 v5, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/4 v10, 1
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 223
    const/4 v14, 0
    move-object v1, v15
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v15
    return-object v15
.end method

.method private static final onPlaybackStarted$lambda$2(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready
    .registers 16
    # ins_size=1
    const-string v0, "it"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    const-wide/16 v3, 0
    const-wide/16 v5, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/4 v10, 1
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 223
    const/4 v14, 0
    move-object v1, v15
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->copy$default(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Ljava/lang/String; J J J Z Z F Z I Ljava/lang/Object;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v15
    return-object v15
.end method

.method public onError(int)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$get_state$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;
    invoke-direct v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;-><init>(I)V
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public onMetadataLoaded(long)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda5;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda5;-><init>(J)V
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$updateReady(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public onPlaybackCompleted(boolean)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    xor-int/lit8 v1, v3, 1
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$setPlaybackCompleted$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Z)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$setPendingSeekAfterPlaybackStarted$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$getLatestSeekGeneration$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;)I
    move-result v1
    add-int/lit8 v1, v1, 1
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$setLatestSeekGeneration$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; I)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda2;
    invoke-direct v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda2;-><init>(Z)V
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$updateReady(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public onPlaybackPaused()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda3;
    invoke-direct v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda3;-><init>()V
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$updateReady(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public onPlaybackPositionUpdated(long)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda4;
    invoke-direct v1, v3, v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda4;-><init>(J Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;)V
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$updateReady(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public onPlaybackResumed()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda1;
    invoke-direct v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$updateReady(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lkotlin/jvm/functions/Function1;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$seekAfterPlaybackStartedIfNeeded(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;)V
    return-void 
.end method

.method public onPlaybackStarted()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$updateReady(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lkotlin/jvm/functions/Function1;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->access$seekAfterPlaybackStartedIfNeeded(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;)V
    return-void 
.end method
