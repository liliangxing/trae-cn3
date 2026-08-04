# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/IHttpConst$DefaultImpls;
.super Ljava/lang/Object;
.source "IHttpConst.kt"


.method public static getHTTPS(com.bytedance.trae.network.IHttpConst)java.lang.String
    .registers 1
    # ins_size=1
    const-string v0, "https://"
    return-object v0
.end method

.method public static getWSS(com.bytedance.trae.network.IHttpConst)java.lang.String
    .registers 1
    # ins_size=1
    const-string/jumbo v0, wss://
    return-object v0
.end method
