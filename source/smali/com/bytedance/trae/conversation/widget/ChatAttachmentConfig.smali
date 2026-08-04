# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;
.super Ljava/lang/Object;
.source "ChatAttachmentConfig.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;
.field private static final entries:Ljava/util/List;


.method public static synthetic $r8$lambda$FAg3m7yRIqSzqtqduTHJpldJmdo(com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->entries$lambda$3(Lcom/bytedance/trae/conversation/widget/ChatMode; Z Z Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$NU9G0hx63pF81UcRh3g1QhIuQko(com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->entries$lambda$4(Lcom/bytedance/trae/conversation/widget/ChatMode; Z Z Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$aNwtPbw6WXAGanIcYvbn6SOCwbg(com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->entries$lambda$0(Lcom/bytedance/trae/conversation/widget/ChatMode; Z Z Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$fWJfUEanWjztoK7hPCNTCPV8PRc(com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->entries$lambda$2(Lcom/bytedance/trae/conversation/widget/ChatMode; Z Z Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$xEjcohUtPoZcBY7VVd4NmgizX4A(com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String)boolean
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->entries$lambda$1(Lcom/bytedance/trae/conversation/widget/ChatMode; Z Z Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 14
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->INSTANCE Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;
    const/4 v0, 5
    new-array v0, v0, [Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    new-instance v7, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->CAMERA Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->btn_camera I
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_chat_attachment_camera I
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_attachment_camera I
    new-instance v6, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig$$ExternalSyntheticLambda0;
    invoke-direct v6, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig$$ExternalSyntheticLambda0;-><init>()V
    move-object v1, v7
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;-><init>(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType; I I I Lkotlin/jvm/functions/Function4;)V
    const/4 v1, 0
    aput-object v7, v0, v1
    new-instance v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    sget-object v9, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PHOTO Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    sget v10, Lcom/bytedance/trae/conversation/R$id;->btn_photo I
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->ic_chat_attachment_photo I
    sget v12, Lcom/bytedance/trae/multilanguage/R$string;->trae_attachment_photo I
    new-instance v13, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig$$ExternalSyntheticLambda1;
    invoke-direct v13, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig$$ExternalSyntheticLambda1;-><init>()V
    move-object v8, v1
    invoke-direct/range v8 ... v13, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;-><init>(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType; I I I Lkotlin/jvm/functions/Function4;)V
    const/4 v2, 1
    aput-object v1, v0, v2
    new-instance v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    sget-object v4, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->FILES Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->btn_files I
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->ic_chat_attachment_files I
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_attachment_files I
    new-instance v8, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig$$ExternalSyntheticLambda2;
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig$$ExternalSyntheticLambda2;-><init>()V
    move-object v3, v1
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;-><init>(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType; I I I Lkotlin/jvm/functions/Function4;)V
    const/4 v2, 2
    aput-object v1, v0, v2
    new-instance v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    sget-object v4, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PLUGINS Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->btn_plugins I
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->ic_chat_attachment_plugins I
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_attachment_plugins I
    new-instance v8, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig$$ExternalSyntheticLambda3;
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig$$ExternalSyntheticLambda3;-><init>()V
    move-object v3, v1
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;-><init>(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType; I I I Lkotlin/jvm/functions/Function4;)V
    const/4 v2, 3
    aput-object v1, v0, v2
    new-instance v1, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;
    sget-object v4, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->SKILLS Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->btn_skills I
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->ic_chat_attachment_skills I
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_attachment_skills I
    new-instance v8, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig$$ExternalSyntheticLambda4;
    invoke-direct v8, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig$$ExternalSyntheticLambda4;-><init>()V
    move-object v3, v1
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/widget/AttachmentEntry;-><init>(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType; I I I Lkotlin/jvm/functions/Function4;)V
    const/4 v2, 4
    aput-object v1, v0, v2
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->entries Ljava/util/List;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final entries$lambda$0(com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String)boolean
    .registers 4
    # ins_size=4
    const-string v1, "<unused var>"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    return v0
.end method

.method private static final entries$lambda$1(com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String)boolean
    .registers 4
    # ins_size=4
    const-string v1, "<unused var>"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    return v0
.end method

.method private static final entries$lambda$2(com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String)boolean
    .registers 4
    # ins_size=4
    const-string v1, "mode"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private static final entries$lambda$3(com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String)boolean
    .registers 5
    # ins_size=4
    const-string v0, "<unused var>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +016h
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    sget-object v3, Lcom/bytedance/trae/settings/api/feature/Feature;->PLUGIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v1, v3, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v1
    if-eqz v1, +00ch
    sget-object v1, Lcom/bytedance/trae/conversation/network/PluginCapability;->INSTANCE Lcom/bytedance/trae/conversation/network/PluginCapability;
    invoke-virtual v1, v2, v4, Lcom/bytedance/trae/conversation/network/PluginCapability;->isSupported(Z Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method private static final entries$lambda$4(com.bytedance.trae.conversation.widget.ChatMode  boolean  boolean  java.lang.String)boolean
    .registers 4
    # ins_size=4
    const-string v1, "<unused var>"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    return v0
.end method

.method public final getEntries()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->entries Ljava/util/List;
    return-object v0
.end method

.method public final rowLayout(int)java.util.List
    .registers 7
    # ins_size=2
    if-eqz v6, +069h
    const/4 v0, 1
    if-eq v6, v0, +05dh
    const/4 v1, 2
    if-eq v6, v1, +051h
    const/4 v2, 3
    if-eq v6, v2, +045h
    const/4 v3, 4
    const/4 v4, 0
    if-eq v6, v3, +02eh
    const/4 v3, 5
    if-eq v6, v3, +018h
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    sub-int/2addr v6, v2
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;->rowLayout(I)Ljava/util/List;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    invoke-static v0, v6, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v6
    goto +46h
    new-array v6, v1, [Ljava/lang/Integer;
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    aput-object v2, v6, v4
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    aput-object v1, v6, v0
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    goto +33h
    new-array v6, v1, [Ljava/lang/Integer;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    aput-object v2, v6, v4
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    aput-object v1, v6, v0
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    goto +20h
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    goto +17h
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    goto +eh
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v6
    return-object v6
.end method
