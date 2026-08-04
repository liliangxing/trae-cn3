# Decompiled TRAE business class
# Source DEX: classes.dex
.class public abstract Lcom/bytedance/trae/keva/SyncWeakListenerRegister;
.super Ljava/lang/Object;
.source "SyncWeakListenerRegister.kt"

.field private final listeners:Ljava/util/WeakHashMap;
.field private final lock:[B


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const/4 v0, 0
    new-array v0, v0, [B
    iput-object v0, v1, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->lock [B
    new-instance v0, Ljava/util/WeakHashMap;
    invoke-direct v0, Ljava/util/WeakHashMap;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->listeners Ljava/util/WeakHashMap;
    return-void 
.end method

.method public final getListenerSize()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->lock [B
    monitor-enter v0
    iget-object v1, v2, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->listeners Ljava/util/WeakHashMap;
    invoke-virtual v1, Ljava/util/WeakHashMap;->size()I
    move-result v1
    monitor-exit v0
    return v1
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method public final getListeners()java.util.HashSet
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->lock [B
    monitor-enter v0
    new-instance v1, Ljava/util/HashSet;
    iget-object v2, v3, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->listeners Ljava/util/WeakHashMap;
    invoke-virtual v2, Ljava/util/WeakHashMap;->keySet()Ljava/util/Set;
    move-result-object v2
    check-cast v2, Ljava/util/Collection;
    invoke-direct v1, v2, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V
    monitor-exit v0
    return-object v1
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method protected onListenerCountChanged(int)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public final registerListener(java.lang.Object)void
    .registers 5
    # ins_size=2
    if-eqz v4, +01fh
    iget-object v0, v3, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->lock [B
    monitor-enter v0
    iget-object v1, v3, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->listeners Ljava/util/WeakHashMap;
    iget-object v2, v3, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->lock [B
    invoke-virtual v1, v4, v2, Ljava/util/WeakHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    if-nez v4, +00bh
    iget-object v4, v3, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->listeners Ljava/util/WeakHashMap;
    invoke-virtual v4, Ljava/util/WeakHashMap;->size()I
    move-result v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->onListenerCountChanged(I)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    goto +4h
    move-exception v4
    monitor-exit v0
    throw v4
    return-void 
    :try_start_0x5
.end method

.method public final unregisterListener(java.lang.Object)void
    .registers 5
    # ins_size=2
    if-eqz v4, +01ch
    iget-object v0, v3, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->lock [B
    monitor-enter v0
    iget-object v1, v3, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->listeners Ljava/util/WeakHashMap;
    iget-object v2, v3, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->lock [B
    invoke-virtual v1, v4, v2, Ljava/util/WeakHashMap;->remove(Ljava/lang/Object; Ljava/lang/Object;)Z
    iget-object v4, v3, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->listeners Ljava/util/WeakHashMap;
    invoke-virtual v4, Ljava/util/WeakHashMap;->size()I
    move-result v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;->onListenerCountChanged(I)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    goto +4h
    move-exception v4
    monitor-exit v0
    throw v4
    return-void 
    :try_start_0x5
.end method
