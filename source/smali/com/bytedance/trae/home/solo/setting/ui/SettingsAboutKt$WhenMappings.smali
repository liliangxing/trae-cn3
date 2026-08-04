# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$WhenMappings;
.super Ljava/lang/Object;
.source "SettingsAbout.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->values()[Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Terms Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Privacy Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->OpenSource Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Help Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    const/4 v2, 4
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Community Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    const/4 v2, 5
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->Contact Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    const/4 v2, 6
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->PersonalInfoList Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    const/4 v2, 7
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ShareList Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    const/16 v2, 8
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->BusinessLicense Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    const/16 v2, 9
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->IcpFiling Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    const/16 v2, 10
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->PermissionUsage Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    const/16 v2, 11
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
    :try_start_0x22
    :try_start_0x2b
    :try_start_0x34
    :try_start_0x3d
    :try_start_0x46
    :try_start_0x50
    :try_start_0x5a
    :try_start_0x64
.end method
