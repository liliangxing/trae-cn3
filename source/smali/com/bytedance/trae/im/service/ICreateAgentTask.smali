# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/ICreateAgentTask;
.super Ljava/lang/Object;
.source "ICreateAgentTask.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/ICreateAgentTask;->Companion Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;
    return-void 
.end method

.method public abstract createAgentTask(com.bytedance.trae.im.service.CreateTaskRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract createAgentTaskRaw(com.bytedance.trae.im.service.CreateTaskRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
