# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "PhoneLoginViewModel.kt"

.field private final _isAgreementChecked:Landroidx/lifecycle/MutableLiveData;
.field private final _isButtonEnabled:Landroidx/lifecycle/MutableLiveData;
.field private final _isPhoneValid:Landroidx/lifecycle/MutableLiveData;
.field private final _phoneNumber:Landroidx/lifecycle/MutableLiveData;
.field private final _sendCodeState:Landroidx/lifecycle/MutableLiveData;
.field private final isAgreementChecked:Landroidx/lifecycle/LiveData;
.field private final isButtonEnabled:Landroidx/lifecycle/LiveData;
.field private final isPhoneValid:Landroidx/lifecycle/LiveData;
.field private final phoneLogin:Lcom/bytedance/trae/login/PhoneLogin;
.field private final phoneNumber:Landroidx/lifecycle/LiveData;
.field private final phoneRegex:Lkotlin/text/Regex;
.field private final sendCodeState:Landroidx/lifecycle/LiveData;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Landroidx/lifecycle/ViewModel;-><init>()V
    new-instance v0, Lcom/bytedance/trae/login/PhoneLogin;
    invoke-direct v0, Lcom/bytedance/trae/login/PhoneLogin;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->phoneLogin Lcom/bytedance/trae/login/PhoneLogin;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "^1\d{10}$"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->phoneRegex Lkotlin/text/Regex;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_phoneNumber Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->phoneNumber Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_isPhoneValid Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->isPhoneValid Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_isAgreementChecked Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->isAgreementChecked Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_sendCodeState Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->sendCodeState Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_isButtonEnabled Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->isButtonEnabled Landroidx/lifecycle/LiveData;
    return-void 
.end method

.method public static final synthetic access$get_sendCodeState$p(com.bytedance.trae.login.fragment.PhoneLoginViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_sendCodeState Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method private final updateButtonState()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_isButtonEnabled Landroidx/lifecycle/MutableLiveData;
    iget-object v1, v3, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_isPhoneValid Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v1, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    const/4 v2, 1
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final getPhoneNumber()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->phoneNumber Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getSendCodeState()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->sendCodeState Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final isAgreementChecked()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->isAgreementChecked Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final isButtonEnabled()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->isButtonEnabled Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final isPhoneValid()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->isPhoneValid Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final onAgreementCheckedChanged(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_isAgreementChecked Landroidx/lifecycle/MutableLiveData;
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->updateButtonState()V
    return-void 
.end method

.method public final onPhoneNumberChanged(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, phone
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_phoneNumber Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v3, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_isPhoneValid Landroidx/lifecycle/MutableLiveData;
    iget-object v1, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->phoneRegex Lkotlin/text/Regex;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v1, v3, Lkotlin/text/Regex;->matches(Ljava/lang/CharSequence;)Z
    move-result v3
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-virtual v0, v3, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    invoke-direct v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->updateButtonState()V
    return-void 
.end method

.method public final sendVerificationCode()void
    .registers 19
    # ins_size=1
    move-object/from16 v0, v18
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_phoneNumber Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v1, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Ljava/lang/String;
    if-nez v3, +003h
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_isButtonEnabled Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v1, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    const/4 v2, 1
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->_sendCodeState Landroidx/lifecycle/MutableLiveData;
    sget-object v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Loading;->INSTANCE Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Loading;
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v5, "login_method_selected"
    const-string/jumbo v6, phone
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 2044
    const/16 v17, 0
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->phoneLogin Lcom/bytedance/trae/login/PhoneLogin;
    new-instance v1, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$sendVerificationCode$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$sendVerificationCode$1;-><init>(Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;)V
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/login/IVerificationCodeCallback;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 1
    const/4 v8, 1
    invoke-virtual/range v2 ... v8, Lcom/bytedance/trae/login/PhoneLogin;->sendCode(Ljava/lang/String; Lcom/bytedance/trae/login/IVerificationCodeCallback; Z Ljava/lang/String; Z Z)V
    return-void 
.end method
