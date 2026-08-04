# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
.super Ljava/lang/Object;
.source "CustomConfirmDialog.kt"


.method public static synthetic $r8$lambda$AOsaid6Gp6eirmSfVihEnVY0Zuw(kotlin.jvm.functions.Function0  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete$lambda$2(Lkotlin/jvm/functions/Function0; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$b7en5X5_zk6uoiBCzQrk2xw7ngk()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete$lambda$1()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nvuQrFXr2xf0wAH_dTaASkqhWvQ()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->rename$lambda$0()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic delete$default(com.bytedance.trae.common.widget.CustomConfirmDialog$Companion  android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  int  int  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  java.lang.Object)com.bytedance.trae.common.widget.CustomConfirmDialog
    .registers 40
    # ins_size=20
    move/from16 v0, v38
    and-int/lit8 v1, v0, 8
    if-eqz v1, +006h
    const-string v1, ""
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v24
    and-int/lit8 v1, v0, 32
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v26
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v27
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v28
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v29
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v30
    and-int/lit16 v1, v0, 1024
    if-eqz v1, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v31
    and-int/lit16 v1, v0, 2048
    if-eqz v1, +004h
    move-object v14, v2
    goto +3h
    move-object/from16 v14, v32
    and-int/lit16 v1, v0, 4096
    if-eqz v1, +004h
    move-object v15, v2
    goto +3h
    move-object/from16 v15, v33
    and-int/lit16 v1, v0, 8192
    if-eqz v1, +006h
    const/4 v1, 0
    move/from16 v16, v1
    goto +3h
    move/from16 v16, v34
    and-int/lit16 v1, v0, 16384
    if-eqz v1, +007h
    sget v1, Lcom/bytedance/trae/common_ui/R$drawable;->trae_bg_custom_dialog_btn_primary I
    move/from16 v17, v1
    goto +3h
    move/from16 v17, v35
    const/high16 v1, 65536
    and-int/2addr v0, v1
    if-eqz v0, +00ah
    new-instance v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion$$ExternalSyntheticLambda0;-><init>()V
    move-object/from16 v19, v0
    goto +3h
    move-object/from16 v19, v37
    move-object/from16 v2, v20
    move-object/from16 v3, v21
    move-object/from16 v4, v22
    move-object/from16 v5, v23
    move-object/from16 v7, v25
    move-object/from16 v18, v36
    invoke-virtual/range v2 ... v19, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v0
    return-object v0
.end method

.method private static final delete$lambda$1()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final delete$lambda$2(kotlin.jvm.functions.Function0  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static synthetic rename$default(com.bytedance.trae.common.widget.CustomConfirmDialog$Companion  android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  int  java.lang.Object)com.bytedance.trae.common.widget.CustomConfirmDialog
    .registers 22
    # ins_size=11
    move/from16 v0, v20
    and-int/lit8 v1, v0, 8
    if-eqz v1, +005h
    const/4 v1, 0
    move-object v6, v1
    goto +2h
    move-object v6, v15
    and-int/lit16 v0, v0, 128
    if-eqz v0, +009h
    new-instance v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion$$ExternalSyntheticLambda1;-><init>()V
    move-object v10, v0
    goto +3h
    move-object/from16 v10, v19
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object/from16 v7, v16
    move-object/from16 v8, v17
    move-object/from16 v9, v18
    invoke-virtual/range v2 ... v10, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->rename(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v0
    return-object v0
.end method

.method private static final rename$lambda$0()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final delete(android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  int  int  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)com.bytedance.trae.common.widget.CustomConfirmDialog
    .registers 45
    # ins_size=18
    move-object/from16 v0, v28
    move-object/from16 v6, v31
    move-object/from16 v2, v43
    const-string v1, "context"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, title
    move-object/from16 v3, v29
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "message"
    move-object/from16 v7, v30
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "cancelText"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "confirmText"
    move-object/from16 v8, v32
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onConfirm"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onCancel"
    move-object/from16 v15, v44
    invoke-static v15, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    move/from16 v20, v1
    new-instance v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    move-object v1, v12
    const/4 v4, 0
    const/4 v5, 0
    const/4 v9, 0
    const/4 v14, 0
    new-instance v10, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion$$ExternalSyntheticLambda2;
    move-object/from16 v21, v10
    invoke-direct v10, v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/functions/Function0;)V
    const/16 v23, 4236
    const/16 v24, 0
    move-object/from16 v2, v29
    move-object/from16 v3, v30
    move-object/from16 v6, v31
    move-object/from16 v7, v32
    move-object/from16 v8, v33
    move-object/from16 v10, v34
    move-object/from16 v11, v35
    move-object/from16 v25, v12
    move-object/from16 v12, v39
    move-object/from16 v26, v13
    move-object/from16 v13, v40
    move/from16 v15, v41
    move/from16 v16, v42
    move-object/from16 v17, v36
    move-object/from16 v18, v37
    move-object/from16 v19, v38
    move-object/from16 v22, v44
    invoke-direct/range v1 ... v24, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v2, v25
    move-object/from16 v1, v26
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;)V
    return-object v1
.end method

.method public final rename(android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)com.bytedance.trae.common.widget.CustomConfirmDialog
    .registers 36
    # ins_size=9
    move-object/from16 v0, v28
    move-object/from16 v2, v29
    move-object/from16 v4, v30
    move-object/from16 v5, v31
    move-object/from16 v6, v32
    move-object/from16 v7, v33
    move-object/from16 v21, v34
    move-object/from16 v22, v35
    const-string v1, "context"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, title
    move-object/from16 v3, v29
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "currentTitle"
    move-object/from16 v3, v30
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "cancelText"
    move-object/from16 v3, v32
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "confirmText"
    move-object/from16 v3, v33
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onConfirm"
    move-object/from16 v3, v34
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onCancel"
    move-object/from16 v3, v35
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v15, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    new-instance v14, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    move-object v1, v14
    const/4 v3, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v16, 0
    move-object/from16 v25, v14
    move/from16 v14, v16
    move-object/from16 v26, v15
    move/from16 v15, v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const v23, 524226
    const/16 v24, 0
    invoke-direct/range v1 ... v24, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v2, v25
    move-object/from16 v1, v26
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;)V
    return-object v1
.end method
