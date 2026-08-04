# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "CodeDeviceSelectBottomSheet.kt"

.implements Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessRefreshTarget;

.field private static final ARG_MODE:Ljava/lang/String;
.field private static final ARG_PRESELECTED_DEVICE_ID:Ljava/lang/String;
.field private static final CLICK_DEBOUNCE_MILLIS:J
.field public static final Companion:Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$Companion;
.field private static final STATE_PICKER_SHOW_REPORTED:Ljava/lang/String;
.field public static final TAG:Ljava/lang/String;
.field private adapter:Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
.field private final navigationClickGate:Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;
.field private onDeviceListChanged:Lkotlin/jvm/functions/Function1;
.field private onDeviceSelected:Lkotlin/jvm/functions/Function1;
.field private pickerShowEventGate:Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
.field private viewModel:Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;


.method public static synthetic $r8$lambda$3uHAziLy33w6PxvrHvTA8jsSHWc(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onViewCreated$lambda$14(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$6-6Be0SjKix6jNR27bkOkYhbqvY(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  com.bytedance.trae.conversation.devices.DeviceProductType)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->showAddTargetSelector$lambda$17$lambda$16(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$InswPd4IdVtKgQ5uZOMgh-H9N0E(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  com.bytedance.trae.conversation.devices.DeviceItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onViewCreated$lambda$7(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; Lcom/bytedance/trae/conversation/devices/DeviceItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$S4i1QkZytyi49IeswIpm7tZhDEo(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->handleDeviceClickInFlow$lambda$19(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$UDXSFTB1wmLElPemWcdkvhobevk(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onViewCreated$lambda$8(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Utdc5Rab16c1cxmNftHxjuT5WBI(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  com.bytedance.trae.conversation.devices.DeviceProductType  com.bytedance.trae.conversation.devices.DeviceItem  com.bytedance.trae.conversation.devices.MobileDevice)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->openOfflineDevice$lambda$25(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/DeviceItem; Lcom/bytedance/trae/conversation/devices/MobileDevice;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$VGA6S9GroMUmab_mZ15GuvQBC4o(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->openOfflineDevice$lambda$24(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$WmVTMZjxtOI10popNM46RwfieQI(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  int  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onCreateDialog$lambda$1(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; I Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$j9vvk0wmC3fdF-T6WsOaEJR2Ojo(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->openConnectGuide$lambda$22(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$rjedQvSoPlKKiCLxr3oOfzLRCVc(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onViewCreated$lambda$3(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$sH32uWWeVqQknVWBjMRRVl-CUq8(android.view.View  android.view.View  java.lang.Boolean)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onViewCreated$lambda$9(Landroid/view/View; Landroid/view/View; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;
    const-wide/16 v1, 500
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;-><init>(J)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->navigationClickGate Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;
    return-void 
.end method

.method public static final synthetic access$getAdapter$p(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet)com.bytedance.trae.conversation.devices.CodeDeviceItemAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    return-object v0
.end method

.method private final currentChatMode()com.bytedance.trae.conversation.widget.ChatMode
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +010h
    const-string v1, "arg_mode"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +008h
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v0
    if-nez v0, +004h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    return-object v0
.end method

.method private final handleDeviceClickInFlow(com.bytedance.trae.conversation.devices.DeviceItem)boolean
    .registers 22
    # ins_size=2
    move-object/from16 v0, v20
    move-object/from16 v1, v21
    move-object v2, v0
    check-cast v2, Landroidx/fragment/app/Fragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v2
    const/4 v3, 0
    if-nez v2, +003h
    return v3
    sget-object v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy;
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickPolicy;->resolve(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$SelectDeviceDirectly;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$SelectDeviceDirectly;
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    const-string v6, "adapter"
    const/4 v7, 0
    if-eqz v5, +04dh
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "offline_device_route: mode=code, route=remote_select, item="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static/range v21, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "CodeDeviceSelectBottomSheet"
    invoke-virtual v3, v5, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v10
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v11
    const/4 v12, 0
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    if-nez v1, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v7, v1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->getShowProductType()Z
    move-result v17
    const/16 v18, 232
    const/16 v19, 0
    move-object v8, v3
    invoke-direct/range v8 ... v19, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->notifyDeviceSelected(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)V
    goto/16 +0c0h
    sget-object v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$ProjectSelect;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$ProjectSelect;
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    const-string/jumbo v8, viewModel
    if-eqz v5, +02eh
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v4, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v7
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, v3, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->selectLocation(Ljava/lang/String; Z)V
    new-instance v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-direct/range v20, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->currentChatMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v4
    iget-object v5, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v7, v5
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->getShowProductType()Z
    move-result v5
    invoke-direct v3, v1, v4, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceItem; Lcom/bytedance/trae/conversation/widget/ChatMode; Z)V
    check-cast v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    invoke-interface v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->navigate(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;)V
    goto/16 +089h
    instance-of v5, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;
    if-eqz v5, +03ch
    iget-object v5, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v5, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v7, v5
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v7, v5, v3, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->selectLocation(Ljava/lang/String; Z)V
    new-instance v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;
    new-instance v11, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v7
    check-cast v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v8
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->isPaired()Z
    move-result v9
    const-string v10, "code_add_device"
    move-object v5, v11
    invoke-direct/range v5 ... v10, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)V
    invoke-direct v3, v11, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;-><init>(Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget; Lkotlin/jvm/functions/Function0;)V
    check-cast v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    invoke-interface v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->navigate(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;)V
    goto +4ah
    instance-of v3, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$BindingGuide;
    if-eqz v3, +049h
    new-instance v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    sget-object v5, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    check-cast v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$BindingGuide;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$BindingGuide;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v4
    iget-object v6, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v6, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v7, v6
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->getLocations()Landroidx/lifecycle/LiveData;
    move-result-object v6
    invoke-virtual v6, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/util/List;
    if-nez v6, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v6
    const-string v7, "code_add_device"
    invoke-virtual v5, v4, v6, v7, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->bindingTarget(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/List; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    sget-object v12, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->UNBOUND_DEVICE Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v13
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v14
    const/4 v15, 7
    const/16 v16, 0
    invoke-static/range v8 ... v16, Lcom/bytedance/trae/conversation/devices/BindingTarget;->copy$default(Lcom/bytedance/trae/conversation/devices/BindingTarget; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-result-object v1
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V
    check-cast v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    invoke-interface v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->navigate(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;)V
    const/4 v1, 1
    return v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method

.method private static final handleDeviceClickInFlow$lambda$19(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet)kotlin.Unit
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v1
    if-eqz v1, +015h
    iget-object v6, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v6, +009h
    const-string/jumbo v6, viewModel
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v6, 0
    move-object v0, v6
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->fetchDevices$default(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel; Landroid/content/Context; Z Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private static final onCreateDialog$lambda$1(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  int  android.content.DialogInterface)void
    .registers 4
    # ins_size=3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->isAdded()Z
    move-result v1
    if-nez v1, +003h
    return-void 
    instance-of v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    if-eqz v1, +005h
    check-cast v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    goto +2h
    const/4 v3, 0
    if-nez v3, +003h
    return-void 
    sget v1, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v3, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    const v3, 17170445
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v3
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

.method private static final onViewCreated$lambda$14(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  java.util.List)kotlin.Unit
    .registers 13
    # ins_size=2
    iget-object v0, v11, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->pickerShowEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "pickerShowEventGate"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->tryConsume()Z
    move-result v0
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v0, +07bh
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-interface v12, Ljava/util/List;->size()I
    move-result v4
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v5, v12
    check-cast v5, Ljava/lang/Iterable;
    instance-of v6, v5, Ljava/util/Collection;
    if-eqz v6, +00dh
    move-object v7, v5
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +004h
    move v8, v3
    goto +27h
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    move v8, v3
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +01dh
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v9
    sget-object v10, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v9, v10, +004h
    move v9, v2
    goto +2h
    move v9, v3
    if-eqz v9, -017h
    add-int/lit8 v8, v8, 1
    if-gez v8, -01bh
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -20h
    if-eqz v6, +00dh
    move-object v6, v5
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-eqz v6, +004h
    move v6, v3
    goto +27h
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    move v6, v3
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +01dh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v7
    sget-object v9, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v7, v9, +004h
    move v7, v2
    goto +2h
    move v7, v3
    if-eqz v7, -017h
    add-int/lit8 v6, v6, 1
    if-gez v6, -01bh
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -20h
    sget-object v5, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, v4, v8, v6, v5, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackDevicePickerShow(I I I Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v0, v12
    check-cast v0, Ljava/lang/Iterable;
    instance-of v4, v0, Ljava/util/Collection;
    if-eqz v4, +00dh
    move-object v5, v0
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +004h
    move v5, v3
    goto +1fh
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, -00ah
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v6, v7, +004h
    move v6, v2
    goto +2h
    move v6, v3
    if-eqz v6, -017h
    move v5, v2
    if-eqz v4, +00dh
    move-object v4, v0
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +004h
    move v0, v3
    goto +1fh
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v4
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v4, v6, +004h
    move v4, v2
    goto +2h
    move v4, v3
    if-eqz v4, -017h
    move v0, v2
    if-eqz v5, +006h
    if-eqz v0, +004h
    move v0, v2
    goto +2h
    move v0, v3
    iget-object v4, v11, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    const-string v5, "adapter"
    if-nez v4, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->getShowProductType()Z
    move-result v4
    if-eq v4, v0, +003h
    goto +2h
    move v2, v3
    iget-object v4, v11, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    if-nez v4, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->setShowProductType(Z)V
    if-eqz v2, +027h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->getItemCount()I
    move-result v0
    if-lez v0, +019h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v2, v11, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    if-nez v2, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->getItemCount()I
    move-result v2
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->notifyItemRangeChanged(I I)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v12, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->submitList(Ljava/util/List;)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->shouldDispatchDeviceListChanged()Z
    move-result v0
    if-eqz v0, +009h
    iget-object v11, v11, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onDeviceListChanged Lkotlin/jvm/functions/Function1;
    if-eqz v11, +005h
    invoke-interface v11, v12, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    move-object v1, v0
    check-cast v1, Landroidx/fragment/app/Fragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v1
    if-eqz v1, +006h
    invoke-interface v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->closeCurrentFlow()V
    goto +4h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$7(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  com.bytedance.trae.conversation.devices.DeviceItem)kotlin.Unit
    .registers 18
    # ins_size=2
    move-object/from16 v0, v16
    move-object/from16 v1, v17
    const-string v2, "location"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->tryAcceptNavigationClick()Z
    move-result v2
    if-nez v2, +005h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v4
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v5
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired()Z
    move-result v6
    invoke-virtual v2, v3, v4, v5, v6, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackDeviceSelectClick(Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Z Z)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "offline_device_click: mode=code, item="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", stateSaved="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v4
    invoke-virtual v4, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", lifecycle="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v4
    invoke-virtual v4, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "CodeDeviceSelectBottomSheet"
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct/range v16 ... v17, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->handleDeviceClickInFlow(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Z
    move-result v2
    if-eqz v2, +005h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired()Z
    move-result v2
    if-nez v2, +01eh
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v2
    aget v2, v3, v2
    const/4 v3, 1
    if-ne v2, v3, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    const-string v3, "code_add_device"
    invoke-direct v0, v2, v3, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->openConnectGuide(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceItem;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    const/4 v3, 0
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v3
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 2
    invoke-static v2, v5, v6, v7, v3, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->selectLocation$default(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel; Ljava/lang/String; Z I Ljava/lang/Object;)V
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v2, v5, +054h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "offline_device_route: mode=code, route=remote_select, item="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v4, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onDeviceSelected Lkotlin/jvm/functions/Function1;
    if-eqz v2, +033h
    new-instance v15, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v7
    const/4 v8, 0
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getIdeVersion()Ljava/lang/String;
    move-result-object v9
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    if-nez v1, +008h
    const-string v1, "adapter"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->getShowProductType()Z
    move-result v13
    const/16 v14, 232
    const/4 v1, 0
    move-object v4, v15
    move-object v3, v15
    move-object v15, v1
    invoke-direct/range v4 ... v15, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->dismiss()V
    goto/16 +0e2h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    const-string v6, "DirectoryBottomSheet"
    if-ne v2, v5, +05dh
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v2
    if-eqz v2, +038h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v8, "offline_device_route: mode=code, route=ide_project, item="
    invoke-direct v5, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v4, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->Companion Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, v3, v7, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;->newInstance$default(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$1$1;
    invoke-direct v3, v0, v1, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$1$1;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; Lcom/bytedance/trae/conversation/devices/DeviceItem; Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;)V
    check-cast v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->setProjectSelected(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v2, v0, v6, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "offline_device_route: mode=code, route=offline_page, productType=IDE, item="
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->openOfflineDevice(Lcom/bytedance/trae/conversation/devices/DeviceItem; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    goto/16 +07dh
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v2, v3, +075h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v2
    if-eqz v2, +052h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "offline_device_route: mode=code, route=local_directory, item="
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v2
    if-eqz v2, +010h
    const-string v3, "arg_mode"
    invoke-virtual v2, v3, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +008h
    invoke-static v2, Lcom/bytedance/trae/conversation/widget/ChatMode;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v2
    if-nez v2, +004h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-object v9, v2
    sget-object v7, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->Companion Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v8
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 12
    const/4 v13, 0
    invoke-static/range v7 ... v13, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;->newInstance$default(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion; Ljava/lang/String; Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;
    invoke-direct v3, v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$onViewCreated$3$2$1;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; Lcom/bytedance/trae/conversation/devices/DeviceItem;)V
    check-cast v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->setOnDirectorySelectedListener(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v2, v0, v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    goto +1eh
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "offline_device_route: mode=code, route=offline_page, productType=WORK, item="
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static/range v17, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->openOfflineDevice(Lcom/bytedance/trae/conversation/devices/DeviceItem; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onViewCreated$lambda$8(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet)kotlin.Unit
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->tryAcceptNavigationClick()Z
    move-result v0
    if-nez v0, +005h
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    const-string v1, "code_add_device"
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackConnectEntryClick(Ljava/lang/String; Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->showAddTargetSelector()V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final onViewCreated$lambda$9(android.view.View  android.view.View  java.lang.Boolean)kotlin.Unit
    .registers 6
    # ins_size=3
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    const/4 v1, 0
    const/16 v2, 8
    if-eqz v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    invoke-virtual v3, v0, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    if-eqz v3, +003h
    move v1, v2
    invoke-virtual v4, v1, Landroid/view/View;->setVisibility(I)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final openConnectGuide(com.bytedance.trae.conversation.devices.DeviceProductType  java.lang.String  com.bytedance.trae.conversation.devices.DeviceItem)void
    .registers 16
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    iget-object v1, v12, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    const/4 v2, 0
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->getLocations()Landroidx/lifecycle/LiveData;
    move-result-object v1
    invoke-virtual v1, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    if-nez v1, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-virtual v0, v13, v1, v14, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->bindingTarget(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/List; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-result-object v3
    sget-object v13, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->Companion Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    if-nez v15, +005h
    sget-object v14, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->CONNECT_BUTTON Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    goto +3h
    sget-object v14, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->UNBOUND_DEVICE Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    move-object v7, v14
    if-eqz v15, +008h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v14
    move-object v8, v14
    goto +2h
    move-object v8, v2
    if-eqz v15, +006h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v2
    move-object v9, v2
    const/4 v10, 7
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lcom/bytedance/trae/conversation/devices/BindingTarget;->copy$default(Lcom/bytedance/trae/conversation/devices/BindingTarget; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-result-object v14
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/BindingTarget;)Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    move-result-object v13
    new-instance v14, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v14, v12, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)V
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->setOnDismissListener(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v12, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v14
    const-string v15, "DeviceManagement"
    invoke-virtual v13, v14, v15, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method static synthetic openConnectGuide$default(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  com.bytedance.trae.conversation.devices.DeviceProductType  java.lang.String  com.bytedance.trae.conversation.devices.DeviceItem  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->openConnectGuide(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceItem;)V
    return-void 
.end method

.method private static final openConnectGuide$lambda$22(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet)kotlin.Unit
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v1
    if-eqz v1, +015h
    iget-object v6, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v6, +009h
    const-string/jumbo v6, viewModel
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v6, 0
    move-object v0, v6
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->fetchDevices$default(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel; Landroid/content/Context; Z Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private final openOfflineDevice(com.bytedance.trae.conversation.devices.DeviceItem  com.bytedance.trae.conversation.devices.DeviceProductType)void
    .registers 18
    # ins_size=3
    move-object v1, v15
    const-string v0, "offline_device_show_called: mode=code, productType="
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "offline_device_show_start: mode=code, productType="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", item="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-static/range v16, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v5, ", stateSaved="
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v6
    invoke-virtual v6, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v6, ", isAdded="
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->isAdded()Z
    move-result v7
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v7, ", lifecycle="
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v8
    invoke-virtual v8, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v8
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v8, "CodeDeviceSelectBottomSheet"
    invoke-virtual v2, v8, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->isAdded()Z
    move-result v2
    if-eqz v2, +0adh
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    invoke-virtual v2, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v2
    if-nez v2, +0a3h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v2
    invoke-virtual v2, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v2
    sget-object v3, Landroidx/lifecycle/Lifecycle$State;->STARTED Landroidx/lifecycle/Lifecycle$State;
    invoke-virtual v2, v3, Landroidx/lifecycle/Lifecycle$State;->isAtLeast(Landroidx/lifecycle/Lifecycle$State;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +091h
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$Companion;
    new-instance v3, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getName()Ljava/lang/String;
    move-result-object v11
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired()Z
    move-result v13
    const-string v14, "code_add_device"
    move-object v9, v3
    move-object/from16 v12, v17
    invoke-direct/range v9 ... v14, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;)Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda9;
    invoke-direct v3, v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->setOnDismissListener(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired()Z
    move-result v3
    if-nez v3, +00fh
    new-instance v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda10;
    move-object/from16 v9, v16
    move-object/from16 v10, v17
    invoke-direct v3, v15, v10, v9, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/DeviceItem;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->setOnUnpairedDeviceOnline(Lkotlin/jvm/functions/Function1;)V
    goto +5h
    move-object/from16 v9, v16
    move-object/from16 v10, v17
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    const-string v5, "DeviceActivateBottomSheet"
    invoke-virtual v2, v3, v5, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static/range v16, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v8, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +28h
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "offline_device_show_failed: mode=code, productType="
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-static/range v16, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v0, Ljava/lang/Throwable;
    invoke-virtual v2, v8, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    move-object/from16 v9, v16
    move-object/from16 v10, v17
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "offline_device_show_skip: mode=code, productType="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-static/range v16, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    invoke-virtual v3, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->isAdded()Z
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v15, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v3
    invoke-virtual v3, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v8, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0xba
.end method

.method private static final openOfflineDevice$lambda$24(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet)kotlin.Unit
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v1
    if-eqz v1, +015h
    iget-object v6, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v6, +009h
    const-string/jumbo v6, viewModel
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v6, 0
    move-object v0, v6
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->fetchDevices$default(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel; Landroid/content/Context; Z Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private static final openOfflineDevice$lambda$25(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  com.bytedance.trae.conversation.devices.DeviceProductType  com.bytedance.trae.conversation.devices.DeviceItem  com.bytedance.trae.conversation.devices.MobileDevice)kotlin.Unit
    .registers 17
    # ins_size=4
    const-string v0, "recovered"
    move-object/from16 v1, v16
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getName()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 1
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 492
    const/4 v12, 0
    move-object v1, v15
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/conversation/devices/DeviceItem;->copy$default(Lcom/bytedance/trae/conversation/devices/DeviceItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z Z Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v0
    const-string v1, "code_add_device"
    move-object v2, v13
    move-object v3, v14
    invoke-direct v13, v14, v1, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->openConnectGuide(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceItem;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final showAddTargetSelector()void
    .registers 9
    # ins_size=1
    move-object v0, v8
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v0
    const-string v1, "code_add_device"
    const-string/jumbo v2, viewModel
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v0, +02fh
    sget-object v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;
    sget-object v7, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    invoke-static v7, v3, v5, v4, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->availableTargets$default(Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy; Z I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    iget-object v5, v8, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v5
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->getLocations()Landroidx/lifecycle/LiveData;
    move-result-object v2
    invoke-virtual v2, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowExistingDeviceIdsKt;->deviceItemIdsByProduct(Ljava/util/List;)Ljava/util/Map;
    move-result-object v2
    invoke-virtual v6, v3, v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;->targetSelectRoute(Ljava/util/List; Ljava/util/Map; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    move-result-object v1
    invoke-interface v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->openNewFlow(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    invoke-static v0, v3, v5, v4, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->availableTargets$default(Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy; Z I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v3
    if-ne v3, v5, +013h
    invoke-static v0, Lkotlin/collections/CollectionsKt;->single(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    const-string v3, "code_add_device"
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v8
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->openConnectGuide$default(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceItem; I Ljava/lang/Object;)V
    return-void 
    iget-object v3, v8, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->getLocations()Landroidx/lifecycle/LiveData;
    move-result-object v2
    invoke-virtual v2, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowExistingDeviceIdsKt;->deviceItemIdsByProduct(Ljava/util/List;)Ljava/util/Map;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;
    sget-object v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-interface v2, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/Set;
    if-nez v4, +006h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    xor-int/2addr v4, v5
    sget-object v6, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-interface v2, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Set;
    if-nez v2, +006h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v2
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/2addr v2, v5
    invoke-virtual v3, v0, v1, v4, v2, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;->newInstance(Ljava/util/List; Ljava/lang/String; Z Z)Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda8;
    invoke-direct v1, v8, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->setOnTargetSelected(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v2, "DeviceTargetSelectBottomSheet"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private static final showAddTargetSelector$lambda$17$lambda$16(com.bytedance.trae.conversation.devices.CodeDeviceSelectBottomSheet  com.bytedance.trae.conversation.devices.DeviceProductType)kotlin.Unit
    .registers 9
    # ins_size=2
    const-string v0, "productType"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "code_add_device"
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->openConnectGuide$default(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceItem; I Ljava/lang/Object;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private final tryAcceptNavigationClick()boolean
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->isAdded()Z
    move-result v0
    if-eqz v0, +032h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    if-nez v0, +028h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    if-nez v0, +01eh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v0
    sget-object v1, Landroidx/lifecycle/Lifecycle$State;->STARTED Landroidx/lifecycle/Lifecycle$State;
    invoke-virtual v0, v1, Landroidx/lifecycle/Lifecycle$State;->isAtLeast(Landroidx/lifecycle/Lifecycle$State;)Z
    move-result v0
    if-nez v0, +003h
    goto +ch
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->navigationClickGate Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;->tryAcquire(J)Z
    move-result v0
    return v0
    const/4 v0, 0
    return v0
.end method

.method public final getOnDeviceListChanged()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onDeviceListChanged Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnDeviceSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onDeviceSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public onCreate(android.os.Bundle)void
    .registers 5
    # ins_size=2
    invoke-super v3, v4, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreate(Landroid/os/Bundle;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    const/4 v1, 0
    if-eqz v4, +00dh
    const-string/jumbo v2, state_picker_show_reported
    invoke-virtual v4, v2, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v4
    const/4 v2, 1
    if-ne v4, v2, +003h
    move v1, v2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->pickerShowEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    return-void 
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 4
    # ins_size=2
    invoke-super v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v3
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    const/16 v0, 512
    int-to-float v0, v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v0, v1
    float-to-int v0, v0
    new-instance v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet; I)V
    invoke-virtual v3, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v3, Landroid/app/Dialog;
    return-object v3
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_code_device_select I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 4
    # ins_size=1
    invoke-super v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDestroyView()V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->isChangingConfigurations()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-nez v1, +00fh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->pickerShowEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    if-nez v0, +008h
    const-string v0, "pickerShowEventGate"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->reset()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->navigationClickGate Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;->release()V
    return-void 
.end method

.method public onDeviceConnectionSuccess(java.lang.String)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v0, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +011h
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    const/4 v2, 1
    invoke-virtual v1, v0, v2, v4, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->fetchDevices(Landroid/content/Context; Z Ljava/lang/String;)V
    return-void 
.end method

.method public onSaveInstanceState(android.os.Bundle)void
    .registers 4
    # ins_size=2
    const-string v0, "outState"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->pickerShowEventGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    if-nez v0, +008h
    const-string v0, "pickerShowEventGate"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed()Z
    move-result v0
    const-string/jumbo v1, state_picker_show_reported
    invoke-virtual v3, v1, v0, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    invoke-super v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onSaveInstanceState(Landroid/os/Bundle;)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 9
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v6, v7, v8, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v8, Landroidx/lifecycle/ViewModelProvider;
    move-object v0, v6
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v8, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    invoke-virtual v8, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    iput-object v8, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v8
    const/4 v0, 0
    const-string/jumbo v1, viewModel
    if-eqz v8, +015h
    const-string v2, "arg_preselected_device_id"
    invoke-virtual v8, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +00dh
    iget-object v2, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    invoke-virtual v2, v8, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->setPreselectedDeviceId(Ljava/lang/String;)V
    iget-object v8, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v8, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v3, requireContext(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 1
    invoke-virtual v8, v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->ensureDevicesLoaded(Landroid/content/Context; Z)V
    sget v8, Lcom/bytedance/trae/conversation/R$id;->progress_loading I
    invoke-virtual v7, v8, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    sget v2, Lcom/bytedance/trae/conversation/R$id;->content_container I
    invoke-virtual v7, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/conversation/R$id;->rv_devices I
    invoke-virtual v7, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v7, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v4, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v5
    invoke-direct v4, v5, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v4, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v3, v4, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    new-instance v4, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda3;
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)V
    invoke-virtual v7, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v7, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    new-instance v4, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda4;
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)V
    new-instance v5, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda5;
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)V
    invoke-direct v7, v4, v5, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)V
    iput-object v7, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    check-cast v7, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v3, v7, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v7, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->isLoading()Landroidx/lifecycle/LiveData;
    move-result-object v7
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda6;
    invoke-direct v4, v8, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda6;-><init>(Landroid/view/View; Landroid/view/View;)V
    new-instance v8, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v8, v4, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v8, Landroidx/lifecycle/Observer;
    invoke-virtual v7, v3, v8, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->viewModel Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    if-nez v7, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v7
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->getLocations()Landroidx/lifecycle/LiveData;
    move-result-object v7
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v8
    new-instance v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda7;
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;)V
    new-instance v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v1, Landroidx/lifecycle/Observer;
    invoke-virtual v7, v8, v1, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method public final setOnDeviceListChanged(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onDeviceListChanged Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnDeviceSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->onDeviceSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method
