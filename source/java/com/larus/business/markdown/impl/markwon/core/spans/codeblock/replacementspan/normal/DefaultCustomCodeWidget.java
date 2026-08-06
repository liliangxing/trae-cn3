package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal;

import android.content.Context;
import android.graphics.Rect;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan;
import com.larus.business.markdown.api.extplugin.code.ICustomCodeWidget;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultCustomCodeWidget.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016JP\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/normal/DefaultCustomCodeWidget;", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeWidget;", "()V", "markdownCodeView", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/normal/DefaultMarkdownCodeView;", "asView", "Landroid/view/View;", "context", "Landroid/content/Context;", "bindData", "Landroid/util/Size;", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeSpan;", "rect", "Landroid/graphics/Rect;", "payload", "", "", "", "maxContentWidth", "", "isFinish", "", "onReuse", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class DefaultCustomCodeWidget implements ICustomCodeWidget {
    private DefaultMarkdownCodeView markdownCodeView;

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeWidget
    public void onRecycle() {
        ICustomCodeWidget.DefaultImpls.onRecycle(this);
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeWidget
    public Size bindData(TextView textView, Spanned text, ICustomCodeSpan span, Rect rect, Map<String, ? extends Object> payload, int maxContentWidth, boolean isFinish) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(span, "span");
        if (this.markdownCodeView == null) {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "textView.context");
            this.markdownCodeView = new DefaultMarkdownCodeView(context, null, 0, 6, null);
        }
        DefaultMarkdownCodeView defaultMarkdownCodeView = this.markdownCodeView;
        if (defaultMarkdownCodeView != null) {
            String code = span.getCode();
            if (code == null) {
                code = "";
            }
            String language = span.getLanguage();
            if (language == null) {
                language = "c";
            }
            defaultMarkdownCodeView.bindData(code, language, true);
        }
        DefaultMarkdownCodeView defaultMarkdownCodeView2 = this.markdownCodeView;
        if (defaultMarkdownCodeView2 != null) {
            defaultMarkdownCodeView2.measure(0, 0);
        }
        DefaultMarkdownCodeView defaultMarkdownCodeView3 = this.markdownCodeView;
        return new Size(maxContentWidth, defaultMarkdownCodeView3 != null ? defaultMarkdownCodeView3.getMeasuredHeight() : 0);
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeWidget
    public View asView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DefaultMarkdownCodeView defaultMarkdownCodeView = this.markdownCodeView;
        if (defaultMarkdownCodeView == null) {
            defaultMarkdownCodeView = new DefaultMarkdownCodeView(context, null, 0, 6, null);
        }
        return defaultMarkdownCodeView;
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeWidget
    public void onReuse(Spanned text, ICustomCodeSpan span) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(span, "span");
        DefaultMarkdownCodeView defaultMarkdownCodeView = this.markdownCodeView;
        if (defaultMarkdownCodeView != null) {
            String code = span.getCode();
            if (code == null) {
                code = "";
            }
            String language = span.getLanguage();
            if (language == null) {
                language = "c";
            }
            defaultMarkdownCodeView.bindData(code, language, true);
        }
    }
}
