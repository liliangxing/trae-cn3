# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;
.super Landroidx/fragment/app/Fragment;
.source "DebugSettingsFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$Companion;
.field private static final TAG:Ljava/lang/String;
.field private etCustomHeaderKey:Landroid/widget/EditText;
.field private etCustomHeaderValue:Landroid/widget/EditText;
.field private etEnvLane:Landroid/widget/EditText;
.field private etPpeEnv:Landroid/widget/EditText;
.field private llCustomHeaders:Landroid/widget/LinearLayout;
.field private llHistory:Landroid/widget/LinearLayout;
.field private tvHistoryLabel:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$-OmdEUl9jfeH9ew4IJjdqMrwf1c(java.lang.String  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->refreshCustomHeaders$lambda$47$lambda$46(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$6A7ueYITwchQpeKH7KERAhc71IE(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$12(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$6b1TQKuf_XfCCNEffZZefbpNEpI(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$13(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$7V_HZ_Ag5ivS_z1NALpJHTz3UyA(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$7(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$8vDmMdX_hJ6siE4KD_FYy37EjPk(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.widget.TextView  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$2(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/widget/TextView; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$E8VywhDO29PQYfzS-uu6fbkzxpk(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$1(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$FaUpfiZ68UOAalZIQ7pd0fpMuS4(android.content.Context  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupForceTokenRefreshToggle$lambda$22$lambda$21(Landroid/content/Context; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$GqCeEUNCctakXyA_mUHcNknULfA(android.content.Context  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupDebugFloatingButtonToggle$lambda$32$lambda$31(Landroid/content/Context; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$HmhhSUx37RTx6O1zR4bmNQz_xMk(com.bytedance.trae.settings.api.feature.IFeatureCapabilityService  android.content.Context  android.widget.TextView  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupFeatureCapabilitySection$lambda$85$lambda$84(Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService; Landroid/content/Context; Landroid/widget/TextView; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$HpFq5RvGFLXRsPkIFtnyFeREUbY(android.widget.TextView  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  boolean)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$16$lambda$15(Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$JByWbAzGDRqzJ0nnCCstggKrvK0(android.content.Context  android.widget.TextView  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupFeatureCapabilitySection$lambda$83$lambda$82(Landroid/content/Context; Landroid/widget/TextView; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$KFKCP8T9CcGmyq4xuMnNippq_2M(android.widget.RadioButton  com.bytedance.trae.settings.api.feature.IFeatureCapabilityService  com.bytedance.trae.settings.api.feature.Feature  android.widget.RadioButton  android.widget.RadioButton  android.widget.TextView  android.widget.RadioGroup  int)void
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupFeatureCapabilitySection$lambda$70(Landroid/widget/RadioButton; Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService; Lcom/bytedance/trae/settings/api/feature/Feature; Landroid/widget/RadioButton; Landroid/widget/RadioButton; Landroid/widget/TextView; Landroid/widget/RadioGroup; I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$MkWGTtuD5SFRl6zMmxcUkZ9ZpSQ(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$11(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$MwsFGByzYl5i-5qOB6hp5ktsuKU(android.widget.TextView  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$16$lambda$15$lambda$14(Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$PQlfxozeH-_Y4wVAt28zwzZ2Cv4(com.bytedance.trae.settings.api.feature.Feature  android.content.Context  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupFeatureCapabilitySection$lambda$73$lambda$72(Lcom/bytedance/trae/settings/api/feature/Feature; Landroid/content/Context; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$V3wfEvAsFp1_HBg29ex12pKnz2w(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.widget.TextView  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$5(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/widget/TextView; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Wy5Hh69CtkXnFGvoWV2-BMLm6lg(android.widget.TextView  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$16(Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Xbi_95C_jZqHewr1ue-Dyh9dnrY(android.widget.TextView  android.content.Context  android.widget.CompoundButton  boolean)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupEnterpriseEnvToggle$lambda$27$lambda$26(Landroid/widget/TextView; Landroid/content/Context; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$a-J0LiCgzgUiAFeeJpIz8GJGUA0(com.bytedance.trae.settings.api.feature.Feature)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupFeatureCapabilitySection$lambda$80$lambda$79$lambda$77(Lcom/bytedance/trae/settings/api/feature/Feature;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$c4Kuo2HVhPRDBExOkB0BW0IpYTo(android.content.Context  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupNotificationBoeToggle$lambda$52$lambda$51(Landroid/content/Context; Landroid/widget/CompoundButton; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$dY9odk5u5TwsW8-7VFEsXFtb66w(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.widget.TextView  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$4(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/widget/TextView; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$m5ELSyIF3iu6Utggv5VNoLbw7Ac(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.widget.TextView  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$3(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/widget/TextView; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$px0mqRSJoI7iEh_dHaI-nlYjIRs(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  java.lang.String  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->refreshHistory$lambda$40$lambda$38(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$qHBWzfleRv0MwMxGHEC468jL-1s(java.lang.String  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->refreshHistory$lambda$40$lambda$39(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$uCpToeFGqOfNGACsKpuvEQDDhm8(android.content.Context  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupFeatureCapabilitySection$lambda$80$lambda$79(Landroid/content/Context; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$vfTNNG4zOPIB-kKbTb8iMeGVVls(com.bytedance.trae.home.solo.setting.DebugSettingsFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$1$lambda$0(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$wNFbYhePLSnd1lsaAowjDYjm2PA(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$6(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xxj-5thDD43btt8jACdQJcZSffM(android.widget.CompoundButton  boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->onViewCreated$lambda$17(Landroid/widget/CompoundButton; Z)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->Companion Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/Fragment;-><init>()V
    return-void 
.end method

.method private static final onViewCreated$lambda$1(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 5
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    const-wide/16 v1, 150
    invoke-virtual v4, v0, v1, v2, Landroid/view/View;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final onViewCreated$lambda$1$lambda$0(com.bytedance.trae.home.solo.setting.DebugSettingsFragment)void
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final onViewCreated$lambda$11(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 6
    # ins_size=5
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v0, "device_id: "
    invoke-direct v5, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v5, "
user_id: "
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "
passport_uid: "
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string v3, "clipboard"
    invoke-virtual v2, v3, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v2
    const-string v3, "null cannot be cast to non-null type android.content.ClipboardManager"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/content/ClipboardManager;
    const-string v3, "device_info"
    check-cast v3, Ljava/lang/CharSequence;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v3, v1, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Landroid/content/ClipData;
    move-result-object v1
    invoke-virtual v2, v1, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_device_info_copied I
    const/4 v3, 0
    invoke-static v1, v2, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final onViewCreated$lambda$12(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 5
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
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
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;->Companion Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesFragment;
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

.method private static final onViewCreated$lambda$13(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 3
    # ins_size=2
    sget-object v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptCoordinator;->clearCacheForDebug()V
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_billing_prompt_cache_cleared I
    const/4 v0, 0
    invoke-static v1, v2, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final onViewCreated$lambda$16(android.widget.TextView  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 14
    # ins_size=3
    sget v13, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_alog_uploading I
    invoke-virtual v12, v13, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getString(I)Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-virtual v11, v13, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/4 v13, 0
    invoke-virtual v11, v13, Landroid/widget/TextView;->setEnabled(Z)V
    const/high16 v13, 1056964608
    invoke-virtual v11, v13, Landroid/widget/TextView;->setAlpha(F)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    const-wide/16 v2, 1000
    div-long v8, v0, v2
    const/16 v13, 3600
    int-to-long v0, v13
    sub-long v6, v8, v0
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v5, "feedback"
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda11;
    invoke-direct v10, v11, v12, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda11;-><init>(Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    invoke-virtual/range v4 ... v10, Lcom/bytedance/trae/utils/logger/FLogger;->uploadALog(Ljava/lang/String; J J Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$16$lambda$15(android.widget.TextView  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  boolean)kotlin.Unit
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda21;
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda21;-><init>(Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Z)V
    invoke-virtual v1, v0, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$16$lambda$15$lambda$14(android.widget.TextView  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  boolean)void
    .registers 4
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_alog_upload I
    invoke-virtual v2, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/4 v0, 1
    invoke-virtual v1, v0, Landroid/widget/TextView;->setEnabled(Z)V
    const/high16 v0, 1065353216
    invoke-virtual v1, v0, Landroid/widget/TextView;->setAlpha(F)V
    if-eqz v3, +005h
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_alog_success I
    goto +3h
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_alog_failed I
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    const/4 v3, 0
    invoke-static v2, v1, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final onViewCreated$lambda$17(android.widget.CompoundButton  boolean)void
    .registers 2
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/DebugSettings;->setDeviceManagerMockDid(Z)V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.widget.TextView  android.view.View)void
    .registers 7
    # ins_size=3
    iget-object v6, v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etPpeEnv Landroid/widget/EditText;
    if-eqz v6, +007h
    invoke-virtual v6, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v6
    goto +2h
    const/4 v6, 0
    invoke-static v6, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +024h
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v0, v6, Lcom/bytedance/trae/network/DebugSettings;->setPpeEnv(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    const-string v3, ""
    invoke-virtual v0, v2, v3, v1, v6, Lcom/bytedance/trae/network/TraeTTNet;->updateHttpEnv(Z Ljava/lang/String; Z Ljava/lang/String;)V
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->updateCurrentDisplay(Landroid/widget/TextView; Ljava/lang/String;)V
    invoke-direct v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->refreshHistory()V
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_ppe_env_saved I
    invoke-static v4, v5, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.widget.TextView  android.view.View)void
    .registers 5
    # ins_size=3
    sget-object v4, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    const-string v0, ""
    invoke-virtual v4, v0, Lcom/bytedance/trae/network/DebugSettings;->setPpeEnv(Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    const/4 v1, 0
    invoke-virtual v4, v1, v0, v1, v0, Lcom/bytedance/trae/network/TraeTTNet;->updateHttpEnv(Z Ljava/lang/String; Z Ljava/lang/String;)V
    iget-object v4, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etPpeEnv Landroid/widget/EditText;
    if-eqz v4, +00bh
    invoke-virtual v4, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v4
    if-eqz v4, +005h
    invoke-interface v4, Landroid/text/Editable;->clear()V
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->updateCurrentDisplay(Landroid/widget/TextView; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_ppe_env_cleared I
    invoke-static v2, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.widget.TextView  android.view.View)void
    .registers 5
    # ins_size=3
    iget-object v4, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etEnvLane Landroid/widget/EditText;
    if-eqz v4, +007h
    invoke-virtual v4, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    invoke-static v4, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    move v0, v1
    if-eqz v0, +01ah
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v0, v4, Lcom/bytedance/trae/network/DebugSettings;->setEnvLane(Ljava/lang/String;)V
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->updateEnvLaneDisplay(Landroid/widget/TextView; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_env_lane_saved I
    invoke-static v2, v3, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.widget.TextView  android.view.View)void
    .registers 5
    # ins_size=3
    sget-object v4, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    const-string v0, ""
    invoke-virtual v4, v0, Lcom/bytedance/trae/network/DebugSettings;->setEnvLane(Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v4, Lcom/bytedance/trae/network/DebugSettings;->getEnvLane()Ljava/lang/String;
    move-result-object v4
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etEnvLane Landroid/widget/EditText;
    if-eqz v0, +008h
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->updateEnvLaneDisplay(Landroid/widget/TextView; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_env_lane_reset I
    const/4 v4, 0
    invoke-static v2, v3, v4, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final onViewCreated$lambda$6(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 5
    # ins_size=2
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etCustomHeaderKey Landroid/widget/EditText;
    const/4 v0, 0
    if-eqz v4, +007h
    invoke-virtual v4, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v4
    goto +2h
    move-object v4, v0
    invoke-static v4, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etCustomHeaderValue Landroid/widget/EditText;
    if-eqz v1, +006h
    invoke-virtual v1, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-static v0, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 0
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    move v1, v2
    if-eqz v1, +010h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_custom_header_empty I
    invoke-static v3, v4, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    return-void 
    sget-object v1, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v1, v4, v0, Lcom/bytedance/trae/network/DebugSettings;->addCustomHeader(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etCustomHeaderKey Landroid/widget/EditText;
    if-eqz v4, +00bh
    invoke-virtual v4, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v4
    if-eqz v4, +005h
    invoke-interface v4, Landroid/text/Editable;->clear()V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etCustomHeaderValue Landroid/widget/EditText;
    if-eqz v4, +00bh
    invoke-virtual v4, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v4
    if-eqz v4, +005h
    invoke-interface v4, Landroid/text/Editable;->clear()V
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->refreshCustomHeaders()V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_custom_header_added I
    invoke-static v3, v4, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final onViewCreated$lambda$7(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 3
    # ins_size=2
    sget-object v2, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    invoke-virtual v2, v0, Lcom/bytedance/trae/network/DebugSettings;->setCustomHeaders(Ljava/util/Map;)V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->refreshCustomHeaders()V
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_custom_header_cleared I
    const/4 v0, 0
    invoke-static v1, v2, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private final refreshCustomHeaders()void
    .registers 15
    # ins_size=1
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->llCustomHeaders Landroid/widget/LinearLayout;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/widget/LinearLayout;->removeAllViews()V
    sget-object v1, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v1, Lcom/bytedance/trae/network/DebugSettings;->getCustomHeaders()Ljava/util/Map;
    move-result-object v1
    invoke-interface v1, Ljava/util/Map;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    const/16 v3, 8
    int-to-float v3, v3
    invoke-virtual v2, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v3, v4
    float-to-int v3, v3
    const/4 v4, 4
    int-to-float v4, v4
    invoke-virtual v2, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v4, v5
    float-to-int v4, v4
    const/16 v5, 12
    int-to-float v5, v5
    invoke-virtual v2, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-virtual v6, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v6
    iget v6, v6, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v5, v6
    float-to-int v5, v5
    invoke-interface v1, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v1
    invoke-interface v1, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +0bbh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/util/Map$Entry;
    invoke-interface v6, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    invoke-interface v6, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    new-instance v8, Landroid/widget/LinearLayout;
    invoke-direct v8, v2, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v9, 0
    invoke-virtual v8, v9, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v10, 16
    invoke-virtual v8, v10, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v11, -1
    const/4 v12, -2
    invoke-direct v10, v11, v12, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v4, v10, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v10, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v8, v3, v3, v3, v3, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    sget v10, Lcom/bytedance/trae/home/R$drawable;->bg_dialog_input I
    invoke-virtual v8, v10, Landroid/widget/LinearLayout;->setBackgroundResource(I)V
    new-instance v10, Landroid/widget/TextView;
    invoke-direct v10, v2, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v13, 1065353216
    invoke-direct v11, v9, v12, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v11, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v9, Ljava/lang/StringBuilder;
    invoke-direct v9, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v9, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v11, ": "
    invoke-virtual v9, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v10, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v6, Lcom/bytedance/trae/home/R$color;->trae_setting_text_primary I
    invoke-static v2, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v10, v6, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v6, 1095761920
    invoke-virtual v10, v6, Landroid/widget/TextView;->setTextSize(F)V
    const/4 v6, 1
    invoke-virtual v10, v6, Landroid/widget/TextView;->setSingleLine(Z)V
    new-instance v6, Landroid/widget/TextView;
    invoke-direct v6, v2, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v12, v12, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v9, v5, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v9, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-string/jumbo v9, ✕
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v6, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v9, Lcom/bytedance/trae/home/R$color;->trae_setting_text_secondary I
    invoke-static v2, v9, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v6, v9, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v9, 1096810496
    invoke-virtual v6, v9, Landroid/widget/TextView;->setTextSize(F)V
    invoke-virtual v6, v3, v4, v3, v4, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v9, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda10;
    invoke-direct v9, v7, v14, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda10;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    invoke-virtual v6, v9, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v10, Landroid/view/View;
    invoke-virtual v8, v10, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v6, Landroid/view/View;
    invoke-virtual v8, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v8, Landroid/view/View;
    invoke-virtual v0, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto/16 -0bdh
    return-void 
.end method

.method private static final refreshCustomHeaders$lambda$47$lambda$46(java.lang.String  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 3
    # ins_size=3
    sget-object v2, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v2, v0, Lcom/bytedance/trae/network/DebugSettings;->removeCustomHeader(Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->refreshCustomHeaders()V
    return-void 
.end method

.method private final refreshHistory()void
    .registers 15
    # ins_size=1
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->llHistory Landroid/widget/LinearLayout;
    if-nez v0, +003h
    return-void 
    iget-object v1, v14, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->tvHistoryLabel Landroid/widget/TextView;
    if-nez v1, +003h
    return-void 
    invoke-virtual v0, Landroid/widget/LinearLayout;->removeAllViews()V
    sget-object v2, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v2, Lcom/bytedance/trae/network/DebugSettings;->getPpeHistory()Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v3
    const/16 v4, 8
    if-eqz v3, +009h
    invoke-virtual v1, v4, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
    const/4 v3, 0
    invoke-virtual v1, v3, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    int-to-float v4, v4
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v4, v5
    float-to-int v4, v4
    const/4 v5, 4
    int-to-float v5, v5
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-virtual v6, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v6
    iget v6, v6, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v5, v6
    float-to-int v5, v5
    const/16 v6, 12
    int-to-float v6, v6
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    invoke-virtual v7, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v7
    iget v7, v7, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v6, v7
    float-to-int v6, v6
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +09eh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    new-instance v8, Landroid/widget/LinearLayout;
    invoke-direct v8, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v8, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v9, 16
    invoke-virtual v8, v9, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v10, -1
    const/4 v11, -2
    invoke-direct v9, v10, v11, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v5, v9, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v9, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v8, v4, v4, v4, v4, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    sget v9, Lcom/bytedance/trae/home/R$drawable;->bg_dialog_input I
    invoke-virtual v8, v9, Landroid/widget/LinearLayout;->setBackgroundResource(I)V
    new-instance v9, Landroid/widget/TextView;
    invoke-direct v9, v1, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v12, 1065353216
    invoke-direct v10, v3, v11, v12, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v10, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    move-object v10, v7
    check-cast v10, Ljava/lang/CharSequence;
    invoke-virtual v9, v10, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v10, Lcom/bytedance/trae/home/R$color;->trae_setting_text_primary I
    invoke-static v1, v10, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v10
    invoke-virtual v9, v10, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v10, 1096810496
    invoke-virtual v9, v10, Landroid/widget/TextView;->setTextSize(F)V
    const/4 v12, 1
    invoke-virtual v9, v12, Landroid/widget/TextView;->setSingleLine(Z)V
    new-instance v12, Landroid/widget/TextView;
    invoke-direct v12, v1, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v13, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v13, v11, v11, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v13, v6, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v13, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-string/jumbo v11, ✕
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v12, v11, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v11, Lcom/bytedance/trae/home/R$color;->trae_setting_text_secondary I
    invoke-static v1, v11, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v11
    invoke-virtual v12, v11, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v12, v10, Landroid/widget/TextView;->setTextSize(F)V
    invoke-virtual v12, v4, v5, v4, v5, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda8;
    invoke-direct v10, v14, v7, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Ljava/lang/String;)V
    invoke-virtual v9, v10, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda9;
    invoke-direct v10, v7, v14, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda9;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    invoke-virtual v12, v10, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v9, Landroid/view/View;
    invoke-virtual v8, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v12, Landroid/view/View;
    invoke-virtual v8, v12, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v8, Landroid/view/View;
    invoke-virtual v0, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto/16 -0a0h
    return-void 
.end method

.method private static final refreshHistory$lambda$40$lambda$38(com.bytedance.trae.home.solo.setting.DebugSettingsFragment  java.lang.String  android.view.View)void
    .registers 4
    # ins_size=3
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etPpeEnv Landroid/widget/EditText;
    if-eqz v3, +008h
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v3, v0, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etPpeEnv Landroid/widget/EditText;
    if-eqz v1, +009h
    invoke-virtual v2, Ljava/lang/String;->length()I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/EditText;->setSelection(I)V
    return-void 
.end method

.method private static final refreshHistory$lambda$40$lambda$39(java.lang.String  com.bytedance.trae.home.solo.setting.DebugSettingsFragment  android.view.View)void
    .registers 3
    # ins_size=3
    sget-object v2, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v2, v0, Lcom/bytedance/trae/network/DebugSettings;->removePpeHistory(Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->refreshHistory()V
    return-void 
.end method

.method private final setupAnyWhereDoorToggle(android.view.View)void
    .registers 9
    # ins_size=2
    const-string v0, "com.bytedance.trae.home.solo.setting.AnyDoorDebugSettings"
    invoke-static v0, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v0
    const-string/jumbo v1, setupToggle
    const/4 v2, 2
    new-array v3, v2, [Ljava/lang/Class;
    const-class v4, Landroidx/fragment/app/Fragment;
    const/4 v5, 0
    aput-object v4, v3, v5
    const-class v4, Landroid/view/View;
    const/4 v6, 1
    aput-object v4, v3, v6
    invoke-virtual v0, v1, v3, Ljava/lang/Class;->getMethod(Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v0
    new-array v1, v2, [Ljava/lang/Object;
    aput-object v7, v1, v5
    aput-object v8, v1, v6
    const/4 v8, 0
    invoke-virtual v0, v8, v1, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    goto +dh
    move-exception v8
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "AnyDoor debug settings setup failed"
    check-cast v8, Ljava/lang/Throwable;
    const-string v2, "DebugSettingsFragment"
    invoke-virtual v0, v2, v1, v8, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method private final setupDebugFloatingButtonToggle(android.view.View)void
    .registers 11
    # ins_size=2
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    const/16 v1, 16
    int-to-float v2, v1
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v3
    float-to-int v2, v2
    const/16 v3, 12
    int-to-float v3, v3
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v3, v4
    float-to-int v3, v3
    const/16 v4, 8
    int-to-float v4, v4
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v4, v5
    float-to-int v4, v4
    new-instance v5, Landroid/widget/LinearLayout;
    invoke-direct v5, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v6, 0
    invoke-virtual v5, v6, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v7, -1
    const/4 v8, -2
    invoke-direct v1, v7, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v1, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v1, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v7, 1065353216
    invoke-direct v2, v6, v8, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-string v2, "Debug Floating Button"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v2, 1096810496
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextSize(F)V
    invoke-virtual v1, v6, v4, v3, v4, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v2, Landroidx/appcompat/widget/SwitchCompat;
    invoke-direct v2, v0, Landroidx/appcompat/widget/SwitchCompat;-><init>(Landroid/content/Context;)V
    sget-object v3, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v3, Lcom/bytedance/trae/network/DebugSettings;->isDebugFloatingButtonEnabled()Z
    move-result v3
    invoke-virtual v2, v3, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda12;
    invoke-direct v3, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda12;-><init>(Landroid/content/Context;)V
    invoke-virtual v2, v3, Landroidx/appcompat/widget/SwitchCompat;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v2, Landroid/view/View;
    invoke-virtual v5, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_upload_alog I
    invoke-virtual v10, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v10
    if-nez v10, +003h
    return-void 
    invoke-virtual v10, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v10
    instance-of v0, v10, Landroid/view/ViewGroup;
    if-eqz v0, +005h
    check-cast v10, Landroid/view/ViewGroup;
    goto +2h
    const/4 v10, 0
    if-nez v10, +003h
    return-void 
    check-cast v5, Landroid/view/View;
    invoke-virtual v10, v5, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    return-void 
.end method

.method private static final setupDebugFloatingButtonToggle$lambda$32$lambda$31(android.content.Context  android.widget.CompoundButton  boolean)void
    .registers 6
    # ins_size=3
    sget-object v4, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/DebugSettings;->setDebugFloatingButtonEnabled(Z)V
    const/4 v4, 0
    const-string v0, "com.bytedance.trae.home.solo.setting.DebugFloatingButtonManager"
    invoke-static v0, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v0
    if-eqz v5, +00ch
    const-string/jumbo v1, show
    new-array v2, v4, [Ljava/lang/Class;
    invoke-virtual v0, v1, v2, Ljava/lang/Class;->getMethod(Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v0
    goto +9h
    const-string v1, "hide"
    new-array v2, v4, [Ljava/lang/Class;
    invoke-virtual v0, v1, v2, Ljava/lang/Class;->getMethod(Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v0
    new-array v1, v4, [Ljava/lang/Object;
    const/4 v2, 0
    invoke-virtual v0, v2, v1, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v5, +005h
    const-string v5, "Debug floating button ON"
    goto +3h
    const-string v5, "Debug floating button OFF"
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v3, v5, v4, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    return-void 
    :try_start_0x6
.end method

.method private final setupEnterpriseEnvToggle(android.view.View)void
    .registers 13
    # ins_size=2
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    const/16 v1, 16
    int-to-float v2, v1
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v3
    float-to-int v2, v2
    const/16 v3, 8
    int-to-float v3, v3
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v3, v4
    float-to-int v3, v3
    const/16 v4, 12
    int-to-float v4, v4
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v4, v5
    float-to-int v4, v4
    new-instance v5, Landroid/widget/LinearLayout;
    invoke-direct v5, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v6, 0
    invoke-virtual v5, v6, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v7, -1
    const/4 v8, -2
    invoke-direct v1, v7, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v1, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v1, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget-object v1, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v1, Lcom/bytedance/trae/network/DebugSettings;->isEnterpriseTestEnv()Z
    move-result v1
    if-eqz v1, +005h
    const-string v2, "TEST (enterprise.mcdemo.show)"
    goto +3h
    const-string v2, "ONLINE (console.enterprise.trae.cn)"
    new-instance v7, Landroid/widget/TextView;
    invoke-direct v7, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v10, 1065353216
    invoke-direct v9, v6, v8, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v9, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-string v8, "Enterprise Env: "
    invoke-virtual v8, v2, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v7, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v2, 1095761920
    invoke-virtual v7, v2, Landroid/widget/TextView;->setTextSize(F)V
    invoke-virtual v7, v6, v3, v4, v3, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v2, Landroidx/appcompat/widget/SwitchCompat;
    invoke-direct v2, v0, Landroidx/appcompat/widget/SwitchCompat;-><init>(Landroid/content/Context;)V
    invoke-virtual v2, v1, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda7;
    invoke-direct v1, v7, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda7;-><init>(Landroid/widget/TextView; Landroid/content/Context;)V
    invoke-virtual v2, v1, Landroidx/appcompat/widget/SwitchCompat;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    check-cast v7, Landroid/view/View;
    invoke-virtual v5, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v2, Landroid/view/View;
    invoke-virtual v5, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_upload_alog I
    invoke-virtual v12, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    if-nez v12, +003h
    return-void 
    invoke-virtual v12, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v12
    instance-of v0, v12, Landroid/view/ViewGroup;
    if-eqz v0, +005h
    check-cast v12, Landroid/view/ViewGroup;
    goto +2h
    const/4 v12, 0
    if-nez v12, +003h
    return-void 
    check-cast v5, Landroid/view/View;
    invoke-virtual v12, v5, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    return-void 
.end method

.method private static final setupEnterpriseEnvToggle$lambda$27$lambda$26(android.widget.TextView  android.content.Context  android.widget.CompoundButton  boolean)void
    .registers 7
    # ins_size=4
    sget-object v5, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    const-string v0, "TEST"
    const-string v1, "ONLINE"
    if-eqz v6, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v1
    invoke-virtual v5, v2, Lcom/bytedance/trae/network/DebugSettings;->setEnterpriseEnv(Ljava/lang/String;)V
    if-eqz v6, +003h
    goto +2h
    move-object v0, v1
    if-eqz v6, +005h
    const-string v5, "TEST (enterprise.mcdemo.show)"
    goto +3h
    const-string v5, "ONLINE (console.enterprise.trae.cn)"
    const-string v6, "Enterprise Env: "
    invoke-virtual v6, v5, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v3, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const-string v3, "Enterprise env: "
    invoke-virtual v3, v0, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v5, 0
    invoke-static v4, v3, v5, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v3
    invoke-virtual v3, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private final setupFeatureCapabilitySection(android.view.View)void
    .registers 31
    # ins_size=2
    invoke-virtual/range v29, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    const-class v1, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    if-nez v1, +003h
    return-void 
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    const/16 v9, 16
    int-to-float v3, v9
    mul-float/2addr v3, v2
    float-to-int v10, v3
    const/16 v3, 12
    int-to-float v3, v3
    mul-float/2addr v3, v2
    float-to-int v11, v3
    const/16 v3, 8
    int-to-float v3, v3
    mul-float/2addr v3, v2
    float-to-int v12, v3
    const/4 v3, 4
    int-to-float v3, v3
    mul-float/2addr v3, v2
    float-to-int v13, v3
    float-to-int v2, v2
    sget v3, Lcom/bytedance/trae/home/R$id;->btn_upload_alog I
    move-object/from16 v4, v30
    invoke-virtual v4, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v3
    instance-of v4, v3, Landroid/view/ViewGroup;
    const/4 v5, 0
    if-eqz v4, +006h
    check-cast v3, Landroid/view/ViewGroup;
    move-object v14, v3
    goto +2h
    move-object v14, v5
    if-nez v14, +003h
    return-void 
    new-instance v3, Landroid/view/View;
    invoke-direct v3, v0, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v15, -1
    invoke-direct v4, v15, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v10, v4, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v4, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v4, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v4, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v2, Lcom/bytedance/trae/home/R$color;->trae_setting_divider I
    invoke-static v0, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v3, v2, Landroid/view/View;->setBackgroundColor(I)V
    invoke-virtual v14, v3, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v8, -2
    invoke-direct v3, v15, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v10, v3, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v3, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v3, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-string v3, "Feature Capability"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v3, 1098907648
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTextSize(F)V
    const/4 v7, 1
    invoke-virtual v2, v5, v7, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface; I)V
    sget v3, Lcom/bytedance/trae/home/R$color;->trae_setting_text_primary I
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTextColor(I)V
    check-cast v2, Landroid/view/View;
    invoke-virtual v14, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    new-instance v6, Landroid/widget/TextView;
    invoke-direct v6, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v15, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v13, v2, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v2, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v2, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v2, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "Current: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    invoke-virtual v3, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->getEnabledFeatures()Ljava/util/Set;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v3, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +010h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v5, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v5
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v4, Ljava/util/List;
    move-object/from16 v16, v4
    check-cast v16, Ljava/lang/Iterable;
    const-string v3, ", "
    move-object/from16 v17, v3
    check-cast v17, Ljava/lang/CharSequence;
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 62
    const/16 v24, 0
    invoke-static/range v16 ... v24, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v6, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v5, 1094713344
    invoke-virtual v6, v5, Landroid/widget/TextView;->setTextSize(F)V
    sget v2, Lcom/bytedance/trae/home/R$color;->trae_setting_text_secondary I
    invoke-static v0, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v6, v2, Landroid/widget/TextView;->setTextColor(I)V
    move-object v2, v6
    check-cast v2, Landroid/view/View;
    invoke-virtual v14, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static Lcom/bytedance/trae/settings/api/feature/Feature;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v2
    invoke-interface v2, Lkotlin/enums/EnumEntries;->iterator()Ljava/util/Iterator;
    move-result-object v16
    invoke-interface/range v16, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    const/4 v4, 0
    if-eqz v2, +198h
    invoke-interface/range v16, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/settings/api/feature/Feature;
    new-instance v7, Landroid/widget/LinearLayout;
    invoke-direct v7, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v7, v4, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v7, v9, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v15, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v12, v9, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v9, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v9, v10, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v9, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget-object v9, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    invoke-virtual v9, v2, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v9
    new-instance v15, Landroid/widget/TextView;
    invoke-direct v15, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v3, v8, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v3, v12, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v15, v3, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    if-eqz v9, +006h
    const-string/jumbo v3, ●
    goto +4h
    const-string/jumbo v3, ○
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v15, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v15, v5, Landroid/widget/TextView;->setTextSize(F)V
    if-eqz v9, +005h
    sget v3, Lcom/bytedance/trae/home/R$color;->trae_setting_pro_badge_bg I
    goto +3h
    sget v3, Lcom/bytedance/trae/home/R$color;->trae_setting_text_secondary I
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v15, v3, Landroid/widget/TextView;->setTextColor(I)V
    new-instance v9, Landroid/widget/TextView;
    invoke-direct v9, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v5, 1065353216
    invoke-direct v3, v4, v8, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v3, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v2, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v9, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v3, 1096810496
    invoke-virtual v9, v3, Landroid/widget/TextView;->setTextSize(F)V
    sget v3, Lcom/bytedance/trae/home/R$color;->trae_setting_text_primary I
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v9, v3, Landroid/widget/TextView;->setTextColor(I)V
    new-instance v5, Landroid/widget/RadioGroup;
    invoke-direct v5, v0, Landroid/widget/RadioGroup;-><init>(Landroid/content/Context;)V
    invoke-virtual v5, v4, Landroid/widget/RadioGroup;->setOrientation(I)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v3, v8, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v3, Landroid/widget/RadioGroup;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/RadioButton;
    invoke-direct v3, v0, Landroid/widget/RadioButton;-><init>(Landroid/content/Context;)V
    const-string v19, "Default"
    move-object/from16 v8, v19
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v3, v8, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;)V
    const/high16 v8, 1093664768
    invoke-virtual v3, v8, Landroid/widget/RadioButton;->setTextSize(F)V
    invoke-static Landroid/view/View;->generateViewId()I
    move-result v8
    invoke-virtual v3, v8, Landroid/widget/RadioButton;->setId(I)V
    invoke-virtual v3, v13, v4, v12, v4, Landroid/widget/RadioButton;->setPadding(I I I I)V
    new-instance v8, Landroid/widget/RadioButton;
    invoke-direct v8, v0, Landroid/widget/RadioButton;-><init>(Landroid/content/Context;)V
    const-string v22, "ON"
    move-object/from16 v4, v22
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v8, v4, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;)V
    const/high16 v4, 1093664768
    invoke-virtual v8, v4, Landroid/widget/RadioButton;->setTextSize(F)V
    invoke-static Landroid/view/View;->generateViewId()I
    move-result v4
    invoke-virtual v8, v4, Landroid/widget/RadioButton;->setId(I)V
    const/4 v4, 0
    invoke-virtual v8, v13, v4, v12, v4, Landroid/widget/RadioButton;->setPadding(I I I I)V
    new-instance v4, Landroid/widget/RadioButton;
    invoke-direct v4, v0, Landroid/widget/RadioButton;-><init>(Landroid/content/Context;)V
    const-string v22, "OFF"
    move-object/from16 v24, v2
    move-object/from16 v2, v22
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v4, v2, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;)V
    const/high16 v2, 1093664768
    invoke-virtual v4, v2, Landroid/widget/RadioButton;->setTextSize(F)V
    invoke-static Landroid/view/View;->generateViewId()I
    move-result v2
    invoke-virtual v4, v2, Landroid/widget/RadioButton;->setId(I)V
    const/4 v2, 0
    invoke-virtual v4, v13, v2, v13, v2, Landroid/widget/RadioButton;->setPadding(I I I I)V
    move-object v2, v3
    check-cast v2, Landroid/view/View;
    invoke-virtual v5, v2, Landroid/widget/RadioGroup;->addView(Landroid/view/View;)V
    move-object v2, v8
    check-cast v2, Landroid/view/View;
    invoke-virtual v5, v2, Landroid/widget/RadioGroup;->addView(Landroid/view/View;)V
    move-object v2, v4
    check-cast v2, Landroid/view/View;
    invoke-virtual v5, v2, Landroid/widget/RadioGroup;->addView(Landroid/view/View;)V
    const/4 v2, 1
    invoke-virtual v3, v2, Landroid/widget/RadioButton;->setChecked(Z)V
    move/from16 v22, v10
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;
    move/from16 v19, v2
    move-object/from16 v30, v24
    const/high16 v23, 1093664768
    move-object v2, v10
    move/from16 v24, v23
    move-object/from16 v23, v4
    move-object v4, v1
    move-object/from16 v25, v1
    move-object v1, v5
    const/high16 v20, 1094713344
    move-object/from16 v5, v30
    move-object/from16 v26, v6
    move-object v6, v8
    move-object v8, v7
    move/from16 v27, v19
    move-object/from16 v7, v23
    move/from16 v28, v11
    move-object/from16 v21, v14
    const/4 v14, -2
    move-object v11, v8
    move-object/from16 v8, v26
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;-><init>(Landroid/widget/RadioButton; Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService; Lcom/bytedance/trae/settings/api/feature/Feature; Landroid/widget/RadioButton; Landroid/widget/RadioButton; Landroid/widget/TextView;)V
    invoke-virtual v1, v10, Landroid/widget/RadioGroup;->setOnCheckedChangeListener(Landroid/widget/RadioGroup$OnCheckedChangeListener;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v3, v14, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v3, v12, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-string v3, "Test"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v3, 1093664768
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTextSize(F)V
    sget v3, Lcom/bytedance/trae/home/R$color;->trae_setting_text_link I
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v2, v12, v13, v12, v13, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda14;
    move-object/from16 v4, v30
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/settings/api/feature/Feature; Landroid/content/Context;)V
    invoke-virtual v2, v3, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v15, Landroid/view/View;
    invoke-virtual v11, v15, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v9, Landroid/view/View;
    invoke-virtual v11, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move-object v5, v1
    check-cast v5, Landroid/view/View;
    invoke-virtual v11, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v2, Landroid/view/View;
    invoke-virtual v11, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move-object v7, v11
    check-cast v7, Landroid/view/View;
    move-object/from16 v3, v21
    invoke-virtual v3, v7, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    move v8, v14
    move/from16 v5, v20
    move/from16 v10, v22
    move-object/from16 v1, v25
    move-object/from16 v6, v26
    move/from16 v7, v27
    move/from16 v11, v28
    const/16 v9, 16
    const/4 v15, -1
    move-object v14, v3
    goto/16 -19bh
    move-object/from16 v25, v1
    move-object/from16 v26, v6
    move/from16 v22, v10
    move/from16 v28, v11
    move-object v3, v14
    move v14, v8
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -1
    invoke-direct v2, v4, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    move/from16 v4, v28
    iput v4, v2, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    move/from16 v5, v22
    invoke-virtual v2, v5, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v2, v5, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v5, v14, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v5, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v5, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-string v5, "Get All Enabled"
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v2, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v5, 1096810496
    invoke-virtual v2, v5, Landroid/widget/TextView;->setTextSize(F)V
    sget v5, Lcom/bytedance/trae/home/R$color;->trae_setting_text_link I
    invoke-static v0, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v2, v5, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v5, 0
    invoke-virtual v2, v5, v12, v12, v12, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda15;
    invoke-direct v5, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda15;-><init>(Landroid/content/Context;)V
    invoke-virtual v2, v5, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v5, Landroid/widget/TextView;
    invoke-direct v5, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v14, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v6, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v6, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-string v4, "Refresh"
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v5, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v4, 1096810496
    invoke-virtual v5, v4, Landroid/widget/TextView;->setTextSize(F)V
    sget v4, Lcom/bytedance/trae/home/R$color;->trae_setting_text_link I
    invoke-static v0, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v5, v4, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v4, 0
    invoke-virtual v5, v4, v12, v12, v12, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda16;
    move-object/from16 v6, v26
    invoke-direct v4, v0, v6, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda16;-><init>(Landroid/content/Context; Landroid/widget/TextView;)V
    invoke-virtual v5, v4, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v4, Landroid/widget/TextView;
    invoke-direct v4, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v14, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v7, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-string v7, "Reset All"
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v4, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v7, 1096810496
    invoke-virtual v4, v7, Landroid/widget/TextView;->setTextSize(F)V
    sget v7, Lcom/bytedance/trae/home/R$color;->trae_setting_text_link I
    invoke-static v0, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    invoke-virtual v4, v7, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v7, 0
    invoke-virtual v4, v7, v12, v7, v12, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda17;
    move-object/from16 v8, v25
    invoke-direct v7, v8, v0, v6, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda17;-><init>(Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService; Landroid/content/Context; Landroid/widget/TextView;)V
    invoke-virtual v4, v7, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v2, Landroid/view/View;
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v5, Landroid/view/View;
    invoke-virtual v1, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v4, Landroid/view/View;
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v3, v1, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    return-void 
.end method

.method private static final setupFeatureCapabilitySection$lambda$70(android.widget.RadioButton  com.bytedance.trae.settings.api.feature.IFeatureCapabilityService  com.bytedance.trae.settings.api.feature.Feature  android.widget.RadioButton  android.widget.RadioButton  android.widget.TextView  android.widget.RadioGroup  int)void
    .registers 8
    # ins_size=8
    invoke-virtual v0, Landroid/widget/RadioButton;->getId()I
    move-result v0
    if-ne v7, v0, +007h
    const/4 v0, 0
    invoke-interface v1, v2, v0, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;->setDebugOverride(Lcom/bytedance/trae/settings/api/feature/Feature; Ljava/lang/Boolean;)V
    goto +1eh
    invoke-virtual v3, Landroid/widget/RadioButton;->getId()I
    move-result v0
    if-ne v7, v0, +00bh
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-interface v1, v2, v0, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;->setDebugOverride(Lcom/bytedance/trae/settings/api/feature/Feature; Ljava/lang/Boolean;)V
    goto +fh
    invoke-virtual v4, Landroid/widget/RadioButton;->getId()I
    move-result v0
    if-ne v7, v0, +00ah
    const/4 v0, 0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-interface v1, v2, v0, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;->setDebugOverride(Lcom/bytedance/trae/settings/api/feature/Feature; Ljava/lang/Boolean;)V
    invoke-static v5, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupFeatureCapabilitySection$refreshCurrentStatus(Landroid/widget/TextView;)V
    return-void 
.end method

.method private static final setupFeatureCapabilitySection$lambda$73$lambda$72(com.bytedance.trae.settings.api.feature.Feature  android.content.Context  android.view.View)void
    .registers 7
    # ins_size=3
    sget-object v6, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    invoke-virtual v6, v4, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v6
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " isEnabled = "
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "FeatureCapability.isEnabled("
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v2, ") = "
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v6, "DebugSettingsFragment"
    invoke-virtual v1, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v4, Landroidx/appcompat/app/AlertDialog$Builder;
    invoke-direct v4, v5, Landroidx/appcompat/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V
    const-string v5, "Feature Test"
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v4, v5, Landroidx/appcompat/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroidx/appcompat/app/AlertDialog$Builder;
    move-result-object v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v4, v0, Landroidx/appcompat/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroidx/appcompat/app/AlertDialog$Builder;
    move-result-object v4
    const-string v5, "OK"
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    invoke-virtual v4, v5, v6, Landroidx/appcompat/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence; Landroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/AlertDialog$Builder;
    move-result-object v4
    invoke-virtual v4, Landroidx/appcompat/app/AlertDialog$Builder;->show()Landroidx/appcompat/app/AlertDialog;
    return-void 
.end method

.method private static final setupFeatureCapabilitySection$lambda$80$lambda$79(android.content.Context  android.view.View)void
    .registers 11
    # ins_size=2
    sget-object v10, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    invoke-virtual v10, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->getEnabledFeatures()Ljava/util/Set;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, "
"
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda19;
    invoke-direct v6, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda19;-><init>()V
    const/16 v7, 30
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "getEnabledFeatures: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "DebugSettingsFragment"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Landroidx/appcompat/app/AlertDialog$Builder;
    invoke-direct v0, v9, Landroidx/appcompat/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V
    const-string v9, "Enabled Features"
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v0, v9, Landroidx/appcompat/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroidx/appcompat/app/AlertDialog$Builder;
    move-result-object v9
    check-cast v10, Ljava/lang/CharSequence;
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +004h
    const-string v10, "(none)"
    check-cast v10, Ljava/lang/CharSequence;
    invoke-virtual v9, v10, Landroidx/appcompat/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroidx/appcompat/app/AlertDialog$Builder;
    move-result-object v9
    const-string v10, "OK"
    check-cast v10, Ljava/lang/CharSequence;
    const/4 v0, 0
    invoke-virtual v9, v10, v0, Landroidx/appcompat/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence; Landroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/AlertDialog$Builder;
    move-result-object v9
    invoke-virtual v9, Landroidx/appcompat/app/AlertDialog$Builder;->show()Landroidx/appcompat/app/AlertDialog;
    return-void 
.end method

.method private static final setupFeatureCapabilitySection$lambda$80$lambda$79$lambda$77(com.bytedance.trae.settings.api.feature.Feature)java.lang.CharSequence
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    return-object v1
.end method

.method private static final setupFeatureCapabilitySection$lambda$83$lambda$82(android.content.Context  android.widget.TextView  android.view.View)void
    .registers 5
    # ins_size=3
    sget-object v4, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    invoke-virtual v4, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->refresh()V
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "DebugSettingsFragment"
    const-string v1, "FeatureCapability.refresh() called"
    invoke-virtual v4, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupFeatureCapabilitySection$refreshCurrentStatus(Landroid/widget/TextView;)V
    const-string v3, "Feature config refreshed"
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 0
    invoke-static v2, v3, v4, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final setupFeatureCapabilitySection$lambda$85$lambda$84(com.bytedance.trae.settings.api.feature.IFeatureCapabilityService  android.content.Context  android.widget.TextView  android.view.View)void
    .registers 6
    # ins_size=4
    invoke-static Lcom/bytedance/trae/settings/api/feature/Feature;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v5
    invoke-interface v5, Lkotlin/enums/EnumEntries;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00dh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/settings/api/feature/Feature;
    const/4 v1, 0
    invoke-interface v2, v0, v1, Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;->setDebugOverride(Lcom/bytedance/trae/settings/api/feature/Feature; Ljava/lang/Boolean;)V
    goto -10h
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupFeatureCapabilitySection$refreshCurrentStatus(Landroid/widget/TextView;)V
    const-string v2, "All feature overrides cleared"
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v4, 0
    invoke-static v3, v2, v4, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final setupFeatureCapabilitySection$refreshCurrentStatus(android.widget.TextView)void
    .registers 13
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Current: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    invoke-virtual v1, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->getEnabledFeatures()Ljava/util/Set;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v3, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v2, Ljava/util/List;
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    const-string v1, ", "
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 62
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v12, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method private final setupForceTokenRefreshToggle(android.view.View)void
    .registers 11
    # ins_size=2
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    const/16 v1, 16
    int-to-float v2, v1
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v3
    float-to-int v2, v2
    const/16 v3, 12
    int-to-float v3, v3
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v3, v4
    float-to-int v3, v3
    const/16 v4, 8
    int-to-float v4, v4
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v4, v5
    float-to-int v4, v4
    new-instance v5, Landroid/widget/LinearLayout;
    invoke-direct v5, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v6, 0
    invoke-virtual v5, v6, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v7, -1
    const/4 v8, -2
    invoke-direct v1, v7, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v1, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v1, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v7, 1065353216
    invoke-direct v2, v6, v8, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-string v2, "Force Token Refresh"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v2, 1096810496
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextSize(F)V
    invoke-virtual v1, v6, v4, v3, v4, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v2, Landroidx/appcompat/widget/SwitchCompat;
    invoke-direct v2, v0, Landroidx/appcompat/widget/SwitchCompat;-><init>(Landroid/content/Context;)V
    sget-object v3, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v3, Lcom/bytedance/trae/network/DebugSettings;->getForceTokenRefresh()Z
    move-result v3
    invoke-virtual v2, v3, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda18;
    invoke-direct v3, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda18;-><init>(Landroid/content/Context;)V
    invoke-virtual v2, v3, Landroidx/appcompat/widget/SwitchCompat;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v2, Landroid/view/View;
    invoke-virtual v5, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_upload_alog I
    invoke-virtual v10, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v10
    if-nez v10, +003h
    return-void 
    invoke-virtual v10, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v10
    instance-of v0, v10, Landroid/view/ViewGroup;
    if-eqz v0, +005h
    check-cast v10, Landroid/view/ViewGroup;
    goto +2h
    const/4 v10, 0
    if-nez v10, +003h
    return-void 
    check-cast v5, Landroid/view/View;
    invoke-virtual v10, v5, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    return-void 
.end method

.method private static final setupForceTokenRefreshToggle$lambda$22$lambda$21(android.content.Context  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    sget-object v1, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/DebugSettings;->setForceTokenRefresh(Z)V
    if-eqz v2, +005h
    const-string v1, "Force refresh ON"
    goto +3h
    const-string v1, "Force refresh OFF"
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private final setupNotificationBoeToggle(android.view.View)void
    .registers 11
    # ins_size=2
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    const/16 v1, 16
    int-to-float v2, v1
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v3
    float-to-int v2, v2
    const/16 v3, 12
    int-to-float v3, v3
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v3, v4
    float-to-int v3, v3
    const/16 v4, 8
    int-to-float v4, v4
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v4, v5
    float-to-int v4, v4
    new-instance v5, Landroid/widget/LinearLayout;
    invoke-direct v5, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v6, 0
    invoke-virtual v5, v6, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v7, -1
    const/4 v8, -2
    invoke-direct v1, v7, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v1, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v1, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v7, 1065353216
    invoke-direct v2, v6, v8, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const-string v2, "Notification BOE"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v2, 1096810496
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextSize(F)V
    invoke-virtual v1, v6, v4, v3, v4, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v2, Landroidx/appcompat/widget/SwitchCompat;
    invoke-direct v2, v0, Landroidx/appcompat/widget/SwitchCompat;-><init>(Landroid/content/Context;)V
    sget-object v3, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v3, Lcom/bytedance/trae/network/DebugSettings;->getNotificationBoe()Z
    move-result v3
    invoke-virtual v2, v3, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda20;
    invoke-direct v3, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda20;-><init>(Landroid/content/Context;)V
    invoke-virtual v2, v3, Landroidx/appcompat/widget/SwitchCompat;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v2, Landroid/view/View;
    invoke-virtual v5, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_upload_alog I
    invoke-virtual v10, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v10
    if-nez v10, +003h
    return-void 
    invoke-virtual v10, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v10
    instance-of v0, v10, Landroid/view/ViewGroup;
    if-eqz v0, +005h
    check-cast v10, Landroid/view/ViewGroup;
    goto +2h
    const/4 v10, 0
    if-nez v10, +003h
    return-void 
    check-cast v5, Landroid/view/View;
    invoke-virtual v10, v5, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    return-void 
.end method

.method private static final setupNotificationBoeToggle$lambda$52$lambda$51(android.content.Context  android.widget.CompoundButton  boolean)void
    .registers 3
    # ins_size=3
    sget-object v1, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/DebugSettings;->setNotificationBoe(Z)V
    if-eqz v2, +005h
    const-string v1, "Notification BOE ON"
    goto +3h
    const-string v1, "Notification BOE OFF"
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private final updateCurrentDisplay(android.widget.TextView  java.lang.String)void
    .registers 4
    # ins_size=3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +00ah
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_ppe_env_not_set I
    invoke-virtual v1, v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method private final updateEnvLaneDisplay(android.widget.TextView  java.lang.String)void
    .registers 6
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_debug_env_lane_current I
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/Object;
    const/4 v2, 0
    aput-object v5, v1, v2
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_debug_settings I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 13
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v10, v11, v12, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v12, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda22;
    invoke-direct v0, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda22;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    invoke-virtual v12, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v12, Lcom/bytedance/trae/home/R$id;->tv_ppe_current I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    check-cast v12, Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->et_ppe_env I
    invoke-virtual v11, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etPpeEnv Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/home/R$id;->ll_ppe_history I
    invoke-virtual v11, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/LinearLayout;
    iput-object v0, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->llHistory Landroid/widget/LinearLayout;
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_ppe_history_label I
    invoke-virtual v11, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->tvHistoryLabel Landroid/widget/TextView;
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v0, Lcom/bytedance/trae/network/DebugSettings;->getPpeEnv()Ljava/lang/String;
    move-result-object v0
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v10, v12, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->updateCurrentDisplay(Landroid/widget/TextView; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    if-lez v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +009h
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etPpeEnv Landroid/widget/EditText;
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_save I
    invoke-virtual v11, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda25;
    invoke-direct v1, v10, v12, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda25;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/widget/TextView;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_clear I
    invoke-virtual v11, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda26;
    invoke-direct v1, v10, v12, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda26;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/widget/TextView;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->refreshHistory()V
    sget v12, Lcom/bytedance/trae/home/R$id;->tv_env_lane_current I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    check-cast v12, Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/home/R$id;->et_env_lane I
    invoke-virtual v11, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/EditText;
    iput-object v0, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etEnvLane Landroid/widget/EditText;
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v0, Lcom/bytedance/trae/network/DebugSettings;->getEnvLane()Ljava/lang/String;
    move-result-object v0
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v10, v12, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->updateEnvLaneDisplay(Landroid/widget/TextView; Ljava/lang/String;)V
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etEnvLane Landroid/widget/EditText;
    if-eqz v1, +007h
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_env_lane_save I
    invoke-virtual v11, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda27;
    invoke-direct v1, v10, v12, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda27;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/widget/TextView;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_env_lane_reset I
    invoke-virtual v11, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda1;
    invoke-direct v1, v10, v12, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment; Landroid/widget/TextView;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v12, Lcom/bytedance/trae/home/R$id;->ll_custom_headers I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    check-cast v12, Landroid/widget/LinearLayout;
    iput-object v12, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->llCustomHeaders Landroid/widget/LinearLayout;
    sget v12, Lcom/bytedance/trae/home/R$id;->et_custom_header_key I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    check-cast v12, Landroid/widget/EditText;
    iput-object v12, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etCustomHeaderKey Landroid/widget/EditText;
    sget v12, Lcom/bytedance/trae/home/R$id;->et_custom_header_value I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    check-cast v12, Landroid/widget/EditText;
    iput-object v12, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->etCustomHeaderValue Landroid/widget/EditText;
    sget v12, Lcom/bytedance/trae/home/R$id;->btn_custom_header_add I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda2;
    invoke-direct v0, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    invoke-virtual v12, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v12, Lcom/bytedance/trae/home/R$id;->btn_custom_header_clear_all I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda3;
    invoke-direct v0, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    invoke-virtual v12, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->refreshCustomHeaders()V
    sget-object v12, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v12, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v12
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getUserID()Ljava/lang/String;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/home/R$id;->tv_device_id I
    invoke-virtual v11, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    sget v5, Lcom/bytedance/trae/home/R$id;->tv_user_id I
    invoke-virtual v11, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/TextView;
    sget v6, Lcom/bytedance/trae/home/R$id;->tv_passport_user_id I
    invoke-virtual v11, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroid/widget/TextView;
    move-object v7, v12
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +004h
    move v8, v2
    goto +2h
    move v8, v3
    const-string v9, "-"
    if-eqz v8, +003h
    move-object v7, v9
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v4, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +004h
    move v7, v2
    goto +2h
    move v7, v3
    if-eqz v7, +003h
    move-object v4, v9
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v5, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +003h
    goto +2h
    move-object v9, v4
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v6, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v2, Lcom/bytedance/trae/home/R$id;->btn_copy_device_info I
    invoke-virtual v11, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda4;
    invoke-direct v3, v12, v0, v1, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda4;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    invoke-virtual v2, v3, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v12, Lcom/bytedance/trae/home/R$id;->btn_view_login_devices I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda5;
    invoke-direct v0, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    invoke-virtual v12, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v12, Lcom/bytedance/trae/home/R$id;->btn_clear_billing_upgrade_prompt_cache I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda6;
    invoke-direct v0, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    invoke-virtual v12, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v12, Lcom/bytedance/trae/home/R$id;->btn_upload_alog I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    check-cast v12, Landroid/widget/TextView;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda23;
    invoke-direct v0, v12, v10, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda23;-><init>(Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;)V
    invoke-virtual v12, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupForceTokenRefreshToggle(Landroid/view/View;)V
    sget v12, Lcom/bytedance/trae/home/R$id;->cb_mock_did I
    invoke-virtual v11, v12, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v12
    check-cast v12, Landroid/widget/CheckBox;
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v0, Lcom/bytedance/trae/network/DebugSettings;->isDeviceManagerMockDid()Z
    move-result v0
    invoke-virtual v12, v0, Landroid/widget/CheckBox;->setChecked(Z)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda24;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda24;-><init>()V
    invoke-virtual v12, v0, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupEnterpriseEnvToggle(Landroid/view/View;)V
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupAnyWhereDoorToggle(Landroid/view/View;)V
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupDebugFloatingButtonToggle(Landroid/view/View;)V
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupNotificationBoeToggle(Landroid/view/View;)V
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->setupFeatureCapabilitySection(Landroid/view/View;)V
    return-void 
.end method
