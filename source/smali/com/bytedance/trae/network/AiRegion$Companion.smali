# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/AiRegion$Companion;
.super Ljava/lang/Object;
.source "HostResolver.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/network/AiRegion$Companion;-><init>()V
    return-void 
.end method

.method public final from(java.lang.String)com.bytedance.trae.network.AiRegion
    .registers 3
    # ins_size=2
    if-eqz v2, +00fh
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v2, v0, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toUpperCase(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    const/4 v2, 0
    const-string v0, "SG"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v2, Lcom/bytedance/trae/network/AiRegion;->SG Lcom/bytedance/trae/network/AiRegion;
    goto +eh
    const-string v0, "US"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    sget-object v2, Lcom/bytedance/trae/network/AiRegion;->US Lcom/bytedance/trae/network/AiRegion;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/network/AiRegion;->CN Lcom/bytedance/trae/network/AiRegion;
    return-object v2
.end method
