# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ALogServiceImpl;
.super Lcom/ss/alog/middleware/ALogService;
.source "ALogServiceImpl.kt"

.field public static final Companion:Lcom/bytedance/trae/apm/impl/ALogServiceImpl$Companion;
.field private static final TAG:Ljava/lang/String;
.field private static sIsDebug:Z


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/impl/ALogServiceImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/ALogServiceImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/apm/impl/ALogServiceImpl;->Companion Lcom/bytedance/trae/apm/impl/ALogServiceImpl$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/ss/alog/middleware/ALogService;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getSInstance$p$s1117816306()com.ss.alog.middleware.ALogService
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/ss/alog/middleware/ALogService;->sInstance Lcom/ss/alog/middleware/ALogService;
    return-object v0
.end method

.method public static final synthetic access$setSIsDebug$cp(boolean)void
    .registers 1
    # ins_size=1
    sput-boolean v0, Lcom/bytedance/trae/apm/impl/ALogServiceImpl;->sIsDebug Z
    return-void 
.end method

.method public static final synchronized initService(boolean)void
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/apm/impl/ALogServiceImpl;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/apm/impl/ALogServiceImpl;->Companion Lcom/bytedance/trae/apm/impl/ALogServiceImpl$Companion;
    invoke-virtual v1, v2, Lcom/bytedance/trae/apm/impl/ALogServiceImpl$Companion;->initService(Z)V
    monitor-exit v0
    return-void 
    move-exception v2
    monitor-exit v0
    throw v2
    :try_start_0x3
.end method

.method public bundle(int  java.lang.String  android.os.Bundle)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public changeLevel(int)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public d(java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public destroy()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public e(java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public e(java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public e(java.lang.String  java.lang.Throwable)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public flush()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public forceLogSharding()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public header(int  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public i(java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public init()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public init(java.lang.String)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public intent(int  java.lang.String  android.content.Intent)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public json(int  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public release()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public statcktrace(int  java.lang.String  java.lang.StackTraceElement[])void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public thread(int  java.lang.String  java.lang.Thread)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public throwable(int  java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public v(java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public w(java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public w(java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public w(java.lang.String  java.lang.Throwable)void
    .registers 3
    # ins_size=3
    return-void 
.end method
