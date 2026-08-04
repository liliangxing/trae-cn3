# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsEntry.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cancelText:Ljava/lang/String;
.field final synthetic $confirmText:Ljava/lang/String;
.field final synthetic $logoutDialogVisible$delegate:Landroidx/compose/runtime/MutableState;
.field final synthetic $logoutMessage:Ljava/lang/String;
.field final synthetic $logoutTitle:Ljava/lang/String;
.field final synthetic $onLogoutConfirmed:Lkotlin/jvm/functions/Function0;
.field  label:I


.method public static synthetic $r8$lambda$lJKwRJtmzA7icHVfHpP-55GBAec(kotlin.jvm.functions.Function0  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->invokeSuspend$lambda$0(Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/MutableState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ldW0PxLmCHm1HYEjXc0BKHVml9g(androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->invokeSuspend$lambda$1(Landroidx/compose/runtime/MutableState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  androidx.compose.runtime.MutableState  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)void
    .registers 8
    # ins_size=8
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$logoutTitle Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$logoutMessage Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$cancelText Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$confirmText Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$logoutDialogVisible$delegate Landroidx/compose/runtime/MutableState;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$onLogoutConfirmed Lkotlin/jvm/functions/Function0;
    const/4 v1, 2
    invoke-direct v0, v1, v7, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(kotlin.jvm.functions.Function0  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 3
    # ins_size=2
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$11(Landroidx/compose/runtime/MutableState; Z)V
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invokeSuspend$lambda$1(androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-static v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$11(Landroidx/compose/runtime/MutableState; Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;
    iget-object v1, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$logoutTitle Ljava/lang/String;
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$logoutMessage Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$cancelText Ljava/lang/String;
    iget-object v4, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$confirmText Ljava/lang/String;
    iget-object v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$logoutDialogVisible$delegate Landroidx/compose/runtime/MutableState;
    iget-object v6, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$onLogoutConfirmed Lkotlin/jvm/functions/Function0;
    move-object v0, v9
    move-object v7, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Landroidx/compose/runtime/MutableState; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/coroutines/Continuation;
    return-object v9
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->label I
    if-nez v0, +030h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$logoutDialogVisible$delegate Landroidx/compose/runtime/MutableState;
    invoke-static v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$10(Landroidx/compose/runtime/MutableState;)Z
    move-result v10
    if-eqz v10, +022h
    sget-object v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostDialogs;
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$logoutTitle Ljava/lang/String;
    iget-object v2, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$logoutMessage Ljava/lang/String;
    iget-object v3, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$cancelText Ljava/lang/String;
    iget-object v4, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$confirmText Ljava/lang/String;
    const/4 v5, 1
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$onLogoutConfirmed Lkotlin/jvm/functions/Function0;
    iget-object v6, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$logoutDialogVisible$delegate Landroidx/compose/runtime/MutableState;
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1$$ExternalSyntheticLambda0;
    invoke-direct v7, v10, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/MutableState;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1;->$logoutDialogVisible$delegate Landroidx/compose/runtime/MutableState;
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1$$ExternalSyntheticLambda1;
    invoke-direct v8, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$1$1$$ExternalSyntheticLambda1;-><init>(Landroidx/compose/runtime/MutableState;)V
    move-object v6, v7
    move-object v7, v8
    invoke-virtual/range v0 ... v7, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->showConfirmDialog(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
.end method
