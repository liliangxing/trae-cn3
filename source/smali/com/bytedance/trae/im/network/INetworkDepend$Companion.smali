# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
.super Ljava/lang/Object;
.source "INetworkDepend.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/network/INetworkDepend$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;->$$INSTANCE Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getInstance()com.bytedance.trae.im.network.INetworkDepend
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/network/NetworkDependImpl;->Companion Lcom/bytedance/trae/im/network/NetworkDependImpl$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/network/NetworkDependImpl$Companion;->getInstance()Lcom/bytedance/trae/im/network/NetworkDependImpl;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/network/INetworkDepend;
    return-object v0
.end method
