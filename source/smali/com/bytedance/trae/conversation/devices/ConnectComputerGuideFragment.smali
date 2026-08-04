# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "ConnectComputerGuideFragment.kt"

.field private static final ARG_DEVICE_ID:Ljava/lang/String;
.field private static final ARG_DEVICE_NAME:Ljava/lang/String;
.field private static final ARG_EMBEDDED_PRESENTATION:Ljava/lang/String;
.field private static final ARG_ENTER_FROM:Ljava/lang/String;
.field private static final ARG_EXISTING_DEVICE_IDS:Ljava/lang/String;
.field private static final ARG_ONLINE_DEVICE_IDS:Ljava/lang/String;
.field private static final ARG_PRODUCT_TYPE:Ljava/lang/String;
.field private static final ARG_TRIGGER_BY:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;
.field private static final DEFAULT_BINDING_TARGET:Lcom/bytedance/trae/conversation/devices/BindingTarget;
.field public static final ENTER_FROM_CODE_ADD_DEVICE:Ljava/lang/String;
.field public static final ENTER_FROM_DEVICE_ACTIVATE:Ljava/lang/String;
.field public static final ENTER_FROM_DEVICE_LIST:Ljava/lang/String;
.field public static final ENTER_FROM_NEW_FEATURE_POPUP:Ljava/lang/String;
.field public static final ENTER_FROM_NEW_TASK:Ljava/lang/String;
.field public static final ENTER_FROM_SETTINGS_DEVICE_MANAGEMENT:Ljava/lang/String;
.field private static final STATE_PAGE_EXPOSURE_REPORTED:Ljava/lang/String;
.field private static final STATE_PAIRING_RESULT_REPORTED:Ljava/lang/String;
.field private static final STATE_PAIRING_STARTED_AT_MILLIS:Ljava/lang/String;
.field private static final STATE_STEP1_COMPLETED_REPORTED:Ljava/lang/String;
.field private static final STATE_STEP2_EXPOSURE_REPORTED:Ljava/lang/String;
.field private static final STATUS_SPINNER_DURATION_MS:J
.field private static final SUCCESS_DISPLAY_DURATION_MS:J
.field private _binding:Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
.field private bindingTarget:Lcom/bytedance/trae/conversation/devices/BindingTarget;
.field private onConnectionSuccessListener:Lkotlin/jvm/functions/Function1;
.field private onDismissListener:Lkotlin/jvm/functions/Function0;
.field private pageExposureGate:Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
.field private pairingEventTracker:Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;
.field private pairingFunnelEventTracker:Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;
.field private pairingStartedAtMillis:J
.field private statusSpinnerAnimator:Landroid/animation/ObjectAnimator;
.field private statusSpinnerView:Landroid/widget/ImageView;
.field private successJob:Lkotlinx/coroutines/Job;
.field private viewModel:Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;


