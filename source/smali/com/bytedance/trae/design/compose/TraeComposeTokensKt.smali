# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;
.super Ljava/lang/Object;
.source "TraeComposeTokens.kt"

.field private static final LocalTraeColors:Landroidx/compose/runtime/ProvidableCompositionLocal;
.field private static final LocalTraeDimens:Landroidx/compose/runtime/ProvidableCompositionLocal;
.field private static final LocalTraeTypography:Landroidx/compose/runtime/ProvidableCompositionLocal;


.method public static synthetic $r8$lambda$1peX1gBA7tL5rDV9evznm19356I()com.bytedance.trae.design.compose.TraeColors
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeColors$lambda$0()Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Om_GvhWllxtMLxfTQB3_xl5TNj8(boolean  kotlin.jvm.functions.Function2  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->TraeDesignTheme$lambda$3(Z Lkotlin/jvm/functions/Function2; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$c93HptntiDSP6KjIippNib6CVIE()com.bytedance.trae.design.compose.TraeTypography
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeTypography$lambda$1()Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$olzKYVdkUTGgFsqk8kW3SEQ0UQI()com.bytedance.trae.design.compose.TraeDimens
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeDimens$lambda$2()Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Landroidx/compose/runtime/CompositionLocalKt;->staticCompositionLocalOf(Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/ProvidableCompositionLocal;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeColors Landroidx/compose/runtime/ProvidableCompositionLocal;
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, Landroidx/compose/runtime/CompositionLocalKt;->staticCompositionLocalOf(Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/ProvidableCompositionLocal;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeTypography Landroidx/compose/runtime/ProvidableCompositionLocal;
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda2;
    invoke-direct v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v0, Landroidx/compose/runtime/CompositionLocalKt;->staticCompositionLocalOf(Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/ProvidableCompositionLocal;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeDimens Landroidx/compose/runtime/ProvidableCompositionLocal;
    return-void 
.end method

.method private static final LocalTraeColors$lambda$0()com.bytedance.trae.design.compose.TraeColors
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeColorTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeColorTokens;
    invoke-virtual v0, Lcom/bytedance/trae/design/compose/TraeColorTokens;->getLight()Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v0
    return-object v0
.end method

.method private static final LocalTraeDimens$lambda$2()com.bytedance.trae.design.compose.TraeDimens
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeDimenTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeDimenTokens;
    invoke-virtual v0, Lcom/bytedance/trae/design/compose/TraeDimenTokens;->getDefault()Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v0
    return-object v0
.end method

.method private static final LocalTraeTypography$lambda$1()com.bytedance.trae.design.compose.TraeTypography
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeTypographyTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTypographyTokens;
    invoke-virtual v0, Lcom/bytedance/trae/design/compose/TraeTypographyTokens;->getDefault()Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v0
    return-object v0
.end method

.method public static final TraeDesignTheme(boolean  kotlin.jvm.functions.Function2  androidx.compose.runtime.Composer  int  int)void
    .registers 11
    # ins_size=5
    const-string v0, "content"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, -1406825424
    invoke-interface v8, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v8
    and-int/lit8 v1, v9, 6
    const/4 v2, 2
    if-nez v1, +011h
    and-int/lit8 v1, v10, 1
    if-nez v1, +00ah
    invoke-interface v8, v6, Landroidx/compose/runtime/Composer;->changed(Z)Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 4
    goto +2h
    move v1, v2
    or-int/2addr v1, v9
    goto +2h
    move v1, v9
    and-int/lit8 v3, v10, 2
    if-eqz v3, +005h
    or-int/lit8 v1, v1, 48
    goto +11h
    and-int/lit8 v3, v9, 48
    if-nez v3, +00eh
    invoke-interface v8, v7, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    const/16 v3, 32
    goto +3h
    const/16 v3, 16
    or-int/2addr v1, v3
    and-int/lit8 v3, v1, 19
    const/16 v4, 18
    if-ne v3, v4, +00eh
    invoke-interface v8, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v3
    if-nez v3, +003h
    goto +6h
    invoke-interface v8, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +078h
    invoke-interface v8, Landroidx/compose/runtime/Composer;->startDefaults()V
    and-int/lit8 v3, v9, 1
    const/4 v4, 0
    if-eqz v3, +011h
    invoke-interface v8, Landroidx/compose/runtime/Composer;->getDefaultsInvalid()Z
    move-result v3
    if-eqz v3, +003h
    goto +9h
    invoke-interface v8, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    and-int/lit8 v3, v10, 1
    if-eqz v3, +00dh
    goto +9h
    and-int/lit8 v3, v10, 1
    if-eqz v3, +008h
    invoke-static v8, v4, Landroidx/compose/foundation/DarkThemeKt;->isSystemInDarkTheme(Landroidx/compose/runtime/Composer; I)Z
    move-result v6
    and-int/lit8 v1, v1, -15
    invoke-interface v8, Landroidx/compose/runtime/Composer;->endDefaults()V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v3
    if-eqz v3, +008h
    const/4 v3, -1
    const-string v5, "com.bytedance.trae.design.compose.TraeDesignTheme (TraeComposeTokens.kt:1412)"
    invoke-static v0, v1, v3, v5, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const/4 v0, 3
    new-array v0, v0, [Landroidx/compose/runtime/ProvidedValue;
    sget-object v3, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeColors Landroidx/compose/runtime/ProvidableCompositionLocal;
    sget-object v5, Lcom/bytedance/trae/design/compose/TraeColorTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeColorTokens;
    if-eqz v6, +007h
    invoke-virtual v5, Lcom/bytedance/trae/design/compose/TraeColorTokens;->getDark()Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v5
    goto +5h
    invoke-virtual v5, Lcom/bytedance/trae/design/compose/TraeColorTokens;->getLight()Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v5
    invoke-virtual v3, v5, Landroidx/compose/runtime/ProvidableCompositionLocal;->provides(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;
    move-result-object v3
    aput-object v3, v0, v4
    sget-object v3, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeTypography Landroidx/compose/runtime/ProvidableCompositionLocal;
    sget-object v4, Lcom/bytedance/trae/design/compose/TraeTypographyTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTypographyTokens;
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeTypographyTokens;->getDefault()Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v4
    invoke-virtual v3, v4, Landroidx/compose/runtime/ProvidableCompositionLocal;->provides(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;
    move-result-object v3
    const/4 v4, 1
    aput-object v3, v0, v4
    sget-object v3, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeDimens Landroidx/compose/runtime/ProvidableCompositionLocal;
    sget-object v4, Lcom/bytedance/trae/design/compose/TraeDimenTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeDimenTokens;
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeDimenTokens;->getDefault()Lcom/bytedance/trae/design/compose/TraeDimens;
    move-result-object v4
    invoke-virtual v3, v4, Landroidx/compose/runtime/ProvidableCompositionLocal;->provides(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;
    move-result-object v3
    aput-object v3, v0, v2
    sget v2, Landroidx/compose/runtime/ProvidedValue;->$stable I
    and-int/lit8 v1, v1, 112
    or-int/2addr v1, v2
    invoke-static v0, v7, v8, v1, Landroidx/compose/runtime/CompositionLocalKt;->CompositionLocalProvider([Landroidx/compose/runtime/ProvidedValue; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v8, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v8
    if-eqz v8, +00ah
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda3;
    invoke-direct v0, v6, v7, v9, v10, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt$$ExternalSyntheticLambda3;-><init>(Z Lkotlin/jvm/functions/Function2; I I)V
    invoke-interface v8, v0, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final TraeDesignTheme$lambda$3(boolean  kotlin.jvm.functions.Function2  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    or-int/lit8 v2, v2, 1
    invoke-static v2, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v2
    invoke-static v0, v1, v4, v2, v3, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->TraeDesignTheme(Z Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static final getLocalTraeColors()androidx.compose.runtime.ProvidableCompositionLocal
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeColors Landroidx/compose/runtime/ProvidableCompositionLocal;
    return-object v0
.end method

.method public static final getLocalTraeDimens()androidx.compose.runtime.ProvidableCompositionLocal
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeDimens Landroidx/compose/runtime/ProvidableCompositionLocal;
    return-object v0
.end method

.method public static final getLocalTraeTypography()androidx.compose.runtime.ProvidableCompositionLocal
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeComposeTokensKt;->LocalTraeTypography Landroidx/compose/runtime/ProvidableCompositionLocal;
    return-object v0
.end method
