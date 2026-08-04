# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;
.super Ljava/lang/Object;
.source "AndroidKmpHostDialogHandler.kt"

.implements Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;

.field public static final $stable:I
.field private activeDialog:Ljava/lang/ref/WeakReference;
.field private final activityProvider:Lkotlin/jvm/functions/Function0;


.method public static synthetic $r8$lambda$Ce5amtT-DKeikCqov11i72TkXbQ(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  android.app.Activity)android.app.Dialog
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->showTextInputDialog$lambda$1(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Landroid/app/Activity;)Landroid/app/Dialog;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$DoWTPkeS35o5n2rrq61bmLHLx44(boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  android.app.Activity)android.app.Dialog
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->showConfirmDialog$lambda$3(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Landroid/app/Activity;)Landroid/app/Dialog;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$YW8a3QCQlBReMYmypEGEUceBYNg(com.bytedance.trae.kmp.host.AndroidKmpHostDialogHandler  kotlin.jvm.functions.Function0  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->show$lambda$6$lambda$5(Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler; Lkotlin/jvm/functions/Function0; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$_fWFpPesQnpB6YyABQ7nAHMzWZ8(kotlin.jvm.functions.Function0  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->showConfirmDialog$lambda$3$lambda$2(Lkotlin/jvm/functions/Function0; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$zF5wDAV90tscnUXkFp810P_-j00(kotlin.jvm.functions.Function1  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->showTextInputDialog$lambda$1$lambda$0(Lkotlin/jvm/functions/Function1; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    const-string v0, "activityProvider"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->activityProvider Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method private final show(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->activityProvider Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/app/Activity;
    const/4 v1, 0
    if-eqz v0, +015h
    invoke-virtual v0, Landroid/app/Activity;->isFinishing()Z
    move-result v2
    if-nez v2, +00bh
    invoke-virtual v0, Landroid/app/Activity;->isDestroyed()Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    if-nez v2, +003h
    goto +2h
    move-object v0, v1
    if-nez v0, +006h
    invoke-interface v4, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->dismiss()V
    invoke-interface v5, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Landroid/app/Dialog;
    new-instance v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, v4, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v5, v0, Landroid/app/Dialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    new-instance v4, Ljava/lang/ref/WeakReference;
    invoke-direct v4, v5, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    iput-object v4, v3, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->activeDialog Ljava/lang/ref/WeakReference;
    invoke-virtual v5, Landroid/app/Dialog;->show()V
    return-void 
.end method

.method private static final show$lambda$6$lambda$5(com.bytedance.trae.kmp.host.AndroidKmpHostDialogHandler  kotlin.jvm.functions.Function0  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    const/4 v2, 0
    iput-object v2, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->activeDialog Ljava/lang/ref/WeakReference;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final showConfirmDialog$lambda$3(boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  android.app.Activity)android.app.Dialog
    .registers 34
    # ins_size=7
    move-object/from16 v0, v33
    const-string v1, "it"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v27, +02ah
    sget-object v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
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
    const/16 v18, 0
    const v19, 98272
    const/16 v20, 0
    move-object/from16 v3, v28
    move-object/from16 v4, v29
    move-object/from16 v5, v30
    move-object/from16 v6, v31
    move-object/from16 v17, v32
    invoke-static/range v1 ... v20, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v0
    check-cast v0, Landroid/app/Dialog;
    goto +42h
    new-instance v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    check-cast v0, Landroid/content/Context;
    new-instance v8, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    move-object v2, v8
    const/4 v5, 0
    const/4 v6, 0
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
    new-instance v3, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda4;
    move-object/from16 v22, v3
    move-object/from16 v4, v32
    invoke-direct v3, v4, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda4;-><init>(Lkotlin/jvm/functions/Function0;)V
    const/16 v23, 0
    const v24, 1572812
    const/16 v25, 0
    move-object/from16 v3, v28
    move-object/from16 v4, v29
    move-object/from16 v7, v30
    move-object/from16 v26, v8
    move-object/from16 v8, v31
    invoke-direct/range v2 ... v25, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v2, v26
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;)V
    move-object v0, v1
    check-cast v0, Landroid/app/Dialog;
    return-object v0
.end method

.method private static final showConfirmDialog$lambda$3$lambda$2(kotlin.jvm.functions.Function0  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final showTextInputDialog$lambda$1(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  android.app.Activity)android.app.Dialog
    .registers 20
    # ins_size=7
    move-object/from16 v0, v19
    const-string v1, "it"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    move-object v3, v0
    check-cast v3, Landroid/content/Context;
    new-instance v9, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda3;
    move-object/from16 v0, v18
    invoke-direct v9, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda3;-><init>(Lkotlin/jvm/functions/Function1;)V
    const/4 v10, 0
    const/16 v11, 128
    const/4 v12, 0
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    move-object/from16 v8, v17
    invoke-static/range v2 ... v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->rename$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v0
    check-cast v0, Landroid/app/Dialog;
    return-object v0
.end method

.method private static final showTextInputDialog$lambda$1$lambda$0(kotlin.jvm.functions.Function1  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    if-nez v1, +004h
    const-string v1, ""
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public dismiss()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->activeDialog Ljava/lang/ref/WeakReference;
    if-eqz v0, +00dh
    invoke-virtual v0, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/app/Dialog;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/app/Dialog;->dismiss()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->activeDialog Ljava/lang/ref/WeakReference;
    return-void 
.end method

.method public showConfirmDialog(java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 16
    # ins_size=8
    const-string/jumbo v0, title
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cancelText"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "confirmText"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onConfirm
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onDismiss
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda1;
    move-object v1, v0
    move v2, v13
    move-object v3, v9
    move-object v4, v10
    move-object v5, v11
    move-object v6, v12
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda1;-><init>(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    invoke-direct v8, v15, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->show(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public showTextInputDialog(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)void
    .registers 16
    # ins_size=8
    const-string/jumbo v0, title
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "initialValue"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cancelText"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "confirmText"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onConfirm
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onDismiss
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move-object v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler$$ExternalSyntheticLambda2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    invoke-direct v8, v15, v0, Lcom/bytedance/trae/kmp/host/AndroidKmpHostDialogHandler;->show(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method
