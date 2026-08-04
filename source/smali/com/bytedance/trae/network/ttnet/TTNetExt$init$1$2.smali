# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/ttnet/TTNetExt$init$1$2;
.super Ljava/lang/Object;
.source "TTNetExt.kt"

.implements Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$CommandListener;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getHeaderKey()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, ""
    return-object v0
.end method

.method public onCommandReceived(java.util.List)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, values
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
