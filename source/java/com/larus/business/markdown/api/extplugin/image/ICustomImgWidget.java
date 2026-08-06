package com.larus.business.markdown.api.extplugin.image;

import android.graphics.Rect;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ICustomImgWidget.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J>\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH&J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0013"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/image/ICustomImgWidget;", "", "asView", "Landroid/view/View;", "bindData", "Landroid/util/Size;", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgSpan;", "rect", "Landroid/graphics/Rect;", "payload", "", "", "onReuse", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface ICustomImgWidget {
    View asView();

    Size bindData(TextView textView, Spanned text, ICustomImgSpan span, Rect rect, Map<String, ? extends Object> payload);

    void onReuse(Spanned text, ICustomImgSpan span);
}
