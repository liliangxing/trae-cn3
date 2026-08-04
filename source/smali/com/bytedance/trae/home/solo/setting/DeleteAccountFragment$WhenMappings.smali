# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$WhenMappings;
.super Ljava/lang/Object;
.source "DeleteAccountFragment.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I


.method static constructor <clinit>()void
    .registers 6
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->values()[Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->EMAIL_CODE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->SMS_CODE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->ordinal()I
    move-result v3
    aput v2, v0, v3
    const/4 v3, 3
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->GOOGLE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->ordinal()I
    move-result v4
    aput v3, v0, v4
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->GITHUB Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->ordinal()I
    move-result v4
    const/4 v5, 4
    aput v5, v0, v4
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->values()[Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->VERIFY Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->ordinal()I
    move-result v4
    aput v1, v0, v4
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->CONFIRM Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->SUBMITTED Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->ordinal()I
    move-result v1
    aput v3, v0, v1
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$WhenMappings;->$EnumSwitchMapping$1 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x1a
    :try_start_0x22
    :try_start_0x34
    :try_start_0x3c
    :try_start_0x44
.end method
