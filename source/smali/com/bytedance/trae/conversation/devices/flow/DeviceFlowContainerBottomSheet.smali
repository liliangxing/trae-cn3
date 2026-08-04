# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "DeviceFlowContainerBottomSheet.kt"

.implements Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;

.field private static final ARG_REQUEST_KEY:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;
.field public static final TAG:Ljava/lang/String;
.field private deferredConnectionSuccessDevice:Lcom/bytedance/trae/conversation/devices/MobileDevice;
.field private request:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
.field private requestKey:Ljava/lang/String;


.method public static synthetic $r8$lambda$0v5bu4zoLCxZIrCkoRBxOFOlGUo(com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet  com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$TargetSelect  com.bytedance.trae.conversation.devices.DeviceProductType)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createTargetSelectFragment$lambda$13$lambda$12(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$1bNvB6IUkOHs14TB3vkpOAbkjEs(com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  com.bytedance.trae.conversation.devices.SelectedDeviceItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createDeviceSelectFragment$lambda$11$lambda$9(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$3ihno_bA0jaUmJlWwPmMRoDHS4s(int  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->onCreateDialog$lambda$3(I Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$M4RN0WXFNi5X4qm0HlC8Za98CMs(com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createDeviceSelectFragment$lambda$8$lambda$7(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$NlB2RZBebq63IR4l5V-CT4Ddk2I(com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createDeviceSelectFragment$lambda$11$lambda$10(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Nzg-VoSMQe5SjqNWI7e_5E00Q3Q(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$NewFeaturePrompt  com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createNewFeaturePromptFragment$lambda$15$lambda$14(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$aEx4OStCaPTZDA9tK6_gNM5j8PM(com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet  android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->onCreateDialog$lambda$4(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet; Landroid/content/DialogInterface; I Landroid/view/KeyEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$bY4Tj4NLQOAlnvKE6Ta4xVVi_Vk(com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  com.bytedance.trae.conversation.devices.SelectedDeviceItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createDeviceSelectFragment$lambda$8$lambda$6(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    return-void 
.end method

.method public static final synthetic access$returnToDeviceSelectionAfterBinding(com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet  com.bytedance.trae.conversation.devices.MobileDevice)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->returnToDeviceSelectionAfterBinding(Lcom/bytedance/trae/conversation/devices/MobileDevice;)Z
    move-result v0
    return v0
.end method

.method private final canMutateChildFragmentState()boolean
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->isAdded()Z
    move-result v0
    if-eqz v0, +01eh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v0
    sget-object v1, Landroidx/lifecycle/Lifecycle$State;->RESUMED Landroidx/lifecycle/Lifecycle$State;
    invoke-virtual v0, v1, Landroidx/lifecycle/Lifecycle$State;->isAtLeast(Landroidx/lifecycle/Lifecycle$State;)Z
    move-result v0
    if-eqz v0, +00eh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private final completeDeferredConnectionSuccessIfPossible()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->deferredConnectionSuccessDevice Lcom/bytedance/trae/conversation/devices/MobileDevice;
    if-nez v0, +003h
    return-void 
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->isAdded()Z
    move-result v1
    if-eqz v1, +014h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v1
    if-eqz v1, +003h
    goto +8h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->completeReturnToDeviceSelection(Ljava/lang/String;)V
    return-void 
.end method

.method private final completeReturnToDeviceSelection(java.lang.String)void
    .registers 5
    # ins_size=2
    const/4 v0, 0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->deferredConnectionSuccessDevice Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const/4 v2, 1
    invoke-virtual v1, v0, v2, Landroidx/fragment/app/FragmentManager;->popBackStackImmediate(Ljava/lang/String; I)Z
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->notifyCurrentRouteConnectionSuccess(Ljava/lang/String;)V
    return-void 
.end method

.method private final createConnectGuideFragment(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ConnectGuide)androidx.fragment.app.Fragment
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->Companion Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;->getTarget()Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/BindingTarget;)Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    move-result-object v2
    check-cast v2, Landroidx/fragment/app/Fragment;
    return-object v2
.end method

.method private final createDeviceSelectFragment(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$DeviceSelect)androidx.fragment.app.Fragment
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->getCallbacks()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->getCodeMode()Z
    move-result v1
    if-eqz v1, +023h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->getMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->getPreselectedDeviceId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v2, v4, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;
    move-result-object v4
    new-instance v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->setOnDeviceSelected(Lkotlin/jvm/functions/Function1;)V
    new-instance v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceSelectBottomSheet;->setOnDeviceListChanged(Lkotlin/jvm/functions/Function1;)V
    check-cast v4, Landroidx/fragment/app/Fragment;
    goto +21h
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->getMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;->getPreselectedDeviceId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v2, v4, Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet;
    move-result-object v4
    new-instance v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet;->setOnDeviceSelected(Lkotlin/jvm/functions/Function1;)V
    new-instance v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda3;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet;->setOnDeviceListChanged(Lkotlin/jvm/functions/Function1;)V
    check-cast v4, Landroidx/fragment/app/Fragment;
    return-object v4
.end method

.method private static final createDeviceSelectFragment$lambda$11$lambda$10(com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "devices"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v1, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnDeviceListChanged()Lkotlin/jvm/functions/Function1;
    move-result-object v1
    if-eqz v1, +005h
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final createDeviceSelectFragment$lambda$11$lambda$9(com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  com.bytedance.trae.conversation.devices.SelectedDeviceItem)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v1, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnDeviceSelected()Lkotlin/jvm/functions/Function1;
    move-result-object v1
    if-eqz v1, +005h
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final createDeviceSelectFragment$lambda$8$lambda$6(com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  com.bytedance.trae.conversation.devices.SelectedDeviceItem)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v1, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnDeviceSelected()Lkotlin/jvm/functions/Function1;
    move-result-object v1
    if-eqz v1, +005h
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final createDeviceSelectFragment$lambda$8$lambda$7(com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "devices"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v1, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnDeviceListChanged()Lkotlin/jvm/functions/Function1;
    move-result-object v1
    if-eqz v1, +005h
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final createDirectorySelectFragment(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ProjectSelect)androidx.fragment.app.Fragment
    .registers 9
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->Companion Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getDevice()Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getMode()Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 12
    const/4 v6, 0
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion;->newInstance$default(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$Companion; Ljava/lang/String; Lcom/bytedance/trae/conversation/widget/ChatMode; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;
    invoke-direct v1, v7, v8, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createDirectorySelectFragment$1$1;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;)V
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment;->setOnDirectorySelectedListener(Lcom/bytedance/trae/conversation/devices/DirectoryBottomSheetFragment$OnDirectorySelectedListener;)V
    check-cast v0, Landroidx/fragment/app/Fragment;
    return-object v0
.end method

.method private final createIdeProjectSelectFragment(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ProjectSelect)androidx.fragment.app.Fragment
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->Companion Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getDevice()Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 2
    invoke-static v0, v1, v2, v3, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;->newInstance$default(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;
    invoke-direct v1, v4, v5, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$createIdeProjectSelectFragment$1$1;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect; Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;)V
    check-cast v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;->setProjectSelected(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;)V
    check-cast v0, Landroidx/fragment/app/Fragment;
    return-object v0
.end method

.method private final createNewFeaturePromptFragment(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$NewFeaturePrompt)androidx.fragment.app.Fragment
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->getHasRegisteredWork()Z
    move-result v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->getHasRegisteredIDE()Z
    move-result v3
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Z)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda4;
    invoke-direct v1, v5, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;->setOnConfirm(Lkotlin/jvm/functions/Function0;)V
    check-cast v0, Landroidx/fragment/app/Fragment;
    return-object v0
.end method

.method private static final createNewFeaturePromptFragment$lambda$15$lambda$14(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$NewFeaturePrompt  com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet)kotlin.Unit
    .registers 13
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->INSTANCE Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->canOpenConnectGuide(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Z
    move-result v0
    if-nez v0, +005h
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    iget-object v0, v12, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    if-eqz v0, +015h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->getCallbacks()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v0
    if-eqz v0, +00fh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnNewFeaturePromptConfirmed()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +009h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    new-instance v10, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v2
    invoke-virtual v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->getDevices()Ljava/util/List;
    move-result-object v1
    invoke-virtual v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v11
    invoke-static v1, v11, Lcom/bytedance/trae/conversation/devices/DeviceBindingPolicyKt;->idsForProduct(Ljava/util/List; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Ljava/util/Set;
    move-result-object v3
    const-string v4, "new_feature_popup"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 56
    const/4 v9, 0
    move-object v1, v10
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    invoke-virtual v12, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->navigate(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method

.method private final createOfflineActivationFragment(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$OfflineActivation)androidx.fragment.app.Fragment
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;->getTarget()Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;)Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;->getOnClosed()Lkotlin/jvm/functions/Function0;
    move-result-object v3
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/devices/DeviceActivateBottomSheet;->setOnDismissListener(Lkotlin/jvm/functions/Function0;)V
    check-cast v0, Landroidx/fragment/app/Fragment;
    return-object v0
.end method

.method private final createProjectSelectFragment(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ProjectSelect)androidx.fragment.app.Fragment
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;->getDevice()Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +007h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createIdeProjectSelectFragment(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;)Landroidx/fragment/app/Fragment;
    move-result-object v3
    goto +5h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createDirectorySelectFragment(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;)Landroidx/fragment/app/Fragment;
    move-result-object v3
    return-object v3
.end method

.method private final createRouteFragment(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute)androidx.fragment.app.Fragment
    .registers 3
    # ins_size=2
    instance-of v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createDeviceSelectFragment(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$DeviceSelect;)Landroidx/fragment/app/Fragment;
    move-result-object v2
    goto +37h
    instance-of v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createTargetSelectFragment(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;)Landroidx/fragment/app/Fragment;
    move-result-object v2
    goto +2ch
    instance-of v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createNewFeaturePromptFragment(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$NewFeaturePrompt;)Landroidx/fragment/app/Fragment;
    move-result-object v2
    goto +21h
    instance-of v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createConnectGuideFragment(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;)Landroidx/fragment/app/Fragment;
    move-result-object v2
    goto +16h
    instance-of v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createProjectSelectFragment(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ProjectSelect;)Landroidx/fragment/app/Fragment;
    move-result-object v2
    goto +bh
    instance-of v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createOfflineActivationFragment(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;)Landroidx/fragment/app/Fragment;
    move-result-object v2
    return-object v2
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
.end method

.method private final createTargetSelectFragment(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$TargetSelect)androidx.fragment.app.Fragment
    .registers 8
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->getAvailableTargets()Ljava/util/List;
    move-result-object v1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->getEnterFrom()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->getExistingDeviceIdsByProduct()Ljava/util/Map;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-interface v3, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/Set;
    if-nez v3, +006h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v3
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->getExistingDeviceIdsByProduct()Ljava/util/Map;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-interface v4, v5, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/Set;
    if-nez v4, +006h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    xor-int/lit8 v4, v4, 1
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;->newInstance(Ljava/util/List; Ljava/lang/String; Z Z)Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda5;
    invoke-direct v1, v6, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->setOnTargetSelected(Lkotlin/jvm/functions/Function1;)V
    check-cast v0, Landroidx/fragment/app/Fragment;
    return-object v0
.end method

.method private static final createTargetSelectFragment$lambda$13$lambda$12(com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet  com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$TargetSelect  com.bytedance.trae.conversation.devices.DeviceProductType)kotlin.Unit
    .registers 14
    # ins_size=3
    const-string v0, "productType"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->INSTANCE Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;
    invoke-virtual v0, v13, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->canOpenConnectGuide(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Z
    move-result v0
    if-nez v0, +005h
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    new-instance v10, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->getExistingDeviceIdsByProduct()Ljava/util/Map;
    move-result-object v1
    invoke-interface v1, v13, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Set;
    if-nez v1, +006h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v1
    move-object v3, v1
    invoke-virtual v12, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$TargetSelect;->getEnterFrom()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 56
    const/4 v9, 0
    move-object v1, v10
    move-object v2, v13
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    invoke-virtual v11, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->navigate(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method

.method private final notifyCurrentRouteConnectionSuccess(java.lang.String)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$id;->device_flow_content I
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentById(I)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessRefreshTarget;
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessRefreshTarget;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-interface v0, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessRefreshTarget;->onDeviceConnectionSuccess(Ljava/lang/String;)V
    return-void 
.end method

.method static synthetic notifyCurrentRouteConnectionSuccess$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet  java.lang.String  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->notifyCurrentRouteConnectionSuccess(Ljava/lang/String;)V
    return-void 
.end method

.method private static final onCreateDialog$lambda$3(int  android.content.DialogInterface)void
    .registers 4
    # ins_size=2
    instance-of v0, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    if-eqz v0, +005h
    check-cast v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    goto +2h
    const/4 v3, 0
    if-eqz v3, +02ch
    sget v0, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v3
    if-nez v3, +003h
    goto +22h
    const v0, 17170445
    invoke-virtual v3, v0, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v1, 3
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    invoke-virtual v3, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v3, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private static final onCreateDialog$lambda$4(com.bytedance.trae.conversation.devices.flow.DeviceFlowContainerBottomSheet  android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 4
    # ins_size=4
    const/4 v1, 4
    if-ne v2, v1, +00dh
    invoke-virtual v3, Landroid/view/KeyEvent;->getAction()I
    move-result v1
    const/4 v2, 1
    if-ne v1, v2, +006h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->closeCurrentFlow()V
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method private final returnToDeviceSelectionAfterBinding(com.bytedance.trae.conversation.devices.MobileDevice)boolean
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    const/4 v1, 0
    if-eqz v0, +039h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->getInitialRoute()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    move-result-object v0
    if-nez v0, +003h
    goto +31h
    sget-object v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessPolicy;
    invoke-direct v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->canMutateChildFragmentState()Z
    move-result v3
    invoke-virtual v2, v0, v5, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessPolicy;->destination(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Lcom/bytedance/trae/conversation/devices/MobileDevice; Z)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination;
    move-result-object v0
    instance-of v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$DeferReturnToDeviceSelection;
    const/4 v3, 1
    if-eqz v2, +006h
    iput-object v5, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->deferredConnectionSuccessDevice Lcom/bytedance/trae/conversation/devices/MobileDevice;
    move v1, v3
    goto +17h
    instance-of v5, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$ReturnToDeviceSelection;
    if-eqz v5, +00ch
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$ReturnToDeviceSelection;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$ReturnToDeviceSelection;->getSelectedDeviceId()Ljava/lang/String;
    move-result-object v5
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->completeReturnToDeviceSelection(Ljava/lang/String;)V
    goto -fh
    sget-object v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$NotifyHost;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowConnectionSuccessDestination$NotifyHost;
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    return v1
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    return v1
.end method

.method private final showInitialRoute(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute)void
    .registers 5
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$id;->device_flow_content I
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createRouteFragment(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;)Landroidx/fragment/app/Fragment;
    move-result-object v2
    invoke-virtual v4, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v1, v2, v4, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v4
    invoke-virtual v4, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    return-void 
.end method

.method public closeCurrentFlow()void
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->dismissAllowingStateLoss()V
    return-void 
.end method

.method public navigate(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute)void
    .registers 7
    # ins_size=2
    const-string/jumbo v0, route
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_in_right I
    sget v2, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_out_left I
    sget v3, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_in_left I
    sget v4, Lcom/bytedance/trae/conversation/R$anim;->trae_slide_out_right I
    invoke-virtual v0, v1, v2, v3, v4, Landroidx/fragment/app/FragmentTransaction;->setCustomAnimations(I I I I)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$id;->device_flow_content I
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->createRouteFragment(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;)Landroidx/fragment/app/Fragment;
    move-result-object v2
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v1, v2, v3, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v6, Landroidx/fragment/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v6
    invoke-virtual v6, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    return-void 
.end method

.method public notifyConnectionSuccess()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->getCallbacks()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnConnectionSuccess()Lkotlin/jvm/functions/Function0;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->dismissAllowingStateLoss()V
    return-void 
.end method

.method public notifyConnectionSuccessWithDevice(com.bytedance.trae.conversation.devices.MobileDevice)void
    .registers 3
    # ins_size=2
    const-string v0, "device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->returnToDeviceSelectionAfterBinding(Lcom/bytedance/trae/conversation/devices/MobileDevice;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->getCallbacks()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnConnectionSuccessWithDevice()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->getCallbacks()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v2
    if-eqz v2, +00bh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnConnectionSuccess()Lkotlin/jvm/functions/Function0;
    move-result-object v2
    if-eqz v2, +005h
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->dismissAllowingStateLoss()V
    return-void 
.end method

.method public notifyDeviceListChanged(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "devices"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->getCallbacks()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnDeviceListChanged()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public notifyDeviceSelected(com.bytedance.trae.conversation.devices.SelectedDeviceItem)void
    .registers 3
    # ins_size=2
    const-string v0, "device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->getCallbacks()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnDeviceSelected()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->dismissAllowingStateLoss()V
    return-void 
.end method

.method public onCreate(android.os.Bundle)void
    .registers 4
    # ins_size=2
    invoke-super v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v3
    const/4 v0, 0
    if-eqz v3, +009h
    const-string v1, "arg_request_key"
    invoke-virtual v3, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v0
    iput-object v3, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->requestKey Ljava/lang/String;
    if-eqz v3, +008h
    sget-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;->get(Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
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
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_connect_guide_sheet_height I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    new-instance v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda6;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda6;-><init>(I)V
    invoke-virtual v3, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda7;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;)V
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)V
    check-cast v3, Landroid/app/Dialog;
    return-object v3
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->bottom_sheet_device_flow_container I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public onDismiss(android.content.DialogInterface)void
    .registers 3
    # ins_size=2
    const-string v0, "dialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDismiss(Landroid/content/DialogInterface;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->getCallbacks()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v2
    if-eqz v2, +00bh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnDismiss()Lkotlin/jvm/functions/Function0;
    move-result-object v2
    if-eqz v2, +005h
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->requestKey Ljava/lang/String;
    if-eqz v2, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;->remove(Ljava/lang/String;)V
    const/4 v2, 0
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->deferredConnectionSuccessDevice Lcom/bytedance/trae/conversation/devices/MobileDevice;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->requestKey Ljava/lang/String;
    return-void 
.end method

.method public onResume()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onResume()V
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->completeDeferredConnectionSuccessIfPossible()V
    return-void 
.end method

.method public onRouteBack()boolean
    .registers 8
    # ins_size=1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->isAdded()Z
    move-result v0
    const-string v1, "DeviceFlowContainerBottomSheet"
    const/4 v2, 0
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v3, "device_flow_route_back_deferred: reason=not_added"
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v3, "getChildFragmentManager(...)"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v3
    invoke-virtual v3, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v3
    sget-object v4, Landroidx/lifecycle/Lifecycle$State;->RESUMED Landroidx/lifecycle/Lifecycle$State;
    invoke-virtual v3, v4, Landroidx/lifecycle/Lifecycle$State;->isAtLeast(Landroidx/lifecycle/Lifecycle$State;)Z
    move-result v3
    const/4 v4, 1
    if-eqz v3, +00ah
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v3
    if-nez v3, +004h
    move v3, v4
    goto +2h
    move v3, v2
    sget-object v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackPolicy;
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->getBackStackEntryCount()I
    move-result v6
    invoke-virtual v5, v6, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackPolicy;->leftAction(I Z)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;
    move-result-object v3
    sget-object v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowBackAction;->ordinal()I
    move-result v3
    aget v3, v5, v3
    if-eq v3, v4, +03dh
    const/4 v5, 2
    if-eq v3, v5, +036h
    const/4 v4, 3
    if-ne v3, v4, +02dh
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "device_flow_route_back_deferred: stateSaved="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v4, ", lifecycle="
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v4
    invoke-virtual v4, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +fh
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->closeCurrentFlow()V
    goto +4h
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    move v2, v4
    return v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    if-nez v2, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->dismissAllowingStateLoss()V
    return-void 
    if-nez v3, +015h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    sget v0, Lcom/bytedance/trae/conversation/R$id;->device_flow_content I
    invoke-virtual v3, v0, Landroidx/fragment/app/FragmentManager;->findFragmentById(I)Landroidx/fragment/app/Fragment;
    move-result-object v3
    if-nez v3, +009h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->getInitialRoute()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->showInitialRoute(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;)V
    return-void 
.end method

.method public openNewFlow(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute)void
    .registers 8
    # ins_size=2
    const-string/jumbo v0, route
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->request Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;
    new-instance v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    sget-object v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->getCallbacks()Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v0
    new-instance v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$openNewFlow$1;
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$openNewFlow$1;-><init>(Ljava/lang/Object;)V
    check-cast v4, Lkotlin/jvm/functions/Function0;
    new-instance v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$openNewFlow$2;
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$openNewFlow$2;-><init>(Ljava/lang/Object;)V
    check-cast v5, Lkotlin/jvm/functions/Function1;
    invoke-virtual v3, v0, v4, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;->withCurrentRouteRefresh(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v0
    invoke-direct v2, v7, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    move-result-object v7
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "DeviceFlowContainerBottomSheet"
    invoke-virtual v7, v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method
