# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/skill/SkillsViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "SkillsViewModel.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/skill/SkillsViewModel$Companion;
.field private static final DEVICE_OFFLINE_CODE:I
.field private static final PAGE_SIZE:I
.field private final _error:Landroidx/lifecycle/MutableLiveData;
.field private final _isDeviceOffline:Landroidx/lifecycle/MutableLiveData;
.field private final _isDeviceProjectOffline:Landroidx/lifecycle/MutableLiveData;
.field private final _skills:Landroidx/lifecycle/MutableLiveData;
.field private agentType:Ljava/lang/String;
.field private cliId:Ljava/lang/String;
.field private configName:Ljava/lang/String;
.field private conversationId:Ljava/lang/String;
.field private final error:Landroidx/lifecycle/LiveData;
.field private final isDeviceOffline:Landroidx/lifecycle/LiveData;
.field private final isDeviceProjectOffline:Landroidx/lifecycle/LiveData;
.field private nextPageToken:Ljava/lang/String;
.field private projectId:Ljava/lang/String;
.field private final skills:Landroidx/lifecycle/LiveData;
.field private workspaceFolder:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->Companion Lcom/bytedance/trae/conversation/skill/SkillsViewModel$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Landroidx/lifecycle/ViewModel;-><init>()V
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->_skills Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->skills Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->_error Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->error Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->_isDeviceOffline Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->isDeviceOffline Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->_isDeviceProjectOffline Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->isDeviceProjectOffline Landroidx/lifecycle/LiveData;
    return-void 
.end method

.method public static final synthetic access$getNextPageToken$p(com.bytedance.trae.conversation.skill.SkillsViewModel)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->nextPageToken Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$get_error$p(com.bytedance.trae.conversation.skill.SkillsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->_error Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_isDeviceOffline$p(com.bytedance.trae.conversation.skill.SkillsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->_isDeviceOffline Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_isDeviceProjectOffline$p(com.bytedance.trae.conversation.skill.SkillsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->_isDeviceProjectOffline Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_skills$p(com.bytedance.trae.conversation.skill.SkillsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->_skills Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$isDeviceOfflineError(com.bytedance.trae.conversation.skill.SkillsViewModel  java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->isDeviceOfflineError(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$setNextPageToken$p(com.bytedance.trae.conversation.skill.SkillsViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->nextPageToken Ljava/lang/String;
    return-void 
.end method

.method private final fetchSkills(boolean)void
    .registers 9
    # ins_size=2
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/skill/SkillsViewModel$fetchSkills$1;-><init>(Lcom/bytedance/trae/conversation/skill/SkillsViewModel; Z Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final isDeviceOfflineError(java.lang.String)boolean
    .registers 5
    # ins_size=2
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v1
    if-eqz v0, +003h
    return v2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, v4, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string v4, "code"
    invoke-virtual v0, v4, v2, Lorg/json/JSONObject;->optInt(Ljava/lang/String; I)I
    move-result v4
    const v0, 2900101
    if-ne v4, v0, +003h
    goto +2h
    move v1, v2
    move v2, v1
    return v2
    :try_start_0x14
.end method

.method public final getAgentType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getConfigName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->configName Ljava/lang/String;
    return-object v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getError()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->error Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getProjectId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->projectId Ljava/lang/String;
    return-object v0
.end method

.method public final getSkills()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->skills Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getWorkspaceFolder()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->workspaceFolder Ljava/lang/String;
    return-object v0
.end method

.method public final isDeviceOffline()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->isDeviceOffline Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final isDeviceProjectOffline()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->isDeviceProjectOffline Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final loadSkills()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->nextPageToken Ljava/lang/String;
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->fetchSkills(Z)V
    return-void 
.end method

.method public final setAgentType(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->agentType Ljava/lang/String;
    return-void 
.end method

.method public final setCliId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->cliId Ljava/lang/String;
    return-void 
.end method

.method public final setConfigName(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->configName Ljava/lang/String;
    return-void 
.end method

.method public final setConversationId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->conversationId Ljava/lang/String;
    return-void 
.end method

.method public final setProjectId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->projectId Ljava/lang/String;
    return-void 
.end method

.method public final setWorkspaceFolder(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsViewModel;->workspaceFolder Ljava/lang/String;
    return-void 
.end method
