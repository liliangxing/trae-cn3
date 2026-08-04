# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/ISubTaskResultApi;
.super Ljava/lang/Object;
.source "ISubTaskResultApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/ISubTaskResultApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/ISubTaskResultApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ISubTaskResultApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/ISubTaskResultApi;->Companion Lcom/bytedance/trae/im/service/ISubTaskResultApi$Companion;
    return-void 
.end method

.method public abstract postSubTaskResult(com.bytedance.trae.im.service.SubTaskResultRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
