# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VideoArtifactPreview.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $dragOffsetY$delegate:Landroidx/compose/runtime/MutableFloatState;
.field  label:I


.method public static synthetic $r8$lambda$Ks3NSTpiWu-mlMt3pWxeNHpKzJc(androidx.compose.runtime.MutableFloatState  androidx.compose.animation.core.Animatable)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;->invokeSuspend$lambda$0(Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/animation/core/Animatable;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(androidx.compose.runtime.MutableFloatState  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(androidx.compose.runtime.MutableFloatState  androidx.compose.animation.core.Animatable)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-virtual v1, Landroidx/compose/animation/core/Animatable;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->floatValue()F
    move-result v1
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoArtifactPreviewScreen$lambda$2(Landroidx/compose/runtime/MutableFloatState; F)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;-><init>(Landroidx/compose/runtime/MutableFloatState; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3eh
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    invoke-static v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoArtifactPreviewScreen$lambda$1(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v14
    const/4 v1, 2
    const/4 v3, 0
    const/4 v4, 0
    invoke-static v14, v3, v1, v4, Landroidx/compose/animation/core/AnimatableKt;->Animatable$default(F F I Ljava/lang/Object;)Landroidx/compose/animation/core/Animatable;
    move-result-object v5
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxFloat(F)Ljava/lang/Float;
    move-result-object v6
    const/4 v14, 0
    const/4 v1, 6
    const/16 v3, 250
    invoke-static v3, v14, v4, v1, v4, Landroidx/compose/animation/core/AnimationSpecKt;->tween$default(I I Landroidx/compose/animation/core/Easing; I Ljava/lang/Object;)Landroidx/compose/animation/core/TweenSpec;
    move-result-object v14
    move-object v7, v14
    check-cast v7, Landroidx/compose/animation/core/AnimationSpec;
    const/4 v8, 0
    iget-object v14, v13, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    new-instance v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2$$ExternalSyntheticLambda0;
    invoke-direct v9, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2$$ExternalSyntheticLambda0;-><init>(Landroidx/compose/runtime/MutableFloatState;)V
    move-object v10, v13
    check-cast v10, Lkotlin/coroutines/Continuation;
    const/4 v11, 4
    const/4 v12, 0
    iput v2, v13, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;->label I
    invoke-static/range v5 ... v12, Landroidx/compose/animation/core/Animatable;->animateTo$default(Landroidx/compose/animation/core/Animatable; Ljava/lang/Object; Landroidx/compose/animation/core/AnimationSpec; Ljava/lang/Object; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    if-ne v14, v0, +003h
    return-object v0
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v14
.end method
