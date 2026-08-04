# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ILaunchTraceImpl;
.super Ljava/lang/Object;
.source "ILaunchTraceImpl.kt"

.implements Lcom/bytedance/services/apm/api/ILaunchTrace;

.field private final synthetic $$delegate_0:Lcom/bytedance/apm/impl/LaunchTraceImpl;


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/bytedance/apm/impl/LaunchTraceImpl;
    invoke-direct v0, Lcom/bytedance/apm/impl/LaunchTraceImpl;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/apm/impl/ILaunchTraceImpl;->$$delegate_0 Lcom/bytedance/apm/impl/LaunchTraceImpl;
    return-void 
.end method

.method public cancelTrace()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/apm/impl/ILaunchTraceImpl;->$$delegate_0 Lcom/bytedance/apm/impl/LaunchTraceImpl;
    invoke-virtual v0, Lcom/bytedance/apm/impl/LaunchTraceImpl;->cancelTrace()V
    return-void 
.end method

.method public endSpan(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/apm/impl/ILaunchTraceImpl;->$$delegate_0 Lcom/bytedance/apm/impl/LaunchTraceImpl;
    invoke-virtual v0, v2, v3, Lcom/bytedance/apm/impl/LaunchTraceImpl;->endSpan(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public endTrace(int  java.lang.String  long)void
    .registers 6
    # ins_size=5
    iget-object v0, v1, Lcom/bytedance/trae/apm/impl/ILaunchTraceImpl;->$$delegate_0 Lcom/bytedance/apm/impl/LaunchTraceImpl;
    invoke-virtual v0, v2, v3, v4, v5, Lcom/bytedance/apm/impl/LaunchTraceImpl;->endTrace(I Ljava/lang/String; J)V
    return-void 
.end method

.method public startSpan(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/apm/impl/ILaunchTraceImpl;->$$delegate_0 Lcom/bytedance/apm/impl/LaunchTraceImpl;
    invoke-virtual v0, v2, v3, Lcom/bytedance/apm/impl/LaunchTraceImpl;->startSpan(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public startTrace()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/apm/impl/ILaunchTraceImpl;->$$delegate_0 Lcom/bytedance/apm/impl/LaunchTraceImpl;
    invoke-virtual v0, Lcom/bytedance/apm/impl/LaunchTraceImpl;->startTrace()V
    return-void 
.end method
