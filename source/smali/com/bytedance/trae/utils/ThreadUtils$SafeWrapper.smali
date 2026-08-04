# Decompiled TRAE business class
# Source DEX: classes4.dex
.class 0x0 Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;
.super Ljava/lang/Object;
.source "ThreadUtils.java"

.implements Ljava/lang/Runnable;

.field final target:Ljava/lang/Runnable;


.method private constructor <init>(java.lang.Runnable)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;->target Ljava/lang/Runnable;
    return-void 
.end method

.method synthetic constructor <init>(java.lang.Runnable  com.bytedance.trae.utils.ThreadUtils$1)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;-><init>(Ljava/lang/Runnable;)V
    return-void 
.end method

.method public run()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/ThreadUtils$SafeWrapper;->target Ljava/lang/Runnable;
    if-eqz v0, +005h
    invoke-interface v0, Ljava/lang/Runnable;->run()V
    return-void 
    :try_start_0x4
.end method
