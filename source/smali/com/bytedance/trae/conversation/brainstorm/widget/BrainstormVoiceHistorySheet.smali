# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "BrainstormVoiceHistorySheet.kt"

.field private static final ARG_CONVERSATION_ID:Ljava/lang/String;
.field private static final ARG_SESSION_ID:Ljava/lang/String;
.field private static final CACHE_MAX_SIZE:I
.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;
.field public static final FRAGMENT_TAG:Ljava/lang/String;
.field private static final ROLE_USER:Ljava/lang/String;
.field private static final SCENE_ID:Ljava/lang/String;
.field private static final SHEET_HEIGHT_RATIO:F
.field private static final TAG:Ljava/lang/String;
.field private static final VIEW_TYPE_ASSISTANT:I
.field private static final VIEW_TYPE_USER_ATTACHMENT:I
.field private static final VIEW_TYPE_USER_IMAGE_GROUP:I
.field private static final VIEW_TYPE_USER_TEXT:I
.field private static final historyCache:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1;
.field private adapter:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;
.field private closeView:Landroid/widget/ImageView;
.field private emptyView:Landroid/view/View;
.field private final imageUploadApi$delegate:Lkotlin/Lazy;
.field private recyclerView:Landroidx/recyclerview/widget/RecyclerView;
.field private final resourceUploadApi$delegate:Lkotlin/Lazy;
.field private statusView:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$A4QTixel13zEgvV86ePK0-ER-XU()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->imageUploadApi_delegate$lambda$1$lambda$0()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$IrxcA8eb9naamO3Jt5NGSdPI2ds(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->onViewCreated$lambda$4(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$i0BKcjK7D5XJm4LcbH48Q7HpQ7M()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->resourceUploadApi_delegate$lambda$3()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$mNi8lpBxRHd76kq9d3H-fl7tG8A()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->resourceUploadApi_delegate$lambda$3$lambda$2()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pkbp9fR5mLw6Qz3Tm1bK1hu7LUQ(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->onViewCreated$lambda$5(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$qv0PXFxwf-zX_a7zce_oaXq0n3U()com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->imageUploadApi_delegate$lambda$1()Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->Companion Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->historyCache Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda4;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda4;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->imageUploadApi$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda5;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda5;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->resourceUploadApi$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$getConversationId(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet)java.lang.String
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getConversationId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getHistoryCache$cp()com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$Companion$historyCache$1
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->historyCache Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1;
    return-object v0
.end method

.method public static final synthetic access$getSessionId(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet)java.lang.String
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getSessionId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$renderResult(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet  com.bytedance.trae.network.response.HttpDataResult)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->renderResult(Lcom/bytedance/trae/network/response/HttpDataResult;)V
    return-void 
.end method

.method private final fetchHistory(boolean)void
    .registers 8
    # ins_size=2
    if-nez v7, +01ch
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->historyCache Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1;
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getSessionId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v7, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;
    if-eqz v7, +00eh
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;->getEntries()Ljava/util/List;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;->getChatSessionId()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->showEntries(Ljava/util/List; Ljava/lang/String;)V
    return-void 
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->showLoading()V
    move-object v7, v6
    check-cast v7, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v7, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v7
    move-object v0, v7
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;
    const/4 v3, 0
    invoke-direct v7, v6, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet; Lkotlin/coroutines/Continuation;)V
    move-object v3, v7
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final getConversationId()java.lang.String
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +009h
    const-string v1, "arg_conversation_id"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method private final getImageUploadApi()com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->imageUploadApi$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    return-object v0
.end method

.method private final getResourceUploadApi()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->resourceUploadApi$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    return-object v0
.end method

.method private final getSessionId()java.lang.String
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +009h
    const-string v1, "arg_session_id"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method private static final imageUploadApi_delegate$lambda$1()com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 7
    # ins_size=0
    new-instance v6, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda0;-><init>()V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v6
.end method

.method private static final imageUploadApi_delegate$lambda$1$lambda$0()java.lang.String
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->dismissAllowingStateLoss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet  android.view.View)void
    .registers 2
    # ins_size=2
    const/4 v1, 1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->fetchHistory(Z)V
    return-void 
.end method

.method private final renderResult(com.bytedance.trae.network.response.HttpDataResult)void
    .registers 8
    # ins_size=2
    instance-of v0, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v1, "BrainstormVoiceHistory"
    if-eqz v0, +08dh
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;
    const/4 v0, 0
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->getHistoryContext()Ljava/util/List;
    move-result-object v2
    goto +2h
    move-object v2, v0
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    const/4 v3, 1
    if-eqz v7, +013h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->getChatSessionId()Ljava/lang/String;
    move-result-object v7
    if-eqz v7, +00dh
    move-object v4, v7
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v3
    if-eqz v4, +003h
    move-object v0, v7
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "fetch success: sessionId="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getSessionId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", count="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", hasChatSessionId="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object v5, v0
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    const/4 v5, 0
    goto +2h
    move v5, v3
    xor-int/2addr v3, v5
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v7, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v7
    if-eqz v7, +006h
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->showEmpty()V
    goto +51h
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->Companion Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getSessionId()Ljava/lang/String;
    move-result-object v1
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;
    invoke-direct v3, v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;-><init>(Ljava/util/List; Ljava/lang/String;)V
    invoke-static v7, v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;->access$putCache(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;)V
    invoke-direct v6, v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->showEntries(Ljava/util/List; Ljava/lang/String;)V
    goto +3fh
    instance-of v0, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +03dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "fetch error: sessionId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getSessionId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", code="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v7
    invoke-virtual v0, v1, v2, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget v7, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_voice_history_error I
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getString(I)Ljava/lang/String;
    move-result-object v7
    const-string v0, "getString(...)"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->showError(Ljava/lang/String;)V
    return-void 
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
.end method

.method private static final resourceUploadApi_delegate$lambda$3()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 7
    # ins_size=0
    new-instance v6, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda3;
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda3;-><init>()V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v6
.end method

.method private static final resourceUploadApi_delegate$lambda$3$lambda$2()java.lang.String
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final showEmpty()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "recyclerView"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->statusView Landroid/widget/TextView;
    const-string/jumbo v3, statusView
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->emptyView Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "emptyView"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->statusView Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, v2, Landroid/widget/TextView;->setClickable(Z)V
    return-void 
.end method

.method private final showEntries(java.util.List  java.lang.String)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->adapter Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "adapter"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->submit(Ljava/util/List; Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->statusView Landroid/widget/TextView;
    if-nez v3, +009h
    const-string/jumbo v3, statusView
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    const/16 v4, 8
    invoke-virtual v3, v4, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->emptyView Landroid/view/View;
    if-nez v3, +008h
    const-string v3, "emptyView"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    invoke-virtual v3, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-nez v3, +008h
    const-string v3, "recyclerView"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    const/4 v3, 0
    invoke-virtual v1, v3, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    return-void 
.end method

.method private final showError(java.lang.String)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "recyclerView"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->emptyView Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "emptyView"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->statusView Landroid/widget/TextView;
    const-string/jumbo v2, statusView
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->statusView Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v0, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->statusView Landroid/widget/TextView;
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v5
    const/4 v5, 1
    invoke-virtual v1, v5, Landroid/widget/TextView;->setClickable(Z)V
    return-void 
.end method

.method private final showLoading()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "recyclerView"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->emptyView Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "emptyView"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->statusView Landroid/widget/TextView;
    const-string/jumbo v2, statusView
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->statusView Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_voice_history_loading I
    invoke-virtual v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getString(I)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->statusView Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, v3, Landroid/widget/TextView;->setClickable(Z)V
    return-void 
.end method

.method public getTheme()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$style;->Trae_BottomSheetDialog I
    return v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_layout_brainstorm_voice_history I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public onStart()void
    .registers 4
    # ins_size=1
    invoke-super v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onStart()V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getDialog()Landroid/app/Dialog;
    move-result-object v0
    if-eqz v0, +033h
    sget v1, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v0, v1, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-nez v0, +003h
    goto +29h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-float v1, v1
    const v2, 1061997773
    mul-float/2addr v1, v2
    float-to-int v1, v1
    invoke-virtual v0, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v2
    iput v1, v2, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v0, v2, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-static v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v0
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    const/4 v1, 3
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v3, v4, v5, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v5, Lcom/bytedance/trae/conversation/R$id;->tv_voice_history_status I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    const-string v0, "findViewById(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/widget/TextView;
    iput-object v5, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->statusView Landroid/widget/TextView;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->ll_voice_history_empty I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v5, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->emptyView Landroid/view/View;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->rv_voice_history I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v5, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->iv_voice_history_close I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/ImageView;
    iput-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->closeView Landroid/widget/ImageView;
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v5
    const-string v0, "getViewLifecycleOwner(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v5, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v5
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getImageUploadApi()Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    move-result-object v0
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getResourceUploadApi()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v1
    invoke-direct v4, v3, v5, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet; Landroidx/lifecycle/LifecycleCoroutineScope; Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi; Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V
    iput-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->adapter Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    const-string v5, "recyclerView"
    const/4 v0, 0
    if-nez v4, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    new-instance v1, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->requireContext()Landroid/content/Context;
    move-result-object v2
    invoke-direct v1, v2, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v4, v1, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-nez v4, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    iget-object v5, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->adapter Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;
    if-nez v5, +008h
    const-string v5, "adapter"
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v0
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v4, v5, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->closeView Landroid/widget/ImageView;
    if-nez v4, +008h
    const-string v4, "closeView"
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    new-instance v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda1;
    invoke-direct v5, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;)V
    invoke-virtual v4, v5, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->statusView Landroid/widget/TextView;
    if-nez v4, +009h
    const-string/jumbo v4, statusView
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v4
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda2;
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;)V
    invoke-virtual v0, v4, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getSessionId()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +011h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_voice_history_error I
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v5, "getString(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->showError(Ljava/lang/String;)V
    return-void 
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->historyCache Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1;
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getSessionId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;
    if-eqz v4, +03ah
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "cache hit: sessionId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->getSessionId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", count="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;->getEntries()Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "BrainstormVoiceHistory"
    invoke-virtual v5, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;->getEntries()Ljava/util/List;
    move-result-object v5
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;->getChatSessionId()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->showEntries(Ljava/util/List; Ljava/lang/String;)V
    goto +5h
    const/4 v4, 0
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->fetchHistory(Z)V
    return-void 
.end method
