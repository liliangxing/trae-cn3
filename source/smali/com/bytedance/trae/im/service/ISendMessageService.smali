# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/ISendMessageService;
.super Ljava/lang/Object;
.source "ISendMessageService.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/ISendMessageService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/ISendMessageService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ISendMessageService$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/ISendMessageService;->Companion Lcom/bytedance/trae/im/service/ISendMessageService$Companion;
    return-void 
.end method

.method public abstract sendMessage(java.lang.String  com.bytedance.trae.im.service.SendMessageRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract subscribeSseEvents(java.lang.String  java.lang.String)com.bytedance.retrofit2.Call
    # abstract or native
.end method
