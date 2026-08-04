# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/init/task/bdturing/DefaultTwiceVerifyDepend;
.super Ljava/lang/Object;
.source "DefaultTwiceVerifyDepend.java"

.implements Lcom/bytedance/bdturing/twiceverify/TwiceVerifyDepend;

.field private url:Ljava/lang/String;


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "https://rmc.bytedance.com/verifycenter/authentication"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/bdturing/DefaultTwiceVerifyDepend;->url Ljava/lang/String;
    return-void 
.end method

.method public dismissLoading()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public host()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->ONLINE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getHost(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public showCertLiveVerify(java.util.HashMap  com.bytedance.bdturing.twiceverify.TwiceVerifyDepend$TwiceVerifyCertVerifyCallback)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public showCertVerify(java.util.HashMap  com.bytedance.bdturing.twiceverify.TwiceVerifyDepend$TwiceVerifyCertVerifyCallback)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public showLoading(android.app.Activity  java.lang.String)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public url()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/init/task/bdturing/DefaultTwiceVerifyDepend;->url Ljava/lang/String;
    return-object v0
.end method
