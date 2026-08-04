# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/IChatSessionAuthApi;
.super Ljava/lang/Object;
.source "IChatSessionAuthApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/IChatSessionAuthApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/IChatSessionAuthApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IChatSessionAuthApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/IChatSessionAuthApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionAuthApi$Companion;
    return-void 
.end method

.method public abstract issueSessionToken(java.lang.String  com.bytedance.trae.im.service.IssueSessionTokenRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
