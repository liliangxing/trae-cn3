# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "OneClickLoginViewModel.kt"

.field private final _isAgreementChecked:Landroidx/lifecycle/MutableLiveData;
.field private final _isButtonEnabled:Landroidx/lifecycle/MutableLiveData;
.field private final _loginState:Landroidx/lifecycle/MutableLiveData;
.field private final _maskedPhone:Landroidx/lifecycle/MutableLiveData;
.field private final isAgreementChecked:Landroidx/lifecycle/LiveData;
.field private final isButtonEnabled:Landroidx/lifecycle/LiveData;
.field private final loginState:Landroidx/lifecycle/LiveData;
.field private final maskedPhone:Landroidx/lifecycle/LiveData;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Landroidx/lifecycle/ViewModel;-><init>()V
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_maskedPhone Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->maskedPhone Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_isAgreementChecked Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->isAgreementChecked Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_isButtonEnabled Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->isButtonEnabled Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_loginState Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->loginState Landroidx/lifecycle/LiveData;
    return-void 
.end method

.method private final updateButtonState()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_isButtonEnabled Landroidx/lifecycle/MutableLiveData;
    iget-object v1, v3, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_isAgreementChecked Landroidx/lifecycle/MutableLiveData;
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

.method public final getLoginState()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->loginState Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getMaskedPhone()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->maskedPhone Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final init(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "maskedPhone"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_maskedPhone Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->updateButtonState()V
    return-void 
.end method

.method public final isAgreementChecked()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->isAgreementChecked Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final isButtonEnabled()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->isButtonEnabled Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final onAgreementCheckedChanged(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_isAgreementChecked Landroidx/lifecycle/MutableLiveData;
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->updateButtonState()V
    return-void 
.end method

.method public final onDeviceLimitLoginContinue()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_isButtonEnabled Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_loginState Landroidx/lifecycle/MutableLiveData;
    sget-object v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Loading;->INSTANCE Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Loading;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final onLoginResult(boolean  java.lang.Integer  java.lang.String)void
    .registers 5
    # ins_size=4
    if-eqz v2, +00ah
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_loginState Landroidx/lifecycle/MutableLiveData;
    sget-object v3, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Success;->INSTANCE Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Success;
    invoke-virtual v2, v3, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +13h
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_loginState Landroidx/lifecycle/MutableLiveData;
    new-instance v0, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Error;
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    goto +2h
    const/4 v3, -1
    invoke-direct v0, v3, v4, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Error;-><init>(I Ljava/lang/String;)V
    invoke-virtual v2, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final onOneClickLogin()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_isButtonEnabled Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_loginState Landroidx/lifecycle/MutableLiveData;
    sget-object v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Loading;->INSTANCE Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Loading;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final resetToIdle()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;->_loginState Landroidx/lifecycle/MutableLiveData;
    sget-object v1, Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Idle;->INSTANCE Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Idle;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method
