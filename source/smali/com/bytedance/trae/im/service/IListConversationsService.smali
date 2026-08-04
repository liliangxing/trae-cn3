# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IListConversationsService;
.super Ljava/lang/Object;
.source "IListConversationsService.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IListConversationsService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IListConversationsService$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IListConversationsService;->Companion Lcom/bytedance/trae/im/service/IListConversationsService$Companion;
    return-void 
.end method

.method public abstract listConversations(int  int  java.lang.String  java.lang.String  boolean  java.lang.Integer  java.lang.Integer  java.lang.String  java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract listConversationsRaw(int  int  java.lang.String  java.lang.String  boolean  java.lang.Integer  java.lang.Integer  java.lang.String  java.util.List  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method

.method public abstract searchConversationsRaw(java.lang.String  int  int  long  long  java.lang.Object)com.bytedance.retrofit2.Call
    # abstract or native
.end method
