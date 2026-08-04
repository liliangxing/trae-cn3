# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/network/NetworkDependImpl$Companion;
.super Ljava/lang/Object;
.source "NetworkDependImpl.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/im/network/NetworkDependImpl$Companion;-><init>()V
    return-void 
.end method

.method public final getInstance()com.bytedance.trae.im.network.NetworkDependImpl
    .registers 3
    # ins_size=1
    invoke-static Lcom/bytedance/trae/im/network/NetworkDependImpl;->access$getInstance$cp()Lcom/bytedance/trae/im/network/NetworkDependImpl;
    move-result-object v0
    if-nez v0, +019h
    monitor-enter v2
    invoke-static Lcom/bytedance/trae/im/network/NetworkDependImpl;->access$getInstance$cp()Lcom/bytedance/trae/im/network/NetworkDependImpl;
    move-result-object v0
    if-nez v0, +00dh
    new-instance v0, Lcom/bytedance/trae/im/network/NetworkDependImpl;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/network/NetworkDependImpl;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v1, Lcom/bytedance/trae/im/network/NetworkDependImpl;->Companion Lcom/bytedance/trae/im/network/NetworkDependImpl$Companion;
    invoke-static v0, Lcom/bytedance/trae/im/network/NetworkDependImpl;->access$setInstance$cp(Lcom/bytedance/trae/im/network/NetworkDependImpl;)V
    monitor-exit v2
    goto +4h
    move-exception v0
    monitor-exit v2
    throw v0
    return-object v0
    :try_start_0x7
.end method
