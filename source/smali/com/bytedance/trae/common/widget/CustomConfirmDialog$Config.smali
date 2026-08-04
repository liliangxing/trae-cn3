# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
.super Ljava/lang/Object;
.source "CustomConfirmDialog.kt"

.field private final buttonTopMarginPx:Ljava/lang/Integer;
.field private final cancelBgRes:I
.field private final cancelText:Ljava/lang/String;
.field private final cancelTextColor:Ljava/lang/Integer;
.field private final confirmBgRes:I
.field private final confirmText:Ljava/lang/String;
.field private final confirmTextColor:Ljava/lang/Integer;
.field private final dialogBgRes:I
.field private final dialogWidthPx:Ljava/lang/Integer;
.field private final dimAmount:F
.field private final inputHint:Ljava/lang/String;
.field private final inputText:Ljava/lang/String;
.field private final message:Ljava/lang/String;
.field private final messageGravity:Ljava/lang/Integer;
.field private final messageHorizontalPaddingPx:Ljava/lang/Integer;
.field private final onCancel:Lkotlin/jvm/functions/Function0;
.field private final onConfirm:Lkotlin/jvm/functions/Function1;
.field private final singleButton:Z
.field private final title:Ljava/lang/String;
.field private final titleGravity:Ljava/lang/Integer;
.field private final titleHorizontalPaddingPx:Ljava/lang/Integer;


