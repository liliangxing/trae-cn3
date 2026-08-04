# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/GodzillaImpl$Companion;
.super Ljava/lang/Object;
.source "GodzillaImpl.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/GodzillaImpl$Companion;-><init>()V
    return-void 
.end method

.method public final getAppMaxMemory()long
    .registers 5
    # ins_size=1
    invoke-static Lcom/bytedance/trae/apm/impl/GodzillaImpl;->access$getSMaxMemory$cp()J
    move-result-wide v0
    const-wide/16 v2, -1
    cmp-long v0, v0, v2
    if-eqz v0, +007h
    invoke-static Lcom/bytedance/trae/apm/impl/GodzillaImpl;->access$getSMaxMemory$cp()J
    move-result-wide v0
    return-wide v0
    monitor-enter v4
    invoke-static Lcom/bytedance/trae/apm/impl/GodzillaImpl;->access$getSMaxMemory$cp()J
    move-result-wide v0
    cmp-long v0, v0, v2
    if-nez v0, +00fh
    sget-object v0, Lcom/bytedance/trae/apm/impl/GodzillaImpl;->Companion Lcom/bytedance/trae/apm/impl/GodzillaImpl$Companion;
    invoke-static Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Runtime;->maxMemory()J
    move-result-wide v0
    invoke-static v0, v1, Lcom/bytedance/trae/apm/impl/GodzillaImpl;->access$setSMaxMemory$cp(J)V
    invoke-static Lcom/bytedance/trae/apm/impl/GodzillaImpl;->access$getSMaxMemory$cp()J
    move-result-wide v0
    monitor-exit v4
    return-wide v0
    move-exception v0
    monitor-exit v4
    throw v0
    :try_start_0x10
.end method
