# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.field public static final $stable:I
.field private final id:Ljava/lang/String;
.field private final model:Ljava/lang/String;
.field private final name:Ljava/lang/String;
.field private final online:Z
.field private final product:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  boolean  com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct)void
    .registers 7
    # ins_size=6
    const-string v0, "id"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "model"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "product"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->id Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->name Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->model Ljava/lang/String;
    iput-boolean v5, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->online Z
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->product Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  java.lang.String  java.lang.String  java.lang.String  boolean  com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->id Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->name Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->model Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-boolean v7, v3, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->online Z
    move v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->product Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;)Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->model Ljava/lang/String;
    return-object v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->online Z
    return v0
.end method

.method public final component5()com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->product Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  boolean  com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct)com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice
    .registers 13
    # ins_size=6
    const-string v0, "id"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "model"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "product"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->model Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->model Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->online Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->online Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->product Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->product Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getModel()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->model Ljava/lang/String;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->name Ljava/lang/String;
    return-object v0
.end method

.method public final getOnline()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->online Z
    return v0
.end method

.method public final getProduct()com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->product Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->id Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->name Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->model Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->online Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->product Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DeviceManagementDevice(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", name="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", model="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->model Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", online="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->online Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", product="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->product Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
