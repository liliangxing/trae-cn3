# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
.super Ljava/lang/Object;
.source "PluginAuthorizationDialogCreator.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;
.field private final originalService:Ljava/lang/String;
.field private final pluginDisplayName:Ljava/lang/String;
.field private final pluginName:Ljava/lang/String;
.field private final providerDisplayName:Ljava/lang/String;
.field private final providerRaw:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=6
    const-string v0, "pluginDisplayName"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "providerDisplayName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "providerRaw"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "originalService"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "pluginName"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginDisplayName Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerDisplayName Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerRaw Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->originalService Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginName Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginDisplayName Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerDisplayName Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerRaw Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->originalService Ljava/lang/String;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginName Ljava/lang/String;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move-object v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginDisplayName Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerDisplayName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerRaw Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->originalService Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginName Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor
    .registers 13
    # ins_size=6
    const-string v0, "pluginDisplayName"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "providerDisplayName"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "providerRaw"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "originalService"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "pluginName"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move-object v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginDisplayName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginDisplayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerDisplayName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerDisplayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerRaw Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerRaw Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->originalService Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->originalService Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginName Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginName Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getOriginalService()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->originalService Ljava/lang/String;
    return-object v0
.end method

.method public final getPluginDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginDisplayName Ljava/lang/String;
    return-object v0
.end method

.method public final getPluginName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginName Ljava/lang/String;
    return-object v0
.end method

.method public final getProviderDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerDisplayName Ljava/lang/String;
    return-object v0
.end method

.method public final getProviderRaw()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerRaw Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginDisplayName Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerDisplayName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerRaw Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->originalService Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PluginAuthorizationDescriptor(pluginDisplayName="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginDisplayName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", providerDisplayName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerDisplayName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", providerRaw="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->providerRaw Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", originalService="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->originalService Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", pluginName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;->pluginName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
