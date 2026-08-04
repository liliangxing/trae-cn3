# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"


.method public static final synthetic access$arrayOrNull(kotlinx.serialization.json.JsonElement)kotlinx.serialization.json.JsonArray
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->arrayOrNull(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$int(kotlinx.serialization.json.JsonObject  java.lang.String)java.lang.Integer
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->int(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$objectOrNull(kotlinx.serialization.json.JsonElement)kotlinx.serialization.json.JsonObject
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->objectOrNull(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$objectValue(kotlinx.serialization.json.JsonObject  java.lang.String)kotlinx.serialization.json.JsonObject
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->objectValue(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$string(kotlinx.serialization.json.JsonObject  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->string(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final arrayOrNull(kotlinx.serialization.json.JsonElement)kotlinx.serialization.json.JsonArray
    .registers 2
    # ins_size=1
    instance-of v0, v1, Lkotlinx/serialization/json/JsonArray;
    if-eqz v0, +005h
    check-cast v1, Lkotlinx/serialization/json/JsonArray;
    goto +2h
    const/4 v1, 0
    return-object v1
.end method

.method public static final formatVideoDuration(int)java.lang.String
    .registers 5
    # ins_size=1
    const/4 v0, 0
    invoke-static v4, v0, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v4
    div-int/lit16 v0, v4, 3600
    rem-int/lit16 v1, v4, 3600
    div-int/lit8 v1, v1, 60
    rem-int/lit8 v4, v4, 60
    const/16 v2, 58
    if-lez v0, +028h
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->twoDigits(I)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->twoDigits(I)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    goto +1eh
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->twoDigits(I)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-static v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->twoDigits(I)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method private static final int(kotlinx.serialization.json.JsonObject  java.lang.String)java.lang.Integer
    .registers 3
    # ins_size=2
    invoke-virtual v1, v2, Lkotlinx/serialization/json/JsonObject;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Lkotlinx/serialization/json/JsonPrimitive;
    const/4 v0, 0
    if-eqz v2, +005h
    check-cast v1, Lkotlinx/serialization/json/JsonPrimitive;
    goto +2h
    move-object v1, v0
    if-eqz v1, +006h
    invoke-static v1, Lkotlinx/serialization/json/JsonElementKt;->getIntOrNull(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
.end method

.method private static final objectOrNull(kotlinx.serialization.json.JsonElement)kotlinx.serialization.json.JsonObject
    .registers 2
    # ins_size=1
    instance-of v0, v1, Lkotlinx/serialization/json/JsonObject;
    if-eqz v0, +005h
    check-cast v1, Lkotlinx/serialization/json/JsonObject;
    goto +2h
    const/4 v1, 0
    return-object v1
.end method

.method private static final objectValue(kotlinx.serialization.json.JsonObject  java.lang.String)kotlinx.serialization.json.JsonObject
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lkotlinx/serialization/json/JsonObject;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lkotlinx/serialization/json/JsonElement;
    if-eqz v0, +007h
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->objectOrNull(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public static final stableHash(java.lang.String)java.lang.String
    .registers 9
    # ins_size=1
    const-string/jumbo v0, value
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v8, Lkotlin/text/StringsKt;->encodeToByteArray(Ljava/lang/String;)[B
    move-result-object v8
    array-length v0, v8
    const-wide v1, -3750763034638185243
    const/4 v3, 0
    if-ge v3, v0, +012h
    aget-byte v4, v8, v3
    int-to-long v4, v4
    const-wide/16 v6, 255
    and-long/2addr v4, v6
    xor-long/2addr v1, v4
    const-wide v4, 1099511628211
    mul-long/2addr v1, v4
    add-int/lit8 v3, v3, 1
    goto -11h
    invoke-static v1, v2, Lkotlin/ULong;->constructor-impl(J)J
    move-result-wide v0
    const/16 v8, 16
    invoke-static v0, v1, v8, Lkotlin/text/UStringsKt;->toString-JSWoG40(J I)Ljava/lang/String;
    move-result-object v0
    const/16 v1, 48
    invoke-static v0, v8, v1, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String; I C)Ljava/lang/String;
    move-result-object v8
    return-object v8
.end method

.method private static final string(kotlinx.serialization.json.JsonObject  java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    invoke-virtual v1, v2, Lkotlinx/serialization/json/JsonObject;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Lkotlinx/serialization/json/JsonPrimitive;
    const/4 v0, 0
    if-eqz v2, +005h
    check-cast v1, Lkotlinx/serialization/json/JsonPrimitive;
    goto +2h
    move-object v1, v0
    if-eqz v1, +006h
    invoke-static v1, Lkotlinx/serialization/json/JsonElementKt;->getContentOrNull(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final toOpenRequest(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactDescriptor  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest
    .registers 19
    # ins_size=6
    const-string v0, "<this>"
    move-object v1, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    move-object v8, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    move-object v9, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliConversationId"
    move-object/from16 v10, v16
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliType"
    move-object/from16 v11, v17
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    invoke-virtual v13, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->getArtifactId()Ljava/lang/String;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;->Video Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;
    invoke-virtual v13, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->getFilePath()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v13, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->getLastFrameUri()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v13, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->getDurationSeconds()I
    move-result v6
    invoke-virtual v13, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->getFileAction()Ljava/lang/String;
    move-result-object v7
    move-object v1, v0
    move-object/from16 v12, v18
    invoke-direct/range v1 ... v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;-><init>(Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method private static final twoDigits(int)java.lang.String
    .registers 3
    # ins_size=1
    invoke-static v2, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v2
    const/4 v0, 2
    const/16 v1, 48
    invoke-static v2, v0, v1, Lkotlin/text/StringsKt;->padStart(Ljava/lang/String; I C)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method
