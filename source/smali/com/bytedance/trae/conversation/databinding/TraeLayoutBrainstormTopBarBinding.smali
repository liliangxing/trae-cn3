# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;
.super Ljava/lang/Object;
.source "TraeLayoutBrainstormTopBarBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final actionPill:Landroid/widget/LinearLayout;
.field public final btnLeft:Landroid/widget/ImageView;
.field public final btnMinimize:Landroid/widget/ImageView;
.field public final btnSubtitleToggle:Landroid/widget/ImageView;
.field private final rootView:Landroid/view/View;
.field public final spacePillGap:Landroid/widget/Space;
.field public final timerContainer:Landroid/widget/LinearLayout;
.field public final tvTimeoutChip:Landroid/widget/TextView;
.field public final tvTimer:Landroid/widget/TextView;


.method private constructor <init>(android.view.View  android.widget.LinearLayout  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.Space  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;->rootView Landroid/view/View;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;->actionPill Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;->btnLeft Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;->btnMinimize Landroid/widget/ImageView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;->btnSubtitleToggle Landroid/widget/ImageView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;->spacePillGap Landroid/widget/Space;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;->timerContainer Landroid/widget/LinearLayout;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;->tvTimeoutChip Landroid/widget/TextView;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;->tvTimer Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeLayoutBrainstormTopBarBinding
    .registers 13
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->action_pill I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +057h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_left I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +04ch
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_minimize I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +041h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_subtitle_toggle I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/ImageView;
    if-eqz v7, +036h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->space_pill_gap I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/Space;
    if-eqz v8, +02bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->timer_container I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +020h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_timeout_chip I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +015h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_timer I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;
    move-object v2, v0
    move-object v3, v12
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;-><init>(Landroid/view/View; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/Space; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v12, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v12
    invoke-virtual v12, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v12
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v12, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    invoke-direct v0, v12, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup)com.bytedance.trae.conversation.databinding.TraeLayoutBrainstormTopBarBinding
    .registers 3
    # ins_size=2
    if-eqz v2, +00ch
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_layout_brainstorm_top_bar I
    invoke-virtual v1, v0, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;
    move-result-object v1
    return-object v1
    new-instance v1, Ljava/lang/NullPointerException;
    const-string v2, "parent"
    invoke-direct v1, v2, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public getRoot()android.view.View
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeLayoutBrainstormTopBarBinding;->rootView Landroid/view/View;
    return-object v0
.end method
