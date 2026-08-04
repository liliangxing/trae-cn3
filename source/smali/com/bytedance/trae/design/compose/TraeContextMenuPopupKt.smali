# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;
.super Ljava/lang/Object;
.source "TraeContextMenuPopup.kt"


.method public static synthetic $r8$lambda$9g6YuEsUUKek5wd10YQV5k_3jTg(long  androidx.compose.ui.unit.Density)androidx.compose.ui.unit.IntOffset
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->TraeContextMenuPopup__G194Zc$lambda$12$lambda$11$lambda$7$lambda$6(J Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/unit/IntOffset;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$F3k-IjNvYBBejmjYhfq3QSVtqOc(java.util.List  com.bytedance.trae.design.compose.TraeContextMenuPosition  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  float  float  float  float  float  boolean  boolean  boolean  float  float  float  float  float  float  com.bytedance.trae.design.compose.TraeContextMenuShadowPadding  long  long  long  java.lang.String  int  int  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 33
    # ins_size=32
    invoke-static/range v1 ... v32, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->TraeContextMenuPopup__G194Zc$lambda$13(Ljava/util/List; Lcom/bytedance/trae/design/compose/TraeContextMenuPosition; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; F F F F F Z Z Z F F F F F F Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding; J J J Ljava/lang/String; I I I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Waj31d7z93RS8wx7A_jCX3CsWwo(java.lang.String  androidx.compose.ui.semantics.SemanticsPropertyReceiver)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->contentDescriptionModifier$lambda$19(Ljava/lang/String; Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$iW_sA3f_nA-IZz-hnYzf5suoXik(androidx.compose.runtime.MutableState  androidx.compose.ui.layout.LayoutCoordinates)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->TraeContextMenuPopup__G194Zc$lambda$12$lambda$5$lambda$4(Landroidx/compose/runtime/MutableState; Landroidx/compose/ui/layout/LayoutCoordinates;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$p_IxrqEhCzodFA2QMyxbRwVA704(com.bytedance.trae.design.compose.TraeContextMenuItem  float  float  float  float  float  float  long  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 12
    # ins_size=12
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->TraeContextMenuRow_oeDw4jE$lambda$18(Lcom/bytedance/trae/design/compose/TraeContextMenuItem; F F F F F F J I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static final TraeContextMenuPopup-_G194Zc(java.util.List  com.bytedance.trae.design.compose.TraeContextMenuPosition  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  float  float  float  float  float  boolean  boolean  boolean  float  float  float  float  float  float  com.bytedance.trae.design.compose.TraeContextMenuShadowPadding  long  long  long  java.lang.String  androidx.compose.runtime.Composer  int  int  int  int)void
    .registers 71
    # ins_size=31
    move-object/from16 v1, v40
    move-object/from16 v2, v41
    move-object/from16 v3, v42
    move/from16 v15, v67
    move/from16 v14, v68
    move/from16 v13, v69
    move/from16 v12, v70
    const-string v0, "items"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "position"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onDismissRequest"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, 671981591
    move-object/from16 v4, v66
    invoke-interface v4, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v0
    and-int/lit8 v4, v12, 1
    if-eqz v4, +005h
    or-int/lit8 v4, v15, 6
    goto +11h
    and-int/lit8 v4, v15, 6
    if-nez v4, +00dh
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    const/4 v4, 4
    goto +2h
    const/4 v4, 2
    or-int/2addr v4, v15
    goto +2h
    move v4, v15
    and-int/lit8 v7, v12, 2
    if-eqz v7, +005h
    or-int/lit8 v4, v4, 48
    goto +11h
    and-int/lit8 v7, v15, 48
    if-nez v7, +00eh
    invoke-interface v0, v2, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/16 v7, 32
    goto +3h
    const/16 v7, 16
    or-int/2addr v4, v7
    and-int/lit8 v7, v12, 4
    if-eqz v7, +005h
    or-int/lit16 v4, v4, 384
    goto +11h
    and-int/lit16 v7, v15, 384
    if-nez v7, +00eh
    invoke-interface v0, v3, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +005h
    const/16 v7, 256
    goto +3h
    const/16 v7, 128
    or-int/2addr v4, v7
    and-int/lit8 v7, v12, 8
    if-eqz v7, +005h
    or-int/lit16 v4, v4, 3072
    goto +15h
    and-int/lit16 v5, v15, 3072
    if-nez v5, +012h
    move-object/from16 v5, v43
    invoke-interface v0, v5, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v16
    if-eqz v16, +005h
    const/16 v16, 2048
    goto +3h
    const/16 v16, 1024
    or-int v4, v4, v16
    goto +3h
    move-object/from16 v5, v43
    and-int/lit8 v16, v12, 16
    if-eqz v16, +005h
    or-int/lit16 v4, v4, 24576
    goto +15h
    and-int/lit16 v8, v15, 24576
    if-nez v8, +012h
    move/from16 v8, v44
    invoke-interface v0, v8, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v18
    if-eqz v18, +005h
    const/16 v18, 16384
    goto +3h
    const/16 v18, 8192
    or-int v4, v4, v18
    goto +3h
    move/from16 v8, v44
    and-int/lit8 v18, v12, 32
    const/high16 v19, 196608
    if-eqz v18, +007h
    or-int v4, v4, v19
    move/from16 v10, v45
    goto +14h
    and-int v20, v15, v19
    move/from16 v10, v45
    if-nez v20, +00fh
    invoke-interface v0, v10, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v21
    if-eqz v21, +005h
    const/high16 v21, 131072
    goto +3h
    const/high16 v21, 65536
    or-int v4, v4, v21
    and-int/lit8 v21, v12, 64
    const/high16 v22, 1572864
    const/high16 v23, 1048576
    const/high16 v24, 524288
    if-eqz v21, +007h
    or-int v4, v4, v22
    move/from16 v11, v46
    goto +14h
    and-int v25, v15, v22
    move/from16 v11, v46
    if-nez v25, +00fh
    invoke-interface v0, v11, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v26
    if-eqz v26, +005h
    move/from16 v26, v23
    goto +3h
    move/from16 v26, v24
    or-int v4, v4, v26
    and-int/lit16 v6, v12, 128
    const/high16 v27, 12582912
    if-eqz v6, +007h
    or-int v4, v4, v27
    move/from16 v9, v47
    goto +14h
    and-int v28, v15, v27
    move/from16 v9, v47
    if-nez v28, +00fh
    invoke-interface v0, v9, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v29
    if-eqz v29, +005h
    const/high16 v29, 8388608
    goto +3h
    const/high16 v29, 4194304
    or-int v4, v4, v29
    and-int/lit16 v2, v12, 256
    const/high16 v29, 100663296
    if-eqz v2, +007h
    or-int v4, v4, v29
    move/from16 v3, v48
    goto +14h
    and-int v30, v15, v29
    move/from16 v3, v48
    if-nez v30, +00fh
    invoke-interface v0, v3, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v30
    if-eqz v30, +005h
    const/high16 v30, 67108864
    goto +3h
    const/high16 v30, 33554432
    or-int v4, v4, v30
    and-int/lit16 v3, v12, 512
    const/high16 v30, 805306368
    if-eqz v3, +007h
    or-int v4, v4, v30
    move/from16 v5, v49
    goto +14h
    and-int v30, v15, v30
    move/from16 v5, v49
    if-nez v30, +00fh
    invoke-interface v0, v5, Landroidx/compose/runtime/Composer;->changed(Z)Z
    move-result v30
    if-eqz v30, +005h
    const/high16 v30, 536870912
    goto +3h
    const/high16 v30, 268435456
    or-int v4, v4, v30
    and-int/lit16 v5, v12, 1024
    if-eqz v5, +007h
    or-int/lit8 v30, v14, 6
    move/from16 v8, v50
    goto +17h
    and-int/lit8 v30, v14, 6
    move/from16 v8, v50
    if-nez v30, +010h
    invoke-interface v0, v8, Landroidx/compose/runtime/Composer;->changed(Z)Z
    move-result v30
    if-eqz v30, +005h
    const/16 v30, 4
    goto +3h
    const/16 v30, 2
    or-int v30, v14, v30
    goto +3h
    move/from16 v30, v14
    and-int/lit16 v8, v12, 2048
    if-eqz v8, +005h
    or-int/lit8 v30, v30, 48
    goto +14h
    and-int/lit8 v31, v14, 48
    move/from16 v9, v51
    if-nez v31, +00fh
    invoke-interface v0, v9, Landroidx/compose/runtime/Composer;->changed(Z)Z
    move-result v31
    if-eqz v31, +005h
    const/16 v31, 32
    goto +3h
    const/16 v31, 16
    or-int v30, v30, v31
    move/from16 v9, v30
    and-int/lit16 v10, v12, 4096
    if-eqz v10, +005h
    or-int/lit16 v9, v9, 384
    goto +15h
    and-int/lit16 v11, v14, 384
    if-nez v11, +012h
    move/from16 v11, v52
    invoke-interface v0, v11, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v30
    if-eqz v30, +005h
    const/16 v30, 256
    goto +3h
    const/16 v30, 128
    or-int v9, v9, v30
    goto +3h
    move/from16 v11, v52
    and-int/lit16 v11, v12, 8192
    if-eqz v11, +005h
    or-int/lit16 v9, v9, 3072
    goto +15h
    and-int/lit16 v1, v14, 3072
    if-nez v1, +012h
    move/from16 v1, v53
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v30
    if-eqz v30, +005h
    const/16 v30, 2048
    goto +3h
    const/16 v30, 1024
    or-int v9, v9, v30
    goto +3h
    move/from16 v1, v53
    and-int/lit16 v1, v12, 16384
    if-eqz v1, +007h
    or-int/lit16 v9, v9, 24576
    move/from16 v30, v1
    goto +17h
    move/from16 v30, v1
    and-int/lit16 v1, v14, 24576
    if-nez v1, +012h
    move/from16 v1, v54
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v31
    if-eqz v31, +005h
    const/16 v31, 16384
    goto +3h
    const/16 v31, 8192
    or-int v9, v9, v31
    goto +3h
    move/from16 v1, v54
    const v31, 32768
    and-int v31, v12, v31
    if-eqz v31, +007h
    or-int v9, v9, v19
    move/from16 v1, v55
    goto +14h
    and-int v19, v14, v19
    move/from16 v1, v55
    if-nez v19, +00fh
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v19
    if-eqz v19, +005h
    const/high16 v19, 131072
    goto +3h
    const/high16 v19, 65536
    or-int v9, v9, v19
    const/high16 v19, 65536
    and-int v19, v12, v19
    if-eqz v19, +007h
    or-int v9, v9, v22
    move/from16 v1, v56
    goto +14h
    and-int v22, v14, v22
    move/from16 v1, v56
    if-nez v22, +00fh
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v22
    if-eqz v22, +005h
    move/from16 v22, v23
    goto +3h
    move/from16 v22, v24
    or-int v9, v9, v22
    const/high16 v22, 131072
    and-int v22, v12, v22
    if-eqz v22, +007h
    or-int v9, v9, v27
    move/from16 v1, v57
    goto +14h
    and-int v27, v14, v27
    move/from16 v1, v57
    if-nez v27, +00fh
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v27
    if-eqz v27, +005h
    const/high16 v27, 8388608
    goto +3h
    const/high16 v27, 4194304
    or-int v9, v9, v27
    const/high16 v27, 262144
    and-int v27, v12, v27
    if-eqz v27, +007h
    or-int v9, v9, v29
    move-object/from16 v1, v58
    goto +14h
    and-int v29, v14, v29
    move-object/from16 v1, v58
    if-nez v29, +00fh
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v29
    if-eqz v29, +005h
    const/high16 v29, 67108864
    goto +3h
    const/high16 v29, 33554432
    or-int v9, v9, v29
    const/high16 v29, 805306368
    and-int v29, v14, v29
    if-nez v29, +020h
    and-int v29, v12, v24
    if-nez v29, +011h
    move/from16 v29, v10
    move/from16 v32, v11
    move-wide/from16 v10, v59
    invoke-interface v0, v10, v11, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v33
    if-eqz v33, +00bh
    const/high16 v33, 536870912
    goto +9h
    move/from16 v29, v10
    move/from16 v32, v11
    move-wide/from16 v10, v59
    const/high16 v33, 268435456
    or-int v9, v9, v33
    goto +7h
    move/from16 v29, v10
    move/from16 v32, v11
    move-wide/from16 v10, v59
    and-int/lit8 v33, v13, 6
    if-nez v33, +016h
    and-int v33, v12, v23
    move-wide/from16 v10, v61
    if-nez v33, +00bh
    invoke-interface v0, v10, v11, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v33
    if-eqz v33, +005h
    const/16 v33, 4
    goto +3h
    const/16 v33, 2
    or-int v33, v13, v33
    goto +5h
    move-wide/from16 v10, v61
    move/from16 v33, v13
    and-int/lit8 v34, v13, 48
    if-nez v34, +018h
    const/high16 v34, 2097152
    and-int v34, v12, v34
    move-wide/from16 v10, v63
    if-nez v34, +00bh
    invoke-interface v0, v10, v11, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v34
    if-eqz v34, +005h
    const/16 v17, 32
    goto +3h
    const/16 v17, 16
    or-int v33, v33, v17
    goto +3h
    move-wide/from16 v10, v63
    move/from16 v1, v33
    const/high16 v17, 4194304
    and-int v17, v12, v17
    if-eqz v17, +005h
    or-int/lit16 v1, v1, 384
    goto +15h
    and-int/lit16 v10, v13, 384
    if-nez v10, +012h
    move-object/from16 v10, v65
    invoke-interface v0, v10, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +005h
    const/16 v20, 256
    goto +3h
    const/16 v20, 128
    or-int v1, v1, v20
    goto +3h
    move-object/from16 v10, v65
    const v11, 306783379
    and-int/2addr v11, v4
    const v10, 306783378
    if-ne v11, v10, +045h
    const v10, 306783379
    and-int/2addr v10, v9
    const v11, 306783378
    if-ne v10, v11, +03ch
    and-int/lit16 v10, v1, 147
    const/16 v11, 146
    if-ne v10, v11, +036h
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v10
    if-nez v10, +003h
    goto +2eh
    invoke-interface v0, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object/from16 v4, v43
    move/from16 v5, v44
    move/from16 v6, v45
    move/from16 v7, v46
    move/from16 v8, v47
    move/from16 v9, v48
    move/from16 v10, v49
    move/from16 v11, v50
    move/from16 v12, v51
    move/from16 v13, v52
    move/from16 v14, v53
    move/from16 v15, v54
    move/from16 v16, v55
    move/from16 v17, v56
    move/from16 v18, v57
    move-object/from16 v19, v58
    move-wide/from16 v20, v59
    move-wide/from16 v22, v61
    move-wide/from16 v24, v63
    move-object/from16 v26, v65
    goto/16 +74eh
    invoke-interface v0, Landroidx/compose/runtime/Composer;->startDefaults()V
    and-int/lit8 v10, v15, 1
    if-eqz v10, +04eh
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getDefaultsInvalid()Z
    move-result v10
    if-eqz v10, +003h
    goto +46h
    invoke-interface v0, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    and-int v2, v12, v24
    if-eqz v2, +006h
    const v2, -1879048193
    and-int/2addr v9, v2
    and-int v2, v12, v23
    if-eqz v2, +004h
    and-int/lit8 v1, v1, -15
    const/high16 v2, 2097152
    and-int/2addr v2, v12
    if-eqz v2, +004h
    and-int/lit8 v1, v1, -113
    move/from16 v10, v44
    move/from16 v11, v45
    move/from16 v2, v46
    move/from16 v3, v47
    move/from16 v5, v48
    move/from16 v18, v49
    move/from16 v6, v50
    move/from16 v7, v51
    move/from16 v8, v52
    move/from16 v17, v54
    move/from16 v19, v55
    move/from16 v21, v56
    move/from16 v22, v57
    move-object/from16 v23, v58
    move-wide/from16 v24, v59
    move-wide/from16 v27, v61
    move-wide/from16 v29, v63
    move-object/from16 v31, v65
    move/from16 v32, v1
    move v12, v9
    move-object/from16 v1, v43
    move/from16 v9, v53
    goto/16 +145h
    if-eqz v7, +007h
    sget-object v7, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v7, Landroidx/compose/ui/Modifier;
    goto +3h
    move-object/from16 v7, v43
    if-eqz v16, +00ah
    const/16 v10, 180
    int-to-float v10, v10
    invoke-static v10, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v10
    goto +3h
    move/from16 v10, v44
    if-eqz v18, +00ah
    const/16 v11, 44
    int-to-float v11, v11
    invoke-static v11, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v11
    goto +3h
    move/from16 v11, v45
    move-object/from16 v43, v7
    if-eqz v21, +00ah
    const/16 v7, 20
    int-to-float v7, v7
    invoke-static v7, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v7
    goto +3h
    move/from16 v7, v46
    if-eqz v6, +00ah
    const/16 v6, 40
    int-to-float v6, v6
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    goto +3h
    move/from16 v6, v47
    move/from16 v45, v6
    move/from16 v44, v7
    if-eqz v2, +00ah
    const-wide/high16 v6, 4602678819172646912
    double-to-float v2, v6
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v2
    goto +3h
    move/from16 v2, v48
    if-eqz v3, +004h
    const/4 v3, 1
    goto +3h
    move/from16 v3, v49
    if-eqz v5, +004h
    const/4 v5, 0
    goto +3h
    move/from16 v5, v50
    if-eqz v8, +004h
    const/4 v6, 0
    goto +3h
    move/from16 v6, v51
    if-eqz v29, +009h
    const/4 v7, 0
    int-to-float v8, v7
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v7
    goto +3h
    move/from16 v7, v52
    if-eqz v32, +00ah
    const/16 v8, 16
    int-to-float v8, v8
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v8
    goto +3h
    move/from16 v8, v53
    move/from16 v46, v2
    if-eqz v30, +00ah
    const/16 v2, 13
    int-to-float v2, v2
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v2
    goto +3h
    move/from16 v2, v54
    move/from16 v47, v2
    if-eqz v31, +00ah
    const/16 v2, 18
    int-to-float v2, v2
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v2
    goto +3h
    move/from16 v2, v55
    move/from16 v48, v2
    if-eqz v19, +00ah
    const/16 v2, 8
    int-to-float v2, v2
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v2
    goto +3h
    move/from16 v2, v56
    move/from16 v49, v2
    move/from16 v18, v3
    if-eqz v22, +009h
    const/4 v2, 0
    int-to-float v3, v2
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v2
    goto +3h
    move/from16 v2, v57
    if-eqz v27, +022h
    new-instance v3, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;
    const/16 v19, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v25, 0
    const/16 v27, 15
    const/16 v28, 0
    move-object/from16 v50, v3
    move/from16 v51, v19
    move/from16 v52, v21
    move/from16 v53, v22
    move/from16 v54, v25
    move/from16 v55, v27
    move-object/from16 v56, v28
    invoke-direct/range v50 ... v56, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;-><init>(F F F F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +3h
    move-object/from16 v3, v58
    and-int v19, v12, v24
    move/from16 v50, v2
    const/4 v2, 6
    move-object/from16 v51, v3
    if-eqz v19, +011h
    sget-object v3, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/design/compose/TraeColors;->getBorderBorderNeutralL1-0d7_KjU()J
    move-result-wide v21
    const v3, -1879048193
    and-int/2addr v9, v3
    goto +3h
    move-wide/from16 v21, v59
    and-int v3, v12, v23
    if-eqz v3, +00fh
    sget-object v3, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/design/compose/TraeColors;->getTextTextDefault-0d7_KjU()J
    move-result-wide v23
    and-int/lit8 v1, v1, -15
    goto +3h
    move-wide/from16 v23, v61
    const/high16 v3, 2097152
    and-int/2addr v3, v12
    if-eqz v3, +00fh
    sget-object v3, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/design/compose/TraeColors;->getBgBgBaseDefault-0d7_KjU()J
    move-result-wide v2
    and-int/lit8 v1, v1, -113
    goto +3h
    move-wide/from16 v2, v63
    if-eqz v17, +010h
    move/from16 v17, v47
    move/from16 v19, v48
    move/from16 v32, v1
    move-wide/from16 v29, v2
    move v12, v9
    move-wide/from16 v27, v23
    const/16 v31, 0
    goto +eh
    move/from16 v17, v47
    move/from16 v19, v48
    move-object/from16 v31, v65
    move/from16 v32, v1
    move-wide/from16 v29, v2
    move v12, v9
    move-wide/from16 v27, v23
    move-object/from16 v1, v43
    move/from16 v2, v44
    move/from16 v3, v45
    move-object/from16 v23, v51
    move v9, v8
    move-wide/from16 v24, v21
    move/from16 v21, v49
    move/from16 v22, v50
    move v8, v7
    move v7, v6
    move v6, v5
    move/from16 v5, v46
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endDefaults()V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v33
    if-eqz v33, +00ah
    const v13, 671981591
    const-string v14, "com.bytedance.trae.design.compose.TraeContextMenuPopup (TraeContextMenuPopup.kt:95)"
    invoke-static v13, v4, v12, v14, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const/4 v13, 0
    move/from16 v33, v5
    const/4 v14, 0
    const/4 v15, 1
    invoke-static v1, v13, v15, v14, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    const v14, 733328855
    const-string v15, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
    invoke-static v0, v14, v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v14, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v14, Landroidx/compose/ui/Alignment$Companion;->getTopStart()Landroidx/compose/ui/Alignment;
    move-result-object v14
    const/4 v15, 0
    invoke-static v14, v15, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v14
    const-string v13, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
    move-object/from16 v34, v1
    const v1, -1323940314
    invoke-static v0, v1, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v0, v15, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHash(Landroidx/compose/runtime/Composer; I)I
    move-result v13
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v15
    invoke-static v0, v5, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    sget-object v35, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual/range v35, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v1
    move/from16 v35, v8
    const v8, -692256719
    move/from16 v56, v7
    const-string v7, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
    invoke-static v0, v8, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v7
    instance-of v7, v7, Landroidx/compose/runtime/Applier;
    if-nez v7, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v7
    if-eqz v7, +006h
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v0, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v0, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v1
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v1, v14, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v1, v15, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-interface v1, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-nez v8, +010h
    invoke-interface v1, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v8
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    invoke-static v8, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +010h
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v1, v8, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v1, v8, v7, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v1, v5, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v1, -2146769399
    const-string v5, "C73@3429L9:Box.kt#2w3rfo"
    invoke-static v0, v1, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v1, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v1, Landroidx/compose/foundation/layout/BoxScope;
    const v1, -2027001546
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v1
    sget-object v5, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v5, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v5
    if-ne v1, v5, +009h
    invoke-static Landroidx/compose/foundation/interaction/InteractionSourceKt;->MutableInteractionSource()Landroidx/compose/foundation/interaction/MutableInteractionSource;
    move-result-object v1
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v1, Landroidx/compose/foundation/interaction/MutableInteractionSource;
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v13, 1
    invoke-static v5, v7, v13, v8, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    const/4 v7, 0
    const/4 v8, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 28
    const/16 v36, 0
    move-object/from16 v43, v5
    move-object/from16 v44, v1
    move-object/from16 v45, v7
    move/from16 v46, v8
    move-object/from16 v47, v13
    move-object/from16 v48, v14
    move-object/from16 v49, v42
    move/from16 v50, v15
    move-object/from16 v51, v36
    invoke-static/range v43 ... v51, Landroidx/compose/foundation/ClickableKt;->clickable-O2vRcR0$default(Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/interaction/MutableInteractionSource; Landroidx/compose/foundation/Indication; Z Ljava/lang/String; Landroidx/compose/ui/semantics/Role; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const/4 v5, 0
    invoke-static v1, v0, v5, Landroidx/compose/foundation/layout/BoxKt;->Box(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    const v1, -2026990312
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v1
    sget-object v5, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v5, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v5
    if-ne v1, v5, +016h
    sget-object v1, Landroidx/compose/ui/unit/IntSize;->Companion Landroidx/compose/ui/unit/IntSize$Companion;
    invoke-virtual v1, Landroidx/compose/ui/unit/IntSize$Companion;->getZero-YbymL2g()J
    move-result-wide v7
    invoke-static v7, v8, Landroidx/compose/ui/unit/IntSize;->box-impl(J)Landroidx/compose/ui/unit/IntSize;
    move-result-object v1
    const/4 v5, 2
    const/4 v7, 0
    invoke-static v1, v7, v5, v7, Landroidx/compose/runtime/SnapshotStateKt;->mutableStateOf$default(Ljava/lang/Object; Landroidx/compose/runtime/SnapshotMutationPolicy; I Ljava/lang/Object;)Landroidx/compose/runtime/MutableState;
    move-result-object v1
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    goto +2h
    const/4 v7, 0
    check-cast v1, Landroidx/compose/runtime/MutableState;
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    const/4 v8, 0
    const/4 v13, 1
    invoke-static v5, v8, v13, v7, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    const v7, -2026985339
    invoke-interface v0, v7, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    sget-object v8, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v8, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v8
    if-ne v7, v8, +00ah
    new-instance v7, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda0;
    invoke-direct v7, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda0;-><init>(Landroidx/compose/runtime/MutableState;)V
    invoke-interface v0, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v7, Lkotlin/jvm/functions/Function1;
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v5, v7, Landroidx/compose/ui/layout/OnGloballyPositionedModifierKt;->onGloballyPositioned(Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    const v7, 733328855
    const-string v8, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
    invoke-static v0, v7, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v7, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v7, Landroidx/compose/ui/Alignment$Companion;->getTopStart()Landroidx/compose/ui/Alignment;
    move-result-object v7
    const/4 v8, 0
    invoke-static v7, v8, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v7
    const-string v13, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
    const v14, -1323940314
    invoke-static v0, v14, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v0, v8, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHash(Landroidx/compose/runtime/Composer; I)I
    move-result v13
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v8
    invoke-static v0, v5, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    sget-object v14, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v14, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v14
    const v15, -692256719
    move/from16 v57, v9
    const-string v9, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
    invoke-static v0, v15, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v9
    instance-of v9, v9, Landroidx/compose/runtime/Applier;
    if-nez v9, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-eqz v9, +006h
    invoke-interface v0, v14, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v0, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v0, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v9
    sget-object v14, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v14, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v14
    invoke-static v9, v7, v14, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v9, v8, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-nez v8, +010h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v8
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v14
    invoke-static v8, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +010h
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v9, v8, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v9, v8, v7, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v9, v5, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v5, -2146769399
    const-string v7, "C73@3429L9:Box.kt#2w3rfo"
    invoke-static v0, v5, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v5, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v5, Landroidx/compose/foundation/layout/BoxScope;
    const v5, -2021344511
    invoke-interface v0, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-static v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->TraeContextMenuPopup__G194Zc$lambda$12$lambda$2(Landroidx/compose/runtime/MutableState;)J
    move-result-wide v7
    invoke-interface/range v40, Ljava/util/List;->size()I
    move-result v1
    shr-int/lit8 v5, v4, 3
    and-int/lit8 v5, v5, 14
    shr-int/lit8 v9, v4, 6
    and-int/lit16 v13, v9, 896
    or-int/2addr v5, v13
    and-int/lit16 v9, v9, 7168
    or-int/2addr v5, v9
    shr-int/lit8 v9, v12, 9
    const/high16 v13, 458752
    and-int/2addr v9, v13
    or-int/2addr v5, v9
    move-object/from16 v43, v41
    move-wide/from16 v44, v7
    move/from16 v46, v10
    move/from16 v47, v11
    move/from16 v48, v1
    move-object/from16 v49, v23
    move-object/from16 v50, v0
    move/from16 v51, v5
    invoke-static/range v43 ... v51, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->calculateMenuOffset-7bnJ_2g(Lcom/bytedance/trae/design/compose/TraeContextMenuPosition; J F F I Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/unit/IntOffset;
    move-result-object v1
    if-eqz v1, +31eh
    invoke-virtual v1, Landroidx/compose/ui/unit/IntOffset;->unbox-impl()J
    move-result-wide v7
    sget-object v1, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v1, Landroidx/compose/ui/Modifier;
    const v5, -342289832
    invoke-interface v0, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v0, v7, v8, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v5
    invoke-interface v0, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    if-nez v5, +00ah
    sget-object v5, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v5, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v5
    if-ne v9, v5, +00ah
    new-instance v9, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda1;
    invoke-direct v9, v7, v8, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda1;-><init>(J)V
    invoke-interface v0, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v9, Lkotlin/jvm/functions/Function1;
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v1, v9, Landroidx/compose/foundation/layout/OffsetKt;->offset(Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    invoke-virtual/range v23, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->getStart-D9Ej5fM()F
    move-result v5
    add-float/2addr v5, v10
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    invoke-virtual/range v23, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->getEnd-D9Ej5fM()F
    move-result v7
    add-float/2addr v5, v7
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    invoke-static v1, v5, Landroidx/compose/foundation/layout/SizeKt;->width-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v1
    invoke-virtual/range v23, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->getStart-D9Ej5fM()F
    move-result v5
    invoke-virtual/range v23, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->getTop-D9Ej5fM()F
    move-result v7
    invoke-virtual/range v23, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->getEnd-D9Ej5fM()F
    move-result v8
    invoke-virtual/range v23, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->getBottom-D9Ej5fM()F
    move-result v9
    invoke-static v1, v5, v7, v8, v9, Landroidx/compose/foundation/layout/PaddingKt;->padding-qDBjuR0(Landroidx/compose/ui/Modifier; F F F F)Landroidx/compose/ui/Modifier;
    move-result-object v1
    invoke-static v2, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v5
    check-cast v5, Landroidx/compose/ui/graphics/Shape;
    const/4 v7, 0
    const-wide/16 v8, 0
    const-wide/16 v13, 0
    const/16 v15, 24
    const/16 v36, 0
    move-object/from16 v43, v1
    move/from16 v44, v3
    move-object/from16 v45, v5
    move/from16 v46, v7
    move-wide/from16 v47, v8
    move-wide/from16 v49, v13
    move/from16 v51, v15
    move-object/from16 v52, v36
    invoke-static/range v43 ... v52, Landroidx/compose/ui/draw/ShadowKt;->shadow-s4CzXII$default(Landroidx/compose/ui/Modifier; F Landroidx/compose/ui/graphics/Shape; Z J J I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    invoke-static v2, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v5
    check-cast v5, Landroidx/compose/ui/graphics/Shape;
    invoke-static v1, v5, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const/4 v5, 0
    const/4 v7, 2
    const/4 v8, 0
    move-object/from16 v43, v1
    move-wide/from16 v44, v29
    move-object/from16 v46, v5
    move/from16 v47, v7
    move-object/from16 v48, v8
    invoke-static/range v43 ... v48, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    invoke-static/range v31, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->contentDescriptionModifier(Ljava/lang/String;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    invoke-interface v1, v5, Landroidx/compose/ui/Modifier;->then(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const v5, -483455358
    const-string v7, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo"
    invoke-static v0, v5, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v5, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v5, Landroidx/compose/foundation/layout/Arrangement;->getTop()Landroidx/compose/foundation/layout/Arrangement$Vertical;
    move-result-object v5
    sget-object v7, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v7, Landroidx/compose/ui/Alignment$Companion;->getStart()Landroidx/compose/ui/Alignment$Horizontal;
    move-result-object v7
    const/4 v8, 0
    invoke-static v5, v7, v0, v8, Landroidx/compose/foundation/layout/ColumnKt;->columnMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Vertical; Landroidx/compose/ui/Alignment$Horizontal; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v5
    const-string v7, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
    const v9, -1323940314
    invoke-static v0, v9, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v0, v8, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHash(Landroidx/compose/runtime/Composer; I)I
    move-result v7
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v8
    invoke-static v0, v1, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    sget-object v9, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v9, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v9
    const v13, -692256719
    const-string v14, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
    invoke-static v0, v13, v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v13
    instance-of v13, v13, Landroidx/compose/runtime/Applier;
    if-nez v13, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v13
    if-eqz v13, +006h
    invoke-interface v0, v9, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v0, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v0, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v9
    sget-object v13, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v13, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v13
    invoke-static v9, v5, v13, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v9, v8, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-nez v8, +010h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v8
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    invoke-static v8, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +010h
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v9, v8, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-interface v9, v7, v5, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    invoke-static v9, v1, v5, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v1, -384862393
    const-string v5, "C87@4365L9:Column.kt#2w3rfo"
    invoke-static v0, v1, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v1, Landroidx/compose/foundation/layout/ColumnScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/ColumnScopeInstance;
    check-cast v1, Landroidx/compose/foundation/layout/ColumnScope;
    const v1, 1850697387
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    move-object/from16 v1, v40
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v5, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +1a1h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    add-int/lit8 v8, v5, 1
    if-gez v5, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v7, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
    if-eqz v18, +00ch
    if-nez v6, +008h
    invoke-static/range v40, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v9
    if-eq v5, v9, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    const v9, 733328855
    const-string v13, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
    invoke-static v0, v9, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v9, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v9, Landroidx/compose/ui/Modifier;
    sget-object v13, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v13, Landroidx/compose/ui/Alignment$Companion;->getTopStart()Landroidx/compose/ui/Alignment;
    move-result-object v13
    const/4 v14, 0
    invoke-static v13, v14, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v13
    const-string v15, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
    move-object/from16 v58, v1
    const v1, -1323940314
    invoke-static v0, v1, v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v0, v14, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHash(Landroidx/compose/runtime/Composer; I)I
    move-result v15
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v14
    invoke-static v0, v9, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v9
    sget-object v36, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual/range v36, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v1
    move/from16 v59, v2
    const v2, -692256719
    move/from16 v60, v3
    const-string v3, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
    invoke-static v0, v2, v3, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v2
    instance-of v2, v2, Landroidx/compose/runtime/Applier;
    if-nez v2, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v2
    if-eqz v2, +006h
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v0, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v0, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v1
    sget-object v2, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v2, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v2
    invoke-static v1, v13, v2, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v2, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v2, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v2
    invoke-static v1, v14, v2, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v2, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v2, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v2
    invoke-interface v1, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v3
    if-nez v3, +010h
    invoke-interface v1, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v3
    invoke-static v15, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    invoke-static v3, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +010h
    invoke-static v15, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v1, v3, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v15, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v1, v3, v2, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v2, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v2, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v2
    invoke-static v1, v9, v2, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v1, -2146769399
    const-string v2, "C73@3429L9:Box.kt#2w3rfo"
    invoke-static v0, v1, v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v1, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v1, Landroidx/compose/foundation/layout/BoxScope;
    shr-int/lit8 v2, v4, 12
    and-int/lit8 v2, v2, 112
    shr-int/lit8 v3, v12, 3
    and-int/lit16 v9, v3, 896
    or-int/2addr v2, v9
    and-int/lit16 v9, v3, 7168
    or-int/2addr v2, v9
    const v9, 57344
    and-int/2addr v9, v3
    or-int/2addr v2, v9
    const/high16 v9, 458752
    and-int/2addr v9, v3
    or-int/2addr v2, v9
    const/high16 v9, 3670016
    and-int/2addr v3, v9
    or-int/2addr v2, v3
    shl-int/lit8 v3, v32, 21
    const/high16 v9, 29360128
    and-int/2addr v3, v9
    or-int/2addr v2, v3
    move-object/from16 v43, v7
    move/from16 v44, v11
    move/from16 v45, v57
    move/from16 v46, v17
    move/from16 v47, v19
    move/from16 v48, v21
    move/from16 v49, v22
    move-wide/from16 v50, v27
    move-object/from16 v52, v0
    move/from16 v53, v2
    invoke-static/range v43 ... v53, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->TraeContextMenuRow-oeDw4jE(Lcom/bytedance/trae/design/compose/TraeContextMenuItem; F F F F F F J Landroidx/compose/runtime/Composer; I)V
    const v2, 248891201
    invoke-interface v0, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    if-eqz v5, +03ch
    if-eqz v56, +03ah
    sget-object v2, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v2, Landroidx/compose/ui/Modifier;
    sget-object v3, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v3, Landroidx/compose/ui/Alignment$Companion;->getBottomCenter()Landroidx/compose/ui/Alignment;
    move-result-object v3
    invoke-interface v1, v2, v3, Landroidx/compose/foundation/layout/BoxScope;->align(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    const/4 v7, 1
    invoke-static v1, v2, v7, v3, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    move/from16 v7, v35
    const/4 v9, 2
    invoke-static v1, v7, v2, v9, v3, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    move/from16 v2, v33
    invoke-static v1, v2, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const/4 v3, 0
    const/4 v9, 2
    const/4 v13, 0
    move-object/from16 v43, v1
    move-wide/from16 v44, v24
    move-object/from16 v46, v3
    move/from16 v47, v9
    move-object/from16 v48, v13
    invoke-static/range v43 ... v48, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const/4 v3, 0
    invoke-static v1, v0, v3, Landroidx/compose/foundation/layout/BoxKt;->Box(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    goto +5h
    move/from16 v2, v33
    move/from16 v7, v35
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    const v1, 1850737793
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    if-eqz v5, +02fh
    if-nez v56, +02dh
    sget-object v1, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v1, Landroidx/compose/ui/Modifier;
    const/4 v3, 0
    const/4 v5, 0
    const/4 v9, 1
    invoke-static v1, v3, v9, v5, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const/4 v13, 2
    invoke-static v1, v7, v3, v13, v5, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    invoke-static v1, v2, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const/4 v14, 0
    const/4 v15, 2
    const/16 v16, 0
    move-object/from16 v43, v1
    move-wide/from16 v44, v24
    move-object/from16 v46, v14
    move/from16 v47, v15
    move-object/from16 v48, v16
    invoke-static/range v43 ... v48, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const/4 v14, 0
    invoke-static v1, v0, v14, Landroidx/compose/foundation/layout/BoxKt;->Box(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    goto +6h
    const/4 v3, 0
    const/4 v5, 0
    const/4 v9, 1
    const/4 v13, 2
    const/4 v14, 0
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object/from16 v1, v58
    move/from16 v3, v60
    move/from16 v33, v2
    move/from16 v35, v7
    move v5, v8
    move/from16 v2, v59
    goto/16 -1a3h
    move/from16 v59, v2
    move/from16 v60, v3
    move/from16 v2, v33
    move/from16 v7, v35
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    goto +ch
    move/from16 v59, v2
    move/from16 v60, v3
    move/from16 v2, v33
    move/from16 v7, v35
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v0, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    move/from16 v12, v56
    move/from16 v14, v57
    move/from16 v8, v60
    move v9, v2
    move v13, v7
    move v5, v10
    move/from16 v15, v17
    move/from16 v10, v18
    move/from16 v16, v19
    move/from16 v17, v21
    move/from16 v18, v22
    move-object/from16 v19, v23
    move-wide/from16 v20, v24
    move-wide/from16 v22, v27
    move-wide/from16 v24, v29
    move-object/from16 v26, v31
    move-object/from16 v4, v34
    move/from16 v7, v59
    move/from16 v39, v11
    move v11, v6
    move/from16 v6, v39
    invoke-interface v0, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v3
    if-eqz v3, +021h
    new-instance v2, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;
    move-object v0, v2
    move-object/from16 v1, v40
    move-object/from16 v37, v2
    move-object/from16 v2, v41
    move-object/from16 v38, v3
    move-object/from16 v3, v42
    move/from16 v27, v67
    move/from16 v28, v68
    move/from16 v29, v69
    move/from16 v30, v70
    invoke-direct/range v0 ... v30, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda2;-><init>(Ljava/util/List; Lcom/bytedance/trae/design/compose/TraeContextMenuPosition; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; F F F F F Z Z Z F F F F F F Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding; J J J Ljava/lang/String; I I I I)V
    move-object/from16 v1, v37
    move-object/from16 v0, v38
    invoke-interface v0, v1, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final TraeContextMenuPopup__G194Zc$lambda$12$lambda$11$lambda$7$lambda$6(long  androidx.compose.ui.unit.Density)androidx.compose.ui.unit.IntOffset
    .registers 4
    # ins_size=3
    const-string v0, "$this$offset"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, v2, Landroidx/compose/ui/unit/IntOffset;->box-impl(J)Landroidx/compose/ui/unit/IntOffset;
    move-result-object v1
    return-object v1
.end method

.method private static final TraeContextMenuPopup__G194Zc$lambda$12$lambda$2(androidx.compose.runtime.MutableState)long
    .registers 3
    # ins_size=1
    check-cast v2, Landroidx/compose/runtime/State;
    invoke-interface v2, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Landroidx/compose/ui/unit/IntSize;
    invoke-virtual v2, Landroidx/compose/ui/unit/IntSize;->unbox-impl()J
    move-result-wide v0
    return-wide v0
.end method

.method private static final TraeContextMenuPopup__G194Zc$lambda$12$lambda$3(androidx.compose.runtime.MutableState  long)void
    .registers 3
    # ins_size=3
    invoke-static v1, v2, Landroidx/compose/ui/unit/IntSize;->box-impl(J)Landroidx/compose/ui/unit/IntSize;
    move-result-object v1
    invoke-interface v0, v1, Landroidx/compose/runtime/MutableState;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private static final TraeContextMenuPopup__G194Zc$lambda$12$lambda$5$lambda$4(androidx.compose.runtime.MutableState  androidx.compose.ui.layout.LayoutCoordinates)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "it"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, Landroidx/compose/ui/layout/LayoutCoordinates;->getSize-YbymL2g()J
    move-result-wide v0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->TraeContextMenuPopup__G194Zc$lambda$12$lambda$3(Landroidx/compose/runtime/MutableState; J)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final TraeContextMenuPopup__G194Zc$lambda$13(java.util.List  com.bytedance.trae.design.compose.TraeContextMenuPosition  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  float  float  float  float  float  boolean  boolean  boolean  float  float  float  float  float  float  com.bytedance.trae.design.compose.TraeContextMenuShadowPadding  long  long  long  java.lang.String  int  int  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 63
    # ins_size=32
    move-object/from16 v0, v31
    move-object/from16 v1, v32
    move-object/from16 v2, v33
    move-object/from16 v3, v34
    move/from16 v4, v35
    move/from16 v5, v36
    move/from16 v6, v37
    move/from16 v7, v38
    move/from16 v8, v39
    move/from16 v9, v40
    move/from16 v10, v41
    move/from16 v11, v42
    move/from16 v12, v43
    move/from16 v13, v44
    move/from16 v14, v45
    move/from16 v15, v46
    move/from16 v16, v47
    move/from16 v17, v48
    move-object/from16 v18, v49
    move-wide/from16 v19, v50
    move-wide/from16 v21, v52
    move-wide/from16 v23, v54
    move-object/from16 v25, v56
    move/from16 v30, v60
    move-object/from16 v26, v61
    or-int/lit8 v27, v57, 1
    invoke-static/range v27, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v27
    invoke-static/range v58, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v28
    invoke-static/range v59, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v29
    invoke-static/range v0 ... v30, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->TraeContextMenuPopup-_G194Zc(Ljava/util/List; Lcom/bytedance/trae/design/compose/TraeContextMenuPosition; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; F F F F F Z Z Z F F F F F F Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding; J J J Ljava/lang/String; Landroidx/compose/runtime/Composer; I I I I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final TraeContextMenuRow-oeDw4jE(com.bytedance.trae.design.compose.TraeContextMenuItem  float  float  float  float  float  float  long  androidx.compose.runtime.Composer  int)void
    .registers 53
    # ins_size=11
    move/from16 v2, v43
    move/from16 v10, v44
    move/from16 v11, v45
    move/from16 v12, v46
    move/from16 v13, v47
    move/from16 v14, v48
    move/from16 v15, v52
    const v0, -680996092
    move-object/from16 v1, v51
    invoke-interface v1, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v1
    and-int/lit8 v3, v15, 6
    move-object/from16 v9, v42
    if-nez v3, +00dh
    invoke-interface v1, v9, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 4
    goto +2h
    const/4 v3, 2
    or-int/2addr v3, v15
    goto +2h
    move v3, v15
    and-int/lit8 v4, v15, 48
    if-nez v4, +00eh
    invoke-interface v1, v2, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v4
    if-eqz v4, +005h
    const/16 v4, 32
    goto +3h
    const/16 v4, 16
    or-int/2addr v3, v4
    and-int/lit16 v4, v15, 384
    if-nez v4, +00eh
    invoke-interface v1, v10, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v4
    if-eqz v4, +005h
    const/16 v4, 256
    goto +3h
    const/16 v4, 128
    or-int/2addr v3, v4
    and-int/lit16 v4, v15, 3072
    if-nez v4, +00eh
    invoke-interface v1, v11, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v4
    if-eqz v4, +005h
    const/16 v4, 2048
    goto +3h
    const/16 v4, 1024
    or-int/2addr v3, v4
    and-int/lit16 v4, v15, 24576
    if-nez v4, +00eh
    invoke-interface v1, v12, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v4
    if-eqz v4, +005h
    const/16 v4, 16384
    goto +3h
    const/16 v4, 8192
    or-int/2addr v3, v4
    const/high16 v4, 196608
    and-int/2addr v4, v15
    if-nez v4, +00eh
    invoke-interface v1, v13, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v4
    if-eqz v4, +005h
    const/high16 v4, 131072
    goto +3h
    const/high16 v4, 65536
    or-int/2addr v3, v4
    const/high16 v4, 1572864
    and-int/2addr v4, v15
    if-nez v4, +00eh
    invoke-interface v1, v14, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v4
    if-eqz v4, +005h
    const/high16 v4, 1048576
    goto +3h
    const/high16 v4, 524288
    or-int/2addr v3, v4
    const/high16 v4, 12582912
    and-int/2addr v4, v15
    move-wide/from16 v7, v49
    if-nez v4, +00eh
    invoke-interface v1, v7, v8, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v4
    if-eqz v4, +005h
    const/high16 v4, 8388608
    goto +3h
    const/high16 v4, 4194304
    or-int/2addr v3, v4
    const v4, 4793491
    and-int/2addr v4, v3
    const v5, 4793490
    if-ne v4, v5, +00eh
    invoke-interface v1, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v4
    if-nez v4, +003h
    goto +6h
    invoke-interface v1, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +250h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +008h
    const/4 v4, -1
    const-string v5, "com.bytedance.trae.design.compose.TraeContextMenuRow (TraeContextMenuPopup.kt:225)"
    invoke-static v0, v3, v4, v5, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-virtual/range v42, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->getTextColor-QN2ZGVo()Landroidx/compose/ui/graphics/Color;
    move-result-object v0
    if-eqz v0, +009h
    invoke-virtual v0, Landroidx/compose/ui/graphics/Color;->unbox-impl()J
    move-result-wide v3
    move-wide/from16 v36, v3
    goto +3h
    move-wide/from16 v36, v7
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    const/4 v3, 0
    const/4 v4, 1
    const/4 v6, 0
    invoke-static v0, v3, v4, v6, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    invoke-static v0, v2, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v16
    invoke-virtual/range v42, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->getKey()Ljava/lang/String;
    move-result-object v0
    const v3, -219829233
    invoke-interface v1, v3, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v1, v0, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v0
    invoke-interface v1, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v3
    if-nez v0, +00ah
    sget-object v0, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v0, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v0
    if-ne v3, v0, +009h
    invoke-static Landroidx/compose/foundation/interaction/InteractionSourceKt;->MutableInteractionSource()Landroidx/compose/foundation/interaction/MutableInteractionSource;
    move-result-object v3
    invoke-interface v1, v3, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v17, v3
    check-cast v17, Landroidx/compose/foundation/interaction/MutableInteractionSource;
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    invoke-virtual/range v42, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->getOnClick()Lkotlin/jvm/functions/Function0;
    move-result-object v22
    const/16 v23, 28
    const/16 v24, 0
    invoke-static/range v16 ... v24, Landroidx/compose/foundation/ClickableKt;->clickable-O2vRcR0$default(Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/interaction/MutableInteractionSource; Landroidx/compose/foundation/Indication; Z Ljava/lang/String; Landroidx/compose/ui/semantics/Role; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    const/4 v5, 0
    add-float v0, v10, v14
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    const/16 v16, 0
    const/16 v17, 10
    move/from16 v4, v44
    move-object/from16 v41, v6
    move v6, v0
    move/from16 v7, v16
    move/from16 v8, v17
    move-object/from16 v9, v18
    invoke-static/range v3 ... v9, Landroidx/compose/foundation/layout/PaddingKt;->padding-qDBjuR0$default(Landroidx/compose/ui/Modifier; F F F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v3, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v3, Landroidx/compose/ui/Alignment$Companion;->getCenterVertically()Landroidx/compose/ui/Alignment$Vertical;
    move-result-object v3
    const v4, 693286680
    const-string v5, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo"
    invoke-static v1, v4, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v4, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v4, Landroidx/compose/foundation/layout/Arrangement;->getStart()Landroidx/compose/foundation/layout/Arrangement$Horizontal;
    move-result-object v4
    const/16 v5, 48
    invoke-static v4, v3, v1, v5, Landroidx/compose/foundation/layout/RowKt;->rowMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Horizontal; Landroidx/compose/ui/Alignment$Vertical; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v3
    const v4, -1323940314
    const-string v5, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
    invoke-static v1, v4, v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v4, 0
    invoke-static v1, v4, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHash(Landroidx/compose/runtime/Composer; I)I
    move-result v5
    invoke-interface v1, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v6
    invoke-static v1, v0, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v7
    const v8, -692256719
    const-string v9, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
    invoke-static v1, v8, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v8
    instance-of v8, v8, Landroidx/compose/runtime/Applier;
    if-nez v8, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v8
    if-eqz v8, +006h
    invoke-interface v1, v7, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v1, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v1, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
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
    invoke-static v7, v0, v3, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v0, -407918630
    const-string v3, "C100@5047L9:Row.kt#2w3rfo"
    invoke-static v1, v0, v3, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v0, Landroidx/compose/foundation/layout/RowScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/RowScopeInstance;
    check-cast v0, Landroidx/compose/foundation/layout/RowScope;
    invoke-virtual/range v42, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->getIcon()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v3
    const v5, 2101314016
    invoke-interface v1, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    if-eqz v3, +04ch
    invoke-static v3, v1, v4, Lorg/jetbrains/compose/resources/ImageResources_androidKt;->painterResource(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/graphics/painter/Painter;
    move-result-object v16
    const/16 v17, 0
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    const/16 v5, 20
    int-to-float v5, v5
    invoke-static v5, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v5
    invoke-static v3, v5, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v18
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    sget-object v22, Landroidx/compose/ui/graphics/ColorFilter;->Companion Landroidx/compose/ui/graphics/ColorFilter$Companion;
    invoke-virtual/range v42, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->getIconTint-QN2ZGVo()Landroidx/compose/ui/graphics/Color;
    move-result-object v3
    if-eqz v3, +009h
    invoke-virtual v3, Landroidx/compose/ui/graphics/Color;->unbox-impl()J
    move-result-wide v5
    move-wide/from16 v23, v5
    goto +3h
    move-wide/from16 v23, v36
    const/16 v25, 0
    const/16 v26, 2
    const/16 v27, 0
    invoke-static/range v22 ... v27, Landroidx/compose/ui/graphics/ColorFilter$Companion;->tint-xETnrds$default(Landroidx/compose/ui/graphics/ColorFilter$Companion; J I I Ljava/lang/Object;)Landroidx/compose/ui/graphics/ColorFilter;
    move-result-object v22
    const/16 v24, 432
    const/16 v25, 56
    move-object/from16 v23, v1
    invoke-static/range v16 ... v25, Landroidx/compose/foundation/ImageKt;->Image(Landroidx/compose/ui/graphics/painter/Painter; Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Landroidx/compose/ui/layout/ContentScale; F Landroidx/compose/ui/graphics/ColorFilter; Landroidx/compose/runtime/Composer; I I)V
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    invoke-static v3, v11, Landroidx/compose/foundation/layout/SizeKt;->width-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v3
    invoke-static v3, v1, v4, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-virtual/range v42, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->getText()Ljava/lang/String;
    move-result-object v3
    sget-object v5, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    const/4 v6, 6
    invoke-virtual v5, v1, v6, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodyBase()Landroidx/compose/ui/text/TextStyle;
    move-result-object v5
    sget-object v6, Landroidx/compose/ui/text/style/TextOverflow;->Companion Landroidx/compose/ui/text/style/TextOverflow$Companion;
    invoke-virtual v6, Landroidx/compose/ui/text/style/TextOverflow$Companion;->getEllipsis-gIe3tQ8()I
    move-result v31
    invoke-virtual/range v42, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->getTrailingIcon()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v6
    if-nez v6, +007h
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    goto +15h
    sget-object v6, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    move-object/from16 v17, v6
    check-cast v17, Landroidx/compose/ui/Modifier;
    const/high16 v18, 1065353216
    const/16 v19, 0
    const/16 v20, 2
    const/16 v21, 0
    move-object/from16 v16, v0
    invoke-static/range v16 ... v21, Landroidx/compose/foundation/layout/RowScope;->weight$default(Landroidx/compose/foundation/layout/RowScope; Landroidx/compose/ui/Modifier; F Z I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    move-object/from16 v17, v0
    const-wide/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const-wide/16 v25, 0
    const/16 v27, 0
    const/16 v28, 0
    const-wide/16 v29, 0
    const/16 v32, 0
    const/16 v33, 1
    const/16 v34, 0
    const/16 v35, 0
    const/16 v38, 0
    const/16 v39, 3120
    const v40, 55288
    move-object/from16 v16, v3
    move-wide/from16 v18, v36
    move-object/from16 v36, v5
    move-object/from16 v37, v1
    invoke-static/range v16 ... v40, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    invoke-virtual/range v42, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->getTrailingIcon()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    const v3, 2101334658
    invoke-interface v1, v3, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    if-nez v0, +003h
    goto +41h
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    invoke-static v3, v13, Landroidx/compose/foundation/layout/SizeKt;->width-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v3
    invoke-static v3, v1, v4, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    invoke-static v0, v1, v4, Lorg/jetbrains/compose/resources/ImageResources_androidKt;->painterResource(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/graphics/painter/Painter;
    move-result-object v16
    const/16 v17, 0
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    invoke-static v0, v12, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v18
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    invoke-virtual/range v42, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->getTrailingIconTint-QN2ZGVo()Landroidx/compose/ui/graphics/Color;
    move-result-object v0
    if-eqz v0, +012h
    sget-object v3, Landroidx/compose/ui/graphics/ColorFilter;->Companion Landroidx/compose/ui/graphics/ColorFilter$Companion;
    invoke-virtual v0, Landroidx/compose/ui/graphics/Color;->unbox-impl()J
    move-result-wide v4
    const/4 v6, 0
    const/4 v7, 2
    const/4 v8, 0
    invoke-static/range v3 ... v8, Landroidx/compose/ui/graphics/ColorFilter$Companion;->tint-xETnrds$default(Landroidx/compose/ui/graphics/ColorFilter$Companion; J I I Ljava/lang/Object;)Landroidx/compose/ui/graphics/ColorFilter;
    move-result-object v0
    move-object/from16 v22, v0
    goto +3h
    move-object/from16 v22, v41
    const/16 v24, 48
    const/16 v25, 56
    move-object/from16 v23, v1
    invoke-static/range v16 ... v25, Landroidx/compose/foundation/ImageKt;->Image(Landroidx/compose/ui/graphics/painter/Painter; Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Landroidx/compose/ui/layout/ContentScale; F Landroidx/compose/ui/graphics/ColorFilter; Landroidx/compose/runtime/Composer; I I)V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v1, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v8
    if-eqz v8, +01fh
    new-instance v9, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;
    move-object v0, v9
    move-object/from16 v1, v42
    move/from16 v2, v43
    move/from16 v3, v44
    move/from16 v4, v45
    move/from16 v5, v46
    move/from16 v6, v47
    move/from16 v7, v48
    move-object v11, v8
    move-object v12, v9
    move-wide/from16 v8, v49
    move/from16 v10, v52
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/design/compose/TraeContextMenuItem; F F F F F F J I)V
    invoke-interface v11, v12, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final TraeContextMenuRow_oeDw4jE$lambda$18(com.bytedance.trae.design.compose.TraeContextMenuItem  float  float  float  float  float  float  long  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 24
    # ins_size=12
    or-int/lit8 v0, v21, 1
    invoke-static v0, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v11
    move-object v1, v12
    move v2, v13
    move v3, v14
    move v4, v15
    move/from16 v5, v16
    move/from16 v6, v17
    move/from16 v7, v18
    move-wide/from16 v8, v19
    move-object/from16 v10, v22
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->TraeContextMenuRow-oeDw4jE(Lcom/bytedance/trae/design/compose/TraeContextMenuItem; F F F F F F J Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final calculateMenuOffset-7bnJ_2g(com.bytedance.trae.design.compose.TraeContextMenuPosition  long  float  float  int  com.bytedance.trae.design.compose.TraeContextMenuShadowPadding  androidx.compose.runtime.Composer  int)androidx.compose.ui.unit.IntOffset
    .registers 16
    # ins_size=9
    const v0, 909711963
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +008h
    const/4 v1, -1
    const-string v2, "com.bytedance.trae.design.compose.calculateMenuOffset (TraeContextMenuPopup.kt:191)"
    invoke-static v0, v15, v1, v2, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-static Landroidx/compose/ui/platform/CompositionLocalsKt;->getLocalDensity()Landroidx/compose/runtime/ProvidableCompositionLocal;
    move-result-object v15
    check-cast v15, Landroidx/compose/runtime/CompositionLocal;
    const v0, 2023513938
    const-string v1, "CC(<get-current>):CompositionLocal.kt#9igjgp"
    invoke-static v14, v0, v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v14, v15, Landroidx/compose/runtime/Composer;->consume(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;
    move-result-object v15
    invoke-static v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    check-cast v15, Landroidx/compose/ui/unit/Density;
    instance-of v0, v7, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;
    const-wide v1, 4294967295
    const/16 v3, 32
    if-eqz v0, +020h
    check-cast v7, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;
    invoke-virtual v7, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->getX-D9Ej5fM()F
    move-result v8
    invoke-interface v15, v8, Landroidx/compose/ui/unit/Density;->roundToPx-0680j_4(F)I
    move-result v8
    invoke-virtual v7, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->getY-D9Ej5fM()F
    move-result v7
    invoke-interface v15, v7, Landroidx/compose/ui/unit/Density;->roundToPx-0680j_4(F)I
    move-result v7
    int-to-long v8, v8
    shl-long/2addr v8, v3
    int-to-long v10, v7
    and-long/2addr v10, v1
    or-long v7, v8, v10
    invoke-static v7, v8, Landroidx/compose/ui/unit/IntOffset;->constructor-impl(J)J
    move-result-wide v7
    goto/16 +088h
    instance-of v0, v7, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Anchored;
    if-eqz v0, +095h
    sget-object v0, Landroidx/compose/ui/unit/IntSize;->Companion Landroidx/compose/ui/unit/IntSize$Companion;
    invoke-virtual v0, Landroidx/compose/ui/unit/IntSize$Companion;->getZero-YbymL2g()J
    move-result-wide v4
    invoke-static v8, v9, v4, v5, Landroidx/compose/ui/unit/IntSize;->equals-impl0(J J)Z
    move-result v0
    if-eqz v0, +004h
    const/4 v7, 0
    goto +79h
    invoke-interface v15, v10, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v10
    invoke-interface v15, v11, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v11
    int-to-float v12, v12
    mul-float/2addr v11, v12
    invoke-virtual v13, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->getStart-D9Ej5fM()F
    move-result v12
    invoke-interface v15, v12, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v12
    add-float/2addr v10, v12
    invoke-virtual v13, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->getEnd-D9Ej5fM()F
    move-result v12
    invoke-interface v15, v12, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v12
    add-float/2addr v10, v12
    invoke-virtual v13, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->getTop-D9Ej5fM()F
    move-result v12
    invoke-interface v15, v12, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v12
    add-float/2addr v12, v11
    invoke-virtual v13, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->getBottom-D9Ej5fM()F
    move-result v0
    invoke-interface v15, v0, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v0
    add-float/2addr v12, v0
    check-cast v7, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Anchored;
    invoke-virtual v7, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Anchored;->getAnchorX()F
    move-result v0
    const/high16 v4, 1073741824
    div-float v5, v10, v4
    sub-float/2addr v0, v5
    shr-long v5, v8, v3
    long-to-int v5, v5
    int-to-float v5, v5
    sub-float/2addr v5, v10
    const/4 v10, 0
    invoke-static v5, v10, Lkotlin/ranges/RangesKt;->coerceAtLeast(F F)F
    move-result v5
    invoke-static v0, v10, v5, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v0
    invoke-virtual v7, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Anchored;->getAnchorY()F
    move-result v7
    invoke-virtual v13, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->getTop-D9Ej5fM()F
    move-result v13
    invoke-interface v15, v13, Landroidx/compose/ui/unit/Density;->toPx-0680j_4(F)F
    move-result v13
    sub-float/2addr v7, v13
    div-float/2addr v11, v4
    sub-float/2addr v7, v11
    and-long/2addr v8, v1
    long-to-int v8, v8
    int-to-float v8, v8
    sub-float/2addr v8, v12
    invoke-static v8, v10, Lkotlin/ranges/RangesKt;->coerceAtLeast(F F)F
    move-result v8
    invoke-static v7, v10, v8, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v7
    invoke-static v0, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v8
    invoke-static v7, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v7
    int-to-long v8, v8
    shl-long/2addr v8, v3
    int-to-long v10, v7
    and-long/2addr v10, v1
    or-long v7, v8, v10
    invoke-static v7, v8, Landroidx/compose/ui/unit/IntOffset;->constructor-impl(J)J
    move-result-wide v7
    invoke-static v7, v8, Landroidx/compose/ui/unit/IntOffset;->box-impl(J)Landroidx/compose/ui/unit/IntOffset;
    move-result-object v7
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v8
    if-eqz v8, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    return-object v7
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
.end method

.method private static final contentDescriptionModifier(java.lang.String)androidx.compose.ui.Modifier
    .registers 5
    # ins_size=1
    if-nez v4, +007h
    sget-object v4, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v4, Landroidx/compose/ui/Modifier;
    goto +11h
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    new-instance v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda3;
    invoke-direct v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt$$ExternalSyntheticLambda3;-><init>(Ljava/lang/String;)V
    const/4 v4, 1
    const/4 v2, 0
    const/4 v3, 0
    invoke-static v0, v3, v1, v4, v2, Landroidx/compose/ui/semantics/SemanticsModifierKt;->semantics$default(Landroidx/compose/ui/Modifier; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v4
    return-object v4
.end method

.method private static final contentDescriptionModifier$lambda$19(java.lang.String  androidx.compose.ui.semantics.SemanticsPropertyReceiver)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "$this$semantics"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v1, Landroidx/compose/ui/semantics/SemanticsPropertiesKt;->setContentDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
