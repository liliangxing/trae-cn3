# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public Lcom/bytedance/trae/utils/ThreadUtils;
.super Ljava/lang/Object;
.source "ThreadUtils.java"

.field private static final backgroundHandler:Landroid/os/Handler;
.field public static final mainHandler:Landroid/os/Handler;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    sput-object v0, Lcom/bytedance/trae/utils/ThreadUtils;->mainHandler Landroid/os/Handler;
    new-instance v0, Landroid/os/HandlerThread;
    const-string v1, "background_thread_utils"
    invoke-direct v0, v1, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Landroid/os/HandlerThread;->start()V
    new-instance v1, Landroid/os/Handler;
    invoke-virtual v0, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;
    move-result-object v0
    invoke-direct v1, v0, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    sput-object v1, Lcom/bytedance/trae/utils/ThreadUtils;->backgroundHandler Landroid/os/Handler;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static getBackgroundHandler()android.os.Handler
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/ThreadUtils;->backgroundHandler Landroid/os/Handler;
    return-object v0
.end method

.method public static postInBackground(java.lang.Runnable)void
    .registers 4
    # ins_size=1
    if-nez v3, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/ThreadUtils;->backgroundHandler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;
    const/4 v2, 0
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;-><init>(Ljava/lang/Runnable; Lcom/bytedance/trae/utils/ThreadUtils$1;)V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public static postInBackground(java.lang.Runnable  long)void
    .registers 6
    # ins_size=3
    if-nez v3, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/ThreadUtils;->backgroundHandler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;
    const/4 v2, 0
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;-><init>(Ljava/lang/Runnable; Lcom/bytedance/trae/utils/ThreadUtils$1;)V
    invoke-virtual v0, v1, v4, v5, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method public static postInForeground(java.lang.Runnable)void
    .registers 4
    # ins_size=1
    if-nez v3, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/ThreadUtils;->mainHandler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;
    const/4 v2, 0
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;-><init>(Ljava/lang/Runnable; Lcom/bytedance/trae/utils/ThreadUtils$1;)V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public static postInForeground(java.lang.Runnable  long)void
    .registers 6
    # ins_size=3
    if-nez v3, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/ThreadUtils;->mainHandler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;
    const/4 v2, 0
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;-><init>(Ljava/lang/Runnable; Lcom/bytedance/trae/utils/ThreadUtils$1;)V
    invoke-virtual v0, v1, v4, v5, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method public static postInForegroundAtFrontOfQueue(java.lang.Runnable)void
    .registers 4
    # ins_size=1
    if-nez v3, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/utils/ThreadUtils;->mainHandler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;
    const/4 v2, 0
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;-><init>(Ljava/lang/Runnable; Lcom/bytedance/trae/utils/ThreadUtils$1;)V
    invoke-virtual v0, v1, Landroid/os/Handler;->postAtFrontOfQueue(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public static runInMain(java.lang.Runnable)void
    .registers 3
    # ins_size=1
    if-nez v2, +003h
    return-void 
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v0
    invoke-virtual v0, Landroid/os/Looper;->getThread()Ljava/lang/Thread;
    move-result-object v0
    invoke-static Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;
    move-result-object v1
    if-ne v0, v1, +006h
    invoke-interface v2, Ljava/lang/Runnable;->run()V
    goto +4h
    invoke-static v2, Lcom/bytedance/trae/utils/ThreadUtils;->postInForeground(Ljava/lang/Runnable;)V
    return-void 
.end method

.method public static sleep(long)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Ljava/lang/Thread;->sleep(J)V
    return-void 
    :try_start_0x0
.end method
