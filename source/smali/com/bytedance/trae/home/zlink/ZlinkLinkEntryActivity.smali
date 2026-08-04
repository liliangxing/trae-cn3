# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "ZlinkLinkEntryActivity.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$Companion;
.field public static final EXTRA_PENDING_URI:Ljava/lang/String;
.field public static final EXTRA_SOURCE:Ljava/lang/String;
.field private static final HOST_CONVERSATION:Ljava/lang/String;
.field private static final HOST_WEBVIEW:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static bridge lastRoutedScheme:Ljava/lang/String;
.field private static lastRoutedTime:J


.method public static synthetic $r8$lambda$PHtRBWqDZneU-NfdSaEsvFIgfkw(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity  android.net.Uri  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->resolveAppLinkRedirect$lambda$5(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Landroid/net/Uri; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Pzlwbuy5xI8hvFAyjbp_zniVGUE(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity  android.net.Uri  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->resolveAppLinkRedirect$lambda$5$lambda$2(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Landroid/net/Uri; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$odiRzaxS7-fzsoJSc4TcTm-k1Qc(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity  android.net.Uri  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->resolveAppLinkRedirect$lambda$5$lambda$3(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Landroid/net/Uri; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xg8diSKfSIKWRtpDm0pdZkppnPs(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity  android.net.Uri  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->resolveAppLinkRedirect$lambda$5$lambda$4(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Landroid/net/Uri; Ljava/lang/String;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->Companion Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/appcompat/app/AppCompatActivity;-><init>()V
    return-void 
.end method

.method public static com_bytedance_trae_home_zlink_ZlinkLinkEntryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->com_bytedance_trae_home_zlink_ZlinkLinkEntryActivity__onStop$___twin___()V
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

.method private final ensureMainActivityInStack(android.net.Uri)boolean
    .registers 7
    # ins_size=2
    const-class v0, Landroid/app/ActivityManager;
    invoke-virtual v5, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->getSystemService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/app/ActivityManager;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +04ah
    invoke-virtual v0, Landroid/app/ActivityManager;->getAppTasks()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +044h
    check-cast v0, Ljava/lang/Iterable;
    instance-of v3, v0, Ljava/util/Collection;
    if-eqz v3, +00dh
    move-object v3, v0
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +004h
    move v0, v2
    goto +2eh
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, -00ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Landroid/app/ActivityManager$AppTask;
    invoke-virtual v3, Landroid/app/ActivityManager$AppTask;->getTaskInfo()Landroid/app/ActivityManager$RecentTaskInfo;
    move-result-object v3
    if-eqz v3, +00bh
    iget-object v3, v3, Landroid/app/ActivityManager$RecentTaskInfo;->baseActivity Landroid/content/ComponentName;
    if-eqz v3, +007h
    invoke-virtual v3, Landroid/content/ComponentName;->getClassName()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    const-class v4, Lcom/bytedance/trae/home/MainActivity;
    invoke-virtual v4, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -026h
    move v0, v1
    if-ne v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    return v1
    new-instance v0, Landroid/content/Intent;
    move-object v1, v5
    check-cast v1, Landroid/content/Context;
    const-class v3, Lcom/bytedance/trae/home/MainActivity;
    invoke-direct v0, v1, v3, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const/high16 v1, 268500992
    invoke-virtual v0, v1, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v0, v6, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    invoke-virtual v5, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->startActivity(Landroid/content/Intent;)V
    return v2
.end method

.method static synthetic ensureMainActivityInStack$default(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity  android.net.Uri  int  java.lang.Object)boolean
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->ensureMainActivityInStack(Landroid/net/Uri;)Z
    move-result v0
    return v0
.end method

.method private final extractSchemeParam(java.lang.String)java.lang.String
    .registers 6
    # ins_size=2
    const/4 v0, 0
    invoke-static v5, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v5
    const-string/jumbo v1, scheme
    invoke-virtual v5, v1, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    const/4 v1, 1
    if-nez v1, +023h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    sget-object v3, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkConfig;
    invoke-virtual v3, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->getSCHEME()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, "://"
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const/4 v3, 2
    invoke-static v5, v1, v2, v3, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v0, v5
    return-object v0
    :try_start_0x1
.end method

.method private final fallbackToMain(android.net.Uri  java.lang.String)void
    .registers 6
    # ins_size=3
    new-instance v0, Landroid/content/Intent;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/home/MainActivity;
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-virtual v0, v4, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    const-string v4, "extra_zlink_source"
    invoke-virtual v0, v4, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private final followRedirectToScheme(java.lang.String)java.lang.String
    .registers 8
    # ins_size=2
    const/4 v0, 0
    move v1, v0
    const/4 v2, 0
    const/16 v3, 10
    if-ge v1, v3, +07ch
    new-instance v3, Ljava/net/URL;
    invoke-direct v3, v7, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;
    move-result-object v7
    const-string v3, "null cannot be cast to non-null type java.net.HttpURLConnection"
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Ljava/net/HttpURLConnection;
    invoke-virtual v7, v0, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V
    const/16 v3, 5000
    invoke-virtual v7, v3, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V
    invoke-virtual v7, v3, Ljava/net/HttpURLConnection;->setReadTimeout(I)V
    const-string v3, "GET"
    invoke-virtual v7, v3, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V
    invoke-virtual v7, Ljava/net/HttpURLConnection;->getResponseCode()I
    move-result v3
    const/16 v4, 300
    const/4 v5, 1
    if-gt v4, v3, +008h
    const/16 v4, 400
    if-ge v3, v4, +004h
    move v3, v5
    goto +2h
    move v3, v0
    if-eqz v3, +041h
    const-string v3, "Location"
    invoke-virtual v7, v3, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00ah
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +2h
    move v5, v0
    if-eqz v5, +006h
    invoke-virtual v7, Ljava/net/HttpURLConnection;->disconnect()V
    return-object v2
    const-string v4, "http://"
    const/4 v5, 2
    invoke-static v3, v4, v0, v5, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +00eh
    const-string v4, "https://"
    invoke-static v3, v4, v0, v5, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +006h
    invoke-virtual v7, Ljava/net/HttpURLConnection;->disconnect()V
    return-object v3
    invoke-direct v6, v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->extractSchemeParam(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +006h
    invoke-virtual v7, Ljava/net/HttpURLConnection;->disconnect()V
    return-object v2
    add-int/lit8 v1, v1, 1
    invoke-virtual v7, Ljava/net/HttpURLConnection;->disconnect()V
    move-object v7, v3
    goto -75h
    invoke-virtual v7, Ljava/net/HttpURLConnection;->disconnect()V
    return-object v2
    move-exception v0
    invoke-virtual v7, Ljava/net/HttpURLConnection;->disconnect()V
    throw v0
    return-object v2
    :try_start_0x17
    :try_start_0x52
    :try_start_0x67
.end method

.method private final handleConversation(android.net.Uri)boolean
    .registers 11
    # ins_size=2
    const/4 v0, 1
    const/4 v1, 0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v9
    check-cast v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v2
    const-class v3, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v2, v3, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v2, +00ah
    invoke-interface v2, Lcom/bytedance/trae/login/api/ILoginService;->isTraeLoggedIn()Z
    move-result v2
    if-ne v2, v0, +004h
    move v2, v0
    goto +2h
    move v2, v1
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    move-object v2, v3
    check-cast v2, Ljava/lang/Boolean;
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    if-nez v2, +009h
    const-string/jumbo v0, scheme
    invoke-direct v9, v10, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->fallbackToMain(Landroid/net/Uri; Ljava/lang/String;)V
    return v1
    const-string v2, "conversation_id"
    invoke-virtual v10, v2, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v9, v10, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->ensureMainActivityInStack(Landroid/net/Uri;)Z
    move-result v10
    if-nez v10, +003h
    return v1
    move-object v10, v9
    check-cast v10, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v10, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v10
    move-object v3, v10
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v10, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;
    const/4 v1, 0
    invoke-direct v10, v9, v2, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$handleConversation$1;-><init>(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v10
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return v0
    :try_start_0x2
.end method

.method private final handleIntent(android.content.Intent)void
    .registers 6
    # ins_size=2
    if-eqz v5, +007h
    invoke-virtual v5, Landroid/content/Intent;->getData()Landroid/net/Uri;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-nez v5, +006h
    invoke-virtual v4, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->finish()V
    return-void 
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    const-string v1, "ZlinkLinkEntry"
    if-nez v0, +021h
    const-string v0, "Privacy not agreed, redirect to MainActivity"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    new-instance v0, Landroid/content/Intent;
    move-object v1, v4
    check-cast v1, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/home/MainActivity;
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v1, "extra_pending_uri"
    invoke-virtual v5, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v1, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v4, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->startActivity(Landroid/content/Intent;)V
    invoke-virtual v4, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->finish()V
    return-void 
    const/4 v0, 0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v2
    const-class v3, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v2, v3, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v2, +00ah
    invoke-interface v2, Lcom/bytedance/trae/login/api/ILoginService;->isTraeLoggedIn()Z
    move-result v2
    const/4 v3, 1
    if-ne v2, v3, +003h
    goto +2h
    move v3, v0
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    move-object v2, v0
    check-cast v2, Ljava/lang/Boolean;
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    if-nez v0, +010h
    const-string v0, "User not logged in, redirect to MainActivity for login"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    const-string v0, "not_logged_in"
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->fallbackToMain(Landroid/net/Uri; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->finish()V
    return-void 
    invoke-direct v4, v5, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->handleLink(Landroid/net/Uri;)V
    return-void 
    :try_start_0x38
.end method

.method private final handleLink(android.net.Uri)void
    .registers 5
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    if-eqz v0, +00ah
    const-string v1, "extra_zlink_source"
    invoke-virtual v0, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, source
    invoke-virtual v4, v0, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    move v1, v2
    if-nez v1, +003h
    goto +34h
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkConfig;
    invoke-virtual v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->getSCHEME()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, scheme
    goto +20h
    invoke-virtual v4, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v0
    const-string v1, "https"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +013h
    invoke-virtual v4, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v0
    const-string v1, "http"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +5h
    const-string/jumbo v0, unknown
    goto +3h
    const-string v0, "applink"
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "handleLink, source="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", uri="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "ZlinkLinkEntry"
    invoke-static v2, v1, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    invoke-direct v3, v4, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->isZlinkAppLink(Landroid/net/Uri;)Z
    move-result v1
    const-string/jumbo v2, toString(...)
    if-eqz v1, +031h
    sget-object v1, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    invoke-virtual v1, v0, v4, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->reportFromUri(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v4, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->extractSchemeParam(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +01bh
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v4
    invoke-direct v3, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->markRouted(Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    invoke-virtual v2, v1, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->reportFromSchema(Ljava/lang/String;)V
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->routeByHost(Landroid/net/Uri; Ljava/lang/String;)Z
    move-result v4
    if-nez v4, +005h
    invoke-virtual v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->finish()V
    return-void 
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->resolveAppLinkRedirect(Landroid/net/Uri; Ljava/lang/String;)V
    return-void 
    invoke-virtual v4, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->isAlreadyRouted(Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +006h
    invoke-virtual v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->finish()V
    return-void 
    invoke-virtual v4, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->markRouted(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    invoke-virtual v1, v0, v4, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->reportFromUri(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->routeByHost(Landroid/net/Uri; Ljava/lang/String;)Z
    move-result v4
    if-nez v4, +005h
    invoke-virtual v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->finish()V
    return-void 
.end method

.method private final handleWebView(android.net.Uri)void
    .registers 10
    # ins_size=2
    const-string/jumbo v0, url
    invoke-virtual v9, v0, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    const-string/jumbo v2, scheme
    if-eqz v0, +006h
    invoke-direct v8, v9, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->fallbackToMain(Landroid/net/Uri; Ljava/lang/String;)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;->INSTANCE Lcom/bytedance/trae/utils/TrustedDomainUtils;
    invoke-virtual v0, v3, Lcom/bytedance/trae/utils/TrustedDomainUtils;->isTrustedUrl(Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +01ah
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "handleWebView blocked untrusted url: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "ZlinkLinkEntry"
    invoke-static v1, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    invoke-direct v8, v9, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->fallbackToMain(Landroid/net/Uri; Ljava/lang/String;)V
    return-void 
    const/4 v0, 0
    invoke-static v8, v0, v1, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->ensureMainActivityInStack$default(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Landroid/net/Uri; I Ljava/lang/Object;)Z
    const-string/jumbo v0, share_url
    invoke-virtual v9, v0, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    const-string v0, "post_url"
    invoke-virtual v9, v0, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    sget-object v1, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->Companion Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;
    move-object v2, v8
    check-cast v2, Landroid/content/Context;
    const-string v4, ""
    const-string v7, "outside"
    invoke-virtual/range v1 ... v7, Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final isAlreadyRouted(java.lang.String)boolean
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->lastRoutedScheme Ljava/lang/String;
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +011h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sget-wide v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->lastRoutedTime J
    sub-long/2addr v0, v2
    const-wide/16 v2, 3000
    cmp-long v5, v0, v2
    if-gez v5, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    return v5
.end method

.method private final isZlinkAppLink(android.net.Uri)boolean
    .registers 6
    # ins_size=2
    invoke-virtual v5, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +059h
    sget-object v2, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v2, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v2, toLowerCase(...)
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v0, +003h
    goto +49h
    const-string v3, "https"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +00bh
    const-string v3, "http"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return v1
    invoke-virtual v5, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +033h
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v5, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v5, +003h
    goto +26h
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkConfig;
    invoke-virtual v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->getAPPLINK_HOST()Ljava/lang/String;
    move-result-object v0
    sget-object v3, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v3, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    const/4 v3, 1
    if-lez v2, +004h
    move v2, v3
    goto +2h
    move v2, v1
    if-eqz v2, +009h
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    move v1, v3
    return v1
.end method

.method private final markRouted(java.lang.String)void
    .registers 4
    # ins_size=2
    sput-object v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->lastRoutedScheme Ljava/lang/String;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sput-wide v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->lastRoutedTime J
    return-void 
.end method

.method private final resolveAppLinkRedirect(android.net.Uri  java.lang.String)void
    .registers 11
    # ins_size=3
    const/4 v0, 0
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    new-instance v5, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda3;
    invoke-direct v5, v8, v9, v10, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Landroid/net/Uri; Ljava/lang/String;)V
    const/16 v6, 31
    const/4 v7, 0
    invoke-static/range v0 ... v7, Lkotlin/concurrent/ThreadsKt;->thread$default(Z Z Ljava/lang/ClassLoader; Ljava/lang/String; I Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Ljava/lang/Thread;
    return-void 
.end method

.method private static final resolveAppLinkRedirect$lambda$5(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity  android.net.Uri  java.lang.String)kotlin.Unit
    .registers 7
    # ins_size=3
    const-string v0, "ZlinkLinkEntry"
    invoke-virtual v5, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toString(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->followRedirectToScheme(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +014h
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;
    invoke-virtual v3, v1, Lcom/bytedance/trae/home/zlink/ZlinkLaunchLog;->reportFromSchema(Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda0;
    invoke-direct v1, v4, v2, v6, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Landroid/net/Uri; Ljava/lang/String;)V
    invoke-virtual v4, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    goto +20h
    const-string v1, "Could not resolve AppLink redirect, fallback to main"
    invoke-static v0, v1, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    new-instance v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda1;
    invoke-direct v1, v4, v5, v6, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Landroid/net/Uri; Ljava/lang/String;)V
    invoke-virtual v4, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    goto +12h
    move-exception v1
    const-string/jumbo v2, resolveAppLinkRedirect failed
    check-cast v1, Ljava/lang/Throwable;
    invoke-static v0, v2, v1, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    new-instance v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda2;
    invoke-direct v0, v4, v5, v6, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity; Landroid/net/Uri; Ljava/lang/String;)V
    invoke-virtual v4, v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    :try_start_0x2
.end method

.method private static final resolveAppLinkRedirect$lambda$5$lambda$2(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity  android.net.Uri  java.lang.String)void
    .registers 4
    # ins_size=3
    invoke-virtual v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +014h
    invoke-virtual v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->isDestroyed()Z
    move-result v0
    if-nez v0, +00eh
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->routeByHost(Landroid/net/Uri; Ljava/lang/String;)Z
    move-result v2
    if-nez v2, +005h
    invoke-virtual v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->finish()V
    return-void 
.end method

.method private static final resolveAppLinkRedirect$lambda$5$lambda$3(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity  android.net.Uri  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->fallbackToMain(Landroid/net/Uri; Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->finish()V
    return-void 
.end method

.method private static final resolveAppLinkRedirect$lambda$5$lambda$4(com.bytedance.trae.home.zlink.ZlinkLinkEntryActivity  android.net.Uri  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->fallbackToMain(Landroid/net/Uri; Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->finish()V
    return-void 
.end method

.method private final routeByHost(android.net.Uri  java.lang.String)boolean
    .registers 6
    # ins_size=3
    invoke-virtual v4, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, webview
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    const/4 v2, 0
    if-eqz v1, +006h
    invoke-direct v3, v4, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->handleWebView(Landroid/net/Uri;)V
    goto +11h
    const-string v1, "conversation"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +007h
    invoke-direct v3, v4, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->handleConversation(Landroid/net/Uri;)Z
    move-result v2
    goto +4h
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->fallbackToMain(Landroid/net/Uri; Ljava/lang/String;)V
    return v2
.end method

.method public com_bytedance_trae_home_zlink_ZlinkLinkEntryActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroidx/appcompat/app/AppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->handleIntent(Landroid/content/Intent;)V
    return-void 
.end method

.method protected onNewIntent(android.content.Intent)void
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Landroidx/appcompat/app/AppCompatActivity;->onNewIntent(Landroid/content/Intent;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->setIntent(Landroid/content/Intent;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->handleIntent(Landroid/content/Intent;)V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;->com_bytedance_trae_home_zlink_ZlinkLinkEntryActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;)V
    return-void 
.end method
