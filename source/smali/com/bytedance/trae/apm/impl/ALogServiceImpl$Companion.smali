# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ALogServiceImpl$Companion;
.super Ljava/lang/Object;
.source "ALogServiceImpl.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/ALogServiceImpl$Companion;-><init>()V
    return-void 
.end method

.method public final synchronized initService(boolean)void
    .registers 2
    # ins_size=2
    monitor-enter v0
    invoke-static v1, Lcom/bytedance/trae/apm/impl/ALogServiceImpl;->access$setSIsDebug$cp(Z)V
    invoke-static Lcom/bytedance/trae/apm/impl/ALogServiceImpl;->access$getSInstance$p$s1117816306()Lcom/ss/alog/middleware/ALogService;
    move-result-object v1
    if-nez v1, +007h
    new-instance v1, Lcom/bytedance/trae/apm/impl/ALogServiceImpl;
    invoke-direct v1, Lcom/bytedance/trae/apm/impl/ALogServiceImpl;-><init>()V
    monitor-exit v0
    return-void 
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x1
.end method
