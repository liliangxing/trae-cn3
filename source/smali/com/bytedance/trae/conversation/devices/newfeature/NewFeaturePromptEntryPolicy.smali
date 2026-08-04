# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntryPolicy;
.super Ljava/lang/Object;
.source "NewFeaturePromptPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntryPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntryPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntryPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntryPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntryPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final canRequestNaturalPrompt(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptEntry)boolean
    .registers 3
    # ins_size=2
    const-string v0, "entry"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntry;->NEW_CHAT Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntry;
    if-ne v2, v0, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method
