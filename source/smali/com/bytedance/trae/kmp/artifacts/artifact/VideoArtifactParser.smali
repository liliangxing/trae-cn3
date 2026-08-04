# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;
.field private static final finishTools:Ljava/util/Set;
.field private static final json:Lkotlinx/serialization/json/Json;


.method public static synthetic $r8$lambda$7Om9IIoYQssRI0TucotQXodXf08(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput)kotlin.sequences.Sequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->parseInputs$lambda$9(Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;)Lkotlin/sequences/Sequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$E_OTfjCG_BSuBKvDjWDSr0ceUDg(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->parseInputs$lambda$7(Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$GpDuz-dJyumCSNNv8GpBn_uByTo(java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->parseInputs$lambda$6(Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$RS3V-IXze4r_-qLgES1oyY-9p6A(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->parseInputs$lambda$8(Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$UyhqyinR5XAEDqJFy8ROnjjpVDY(kotlinx.serialization.json.JsonBuilder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->json$lambda$16(Lkotlinx/serialization/json/JsonBuilder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 7
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;
    const-string v1, "finish"
    const-string v2, "Finish"
    const-string v3, "agent_finish"
    const-string/jumbo v4, response_to_user
    const-string v5, "ResponseToUser"
    const-string v6, "Task"
    filled-new-array/range v1 ... v6, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->finishTools Ljava/util/Set;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$$ExternalSyntheticLambda4;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$$ExternalSyntheticLambda4;-><init>()V
    const/4 v1, 1
    const/4 v2, 0
    invoke-static v2, v0, v1, v2, Lkotlinx/serialization/json/JsonKt;->Json$default(Lkotlinx/serialization/json/Json; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Lkotlinx/serialization/json/Json;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->json Lkotlinx/serialization/json/Json;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$descriptor(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactParser  com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactFileInput)com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactDescriptor
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->descriptor(Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;)Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    move-result-object v0
    return-object v0
.end method

.method private final descriptor(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactFileInput)com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactDescriptor
    .registers 10
    # ins_size=2
    invoke-virtual v9, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->getFilePath()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00dh
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-nez v0, +004h
    const-string v0, ""
    move-object v4, v0
    invoke-virtual v9, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->getFileAction()Ljava/lang/String;
    move-result-object v7
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +052h
    const-string v0, "deleted"
    const/4 v2, 1
    invoke-static v7, v0, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    if-eqz v0, +003h
    goto +47h
    invoke-virtual v9, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->getVideoInfo()Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    move-result-object v0
    if-eqz v0, +020h
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;->getLastFrameUri()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +01ah
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00eh
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v2, v3
    if-eqz v2, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v1
    invoke-virtual v9, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;->getVideoInfo()Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    move-result-object v9
    const/4 v0, 0
    if-eqz v9, +00dh
    invoke-virtual v9, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;->getDurationSeconds()Ljava/lang/Integer;
    move-result-object v9
    if-eqz v9, +007h
    invoke-virtual v9, Ljava/lang/Integer;->intValue()I
    move-result v9
    goto +2h
    move v9, v0
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    invoke-direct v8, v4, v5, v9, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->stableArtifactId(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-static v9, v0, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v6
    move-object v2, v1
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String;)V
    return-object v1
.end method

.method private final fileInput(kotlinx.serialization.json.JsonObject)com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactFileInput
    .registers 7
    # ins_size=2
    const-string/jumbo v0, video_info
    invoke-static v6, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$objectValue(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v0
    const-string v1, "file_path"
    invoke-static v6, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$string(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "file_action"
    invoke-static v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$string(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-eqz v0, +014h
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;
    const-string v3, "last_frame_uri"
    invoke-static v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$string(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "duration"
    invoke-static v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$int(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v0
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;-><init>(Ljava/lang/String; Ljava/lang/Integer;)V
    goto +2h
    const/4 v2, 0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;
    invoke-direct v0, v1, v6, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactInfoInput;)V
    return-object v0
.end method

.method private static final json$lambda$16(kotlinx.serialization.json.JsonBuilder)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "$this$Json"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    invoke-virtual v1, v0, Lkotlinx/serialization/json/JsonBuilder;->setIgnoreUnknownKeys(Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final parseInputs$lambda$6(java.lang.String  com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput)boolean
    .registers 5
    # ins_size=2
    const-string v0, "item"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->getAgentRunId()Ljava/lang/String;
    move-result-object v4
    const/4 v0, 1
    if-eqz v3, +01ch
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v0
    if-nez v1, +00ah
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move v0, v2
    return v0
.end method

.method private static final parseInputs$lambda$7(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput)boolean
    .registers 2
    # ins_size=1
    const-string v0, "item"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->finishTools Ljava/util/Set;
    check-cast v0, Ljava/lang/Iterable;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->getToolName()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method private static final parseInputs$lambda$8(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput)boolean
    .registers 4
    # ins_size=1
    const-string v0, "item"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->getResultStatus()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +00fh
    invoke-virtual v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->getResultStatus()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, success
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    move v1, v2
    return v1
.end method

.method private static final parseInputs$lambda$9(com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput)kotlin.sequences.Sequence
    .registers 2
    # ins_size=1
    const-string v0, "item"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->getFiles()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v1
    return-object v1
.end method

.method private final parseJsonPlanItems(java.util.List)java.util.List
    .registers 4
    # ins_size=2
    check-cast v3, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v3, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlinx/serialization/json/JsonObject;
    invoke-direct v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->planItemInput(Lkotlinx/serialization/json/JsonObject;)Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v0, Ljava/util/List;
    invoke-virtual v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->parseInputs(Ljava/util/List;)Ljava/util/List;
    move-result-object v3
    return-object v3
.end method

.method private final planItemInput(kotlinx.serialization.json.JsonObject)com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput
    .registers 9
    # ins_size=2
    const-string/jumbo v0, tool_call_info
    invoke-static v8, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$objectValue(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    const-string/jumbo v2, result
    invoke-static v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$objectValue(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v2
    goto +2h
    move-object v2, v1
    if-eqz v2, +05bh
    const-string v3, "data"
    invoke-static v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$objectValue(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v3
    if-eqz v3, +053h
    const-string/jumbo v4, products
    invoke-static v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$objectValue(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v3
    if-eqz v3, +04ah
    const-string v4, "changed_videos"
    invoke-static v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$objectValue(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v3
    if-eqz v3, +042h
    const-string v4, "file_diff_infos"
    invoke-virtual v3, v4, Lkotlinx/serialization/json/JsonObject;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lkotlinx/serialization/json/JsonElement;
    if-eqz v3, +038h
    invoke-static v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$arrayOrNull(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;
    move-result-object v3
    if-eqz v3, +032h
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +01ch
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lkotlinx/serialization/json/JsonElement;
    invoke-static v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$objectOrNull(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v5
    if-eqz v5, +009h
    sget-object v6, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;
    invoke-direct v6, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->fileInput(Lkotlinx/serialization/json/JsonObject;)Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;
    move-result-object v5
    goto +2h
    move-object v5, v1
    if-eqz v5, -01ah
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1fh
    check-cast v4, Ljava/util/List;
    goto +2h
    move-object v4, v1
    if-nez v4, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;
    const-string v5, "agent_run_id"
    invoke-static v8, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$string(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-eqz v0, +009h
    const-string v5, "name"
    invoke-static v0, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$string(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-eqz v2, +009h
    const-string/jumbo v1, status
    invoke-static v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$string(Lkotlinx/serialization/json/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v3, v8, v0, v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    return-object v3
.end method

.method private final stableArtifactId(java.lang.String  java.lang.String  int  java.lang.String)java.lang.String
    .registers 7
    # ins_size=5
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v0, 124
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v1, ""
    if-nez v4, +003h
    move-object v4, v1
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    if-nez v6, +003h
    move-object v6, v1
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->stableHash(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public final parse(java.lang.String)java.util.List
    .registers 6
    # ins_size=2
    const-string/jumbo v0, rawAssistantContent
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->json Lkotlinx/serialization/json/Json;
    invoke-virtual v0, v5, Lkotlinx/serialization/json/Json;->parseToJsonElement(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;
    move-result-object v5
    invoke-static v5, Lkotlinx/serialization/json/JsonElementKt;->getJsonObject(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    goto +ch
    move-exception v5
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v5, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    move-object v5, v1
    check-cast v5, Lkotlinx/serialization/json/JsonObject;
    if-nez v5, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    return-object v5
    const-string v0, "messages"
    invoke-virtual v5, v0, Lkotlinx/serialization/json/JsonObject;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lkotlinx/serialization/json/JsonElement;
    if-eqz v5, +041h
    invoke-static v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$arrayOrNull(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;
    move-result-object v5
    if-eqz v5, +03bh
    check-cast v5, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +025h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lkotlinx/serialization/json/JsonElement;
    invoke-static v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$objectOrNull(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v2
    if-eqz v2, +012h
    const-string/jumbo v3, plan_item
    invoke-virtual v2, v3, Lkotlinx/serialization/json/JsonObject;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lkotlinx/serialization/json/JsonElement;
    if-eqz v2, +007h
    invoke-static v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$objectOrNull(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v2
    goto +2h
    move-object v2, v1
    if-eqz v2, -023h
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -28h
    move-object v1, v0
    check-cast v1, Ljava/util/List;
    if-nez v1, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-direct v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->parseJsonPlanItems(Ljava/util/List;)Ljava/util/List;
    move-result-object v5
    return-object v5
    :try_start_0x6
.end method

.method public final parseInputs(java.util.List)java.util.List
    .registers 6
    # ins_size=2
    const-string/jumbo v0, planItems
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    return-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v2, 0
    if-eqz v1, +01ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;->getAgentRunId()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00eh
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    move-object v2, v1
    if-eqz v2, -01fh
    invoke-static v5, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v5
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String;)V
    invoke-static v5, v0, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v5
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v5, v0, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v5
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$$ExternalSyntheticLambda2;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v5, v0, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v5
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$$ExternalSyntheticLambda3;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$$ExternalSyntheticLambda3;-><init>()V
    invoke-static v5, v0, Lkotlin/sequences/SequencesKt;->flatMap(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v5
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$parseInputs$5;
    invoke-direct v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser$parseInputs$5;-><init>(Ljava/lang/Object;)V
    check-cast v0, Lkotlin/jvm/functions/Function1;
    invoke-static v5, v0, Lkotlin/sequences/SequencesKt;->mapNotNull(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v5
    invoke-static v5, Lkotlin/sequences/SequencesKt;->toList(Lkotlin/sequences/Sequence;)Ljava/util/List;
    move-result-object v5
    return-object v5
.end method

.method public final parsePlanItemsJson(java.lang.String)java.util.List
    .registers 4
    # ins_size=2
    const-string/jumbo v0, planItemsJson
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->json Lkotlinx/serialization/json/Json;
    invoke-virtual v0, v3, Lkotlinx/serialization/json/Json;->parseToJsonElement(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;
    move-result-object v3
    invoke-static v3, Lkotlinx/serialization/json/JsonElementKt;->getJsonArray(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +012h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlinx/serialization/json/JsonElement;
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->access$objectOrNull(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;
    move-result-object v1
    if-eqz v1, -010h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v3, 0
    check-cast v3, Ljava/util/List;
    if-nez v3, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;->parseJsonPlanItems(Ljava/util/List;)Ljava/util/List;
    move-result-object v3
    return-object v3
    :try_start_0x6
.end method
