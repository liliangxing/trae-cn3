# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
.super Lcom/bytedance/trae/common/fragment/TraceFragment;
.source "DouyinBindPhoneInputFragment.kt"

.field public static final Companion:Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$Companion;
.field private static final PHONE_REGEX:Lkotlin/text/Regex;
.field private _binding:Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
.field private isSendingCode:Z
.field private phoneNumber:Ljava/lang/String;


.method public static synthetic $r8$lambda$_0JtfcMp0wCiC7SIj_u22VuLgqY(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->setupViews$lambda$0(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$hvExl9O9QEN7N4wxFFyGpze02xI(java.lang.CharSequence  int  int  android.text.Spanned  int  int)java.lang.CharSequence
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->digitFilter$lambda$1(Ljava/lang/CharSequence; I I Landroid/text/Spanned; I I)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$qTN5q9dfJbVX3t6Ld0Zbxmp43zA(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  androidx.fragment.app.FragmentActivity  kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->runOnUiThread$lambda$2(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Landroidx/fragment/app/FragmentActivity; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->Companion Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$Companion;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "^1\d{10}$"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->PHONE_REGEX Lkotlin/text/Regex;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/fragment/TraceFragment;-><init>()V
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->phoneNumber Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$getBinding(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment)com.bytedance.trae.login.databinding.TraeFragmentDouyinBindPhoneInputBinding
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$runOnUiThread(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->runOnUiThread(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static final synthetic access$setPhoneNumber$p(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->phoneNumber Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setSendingCode$p(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->isSendingCode Z
    return-void 
.end method

.method public static final synthetic access$updateSendButton(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->updateSendButton()V
    return-void 
.end method

.method private final digitFilter()android.text.InputFilter
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$$ExternalSyntheticLambda2;
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$$ExternalSyntheticLambda2;-><init>()V
    return-object v0
.end method

.method private static final digitFilter$lambda$1(java.lang.CharSequence  int  int  android.text.Spanned  int  int)java.lang.CharSequence
    .registers 6
    # ins_size=6
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    move v4, v1
    if-ge v4, v2, +016h
    invoke-interface v0, v4, Ljava/lang/CharSequence;->charAt(I)C
    move-result v5
    invoke-static v5, Ljava/lang/Character;->isDigit(C)Z
    move-result v5
    if-eqz v5, +009h
    invoke-interface v0, v4, Ljava/lang/CharSequence;->charAt(I)C
    move-result v5
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    add-int/lit8 v4, v4, 1
    goto -15h
    invoke-virtual v3, Ljava/lang/StringBuilder;->length()I
    move-result v0
    sub-int/2addr v2, v1
    if-ne v0, v2, +004h
    const/4 v0, 0
    goto +7h
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    return-object v0
.end method

.method private final getBinding()com.bytedance.trae.login.databinding.TraeFragmentDouyinBindPhoneInputBinding
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    return-object v0
.end method

.method private final runOnUiThread(kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    new-instance v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, v0, v3, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Landroidx/fragment/app/FragmentActivity; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final runOnUiThread$lambda$2(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  androidx.fragment.app.FragmentActivity  kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->isAdded()Z
    move-result v0
    if-eqz v0, +011h
    invoke-virtual v1, Landroidx/fragment/app/FragmentActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +00bh
    invoke-virtual v1, Landroidx/fragment/app/FragmentActivity;->isDestroyed()Z
    move-result v0
    if-nez v0, +005h
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final sendCode()void
    .registers 18
    # ins_size=1
    move-object/from16 v0, v17
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->phoneNumber Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->PHONE_REGEX Lkotlin/text/Regex;
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Lkotlin/text/Regex;->matches(Ljava/lang/CharSequence;)Z
    move-result v2
    if-nez v2, +011h
    invoke-virtual/range v17, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_phone_invalid I
    const/4 v3, 0
    invoke-static v1, v2, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    return-void 
    iget-boolean v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->isSendingCode Z
    if-eqz v2, +003h
    return-void 
    const/4 v2, 1
    iput-boolean v2, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->isSendingCode Z
    invoke-direct/range v17, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->updateSendButton()V
    sget-object v2, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    invoke-virtual v2, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackDouyinBindPhoneSendCodeClick()V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "douyin_bind_send_code"
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
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v2, Ljava/util/Map;
    const-string v3, "is6Digits"
    const-string v4, "1"
    invoke-interface v2, v3, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppName()Ljava/lang/String;
    move-result-object v3
    const-string v4, "app_name"
    invoke-interface v2, v4, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountAPIV3Impl;->instance()Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;
    invoke-direct v4, v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$sendCode$1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Ljava/lang/String;)V
    check-cast v4, Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;
    const/16 v5, 24
    invoke-interface v3, v1, v5, v2, v4, Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;->sendCode2(Ljava/lang/String; I Ljava/util/Map; Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;)V
    return-void 
.end method

.method private final setupViews()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v0
    if-eqz v0, +01dh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->etPhone Landroid/widget/EditText;
    if-eqz v0, +019h
    const/4 v1, 2
    new-array v1, v1, [Landroid/text/InputFilter;
    const/4 v2, 0
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->digitFilter()Landroid/text/InputFilter;
    move-result-object v3
    aput-object v3, v1, v2
    new-instance v2, Landroid/text/InputFilter$LengthFilter;
    const/16 v3, 11
    invoke-direct v2, v3, Landroid/text/InputFilter$LengthFilter;-><init>(I)V
    const/4 v3, 1
    aput-object v2, v1, v3
    invoke-virtual v0, v1, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v0
    if-eqz v0, +00dh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->etPhone Landroid/widget/EditText;
    if-eqz v0, +009h
    iget-object v1, v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->phoneNumber Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v0
    if-eqz v0, +00fh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->etPhone Landroid/widget/EditText;
    if-eqz v0, +00bh
    iget-object v1, v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->phoneNumber Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/EditText;->setSelection(I)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v0
    if-eqz v0, +010h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->etPhone Landroid/widget/EditText;
    if-eqz v0, +00ch
    new-instance v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$setupViews$1;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$setupViews$1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;)V
    check-cast v1, Landroid/text/TextWatcher;
    invoke-virtual v0, v1, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v0
    if-eqz v0, +00eh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->btnSendCode Landroid/widget/TextView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$$ExternalSyntheticLambda1;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->updateSendButton()V
    return-void 
.end method

.method private static final setupViews$lambda$0(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->sendCode()V
    return-void 
.end method

.method private final updateSendButton()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->phoneNumber Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v0
    const/16 v1, 11
    const/4 v2, 1
    const/4 v3, 0
    if-lt v0, v1, +004h
    move v0, v2
    goto +2h
    move v0, v3
    if-eqz v0, +007h
    iget-boolean v0, v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->isSendingCode Z
    if-nez v0, +003h
    goto +2h
    move v2, v3
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v0
    if-eqz v0, +009h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->btnSendCode Landroid/widget/TextView;
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroid/widget/TextView;->setEnabled(Z)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v0
    if-eqz v0, +018h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->btnSendCode Landroid/widget/TextView;
    if-eqz v0, +014h
    iget-boolean v1, v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->isSendingCode Z
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_sending_code I
    goto +3h
    sget v1, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_get_code I
    invoke-virtual v4, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v0
    if-eqz v0, +01dh
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->btnSendCode Landroid/widget/TextView;
    if-eqz v0, +019h
    invoke-virtual v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    if-nez v2, +00ah
    iget-boolean v2, v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->isSendingCode Z
    if-eqz v2, +003h
    goto +4h
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_disabled I
    goto +3h
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_onaccent I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTextColor(I)V
    invoke-direct v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v0
    if-eqz v0, +010h
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->pbLoading Landroid/widget/ProgressBar;
    if-eqz v0, +00ch
    iget-boolean v1, v4, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->isSendingCode Z
    if-eqz v1, +003h
    goto +3h
    const/16 v3, 8
    invoke-virtual v0, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    return-void 
.end method

.method public autoLogEnterPage()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 4
    # ins_size=4
    const-string v3, "inflater"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    invoke-static v1, v2, v3, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->getBinding()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method public onDestroyView()void
    .registers 2
    # ins_size=1
    invoke-super v1, Lcom/bytedance/trae/common/fragment/TraceFragment;->onDestroyView()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->_binding Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindPhoneInputBinding;
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Lcom/bytedance/trae/common/fragment/TraceFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->setupViews()V
    return-void 
.end method
