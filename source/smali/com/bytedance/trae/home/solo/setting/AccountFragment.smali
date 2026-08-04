# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/AccountFragment;
.super Landroidx/fragment/app/Fragment;
.source "AccountFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/AccountFragment$Companion;
.field private static final DIALOG_DIM_AMOUNT:F
.field private static final DIALOG_WIDTH_RATIO:F
.field private static final DOUYIN_BIND_CONFLICT_ERROR:I
.field private static final ENTERPRISE_DATA_PROTECTION_URL:Ljava/lang/String;
.field private static final PHONE_BIND_ACTIVITY_CLASS:Ljava/lang/String;
.field private static final PHONE_BIND_EXTRA_MODE:Ljava/lang/String;
.field private static final PHONE_BIND_EXTRA_PHONE_MASKED:Ljava/lang/String;
.field private static final PHONE_BIND_EXTRA_SOURCE:Ljava/lang/String;
.field private static final PHONE_BIND_MODE_BIND:Ljava/lang/String;
.field private static final PHONE_BIND_MODE_CHANGE:Ljava/lang/String;
.field private static final PHONE_BIND_SOURCE_SETTINGS:Ljava/lang/String;
.field private btnDouyinAction:Landroid/widget/TextView;
.field private btnPhoneAction:Landroid/widget/TextView;
.field private cardDeleteAccount:Landroid/view/View;
.field private cardLoginMethods:Landroid/view/View;
.field private dividerPhone:Landroid/view/View;
.field private final douyinLoginService$delegate:Lkotlin/Lazy;
.field private hasResumedOnce:Z
.field private isSwitching:Z
.field private final loginService$delegate:Lkotlin/Lazy;
.field private final phoneBindLauncher:Landroidx/activity/result/ActivityResultLauncher;
.field private switchPrivacyMode:Landroidx/appcompat/widget/SwitchCompat;
.field private tvDouyinSubtitle:Landroid/widget/TextView;
.field private tvPhoneSubtitle:Landroid/widget/TextView;
.field private tvPrivacyDesc:Landroid/widget/TextView;
.field private tvPrivacyDetails:Landroid/widget/TextView;
.field private unbindDialog:Landroid/app/Dialog;
.field private viewModel:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;


