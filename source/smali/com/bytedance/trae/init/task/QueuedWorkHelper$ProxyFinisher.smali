# Decompiled TRAE business class
# Source DEX: classes5.dex
.class 0x0 Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyFinisher;
.super Ljava/util/LinkedList;
.source "QueuedWorkHelper.java"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/util/LinkedList;-><init>()V
    return-void 
.end method

.method synthetic constructor <init>(com.bytedance.trae.init.task.QueuedWorkHelper$1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyFinisher;-><init>()V
    return-void 
.end method

.method public bridge synthetic add(java.lang.Object)boolean
    .registers 2
    # ins_size=2
    check-cast v1, Ljava/lang/Runnable;
    invoke-virtual v0, v1, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyFinisher;->add(Ljava/lang/Runnable;)Z
    move-result v1
    return v1
.end method

.method public add(java.lang.Runnable)boolean
    .registers 2
    # ins_size=2
    const/4 v1, 1
    return v1
.end method

.method public bridge synthetic poll()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyFinisher;->poll()Ljava/lang/Runnable;
    move-result-object v0
    return-object v0
.end method

.method public poll()java.lang.Runnable
    .registers 6
    # ins_size=1
    const-string v0, "QueuedWorkHelper"
    const-string v1, "ProxyFinisher: sWork.size: "
    const/4 v2, 0
    sget v3, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v4, 31
    if-lt v3, v4, +00fh
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$200()Ljava/lang/reflect/Field;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/LinkedList;
    invoke-static v3, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$102(Ljava/util/LinkedList;)Ljava/util/LinkedList;
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$300()Z
    move-result v3
    if-nez v3, +02dh
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$100()Ljava/util/LinkedList;
    move-result-object v3
    if-eqz v3, +027h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/init/task/QueuedWorkHelper;->access$100()Ljava/util/LinkedList;
    move-result-object v1
    invoke-virtual v1, Ljava/util/LinkedList;->size()I
    move-result v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +bh
    move-exception v1
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-virtual v1, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-object v2
    :try_start_0x5
.end method

.method public remove(java.lang.Object)boolean
    .registers 2
    # ins_size=2
    const/4 v1, 1
    return v1
.end method
