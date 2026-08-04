# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationUtils;
.super Ljava/lang/Object;
.source "ConversationUtils.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/ConversationUtils;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationUtils;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationUtils;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/ConversationUtils;->INSTANCE Lcom/bytedance/trae/conversation/ConversationUtils;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final resolveInitialConversation(java.lang.String  com.bytedance.trae.im.service.Conversation)com.bytedance.trae.im.service.Conversation
    .registers 5
    # ins_size=3
    if-nez v4, +04ah
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    goto +37h
    const-class v4, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v4
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v4, v0, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v4, +026h
    invoke-interface v4, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v4
    if-eqz v4, +020h
    invoke-virtual v4, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +01ah
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseManager;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseManager;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/im/database/DatabaseManager;->getDatabase(Landroid/content/Context; Ljava/lang/String;)Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    move-result-object v4
    new-instance v0, Lcom/bytedance/trae/im/database/ConversationDao;
    invoke-direct v0, v4, Lcom/bytedance/trae/im/database/ConversationDao;-><init>(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V
    invoke-virtual v0, v3, Lcom/bytedance/trae/im/database/ConversationDao;->queryById(Ljava/lang/String;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v3
    return-object v3
    const/4 v3, 0
    return-object v3
    return-object v4
.end method
