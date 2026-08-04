# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeTypographyTokens;
.super Ljava/lang/Object;
.source "TraeComposeTokens.kt"

.field public static final $stable:I
.field private static final Default:Lcom/bytedance/trae/design/compose/TraeTypography;
.field public static final INSTANCE:Lcom/bytedance/trae/design/compose/TraeTypographyTokens;


.method static constructor <clinit>()void
    .registers 70
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeTypographyTokens;
    invoke-direct v0, Lcom/bytedance/trae/design/compose/TraeTypographyTokens;-><init>()V
    sput-object v0, Lcom/bytedance/trae/design/compose/TraeTypographyTokens;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTypographyTokens;
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeTypography;
    move-object v1, v0
    sget-object v2, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v2, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v3
    sget-object v2, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v2, Landroidx/compose/ui/text/font/FontWeight$Companion;->getNormal()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v9
    const/16 v36, 17
    invoke-static/range v36, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v7
    const/16 v37, 24
    invoke-static/range v37, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v26
    new-instance v4, Landroidx/compose/ui/text/TextStyle;
    move-object v2, v4
    const-wide/16 v5, 0
    const/4 v10, 0
    const/4 v11, 0
    move-object v12, v3
    check-cast v12, Landroidx/compose/ui/text/font/FontFamily;
    const/4 v13, 0
    const-wide/16 v14, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const-wide/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const v34, 16646105
    const/16 v35, 0
    invoke-direct/range v4 ... v35, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v3, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v3, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v4
    sget-object v3, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v3, Landroidx/compose/ui/text/font/FontWeight$Companion;->getMedium()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v43
    invoke-static/range v36, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v41
    invoke-static/range v37, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v60
    new-instance v38, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v3, v38
    const-wide/16 v39, 0
    const/16 v44, 0
    const/16 v45, 0
    move-object/from16 v46, v4
    check-cast v46, Landroidx/compose/ui/text/font/FontFamily;
    const/16 v47, 0
    const-wide/16 v48, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const-wide/16 v53, 0
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 0
    const/16 v58, 0
    const/16 v59, 0
    const/16 v62, 0
    const/16 v63, 0
    const/16 v64, 0
    const/16 v65, 0
    const/16 v66, 0
    const/16 v67, 0
    const v68, 16646105
    const/16 v69, 0
    invoke-direct/range v38 ... v69, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v4, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v4, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v5
    sget-object v4, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v4, Landroidx/compose/ui/text/font/FontWeight$Companion;->getSemiBold()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v43
    invoke-static/range v36, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v41
    invoke-static/range v37, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v60
    new-instance v38, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v4, v38
    move-object/from16 v46, v5
    check-cast v46, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v38 ... v69, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v5, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v5, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v6
    sget-object v5, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v5, Landroidx/compose/ui/text/font/FontWeight$Companion;->getNormal()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    const/16 v15, 16
    invoke-static v15, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    const/16 v29, 22
    invoke-static/range v29, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v5, v37
    const-wide/16 v38, 0
    const/16 v43, 0
    move-object/from16 v45, v6
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    const/16 v46, 0
    const-wide/16 v47, 0
    const/16 v49, 0
    const-wide/16 v52, 0
    const/16 v54, 0
    const/16 v57, 0
    const/16 v61, 0
    const/16 v64, 0
    const/16 v66, 0
    const v67, 16646105
    const/16 v68, 0
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v6, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v6, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v7
    sget-object v6, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v6, Landroidx/compose/ui/text/font/FontWeight$Companion;->getMedium()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    invoke-static v15, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static/range v29, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v6, v37
    move-object/from16 v45, v7
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v7, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v7, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v8
    sget-object v7, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v7, Landroidx/compose/ui/text/font/FontWeight$Companion;->getSemiBold()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    invoke-static v15, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static/range v29, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v7, v37
    move-object/from16 v45, v8
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v8, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v8, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v9
    sget-object v8, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v8, Landroidx/compose/ui/text/font/FontWeight$Companion;->getNormal()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    const/16 v12, 15
    invoke-static v12, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    const/16 v25, 20
    invoke-static/range v25, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v8, v37
    move-object/from16 v45, v9
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v9, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v9, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v10
    sget-object v9, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v9, Landroidx/compose/ui/text/font/FontWeight$Companion;->getMedium()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    invoke-static v12, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static/range v25, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v9, v37
    move-object/from16 v45, v10
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v10, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v10, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v11
    sget-object v10, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v10, Landroidx/compose/ui/text/font/FontWeight$Companion;->getSemiBold()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    invoke-static v12, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static/range v25, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v10, v37
    move-object/from16 v45, v11
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v11, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v11, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v13
    sget-object v11, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v11, Landroidx/compose/ui/text/font/FontWeight$Companion;->getNormal()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    const/16 v14, 12
    invoke-static v14, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static v12, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v11, v37
    move-object/from16 v45, v13
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v13, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v13, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v13
    sget-object v16, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual/range v16, Landroidx/compose/ui/text/font/FontWeight$Companion;->getSemiBold()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    invoke-static v14, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static v12, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v12, v37
    move-object/from16 v45, v13
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v13, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v13, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v14
    sget-object v13, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v13, Landroidx/compose/ui/text/font/FontWeight$Companion;->getNormal()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    const/16 v16, 11
    invoke-static/range v16, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    const/16 v19, 13
    invoke-static/range v19, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v13, v37
    move-object/from16 v45, v14
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v14, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v14, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v17
    sget-object v14, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v14, Landroidx/compose/ui/text/font/FontWeight$Companion;->getSemiBold()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    invoke-static/range v16, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static/range v19, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v14, v37
    move-object/from16 v45, v17
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v16, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual/range v16, Landroidx/compose/ui/text/font/FontFamily$Companion;->getMonospace()Landroidx/compose/ui/text/font/GenericFontFamily;
    move-result-object v16
    new-instance v15, Landroidx/compose/ui/text/font/FontWeight;
    move-object/from16 v42, v15
    move-object/from16 v30, v0
    const/16 v0, 450
    invoke-direct v15, v0, Landroidx/compose/ui/text/font/FontWeight;-><init>(I)V
    const/16 v15, 16
    invoke-static v15, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static/range v29, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v15, v37
    move-object/from16 v45, v16
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v16, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual/range v16, Landroidx/compose/ui/text/font/FontFamily$Companion;->getMonospace()Landroidx/compose/ui/text/font/GenericFontFamily;
    move-result-object v17
    move-object/from16 v31, v1
    new-instance v1, Landroidx/compose/ui/text/font/FontWeight;
    move-object/from16 v42, v1
    invoke-direct v1, v0, Landroidx/compose/ui/text/font/FontWeight;-><init>(I)V
    const/16 v1, 14
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static/range v25, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v16, v37
    move-object/from16 v45, v17
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v1, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v1, Landroidx/compose/ui/text/font/FontFamily$Companion;->getMonospace()Landroidx/compose/ui/text/font/GenericFontFamily;
    move-result-object v1
    move-object/from16 v32, v2
    new-instance v2, Landroidx/compose/ui/text/font/FontWeight;
    move-object/from16 v42, v2
    invoke-direct v2, v0, Landroidx/compose/ui/text/font/FontWeight;-><init>(I)V
    invoke-static/range v19, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static/range v36, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v17, v37
    move-object/from16 v45, v1
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v1, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v1, Landroidx/compose/ui/text/font/FontWeight$Companion;->getNormal()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    invoke-static/range v19, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static/range v36, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v18, v37
    move-object/from16 v45, v0
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v1, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v1, Landroidx/compose/ui/text/font/FontWeight$Companion;->getSemiBold()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v42
    invoke-static/range v19, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v40
    invoke-static/range v36, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v59
    new-instance v37, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v19, v37
    move-object/from16 v45, v0
    check-cast v45, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v37 ... v68, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v1, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v1, Landroidx/compose/ui/text/font/FontWeight$Companion;->getNormal()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v38
    const/16 v1, 26
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v36
    const/16 v2, 32
    invoke-static v2, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v55
    new-instance v33, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v20, v33
    const-wide/16 v34, 0
    const/16 v39, 0
    const/16 v40, 0
    move-object/from16 v41, v0
    check-cast v41, Landroidx/compose/ui/text/font/FontFamily;
    const/16 v42, 0
    const-wide/16 v43, 0
    const/16 v45, 0
    const/16 v47, 0
    const-wide/16 v48, 0
    const/16 v52, 0
    const/16 v53, 0
    const/16 v54, 0
    const/16 v57, 0
    const/16 v58, 0
    const/16 v59, 0
    const/16 v60, 0
    const/16 v61, 0
    const v63, 16646105
    const/16 v64, 0
    invoke-direct/range v33 ... v64, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v21, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual/range v21, Landroidx/compose/ui/text/font/FontWeight$Companion;->getSemiBold()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v38
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v36
    invoke-static v2, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v55
    new-instance v33, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v21, v33
    move-object/from16 v41, v0
    check-cast v41, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v33 ... v64, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v22, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual/range v22, Landroidx/compose/ui/text/font/FontWeight$Companion;->getNormal()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v38
    invoke-static v2, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v36
    const/16 v23, 40
    invoke-static/range v23, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v55
    new-instance v33, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v22, v33
    move-object/from16 v41, v0
    check-cast v41, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v33 ... v64, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v24, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual/range v24, Landroidx/compose/ui/text/font/FontWeight$Companion;->getSemiBold()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v38
    invoke-static v2, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v36
    invoke-static/range v23, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v55
    new-instance v33, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v23, v33
    move-object/from16 v41, v0
    check-cast v41, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v33 ... v64, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v2, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v2, Landroidx/compose/ui/text/font/FontWeight$Companion;->getNormal()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v38
    invoke-static/range v25, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v36
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v55
    new-instance v33, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v24, v33
    move-object/from16 v41, v0
    check-cast v41, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v33 ... v64, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v2, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v2, Landroidx/compose/ui/text/font/FontWeight$Companion;->getSemiBold()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v38
    invoke-static/range v25, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v36
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v55
    new-instance v33, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v25, v33
    move-object/from16 v41, v0
    check-cast v41, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v33 ... v64, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v1, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v1, Landroidx/compose/ui/text/font/FontWeight$Companion;->getNormal()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v38
    const/16 v1, 18
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v36
    invoke-static/range v29, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v55
    new-instance v33, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v26, v33
    move-object/from16 v41, v0
    check-cast v41, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v33 ... v64, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v2, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v2, Landroidx/compose/ui/text/font/FontWeight$Companion;->getSemiBold()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v38
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v36
    invoke-static/range v29, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v55
    new-instance v33, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v27, v33
    move-object/from16 v41, v0
    check-cast v41, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v33 ... v64, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v1, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v1, Landroidx/compose/ui/text/font/FontWeight$Companion;->getNormal()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v38
    invoke-static/range v29, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v36
    const/16 v1, 28
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v55
    new-instance v33, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v28, v33
    move-object/from16 v41, v0
    check-cast v41, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v33 ... v64, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Landroidx/compose/ui/text/font/FontFamily;->Companion Landroidx/compose/ui/text/font/FontFamily$Companion;
    invoke-virtual v0, Landroidx/compose/ui/text/font/FontFamily$Companion;->getDefault()Landroidx/compose/ui/text/font/SystemFontFamily;
    move-result-object v0
    sget-object v2, Landroidx/compose/ui/text/font/FontWeight;->Companion Landroidx/compose/ui/text/font/FontWeight$Companion;
    invoke-virtual v2, Landroidx/compose/ui/text/font/FontWeight$Companion;->getSemiBold()Landroidx/compose/ui/text/font/FontWeight;
    move-result-object v38
    invoke-static/range v29, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v36
    invoke-static v1, Landroidx/compose/ui/unit/TextUnitKt;->getSp(I)J
    move-result-wide v55
    new-instance v33, Landroidx/compose/ui/text/TextStyle;
    move-object/from16 v29, v33
    move-object/from16 v41, v0
    check-cast v41, Landroidx/compose/ui/text/font/FontFamily;
    invoke-direct/range v33 ... v64, Landroidx/compose/ui/text/TextStyle;-><init>(J J Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontSynthesis; Landroidx/compose/ui/text/font/FontFamily; Ljava/lang/String; J Landroidx/compose/ui/text/style/BaselineShift; Landroidx/compose/ui/text/style/TextGeometricTransform; Landroidx/compose/ui/text/intl/LocaleList; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/graphics/Shadow; Landroidx/compose/ui/graphics/drawscope/DrawStyle; I I J Landroidx/compose/ui/text/style/TextIndent; Landroidx/compose/ui/text/PlatformTextStyle; Landroidx/compose/ui/text/style/LineHeightStyle; I I Landroidx/compose/ui/text/style/TextMotion; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v1, v31
    move-object/from16 v2, v32
    invoke-direct/range v1 ... v29, Lcom/bytedance/trae/design/compose/TraeTypography;-><init>(Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/ui/text/TextStyle;)V
    sput-object v30, Lcom/bytedance/trae/design/compose/TraeTypographyTokens;->Default Lcom/bytedance/trae/design/compose/TraeTypography;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getDefault()com.bytedance.trae.design.compose.TraeTypography
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/design/compose/TraeTypographyTokens;->Default Lcom/bytedance/trae/design/compose/TraeTypography;
    return-object v0
.end method
