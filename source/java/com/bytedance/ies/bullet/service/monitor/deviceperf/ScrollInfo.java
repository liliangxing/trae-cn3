package com.bytedance.ies.bullet.service.monitor.deviceperf;

import android.view.View;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: ScrollInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/deviceperf/ScrollInfo;", "", "mView", "Landroid/view/View;", "mTagName", "", "mScrollMonitorTag", "url", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMScrollMonitorTag", "()Ljava/lang/String;", "setMScrollMonitorTag", "(Ljava/lang/String;)V", "getMTagName", "setMTagName", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "getUrl", "setUrl", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ScrollInfo {
    private String mScrollMonitorTag;
    private String mTagName;
    private View mView;
    private String url;

    public ScrollInfo(View mView, String mTagName, String str, String url) {
        Intrinsics.checkNotNullParameter(mView, "mView");
        Intrinsics.checkNotNullParameter(mTagName, "mTagName");
        Intrinsics.checkNotNullParameter(url, "url");
        this.mView = mView;
        this.mTagName = mTagName;
        this.mScrollMonitorTag = str;
        this.url = url;
    }

    public /* synthetic */ ScrollInfo(View view, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, str, (i & 4) != 0 ? "unknown" : str2, str3);
    }

    public final String getMScrollMonitorTag() {
        return this.mScrollMonitorTag;
    }

    public final String getMTagName() {
        return this.mTagName;
    }

    public final View getMView() {
        return this.mView;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setMScrollMonitorTag(String str) {
        this.mScrollMonitorTag = str;
    }

    public final void setMTagName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTagName = str;
    }

    public final void setMView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mView = view;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("ViewInfo @%d view %s, name %s, monitor-name %s", Arrays.copyOf(new Object[]{Integer.valueOf(hashCode()), this.mView.getClass().getSimpleName(), this.mTagName, this.mScrollMonitorTag}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
