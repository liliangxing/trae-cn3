# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
.super Ljava/lang/Object;
.source "ModelSelectionRepository.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
.field private static final KEY_PREFIX_MODE:Ljava/lang/String;
.field private static final KEY_PREFIX_SESSION:Ljava/lang/String;
.field public static final MODE_CODE:Ljava/lang/String;
.field public static final MODE_MTC:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final gson:Lcom/google/gson/Gson;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->gson Lcom/google/gson/Gson;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final load(java.lang.String)com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 8
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v7, v1, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    return-object v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v6
    check-cast v2, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    sget-object v2, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->gson Lcom/google/gson/Gson;
    const-class v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v2, v0, v3, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v2
    if-eqz v2, +018h
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "load failed, key="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v4, "ModelSelectionRepository"
    invoke-virtual v3, v4, v7, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    xor-int/lit8 v7, v7, 1
    if-eqz v7, +003h
    move-object v1, v0
    return-object v1
    :try_start_0xe
.end method

.method private final modeKey(java.lang.String  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, solo_model_selection_mode_
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v0, 95
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final save(java.lang.String  com.bytedance.trae.conversation.network.RemoteModelItem)void
    .registers 7
    # ins_size=3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;
    sget-object v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->gson Lcom/google/gson/Gson;
    invoke-virtual v1, v6, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v5, v1, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-eqz v0, +027h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, save failed, key=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ", model="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v6, "ModelSelectionRepository"
    invoke-virtual v1, v6, v5, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method private final sessionKey(java.lang.String  java.lang.String  java.lang.String)java.lang.String
    .registers 6
    # ins_size=4
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, solo_model_selection_session_
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v0, 95
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public final environmentKey(com.bytedance.trae.im.service.CliType)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "cliType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public final loadModeSelection(java.lang.String  java.lang.String)com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 4
    # ins_size=3
    const-string v0, "environment"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->modeKey(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->load(Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v2
    return-object v2
.end method

.method public final loadSelection(java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 5
    # ins_size=4
    const-string v0, "environment"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->loadSessionSelection(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v4
    if-nez v4, +00eh
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->loadModeSelection(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v4
    if-nez v4, +008h
    sget-object v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v4
    return-object v4
.end method

.method public final loadSessionSelection(java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 5
    # ins_size=4
    const-string v0, "environment"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +004h
    const/4 v2, 0
    return-object v2
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->sessionKey(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->load(Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v2
    return-object v2
.end method

.method public final modeKey(com.bytedance.trae.im.service.Mode)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "mode"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/Mode;->CODE Lcom/bytedance/trae/im/service/Mode;
    if-ne v2, v0, +005h
    const-string v2, "code"
    goto +3h
    const-string v2, "mtc"
    return-object v2
.end method

.method public final resolveValidSelection(com.bytedance.trae.conversation.network.RemoteModelItem  java.util.List)com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 8
    # ins_size=3
    const-string/jumbo v0, selected
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "models"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +009h
    sget-object v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v6
    return-object v6
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +04eh
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    const/4 v3, 1
    if-nez v2, +035h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +027h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getCustomModelId()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v4, 0
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v4
    goto +2h
    move v2, v3
    if-nez v2, +011h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getCustomModelId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getCustomModelId()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move v3, v4
    if-eqz v3, -04fh
    goto +2h
    const/4 v0, 0
    check-cast v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    if-nez v0, +008h
    sget-object v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v0
    return-object v0
.end method

.method public final saveModeSelection(java.lang.String  java.lang.String  com.bytedance.trae.conversation.network.RemoteModelItem)void
    .registers 5
    # ins_size=4
    const-string v0, "environment"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "model"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->modeKey(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v2, v4, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->save(Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)V
    return-void 
.end method

.method public final saveSessionSelection(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.network.RemoteModelItem)void
    .registers 6
    # ins_size=5
    const-string v0, "environment"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "model"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    return-void 
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->sessionKey(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v2, v5, Lcom/bytedance/trae/conversation/network/ModelSelectionRepository;->save(Ljava/lang/String; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)V
    return-void 
.end method
