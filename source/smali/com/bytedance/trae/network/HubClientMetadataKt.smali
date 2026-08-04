# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HubClientMetadataKt;
.super Ljava/lang/Object;
.source "HubClientMetadata.kt"


.method public static final buildFrontierIdentityExtras(long  com.bytedance.trae.network.HubClientMetadata)java.util.Map
    .registers 5
    # ins_size=3
    const-string v0, "clientMetadata"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 2
    new-array v0, v0, [Lkotlin/Pair;
    const-string v1, "frontier_id"
    invoke-static v2, v3, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v3, 0
    aput-object v2, v0, v3
    const-string v2, "name"
    invoke-virtual v4, Lcom/bytedance/trae/network/HubClientMetadata;->getDeviceName()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v3, 1
    aput-object v2, v0, v3
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    return-object v2
.end method
