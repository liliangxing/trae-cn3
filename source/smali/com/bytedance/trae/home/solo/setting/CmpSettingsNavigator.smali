# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;
.super Ljava/lang/Object;
.source "CmpSettingsNavigator.kt"

.field public static final $stable:I
.field private final fragmentManager:Landroidx/fragment/app/FragmentManager;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(androidx.fragment.app.FragmentManager)void
    .registers 3
    # ins_size=2
    const-string v0, "fragmentManager"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->fragmentManager Landroidx/fragment/app/FragmentManager;
    return-void 
.end method

.method private final push(androidx.fragment.app.Fragment)void
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->fragmentManager Landroidx/fragment/app/FragmentManager;
    sget v1, Lcom/bytedance/trae/home/R$id;->settings_fragment_container I
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentById(I)Landroidx/fragment/app/Fragment;
    move-result-object v0
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->fragmentManager Landroidx/fragment/app/FragmentManager;
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/home/R$anim;->trae_slide_in_right I
    sget v3, Lcom/bytedance/trae/home/R$anim;->trae_slide_out_left I
    sget v4, Lcom/bytedance/trae/home/R$anim;->trae_slide_in_left I
    sget v5, Lcom/bytedance/trae/home/R$anim;->trae_slide_out_right I
    invoke-virtual v1, v2, v3, v4, v5, Landroidx/fragment/app/FragmentTransaction;->setCustomAnimations(I I I I)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    if-eqz v0, +005h
    invoke-virtual v1, v0, Landroidx/fragment/app/FragmentTransaction;->hide(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    sget v0, Lcom/bytedance/trae/home/R$id;->settings_fragment_container I
    invoke-virtual v1, v0, v7, Landroidx/fragment/app/FragmentTransaction;->add(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v7
    const/4 v0, 0
    invoke-virtual v7, v0, Landroidx/fragment/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v7
    invoke-virtual v7, Landroidx/fragment/app/FragmentTransaction;->commit()I
    return-void 
.end method

.method public final openAbout()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;->Companion Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsAboutFragment;
    move-result-object v0
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->push(Landroidx/fragment/app/Fragment;)V
    return-void 
.end method

.method public final openConnectComputerGuide()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment;->Companion Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/fragment/CmpConnectComputerGuideFragment;
    move-result-object v0
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->push(Landroidx/fragment/app/Fragment;)V
    return-void 
.end method

.method public final openDeviceManagement()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;->INSTANCE Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;->isDeviceManagementEnabled()Z
    move-result v0
    if-eqz v0, +00bh
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;->Companion Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment;
    move-result-object v0
    check-cast v0, Landroidx/fragment/app/Fragment;
    goto +9h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;->Companion Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/DeviceManagementFragment;
    move-result-object v0
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->push(Landroidx/fragment/app/Fragment;)V
    return-void 
.end method

.method public final openNative(androidx.fragment.app.Fragment)void
    .registers 3
    # ins_size=2
    const-string v0, "fragment"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->push(Landroidx/fragment/app/Fragment;)V
    return-void 
.end method

.method public final pop()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->fragmentManager Landroidx/fragment/app/FragmentManager;
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->getBackStackEntryCount()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 0
    return v0
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->fragmentManager Landroidx/fragment/app/FragmentManager;
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    const/4 v0, 1
    return v0
.end method
