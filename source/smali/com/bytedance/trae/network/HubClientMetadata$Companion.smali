# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HubClientMetadata$Companion;
.super Ljava/lang/Object;
.source "HubClientMetadata.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/network/HubClientMetadata$Companion;-><init>()V
    return-void 
.end method

.method private final toSafeDeviceName(java.lang.String)java.lang.String
    .registers 8
    # ins_size=2
    const/4 v0, 0
    if-eqz v7, +054h
    check-cast v7, Ljava/lang/CharSequence;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    check-cast v1, Ljava/lang/Appendable;
    const/4 v2, 0
    move v3, v2
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-ge v3, v4, +012h
    invoke-interface v7, v3, Ljava/lang/CharSequence;->charAt(I)C
    move-result v4
    invoke-static v4, Ljava/lang/Character;->isISOControl(C)Z
    move-result v5
    if-nez v5, +005h
    invoke-interface v1, v4, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;
    add-int/lit8 v3, v3, 1
    goto -15h
    check-cast v1, Ljava/lang/StringBuilder;
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v1, toString(...)
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v7, +025h
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v7
    if-eqz v7, +019h
    move-object v1, v7
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +003h
    const/4 v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v7, v0
    if-eqz v7, +009h
    const/16 v0, 256
    invoke-static v7, v0, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v7
    return-object v7
    return-object v0
.end method

.method public final fromSystem()com.bytedance.trae.network.HubClientMetadata
    .registers 4
    # ins_size=1
    sget-object v0, Landroid/os/Build;->MANUFACTURER Ljava/lang/String;
    sget-object v1, Landroid/os/Build;->MODEL Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v2, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v0, v1, v2, Lcom/bytedance/trae/network/HubClientMetadata$Companion;->resolve(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/network/HubClientMetadata;
    move-result-object v0
    return-object v0
.end method

.method public final resolve(java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.network.HubClientMetadata
    .registers 5
    # ins_size=4
    invoke-direct v1, v2, Lcom/bytedance/trae/network/HubClientMetadata$Companion;->toSafeDeviceName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v3, Lcom/bytedance/trae/network/HubClientMetadata$Companion;->toSafeDeviceName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v2, +003h
    goto +bh
    if-nez v3, +003h
    goto +27h
    const/4 v0, 1
    invoke-static v3, v2, v0, Lkotlin/text/StringsKt;->startsWith(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    if-eqz v0, +004h
    move-object v2, v3
    goto +1eh
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v0, 32
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const/16 v3, 256
    invoke-static v2, v3, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/HubClientMetadata;
    if-nez v2, +00ah
    invoke-direct v1, v4, Lcom/bytedance/trae/network/HubClientMetadata$Companion;->toSafeDeviceName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, "Android"
    const/4 v4, 0
    invoke-direct v3, v2, v4, Lcom/bytedance/trae/network/HubClientMetadata;-><init>(Ljava/lang/String; Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v3
.end method
