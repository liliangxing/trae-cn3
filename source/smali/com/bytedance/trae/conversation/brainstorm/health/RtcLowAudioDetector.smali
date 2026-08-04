# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;
.super Ljava/lang/Object;
.source "RtcLowAudioDetector.kt"

.field public static final ASR_FALLBACK_MS:J
.field public static final AVG_THRESHOLD:D
.field public static final CONFIRM_WINDOW_COUNT:I
.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Companion;
.field public static final HEALTH_WINDOW_MS:J
.field public static final LOW_FRAME_RATIO:F
.field public static final MAX_THRESHOLD:I
.field public static final MIN_ASR_FALLBACK_VAD_FRAMES:I
.field public static final MIN_VAD_FRAMES:I
.field private consecutiveLowWindows:I
.field private final samples:Ljava/util/List;
.field private windowStartMs:J


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->Companion Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->samples Ljava/util/List;
    return-void 
.end method

.method private final clearWindow()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->samples Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    const-wide/16 v0, 0
    iput-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->windowStartMs J
    return-void 
.end method

.method private final evaluateWindow(boolean)com.bytedance.trae.conversation.brainstorm.health.RtcLowAudioDetector$Evaluation
    .registers 18
    # ins_size=2
    move-object/from16 v0, v16
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->samples Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +015h
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->reset()V
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const-wide/16 v6, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    move-object v2, v1
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;-><init>(Z Z I D I I I F)V
    return-object v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->samples Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v3, +017h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v6, v3
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;->getVad()I
    move-result v6
    if-ne v6, v4, +003h
    goto +2h
    move v4, v5
    if-eqz v4, -017h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    check-cast v2, Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v1
    const/4 v3, 6
    if-ge v1, v3, +00eh
    if-eqz v17, +00ah
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v1
    const/4 v3, 4
    if-lt v1, v3, +003h
    goto +3h
    move v1, v5
    goto +2h
    move v1, v4
    if-nez v1, +066h
    iput v5, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->consecutiveLowWindows I
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const-wide/16 v10, 0
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->samples Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-nez v3, +004h
    const/4 v1, 0
    goto +30h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;->getLinearVolume()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    check-cast v3, Ljava/lang/Comparable;
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;->getLinearVolume()I
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    check-cast v4, Ljava/lang/Comparable;
    invoke-interface v3, v4, Ljava/lang/Comparable;->compareTo(Ljava/lang/Object;)I
    move-result v6
    if-gez v6, -01ah
    move-object v3, v4
    goto -1dh
    move-object v1, v3
    check-cast v1, Ljava/lang/Integer;
    if-eqz v1, +006h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v5
    move v12, v5
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v13
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->samples Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v14
    const/4 v15, 0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;
    move-object v6, v1
    invoke-direct/range v6 ... v15, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;-><init>(Z Z I D I I I F)V
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->clearWindow()V
    return-object v1
    move-object v1, v2
    check-cast v1, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v6, 10
    invoke-static v1, v6, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v6
    invoke-direct v3, v6, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +014h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;->getLinearVolume()I
    move-result v7
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-interface v3, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v3, Ljava/util/List;
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->averageOfInt(Ljava/lang/Iterable;)D
    move-result-wide v10
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->samples Ljava/util/List;
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +09ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;->getLinearVolume()I
    move-result v6
    move v12, v6
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +00fh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;->getLinearVolume()I
    move-result v6
    if-ge v12, v6, -010h
    goto -13h
    instance-of v3, v1, Ljava/util/Collection;
    const-wide/high16 v6, 4635048441494372352
    if-eqz v3, +00dh
    move-object v3, v1
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +004h
    move v3, v5
    goto +28h
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    move v3, v5
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +01eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;->getLinearVolume()I
    move-result v8
    int-to-double v8, v8
    cmpg-double v8, v8, v6
    if-gez v8, +004h
    move v8, v4
    goto +2h
    move v8, v5
    if-eqz v8, -018h
    add-int/lit8 v3, v3, 1
    if-gez v3, -01ch
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -21h
    int-to-float v1, v3
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v3
    int-to-float v3, v3
    div-float v15, v1, v3
    cmpg-double v1, v10, v6
    if-gez v1, +00fh
    const/16 v1, 100
    if-ge v12, v1, +00bh
    const v1, 1061997773
    cmpl-float v1, v15, v1
    if-ltz v1, +004h
    move v8, v4
    goto +2h
    move v8, v5
    if-eqz v8, +007h
    iget v1, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->consecutiveLowWindows I
    add-int/2addr v1, v4
    move v9, v1
    goto +2h
    move v9, v5
    iput v9, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->consecutiveLowWindows I
    const/4 v1, 3
    if-lt v9, v1, +004h
    move v7, v4
    goto +2h
    move v7, v5
    if-eqz v7, +004h
    iput v5, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->consecutiveLowWindows I
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v13
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->samples Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v14
    move-object v6, v1
    invoke-direct/range v6 ... v15, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;-><init>(Z Z I D I I I F)V
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->clearWindow()V
    return-object v1
    new-instance v1, Ljava/util/NoSuchElementException;
    invoke-direct v1, Ljava/util/NoSuchElementException;-><init>()V
    throw v1
.end method

.method public final onAudioSample(int  int  long  boolean)com.bytedance.trae.conversation.brainstorm.health.RtcLowAudioDetector$Evaluation
    .registers 10
    # ins_size=6
    iget-wide v0, v4, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->windowStartMs J
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-nez v0, +004h
    iput-wide v7, v4, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->windowStartMs J
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->samples Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;
    invoke-direct v1, v5, v6, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Sample;-><init>(I I)V
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    iget-wide v5, v4, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->windowStartMs J
    sub-long/2addr v7, v5
    const-wide/16 v5, 2000
    cmp-long v5, v7, v5
    if-gez v5, +004h
    const/4 v5, 0
    return-object v5
    invoke-direct v4, v9, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->evaluateWindow(Z)Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector$Evaluation;
    move-result-object v5
    return-object v5
.end method

.method public final reset()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->samples Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    const-wide/16 v0, 0
    iput-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->windowStartMs J
    const/4 v0, 0
    iput v0, v2, Lcom/bytedance/trae/conversation/brainstorm/health/RtcLowAudioDetector;->consecutiveLowWindows I
    return-void 
.end method
