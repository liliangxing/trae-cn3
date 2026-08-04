# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
.super Landroidx/appcompat/widget/AppCompatEditText;
.source "TranscriptEditText.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/widget/TranscriptEditText$Companion;
.field public static final LONG_PRESS_TIMEOUT:J
.field private currentSkill:Lcom/bytedance/trae/conversation/widget/SkillItem;
.field private downX:F
.field private downY:F
.field private final handler:Landroid/os/Handler;
.field private isInternalUpdate:Z
.field private final longPressRunnable:Ljava/lang/Runnable;
.field private longPressTriggered:Z
.field private final touchSlop:I


.method public static synthetic $r8$lambda$w8nRMS8SDShpntRrdfUMiMrIxFM(com.bytedance.trae.conversation.widget.TranscriptEditText)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->longPressRunnable$lambda$10(Lcom/bytedance/trae/conversation/widget/TranscriptEditText;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->Companion Lcom/bytedance/trae/conversation/widget/TranscriptEditText$Companion;
    return-void 
.end method

.method public constructor <init>(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet)void
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Landroidx/appcompat/widget/AppCompatEditText;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    new-instance v3, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v4
    invoke-direct v3, v4, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->handler Landroid/os/Handler;
    invoke-static v2, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;
    move-result-object v2
    invoke-virtual v2, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->touchSlop I
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;
    move-object v3, v1
    check-cast v3, Landroid/widget/EditText;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;-><init>(Landroid/widget/EditText;)V
    check-cast v2, Landroid/text/TextWatcher;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    new-instance v2, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/TranscriptEditText;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->longPressRunnable Ljava/lang/Runnable;
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  android.util.AttributeSet  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +005h
    const v3, 16842862
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method public static final synthetic access$getTagSpans(com.bytedance.trae.conversation.widget.TranscriptEditText  android.text.Spanned)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getTagSpans(Landroid/text/Spanned;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setInternalUpdate$p(com.bytedance.trae.conversation.widget.TranscriptEditText  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdate Z
    return-void 
.end method

.method private final getTagSpans(android.text.Spanned)java.util.List
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v7, Landroid/text/Spanned;->length()I
    move-result v2
    const-class v3, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    const/4 v4, 0
    invoke-interface v7, v4, v2, v3, Landroid/text/Spanned;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v2
    const-string v3, "getSpans(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; [Ljava/lang/Object;)Z
    invoke-interface v7, Landroid/text/Spanned;->length()I
    move-result v2
    const-class v5, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    invoke-interface v7, v4, v2, v5, Landroid/text/Spanned;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; [Ljava/lang/Object;)Z
    invoke-static v0, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$getTagSpans$$inlined$sortedBy$1;
    invoke-direct v1, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$getTagSpans$$inlined$sortedBy$1;-><init>(Landroid/text/Spanned;)V
    check-cast v1, Ljava/util/Comparator;
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v7
    return-object v7
.end method

.method private final getTextExcludingSkillTag(java.lang.CharSequence)java.lang.String
    .registers 7
    # ins_size=2
    if-nez v6, +005h
    const-string v6, ""
    return-object v6
    instance-of v0, v6, Landroid/text/Spanned;
    if-eqz v0, +063h
    move-object v0, v6
    check-cast v0, Landroid/text/Spanned;
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getTagSpans(Landroid/text/Spanned;)Ljava/util/List;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +051h
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01bh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/widget/InputTagSpan;
    invoke-interface v0, v3, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I
    move-result v4
    invoke-interface v0, v3, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I
    move-result v3
    if-ge v2, v4, +009h
    invoke-interface v0, v2, v4, Landroid/text/Spanned;->subSequence(I I)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    move v2, v3
    goto -1eh
    invoke-interface v0, Landroid/text/Spanned;->length()I
    move-result v1
    if-ge v2, v1, +00dh
    invoke-interface v0, Landroid/text/Spanned;->length()I
    move-result v1
    invoke-interface v0, v2, v1, Landroid/text/Spanned;->subSequence(I I)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string/jumbo v0, toString(...)
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    return-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method

.method private static final longPressRunnable$lambda$10(com.bytedance.trae.conversation.widget.TranscriptEditText)void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->longPressTriggered Z
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->cancelLongPress()V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->performLongClick()Z
    return-void 
.end method

.method private final removeSkillTagInternal()void
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-interface v0, Landroid/text/Editable;->length()I
    move-result v1
    const-class v2, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    const/4 v3, 0
    invoke-interface v0, v3, v1, v2, Landroid/text/Editable;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v1
    const-string v2, "getSpans(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$removeSkillTagInternal$$inlined$removeSpansOfType$1;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$removeSkillTagInternal$$inlined$removeSpansOfType$1;-><init>(Landroid/text/Editable;)V
    check-cast v2, Ljava/util/Comparator;
    invoke-static v1, v2, Lkotlin/collections/ArraysKt;->sortedWith([Ljava/lang/Object; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +021h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/widget/InputTagSpan;
    invoke-interface v0, v2, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I
    move-result v3
    invoke-interface v0, v2, Landroid/text/Editable;->getSpanEnd(Ljava/lang/Object;)I
    move-result v4
    instance-of v5, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    if-eqz v5, +008h
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->release()V
    invoke-interface v0, v2, Landroid/text/Editable;->removeSpan(Ljava/lang/Object;)V
    invoke-interface v0, v3, v4, Landroid/text/Editable;->delete(I I)Landroid/text/Editable;
    goto -24h
    return-void 
.end method

.method private final synthetic removeSpansOfType(android.text.Editable)void
    .registers 7
    # ins_size=2
    invoke-interface v6, Landroid/text/Editable;->length()I
    move-result v0
    const/4 v1, 4
    const-string v2, "T"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->reifiedOperationMarker(I Ljava/lang/String;)V
    const-class v1, Lcom/bytedance/trae/conversation/widget/InputTagSpan;
    move-object v2, v1
    check-cast v2, Ljava/lang/Class;
    const/4 v2, 0
    invoke-interface v6, v2, v0, v1, Landroid/text/Editable;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getSpans(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, [Ljava/lang/Object;
    invoke-static Lkotlin/jvm/internal/Intrinsics;->needClassReification()V
    new-instance v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$removeSpansOfType$$inlined$sortedByDescending$1;
    invoke-direct v1, v6, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$removeSpansOfType$$inlined$sortedByDescending$1;-><init>(Landroid/text/Editable;)V
    check-cast v1, Ljava/util/Comparator;
    invoke-static v0, v1, Lkotlin/collections/ArraysKt;->sortedWith([Ljava/lang/Object; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +021h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputTagSpan;
    invoke-interface v6, v1, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I
    move-result v2
    invoke-interface v6, v1, Landroid/text/Editable;->getSpanEnd(Ljava/lang/Object;)I
    move-result v3
    instance-of v4, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    if-eqz v4, +008h
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->release()V
    invoke-interface v6, v1, Landroid/text/Editable;->removeSpan(Ljava/lang/Object;)V
    invoke-interface v6, v2, v3, Landroid/text/Editable;->delete(I I)Landroid/text/Editable;
    goto -24h
    return-void 
.end method

.method private final setInternalUpdateFlag(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdate Z
    return-void 
.end method

.method public final getContentSegments()java.util.List
    .registers 10
    # ins_size=1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-nez v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    move-object v1, v0
    check-cast v1, Landroid/text/Spanned;
    invoke-direct v9, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getTagSpans(Landroid/text/Spanned;)Ljava/util/List;
    move-result-object v1
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v3, 0
    move v4, v3
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, 1
    if-eqz v5, +068h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/widget/InputTagSpan;
    invoke-interface v0, v5, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I
    move-result v7
    invoke-interface v0, v5, Landroid/text/Editable;->getSpanEnd(Ljava/lang/Object;)I
    move-result v8
    if-ge v4, v7, +029h
    invoke-interface v0, v4, v7, Landroid/text/Editable;->subSequence(I I)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    move-object v7, v4
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-lez v7, +003h
    goto +2h
    move v6, v3
    if-eqz v6, +00ah
    new-instance v6, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Text;
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Text;-><init>(Ljava/lang/String;)V
    invoke-interface v2, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    instance-of v4, v5, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    if-eqz v4, +013h
    check-cast v5, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;->getSkillItem()Lcom/bytedance/trae/conversation/widget/SkillItem;
    move-result-object v4
    if-eqz v4, +01dh
    new-instance v5, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Skill;
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Skill;-><init>(Lcom/bytedance/trae/conversation/widget/SkillItem;)V
    invoke-interface v2, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +13h
    instance-of v4, v5, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    if-eqz v4, +012h
    new-instance v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Plugin;
    check-cast v5, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->getPluginItem()Lcom/bytedance/trae/conversation/widget/PluginTagItem;
    move-result-object v5
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Plugin;-><init>(Lcom/bytedance/trae/conversation/widget/PluginTagItem;)V
    invoke-interface v2, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move v4, v8
    goto -66h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    invoke-interface v0, Landroid/text/Editable;->length()I
    move-result v1
    if-ge v4, v1, +02ch
    invoke-interface v0, Landroid/text/Editable;->length()I
    move-result v1
    invoke-interface v0, v4, v1, Landroid/text/Editable;->subSequence(I I)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +003h
    move v3, v6
    if-eqz v3, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Text;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Text;-><init>(Ljava/lang/String;)V
    invoke-interface v2, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-object v2
.end method

.method public final getSelectedSkill()com.bytedance.trae.conversation.widget.SkillItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    return-object v0
.end method

.method public final getSkillList()java.util.List
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-nez v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    invoke-interface v0, Landroid/text/Editable;->length()I
    move-result v1
    const-class v2, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    const/4 v3, 0
    invoke-interface v0, v3, v1, v2, Landroid/text/Editable;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v1
    const-string v2, "getSpans(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$getSkillList$$inlined$sortedBy$1;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$getSkillList$$inlined$sortedBy$1;-><init>(Landroid/text/Editable;)V
    check-cast v2, Ljava/util/Comparator;
    invoke-static v1, v2, Lkotlin/collections/ArraysKt;->sortedWith([Ljava/lang/Object; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +012h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;->getSkillItem()Lcom/bytedance/trae/conversation/widget/SkillItem;
    move-result-object v2
    if-eqz v2, -010h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method public final hasInputTag()boolean
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-nez v0, +004h
    const/4 v0, 0
    return v0
    check-cast v0, Landroid/text/Spanned;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getTagSpans(Landroid/text/Spanned;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    return v0
.end method

.method public final insertPluginTag(com.bytedance.trae.conversation.widget.PluginTagItem)void
    .registers 25
    # ins_size=2
    move-object/from16 v0, v23
    const-string v1, "plugin"
    move-object/from16 v6, v24
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 1
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdate Z
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v1
    const/4 v15, 0
    if-nez v1, +008h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    iput-boolean v15, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdate Z
    return-void 
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getSelectionStart()I
    move-result v2
    invoke-interface v1, Landroid/text/Editable;->length()I
    move-result v3
    invoke-static v2, v15, v3, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v14
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3,  
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/PluginTagItem;->getDisplayName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 160
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v19
    new-instance v13, Landroid/text/SpannableStringBuilder;
    move-object/from16 v2, v19
    check-cast v2, Ljava/lang/CharSequence;
    invoke-direct v13, v2, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V
    new-instance v12, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    move-object v2, v12
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v4
    move-object v3, v4
    const-string v11, "getContext(...)"
    invoke-static v4, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/PluginTagItem;->getDisplayName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/PluginTagItem;->getIconRes()I
    move-result v5
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/PluginTagItem;->getIconUrl()Ljava/lang/String;
    move-result-object v7
    new-instance v9, Ljava/lang/ref/WeakReference;
    move-object v8, v9
    invoke-direct v9, v0, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v9
    invoke-static v9, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v10, 1095761920
    invoke-static v10, v9, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v9
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v10
    invoke-static v10, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v15, 1086324736
    invoke-static v15, v10, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v10
    const/4 v15, 0
    move-object/from16 v20, v11
    move v11, v15
    move-object/from16 v21, v12
    move v12, v15
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v15
    move-object/from16 v11, v20
    invoke-static v15, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v12, 1065353216
    invoke-static v12, v15, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v12
    move-object v15, v13
    move v13, v12
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v12
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_blue_100 I
    invoke-static v12, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    move v12, v14
    move v14, v6
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v6
    move/from16 v22, v12
    sget v12, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_blue_900 I
    invoke-static v6, v12, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    move-object v12, v15
    move v15, v6
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v6
    invoke-static v6, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v11, 1090519040
    invoke-static v11, v6, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v16
    const/16 v17, 768
    const/16 v18, 0
    move-object/from16 v6, v24
    move-object v0, v12
    const/4 v11, 0
    const/4 v12, 0
    invoke-direct/range v2 ... v18, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;-><init>(Landroid/content/Context; Ljava/lang/String; I Lcom/bytedance/trae/conversation/widget/PluginTagItem; Ljava/lang/String; Ljava/lang/ref/WeakReference; F F F F F I I F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual/range v19, Ljava/lang/String;->length()I
    move-result v2
    const/16 v3, 33
    move-object/from16 v4, v21
    const/4 v5, 0
    invoke-virtual v0, v4, v5, v2, v3, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    const-string v2, " "
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    move-object v13, v0
    check-cast v13, Ljava/lang/CharSequence;
    move/from16 v2, v22
    invoke-interface v1, v2, v13, Landroid/text/Editable;->insert(I Ljava/lang/CharSequence;)Landroid/text/Editable;
    invoke-virtual v0, Landroid/text/SpannableStringBuilder;->length()I
    move-result v0
    add-int v14, v2, v0
    invoke-interface v1, Landroid/text/Editable;->length()I
    move-result v0
    invoke-static v14, v0, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v0
    move-object/from16 v1, v23
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setSelection(I)V
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdate Z
    return-void 
.end method

.method public final insertSkillTag(com.bytedance.trae.conversation.widget.SkillItem)void
    .registers 26
    # ins_size=2
    move-object/from16 v0, v24
    move-object/from16 v5, v25
    const-string/jumbo v1, skill
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v5, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    const/4 v1, 1
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdate Z
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v15
    const/4 v14, 0
    if-nez v15, +008h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    iput-boolean v14, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdate Z
    return-void 
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getSelectionStart()I
    move-result v1
    invoke-interface v15, Landroid/text/Editable;->length()I
    move-result v2
    invoke-static v1, v14, v2, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v13
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2,  
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/widget/SkillItem;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 160
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v16
    new-instance v12, Landroid/text/SpannableStringBuilder;
    move-object/from16 v1, v16
    check-cast v1, Ljava/lang/CharSequence;
    invoke-direct v12, v1, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V
    new-instance v11, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v2
    const-string v1, "getContext(...)"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/widget/SkillItem;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/widget/SkillItem;->getIconRes()I
    move-result v4
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v7, 1095761920
    invoke-static v7, v6, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v6
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v7
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v8, 1086324736
    invoke-static v8, v7, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v7
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v10
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v14, 1065353216
    invoke-static v14, v10, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v10
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v14
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_blue_100 I
    invoke-static v14, v9, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v14
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v9
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_blue_900 I
    invoke-static v9, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v17
    invoke-virtual/range v24, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getContext()Landroid/content/Context;
    move-result-object v8
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v1, 1090519040
    invoke-static v1, v8, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v18
    const/16 v19, 192
    const/16 v20, 0
    move-object v1, v11
    move-object/from16 v5, v25
    const/4 v8, 0
    const/4 v9, 0
    move-object/from16 v21, v11
    move v11, v14
    move-object v14, v12
    move/from16 v12, v17
    move/from16 v22, v13
    move/from16 v13, v18
    move-object/from16 v23, v14
    move/from16 v14, v19
    move-object v0, v15
    move-object/from16 v15, v20
    invoke-direct/range v1 ... v15, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;-><init>(Landroid/content/Context; Ljava/lang/String; I Lcom/bytedance/trae/conversation/widget/SkillItem; F F F F F I I F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual/range v16, Ljava/lang/String;->length()I
    move-result v1
    const/16 v2, 33
    move-object/from16 v4, v21
    move-object/from16 v3, v23
    const/4 v5, 0
    invoke-virtual v3, v4, v5, v1, v2, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    const-string v1, " "
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v3, v1, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    move-object v12, v3
    check-cast v12, Ljava/lang/CharSequence;
    move/from16 v1, v22
    invoke-interface v0, v1, v12, Landroid/text/Editable;->insert(I Ljava/lang/CharSequence;)Landroid/text/Editable;
    invoke-virtual v3, Landroid/text/SpannableStringBuilder;->length()I
    move-result v2
    add-int v13, v1, v2
    invoke-interface v0, Landroid/text/Editable;->length()I
    move-result v0
    invoke-static v13, v0, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v0
    move-object/from16 v1, v24
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setSelection(I)V
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdate Z
    return-void 
.end method

.method public final isInternalUpdateFlag()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdate Z
    return v0
.end method

.method public onCreateInputConnection(android.view.inputmethod.EditorInfo)android.view.inputmethod.InputConnection
    .registers 4
    # ins_size=2
    const-string v0, "outAttrs"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v2, v3, Landroidx/appcompat/widget/AppCompatEditText;->onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;
    move-result-object v3
    if-nez v3, +004h
    const/4 v3, 0
    return-object v3
    new-instance v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;
    const/4 v1, 1
    invoke-direct v0, v2, v3, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;-><init>(Lcom/bytedance/trae/conversation/widget/TranscriptEditText; Landroid/view/inputmethod/InputConnection; Z)V
    check-cast v0, Landroid/view/inputmethod/InputConnection;
    return-object v0
.end method

.method protected onDetachedFromWindow()void
    .registers 5
    # ins_size=1
    invoke-super v4, Landroidx/appcompat/widget/AppCompatEditText;->onDetachedFromWindow()V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-eqz v0, +01fh
    invoke-interface v0, Landroid/text/Editable;->length()I
    move-result v1
    const-class v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    const/4 v3, 0
    invoke-interface v0, v3, v1, v2, Landroid/text/Editable;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getSpans(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v1, v0
    if-ge v3, v1, +00ch
    aget-object v2, v0, v3
    check-cast v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->release()V
    add-int/lit8 v3, v3, 1
    goto -bh
    return-void 
.end method

.method public onTouchEvent(android.view.MotionEvent)boolean
    .registers 6
    # ins_size=2
    const-string v0, "event"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v0
    const/4 v1, 0
    if-eqz v0, +046h
    const/4 v2, 1
    if-eq v0, v2, +035h
    const/4 v3, 2
    if-eq v0, v3, +006h
    const/4 v3, 3
    if-eq v0, v3, +02fh
    goto +52h
    invoke-virtual v5, Landroid/view/MotionEvent;->getX()F
    move-result v0
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->downX F
    sub-float/2addr v0, v1
    invoke-static v0, Ljava/lang/Math;->abs(F)F
    move-result v0
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->touchSlop I
    int-to-float v1, v1
    cmpl-float v0, v0, v1
    if-gtz v0, +014h
    invoke-virtual v5, Landroid/view/MotionEvent;->getY()F
    move-result v0
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->downY F
    sub-float/2addr v0, v1
    invoke-static v0, Ljava/lang/Math;->abs(F)F
    move-result v0
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->touchSlop I
    int-to-float v1, v1
    cmpl-float v0, v0, v1
    if-lez v0, +02fh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->handler Landroid/os/Handler;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->longPressRunnable Ljava/lang/Runnable;
    invoke-virtual v0, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    goto +26h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->handler Landroid/os/Handler;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->longPressRunnable Ljava/lang/Runnable;
    invoke-virtual v0, v3, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->longPressTriggered Z
    if-eqz v0, +01ch
    iput-boolean v1, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->longPressTriggered Z
    return v2
    invoke-virtual v5, Landroid/view/MotionEvent;->getX()F
    move-result v0
    iput v0, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->downX F
    invoke-virtual v5, Landroid/view/MotionEvent;->getY()F
    move-result v0
    iput v0, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->downY F
    iput-boolean v1, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->longPressTriggered Z
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->handler Landroid/os/Handler;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->longPressRunnable Ljava/lang/Runnable;
    const-wide/16 v2, 250
    invoke-virtual v0, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    invoke-super v4, v5, Landroidx/appcompat/widget/AppCompatEditText;->onTouchEvent(Landroid/view/MotionEvent;)Z
    move-result v5
    return v5
.end method

.method public final removeSkillTag()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdate Z
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->removeSkillTagInternal()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdate Z
    return-void 
.end method

.method public final setCurrentSkill(com.bytedance.trae.conversation.widget.SkillItem)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->currentSkill Lcom/bytedance/trae/conversation/widget/SkillItem;
    return-void 
.end method
