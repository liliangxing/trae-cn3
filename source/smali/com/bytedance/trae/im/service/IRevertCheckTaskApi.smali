# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IRevertCheckTaskApi;
.super Ljava/lang/Object;
.source "IRevertCheckTaskApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi;->Companion Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;
    return-void 
.end method

.method public abstract revertCheckTaskRaw(com.bytedance.trae.im.service.RevertCheckTaskRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
