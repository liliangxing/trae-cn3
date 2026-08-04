# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
.super Landroidx/lifecycle/AndroidViewModel;
.source "DirectoryViewModel.kt"

.field private static final CODE_LITE_DEVICE_OFFLINE:J
.field public static final Companion:Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Companion;
.field private final _defaultFolder:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _events:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final _folderTree:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _uiState:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _userFolders:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private chatMode:Lcom/bytedance/trae/im/service/Mode;
.field private final childrenCache:Ljava/util/Map;
.field private cliId:Ljava/lang/String;
.field private final defaultFolder:Lkotlinx/coroutines/flow/StateFlow;
.field private final events:Lkotlinx/coroutines/flow/SharedFlow;
.field private final folderTree:Lkotlinx/coroutines/flow/StateFlow;
.field private mode:Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
.field private preselectedPath:Ljava/lang/String;
.field private final uiState:Lkotlinx/coroutines/flow/StateFlow;
.field private final userFolders:Lkotlinx/coroutines/flow/StateFlow;


.method public static synthetic $r8$lambda$1OoVvHSgvhTXWAtZg8rEJ9GvPGM(java.lang.String  com.bytedance.trae.conversation.devices.DirectoryNode)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cancelNewFolder$lambda$11(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->Companion Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Companion;
    return-void 
.end method

.method public constructor <init>(android.app.Application)void
    .registers 11
    # ins_size=2
    const-string v0, "application"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v10, Landroidx/lifecycle/AndroidViewModel;-><init>(Landroid/app/Application;)V
    sget-object v10, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->RECENT Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->mode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    sget-object v10, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->chatMode Lcom/bytedance/trae/im/service/Mode;
    new-instance v10, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 63
    const/4 v8, 0
    move-object v0, v10
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;-><init>(Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v10, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v10, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->uiState Lkotlinx/coroutines/flow/StateFlow;
    const/4 v10, 7
    const/4 v0, 0
    invoke-static v0, v0, v1, v10, v1, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_events Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v10, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->events Lkotlinx/coroutines/flow/SharedFlow;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v10
    invoke-static v10, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_userFolders Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v10, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->userFolders Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v1, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_defaultFolder Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v10, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->defaultFolder Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v1, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_folderTree Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v10, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->folderTree Lkotlinx/coroutines/flow/StateFlow;
    new-instance v10, Ljava/util/LinkedHashMap;
    invoke-direct v10, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v10, Ljava/util/Map;
    iput-object v10, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->childrenCache Ljava/util/Map;
    return-void 
.end method

.method public static final synthetic access$applyPreselection(com.bytedance.trae.conversation.devices.DirectoryViewModel  java.util.List)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->applyPreselection(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$errorMessage(com.bytedance.trae.conversation.devices.DirectoryViewModel  int  java.lang.String  int)java.lang.String
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->errorMessage(I Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$errorMessage(com.bytedance.trae.conversation.devices.DirectoryViewModel  long  java.lang.String  int)java.lang.String
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->errorMessage(J Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$flattenFolderNodeShallow(com.bytedance.trae.conversation.devices.DirectoryViewModel  com.bytedance.trae.conversation.network.FolderNode)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->flattenFolderNodeShallow(Lcom/bytedance/trae/conversation/network/FolderNode;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getChildrenCache$p(com.bytedance.trae.conversation.devices.DirectoryViewModel)java.util.Map
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->childrenCache Ljava/util/Map;
    return-object v0
.end method

.method public static final synthetic access$get_defaultFolder$p(com.bytedance.trae.conversation.devices.DirectoryViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_defaultFolder Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_events$p(com.bytedance.trae.conversation.devices.DirectoryViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_events Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$get_folderTree$p(com.bytedance.trae.conversation.devices.DirectoryViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_folderTree Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_uiState$p(com.bytedance.trae.conversation.devices.DirectoryViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_userFolders$p(com.bytedance.trae.conversation.devices.DirectoryViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_userFolders Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$updatePlaceholderState(com.bytedance.trae.conversation.devices.DirectoryViewModel  java.lang.String  boolean  boolean  java.lang.String)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->updatePlaceholderState(Ljava/lang/String; Z Z Ljava/lang/String;)V
    return-void 
.end method

.method private final applyPreselection(java.util.List)java.util.List
    .registers 21
    # ins_size=2
    move-object/from16 v0, v19
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->preselectedPath Ljava/lang/String;
    if-nez v1, +003h
    return-object v20
    move-object/from16 v2, v20
    check-cast v2, Ljava/lang/Iterable;
    instance-of v3, v2, Ljava/util/Collection;
    const/4 v4, 0
    if-eqz v3, +00ch
    move-object v3, v2
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +003h
    goto +1ch
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +013h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getPath()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -014h
    const/4 v4, 1
    if-nez v4, +003h
    return-object v20
    new-instance v3, Ljava/util/ArrayList;
    const/16 v4, 10
    invoke-static v2, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v3, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +027h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getPath()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v16
    const/16 v17, 1023
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryNode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2ah
    check-cast v3, Ljava/util/List;
    return-object v3
.end method

.method private static final cancelNewFolder$lambda$11(java.lang.String  com.bytedance.trae.conversation.devices.DirectoryNode)boolean
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method public static synthetic checkNeedAuthorization$default(com.bytedance.trae.conversation.devices.DirectoryViewModel  java.lang.String  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->checkNeedAuthorization(Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private final collapseNode(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 26
    # ins_size=2
    move-object/from16 v0, v24
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    move v4, v2
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, -1
    if-eqz v5, +01ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    goto +5h
    add-int/lit8 v4, v4, 1
    goto -1eh
    move v4, v6
    if-ne v4, v6, +003h
    return-void 
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v1
    invoke-direct v0, v3, v4, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->countDescendants(Ljava/util/List; I I)I
    move-result v1
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/List;
    add-int/lit8 v6, v4, 1
    add-int v7, v6, v1
    move v8, v6
    if-ge v8, v7, +034h
    invoke-interface v3, v8, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v9
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v9
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v11
    add-int/lit8 v11, v11, 1
    if-ne v9, v11, +01eh
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 1983
    const/16 v23, 0
    invoke-static/range v10 ... v23, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryNode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v9
    invoke-interface v5, v9, Ljava/util/List;->add(Ljava/lang/Object;)Z
    add-int/lit8 v8, v8, 1
    goto -33h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->childrenCache Ljava/util/Map;
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v8
    invoke-interface v7, v8, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-ge v2, v1, +008h
    invoke-interface v3, v6, Ljava/util/List;->remove(I)Ljava/lang/Object;
    add-int/lit8 v2, v2, 1
    goto -7h
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 1983
    const/16 v20, 0
    move-object/from16 v7, v25
    invoke-static/range v7 ... v20, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryNode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v1
    invoke-interface v3, v4, v1, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v9, 62
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private final countDescendants(java.util.List  int  int)int
    .registers 7
    # ins_size=4
    add-int/lit8 v5, v5, 1
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v0
    const/4 v1, 0
    if-ge v5, v0, +013h
    invoke-interface v4, v5, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v2
    if-le v2, v6, +007h
    add-int/lit8 v1, v1, 1
    add-int/lit8 v5, v5, 1
    goto -12h
    return v1
.end method

.method private final errorMessage(int  java.lang.String  int)java.lang.String
    .registers 8
    # ins_size=4
    int-to-long v0, v5
    const-wide/32 v2, 2900101
    cmp-long v5, v0, v2
    if-nez v5, +009h
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getString(I)Ljava/lang/String;
    move-result-object v5
    goto +15h
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    if-eqz v5, +006h
    invoke-direct v4, v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getString(I)Ljava/lang/String;
    move-result-object v6
    move-object v5, v6
    check-cast v5, Ljava/lang/String;
    return-object v5
.end method

.method private final errorMessage(long  java.lang.String  int)java.lang.String
    .registers 7
    # ins_size=5
    const-wide/32 v0, 2900101
    cmp-long v3, v3, v0
    if-nez v3, +009h
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_device_offline I
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getString(I)Ljava/lang/String;
    move-result-object v5
    goto +7h
    if-nez v5, +006h
    invoke-direct v2, v6, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getString(I)Ljava/lang/String;
    move-result-object v5
    return-object v5
.end method

.method private final expandNode(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 20
    # ins_size=2
    move-object/from16 v0, v18
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const/4 v5, -1
    if-eqz v4, +01ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v6
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +5h
    add-int/lit8 v2, v2, 1
    goto -1eh
    move v2, v5
    if-ne v2, v5, +003h
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->childrenCache Ljava/util/Map;
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-interface v1, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    if-eqz v1, +038h
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 1
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 1983
    const/16 v17, 0
    move-object/from16 v4, v19
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryNode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v4
    invoke-interface v3, v2, v4, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    add-int/lit8 v2, v2, 1
    check-cast v1, Ljava/util/Collection;
    invoke-interface v3, v2, v1, Ljava/util/List;->addAll(I Ljava/util/Collection;)Z
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 62
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getChildrenLoaded()Z
    move-result v1
    if-nez v1, +04eh
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 1
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 1919
    const/16 v17, 0
    move-object/from16 v4, v19
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryNode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v1
    invoke-interface v3, v2, v1, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 62
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cliId Ljava/lang/String;
    if-nez v1, +003h
    return-void 
    move-object v2, v0
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;
    const/4 v6, 0
    move-object/from16 v7, v19
    invoke-direct v2, v1, v7, v0, v6, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DirectoryNode; Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final flattenFolderNode(com.bytedance.trae.conversation.network.FolderNode  int)java.util.List
    .registers 22
    # ins_size=3
    if-nez v20, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/network/FolderNode;->getChildren()Ljava/util/List;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +004h
    move v1, v3
    goto +2h
    move v1, v2
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/network/FolderNode;->getHasChildren()Z
    move-result v4
    if-nez v4, +019h
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/network/FolderNode;->getChildren()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v2
    goto +2h
    move v4, v3
    if-nez v4, +003h
    goto +3h
    move v11, v2
    goto +2h
    move v11, v3
    if-eqz v11, +018h
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/network/FolderNode;->getChildren()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v2
    goto +2h
    move v4, v3
    if-nez v4, +004h
    move v12, v3
    goto +2h
    move v12, v2
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/network/FolderNode;->getPath()Ljava/lang/String;
    move-result-object v6
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/network/FolderNode;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/network/FolderNode;->getPath()Ljava/lang/String;
    move-result-object v8
    if-eqz v1, +006h
    if-eqz v11, +004h
    move v14, v3
    goto +2h
    move v14, v2
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/4 v10, 0
    const/4 v13, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 1680
    const/16 v18, 0
    move-object v5, v1
    move/from16 v9, v21
    invoke-direct/range v5 ... v18, Lcom/bytedance/trae/conversation/devices/DirectoryNode;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/network/FolderNode;->getChildren()Ljava/util/List;
    move-result-object v1
    if-eqz v1, +022h
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +016h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/FolderNode;
    add-int/lit8 v4, v21, 1
    move-object/from16 v5, v19
    invoke-direct v5, v2, v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->flattenFolderNode(Lcom/bytedance/trae/conversation/network/FolderNode; I)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    goto -19h
    move-object/from16 v5, v19
    return-object v0
.end method

.method static synthetic flattenFolderNode$default(com.bytedance.trae.conversation.devices.DirectoryViewModel  com.bytedance.trae.conversation.network.FolderNode  int  int  java.lang.Object)java.util.List
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->flattenFolderNode(Lcom/bytedance/trae/conversation/network/FolderNode; I)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method private final flattenFolderNodeShallow(com.bytedance.trae.conversation.network.FolderNode)java.util.List
    .registers 22
    # ins_size=2
    if-nez v21, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/network/FolderNode;->getHasChildren()Z
    move-result v1
    const/4 v2, 0
    const/4 v3, 1
    if-nez v1, +019h
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/network/FolderNode;->getChildren()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-nez v1, +003h
    goto +3h
    move v10, v2
    goto +2h
    move v10, v3
    if-eqz v10, +018h
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/network/FolderNode;->getChildren()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-nez v1, +004h
    move v13, v3
    goto +2h
    move v13, v2
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/network/FolderNode;->getPath()Ljava/lang/String;
    move-result-object v5
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/network/FolderNode;->getName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/network/FolderNode;->getPath()Ljava/lang/String;
    move-result-object v7
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/4 v8, 0
    const/4 v9, 0
    const/4 v12, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 1680
    const/16 v17, 0
    move-object v4, v1
    move v11, v13
    invoke-direct/range v4 ... v17, Lcom/bytedance/trae/conversation/devices/DirectoryNode;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/network/FolderNode;->getChildren()Ljava/util/List;
    move-result-object v1
    if-eqz v1, +058h
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +04ch
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/network/FolderNode;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/FolderNode;->getHasChildren()Z
    move-result v5
    if-nez v5, +019h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/FolderNode;->getChildren()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/util/Collection;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v2
    goto +2h
    move v5, v3
    if-nez v5, +003h
    goto +3h
    move v12, v2
    goto +2h
    move v12, v3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/FolderNode;->getPath()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/FolderNode;->getName()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/FolderNode;->getPath()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/network/FolderNode;->getPath()Ljava/lang/String;
    move-result-object v11
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/4 v10, 1
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 1664
    const/16 v19, 0
    move-object v6, v4
    invoke-direct/range v6 ... v19, Lcom/bytedance/trae/conversation/devices/DirectoryNode;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -4fh
    return-object v0
.end method

.method private final getString(int)java.lang.String
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v0, v2, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v0, "getString(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method private final listFolder(java.lang.String  int  boolean)void
    .registers 15
    # ins_size=4
    iget-object v2, v11, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cliId Ljava/lang/String;
    if-nez v2, +003h
    return-void 
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v7
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$listFolder$1;
    const/4 v6, 0
    move-object v0, v10
    move-object v1, v11
    move-object v3, v12
    move v4, v13
    move v5, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$listFolder$1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Ljava/lang/String; Ljava/lang/String; I Z Lkotlin/coroutines/Continuation;)V
    move-object v6, v10
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v12, 3
    const/4 v13, 0
    move-object v3, v7
    move-object v4, v8
    move-object v5, v9
    move v7, v12
    move-object v8, v13
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method static synthetic listFolder$default(com.bytedance.trae.conversation.devices.DirectoryViewModel  java.lang.String  int  boolean  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->listFolder(Ljava/lang/String; I Z)V
    return-void 
.end method

.method public static synthetic loadDocumentFolder$default(com.bytedance.trae.conversation.devices.DirectoryViewModel  java.lang.String  int  boolean  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 3
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->loadDocumentFolder(Ljava/lang/String; I Z)V
    return-void 
.end method

.method public static synthetic submitAuthorizationResult$default(com.bytedance.trae.conversation.devices.DirectoryViewModel  java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->submitAuthorizationResult(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private final updatePlaceholderState(java.lang.String  boolean  boolean  java.lang.String)void
    .registers 23
    # ins_size=5
    move-object/from16 v0, v18
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const/4 v5, -1
    if-eqz v4, +018h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v4
    move-object/from16 v6, v19
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +5h
    add-int/lit8 v2, v2, 1
    goto -1ch
    move v2, v5
    if-eq v2, v5, +041h
    invoke-interface v3, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    if-nez v22, +008h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getName()Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v22
    const/4 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v13, 0
    const/4 v15, 0
    const/16 v16, 1405
    const/16 v17, 0
    move/from16 v12, v21
    move/from16 v14, v20
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryNode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v1
    invoke-interface v3, v2, v1, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 62
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method static synthetic updatePlaceholderState$default(com.bytedance.trae.conversation.devices.DirectoryViewModel  java.lang.String  boolean  boolean  java.lang.String  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->updatePlaceholderState(Ljava/lang/String; Z Z Ljava/lang/String;)V
    return-void 
.end method

.method public final cancelNewFolder(java.lang.String)void
    .registers 12
    # ins_size=2
    const-string v0, "placeholderId"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$$ExternalSyntheticLambda0;
    invoke-direct v0, v11, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String;)V
    invoke-static v2, v0, Lkotlin/collections/CollectionsKt;->removeAll(Ljava/util/List; Lkotlin/jvm/functions/Function1;)Z
    iget-object v11, v10, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v11, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 62
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v0
    invoke-interface v11, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final checkNeedAuthorization(java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 13
    # ins_size=3
    const-string v0, "path"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v10, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cliId Ljava/lang/String;
    if-nez v2, +003h
    return-void 
    move-object v0, v10
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$checkNeedAuthorization$1;
    const/4 v6, 0
    move-object v1, v9
    move-object v3, v11
    move-object v4, v12
    move-object v5, v10
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$checkNeedAuthorization$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v6, v9
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v11, 3
    const/4 v12, 0
    move-object v3, v0
    move-object v4, v7
    move-object v5, v8
    move v7, v11
    move-object v8, v12
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final clearSelection()void
    .registers 19
    # ins_size=1
    move-object/from16 v0, v18
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +020h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 1023
    const/16 v17, 0
    invoke-static/range v4 ... v17, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryNode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -23h
    move-object v5, v2
    check-cast v5, Ljava/util/List;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 62
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final getChatMode()com.bytedance.trae.im.service.Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->chatMode Lcom/bytedance/trae/im/service/Mode;
    return-object v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getDefaultFolder()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->defaultFolder Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getEvents()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->events Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getFolderTree()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->folderTree Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getMode()com.bytedance.trae.conversation.devices.DirectoryViewModel$Mode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->mode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    return-object v0
.end method

.method public final getPreselectedPath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->preselectedPath Ljava/lang/String;
    return-object v0
.end method

.method public final getUiState()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->uiState Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getUserFolders()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->userFolders Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final loadDocumentFolder(java.lang.String  int  boolean)void
    .registers 15
    # ins_size=4
    const-string v0, "path"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->DOCUMENT Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    iput-object v0, v11, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->mode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    iget-object v0, v11, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    sget-object v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->DOCUMENT Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    const/16 v9, 31
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-direct v11, v12, v13, v14, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->listFolder(Ljava/lang/String; I Z)V
    return-void 
.end method

.method public final loadInitialData()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cliId Ljava/lang/String;
    if-nez v0, +003h
    return-void 
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;
    const/4 v5, 0
    invoke-direct v1, v8, v0, v5, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final onAddNewFolderClicked()void
    .registers 13
    # ins_size=1
    iget-object v0, v12, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v2
    move-object v0, v2
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v1, +00dh
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v1, v3
    goto +18h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, -00ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing()Z
    move-result v5
    if-eqz v5, -010h
    move v1, v4
    if-eqz v1, +003h
    return-void 
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v10, 0
    if-eqz v5, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isSelected()Z
    move-result v6
    if-eqz v6, -012h
    goto +2h
    move-object v5, v10
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    new-instance v11, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v11, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    if-eqz v5, +01ch
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded()Z
    move-result v1
    if-eqz v1, +016h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v1
    add-int/2addr v1, v4
    invoke-interface v2, v5, Ljava/util/List;->indexOf(Ljava/lang/Object;)I
    move-result v3
    add-int/2addr v3, v4
    iput v3, v11, Lkotlin/jvm/internal/Ref$IntRef;->element I
    move-object v5, v0
    move v6, v1
    goto/16 +089h
    if-eqz v5, +01fh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getHasChildren()Z
    move-result v1
    if-eqz v1, +019h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded()Z
    move-result v1
    if-nez v1, +013h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v1
    add-int/2addr v1, v4
    invoke-interface v2, v5, Ljava/util/List;->indexOf(Ljava/lang/Object;)I
    move-result v3
    add-int/2addr v3, v4
    iput v3, v11, Lkotlin/jvm/internal/Ref$IntRef;->element I
    goto -22h
    if-eqz v5, +032h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getParentId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00eh
    iget-object v0, v12, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getCurrentParentId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v1
    invoke-interface v2, v5, Ljava/util/List;->indexOf(Ljava/lang/Object;)I
    move-result v3
    sub-int/2addr v3, v4
    if-ltz v3, +011h
    invoke-interface v2, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v5
    if-lt v5, v1, +005h
    add-int/lit8 v3, v3, -1
    goto -10h
    add-int/2addr v3, v4
    iput v3, v11, Lkotlin/jvm/internal/Ref$IntRef;->element I
    goto -54h
    iget-object v1, v12, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getCurrentParentId()Ljava/lang/String;
    move-result-object v1
    iput v3, v11, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move v5, v3
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +01dh
    add-int/2addr v5, v4
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, -015h
    iput v5, v11, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v0
    add-int/2addr v0, v4
    move v6, v0
    move-object v5, v1
    goto +3h
    move-object v5, v1
    move v6, v3
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->Companion Lcom/bytedance/trae/conversation/devices/DirectoryNode$Companion;
    invoke-virtual v0, v5, v6, Lcom/bytedance/trae/conversation/devices/DirectoryNode$Companion;->newFolderPlaceholder(Ljava/lang/String; I)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v0
    iget v1, v11, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-interface v2, v1, v0, Ljava/util/List;->add(I Ljava/lang/Object;)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v7, 0
    const/16 v8, 38
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    move-object v0, v12
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onAddNewFolderClicked$2;
    invoke-direct v0, v12, v11, v10, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onAddNewFolderClicked$2;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final onNewFolderNameConfirmed(java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=3
    const-string v0, "placeholderId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "finalName"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v9
    move-object v0, v9
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +006h
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cancelNewFolder(Ljava/lang/String;)V
    return-void 
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v9, v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final onNodeClicked(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 3
    # ins_size=2
    const-string v0, "node"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getHasChildren()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded()Z
    move-result v0
    if-eqz v0, +006h
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->collapseNode(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    goto +4h
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->expandNode(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    return-void 
.end method

.method public final onNodeSelected(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 21
    # ins_size=2
    move-object/from16 v0, v19
    const-string v1, "node"
    move-object/from16 v2, v20
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v4, 10
    invoke-static v1, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v3, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +02dh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v15
    invoke-static v4, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    const/16 v17, 1023
    const/16 v18, 0
    const/4 v15, 0
    move/from16 v16, v4
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryNode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -30h
    move-object v6, v3
    check-cast v6, Ljava/util/List;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->_uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 62
    const/4 v13, 0
    invoke-static/range v5 ... v13, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final setChatMode(com.bytedance.trae.im.service.Mode)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->chatMode Lcom/bytedance/trae/im/service/Mode;
    return-void 
.end method

.method public final setCliId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cliId Ljava/lang/String;
    return-void 
.end method

.method public final setMode(com.bytedance.trae.conversation.devices.DirectoryViewModel$Mode)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->mode Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    return-void 
.end method

.method public final setPreselectedPath(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->preselectedPath Ljava/lang/String;
    return-void 
.end method

.method public final submitAuthorizationResult(java.lang.String  java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 15
    # ins_size=4
    const-string v0, "path"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "action"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v11, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cliId Ljava/lang/String;
    if-nez v2, +003h
    return-void 
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;
    const/4 v7, 0
    move-object v1, v10
    move-object v3, v12
    move-object v4, v13
    move-object v5, v11
    move-object v6, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$submitAuthorizationResult$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    move-object v6, v10
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v12, 0
    move-object v3, v0
    move-object v4, v8
    move-object v5, v9
    move-object v8, v12
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
