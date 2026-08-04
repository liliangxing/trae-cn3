# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/account/TTAccountConfig;
.super Lcom/ss/android/AbsTTAccountConfig;
.source "TTAccountConfig.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/account/TTAccountConfig$Companion;
.field private static final TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$AY2l3qkLGBZV1rHhib2tQqRyIBo(android.content.Context)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/account/TTAccountConfig;->getISec$lambda$0(Landroid/content/Context;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/account/TTAccountConfig$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/account/TTAccountConfig$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/account/TTAccountConfig;->Companion Lcom/bytedance/trae/account/TTAccountConfig$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/ss/android/AbsTTAccountConfig;-><init>()V
    return-void 
.end method

.method private static final getISec$lambda$0(android.content.Context)boolean
    .registers 1
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public getApplicationContext()android.content.Context
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    return-object v0
.end method

.method public getIBdTruing()com.ss.android.account.dbtring.IBdTruing
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/account/TTAccountConfig$getIBdTruing$1;
    invoke-direct v0, Lcom/bytedance/trae/account/TTAccountConfig$getIBdTruing$1;-><init>()V
    check-cast v0, Lcom/ss/android/account/dbtring/IBdTruing;
    return-object v0
.end method

.method public getISec()com.ss.android.account.sec.IAccountSec
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/account/TTAccountConfig$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/account/TTAccountConfig$$ExternalSyntheticLambda0;-><init>()V
    return-object v0
.end method

.method public getMonitor()com.bytedance.sdk.account.utils.IMonitor
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/ss/android/account/adapter/MonitorAdapter;
    invoke-direct v0, Lcom/ss/android/account/adapter/MonitorAdapter;-><init>()V
    check-cast v0, Lcom/bytedance/sdk/account/utils/IMonitor;
    return-object v0
.end method

.method public getNetwork()com.bytedance.sdk.account.INetWork
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/ss/android/account/adapter/NetworkAdapter;
    invoke-direct v0, Lcom/ss/android/account/adapter/NetworkAdapter;-><init>()V
    check-cast v0, Lcom/bytedance/sdk/account/INetWork;
    return-object v0
.end method

.method public host()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->PASSPORT Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getHost(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public isLocalTest()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public isSaveLoginInfo()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public isSupportMultiLogin()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method
