# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
.super Ljava/lang/Object;
.source "DeviceManagementViewModel.kt"

.field public static final $stable:I
.field private final actionMenu:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
.field private final deleteDialog:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
.field private final devices:Ljava/util/List;
.field private final loadFailed:Z
.field private final loading:Z
.field private final renameDialog:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
.field private final selectedGuideProduct:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 11
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 127
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;-><init>(Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(boolean  boolean  java.util.List  com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuState  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementRenameState  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementDeleteState)void
    .registers 9
    # ins_size=8
    const-string v0, "devices"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, selectedGuideProduct
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-boolean v2, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loading Z
    iput-boolean v3, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loadFailed Z
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->devices Ljava/util/List;
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->selectedGuideProduct Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->actionMenu Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
    iput-object v7, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    iput-object v8, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    return-void 
.end method

.method public synthetic constructor <init>(boolean  boolean  java.util.List  com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuState  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementRenameState  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementDeleteState  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +003h
    const/4 v6, 1
    and-int/lit8 v14, v13, 2
    if-eqz v14, +003h
    const/4 v7, 0
    move v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v8
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    sget-object v9, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;->Work Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    const/4 v8, 0
    if-eqz v7, +004h
    move-object v2, v8
    goto +2h
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    move-object v3, v8
    goto +2h
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    move-object v4, v8
    goto +2h
    move-object v4, v12
    move-object v7, v5
    move v8, v6
    move v9, v14
    move-object v10, v0
    move-object v11, v1
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    invoke-direct/range v7 ... v14, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;-><init>(Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementUiState  boolean  boolean  java.util.List  com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuState  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementRenameState  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementDeleteState  int  java.lang.Object)com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementUiState
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-boolean v6, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loading Z
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-boolean v7, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loadFailed Z
    move v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->devices Ljava/util/List;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->selectedGuideProduct Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v10, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->actionMenu Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    move-object v4, v12
    move-object v7, v5
    move v8, v6
    move v9, v14
    move-object v10, v0
    move-object v11, v1
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy(Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v5
    return-object v5
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loading Z
    return v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loadFailed Z
    return v0
.end method

.method public final component3()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->devices Ljava/util/List;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->selectedGuideProduct Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    return-object v0
.end method

.method public final component5()com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->actionMenu Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementRenameState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    return-object v0
.end method

.method public final component7()com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementDeleteState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    return-object v0
.end method

.method public final copy(boolean  boolean  java.util.List  com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuState  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementRenameState  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementDeleteState)com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementUiState
    .registers 17
    # ins_size=8
    const-string v0, "devices"
    move-object v4, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, selectedGuideProduct
    move-object v5, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-object v1, v0
    move v2, v10
    move v3, v11
    move-object v6, v14
    move-object v7, v15
    move-object/from16 v8, v16
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;-><init>(Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loading Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loading Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loadFailed Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loadFailed Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->devices Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->devices Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->selectedGuideProduct Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->selectedGuideProduct Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->actionMenu Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->actionMenu Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getActionMenu()com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->actionMenu Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
    return-object v0
.end method

.method public final getDeleteDialog()com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementDeleteState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    return-object v0
.end method

.method public final getDevices()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->devices Ljava/util/List;
    return-object v0
.end method

.method public final getLoadFailed()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loadFailed Z
    return v0
.end method

.method public final getLoading()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loading Z
    return v0
.end method

.method public final getRenameDialog()com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementRenameState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    return-object v0
.end method

.method public final getSelectedGuideProduct()com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->selectedGuideProduct Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loading Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loadFailed Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->devices Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->selectedGuideProduct Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->actionMenu Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isEmpty()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loading Z
    if-nez v0, +00ch
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->devices Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DeviceManagementUiState(loading="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loading Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", loadFailed="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->loadFailed Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", devices="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->devices Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", selectedGuideProduct="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->selectedGuideProduct Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", actionMenu="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->actionMenu Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", renameDialog="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->renameDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deleteDialog="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->deleteDialog Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
