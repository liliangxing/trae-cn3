# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IChatSessionApi;
.super Ljava/lang/Object;
.source "IChatSessionApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IChatSessionApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    return-void 
.end method

.method public abstract getChatSessionRaw(java.lang.String  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method

.method public abstract wakeupSandbox(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract wakeupSandboxRaw(java.lang.String  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
