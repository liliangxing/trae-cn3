# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IDeleteTaskApi;
.super Ljava/lang/Object;
.source "IDeleteTaskApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IDeleteTaskApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IDeleteTaskApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IDeleteTaskApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IDeleteTaskApi;->Companion Lcom/bytedance/trae/im/service/IDeleteTaskApi$Companion;
    return-void 
.end method

.method public abstract deleteTaskRaw(com.bytedance.trae.im.service.DeleteTaskRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