.method public static synthetic $r8$lambda$-_S0OasosZL9KNedK03C81ALX8g(com.bytedance.trae.home.solo.setting.AccountFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->performDouyinUnbind$lambda$21(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$0DwjhMhrjeHNti-6HG3Ya-umqnQ(com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->setupPhoneBinding$lambda$11(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$1ix7yckM_8CyHYY6rMvSVW78xXM(com.bytedance.trae.home.solo.setting.AccountFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->performDouyinBind$lambda$25$lambda$24(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$6YT-dOV2RVRGZ8BIKscOThMzDgY(com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->setupDouyinBinding$lambda$12(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$7HUwom-i-E-q3O49P65hjyUlq18(com.bytedance.trae.home.solo.setting.AccountFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->performDouyinBind$lambda$25(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$FIeWQTg5Cj6XOpyDQxCWl9PUdZU(com.bytedance.trae.home.solo.setting.AccountFragment  java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->performDouyinBind$lambda$27$lambda$26(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Ljava/lang/String; I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$K-UIhXDzHIBxp0eQWYPE6ERbfg4(android.app.Dialog  com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->showUnbindDialog$lambda$17$lambda$16(Landroid/app/Dialog; Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Lqnt0-7w571d32-qEPUCcLQc4bU(android.app.Dialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->showUnbindDialog$lambda$19$lambda$18(Landroid/app/Dialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$M0e1y15wP-m_hG5ickXc69Edoas(com.bytedance.trae.home.solo.setting.AccountFragment  android.app.Dialog  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->showUnbindDialog$lambda$15(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroid/app/Dialog; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$MJDMmM3Hd8W7vsS0m96kql7CoGw()com.bytedance.trae.login.api.ILoginService
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/setting/AccountFragment;->loginService_delegate$lambda$0()Lcom/bytedance/trae/login/api/ILoginService;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$RrEGIg5JdEQ-1UvAmRIzHar-uqc(com.bytedance.trae.home.solo.setting.AccountFragment  int  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->performDouyinBind$lambda$27(Lcom/bytedance/trae/home/solo/setting/AccountFragment; I Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$V9ZHendI2Oj_LzylZtx3q8MJxHc(com.bytedance.trae.home.solo.setting.AccountFragment  com.bytedance.trae.home.solo.setting.UserProfileState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->onViewCreated$lambda$5(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Lcom/bytedance/trae/home/solo/setting/UserProfileState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$YGRn1QtCY5qRltm437c2hMUyIlQ(com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->onViewCreated$lambda$6(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$YVCeLPZ7Y5QPUs2Yp5Nlhcubm4E(com.bytedance.trae.home.solo.setting.AccountFragment  int  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->performDouyinUnbind$lambda$23(Lcom/bytedance/trae/home/solo/setting/AccountFragment; I Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$__Hi3PxJOtFZ0R8jvbYA89UCydk(com.bytedance.trae.home.solo.setting.AccountFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->performDouyinUnbind$lambda$21$lambda$20(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$a9IjUr78_49mVoxEccptbIWF5tU(com.bytedance.trae.home.solo.setting.AccountFragment  androidx.activity.result.ActivityResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->phoneBindLauncher$lambda$2(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroidx/activity/result/ActivityResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$c500OM1ZAXhTHf32JWV_c7QEAyk(com.bytedance.trae.home.solo.setting.AccountFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->performDouyinUnbind$lambda$23$lambda$22(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$elQM4NDtyDD-Ny253FIFNnAca50(com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->setupDeleteAccount$lambda$13(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$nPahzNInNIxkstUjARSlAR2Aibk(com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->onViewCreated$lambda$3(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$rDyQJLwQnpj5f4DoyJ9JMRRKiTY(com.bytedance.trae.home.solo.setting.AccountFragment  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->setupPrivacyModeSwitch$lambda$7(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xdyxWAX_bMhd94su6ZD26wK361k()com.bytedance.trae.login.api.IDouyinLoginService
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/setting/AccountFragment;->douyinLoginService_delegate$lambda$1()Lcom/bytedance/trae/login/api/IDouyinLoginService;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->Companion Lcom/bytedance/trae/home/solo/setting/AccountFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Landroidx/fragment/app/Fragment;-><init>()V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda9;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda9;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->loginService$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda10;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda10;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->douyinLoginService$delegate Lkotlin/Lazy;
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;
    invoke-direct v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V
    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda12;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract; Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;
    move-result-object v0
    const-string v1, "registerForActivityResult(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->phoneBindLauncher Landroidx/activity/result/ActivityResultLauncher;
    return-void 
.end method

.method public static final synthetic access$applyEditablePrivacyMode(com.bytedance.trae.home.solo.setting.AccountFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->applyEditablePrivacyMode()V
    return-void 
.end method

.method public static final synthetic access$applyEnterprisePrivacyMode(com.bytedance.trae.home.solo.setting.AccountFragment  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->applyEnterprisePrivacyMode(Z)V
    return-void 
.end method

.method public static final synthetic access$getLoginService(com.bytedance.trae.home.solo.setting.AccountFragment)com.bytedance.trae.login.api.ILoginService
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getLoginService()Lcom/bytedance/trae/login/api/ILoginService;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getSwitchPrivacyMode$p(com.bytedance.trae.home.solo.setting.AccountFragment)androidx.appcompat.widget.SwitchCompat
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    return-object v0
.end method

.method public static final synthetic access$isEnterpriseLogin(com.bytedance.trae.home.solo.setting.AccountFragment)boolean
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isEnterpriseLogin()Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$openPrivacyModeDetails(com.bytedance.trae.home.solo.setting.AccountFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->openPrivacyModeDetails()V
    return-void 
.end method

.method public static final synthetic access$setSwitching$p(com.bytedance.trae.home.solo.setting.AccountFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isSwitching Z
    return-void 
.end method

.method private final applyBindingButtonStyle(android.widget.TextView  boolean)void
    .registers 4
    # ins_size=3
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    if-eqz v3, +010h
    if-eqz v2, +007h
    sget v3, Lcom/bytedance/trae/home/R$drawable;->bg_btn_binding_primary I
    invoke-virtual v2, v3, Landroid/widget/TextView;->setBackgroundResource(I)V
    if-eqz v2, +019h
    const/4 v3, -1
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTextColor(I)V
    goto +13h
    if-eqz v2, +007h
    sget v3, Lcom/bytedance/trae/home/R$drawable;->bg_btn_binding_secondary I
    invoke-virtual v2, v3, Landroid/widget/TextView;->setBackgroundResource(I)V
    if-eqz v2, +00bh
    sget v3, Lcom/bytedance/trae/home/R$color;->trae_setting_text_primary I
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTextColor(I)V
    return-void 
.end method

.method static synthetic applyBindingButtonStyle$default(com.bytedance.trae.home.solo.setting.AccountFragment  android.widget.TextView  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->applyBindingButtonStyle(Landroid/widget/TextView; Z)V
    return-void 
.end method

.method private final applyEditablePrivacyMode()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->restoreEditablePrivacyModeInteraction()V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    const/4 v1, 0
    const-string/jumbo v2, switchPrivacyMode
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroidx/appcompat/widget/SwitchCompat;->jumpDrawablesToCurrentState()V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 0
    invoke-virtual v1, v0, Landroidx/appcompat/widget/SwitchCompat;->setVisibility(I)V
    return-void 
.end method

.method private final applyEnterprisePrivacyMode(boolean)void
    .registers 5
    # ins_size=2
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isSwitching Z
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    const/4 v1, 0
    const-string/jumbo v2, switchPrivacyMode
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v4, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    const/4 v0, 0
    invoke-virtual v4, v0, Landroidx/appcompat/widget/SwitchCompat;->setEnabled(Z)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    invoke-virtual v4, v0, Landroidx/appcompat/widget/SwitchCompat;->setClickable(Z)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    invoke-virtual v4, v0, Landroidx/appcompat/widget/SwitchCompat;->setFocusable(Z)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    invoke-virtual v4, Landroidx/appcompat/widget/SwitchCompat;->jumpDrawablesToCurrentState()V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v4
    invoke-virtual v1, v0, Landroidx/appcompat/widget/SwitchCompat;->setVisibility(I)V
    iput-boolean v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isSwitching Z
    return-void 
.end method

.method private final buildEnterprisePrivacyDesc()android.text.SpannableString
    .registers 6
    # ins_size=1
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_setting_enterprise_privacy_desc I
    invoke-virtual v5, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_setting_enterprise_privacy_details I
    invoke-virtual v5, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_setting_enterprise_privacy_link_separator I
    invoke-virtual v5, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v0
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v2
    add-int/2addr v0, v2
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/home/R$color;->trae_setting_text_link I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    new-instance v3, Landroid/text/SpannableString;
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-direct v3, v4, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$buildEnterprisePrivacyDesc$1$1;
    invoke-direct v4, v5, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$buildEnterprisePrivacyDesc$1$1;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment; I)V
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v1
    const/16 v2, 33
    invoke-virtual v3, v4, v0, v1, v2, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object; I I I)V
    return-object v3
.end method

.method private static final douyinLoginService_delegate$lambda$1()com.bytedance.trae.login.api.IDouyinLoginService
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/login/api/IDouyinLoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/IDouyinLoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/IDouyinLoginService;
    return-object v0
.end method

.method private final fetchPrivacyModeStatus()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final getDouyinLoginService()com.bytedance.trae.login.api.IDouyinLoginService
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->douyinLoginService$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/IDouyinLoginService;
    return-object v0
.end method

.method private final getHideLoginMethods()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-nez v0, +011h
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isEnterpriseLogin()Z
    move-result v0
    if-nez v0, +00bh
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isBytecloudLogin()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    return v0
.end method

.method private final getLoginService()com.bytedance.trae.login.api.ILoginService
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->loginService$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    return-object v0
.end method

.method private final getPrivacyModeDetailsUrl()java.lang.String
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isEnterpriseLogin()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "https://docs.trae.cn/enterprise_general-settings-for-trae-enterprise#d6637bb7"
    return-object v0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "docs.trae.ai"
    goto +3h
    const-string v0, "docs.trae.cn"
    sget-object v1, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v1, Lcom/bytedance/trae/utils/LocaleManager;->getAppLocale()Ljava/util/Locale;
    move-result-object v1
    invoke-virtual v1, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "https://"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, "/ide/privacy-mode?_lang="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final isBytecloudLogin()boolean
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getLoginService()Lcom/bytedance/trae/login/api/ILoginService;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getLoginPlatform()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    const-string v1, "bytecloud"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method private final isEnterpriseLogin()boolean
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getLoginService()Lcom/bytedance/trae/login/api/ILoginService;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/login/api/AccountType;->TOB Lcom/bytedance/trae/login/api/AccountType;
    if-ne v0, v1, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private static final loginService_delegate$lambda$0()com.bytedance.trae.login.api.ILoginService
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    return-object v0
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.home.solo.setting.AccountFragment  com.bytedance.trae.home.solo.setting.UserProfileState)kotlin.Unit
    .registers 3
    # ins_size=2
    if-eqz v2, +020h
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->updateLoginMethods(Lcom/bytedance/trae/home/solo/setting/UserProfileState;)V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->updateDeleteAccountEntry()V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->updatePrivacyModeCopy()V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isEnterpriseLogin()Z
    move-result v0
    if-eqz v0, +011h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getSaasPrivacyMode()Ljava/lang/Boolean;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    goto +2h
    const/4 v2, 1
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->applyEnterprisePrivacyMode(Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$6(com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->openPrivacyModeDetails()V
    return-void 
.end method

.method private final openPrivacyModeDetails()void
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.intent.action.VIEW"
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getPrivacyModeDetailsUrl()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->startActivity(Landroid/content/Intent;)V
    return-void 
    :try_start_0x0
.end method

.method private final performDouyinBind()void
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v2, "douyin"
    const-string v3, "bind"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackAccountBindingClick(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getDouyinLoginService()Lcom/bytedance/trae/login/api/IDouyinLoginService;
    move-result-object v1
    if-eqz v1, +011h
    check-cast v0, Landroid/app/Activity;
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda7;
    invoke-direct v2, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda8;
    invoke-direct v3, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-interface v1, v0, v2, v3, Lcom/bytedance/trae/login/api/IDouyinLoginService;->bindToAccount(Landroid/app/Activity; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final performDouyinBind$lambda$25(com.bytedance.trae.home.solo.setting.AccountFragment)kotlin.Unit
    .registers 9
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v1, "douyin"
    const-string v2, "bind"
    const-string/jumbo v3, success
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 24
    const/4 v7, 0
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackAccountBindingResult$default(Lcom/bytedance/trae/home/solo/setting/SettingsTracker; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda15;
    invoke-direct v1, v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda15;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method

.method private static final performDouyinBind$lambda$25$lambda$24(com.bytedance.trae.home.solo.setting.AccountFragment)void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isAdded()Z
    move-result v0
    if-eqz v0, +013h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_douyin_bind_success I
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->refreshDouyinStatus()V
    return-void 
.end method

.method private static final performDouyinBind$lambda$27(com.bytedance.trae.home.solo.setting.AccountFragment  int  java.lang.String)kotlin.Unit
    .registers 9
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v1, "douyin"
    const-string v2, "bind"
    const-string v3, "fail"
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    move-object v5, v8
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackAccountBindingResult(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda11;
    invoke-direct v1, v6, v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Ljava/lang/String; I)V
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private static final performDouyinBind$lambda$27$lambda$26(com.bytedance.trae.home.solo.setting.AccountFragment  java.lang.String  int)void
    .registers 5
    # ins_size=3
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isAdded()Z
    move-result v0
    if-eqz v0, +039h
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    const/4 v0, 1
    if-nez v0, +003h
    goto +18h
    const/16 v3, 1030
    if-ne v4, v3, +00ch
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_douyin_bind_conflict I
    invoke-virtual v2, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    goto +ah
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_douyin_operation_failed I
    invoke-virtual v2, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v2, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private final performDouyinUnbind()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getDouyinLoginService()Lcom/bytedance/trae/login/api/IDouyinLoginService;
    move-result-object v0
    if-eqz v0, +00fh
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda20;
    invoke-direct v1, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda20;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda1;
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/login/api/IDouyinLoginService;->unbind(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final performDouyinUnbind$lambda$21(com.bytedance.trae.home.solo.setting.AccountFragment)kotlin.Unit
    .registers 9
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v1, "douyin"
    const-string/jumbo v2, unbind
    const-string/jumbo v3, success
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 24
    const/4 v7, 0
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackAccountBindingResult$default(Lcom/bytedance/trae/home/solo/setting/SettingsTracker; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda13;
    invoke-direct v1, v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method

.method private static final performDouyinUnbind$lambda$21$lambda$20(com.bytedance.trae.home.solo.setting.AccountFragment)void
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isAdded()Z
    move-result v0
    if-eqz v0, +013h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_douyin_unbind_success I
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->refreshDouyinStatus()V
    return-void 
.end method

.method private static final performDouyinUnbind$lambda$23(com.bytedance.trae.home.solo.setting.AccountFragment  int  java.lang.String)kotlin.Unit
    .registers 9
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v1, "douyin"
    const-string/jumbo v2, unbind
    const-string v3, "fail"
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    move-object v5, v8
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackAccountBindingResult(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v7
    if-eqz v7, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda19;
    invoke-direct v0, v6, v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda19;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Ljava/lang/String;)V
    invoke-virtual v7, v0, Landroidx/fragment/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private static final performDouyinUnbind$lambda$23$lambda$22(com.bytedance.trae.home.solo.setting.AccountFragment  java.lang.String)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isAdded()Z
    move-result v0
    if-eqz v0, +02bh
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    const/4 v0, 1
    if-nez v0, +003h
    goto +ah
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_douyin_operation_failed I
    invoke-virtual v2, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v2, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final phoneBindLauncher$lambda$2(com.bytedance.trae.home.solo.setting.AccountFragment  androidx.activity.result.ActivityResult)void
    .registers 5
    # ins_size=2
    invoke-virtual v4, Landroidx/activity/result/ActivityResult;->getResultCode()I
    move-result v0
    const/4 v1, -1
    if-ne v0, v1, +03ch
    invoke-virtual v4, Landroidx/activity/result/ActivityResult;->getData()Landroid/content/Intent;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +009h
    const-string v1, "extra_new_phone"
    invoke-virtual v4, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v0
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    const-string/jumbo v2, viewModel
    if-nez v1, +00dh
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    invoke-virtual v1, v4, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->updatePhoneNumber(Ljava/lang/String;)V
    iget-object v3, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v3
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->loadUserInfo()V
    return-void 
.end method

.method private final refreshAccountControlsForCurrentAccount(boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->refreshLoginMethodsForCurrentAccount(Z)V
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->updateDeleteAccountEntry()V
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->refreshPrivacySectionForCurrentAccount()V
    return-void 
.end method

.method static synthetic refreshAccountControlsForCurrentAccount$default(com.bytedance.trae.home.solo.setting.AccountFragment  boolean  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    const/4 v3, 1
    and-int/2addr v2, v3
    if-eqz v2, +003h
    move v1, v3
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->refreshAccountControlsForCurrentAccount(Z)V
    return-void 
.end method

.method private final refreshDouyinStatus()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getHideLoginMethods()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getDouyinLoginService()Lcom/bytedance/trae/login/api/IDouyinLoginService;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lcom/bytedance/trae/login/api/IDouyinLoginService;->isBound()Z
    move-result v0
    if-ne v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +03ah
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getDouyinLoginService()Lcom/bytedance/trae/login/api/IDouyinLoginService;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/IDouyinLoginService;->getDouyinNickname()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvDouyinSubtitle Landroid/widget/TextView;
    if-eqz v1, +015h
    if-eqz v0, +003h
    goto +ch
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_douyin_bound I
    invoke-virtual v4, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v3, "getString(...)"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnDouyinAction Landroid/widget/TextView;
    if-eqz v0, +00dh
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_unbind I
    invoke-virtual v4, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnDouyinAction Landroid/widget/TextView;
    invoke-direct v4, v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->applyBindingButtonStyle(Landroid/widget/TextView; Z)V
    goto +24h
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvDouyinSubtitle Landroid/widget/TextView;
    if-eqz v0, +00dh
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_setting_not_bound I
    invoke-virtual v4, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnDouyinAction Landroid/widget/TextView;
    if-eqz v0, +00dh
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_setting_bind I
    invoke-virtual v4, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnDouyinAction Landroid/widget/TextView;
    invoke-direct v4, v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->applyBindingButtonStyle(Landroid/widget/TextView; Z)V
    return-void 
.end method

.method private final refreshLoginMethodsForCurrentAccount(boolean)void
    .registers 6
    # ins_size=2
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getHideLoginMethods()Z
    move-result v0
    if-eqz v0, +00ch
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->cardLoginMethods Landroid/view/View;
    if-eqz v5, +007h
    const/16 v0, 8
    invoke-virtual v5, v0, Landroid/view/View;->setVisibility(I)V
    return-void 
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->getUserProfile()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    if-nez v0, +019h
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->cardLoginMethods Landroid/view/View;
    if-eqz v0, +006h
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    if-eqz v5, +012h
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v5
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->loadUserInfo()V
    goto +4h
    invoke-direct v4, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->updateLoginMethods(Lcom/bytedance/trae/home/solo/setting/UserProfileState;)V
    return-void 
.end method

.method private final refreshPrivacySectionForCurrentAccount()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->updatePrivacyModeCopy()V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isEnterpriseLogin()Z
    move-result v0
    if-eqz v0, +01eh
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getLoginService()Lcom/bytedance/trae/login/api/ILoginService;
    move-result-object v0
    if-eqz v0, +013h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getSaasPrivacyMode()Ljava/lang/Boolean;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    goto +2h
    const/4 v0, 1
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->applyEnterprisePrivacyMode(Z)V
    goto +7h
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->restoreEditablePrivacyModeInteraction()V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->fetchPrivacyModeStatus()V
    return-void 
.end method

.method private final restoreEditablePrivacyModeInteraction()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    const/4 v1, 0
    const-string/jumbo v2, switchPrivacyMode
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 1
    invoke-virtual v0, v3, Landroidx/appcompat/widget/SwitchCompat;->setEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v3, Landroidx/appcompat/widget/SwitchCompat;->setClickable(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, v3, Landroidx/appcompat/widget/SwitchCompat;->setFocusable(Z)V
    return-void 
.end method

.method private final setupDeleteAccount()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +012h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_delete_account I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda2;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupDeleteAccount$lambda$13(com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 5
    # ins_size=2
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isEnterpriseLogin()Z
    move-result v4
    if-eqz v4, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    invoke-virtual v3, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$anim;->trae_slide_in_right I
    sget v0, Lcom/bytedance/trae/home/R$anim;->trae_slide_out_left I
    sget v1, Lcom/bytedance/trae/home/R$anim;->trae_slide_in_left I
    sget v2, Lcom/bytedance/trae/home/R$anim;->trae_slide_out_right I
    invoke-virtual v3, v4, v0, v1, v2, Landroidx/fragment/app/FragmentTransaction;->setCustomAnimations(I I I I)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$id;->settings_fragment_container I
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->Companion Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    move-result-object v0
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-virtual v3, v4, v0, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v3
    const/4 v4, 0
    invoke-virtual v3, v4, Landroidx/fragment/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v3
    invoke-virtual v3, Landroidx/fragment/app/FragmentTransaction;->commit()I
    return-void 
.end method

.method private final setupDouyinBinding()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnDouyinAction Landroid/widget/TextView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupDouyinBinding$lambda$12(com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getHideLoginMethods()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getDouyinLoginService()Lcom/bytedance/trae/login/api/IDouyinLoginService;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    invoke-interface v1, Lcom/bytedance/trae/login/api/IDouyinLoginService;->isBound()Z
    move-result v1
    if-eqz v1, +006h
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->showUnbindDialog()V
    goto +4h
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->performDouyinBind()V
    return-void 
.end method

.method private final setupPhoneBinding()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnPhoneAction Landroid/widget/TextView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda3;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupPhoneBinding$lambda$11(com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 16
    # ins_size=2
    invoke-direct v14, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getHideLoginMethods()Z
    move-result v15
    if-eqz v15, +003h
    return-void 
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v15
    if-nez v15, +003h
    return-void 
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->getUserProfile()Landroidx/lifecycle/LiveData;
    move-result-object v0
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v0, +01ah
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getPhoneNumber()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +014h
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    move v4, v2
    goto +2h
    move v4, v3
    if-eqz v4, +003h
    goto +2h
    move-object v0, v1
    if-nez v0, +018h
    invoke-direct v14, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getLoginService()Lcom/bytedance/trae/login/api/ILoginService;
    move-result-object v0
    if-eqz v0, +00ch
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getPhoneNumber()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +005h
    const-string v0, ""
    goto +2h
    move-object v0, v1
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +003h
    goto +2h
    move v2, v3
    const-string v1, "change"
    const-string v4, "bind"
    if-eqz v2, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v4
    if-eqz v2, +004h
    move-object v8, v1
    goto +2h
    move-object v8, v4
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v4, "phone"
    invoke-virtual v1, v4, v8, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackAccountBindingClick(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Landroid/content/Intent;
    invoke-direct v1, Landroid/content/Intent;-><init>()V
    check-cast v15, Landroid/content/Context;
    const-string v4, "com.bytedance.trae.login.activity.PhoneBindActivity"
    invoke-virtual v1, v15, v4, Landroid/content/Intent;->setClassName(Landroid/content/Context; Ljava/lang/String;)Landroid/content/Intent;
    const-string v15, "extra_mode"
    invoke-virtual v1, v15, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v15, "extra_source"
    const-string/jumbo v4, settings
    invoke-virtual v1, v15, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    if-eqz v2, +007h
    const-string v15, "extra_phone_masked"
    invoke-virtual v1, v15, v0, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    iget-object v15, v14, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->phoneBindLauncher Landroidx/activity/result/ActivityResultLauncher;
    invoke-virtual v15, v1, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    goto +1dh
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v7, "phone"
    const-string v9, "fail"
    const/4 v10, 0
    const-string v11, "activity_launch_failed"
    const/16 v12, 8
    const/4 v13, 0
    invoke-static/range v6 ... v13, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackAccountBindingResult$default(Lcom/bytedance/trae/home/solo/setting/SettingsTracker; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->requireContext()Landroid/content/Context;
    move-result-object v14
    sget v15, Lcom/bytedance/trae/home/R$string;->trae_setting_douyin_operation_failed I
    invoke-static v14, v15, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v14
    invoke-virtual v14, Landroid/widget/Toast;->show()V
    return-void 
    :try_start_0x76
.end method

.method private final setupPrivacyModeSwitch()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    if-nez v0, +009h
    const-string/jumbo v0, switchPrivacyMode
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda14;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-virtual v0, v1, Landroidx/appcompat/widget/SwitchCompat;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    return-void 
.end method

.method private static final setupPrivacyModeSwitch$lambda$7(com.bytedance.trae.home.solo.setting.AccountFragment  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    iget-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isSwitching Z
    if-nez v1, +00ch
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isEnterpriseLogin()Z
    move-result v1
    if-eqz v1, +003h
    goto +4h
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->togglePrivacyMode(Z)V
    return-void 
.end method

.method private final showUnbindDialog()void
    .registers 13
    # ins_size=1
    invoke-direct v12, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getLoginService()Lcom/bytedance/trae/login/api/ILoginService;
    move-result-object v0
    if-eqz v0, +0f8h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +0f0h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getPhoneNumber()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +02ch
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v2, "douyin"
    const-string/jumbo v3, unbind
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackAccountBindingClick(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v5, "douyin"
    const-string/jumbo v6, unbind
    const-string v7, "fail"
    const/4 v8, 0
    const-string v9, "last_login_method"
    const/16 v10, 8
    const/4 v11, 0
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackAccountBindingResult$default(Lcom/bytedance/trae/home/solo/setting/SettingsTracker; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_setting_douyin_last_method I
    invoke-static v0, v2, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    new-instance v3, Landroid/app/Dialog;
    invoke-direct v3, v0, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->trae_dialog_unbind_confirm I
    invoke-virtual v3, v4, Landroid/app/Dialog;->setContentView(I)V
    invoke-virtual v3, Landroid/app/Dialog;->getWindow()Landroid/view/Window;
    move-result-object v4
    if-eqz v4, +02ah
    new-instance v5, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v5, v1, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v5, Landroid/graphics/drawable/Drawable;
    invoke-virtual v4, v5, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels I
    int-to-float v0, v0
    const v1, 1061997773
    mul-float/2addr v0, v1
    float-to-int v0, v0
    const/4 v1, -2
    invoke-virtual v4, v0, v1, Landroid/view/Window;->setLayout(I I)V
    const/16 v0, 17
    invoke-virtual v4, v0, Landroid/view/Window;->setGravity(I)V
    const/high16 v0, 1056964608
    invoke-virtual v4, v0, Landroid/view/Window;->setDimAmount(F)V
    invoke-virtual v3, v2, Landroid/app/Dialog;->setCancelable(Z)V
    invoke-virtual v3, v2, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda16;
    invoke-direct v0, v12, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda16;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroid/app/Dialog;)V
    invoke-virtual v3, v0, Landroid/app/Dialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    iput-object v3, v12, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->unbindDialog Landroid/app/Dialog;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_dialog_title I
    invoke-virtual v3, v0, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_douyin_unbind_title I
    invoke-virtual v12, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_message I
    invoke-virtual v3, v0, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_douyin_unbind_message I
    invoke-virtual v12, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_confirm I
    invoke-virtual v3, v0, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_douyin_unbind_confirm I
    invoke-virtual v12, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda17;
    invoke-direct v1, v3, v12, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda17;-><init>(Landroid/app/Dialog; Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_cancel I
    invoke-virtual v3, v0, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_cancel I
    invoke-virtual v12, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda18;
    invoke-direct v1, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda18;-><init>(Landroid/app/Dialog;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v3, Landroid/app/Dialog;->show()V
    return-void 
.end method

.method private static final showUnbindDialog$lambda$15(com.bytedance.trae.home.solo.setting.AccountFragment  android.app.Dialog  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->unbindDialog Landroid/app/Dialog;
    if-ne v2, v1, +005h
    const/4 v1, 0
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->unbindDialog Landroid/app/Dialog;
    return-void 
.end method

.method private static final showUnbindDialog$lambda$17$lambda$16(android.app.Dialog  com.bytedance.trae.home.solo.setting.AccountFragment  android.view.View)void
    .registers 4
    # ins_size=3
    invoke-virtual v1, Landroid/app/Dialog;->dismiss()V
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->INSTANCE Lcom/bytedance/trae/home/solo/setting/SettingsTracker;
    const-string v3, "douyin"
    const-string/jumbo v0, unbind
    invoke-virtual v1, v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsTracker;->trackAccountBindingClick(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->performDouyinUnbind()V
    return-void 
.end method

.method private static final showUnbindDialog$lambda$19$lambda$18(android.app.Dialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Landroid/app/Dialog;->dismiss()V
    return-void 
.end method

.method private final togglePrivacyMode(boolean)void
    .registers 10
    # ins_size=2
    iget-boolean v0, v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isSwitching Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isSwitching Z
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, switchPrivacyMode
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Landroidx/appcompat/widget/SwitchCompat;->setEnabled(Z)V
    move-object v0, v8
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;
    invoke-direct v0, v9, v8, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;-><init>(Z Lcom/bytedance/trae/home/solo/setting/AccountFragment; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final updateDeleteAccountEntry()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->cardDeleteAccount Landroid/view/View;
    if-eqz v0, +00fh
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isEnterpriseLogin()Z
    move-result v1
    if-eqz v1, +005h
    const/16 v1, 8
    goto +2h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method private final updateLoginMethods(com.bytedance.trae.home.solo.setting.UserProfileState)void
    .registers 5
    # ins_size=2
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getHideLoginMethods()Z
    move-result v0
    if-eqz v0, +00ch
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->cardLoginMethods Landroid/view/View;
    if-eqz v4, +007h
    const/16 v0, 8
    invoke-virtual v4, v0, Landroid/view/View;->setVisibility(I)V
    return-void 
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->cardLoginMethods Landroid/view/View;
    const/4 v1, 0
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->dividerPhone Landroid/view/View;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getPhoneNumber()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v2, 1
    if-lez v0, +004h
    move v0, v2
    goto +2h
    move v0, v1
    if-eqz v0, +026h
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPhoneSubtitle Landroid/widget/TextView;
    if-eqz v0, +00bh
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getPhoneNumber()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnPhoneAction Landroid/widget/TextView;
    if-eqz v4, +00dh
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_change_bind I
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v4, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnPhoneAction Landroid/widget/TextView;
    const/4 v0, 2
    const/4 v2, 0
    invoke-static v3, v4, v1, v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->applyBindingButtonStyle$default(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Landroid/widget/TextView; Z I Ljava/lang/Object;)V
    goto +24h
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPhoneSubtitle Landroid/widget/TextView;
    if-eqz v4, +00dh
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_not_bound I
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v4, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnPhoneAction Landroid/widget/TextView;
    if-eqz v4, +00dh
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_bind I
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v4, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnPhoneAction Landroid/widget/TextView;
    invoke-direct v3, v4, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->applyBindingButtonStyle(Landroid/widget/TextView; Z)V
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->refreshDouyinStatus()V
    return-void 
.end method

.method private final updatePrivacyModeCopy()void
    .registers 7
    # ins_size=1
    invoke-direct v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isEnterpriseLogin()Z
    move-result v0
    const/4 v1, 0
    const-string/jumbo v2, tvPrivacyDetails
    const-string/jumbo v3, tvPrivacyDesc
    const/4 v4, 0
    if-eqz v0, +03ch
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDesc Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-direct v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->buildEnterprisePrivacyDesc()Landroid/text/SpannableString;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v0, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDesc Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-static Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;
    move-result-object v5
    invoke-virtual v0, v5, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDesc Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, v1, Landroid/widget/TextView;->setHighlightColor(I)V
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDetails Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v0
    const/16 v0, 8
    invoke-virtual v4, v0, Landroid/widget/TextView;->setVisibility(I)V
    goto +32h
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDesc Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    sget v5, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_desc I
    invoke-virtual v0, v5, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDesc Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, v4, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDetails Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_details I
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDetails Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v0
    invoke-virtual v4, v1, Landroid/widget/TextView;->setVisibility(I)V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_account I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->unbindDialog Landroid/app/Dialog;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/app/Dialog;->dismiss()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->unbindDialog Landroid/app/Dialog;
    invoke-super v1, Landroidx/fragment/app/Fragment;->onDestroyView()V
    return-void 
.end method

.method public onResume()void
    .registers 4
    # ins_size=1
    invoke-super v3, Landroidx/fragment/app/Fragment;->onResume()V
    iget-boolean v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->hasResumedOnce Z
    const/4 v1, 1
    if-nez v0, +005h
    iput-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->hasResumedOnce Z
    return-void 
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    if-eqz v0, +00fh
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDesc Landroid/widget/TextView;
    if-eqz v0, +00bh
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDetails Landroid/widget/TextView;
    if-eqz v0, +007h
    const/4 v0, 0
    const/4 v2, 0
    invoke-static v3, v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->refreshAccountControlsForCurrentAccount$default(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Z I Ljava/lang/Object;)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 7
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v4, v5, v6, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v6, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string/jumbo v1, requireActivity(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v6, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-virtual v6, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    sget v6, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda4;
    invoke-direct v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-virtual v6, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v6, Lcom/bytedance/trae/home/R$id;->card_login_methods I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->cardLoginMethods Landroid/view/View;
    sget v6, Lcom/bytedance/trae/home/R$id;->tv_phone_subtitle I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroid/widget/TextView;
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPhoneSubtitle Landroid/widget/TextView;
    sget v6, Lcom/bytedance/trae/home/R$id;->btn_phone_action I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroid/widget/TextView;
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnPhoneAction Landroid/widget/TextView;
    sget v6, Lcom/bytedance/trae/home/R$id;->divider_phone I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->dividerPhone Landroid/view/View;
    sget v6, Lcom/bytedance/trae/home/R$id;->tv_douyin_subtitle I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroid/widget/TextView;
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvDouyinSubtitle Landroid/widget/TextView;
    sget v6, Lcom/bytedance/trae/home/R$id;->btn_douyin_action I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroid/widget/TextView;
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->btnDouyinAction Landroid/widget/TextView;
    sget v6, Lcom/bytedance/trae/home/R$id;->card_delete_account I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->cardDeleteAccount Landroid/view/View;
    sget v6, Lcom/bytedance/trae/home/R$id;->switch_privacy_mode I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    const-string v0, "findViewById(...)"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroidx/appcompat/widget/SwitchCompat;
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->switchPrivacyMode Landroidx/appcompat/widget/SwitchCompat;
    const/4 v1, 0
    if-nez v6, +009h
    const-string/jumbo v6, switchPrivacyMode
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v1
    const/4 v2, 4
    invoke-virtual v6, v2, Landroidx/appcompat/widget/SwitchCompat;->setVisibility(I)V
    sget v6, Lcom/bytedance/trae/home/R$id;->tv_privacy_desc I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/TextView;
    iput-object v6, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDesc Landroid/widget/TextView;
    sget v6, Lcom/bytedance/trae/home/R$id;->tv_privacy_details I
    invoke-virtual v5, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/widget/TextView;
    iput-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDetails Landroid/widget/TextView;
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->updatePrivacyModeCopy()V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    const-string/jumbo v6, viewModel
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v1
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->getUserProfile()Landroidx/lifecycle/LiveData;
    move-result-object v5
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda5;
    invoke-direct v2, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment$sam$androidx_lifecycle_Observer$0;
    invoke-direct v3, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v3, Landroidx/lifecycle/Observer;
    invoke-virtual v5, v0, v3, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->setupPrivacyModeSwitch()V
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->setupPhoneBinding()V
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->setupDouyinBinding()V
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->setupDeleteAccount()V
    const/4 v5, 0
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->refreshAccountControlsForCurrentAccount(Z)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->viewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v1
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->loadUserInfo()V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->tvPrivacyDetails Landroid/widget/TextView;
    if-nez v5, +009h
    const-string/jumbo v5, tvPrivacyDetails
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v5
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda6;
    invoke-direct v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    invoke-virtual v1, v5, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
