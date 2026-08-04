# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;
.super Ljava/lang/Object;
.source "KmpHostEnvironment.android.kt"

.implements Lcom/bytedance/trae/kmp/host/KmpHostInfo;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;
.field private static hostInfo:Lcom/bytedance/trae/kmp/host/KmpHostInfo;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;
    invoke-direct v0, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final requireHostInfo()com.bytedance.trae.kmp.host.KmpHostInfo
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    if-eqz v0, +003h
    return-object v0
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "KmpHostEnvironment must be configured by host before use."
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public final configure(com.bytedance.trae.kmp.host.KmpHostInfo)void
    .registers 3
    # ins_size=2
    const-string v0, "hostInfo"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    return-void 
.end method

.method public getAiRegion()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getAiRegion()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getAppVersionName()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getAppVersionName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getLanguageCode()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getLanguageCode()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getStoreCountryCode()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getStoreCountryCode()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getThemeMode()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getThemeMode()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getUserId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public isAndroid()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isAndroid()Z
    move-result v0
    return v0
.end method

.method public isByteCloud()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isByteCloud()Z
    move-result v0
    return v0
.end method

.method public isDebug()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isDebug()Z
    move-result v0
    return v0
.end method

.method public isEnterprise()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isEnterprise()Z
    move-result v0
    return v0
.end method

.method public isEnterpriseBoe()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isEnterpriseBoe()Z
    move-result v0
    return v0
.end method

.method public isIOS()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isIOS()Z
    move-result v0
    return v0
.end method

.method public isLoggedIn()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isLoggedIn()Z
    move-result v0
    return v0
.end method

.method public isMainland()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isMainland()Z
    move-result v0
    return v0
.end method

.method public isOversea()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isOversea()Z
    move-result v0
    return v0
.end method

.method public isPublicCloud()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->requireHostInfo()Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isPublicCloud()Z
    move-result v0
    return v0
.end method