.method public static synthetic $r8$lambda$7JLCBjDkLfwIIf8QciGfrjF18hI(java.lang.String)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->_init_$lambda$0(Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$FYlV-RL6Jivubspw3an1-W9_TBU()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->_init_$lambda$1()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>()void
    .registers 25
    # ins_size=1
    move-object/from16 v0, v24
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const v22, 2097151
    const/16 v23, 0
    invoke-direct/range v0 ... v23, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  float  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  int  int  int  java.lang.Integer  java.lang.Integer  java.lang.Integer  boolean  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)void
    .registers 29
    # ins_size=22
    move-object v0, v7
    move-object v1, v8
    move-object v2, v12
    move-object v3, v13
    move-object/from16 v4, v27
    move-object/from16 v5, v28
    const-string/jumbo v6, title
    invoke-static v8, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "cancelText"
    invoke-static v12, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "confirmText"
    invoke-static v13, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "onConfirm"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "onCancel"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->title Ljava/lang/String;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->message Ljava/lang/String;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputText Ljava/lang/String;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputHint Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelText Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmText Ljava/lang/String;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogWidthPx Ljava/lang/Integer;
    move v1, v15
    iput v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dimAmount F
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleGravity Ljava/lang/Integer;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleHorizontalPaddingPx Ljava/lang/Integer;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelTextColor Ljava/lang/Integer;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmTextColor Ljava/lang/Integer;
    move/from16 v1, v20
    iput v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogBgRes I
    move/from16 v1, v21
    iput v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelBgRes I
    move/from16 v1, v22
    iput v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmBgRes I
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageGravity Ljava/lang/Integer;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageHorizontalPaddingPx Ljava/lang/Integer;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->buttonTopMarginPx Ljava/lang/Integer;
    move/from16 v1, v26
    iput-boolean v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->singleButton Z
    iput-object v4, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onConfirm Lkotlin/jvm/functions/Function1;
    iput-object v5, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onCancel Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  float  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  int  int  int  java.lang.Integer  java.lang.Integer  java.lang.Integer  boolean  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 46
    # ins_size=24
    move/from16 v0, v44
    and-int/lit8 v1, v0, 1
    const-string v2, ""
    if-eqz v1, +004h
    move-object v1, v2
    goto +3h
    move-object/from16 v1, v23
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    const/4 v3, 0
    goto +3h
    move-object/from16 v3, v24
    and-int/lit8 v5, v0, 4
    if-eqz v5, +004h
    const/4 v5, 0
    goto +3h
    move-object/from16 v5, v25
    and-int/lit8 v6, v0, 8
    if-eqz v6, +004h
    const/4 v6, 0
    goto +3h
    move-object/from16 v6, v26
    and-int/lit8 v7, v0, 16
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v27
    and-int/lit8 v8, v0, 32
    if-eqz v8, +003h
    goto +3h
    move-object/from16 v2, v28
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    const/4 v8, 0
    goto +3h
    move-object/from16 v8, v29
    and-int/lit16 v9, v0, 128
    if-eqz v9, +005h
    const/high16 v9, 1056964608
    goto +3h
    move/from16 v9, v30
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    const/4 v10, 0
    goto +3h
    move-object/from16 v10, v31
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    const/4 v11, 0
    goto +3h
    move-object/from16 v11, v32
    and-int/lit16 v12, v0, 1024
    if-eqz v12, +004h
    const/4 v12, 0
    goto +3h
    move-object/from16 v12, v33
    and-int/lit16 v13, v0, 2048
    if-eqz v13, +004h
    const/4 v13, 0
    goto +3h
    move-object/from16 v13, v34
    and-int/lit16 v14, v0, 4096
    if-eqz v14, +005h
    sget v14, Lcom/bytedance/trae/common_ui/R$drawable;->trae_bg_custom_dialog I
    goto +3h
    move/from16 v14, v35
    and-int/lit16 v15, v0, 8192
    const/16 v16, 0
    if-eqz v15, +005h
    move/from16 v15, v16
    goto +3h
    move/from16 v15, v36
    and-int/lit16 v4, v0, 16384
    if-eqz v4, +005h
    sget v4, Lcom/bytedance/trae/common_ui/R$drawable;->trae_bg_custom_dialog_btn_primary I
    goto +3h
    move/from16 v4, v37
    const v17, 32768
    and-int v17, v0, v17
    if-eqz v17, +005h
    const/16 v17, 0
    goto +3h
    move-object/from16 v17, v38
    const/high16 v18, 65536
    and-int v18, v0, v18
    if-eqz v18, +005h
    const/16 v18, 0
    goto +3h
    move-object/from16 v18, v39
    const/high16 v19, 131072
    and-int v19, v0, v19
    if-eqz v19, +005h
    const/16 v19, 0
    goto +3h
    move-object/from16 v19, v40
    const/high16 v20, 262144
    and-int v20, v0, v20
    if-eqz v20, +003h
    goto +3h
    move/from16 v16, v41
    const/high16 v20, 524288
    and-int v20, v0, v20
    if-eqz v20, +008h
    new-instance v20, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config$$ExternalSyntheticLambda0;
    invoke-direct/range v20, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config$$ExternalSyntheticLambda0;-><init>()V
    goto +3h
    move-object/from16 v20, v42
    const/high16 v21, 1048576
    and-int v0, v0, v21
    if-eqz v0, +008h
    new-instance v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config$$ExternalSyntheticLambda1;-><init>()V
    goto +3h
    move-object/from16 v0, v43
    move-object/from16 v23, v22
    move-object/from16 v24, v1
    move-object/from16 v25, v3
    move-object/from16 v26, v5
    move-object/from16 v27, v6
    move-object/from16 v28, v7
    move-object/from16 v29, v2
    move-object/from16 v30, v8
    move/from16 v31, v9
    move-object/from16 v32, v10
    move-object/from16 v33, v11
    move-object/from16 v34, v12
    move-object/from16 v35, v13
    move/from16 v36, v14
    move/from16 v37, v15
    move/from16 v38, v4
    move-object/from16 v39, v17
    move-object/from16 v40, v18
    move-object/from16 v41, v19
    move/from16 v42, v16
    move-object/from16 v43, v20
    move-object/from16 v44, v0
    invoke-direct/range v23 ... v44, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final _init_$lambda$0(java.lang.String)kotlin.Unit
    .registers 1
    # ins_size=1
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final _init_$lambda$1()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.common.widget.CustomConfirmDialog$Config  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  float  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  int  int  int  java.lang.Integer  java.lang.Integer  java.lang.Integer  boolean  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  int  java.lang.Object)com.bytedance.trae.common.widget.CustomConfirmDialog$Config
    .registers 41
    # ins_size=24
    move-object/from16 v0, v17
    move/from16 v1, v39
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->title Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->message Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputText Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputHint Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelText Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmText Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogWidthPx Ljava/lang/Integer;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget v9, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dimAmount F
    goto +3h
    move/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleGravity Ljava/lang/Integer;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleHorizontalPaddingPx Ljava/lang/Integer;
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelTextColor Ljava/lang/Integer;
    goto +3h
    move-object/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmTextColor Ljava/lang/Integer;
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget v14, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogBgRes I
    goto +3h
    move/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget v15, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelBgRes I
    goto +3h
    move/from16 v15, v31
    move/from16 v31, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget v15, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmBgRes I
    goto +3h
    move/from16 v15, v32
    const v16, 32768
    and-int v16, v1, v16
    move/from16 v32, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageGravity Ljava/lang/Integer;
    goto +3h
    move-object/from16 v15, v33
    const/high16 v16, 65536
    and-int v16, v1, v16
    move-object/from16 v33, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageHorizontalPaddingPx Ljava/lang/Integer;
    goto +3h
    move-object/from16 v15, v34
    const/high16 v16, 131072
    and-int v16, v1, v16
    move-object/from16 v34, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->buttonTopMarginPx Ljava/lang/Integer;
    goto +3h
    move-object/from16 v15, v35
    const/high16 v16, 262144
    and-int v16, v1, v16
    move-object/from16 v35, v15
    if-eqz v16, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->singleButton Z
    goto +3h
    move/from16 v15, v36
    const/high16 v16, 524288
    and-int v16, v1, v16
    move/from16 v36, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onConfirm Lkotlin/jvm/functions/Function1;
    goto +3h
    move-object/from16 v15, v37
    const/high16 v16, 1048576
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onCancel Lkotlin/jvm/functions/Function0;
    goto +3h
    move-object/from16 v1, v38
    move-object/from16 v18, v2
    move-object/from16 v19, v3
    move-object/from16 v20, v4
    move-object/from16 v21, v5
    move-object/from16 v22, v6
    move-object/from16 v23, v7
    move-object/from16 v24, v8
    move/from16 v25, v9
    move-object/from16 v26, v10
    move-object/from16 v27, v11
    move-object/from16 v28, v12
    move-object/from16 v29, v13
    move/from16 v30, v14
    move-object/from16 v37, v15
    move-object/from16 v38, v1
    invoke-virtual/range v17 ... v38, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleHorizontalPaddingPx Ljava/lang/Integer;
    return-object v0
