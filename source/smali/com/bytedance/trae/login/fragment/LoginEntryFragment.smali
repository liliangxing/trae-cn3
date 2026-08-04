# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/LoginEntryFragment;
.super Lcom/bytedance/trae/common/fragment/TraceFragment;
.source "LoginEntryFragment.kt"

.implements Lcom/bytedance/trae/login/fragment/BytecloudSsoHost;

.field public static final Companion:Lcom/bytedance/trae/login/fragment/LoginEntryFragment$Companion;
.field private static final KEY_AGREEMENT_CHECKED:Ljava/lang/String;
.field private agreementDialog:Lcom/bytedance/trae/login/activity/AgreementDialog;
.field private isAgreementChecked:Z


.method public static synthetic $r8$lambda$-4UpA9tmX9n8M1DoIiekADG608E()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->setupViews$lambda$4$lambda$2()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$0Tg8kTcFE7tKHbnMqBrqMppOe3g(com.bytedance.trae.login.fragment.LoginEntryFragment  android.view.View  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->setupViews$lambda$4(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Anc4P5Y4NUoGC20o9JUY1gUb18M(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->showBytecloudSso$lambda$11$lambda$10(Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Dor2gJFAiaytFIpqB_1BWzWZouo(com.bytedance.trae.login.activity.AccountLoginActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->tryShowBytecloudSso$lambda$9(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$G6Wt2w-VSTH7S2x9crFmNOmZMwI(com.bytedance.trae.login.fragment.LoginEntryFragment  android.widget.ImageView  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->setupViews$lambda$0(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Landroid/widget/ImageView; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$KKPWx6gAR_bhGHul--9j1gVxR1E(com.bytedance.trae.login.fragment.LoginEntryFragment  android.view.View  com.bytedance.trae.login.activity.AccountLoginActivity)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->setupViews$lambda$4$lambda$1(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Landroid/view/View; Lcom/bytedance/trae/login/activity/AccountLoginActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$VAfwHnGpWx1Kb62QbgB5VbHRY8M(com.bytedance.trae.login.fragment.LoginEntryFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->setupViews$lambda$5(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$s_nc5HVColbwJKX-c9hFVNxpNXc(com.bytedance.trae.login.fragment.LoginEntryFragment  android.view.View  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->setupEnterpriseLogin$lambda$8(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$y6SrL2jqnb4bKGrEJCpBJOnkXAk(com.bytedance.trae.login.fragment.LoginEntryFragment  android.view.View)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->setupEnterpriseLogin$lambda$8$lambda$6(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Landroid/view/View;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->Companion Lcom/bytedance/trae/login/fragment/LoginEntryFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/fragment/TraceFragment;-><init>()V
    return-void 
.end method

.method public static final synthetic access$openUrl(com.bytedance.trae.login.fragment.LoginEntryFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->openUrl(Ljava/lang/String;)V
    return-void 
.end method

.method private final openUrl(java.lang.String)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/AgreementUrlOpener;->INSTANCE Lcom/bytedance/trae/utils/AgreementUrlOpener;
    invoke-virtual v3, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    const-string/jumbo v2, requireContext(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/AgreementUrlOpener;->open(Landroid/content/Context; Ljava/lang/String;)V
    goto +5h
    move-exception v4
    invoke-virtual v4, Ljava/lang/Exception;->printStackTrace()V
    return-void 
    :try_start_0x0
.end method

.method private final setupEnterpriseLogin(android.view.View)void
    .registers 4
    # ins_size=2
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_enterprise_login I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda2;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Landroid/view/View;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupEnterpriseLogin$lambda$8(com.bytedance.trae.login.fragment.LoginEntryFragment  android.view.View  android.view.View)void
    .registers 10
    # ins_size=3
    sget-object v9, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const-string v0, "enterprise"
    invoke-virtual v9, v0, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackLoginClick(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v9
    instance-of v0, v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    if-eqz v0, +005h
    check-cast v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    goto +2h
    const/4 v9, 0
    if-nez v9, +003h
    return-void 
    iget-boolean v0, v7, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAgreementChecked Z
    if-nez v0, +02dh
    iget-object v9, v7, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->agreementDialog Lcom/bytedance/trae/login/activity/AgreementDialog;
    const/4 v0, 0
    if-eqz v9, +00ah
    invoke-virtual v9, Lcom/bytedance/trae/login/activity/AgreementDialog;->isShowing()Z
    move-result v9
    const/4 v1, 1
    if-ne v9, v1, +003h
    move v0, v1
    if-eqz v0, +003h
    return-void 
    invoke-virtual v7, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    new-instance v9, Lcom/bytedance/trae/login/activity/AgreementDialog;
    new-instance v3, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda1;
    invoke-direct v3, v7, v8, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Landroid/view/View;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/login/activity/AgreementDialog;-><init>(Landroid/content/Context; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v9, Lcom/bytedance/trae/login/activity/AgreementDialog;->show()V
    iput-object v9, v7, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->agreementDialog Lcom/bytedance/trae/login/activity/AgreementDialog;
    return-void 
    invoke-virtual v9, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->openEnterpriseLogin()V
    return-void 
.end method

.method private static final setupEnterpriseLogin$lambda$8$lambda$6(com.bytedance.trae.login.fragment.LoginEntryFragment  android.view.View)kotlin.Unit
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAdded()Z
    move-result v0
    if-nez v0, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAgreementChecked Z
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_agreement_check I
    invoke-virtual v2, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_ic_checkmark_circle_filled I
    invoke-virtual v2, v0, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    if-eqz v2, +005h
    check-cast v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +005h
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->openEnterpriseLogin()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final setupViews(android.view.View)void
    .registers 8
    # ins_size=2
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_agreement_check I
    invoke-virtual v7, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/login/R$id;->privacy_policy_text I
    invoke-virtual v7, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    sget v2, Lcom/bytedance/trae/login/R$id;->btn_douyin_login I
    invoke-virtual v7, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/FrameLayout;
    sget v3, Lcom/bytedance/trae/login/R$id;->btn_phone_login I
    invoke-virtual v7, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/FrameLayout;
    iget-boolean v4, v6, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAgreementChecked Z
    if-eqz v4, +005h
    sget v4, Lcom/bytedance/trae/login/R$drawable;->trae_ic_checkmark_circle_filled I
    goto +3h
    sget v4, Lcom/bytedance/trae/login/R$drawable;->trae_ic_checkmark_circle_unchecked I
    invoke-virtual v0, v4, Landroid/widget/ImageView;->setImageResource(I)V
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->login_agreement I
    invoke-virtual v6, v4, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v5, "getString(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v4, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->setUrlSpannedText(Ljava/lang/String;)V
    new-instance v4, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$setupViews$1;
    invoke-direct v4, v6, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$setupViews$1;-><init>(Lcom/bytedance/trae/login/fragment/LoginEntryFragment;)V
    check-cast v4, Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;
    invoke-virtual v1, v4, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->setOnClickListener(Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;)V
    new-instance v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda6;
    invoke-direct v1, v6, v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Landroid/widget/ImageView;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda7;
    invoke-direct v0, v6, v7, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Landroid/view/View;)V
    invoke-virtual v2, v0, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v7, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda8;
    invoke-direct v7, v6, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/login/fragment/LoginEntryFragment;)V
    invoke-virtual v3, v7, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupViews$lambda$0(com.bytedance.trae.login.fragment.LoginEntryFragment  android.widget.ImageView  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->toggleAgreement(Landroid/widget/ImageView;)V
    return-void 
.end method

.method private static final setupViews$lambda$4(com.bytedance.trae.login.fragment.LoginEntryFragment  android.view.View  android.view.View)void
    .registers 22
    # ins_size=3
    move-object/from16 v0, v19
    sget-object v1, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const-string v2, "douyin"
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackLoginClick(Ljava/lang/String;)V
    invoke-virtual/range v19, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    if-eqz v2, +005h
    check-cast v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    goto +2h
    const/4 v1, 0
    if-nez v1, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "login_button_clicked"
    const-string v4, "douyin"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 2044
    const/4 v15, 0
    invoke-static/range v2 ... v15, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-boolean v2, v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAgreementChecked Z
    if-nez v2, +046h
    iget-object v2, v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->agreementDialog Lcom/bytedance/trae/login/activity/AgreementDialog;
    const/4 v3, 0
    if-eqz v2, +00ah
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/AgreementDialog;->isShowing()Z
    move-result v2
    const/4 v4, 1
    if-ne v2, v4, +003h
    move v3, v4
    if-eqz v3, +003h
    return-void 
    invoke-virtual/range v19, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->getContext()Landroid/content/Context;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "agreement_dialog_shown"
    const-string v5, "douyin"
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 2044
    const/16 v16, 0
    invoke-static/range v3 ... v16, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    new-instance v3, Lcom/bytedance/trae/login/activity/AgreementDialog;
    new-instance v4, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda4;
    move-object/from16 v5, v20
    invoke-direct v4, v0, v5, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Landroid/view/View; Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    new-instance v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda5;
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda5;-><init>()V
    invoke-direct v3, v2, v4, v1, Lcom/bytedance/trae/login/activity/AgreementDialog;-><init>(Landroid/content/Context; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/AgreementDialog;->show()V
    iput-object v3, v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->agreementDialog Lcom/bytedance/trae/login/activity/AgreementDialog;
    return-void 
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v6, "login_method_selected"
    const-string v7, "douyin"
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 2044
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->onDouyinLogin()V
    return-void 
.end method

.method private static final setupViews$lambda$4$lambda$1(com.bytedance.trae.login.fragment.LoginEntryFragment  android.view.View  com.bytedance.trae.login.activity.AccountLoginActivity)kotlin.Unit
    .registers 19
    # ins_size=3
    invoke-virtual/range v16, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAdded()Z
    move-result v0
    if-nez v0, +005h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v2, "agreement_accepted"
    const-string v3, "douyin"
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 2044
    const/4 v14, 0
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    const/4 v0, 1
    move-object/from16 v1, v16
    iput-boolean v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAgreementChecked Z
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_agreement_check I
    move-object/from16 v1, v17
    invoke-virtual v1, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/login/R$drawable;->trae_ic_checkmark_circle_filled I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "login_method_selected"
    const-string v4, "douyin"
    const/4 v13, 0
    const/16 v14, 2044
    const/4 v15, 0
    invoke-static/range v2 ... v15, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->onDouyinLogin()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final setupViews$lambda$4$lambda$2()kotlin.Unit
    .registers 14
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v1, "agreement_rejected"
    const-string v2, "douyin"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 2044
    const/4 v13, 0
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final setupViews$lambda$5(com.bytedance.trae.login.fragment.LoginEntryFragment  android.view.View)void
    .registers 3
    # ins_size=2
    sget-object v2, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const-string/jumbo v0, phone
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackLoginClick(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v2
    instance-of v0, v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    if-eqz v0, +005h
    check-cast v2, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    goto +2h
    const/4 v2, 0
    if-nez v2, +003h
    return-void 
    iget-boolean v1, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAgreementChecked Z
    invoke-virtual v2, v1, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->onPhoneLoginClicked(Z)V
    return-void 
.end method

.method private static final showBytecloudSso$lambda$11$lambda$10(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 3
    # ins_size=2
    sget-object v2, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const-string v0, "bytecloud"
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackLoginClick(Ljava/lang/String;)V
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final toggleAgreement(android.widget.ImageView)void
    .registers 3
    # ins_size=2
    iget-boolean v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAgreementChecked Z
    xor-int/lit8 v0, v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAgreementChecked Z
    if-eqz v0, +005h
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_ic_checkmark_circle_filled I
    goto +3h
    sget v0, Lcom/bytedance/trae/login/R$drawable;->trae_ic_checkmark_circle_unchecked I
    invoke-virtual v2, v0, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
.end method

.method private final tryShowBytecloudSso()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->isBytedanceNetwork()Z
    move-result v1
    if-nez v1, +00ah
    sget-object v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->hasEverSeenIntranet()Z
    move-result v1
    if-eqz v1, +00ah
    new-instance v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/AccountLoginActivity;)V
    invoke-virtual v2, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->showBytecloudSso(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final tryShowBytecloudSso$lambda$9(com.bytedance.trae.login.activity.AccountLoginActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->openBytecloudLogin()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public autoLogEnterPage()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public onCreate(android.os.Bundle)void
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/bytedance/trae/common/fragment/TraceFragment;->onCreate(Landroid/os/Bundle;)V
    if-eqz v2, +009h
    const-string v0, "key_agreement_checked"
    invoke-virtual v2, v0, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v2
    goto +2h
    const/4 v2, 0
    iput-boolean v2, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAgreementChecked Z
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/login/R$layout;->trae_fragment_login_entry I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 2
    # ins_size=1
    invoke-super v1, Lcom/bytedance/trae/common/fragment/TraceFragment;->onDestroyView()V
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->agreementDialog Lcom/bytedance/trae/login/activity/AgreementDialog;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AgreementDialog;->dismiss()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->agreementDialog Lcom/bytedance/trae/login/activity/AgreementDialog;
    return-void 
.end method

.method public onSaveInstanceState(android.os.Bundle)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, outState
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v2, v3, Lcom/bytedance/trae/common/fragment/TraceFragment;->onSaveInstanceState(Landroid/os/Bundle;)V
    const-string v0, "key_agreement_checked"
    iget-boolean v1, v2, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->isAgreementChecked Z
    invoke-virtual v3, v0, v1, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Lcom/bytedance/trae/common/fragment/TraceFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->setupViews(Landroid/view/View;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->setupEnterpriseLogin(Landroid/view/View;)V
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->tryShowBytecloudSso()V
    return-void 
.end method

.method public showBytecloudSso(kotlin.jvm.functions.Function0)void
    .registers 6
    # ins_size=2
    const-string/jumbo v0, onSsoClick
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->getView()Landroid/view/View;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +017h
    sget v2, Lcom/bytedance/trae/login/R$id;->btn_bytecloud_sso I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    if-eqz v0, +00dh
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    new-instance v2, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda3;
    invoke-direct v2, v5, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$$ExternalSyntheticLambda3;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v0, v2, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v4, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->getView()Landroid/view/View;
    move-result-object v5
    if-eqz v5, +00dh
    sget v0, Lcom/bytedance/trae/login/R$id;->divider_login_links I
    invoke-virtual v5, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    if-eqz v5, +005h
    invoke-virtual v5, v1, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v4, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->getView()Landroid/view/View;
    move-result-object v5
    if-eqz v5, +02dh
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_enterprise_login I
    invoke-virtual v5, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +023h
    invoke-virtual v5, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    instance-of v2, v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, 0
    if-eqz v2, +005h
    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;
    goto +2h
    move-object v0, v3
    if-eqz v0, +009h
    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->width I
    const/high16 v1, 1065353216
    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->weight F
    move-object v3, v0
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v3, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const v0, 8388611
    invoke-virtual v5, v0, Landroid/widget/TextView;->setGravity(I)V
    return-void 
.end method
