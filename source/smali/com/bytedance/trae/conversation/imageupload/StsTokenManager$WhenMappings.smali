# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$WhenMappings;
.super Ljava/lang/Object;
.source "StsTokenManager.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->values()[Lcom/bytedance/trae/conversation/imageupload/TokenStatus;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->NeedSyncRefresh Lcom/bytedance/trae/conversation/imageupload/TokenStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->NeedAsyncRefresh Lcom/bytedance/trae/conversation/imageupload/TokenStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->Valid Lcom/bytedance/trae/conversation/imageupload/TokenStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/TokenStatus;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
.end method
