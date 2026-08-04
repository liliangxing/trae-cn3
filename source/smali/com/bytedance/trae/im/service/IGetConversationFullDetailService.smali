# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IGetConversationFullDetailService;
.super Ljava/lang/Object;
.source "IGetConversationFullDetailService.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IGetConversationFullDetailService;->Companion Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;
    return-void 
.end method

.method public abstract getConversationFullDetailRaw(java.lang.String  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
