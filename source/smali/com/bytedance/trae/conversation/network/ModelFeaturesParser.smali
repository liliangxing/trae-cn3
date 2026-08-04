# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;
.super Ljava/lang/Object;
.source "ModelPricingPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;
.field private static final gson:Lcom/google/gson/Gson;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;->gson Lcom/google/gson/Gson;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final parse(java.lang.String)com.bytedance.trae.conversation.network.ModelFeatures
    .registers 5
    # ins_size=2
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;
    sget-object v0, Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;->gson Lcom/google/gson/Gson;
    const-class v2, Lcom/bytedance/trae/conversation/network/ModelFeatures;
    invoke-virtual v0, v4, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/network/ModelFeatures;
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v1, v4
    check-cast v1, Lcom/bytedance/trae/conversation/network/ModelFeatures;
    return-object v1
    :try_start_0x13
.end method
