# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceItem;
.super Ljava/lang/Object;
.source "DeviceItem.kt"

.field private final iconResId:I
.field private final id:Ljava/lang/String;
.field private final ideVersion:Ljava/lang/String;
.field private final isOnline:Z
.field private final isPaired:Z
.field private final isSelected:Z
.field private final model:Ljava/lang/String;
.field private final name:Ljava/lang/String;
.field private final type:Lcom/bytedance/trae/im/service/CliType;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  int  boolean  boolean  com.bytedance.trae.im.service.CliType  java.lang.String  boolean)void
    .registers 11
    # ins_size=10
    const-string v0, "id"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "model"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, type
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->id Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->name Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->model Ljava/lang/String;
    iput v5, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->iconResId I
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline Z
    iput-boolean v7, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isSelected Z
    iput-object v8, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->type Lcom/bytedance/trae/im/service/CliType;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->ideVersion Ljava/lang/String;
    iput-boolean v10, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  int  boolean  boolean  com.bytedance.trae.im.service.CliType  java.lang.String  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 24
    # ins_size=12
    move/from16 v0, v22
    and-int/lit8 v1, v0, 4
    if-eqz v1, +006h
    const-string v1, ""
    move-object v5, v1
    goto +2h
    move-object v5, v15
    and-int/lit8 v1, v0, 64
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v19
    and-int/lit16 v1, v0, 128
    if-eqz v1, +005h
    const/4 v1, 0
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v20
    and-int/lit16 v0, v0, 256
    if-eqz v0, +005h
    const/4 v0, 1
    move v11, v0
    goto +3h
    move/from16 v11, v21
    move-object v2, v12
    move-object v3, v13
    move-object v4, v14
    move/from16 v6, v16
    move/from16 v7, v17
    move/from16 v8, v18
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/conversation/devices/DeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z Z Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.DeviceItem  java.lang.String  java.lang.String  java.lang.String  int  boolean  boolean  com.bytedance.trae.im.service.CliType  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.conversation.devices.DeviceItem
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->id Ljava/lang/String;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->name Ljava/lang/String;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->model Ljava/lang/String;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->iconResId I
    goto +2h
    move v5, v14
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-boolean v6, v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline Z
    goto +2h
    move v6, v15
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-boolean v7, v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isSelected Z
    goto +3h
    move/from16 v7, v16
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->type Lcom/bytedance/trae/im/service/CliType;
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->ideVersion Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired Z
    goto +3h
    move/from16 v1, v19
    move-object v11, v2
    move-object v12, v3
    move-object v13, v4
    move v14, v5
    move v15, v6
    move/from16 v16, v7
    move-object/from16 v17, v8
    move-object/from16 v18, v9
    move/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/conversation/devices/DeviceItem;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z Z Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->model Ljava/lang/String;
    return-object v0
.end method

.method public final component4()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->iconResId I
    return v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline Z
    return v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isSelected Z
    return v0
.end method

.method public final component7()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->type Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->ideVersion Ljava/lang/String;
    return-object v0
.end method

.method public final component9()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired Z
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  int  boolean  boolean  com.bytedance.trae.im.service.CliType  java.lang.String  boolean)com.bytedance.trae.conversation.devices.DeviceItem
    .registers 21
    # ins_size=10
    const-string v0, "id"
    move-object v2, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    move-object v3, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "model"
    move-object v4, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, type
    move-object/from16 v8, v18
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-object v1, v0
    move v5, v15
    move/from16 v6, v16
    move/from16 v7, v17
    move-object/from16 v9, v19
    move/from16 v10, v20
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/conversation/devices/DeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z Z Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DeviceItem;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DeviceItem;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DeviceItem;->model Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;->model Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/devices/DeviceItem;->iconResId I
    iget v3, v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;->iconResId I
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isSelected Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isSelected Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DeviceItem;->type Lcom/bytedance/trae/im/service/CliType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;->type Lcom/bytedance/trae/im/service/CliType;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DeviceItem;->ideVersion Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;->ideVersion Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getIconResId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->iconResId I
    return v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getIdeVersion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->ideVersion Ljava/lang/String;
    return-object v0
.end method

.method public final getModel()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->model Ljava/lang/String;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->name Ljava/lang/String;
    return-object v0
.end method

.method public final getType()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->type Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->id Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->name Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->model Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->iconResId I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isSelected Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->type Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->ideVersion Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isOnline()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline Z
    return v0
.end method

.method public final isPaired()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired Z
    return v0
.end method

.method public final isSelected()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isSelected Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DeviceItem(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", name="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", model="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->model Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", iconResId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->iconResId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isOnline="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSelected="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isSelected Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", type="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->type Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", ideVersion="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->ideVersion Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isPaired="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isPaired Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
