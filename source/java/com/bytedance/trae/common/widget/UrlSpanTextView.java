package com.bytedance.trae.common.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.HtmlCompat;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.common_ui.C0591R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UrlSpanTextView.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001f B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/common/widget/UrlSpanTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAttrs", "()Landroid/util/AttributeSet;", "mOnClickListener", "Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;", "linkColor", "Landroid/content/res/ColorStateList;", "linkUnderLine", "", "linkText", "", "setUrlText", "", "text", "setUrlTextColor", "setUrlSpannedText", "spannedText", "", "wrapText", "charSequence", "setOnClickListener", "listener", "OnClickListener", "UrlClickSpan", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UrlSpanTextView extends AppCompatTextView {
    private final AttributeSet attrs;
    private ColorStateList linkColor;
    private CharSequence linkText;
    private boolean linkUnderLine;
    private OnClickListener mOnClickListener;

    /* compiled from: UrlSpanTextView.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;", "", "onUrlClick", "", IWeixinService.ResponseConstants.URL, "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnClickListener {
        void onUrlClick(String url);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UrlSpanTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UrlSpanTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ UrlSpanTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final AttributeSet getAttrs() {
        return this.attrs;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlSpanTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.attrs = attributeSet;
        this.linkUnderLine = true;
        this.linkText = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0591R.styleable.trae_UrlSpanTextView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.linkColor = obtainStyledAttributes.getColorStateList(C0591R.styleable.trae_UrlSpanTextView_trae_linkColor);
            this.linkUnderLine = obtainStyledAttributes.getBoolean(C0591R.styleable.trae_UrlSpanTextView_trae_linkUnderLine, true);
            String text = obtainStyledAttributes.getText(C0591R.styleable.trae_UrlSpanTextView_trae_linkText);
            this.linkText = text == null ? "" : text;
            ColorStateList colorStateList = this.linkColor;
            if (colorStateList != null) {
                super.setLinkTextColor(colorStateList);
            }
            setUrlText(this.linkText);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void setUrlText(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.linkText = text;
        super.setText(wrapText(text));
    }

    public final void setUrlTextColor(ColorStateList linkColor) {
        Intrinsics.checkNotNullParameter(linkColor, "linkColor");
        this.linkColor = linkColor;
        super.setLinkTextColor(linkColor);
    }

    public final void setUrlSpannedText(String spannedText) {
        Intrinsics.checkNotNullParameter(spannedText, "spannedText");
        Spanned fromHtml = HtmlCompat.fromHtml(StringsKt.replace$default(spannedText, "\n", "<br/>", false, 4, (Object) null), 0);
        SpannedString valueOf = SpannedString.valueOf(fromHtml instanceof SpannableStringBuilder ? (SpannableStringBuilder) fromHtml : null);
        Intrinsics.checkNotNull(valueOf);
        SpannedString spannedString = valueOf;
        this.linkText = spannedString;
        super.setText(wrapText(spannedString));
    }

    private final CharSequence wrapText(CharSequence charSequence) {
        if (!(charSequence instanceof SpannedString)) {
            return charSequence;
        }
        SpannableString valueOf = SpannableString.valueOf(charSequence);
        SpannedString spannedString = (SpannedString) charSequence;
        Iterator it = ArrayIteratorKt.iterator((URLSpan[]) spannedString.getSpans(0, valueOf.length() - 1, URLSpan.class));
        while (it.hasNext()) {
            URLSpan uRLSpan = (URLSpan) it.next();
            int spanStart = spannedString.getSpanStart(uRLSpan);
            int spanEnd = spannedString.getSpanEnd(uRLSpan);
            valueOf.removeSpan(uRLSpan);
            String url = uRLSpan.getURL();
            Intrinsics.checkNotNullExpressionValue(url, "getURL(...)");
            UrlClickSpan urlClickSpan = new UrlClickSpan(this, url, this.linkUnderLine);
            StyleSpan styleSpan = new StyleSpan(1);
            valueOf.setSpan(urlClickSpan, spanStart, spanEnd, 33);
            valueOf.setSpan(styleSpan, spanStart, spanEnd, 33);
        }
        super.setMovementMethod(LinkMovementMethod.getInstance());
        super.setHighlightColor(0);
        super.setAutoLinkMask(1);
        Intrinsics.checkNotNull(valueOf);
        return valueOf;
    }

    public final void setOnClickListener(OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnClickListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UrlSpanTextView.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;", "Landroid/text/style/ClickableSpan;", IWeixinService.ResponseConstants.URL, "", "underlineText", "", "<init>", "(Lcom/bytedance/trae/common/widget/UrlSpanTextView;Ljava/lang/String;Z)V", "getUrl$common_ui_mainlandRelease", "()Ljava/lang/String;", "setUrl$common_ui_mainlandRelease", "(Ljava/lang/String;)V", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class UrlClickSpan extends ClickableSpan {
        final /* synthetic */ UrlSpanTextView this$0;
        private boolean underlineText;
        private String url;

        public UrlClickSpan(UrlSpanTextView urlSpanTextView, String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, IWeixinService.ResponseConstants.URL);
            this.this$0 = urlSpanTextView;
            this.url = str;
            this.underlineText = z;
        }

        /* renamed from: getUrl$common_ui_mainlandRelease, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final void setUrl$common_ui_mainlandRelease(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            OnClickListener onClickListener = this.this$0.mOnClickListener;
            if (onClickListener != null) {
                onClickListener.onUrlClick(this.url);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(this.underlineText);
            ds.setColor(ds.linkColor);
        }
    }
}
