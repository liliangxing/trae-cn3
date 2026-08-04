# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IListMessagesService;
.super Ljava/lang/Object;
.source "IListMessagesService.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IListMessagesService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IListMessagesService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IListMessagesService$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IListMessagesService;->Companion Lcom/bytedance/trae/im/service/IListMessagesService$Companion;
    return-void 
.end method

.method public abstract listMessagesByAnchorRaw(java.lang.String  java.lang.String  int  int  boolean  int  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
