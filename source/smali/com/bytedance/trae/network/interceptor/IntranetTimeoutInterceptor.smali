# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;
.super Ljava/lang/Object;
.source "IntranetTimeoutInterceptor.kt"

.implements Lcom/bytedance/retrofit2/intercept/Interceptor;

.field public static final Companion:Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor$Companion;
.field private static final TAG:Ljava/lang/String;
.field private static final TOAST_DEBOUNCE_MS:J
.field private static final USER_ACTION_PATHS:Ljava/util/List;
.field private static bridge lastToastTimestamp:J
.field private static final mainHandler:Landroid/os/Handler;
.field private static final probeExecutor:Ljava/util/concurrent/ExecutorService;


.method public static synthetic $r8$lambda$9EDdsqyxh_K--to-3--dy3OBQb0()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->checkIntranetAndNotify$lambda$2()V
    return-void 
.end method

.method public static synthetic $r8$lambda$Iw0iTJ_ac2d-horLIqhcJPiN0DY(java.lang.Runnable)java.lang.Thread
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->probeExecutor$lambda$4(Ljava/lang/Runnable;)Ljava/lang/Thread;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ojdsobjDukilchMFASsfUB4eRSc()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->checkIntranetAndNotify$lambda$2$lambda$1()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->Companion Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor$Companion;
    const-string v0, "/conversations/tasks/create"
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->USER_ACTION_PATHS Ljava/util/List;
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    sput-object v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->mainHandler Landroid/os/Handler;
    new-instance v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Ljava/util/concurrent/Executors;->newSingleThreadExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->probeExecutor Ljava/util/concurrent/ExecutorService;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final checkIntranetAndNotify()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->probeExecutor Ljava/util/concurrent/ExecutorService;
    new-instance v1, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor$$ExternalSyntheticLambda1;
    invoke-direct v1, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor$$ExternalSyntheticLambda1;-><init>()V
    invoke-interface v0, v1, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final checkIntranetAndNotify$lambda$2()void
    .registers 6
    # ins_size=0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sget-wide v2, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->lastToastTimestamp J
    sub-long v2, v0, v2
    const-wide/16 v4, 30000
    cmp-long v2, v2, v4
    if-gez v2, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/network/IntranetProber;->INSTANCE Lcom/bytedance/trae/network/IntranetProber;
    const/4 v3, 1
    const/4 v4, 0
    const/4 v5, 0
    invoke-static v2, v5, v3, v4, Lcom/bytedance/trae/network/IntranetProber;->isRegionalReachable$default(Lcom/bytedance/trae/network/IntranetProber; I I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +017h
    sput-wide v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->lastToastTimestamp J
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "IntranetTimeout"
    const-string v2, "Intranet unreachable, showing toast"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->mainHandler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor$$ExternalSyntheticLambda2;
    invoke-direct v1, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor$$ExternalSyntheticLambda2;-><init>()V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final checkIntranetAndNotify$lambda$2$lambda$1()void
    .registers 3
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/common/ttnet/R$string;->trae_intranet_disconnected I
    const/4 v2, 1
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private final isBytecloudLogin()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    invoke-virtual v0, Lcom/bytedance/trae/network/HostResolver;->isBytecloudLogin()Z
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
    :try_start_0x0
.end method

.method private final isTimeoutException(java.io.IOException)boolean
    .registers 7
    # ins_size=2
    instance-of v0, v6, Ljava/net/SocketTimeoutException;
    const/4 v1, 1
    if-eqz v0, +003h
    return v1
    invoke-virtual v6, Ljava/io/IOException;->getMessage()Ljava/lang/String;
    move-result-object v6
    const/4 v0, 0
    if-nez v6, +003h
    return v0
    check-cast v6, Ljava/lang/CharSequence;
    const-string v2, "ERR_CONNECTION_TIMED_OUT"
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v6, v2, v0, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +023h
    const-string v2, "ERR_TTNET_APP_TIMED_OUT"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v6, v2, v0, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +019h
    const-string v2, "ERR_TTNET_REQUEST_TIMED_OUT"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v6, v2, v0, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00fh
    const-string/jumbo v2, timed out
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v6, v2, v0, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move v1, v0
    return v1
.end method

.method private final isUserActionRequest(java.lang.String)boolean
    .registers 8
    # ins_size=2
    check-cast v7, Ljava/lang/CharSequence;
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v7, +00bh
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    move v2, v0
    if-eqz v2, +003h
    return v1
    sget-object v2, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->USER_ACTION_PATHS Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    instance-of v3, v2, Ljava/util/Collection;
    if-eqz v3, +00dh
    move-object v3, v2
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +004h
    move v0, v1
    goto +1bh
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, -00ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 2
    const/4 v5, 0
    invoke-static v7, v3, v1, v4, v5, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -014h
    return v0
.end method

.method private static final probeExecutor$lambda$4(java.lang.Runnable)java.lang.Thread
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/Thread;
    const-string v1, "intranet-probe"
    invoke-direct v0, v2, v1, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable; Ljava/lang/String;)V
    const/4 v2, 1
    invoke-virtual v0, v2, Ljava/lang/Thread;->setDaemon(Z)V
    return-object v0
.end method

.method public intercept(com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 4
    # ins_size=2
    if-eqz v3, +029h
    invoke-interface v3, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    if-nez v0, +003h
    goto +21h
    invoke-interface v3, v0, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v3
    return-object v3
    move-exception v3
    invoke-direct v2, v3, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->isTimeoutException(Ljava/io/IOException;)Z
    move-result v1
    if-eqz v1, +015h
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getUrl()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->isUserActionRequest(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +00bh
    invoke-direct v2, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->isBytecloudLogin()Z
    move-result v0
    if-eqz v0, +005h
    invoke-direct v2, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;->checkIntranetAndNotify()V
    throw v3
    const/4 v3, 0
    return-object v3
    :try_start_0x9
.end method
