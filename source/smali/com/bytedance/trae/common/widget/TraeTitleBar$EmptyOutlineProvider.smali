# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/common/widget/TraeTitleBar$EmptyOutlineProvider;
.super Landroid/view/ViewOutlineProvider;
.source "TraeTitleBar.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/common/widget/TraeTitleBar$EmptyOutlineProvider;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$EmptyOutlineProvider;
    invoke-direct v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$EmptyOutlineProvider;-><init>()V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$EmptyOutlineProvider;->INSTANCE Lcom/bytedance/trae/common/widget/TraeTitleBar$EmptyOutlineProvider;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroid/view/ViewOutlineProvider;-><init>()V
    return-void 
.end method

.method public getOutline(android.view.View  android.graphics.Outline)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "outline"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/graphics/Outline;->setEmpty()V
    return-void 
.end method
