# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;
.super Ljava/lang/Object;
.source "DiscussingFragment.kt"

.field private final paddingBottom:I
.field private final paddingTop:I
.field private final radius:I
.field private final shadowView:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
.field private final target:Landroid/view/View;


.method public constructor <init>(com.bytedance.trae.conversation.brainstorm.widget.BrainstormActionShadowView  android.view.View  int  int  int)void
    .registers 7
    # ins_size=6
    const-string/jumbo v0, shadowView
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, target
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->shadowView Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->target Landroid/view/View;
    iput v4, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->radius I
    iput v5, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->paddingTop I
    iput v6, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->paddingBottom I
    return-void 
.end method

.method public final getPaddingBottom()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->paddingBottom I
    return v0
.end method

.method public final getPaddingTop()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->paddingTop I
    return v0
.end method

.method public final getRadius()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->radius I
    return v0
.end method

.method public final getShadowView()com.bytedance.trae.conversation.brainstorm.widget.BrainstormActionShadowView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->shadowView Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    return-object v0
.end method

.method public final getTarget()android.view.View
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$BottomShadowEntry;->target Landroid/view/View;
    return-object v0
.end method
