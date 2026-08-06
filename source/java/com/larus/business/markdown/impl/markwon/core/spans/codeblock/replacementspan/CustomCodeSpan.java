package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.facebook.imageutils.JfifUtil;
import com.larus.business.markdown.api.SpanUtilsKt;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.extplugin.code.ICustomCodeHandler;
import com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan;
import com.larus.business.markdown.api.extplugin.code.ICustomCodeWidget;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import com.larus.business.markdown.api.view.text.IMarkdownTextView;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultCustomCodeWidget;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.core.spans.MarkdownSpanInfo;
import io.noties.markwon.html.C1562R;
import io.noties.markwon.html.tag.ImageGridHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: CustomCodeSpan.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB]\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0013H\u0016J\"\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016JR\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.2\b\u0010(\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u000208H\u0016J4\u00109\u001a\u00020\n2\u0006\u00107\u001a\u0002082\b\u0010(\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0010\u0010<\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0002J!\u0010=\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010>J\u0018\u0010?\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u0010H\u0016J\u0010\u0010A\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0013H\u0016J\u0018\u0010B\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010C\u001a\u00020\u0001H\u0016J\"\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010/2\u0006\u0010F\u001a\u00020\nH\u0002J'\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020I2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0002\u0010JR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001bR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0019R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/CustomCodeSpan;", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeSpan;", "Landroid/text/style/ReplacementSpan;", "payload", "", "", "", "code", "language", "startIndex", "", "endIndex", "maxContentWidth", "customCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "isFinish", "", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;Z)V", "attachedTextView", "Landroid/widget/TextView;", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getEndIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "getLanguage", "getPayload", "()Ljava/util/Map;", "size", "Landroid/util/Size;", "getStartIndex", "widget", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeWidget;", "afterAttach", "", "textView", "beforeAttach", "text", "Landroid/text/Spanned;", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", WebViewContainer.EVENT_draw, "canvas", "Landroid/graphics/Canvas;", "", "start", "end", "x", "", AnimationConstant.PROP_STR_TOP, "y", AnimationConstant.PROP_STR_BOTTOM, "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "getSpanWidth", "obtainWidget", "(Landroid/widget/TextView;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeWidget;", "onDetach", "needRemoveView", "onRecycle", "onReuse", "span", "printLog", "log", ImageGridHandler.Index, "recycleWidget", "view", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/Integer;Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeWidget;)V", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomCodeSpan extends ReplacementSpan implements ICustomCodeSpan {
    public static final String LOG_TAG = "CustomCodeSpan";
    private TextView attachedTextView;
    private String code;
    private final ICustomCodeHandler customCodeHandler;
    private final Integer endIndex;
    private final boolean isFinish;
    private final String language;
    private final int maxContentWidth;
    private final Map<String, Object> payload;
    private Size size = new Size(0, 0);
    private final Integer startIndex;
    private ICustomCodeWidget widget;

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan
    public void onReuse(Spanned text, ICustomCodeSpan span) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(span, "span");
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan
    public Map<String, Object> getPayload() {
        return this.payload;
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan
    public String getCode() {
        return this.code;
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan
    public void setCode(String str) {
        this.code = str;
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan
    public String getLanguage() {
        return this.language;
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan
    public Integer getStartIndex() {
        return this.startIndex;
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan
    public Integer getEndIndex() {
        return this.endIndex;
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan
    /* renamed from: isFinish, reason: from getter */
    public boolean getIsFinish() {
        return this.isFinish;
    }

    public CustomCodeSpan(Map<String, ? extends Object> map, String str, String str2, Integer num, Integer num2, int i, ICustomCodeHandler iCustomCodeHandler, boolean z) {
        this.payload = map;
        this.code = str;
        this.language = str2;
        this.startIndex = num;
        this.endIndex = num2;
        this.maxContentWidth = i;
        this.customCodeHandler = iCustomCodeHandler;
        this.isFinish = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if (r2 == null) goto L17;
     */
    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void beforeAttach(TextView textView, Spanned text, CustomMarkDownInfo customMarkDownInfo) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        try {
            this.attachedTextView = textView;
            ViewParent parent = textView.getParent();
            FrameLayout frameLayout = parent instanceof FrameLayout ? (FrameLayout) parent : null;
            if ((textView instanceof IMarkdownTextView) && frameLayout != null) {
                DefaultCustomCodeWidget obtainWidget = obtainWidget(textView, getStartIndex());
                if (obtainWidget == null) {
                    ICustomCodeHandler iCustomCodeHandler = this.customCodeHandler;
                    if (iCustomCodeHandler != null) {
                        obtainWidget = iCustomCodeHandler.getWidget(frameLayout, textView, text, this, customMarkDownInfo);
                    }
                    obtainWidget = new DefaultCustomCodeWidget();
                    recycleWidget(textView, getStartIndex(), obtainWidget);
                }
                ICustomCodeWidget iCustomCodeWidget = obtainWidget;
                this.size = iCustomCodeWidget.bindData(textView, text, this, null, getPayload(), getSpanWidth(text), getIsFinish());
                printLog("span calc new__: " + this.size.getWidth() + ", " + this.size.getHeight(), textView.getText(), 0);
                Context context = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "textView.context");
                View asView = iCustomCodeWidget.asView(context);
                ViewGroup.LayoutParams layoutParams = asView.getLayoutParams();
                if (layoutParams == null) {
                    asView.setLayoutParams(new FrameLayout.LayoutParams(this.size.getWidth(), this.size.getHeight()));
                    asView.setVisibility(4);
                } else if (layoutParams.width != this.size.getWidth() || layoutParams.height != this.size.getHeight()) {
                    ViewGroup.LayoutParams layoutParams2 = asView.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.width = this.size.getWidth();
                        layoutParams2.height = this.size.getHeight();
                        asView.setLayoutParams(layoutParams2);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                }
                this.widget = iCustomCodeWidget;
                if (asView.getParent() == null) {
                    frameLayout.addView(asView);
                    return;
                }
                return;
            }
            this.widget = null;
        } catch (Exception e) {
            IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
            if (markdownLoggerDelegate != null) {
                markdownLoggerDelegate.mo2529e(LOG_TAG, "beforeAttach error:" + e);
            }
        }
    }

    private final int getSpanWidth(Spanned text) {
        if (getStartIndex() == null) {
            return this.maxContentWidth;
        }
        return this.maxContentWidth - SpanUtilsKt.getLeadingMargin(text, getStartIndex().intValue());
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan
    public void afterAttach(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        printLog("span afterAttach", textView.getText(), -1);
    }

    @Override // com.larus.business.markdown.api.extplugin.code.ICustomCodeSpan
    public void onDetach(TextView textView, boolean needRemoveView) {
        ICustomCodeWidget iCustomCodeWidget;
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (needRemoveView && (iCustomCodeWidget = this.widget) != null) {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "textView.context");
            View asView = iCustomCodeWidget.asView(context);
            if (asView != null) {
                ViewParent parent = asView.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(asView);
                }
            }
        }
        this.attachedTextView = null;
        printLog("span detach", null, 0);
    }

    @Override // io.noties.markwon.html.IRecyclableSpan
    public void onRecycle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        ICustomCodeWidget iCustomCodeWidget = this.widget;
        if (iCustomCodeWidget != null) {
            iCustomCodeWidget.onRecycle();
        }
    }

    private final void printLog(String log, CharSequence text, int index) {
        Log.d(LOG_TAG, "log:" + log + ", text:" + ((Object) text) + ", index:" + index);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        int height;
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (text != null && text.length() == end) {
            height = this.size.getHeight();
        } else {
            TextView textView = this.attachedTextView;
            if (textView != null) {
                height = (int) ((this.size.getHeight() - textView.getLineSpacingExtra()) / textView.getLineSpacingMultiplier());
            } else {
                height = this.size.getHeight();
            }
        }
        if (fm != null) {
            fm.ascent = -height;
            fm.descent = 0;
            fm.top = fm.ascent;
            fm.bottom = 0;
        }
        printLog("span_size, get: " + this.size.getWidth() + ", " + height, text, start);
        return this.size.getWidth();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, final CharSequence text, final int start, int end, float x, int top, int y, int bottom, Paint paint) {
        ICustomCodeWidget iCustomCodeWidget;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        TextView textView = this.attachedTextView;
        if (textView == null || (iCustomCodeWidget = this.widget) == null) {
            return;
        }
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        final View asView = iCustomCodeWidget.asView(context);
        MarkdownSpanInfo markdownSpanInfo = null;
        SpannableString spannableString = text instanceof SpannableString ? (SpannableString) text : null;
        if (spannableString != null) {
            Object[] spans = spannableString.getSpans(start, end, MarkdownSpanInfo.class);
            Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
            MarkdownSpanInfo[] markdownSpanInfoArr = (MarkdownSpanInfo[]) spans;
            if (markdownSpanInfoArr != null) {
                markdownSpanInfo = (MarkdownSpanInfo) ArraysKt.firstOrNull(markdownSpanInfoArr);
            }
        }
        asView.setAlpha((markdownSpanInfo != null ? markdownSpanInfo.getAlpha() : 255.0f) / JfifUtil.MARKER_FIRST_BYTE);
        final int height = (((bottom - top) - this.size.getHeight()) / 2) + textView.getTop() + top + textView.getPaddingTop();
        int left = ((int) x) + textView.getLeft() + textView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = asView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.topMargin == height && marginLayoutParams.leftMargin == left) {
            if (asView.getVisibility() != 0) {
                printLog("span just show image marginTop " + height, text, start);
                asView.setVisibility(0);
                return;
            } else {
                printLog("span already show image marginTop " + height, text, start);
                return;
            }
        }
        ViewGroup.LayoutParams layoutParams2 = asView.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams3 = marginLayoutParams2;
        marginLayoutParams3.topMargin = height;
        marginLayoutParams3.leftMargin = left;
        asView.setLayoutParams(marginLayoutParams2);
        asView.setVisibility(4);
        asView.post(new Runnable() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.CustomCodeSpan$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CustomCodeSpan.draw$lambda$4(CustomCodeSpan.this, height, text, start, asView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void draw$lambda$4(CustomCodeSpan customCodeSpan, int i, CharSequence charSequence, int i2, View view) {
        Intrinsics.checkNotNullParameter(customCodeSpan, "this$0");
        Intrinsics.checkNotNullParameter(view, "$widgetView");
        customCodeSpan.printLog("post show image marginTop " + i, charSequence, i2);
        view.setVisibility(0);
    }

    private final ICustomCodeWidget obtainWidget(TextView textView, Integer startIndex) {
        if (startIndex == null) {
            return null;
        }
        Object tag = textView.getTag(C1562R.id.markwon_cached_code_widget_list);
        Map map = TypeIntrinsics.isMutableMap(tag) ? (Map) tag : null;
        if (map == null) {
            return null;
        }
        return (ICustomCodeWidget) map.get(startIndex);
    }

    private final void recycleWidget(View view, Integer startIndex, ICustomCodeWidget widget) {
        if (startIndex == null) {
            return;
        }
        Object tag = view.getTag(C1562R.id.markwon_cached_code_widget_list);
        LinkedHashMap linkedHashMap = TypeIntrinsics.isMutableMap(tag) ? (Map) tag : null;
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
        }
        linkedHashMap.put(startIndex, widget);
        view.setTag(C1562R.id.markwon_cached_code_widget_list, linkedHashMap);
    }
}
