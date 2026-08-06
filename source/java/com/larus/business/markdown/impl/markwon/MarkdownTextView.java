package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.model.IMarkwonStruct;
import com.larus.business.markdown.api.model.MarkdownContent;
import com.larus.business.markdown.api.view.text.IMarkdownTextView;
import io.noties.markwon.Markwon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkdownTextView.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0000H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;", "Lcom/larus/business/markdown/impl/markwon/UnderlineTextView;", "Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "getMarkdownContent", "()Lcom/larus/business/markdown/api/model/MarkdownContent;", "markdownWidth", "getMarkdownWidth", "()I", "setMarkdownWidth", "(I)V", "markwonContent", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "asTextView", "getSelectedColor", "isSelected", "", "start", "end", "setMarkdown", "", "content", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkdownTextView extends UnderlineTextView implements IMarkdownTextView {
    private int markdownWidth;
    private MarkwonContent markwonContent;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MarkdownTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MarkdownTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: asTextView, reason: collision with other method in class */
    public MarkdownTextView m2871asTextView() {
        return this;
    }

    @Override // com.larus.business.markdown.api.view.text.IMarkdownTextView
    public int getSelectedColor() {
        return 1719254015;
    }

    @Override // com.larus.business.markdown.api.view.text.IMarkdownTextView
    public boolean isSelected(int start, int end) {
        return false;
    }

    public /* synthetic */ MarkdownTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.larus.business.markdown.api.view.text.IMarkdownTextView
    public /* bridge */ /* synthetic */ TextView asTextView() {
        return (TextView) m2871asTextView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkdownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.larus.business.markdown.api.view.text.IMarkdownTextView
    public int getMarkdownWidth() {
        return this.markdownWidth;
    }

    @Override // com.larus.business.markdown.api.view.text.IMarkdownTextView
    public void setMarkdownWidth(int i) {
        this.markdownWidth = i;
    }

    @Override // com.larus.business.markdown.api.view.text.IMarkdownTextView
    public MarkdownContent getMarkdownContent() {
        return this.markwonContent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.business.markdown.api.view.text.IMarkdownTextView
    public void setMarkdown(MarkdownContent content) {
        MarkwonContent markwonContent;
        SpannableStringBuilder markdown;
        IMarkwonStruct markwonStruct;
        Markwon markwon;
        if (content == null || (content instanceof MarkwonContent)) {
            if (content instanceof MarkwonContent) {
                markwonContent = (MarkwonContent) content;
                this.markwonContent = markwonContent;
                if (markwonContent != null || (markdown = markwonContent.getMarkdown()) == null || (markwonStruct = markwonContent.getMarkwonStruct()) == null || (markwon = markwonStruct.getMarkwon()) == null) {
                    return;
                }
                markwon.setParsedMarkdown((TextView) this, markdown, null);
                return;
            }
        } else {
            IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
            if (markdownLoggerDelegate != null) {
                markdownLoggerDelegate.mo2529e("mark_down", "unsupport markdown: " + content);
            }
        }
        markwonContent = null;
        this.markwonContent = markwonContent;
        if (markwonContent != null) {
        }
    }
}
