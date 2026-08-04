# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/push/impl/IPushServiceImpl$WhenMappings;
.super Ljava/lang/Object;
.source "IPushServiceImpl.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/login/api/AccountStatus;->values()[Lcom/bytedance/trae/login/api/AccountStatus;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountStatus;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_OUT Lcom/bytedance/trae/login/api/AccountStatus;
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountStatus;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/push/impl/IPushServiceImpl$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
.end method
