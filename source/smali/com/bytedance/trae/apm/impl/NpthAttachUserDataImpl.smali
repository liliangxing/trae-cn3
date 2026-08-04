# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;
.super Ljava/lang/Object;
.source "NpthAttachUserDataImpl.kt"

.implements Lcom/bytedance/crash/AttachUserData;

.field public static final Companion:Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl$Companion;
.field public static final TAG:Ljava/lang/String;
.field private final npthUserData:Ljava/util/Map;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;->Companion Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v1, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;->npthUserData Ljava/util/Map;
    return-void 
.end method

.method private final appendLibLoadInfo()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;->npthUserData Ljava/util/Map;
    invoke-static Lcom/bytedance/librarian/Librarian;->getErrors()[Ljava/lang/UnsatisfiedLinkError;
    move-result-object v1
    invoke-static v1, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toString(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "librarian"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v3, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;->npthUserData Ljava/util/Map;
    invoke-virtual v3, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v1, Ljava/lang/ClassLoader;->toString()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, "No ClassLoader information"
    const-string v2, "class_loader"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final appendUserData()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;->npthUserData Ljava/util/Map;
    const-string v1, "curDeviceId"
    invoke-interface v0, v1, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v0
    const-string v2, ""
    if-nez v0, +029h
    iget-object v0, v5, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;->npthUserData Ljava/util/Map;
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v3, v5
    check-cast v3, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    move-object v3, v2
    invoke-interface v0, v1, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v5, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;->npthUserData Ljava/util/Map;
    const-string v1, "curUserId"
    invoke-interface v0, v1, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +02ah
    iget-object v0, v5, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;->npthUserData Ljava/util/Map;
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v3, v5
    check-cast v3, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getUserID()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v2, v3
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0xe
    :try_start_0x3f
.end method

.method public getUserData(com.bytedance.crash.CrashType)java.util.Map
    .registers 3
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;->appendLibLoadInfo()V
    invoke-direct v1, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;->appendUserData()V
    iget-object v2, v1, Lcom/bytedance/trae/apm/impl/NpthAttachUserDataImpl;->npthUserData Ljava/util/Map;
    return-object v2
    :try_start_0x6
.end method
