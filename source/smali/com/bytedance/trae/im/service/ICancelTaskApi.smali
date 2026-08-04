# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/ICancelTaskApi;
.super Ljava/lang/Object;
.source "ICancelTaskApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/ICancelTaskApi;->Companion Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;
    return-void 
.end method

.method public abstract cancelTask(com.bytedance.trae.im.service.CancelTaskRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract cancelTaskRaw(com.bytedance.trae.im.service.CancelTaskRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
