package io.noties.markwon.ext.drawable;

import android.text.Spanned;
import android.widget.TextView;
import com.larus.business.markdown.api.common.ReuseDrawablePoolNew;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* compiled from: ReuseAsyncDrawablePlugin.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/noties/markwon/ext/drawable/ReuseAsyncDrawablePlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "drawablePool", "Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "clearDrawablePoolAfterRender", "", "(Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;Z)V", "afterRender", "", "node", "Lorg/commonmark/node/Node;", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "afterSetText", "textView", "Landroid/widget/TextView;", "beforeRender", "reuseCharSequence", "", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ReuseAsyncDrawablePlugin extends AbstractMarkwonPlugin {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean clearDrawablePoolAfterRender;
    private final ReuseDrawablePoolNew drawablePool;

    public ReuseAsyncDrawablePlugin(ReuseDrawablePoolNew reuseDrawablePoolNew, boolean z) {
        Intrinsics.checkNotNullParameter(reuseDrawablePoolNew, "drawablePool");
        this.drawablePool = reuseDrawablePoolNew;
        this.clearDrawablePoolAfterRender = z;
    }

    public void beforeRender(TextView textView, Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (textView != null) {
            Companion companion = INSTANCE;
            CharSequence text = textView.getText();
            Intrinsics.checkNotNullExpressionValue(text, "textView.text");
            AsyncDrawableSpan[] asyncDrawableSpans = companion.getAsyncDrawableSpans(text);
            if (asyncDrawableSpans != null) {
                for (AsyncDrawableSpan asyncDrawableSpan : asyncDrawableSpans) {
                    ReuseDrawablePoolNew reuseDrawablePoolNew = this.drawablePool;
                    AsyncDrawable drawable = asyncDrawableSpan.getDrawable();
                    Intrinsics.checkNotNullExpressionValue(drawable, "it.drawable");
                    reuseDrawablePoolNew.recycle(drawable);
                }
            }
        }
    }

    public void beforeRender(CharSequence reuseCharSequence, Node node) {
        AsyncDrawableSpan[] asyncDrawableSpans;
        Intrinsics.checkNotNullParameter(node, "node");
        if (reuseCharSequence == null || (asyncDrawableSpans = INSTANCE.getAsyncDrawableSpans(reuseCharSequence)) == null) {
            return;
        }
        for (AsyncDrawableSpan asyncDrawableSpan : asyncDrawableSpans) {
            ReuseDrawablePoolNew reuseDrawablePoolNew = this.drawablePool;
            AsyncDrawable drawable = asyncDrawableSpan.getDrawable();
            Intrinsics.checkNotNullExpressionValue(drawable, "it.drawable");
            reuseDrawablePoolNew.recycle(drawable);
        }
    }

    public void afterRender(Node node, MarkwonVisitor visitor) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (this.clearDrawablePoolAfterRender) {
            this.drawablePool.clear();
        }
    }

    public void afterSetText(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (this.clearDrawablePoolAfterRender) {
            return;
        }
        this.drawablePool.clear();
    }

    /* compiled from: ReuseAsyncDrawablePlugin.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lio/noties/markwon/ext/drawable/ReuseAsyncDrawablePlugin$Companion;", "", "()V", "getAsyncDrawableSpans", "", "Lio/noties/markwon/image/AsyncDrawableSpan;", "cs", "", "(Ljava/lang/CharSequence;)[Lio/noties/markwon/image/AsyncDrawableSpan;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AsyncDrawableSpan[] getAsyncDrawableSpans(CharSequence cs) {
            Intrinsics.checkNotNullParameter(cs, "cs");
            if (cs.length() > 0) {
                Spanned spanned = cs instanceof Spanned ? (Spanned) cs : null;
                if (spanned != null) {
                    return (AsyncDrawableSpan[]) spanned.getSpans(0, cs.length(), AsyncDrawableSpan.class);
                }
                return null;
            }
            return null;
        }
    }
}
