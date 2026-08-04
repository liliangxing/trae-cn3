# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/apm/impl/NpthImpl$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/crash/ICrashCallback;

.field public final synthetic f$0:Lcom/bytedance/trae/apm/api/ICrashCallback;


.method public synthetic constructor <init>(com.bytedance.trae.apm.api.ICrashCallback)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/apm/impl/NpthImpl$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/apm/api/ICrashCallback;
    return-void 
.end method

.method public final onCrash(com.bytedance.crash.CrashType  java.lang.String  java.lang.Thread)void
    .registers 5
    # ins_size=4
    iget-object v0, v1, Lcom/bytedance/trae/apm/impl/NpthImpl$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/apm/api/ICrashCallback;
    invoke-static v0, v2, v3, v4, Lcom/bytedance/trae/apm/impl/NpthImpl;->$r8$lambda$EttcgRztxGXxQUBCNMPveiJOulE(Lcom/bytedance/trae/apm/api/ICrashCallback; Lcom/bytedance/crash/CrashType; Ljava/lang/String; Ljava/lang/Thread;)V
    return-void 
.end method
