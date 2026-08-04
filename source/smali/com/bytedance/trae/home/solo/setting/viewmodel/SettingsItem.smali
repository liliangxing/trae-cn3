# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
.super Ljava/lang/Object;
.source "SettingsUiState.kt"

.field public static final $stable:I
.field private final clickable:Z
.field private final destructive:Z
.field private final key:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
.field private final showTrailingIcon:Z
.field private final trailingText:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey  java.lang.String  boolean  boolean  boolean)void
    .registers 7
    # ins_size=6
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->trailingText Ljava/lang/String;
    iput-boolean v4, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->destructive Z
    iput-boolean v5, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->clickable Z
    iput-boolean v6, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->showTrailingIcon Z
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey  java.lang.String  boolean  boolean  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 2
    if-eqz v13, +003h
    const/4 v8, 0
    move-object v2, v8
    and-int/lit8 v8, v12, 4
    if-eqz v8, +003h
    const/4 v9, 0
    move v3, v9
    and-int/lit8 v8, v12, 8
    const/4 v9, 1
    if-eqz v8, +004h
    move v4, v9
    goto +2h
    move v4, v10
    and-int/lit8 v8, v12, 16
    if-eqz v8, +004h
    move v5, v9
    goto +2h
    move v5, v11
    move-object v0, v6
    move-object v1, v7
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey  java.lang.String  boolean  boolean  boolean  int  java.lang.Object)com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->trailingText Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-boolean v6, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->destructive Z
    move v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-boolean v7, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->clickable Z
    move v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-boolean v8, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->showTrailingIcon Z
    move v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move v8, v0
    move v9, v1
    move v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->copy(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v3
    return-object v3
.end method

.method public final component1()com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->trailingText Ljava/lang/String;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->destructive Z
    return v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->clickable Z
    return v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->showTrailingIcon Z
    return v0
.end method

.method public final copy(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey  java.lang.String  boolean  boolean  boolean)com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem
    .registers 13
    # ins_size=6
    const-string v0, "key"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move v4, v10
    move v5, v11
    move v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->trailingText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->trailingText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->destructive Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->destructive Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->clickable Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->clickable Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->showTrailingIcon Z
    iget-boolean v5, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->showTrailingIcon Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getClickable()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->clickable Z
    return v0
.end method

.method public final getDestructive()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->destructive Z
    return v0
.end method

.method public final getKey()com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    return-object v0
.end method

.method public final getShowTrailingIcon()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->showTrailingIcon Z
    return v0
.end method

.method public final getTrailingText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->trailingText Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->trailingText Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->destructive Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->clickable Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->showTrailingIcon Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SettingsItem(key="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->key Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", trailingText="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->trailingText Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", destructive="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->destructive Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", clickable="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->clickable Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", showTrailingIcon="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;->showTrailingIcon Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
