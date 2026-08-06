package com.larus.business.markdown.api.extplugin.image;

import android.text.Spanned;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICustomImgHandler.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "", "getCustomImgLoader", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgLoader;", "getWidget", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgWidget;", "container", "Landroid/widget/FrameLayout;", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgSpan;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface ICustomImgHandler {

    /* compiled from: ICustomImgHandler.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static ICustomImgLoader getCustomImgLoader(ICustomImgHandler iCustomImgHandler) {
            return null;
        }

        public static ICustomImgWidget getWidget(ICustomImgHandler iCustomImgHandler, FrameLayout container, TextView textView, Spanned text, ICustomImgSpan span) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(textView, "textView");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(span, "span");
            return null;
        }
    }

    ICustomImgLoader getCustomImgLoader();

    ICustomImgWidget getWidget(FrameLayout container, TextView textView, Spanned text, ICustomImgSpan span);
}
