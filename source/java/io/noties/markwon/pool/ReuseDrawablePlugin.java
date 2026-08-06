package io.noties.markwon.pool;

import android.text.Spanned;
import android.widget.TextView;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* compiled from: ReuseDrawablePlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/pool/ReuseDrawablePlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "drawablePool", "Lio/noties/markwon/pool/ReuseDrawablePool;", "(Lio/noties/markwon/pool/ReuseDrawablePool;)V", "afterSetText", "", "textView", "Landroid/widget/TextView;", "beforeRender", "node", "Lorg/commonmark/node/Node;", "reuseCharSequence", "", "Companion", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ReuseDrawablePlugin extends AbstractMarkwonPlugin {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ReuseDrawablePool drawablePool;

    public ReuseDrawablePlugin(ReuseDrawablePool reuseDrawablePool) {
        Intrinsics.checkParameterIsNotNull(reuseDrawablePool, "drawablePool");
        this.drawablePool = reuseDrawablePool;
    }

    public void beforeRender(TextView textView, Node node) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        if (textView != null) {
            Companion companion = INSTANCE;
            CharSequence text = textView.getText();
            Intrinsics.checkExpressionValueIsNotNull(text, "textView.text");
            AsyncDrawableSpan[] spans = companion.getSpans(text);
            if (spans != null) {
                for (AsyncDrawableSpan asyncDrawableSpan : spans) {
                    ReuseDrawablePool reuseDrawablePool = this.drawablePool;
                    AsyncDrawable drawable = asyncDrawableSpan.getDrawable();
                    Intrinsics.checkExpressionValueIsNotNull(drawable, "it.drawable");
                    reuseDrawablePool.recycle(drawable);
                }
            }
        }
    }

    public void beforeRender(CharSequence reuseCharSequence, Node node) {
        AsyncDrawableSpan[] spans;
        Intrinsics.checkParameterIsNotNull(node, "node");
        if (reuseCharSequence == null || (spans = INSTANCE.getSpans(reuseCharSequence)) == null) {
            return;
        }
        for (AsyncDrawableSpan asyncDrawableSpan : spans) {
            ReuseDrawablePool reuseDrawablePool = this.drawablePool;
            AsyncDrawable drawable = asyncDrawableSpan.getDrawable();
            Intrinsics.checkExpressionValueIsNotNull(drawable, "it.drawable");
            reuseDrawablePool.recycle(drawable);
        }
    }

    public void afterSetText(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        this.drawablePool.clear();
    }

    /* compiled from: ReuseDrawablePlugin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lio/noties/markwon/pool/ReuseDrawablePlugin$Companion;", "", "()V", "getSpans", "", "Lio/noties/markwon/image/AsyncDrawableSpan;", "cs", "", "(Ljava/lang/CharSequence;)[Lio/noties/markwon/image/AsyncDrawableSpan;", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AsyncDrawableSpan[] getSpans(CharSequence cs) {
            Intrinsics.checkParameterIsNotNull(cs, "cs");
            if (!(cs.length() > 0)) {
                return null;
            }
            Spanned spanned = (Spanned) (!(cs instanceof Spanned) ? null : cs);
            if (spanned != null) {
                return (AsyncDrawableSpan[]) spanned.getSpans(0, cs.length(), AsyncDrawableSpan.class);
            }
            return null;
        }
    }
}