.end method

.method public final component11()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelTextColor Ljava/lang/Integer;
    return-object v0
.end method

.method public final component12()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmTextColor Ljava/lang/Integer;
    return-object v0
.end method

.method public final component13()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogBgRes I
    return v0
.end method

.method public final component14()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelBgRes I
    return v0
.end method

.method public final component15()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmBgRes I
    return v0
.end method

.method public final component16()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageGravity Ljava/lang/Integer;
    return-object v0
.end method

.method public final component17()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageHorizontalPaddingPx Ljava/lang/Integer;
    return-object v0
.end method

.method public final component18()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->buttonTopMarginPx Ljava/lang/Integer;
    return-object v0
.end method

.method public final component19()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->singleButton Z
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component20()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onConfirm Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final component21()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onCancel Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputText Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputHint Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelText Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmText Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogWidthPx Ljava/lang/Integer;
    return-object v0
.end method

.method public final component8()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dimAmount F
    return v0
.end method

.method public final component9()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleGravity Ljava/lang/Integer;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  float  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  int  int  int  java.lang.Integer  java.lang.Integer  java.lang.Integer  boolean  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)com.bytedance.trae.common.widget.CustomConfirmDialog$Config
    .registers 46
    # ins_size=22
    move-object/from16 v1, v25
    move-object/from16 v2, v26
    move-object/from16 v3, v27
    move-object/from16 v4, v28
    move-object/from16 v5, v29
    move-object/from16 v6, v30
    move-object/from16 v7, v31
    move/from16 v8, v32
    move-object/from16 v9, v33
    move-object/from16 v10, v34
    move-object/from16 v11, v35
    move-object/from16 v12, v36
    move/from16 v13, v37
    move/from16 v14, v38
    move/from16 v15, v39
    move-object/from16 v16, v40
    move-object/from16 v17, v41
    move-object/from16 v18, v42
    move/from16 v19, v43
    move-object/from16 v20, v44
    move-object/from16 v21, v45
    const-string/jumbo v0, title
    move-object/from16 v22, v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cancelText"
    move-object/from16 v1, v29
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "confirmText"
    move-object/from16 v1, v30
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onConfirm"
    move-object/from16 v1, v44
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onCancel"
    move-object/from16 v1, v45
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v23, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    move-object/from16 v0, v23
    move-object/from16 v1, v22
    invoke-direct/range v0 ... v21, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)V
    return-object v23
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputHint Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputHint Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogWidthPx Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogWidthPx Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dimAmount F
    iget v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dimAmount F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleGravity Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleGravity Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleHorizontalPaddingPx Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleHorizontalPaddingPx Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelTextColor Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelTextColor Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmTextColor Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmTextColor Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogBgRes I
    iget v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogBgRes I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelBgRes I
    iget v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelBgRes I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmBgRes I
    iget v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmBgRes I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageGravity Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageGravity Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageHorizontalPaddingPx Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageHorizontalPaddingPx Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->buttonTopMarginPx Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->buttonTopMarginPx Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->singleButton Z
    iget-boolean v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->singleButton Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onConfirm Lkotlin/jvm/functions/Function1;
    iget-object v3, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onConfirm Lkotlin/jvm/functions/Function1;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onCancel Lkotlin/jvm/functions/Function0;
    iget-object v5, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onCancel Lkotlin/jvm/functions/Function0;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getButtonTopMarginPx()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->buttonTopMarginPx Ljava/lang/Integer;
    return-object v0
