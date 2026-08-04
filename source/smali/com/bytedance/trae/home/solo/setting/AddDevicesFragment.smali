# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;
.super Landroidx/fragment/app/Fragment;
.source "AddDevicesFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$Companion;
.field private static final STATE_PAGE_EXPOSURE_REPORTED:Ljava/lang/String;
.field private pageExposureReported:Z
.field private viewModel:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;


.method public static synthetic $r8$lambda$RqYWnadRSKVd4L29pSxEY98FdIw(com.bytedance.trae.home.solo.setting.AddDevicesFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->onViewCreated$lambda$1(Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$oY_6TEqslD7C1UvyHdkMcG2FD9w(com.bytedance.trae.home.solo.setting.AddDevicesFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->onViewCreated$lambda$0(Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ugqOuFNhwmGA1zCxqZzK8XUtKHE(com.bytedance.trae.home.solo.setting.AddDevicesFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->onViewCreated$lambda$2(Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->Companion Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/Fragment;-><init>()V
    return-void 
.end method

.method public static final synthetic access$openUrl(com.bytedance.trae.home.solo.setting.AddDevicesFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->openUrl(Ljava/lang/String;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$0(com.bytedance.trae.home.solo.setting.AddDevicesFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final onViewCreated$lambda$1(com.bytedance.trae.home.solo.setting.AddDevicesFragment  android.view.View)void
    .registers 4
    # ins_size=2
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    const-string/jumbo v0, settings_device_management
    sget-object v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackDownloadLinkCopyClick(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v3
    if-eqz v3, +005h
    const-string v3, "https://trae.ai"
    goto +3h
    const-string v3, "https://trae.cn"
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "clipboard"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    const-string v1, "null cannot be cast to non-null type android.content.ClipboardManager"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/content/ClipboardManager;
    const-string/jumbo v1, url
    check-cast v1, Ljava/lang/CharSequence;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v1, v3, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Landroid/content/ClipData;
    move-result-object v3
    invoke-virtual v0, v3, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_url_copied I
    const/4 v0, 0
    invoke-static v2, v3, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.home.solo.setting.AddDevicesFragment  java.lang.String)kotlin.Unit
    .registers 6
    # ins_size=2
    if-eqz v5, +030h
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_device_online I
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/Object;
    const/4 v3, 0
    aput-object v5, v2, v3
    invoke-virtual v4, v1, v2, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v0, v5, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v5
    invoke-virtual v5, Landroid/widget/Toast;->show()V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v5, +009h
    const-string/jumbo v5, viewModel
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->onNewDeviceToastShown()V
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v4
    invoke-virtual v4, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private final openUrl(java.lang.String)void
    .registers 9
    # ins_size=2
    const-string/jumbo v0, sslocal://webview?hide_nav_bar=1&url=
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v1
    if-eqz v1, +00ch
    sget-object v1, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->Companion Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v3, v8
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;->start$default(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion; Landroid/content/Context; Ljava/lang/String; Z I Ljava/lang/Object;)V
    goto +2ah
    const-string v1, ":/?=&#"
    invoke-static v8, v1, Landroid/net/Uri;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    sget-object v1, Lcom/bytedance/android/anniex/assemble/AnnieX;->INSTANCE Lcom/bytedance/android/anniex/assemble/AnnieX;
    invoke-static v8, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v3
    const-string v8, "parse(...)"
    invoke-static v3, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lcom/bytedance/android/anniex/assemble/AnnieX;->open$default(Lcom/bytedance/android/anniex/assemble/AnnieX; Landroid/content/Context; Landroid/net/Uri; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Z
    goto +5h
    move-exception v8
    invoke-virtual v8, Ljava/lang/Exception;->printStackTrace()V
    return-void 
    :try_start_0xa
.end method

.method public onCreate(android.os.Bundle)void
    .registers 4
    # ins_size=2
    invoke-super v2, v3, Landroidx/fragment/app/Fragment;->onCreate(Landroid/os/Bundle;)V
    const/4 v0, 0
    if-eqz v3, +00dh
    const-string/jumbo v1, state_page_exposure_reported
    invoke-virtual v3, v1, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v3
    const/4 v1, 1
    if-ne v3, v1, +003h
    move v0, v1
    iput-boolean v0, v2, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->pageExposureReported Z
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_add_devices I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 4
    # ins_size=1
    invoke-super v3, Landroidx/fragment/app/Fragment;->onDestroyView()V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->isChangingConfigurations()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    goto +2h
    move v2, v1
    if-nez v2, +004h
    iput-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->pageExposureReported Z
    return-void 
.end method

.method public onPause()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/fragment/app/Fragment;->onPause()V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-eqz v0, +00eh
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->stopPolling()V
    return-void 
.end method

.method public onResume()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/fragment/app/Fragment;->onResume()V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-eqz v0, +00eh
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->startPolling()V
    return-void 
.end method

.method public onSaveInstanceState(android.os.Bundle)void
    .registers 4
    # ins_size=2
    const-string v0, "outState"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, state_page_exposure_reported
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->pageExposureReported Z
    invoke-virtual v3, v0, v1, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    invoke-super v2, v3, Landroidx/fragment/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 9
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v6, v7, v8, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    iget-boolean v8, v6, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->pageExposureReported Z
    if-nez v8, +012h
    const/4 v8, 1
    iput-boolean v8, v6, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->pageExposureReported Z
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    const-string/jumbo v1, settings_device_management
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackPairingPageView$default(Lcom/bytedance/trae/conversation/tracker/DeviceTracker; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; I Ljava/lang/Object;)V
    new-instance v8, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string/jumbo v1, requireActivity(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v8, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    invoke-virtual v8, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    iput-object v8, v6, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    sget v8, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v7, v8, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v6, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;)V
    invoke-virtual v8, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v8, Lcom/bytedance/trae/home/R$id;->tv_step1_url I
    invoke-virtual v7, v8, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, trae.ai
    goto +4h
    const-string/jumbo v0, trae.cn
    const-string v1, "  "
    invoke-virtual v1, v0, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v8, v0, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->setUrlSpannedText(Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$onViewCreated$2;
    invoke-direct v0, v6, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$onViewCreated$2;-><init>(Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;)V
    check-cast v0, Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;
    invoke-virtual v8, v0, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->setOnClickListener(Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;)V
    sget v8, Lcom/bytedance/trae/home/R$id;->btn_copy_url I
    invoke-virtual v7, v8, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v7
    check-cast v7, Landroid/widget/ImageView;
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$$ExternalSyntheticLambda1;
    invoke-direct v8, v6, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;)V
    invoke-virtual v7, v8, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    if-nez v7, +009h
    const-string/jumbo v7, viewModel
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v7, 0
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->getNewOnlineDevice()Landroidx/lifecycle/LiveData;
    move-result-object v7
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v8
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$$ExternalSyntheticLambda2;
    invoke-direct v0, v6, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/AddDevicesFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v1, Landroidx/lifecycle/Observer;
    invoke-virtual v7, v8, v1, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    return-void 
.end method
