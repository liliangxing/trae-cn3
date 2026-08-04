# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IConfirmTaskApi;
.super Ljava/lang/Object;
.source "IConfirmTaskApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IConfirmTaskApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IConfirmTaskApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IConfirmTaskApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IConfirmTaskApi;->Companion Lcom/bytedance/trae/im/service/IConfirmTaskApi$Companion;
    return-void 
.end method

.method public abstract confirmTask(com.bytedance.trae.im.service.ConfirmTaskRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
