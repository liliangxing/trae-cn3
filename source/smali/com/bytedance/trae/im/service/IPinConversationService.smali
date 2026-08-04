# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IPinConversationService;
.super Ljava/lang/Object;
.source "IPinConversationService.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IPinConversationService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IPinConversationService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IPinConversationService$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IPinConversationService;->Companion Lcom/bytedance/trae/im/service/IPinConversationService$Companion;
    return-void 
.end method

.method public abstract pinRaw(com.bytedance.trae.im.service.PinConversationRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method

.method public abstract unpinRaw(com.bytedance.trae.im.service.PinConversationRequest  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
