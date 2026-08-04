# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/AudioSwitchToast;
.super Ljava/lang/Object;
.source "AudioSwitchToast.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/widget/AudioSwitchToast;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioSwitchToast;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioSwitchToast;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioSwitchToast;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/widget/AudioSwitchToast;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final dismiss()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/widget/InlineToast;->INSTANCE Lcom/bytedance/trae/common/widget/InlineToast;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/InlineToast;->dismiss()V
    return-void 
.end method

.method public final show(android.view.ViewGroup  java.lang.String)void
    .registers 15
    # ins_size=3
    const-string v0, "container"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "deviceName"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/common/widget/InlineToast;->INSTANCE Lcom/bytedance/trae/common/widget/InlineToast;
    move-object v3, v14
    check-cast v3, Ljava/lang/CharSequence;
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->icon_16_checkmark_circle_filled I
    const-wide/16 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 120
    const/4 v11, 0
    move-object v2, v13
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/common/widget/InlineToast;->show$default(Lcom/bytedance/trae/common/widget/InlineToast; Landroid/view/ViewGroup; Ljava/lang/CharSequence; I J I Lcom/bytedance/trae/common/widget/InlineToast$Position; I I Ljava/lang/Object;)V
    return-void 
.end method
