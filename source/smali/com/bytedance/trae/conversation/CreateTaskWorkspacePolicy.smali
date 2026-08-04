# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;
.super Ljava/lang/Object;
.source "CreateTaskWorkspacePolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;->INSTANCE Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final fromDevice(com.bytedance.trae.conversation.devices.SelectedDeviceItem)com.bytedance.trae.conversation.CreateTaskWorkspaceFields
    .registers 8
    # ins_size=2
    const-string v0, "device"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    const/4 v2, 0
    if-eq v0, v1, +010h
    const/4 v3, 2
    if-eq v0, v3, +00dh
    const/4 v3, 3
    if-ne v0, v3, +004h
    move-object v0, v2
    goto +17h
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getSelectedDirectory()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, -00ch
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v1
    if-eqz v3, -016h
    if-eqz v0, +007h
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    goto +2h
    move-object v3, v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectId()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +019h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v7
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v7, v5, +00dh
    move-object v7, v4
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    xor-int/2addr v7, v1
    if-eqz v7, +003h
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    move-object v2, v4
    new-instance v7, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;
    invoke-direct v7, v0, v3, v2, Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;-><init>(Ljava/lang/String; Ljava/util/List; Ljava/lang/String;)V
    return-object v7
.end method

.method public final requiresWorkspace(com.bytedance.trae.conversation.devices.SelectedDeviceItem)boolean
    .registers 4
    # ins_size=2
    const-string v0, "device"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-eq v0, v1, +00dh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v0, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    return v3
.end method
