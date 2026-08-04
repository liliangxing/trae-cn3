# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
.super Landroidx/fragment/app/Fragment;
.source "DeviceManagementFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$Companion;
.field private static final EMPTY_GUIDE_FRAGMENT_TAG:Ljava/lang/String;
.field private static final STATE_EMPTY_GUIDE_PRODUCT_TYPE:Ljava/lang/String;
.field private actionPopup:Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
.field private adapter:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
.field private hasTrackedPageView:Z
.field private isBindingGuideShowing:Z
.field private isEmbeddedEmptyGuideShowing:Z
.field private isRefreshingAfterEmbeddedSuccess:Z
.field private selectedEmptyGuideTarget:Lcom/bytedance/trae/conversation/devices/DeviceProductType;
.field private viewModel:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;


.method public static synthetic $r8$lambda$-GAYafkdo42uLZIyw3YgjoVrgWg(kotlin.jvm.functions.Function0  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showUnbindDialog$lambda$27(Lkotlin/jvm/functions/Function0; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$07Bqdegj694yjytittxaD_kNHFw(com.bytedance.trae.home.solo.setting.DeviceManagementFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showBindingDeviceFlow$lambda$29(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$1rtZ_JB_AW2pHK8VdmMWqxurkmY(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  java.lang.Boolean)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$13(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$42NHKyU3m0LmhpP95AgIv3YITzI(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  java.lang.Boolean)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$14(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$9JCuHaZCViMyfpyYENJItJ2_93A(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showActionPopup$lambda$23(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Bq-8wH76cYPWHyNiEuRTiDKn5k4(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  android.view.View  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->setupEmptyGuide$lambda$16(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$DkddK0qxwNkqfXYO7TVjKhWthAw(kotlin.jvm.functions.Function0  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showRenameDialog$lambda$25(Lkotlin/jvm/functions/Function0; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$GnCz15lKL-HlWgMK0358jBGyGCQ(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$12(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$H0TNZDxKw1U9_OSqP545kYxk9so(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$7(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Mpw1mC-ZWMAZUrlnyx4E950xWB8(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showUnbindDialog$lambda$26(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$PwiVV2CHwJkZfbRPn2H4eg_OcSQ(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$5(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$VTLSRD8VeCqhdS_Hr_RsjVbh3hc(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showRenameDialog$lambda$24(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$_yfRI3XyL_qM4f5O1cw-Ga8xyaU(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$2(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$eItuiJwJ1g_d6ZVkd3YO7Yge2vA()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showActionPopup$lambda$21$lambda$20()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$fYjCvTEHWrpnblf5lhyY-A_lcnM(com.bytedance.trae.home.solo.setting.DeviceManagementFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$6(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ftrvsfUJ74OFe80HpLJkpcvaoVo(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$8(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$mO_Bjhj83AK7sE5LIiK44b6QfKQ(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.conversation.devices.MobileDevice)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->bindEmbeddedGuideCallback$lambda$19(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/conversation/devices/MobileDevice;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nij71YvXbJHLtEki8NLonMXDxQc(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showActionPopup$lambda$21(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nirhwLa42pOih2te88GyvRDqCo0()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showActionPopup$lambda$23$lambda$22()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$p74Gq6ZuoTj0npO6gfa2Ks_-34Q(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$4(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pE9lzm8ztXuEOCVJ78c1A32vgeI(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem  android.view.View  float  float)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$3(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Landroid/view/View; F F)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$uC4afE_Z1CNzJn8Q4GHxnDg3GaY(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  android.view.View  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->setupEmptyGuide$lambda$15(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$vrO8W2xbkoWUBUKaTdBuSP1h1f0(android.widget.ProgressBar  java.lang.Boolean)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$9(Landroid/widget/ProgressBar; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$wBB0iyaTdRy7wQnz5E1_MtahKdw(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  android.view.View  android.view.View  androidx.recyclerview.widget.RecyclerView  android.widget.TextView  java.util.List)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onViewCreated$lambda$11(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Landroid/view/View; Landroid/view/View; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/TextView; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$yq4NBdWcWCx_WXGgGsOF8uh89Oc(com.bytedance.trae.home.solo.setting.DeviceManagementFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showBindingDeviceFlow$lambda$28(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->Companion Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/fragment/app/Fragment;-><init>()V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->selectedEmptyGuideTarget Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-void 
.end method

.method public static final synthetic access$getAdapter$p(com.bytedance.trae.home.solo.setting.DeviceManagementFragment)com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->adapter Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    return-object v0
.end method

.method private final bindEmbeddedGuideCallback(com.bytedance.trae.conversation.devices.ConnectComputerGuideFragment)void
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda1;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->setOnConnectionSuccessListener(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final bindEmbeddedGuideCallback$lambda$19(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.conversation.devices.MobileDevice)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "it"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v3, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isEmbeddedEmptyGuideShowing Z
    if-eqz v3, +026h
    const/4 v3, 1
    iput-boolean v3, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isRefreshingAfterEmbeddedSuccess Z
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    const/4 v0, 0
    const-string/jumbo v1, viewModel
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->fetchDevices()V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isResumed()Z
    move-result v3
    if-eqz v3, +00eh
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->startPolling()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private final onBindingFlowClosed()void
    .registers 5
    # ins_size=1
    iget-boolean v0, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isBindingGuideShowing Z
    if-nez v0, +003h
    return-void 
    const/4 v0, 0
    iput-boolean v0, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isBindingGuideShowing Z
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 1
    invoke-virtual v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->setNewDeviceNotificationsEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->fetchDevices()V
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isResumed()Z
    move-result v0
    if-eqz v0, +00eh
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->startPolling()V
    return-void 
.end method

.method private static final onViewCreated$lambda$11(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  android.view.View  android.view.View  androidx.recyclerview.widget.RecyclerView  android.widget.TextView  java.util.List)kotlin.Unit
    .registers 13
    # ins_size=6
    iget-boolean v0, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->hasTrackedPageView Z
    const/4 v1, 1
    if-nez v0, +00dh
    iput-boolean v1, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->hasTrackedPageView Z
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    invoke-interface v12, Ljava/util/List;->size()I
    move-result v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackDeviceManagementPageView(I)V
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v0, v12
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v0, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    const/4 v2, 0
    if-le v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->adapter Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    const-string v4, "adapter"
    const/4 v5, 0
    if-nez v3, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v5
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->getShowProductType()Z
    move-result v3
    if-eq v3, v0, +004h
    move v3, v1
    goto +2h
    move v3, v2
    iget-object v6, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->adapter Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    if-nez v6, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v5
    invoke-virtual v6, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->setShowProductType(Z)V
    if-eqz v3, +027h
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->adapter Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v5
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->getItemCount()I
    move-result v0
    if-lez v0, +019h
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->adapter Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v5
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->adapter Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    if-nez v3, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v5
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->getItemCount()I
    move-result v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->notifyItemRangeChanged(I I)V
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->adapter Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v5
    invoke-virtual v0, v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->submitList(Ljava/util/List;)V
    invoke-interface v12, Ljava/util/List;->isEmpty()Z
    move-result v12
    const-string/jumbo v0, viewModel
    if-eqz v12, +036h
    iput-boolean v1, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isEmbeddedEmptyGuideShowing Z
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v1, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v5
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->setNewDeviceNotificationsEnabled(Z)V
    iget-boolean v1, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isRefreshingAfterEmbeddedSuccess Z
    if-eqz v1, +015h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isResumed()Z
    move-result v1
    if-eqz v1, +00fh
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v1, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v1
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->startPolling()V
    goto +dh
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v1, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v1
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->stopPolling()V
    invoke-direct v7, v8, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->renderEmptyGuide(Landroid/view/View;)V
    goto +18h
    iput-boolean v2, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isRefreshingAfterEmbeddedSuccess Z
    iput-boolean v2, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isEmbeddedEmptyGuideShowing Z
    invoke-direct v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->removeEmbeddedEmptyGuide()V
    iget-boolean v8, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isBindingGuideShowing Z
    if-nez v8, +00eh
    iget-object v7, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v7, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v5, v7
    invoke-virtual v5, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->setNewDeviceNotificationsEnabled(Z)V
    const/16 v7, 8
    if-eqz v12, +004h
    move v8, v2
    goto +2h
    move v8, v7
    invoke-virtual v9, v8, Landroid/view/View;->setVisibility(I)V
    if-eqz v12, +004h
    move v8, v7
    goto +2h
    move v8, v2
    invoke-virtual v10, v8, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    if-eqz v12, +003h
    move v2, v7
    invoke-virtual v11, v2, Landroid/widget/TextView;->setVisibility(I)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final onViewCreated$lambda$12(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  java.lang.String)kotlin.Unit
    .registers 6
    # ins_size=2
    if-eqz v5, +029h
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_device_online I
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/Object;
    const/4 v3, 0
    aput-object v5, v2, v3
    invoke-virtual v4, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v0, v5, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v5
    invoke-virtual v5, Landroid/widget/Toast;->show()V
    iget-object v4, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v4, +009h
    const-string/jumbo v4, viewModel
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->onNewDeviceToastShown()V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final onViewCreated$lambda$13(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  java.lang.Boolean)kotlin.Unit
    .registers 4
    # ins_size=2
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +024h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    sget v0, Lcom/bytedance/trae/home/R$string;->solo_toast_rename_failed I
    invoke-virtual v2, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v3, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->onRenameFailureToastShown()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onViewCreated$lambda$14(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  java.lang.Boolean)kotlin.Unit
    .registers 4
    # ins_size=2
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +024h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    sget v0, Lcom/bytedance/trae/home/R$string;->solo_toast_device_unbind_failed I
    invoke-virtual v2, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v3, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->onUnbindFailureToastShown()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "item"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showUnpairedDeviceBindingGuide(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem  android.view.View  float  float)kotlin.Unit
    .registers 6
    # ins_size=5
    const-string v0, "item"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v4, v5, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showActionPopup(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; F F)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "item"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "closeAction"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showRenameDialog(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Lkotlin/jvm/functions/Function0;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "item"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "closeAction"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showUnbindDialog(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Lkotlin/jvm/functions/Function0;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$6(com.bytedance.trae.home.solo.setting.DeviceManagementFragment)kotlin.Unit
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_toast_unpaired_device_unsupported I
    invoke-virtual v2, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v0, v2, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onViewCreated$lambda$7(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final onViewCreated$lambda$8(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showAddDeviceTargetSelector()V
    return-void 
.end method

.method private static final onViewCreated$lambda$9(android.widget.ProgressBar  java.lang.Boolean)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 0
    goto +3h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final removeEmbeddedEmptyGuide()void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v1, "device_management_empty_guide"
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    goto +2h
    move-object v0, v2
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->setOnConnectionSuccessListener(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    const/4 v2, 1
    invoke-virtual v1, v2, Landroidx/fragment/app/FragmentTransaction;->setReorderingAllowed(Z)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-virtual v1, v0, Landroidx/fragment/app/FragmentTransaction;->remove(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    return-void 
.end method

.method private final renderEmptyGuide(android.view.View)void
    .registers 9
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    const/4 v1, 0
    const/4 v2, 1
    const/4 v3, 0
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->availableTargets$default(Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy; Z I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    iget-object v4, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->selectedEmptyGuideTarget Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-interface v0, v4, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    move-object v3, v4
    if-nez v3, +00ch
    invoke-static v0, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-nez v3, +004h
    sget-object v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iput-object v3, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->selectedEmptyGuideTarget Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v4
    if-le v4, v2, +004h
    move v4, v2
    goto +2h
    move v4, v1
    sget v5, Lcom/bytedance/trae/home/R$id;->layout_empty_guide_tabs I
    invoke-virtual v8, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    const/16 v6, 8
    if-eqz v4, +004h
    move v4, v1
    goto +2h
    move v4, v6
    invoke-virtual v5, v4, Landroid/view/View;->setVisibility(I)V
    sget v4, Lcom/bytedance/trae/home/R$id;->tab_empty_guide_ide I
    invoke-virtual v8, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-interface v0, v5, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    move v6, v1
    invoke-virtual v4, v6, Landroid/view/View;->setVisibility(I)V
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_empty_guide_work_tab I
    sget v4, Lcom/bytedance/trae/home/R$id;->indicator_empty_guide_work I
    sget-object v5, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-ne v3, v5, +004h
    move v5, v2
    goto +2h
    move v5, v1
    invoke-direct v7, v8, v0, v4, v5, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->renderEmptyGuideTab(Landroid/view/View; I I Z)V
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_empty_guide_ide_tab I
    sget v4, Lcom/bytedance/trae/home/R$id;->indicator_empty_guide_ide I
    sget-object v5, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-ne v3, v5, +003h
    move v1, v2
    invoke-direct v7, v8, v0, v4, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->renderEmptyGuideTab(Landroid/view/View; I I Z)V
    invoke-direct v7, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showEmbeddedEmptyGuide(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    return-void 
.end method

.method private final renderEmptyGuideTab(android.view.View  int  int  boolean)void
    .registers 7
    # ins_size=5
    invoke-virtual v3, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v3, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    if-eqz v6, +005h
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    goto +3h
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v4, v0, Landroid/widget/TextView;->setTextColor(I)V
    if-eqz v6, +006h
    const-string/jumbo v0, sans-serif-medium
    goto +4h
    const-string/jumbo v0, sans-serif
    const/4 v1, 0
    invoke-static v0, v1, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v0
    invoke-virtual v4, v0, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v3, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    if-eqz v6, +003h
    goto +2h
    const/4 v1, 4
    invoke-virtual v3, v1, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method private final selectEmptyGuideTarget(android.view.View  com.bytedance.trae.conversation.devices.DeviceProductType)void
    .registers 7
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    const/4 v1, 1
    const/4 v2, 0
    const/4 v3, 0
    invoke-static v0, v3, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->availableTargets$default(Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy; Z I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, v6, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->selectedEmptyGuideTarget Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->renderEmptyGuide(Landroid/view/View;)V
    return-void 
.end method

.method private final setupEmptyGuide(android.view.View)void
    .registers 4
    # ins_size=2
    sget v0, Lcom/bytedance/trae/home/R$id;->tab_empty_guide_work I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda23;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda23;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Landroid/view/View;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->tab_empty_guide_ide I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda24;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda24;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Landroid/view/View;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupEmptyGuide$lambda$15(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  android.view.View  android.view.View)void
    .registers 3
    # ins_size=3
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->selectEmptyGuideTarget(Landroid/view/View; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    return-void 
.end method

.method private static final setupEmptyGuide$lambda$16(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  android.view.View  android.view.View)void
    .registers 3
    # ins_size=3
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->selectEmptyGuideTarget(Landroid/view/View; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    return-void 
.end method

.method private final showActionPopup(com.bytedance.trae.home.solo.setting.SettingsDeviceItem  float  float)void
    .registers 32
    # ins_size=4
    move-object/from16 v0, v28
    move-object/from16 v1, v29
    invoke-virtual/range v29, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v2
    if-nez v2, +003h
    return-void 
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->actionPopup Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    if-eqz v2, +005h
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->dismiss()V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->adapter Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    if-nez v2, +008h
    const-string v2, "adapter"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->closeOpenItem()V
    new-instance v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    invoke-virtual/range v28, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    const-string/jumbo v3, requireContext(...)
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 2
    new-array v3, v3, [Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    new-instance v15, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    sget v6, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_rename I
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_context_menu_rename I
    invoke-virtual v0, v5, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    const-string v14, "getString(...)"
    invoke-static v5, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v7, v5
    check-cast v7, Ljava/lang/CharSequence;
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    sget v11, Lcom/bytedance/trae/home/R$id;->menu_rename I
    new-instance v12, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda2;
    invoke-direct v12, v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;)V
    const/16 v13, 28
    const/16 v16, 0
    move-object v5, v15
    move-object/from16 v17, v4
    move-object v4, v14
    move-object/from16 v14, v16
    invoke-direct/range v5 ... v14, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v5, 0
    aput-object v15, v3, v5
    new-instance v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    sget v19, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_delete I
    sget v6, Lcom/bytedance/trae/home/R$string;->solo_device_context_menu_unbind I
    invoke-virtual v0, v6, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v20, v6
    check-cast v20, Ljava/lang/CharSequence;
    const/16 v21, 1
    const/16 v22, 0
    const/16 v23, 0
    sget v24, Lcom/bytedance/trae/home/R$id;->menu_delete I
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda3;
    invoke-direct v4, v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;)V
    const/16 v26, 24
    const/16 v27, 0
    move-object/from16 v18, v5
    move-object/from16 v25, v4
    invoke-direct/range v18 ... v27, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v1, 1
    aput-object v5, v3, v1
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 4
    const/4 v8, 0
    move-object v3, v2
    move-object/from16 v4, v17
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;-><init>(Landroid/content/Context; Ljava/util/List; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual/range v28, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->requireView()Landroid/view/View;
    move-result-object v1
    const-string/jumbo v3, requireView(...)
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v3, v30
    move/from16 v4, v31
    invoke-virtual v2, v1, v3, v4, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->showNear(Landroid/view/View; F F)V
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->actionPopup Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    return-void 
.end method

.method private static final showActionPopup$lambda$21(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem)kotlin.Unit
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda17;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda17;-><init>()V
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showRenameDialog(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Lkotlin/jvm/functions/Function0;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final showActionPopup$lambda$21$lambda$20()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final showActionPopup$lambda$23(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem)kotlin.Unit
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda18;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda18;-><init>()V
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showUnbindDialog(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Lkotlin/jvm/functions/Function0;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final showActionPopup$lambda$23$lambda$22()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final showAddDeviceTargetSelector()void
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    const/4 v1, 0
    const/4 v2, 1
    const/4 v3, 0
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->availableTargets$default(Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy; Z I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v4, +009h
    const-string/jumbo v4, viewModel
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->getDevices()Landroidx/lifecycle/LiveData;
    move-result-object v4
    invoke-virtual v4, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/List;
    if-nez v4, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceMapperKt;->deviceIdsByProduct(Ljava/util/List;)Ljava/util/Map;
    move-result-object v4
    const-string/jumbo v5, settings_device_management
    invoke-virtual v2, v0, v4, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;->targetSelectRoute(Ljava/util/List; Ljava/util/Map; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    move-result-object v0
    const/4 v2, 2
    invoke-static v6, v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showBindingDeviceFlow$default(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Z I Ljava/lang/Object;)V
    return-void 
.end method

.method private final showBindingDeviceFlow(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute  boolean)void
    .registers 14
    # ins_size=3
    iget-boolean v0, v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isBindingGuideShowing Z
    if-nez v0, +0aah
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isAdded()Z
    move-result v0
    if-eqz v0, +0a4h
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    if-nez v0, +09ah
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;
    move-result-object v0
    sget-object v1, Landroidx/lifecycle/Lifecycle$State;->STARTED Landroidx/lifecycle/Lifecycle$State;
    invoke-virtual v0, v1, Landroidx/lifecycle/Lifecycle$State;->isAtLeast(Landroidx/lifecycle/Lifecycle$State;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +088h
    instance-of v0, v12, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    const/4 v1, 0
    if-eqz v0, +00eh
    move-object v0, v12
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;->getTarget()Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    goto +12h
    instance-of v0, v12, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;
    if-eqz v0, +00eh
    move-object v0, v12
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$OfflineActivation;->getTarget()Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-eqz v13, +00dh
    if-eqz v0, +00bh
    sget-object v13, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->INSTANCE Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;
    invoke-virtual v13, v0, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->canOpenConnectGuide(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Z
    move-result v13
    if-nez v13, +003h
    return-void 
    const/4 v13, 1
    iput-boolean v13, v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isBindingGuideShowing Z
    sget-object v13, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    const-string/jumbo v0, settings_device_management
    invoke-virtual v13, v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackConnectEntryClick(Ljava/lang/String; Lcom/bytedance/trae/conversation/widget/ChatMode;)V
    iget-object v13, v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    const-string/jumbo v0, viewModel
    if-nez v13, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v1
    const/4 v2, 0
    invoke-virtual v13, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->setNewDeviceNotificationsEnabled(Z)V
    iget-object v13, v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v13, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v13
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->stopPolling()V
    sget-object v13, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    new-instance v10, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda0;
    invoke-direct v5, v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda11;
    invoke-direct v7, v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    const/16 v8, 23
    const/4 v9, 0
    move-object v1, v10
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v0, v12, v10, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    invoke-virtual v13, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$Companion;->newInstance(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    move-result-object v12
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v13
    const-string v0, "DeviceFlowContainerBottomSheet"
    invoke-virtual v12, v13, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
    move-exception v12
    invoke-direct v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onBindingFlowClosed()V
    throw v12
    return-void 
    :try_start_0x9d
.end method

.method static synthetic showBindingDeviceFlow$default(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showBindingDeviceFlow(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Z)V
    return-void 
.end method

.method private static final showBindingDeviceFlow$lambda$28(com.bytedance.trae.home.solo.setting.DeviceManagementFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onBindingFlowClosed()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final showBindingDeviceFlow$lambda$29(com.bytedance.trae.home.solo.setting.DeviceManagementFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->onBindingFlowClosed()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final showEmbeddedEmptyGuide(com.bytedance.trae.conversation.devices.DeviceProductType)void
    .registers 15
    # ins_size=2
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isAdded()Z
    move-result v0
    if-eqz v0, +0d1h
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z
    move-result v0
    if-eqz v0, +004h
    goto/16 +0c5h
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string v9, "device_management_empty_guide"
    invoke-virtual v0, v9, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v2, v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    const/4 v3, 0
    if-eqz v2, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    goto +2h
    move-object v0, v3
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->getTargetProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v2
    goto +2h
    move-object v2, v3
    if-ne v2, v14, +006h
    invoke-direct v13, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->bindEmbeddedGuideCallback(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    return-void 
    if-eqz v0, +005h
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->setOnConnectionSuccessListener(Lkotlin/jvm/functions/Function1;)V
    sget-object v10, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;->Companion Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;
    iget-object v0, v13, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v0
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->getDevices()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    const/4 v11, 1
    if-eqz v3, +017h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v4
    if-ne v4, v14, +003h
    goto +2h
    const/4 v11, 0
    if-eqz v11, -016h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1bh
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    move-object v2, v0
    check-cast v2, Ljava/util/Set;
    const-string/jumbo v3, settings_device_management
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 56
    const/4 v8, 0
    new-instance v12, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-object v0, v12
    move-object v1, v14
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v10, v12, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment$Companion;->newEmbeddedInstance(Lcom/bytedance/trae/conversation/devices/BindingTarget;)Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;
    move-result-object v0
    invoke-direct v13, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->bindEmbeddedGuideCallback(Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideFragment;)V
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    invoke-virtual v1, v11, Landroidx/fragment/app/FragmentTransaction;->setReorderingAllowed(Z)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/home/R$id;->empty_guide_content I
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-virtual v1, v2, v0, v9, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commit()I
    return-void 
.end method

.method private final showRenameDialog(com.bytedance.trae.home.solo.setting.SettingsDeviceItem  kotlin.jvm.functions.Function0)void
    .registers 15
    # ins_size=3
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v0, requireContext(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/home/R$string;->solo_device_dialog_rename_title I
    invoke-virtual v12, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v0, "getString(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getName()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    sget v6, Lcom/bytedance/trae/home/R$string;->solo_dialog_btn_cancel I
    invoke-virtual v12, v6, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v7, Lcom/bytedance/trae/home/R$string;->solo_dialog_btn_confirm I
    invoke-virtual v12, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda21;
    invoke-direct v8, v12, v13, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda21;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;)V
    const/4 v9, 0
    const/16 v10, 136
    const/4 v11, 0
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->rename$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v13
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda22;
    invoke-direct v0, v14, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda22;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v13, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showRenameDialog$lambda$24(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem  java.lang.String)kotlin.Unit
    .registers 5
    # ins_size=3
    const/4 v0, 0
    if-eqz v4, +00dh
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v0
    if-nez v4, +004h
    const-string v4, ""
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +015h
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v2, +009h
    const-string/jumbo v2, viewModel
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->renameDevice(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final showRenameDialog$lambda$25(kotlin.jvm.functions.Function0  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final showUnbindDialog(com.bytedance.trae.home.solo.setting.SettingsDeviceItem  kotlin.jvm.functions.Function0)void
    .registers 25
    # ins_size=3
    move-object/from16 v0, v22
    invoke-virtual/range v23, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v1
    if-nez v1, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    invoke-virtual/range v22, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    move-object v3, v1
    const-string/jumbo v4, requireContext(...)
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_device_unbind_dialog_title I
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    move-object v4, v1
    const-string v8, "getString(...)"
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_device_unbind_dialog_message I
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    move-object v5, v1
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_dialog_btn_cancel I
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_device_dialog_btn_unbind I
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    move-object v7, v1
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda19;
    move-object/from16 v18, v1
    move-object/from16 v8, v23
    invoke-direct v1, v0, v8, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda19;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;)V
    const/16 v19, 0
    const v20, 98272
    const/16 v21, 0
    const/4 v8, 0
    invoke-static/range v2 ... v21, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda20;
    move-object/from16 v3, v24
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda20;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showUnbindDialog$lambda$26(com.bytedance.trae.home.solo.setting.DeviceManagementFragment  com.bytedance.trae.home.solo.setting.SettingsDeviceItem)kotlin.Unit
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->unbindDevice(Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final showUnbindDialog$lambda$27(kotlin.jvm.functions.Function0  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final showUnpairedDeviceBindingGuide(com.bytedance.trae.home.solo.setting.SettingsDeviceItem)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->getDevices()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    const-string/jumbo v1, settings_device_management
    invoke-static v3, v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceMapperKt;->unpairedBindingRoute(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Ljava/util/List; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    check-cast v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    const/4 v0, 0
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->showBindingDeviceFlow(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Z)V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_device_management I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->actionPopup Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->dismiss()V
    const/4 v0, 0
    iput-object v0, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->actionPopup Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-eqz v1, +01fh
    iget-boolean v2, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isBindingGuideShowing Z
    if-nez v2, +006h
    iget-boolean v2, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isEmbeddedEmptyGuideShowing Z
    if-eqz v2, +017h
    const/4 v2, 0
    iput-boolean v2, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isBindingGuideShowing Z
    iput-boolean v2, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isEmbeddedEmptyGuideShowing Z
    iput-boolean v2, v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isRefreshingAfterEmbeddedSuccess Z
    if-nez v1, +009h
    const-string/jumbo v1, viewModel
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v1
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->setNewDeviceNotificationsEnabled(Z)V
    invoke-super v3, Landroidx/fragment/app/Fragment;->onDestroyView()V
    return-void 
.end method

.method public onPause()void
    .registers 3
    # ins_size=1
    invoke-super v2, Landroidx/fragment/app/Fragment;->onPause()V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    const/4 v1, 0
    if-eqz v0, +00eh
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->stopPolling()V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->actionPopup Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->dismiss()V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->adapter Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    if-eqz v0, +00eh
    if-nez v0, +008h
    const-string v0, "adapter"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->closeOpenItem()V
    return-void 
.end method

.method public onResume()void
    .registers 5
    # ins_size=1
    invoke-super v4, Landroidx/fragment/app/Fragment;->onResume()V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-eqz v0, +04eh
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isBindingGuideShowing Z
    const/4 v2, 0
    const-string/jumbo v3, viewModel
    if-nez v1, +030h
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isEmbeddedEmptyGuideShowing Z
    if-eqz v1, +007h
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isRefreshingAfterEmbeddedSuccess Z
    if-nez v1, +003h
    goto +26h
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->isEmbeddedEmptyGuideShowing Z
    xor-int/lit8 v1, v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->setNewDeviceNotificationsEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->fetchDevices()V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->startPolling()V
    goto +17h
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->setNewDeviceNotificationsEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->stopPolling()V
    return-void 
.end method

.method public onSaveInstanceState(android.os.Bundle)void
    .registers 4
    # ins_size=2
    const-string v0, "outState"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->selectedEmptyGuideTarget Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, state_empty_guide_product_type
    invoke-virtual v3, v1, v0, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-super v2, v3, Landroidx/fragment/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 18
    # ins_size=3
    move-object v7, v15
    move-object/from16 v3, v16
    move-object/from16 v0, v17
    const-string/jumbo v1, view
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super/range v15 ... v17, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v1, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v2
    const-string/jumbo v4, requireActivity(...)
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v1, v2, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    invoke-virtual v1, v2, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    iput-object v1, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    const/4 v8, 0
    if-eqz v0, +030h
    const-string/jumbo v1, state_empty_guide_product_type
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +027h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v7
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-eqz v0, +003h
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iput-object v0, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->selectedEmptyGuideTarget Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    sget v0, Lcom/bytedance/trae/home/R$id;->progress_loading I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/ProgressBar;
    sget v1, Lcom/bytedance/trae/home/R$id;->rv_device_management I
    invoke-virtual v3, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView;
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_empty_guide I
    invoke-virtual v3, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_add_device I
    invoke-virtual v3, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/TextView;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda4;
    invoke-direct v10, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    new-instance v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda7;
    invoke-direct v11, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    new-instance v12, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda8;
    invoke-direct v12, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    new-instance v13, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda9;
    invoke-direct v13, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    new-instance v14, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda10;
    invoke-direct v14, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    move-object v9, v1
    invoke-direct/range v9 ... v14, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function4; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function0;)V
    iput-object v1, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->adapter Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    new-instance v1, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-direct v1, v2, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v5, v1, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->adapter Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    if-nez v1, +008h
    const-string v1, "adapter"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v8
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v5, v1, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$7;
    invoke-direct v1, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$7;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
    invoke-virtual v5, v1, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v1
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v2
    const-string v9, "getViewLifecycleOwner(...)"
    invoke-static v2, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v9, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$8;
    invoke-direct v9, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$onViewCreated$8;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    check-cast v9, Landroidx/activity/OnBackPressedCallback;
    invoke-virtual v1, v2, v9, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner; Landroidx/activity/OnBackPressedCallback;)V
    sget v1, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v3, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda12;
    invoke-direct v2, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct/range v15 ... v16, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->setupEmptyGuide(Landroid/view/View;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda13;
    invoke-direct v1, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    invoke-virtual v6, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    const-string/jumbo v9, viewModel
    if-nez v1, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v8
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->isLoading()Landroidx/lifecycle/LiveData;
    move-result-object v1
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v2
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda14;
    invoke-direct v10, v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda14;-><init>(Landroid/widget/ProgressBar;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v0, v10, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v0, Landroidx/lifecycle/Observer;
    invoke-virtual v1, v2, v0, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v8
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->getDevices()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v10
    new-instance v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda15;
    move-object v1, v11
    move-object v2, v15
    move-object/from16 v3, v16
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda15;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment; Landroid/view/View; Landroid/view/View; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/TextView;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v1, v11, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v1, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v10, v1, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v8
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->getNewOnlineDevice()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda16;
    invoke-direct v2, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda16;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v8
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->getRenameFailed()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda5;
    invoke-direct v2, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v0, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v8, v0
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->getUnbindFailed()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda6;
    invoke-direct v2, v15, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;)V
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
    :try_start_0x35
.end method
