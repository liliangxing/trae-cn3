# Decompiled TRAE business class
# Source DEX: classes5.dex
.class 0x0 Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;
.super Landroid/os/Handler;
.source "QueuedWorkHelper.java"

.field private static hasRun:Z
.field private static running:Z
.field  cache:Ljava/util/LinkedList;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method constructor <init>(android.os.Looper)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    new-instance v1, Ljava/util/LinkedList;
    invoke-direct v1, Ljava/util/LinkedList;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->cache Ljava/util/LinkedList;
    return-void 
.end method

.method public handleMessage(android.os.Message)void
    .registers 7
    # ins_size=2
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$300()Z
    move-result v6
    if-nez v6, +01eh
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "QueuedWorkHelper"
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "handleMessage begin cache.size: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v5, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->cache Ljava/util/LinkedList;
    invoke-virtual v2, Ljava/util/LinkedList;->size()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v6, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->cache Ljava/util/LinkedList;
    invoke-virtual v6, Ljava/util/LinkedList;->isEmpty()Z
    move-result v6
    if-eqz v6, +003h
    return-void 
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$400()Ljava/lang/Object;
    move-result-object v6
    monitor-enter v6
    iget-object v0, v5, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->cache Ljava/util/LinkedList;
    new-instance v1, Ljava/util/LinkedList;
    invoke-direct v1, Ljava/util/LinkedList;-><init>()V
    iput-object v1, v5, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->cache Ljava/util/LinkedList;
    monitor-exit v6
    const/4 v6, 1
    sput-boolean v6, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->running Z
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$500()I
    move-result v6
    const/4 v1, -1
    if-eq v6, v1, +022h
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$500()I
    move-result v6
    int-to-long v1, v6
    invoke-static v1, v2, Ljava/lang/Thread;->sleep(J)V
    goto +18h
    move-exception v6
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "QueuedWorkHelper"
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "ignore: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v2, v6, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$300()Z
    move-result v6
    if-nez v6, +01ch
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "QueuedWorkHelper"
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "handleMessage clone.size: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/util/LinkedList;->size()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/util/LinkedList;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Runnable;
    invoke-interface v0, Ljava/lang/Runnable;->run()V
    goto -fh
    iget-object v6, v5, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->cache Ljava/util/LinkedList;
    invoke-virtual v6, Ljava/util/LinkedList;->isEmpty()Z
    move-result v6
    if-nez v6, +00bh
    const/4 v6, 2
    invoke-static v5, v6, Landroid/os/Message;->obtain(Landroid/os/Handler; I)Landroid/os/Message;
    move-result-object v6
    invoke-virtual v5, v6, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->sendMessageAtFrontOfQueue(Landroid/os/Message;)Z
    goto +4h
    const/4 v6, 0
    sput-boolean v6, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->running Z
    return-void 
    move-exception v0
    monitor-exit v6
    throw v0
    :try_start_0x30
    :try_start_0x44
    :try_start_0xae
.end method

.method public sendMessageAtTime(android.os.Message  long)boolean
    .registers 9
    # ins_size=4
    const-string/jumbo v7, sendMessageAtTime cache.size: 
    sget-boolean v8, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->hasRun Z
    const/4 v0, 0
    const/4 v1, 1
    if-nez v8, +01fh
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$200()Ljava/lang/reflect/Field;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/LinkedList;
    invoke-static v2, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$102(Ljava/util/LinkedList;)Ljava/util/LinkedList;
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$600()Landroid/os/Handler;
    move-result-object v2
    invoke-virtual v2, v1, Landroid/os/Handler;->removeMessages(I)V
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$700()Ljava/util/LinkedList;
    move-result-object v2
    invoke-virtual v2, Ljava/util/LinkedList;->clear()V
    sput-boolean v1, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->hasRun Z
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$300()Z
    move-result v2
    if-nez v2, +059h
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$800()Ljava/lang/reflect/Method;
    move-result-object v2
    const/4 v3, 0
    new-array v3, v3, [Ljava/lang/Object;
    invoke-virtual v2, v0, v3, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "QueuedWorkHelper"
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v7, v5, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->cache Ljava/util/LinkedList;
    invoke-virtual v7, Ljava/util/LinkedList;->size()I
    move-result v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v4, "  sWork.size: "
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$100()Ljava/util/LinkedList;
    move-result-object v4
    invoke-virtual v4, Ljava/util/LinkedList;->size()I
    move-result v4
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v4, "  hasRunBackUp: "
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, "  hasRun: "
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    sget-boolean v8, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->hasRun Z
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, "  hasPendingWork:"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v3, v7, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$100()Ljava/util/LinkedList;
    move-result-object v7
    invoke-virtual v7, Ljava/util/LinkedList;->isEmpty()Z
    move-result v7
    if-eqz v7, +00bh
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$900()Z
    move-result v7
    if-nez v7, +005h
    invoke-static v1, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$902(Z)Z
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$100()Ljava/util/LinkedList;
    move-result-object v7
    invoke-virtual v7, Ljava/util/LinkedList;->size()I
    move-result v7
    if-ne v7, v1, +012h
    iget-object v7, v5, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->cache Ljava/util/LinkedList;
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$100()Ljava/util/LinkedList;
    move-result-object v8
    invoke-virtual v8, Ljava/util/LinkedList;->poll()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/lang/Runnable;
    invoke-virtual v7, v8, Ljava/util/LinkedList;->addLast(Ljava/lang/Object;)V
    goto +27h
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$100()Ljava/util/LinkedList;
    move-result-object v7
    invoke-virtual v7, Ljava/util/LinkedList;->size()I
    move-result v7
    if-le v7, v1, +01eh
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$100()Ljava/util/LinkedList;
    move-result-object v7
    invoke-virtual v7, Ljava/util/LinkedList;->poll()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/Runnable;
    if-eqz v7, +012h
    iget-object v8, v5, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->cache Ljava/util/LinkedList;
    invoke-virtual v8, v7, Ljava/util/LinkedList;->addLast(Ljava/lang/Object;)V
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$100()Ljava/util/LinkedList;
    move-result-object v7
    invoke-virtual v7, Ljava/util/LinkedList;->poll()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/Runnable;
    goto -11h
    sget-boolean v7, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;->running Z
    if-nez v7, +00ah
    const/4 v7, 2
    iput v7, v6, Landroid/os/Message;->what I
    invoke-super v5, v6, Landroid/os/Handler;->sendMessageAtFrontOfQueue(Landroid/os/Message;)Z
    move-result v6
    return v6
    return v1
    :try_start_0x9
.end method