.method public static synthetic $r8$lambda$4bwMmUUXeXICxxsMQj0bZz1Q4WY(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onViewCreated$lambda$4(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$4kV_p9nkQMMNqxJg9ElgPSIhftI(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onViewCreated$lambda$5(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$51Wu40SotT3e7lp7eBNPzQ0iNEg(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  android.content.ComponentName)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onViewCreated$lambda$8$lambda$7(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment; Landroid/content/ComponentName;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$BoUd32lFF4SzMdF7yqB8fMv9sFs(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  com.bytedance.trae.conversation.tracker.DevicePairingTerminalResult)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onViewCreated$lambda$3(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment; Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$DQ5VjRyT0ojKc8YO7HDbmQyuUiI(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onViewCreated$lambda$6(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$mpoNpq2tmsAL_nvAgxF3ixXidE0(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onViewCreated$lambda$8(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$yMMGVmG0ppgkFErdb7Qh9g5one0(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onCreateDialog$lambda$1(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 11
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->Companion Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    sget-object v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v4
    const-string v5, "new_task"
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 56
    const/4 v10, 0
    move-object v2, v0
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->DEFAULT_BINDING_TARGET Lcom/bytedance/trae/conversation/devices/BindingTarget;
    return-void 
.end method

.method public constructor <init>()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->DEFAULT_BINDING_TARGET Lcom/bytedance/trae/conversation/devices/BindingTarget;
    iput-object v0, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    const/4 v1, 1
    const/4 v2, 0
    const/4 v3, 0
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pageExposureGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    return-void 
.end method

.method public static final synthetic access$completeConnectionSuccess(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->completeConnectionSuccess()V
    return-void 
.end method

.method public static final synthetic access$getPairingEventTracker$p(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment)com.bytedance.trae.conversation.tracker.DevicePairingEventTracker
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;
    return-object v0
.end method

.method public static final synthetic access$getViewModel$p(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment)com.bytedance.trae.conversation.devices.ConnectComputerGuideViewModel
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->viewModel Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    return-object v0
.end method

.method public static final synthetic access$renderBindingState(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  com.bytedance.trae.conversation.devices.BindingGuideStableState)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->renderBindingState(Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;)V
    return-void 
.end method

.method public static final synthetic access$scheduleSuccessCompletion(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->scheduleSuccessCompletion()V
    return-void 
.end method

.method private final completeConnectionSuccess()void
    .registers 11
    # ins_size=1
    iget-object v0, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->viewModel Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->consumeSucceededDevice()Lcom/bytedance/trae/conversation/devices/MobileDevice;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    iget-object v1, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    const/4 v2, 0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getExistingDeviceIds()Ljava/util/Set;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/collections/SetsKt;->plus(Ljava/util/Set; Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getName()Ljava/lang/String;
    move-result-object v7
    const/16 v8, 13
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/conversation/devices/BindingTarget;->copy$default(Lcom/bytedance/trae/conversation/devices/BindingTarget; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-result-object v1
    iput-object v1, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getContext()Landroid/content/Context;
    move-result-object v1
    if-eqz v1, +01bh
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_setting_device_online I
    const/4 v3, 1
    new-array v3, v3, [Ljava/lang/Object;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getName()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    aput-object v4, v3, v5
    invoke-virtual v10, v2, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v1, v2, v5, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    move-object v1, v10
    check-cast v1, Landroidx/fragment/app/Fragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v1
    if-eqz v1, +006h
    invoke-interface v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->notifyConnectionSuccessWithDevice(Lcom/bytedance/trae/conversation/devices/MobileDevice;)V
    goto +12h
    invoke-direct v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->isEmbeddedPresentation()Z
    move-result v1
    if-eqz v1, +00ah
    iget-object v1, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onConnectionSuccessListener Lkotlin/jvm/functions/Function1;
    if-eqz v1, +009h
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +4h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->dismissAllowingStateLoss()V
    return-void 
.end method

.method private final displayUrl()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;->displayUrl(Z)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final downloadUrl()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;->downloadUrl(Z)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final getBinding()com.bytedance.trae.conversation.databinding.FragmentConnectComputerGuideBinding
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->_binding Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v0
.end method

.method private final isEmbeddedPresentation()boolean
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ch
    const-string v2, "arg_embedded_presentation"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    return v1
.end method

.method private final loadHeroGif(int)void
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, res:///
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v3
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->newDraweeControllerBuilder()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setUri(Landroid/net/Uri;)Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v3
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setAutoPlayAnimations(Z)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-direct v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->ivConnectGuideImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v0
    invoke-virtual v3, v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;
    move-result-object v3
    invoke-direct v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v0
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->ivConnectGuideImage Lcom/facebook/drawee/view/SimpleDraweeView;
    check-cast v3, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v0, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
.end method

.method private final observeBindingState()void
    .registers 8
    # ins_size=1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$observeBindingState$1;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final onCreateDialog$lambda$1(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  android.content.DialogInterface)void
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
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v0, Lcom/bytedance/trae/conversation/R$dimen;->trae_connect_guide_sheet_height I
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

.method private static final onViewCreated$lambda$3(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  com.bytedance.trae.conversation.tracker.DevicePairingTerminalResult)kotlin.Unit
    .registers 11
    # ins_size=2
    const-string/jumbo v0, result
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->getDurationMillis()J
    move-result-wide v2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->isSuccess()Z
    move-result v4
    iget-object v0, v9, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getEnterFrom()Ljava/lang/String;
    move-result-object v5
    iget-object v0, v9, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v6
    invoke-virtual v10, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->getResultDetail()Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    move-result-object v7
    iget-object v9, v9, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getTriggerBy()Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    move-result-object v8
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackPairResult$conversation_mainlandRelease(J Z Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment)kotlin.Unit
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getEnterFrom()Ljava/lang/String;
    move-result-object v1
    iget-object v2, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackPairingStep1Complete(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment)kotlin.Unit
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getEnterFrom()Ljava/lang/String;
    move-result-object v1
    iget-object v2, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackPairingStep2Show(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onViewCreated$lambda$6(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->reportPairingExitIfNeeded()V
    move-object v1, v0
    check-cast v1, Landroidx/fragment/app/Fragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v1
    if-eqz v1, +006h
    invoke-interface v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->onRouteBack()Z
    goto +4h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$8(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  android.view.View)void
    .registers 12
    # ins_size=2
    sget-object v11, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    iget-object v0, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getEnterFrom()Ljava/lang/String;
    move-result-object v0
    iget-object v1, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    invoke-virtual v11, v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackPairingPageShareClick(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getContext()Landroid/content/Context;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/share/ShareUtils;->INSTANCE Lcom/bytedance/trae/conversation/share/ShareUtils;
    invoke-direct v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->downloadUrl()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda0;
    invoke-direct v7, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    const/16 v8, 12
    const/4 v9, 0
    invoke-static/range v2 ... v9, Lcom/bytedance/trae/conversation/share/ShareUtils;->shareLink$default(Lcom/bytedance/trae/conversation/share/ShareUtils; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Z
    return-void 
.end method

.method private static final onViewCreated$lambda$8$lambda$7(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment  android.content.ComponentName)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "component"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    iget-object v2, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getEnterFrom()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, Landroid/content/ComponentName;->getPackageName()Ljava/lang/String;
    move-result-object v3
    const-string v1, "getPackageName(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackShareChannelSelect(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final readBindingTarget()com.bytedance.trae.conversation.devices.BindingTarget
    .registers 11
    # ins_size=1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-nez v0, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->DEFAULT_BINDING_TARGET Lcom/bytedance/trae/conversation/devices/BindingTarget;
    return-object v0
    const-string v1, "arg_product_type"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +027h
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v3, v10
    check-cast v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-eqz v1, +003h
    goto +3h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-object v4, v1
    const-string v1, "arg_existing_device_ids"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;
    move-result-object v1
    if-eqz v1, +005h
    check-cast v1, Ljava/util/List;
    goto +eh
    const-string v1, "arg_online_device_ids"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;
    move-result-object v1
    if-eqz v1, +003h
    goto -bh
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v5
    const-string v1, "arg_enter_from"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, "new_task"
    move-object v6, v1
    const-string v1, "arg_trigger_by"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +029h
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v3, v10
    check-cast v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    if-eqz v2, +004h
    move-object v7, v2
    goto +4h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->CONNECT_BUTTON Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    move-object v7, v1
    const-string v1, "arg_device_id"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    const-string v1, "arg_device_name"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    new-instance v0, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-object v3, v0
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    :try_start_0x12
    :try_start_0x6b
.end method

.method private final renderBindingState(com.bytedance.trae.conversation.devices.BindingGuideStableState)void
    .registers 10
    # ins_size=2
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_status_primary_default I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_status_success_default I
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_disabled I
    invoke-static v4, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    instance-of v5, v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForDesktop;
    const-string v6, "ivStep2Status"
    const-string v7, "ivStep1Status"
    if-eqz v5, +058h
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->step1Card Lcom/google/android/material/card/MaterialCardView;
    invoke-virtual v9, v0, Lcom/google/android/material/card/MaterialCardView;->setStrokeColor(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->ivStep1Status Landroid/widget/ImageView;
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->showWaitingStatus(Landroid/widget/ImageView;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep1Status Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_connect_guide_waiting_connection I
    invoke-virtual v9, v0, Landroid/widget/TextView;->setText(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep1Status Landroid/widget/TextView;
    invoke-virtual v9, v2, Landroid/widget/TextView;->setTextColor(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->step2Card Lcom/google/android/material/card/MaterialCardView;
    invoke-virtual v9, v1, Lcom/google/android/material/card/MaterialCardView;->setStrokeColor(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->ivStep2Status Landroid/widget/ImageView;
    invoke-static v9, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_connect_guide_inactive I
    invoke-direct v8, v9, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->showStaticStatus(Landroid/widget/ImageView; I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep2Status Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_connect_guide_awaiting_authorization I
    invoke-virtual v9, v0, Landroid/widget/TextView;->setText(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep2Status Landroid/widget/TextView;
    invoke-virtual v9, v4, Landroid/widget/TextView;->setTextColor(I)V
    goto/16 +0c3h
    instance-of v4, v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$WaitingForAuthorization;
    if-eqz v4, +05eh
    iget-object v9, v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingFunnelEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;
    if-eqz v9, +005h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->onAuthorizationStepAvailable()V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->step1Card Lcom/google/android/material/card/MaterialCardView;
    invoke-virtual v9, v1, Lcom/google/android/material/card/MaterialCardView;->setStrokeColor(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->ivStep1Status Landroid/widget/ImageView;
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->checkmark_circle_1 I
    invoke-direct v8, v9, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->showStaticStatus(Landroid/widget/ImageView; I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep1Status Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_connect_guide_connected_to_pc I
    invoke-virtual v9, v1, Landroid/widget/TextView;->setText(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep1Status Landroid/widget/TextView;
    invoke-virtual v9, v3, Landroid/widget/TextView;->setTextColor(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->step2Card Lcom/google/android/material/card/MaterialCardView;
    invoke-virtual v9, v0, Lcom/google/android/material/card/MaterialCardView;->setStrokeColor(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->ivStep2Status Landroid/widget/ImageView;
    invoke-static v9, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->showWaitingStatus(Landroid/widget/ImageView;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep2Status Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_connect_guide_awaiting_authorization I
    invoke-virtual v9, v0, Landroid/widget/TextView;->setText(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep2Status Landroid/widget/TextView;
    invoke-virtual v9, v2, Landroid/widget/TextView;->setTextColor(I)V
    goto +62h
    instance-of v9, v9, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;
    if-eqz v9, +060h
    iget-object v9, v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingFunnelEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;
    if-eqz v9, +005h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->onAuthorizationStepAvailable()V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->step1Card Lcom/google/android/material/card/MaterialCardView;
    invoke-virtual v9, v1, Lcom/google/android/material/card/MaterialCardView;->setStrokeColor(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->ivStep1Status Landroid/widget/ImageView;
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->checkmark_circle_1 I
    invoke-direct v8, v9, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->showStaticStatus(Landroid/widget/ImageView; I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep1Status Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_connect_guide_connected_to_pc I
    invoke-virtual v9, v1, Landroid/widget/TextView;->setText(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep1Status Landroid/widget/TextView;
    invoke-virtual v9, v3, Landroid/widget/TextView;->setTextColor(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->step2Card Lcom/google/android/material/card/MaterialCardView;
    invoke-virtual v9, v0, Lcom/google/android/material/card/MaterialCardView;->setStrokeColor(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->ivStep2Status Landroid/widget/ImageView;
    invoke-static v9, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->checkmark_circle_1 I
    invoke-direct v8, v9, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->showStaticStatus(Landroid/widget/ImageView; I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep2Status Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_connect_guide_connected I
    invoke-virtual v9, v0, Landroid/widget/TextView;->setText(I)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep2Status Landroid/widget/TextView;
    invoke-virtual v9, v3, Landroid/widget/TextView;->setTextColor(I)V
    return-void 
    new-instance v9, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v9, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v9
.end method

.method private final renderBindingTarget()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;->content(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->getHeroRes()I
    move-result v1
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->loadHeroGif(I)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep1 Landroid/widget/TextView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->getStep1Res()I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(I)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->traeUrl Landroid/widget/TextView;
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->displayUrl()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v1
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep2 Landroid/widget/TextView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;->getStep2Res()I
    move-result v0
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(I)V
    return-void 
.end method

.method private final reportPairingExitIfNeeded()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;
    if-nez v0, +003h
    return-void 
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->viewModel Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    if-eqz v1, +021h
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->getState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/BindingGuideState;
    invoke-interface v1, Lcom/bytedance/trae/conversation/devices/BindingGuideState;->getDisplayState()Lcom/bytedance/trae/conversation/devices/BindingGuideStableState;
    move-result-object v1
    instance-of v1, v1, Lcom/bytedance/trae/conversation/devices/BindingGuideStableState$Succeeded;
    if-eqz v1, +006h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->onPairingSucceeded()V
    return-void 
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingFunnelEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;
    const/4 v2, 0
    if-eqz v1, +00ah
    invoke-virtual v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->isStep1Reported()Z
    move-result v1
    const/4 v3, 1
    if-ne v1, v3, +003h
    move v2, v3
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->onPairingExited(Z)V
    return-void 
.end method

.method private final scheduleSuccessCompletion()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->successJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +003h
    return-void 
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$scheduleSuccessCompletion$1;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v7, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->successJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final showStaticStatus(android.widget.ImageView  int)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->statusSpinnerView Landroid/widget/ImageView;
    if-ne v0, v2, +005h
    invoke-direct v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->stopStatusSpinner()V
    const/4 v0, 0
    invoke-virtual v2, v0, Landroid/widget/ImageView;->setRotation(F)V
    invoke-virtual v2, v3, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
.end method

.method private final showWaitingStatus(android.widget.ImageView)void
    .registers 5
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_connect_guide_waiting I
    invoke-virtual v4, v0, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->statusSpinnerView Landroid/widget/ImageView;
    if-ne v0, v4, +012h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->statusSpinnerAnimator Landroid/animation/ObjectAnimator;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroid/animation/ObjectAnimator;->isStarted()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +003h
    return-void 
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->stopStatusSpinner()V
    const/4 v0, 0
    invoke-virtual v4, v0, Landroid/widget/ImageView;->setRotation(F)V
    iput-object v4, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->statusSpinnerView Landroid/widget/ImageView;
    sget-object v0, Landroid/view/View;->ROTATION Landroid/util/Property;
    const/4 v1, 2
    new-array v1, v1, [F
    fill-array-data v1, +0000021h
    invoke-static v4, v0, v1, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object; Landroid/util/Property; [F)Landroid/animation/ObjectAnimator;
    move-result-object v4
    const-wide/16 v0, 1000
    invoke-virtual v4, v0, v1, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;
    new-instance v0, Landroid/view/animation/LinearInterpolator;
    invoke-direct v0, Landroid/view/animation/LinearInterpolator;-><init>()V
    check-cast v0, Landroid/animation/TimeInterpolator;
    invoke-virtual v4, v0, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    const/4 v0, -1
    invoke-virtual v4, v0, Landroid/animation/ObjectAnimator;->setRepeatCount(I)V
    invoke-virtual v4, Landroid/animation/ObjectAnimator;->start()V
    iput-object v4, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->statusSpinnerAnimator Landroid/animation/ObjectAnimator;
    return-void 
    nop 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\xb4C' | \x00\x00\x00\x00\x00\x00\xb4\x43
.end method

.method private final stopStatusSpinner()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->statusSpinnerAnimator Landroid/animation/ObjectAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ObjectAnimator;->cancel()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->statusSpinnerView Landroid/widget/ImageView;
    if-eqz v0, +006h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setRotation(F)V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->statusSpinnerAnimator Landroid/animation/ObjectAnimator;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->statusSpinnerView Landroid/widget/ImageView;
    return-void 
.end method

.method public final getOnConnectionSuccessListener()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onConnectionSuccessListener Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnDismissListener()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onDismissListener Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getTargetProductType()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->readBindingTarget()Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
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
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda1;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 4
    # ins_size=4
    const-string v3, "inflater"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    invoke-static v1, v2, v3, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->_binding Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v1
    const-string v2, "getRoot(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method public onDestroyView()void
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00ah
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->isChangingConfigurations()Z
    move-result v0
    if-ne v0, v2, +004h
    move v0, v2
    goto +2h
    move v0, v1
    if-nez v0, +005h
    invoke-direct v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->reportPairingExitIfNeeded()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->viewModel Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    const/4 v3, 0
    if-eqz v0, +00eh
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->stop()V
    invoke-direct v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->stopStatusSpinner()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->successJob Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v3, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->successJob Lkotlinx/coroutines/Job;
    iput-object v3, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;
    iput-object v3, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingFunnelEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;
    iput-object v3, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onConnectionSuccessListener Lkotlin/jvm/functions/Function1;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-eqz v0, +009h
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->isChangingConfigurations()Z
    move-result v0
    if-ne v0, v2, +003h
    move v1, v2
    if-nez v1, +00bh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pageExposureGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->reset()V
    const-wide/16 v0, 0
    iput-wide v0, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingStartedAtMillis J
    iput-object v3, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->_binding Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    invoke-super v4, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDestroyView()V
    return-void 
.end method

.method public onDismiss(android.content.DialogInterface)void
    .registers 4
    # ins_size=2
    const-string v0, "dialog"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->reportPairingExitIfNeeded()V
    invoke-super v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDismiss(Landroid/content/DialogInterface;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->viewModel Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    const/4 v0, 0
    if-eqz v3, +00eh
    if-nez v3, +009h
    const-string/jumbo v3, viewModel
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->stop()V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->successJob Lkotlinx/coroutines/Job;
    if-eqz v3, +006h
    const/4 v1, 1
    invoke-static v3, v0, v1, v0, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->successJob Lkotlinx/coroutines/Job;
    iget-object v3, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onDismissListener Lkotlin/jvm/functions/Function0;
    if-eqz v3, +005h
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public onSaveInstanceState(android.os.Bundle)void
    .registers 6
    # ins_size=2
    const-string v0, "outState"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v4, v5, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onSaveInstanceState(Landroid/os/Bundle;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pageExposureGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed()Z
    move-result v0
    const-string/jumbo v1, state_page_exposure_reported
    invoke-virtual v5, v1, v0, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    const-string/jumbo v0, state_pairing_started_at_millis
    iget-wide v1, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingStartedAtMillis J
    invoke-virtual v5, v0, v1, v2, Landroid/os/Bundle;->putLong(Ljava/lang/String; J)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->isReported()Z
    move-result v0
    if-ne v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    const-string/jumbo v3, state_pairing_result_reported
    invoke-virtual v5, v3, v0, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingFunnelEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->isStep1Reported()Z
    move-result v0
    if-ne v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    const-string/jumbo v3, state_step1_completed_reported
    invoke-virtual v5, v3, v0, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingFunnelEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->isStep2Reported()Z
    move-result v0
    if-ne v0, v1, +003h
    goto +2h
    move v1, v2
    const-string/jumbo v0, state_step2_exposure_reported
    invoke-virtual v5, v0, v1, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    return-void 
.end method

.method public onStop()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->stopStatusSpinner()V
    invoke-super v0, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onStop()V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 13
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v10, v11, v12, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->readBindingTarget()Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-result-object v11
    iput-object v11, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    new-instance v11, Landroidx/lifecycle/ViewModelProvider;
    move-object v0, v10
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    new-instance v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$Factory;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$Factory;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V
    check-cast v1, Landroidx/lifecycle/ViewModelProvider$Factory;
    invoke-direct v11, v0, v1, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner; Landroidx/lifecycle/ViewModelProvider$Factory;)V
    const-class v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    invoke-virtual v11, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    iput-object v11, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->viewModel Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    invoke-direct v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->renderBindingTarget()V
    new-instance v11, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v12, +00dh
    const-string/jumbo v2, state_page_exposure_reported
    invoke-virtual v12, v2, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v2
    if-ne v2, v0, +004h
    move v2, v0
    goto +2h
    move v2, v1
    invoke-direct v11, v2, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z)V
    iput-object v11, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pageExposureGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->tryConsume()Z
    move-result v11
    if-eqz v11, +019h
    sget-object v11, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getEnterFrom()Ljava/lang/String;
    move-result-object v2
    iget-object v3, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v3
    iget-object v4, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->bindingTarget Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getTriggerBy()Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    move-result-object v4
    invoke-virtual v11, v2, v3, v4, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackPairingPageView(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;)V
    const/4 v11, 0
    if-eqz v12, +028h
    const-string/jumbo v2, state_pairing_started_at_millis
    invoke-virtual v12, v2, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J
    move-result-wide v2
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    const-wide/16 v5, 0
    cmp-long v3, v3, v5
    if-lez v3, +004h
    move v3, v0
    goto +2h
    move v3, v1
    if-eqz v3, +003h
    goto +2h
    move-object v2, v11
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v2
    goto +5h
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v2
    move-wide v5, v2
    iput-wide v5, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingStartedAtMillis J
    if-eqz v12, +00dh
    const-string/jumbo v2, state_pairing_result_reported
    invoke-virtual v12, v2, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v2
    if-ne v2, v0, +004h
    move v9, v0
    goto +2h
    move v9, v1
    new-instance v2, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;
    sget-object v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$onViewCreated$2;->INSTANCE Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$onViewCreated$2;
    move-object v7, v3
    check-cast v7, Lkotlin/jvm/functions/Function0;
    new-instance v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda2;
    invoke-direct v8, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    move-object v4, v2
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;-><init>(J Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Z)V
    iput-object v2, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;
    new-instance v2, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;
    if-eqz v12, +00dh
    const-string/jumbo v3, state_step1_completed_reported
    invoke-virtual v12, v3, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v3
    if-ne v3, v0, +004h
    move v3, v0
    goto +2h
    move v3, v1
    if-eqz v12, +00ch
    const-string/jumbo v4, state_step2_exposure_reported
    invoke-virtual v12, v4, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v12
    if-ne v12, v0, +003h
    goto +2h
    move v0, v1
    new-instance v12, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda3;
    invoke-direct v12, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    new-instance v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda4;
    invoke-direct v1, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    invoke-direct v2, v3, v0, v12, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;-><init>(Z Z Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    iput-object v2, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->pairingFunnelEventTracker Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;
    invoke-direct v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->isEmbeddedPresentation()Z
    move-result v12
    if-eqz v12, +01bh
    invoke-direct v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v12
    iget-object v12, v12, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    const/16 v0, 8
    invoke-virtual v12, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setVisibility(I)V
    invoke-direct v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v12
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_secondary I
    invoke-virtual v12, v0, Landroid/widget/LinearLayout;->setBackgroundResource(I)V
    goto +fh
    invoke-direct v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v12
    iget-object v12, v12, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda5;
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    invoke-virtual v12, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getBinding()Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v12
    iget-object v12, v12, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->btnShare Landroid/widget/LinearLayout;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda6;
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    invoke-virtual v12, v0, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->observeBindingState()V
    iget-object v12, v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->viewModel Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    if-nez v12, +009h
    const-string/jumbo v12, viewModel
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v11, v12
    invoke-virtual v11, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;->start()V
    return-void 
.end method

.method public final setOnConnectionSuccessListener(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onConnectionSuccessListener Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnDismissListener(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->onDismissListener Lkotlin/jvm/functions/Function0;
    return-void 
.end method
