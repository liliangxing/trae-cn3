# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
.super Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;
.source "CmpSettingsEntryFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$Companion;
.field private final composeViewId:I
.field private final leftAction:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field private final legacyViewModel$delegate:Lkotlin/Lazy;
.field private final rightAction:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field private final settingsEntryViewModel$delegate:Lkotlin/Lazy;
.field private final titleResId:I


.method public static synthetic $r8$lambda$-m_qyNBb-fOUVLaTHuiU5dlsfSU(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)androidx.lifecycle.ViewModelProvider$Factory
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->settingsEntryViewModel_delegate$lambda$1(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)Landroidx/lifecycle/ViewModelProvider$Factory;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Ex0LXbVGqs23_s1BNmVODnzFPYU(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->RenderCmpContent$lambda$14$lambda$13$lambda$12(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$RwMJuwCHRvw9pivryoQq7nC54Cs(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)com.bytedance.trae.home.solo.setting.SettingsViewModel
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->legacyViewModel_delegate$lambda$0(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$TbTtyfVf_ILV3s0E3eJOglevry4(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->RenderCmpContent$lambda$14$lambda$11$lambda$10(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ej8uDhO34LW8hEcSwjp_eVqxjeo()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->showNotificationConfirmDialog$lambda$16()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$guXdZ3RMhIz07erqhN7E7kzhHnY()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->showNotificationConfirmDialog$lambda$17()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$rEb-fW5zMpiy-zW-1kcafplYwhU(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->RenderCmpContent$lambda$15(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$vfpF0L0-SjOgv_mr-HH0NP-f0C8(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->RenderCmpContent$lambda$14$lambda$9$lambda$8(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->Companion Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;-><init>()V
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_title I
    iput v0, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->titleResId I
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    iput-object v0, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->CLOSE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    iput-object v0, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->rightAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget v0, Lcom/bytedance/trae/home/R$id;->cmp_settings_entry_root I
    iput v0, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->composeViewId I
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda4;
    invoke-direct v0, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->legacyViewModel$delegate Lkotlin/Lazy;
    move-object v0, v5
    check-cast v0, Landroidx/fragment/app/Fragment;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda5;
    invoke-direct v1, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)V
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$special$$inlined$viewModels$default$1;
    invoke-direct v2, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$special$$inlined$viewModels$default$1;-><init>(Landroidx/fragment/app/Fragment;)V
    check-cast v2, Lkotlin/jvm/functions/Function0;
    const-class v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    invoke-static v3, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$special$$inlined$viewModels$default$2;
    invoke-direct v4, v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$special$$inlined$viewModels$default$2;-><init>(Lkotlin/jvm/functions/Function0;)V
    check-cast v4, Lkotlin/jvm/functions/Function0;
    invoke-static v0, v3, v4, v1, Landroidx/fragment/app/FragmentViewModelLazyKt;->createViewModelLazy(Landroidx/fragment/app/Fragment; Lkotlin/reflect/KClass; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->settingsEntryViewModel$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private static final RenderCmpContent$lambda$14$lambda$11$lambda$10(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)kotlin.Unit
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v1, "about"
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackSettingsClick(Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->cmpSheet()Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    move-result-object v2
    if-eqz v2, +00bh
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->getNavigator()Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;
    move-result-object v2
    if-eqz v2, +005h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->openAbout()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final RenderCmpContent$lambda$14$lambda$13$lambda$12(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)kotlin.Unit
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v1, "device_management"
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackSettingsClick(Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->cmpSheet()Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    move-result-object v2
    if-eqz v2, +00bh
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->getNavigator()Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;
    move-result-object v2
    if-eqz v2, +005h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->openDeviceManagement()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final RenderCmpContent$lambda$14$lambda$9$lambda$8(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)kotlin.Unit
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;->Companion Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/EditProfileFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/EditProfileFragment;
    move-result-object v0
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->navigateTo(Landroidx/fragment/app/Fragment;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final RenderCmpContent$lambda$15(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    or-int/lit8 v1, v1, 1
    invoke-static v1, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->RenderCmpContent(Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final RenderCmpContent$lambda$2(androidx.compose.runtime.State)com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState
    .registers 1
    # ins_size=1
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    return-object v0
.end method

.method public static final synthetic access$applyLanguage(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->applyLanguage(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$applyThemeMode(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment  com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->applyThemeMode(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;)V
    return-void 
.end method

.method public static final synthetic access$cmpSheet(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)com.bytedance.trae.home.solo.setting.CmpAccountSettingsBottomSheet
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->cmpSheet()Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$dismissSheet(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->dismissSheet()V
    return-void 
.end method

.method public static final synthetic access$handleItemClick(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->handleItemClick(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;)V
    return-void 
.end method

.method public static final synthetic access$performLogout(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->performLogout()V
    return-void 
.end method

.method private final applyLanguage(java.lang.String)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v1, "language"
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackSettingsClick(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v0, Lcom/bytedance/trae/utils/LocaleManager;->getCurrentLanguage()Ljava/lang/String;
    move-result-object v0
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    invoke-virtual v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackLanguageSwitchClick(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v0, v3, Lcom/bytedance/trae/utils/LocaleManager;->setLanguage(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/IChangeLanguageApi;->Companion Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;
    invoke-virtual v0, v3, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion;->syncLanguage(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getParentFragment()Landroidx/fragment/app/Fragment;
    move-result-object v3
    instance-of v0, v3, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    if-eqz v0, +005h
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    goto +2h
    const/4 v3, 0
    if-eqz v3, +005h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->dismissAllowingStateLoss()V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v3
    if-eqz v3, +00eh
    invoke-virtual v3, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    if-eqz v3, +008h
    const-string v0, "from_language_switch"
    const/4 v1, 1
    invoke-virtual v3, v0, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v3
    if-eqz v3, +005h
    invoke-virtual v3, Landroidx/fragment/app/FragmentActivity;->recreate()V
    return-void 
.end method

.method private final applyThemeMode(com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string/jumbo v1, theme
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackSettingsClick(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackThemeSwitchClick(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/theme/ThemeManager;->INSTANCE Lcom/bytedance/trae/common/theme/ThemeManager;
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->ordinal()I
    move-result v3
    aget v3, v1, v3
    const/4 v1, 1
    if-eq v3, v1, +010h
    const/4 v1, 2
    if-eq v3, v1, +00dh
    const/4 v1, 3
    if-ne v3, v1, +004h
    const/4 v1, -1
    goto +7h
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/theme/ThemeManager;->applyDarkMode(I)V
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getSettingsEntryViewModel()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->refresh()V
    return-void 
.end method

.method private final cmpSheet()com.bytedance.trae.home.solo.setting.CmpAccountSettingsBottomSheet
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getParentFragment()Landroidx/fragment/app/Fragment;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method private final dismissSheet()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->cmpSheet()Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->dismissSafely()V
    return-void 
.end method

.method private final getLegacyViewModel()com.bytedance.trae.home.solo.setting.SettingsViewModel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->legacyViewModel$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    return-object v0
.end method

.method private final getSettingsEntryViewModel()com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->settingsEntryViewModel$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    return-object v0
.end method

.method private final handleItemClick(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v3
    aget v3, v0, v3
    const/4 v0, 0
    packed-switch v3, +0000097h
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackLogoutClick()V
    goto/16 +087h
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->Companion Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;
    move-result-object v3
    check-cast v3, Landroidx/fragment/app/Fragment;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->navigateTo(Landroidx/fragment/app/Fragment;)V
    goto/16 +07ah
    sget-object v3, Lcom/bytedance/trae/update/AppUpdateChecker;->INSTANCE Lcom/bytedance/trae/update/AppUpdateChecker;
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/AppUpdateChecker;->checkUpdate(Z)V
    goto/16 +073h
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->Companion Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;
    move-result-object v3
    check-cast v3, Landroidx/fragment/app/Fragment;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->navigateTo(Landroidx/fragment/app/Fragment;)V
    goto +66h
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v0, "connectors"
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackSettingsClick(Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->Companion Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    move-result-object v3
    check-cast v3, Landroidx/fragment/app/Fragment;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->navigateTo(Landroidx/fragment/app/Fragment;)V
    goto +53h
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v0, "notification"
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackSettingsClick(Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->showNotificationConfirmDialog()V
    goto +48h
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v0, "language"
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackSettingsClick(Ljava/lang/String;)V
    goto +40h
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string/jumbo v0, theme
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackSettingsClick(Ljava/lang/String;)V
    goto +37h
    sget-object v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->getUnreadCount()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    if-lez v1, +003h
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->trackEntryClick(Z)V
    sget-object v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->Companion Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    move-result-object v3
    check-cast v3, Landroidx/fragment/app/Fragment;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->navigateTo(Landroidx/fragment/app/Fragment;)V
    goto +13h
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v0, "account"
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackSettingsClick(Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->Companion Lcom/bytedance/trae/home/solo/setting/AccountFragment$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    move-result-object v3
    check-cast v3, Landroidx/fragment/app/Fragment;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->navigateTo(Landroidx/fragment/app/Fragment;)V
    return-void 
    nop 
    packed-switch-payload 1 2 3 4 5 6 7 8 9 a b c d e f
.end method

.method private static final legacyViewModel_delegate$lambda$0(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)com.bytedance.trae.home.solo.setting.SettingsViewModel
    .registers 3
    # ins_size=1
    new-instance v0, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v2
    const-string/jumbo v1, requireActivity(...)
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v0, v2, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-virtual v0, v2, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    return-object v2
.end method

.method private final navigateTo(androidx.fragment.app.Fragment)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->cmpSheet()Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->getNavigator()Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->openNative(Landroidx/fragment/app/Fragment;)V
    return-void 
.end method

.method private final performLogout()void
    .registers 5
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-nez v0, +003h
    return-void 
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$performLogout$1;
    invoke-direct v1, v4, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$performLogout$1;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)V
    check-cast v1, Lcom/bytedance/trae/login/api/IAccountCallback;
    const-string/jumbo v2, user_logout
    const/4 v3, 0
    invoke-interface v0, v3, v1, v2, Lcom/bytedance/trae/login/api/ILoginService;->logout(Z Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
.end method

.method private static final settingsEntryViewModel_delegate$lambda$1(com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment)androidx.lifecycle.ViewModelProvider$Factory
    .registers 4
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getLegacyViewModel()Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    move-result-object v3
    const/4 v1, 0
    const/4 v2, 2
    invoke-direct v0, v3, v1, v2, v1, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Lcom/bytedance/trae/kmp/host/KmpHostInfo; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Landroidx/lifecycle/ViewModelProvider$Factory;
    return-object v0
.end method

.method private final showNotificationConfirmDialog()void
    .registers 12
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostDialogs;
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_notification_dialog_title I
    invoke-virtual v11, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    const-string v2, "getString(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_notification_dialog_message I
    invoke-virtual v11, v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$string;->trae_setting_cancel I
    invoke-virtual v11, v4, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v5, Lcom/bytedance/trae/home/R$string;->trae_setting_notification_dialog_confirm I
    invoke-virtual v11, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda6;
    invoke-direct v7, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda6;-><init>()V
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda7;
    invoke-direct v8, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda7;-><init>()V
    const/16 v9, 16
    const/4 v10, 0
    move-object v2, v3
    move-object v3, v4
    move-object v4, v5
    move v5, v6
    move-object v6, v7
    move-object v7, v8
    move v8, v9
    move-object v9, v10
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/kmp/host/KmpHostDialogs;->showConfirmDialog$default(Lcom/bytedance/trae/kmp/host/KmpHostDialogs; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)V
    return-void 
.end method

.method private static final showNotificationConfirmDialog$lambda$16()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/push/api/IPushService;->Companion Lcom/bytedance/trae/push/api/IPushService$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/push/api/IPushService$Companion;->openSystemNotificationSetting()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final showNotificationConfirmDialog$lambda$17()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method protected RenderCmpContent(androidx.compose.runtime.Composer  int)void
    .registers 22
    # ins_size=3
    move-object/from16 v0, v19
    move/from16 v1, v21
    const v2, -390959967
    move-object/from16 v3, v20
    invoke-interface v3, v2, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v15
    and-int/lit8 v3, v1, 6
    const/4 v4, 2
    if-nez v3, +00dh
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 4
    goto +2h
    move v3, v4
    or-int/2addr v3, v1
    goto +2h
    move v3, v1
    and-int/lit8 v5, v3, 3
    if-ne v5, v4, +00fh
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v4
    if-nez v4, +003h
    goto +7h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object v2, v15
    goto/16 +1a1h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +008h
    const/4 v4, -1
    const-string v5, "com.bytedance.trae.home.solo.setting.fragment.CmpSettingsEntryFragment.RenderCmpContent (CmpSettingsEntryFragment.kt:63)"
    invoke-static v2, v3, v4, v5, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-direct/range v19, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getSettingsEntryViewModel()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->getState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v8, 0
    const/4 v9, 7
    move-object v7, v15
    invoke-static/range v3 ... v9, Landroidx/lifecycle/compose/FlowExtKt;->collectAsStateWithLifecycle(Lkotlinx/coroutines/flow/StateFlow; Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Lifecycle$State; Lkotlin/coroutines/CoroutineContext; Landroidx/compose/runtime/Composer; I I)Landroidx/compose/runtime/State;
    move-result-object v2
    const/4 v3, 1
    const/4 v4, 0
    invoke-static v4, v15, v4, v3, Landroidx/compose/foundation/ScrollKt;->rememberScrollState(I Landroidx/compose/runtime/Composer; I I)Landroidx/compose/foundation/ScrollState;
    move-result-object v5
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->RenderCmpContent$lambda$2(Landroidx/compose/runtime/State;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    move-result-object v3
    if-nez v3, +005h
    move-object v2, v15
    goto/16 +16bh
    sget-object v2, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v2, Landroidx/compose/ui/Modifier;
    const v4, 176946141
    invoke-interface v15, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v4
    invoke-interface v15, v5, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v6
    or-int/2addr v4, v6
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    if-nez v4, +00ah
    sget-object v4, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v4, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v4
    if-ne v6, v4, +00dh
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1;
    invoke-direct v4, v0, v5, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$1$1;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment; Landroidx/compose/foundation/ScrollState;)V
    move-object v6, v4
    check-cast v6, Landroidx/compose/ui/input/pointer/PointerInputEventHandler;
    invoke-interface v15, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v6, Landroidx/compose/ui/input/pointer/PointerInputEventHandler;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v2, v5, v6, Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilterKt;->pointerInput(Landroidx/compose/ui/Modifier; Ljava/lang/Object; Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)Landroidx/compose/ui/Modifier;
    move-result-object v4
    const v2, 176963977
    invoke-interface v15, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v2
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    if-nez v2, +00ah
    sget-object v2, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v2, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v2
    if-ne v6, v2, +00dh
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$2$1;
    invoke-direct v2, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$2$1;-><init>(Ljava/lang/Object;)V
    move-object v6, v2
    check-cast v6, Lkotlin/reflect/KFunction;
    invoke-interface v15, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v6, Lkotlin/reflect/KFunction;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v2, 176965736
    invoke-interface v15, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v2
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    if-nez v2, +00ah
    sget-object v2, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v2, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v2
    if-ne v7, v2, +00dh
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$3$1;
    invoke-direct v2, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$3$1;-><init>(Ljava/lang/Object;)V
    move-object v7, v2
    check-cast v7, Lkotlin/reflect/KFunction;
    invoke-interface v15, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v7, Lkotlin/reflect/KFunction;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v2, 176980616
    invoke-interface v15, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v2
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v8
    if-nez v2, +00ah
    sget-object v2, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v2, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v2
    if-ne v8, v2, +00dh
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$4$1;
    invoke-direct v2, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$4$1;-><init>(Ljava/lang/Object;)V
    move-object v8, v2
    check-cast v8, Lkotlin/reflect/KFunction;
    invoke-interface v15, v8, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v8, Lkotlin/reflect/KFunction;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v2, 176982122
    invoke-interface v15, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v2
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    if-nez v2, +00ah
    sget-object v2, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v2, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v2
    if-ne v9, v2, +00dh
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$5$1;
    invoke-direct v2, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$RenderCmpContent$1$5$1;-><init>(Ljava/lang/Object;)V
    move-object v9, v2
    check-cast v9, Lkotlin/reflect/KFunction;
    invoke-interface v15, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v9, Lkotlin/reflect/KFunction;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v2, 176961290
    invoke-interface v15, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v2
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v10
    if-nez v2, +00ah
    sget-object v2, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v2, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v2
    if-ne v10, v2, +00ah
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda0;
    invoke-direct v10, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)V
    invoke-interface v15, v10, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v2, v10
    check-cast v2, Lkotlin/jvm/functions/Function0;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v10, v6
    check-cast v10, Lkotlin/jvm/functions/Function1;
    move-object v11, v7
    check-cast v11, Lkotlin/jvm/functions/Function1;
    const v6, 176967382
    invoke-interface v15, v6, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v6
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    if-nez v6, +00ah
    sget-object v6, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v6, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v6
    if-ne v7, v6, +00ah
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda1;
    invoke-direct v7, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)V
    invoke-interface v15, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v12, v7
    check-cast v12, Lkotlin/jvm/functions/Function0;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v6, 176973805
    invoke-interface v15, v6, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v6
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    if-nez v6, +00ah
    sget-object v6, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v6, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v6
    if-ne v7, v6, +00ah
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda2;
    invoke-direct v7, v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;)V
    invoke-interface v15, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v13, v7
    check-cast v13, Lkotlin/jvm/functions/Function0;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v14, v8
    check-cast v14, Lkotlin/jvm/functions/Function0;
    move-object/from16 v16, v9
    check-cast v16, Lkotlin/jvm/functions/Function1;
    const/16 v17, 0
    const/16 v18, 0
    move-object v6, v2
    move-object v7, v10
    move-object v8, v11
    move-object v9, v12
    move-object v10, v13
    move-object v11, v14
    move-object/from16 v12, v16
    move-object v13, v15
    move/from16 v14, v17
    move-object v2, v15
    move/from16 v15, v18
    invoke-static/range v3 ... v15, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->SettingsEntryContent(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState; Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/ScrollState; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/Composer; I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v3
    if-eqz v3, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v2
    if-eqz v2, +00ah
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda3;
    invoke-direct v3, v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment; I)V
    invoke-interface v2, v3, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method protected getComposeViewId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->composeViewId I
    return v0
.end method

.method protected getLeftAction()com.bytedance.trae.common.widget.TraeTitleBar$Action
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->leftAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    return-object v0
.end method

.method protected getRightAction()com.bytedance.trae.common.widget.TraeTitleBar$Action
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->rightAction Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    return-object v0
.end method

.method protected getTitleResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->titleResId I
    return v0
.end method

.method protected onCloseAction()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->cmpSheet()Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->dismiss()V
    return-void 
.end method

.method protected onCmpViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v3, view
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const/4 v3, 0
    const/4 v0, 1
    invoke-static v2, v3, v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackSettingsPageView$default(Lcom/bytedance/trae/home/solo/setting/SettingsTracker; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public onDestroyView()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->cmpSheet()Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->onContentGestureEnded()V
    invoke-super v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;->onDestroyView()V
    return-void 
.end method

.method public onResume()void
    .registers 2
    # ins_size=1
    invoke-super v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpSheetContentFragment;->onResume()V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->getSettingsEntryViewModel()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->onResume()V
    return-void 
.end method
