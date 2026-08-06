package com.larus.business.markdown.api.depend;

import android.text.Spanned;
import android.widget.FrameLayout;
import android.widget.TextView;
import io.noties.markwon.html.customdata.ICustomDataSpan;
import io.noties.markwon.html.customdata.ICustomDataWidget;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ICustomDataHandler.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J>\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "", "accept", "", "dataType", "", "getWidget", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "container", "Landroid/widget/FrameLayout;", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "payload", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface ICustomDataHandler {
    boolean accept(String dataType);

    ICustomDataWidget getWidget(FrameLayout container, TextView textView, Spanned text, ICustomDataSpan span, Map<String, ? extends Object> payload);
}
