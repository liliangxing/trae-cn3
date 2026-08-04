# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BytecloudLoginActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callbackStartTime:J
.field final synthetic $uri:Landroid/net/Uri;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;


.method constructor <init>(android.net.Uri  long  com.bytedance.trae.login.bytecloud.BytecloudLoginActivity  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->$uri Landroid/net/Uri;
    iput-wide v2, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->$callbackStartTime J
    iput-object v4, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->this$0 Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;
    iget-object v1, v6, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->$uri Landroid/net/Uri;
    iget-wide v2, v6, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->$callbackStartTime J
    iget-object v4, v6, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->this$0 Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;-><init>(Landroid/net/Uri; J Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 23
    # ins_size=2
    move-object/from16 v0, v21
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->label I
    const/4 v3, 1
    if-eqz v2, +012h
    if-ne v2, v3, +008h
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v22
    goto +1ch
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    iget-object v4, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->$uri Landroid/net/Uri;
    move-object v5, v0
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v3, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->label I
    invoke-virtual v2, v4, v5, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->handleCallback(Landroid/net/Uri; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    iget-wide v5, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->$callbackStartTime J
    sub-long/2addr v3, v5
    instance-of v1, v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Success;
    const-string v5, "BytecloudLoginActivity"
    if-eqz v1, +049h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "ByteCloud 回调校验通过，先完成主登录，再异步补齐 Passport 身份"
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v7, "login_success"
    const-string v8, "bytecloud"
    invoke-static v3, v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v9
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 2040
    const/16 v19, 0
    invoke-static/range v6 ... v19, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/login/service/AccountStatusManager;->INSTANCE Lcom/bytedance/trae/login/service/AccountStatusManager;
    sget-object v2, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    const-string v3, "bytecloud_login"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/login/service/AccountStatusManager;->loginStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtToken()Ljava/lang/String;
    move-result-object v1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    sget-object v4, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;
    new-instance v5, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1$1;
    invoke-direct v5, v2, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1$1;-><init>(J)V
    check-cast v5, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$Callback;
    invoke-virtual v4, v1, v5, Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin;->login(Ljava/lang/String; Lcom/bytedance/trae/login/bytecloud/BytecloudPassportLogin$Callback;)V
    iget-object v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->this$0 Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;
    invoke-static v1, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->access$navigateToMainActivity(Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;)V
    goto +5ah
    instance-of v1, v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;
    if-eqz v1, +05ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "ByteCloud 回调被拒绝: "
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;
    invoke-virtual v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;->getReason()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v5, v6, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v8, passport_fail
    const-string v9, "bytecloud"
    invoke-static v3, v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v10
    const-string v11, "callback_security_check"
    const/4 v12, 0
    invoke-virtual v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;->getReason()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 2000
    const/16 v20, 0
    invoke-static/range v7 ... v20, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->this$0 Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;
    move-object v2, v1
    check-cast v2, Landroid/content/Context;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_login_error_failed I
    invoke-virtual v1, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v3, 0
    invoke-static v2, v1, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    iget-object v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;->this$0 Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;
    invoke-virtual v1, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->finish()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method
