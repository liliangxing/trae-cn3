package com.larus.business.markdown.api.widget;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMarkdownWidgetHandler.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/business/markdown/api/widget/IMarkdownWidgetCallback;", "", "handle", "", "parent", "Landroid/view/ViewGroup;", "updateHandle", "index", "", "currentViewGroup", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface IMarkdownWidgetCallback {

    /* compiled from: IMarkdownWidgetHandler.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static void handle(IMarkdownWidgetCallback iMarkdownWidgetCallback, ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
        }

        public static void updateHandle(IMarkdownWidgetCallback iMarkdownWidgetCallback, int i, ViewGroup currentViewGroup) {
            Intrinsics.checkNotNullParameter(currentViewGroup, "currentViewGroup");
        }
    }

    void handle(ViewGroup parent);

    void updateHandle(int index, ViewGroup currentViewGroup);
}
