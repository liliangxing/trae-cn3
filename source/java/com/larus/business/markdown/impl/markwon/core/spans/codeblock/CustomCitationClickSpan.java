package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.text.style.ClickableSpan;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.larus.business.markdown.api.model.CitationSpanClickListener;
import io.noties.markwon.core.spans.CustomCitationSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomCitationClickSpan.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CustomCitationClickSpan;", "Landroid/text/style/ClickableSpan;", "span", "Lio/noties/markwon/core/spans/CustomCitationSpan;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/larus/business/markdown/api/model/CitationSpanClickListener;", "(Lio/noties/markwon/core/spans/CustomCitationSpan;Lcom/larus/business/markdown/api/model/CitationSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomCitationClickSpan extends ClickableSpan {
    private final CitationSpanClickListener listener;
    private final CustomCitationSpan span;

    public CustomCitationClickSpan(CustomCitationSpan customCitationSpan, CitationSpanClickListener citationSpanClickListener) {
        Intrinsics.checkNotNullParameter(customCitationSpan, "span");
        this.span = customCitationSpan;
        this.listener = citationSpanClickListener;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.span.onClick(widget);
        CitationSpanClickListener citationSpanClickListener = this.listener;
        if (citationSpanClickListener != null) {
            citationSpanClickListener.onClick(this.span);
        }
    }
}
