# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IRenameConversationService;
.super Ljava/lang/Object;
.source "IRenameConversationService.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IRenameConversationService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IRenameConversationService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IRenameConversationService$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IRenameConversationService;->Companion Lcom/bytedance/trae/im/service/IRenameConversationService$Companion;
    return-void 
.end method

.method public abstract rename(com.bytedance.trae.im.service.RenameConversationRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract renameRaw(com.bytedance.trae.im.service.RenameConversationRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