.end method

.method public final getCancelBgRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelBgRes I
    return v0
.end method

.method public final getCancelText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelText Ljava/lang/String;
    return-object v0
.end method

.method public final getCancelTextColor()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelTextColor Ljava/lang/Integer;
    return-object v0
.end method

.method public final getConfirmBgRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmBgRes I
    return v0
.end method

.method public final getConfirmText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmText Ljava/lang/String;
    return-object v0
.end method

.method public final getConfirmTextColor()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmTextColor Ljava/lang/Integer;
    return-object v0
.end method

.method public final getDialogBgRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogBgRes I
    return v0
.end method

.method public final getDialogWidthPx()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogWidthPx Ljava/lang/Integer;
    return-object v0
.end method

.method public final getDimAmount()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dimAmount F
    return v0
.end method

.method public final getInputHint()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputHint Ljava/lang/String;
    return-object v0
.end method

.method public final getInputText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputText Ljava/lang/String;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageGravity()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageGravity Ljava/lang/Integer;
    return-object v0
.end method

.method public final getMessageHorizontalPaddingPx()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageHorizontalPaddingPx Ljava/lang/Integer;
    return-object v0
.end method

.method public final getOnCancel()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onCancel Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnConfirm()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onConfirm Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getSingleButton()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->singleButton Z
    return v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->title Ljava/lang/String;
    return-object v0
.end method

.method public final getTitleGravity()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleGravity Ljava/lang/Integer;
    return-object v0
.end method

.method public final getTitleHorizontalPaddingPx()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleHorizontalPaddingPx Ljava/lang/Integer;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->title Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->message Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputText Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputHint Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelText Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmText Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogWidthPx Ljava/lang/Integer;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dimAmount F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleGravity Ljava/lang/Integer;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleHorizontalPaddingPx Ljava/lang/Integer;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelTextColor Ljava/lang/Integer;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmTextColor Ljava/lang/Integer;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogBgRes I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelBgRes I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmBgRes I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageGravity Ljava/lang/Integer;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageHorizontalPaddingPx Ljava/lang/Integer;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->buttonTopMarginPx Ljava/lang/Integer;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->singleButton Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onConfirm Lkotlin/jvm/functions/Function1;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onCancel Lkotlin/jvm/functions/Function0;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Config(title="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", message="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->message Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", inputText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputText Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", inputHint="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->inputHint Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cancelText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelText Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", confirmText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmText Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", dialogWidthPx="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogWidthPx Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", dimAmount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dimAmount F
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleGravity="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleGravity Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", titleHorizontalPaddingPx="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->titleHorizontalPaddingPx Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cancelTextColor="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelTextColor Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", confirmTextColor="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmTextColor Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", dialogBgRes="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->dialogBgRes I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cancelBgRes="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->cancelBgRes I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", confirmBgRes="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->confirmBgRes I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageGravity="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageGravity Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageHorizontalPaddingPx="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->messageHorizontalPaddingPx Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", buttonTopMarginPx="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->buttonTopMarginPx Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", singleButton="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->singleButton Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", onConfirm="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onConfirm Lkotlin/jvm/functions/Function1;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", onCancel="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->onCancel Lkotlin/jvm/functions/Function0;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
