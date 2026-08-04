# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
.super Ljava/lang/Object;
.source "KmpBusinessResponse.kt"

.field private static final $cachedDescriptor:Lkotlinx/serialization/descriptors/SerialDescriptor;
.field public static final $stable:I
.field public static final CODE_UNKNOWN:J
.field public static final Companion:Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$Companion;
.field private final code:J
.field private final data:Ljava/lang/Object;
.field private final rawMessage:Ljava/lang/String;
.field private final rawMsg:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->Companion Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$Companion;
    new-instance v0, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;
    const-string v2, "com.bytedance.trae.kmp.network.KmpBusinessResponse"
    const/4 v3, 4
    invoke-direct v0, v2, v1, v3, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;-><init>(Ljava/lang/String; Lkotlinx/serialization/internal/GeneratedSerializer; I)V
    const-string v1, "code"
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v1, "msg"
    invoke-virtual v0, v1, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v1, "message"
    invoke-virtual v0, v1, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    const-string v1, "data"
    invoke-virtual v0, v1, v2, Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;->addElement(Ljava/lang/String; Z)V
    check-cast v0, Lkotlinx/serialization/descriptors/SerialDescriptor;
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->$cachedDescriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    return-void 
.end method

.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  long  java.lang.String  java.lang.String  java.lang.Object  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 9
    # ins_size=8
    and-int/lit8 v8, v2, 0
    if-eqz v8, +008h
    sget-object v8, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->$cachedDescriptor Lkotlinx/serialization/descriptors/SerialDescriptor;
    const/4 v0, 0
    invoke-static v2, v0, v8, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v8, v2, 1
    if-nez v8, +004h
    const-wide/16 v3, -999
    iput-wide v3, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    and-int/lit8 v3, v2, 2
    const/4 v4, 0
    if-nez v3, +005h
    iput-object v4, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    goto +3h
    iput-object v5, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    and-int/lit8 v3, v2, 4
    if-nez v3, +005h
    iput-object v4, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    goto +3h
    iput-object v6, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    and-int/lit8 v2, v2, 8
    if-nez v2, +005h
    iput-object v4, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    goto +3h
    iput-object v7, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    return-void 
.end method

.method public constructor <init>(long  java.lang.String  java.lang.String  java.lang.Object)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    iput-object v3, v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    return-void 
.end method

.method public synthetic constructor <init>(long  java.lang.String  java.lang.String  java.lang.Object  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 1
    if-eqz v13, +004h
    const-wide/16 v7, -999
    move-wide v1, v7
    and-int/lit8 v7, v12, 2
    const/4 v8, 0
    if-eqz v7, +004h
    move-object v3, v8
    goto +2h
    move-object v3, v9
    and-int/lit8 v7, v12, 4
    if-eqz v7, +004h
    move-object v4, v8
    goto +2h
    move-object v4, v10
    and-int/lit8 v7, v12, 8
    if-eqz v7, +004h
    move-object v5, v8
    goto +2h
    move-object v5, v11
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.network.KmpBusinessResponse  long  java.lang.String  java.lang.String  java.lang.Object  int  java.lang.Object)com.bytedance.trae.kmp.network.KmpBusinessResponse
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 1
    if-eqz v13, +004h
    iget-wide v7, v6, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    move-wide v1, v7
    and-int/lit8 v7, v12, 2
    if-eqz v7, +004h
    iget-object v9, v6, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    move-object v3, v9
    and-int/lit8 v7, v12, 4
    if-eqz v7, +004h
    iget-object v10, v6, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    move-object v4, v10
    and-int/lit8 v7, v12, 8
    if-eqz v7, +004h
    iget-object v11, v6, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    move-object v5, v11
    move-object v0, v6
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->copy(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object;)Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
    move-result-object v6
    return-object v6
.end method

.method public static synthetic getCode$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getData$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getRawMessage$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getRawMsg$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$base_mainlandRelease(com.bytedance.trae.kmp.network.KmpBusinessResponse  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor  kotlinx.serialization.KSerializer)void
    .registers 11
    # ins_size=4
    const/4 v0, 0
    invoke-interface v8, v9, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +004h
    move v1, v2
    goto +bh
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    const-wide/16 v5, -999
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    goto -ah
    move v1, v0
    if-eqz v1, +007h
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    invoke-interface v8, v9, v0, v3, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeLongElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I J)V
    invoke-interface v8, v9, v2, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    if-eqz v1, +004h
    move v1, v2
    goto +7h
    iget-object v1, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    if-eqz v1, +003h
    goto -6h
    move v1, v0
    if-eqz v1, +00bh
    sget-object v1, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v1, Lkotlinx/serialization/SerializationStrategy;
    iget-object v3, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    invoke-interface v8, v9, v2, v1, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    const/4 v1, 2
    invoke-interface v8, v9, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v3
    if-eqz v3, +004h
    move v3, v2
    goto +7h
    iget-object v3, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    if-eqz v3, +003h
    goto -6h
    move v3, v0
    if-eqz v3, +00bh
    sget-object v3, Lkotlinx/serialization/internal/StringSerializer;->INSTANCE Lkotlinx/serialization/internal/StringSerializer;
    check-cast v3, Lkotlinx/serialization/SerializationStrategy;
    iget-object v4, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    invoke-interface v8, v9, v1, v3, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    const/4 v1, 3
    invoke-interface v8, v9, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v3
    if-eqz v3, +004h
    move v0, v2
    goto +6h
    iget-object v3, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    if-eqz v3, +003h
    goto -6h
    if-eqz v0, +009h
    check-cast v10, Lkotlinx/serialization/SerializationStrategy;
    iget-object v7, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    invoke-interface v8, v9, v1, v10, v7, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeNullableSerializableElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)V
    return-void 
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    return-wide v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final copy(long  java.lang.String  java.lang.String  java.lang.Object)com.bytedance.trae.kmp.network.KmpBusinessResponse
    .registers 13
    # ins_size=6
    new-instance v6, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
    move-object v0, v6
    move-wide v1, v8
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object;)V
    return-object v6
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    iget-object v8, v8, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getBusinessMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    if-nez v0, +008h
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public final getCode()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    return-wide v0
.end method

.method public final getData()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final getRawMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    return-object v0
.end method

.method public final getRawMsg()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isSuccess(java.util.Set)boolean
    .registers 4
    # ins_size=2
    const-string/jumbo v0, successCodes
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-interface v3, v0, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    return v3
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "KmpBusinessResponse(code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->code J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawMsg="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMsg Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawMessage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->rawMessage Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->data Ljava/lang/Object;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
