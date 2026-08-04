# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/host/NoopKmpHostDialogHandler;
.super Ljava/lang/Object;
.source "KmpHostDialogs.kt"

.implements Lcom/bytedance/trae/kmp/host/KmpHostDialogHandler;

.field public static final INSTANCE:Lcom/bytedance/trae/kmp/host/NoopKmpHostDialogHandler;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/host/NoopKmpHostDialogHandler;
    invoke-direct v0, Lcom/bytedance/trae/kmp/host/NoopKmpHostDialogHandler;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/host/NoopKmpHostDialogHandler;->INSTANCE Lcom/bytedance/trae/kmp/host/NoopKmpHostDialogHandler;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public dismiss()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public showConfirmDialog(java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 8
    # ins_size=8
    const-string/jumbo v5, title
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "message"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "cancelText"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "confirmText"
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, onConfirm
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, onDismiss
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public showTextInputDialog(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)void
    .registers 8
    # ins_size=8
    const-string/jumbo v3, title
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "initialValue"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "cancelText"
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "confirmText"
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, onConfirm
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, onDismiss
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method
