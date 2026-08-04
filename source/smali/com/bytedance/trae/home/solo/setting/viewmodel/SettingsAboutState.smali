# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
.super Ljava/lang/Object;
.source "SettingsUiState.kt"

.field public static final $stable:I
.field private final appName:Ljava/lang/String;
.field private final items:Ljava/util/List;
.field private final versionName:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.util.List)void
    .registers 5
    # ins_size=4
    const-string v0, "appName"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, versionName
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "items"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->appName Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->versionName Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->items Ljava/util/List;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState  java.lang.String  java.lang.String  java.util.List  int  java.lang.Object)com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->appName Ljava/lang/String;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->versionName Ljava/lang/String;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->items Ljava/util/List;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->appName Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->versionName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->items Ljava/util/List;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.util.List)com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState
    .registers 5
    # ins_size=4
    const-string v0, "appName"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, versionName
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "items"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->appName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->appName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->versionName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->versionName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->items Ljava/util/List;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->items Ljava/util/List;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAppName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->appName Ljava/lang/String;
    return-object v0
.end method

.method public final getItems()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->items Ljava/util/List;
    return-object v0
.end method

.method public final getVersionName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->versionName Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->appName Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->versionName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->items Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SettingsAboutState(appName="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->appName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", versionName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->versionName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", items="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->items Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
