# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;
.super Lcom/bytedance/trae/conversation/widget/blur/BlurView;
.source "BlurCircleWithAmplitude.kt"

.field private final amplitudeCapacity:I
.field private final amplitudeList:Ljava/util/concurrent/CopyOnWriteArrayList;
.field private final animHelper:Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
.field private pendingStartAnim:Z


.method public constructor <init>(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet)void
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    new-instance v2, Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-direct v2, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->amplitudeList Ljava/util/concurrent/CopyOnWriteArrayList;
    const/16 v2, 10
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->amplitudeCapacity I
    new-instance v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/conversation/widget/blur/BlurView;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;-><init>(Lcom/bytedance/trae/conversation/widget/blur/BlurView;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->animHelper Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  android.util.AttributeSet  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method public static final synthetic access$getMaxAmplitude(com.bytedance.trae.conversation.widget.blur.BlurCircleWithAmplitude)float
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->getMaxAmplitude()F
    move-result v0
    return v0
.end method

.method private final getMaxAmplitude()float
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->amplitudeList Ljava/util/concurrent/CopyOnWriteArrayList;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->maxOrNull(Ljava/lang/Iterable;)Ljava/lang/Float;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Float;->floatValue()F
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private final optAmplitude(double)float
    .registers 5
    # ins_size=3
    const-wide/high16 v0, 4602678819172646912
    cmpl-double v0, v3, v0
    if-lez v0, +005h
    const-wide/high16 v3, 4607182418800017408
    goto +bh
    const-wide v0, 4614256656552045848
    mul-double/2addr v3, v0
    invoke-static v3, v4, Ljava/lang/Math;->sin(D)D
    move-result-wide v3
    double-to-float v3, v3
    const/high16 v4, 1075838976
    mul-float/2addr v3, v4
    const/high16 v4, 1065353216
    invoke-static v3, v4, Lkotlin/ranges/RangesKt;->coerceAtMost(F F)F
    move-result v3
    return v3
.end method

.method public final isAnimating()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->animHelper Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->isAnimating()Z
    move-result v0
    if-nez v0, +009h
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->pendingStartAnim Z
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    return v0
.end method

.method protected onDetachedFromWindow()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->onDetachedFromWindow()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->stopWaveAnim()V
    return-void 
.end method

.method protected onSizeChanged(int  int  int  int)void
    .registers 6
    # ins_size=5
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->isAnimating()Z
    move-result v0
    if-eqz v0, +005h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->stopWaveAnim()V
    invoke-super v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->onSizeChanged(I I I I)V
    if-nez v0, +006h
    iget-boolean v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->pendingStartAnim Z
    if-eqz v2, +011h
    const/4 v2, 0
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->pendingStartAnim Z
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->animHelper Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
    new-instance v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude$onSizeChanged$1;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude$onSizeChanged$1;-><init>(Ljava/lang/Object;)V
    check-cast v3, Lkotlin/jvm/functions/Function0;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->startAnim(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final startWaveAnim()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->isAnimating()Z
    move-result v0
    if-nez v0, +024h
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->pendingStartAnim Z
    if-eqz v0, +003h
    goto +1eh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->getWidth()I
    move-result v0
    if-eqz v0, +016h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->getHeight()I
    move-result v0
    if-nez v0, +003h
    goto +eh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->animHelper Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude$startWaveAnim$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude$startWaveAnim$1;-><init>(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/jvm/functions/Function0;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->startAnim(Lkotlin/jvm/functions/Function0;)V
    return-void 
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->pendingStartAnim Z
    return-void 
.end method

.method public final stopWaveAnim()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->pendingStartAnim Z
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->animHelper Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->stopAnim()V
    return-void 
.end method

.method public final updateVolumeData(float)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->isAnimating()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    float-to-double v0, v3
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->optAmplitude(D)F
    move-result v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->amplitudeList Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArrayList;->size()I
    move-result v0
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->amplitudeCapacity I
    if-lt v0, v1, +008h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->amplitudeList Ljava/util/concurrent/CopyOnWriteArrayList;
    const/4 v1, 0
    invoke-virtual v0, v1, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(I)Ljava/lang/Object;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;->amplitudeList Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-static v3, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z
    return-void 
.end method
