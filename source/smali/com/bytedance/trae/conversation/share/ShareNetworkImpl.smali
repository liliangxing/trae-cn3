# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/share/ShareNetworkImpl;
.super Ljava/lang/Object;
.source "ShareNetworkImpl.kt"

.implements Lcom/bytedance/ug/sdk/share/api/depend/IShareNetworkConfig;

.field public static final Companion:Lcom/bytedance/trae/conversation/share/ShareNetworkImpl$Companion;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/share/ShareNetworkImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/share/ShareNetworkImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/share/ShareNetworkImpl;->Companion Lcom/bytedance/trae/conversation/share/ShareNetworkImpl$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public checkResponseException(java.lang.Throwable)int
    .registers 3
    # ins_size=2
    const-string v0, "e"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    return v2
.end method

.method public executeGet(int  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    const-string/jumbo v1, strUrl
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/common/utility/NetworkClient;->getDefault()Lcom/bytedance/common/utility/NetworkClient;
    move-result-object v1
    invoke-virtual v1, v2, Lcom/bytedance/common/utility/NetworkClient;->get(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v1
.end method

.method public executePost(int  java.lang.String  org.json.JSONObject)java.lang.String
    .registers 10
    # ins_size=4
    const-string/jumbo v7, strUrl
    invoke-static v8, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v7, "json"
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/common/utility/NetworkClient;->getDefault()Lcom/bytedance/common/utility/NetworkClient;
    move-result-object v0
    invoke-virtual v9, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v9, toString(...)
    invoke-static v7, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v9, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-virtual v7, v9, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B
    move-result-object v2
    const-string v7, "getBytes(...)"
    invoke-static v2, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const-string v4, "application/json"
    const/4 v5, 1
    move-object v1, v8
    invoke-virtual/range v0 ... v5, Lcom/bytedance/common/utility/NetworkClient;->post(Ljava/lang/String; [B Z Ljava/lang/String; Z)Ljava/lang/String;
    move-result-object v7
    const-string v8, "post(...)"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v7
.end method

.method public getHost()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, ""
    return-object v0
.end method
