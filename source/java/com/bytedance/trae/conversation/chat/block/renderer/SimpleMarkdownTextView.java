package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.conversation.chat.block.renderer.markdown.MarkdownHeaderFactoryHooker;
import com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefClickListener;
import com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefDialog;
import com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup;
import com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefRenderer;
import com.bytedance.trae.conversation.chat.block.renderer.ref.WebReference;
import com.larus.business.markdown.api.model.IMarkwonStruct;
import com.larus.business.markdown.api.model.MarkdownContent;
import com.larus.business.markdown.api.view.text.IMarkdownTextView;
import com.larus.business.markdown.impl.markwon.MarkwonContent;
import io.noties.markwon.Markwon;
import io.noties.markwon.SetMarkdownCallback;
import io.noties.markwon.core.spans.HeadingSpan;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleMarkdownTextView.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ.\u0010&\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\b2\b\b\u0001\u0010)\u001a\u00020\u00182\b\b\u0001\u0010*\u001a\u00020\u00182\b\b\u0001\u0010+\u001a\u00020\u0018J\u000e\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u001cJ\u0010\u00103\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u00010/J\u0016\u00105\u001a\u00020'2\u000e\u00106\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101J\u0012\u00107\u001a\u00020'2\b\u00108\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020;H\u0014J\u0010\u0010<\u001a\u00020'2\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020\bH\u0016J\u0018\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\bH\u0016J\u0010\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020FH\u0002R\u001a\u0010\u000b\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markdownWidth", "getMarkdownWidth", "()I", "setMarkdownWidth", "(I)V", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "getMarkdownContent", "()Lcom/larus/business/markdown/api/model/MarkdownContent;", "_content", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "inlineCodeBgColor", "inlineCodeCornerRadius", "", "inlineCodeHPadding", "inlineCodeVPadding", "headerStyleConfig", "Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;", "bgPaint", "Landroid/graphics/Paint;", "bgRect", "Landroid/graphics/RectF;", "codePaint", "reusableFm", "Landroid/graphics/Paint$FontMetrics;", "traeRefRenderer", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;", "setInlineCodeStyle", "", "bgColor", "cornerRadius", "hPadding", "vPadding", "setHeadingStyle", "config", "pendingStripResult", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;", "webReferences", "", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;", "setRefStripResult", "result", "setWebReferenceDescription", "references", "setMarkdown", ReportConstant.COMMON_CONTENT, "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawInlineCodeBackgrounds", "asTextView", "Landroid/widget/TextView;", "getSelectedColor", "isSelected", "", "start", "end", "bindHeadingStyles", "spanned", "Landroid/text/Spanned;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SimpleMarkdownTextView extends AppCompatTextView implements IMarkdownTextView {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HeaderStyleConfig defaultHeaderConfig = new HeaderStyleConfig(MapsKt.mapOf(new Pair[]{TuplesKt.to(1, Float.valueOf(20.0f)), TuplesKt.to(2, Float.valueOf(19.0f)), TuplesKt.to(3, Float.valueOf(18.0f)), TuplesKt.to(4, Float.valueOf(17.0f)), TuplesKt.to(5, Float.valueOf(16.0f)), TuplesKt.to(6, Float.valueOf(15.0f))}), null);
    private MarkwonContent _content;
    private final Paint bgPaint;
    private final RectF bgRect;
    private final Paint codePaint;
    private HeaderStyleConfig headerStyleConfig;
    private int inlineCodeBgColor;
    private float inlineCodeCornerRadius;
    private float inlineCodeHPadding;
    private float inlineCodeVPadding;
    private int markdownWidth;
    private TraeRefRenderer.StripResult pendingStripResult;
    private final Paint.FontMetrics reusableFm;
    private final TraeRefRenderer traeRefRenderer;
    private List<WebReference> webReferences;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleMarkdownTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleMarkdownTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public int getSelectedColor() {
        return 1719254015;
    }

    public boolean isSelected(int start, int end) {
        return false;
    }

    public /* synthetic */ SimpleMarkdownTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleMarkdownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.headerStyleConfig = defaultHeaderConfig;
        this.bgPaint = new Paint(1);
        this.bgRect = new RectF();
        Paint paint = new Paint();
        paint.setTypeface(Typeface.MONOSPACE);
        this.codePaint = paint;
        this.reusableFm = new Paint.FontMetrics();
        this.traeRefRenderer = new TraeRefRenderer(new TraeRefClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView$$ExternalSyntheticLambda0
            @Override // com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefClickListener
            public final void onRefClick(View view, TraeRefGroup traeRefGroup) {
                SimpleMarkdownTextView.traeRefRenderer$lambda$1(SimpleMarkdownTextView.this, view, traeRefGroup);
            }
        });
    }

    /* compiled from: SimpleMarkdownTextView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView$Companion;", "", "<init>", "()V", "defaultHeaderConfig", "Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;", "getDefaultHeaderConfig", "()Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HeaderStyleConfig getDefaultHeaderConfig() {
            return SimpleMarkdownTextView.defaultHeaderConfig;
        }
    }

    public int getMarkdownWidth() {
        return this.markdownWidth;
    }

    public void setMarkdownWidth(int i) {
        this.markdownWidth = i;
    }

    public MarkdownContent getMarkdownContent() {
        return this._content;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void traeRefRenderer$lambda$1(SimpleMarkdownTextView simpleMarkdownTextView, View view, TraeRefGroup traeRefGroup) {
        Intrinsics.checkNotNullParameter(view, "anchor");
        Intrinsics.checkNotNullParameter(traeRefGroup, "group");
        TraeRefDialog traeRefDialog = TraeRefDialog.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        traeRefDialog.show(context, traeRefGroup, simpleMarkdownTextView.webReferences);
    }

    public final void setInlineCodeStyle(int bgColor, float cornerRadius, float hPadding, float vPadding) {
        this.inlineCodeBgColor = bgColor;
        this.inlineCodeCornerRadius = cornerRadius;
        this.inlineCodeHPadding = hPadding;
        this.inlineCodeVPadding = vPadding;
    }

    public final void setHeadingStyle(HeaderStyleConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (Intrinsics.areEqual(config, this.headerStyleConfig)) {
            return;
        }
        this.headerStyleConfig = config;
        if (getText() != null) {
            CharSequence text = getText();
            Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
            if (spanned == null) {
                return;
            }
            bindHeadingStyles(spanned);
            requestLayout();
        }
    }

    public final void setRefStripResult(TraeRefRenderer.StripResult result) {
        this.pendingStripResult = result;
    }

    public final void setWebReferenceDescription(List<WebReference> references) {
        this.webReferences = references;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMarkdown(MarkdownContent content) {
        SpannableStringBuilder markdown;
        Markwon markwon;
        Markwon markwon2;
        MarkwonContent markwonContent = content instanceof MarkwonContent ? (MarkwonContent) content : null;
        this._content = markwonContent;
        if (markwonContent == null || (markdown = markwonContent.getMarkdown()) == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = markdown;
        bindHeadingStyles(spannableStringBuilder);
        TraeRefRenderer.StripResult stripResult = this.pendingStripResult;
        if (stripResult != null) {
            TextView textView = (TextView) this;
            Spanned applyOnSpanned = this.traeRefRenderer.applyOnSpanned(textView, spannableStringBuilder, stripResult);
            this.pendingStripResult = null;
            IMarkwonStruct markwonStruct = markwonContent.getMarkwonStruct();
            if (markwonStruct == null || (markwon2 = markwonStruct.getMarkwon()) == null) {
                return;
            }
            markwon2.setParsedMarkdown(textView, applyOnSpanned, (SetMarkdownCallback) null);
            return;
        }
        IMarkwonStruct markwonStruct2 = markwonContent.getMarkwonStruct();
        if (markwonStruct2 == null || (markwon = markwonStruct2.getMarkwon()) == null) {
            return;
        }
        markwon.setParsedMarkdown((TextView) this, spannableStringBuilder, (SetMarkdownCallback) null);
    }

    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.inlineCodeBgColor != 0) {
            drawInlineCodeBackgrounds(canvas);
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void drawInlineCodeBackgrounds(Canvas canvas) {
        boolean z;
        int lineForOffset;
        int lineForOffset2;
        Spanned spanned;
        float primaryHorizontal;
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        CharSequence text = getText();
        Spanned spanned2 = text instanceof Spanned ? (Spanned) text : null;
        if (spanned2 == null) {
            return;
        }
        boolean z2 = false;
        InlineCodeSpan[] inlineCodeSpanArr = (InlineCodeSpan[]) spanned2.getSpans(0, spanned2.length(), InlineCodeSpan.class);
        if (inlineCodeSpanArr != null) {
            if (!(inlineCodeSpanArr.length == 0)) {
                z = false;
                if (z) {
                    this.bgPaint.setColor(this.inlineCodeBgColor);
                    this.codePaint.setTextSize(getPaint().getTextSize());
                    this.codePaint.getFontMetrics(this.reusableFm);
                    int save = canvas.save();
                    canvas.translate(getTotalPaddingLeft(), getTotalPaddingTop());
                    Iterator it = ArrayIteratorKt.iterator(inlineCodeSpanArr);
                    while (it.hasNext()) {
                        InlineCodeSpan inlineCodeSpan = (InlineCodeSpan) it.next();
                        int spanStart = spanned2.getSpanStart(inlineCodeSpan);
                        int spanEnd = spanned2.getSpanEnd(inlineCodeSpan);
                        if (spanStart >= 0 && spanEnd >= 0 && spanStart < spanEnd && (lineForOffset = layout.getLineForOffset(spanStart)) <= (lineForOffset2 = layout.getLineForOffset(spanEnd))) {
                            int i = lineForOffset;
                            while (true) {
                                int lineStart = layout.getLineStart(i);
                                int lineEnd = layout.getLineEnd(i);
                                int max = Math.max(lineStart, spanStart);
                                int min = Math.min(lineEnd, spanEnd);
                                if (max < min) {
                                    float max2 = Math.max(0.0f, layout.getPrimaryHorizontal(max) - this.inlineCodeHPadding);
                                    boolean z3 = i == lineForOffset2 ? true : z2;
                                    if (!z3) {
                                        primaryHorizontal = layout.getLineRight(i) + this.inlineCodeHPadding;
                                    } else {
                                        primaryHorizontal = this.inlineCodeHPadding + layout.getPrimaryHorizontal(min);
                                    }
                                    float f = i == lineForOffset ? this.inlineCodeVPadding : 0.0f;
                                    float f2 = z3 ? this.inlineCodeVPadding : 0.0f;
                                    float lineBaseline = layout.getLineBaseline(i);
                                    spanned = spanned2;
                                    float f3 = (this.reusableFm.ascent + lineBaseline) - f;
                                    float f4 = lineBaseline + this.reusableFm.descent + f2;
                                    if (i > lineForOffset) {
                                        f3 = Math.max(f3, layout.getLineTop(i));
                                    }
                                    if (i < lineForOffset2) {
                                        f4 = Math.min(f4, layout.getLineBottom(i));
                                    }
                                    this.bgRect.set(max2, f3, primaryHorizontal, f4);
                                    RectF rectF = this.bgRect;
                                    float f5 = this.inlineCodeCornerRadius;
                                    canvas.drawRoundRect(rectF, f5, f5, this.bgPaint);
                                } else {
                                    spanned = spanned2;
                                }
                                if (i == lineForOffset2) {
                                    break;
                                }
                                i++;
                                spanned2 = spanned;
                                z2 = false;
                            }
                            spanned2 = spanned;
                            z2 = false;
                        }
                    }
                    canvas.restoreToCount(save);
                    return;
                }
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextView asTextView() {
        return (TextView) this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if ((r4.length == 0) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void bindHeadingStyles(Spanned spanned) {
        boolean z = false;
        HeadingSpan[] headingSpanArr = (HeadingSpan[]) spanned.getSpans(0, spanned.length(), HeadingSpan.class);
        if (headingSpanArr != null) {
        }
        z = true;
        if (z) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(headingSpanArr);
        while (it.hasNext()) {
            MarkdownHeaderFactoryHooker.bindHeadingStyle((HeadingSpan) it.next(), this.headerStyleConfig);
        }
    }
}
