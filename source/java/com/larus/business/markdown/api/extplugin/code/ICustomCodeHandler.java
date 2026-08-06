package com.larus.business.markdown.api.extplugin.code;

import android.text.Spanned;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICustomCodeHandler.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "", "getWidget", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeWidget;", "container", "Landroid/widget/FrameLayout;", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeSpan;", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface ICustomCodeHandler {
    ICustomCodeWidget getWidget(FrameLayout container, TextView textView, Spanned text, ICustomCodeSpan span, CustomMarkDownInfo customMarkDownInfo);

    /* compiled from: ICustomCodeHandler.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DefaultImpls {
        public static ICustomCodeWidget getWidget(ICustomCodeHandler iCustomCodeHandler, FrameLayout frameLayout, TextView textView, Spanned spanned, ICustomCodeSpan iCustomCodeSpan, CustomMarkDownInfo customMarkDownInfo) {
            Intrinsics.checkNotNullParameter(frameLayout, "container");
            Intrinsics.checkNotNullParameter(textView, "textView");
            Intrinsics.checkNotNullParameter(spanned, "text");
            Intrinsics.checkNotNullParameter(iCustomCodeSpan, "span");
            return null;
        }

        public static /* synthetic */ ICustomCodeWidget getWidget$default(ICustomCodeHandler iCustomCodeHandler, FrameLayout frameLayout, TextView textView, Spanned spanned, ICustomCodeSpan iCustomCodeSpan, CustomMarkDownInfo customMarkDownInfo, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWidget");
            }
            if ((i & 16) != 0) {
                customMarkDownInfo = null;
            }
            return iCustomCodeHandler.getWidget(frameLayout, textView, spanned, iCustomCodeSpan, customMarkDownInfo);
        }
    }
}
