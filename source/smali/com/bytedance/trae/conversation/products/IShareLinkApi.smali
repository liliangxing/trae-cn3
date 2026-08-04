# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/products/IShareLinkApi;
.super Ljava/lang/Object;
.source "IShareLinkApi.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;
    sput-object v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->Companion Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;
    return-void 
.end method

.method public abstract createLocalShareLink(com.bytedance.trae.conversation.products.LocalShareLinkRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract createShareLink(com.bytedance.trae.conversation.products.ShareLinkRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract getLocalShareLink(com.bytedance.trae.conversation.products.GetLocalShareLinkRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract getRemoteShareLink(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract updateLocalShareLinkStatus(com.bytedance.trae.conversation.products.UpdateLocalShareLinkStatusRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract updateShareLinkStatus(java.lang.String  com.bytedance.trae.conversation.products.UpdateShareLinkStatusRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
