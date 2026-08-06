package com.bytedance.trae.conversation.chat.toolcall;

import android.content.Context;
import android.view.View;
import com.bytedance.forest.model.PreloadConfig;
import com.ss.ttm.player.MediaFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToolDetailCard.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u00109\u001a\u0004\u0018\u00010\r2\u0006\u0010:\u001a\u00020\fJ\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bHÆ\u0003J\t\u0010B\u001a\u00020\u000fHÆ\u0003J\t\u0010C\u001a\u00020\u0011HÆ\u0003J\u0017\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bHÆ\u0003J\u008d\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bHÆ\u0001J\u0013\u0010F\u001a\u00020\u00112\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\u0005HÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010'\"\u0004\b3\u0010)R\u001c\u00104\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006J"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "", "iconEmoji", "", "iconResId", "", "iconTintColorRes", "title", MediaFormat.KEY_SUBTITLE, "badgeText", "contentView", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/view/View;", "status", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;", "shimmerTitle", "", "onDetailClick", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;ZLkotlin/jvm/functions/Function1;)V", "getIconEmoji", "()Ljava/lang/String;", "setIconEmoji", "(Ljava/lang/String;)V", "getIconResId", "()I", "setIconResId", "(I)V", "getIconTintColorRes", "setIconTintColorRes", "getTitle", "setTitle", "getSubtitle", "setSubtitle", "getBadgeText", "setBadgeText", "getContentView", "()Lkotlin/jvm/functions/Function1;", "setContentView", "(Lkotlin/jvm/functions/Function1;)V", "getStatus", "()Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;", "setStatus", "(Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;)V", "getShimmerTitle", "()Z", "setShimmerTitle", "(Z)V", "getOnDetailClick", "setOnDetailClick", "contentViewInstance", "getContentViewInstance", "()Landroid/view/View;", "setContentViewInstance", "(Landroid/view/View;)V", "getOrCreateContentView", "context", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ToolDetailCard {
    private String badgeText;
    private Function1<? super Context, ? extends View> contentView;
    private View contentViewInstance;
    private String iconEmoji;
    private int iconResId;
    private int iconTintColorRes;
    private Function1<? super View, Unit> onDetailClick;
    private boolean shimmerTitle;
    private ToolExecutionStatus status;
    private String subtitle;
    private String title;

    /* renamed from: component1, reason: from getter */
    public final String getIconEmoji() {
        return this.iconEmoji;
    }

    public final Function1<View, Unit> component10() {
        return this.onDetailClick;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIconResId() {
        return this.iconResId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIconTintColorRes() {
        return this.iconTintColorRes;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBadgeText() {
        return this.badgeText;
    }

    public final Function1<Context, View> component7() {
        return this.contentView;
    }

    /* renamed from: component8, reason: from getter */
    public final ToolExecutionStatus getStatus() {
        return this.status;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getShimmerTitle() {
        return this.shimmerTitle;
    }

    public final ToolDetailCard copy(String iconEmoji, int iconResId, int iconTintColorRes, String title, String subtitle, String badgeText, Function1<? super Context, ? extends View> contentView, ToolExecutionStatus status, boolean shimmerTitle, Function1<? super View, Unit> onDetailClick) {
        Intrinsics.checkNotNullParameter(iconEmoji, "iconEmoji");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(status, "status");
        return new ToolDetailCard(iconEmoji, iconResId, iconTintColorRes, title, subtitle, badgeText, contentView, status, shimmerTitle, onDetailClick);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolDetailCard)) {
            return false;
        }
        ToolDetailCard toolDetailCard = (ToolDetailCard) other;
        return Intrinsics.areEqual(this.iconEmoji, toolDetailCard.iconEmoji) && this.iconResId == toolDetailCard.iconResId && this.iconTintColorRes == toolDetailCard.iconTintColorRes && Intrinsics.areEqual(this.title, toolDetailCard.title) && Intrinsics.areEqual(this.subtitle, toolDetailCard.subtitle) && Intrinsics.areEqual(this.badgeText, toolDetailCard.badgeText) && Intrinsics.areEqual(this.contentView, toolDetailCard.contentView) && this.status == toolDetailCard.status && this.shimmerTitle == toolDetailCard.shimmerTitle && Intrinsics.areEqual(this.onDetailClick, toolDetailCard.onDetailClick);
    }

    public int hashCode() {
        int hashCode = ((((((this.iconEmoji.hashCode() * 31) + Integer.hashCode(this.iconResId)) * 31) + Integer.hashCode(this.iconTintColorRes)) * 31) + this.title.hashCode()) * 31;
        String str = this.subtitle;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.badgeText;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Function1<? super Context, ? extends View> function1 = this.contentView;
        int hashCode4 = (((((hashCode3 + (function1 == null ? 0 : function1.hashCode())) * 31) + this.status.hashCode()) * 31) + Boolean.hashCode(this.shimmerTitle)) * 31;
        Function1<? super View, Unit> function12 = this.onDetailClick;
        return hashCode4 + (function12 != null ? function12.hashCode() : 0);
    }

    public String toString() {
        return "ToolDetailCard(iconEmoji=" + this.iconEmoji + ", iconResId=" + this.iconResId + ", iconTintColorRes=" + this.iconTintColorRes + ", title=" + this.title + ", subtitle=" + this.subtitle + ", badgeText=" + this.badgeText + ", contentView=" + this.contentView + ", status=" + this.status + ", shimmerTitle=" + this.shimmerTitle + ", onDetailClick=" + this.onDetailClick + ')';
    }

    public ToolDetailCard(String iconEmoji, int i, int i2, String title, String str, String str2, Function1<? super Context, ? extends View> function1, ToolExecutionStatus status, boolean z, Function1<? super View, Unit> function12) {
        Intrinsics.checkNotNullParameter(iconEmoji, "iconEmoji");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(status, "status");
        this.iconEmoji = iconEmoji;
        this.iconResId = i;
        this.iconTintColorRes = i2;
        this.title = title;
        this.subtitle = str;
        this.badgeText = str2;
        this.contentView = function1;
        this.status = status;
        this.shimmerTitle = z;
        this.onDetailClick = function12;
    }

    public final String getIconEmoji() {
        return this.iconEmoji;
    }

    public final void setIconEmoji(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconEmoji = str;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final void setIconResId(int i) {
        this.iconResId = i;
    }

    public final int getIconTintColorRes() {
        return this.iconTintColorRes;
    }

    public final void setIconTintColorRes(int i) {
        this.iconTintColorRes = i;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final void setSubtitle(String str) {
        this.subtitle = str;
    }

    public final String getBadgeText() {
        return this.badgeText;
    }

    public final void setBadgeText(String str) {
        this.badgeText = str;
    }

    public final Function1<Context, View> getContentView() {
        return this.contentView;
    }

    public final void setContentView(Function1<? super Context, ? extends View> function1) {
        this.contentView = function1;
    }

    public /* synthetic */ ToolDetailCard(String str, int i, int i2, String str2, String str3, String str4, Function1 function1, ToolExecutionStatus toolExecutionStatus, boolean z, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? null : function1, (i3 & 128) != 0 ? ToolExecutionStatus.PENDING : toolExecutionStatus, (i3 & 256) != 0 ? false : z, (i3 & 512) != 0 ? null : function12);
    }

    public final ToolExecutionStatus getStatus() {
        return this.status;
    }

    public final void setStatus(ToolExecutionStatus toolExecutionStatus) {
        Intrinsics.checkNotNullParameter(toolExecutionStatus, "<set-?>");
        this.status = toolExecutionStatus;
    }

    public final boolean getShimmerTitle() {
        return this.shimmerTitle;
    }

    public final void setShimmerTitle(boolean z) {
        this.shimmerTitle = z;
    }

    public final Function1<View, Unit> getOnDetailClick() {
        return this.onDetailClick;
    }

    public final void setOnDetailClick(Function1<? super View, Unit> function1) {
        this.onDetailClick = function1;
    }

    public final View getContentViewInstance() {
        return this.contentViewInstance;
    }

    public final void setContentViewInstance(View view) {
        this.contentViewInstance = view;
    }

    public final View getOrCreateContentView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View view = this.contentViewInstance;
        if (view != null) {
            return view;
        }
        Function1<? super Context, ? extends View> function1 = this.contentView;
        View invoke = function1 != null ? function1.invoke(context) : null;
        this.contentViewInstance = invoke;
        return invoke;
    }
}
