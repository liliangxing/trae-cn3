package com.larus.business.markdown.api.extplugin.image;

import android.view.ViewGroup;
import com.larus.business.markdown.api.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomImgWidgetExt.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"clearWidgetCache", "", "Landroid/view/ViewGroup;", "markdown-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class CustomImgWidgetExtKt {
    public static final void clearWidgetCache(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        viewGroup.setTag(R.id.markwon_cached_widget_list, null);
    }
}
