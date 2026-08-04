# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "VerifyCodeViewModel.kt"

.field private static final CODE_LENGTH:I
.field private static final COUNTDOWN_TOTAL_SECONDS:I
.field public static final Companion:Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Companion;
.field private final _clearInputEvent:Landroidx/lifecycle/MutableLiveData;
.field private final _countdownSeconds:Landroidx/lifecycle/MutableLiveData;
.field private final _isResendEnabled:Landroidx/lifecycle/MutableLiveData;
.field private final _loginExtras:Landroidx/lifecycle/MutableLiveData;
.field private final _loginState:Landroidx/lifecycle/MutableLiveData;
.field private final _maskedPhone:Landroidx/lifecycle/MutableLiveData;
.field private final _phoneNumber:Landroidx/lifecycle/MutableLiveData;
.field private final _resendState:Landroidx/lifecycle/MutableLiveData;
.field private final clearInputEvent:Landroidx/lifecycle/LiveData;
.field private final codeDigits:[Ljava/lang/String;
.field private countDownTimer:Landroid/os/CountDownTimer;
.field private final countdownSeconds:Landroidx/lifecycle/LiveData;
.field private final isResendEnabled:Landroidx/lifecycle/LiveData;
.field private final loginState:Landroidx/lifecycle/LiveData;
.field private final maskedPhone:Landroidx/lifecycle/LiveData;
.field private final phoneLogin:Lcom/bytedance/trae/login/PhoneLogin;
.field private final phoneNumber:Landroidx/lifecycle/LiveData;
.field private final resendState:Landroidx/lifecycle/LiveData;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->Companion Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 6
    # ins_size=1
    invoke-direct v5, Landroidx/lifecycle/ViewModel;-><init>()V
    new-instance v0, Lcom/bytedance/trae/login/PhoneLogin;
    invoke-direct v0, Lcom/bytedance/trae/login/PhoneLogin;-><init>()V
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->phoneLogin Lcom/bytedance/trae/login/PhoneLogin;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_phoneNumber Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->phoneNumber Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_maskedPhone Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->maskedPhone Landroidx/lifecycle/LiveData;
    const/4 v0, 6
    new-array v1, v0, [Ljava/lang/String;
    const/4 v2, 0
    move v3, v2
    if-ge v3, v0, +009h
    const-string v4, ""
    aput-object v4, v1, v3
    add-int/lit8 v3, v3, 1
    goto -8h
    iput-object v1, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->codeDigits [Ljava/lang/String;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    const/16 v1, 60
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_countdownSeconds Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->countdownSeconds Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_isResendEnabled Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->isResendEnabled Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_loginState Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->loginState Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_loginExtras Landroidx/lifecycle/MutableLiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_resendState Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->resendState Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_clearInputEvent Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->clearInputEvent Landroidx/lifecycle/LiveData;
    return-void 
.end method

.method public static final synthetic access$clearCodeInput(com.bytedance.trae.login.fragment.VerifyCodeViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->clearCodeInput()V
    return-void 
.end method

.method public static final synthetic access$get_countdownSeconds$p(com.bytedance.trae.login.fragment.VerifyCodeViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_countdownSeconds Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_isResendEnabled$p(com.bytedance.trae.login.fragment.VerifyCodeViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_isResendEnabled Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_loginExtras$p(com.bytedance.trae.login.fragment.VerifyCodeViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_loginExtras Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_loginState$p(com.bytedance.trae.login.fragment.VerifyCodeViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_loginState Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_resendState$p(com.bytedance.trae.login.fragment.VerifyCodeViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_resendState Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$startCountdown(com.bytedance.trae.login.fragment.VerifyCodeViewModel)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->startCountdown()V
    return-void 
.end method

.method private final clearCodeInput()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_clearInputEvent Landroidx/lifecycle/MutableLiveData;
    new-instance v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Event;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-direct v1, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Event;-><init>(Ljava/lang/Object;)V
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private final maskPhoneNumber(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v0
    const/4 v1, 7
    if-ge v0, v1, +003h
    return-object v4
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    const/4 v1, 0
    const/4 v2, 3
    invoke-virtual v4, v1, v2, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, substring(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "****"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v1
    add-int/lit8 v1, v1, -4
    invoke-virtual v4, v1, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method private final startCountdown()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->countDownTimer Landroid/os/CountDownTimer;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/os/CountDownTimer;->cancel()V
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_isResendEnabled Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_countdownSeconds Landroidx/lifecycle/MutableLiveData;
    const/16 v1, 60
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    new-instance v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$startCountdown$1;
    invoke-direct v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$startCountdown$1;-><init>(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)V
    invoke-virtual v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$startCountdown$1;->start()Landroid/os/CountDownTimer;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->countDownTimer Landroid/os/CountDownTimer;
    return-void 
.end method

.method private final submitCode()void
    .registers 14
    # ins_size=1
    iget-object v0, v13, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_loginState Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    instance-of v0, v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Loading;
    if-eqz v0, +003h
    return-void 
    iget-object v0, v13, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_phoneNumber Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Ljava/lang/String;
    if-nez v3, +003h
    return-void 
    iget-object v4, v13, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->codeDigits [Ljava/lang/String;
    const-string v0, ""
    move-object v5, v0
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 62
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lkotlin/collections/ArraysKt;->joinToString$default([Ljava/lang/Object; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v0
    const/4 v1, 6
    if-eq v0, v1, +003h
    return-void 
    iget-object v0, v13, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_loginState Landroidx/lifecycle/MutableLiveData;
    sget-object v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Loading;->INSTANCE Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Loading;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v0, v13, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_isResendEnabled Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v1, v13, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->phoneLogin Lcom/bytedance/trae/login/PhoneLogin;
    sget-object v2, Lcom/bytedance/trae/login/api/LoginPlatform;->PHONE Lcom/bytedance/trae/login/api/LoginPlatform;
    new-instance v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;
    invoke-direct v0, v13, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$submitCode$1;-><init>(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)V
    move-object v5, v0
    check-cast v5, Lcom/bytedance/trae/login/api/IAccountCallback;
    const/4 v6, 0
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/login/PhoneLogin;->doPhoneLogin(Lcom/bytedance/trae/login/api/LoginPlatform; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
.end method

.method public final getClearInputEvent()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->clearInputEvent Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getCountdownSeconds()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->countdownSeconds Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getLoginState()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->loginState Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getMaskedPhone()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->maskedPhone Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getPhoneNumber()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->phoneNumber Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getResendState()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->resendState Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final init(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, phone
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_phoneNumber Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_maskedPhone Landroidx/lifecycle/MutableLiveData;
    invoke-direct v1, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->maskPhoneNumber(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    invoke-direct v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->startCountdown()V
    return-void 
.end method

.method public final isResendEnabled()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->isResendEnabled Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method protected onCleared()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/lifecycle/ViewModel;->onCleared()V
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->countDownTimer Landroid/os/CountDownTimer;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/os/CountDownTimer;->cancel()V
    return-void 
.end method

.method public final onCodeChanged(java.lang.String)void
    .registers 7
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    move v1, v0
    const/4 v2, 6
    if-ge v1, v2, +01ch
    iget-object v2, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->codeDigits [Ljava/lang/String;
    move-object v3, v6
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, v1, Lkotlin/text/StringsKt;->getOrNull(Ljava/lang/CharSequence; I)Ljava/lang/Character;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Character;->toString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    if-nez v3, +004h
    const-string v3, ""
    aput-object v3, v2, v1
    add-int/lit8 v1, v1, 1
    goto -1ch
    iget-object v6, v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->codeDigits [Ljava/lang/String;
    array-length v1, v6
    move v2, v0
    const/4 v3, 1
    if-ge v2, v1, +014h
    aget-object v4, v6, v2
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +003h
    goto +2h
    move v3, v0
    if-nez v3, +003h
    goto +5h
    add-int/lit8 v2, v2, 1
    goto -14h
    move v0, v3
    if-eqz v0, +005h
    invoke-direct v5, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->submitCode()V
    return-void 
.end method

.method public final onDeviceLimitLoginContinue()void
    .registers 5
    # ins_size=1
    const/4 v0, 0
    iget-object v1, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_loginExtras Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v1, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    if-eqz v1, +035h
    iget-object v1, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_loginExtras Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v1, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map;
    const-string v2, "is_new_user"
    if-eqz v1, +00ah
    invoke-interface v1, v2, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v1
    const/4 v3, 1
    if-ne v1, v3, +003h
    goto +2h
    move v3, v0
    if-eqz v3, +01eh
    iget-object v1, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_loginExtras Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v1, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map;
    if-eqz v1, +007h
    invoke-interface v1, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    const-string/jumbo v2, null cannot be cast to non-null type kotlin.Boolean
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/lang/Boolean;
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    sget-object v1, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-virtual v1, v0, Lcom/bytedance/trae/login/service/AccountHelper;->setIsNewUser(Z)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    new-instance v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$onDeviceLimitLoginContinue$1;
    invoke-direct v1, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$onDeviceLimitLoginContinue$1;-><init>(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)V
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const-string/jumbo v2, phone
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->onLoginContinueByDeviceLimit(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Ljava/lang/String;)V
    return-void 
    :try_start_0x1
    :try_start_0x15
.end method

.method public final resendCode()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_isResendEnabled Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    iget-object v0, v8, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_phoneNumber Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/String;
    if-nez v2, +003h
    return-void 
    iget-object v0, v8, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->_resendState Landroidx/lifecycle/MutableLiveData;
    sget-object v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Loading;->INSTANCE Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Loading;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v1, v8, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->phoneLogin Lcom/bytedance/trae/login/PhoneLogin;
    new-instance v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$resendCode$1;
    invoke-direct v0, v8, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$resendCode$1;-><init>(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)V
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/login/IVerificationCodeCallback;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 1
    const/4 v7, 1
    invoke-virtual/range v1 ... v7, Lcom/bytedance/trae/login/PhoneLogin;->sendCode(Ljava/lang/String; Lcom/bytedance/trae/login/IVerificationCodeCallback; Z Ljava/lang/String; Z Z)V
    return-void 
.end method
