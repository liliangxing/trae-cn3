# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/im/track/AgentMonitor$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Ljava/lang/String;


.method public synthetic constructor <init>(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/track/AgentMonitor$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    return-void 
.end method

.method public final run()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/track/AgentMonitor$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    invoke-static v0, Lcom/bytedance/trae/im/track/AgentMonitor;->$r8$lambda$rImV47Z4WfNRrTaXx3_QvbuL-Kk(Ljava/lang/String;)V
    return-void 
.end method
