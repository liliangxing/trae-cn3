# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "DeviceActivateBottomSheet.kt"

.field private static final ARG_DEVICE_ID:Ljava/lang/String;
.field private static final ARG_DEVICE_NAME:Ljava/lang/String;
.field private static final ARG_ENTER_FROM:Ljava/lang/String;
.field private static final ARG_IS_PAIRED:Ljava/lang/String;
.field private static final ARG_PRODUCT_TYPE:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$Companion;
.field private static final DEFAULT_TARGET:Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
.field private static final POLL_INTERVAL_MS:J
.field public static final TAG:Ljava/lang/String;
.field private onDismissListener:Lkotlin/jvm/functions/Function0;
.field private onUnpairedDeviceOnline:Lkotlin/jvm/functions/Function1;
.field private pollingJob:Lkotlinx/coroutines/Job;
.field private final repository:Lcom/bytedance/trae/conversation/CliListRepository;
.field private target:Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;


.method public static synthetic $r8$lambda$50dr50hdOpz1qRe2sZCQZYYoIpo(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->onCreateDialog$lambda$1(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$u4imDg5lsdy68d2asMFAnep1p98(com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->onViewCreated$lambda$2(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 10
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    const-string v3, ""
    const-string v4, ""
    sget-object v5, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 24
    const/4 v9, 0
    move-object v2, v0
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->DEFAULT_TARGET Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->repository Lcom/bytedance/trae/conversation/CliListRepository;
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->DEFAULT_TARGET Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->target Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    return-void 
.end method

.method public static final synthetic access$getRepository$p(com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet)com.bytedance.trae.conversation.CliListRepository
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->repository Lcom/bytedance/trae/conversation/CliListRepository;
    return-object v0
.end method

.method public static final synthetic access$getTarget$p(com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet)com.bytedance.trae.conversation.devices.OfflineDeviceTarget
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->target Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    return-object v0
.end method

.method private final descriptionRes(com.bytedance.trae.conversation.devices.DeviceProductType)int
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +00eh
    const/4 v0, 2
    if-ne v2, v0, +005h
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_device_activate_ide_description I
    goto +9h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_device_activate_work_description I
    return v2
.end method

.method private static final onCreateDialog$lambda$1(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet  android.content.DialogInterface)void
    .registers 4
    # ins_size=3
    sget v3, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +02dh
    const v3, 17170445
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v0, Lcom/bytedance/trae/conversation/R$dimen;->trae_device_activate_sheet_height I
    invoke-virtual v2, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    invoke-virtual v3, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v0, 3
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    invoke-virtual v1, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    iput v2, v3, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v1, v3, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.conversation.devices.DeviceActivateBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    move-object v1, v0
    check-cast v1, Landroidx/fragment/app/Fragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v1
    if-eqz v1, +010h
    invoke-interface v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->onRouteBack()Z
    move-result v1
    if-eqz v1, +00dh
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->onDismissListener Lkotlin/jvm/functions/Function0;
    if-eqz v0, +009h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +4h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->dismiss()V
    return-void 
.end method

.method private final readTarget()com.bytedance.trae.conversation.devices.OfflineDeviceTarget
    .registers 9
    # ins_size=1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->DEFAULT_TARGET Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    return-object v0
    const-string v1, "arg_product_type"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +027h
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v8
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-eqz v1, +003h
    goto +3h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-object v5, v1
    new-instance v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    const-string v2, "arg_device_id"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const-string v3, ""
    if-nez v2, +004h
    move-object v4, v3
    goto +2h
    move-object v4, v2
    const-string v2, "arg_device_name"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v6, v3
    goto +2h
    move-object v6, v2
    const-string v2, "arg_is_paired"
    const/4 v3, 1
    invoke-virtual v0, v2, v3, Landroid/os/Bundle;->getBoolean(Ljava/lang/String; Z)Z
    move-result v7
    const-string v2, "arg_enter_from"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "device_list"
    move-object v2, v1
    move-object v3, v4
    move-object v4, v6
    move v6, v7
    move-object v7, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Ljava/lang/String;)V
    return-object v1
    :try_start_0x11
.end method

.method private final renderTarget(android.view.View)void
    .registers 4
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_device_activate_title I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_device_activate_title I
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_device_activate_description I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->target Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->descriptionRes(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)I
    move-result v0
    invoke-virtual v3, v0, Landroid/widget/TextView;->setText(I)V
    return-void 
.end method

.method private final startPolling()void
    .registers 8
    # ins_size=1
    invoke-direct v7, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->stopPolling()V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "offline_device_poll_start: target="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->target Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "DeviceActivateBottomSheet"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$startPolling$1;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v7, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final stopPolling()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->pollingJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final trackPageView()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->target Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    if-eq v0, v1, +00eh
    const/4 v1, 2
    if-ne v0, v1, +005h
    const-string v0, "ide"
    goto +9h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    const-string v0, "pc"
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackOfflineDevicePageView(Ljava/lang/String;)V
    return-void 
.end method

.method public final getOnDismissListener()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->onDismissListener Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnUnpairedDeviceOnline()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->onUnpairedDeviceOnline Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_bottom_sheet_device_activate I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDestroyView()V
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->stopPolling()V
    return-void 
.end method

.method public onDismiss(android.content.DialogInterface)void
    .registers 4
    # ins_size=2
    const-string v0, "dialog"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDismiss(Landroid/content/DialogInterface;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->stopPolling()V
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "offline_device_dismiss: target="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->target Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "DeviceActivateBottomSheet"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->onDismissListener Lkotlin/jvm/functions/Function0;
    if-eqz v3, +005h
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v2, v3, v4, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->readTarget()Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-result-object v4
    iput-object v4, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->target Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "offline_device_page_render: target="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->target Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", stateSaved="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isAdded="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->isAdded()Z
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", lifecycle="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v1
    invoke-virtual v1, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "DeviceActivateBottomSheet"
    invoke-virtual v4, v1, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->renderTarget(Landroid/view/View;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->trackPageView()V
    sget v4, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v3, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;)V
    invoke-virtual v3, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->target Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getDeviceId()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +006h
    invoke-direct v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->startPolling()V
    goto +8h
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v4, "offline_device_poll_skip: reason=empty_target"
    invoke-virtual v3, v1, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final setOnDismissListener(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->onDismissListener Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnUnpairedDeviceOnline(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->onUnpairedDeviceOnline Lkotlin/jvm/functions/Function1;
    return-void 
.end method
