# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;
.super Ljava/lang/Object;
.source "VideoArtifactPreview.kt"

.field private static final PlaybackPositionUpdateIntervalMs:I
.field private static final PlaybackSpeeds:Ljava/util/List;
.field private static final PreviewBackgroundColor:J
.field private static final PreviewDismissDistance:F
.field private static final PreviewDismissResetDurationMs:I
.field private static final PreviewDismissScaleDistance:F
.field private static final PreviewDismissScaleReduction:F
.field private static final PreviewDismissVelocityThreshold:F
.field private static final PreviewReloadBackgroundColor:J
.field private static final PreviewStateTextColor:J


.method public static synthetic $r8$lambda$-X1HpUr1LFIvCLfPzhQfAYZsclo(com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer  kotlin.jvm.functions.Function0  com.bytedance.vcloud.uniplayer.UniWindowClient)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$63$lambda$44$lambda$43(Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer; Lkotlin/jvm/functions/Function0; Lcom/bytedance/vcloud/uniplayer/UniWindowClient;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$24BWWUPUT3T1gVE66C6Tv0XuYp8(kotlin.jvm.functions.Function0  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->ArtifactPreviewErrorState$lambda$39(Lkotlin/jvm/functions/Function0; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$2CECS89c2RGjLLUfjZ7zsWVSpfc(boolean  long  long  float  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 16
    # ins_size=16
    invoke-static/range v0 ... v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoPlaybackControls$lambda$84(Z J J F Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$3KNoH5LtYSrQnrD9B9bjPOyjYDQ(long  long  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 11
    # ins_size=11
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoProgressBar$lambda$92(J J Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$7Ou9oBMng7_O40kDCaEMiWLBjCk(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoPlaybackControls$lambda$83$lambda$82$lambda$81$lambda$80$lambda$78$lambda$77(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$EI319J6mlbdVWaoM2I5rLzjYAXU(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$22$lambda$21(Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$GS_na5PYY_wSmlAxu_5JuWOMw9M(kotlin.jvm.functions.Function1  long)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$63$lambda$50$lambda$49(Lkotlin/jvm/functions/Function1; J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Ij1lgILfWKPHJhRybzLVh_YgHuk(androidx.compose.runtime.MutableState  androidx.compose.ui.geometry.Offset)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$63$lambda$54$lambda$53(Landroidx/compose/runtime/MutableState; Landroidx/compose/ui/geometry/Offset;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$LLlOj3DHgWJNGLiK9hcFFlNHkMw(java.util.Map  float  kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$63$lambda$60$lambda$59$lambda$58(Ljava/util/Map; F Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$N64agJmVKZ4_VYGCNSpFX9HI0Xc(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 12
    # ins_size=12
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$27(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$R8wGlbFNDKBH9pN6ACLTDxvwV_o(kotlin.jvm.functions.Function1  float)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$63$lambda$60$lambda$59$lambda$58$lambda$57(Lkotlin/jvm/functions/Function1; F)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$TlGweskd5UZIQzXzkst52_lNqLk(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$24$lambda$23(Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$WnTXWyV1acZ66S4TEbKKth54dTk(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready  com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 9
    # ins_size=9
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$64(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$bSDo47ieVaN4hWSBaLXjIQWMWJ0(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->ArtifactPreviewErrorState$lambda$38$lambda$36$lambda$35(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$dsUNj27sejuqMo7lgClGpaPubK0(kotlin.jvm.functions.Function1  com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer  kotlin.jvm.functions.Function1  androidx.compose.runtime.DisposableEffectScope)androidx.compose.runtime.DisposableEffectResult
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$19$lambda$18(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/DisposableEffectScope;)Landroidx/compose/runtime/DisposableEffectResult;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$fVzGa4CjdvsbzRNc4n7qZB2taCU(androidx.compose.ui.unit.Density  kotlin.jvm.functions.Function1  com.bytedance.trae.design.compose.TraeDimens  androidx.compose.ui.layout.LayoutCoordinates)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoPlaybackControls$lambda$83$lambda$82$lambda$81$lambda$80$lambda$75$lambda$74(Landroidx/compose/ui/unit/Density; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/design/compose/TraeDimens; Landroidx/compose/ui/layout/LayoutCoordinates;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jh_5tKPAvamZIDeipWUWM1WqUZg(com.bytedance.trae.design.compose.TraeDimens  float  long  long  androidx.compose.ui.graphics.drawscope.DrawScope)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoProgressBar$lambda$91$lambda$90(Lcom/bytedance/trae/design/compose/TraeDimens; F J J Landroidx/compose/ui/graphics/drawscope/DrawScope;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kTg6miDgx5QNiT8iITBwRPZ8lvc(androidx.compose.runtime.MutableFloatState  androidx.compose.ui.unit.Density)androidx.compose.ui.unit.IntOffset
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$26$lambda$12$lambda$11(Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/unit/IntOffset;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$l7NTDr3oQmk7mbADSTBCzt6Wo4k(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$lVuzdL3xERmmrJwNCunH7BCJrAI(kotlin.jvm.functions.Function1  long)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$63$lambda$48$lambda$47(Lkotlin/jvm/functions/Function1; J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$oYX4jY0sZhS-pHzLk6nizuhZm_I(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$63$lambda$52$lambda$51(Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pKc-tJu76vqHO_Eo81gT_DexmOY(int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->ArtifactPreviewLoadingState$lambda$32(I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$sWT67o-gKYSyF478vg8ZCPjM-DY(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$63$lambda$46$lambda$45(Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$sy3Fn-W4ghpSUIRBSbfnIoQ_2F4(float  androidx.compose.ui.graphics.GraphicsLayerScope)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$26$lambda$14$lambda$13(F Landroidx/compose/ui/graphics/GraphicsLayerScope;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$z9Eme5wMCiqY3L9IYkYLL_t1ITk(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$63$lambda$62$lambda$61(Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    const/4 v0, 4
    new-array v0, v0, [Ljava/lang/Float;
    const/high16 v1, 1056964608
    invoke-static v1, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    const/high16 v1, 1065353216
    invoke-static v1, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v1
    const/4 v2, 1
    aput-object v1, v0, v2
    const/high16 v1, 1069547520
    invoke-static v1, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v1
    const/4 v2, 2
    aput-object v1, v0, v2
    const/high16 v1, 1073741824
    invoke-static v1, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v1
    const/4 v2, 3
    aput-object v1, v0, v2
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PlaybackSpeeds Ljava/util/List;
    const-wide v0, 4278848010
    invoke-static v0, v1, Landroidx/compose/ui/graphics/ColorKt;->Color(J)J
    move-result-wide v0
    sput-wide v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewBackgroundColor J
    const-wide v0, 4285756275
    invoke-static v0, v1, Landroidx/compose/ui/graphics/ColorKt;->Color(J)J
    move-result-wide v0
    sput-wide v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewStateTextColor J
    const v0, 862546281
    invoke-static v0, Landroidx/compose/ui/graphics/ColorKt;->Color(I)J
    move-result-wide v0
    sput-wide v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewReloadBackgroundColor J
    const/16 v0, 120
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    sput v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewDismissDistance F
    const/16 v0, 300
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    sput v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewDismissScaleDistance F
    const/16 v0, 800
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    sput v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewDismissVelocityThreshold F
    return-void 
.end method

.method private static final ArtifactPreviewErrorState(kotlin.jvm.functions.Function0  androidx.compose.runtime.Composer  int)void
    .registers 36
    # ins_size=3
    move-object/from16 v0, v33
    move/from16 v1, v35
    const v2, -1864549436
    move-object/from16 v3, v34
    invoke-interface v3, v2, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v15
    and-int/lit8 v3, v1, 6
    const/4 v4, 2
    if-nez v3, +00eh
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 4
    goto +2h
    move v3, v4
    or-int/2addr v3, v1
    move v13, v3
    goto +2h
    move v13, v1
    and-int/lit8 v3, v13, 3
    if-ne v3, v4, +00fh
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v3
    if-nez v3, +003h
    goto +7h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object v2, v15
    goto/16 +344h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v3
    if-eqz v3, +008h
    const/4 v3, -1
    const-string v5, "com.bytedance.trae.kmp.artifacts.video.ArtifactPreviewErrorState (VideoArtifactPreview.kt:408)"
    invoke-static v2, v13, v3, v5, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v3, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v2, v15, v3, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v2
    const v3, -15563135
    invoke-interface v15, v3, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v3
    sget-object v5, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v5, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v5
    const/4 v12, 1
    const/4 v6, 0
    if-ne v3, v5, +00ah
    new-instance v3, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-direct v3, v6, v12, v6, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v15, v3, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v11, v3
    check-cast v11, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeDimens;->getContextMenuShadowPaddingTop-D9Ej5fM()F
    move-result v5
    neg-float v5, v5
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    const/4 v7, 0
    invoke-static v3, v7, v5, v12, v6, Landroidx/compose/foundation/layout/OffsetKt;->offset-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeDimens;->getArtifactPreviewStateHorizontalPadding-D9Ej5fM()F
    move-result v5
    invoke-static v3, v5, v7, v4, v6, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    sget-object v4, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v4, Landroidx/compose/ui/Alignment$Companion;->getCenterHorizontally()Landroidx/compose/ui/Alignment$Horizontal;
    move-result-object v4
    const v5, 1341605231
    const-string v6, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo"
    invoke-static v15, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v5, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v5, Landroidx/compose/foundation/layout/Arrangement;->getTop()Landroidx/compose/foundation/layout/Arrangement$Vertical;
    move-result-object v5
    const/16 v6, 48
    invoke-static v5, v4, v15, v6, Landroidx/compose/foundation/layout/ColumnKt;->columnMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Vertical; Landroidx/compose/ui/Alignment$Horizontal; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v4
    const v10, -1159599143
    const-string v9, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v15, v10, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v8, 0
    invoke-static v15, v8, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->hashCode(J)I
    move-result v5
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v6
    invoke-static v15, v3, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v7
    const v14, -553112988
    move/from16 v16, v13
    const-string v13, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v15, v14, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v10
    instance-of v10, v10, Landroidx/compose/runtime/Applier;
    if-nez v10, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v10
    if-eqz v10, +006h
    invoke-interface v15, v7, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v7
    sget-object v10, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v10, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v10
    invoke-static v7, v4, v10, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v4, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v4, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v4
    invoke-static v7, v6, v4, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v4, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v4, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v4
    invoke-interface v7, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v6
    if-nez v6, +010h
    invoke-interface v7, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-static v6, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +010h
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v7, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-interface v7, v5, v4, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v4, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v4, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v4
    invoke-static v7, v3, v4, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v3, 2093002350
    const-string v4, "C89@4557L9:Column.kt#2w3rfo"
    invoke-static v15, v3, v4, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v3, Landroidx/compose/foundation/layout/ColumnScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/ColumnScopeInstance;
    check-cast v3, Landroidx/compose/foundation/layout/ColumnScope;
    sget-object v3, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;
    invoke-static v3, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Drawable0_commonMainKt;->getTrae_video_preview_error(Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v3
    invoke-static v3, v15, v8, Lorg/jetbrains/compose/resources/ImageResources_androidKt;->painterResource(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/graphics/painter/Painter;
    move-result-object v3
    const/4 v4, 0
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeDimens;->getArtifactPreviewErrorIconSize-D9Ej5fM()F
    move-result v6
    invoke-static v5, v6, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v10, 0
    const/16 v18, 0
    const/16 v19, 48
    const/16 v20, 120
    move v14, v8
    move v8, v10
    move-object v10, v9
    move-object/from16 v9, v18
    move-object/from16 v28, v10
    move-object v10, v15
    move-object/from16 v29, v11
    move/from16 v11, v19
    move/from16 v30, v12
    move/from16 v12, v20
    invoke-static/range v3 ... v12, Landroidx/compose/foundation/ImageKt;->Image(Landroidx/compose/ui/graphics/painter/Painter; Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Landroidx/compose/ui/layout/ContentScale; F Landroidx/compose/ui/graphics/ColorFilter; Landroidx/compose/runtime/Composer; I I)V
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeDimens;->getArtifactPreviewStateGap-D9Ej5fM()F
    move-result v4
    invoke-static v3, v4, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v3
    invoke-static v3, v15, v14, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v3, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;
    invoke-static v3, Lcom/bytedance/trae/kmp/artifacts/generated/resources/String0_commonMainKt;->getTrae_video_artifact_preview_error(Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v3
    new-array v4, v14, [Ljava/lang/Object;
    invoke-static v3, v4, v15, v14, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v3
    sget-wide v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewStateTextColor J
    sget-object v4, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v7, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v4, v15, v7, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodyBase()Landroidx/compose/ui/text/TextStyle;
    move-result-object v23
    sget-object v4, Landroidx/compose/ui/text/style/TextAlign;->Companion Landroidx/compose/ui/text/style/TextAlign$Companion;
    invoke-virtual v4, Landroidx/compose/ui/text/style/TextAlign$Companion;->getCenter-e0LSkKk()I
    move-result v17
    const/4 v4, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const-wide/16 v18, 0
    move-object/from16 v32, v13
    move/from16 v31, v16
    move-wide/from16 v12, v18
    const/16 v16, 0
    move-object/from16 v14, v16
    invoke-static/range v17, Landroidx/compose/ui/text/style/TextAlign;->box-impl(I)Landroidx/compose/ui/text/style/TextAlign;
    move-result-object v16
    move-object/from16 v34, v15
    move-object/from16 v15, v16
    const-wide/16 v16, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v25, 384
    const/16 v26, 0
    const v27, 65018
    move-object/from16 v24, v34
    invoke-static/range v3 ... v27, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeDimens;->getArtifactPreviewStateGap-D9Ej5fM()F
    move-result v4
    invoke-static v3, v4, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v3
    move-object/from16 v15, v34
    const/4 v4, 0
    invoke-static v3, v15, v4, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeDimens;->getArtifactPreviewReloadButtonRadius-D9Ej5fM()F
    move-result v5
    invoke-static v5, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v5
    check-cast v5, Landroidx/compose/ui/graphics/Shape;
    invoke-static v3, v5, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v6
    sget-wide v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewReloadBackgroundColor J
    const/4 v10, 2
    invoke-static/range v6 ... v11, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v16
    const v3, 1553033385
    invoke-interface v15, v3, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v3
    sget-object v5, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v5, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v5
    if-ne v3, v5, +009h
    invoke-static Landroidx/compose/foundation/interaction/InteractionSourceKt;->MutableInteractionSource()Landroidx/compose/foundation/interaction/MutableInteractionSource;
    move-result-object v3
    invoke-interface v15, v3, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v17, v3
    check-cast v17, Landroidx/compose/foundation/interaction/MutableInteractionSource;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const v3, 1553036560
    invoke-interface v15, v3, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    move-object/from16 v3, v29
    invoke-interface v15, v3, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v5
    and-int/lit8 v6, v31, 14
    const/4 v7, 4
    if-ne v6, v7, +005h
    move/from16 v12, v30
    goto +2h
    move v12, v4
    or-int/2addr v5, v12
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    if-nez v5, +00ah
    sget-object v5, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v5, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v5
    if-ne v6, v5, +00ah
    new-instance v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda14;
    invoke-direct v6, v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)V
    invoke-interface v15, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v22, v6
    check-cast v22, Lkotlin/jvm/functions/Function0;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v23, 28
    const/16 v24, 0
    invoke-static/range v16 ... v24, Landroidx/compose/foundation/ClickableKt;->clickable-O2vRcR0$default(Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/interaction/MutableInteractionSource; Landroidx/compose/foundation/Indication; Z Ljava/lang/String; Landroidx/compose/ui/semantics/Role; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeDimens;->getArtifactPreviewReloadButtonPaddingHorizontal-D9Ej5fM()F
    move-result v5
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeDimens;->getArtifactPreviewReloadButtonPaddingVertical-D9Ej5fM()F
    move-result v2
    invoke-static v3, v5, v2, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4(Landroidx/compose/ui/Modifier; F F)Landroidx/compose/ui/Modifier;
    move-result-object v2
    sget-object v3, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v3, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;
    move-result-object v3
    const v5, 1042775818
    const-string v6, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v15, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v3, v4, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v3
    move-object/from16 v5, v28
    const v6, -1159599143
    invoke-static v15, v6, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v15, v4, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->hashCode(J)I
    move-result v5
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v6
    invoke-static v15, v2, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v2
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v7
    move-object/from16 v8, v32
    const v9, -553112988
    invoke-static v15, v9, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v8
    instance-of v8, v8, Landroidx/compose/runtime/Applier;
    if-nez v8, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-eqz v8, +006h
    invoke-interface v15, v7, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v7
    sget-object v8, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v8, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v8
    invoke-static v7, v3, v8, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-static v7, v6, v3, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-interface v7, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v6
    if-nez v6, +010h
    invoke-interface v7, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-static v6, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +010h
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v7, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-interface v7, v5, v3, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-static v7, v2, v3, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v2, 1833054614
    const-string v3, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v15, v2, v3, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v2, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v2, Landroidx/compose/foundation/layout/BoxScope;
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;
    invoke-static v2, Lcom/bytedance/trae/kmp/artifacts/generated/resources/String0_commonMainKt;->getTrae_video_artifact_preview_reload(Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v2
    new-array v3, v4, [Ljava/lang/Object;
    invoke-static v2, v3, v15, v4, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    sget-object v2, Landroidx/compose/ui/graphics/Color;->Companion Landroidx/compose/ui/graphics/Color$Companion;
    invoke-virtual v2, Landroidx/compose/ui/graphics/Color$Companion;->getWhite-0d7_KjU()J
    move-result-wide v5
    const-wide/16 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const-wide/16 v12, 0
    const/4 v14, 0
    const/4 v2, 0
    move-object v4, v15
    move-object v15, v2
    const-wide/16 v16, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    sget-object v2, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v7, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v2, v4, v7, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodyBaseMd()Landroidx/compose/ui/text/TextStyle;
    move-result-object v23
    const/16 v25, 384
    const/16 v26, 0
    const v27, 65530
    move-object/from16 v24, v4
    move-object v2, v4
    const/4 v4, 0
    const-wide/16 v7, 0
    invoke-static/range v3 ... v27, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v3
    if-eqz v3, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v2
    if-eqz v2, +00ah
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda15;
    invoke-direct v3, v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda15;-><init>(Lkotlin/jvm/functions/Function0; I)V
    invoke-interface v2, v3, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final ArtifactPreviewErrorState$lambda$38$lambda$36$lambda$35(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->tryHandle(Lkotlin/jvm/functions/Function0;)Z
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final ArtifactPreviewErrorState$lambda$39(kotlin.jvm.functions.Function0  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    or-int/lit8 v1, v1, 1
    invoke-static v1, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v1
    invoke-static v0, v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->ArtifactPreviewErrorState(Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final ArtifactPreviewLoadingState(androidx.compose.runtime.Composer  int)void
    .registers 29
    # ins_size=2
    move/from16 v0, v28
    const v1, -1200563270
    move-object/from16 v2, v27
    invoke-interface v2, v1, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v15
    if-nez v0, +00fh
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v2
    if-nez v2, +003h
    goto +7h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object v1, v15
    goto/16 +238h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v2
    if-eqz v2, +008h
    const/4 v2, -1
    const-string v3, "com.bytedance.trae.kmp.artifacts.video.ArtifactPreviewLoadingState (VideoArtifactPreview.kt:374)"
    invoke-static v1, v0, v2, v3, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v2, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v15, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v1
    sget-object v2, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v2, Landroidx/compose/ui/Modifier;
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoArtifactCardDurationHeight-D9Ej5fM()F
    move-result v3
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getContextMenuDividerHeight-D9Ej5fM()F
    move-result v4
    sub-float/2addr v3, v4
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v3
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getContextMenuDividerHeight-D9Ej5fM()F
    move-result v4
    sub-float/2addr v3, v4
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v3
    neg-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v3
    const/4 v4, 1
    const/4 v5, 0
    const/4 v6, 0
    invoke-static v2, v5, v3, v4, v6, Landroidx/compose/foundation/layout/OffsetKt;->offset-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getArtifactPreviewStateHorizontalPadding-D9Ej5fM()F
    move-result v3
    const/4 v4, 2
    invoke-static v2, v3, v5, v4, v6, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v2
    sget-object v3, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v3, Landroidx/compose/ui/Alignment$Companion;->getCenterHorizontally()Landroidx/compose/ui/Alignment$Horizontal;
    move-result-object v3
    const v4, 1341605231
    const-string v5, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo"
    invoke-static v15, v4, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v4, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v4, Landroidx/compose/foundation/layout/Arrangement;->getTop()Landroidx/compose/foundation/layout/Arrangement$Vertical;
    move-result-object v4
    const/16 v5, 48
    invoke-static v4, v3, v15, v5, Landroidx/compose/foundation/layout/ColumnKt;->columnMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Vertical; Landroidx/compose/ui/Alignment$Horizontal; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v3
    const v4, -1159599143
    const-string v5, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v15, v4, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v8, 0
    invoke-static v15, v8, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v6
    invoke-static v6, v7, Ljava/lang/Long;->hashCode(J)I
    move-result v6
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v7
    invoke-static v15, v2, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v2
    sget-object v9, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v9, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v9
    const v10, -553112988
    const-string v11, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v15, v10, v11, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v12
    instance-of v12, v12, Landroidx/compose/runtime/Applier;
    if-nez v12, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v12
    if-eqz v12, +006h
    invoke-interface v15, v9, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v9
    sget-object v12, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v12, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v12
    invoke-static v9, v3, v12, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-static v9, v7, v3, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v7
    if-nez v7, +010h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-static v7, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +010h
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-interface v9, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v9, v6, v3, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-static v9, v2, v3, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v2, 2093002350
    const-string v3, "C89@4557L9:Column.kt#2w3rfo"
    invoke-static v15, v2, v3, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v2, Landroidx/compose/foundation/layout/ColumnScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/ColumnScopeInstance;
    check-cast v2, Landroidx/compose/foundation/layout/ColumnScope;
    sget-object v2, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v2, Landroidx/compose/ui/Modifier;
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getArtifactPreviewLoadingIndicatorSize-D9Ej5fM()F
    move-result v3
    invoke-static v2, v3, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v2
    sget-object v3, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v3, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;
    move-result-object v3
    const v6, 1042775818
    const-string v7, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v15, v6, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v3, v8, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v3
    invoke-static v15, v4, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v15, v8, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v4
    invoke-static v4, v5, Ljava/lang/Long;->hashCode(J)I
    move-result v4
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v5
    invoke-static v15, v2, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v2
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v6
    invoke-static v15, v10, v11, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v7
    instance-of v7, v7, Landroidx/compose/runtime/Applier;
    if-nez v7, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v7
    if-eqz v7, +006h
    invoke-interface v15, v6, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v6
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v6, v3, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-static v6, v5, v3, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-interface v6, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v5
    if-nez v5, +010h
    invoke-interface v6, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v5
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +010h
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-interface v6, v5, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v6, v4, v3, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v3, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v3, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v3
    invoke-static v6, v2, v3, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v2, 1833054614
    const-string v3, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v15, v2, v3, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v2, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v2, Landroidx/compose/foundation/layout/BoxScope;
    sget-object v2, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v2, Landroidx/compose/ui/Modifier;
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getTitleBarIconSize-D9Ej5fM()F
    move-result v3
    invoke-static v2, v3, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v4, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v3, v15, v4, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/design/compose/TraeColors;->getSpecialWhite-0d7_KjU()J
    move-result-wide v3
    const/4 v6, 0
    const/4 v7, 0
    move-object v5, v15
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt;->TraeActivityIndicator-iJQMabo(Landroidx/compose/ui/Modifier; J Landroidx/compose/runtime/Composer; I I)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    sget-object v2, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v2, Landroidx/compose/ui/Modifier;
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getArtifactPreviewStateGap-D9Ej5fM()F
    move-result v1
    invoke-static v2, v1, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v1
    invoke-static v1, v15, v8, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v1, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/generated/resources/String0_commonMainKt;->getTrae_video_artifact_preview_loading(Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    new-array v2, v8, [Ljava/lang/Object;
    invoke-static v1, v2, v15, v8, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v2
    sget-wide v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewStateTextColor J
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v3, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v15, v3, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodyBase()Landroidx/compose/ui/text/TextStyle;
    move-result-object v22
    sget-object v1, Landroidx/compose/ui/text/style/TextAlign;->Companion Landroidx/compose/ui/text/style/TextAlign$Companion;
    invoke-virtual v1, Landroidx/compose/ui/text/style/TextAlign$Companion;->getCenter-e0LSkKk()I
    move-result v1
    const/4 v3, 0
    const-wide/16 v6, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const-wide/16 v11, 0
    const/4 v13, 0
    invoke-static v1, Landroidx/compose/ui/text/style/TextAlign;->box-impl(I)Landroidx/compose/ui/text/style/TextAlign;
    move-result-object v14
    const-wide/16 v16, 0
    move-object v1, v15
    move-wide/from16 v15, v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v24, 384
    const/16 v25, 0
    const v26, 65018
    move-object/from16 v23, v1
    invoke-static/range v2 ... v26, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v2
    if-eqz v2, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v1
    if-eqz v1, +00ah
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda16;
    invoke-direct v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda16;-><init>(I)V
    invoke-interface v1, v2, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final ArtifactPreviewLoadingState$lambda$32(int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 3
    # ins_size=3
    or-int/lit8 v0, v0, 1
    invoke-static v0, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v0
    invoke-static v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->ArtifactPreviewLoadingState(Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static final VideoArtifactPreviewContent(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready  com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  androidx.compose.runtime.Composer  int  int)void
    .registers 47
    # ins_size=8
    move-object/from16 v1, v39
    move-object/from16 v2, v40
    move-object/from16 v3, v41
    move-object/from16 v4, v42
    move/from16 v6, v45
    const-string/jumbo v0, state
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, player
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onPlayerWindowReady
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onAction
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, -638522054
    move-object/from16 v5, v44
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v5
    and-int/lit8 v7, v46, 1
    const/4 v8, 2
    if-eqz v7, +005h
    or-int/lit8 v7, v6, 6
    goto +11h
    and-int/lit8 v7, v6, 6
    if-nez v7, +00dh
    invoke-interface v5, v1, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +004h
    const/4 v7, 4
    goto +2h
    move v7, v8
    or-int/2addr v7, v6
    goto +2h
    move v7, v6
    and-int/lit8 v9, v46, 2
    const/16 v22, 32
    if-eqz v9, +005h
    or-int/lit8 v7, v7, 48
    goto +11h
    and-int/lit8 v9, v6, 48
    if-nez v9, +00eh
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +005h
    move/from16 v9, v22
    goto +3h
    const/16 v9, 16
    or-int/2addr v7, v9
    and-int/lit8 v9, v46, 4
    if-eqz v9, +005h
    or-int/lit16 v7, v7, 384
    goto +11h
    and-int/lit16 v9, v6, 384
    if-nez v9, +00eh
    invoke-interface v5, v3, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +005h
    const/16 v9, 256
    goto +3h
    const/16 v9, 128
    or-int/2addr v7, v9
    and-int/lit8 v9, v46, 8
    if-eqz v9, +005h
    or-int/lit16 v7, v7, 3072
    goto +11h
    and-int/lit16 v9, v6, 3072
    if-nez v9, +00eh
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +005h
    const/16 v9, 2048
    goto +3h
    const/16 v9, 1024
    or-int/2addr v7, v9
    and-int/lit8 v9, v46, 16
    if-eqz v9, +005h
    or-int/lit16 v7, v7, 24576
    goto +14h
    and-int/lit16 v11, v6, 24576
    if-nez v11, +011h
    move-object/from16 v11, v43
    invoke-interface v5, v11, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +005h
    const/16 v12, 16384
    goto +3h
    const/16 v12, 8192
    or-int/2addr v7, v12
    goto +3h
    move-object/from16 v11, v43
    move v13, v7
    and-int/lit16 v7, v13, 9363
    const/16 v12, 9362
    if-ne v7, v12, +010h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v7
    if-nez v7, +003h
    goto +8h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object/from16 v38, v11
    goto/16 +49bh
    if-eqz v9, +008h
    sget-object v7, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v7, Landroidx/compose/ui/Modifier;
    move-object v12, v7
    goto +2h
    move-object v12, v11
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v7
    if-eqz v7, +008h
    const/4 v7, -1
    const-string v9, "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewContent (VideoArtifactPreview.kt:462)"
    invoke-static v0, v13, v7, v9, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const v0, 77860170
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v7, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v7, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v7
    const/4 v11, 0
    if-ne v0, v7, +013h
    sget-object v0, Landroidx/compose/ui/geometry/Offset;->Companion Landroidx/compose/ui/geometry/Offset$Companion;
    invoke-virtual v0, Landroidx/compose/ui/geometry/Offset$Companion;->getZero-F1C5BW0()J
    move-result-wide v16
    invoke-static/range v16 ... v17, Landroidx/compose/ui/geometry/Offset;->box-impl(J)Landroidx/compose/ui/geometry/Offset;
    move-result-object v0
    invoke-static v0, v11, v8, v11, Landroidx/compose/runtime/SnapshotStateKt;->mutableStateOf$default(Ljava/lang/Object; Landroidx/compose/runtime/SnapshotMutationPolicy; I Ljava/lang/Object;)Landroidx/compose/runtime/MutableState;
    move-result-object v0
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v0, Landroidx/compose/runtime/MutableState;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/4 v9, 0
    const/4 v8, 1
    invoke-static v12, v9, v8, v11, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v16
    sget-object v7, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v15, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v7, v5, v15, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/design/compose/TraeColors;->getSpecialBlack-0d7_KjU()J
    move-result-wide v17
    const/16 v19, 0
    const/16 v20, 2
    const/16 v21, 0
    invoke-static/range v16 ... v21, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v7
    const v15, 1042775818
    const-string v14, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v5, v15, v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v14, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v14, Landroidx/compose/ui/Alignment$Companion;->getTopStart()Landroidx/compose/ui/Alignment;
    move-result-object v14
    const/4 v15, 0
    invoke-static v14, v15, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v14
    const v10, -1159599143
    const-string v8, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v5, v10, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v5, v15, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v18
    invoke-static/range v18 ... v19, Ljava/lang/Long;->hashCode(J)I
    move-result v8
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v10
    invoke-static v5, v7, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v7
    sget-object v18, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual/range v18, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v15
    const v9, -553112988
    const-string v11, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v5, v9, v11, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v9
    instance-of v9, v9, Landroidx/compose/runtime/Applier;
    if-nez v9, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-eqz v9, +006h
    invoke-interface v5, v15, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v5, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v9
    sget-object v11, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v11, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v11
    invoke-static v9, v14, v11, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v11, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v11, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v11
    invoke-static v9, v10, v11, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v10, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v10, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v10
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v11
    if-nez v11, +010h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v11
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    invoke-static v11, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +010h
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-interface v9, v11, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v9, v8, v10, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v8, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v8, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v8
    invoke-static v9, v7, v8, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v7, 1833054614
    const-string v8, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v5, v7, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v7, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    move-object v14, v7
    check-cast v14, Landroidx/compose/foundation/layout/BoxScope;
    sget-object v7, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v7, Landroidx/compose/ui/Modifier;
    const/4 v8, 1
    const/4 v9, 0
    const/4 v11, 0
    invoke-static v7, v9, v8, v11, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v7
    const v10, 619478513
    invoke-interface v5, v10, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v10
    and-int/lit16 v15, v13, 896
    const/16 v8, 256
    if-ne v15, v8, +004h
    const/4 v8, 1
    goto +2h
    const/4 v8, 0
    or-int/2addr v8, v10
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v10
    if-nez v8, +00ah
    sget-object v8, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v8, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v8
    if-ne v10, v8, +00ah
    new-instance v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda11;
    invoke-direct v10, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer; Lkotlin/jvm/functions/Function0;)V
    invoke-interface v5, v10, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v8, v10
    check-cast v8, Lkotlin/jvm/functions/Function1;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/4 v10, 0
    sget-object v15, Lcom/bytedance/vcloud/uniplayer/UniScaleType;->ASPECT_FIT Lcom/bytedance/vcloud/uniplayer/UniScaleType;
    const/16 v17, 3078
    const/16 v18, 4
    move v9, v10
    move-object v10, v15
    move-object v15, v11
    move-object v11, v5
    move-object/from16 v38, v12
    move/from16 v12, v17
    move v15, v13
    move/from16 v13, v18
    invoke-static/range v7 ... v13, Lcom/bytedance/vcloud/uniplayer/UniVideoViewKt;->UniVideoView(Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function1; F Lcom/bytedance/vcloud/uniplayer/UniScaleType; Landroidx/compose/runtime/Composer; I I)V
    invoke-virtual/range v39, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isPlaying()Z
    move-result v7
    invoke-virtual/range v39, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->isDragging()Z
    move-result v8
    if-eqz v8, +007h
    invoke-virtual/range v39, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getDragPositionMs()J
    move-result-wide v8
    goto +5h
    invoke-virtual/range v39, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getPositionMs()J
    move-result-wide v8
    invoke-virtual/range v39, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getDurationMs()J
    move-result-wide v10
    invoke-virtual/range v39, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getPlaybackSpeed()F
    move-result v12
    const v13, 619493012
    invoke-interface v5, v13, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    and-int/lit16 v15, v15, 7168
    const/16 v13, 2048
    if-ne v15, v13, +004h
    const/4 v13, 1
    goto +2h
    const/4 v13, 0
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v1
    if-nez v13, +00ah
    sget-object v13, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v13, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v13
    if-ne v1, v13, +00ah
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda17;
    invoke-direct v1, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda17;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-interface v5, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v13, v1
    check-cast v13, Lkotlin/jvm/functions/Function0;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v1, 619496674
    invoke-interface v5, v1, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const/16 v1, 2048
    if-ne v15, v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v2
    if-nez v1, +00ah
    sget-object v1, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v1, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v1
    if-ne v2, v1, +00ah
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda18;
    invoke-direct v2, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda18;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v1, v2
    check-cast v1, Lkotlin/jvm/functions/Function1;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v2, 619500514
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const/16 v2, 2048
    if-ne v15, v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v3
    if-nez v2, +00ah
    sget-object v2, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v2, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v2
    if-ne v3, v2, +00ah
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda19;
    invoke-direct v3, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda19;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-interface v5, v3, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v2, v3
    check-cast v2, Lkotlin/jvm/functions/Function1;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v3, 619504531
    invoke-interface v5, v3, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const/16 v3, 2048
    if-ne v15, v3, +005h
    const/16 v16, 1
    goto +3h
    const/16 v16, 0
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v3
    if-nez v16, +00ah
    sget-object v16, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual/range v16, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v6
    if-ne v3, v6, +00ah
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda20;
    invoke-direct v3, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda20;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-interface v5, v3, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v16, v3
    check-cast v16, Lkotlin/jvm/functions/Function0;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v3, 619508277
    invoke-interface v5, v3, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v3
    sget-object v6, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v6, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v6
    if-ne v3, v6, +00ah
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda21;
    invoke-direct v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda21;-><init>(Landroidx/compose/runtime/MutableState;)V
    invoke-interface v5, v3, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v3, Lkotlin/jvm/functions/Function1;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    sget-object v6, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v6, Landroidx/compose/ui/Modifier;
    sget-object v18, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    move/from16 v21, v15
    invoke-virtual/range v18, Landroidx/compose/ui/Alignment$Companion;->getBottomCenter()Landroidx/compose/ui/Alignment;
    move-result-object v15
    invoke-interface v14, v6, v15, Landroidx/compose/foundation/layout/BoxScope;->align(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment;)Landroidx/compose/ui/Modifier;
    move-result-object v6
    move-object/from16 v43, v0
    const/4 v0, 1
    const/4 v14, 0
    const/4 v15, 0
    invoke-static v6, v14, v0, v15, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v23
    sget-object v6, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v14, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v6, v5, v14, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlHorizontalMargin-D9Ej5fM()F
    move-result v24
    const/16 v25, 0
    sget-object v6, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v14, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v6, v5, v14, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlHorizontalMargin-D9Ej5fM()F
    move-result v26
    sget-object v6, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v14, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v6, v5, v14, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlBottomMargin-D9Ej5fM()F
    move-result v27
    const/16 v28, 2
    const/16 v29, 0
    invoke-static/range v23 ... v29, Landroidx/compose/foundation/layout/PaddingKt;->padding-qDBjuR0$default(Landroidx/compose/ui/Modifier; F F F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v18
    const/high16 v20, 100663296
    const/4 v6, 0
    move-object v14, v1
    move/from16 v1, v21
    const/16 v0, 16
    const/16 v23, 0
    move-object v15, v2
    move-object/from16 v17, v3
    move-object/from16 v19, v5
    move/from16 v21, v6
    invoke-static/range v7 ... v21, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoPlaybackControls(Z J J F Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    const v2, 619524375
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual/range v39, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getShowSpeedMenu()Z
    move-result v2
    if-eqz v2, +1e4h
    const v2, 619524220
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v2
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    const/16 v6, 10
    if-ne v2, v3, +042h
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PlaybackSpeeds Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/LinkedHashMap;
    invoke-static v2, v6, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v7
    invoke-static v7, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v7
    invoke-static v7, v0, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v0
    invoke-direct v3, v0, Ljava/util/LinkedHashMap;-><init>(I)V
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v7, v3
    check-cast v7, Ljava/util/Map;
    move-object v8, v2
    check-cast v8, Ljava/lang/Number;
    invoke-virtual v8, Ljava/lang/Number;->floatValue()F
    new-instance v8, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    const/4 v9, 0
    const/4 v10, 1
    invoke-direct v8, v9, v10, v9, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v7, v2, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1dh
    const/4 v9, 0
    const/4 v10, 1
    move-object v2, v3
    check-cast v2, Ljava/util/Map;
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    goto +3h
    const/4 v9, 0
    const/4 v10, 1
    check-cast v2, Ljava/util/Map;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v0, 619530040
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PlaybackSpeeds Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-static v0, v6, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v6
    invoke-direct v3, v6, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +076h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Number;
    invoke-virtual v6, Ljava/lang/Number;->floatValue()F
    move-result v6
    invoke-static v6, Ljava/lang/String;->valueOf(F)Ljava/lang/String;
    move-result-object v12
    invoke-static v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->formatMenuSpeed(F)Ljava/lang/String;
    move-result-object v13
    invoke-virtual/range v39, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getPlaybackSpeed()F
    move-result v7
    cmpg-float v7, v6, v7
    if-nez v7, +004h
    move v8, v10
    goto +3h
    move/from16 v8, v23
    if-eqz v8, +00bh
    sget-object v7, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;
    invoke-static v7, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Drawable0_commonMainKt;->getTrae_video_preview_checkmark(Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v11
    move-object/from16 v18, v11
    goto +3h
    move-object/from16 v18, v9
    const v7, -1716241161
    invoke-interface v5, v7, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v7
    invoke-interface v5, v6, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v8
    or-int/2addr v7, v8
    const/16 v8, 2048
    if-ne v1, v8, +004h
    move v11, v10
    goto +3h
    move/from16 v11, v23
    or-int/2addr v7, v11
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v11
    if-nez v7, +00ah
    sget-object v7, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v7, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v7
    if-ne v11, v7, +00ah
    new-instance v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda22;
    invoke-direct v11, v2, v6, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda22;-><init>(Ljava/util/Map; F Lkotlin/jvm/functions/Function1;)V
    invoke-interface v5, v11, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v14, v11
    check-cast v14, Lkotlin/jvm/functions/Function0;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v19, 0
    const/16 v20, 184
    const/16 v21, 0
    new-instance v6, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
    move-object v11, v6
    invoke-direct/range v11 ... v21, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; Landroidx/compose/ui/graphics/Color; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v3, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -79h
    const/16 v8, 2048
    move-object v7, v3
    check-cast v7, Ljava/util/List;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Anchored;
    invoke-static/range v43, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$41(Landroidx/compose/runtime/MutableState;)J
    move-result-wide v2
    shr-long v2, v2, v22
    long-to-int v2, v2
    invoke-static v2, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v2
    invoke-static/range v43, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$41(Landroidx/compose/runtime/MutableState;)J
    move-result-wide v11
    const-wide v13, 4294967295
    and-long/2addr v11, v13
    long-to-int v3, v11
    invoke-static v3, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v3
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Anchored;-><init>(F F)V
    check-cast v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;
    const v2, 619556318
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    if-ne v1, v8, +004h
    move v8, v10
    goto +3h
    move/from16 v8, v23
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v1
    if-nez v8, +00ah
    sget-object v2, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v2, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v2
    if-ne v1, v2, +00ah
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda23;
    invoke-direct v1, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda23;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-interface v5, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v9, v1
    check-cast v9, Lkotlin/jvm/functions/Function0;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/4 v10, 0
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v2, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewSpeedMenuWidth-D9Ej5fM()F
    move-result v11
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v2, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewSpeedMenuItemHeight-D9Ej5fM()F
    move-result v12
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v2, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewSpeedMenuRadius-D9Ej5fM()F
    move-result v13
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 1
    const/16 v17, 1
    const/16 v18, 1
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v2, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getContextMenuItemHorizontalPadding-D9Ej5fM()F
    move-result v19
    const/16 v20, 0
    const/16 v21, 0
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v2, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getBodySmLineHeightDp-D9Ej5fM()F
    move-result v22
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v2, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getContextMenuDetailIconTextGap-D9Ej5fM()F
    move-result v23
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v2, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeDimens;->getContextMenuAnchorGap-D9Ej5fM()F
    move-result v24
    const/16 v25, 0
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeColorTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeColorTokens;
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColorTokens;->getLight()Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getBorderBorderNeutralL1-0d7_KjU()J
    move-result-wide v26
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeColorTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeColorTokens;
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColorTokens;->getLight()Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getTextTextDefault-0d7_KjU()J
    move-result-wide v28
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeColorTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeColorTokens;
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColorTokens;->getLight()Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getBgBgBaseDefault-0d7_KjU()J
    move-result-wide v30
    const v32, 1061997773
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 14
    const/16 v37, 0
    invoke-static/range v30 ... v37, Landroidx/compose/ui/graphics/Color;->copy-wmQWz5c$default(J F F F F I Ljava/lang/Object;)J
    move-result-wide v30
    const/16 v32, 0
    const/high16 v34, 805306368
    const/16 v35, 54
    const/16 v36, 0
    const v37, 4481416
    move-object v8, v0
    move-object/from16 v33, v5
    invoke-static/range v7 ... v37, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->TraeContextMenuPopup-_G194Zc(Ljava/util/List; Lcom/bytedance/trae/design/compose/TraeContextMenuPosition; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; F F F F F Z Z Z F F F F F F Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding; J J J Ljava/lang/String; Landroidx/compose/runtime/Composer; I I I I)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v8
    if-eqz v8, +019h
    new-instance v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;
    move-object v0, v9
    move-object/from16 v1, v39
    move-object/from16 v2, v40
    move-object/from16 v3, v41
    move-object/from16 v4, v42
    move-object/from16 v5, v38
    move/from16 v6, v45
    move/from16 v7, v46
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; I I)V
    invoke-interface v8, v9, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final VideoArtifactPreviewContent$lambda$41(androidx.compose.runtime.MutableState)long
    .registers 3
    # ins_size=1
    check-cast v2, Landroidx/compose/runtime/State;
    invoke-interface v2, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Landroidx/compose/ui/geometry/Offset;
    invoke-virtual v2, Landroidx/compose/ui/geometry/Offset;->unbox-impl()J
    move-result-wide v0
    return-wide v0
.end method

.method private static final VideoArtifactPreviewContent$lambda$42(androidx.compose.runtime.MutableState  long)void
    .registers 3
    # ins_size=3
    invoke-static v1, v2, Landroidx/compose/ui/geometry/Offset;->box-impl(J)Landroidx/compose/ui/geometry/Offset;
    move-result-object v1
    invoke-interface v0, v1, Landroidx/compose/runtime/MutableState;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final VideoArtifactPreviewContent$lambda$63$lambda$44$lambda$43(com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer  kotlin.jvm.functions.Function0  com.bytedance.vcloud.uniplayer.UniWindowClient)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string/jumbo v0, window
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->getEngine()Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    move-result-object v1
    invoke-interface v3, v1, Lcom/bytedance/vcloud/uniplayer/UniWindowClient;->bindEngine(Lcom/bytedance/vcloud/uniplayer/UniAVEngine;)V
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final VideoArtifactPreviewContent$lambda$63$lambda$46$lambda$45(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$TogglePlayback;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$TogglePlayback;
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final VideoArtifactPreviewContent$lambda$63$lambda$48$lambda$47(kotlin.jvm.functions.Function1  long)kotlin.Unit
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DragTo;-><init>(J)V
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final VideoArtifactPreviewContent$lambda$63$lambda$50$lambda$49(kotlin.jvm.functions.Function1  long)kotlin.Unit
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SeekTo;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SeekTo;-><init>(J)V
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final VideoArtifactPreviewContent$lambda$63$lambda$52$lambda$51(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$OpenSpeedMenu;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$OpenSpeedMenu;
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final VideoArtifactPreviewContent$lambda$63$lambda$54$lambda$53(androidx.compose.runtime.MutableState  androidx.compose.ui.geometry.Offset)kotlin.Unit
    .registers 4
    # ins_size=2
    invoke-virtual v3, Landroidx/compose/ui/geometry/Offset;->unbox-impl()J
    move-result-wide v0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent$lambda$42(Landroidx/compose/runtime/MutableState; J)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final VideoArtifactPreviewContent$lambda$63$lambda$60$lambda$59$lambda$58(java.util.Map  float  kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 4
    # ins_size=3
    invoke-static v2, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v0
    invoke-static v1, v0, Lkotlin/collections/MapsKt;->getValue(Ljava/util/Map; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1; F)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->tryHandle(Lkotlin/jvm/functions/Function0;)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final VideoArtifactPreviewContent$lambda$63$lambda$60$lambda$59$lambda$58$lambda$57(kotlin.jvm.functions.Function1  float)kotlin.Unit
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$SelectSpeed;-><init>(F)V
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final VideoArtifactPreviewContent$lambda$63$lambda$62$lambda$61(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$DismissSpeedMenu;
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final VideoArtifactPreviewContent$lambda$64(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready  com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 18
    # ins_size=9
    or-int/lit8 v0, v14, 1
    invoke-static v0, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v7
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object/from16 v6, v16
    move v8, v15
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static final VideoArtifactPreviewScreen(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  androidx.compose.runtime.Composer  int  int)void
    .registers 42
    # ins_size=11
    move-object/from16 v2, v31
    move-object/from16 v3, v32
    move-object/from16 v4, v33
    move-object/from16 v13, v34
    move-object/from16 v14, v35
    move-object/from16 v15, v36
    move-object/from16 v1, v37
    move/from16 v12, v40
    move/from16 v11, v41
    const-string/jumbo v0, state
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onAttachPlayer
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onDetachPlayer
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onPlayerWindowReady
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onPlayerCreationFailed
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onAction
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onClose
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, -1210240656
    move-object/from16 v5, v39
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v10
    and-int/lit8 v5, v11, 1
    if-eqz v5, +005h
    or-int/lit8 v5, v12, 6
    goto +1ah
    and-int/lit8 v5, v12, 6
    if-nez v5, +016h
    and-int/lit8 v5, v12, 8
    if-nez v5, +007h
    invoke-interface v10, v2, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v5
    goto +5h
    invoke-interface v10, v2, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +004h
    const/4 v5, 4
    goto +2h
    const/4 v5, 2
    or-int/2addr v5, v12
    goto +2h
    move v5, v12
    and-int/lit8 v7, v11, 2
    if-eqz v7, +005h
    or-int/lit8 v5, v5, 48
    goto +11h
    and-int/lit8 v7, v12, 48
    if-nez v7, +00eh
    invoke-interface v10, v3, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/16 v7, 32
    goto +3h
    const/16 v7, 16
    or-int/2addr v5, v7
    and-int/lit8 v7, v11, 4
    if-eqz v7, +005h
    or-int/lit16 v5, v5, 384
    goto +11h
    and-int/lit16 v7, v12, 384
    if-nez v7, +00eh
    invoke-interface v10, v4, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/16 v7, 256
    goto +3h
    const/16 v7, 128
    or-int/2addr v5, v7
    and-int/lit8 v7, v11, 8
    if-eqz v7, +005h
    or-int/lit16 v5, v5, 3072
    goto +11h
    and-int/lit16 v7, v12, 3072
    if-nez v7, +00eh
    invoke-interface v10, v13, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/16 v7, 2048
    goto +3h
    const/16 v7, 1024
    or-int/2addr v5, v7
    and-int/lit8 v7, v11, 16
    if-eqz v7, +005h
    or-int/lit16 v5, v5, 24576
    goto +11h
    and-int/lit16 v7, v12, 24576
    if-nez v7, +00eh
    invoke-interface v10, v14, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/16 v7, 16384
    goto +3h
    const/16 v7, 8192
    or-int/2addr v5, v7
    and-int/lit8 v7, v11, 32
    const/high16 v16, 196608
    if-eqz v7, +005h
    or-int v5, v5, v16
    goto +11h
    and-int v7, v12, v16
    if-nez v7, +00eh
    invoke-interface v10, v15, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/high16 v7, 131072
    goto +3h
    const/high16 v7, 65536
    or-int/2addr v5, v7
    and-int/lit8 v7, v11, 64
    const/high16 v16, 1572864
    if-eqz v7, +005h
    or-int v5, v5, v16
    goto +11h
    and-int v7, v12, v16
    if-nez v7, +00eh
    invoke-interface v10, v1, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/high16 v7, 1048576
    goto +3h
    const/high16 v7, 524288
    or-int/2addr v5, v7
    and-int/lit16 v7, v11, 128
    const/high16 v16, 12582912
    if-eqz v7, +007h
    or-int v5, v5, v16
    move-object/from16 v9, v38
    goto +14h
    and-int v16, v12, v16
    move-object/from16 v9, v38
    if-nez v16, +00fh
    invoke-interface v10, v9, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v17
    if-eqz v17, +005h
    const/high16 v17, 8388608
    goto +3h
    const/high16 v17, 4194304
    or-int v5, v5, v17
    const v17, 4793491
    and-int v8, v5, v17
    const v6, 4793490
    if-ne v8, v6, +011h
    invoke-interface v10, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v6
    if-nez v6, +003h
    goto +9h
    invoke-interface v10, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object v6, v14
    move-object v8, v15
    move-object v14, v10
    goto/16 +4aah
    if-eqz v7, +007h
    sget-object v6, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v6, Landroidx/compose/ui/Modifier;
    move-object v9, v6
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v6
    if-eqz v6, +008h
    const/4 v6, -1
    const-string v7, "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewScreen (VideoArtifactPreview.kt:195)"
    invoke-static v0, v5, v6, v7, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const v0, 1682469831
    invoke-interface v10, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v6, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v6, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v6
    const/4 v7, 0
    if-ne v0, v6, +009h
    invoke-static v7, Landroidx/compose/runtime/PrimitiveSnapshotStateKt;->mutableFloatStateOf(F)Landroidx/compose/runtime/MutableFloatState;
    move-result-object v0
    invoke-interface v10, v0, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v0, Landroidx/compose/runtime/MutableFloatState;
    invoke-interface v10, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v6, 1682471946
    invoke-interface v10, v6, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    sget-object v8, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v8, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v8
    const/4 v7, 0
    if-ne v6, v8, +00ah
    const/4 v8, 2
    invoke-static v7, v7, v8, v7, Landroidx/compose/runtime/SnapshotStateKt;->mutableStateOf$default(Ljava/lang/Object; Landroidx/compose/runtime/SnapshotMutationPolicy; I Ljava/lang/Object;)Landroidx/compose/runtime/MutableState;
    move-result-object v6
    invoke-interface v10, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v22, v6
    check-cast v22, Landroidx/compose/runtime/MutableState;
    invoke-interface v10, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v6, 773894976
    const-string v8, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp"
    invoke-static v10, v6, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const v6, 683737348
    const-string v8, "CC(remember):Effects.kt#9igjgp"
    invoke-static v10, v6, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    sget-object v8, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v8, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v8
    if-ne v6, v8, +00dh
    sget-object v6, Lkotlin/coroutines/EmptyCoroutineContext;->INSTANCE Lkotlin/coroutines/EmptyCoroutineContext;
    check-cast v6, Lkotlin/coroutines/CoroutineContext;
    invoke-static v6, v10, Landroidx/compose/runtime/EffectsKt;->createCompositionCoroutineScope(Lkotlin/coroutines/CoroutineContext; Landroidx/compose/runtime/Composer;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v6
    invoke-interface v10, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v6, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    shr-int/lit8 v8, v5, 18
    and-int/lit8 v8, v8, 14
    invoke-static v1, v10, v8, Landroidx/compose/runtime/SnapshotStateKt;->rememberUpdatedState(Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Landroidx/compose/runtime/State;
    move-result-object v8
    invoke-static Landroidx/compose/ui/platform/CompositionLocalsKt;->getLocalDensity()Landroidx/compose/runtime/ProvidableCompositionLocal;
    move-result-object v17
    move-object/from16 v7, v17
    check-cast v7, Landroidx/compose/runtime/CompositionLocal;
    const v1, 2023513938
    const-string v11, "CC(<get-current>):CompositionLocal.kt#9igjgp"
    invoke-static v10, v1, v11, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v10, v7, Landroidx/compose/runtime/Composer;->consume(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    check-cast v1, Landroidx/compose/ui/unit/Density;
    sget v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewDismissDistance F
    invoke-interface v1, v7, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v7
    sget v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewDismissScaleDistance F
    invoke-interface v1, v11, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v11
    sget v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewDismissVelocityThreshold F
    invoke-interface v1, v12, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$1(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v12
    div-float/2addr v12, v11
    const/high16 v11, 1065353216
    const/4 v13, 0
    invoke-static v12, v13, v11, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v11
    const v12, 1045220557
    mul-float/2addr v11, v12
    const/high16 v12, 1065353216
    sub-float/2addr v12, v11
    const/4 v11, 1
    const/4 v15, 0
    invoke-static v9, v13, v11, v15, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v25
    sget-wide v26, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PreviewBackgroundColor J
    const/16 v28, 0
    const/16 v29, 2
    const/16 v30, 0
    invoke-static/range v25 ... v30, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v13
    invoke-static v7, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v15
    invoke-static v1, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v11
    move-object/from16 v25, v9
    const v9, 1682502407
    invoke-interface v10, v9, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v10, v7, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v9
    invoke-interface v10, v1, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v18
    or-int v9, v9, v18
    invoke-interface v10, v8, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v18
    or-int v9, v9, v18
    invoke-interface v10, v6, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v18
    or-int v9, v9, v18
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v14
    if-nez v9, +00ah
    sget-object v9, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v9, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v9
    if-ne v14, v9, +019h
    new-instance v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;
    move-object/from16 v18, v9
    move/from16 v19, v7
    move/from16 v20, v1
    move-object/from16 v21, v6
    move-object/from16 v23, v0
    move-object/from16 v24, v8
    invoke-direct/range v18 ... v24, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;-><init>(F F Lkotlinx/coroutines/CoroutineScope; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/runtime/State;)V
    move-object v14, v9
    check-cast v14, Landroidx/compose/ui/input/pointer/PointerInputEventHandler;
    invoke-interface v10, v14, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v14, Landroidx/compose/ui/input/pointer/PointerInputEventHandler;
    invoke-interface v10, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v13, v15, v11, v14, Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilterKt;->pointerInput(Landroidx/compose/ui/Modifier; Ljava/lang/Object; Ljava/lang/Object; Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    sget-object v6, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v6, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;
    move-result-object v6
    const v7, 1042775818
    const-string v8, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v10, v7, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v7, 0
    invoke-static v6, v7, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v6
    const v8, -1159599143
    const-string v9, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v10, v8, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v10, v7, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v8
    invoke-static v8, v9, Ljava/lang/Long;->hashCode(J)I
    move-result v8
    invoke-interface v10, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v9
    invoke-static v10, v1, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    sget-object v11, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v11, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v11
    const v13, -553112988
    const-string v14, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v10, v13, v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v10, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v13
    instance-of v13, v13, Landroidx/compose/runtime/Applier;
    if-nez v13, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v10, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v10, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v13
    if-eqz v13, +006h
    invoke-interface v10, v11, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v10, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v10, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v11
    sget-object v13, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v13, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v13
    invoke-static v11, v6, v13, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-static v11, v9, v6, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-interface v11, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-nez v9, +010h
    invoke-interface v11, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    invoke-static v9, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +010h
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v11, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v11, v8, v6, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-static v11, v1, v6, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v1, 1833054614
    const-string v6, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v10, v1, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v1, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v1, Landroidx/compose/foundation/layout/BoxScope;
    sget-object v1, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v1, Landroidx/compose/ui/Modifier;
    const/4 v6, 0
    const/4 v8, 0
    const/4 v9, 1
    invoke-static v1, v6, v9, v8, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const v6, -1108579916
    invoke-interface v10, v6, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    sget-object v8, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v8, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v8
    if-ne v6, v8, +00ah
    new-instance v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda1;
    invoke-direct v6, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda1;-><init>(Landroidx/compose/runtime/MutableFloatState;)V
    invoke-interface v10, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v6, Lkotlin/jvm/functions/Function1;
    invoke-interface v10, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v1, v6, Landroidx/compose/foundation/layout/OffsetKt;->offset(Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    const v1, -1108577245
    invoke-interface v10, v1, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v10, v12, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v1
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    if-nez v1, +00ah
    sget-object v1, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v1, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v1
    if-ne v6, v1, +00ah
    new-instance v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda2;
    invoke-direct v6, v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda2;-><init>(F)V
    invoke-interface v10, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v6, Lkotlin/jvm/functions/Function1;
    invoke-interface v10, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v0, v6, Landroidx/compose/ui/graphics/GraphicsLayerModifierKt;->graphicsLayer(Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v1, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v1, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;
    move-result-object v1
    const v6, 1042775818
    const-string v8, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v10, v6, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v1, v7, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v1
    const v6, -1159599143
    const-string v8, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v10, v6, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v10, v7, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v8
    invoke-static v8, v9, Ljava/lang/Long;->hashCode(J)I
    move-result v6
    invoke-interface v10, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v8
    invoke-static v10, v0, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v9, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v9, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v9
    const v11, -553112988
    const-string v12, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v10, v11, v12, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v10, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v11
    instance-of v11, v11, Landroidx/compose/runtime/Applier;
    if-nez v11, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v10, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v10, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v11
    if-eqz v11, +006h
    invoke-interface v10, v9, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v10, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v10, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v9
    sget-object v11, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v11, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v11
    invoke-static v9, v1, v11, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v1, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v1, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v1
    invoke-static v9, v8, v1, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v1, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v1, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v1
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-nez v8, +010h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v8
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-static v8, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +010h
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v9, v8, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v9, v6, v1, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v1, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v1, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v1
    invoke-static v9, v0, v1, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v0, 1833054614
    const-string v1, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v10, v0, v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v0, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v0, Landroidx/compose/foundation/layout/BoxScope;
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Preparing;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Preparing;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +017h
    const v0, 923111708
    invoke-interface v10, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-static v10, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->ArtifactPreviewLoadingState(Landroidx/compose/runtime/Composer; I)V
    invoke-interface v10, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object/from16 v6, v35
    move-object/from16 v8, v36
    move-object v14, v10
    move-object/from16 v13, v25
    goto/16 +192h
    instance-of v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    if-eqz v0, +14bh
    const v0, 923276814
    invoke-interface v10, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getLocalSource()Ljava/lang/String;
    move-result-object v0
    const v6, 1138161773
    invoke-interface v10, v6, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v10, v0, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v0
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    if-nez v0, +00ah
    sget-object v0, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v0, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v0
    if-ne v6, v0, +031h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    move-object v6, v2
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    invoke-virtual v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getLocalSource()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->createVideoArtifactEngine(Ljava/lang/String;)Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    move-result-object v6
    invoke-direct v0, v6, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;-><init>(Lcom/bytedance/vcloud/uniplayer/UniAVEngine;)V
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    const/4 v0, 0
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-interface v10, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v6, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-interface v10, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    if-eqz v6, +06eh
    const v0, 923625192
    invoke-interface v10, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const v0, 1138174220
    invoke-interface v10, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    and-int/lit8 v0, v5, 112
    const/16 v8, 32
    if-ne v0, v8, +004h
    const/4 v9, 1
    goto +2h
    move v9, v7
    invoke-interface v10, v6, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    or-int/2addr v0, v9
    and-int/lit16 v8, v5, 896
    const/16 v9, 256
    if-ne v8, v9, +004h
    const/4 v9, 1
    goto +2h
    move v9, v7
    or-int/2addr v0, v9
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v8
    if-nez v0, +00ah
    sget-object v0, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v0, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v0
    if-ne v8, v0, +00ah
    new-instance v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda3;
    invoke-direct v8, v3, v6, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda3;-><init>(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer; Lkotlin/jvm/functions/Function1;)V
    invoke-interface v10, v8, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v8, Lkotlin/jvm/functions/Function1;
    invoke-interface v10, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v6, v8, v10, v7, Landroidx/compose/runtime/EffectsKt;->DisposableEffect(Ljava/lang/Object; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 1
    invoke-static v0, v7, v9, v8, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v9
    shr-int/lit8 v0, v5, 3
    and-int/lit16 v0, v0, 896
    or-int/lit16 v0, v0, 24576
    shr-int/lit8 v5, v5, 6
    and-int/lit16 v5, v5, 7168
    or-int v11, v0, v5
    const/4 v12, 0
    move-object v5, v1
    move-object/from16 v7, v34
    move-object/from16 v8, v36
    move-object/from16 v13, v25
    move-object v14, v10
    invoke-static/range v5 ... v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewContent(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object/from16 v6, v35
    goto/16 +080h
    move-object v14, v10
    move-object/from16 v13, v25
    const/4 v9, 1
    const v0, 924251671
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;->getLocalSource()Ljava/lang/String;
    move-result-object v0
    const v1, 1138195057
    invoke-interface v14, v1, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const v1, 57344
    and-int/2addr v1, v5
    const/16 v6, 16384
    if-ne v1, v6, +004h
    move v1, v9
    goto +2h
    move v1, v7
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    if-nez v1, +00fh
    sget-object v1, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v1, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v1
    if-ne v6, v1, +003h
    goto +5h
    move-object v1, v6
    move-object/from16 v6, v35
    goto +eh
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1;
    move-object/from16 v6, v35
    const/4 v8, 0
    invoke-direct v1, v6, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-interface v14, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v0, v1, v14, v7, Landroidx/compose/runtime/EffectsKt;->LaunchedEffect(Ljava/lang/Object; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    const v0, 1138200556
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const/high16 v0, 458752
    and-int/2addr v0, v5
    const/high16 v1, 131072
    if-ne v0, v1, +004h
    move v11, v9
    goto +2h
    move v11, v7
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v0
    if-nez v11, +00eh
    sget-object v1, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v1, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v1
    if-ne v0, v1, +003h
    goto +4h
    move-object/from16 v8, v36
    goto +bh
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda4;
    move-object/from16 v8, v36
    invoke-direct v0, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda4;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v0, Lkotlin/jvm/functions/Function0;
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v0, v14, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->ArtifactPreviewErrorState(Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/Composer; I)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    goto +44h
    move-object/from16 v6, v35
    move-object/from16 v8, v36
    move-object v14, v10
    move-object/from16 v13, v25
    const/4 v9, 1
    instance-of v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Failed;
    if-eqz v0, +083h
    const v0, 924710657
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const v0, 1138210596
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const/high16 v0, 458752
    and-int/2addr v0, v5
    const/high16 v1, 131072
    if-ne v0, v1, +004h
    move v11, v9
    goto +2h
    move v11, v7
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v0
    if-nez v11, +00ah
    sget-object v1, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v1, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v1
    if-ne v0, v1, +00ah
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda5;
    invoke-direct v0, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda5;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v0, Lkotlin/jvm/functions/Function0;
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v0, v14, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->ArtifactPreviewErrorState(Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/Composer; I)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    move-object v9, v13
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v0
    if-eqz v0, +01dh
    new-instance v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;
    move-object v1, v12
    move-object/from16 v2, v31
    move-object/from16 v3, v32
    move-object/from16 v4, v33
    move-object/from16 v5, v34
    move-object/from16 v6, v35
    move-object/from16 v7, v36
    move-object/from16 v8, v37
    move/from16 v10, v40
    move/from16 v11, v41
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; I I)V
    invoke-interface v0, v12, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
    const v0, 1138155471
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    :try_start_0x443
.end method

.method private static final VideoArtifactPreviewScreen$lambda$1(androidx.compose.runtime.MutableFloatState)float
    .registers 1
    # ins_size=1
    check-cast v0, Landroidx/compose/runtime/FloatState;
    invoke-interface v0, Landroidx/compose/runtime/FloatState;->getFloatValue()F
    move-result v0
    return v0
.end method

.method private static final VideoArtifactPreviewScreen$lambda$2(androidx.compose.runtime.MutableFloatState  float)void
    .registers 2
    # ins_size=2
    invoke-interface v0, v1, Landroidx/compose/runtime/MutableFloatState;->setFloatValue(F)V
    return-void 
.end method

.method private static final VideoArtifactPreviewScreen$lambda$26$lambda$12$lambda$11(androidx.compose.runtime.MutableFloatState  androidx.compose.ui.unit.Density)androidx.compose.ui.unit.IntOffset
    .registers 6
    # ins_size=2
    const-string v0, "$this$offset"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$1(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v4
    invoke-static v4, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v4
    const/4 v5, 0
    int-to-long v0, v5
    const/16 v5, 32
    shl-long/2addr v0, v5
    int-to-long v4, v4
    const-wide v2, 4294967295
    and-long/2addr v4, v2
    or-long/2addr v4, v0
    invoke-static v4, v5, Landroidx/compose/ui/unit/IntOffset;->constructor-impl(J)J
    move-result-wide v4
    invoke-static v4, v5, Landroidx/compose/ui/unit/IntOffset;->box-impl(J)Landroidx/compose/ui/unit/IntOffset;
    move-result-object v4
    return-object v4
.end method

.method private static final VideoArtifactPreviewScreen$lambda$26$lambda$14$lambda$13(float  androidx.compose.ui.graphics.GraphicsLayerScope)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "$this$graphicsLayer"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, Landroidx/compose/ui/graphics/GraphicsLayerScope;->setScaleX(F)V
    invoke-interface v2, v1, Landroidx/compose/ui/graphics/GraphicsLayerScope;->setScaleY(F)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$19$lambda$18(kotlin.jvm.functions.Function1  com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer  kotlin.jvm.functions.Function1  androidx.compose.runtime.DisposableEffectScope)androidx.compose.runtime.DisposableEffectResult
    .registers 5
    # ins_size=4
    const-string v0, "$this$DisposableEffect"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$19$lambda$18$$inlined$onDispose$1;
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$19$lambda$18$$inlined$onDispose$1;-><init>(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;)V
    check-cast v1, Landroidx/compose/runtime/DisposableEffectResult;
    return-object v1
.end method

.method private static final VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$22$lambda$21(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$Reload;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$Reload;
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$24$lambda$23(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$Reload;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction$Reload;
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final VideoArtifactPreviewScreen$lambda$27(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 24
    # ins_size=12
    or-int/lit8 v0, v20, 1
    invoke-static v0, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v10
    move-object v1, v12
    move-object v2, v13
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    move-object/from16 v7, v18
    move-object/from16 v8, v19
    move-object/from16 v9, v22
    move/from16 v11, v21
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final VideoArtifactPreviewScreen$lambda$4(androidx.compose.runtime.MutableState)kotlinx.coroutines.Job
    .registers 1
    # ins_size=1
    check-cast v0, Landroidx/compose/runtime/State;
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    return-object v0
.end method

.method private static final VideoArtifactPreviewScreen$lambda$5(androidx.compose.runtime.MutableState  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    invoke-interface v0, v1, Landroidx/compose/runtime/MutableState;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final VideoArtifactPreviewScreen$lambda$6(androidx.compose.runtime.State)kotlin.jvm.functions.Function0
    .registers 1
    # ins_size=1
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method private static final VideoPlaybackControls(boolean  long  long  float  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  androidx.compose.runtime.Composer  int  int)void
    .registers 60
    # ins_size=15
    move/from16 v1, v45
    move/from16 v6, v50
    move-object/from16 v7, v51
    move-object/from16 v10, v54
    move-object/from16 v11, v55
    move/from16 v13, v58
    move/from16 v14, v59
    const v0, -295831889
    move-object/from16 v2, v57
    invoke-interface v2, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v2
    and-int/lit8 v3, v14, 1
    if-eqz v3, +005h
    or-int/lit8 v3, v13, 6
    goto +11h
    and-int/lit8 v3, v13, 6
    if-nez v3, +00dh
    invoke-interface v2, v1, Landroidx/compose/runtime/Composer;->changed(Z)Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 4
    goto +2h
    const/4 v3, 2
    or-int/2addr v3, v13
    goto +2h
    move v3, v13
    and-int/lit8 v4, v14, 2
    if-eqz v4, +005h
    or-int/lit8 v3, v3, 48
    goto +14h
    and-int/lit8 v4, v13, 48
    if-nez v4, +011h
    move-wide/from16 v4, v46
    invoke-interface v2, v4, v5, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v8
    if-eqz v8, +005h
    const/16 v8, 32
    goto +3h
    const/16 v8, 16
    or-int/2addr v3, v8
    goto +3h
    move-wide/from16 v4, v46
    and-int/lit8 v8, v14, 4
    if-eqz v8, +005h
    or-int/lit16 v3, v3, 384
    goto +14h
    and-int/lit16 v8, v13, 384
    if-nez v8, +011h
    move-wide/from16 v8, v48
    invoke-interface v2, v8, v9, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v12
    if-eqz v12, +005h
    const/16 v12, 256
    goto +3h
    const/16 v12, 128
    or-int/2addr v3, v12
    goto +3h
    move-wide/from16 v8, v48
    and-int/lit8 v12, v14, 8
    if-eqz v12, +005h
    or-int/lit16 v3, v3, 3072
    goto +11h
    and-int/lit16 v12, v13, 3072
    if-nez v12, +00eh
    invoke-interface v2, v6, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v12
    if-eqz v12, +005h
    const/16 v12, 2048
    goto +3h
    const/16 v12, 1024
    or-int/2addr v3, v12
    and-int/lit8 v12, v14, 16
    if-eqz v12, +005h
    or-int/lit16 v3, v3, 24576
    goto +11h
    and-int/lit16 v12, v13, 24576
    if-nez v12, +00eh
    invoke-interface v2, v7, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +005h
    const/16 v12, 16384
    goto +3h
    const/16 v12, 8192
    or-int/2addr v3, v12
    and-int/lit8 v12, v14, 32
    if-eqz v12, +006h
    const/high16 v12, 196608
    or-int/2addr v3, v12
    goto +15h
    const/high16 v12, 196608
    and-int/2addr v12, v13
    if-nez v12, +011h
    move-object/from16 v12, v52
    invoke-interface v2, v12, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v15
    if-eqz v15, +005h
    const/high16 v15, 131072
    goto +3h
    const/high16 v15, 65536
    or-int/2addr v3, v15
    goto +3h
    move-object/from16 v12, v52
    and-int/lit8 v15, v14, 64
    if-eqz v15, +006h
    const/high16 v15, 1572864
    or-int/2addr v3, v15
    goto +16h
    const/high16 v15, 1572864
    and-int/2addr v15, v13
    if-nez v15, +012h
    move-object/from16 v15, v53
    invoke-interface v2, v15, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v16
    if-eqz v16, +005h
    const/high16 v16, 1048576
    goto +3h
    const/high16 v16, 524288
    or-int v3, v3, v16
    goto +3h
    move-object/from16 v15, v53
    and-int/lit16 v0, v14, 128
    if-eqz v0, +006h
    const/high16 v0, 12582912
    or-int/2addr v3, v0
    goto +12h
    const/high16 v0, 12582912
    and-int/2addr v0, v13
    if-nez v0, +00eh
    invoke-interface v2, v10, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const/high16 v0, 8388608
    goto -fh
    const/high16 v0, 4194304
    goto -12h
    and-int/lit16 v0, v14, 256
    if-eqz v0, +006h
    const/high16 v0, 100663296
    or-int/2addr v3, v0
    goto +12h
    const/high16 v0, 100663296
    and-int/2addr v0, v13
    if-nez v0, +00eh
    invoke-interface v2, v11, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    const/high16 v0, 67108864
    goto -fh
    const/high16 v0, 33554432
    goto -12h
    and-int/lit16 v0, v14, 512
    const/high16 v17, 805306368
    if-eqz v0, +007h
    or-int v3, v3, v17
    move-object/from16 v4, v56
    goto +13h
    and-int v17, v13, v17
    move-object/from16 v4, v56
    if-nez v17, +00eh
    invoke-interface v2, v4, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +005h
    const/high16 v5, 536870912
    goto +3h
    const/high16 v5, 268435456
    or-int/2addr v3, v5
    const v5, 306783379
    and-int/2addr v5, v3
    const v4, 306783378
    if-ne v5, v4, +010h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v4
    if-nez v4, +003h
    goto +8h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object/from16 v12, v56
    goto/16 +7e3h
    if-eqz v0, +007h
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    goto +3h
    move-object/from16 v0, v56
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +00bh
    const/4 v4, -1
    const-string v5, "com.bytedance.trae.kmp.artifacts.video.VideoPlaybackControls (VideoArtifactPreview.kt:563)"
    const v8, -295831889
    invoke-static v8, v3, v4, v5, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v5, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v4, v2, v5, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v4
    invoke-static Landroidx/compose/ui/platform/CompositionLocalsKt;->getLocalDensity()Landroidx/compose/runtime/ProvidableCompositionLocal;
    move-result-object v5
    check-cast v5, Landroidx/compose/runtime/CompositionLocal;
    const v8, 2023513938
    const-string v9, "CC(<get-current>):CompositionLocal.kt#9igjgp"
    invoke-static v2, v8, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v2, v5, Landroidx/compose/runtime/Composer;->consume(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    check-cast v5, Landroidx/compose/ui/unit/Density;
    const v8, 1449294190
    invoke-interface v2, v8, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v8
    sget-object v9, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v9, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v9
    const/4 v12, 1
    if-ne v8, v9, +00bh
    new-instance v8, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    const/4 v9, 0
    invoke-direct v8, v9, v12, v9, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v8, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v8, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v9, 1449296078
    invoke-interface v2, v9, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    sget-object v16, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual/range v16, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v12
    if-ne v9, v12, +00ch
    new-instance v9, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    const/4 v12, 0
    const/4 v13, 1
    invoke-direct v9, v12, v13, v12, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v9, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlRadius-D9Ej5fM()F
    move-result v12
    invoke-static v12, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v12
    const v13, 1449300264
    invoke-interface v2, v13, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const/high16 v13, 1065353216
    cmpg-float v13, v6, v13
    const/4 v6, 0
    if-nez v13, +004h
    const/4 v13, 1
    goto +2h
    move v13, v6
    if-eqz v13, +00fh
    sget-object v13, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;
    invoke-static v13, Lcom/bytedance/trae/kmp/artifacts/generated/resources/String0_commonMainKt;->getTrae_video_artifact_preview_speed(Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v13
    new-array v14, v6, [Ljava/lang/Object;
    invoke-static v13, v14, v2, v6, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v13
    goto +5h
    invoke-static/range v50, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->formatSpeed(F)Ljava/lang/String;
    move-result-object v13
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlHeight-D9Ej5fM()F
    move-result v14
    invoke-static v0, v14, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v16
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getTitleBarElevation-D9Ej5fM()F
    move-result v17
    check-cast v12, Landroidx/compose/ui/graphics/Shape;
    const/16 v19, 0
    const-wide/16 v20, 0
    const-wide/16 v22, 0
    const/16 v24, 24
    const/16 v25, 0
    move-object/from16 v18, v12
    invoke-static/range v16 ... v25, Landroidx/compose/ui/draw/ShadowKt;->shadow-s4CzXII$default(Landroidx/compose/ui/Modifier; F Landroidx/compose/ui/graphics/Shape; Z J J I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v14
    invoke-static v14, v12, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v16
    sget-object v12, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v14, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v12, v2, v14, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/design/compose/TraeColors;->getSpecialWhite-0d7_KjU()J
    move-result-wide v17
    const v19, 1053609165
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 14
    const/16 v24, 0
    invoke-static/range v17 ... v24, Landroidx/compose/ui/graphics/Color;->copy-wmQWz5c$default(J F F F F I Ljava/lang/Object;)J
    move-result-wide v17
    const/16 v19, 0
    const/16 v20, 2
    const/16 v21, 0
    invoke-static/range v16 ... v21, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v12
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlPaddingStart-D9Ej5fM()F
    move-result v14
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlPaddingEnd-D9Ej5fM()F
    move-result v6
    move-object/from16 v40, v0
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlPaddingVertical-D9Ej5fM()F
    move-result v0
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlPaddingVertical-D9Ej5fM()F
    move-result v15
    invoke-static v12, v14, v0, v6, v15, Landroidx/compose/foundation/layout/PaddingKt;->padding-qDBjuR0(Landroidx/compose/ui/Modifier; F F F F)Landroidx/compose/ui/Modifier;
    move-result-object v0
    const v6, 1042775818
    const-string v12, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v2, v6, v12, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v14, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v14, Landroidx/compose/ui/Alignment$Companion;->getTopStart()Landroidx/compose/ui/Alignment;
    move-result-object v14
    const/4 v15, 0
    invoke-static v14, v15, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v14
    const v6, -1159599143
    move-object/from16 v41, v13
    const-string v13, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v2, v6, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v2, v15, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v16
    invoke-static/range v16 ... v17, Ljava/lang/Long;->hashCode(J)I
    move-result v15
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v6
    invoke-static v2, v0, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v16, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual/range v16, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v10
    move-object/from16 v42, v9
    const v9, -553112988
    const-string v11, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v2, v9, v11, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v9
    instance-of v9, v9, Landroidx/compose/runtime/Applier;
    if-nez v9, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-eqz v9, +006h
    invoke-interface v2, v10, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v2, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v9
    sget-object v10, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v10, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v10
    invoke-static v9, v14, v10, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v10, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v10, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v10
    invoke-static v9, v6, v10, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v10
    if-nez v10, +010h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v10
    invoke-static v15, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    invoke-static v10, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +010h
    invoke-static v15, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-interface v9, v10, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v15, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-interface v9, v10, v6, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-static v9, v0, v6, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v0, 1833054614
    const-string v6, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v2, v0, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v9, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v9, Landroidx/compose/foundation/layout/BoxScope;
    sget-object v9, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v9, Landroidx/compose/ui/Modifier;
    const/4 v10, 0
    const/4 v14, 0
    const/4 v15, 1
    invoke-static v9, v10, v15, v14, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v9
    sget-object v14, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v14, Landroidx/compose/ui/Alignment$Companion;->getCenterVertically()Landroidx/compose/ui/Alignment$Vertical;
    move-result-object v14
    const v15, 844473419
    const-string v10, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo"
    invoke-static v2, v15, v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v10, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v10, Landroidx/compose/foundation/layout/Arrangement;->getStart()Landroidx/compose/foundation/layout/Arrangement$Horizontal;
    move-result-object v10
    const/16 v15, 48
    invoke-static v10, v14, v2, v15, Landroidx/compose/foundation/layout/RowKt;->rowMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Horizontal; Landroidx/compose/ui/Alignment$Vertical; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v10
    const v14, -1159599143
    invoke-static v2, v14, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v14, 0
    invoke-static v2, v14, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v16
    invoke-static/range v16 ... v17, Ljava/lang/Long;->hashCode(J)I
    move-result v14
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v15
    invoke-static v2, v9, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v9
    sget-object v17, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual/range v17, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v0
    move-object/from16 v43, v5
    const v5, -553112988
    invoke-static v2, v5, v11, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v5
    instance-of v5, v5, Landroidx/compose/runtime/Applier;
    if-nez v5, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v5
    if-eqz v5, +006h
    invoke-interface v2, v0, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v2, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v0
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v0, v10, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v0, v15, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v10
    if-nez v10, +010h
    invoke-interface v0, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v10
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v15
    invoke-static v10, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +010h
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-interface v0, v10, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v14, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-interface v0, v10, v5, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v0, v9, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v0, 1456264949
    const-string v5, "C101@5233L9:Row.kt#2w3rfo"
    invoke-static v2, v0, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v0, Landroidx/compose/foundation/layout/RowScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/RowScopeInstance;
    check-cast v0, Landroidx/compose/foundation/layout/RowScope;
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewPlayTouchSize-D9Ej5fM()F
    move-result v9
    invoke-static v5, v9, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v17
    const v5, 2074446709
    invoke-interface v2, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v5
    sget-object v9, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v9, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v9
    if-ne v5, v9, +009h
    invoke-static Landroidx/compose/foundation/interaction/InteractionSourceKt;->MutableInteractionSource()Landroidx/compose/foundation/interaction/MutableInteractionSource;
    move-result-object v5
    invoke-interface v2, v5, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v18, v5
    check-cast v18, Landroidx/compose/foundation/interaction/MutableInteractionSource;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const v5, 2074450149
    invoke-interface v2, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v2, v8, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v5
    const v9, 57344
    and-int/2addr v9, v3
    const/16 v10, 16384
    if-ne v9, v10, +004h
    const/4 v9, 1
    goto +2h
    const/4 v9, 0
    or-int/2addr v5, v9
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    if-nez v5, +00ah
    sget-object v5, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v5, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v5
    if-ne v9, v5, +00ah
    new-instance v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda7;
    invoke-direct v9, v8, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)V
    invoke-interface v2, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v23, v9
    check-cast v23, Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v24, 28
    const/16 v25, 0
    invoke-static/range v17 ... v25, Landroidx/compose/foundation/ClickableKt;->clickable-O2vRcR0$default(Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/interaction/MutableInteractionSource; Landroidx/compose/foundation/Indication; Z Ljava/lang/String; Landroidx/compose/ui/semantics/Role; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    sget-object v8, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v8, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;
    move-result-object v8
    const v9, 1042775818
    invoke-static v2, v9, v12, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v9, 0
    invoke-static v8, v9, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v8
    const v10, -1159599143
    invoke-static v2, v10, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v2, v9, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v14
    invoke-static v14, v15, Ljava/lang/Long;->hashCode(J)I
    move-result v9
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v10
    invoke-static v2, v5, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    sget-object v14, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v14, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v14
    const v15, -553112988
    invoke-static v2, v15, v11, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v15
    instance-of v15, v15, Landroidx/compose/runtime/Applier;
    if-nez v15, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v15
    if-eqz v15, +006h
    invoke-interface v2, v14, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v2, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v14
    sget-object v15, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v15, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v15
    invoke-static v14, v8, v15, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v8, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v8, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v8
    invoke-static v14, v10, v8, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v8, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v8, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v8
    invoke-interface v14, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v10
    if-nez v10, +010h
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v10
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v15
    invoke-static v10, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +010h
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-interface v14, v10, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v14, v9, v8, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v8, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v8, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v8
    invoke-static v14, v5, v8, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v5, 1833054614
    invoke-static v2, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v5, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v5, Landroidx/compose/foundation/layout/BoxScope;
    if-eqz v1, +009h
    sget-object v5, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;
    invoke-static v5, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Drawable0_commonMainKt;->getTrae_video_preview_pause(Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v5
    goto +7h
    sget-object v5, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;
    invoke-static v5, Lcom/bytedance/trae/kmp/artifacts/generated/resources/Drawable0_commonMainKt;->getTrae_video_preview_play(Lcom/bytedance/trae/kmp/artifacts/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v5
    const/4 v8, 0
    invoke-static v5, v2, v8, Lorg/jetbrains/compose/resources/ImageResources_androidKt;->painterResource(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/graphics/painter/Painter;
    move-result-object v15
    const/4 v5, 0
    sget-object v8, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v8, Landroidx/compose/ui/Modifier;
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewPlayIconSize-D9Ej5fM()F
    move-result v9
    invoke-static v8, v9, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v17
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v23, 48
    const/16 v24, 120
    const/16 v8, 48
    move-object/from16 v16, v5
    move-object/from16 v22, v2
    invoke-static/range v15 ... v24, Landroidx/compose/foundation/ImageKt;->Image(Landroidx/compose/ui/graphics/painter/Painter; Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Landroidx/compose/ui/layout/ContentScale; F Landroidx/compose/ui/graphics/ColorFilter; Landroidx/compose/runtime/Composer; I I)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlGap-D9Ej5fM()F
    move-result v9
    invoke-static v5, v9, Landroidx/compose/foundation/layout/SizeKt;->width-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    const/4 v9, 0
    invoke-static v5, v2, v9, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    move-object/from16 v18, v5
    check-cast v18, Landroidx/compose/ui/Modifier;
    const/high16 v19, 1065353216
    const/16 v20, 0
    const/16 v21, 2
    const/16 v22, 0
    move-object/from16 v17, v0
    invoke-static/range v17 ... v22, Landroidx/compose/foundation/layout/RowScope;->weight$default(Landroidx/compose/foundation/layout/RowScope; Landroidx/compose/ui/Modifier; F Z I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlContentHeight-D9Ej5fM()F
    move-result v5
    invoke-static v0, v5, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v0
    const v5, 1341605231
    const-string v9, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo"
    invoke-static v2, v5, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v5, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v5, Landroidx/compose/foundation/layout/Arrangement;->getTop()Landroidx/compose/foundation/layout/Arrangement$Vertical;
    move-result-object v5
    sget-object v9, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v9, Landroidx/compose/ui/Alignment$Companion;->getStart()Landroidx/compose/ui/Alignment$Horizontal;
    move-result-object v9
    const/4 v10, 0
    invoke-static v5, v9, v2, v10, Landroidx/compose/foundation/layout/ColumnKt;->columnMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Vertical; Landroidx/compose/ui/Alignment$Horizontal; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v5
    const v9, -1159599143
    invoke-static v2, v9, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v2, v10, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v14
    invoke-static v14, v15, Ljava/lang/Long;->hashCode(J)I
    move-result v9
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v10
    invoke-static v2, v0, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v14, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v14, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v14
    const v15, -553112988
    invoke-static v2, v15, v11, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v15
    instance-of v15, v15, Landroidx/compose/runtime/Applier;
    if-nez v15, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v15
    if-eqz v15, +006h
    invoke-interface v2, v14, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v2, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v14
    sget-object v15, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v15, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v15
    invoke-static v14, v5, v15, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v14, v10, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-interface v14, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v10
    if-nez v10, +010h
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v10
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v15
    invoke-static v10, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +010h
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-interface v14, v10, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v14, v9, v5, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v14, v0, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v0, 2093002350
    const-string v5, "C89@4557L9:Column.kt#2w3rfo"
    invoke-static v2, v0, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v0, Landroidx/compose/foundation/layout/ColumnScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/ColumnScopeInstance;
    check-cast v0, Landroidx/compose/foundation/layout/ColumnScope;
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    const/4 v5, 0
    const/4 v9, 0
    const/4 v10, 1
    invoke-static v0, v5, v10, v9, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewControlTextRowHeight-D9Ej5fM()F
    move-result v5
    invoke-static v0, v5, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v5, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v5, Landroidx/compose/ui/Alignment$Companion;->getCenterVertically()Landroidx/compose/ui/Alignment$Vertical;
    move-result-object v5
    const v9, 844473419
    const-string v10, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo"
    invoke-static v2, v9, v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v9, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v9, Landroidx/compose/foundation/layout/Arrangement;->getStart()Landroidx/compose/foundation/layout/Arrangement$Horizontal;
    move-result-object v9
    invoke-static v9, v5, v2, v8, Landroidx/compose/foundation/layout/RowKt;->rowMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Horizontal; Landroidx/compose/ui/Alignment$Vertical; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v5
    const v8, -1159599143
    invoke-static v2, v8, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v8, 0
    invoke-static v2, v8, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v9
    invoke-static v9, v10, Ljava/lang/Long;->hashCode(J)I
    move-result v8
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v9
    invoke-static v2, v0, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v10, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v10, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v10
    const v14, -553112988
    invoke-static v2, v14, v11, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v14
    instance-of v14, v14, Landroidx/compose/runtime/Applier;
    if-nez v14, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v14
    if-eqz v14, +006h
    invoke-interface v2, v10, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v2, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v10
    sget-object v14, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v14, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v14
    invoke-static v10, v5, v14, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v10, v9, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-interface v10, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-nez v9, +010h
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    invoke-static v9, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +010h
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v10, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v10, v8, v5, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v10, v0, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v0, 1456264949
    const-string v5, "C101@5233L9:Row.kt#2w3rfo"
    invoke-static v2, v0, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v0, Landroidx/compose/foundation/layout/RowScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/RowScopeInstance;
    move-object v14, v0
    check-cast v14, Landroidx/compose/foundation/layout/RowScope;
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-static/range v46 ... v47, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->formatTime(J)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v5, " / "
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static/range v48 ... v49, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->formatTime(J)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v15
    const/16 v16, 0
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v5, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v0, v2, v5, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/design/compose/TraeColors;->getTextTextWhite-0d7_KjU()J
    move-result-wide v17
    const-wide/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const-wide/16 v24, 0
    const/16 v26, 0
    const/16 v27, 0
    const-wide/16 v28, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v5, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v0, v2, v5, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/design/compose/TraeTypography;->getCaptionXs()Landroidx/compose/ui/text/TextStyle;
    move-result-object v35
    const/16 v37, 0
    const/16 v38, 0
    const v39, 65530
    move-object/from16 v36, v2
    invoke-static/range v15 ... v39, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    move-object v15, v0
    check-cast v15, Landroidx/compose/ui/Modifier;
    const/high16 v16, 1065353216
    const/16 v17, 0
    const/16 v18, 2
    const/16 v19, 0
    invoke-static/range v14 ... v19, Landroidx/compose/foundation/layout/RowScope;->weight$default(Landroidx/compose/foundation/layout/RowScope; Landroidx/compose/ui/Modifier; F Z I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    const/4 v5, 0
    invoke-static v0, v2, v5, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    const/4 v8, 3
    const/4 v9, 0
    invoke-static v0, v9, v5, v8, v9, Landroidx/compose/foundation/layout/SizeKt;->wrapContentWidth$default(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment$Horizontal; Z I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    const v5, 460831822
    invoke-interface v2, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    move-object/from16 v5, v43
    invoke-interface v2, v5, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v8
    invoke-interface v2, v4, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v9
    or-int/2addr v8, v9
    const/high16 v9, 234881024
    and-int/2addr v9, v3
    const/high16 v10, 67108864
    if-ne v9, v10, +004h
    const/4 v9, 1
    goto +2h
    const/4 v9, 0
    or-int/2addr v8, v9
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    if-nez v8, +00fh
    sget-object v8, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v8, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v8
    if-ne v9, v8, +003h
    goto +5h
    move-object v8, v11
    move-object/from16 v11, v55
    goto +ch
    new-instance v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda8;
    move-object v8, v11
    move-object/from16 v11, v55
    invoke-direct v9, v5, v11, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda8;-><init>(Landroidx/compose/ui/unit/Density; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/design/compose/TraeDimens;)V
    invoke-interface v2, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v9, Lkotlin/jvm/functions/Function1;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v0, v9, Landroidx/compose/ui/layout/OnGloballyPositionedModifierKt;->onGloballyPositioned(Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;
    move-result-object v14
    const v0, 460877555
    invoke-interface v2, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v0
    sget-object v5, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v5, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v5
    if-ne v0, v5, +009h
    invoke-static Landroidx/compose/foundation/interaction/InteractionSourceKt;->MutableInteractionSource()Landroidx/compose/foundation/interaction/MutableInteractionSource;
    move-result-object v0
    invoke-interface v2, v0, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v15, v0
    check-cast v15, Landroidx/compose/foundation/interaction/MutableInteractionSource;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const v0, 460881525
    invoke-interface v2, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    move-object/from16 v9, v42
    invoke-interface v2, v9, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    const/high16 v5, 29360128
    and-int/2addr v5, v3
    const/high16 v10, 8388608
    if-ne v5, v10, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    or-int/2addr v0, v5
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v5
    if-nez v0, +00eh
    sget-object v0, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v0, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v0
    if-ne v5, v0, +003h
    goto +4h
    move-object/from16 v10, v54
    goto +bh
    new-instance v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda9;
    move-object/from16 v10, v54
    invoke-direct v5, v9, v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)V
    invoke-interface v2, v5, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v20, v5
    check-cast v20, Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v21, 28
    const/16 v22, 0
    invoke-static/range v14 ... v22, Landroidx/compose/foundation/ClickableKt;->clickable-O2vRcR0$default(Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/interaction/MutableInteractionSource; Landroidx/compose/foundation/Indication; Z Ljava/lang/String; Landroidx/compose/ui/semantics/Role; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v5, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v5, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;
    move-result-object v5
    const v9, 1042775818
    invoke-static v2, v9, v12, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v9, 0
    invoke-static v5, v9, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v5
    const v12, -1159599143
    invoke-static v2, v12, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v2, v9, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v12
    invoke-static v12, v13, Ljava/lang/Long;->hashCode(J)I
    move-result v9
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v12
    invoke-static v2, v0, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v13, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v13, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v13
    const v14, -553112988
    invoke-static v2, v14, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v8
    instance-of v8, v8, Landroidx/compose/runtime/Applier;
    if-nez v8, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-eqz v8, +006h
    invoke-interface v2, v13, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v2, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v8
    sget-object v13, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v13, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v13
    invoke-static v8, v5, v13, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v8, v12, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-interface v8, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v12
    if-nez v12, +010h
    invoke-interface v8, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v12
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    invoke-static v12, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-nez v12, +010h
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-interface v8, v12, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v8, v9, v5, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v8, v0, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v0, 1833054614
    invoke-static v2, v0, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v0, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v0, Landroidx/compose/foundation/layout/BoxScope;
    const/16 v16, 0
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v5, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v0, v2, v5, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/design/compose/TraeColors;->getTextTextWhite-0d7_KjU()J
    move-result-wide v17
    const-wide/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const-wide/16 v24, 0
    const/16 v26, 0
    const/16 v27, 0
    const-wide/16 v28, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v5, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v0, v2, v5, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/design/compose/TraeTypography;->getCaptionXsStrong()Landroidx/compose/ui/text/TextStyle;
    move-result-object v35
    const/16 v37, 0
    const/16 v38, 0
    const v39, 65530
    move-object/from16 v15, v41
    move-object/from16 v36, v2
    invoke-static/range v15 ... v39, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v8, 1
    invoke-static v0, v5, v8, v6, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewProgressHeight-D9Ej5fM()F
    move-result v4
    invoke-static v0, v4, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v21
    shr-int/lit8 v0, v3, 3
    and-int/lit8 v4, v0, 14
    and-int/lit8 v0, v0, 112
    or-int/2addr v0, v4
    shr-int/lit8 v3, v3, 9
    and-int/lit16 v4, v3, 896
    or-int/2addr v0, v4
    and-int/lit16 v3, v3, 7168
    or-int v23, v0, v3
    const/16 v24, 0
    move-wide/from16 v15, v46
    move-wide/from16 v17, v48
    move-object/from16 v19, v52
    move-object/from16 v20, v53
    move-object/from16 v22, v2
    invoke-static/range v15 ... v24, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoProgressBar(J J Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    move-object/from16 v12, v40
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v15
    if-eqz v15, +025h
    new-instance v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;
    move-object v0, v14
    move/from16 v1, v45
    move-wide/from16 v2, v46
    move-wide/from16 v4, v48
    move/from16 v6, v50
    move-object/from16 v7, v51
    move-object/from16 v8, v52
    move-object/from16 v9, v53
    move-object/from16 v10, v54
    move-object/from16 v11, v55
    move/from16 v13, v58
    move-object/from16 v44, v14
    move/from16 v14, v59
    invoke-direct/range v0 ... v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda10;-><init>(Z J J F Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; I I)V
    move-object/from16 v0, v44
    invoke-interface v15, v0, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final VideoPlaybackControls$lambda$83$lambda$82$lambda$69$lambda$68(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->tryHandle(Lkotlin/jvm/functions/Function0;)Z
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final VideoPlaybackControls$lambda$83$lambda$82$lambda$81$lambda$80$lambda$75$lambda$74(androidx.compose.ui.unit.Density  kotlin.jvm.functions.Function1  com.bytedance.trae.design.compose.TraeDimens  androidx.compose.ui.layout.LayoutCoordinates)kotlin.Unit
    .registers 12
    # ins_size=4
    const-string v0, "coordinates"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v11, Landroidx/compose/ui/layout/LayoutCoordinatesKt;->positionInRoot(Landroidx/compose/ui/layout/LayoutCoordinates;)J
    move-result-wide v0
    invoke-virtual v10, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewSpeedMenuWidth-D9Ej5fM()F
    move-result v2
    invoke-interface v8, v2, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v2
    invoke-virtual v10, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewSpeedMenuItemHeight-D9Ej5fM()F
    move-result v3
    invoke-interface v8, v3, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v3
    sget-object v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->PlaybackSpeeds Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    int-to-float v4, v4
    mul-float/2addr v3, v4
    const/high16 v4, 1073741824
    div-float/2addr v3, v4
    invoke-virtual v10, Lcom/bytedance/trae/design/compose/TraeDimens;->getContextMenuVerticalPadding-D9Ej5fM()F
    move-result v5
    invoke-virtual v10, Lcom/bytedance/trae/design/compose/TraeDimens;->getContextMenuDividerHeight-D9Ej5fM()F
    move-result v6
    sub-float/2addr v5, v6
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    invoke-virtual v10, Lcom/bytedance/trae/design/compose/TraeDimens;->getContextMenuDividerHeight-D9Ej5fM()F
    move-result v10
    sub-float/2addr v5, v10
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v10
    invoke-interface v8, v10, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v8
    const/16 v10, 32
    shr-long v5, v0, v10
    long-to-int v5, v5
    invoke-static v5, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v5
    invoke-interface v11, Landroidx/compose/ui/layout/LayoutCoordinates;->getSize-YbymL2g()J
    move-result-wide v6
    shr-long/2addr v6, v10
    long-to-int v11, v6
    int-to-float v11, v11
    add-float/2addr v5, v11
    div-float/2addr v2, v4
    sub-float/2addr v5, v2
    const-wide v6, 4294967295
    and-long/2addr v0, v6
    long-to-int v11, v0
    invoke-static v11, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v11
    sub-float/2addr v11, v8
    sub-float/2addr v11, v3
    invoke-static v5, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v8
    int-to-long v0, v8
    invoke-static v11, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v8
    int-to-long v2, v8
    shl-long v10, v0, v10
    and-long v0, v2, v6
    or-long/2addr v10, v0
    invoke-static v10, v11, Landroidx/compose/ui/geometry/Offset;->constructor-impl(J)J
    move-result-wide v10
    invoke-static v10, v11, Landroidx/compose/ui/geometry/Offset;->box-impl(J)Landroidx/compose/ui/geometry/Offset;
    move-result-object v8
    invoke-interface v9, v8, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method

.method private static final VideoPlaybackControls$lambda$83$lambda$82$lambda$81$lambda$80$lambda$78$lambda$77(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->tryHandle(Lkotlin/jvm/functions/Function0;)Z
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final VideoPlaybackControls$lambda$84(boolean  long  long  float  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 32
    # ins_size=16
    or-int/lit8 v0, v28, 1
    invoke-static v0, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v14
    move/from16 v1, v16
    move-wide/from16 v2, v17
    move-wide/from16 v4, v19
    move/from16 v6, v21
    move-object/from16 v7, v22
    move-object/from16 v8, v23
    move-object/from16 v9, v24
    move-object/from16 v10, v25
    move-object/from16 v11, v26
    move-object/from16 v12, v27
    move-object/from16 v13, v30
    move/from16 v15, v29
    invoke-static/range v1 ... v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoPlaybackControls(Z J J F Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final VideoProgressBar(long  long  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  androidx.compose.runtime.Composer  int  int)void
    .registers 36
    # ins_size=10
    move-wide/from16 v1, v26
    move-wide/from16 v9, v28
    move-object/from16 v11, v31
    move/from16 v12, v34
    const v0, -1419374183
    move-object/from16 v3, v33
    invoke-interface v3, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v13
    and-int/lit8 v3, v35, 1
    const/4 v4, 2
    if-eqz v3, +005h
    or-int/lit8 v3, v12, 6
    goto +11h
    and-int/lit8 v3, v12, 6
    if-nez v3, +00dh
    invoke-interface v13, v1, v2, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 4
    goto +2h
    move v3, v4
    or-int/2addr v3, v12
    goto +2h
    move v3, v12
    and-int/lit8 v5, v35, 2
    if-eqz v5, +005h
    or-int/lit8 v3, v3, 48
    goto +11h
    and-int/lit8 v5, v12, 48
    if-nez v5, +00eh
    invoke-interface v13, v9, v10, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v5
    if-eqz v5, +005h
    const/16 v5, 32
    goto +3h
    const/16 v5, 16
    or-int/2addr v3, v5
    and-int/lit8 v5, v35, 4
    if-eqz v5, +007h
    or-int/lit16 v3, v3, 384
    move-object/from16 v14, v30
    goto +13h
    and-int/lit16 v5, v12, 384
    move-object/from16 v14, v30
    if-nez v5, +00eh
    invoke-interface v13, v14, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +005h
    const/16 v5, 256
    goto +3h
    const/16 v5, 128
    or-int/2addr v3, v5
    and-int/lit8 v5, v35, 8
    if-eqz v5, +005h
    or-int/lit16 v3, v3, 3072
    goto +11h
    and-int/lit16 v5, v12, 3072
    if-nez v5, +00eh
    invoke-interface v13, v11, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +005h
    const/16 v5, 2048
    goto +3h
    const/16 v5, 1024
    or-int/2addr v3, v5
    and-int/lit8 v5, v35, 16
    if-eqz v5, +005h
    or-int/lit16 v3, v3, 24576
    goto +15h
    and-int/lit16 v15, v12, 24576
    if-nez v15, +012h
    move-object/from16 v15, v32
    invoke-interface v13, v15, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v16
    if-eqz v16, +005h
    const/16 v16, 16384
    goto +3h
    const/16 v16, 8192
    or-int v3, v3, v16
    goto +3h
    move-object/from16 v15, v32
    and-int/lit16 v7, v3, 9363
    const/16 v6, 9362
    if-ne v7, v6, +00fh
    invoke-interface v13, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v6
    if-nez v6, +003h
    goto +7h
    invoke-interface v13, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object v7, v15
    goto/16 +16eh
    if-eqz v5, +007h
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    move-object v15, v5
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v5
    if-eqz v5, +008h
    const/4 v5, -1
    const-string v6, "com.bytedance.trae.kmp.artifacts.video.VideoProgressBar (VideoArtifactPreview.kt:699)"
    invoke-static v0, v3, v5, v6, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v5, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v0, v13, v5, Lcom/bytedance/trae/design/compose/TraeTheme;->getDimens(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v0
    const-wide/16 v5, 0
    cmp-long v5, v9, v5
    const/4 v6, 0
    if-lez v5, +00dh
    long-to-float v5, v1
    long-to-float v7, v9
    div-float/2addr v5, v7
    const/high16 v7, 1065353216
    invoke-static v5, v6, v7, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v5
    move v7, v5
    goto +2h
    move v7, v6
    const v5, -512929458
    invoke-interface v13, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v13, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v5
    sget-object v6, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v6, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v6
    if-ne v5, v6, +00eh
    invoke-static/range v26 ... v27, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    const/4 v6, 0
    invoke-static v5, v6, v4, v6, Landroidx/compose/runtime/SnapshotStateKt;->mutableStateOf$default(Ljava/lang/Object; Landroidx/compose/runtime/SnapshotMutationPolicy; I Ljava/lang/Object;)Landroidx/compose/runtime/MutableState;
    move-result-object v5
    invoke-interface v13, v5, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v17, v5
    check-cast v17, Landroidx/compose/runtime/MutableState;
    invoke-interface v13, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    sget-object v4, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v5, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v4, v13, v5, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeColors;->getSpecialWhite-0d7_KjU()J
    move-result-wide v18
    const v20, 1045220557
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 14
    const/16 v25, 0
    invoke-static/range v18 ... v25, Landroidx/compose/ui/graphics/Color;->copy-wmQWz5c$default(J F F F F I Ljava/lang/Object;)J
    move-result-wide v5
    sget-object v4, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v8, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v4, v13, v8, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeColors;->getBgBgWhite-0d7_KjU()J
    move-result-wide v1
    invoke-static/range v28 ... v29, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v4
    const v8, -512915342
    invoke-interface v13, v8, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    and-int/lit16 v8, v3, 7168
    const/16 v19, 1
    const/16 v12, 2048
    if-ne v8, v12, +005h
    move/from16 v12, v19
    goto +2h
    const/4 v12, 0
    move-wide/from16 v20, v5
    and-int/lit8 v5, v3, 112
    const/16 v6, 32
    if-ne v5, v6, +005h
    move/from16 v6, v19
    goto +2h
    const/4 v6, 0
    or-int/2addr v6, v12
    invoke-interface v13, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v12
    if-nez v6, +00ah
    sget-object v6, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v6, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v6
    if-ne v12, v6, +00dh
    new-instance v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1;
    invoke-direct v6, v11, v9, v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1;-><init>(Lkotlin/jvm/functions/Function1; J)V
    move-object v12, v6
    check-cast v12, Landroidx/compose/ui/input/pointer/PointerInputEventHandler;
    invoke-interface v13, v12, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v12, Landroidx/compose/ui/input/pointer/PointerInputEventHandler;
    invoke-interface v13, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v15, v4, v12, Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilterKt;->pointerInput(Landroidx/compose/ui/Modifier; Ljava/lang/Object; Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)Landroidx/compose/ui/Modifier;
    move-result-object v12
    invoke-static/range v28 ... v29, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v6
    const v4, -512909199
    invoke-interface v13, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const/16 v4, 32
    if-ne v5, v4, +005h
    move/from16 v4, v19
    goto +2h
    const/4 v4, 0
    and-int/lit16 v3, v3, 896
    const/16 v5, 256
    if-ne v3, v5, +005h
    move/from16 v3, v19
    goto +2h
    const/4 v3, 0
    or-int/2addr v3, v4
    const/16 v4, 2048
    if-ne v8, v4, +003h
    goto +3h
    const/16 v19, 0
    or-int v3, v3, v19
    invoke-interface v13, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v4
    if-nez v3, +010h
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v4, v3, +003h
    goto +6h
    move-object v14, v6
    move v11, v7
    move-wide/from16 v9, v20
    goto +1ch
    new-instance v16, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;
    move-object/from16 v3, v16
    move-object/from16 v4, v30
    move-object v8, v6
    move-wide/from16 v9, v20
    move-wide/from16 v5, v28
    move v11, v7
    move-object/from16 v7, v17
    move-object v14, v8
    move-object/from16 v8, v31
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;-><init>(Lkotlin/jvm/functions/Function1; J Landroidx/compose/runtime/MutableState; Lkotlin/jvm/functions/Function1;)V
    move-object/from16 v4, v16
    check-cast v4, Landroidx/compose/ui/input/pointer/PointerInputEventHandler;
    invoke-interface v13, v4, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v4, Landroidx/compose/ui/input/pointer/PointerInputEventHandler;
    invoke-interface v13, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v12, v14, v4, Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilterKt;->pointerInput(Landroidx/compose/ui/Modifier; Ljava/lang/Object; Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    const v4, -512889411
    invoke-interface v13, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v13, v0, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v4
    invoke-interface v13, v11, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v5
    or-int/2addr v4, v5
    invoke-interface v13, v9, v10, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v5
    or-int/2addr v4, v5
    invoke-interface v13, v1, v2, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v5
    or-int/2addr v4, v5
    invoke-interface v13, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v5
    if-nez v4, +00ah
    sget-object v4, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v4, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v4
    if-ne v5, v4, +014h
    new-instance v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda12;
    move-object/from16 v17, v5
    move-object/from16 v18, v0
    move/from16 v19, v11
    move-wide/from16 v20, v9
    move-wide/from16 v22, v1
    invoke-direct/range v17 ... v23, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/design/compose/TraeDimens; F J J)V
    invoke-interface v13, v5, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v5, Lkotlin/jvm/functions/Function1;
    invoke-interface v13, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/4 v0, 0
    invoke-static v3, v5, v13, v0, Landroidx/compose/foundation/CanvasKt;->Canvas(Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/Composer; I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, -168h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    goto/16 -16dh
    invoke-interface v13, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v10
    if-eqz v10, +017h
    new-instance v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;
    move-object v0, v11
    move-wide/from16 v1, v26
    move-wide/from16 v3, v28
    move-object/from16 v5, v30
    move-object/from16 v6, v31
    move/from16 v8, v34
    move/from16 v9, v35
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda13;-><init>(J J Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; I I)V
    invoke-interface v10, v11, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final VideoProgressBar$lambda$86(androidx.compose.runtime.MutableState)long
    .registers 3
    # ins_size=1
    check-cast v2, Landroidx/compose/runtime/State;
    invoke-interface v2, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    return-wide v0
.end method

.method private static final VideoProgressBar$lambda$87(androidx.compose.runtime.MutableState  long)void
    .registers 3
    # ins_size=3
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    invoke-interface v0, v1, Landroidx/compose/runtime/MutableState;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final VideoProgressBar$lambda$91$lambda$90(com.bytedance.trae.design.compose.TraeDimens  float  long  long  androidx.compose.ui.graphics.drawscope.DrawScope)kotlin.Unit
    .registers 34
    # ins_size=7
    move-object/from16 v15, v33
    const-string v0, "$this$Canvas"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v27, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewProgressHorizontalInset-D9Ej5fM()F
    move-result v0
    invoke-interface v15, v0, Landroidx/compose/ui/graphics/drawscope/DrawScope;->toPx-0680j_4(F)F
    move-result v14
    invoke-virtual/range v27, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewProgressTrackHeight-D9Ej5fM()F
    move-result v0
    invoke-interface v15, v0, Landroidx/compose/ui/graphics/drawscope/DrawScope;->toPx-0680j_4(F)F
    move-result v16
    invoke-virtual/range v27, Lcom/bytedance/trae/design/compose/TraeDimens;->getVideoPreviewProgressThumbSize-D9Ej5fM()F
    move-result v0
    invoke-interface v15, v0, Landroidx/compose/ui/graphics/drawscope/DrawScope;->toPx-0680j_4(F)F
    move-result v0
    const/high16 v1, 1073741824
    div-float v17, v0, v1
    invoke-interface/range v33, Landroidx/compose/ui/graphics/drawscope/DrawScope;->getSize-NH-jbRc()J
    move-result-wide v2
    const/16 v18, 32
    shr-long v2, v2, v18
    long-to-int v0, v2
    invoke-static v0, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v0
    sub-float/2addr v0, v14
    invoke-static v0, v14, Lkotlin/ranges/RangesKt;->coerceAtLeast(F F)F
    move-result v0
    sub-float/2addr v0, v14
    mul-float v2, v0, v28
    add-float v19, v14, v2
    invoke-interface/range v33, Landroidx/compose/ui/graphics/drawscope/DrawScope;->getSize-NH-jbRc()J
    move-result-wide v2
    const-wide v20, 4294967295
    and-long v2, v2, v20
    long-to-int v2, v2
    invoke-static v2, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v2
    div-float v22, v2, v1
    div-float v23, v16, v1
    sub-float v24, v22, v23
    invoke-static v14, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v1
    int-to-long v1, v1
    invoke-static/range v24, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v3
    int-to-long v3, v3
    shl-long v1, v1, v18
    and-long v3, v3, v20
    or-long/2addr v1, v3
    invoke-static v1, v2, Landroidx/compose/ui/geometry/Offset;->constructor-impl(J)J
    move-result-wide v3
    invoke-static v0, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v0
    int-to-long v0, v0
    invoke-static/range v16, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v2
    int-to-long v5, v2
    shl-long v0, v0, v18
    and-long v5, v5, v20
    or-long/2addr v0, v5
    invoke-static v0, v1, Landroidx/compose/ui/geometry/Size;->constructor-impl(J)J
    move-result-wide v5
    invoke-static/range v23, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v0
    int-to-long v0, v0
    invoke-static/range v23, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v2
    int-to-long v7, v2
    shl-long v0, v0, v18
    and-long v7, v7, v20
    or-long/2addr v0, v7
    invoke-static v0, v1, Landroidx/compose/ui/geometry/CornerRadius;->constructor-impl(J)J
    move-result-wide v7
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 240
    const/16 v25, 0
    move-object/from16 v0, v33
    move-wide/from16 v1, v29
    move/from16 v26, v14
    move-object/from16 v14, v25
    invoke-static/range v0 ... v14, Landroidx/compose/ui/graphics/drawscope/DrawScope;->drawRoundRect-u-Aw5IA$default(Landroidx/compose/ui/graphics/drawscope/DrawScope; J J J J Landroidx/compose/ui/graphics/drawscope/DrawStyle; F Landroidx/compose/ui/graphics/ColorFilter; I I Ljava/lang/Object;)V
    invoke-static/range v26, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v0
    int-to-long v0, v0
    invoke-static/range v24, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v2
    int-to-long v2, v2
    shl-long v0, v0, v18
    and-long v2, v2, v20
    or-long/2addr v0, v2
    invoke-static v0, v1, Landroidx/compose/ui/geometry/Offset;->constructor-impl(J)J
    move-result-wide v3
    sub-float v0, v19, v26
    const/4 v1, 0
    invoke-static v0, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(F F)F
    move-result v0
    invoke-static v0, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v0
    int-to-long v0, v0
    invoke-static/range v16, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v2
    int-to-long v5, v2
    shl-long v0, v0, v18
    and-long v5, v5, v20
    or-long/2addr v0, v5
    invoke-static v0, v1, Landroidx/compose/ui/geometry/Size;->constructor-impl(J)J
    move-result-wide v5
    invoke-static/range v23, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v0
    int-to-long v0, v0
    invoke-static/range v23, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v2
    int-to-long v7, v2
    shl-long v0, v0, v18
    and-long v7, v7, v20
    or-long/2addr v0, v7
    invoke-static v0, v1, Landroidx/compose/ui/geometry/CornerRadius;->constructor-impl(J)J
    move-result-wide v7
    const/4 v14, 0
    move-object/from16 v0, v33
    move-wide/from16 v1, v31
    invoke-static/range v0 ... v14, Landroidx/compose/ui/graphics/drawscope/DrawScope;->drawRoundRect-u-Aw5IA$default(Landroidx/compose/ui/graphics/drawscope/DrawScope; J J J J Landroidx/compose/ui/graphics/drawscope/DrawStyle; F Landroidx/compose/ui/graphics/ColorFilter; I I Ljava/lang/Object;)V
    invoke-static/range v19, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v0
    int-to-long v0, v0
    invoke-static/range v22, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v2
    int-to-long v2, v2
    shl-long v0, v0, v18
    and-long v2, v2, v20
    or-long/2addr v0, v2
    invoke-static v0, v1, Landroidx/compose/ui/geometry/Offset;->constructor-impl(J)J
    move-result-wide v4
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 120
    move-object/from16 v0, v33
    move-wide/from16 v1, v31
    move/from16 v3, v17
    invoke-static/range v0 ... v11, Landroidx/compose/ui/graphics/drawscope/DrawScope;->drawCircle-VaOC9Bg$default(Landroidx/compose/ui/graphics/drawscope/DrawScope; J F J F Landroidx/compose/ui/graphics/drawscope/DrawStyle; Landroidx/compose/ui/graphics/ColorFilter; I I Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final VideoProgressBar$lambda$92(long  long  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 22
    # ins_size=11
    or-int/lit8 v0, v18, 1
    invoke-static v0, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v9
    move-wide v1, v11
    move-wide v3, v13
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v20
    move/from16 v10, v19
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoProgressBar(J J Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final VideoProgressBar$targetFor(long  float  int)long
    .registers 7
    # ins_size=4
    const-wide/16 v0, 0
    cmp-long v2, v3, v0
    if-lez v2, +012h
    if-gtz v6, +003h
    goto +eh
    long-to-float v3, v3
    int-to-float v4, v6
    div-float/2addr v5, v4
    const/4 v4, 0
    const/high16 v6, 1065353216
    invoke-static v5, v4, v6, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v4
    mul-float/2addr v3, v4
    float-to-long v3, v3
    return-wide v3
    return-wide v0
.end method

.method public static final synthetic access$VideoArtifactPreviewScreen$lambda$1(androidx.compose.runtime.MutableFloatState)float
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$1(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v0
    return v0
.end method

.method public static final synthetic access$VideoArtifactPreviewScreen$lambda$2(androidx.compose.runtime.MutableFloatState  float)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$2(Landroidx/compose/runtime/MutableFloatState; F)V
    return-void 
.end method

.method public static final synthetic access$VideoArtifactPreviewScreen$lambda$4(androidx.compose.runtime.MutableState)kotlinx.coroutines.Job
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$4(Landroidx/compose/runtime/MutableState;)Lkotlinx/coroutines/Job;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$VideoArtifactPreviewScreen$lambda$5(androidx.compose.runtime.MutableState  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$5(Landroidx/compose/runtime/MutableState; Lkotlinx/coroutines/Job;)V
    return-void 
.end method

.method public static final synthetic access$VideoArtifactPreviewScreen$lambda$6(androidx.compose.runtime.State)kotlin.jvm.functions.Function0
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen$lambda$6(Landroidx/compose/runtime/State;)Lkotlin/jvm/functions/Function0;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$VideoProgressBar$lambda$86(androidx.compose.runtime.MutableState)long
    .registers 3
    # ins_size=1
    invoke-static v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoProgressBar$lambda$86(Landroidx/compose/runtime/MutableState;)J
    move-result-wide v0
    return-wide v0
.end method

.method public static final synthetic access$VideoProgressBar$lambda$87(androidx.compose.runtime.MutableState  long)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoProgressBar$lambda$87(Landroidx/compose/runtime/MutableState; J)V
    return-void 
.end method

.method public static final synthetic access$VideoProgressBar$targetFor(long  float  int)long
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoProgressBar$targetFor(J F I)J
    move-result-wide v0
    return-wide v0
.end method

.method private static final createVideoArtifactEngine(java.lang.String)com.bytedance.vcloud.uniplayer.UniAVEngine
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/vcloud/uniplayer/UniAbConfig;->Companion Lcom/bytedance/vcloud/uniplayer/UniAbConfig$Companion;
    invoke-virtual v0, Lcom/bytedance/vcloud/uniplayer/UniAbConfig$Companion;->create()Lcom/bytedance/vcloud/uniplayer/UniAbConfig;
    move-result-object v0
    sget-object v1, Lcom/bytedance/vcloud/uniplayer/UniAbKey;->USE_LOCK_TT_NOTIFIER Lcom/bytedance/vcloud/uniplayer/UniAbKey;
    const/4 v2, 1
    invoke-interface v0, v1, v2, Lcom/bytedance/vcloud/uniplayer/UniAbConfig;->setUniAbKv(Lcom/bytedance/vcloud/uniplayer/UniAbKey; I)V
    sget-object v1, Lcom/bytedance/vcloud/uniplayer/UniInstConfig;->Companion Lcom/bytedance/vcloud/uniplayer/UniInstConfig$Companion;
    invoke-virtual v1, Lcom/bytedance/vcloud/uniplayer/UniInstConfig$Companion;->create()Lcom/bytedance/vcloud/uniplayer/UniInstConfig;
    move-result-object v1
    sget-object v2, Lcom/bytedance/vcloud/uniplayer/InstIntKey;->POSITION_UPDATE_INTERVAL Lcom/bytedance/vcloud/uniplayer/InstIntKey;
    const/16 v3, 1000
    invoke-interface v1, v2, v3, Lcom/bytedance/vcloud/uniplayer/UniInstConfig;->setIntValue(Lcom/bytedance/vcloud/uniplayer/InstIntKey; I)V
    sget-object v2, Lcom/bytedance/vcloud/uniplayer/UniAVEngine;->Companion Lcom/bytedance/vcloud/uniplayer/UniAVEngine$Companion;
    invoke-virtual v2, v4, v0, v1, Lcom/bytedance/vcloud/uniplayer/UniAVEngine$Companion;->create(Ljava/lang/String; Lcom/bytedance/vcloud/uniplayer/UniAbConfig; Lcom/bytedance/vcloud/uniplayer/UniInstConfig;)Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    move-result-object v4
    invoke-interface v0, Lcom/bytedance/vcloud/uniplayer/UniAbConfig;->close()V
    return-object v4
    move-exception v4
    invoke-interface v0, Lcom/bytedance/vcloud/uniplayer/UniAbConfig;->close()V
    throw v4
    :try_start_0x19
.end method

.method private static final formatMenuSpeed(float)java.lang.String
    .registers 3
    # ins_size=1
    const/high16 v0, 1065353216
    rem-float v0, v2, v0
    const/4 v1, 0
    cmpg-float v0, v0, v1
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +017h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    float-to-int v2, v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v0, ".0"
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    goto +5h
    invoke-static v2, Ljava/lang/String;->valueOf(F)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method private static final formatSpeed(float)java.lang.String
    .registers 3
    # ins_size=1
    const/high16 v0, 1065353216
    rem-float v0, v2, v0
    const/4 v1, 0
    cmpg-float v0, v0, v1
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +008h
    float-to-int v2, v2
    invoke-static v2, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v2
    goto +5h
    invoke-static v2, Ljava/lang/String;->valueOf(F)Ljava/lang/String;
    move-result-object v2
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v0, 120
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method private static final formatTime(long)java.lang.String
    .registers 6
    # ins_size=2
    const-wide/16 v0, 0
    invoke-static v4, v5, v0, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v4
    const-wide/16 v0, 1000
    div-long/2addr v4, v0
    const-wide/16 v0, 60
    div-long v2, v4, v0
    rem-long/2addr v4, v0
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v2, v3, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v1
    const/4 v2, 2
    const/16 v3, 48
    invoke-static v1, v2, v3, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String; I C)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 58
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static v4, v5, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v2, v3, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String; I C)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method
