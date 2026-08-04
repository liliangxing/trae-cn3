# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
.super Ljava/lang/Object;
.source "SettingsUiState.kt"

.field public static final $stable:I
.field private final aboutState:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
.field private final accountText:Ljava/lang/String;
.field private final avatarUrl:Ljava/lang/String;
.field private final displayName:Ljava/lang/String;
.field private final enterpriseBadge:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
.field private final footer:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
.field private final groups:Ljava/util/List;
.field private final identityBadgeText:Ljava/lang/String;
.field private final messageUnreadBadge:Ljava/lang/String;
.field private final showByteCloudBadge:Z
.field private final showEditProfile:Z
.field private final themeMode:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge  boolean  java.util.List  boolean  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState  com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState)void
    .registers 14
    # ins_size=13
    const-string v0, "displayName"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "accountText"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "avatarUrl"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, themeMode
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "groups"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "aboutState"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->displayName Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->accountText Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->avatarUrl Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->themeMode Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->identityBadgeText Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->enterpriseBadge Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    iput-boolean v8, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showByteCloudBadge Z
    iput-object v9, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->groups Ljava/util/List;
    iput-boolean v10, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showEditProfile Z
    iput-object v11, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->messageUnreadBadge Ljava/lang/String;
    iput-object v12, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->footer Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
    iput-object v13, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->aboutState Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge  boolean  java.util.List  boolean  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState  com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 30
    # ins_size=15
    move/from16 v0, v28
    and-int/lit8 v1, v0, 4
    if-eqz v1, +006h
    const-string v1, ""
    move-object v5, v1
    goto +3h
    move-object/from16 v5, v18
    and-int/lit8 v1, v0, 8
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Light Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v19
    and-int/lit16 v1, v0, 512
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v25
    and-int/lit16 v0, v0, 1024
    if-eqz v0, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v26
    move-object v2, v15
    move-object/from16 v3, v16
    move-object/from16 v4, v17
    move-object/from16 v7, v20
    move-object/from16 v8, v21
    move/from16 v9, v22
    move-object/from16 v10, v23
    move/from16 v11, v24
    move-object/from16 v14, v27
    invoke-direct/range v2 ... v14, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge; Z Ljava/util/List; Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge  boolean  java.util.List  boolean  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState  com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState  int  java.lang.Object)com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState
    .registers 28
    # ins_size=15
    move-object v0, v13
    move/from16 v1, v26
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->displayName Ljava/lang/String;
    goto +2h
    move-object v2, v14
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->accountText Ljava/lang/String;
    goto +2h
    move-object v3, v15
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->avatarUrl Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v16
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->themeMode Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    goto +3h
    move-object/from16 v5, v17
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->identityBadgeText Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->enterpriseBadge Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    goto +3h
    move-object/from16 v7, v19
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-boolean v8, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showByteCloudBadge Z
    goto +3h
    move/from16 v8, v20
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->groups Ljava/util/List;
    goto +3h
    move-object/from16 v9, v21
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-boolean v10, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showEditProfile Z
    goto +3h
    move/from16 v10, v22
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->messageUnreadBadge Ljava/lang/String;
    goto +3h
    move-object/from16 v11, v23
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->footer Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
    goto +3h
    move-object/from16 v12, v24
    and-int/lit16 v1, v1, 2048
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->aboutState Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    goto +3h
    move-object/from16 v1, v25
    move-object v14, v2
    move-object v15, v3
    move-object/from16 v16, v4
    move-object/from16 v17, v5
    move-object/from16 v18, v6
    move-object/from16 v19, v7
    move/from16 v20, v8
    move-object/from16 v21, v9
    move/from16 v22, v10
    move-object/from16 v23, v11
    move-object/from16 v24, v12
    move-object/from16 v25, v1
    invoke-virtual/range v13 ... v25, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge; Z Ljava/util/List; Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->messageUnreadBadge Ljava/lang/String;
    return-object v0
.end method

.method public final component11()com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->footer Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
    return-object v0
.end method

.method public final component12()com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->aboutState Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->accountText Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->avatarUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->themeMode Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->identityBadgeText Ljava/lang/String;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->enterpriseBadge Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    return-object v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showByteCloudBadge Z
    return v0
.end method

.method public final component8()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->groups Ljava/util/List;
    return-object v0
.end method

.method public final component9()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showEditProfile Z
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge  boolean  java.util.List  boolean  java.lang.String  com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState  com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState)com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState
    .registers 27
    # ins_size=13
    const-string v0, "displayName"
    move-object v2, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "accountText"
    move-object/from16 v3, v16
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "avatarUrl"
    move-object/from16 v4, v17
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, themeMode
    move-object/from16 v5, v18
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "groups"
    move-object/from16 v9, v22
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "aboutState"
    move-object/from16 v13, v26
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    move-object v1, v0
    move-object/from16 v6, v19
    move-object/from16 v7, v20
    move/from16 v8, v21
    move/from16 v10, v23
    move-object/from16 v11, v24
    move-object/from16 v12, v25
    invoke-direct/range v1 ... v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge; Z Ljava/util/List; Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->displayName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->displayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->accountText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->accountText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->avatarUrl Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->avatarUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->themeMode Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->themeMode Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->identityBadgeText Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->identityBadgeText Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->enterpriseBadge Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->enterpriseBadge Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showByteCloudBadge Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showByteCloudBadge Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->groups Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->groups Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showEditProfile Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showEditProfile Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->messageUnreadBadge Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->messageUnreadBadge Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->footer Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->footer Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->aboutState Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->aboutState Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAboutState()com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->aboutState Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    return-object v0
.end method

.method public final getAccountText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->accountText Ljava/lang/String;
    return-object v0
.end method

.method public final getAvatarUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->avatarUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final getEnterpriseBadge()com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->enterpriseBadge Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    return-object v0
.end method

.method public final getFooter()com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->footer Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
    return-object v0
.end method

.method public final getGroups()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->groups Ljava/util/List;
    return-object v0
.end method

.method public final getIdentityBadgeText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->identityBadgeText Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageUnreadBadge()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->messageUnreadBadge Ljava/lang/String;
    return-object v0
.end method

.method public final getShowByteCloudBadge()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showByteCloudBadge Z
    return v0
.end method

.method public final getShowEditProfile()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showEditProfile Z
    return v0
.end method

.method public final getThemeMode()com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->themeMode Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->displayName Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->accountText Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->avatarUrl Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->themeMode Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->identityBadgeText Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->enterpriseBadge Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showByteCloudBadge Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->groups Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showEditProfile Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->messageUnreadBadge Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->footer Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->aboutState Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SettingsEntryState(displayName="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->displayName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", accountText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->accountText Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", avatarUrl="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->avatarUrl Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", themeMode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->themeMode Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", identityBadgeText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->identityBadgeText Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enterpriseBadge="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->enterpriseBadge Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", showByteCloudBadge="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showByteCloudBadge Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", groups="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->groups Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", showEditProfile="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->showEditProfile Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageUnreadBadge="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->messageUnreadBadge Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", footer="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->footer Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", aboutState="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->aboutState Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
