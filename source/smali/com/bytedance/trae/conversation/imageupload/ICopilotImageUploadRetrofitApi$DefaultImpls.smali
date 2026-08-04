# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/ICopilotImageUploadRetrofitApi$DefaultImpls;
.super Ljava/lang/Object;
.source "ImageUploadApi.kt"


.method public static synthetic getResourceUploadToken$default(com.bytedance.trae.conversation.imageupload.ICopilotImageUploadRetrofitApi  java.util.Map  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    if-nez v4, +00fh
    and-int/lit8 v3, v3, 1
    if-eqz v3, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ICopilotImageUploadRetrofitApi;->getResourceUploadToken(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: getResourceUploadToken"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
