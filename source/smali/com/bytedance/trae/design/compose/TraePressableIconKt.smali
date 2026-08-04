# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraePressableIconKt;
.super Ljava/lang/Object;
.source "TraePressableIcon.kt"


.method public static synthetic $r8$lambda$IWDv9Ci1z7CHRz_jJDJIX-FF_8o(org.jetbrains.compose.resources.DrawableResource  java.lang.String  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  boolean  long  long  long  long  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 18
    # ins_size=17
    invoke-static/range v1 ... v17, Lcom/bytedance/trae/design/compose/TraePressableIconKt;->TraePressableIcon_v_nKSRU$lambda$10(Lorg/jetbrains/compose/resources/DrawableResource; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; Z J J J J I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$tz-9Ar3P71a41O6Mvpl3h_jsVE0(kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function0  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableState  long)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/design/compose/TraePressableIconKt;->TraePressableIcon_v_nKSRU$lambda$9$lambda$8(Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableState; J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static final TraePressableIcon-v-nKSRU(org.jetbrains.compose.resources.DrawableResource  java.lang.String  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  boolean  long  long  long  long  androidx.compose.runtime.Composer  int  int)void
    .registers 48
    # ins_size=16
    move-object/from16 v1, v32
    move-object/from16 v3, v34
    move/from16 v14, v46
    move/from16 v15, v47
    const-string v0, "icon"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onClick"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, 1829015393
    move-object/from16 v2, v45
    invoke-interface v2, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v2
    and-int/lit8 v4, v15, 1
    if-eqz v4, +005h
    or-int/lit8 v4, v14, 6
    goto +11h
    and-int/lit8 v4, v14, 6
    if-nez v4, +00dh
    invoke-interface v2, v1, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    const/4 v4, 4
    goto +2h
    const/4 v4, 2
    or-int/2addr v4, v14
    goto +2h
    move v4, v14
    and-int/lit8 v6, v15, 2
    if-eqz v6, +005h
    or-int/lit8 v4, v4, 48
    goto +14h
    and-int/lit8 v6, v14, 48
    if-nez v6, +011h
    move-object/from16 v6, v33
    invoke-interface v2, v6, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/16 v7, 32
    goto +3h
    const/16 v7, 16
    or-int/2addr v4, v7
    goto +3h
    move-object/from16 v6, v33
    and-int/lit8 v7, v15, 4
    if-eqz v7, +005h
    or-int/lit16 v4, v4, 384
    goto +11h
    and-int/lit16 v7, v14, 384
    if-nez v7, +00eh
    invoke-interface v2, v3, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/16 v7, 256
    goto +3h
    const/16 v7, 128
    or-int/2addr v4, v7
    and-int/lit8 v7, v15, 8
    if-eqz v7, +005h
    or-int/lit16 v4, v4, 3072
    goto +14h
    and-int/lit16 v9, v14, 3072
    if-nez v9, +011h
    move-object/from16 v9, v35
    invoke-interface v2, v9, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +005h
    const/16 v10, 2048
    goto +3h
    const/16 v10, 1024
    or-int/2addr v4, v10
    goto +3h
    move-object/from16 v9, v35
    and-int/lit8 v10, v15, 16
    if-eqz v10, +005h
    or-int/lit16 v4, v4, 24576
    goto +14h
    and-int/lit16 v11, v14, 24576
    if-nez v11, +011h
    move/from16 v11, v36
    invoke-interface v2, v11, Landroidx/compose/runtime/Composer;->changed(Z)Z
    move-result v12
    if-eqz v12, +005h
    const/16 v12, 16384
    goto +3h
    const/16 v12, 8192
    or-int/2addr v4, v12
    goto +3h
    move/from16 v11, v36
    const/high16 v12, 196608
    and-int/2addr v12, v14
    if-nez v12, +018h
    and-int/lit8 v12, v15, 32
    if-nez v12, +00dh
    move-wide/from16 v12, v37
    invoke-interface v2, v12, v13, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v16
    if-eqz v16, +007h
    const/high16 v16, 131072
    goto +5h
    move-wide/from16 v12, v37
    const/high16 v16, 65536
    or-int v4, v4, v16
    goto +3h
    move-wide/from16 v12, v37
    const/high16 v16, 1572864
    and-int v16, v14, v16
    if-nez v16, +016h
    and-int/lit8 v16, v15, 64
    move-wide/from16 v8, v39
    if-nez v16, +00bh
    invoke-interface v2, v8, v9, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v16
    if-eqz v16, +005h
    const/high16 v16, 1048576
    goto +3h
    const/high16 v16, 524288
    or-int v4, v4, v16
    goto +3h
    move-wide/from16 v8, v39
    const/high16 v16, 12582912
    and-int v16, v14, v16
    if-nez v16, +016h
    and-int/lit16 v5, v15, 128
    move-wide/from16 v0, v41
    if-nez v5, +00bh
    invoke-interface v2, v0, v1, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v17
    if-eqz v17, +005h
    const/high16 v17, 8388608
    goto +3h
    const/high16 v17, 4194304
    or-int v4, v4, v17
    goto +3h
    move-wide/from16 v0, v41
    and-int/lit16 v5, v15, 256
    const/high16 v1, 100663296
    if-eqz v5, +004h
    or-int/2addr v4, v1
    goto +14h
    and-int/2addr v1, v14
    if-nez v1, +012h
    move-wide/from16 v0, v43
    invoke-interface v2, v0, v1, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v18
    if-eqz v18, +005h
    const/high16 v18, 67108864
    goto +3h
    const/high16 v18, 33554432
    or-int v4, v4, v18
    goto +3h
    move-wide/from16 v0, v43
    const v18, 38347923
    and-int v0, v4, v18
    const v1, 38347922
    if-ne v0, v1, +016h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v0
    if-nez v0, +003h
    goto +eh
    invoke-interface v2, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object/from16 v4, v35
    move v5, v11
    move-wide v6, v12
    move-wide/from16 v10, v41
    move-wide/from16 v12, v43
    goto/16 +1fbh
    invoke-interface v2, Landroidx/compose/runtime/Composer;->startDefaults()V
    and-int/lit8 v0, v14, 1
    const v18, -3670017
    const v19, -458753
    const/4 v1, 6
    const/16 v21, 1
    if-eqz v0, +027h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getDefaultsInvalid()Z
    move-result v0
    if-eqz v0, +003h
    goto +1fh
    invoke-interface v2, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    and-int/lit8 v0, v15, 32
    if-eqz v0, +004h
    and-int v4, v4, v19
    and-int/lit8 v0, v15, 64
    if-eqz v0, +004h
    and-int v4, v4, v18
    and-int/lit16 v0, v15, 128
    if-eqz v0, +006h
    const v0, -29360129
    and-int/2addr v4, v0
    move-object/from16 v0, v35
    move-wide/from16 v18, v41
    move-wide/from16 v22, v43
    goto +3eh
    if-eqz v7, +007h
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    goto +3h
    move-object/from16 v0, v35
    if-eqz v10, +004h
    move/from16 v11, v21
    and-int/lit8 v7, v15, 32
    if-eqz v7, +00eh
    sget-object v7, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    invoke-virtual v7, v2, v1, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/design/compose/TraeColors;->getIconIconDefault-0d7_KjU()J
    move-result-wide v12
    and-int v4, v4, v19
    and-int/lit8 v7, v15, 64
    if-eqz v7, +005h
    and-int v4, v4, v18
    move-wide v8, v12
    and-int/lit16 v7, v15, 128
    if-eqz v7, +011h
    sget-object v7, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    invoke-virtual v7, v2, v1, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/design/compose/TraeColors;->getIconIconDisabled-0d7_KjU()J
    move-result-wide v18
    const v7, -29360129
    and-int/2addr v4, v7
    goto +3h
    move-wide/from16 v18, v41
    if-eqz v5, -03ch
    const-wide/16 v22, 120
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endDefaults()V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v5
    if-eqz v5, +00bh
    const/4 v5, -1
    const-string v7, "com.bytedance.trae.design.compose.TraePressableIcon (TraePressableIcon.kt:32)"
    const v10, 1829015393
    invoke-static v10, v4, v5, v7, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const v5, -1434444789
    invoke-interface v2, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v5
    sget-object v7, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v7, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v7
    if-ne v5, v7, +009h
    invoke-static Landroidx/compose/foundation/interaction/InteractionSourceKt;->MutableInteractionSource()Landroidx/compose/foundation/interaction/MutableInteractionSource;
    move-result-object v5
    invoke-interface v2, v5, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v5, Landroidx/compose/foundation/interaction/MutableInteractionSource;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v7, v5
    check-cast v7, Landroidx/compose/foundation/interaction/InteractionSource;
    invoke-static v7, v2, v1, Landroidx/compose/foundation/interaction/PressInteractionKt;->collectIsPressedAsState(Landroidx/compose/foundation/interaction/InteractionSource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/runtime/State;
    move-result-object v1
    const v7, 773894976
    const-string v10, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp"
    invoke-static v2, v7, v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const v7, 683737348
    const-string v10, "CC(remember):Effects.kt#9igjgp"
    invoke-static v2, v7, v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    sget-object v10, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v10, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v10
    if-ne v7, v10, +00dh
    sget-object v7, Lkotlin/coroutines/EmptyCoroutineContext;->INSTANCE Lkotlin/coroutines/EmptyCoroutineContext;
    check-cast v7, Lkotlin/coroutines/CoroutineContext;
    invoke-static v7, v2, Landroidx/compose/runtime/EffectsKt;->createCompositionCoroutineScope(Lkotlin/coroutines/CoroutineContext; Landroidx/compose/runtime/Composer;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v7
    invoke-interface v2, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    const v10, -1434438906
    invoke-interface v2, v10, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v10
    sget-object v17, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual/range v17, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    const/16 v17, 0
    const/4 v6, 0
    if-ne v10, v3, +00fh
    invoke-static/range v17, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    const/4 v10, 2
    invoke-static v3, v6, v10, v6, Landroidx/compose/runtime/SnapshotStateKt;->mutableStateOf$default(Ljava/lang/Object; Landroidx/compose/runtime/SnapshotMutationPolicy; I Ljava/lang/Object;)Landroidx/compose/runtime/MutableState;
    move-result-object v3
    invoke-interface v2, v3, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v10, v3
    move-object v3, v10
    check-cast v3, Landroidx/compose/runtime/MutableState;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v10, -1434436885
    invoke-interface v2, v10, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v10
    sget-object v20, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    move-wide/from16 v24, v8
    invoke-virtual/range v20, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v8
    if-ne v10, v8, +00ah
    const/4 v8, 2
    invoke-static v6, v6, v8, v6, Landroidx/compose/runtime/SnapshotStateKt;->mutableStateOf$default(Ljava/lang/Object; Landroidx/compose/runtime/SnapshotMutationPolicy; I Ljava/lang/Object;)Landroidx/compose/runtime/MutableState;
    move-result-object v10
    invoke-interface v2, v10, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v6, v10
    check-cast v6, Landroidx/compose/runtime/MutableState;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    if-eqz v11, +011h
    invoke-static v1, Lcom/bytedance/trae/design/compose/TraePressableIconKt;->TraePressableIcon_v_nKSRU$lambda$1(Landroidx/compose/runtime/State;)Z
    move-result v1
    if-nez v1, +008h
    invoke-static v3, Lcom/bytedance/trae/design/compose/TraePressableIconKt;->TraePressableIcon_v_nKSRU$lambda$3(Landroidx/compose/runtime/MutableState;)Z
    move-result v1
    if-eqz v1, +005h
    move/from16 v1, v21
    goto +3h
    move/from16 v1, v17
    if-nez v11, +005h
    move-wide/from16 v8, v18
    goto +7h
    if-eqz v1, +005h
    move-wide/from16 v8, v24
    goto +2h
    move-wide v8, v12
    and-int/lit8 v1, v4, 14
    move-object/from16 v10, v32
    invoke-static v10, v2, v1, Lorg/jetbrains/compose/resources/ImageResources_androidKt;->painterResource(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/graphics/painter/Painter;
    move-result-object v1
    const/16 v16, 0
    const/16 v20, 0
    const/16 v26, 0
    const v10, -1434419977
    invoke-interface v2, v10, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v2, v7, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v10
    const/high16 v27, 234881024
    move-wide/from16 v28, v12
    and-int v12, v4, v27
    const/high16 v13, 67108864
    if-ne v12, v13, +005h
    move/from16 v12, v21
    goto +3h
    move/from16 v12, v17
    or-int/2addr v10, v12
    and-int/lit16 v12, v4, 896
    const/16 v13, 256
    if-ne v12, v13, +003h
    goto +3h
    move/from16 v21, v17
    or-int v10, v10, v21
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v12
    if-nez v10, +00ah
    sget-object v10, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v10, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v10
    if-ne v12, v10, +016h
    new-instance v12, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda0;
    move-object/from16 v35, v12
    move-object/from16 v36, v7
    move-object/from16 v37, v34
    move-object/from16 v38, v6
    move-object/from16 v39, v3
    move-wide/from16 v40, v22
    invoke-direct/range v35 ... v41, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda0;-><init>(Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableState; J)V
    invoke-interface v2, v12, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v3, v12
    check-cast v3, Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v6, 24
    const/4 v7, 0
    move-object/from16 v35, v0
    move-object/from16 v36, v5
    move-object/from16 v37, v16
    move/from16 v38, v11
    move-object/from16 v39, v20
    move-object/from16 v40, v26
    move-object/from16 v41, v3
    move/from16 v42, v6
    move-object/from16 v43, v7
    invoke-static/range v35 ... v43, Landroidx/compose/foundation/ClickableKt;->clickable-O2vRcR0$default(Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/interaction/MutableInteractionSource; Landroidx/compose/foundation/Indication; Z Ljava/lang/String; Landroidx/compose/ui/semantics/Role; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    sget-object v10, Landroidx/compose/ui/graphics/ColorFilter;->Companion Landroidx/compose/ui/graphics/ColorFilter$Companion;
    const/4 v12, 0
    const/4 v13, 2
    const/16 v16, 0
    move-object/from16 v35, v10
    move-wide/from16 v36, v8
    move/from16 v38, v12
    move/from16 v39, v13
    move-object/from16 v40, v16
    invoke-static/range v35 ... v40, Landroidx/compose/ui/graphics/ColorFilter$Companion;->tint-xETnrds$default(Landroidx/compose/ui/graphics/ColorFilter$Companion; J I I Ljava/lang/Object;)Landroidx/compose/ui/graphics/ColorFilter;
    move-result-object v8
    and-int/lit8 v4, v4, 112
    const/16 v9, 56
    move-object/from16 v35, v1
    move-object/from16 v36, v33
    move-object/from16 v37, v3
    move-object/from16 v38, v5
    move-object/from16 v39, v6
    move/from16 v40, v7
    move-object/from16 v41, v8
    move-object/from16 v42, v2
    move/from16 v43, v4
    move/from16 v44, v9
    invoke-static/range v35 ... v44, Landroidx/compose/foundation/ImageKt;->Image(Landroidx/compose/ui/graphics/painter/Painter; Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Landroidx/compose/ui/layout/ContentScale; F Landroidx/compose/ui/graphics/ColorFilter; Landroidx/compose/runtime/Composer; I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    move-object v4, v0
    move v5, v11
    move-wide/from16 v10, v18
    move-wide/from16 v12, v22
    move-wide/from16 v8, v24
    move-wide/from16 v6, v28
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v3
    if-eqz v3, +01dh
    new-instance v2, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;
    move-object v0, v2
    move-object/from16 v1, v32
    move-object/from16 v30, v2
    move-object/from16 v2, v33
    move-object/from16 v31, v3
    move-object/from16 v3, v34
    move/from16 v14, v46
    move/from16 v15, v47
    invoke-direct/range v0 ... v15, Lcom/bytedance/trae/design/compose/TraePressableIconKt$$ExternalSyntheticLambda1;-><init>(Lorg/jetbrains/compose/resources/DrawableResource; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; Z J J J J I I)V
    move-object/from16 v1, v30
    move-object/from16 v0, v31
    invoke-interface v0, v1, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final TraePressableIcon_v_nKSRU$lambda$1(androidx.compose.runtime.State)boolean
    .registers 1
    # ins_size=1
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
.end method

.method private static final TraePressableIcon_v_nKSRU$lambda$10(org.jetbrains.compose.resources.DrawableResource  java.lang.String  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  boolean  long  long  long  long  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 34
    # ins_size=17
    or-int/lit8 v0, v30, 1
    invoke-static v0, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v15
    move-object/from16 v1, v17
    move-object/from16 v2, v18
    move-object/from16 v3, v19
    move-object/from16 v4, v20
    move/from16 v5, v21
    move-wide/from16 v6, v22
    move-wide/from16 v8, v24
    move-wide/from16 v10, v26
    move-wide/from16 v12, v28
    move-object/from16 v14, v32
    move/from16 v16, v31
    invoke-static/range v1 ... v16, Lcom/bytedance/trae/design/compose/TraePressableIconKt;->TraePressableIcon-v-nKSRU(Lorg/jetbrains/compose/resources/DrawableResource; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; Z J J J J Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final TraePressableIcon_v_nKSRU$lambda$3(androidx.compose.runtime.MutableState)boolean
    .registers 1
    # ins_size=1
    check-cast v0, Landroidx/compose/runtime/State;
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
.end method

.method private static final TraePressableIcon_v_nKSRU$lambda$4(androidx.compose.runtime.MutableState  boolean)void
    .registers 2
    # ins_size=2
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Landroidx/compose/runtime/MutableState;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final TraePressableIcon_v_nKSRU$lambda$6(androidx.compose.runtime.MutableState)kotlinx.coroutines.Job
    .registers 1
    # ins_size=1
    check-cast v0, Landroidx/compose/runtime/State;
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    return-object v0
.end method

.method private static final TraePressableIcon_v_nKSRU$lambda$7(androidx.compose.runtime.MutableState  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    invoke-interface v0, v1, Landroidx/compose/runtime/MutableState;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final TraePressableIcon_v_nKSRU$lambda$9$lambda$8(kotlinx.coroutines.CoroutineScope  kotlin.jvm.functions.Function0  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableState  long)kotlin.Unit
    .registers 15
    # ins_size=6
    invoke-static v11, Lcom/bytedance/trae/design/compose/TraePressableIconKt;->TraePressableIcon_v_nKSRU$lambda$6(Landroidx/compose/runtime/MutableState;)Lkotlinx/coroutines/Job;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    invoke-static v12, v1, Lcom/bytedance/trae/design/compose/TraePressableIconKt;->TraePressableIcon_v_nKSRU$lambda$4(Landroidx/compose/runtime/MutableState; Z)V
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;
    invoke-direct v0, v13, v14, v12, v2, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;-><init>(J Landroidx/compose/runtime/MutableState; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    move-object v3, v9
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v9
    invoke-static v11, v9, Lcom/bytedance/trae/design/compose/TraePressableIconKt;->TraePressableIcon_v_nKSRU$lambda$7(Landroidx/compose/runtime/MutableState; Lkotlinx/coroutines/Job;)V
    invoke-interface v10, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method

.method public static final synthetic access$TraePressableIcon_v_nKSRU$lambda$4(androidx.compose.runtime.MutableState  boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/design/compose/TraePressableIconKt;->TraePressableIcon_v_nKSRU$lambda$4(Landroidx/compose/runtime/MutableState; Z)V
    return-void 
.end method
