# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;
.super Ljava/lang/Object;
.source "BDTuringAccount.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;
.field private static final appInfoProvider:Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$appInfoProvider$1;
.field private static final loginVerifyDepend:Lcom/bytedance/bdturing/loginverify/ILoginVerifyDepend;
.field private static final ucTwiceVerifyDepend:Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyDepend;


.method public static synthetic $r8$lambda$1rXCQeHY8JDq8ERGXLo22Wvyzhs()android.app.Activity
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->init$lambda$1()Landroid/app/Activity;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Z1saeet7LvmeH7R9wJuKNCmShTg(org.json.JSONObject  com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyResultCallback)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->ucTwiceVerifyDepend$lambda$4(Lorg/json/JSONObject; Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyResultCallback;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$nOcmpinAh5YEH86p7YM5Iipv_-A(java.lang.String  org.json.JSONObject)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->init$lambda$0(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$r_IiIZzdFTg1liOXssDASgj-MXg(android.app.Activity  org.json.JSONObject  com.bytedance.bdturing.loginverify.LoginVerifyCallBack)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->loginVerifyDepend$lambda$3(Landroid/app/Activity; Lorg/json/JSONObject; Lcom/bytedance/bdturing/loginverify/LoginVerifyCallBack;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;
    invoke-direct v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->INSTANCE Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;
    new-instance v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$$ExternalSyntheticLambda0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->loginVerifyDepend Lcom/bytedance/bdturing/loginverify/ILoginVerifyDepend;
    new-instance v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$$ExternalSyntheticLambda1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->ucTwiceVerifyDepend Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyDepend;
    new-instance v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$appInfoProvider$1;
    invoke-direct v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$appInfoProvider$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->appInfoProvider Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$appInfoProvider$1;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final init$lambda$0(java.lang.String  org.json.JSONObject)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method private static final init$lambda$1()android.app.Activity
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/sdk/account/utils/ActivityStack;->getTopActivity()Landroid/app/Activity;
    move-result-object v0
    return-object v0
.end method

.method private static final loginVerifyDepend$lambda$3(android.app.Activity  org.json.JSONObject  com.bytedance.bdturing.loginverify.LoginVerifyCallBack)void
    .registers 4
    # ins_size=3
    const-string v0, "<unused var>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "data"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "callBack"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v0, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    if-nez v1, +004h
    const-string v1, ""
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +006h
    invoke-interface v3, v1, Lcom/bytedance/bdturing/loginverify/LoginVerifyCallBack;->onSuccess(Ljava/lang/String;)V
    goto +eh
    const-string v1, "reason"
    const-string v0, "bdturing login fail"
    invoke-virtual v2, v1, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v1, -1
    invoke-interface v3, v1, v2, Lcom/bytedance/bdturing/loginverify/LoginVerifyCallBack;->onFail(I Lorg/json/JSONObject;)V
    return-void 
.end method

.method private static final ucTwiceVerifyDepend$lambda$4(org.json.JSONObject  com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyResultCallback)boolean
    .registers 4
    # ins_size=2
    invoke-static Lcom/bytedance/sdk/account/twiceverify/TwiceVerifyManager;->getInstance()Lcom/bytedance/sdk/account/twiceverify/TwiceVerifyManager;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$ucTwiceVerifyDepend$1$1;
    invoke-direct v1, v3, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$ucTwiceVerifyDepend$1$1;-><init>(Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyResultCallback;)V
    check-cast v1, Lcom/bytedance/sdk/account/twiceverify/TwiceVerifyResultCallback;
    invoke-virtual v0, v2, v1, Lcom/bytedance/sdk/account/twiceverify/TwiceVerifyManager;->startTwiceVerify(Lorg/json/JSONObject; Lcom/bytedance/sdk/account/twiceverify/TwiceVerifyResultCallback;)Z
    move-result v2
    return v2
.end method

.method public final init()void
    .registers 3
    # ins_size=1
    new-instance v0, Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    invoke-direct v0, Lcom/bytedance/bdturing/BdTuringConfig$Builder;-><init>()V
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v1
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->appId(Ljava/lang/String;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->appVersionCode(Ljava/lang/String;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->appName(Ljava/lang/String;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v1, Lcom/bytedance/trae/utils/AppLocaleUtils;->getAppLocale()Ljava/util/Locale;
    move-result-object v1
    invoke-virtual v1, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->language(Ljava/lang/String;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$$ExternalSyntheticLambda2;
    invoke-direct v1, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$$ExternalSyntheticLambda2;-><init>()V
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->eventClient(Lcom/bytedance/bdturing/EventClient;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->appVersion(Ljava/lang/String;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->channel(Ljava/lang/String;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/init/task/bdturing/DefaultTwiceVerifyDepend;
    invoke-direct v1, Lcom/bytedance/trae/init/task/bdturing/DefaultTwiceVerifyDepend;-><init>()V
    check-cast v1, Lcom/bytedance/bdturing/twiceverify/TwiceVerifyDepend;
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->twiceVerifyDepend(Lcom/bytedance/bdturing/twiceverify/TwiceVerifyDepend;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    const/4 v1, 6
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->smsDigits(I)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->appInfoProvider Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$appInfoProvider$1;
    check-cast v1, Lcom/bytedance/bdturing/AppInfoProvider;
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->appInfoProvider(Lcom/bytedance/bdturing/AppInfoProvider;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$$ExternalSyntheticLambda3;
    invoke-direct v1, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$$ExternalSyntheticLambda3;-><init>()V
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->bdTuringDepend(Lcom/bytedance/bdturing/IBdTuringDepend;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->ucTwiceVerifyDepend Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyDepend;
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->ucTwiceVerifyDepend(Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyDepend;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->loginVerifyDepend Lcom/bytedance/bdturing/loginverify/ILoginVerifyDepend;
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->loginVerifyDepend(Lcom/bytedance/bdturing/loginverify/ILoginVerifyDepend;)Lcom/bytedance/bdturing/BdTuringConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, Lcom/bytedance/bdturing/BdTuringConfig$Builder;->build(Landroid/content/Context;)Lcom/bytedance/bdturing/BdTuringConfig;
    move-result-object v0
    invoke-static Lcom/bytedance/bdturing/BdTuring;->getInstance()Lcom/bytedance/bdturing/BdTuring;
    move-result-object v1
    invoke-virtual v1, v0, Lcom/bytedance/bdturing/BdTuring;->init(Lcom/bytedance/bdturing/BdTuringConfig;)Lcom/bytedance/bdturing/BdTuring;
    return-void 
.end method
