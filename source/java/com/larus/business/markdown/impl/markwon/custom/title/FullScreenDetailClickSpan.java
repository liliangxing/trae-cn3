package com.larus.business.markdown.impl.markwon.custom.title;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.larus.business.markdown.api.FullScreenDetailSpanClickListener;
import com.larus.business.markdown.api.model.MarkdownContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullScreenDetailClickSpan.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/custom/title/FullScreenDetailClickSpan;", "Landroid/text/style/ClickableSpan;", "parentContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "fullScreenDetailInfoSpan", "Lcom/larus/business/markdown/impl/markwon/custom/title/FullScreenDetailInfoSpan;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/larus/business/markdown/api/FullScreenDetailSpanClickListener;", "(Lcom/larus/business/markdown/api/model/MarkdownContent;Lcom/larus/business/markdown/impl/markwon/custom/title/FullScreenDetailInfoSpan;Lcom/larus/business/markdown/api/FullScreenDetailSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class FullScreenDetailClickSpan extends ClickableSpan {
    private final FullScreenDetailInfoSpan fullScreenDetailInfoSpan;
    private final FullScreenDetailSpanClickListener listener;
    private final MarkdownContent parentContent;

    public FullScreenDetailClickSpan(MarkdownContent markdownContent, FullScreenDetailInfoSpan fullScreenDetailInfoSpan, FullScreenDetailSpanClickListener fullScreenDetailSpanClickListener) {
        Intrinsics.checkNotNullParameter(markdownContent, "parentContent");
        Intrinsics.checkNotNullParameter(fullScreenDetailInfoSpan, "fullScreenDetailInfoSpan");
        Intrinsics.checkNotNullParameter(fullScreenDetailSpanClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.parentContent = markdownContent;
        this.fullScreenDetailInfoSpan = fullScreenDetailInfoSpan;
        this.listener = fullScreenDetailSpanClickListener;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.listener.onClick(this.parentContent, widget, this.fullScreenDetailInfoSpan);
        TextView textView = widget instanceof TextView ? (TextView) widget : null;
        if (textView == null) {
            return;
        }
        textView.setHighlightColor(0);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        ds.setUnderlineText(false);
    }
}
