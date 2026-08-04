# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/network/IGeneralActivityApi;
.super Ljava/lang/Object;
.source "ICustomActivityApi.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi;->Companion Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;
    return-void 
.end method

.method public abstract getGeneralActivities(com.bytedance.trae.conversation.network.MobileActivityRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
