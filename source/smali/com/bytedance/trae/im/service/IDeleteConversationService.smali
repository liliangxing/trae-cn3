# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IDeleteConversationService;
.super Ljava/lang/Object;
.source "IDeleteConversationService.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IDeleteConversationService;->Companion Lcom/bytedance/trae/im/service/IDeleteConversationService$Companion;
    return-void 
.end method

.method public abstract delete(com.bytedance.trae.im.service.DeleteConversationRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract deleteRaw(com.bytedance.trae.im.service.DeleteConversationRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
