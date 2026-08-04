# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsContentScreens.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cancelText:Ljava/lang/String;
.field final synthetic $confirmText:Ljava/lang/String;
.field final synthetic $deleteDialog:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
.field final synthetic $deleteMessage:Ljava/lang/String;
.field final synthetic $deleteText:Ljava/lang/String;
.field final synthetic $deleteTitle:Ljava/lang/String;
.field final synthetic $onAction:Lkotlin/jvm/functions/Function1;
.field final synthetic $renameDialog:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
.field final synthetic $renameTitle:Ljava/lang/String;
.field  label:I


.method public static synthetic $r8$lambda$FWUzMYpW-RBIisiuvLDGiQJx7bU(kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementDeleteState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->invokeSuspend$lambda$2(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$MCGM4n9aKuPucO53oieqZS8IdxI(kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementRenameState  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->invokeSuspend$lambda$0(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$a_f_OkMqxmzs9OvSkbsIx9aTf3U(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->invokeSuspend$lambda$1(Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$oMrlKpxDgjNTiGh1flAYBN9GSzQ(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->invokeSuspend$lambda$3(Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementRenameState  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementDeleteState  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)void
    .registers 11
    # ins_size=11
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$renameTitle Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$cancelText Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$confirmText Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteTitle Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteMessage Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteText Ljava/lang/String;
    iput-object v9, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$onAction Lkotlin/jvm/functions/Function1;
    const/4 v1, 2
    invoke-direct v0, v1, v10, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementRenameState  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;->getDevice()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v2
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Ljava/lang/String;)V
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invokeSuspend$lambda$1(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseRename;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseRename;
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invokeSuspend$lambda$2(kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementDeleteState)kotlin.Unit
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$ConfirmDelete;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;->getDevice()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v2
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$ConfirmDelete;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;)V
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invokeSuspend$lambda$3(kotlin.jvm.functions.Function1)kotlin.Unit
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseDelete;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseDelete;
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 14
    # ins_size=3
    new-instance v12, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;
    iget-object v1, v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    iget-object v2, v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$renameTitle Ljava/lang/String;
    iget-object v3, v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$cancelText Ljava/lang/String;
    iget-object v4, v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$confirmText Ljava/lang/String;
    iget-object v5, v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    iget-object v6, v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteTitle Ljava/lang/String;
    iget-object v7, v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteMessage Ljava/lang/String;
    iget-object v8, v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteText Ljava/lang/String;
    iget-object v9, v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$onAction Lkotlin/jvm/functions/Function1;
    move-object v0, v12
    move-object v10, v13
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/coroutines/Continuation;
    return-object v12
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->label I
    if-nez v0, +05fh
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    if-eqz v10, +02bh
    sget-object v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostDialogs;
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$renameTitle Ljava/lang/String;
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;->getDevice()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->getName()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    iget-object v4, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$cancelText Ljava/lang/String;
    iget-object v5, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$confirmText Ljava/lang/String;
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$onAction Lkotlin/jvm/functions/Function1;
    iget-object v6, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda0;
    invoke-direct v7, v10, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$onAction Lkotlin/jvm/functions/Function1;
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda1;
    invoke-direct v8, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function1;)V
    move-object v6, v7
    move-object v7, v8
    invoke-virtual/range v0 ... v7, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->showTextInputDialog(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)V
    goto +2bh
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    if-eqz v10, +023h
    sget-object v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostDialogs;
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteTitle Ljava/lang/String;
    iget-object v2, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteMessage Ljava/lang/String;
    iget-object v3, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$cancelText Ljava/lang/String;
    iget-object v4, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteText Ljava/lang/String;
    const/4 v5, 1
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$onAction Lkotlin/jvm/functions/Function1;
    iget-object v6, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda2;
    invoke-direct v7, v10, v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;)V
    iget-object v10, v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1;->$onAction Lkotlin/jvm/functions/Function1;
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda3;
    invoke-direct v8, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda3;-><init>(Lkotlin/jvm/functions/Function1;)V
    move-object v6, v7
    move-object v7, v8
    invoke-virtual/range v0 ... v7, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->showConfirmDialog(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    goto +6h
    sget-object v10, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostDialogs;
    invoke-virtual v10, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->dismiss()V
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
.end method
