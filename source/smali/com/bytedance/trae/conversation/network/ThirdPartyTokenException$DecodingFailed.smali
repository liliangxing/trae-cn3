# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException$DecodingFailed;
.super Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException;
.source "ThirdPartyTokenRepository.kt"


.method public constructor <init>(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "message"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/network/ThirdPartyTokenException;-><init>(Ljava/lang/String; Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method
