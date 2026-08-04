# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/util/concurrent/ThreadFactory;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final newThread(java.lang.Runnable)java.lang.Thread
    .registers 2
    # ins_size=2
    invoke-static v1, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->$r8$lambda$S6RGaMgiRGU1a9zPIcKrj5FkQVc(Ljava/lang/Runnable;)Ljava/lang/Thread;
    move-result-object v1
    return-object v1
.end method
