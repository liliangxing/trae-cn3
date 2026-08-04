# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/im/service/ISendUserDecisionApi;
.super Ljava/lang/Object;
.source "ISendUserDecisionApi.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/ISendUserDecisionApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/ISendUserDecisionApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ISendUserDecisionApi$Companion;
    sput-object v0, Lcom/bytedance/trae/im/service/ISendUserDecisionApi;->Companion Lcom/bytedance/trae/im/service/ISendUserDecisionApi$Companion;
    return-void 
.end method

.method public abstract sendUserDecision(com.bytedance.trae.im.service.SendUserDecisionRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
