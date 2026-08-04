# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IRevertTaskApi;
.super Ljava/lang/Object;
.source "IRevertTaskApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IRevertTaskApi;->Companion Lcom/bytedance/trae/im/service/IRevertTaskApi$Companion;
    return-void 
.end method

.method public abstract revertTask(com.bytedance.trae.im.service.RevertTaskRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
