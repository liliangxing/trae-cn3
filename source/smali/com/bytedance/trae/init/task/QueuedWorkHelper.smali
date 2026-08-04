# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/init/task/QueuedWorkHelper;
.super Ljava/lang/Object;
.source "QueuedWorkHelper.java"

.field static final TAG:Ljava/lang/String;
.field private static clsQueuedWork:Ljava/lang/Class;
.field private static fieldWork:Ljava/lang/reflect/Field;
.field private static hasPendingWorkMethod:Ljava/lang/reflect/Method;
.field private static inited:Z
.field private static mHandler:Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;
.field private static originHandler:Landroid/os/Handler;
.field private static sFinishers:Ljava/util/LinkedList;
.field private static sLock:Ljava/lang/Object;
.field private static sOutBuild:Z
.field private static sWork:Ljava/util/LinkedList;
.field private static sWorkEmptyReported:Z
.field private static sleepTime:I


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method static synthetic access$100()java.util.LinkedList
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sWork Ljava/util/LinkedList;
    return-object v0
.end method

.method static synthetic access$102(java.util.LinkedList)java.util.LinkedList
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sWork Ljava/util/LinkedList;
    return-object v0
.end method

.method static synthetic access$200()java.lang.reflect.Field
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->fieldWork Ljava/lang/reflect/Field;
    return-object v0
.end method

.method static synthetic access$300()boolean
    .registers 1
    # ins_size=0
    sget-boolean v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sOutBuild Z
    return v0
.end method

.method static synthetic access$400()java.lang.Object
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sLock Ljava/lang/Object;
    return-object v0
.end method

.method static synthetic access$500()int
    .registers 1
    # ins_size=0
    sget v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sleepTime I
    return v0
.end method

.method static synthetic access$600()android.os.Handler
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->originHandler Landroid/os/Handler;
    return-object v0
.end method

.method static synthetic access$700()java.util.LinkedList
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sFinishers Ljava/util/LinkedList;
    return-object v0
.end method

.method static synthetic access$800()java.lang.reflect.Method
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->hasPendingWorkMethod Ljava/lang/reflect/Method;
    return-object v0
.end method

.method static synthetic access$900()boolean
    .registers 1
    # ins_size=0
    sget-boolean v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sWorkEmptyReported Z
    return v0
.end method

.method static synthetic access$902(boolean)boolean
    .registers 1
    # ins_size=1
    sput-boolean v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sWorkEmptyReported Z
    return v0
.end method

.method public static init()void
    .registers 12
    # ins_size=0
    const-string v0, "init: "
    const-string v1, "ignore: "
    sget-boolean v2, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->inited Z
    if-eqz v2, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v2
    const/4 v3, 1
    xor-int/2addr v2, v3
    sput-boolean v2, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sOutBuild Z
    sget v2, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v4, 26
    const-string v5, "QueuedWorkHelper"
    if-lt v2, v4, +11dh
    sget v2, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v4, 33
    if-le v2, v4, +004h
    goto/16 +115h
    const-string v2, "android.app.QueuedWork"
    invoke-static v2, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->clsQueuedWork Ljava/lang/Class;
    const-string/jumbo v4, sHandler
    invoke-static v2, v4, Lcom/bytedance/monitor/collector/service/DoubleReflectHelper;->getField(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/reflect/Field;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->clsQueuedWork Ljava/lang/Class;
    const-string/jumbo v6, sWork
    invoke-static v4, v6, Lcom/bytedance/monitor/collector/service/DoubleReflectHelper;->getField(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/reflect/Field;
    move-result-object v4
    sput-object v4, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->fieldWork Ljava/lang/reflect/Field;
    sget-object v4, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->clsQueuedWork Ljava/lang/Class;
    const-string/jumbo v6, sFinishers
    invoke-static v4, v6, Lcom/bytedance/monitor/collector/service/DoubleReflectHelper;->getField(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/reflect/Field;
    move-result-object v4
    sget-object v6, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->clsQueuedWork Ljava/lang/Class;
    const-string/jumbo v7, sLock
    invoke-static v6, v7, Lcom/bytedance/monitor/collector/service/DoubleReflectHelper;->getField(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/reflect/Field;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->clsQueuedWork Ljava/lang/Class;
    const-string v8, "getHandler"
    const/4 v9, 0
    new-array v10, v9, [Ljava/lang/Class;
    invoke-static v7, v8, v10, Lcom/bytedance/monitor/collector/service/DoubleReflectHelper;->getMethodInner(Ljava/lang/Class; Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v7
    sget-object v8, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->clsQueuedWork Ljava/lang/Class;
    const-string v10, "hasPendingWork"
    new-array v11, v9, [Ljava/lang/Class;
    invoke-static v8, v10, v11, Lcom/bytedance/monitor/collector/service/DoubleReflectHelper;->getMethodInner(Ljava/lang/Class; Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v8
    sput-object v8, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->hasPendingWorkMethod Ljava/lang/reflect/Method;
    if-nez v7, +017h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->inited Z
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    new-array v8, v9, [Ljava/lang/Object;
    const/4 v9, 0
    invoke-virtual v7, v9, v8, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    if-nez v2, +017h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->inited Z
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual v2, v9, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Landroid/os/Handler;
    sput-object v7, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->originHandler Landroid/os/Handler;
    sget-object v7, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->fieldWork Ljava/lang/reflect/Field;
    if-eqz v7, +012h
    if-eqz v6, +010h
    invoke-virtual v7, v9, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/util/LinkedList;
    sput-object v7, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sWork Ljava/util/LinkedList;
    invoke-virtual v6, v9, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    sput-object v6, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sLock Ljava/lang/Object;
    sget-object v6, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sWork Ljava/util/LinkedList;
    if-eqz v6, +02bh
    sget-object v6, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sLock Ljava/lang/Object;
    if-nez v6, +003h
    goto +25h
    new-instance v6, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyFinisher;
    invoke-direct v6, v9, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyFinisher;-><init>(Lcom/bytedance/trae/init/task/QueuedWorkHelper$1;)V
    sput-object v6, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sFinishers Ljava/util/LinkedList;
    invoke-virtual v4, v9, v6, Ljava/lang/reflect/Field;->set(Ljava/lang/Object; Ljava/lang/Object;)V
    new-instance v4, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;
    sget-object v6, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->originHandler Landroid/os/Handler;
    invoke-virtual v6, Landroid/os/Handler;->getLooper()Landroid/os/Looper;
    move-result-object v6
    invoke-direct v4, v6, Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;-><init>(Landroid/os/Looper;)V
    sput-object v4, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->mHandler Lcom/bytedance/trae/init/task/QueuedWorkHelper$ProxyHandler;
    invoke-virtual v2, v9, v4, Ljava/lang/reflect/Field;->set(Ljava/lang/Object; Ljava/lang/Object;)V
    sput-boolean v3, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->inited Z
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +30h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->inited Z
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-exception v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v5, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->inited Z
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->inited Z
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    throw v1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "QueuedWorkHelper does not support "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget v2, Landroid/os/Build$VERSION;->SDK_INT I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v5, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x23
    :try_start_0x7d
    :try_start_0x9a
    :try_start_0xf9
.end method

.method public static setSleepTime(int)void
    .registers 1
    # ins_size=1
    sput v0, Lcom/bytedance/trae/init/task/QueuedWorkHelper;->sleepTime I
    return-void 
.end method
