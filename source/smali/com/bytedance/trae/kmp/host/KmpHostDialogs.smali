# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/host/KmpHostDialogs;
.super Ljava/lang/Object;
.source "KmpHostDialogs.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/host/KmpHostDialogs;
.field private static handler:Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;
    invoke-direct v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostDialogs;
    sget-object v0, Lcom/bytedance/trae/kmp/host/NoopKmpHostDialogHandler;->INSTANCE Lcom/bytedance/trae/kmp/host/NoopKmpHostDialogHandler;
    check-cast v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;
    sput-object v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->handler Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic showConfirmDialog$default(com.bytedance.trae.kmp.host.KmpHostDialogs  java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  java.lang.Object)void
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 16
    if-eqz v0, +005h
    const/4 v0, 0
    move v6, v0
    goto +2h
    move v6, v14
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v7, v15
    move-object/from16 v8, v16
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->showConfirmDialog(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final configure(com.bytedance.trae.kmp.host.KmpHostDialogHandler)void
    .registers 3
    # ins_size=2
    const-string v0, "handler"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->handler Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;
    return-void 
.end method

.method public final dismiss()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->handler Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;->dismiss()V
    return-void 
.end method

.method public final showConfirmDialog(java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 17
    # ins_size=8
    const-string/jumbo v0, title
    move-object v2, v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    move-object v3, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cancelText"
    move-object v4, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "confirmText"
    move-object v5, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onConfirm
    move-object v7, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onDismiss
    move-object/from16 v8, v16
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->handler Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;
    move v6, v14
    invoke-interface/range v1 ... v8, Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;->showConfirmDialog(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final showTextInputDialog(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)void
    .registers 17
    # ins_size=8
    const-string/jumbo v0, title
    move-object v2, v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "initialValue"
    move-object v3, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cancelText"
    move-object v5, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "confirmText"
    move-object v6, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onConfirm
    move-object v7, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onDismiss
    move-object/from16 v8, v16
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->handler Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;
    move-object v4, v12
    invoke-interface/range v1 ... v8, Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;->showTextInputDialog(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
