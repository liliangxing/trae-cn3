# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "BytecloudLoginActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$Companion;
.field private static final MAIN_ACTIVITY_CLASS:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->Companion Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/appcompat/app/AppCompatActivity;-><init>()V
    return-void 
.end method

.method public static final synthetic access$navigateToMainActivity(com.bytedance.trae.login.bytecloud.BytecloudLoginActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->navigateToMainActivity()V
    return-void 
.end method

.method public static com_bytedance_trae_login_bytecloud_BytecloudLoginActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.login.bytecloud.BytecloudLoginActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->com_bytedance_trae_login_bytecloud_BytecloudLoginActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method private final handleIntent(android.content.Intent)void
    .registers 12
    # ins_size=2
    invoke-virtual v11, Landroid/content/Intent;->getData()Landroid/net/Uri;
    move-result-object v1
    const-string v11, "BytecloudLoginActivity"
    if-nez v1, +00eh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v1, 回调 Intent 无 data URI
    invoke-virtual v0, v11, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->finish()V
    return-void 
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->getRedirectUri()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, toString(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 0
    invoke-static v2, v0, v5, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +01bh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, 非法回调 URI, expected=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v11, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->finish()V
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, 收到 ByteCloud 回调: 
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "://"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v1, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v1, Landroid/net/Uri;->getPath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v11, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    move-object v11, v10
    check-cast v11, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v11, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v11
    check-cast v11, Lkotlinx/coroutines/CoroutineScope;
    const/4 v6, 0
    const/4 v7, 0
    new-instance v8, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;
    const/4 v5, 0
    move-object v0, v8
    move-object v4, v10
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity$handleIntent$1;-><init>(Landroid/net/Uri; J Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity; Lkotlin/coroutines/Continuation;)V
    move-object v0, v8
    check-cast v0, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    move-object v4, v11
    move-object v5, v6
    move-object v6, v7
    move-object v7, v0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final navigateToMainActivity()void
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/content/Intent;
    invoke-direct v0, Landroid/content/Intent;-><init>()V
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    const-string v2, "com.bytedance.trae.home.MainActivity"
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->setClassName(Landroid/content/Context; Ljava/lang/String;)Landroid/content/Intent;
    const v1, 268468224
    invoke-virtual v0, v1, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    const-string v1, "from_login_success"
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->startActivity(Landroid/content/Intent;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->finish()V
    return-void 
.end method

.method public com_bytedance_trae_login_bytecloud_BytecloudLoginActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroidx/appcompat/app/AppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string v0, "getIntent(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->handleIntent(Landroid/content/Intent;)V
    return-void 
.end method

.method protected onNewIntent(android.content.Intent)void
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Landroidx/appcompat/app/AppCompatActivity;->onNewIntent(Landroid/content/Intent;)V
    if-eqz v1, +005h
    invoke-direct v0, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->handleIntent(Landroid/content/Intent;)V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;->com_bytedance_trae_login_bytecloud_BytecloudLoginActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;)V
    return-void 
.end method
