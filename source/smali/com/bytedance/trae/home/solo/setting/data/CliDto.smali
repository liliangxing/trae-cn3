# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/CliDto;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/data/CliDto$Companion;
.field private final id:Ljava/lang/String;
.field private final ideVersion:Ljava/lang/String;
.field private final name:Ljava/lang/String;
.field private final status:Ljava/lang/String;
.field private final type:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->Companion Lcom/bytedance/trae/home/solo/setting/data/CliDto$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 31
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/data/CliDto;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlinx.serialization.internal.SerializationConstructorMarker)void
    .registers 9
    # ins_size=8
    and-int/lit8 v8, v2, 0
    if-eqz v8, +00ch
    sget-object v8, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->getDescriptor()Lkotlinx/serialization/descriptors/SerialDescriptor;
    move-result-object v8
    const/4 v0, 0
    invoke-static v2, v0, v8, Lkotlinx/serialization/internal/PluginExceptionsKt;->throwMissingFieldException(I I Lkotlinx/serialization/descriptors/SerialDescriptor;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    and-int/lit8 v8, v2, 1
    const-string v0, ""
    if-nez v8, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    goto +3h
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    and-int/lit8 v3, v2, 2
    if-nez v3, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    goto +3h
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    and-int/lit8 v3, v2, 4
    if-nez v3, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    goto +3h
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    and-int/lit8 v3, v2, 8
    if-nez v3, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    goto +3h
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    and-int/lit8 v2, v2, 16
    if-nez v2, +005h
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    goto +3h
    iput-object v7, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=6
    const-string v0, "id"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, type
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "ideVersion"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 12
    # ins_size=8
    and-int/lit8 v11, v10, 1
    const-string v0, ""
    if-eqz v11, +004h
    move-object v11, v0
    goto +2h
    move-object v11, v5
    and-int/lit8 v5, v10, 2
    if-eqz v5, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v6
    and-int/lit8 v5, v10, 4
    if-eqz v5, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v7
    and-int/lit8 v5, v10, 8
    if-eqz v5, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v8
    and-int/lit8 v5, v10, 16
    if-eqz v5, +004h
    move-object v10, v0
    goto +2h
    move-object v10, v9
    move-object v5, v4
    move-object v6, v11
    move-object v7, v1
    move-object v8, v2
    move-object v9, v3
    invoke-direct/range v5 ... v10, Lcom/bytedance/trae/home/solo/setting/data/CliDto;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.CliDto  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.CliDto
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move-object v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/data/CliDto;
    move-result-object v3
    return-object v3
.end method

.method public static synthetic getId$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getIdeVersion$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getName$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getStatus$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static synthetic getType$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public static final synthetic write$Self$impl_mainlandRelease(com.bytedance.trae.home.solo.setting.data.CliDto  kotlinx.serialization.encoding.CompositeEncoder  kotlinx.serialization.descriptors.SerialDescriptor)void
    .registers 8
    # ins_size=3
    const/4 v0, 0
    invoke-interface v6, v7, v0, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    const-string v2, ""
    const/4 v3, 1
    if-eqz v1, +004h
    move v1, v3
    goto +bh
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto -ah
    move v1, v0
    if-eqz v1, +007h
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    invoke-interface v6, v7, v0, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    invoke-interface v6, v7, v3, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v1
    if-eqz v1, +004h
    move v1, v3
    goto +bh
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto -ah
    move v1, v0
    if-eqz v1, +007h
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    invoke-interface v6, v7, v3, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    const/4 v1, 2
    invoke-interface v6, v7, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v4
    if-eqz v4, +004h
    move v4, v3
    goto +bh
    iget-object v4, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto -ah
    move v4, v0
    if-eqz v4, +007h
    iget-object v4, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    invoke-interface v6, v7, v1, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    const/4 v1, 3
    invoke-interface v6, v7, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v4
    if-eqz v4, +004h
    move v4, v3
    goto +bh
    iget-object v4, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto -ah
    move v4, v0
    if-eqz v4, +007h
    iget-object v4, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    invoke-interface v6, v7, v1, v4, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    const/4 v1, 4
    invoke-interface v6, v7, v1, Lkotlinx/serialization/encoding/CompositeEncoder;->shouldEncodeElementDefault(Lkotlinx/serialization/descriptors/SerialDescriptor; I)Z
    move-result v4
    if-eqz v4, +004h
    move v0, v3
    goto +ah
    iget-object v4, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto -ah
    if-eqz v0, +007h
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    invoke-interface v6, v7, v1, v5, Lkotlinx/serialization/encoding/CompositeEncoder;->encodeStringElement(Lkotlinx/serialization/descriptors/SerialDescriptor; I Ljava/lang/String;)V
    return-void 
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.home.solo.setting.data.CliDto
    .registers 13
    # ins_size=6
    const-string v0, "id"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, type
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "ideVersion"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move-object v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/home/solo/setting/data/CliDto;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getIdeVersion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CliDto(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", name="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->status Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", type="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->type Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", ideVersion="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->ideVersion Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
