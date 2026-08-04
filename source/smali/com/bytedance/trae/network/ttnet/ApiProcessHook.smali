# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/ttnet/ApiProcessHook;
.super Ljava/lang/Object;
.source "TTNetExt.kt"

.implements Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;

.field public static final INSTANCE:Lcom/bytedance/trae/network/ttnet/ApiProcessHook;
.field public static final TAG:Ljava/lang/String;
.field private static hasDeviceId:Z


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/ttnet/ApiProcessHook;
    invoke-direct v0, Lcom/bytedance/trae/network/ttnet/ApiProcessHook;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/ttnet/ApiProcessHook;->INSTANCE Lcom/bytedance/trae/network/ttnet/ApiProcessHook;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public addCommonParams(java.lang.String  boolean)java.lang.String
    .registers 5
    # ins_size=3
    const-string/jumbo v0, url
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->shouldBypassAppLogDidWaitForMockE2E()Z
    move-result v0
    if-nez v0, +005h
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/ttnet/ApiProcessHook;->waitDidandBDAccountCallback(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    sget-object v1, Lcom/bytedance/bdinstall/Level;->L1 Lcom/bytedance/bdinstall/Level;
    invoke-static v0, v3, v4, v1, Lcom/bytedance/applog/AppLog;->addNetCommonParams(Landroid/content/Context; Ljava/lang/String; Z Lcom/bytedance/bdinstall/Level;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "addNetCommonParams(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method public varargs addRequestVertifyParams(java.lang.String  boolean  java.lang.Object[])java.lang.String
    .registers 4
    # ins_size=4
    const-string/jumbo v2, url
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "extra"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v1
.end method

.method public getCommonParamsByLevel(int)java.util.Map
    .registers 2
    # ins_size=2
    const/4 v1, 0
    return-object v1
.end method

.method public bridge synthetic handleApiError(java.lang.String  java.lang.Throwable  long  com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo)void
    .registers 6
    # ins_size=6
    check-cast v5, Lcom/bytedance/ttnet/http/HttpRequestInfo;
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/network/ttnet/ApiProcessHook;->handleApiError(Ljava/lang/String; Ljava/lang/Throwable; J Lcom/bytedance/ttnet/http/HttpRequestInfo;)V
    return-void 
.end method

.method public handleApiError(java.lang.String  java.lang.Throwable  long  com.bytedance.ttnet.http.HttpRequestInfo)void
    .registers 6
    # ins_size=6
    const-string/jumbo v3, url
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "e"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public bridge synthetic handleApiOk(java.lang.String  long  com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo)void
    .registers 5
    # ins_size=5
    check-cast v4, Lcom/bytedance/ttnet/http/HttpRequestInfo;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/ttnet/ApiProcessHook;->handleApiOk(Ljava/lang/String; J Lcom/bytedance/ttnet/http/HttpRequestInfo;)V
    return-void 
.end method

.method public handleApiOk(java.lang.String  long  com.bytedance.ttnet.http.HttpRequestInfo)void
    .registers 5
    # ins_size=5
    const-string/jumbo v2, url
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onTryInit()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public putCommonParams(java.util.Map  boolean)void
    .registers 3
    # ins_size=3
    const-string/jumbo v2, params
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public final synchronized waitDidandBDAccountCallback(java.lang.String)void
    .registers 6
    # ins_size=2
    monitor-enter v4
    const-string/jumbo v0, url
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/applog/AppLog;->getDid()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v1
    goto +2h
    move v5, v0
    if-nez v5, +008h
    invoke-static Lcom/bytedance/applog/AppLog;->getBDAccountCallback()Lcom/bytedance/applog/IBDAccountCallback;
    move-result-object v5
    if-nez v5, +03fh
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/network/ttnet/ApiProcessHook;
    move v5, v1
    invoke-static Lcom/bytedance/applog/AppLog;->getDid()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    move v2, v0
    if-nez v2, +008h
    invoke-static Lcom/bytedance/applog/AppLog;->getBDAccountCallback()Lcom/bytedance/applog/IBDAccountCallback;
    move-result-object v2
    if-nez v2, +00fh
    const/16 v2, 5000
    if-ge v5, v2, +00bh
    add-int/lit8 v5, v5, 50
    const/16 v2, 50
    int-to-long v2, v2
    invoke-static v2, v3, Ljava/lang/Thread;->sleep(J)V
    goto -26h
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v5
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v5, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    monitor-exit v4
    return-void 
    move-exception v5
    monitor-exit v4
    throw v5
    :try_start_0x1
    :try_start_0x23
    :try_start_0x57
.end method
