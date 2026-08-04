# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeTheme;
.super Ljava/lang/Object;
.source "TraeComposeTokens.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/design/compose/TraeTheme;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeTheme;
    invoke-direct v0, Lcom/bytedance/trae/design/compose/TraeTheme;-><init>()V
    sput-object v0, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getColors(androidx.compose.runtime.Composer  int)com.bytedance.trae.design.compose.TraeColors
    .registers 6
    # ins_size=3
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +00bh
    const/4 v0, -1
    const-string v1, "com.bytedance.trae.design.compose.TraeTheme.<get-colors> (TraeComposeTokens.kt:1425)"
    const v2, -204283094
    invoke-static v2, v5, v0, v1, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->getLocalTraeColors()Landroidx/compose/runtime/ProvidableCompositionLocal;
    move-result-object v5
    check-cast v5, Landroidx/compose/runtime/CompositionLocal;
    const v0, 2023513938
    const-string v1, "CC(<get-current>):CompositionLocal.kt#9igjgp"
    invoke-static v4, v0, v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v4, v5, Landroidx/compose/runtime/Composer;->consume(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v4, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    check-cast v5, Lcom/bytedance/trae/design/compose/TraeColors;
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    return-object v5
.end method

.method public final getDimens(androidx.compose.runtime.Composer  int)com.bytedance.trae.design.compose.TraeDimens
    .registers 6
    # ins_size=3
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +00bh
    const/4 v0, -1
    const-string v1, "com.bytedance.trae.design.compose.TraeTheme.<get-dimens> (TraeComposeTokens.kt:1435)"
    const v2, 133588956
    invoke-static v2, v5, v0, v1, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->getLocalTraeDimens()Landroidx/compose/runtime/ProvidableCompositionLocal;
    move-result-object v5
    check-cast v5, Landroidx/compose/runtime/CompositionLocal;
    const v0, 2023513938
    const-string v1, "CC(<get-current>):CompositionLocal.kt#9igjgp"
    invoke-static v4, v0, v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v4, v5, Landroidx/compose/runtime/Composer;->consume(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v4, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    check-cast v5, Lcom/bytedance/trae/design/compose/TraeDimens;
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    return-object v5
.end method

.method public final getTypography(androidx.compose.runtime.Composer  int)com.bytedance.trae.design.compose.TraeTypography
    .registers 6
    # ins_size=3
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +00bh
    const/4 v0, -1
    const-string v1, "com.bytedance.trae.design.compose.TraeTheme.<get-typography> (TraeComposeTokens.kt:1430)"
    const v2, 595971209
    invoke-static v2, v5, v0, v1, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->getLocalTraeTypography()Landroidx/compose/runtime/ProvidableCompositionLocal;
    move-result-object v5
    check-cast v5, Landroidx/compose/runtime/CompositionLocal;
    const v0, 2023513938
    const-string v1, "CC(<get-current>):CompositionLocal.kt#9igjgp"
    invoke-static v4, v0, v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v4, v5, Landroidx/compose/runtime/Composer;->consume(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v4, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    check-cast v5, Lcom/bytedance/trae/design/compose/TraeTypography;
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    return-object v5
.end method
