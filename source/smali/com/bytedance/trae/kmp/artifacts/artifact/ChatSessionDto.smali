# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$Companion;
.field private final explorerUrl:Ljava/lang/String;
.field private final workspacePath:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;-><init>(Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  java.lang.String  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v2, 0
    if-eqz v5, +00ch
    sget-object v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$$serializer;
    invoke-virtual v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v5
    const/4 v0, 0
    invoke-static v2, v0, v5, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v5, v2, 1
    const/4 v0, 0
    if-nez v5, +005h
    iput-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    goto +3h
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    and-int/lit8 v2, v2, 2
    if-nez v2, +005h
    iput-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    goto +3h
    iput-object v4, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.ChatSessionDto  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.ChatSessionDto
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->copy(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic getExplorerUrl$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getWorkspacePath$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$artifacts_mainlandRelease(com.bytedance.trae.kmp.artifacts.artifact.ChatSessionDto  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 7
    # ins_size=3
    const/4 v0, 0
    invoke-interface v5, v6, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +004h
    move v1, v2
    goto +7h
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    if-eqz v1, +003h
    goto -6h
    move v1, v0
    if-eqz v1, +00bh
    sget-object v1, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v1, Lkotlinx/serialization/SerializationStrategy;
    iget-object v3, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    invoke-interface v5, v6, v0, v1, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    invoke-interface v5, v6, v2, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    if-eqz v1, +004h
    move v0, v2
    goto +6h
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    if-eqz v1, +003h
    goto -6h
    if-eqz v0, +00bh
    sget-object v0, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v0, Lkotlinx/serialization/SerializationStrategy;
    iget-object v4, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    invoke-interface v5, v6, v2, v0, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String)com.bytedance.trae.kmp.artifacts.artifact.ChatSessionDto
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getExplorerUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getWorkspacePath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ChatSessionDto(explorerUrl="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->explorerUrl Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", workspacePath="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ChatSessionDto;->workspacePath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
