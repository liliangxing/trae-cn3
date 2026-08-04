# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;
.super Ljava/lang/Object;
.source "ImageUploadModels.kt"

.field private final urlMap:Ljava/util/Map;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;-><init>(Ljava/util/Map; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.Map)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, urlMap
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;->urlMap Ljava/util/Map;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.Map  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;-><init>(Ljava/util/Map;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.imageupload.GetResourceUrlResponse  java.util.Map  int  java.lang.Object)com.bytedance.trae.conversation.imageupload.GetResourceUrlResponse
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;->urlMap Ljava/util/Map;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;->copy(Ljava/util/Map;)Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;->urlMap Ljava/util/Map;
    return-object v0
.end method

.method public final copy(java.util.Map)com.bytedance.trae.conversation.imageupload.GetResourceUrlResponse
    .registers 3
    # ins_size=2
    const-string/jumbo v0, urlMap
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;-><init>(Ljava/util/Map;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;->urlMap Ljava/util/Map;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;->urlMap Ljava/util/Map;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getUrlMap()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;->urlMap Ljava/util/Map;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;->urlMap Ljava/util/Map;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "GetResourceUrlResponse(urlMap="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;->urlMap Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
