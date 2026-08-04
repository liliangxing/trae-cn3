# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
.super Ljava/lang/Object;
.source "SettingsUiState.kt"

.field public static final $stable:I
.field private final destination:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
.field private final key:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItemKey  com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutDestination)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "destination"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->destination Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem  com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItemKey  com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutDestination  int  java.lang.Object)com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->destination Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->copy(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItemKey
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutDestination
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->destination Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItemKey  com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutDestination)com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "destination"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->destination Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->destination Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getDestination()com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutDestination
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->destination Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
    return-object v0
.end method

.method public final getKey()com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItemKey
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->destination Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SettingsAboutItem(key="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", destination="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->destination Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutDestination;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
