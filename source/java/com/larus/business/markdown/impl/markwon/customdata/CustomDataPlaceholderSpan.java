package com.larus.business.markdown.impl.markwon.customdata;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.facebook.imageutils.JfifUtil;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.business.markdown.api.SpanUtilsKt;
import com.larus.business.markdown.api.depend.ICustomDataHandler;
import com.larus.business.markdown.api.depend.ICustomDataHandlerKt;
import com.larus.business.markdown.api.view.IMarkdownMarginFreeView;
import com.larus.business.markdown.api.view.text.IMarkdownTextView;
import com.larus.business.markdown.api.widget.IMarkdownWidgetHandlerKt;
import com.larus.business.markdown.impl.C1327R;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.core.spans.MarkdownSpanInfo;
import io.noties.markwon.html.customdata.CustomDataLynxWidgetExt;
import io.noties.markwon.html.customdata.CustomDataWidgetExtKt;
import io.noties.markwon.html.customdata.ICustomDataSpan;
import io.noties.markwon.html.customdata.ICustomDataWidget;
import io.noties.markwon.html.tag.ImageGridHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: CustomDataPlaceholderSpan.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001VBw\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0002\u0010\u0015J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0019H\u0016J\u0018\u00102\u001a\u0002002\u0006\u00101\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0017H\u0016J\u0018\u00104\u001a\u0002002\u0006\u00101\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0017H\u0002JR\u00105\u001a\u0002002\u0006\u00106\u001a\u0002072\b\u00103\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020AH\u0016J8\u0010B\u001a\u0002002\u0006\u0010C\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u00106\u001a\u000207H\u0002J4\u0010G\u001a\u00020\n2\u0006\u0010@\u001a\u00020A2\b\u00103\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010J\u001a\u00020\n2\u0006\u00103\u001a\u00020\u0017H\u0002J\b\u0010K\u001a\u00020\u0004H\u0002J\b\u0010L\u001a\u00020\u0013H\u0002J\b\u0010M\u001a\u00020\u0013H\u0002J\u0010\u0010N\u001a\u0002002\u0006\u00101\u001a\u00020\u0019H\u0016J\u0010\u0010O\u001a\u0002002\u0006\u00101\u001a\u00020\u0019H\u0016J\u0018\u0010P\u001a\u0002002\u0006\u00101\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0017H\u0016J\"\u0010Q\u001a\u0002002\u0006\u0010R\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u0001082\u0006\u0010S\u001a\u00020\nH\u0002J$\u0010T\u001a\u0002002\u0006\u0010\f\u001a\u00020\n2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u0010\u0010U\u001a\u0002002\u0006\u00101\u001a\u00020\u0019H\u0002R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010 R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/customdata/CustomDataPlaceholderSpan;", "Landroid/text/style/ReplacementSpan;", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "dataType", "", "dataValue", "dataValueId", "dataExtra", "dataTag", "startIndex", "", "endIndex", "maxContentWidth", "dataHandler", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "payload", "", "", "forbiddenLeadingMargin", "", "needRefresh", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILcom/larus/business/markdown/api/depend/ICustomDataHandler;Ljava/util/Map;ZZ)V", "attachedSpanned", "Landroid/text/Spanned;", "attachedTextView", "Landroid/widget/TextView;", "getDataExtra", "()Ljava/lang/String;", "getDataTag", "getDataType", "getDataValue", "setDataValue", "(Ljava/lang/String;)V", "getDataValueId", "debugRect", "Landroid/graphics/Rect;", "getEndIndex$markdown_impl_release", "()I", "getNeedRefresh", "()Z", "setNeedRefresh", "(Z)V", "size", "Landroid/util/Size;", "getStartIndex$markdown_impl_release", "widget", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "afterAttach", "", "textView", "beforeAttach", "text", "beforeAttachCacheWidget", WebViewContainer.EVENT_draw, "canvas", "Landroid/graphics/Canvas;", "", "start", "end", "x", "", AnimationConstant.PROP_STR_TOP, "y", AnimationConstant.PROP_STR_BOTTOM, "paint", "Landroid/graphics/Paint;", "drawDebugRect", AnimationConstant.PROP_STR_LEFT, AnimationConstant.PROP_STR_WIDTH, AnimationConstant.PROP_STR_HEIGHT, RemoteMessageConst.Notification.COLOR, "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "getSpanWidth", "getValueId", "isForbiddenPaddingAndMargin", "isUseCacheWidget", "onDetach", "onRecycle", "onReuse", "printLog", "log", ImageGridHandler.Index, "updateConfig", "updateTextViewPadding", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomDataPlaceholderSpan extends ReplacementSpan implements ICustomDataSpan {
    public static final String LOG_TAG = "custom-data";
    public static final String PAY_LOAD_KEY_FULL_BLOCK = "full_block";
    private Spanned attachedSpanned;
    private TextView attachedTextView;
    private final String dataExtra;
    private final ICustomDataHandler dataHandler;
    private final String dataTag;
    private final String dataType;
    private String dataValue;
    private final String dataValueId;
    private final Rect debugRect;
    private final int endIndex;
    private final boolean forbiddenLeadingMargin;
    private int maxContentWidth;
    private boolean needRefresh;
    private Map<String, ? extends Object> payload;
    private Size size;
    private final int startIndex;
    private ICustomDataWidget widget;

    private final void printLog(String log, CharSequence text, int index) {
    }

    public /* synthetic */ CustomDataPlaceholderSpan(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, ICustomDataHandler iCustomDataHandler, Map map, boolean z, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, i, i2, i3, iCustomDataHandler, map, z, (i4 & AnimationConstant.PROP_BOTTOM) != 0 ? false : z2);
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public String getDataType() {
        return this.dataType;
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public String getDataValue() {
        return this.dataValue;
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public void setDataValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataValue = str;
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public String getDataValueId() {
        return this.dataValueId;
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public String getDataExtra() {
        return this.dataExtra;
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public String getDataTag() {
        return this.dataTag;
    }

    /* renamed from: getStartIndex$markdown_impl_release, reason: from getter */
    public final int getStartIndex() {
        return this.startIndex;
    }

    /* renamed from: getEndIndex$markdown_impl_release, reason: from getter */
    public final int getEndIndex() {
        return this.endIndex;
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public boolean getNeedRefresh() {
        return this.needRefresh;
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public void setNeedRefresh(boolean z) {
        this.needRefresh = z;
    }

    public CustomDataPlaceholderSpan(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, ICustomDataHandler iCustomDataHandler, Map<String, ? extends Object> map, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "dataType");
        Intrinsics.checkNotNullParameter(str2, "dataValue");
        Intrinsics.checkNotNullParameter(str3, "dataValueId");
        Intrinsics.checkNotNullParameter(str5, "dataTag");
        Intrinsics.checkNotNullParameter(iCustomDataHandler, "dataHandler");
        this.dataType = str;
        this.dataValue = str2;
        this.dataValueId = str3;
        this.dataExtra = str4;
        this.dataTag = str5;
        this.startIndex = i;
        this.endIndex = i2;
        this.maxContentWidth = i3;
        this.dataHandler = iCustomDataHandler;
        this.payload = map;
        this.forbiddenLeadingMargin = z;
        this.needRefresh = z2;
        this.size = new Size(0, 0);
        this.debugRect = new Rect();
    }

    public final void updateConfig(int maxContentWidth, Map<String, ? extends Object> payload) {
        this.maxContentWidth = maxContentWidth;
        this.payload = payload;
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public void beforeAttach(TextView textView, Spanned text) {
        View asView;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        this.attachedTextView = textView;
        this.attachedSpanned = text;
        updateTextViewPadding(textView);
        if (isUseCacheWidget()) {
            beforeAttachCacheWidget(textView, text);
            return;
        }
        ViewParent parent = textView.getParent();
        FrameLayout frameLayout = parent instanceof FrameLayout ? (FrameLayout) parent : null;
        if (!(textView instanceof IMarkdownTextView) || frameLayout == null) {
            this.widget = null;
            return;
        }
        ICustomDataWidget obtainWidget = CustomDataWidgetExtKt.obtainWidget(frameLayout, this.startIndex, this.endIndex, getDataType(), getDataValue(), getDataValueId());
        if (obtainWidget != null) {
            this.size = obtainWidget.bindData(textView, text, this, getSpanWidth(text), this.payload);
            printLog("span calc cache: " + this.size.getWidth() + ", " + this.size.getHeight(), textView.getText(), this.startIndex);
            this.widget = obtainWidget;
            asView = obtainWidget.asView();
            ViewGroup.LayoutParams layoutParams = asView.getLayoutParams();
            if (layoutParams.width != this.size.getWidth() || layoutParams.height != this.size.getHeight()) {
                ViewGroup.LayoutParams layoutParams2 = asView.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.size.getWidth();
                    layoutParams2.height = this.size.getHeight();
                    asView.setLayoutParams(layoutParams2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            }
        } else {
            CustomDataPlaceholderSpan customDataPlaceholderSpan = this;
            ICustomDataWidget widget = this.dataHandler.getWidget(frameLayout, textView, text, customDataPlaceholderSpan, this.payload);
            this.size = widget.bindData(textView, text, customDataPlaceholderSpan, getSpanWidth(text), this.payload);
            printLog("span calc new__: " + this.size.getWidth() + ", " + this.size.getHeight(), textView.getText(), this.startIndex);
            asView = widget.asView();
            asView.setLayoutParams(new FrameLayout.LayoutParams(this.size.getWidth(), this.size.getHeight()));
            asView.setVisibility(4);
            this.widget = widget;
        }
        frameLayout.addView(asView);
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public void onReuse(TextView textView, Spanned text) {
        Size onReuse;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        ICustomDataWidget iCustomDataWidget = this.widget;
        if (iCustomDataWidget == null || (onReuse = iCustomDataWidget.onReuse(textView, this, this.payload)) == null) {
            return;
        }
        this.size = onReuse;
        View asView = iCustomDataWidget.asView();
        ViewGroup.LayoutParams layoutParams = asView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (layoutParams.width == this.size.getWidth() && layoutParams.height == this.size.getHeight()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = asView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = this.size.getWidth();
            layoutParams2.height = this.size.getHeight();
            asView.setLayoutParams(layoutParams2);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void updateTextViewPadding(TextView textView) {
        Object tag = textView.getTag(C1327R.id.textview_padding_start);
        Integer num = tag instanceof Integer ? (Integer) tag : null;
        if (num != null) {
            int intValue = num.intValue();
            Object tag2 = textView.getTag(C1327R.id.textview_padding_top);
            Integer num2 = tag2 instanceof Integer ? (Integer) tag2 : null;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                Object tag3 = textView.getTag(C1327R.id.textview_padding_end);
                Integer num3 = tag3 instanceof Integer ? (Integer) tag3 : null;
                if (num3 != null) {
                    int intValue3 = num3.intValue();
                    Object tag4 = textView.getTag(C1327R.id.textview_padding_bottom);
                    Integer num4 = tag4 instanceof Integer ? (Integer) tag4 : null;
                    if (num4 != null) {
                        int intValue4 = num4.intValue();
                        if (Intrinsics.areEqual(getDataTag(), IMarkdownWidgetHandlerKt.DATA_BLOCK_FULL_TAG)) {
                            this.maxContentWidth += intValue + intValue3;
                            textView.setPadding(0, 0, 0, 0);
                        } else if (textView.getPaddingStart() == 0) {
                            textView.setPadding(intValue, intValue2, intValue3, intValue4);
                        }
                    }
                }
            }
        }
    }

    private final int getSpanWidth(Spanned text) {
        if (isForbiddenPaddingAndMargin()) {
            int i = this.maxContentWidth;
            TextView textView = this.attachedTextView;
            int paddingStart = i + (textView != null ? textView.getPaddingStart() : 0);
            TextView textView2 = this.attachedTextView;
            return paddingStart + (textView2 != null ? textView2.getPaddingEnd() : 0);
        }
        if (this.forbiddenLeadingMargin) {
            return this.maxContentWidth;
        }
        return this.maxContentWidth - SpanUtilsKt.getLeadingMargin(text, this.startIndex);
    }

    private final boolean isForbiddenPaddingAndMargin() {
        return (Intrinsics.areEqual(getDataType(), ICustomDataHandlerKt.TYPE_UGC) || Intrinsics.areEqual(getDataType(), ICustomDataHandlerKt.TYPE_FLOW_CREATION) || Intrinsics.areEqual(getDataType(), ICustomDataHandlerKt.TYPE_VLM_MIXED_MEDIA_CARD)) && this.forbiddenLeadingMargin;
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public void afterAttach(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        printLog("span afterAttach", textView.getText(), this.startIndex);
    }

    @Override // io.noties.markwon.html.customdata.ICustomDataSpan
    public void onDetach(TextView textView) {
        View asView;
        Intrinsics.checkNotNullParameter(textView, "textView");
        ICustomDataWidget iCustomDataWidget = this.widget;
        if (iCustomDataWidget != null && (asView = iCustomDataWidget.asView()) != null) {
            ViewParent parent = asView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(asView);
            }
        }
        this.attachedTextView = null;
        printLog("span detach", null, 0);
    }

    @Override // io.noties.markwon.html.IRecyclableSpan
    public void onRecycle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        ICustomDataWidget iCustomDataWidget = this.widget;
        if (iCustomDataWidget != null) {
            iCustomDataWidget.onRecycle();
        }
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
        int i = this.maxContentWidth;
        Spanned spanned = this.attachedSpanned;
        return Math.min(i - (spanned != null ? SpanUtilsKt.getLeadingMargin(spanned, this.startIndex) : 0), this.size.getWidth());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0056  */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas, final CharSequence text, final int start, int end, float x, int top, int y, int bottom, Paint paint) {
        ICustomDataWidget iCustomDataWidget;
        MarkdownSpanInfo markdownSpanInfo;
        int left;
        Integer onDrawOffsetY;
        Integer onDrawOffsetX;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        TextView textView = this.attachedTextView;
        if (textView == null || (iCustomDataWidget = this.widget) == null) {
            return;
        }
        final View asView = iCustomDataWidget.asView();
        SpannableString spannableString = text instanceof SpannableString ? (SpannableString) text : null;
        if (spannableString != null) {
            Object[] spans = spannableString.getSpans(start, end, MarkdownSpanInfo.class);
            Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
            MarkdownSpanInfo[] markdownSpanInfoArr = (MarkdownSpanInfo[]) spans;
            if (markdownSpanInfoArr != null) {
                markdownSpanInfo = (MarkdownSpanInfo) ArraysKt.firstOrNull(markdownSpanInfoArr);
                asView.setAlpha((markdownSpanInfo == null ? markdownSpanInfo.getAlpha() : 255.0f) / JfifUtil.MARKER_FIRST_BYTE);
                final Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = top + textView.getTop() + textView.getPaddingTop();
                if (!isForbiddenPaddingAndMargin()) {
                    left = textView.getLeft();
                } else if (this.forbiddenLeadingMargin) {
                    left = textView.getLeft() + textView.getPaddingLeft();
                } else {
                    left = ((int) x) + textView.getLeft() + textView.getPaddingLeft();
                    int i = left;
                    onDrawOffsetY = iCustomDataWidget.onDrawOffsetY(this.size, textView, canvas, text, start, end, x, top, y, bottom, paint);
                    onDrawOffsetX = iCustomDataWidget.onDrawOffsetX(this.size, textView, canvas, text, start, end, x, top, y, bottom, paint);
                    if (onDrawOffsetY != null) {
                        intRef.element += onDrawOffsetY.intValue();
                    }
                    if (onDrawOffsetX != null) {
                        i += onDrawOffsetX.intValue();
                    }
                    int i2 = i;
                    ViewGroup.LayoutParams layoutParams = asView.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                    if (asView instanceof IMarkdownMarginFreeView) {
                        IMarkdownMarginFreeView.DefaultImpls.onMarkdownMarginChanged$default((IMarkdownMarginFreeView) asView, Integer.valueOf(i2), Integer.valueOf(intRef.element), null, null, 12, null);
                        return;
                    }
                    if (marginLayoutParams == null || (marginLayoutParams.topMargin == intRef.element && marginLayoutParams.leftMargin == i2)) {
                        if (asView.getVisibility() != 0) {
                            printLog("span just show image marginTop " + intRef.element, text, start);
                            asView.setVisibility(0);
                            return;
                        } else {
                            printLog("span already show image marginTop " + intRef.element, text, start);
                            return;
                        }
                    }
                    ViewGroup.LayoutParams layoutParams2 = asView.getLayoutParams();
                    if (layoutParams2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = marginLayoutParams2;
                    marginLayoutParams3.topMargin = intRef.element;
                    marginLayoutParams3.leftMargin = i2;
                    asView.setLayoutParams(marginLayoutParams2);
                    asView.setVisibility(4);
                    asView.post(new Runnable() { // from class: com.larus.business.markdown.impl.markwon.customdata.CustomDataPlaceholderSpan$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            CustomDataPlaceholderSpan.draw$lambda$5(CustomDataPlaceholderSpan.this, intRef, text, start, asView);
                        }
                    });
                    return;
                }
                int i3 = left;
                onDrawOffsetY = iCustomDataWidget.onDrawOffsetY(this.size, textView, canvas, text, start, end, x, top, y, bottom, paint);
                onDrawOffsetX = iCustomDataWidget.onDrawOffsetX(this.size, textView, canvas, text, start, end, x, top, y, bottom, paint);
                if (onDrawOffsetY != null) {
                }
                if (onDrawOffsetX != null) {
                }
                int i22 = i3;
                ViewGroup.LayoutParams layoutParams3 = asView.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams4 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
                if (asView instanceof IMarkdownMarginFreeView) {
                }
            }
        }
        markdownSpanInfo = null;
        asView.setAlpha((markdownSpanInfo == null ? markdownSpanInfo.getAlpha() : 255.0f) / JfifUtil.MARKER_FIRST_BYTE);
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = top + textView.getTop() + textView.getPaddingTop();
        if (!isForbiddenPaddingAndMargin()) {
        }
        int i32 = left;
        onDrawOffsetY = iCustomDataWidget.onDrawOffsetY(this.size, textView, canvas, text, start, end, x, top, y, bottom, paint);
        onDrawOffsetX = iCustomDataWidget.onDrawOffsetX(this.size, textView, canvas, text, start, end, x, top, y, bottom, paint);
        if (onDrawOffsetY != null) {
        }
        if (onDrawOffsetX != null) {
        }
        int i222 = i32;
        ViewGroup.LayoutParams layoutParams32 = asView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams42 = layoutParams32 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams32 : null;
        if (asView instanceof IMarkdownMarginFreeView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void draw$lambda$5(CustomDataPlaceholderSpan customDataPlaceholderSpan, Ref.IntRef intRef, CharSequence charSequence, int i, View view) {
        Intrinsics.checkNotNullParameter(customDataPlaceholderSpan, "this$0");
        Intrinsics.checkNotNullParameter(intRef, "$newTop");
        Intrinsics.checkNotNullParameter(view, "$widgetView");
        customDataPlaceholderSpan.printLog("post show image marginTop " + intRef.element, charSequence, i);
        view.setVisibility(0);
    }

    private final void drawDebugRect(int left, int top, int width, int height, int color, Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        this.debugRect.set(left, top, width + left, height + top);
        canvas.drawRect(this.debugRect, paint);
    }

    private final void beforeAttachCacheWidget(TextView textView, Spanned text) {
        TextView textView2;
        FrameLayout frameLayout;
        View asView;
        ViewParent parent = textView.getParent();
        if (parent instanceof FrameLayout) {
            textView2 = textView;
            frameLayout = (FrameLayout) parent;
        } else {
            textView2 = textView;
            frameLayout = null;
        }
        if (!(textView2 instanceof IMarkdownTextView) || frameLayout == null) {
            this.widget = null;
            return;
        }
        String valueId = getValueId();
        FrameLayout frameLayout2 = frameLayout;
        ICustomDataWidget obtainWidget = CustomDataLynxWidgetExt.INSTANCE.obtainWidget(frameLayout2, this.startIndex, this.endIndex, getDataType(), getDataValue(), valueId, getDataTag());
        if (obtainWidget != null) {
            this.size = obtainWidget.bindData(textView, text, this, getSpanWidth(text), this.payload);
            printLog("span calc cache: " + this.size.getWidth() + ", " + this.size.getHeight(), textView.getText(), this.startIndex);
            this.widget = obtainWidget;
            asView = obtainWidget.asView();
            ViewGroup.LayoutParams layoutParams = asView.getLayoutParams();
            if (layoutParams.width != this.size.getWidth() || layoutParams.height != this.size.getHeight()) {
                ViewGroup.LayoutParams layoutParams2 = asView.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.size.getWidth();
                    layoutParams2.height = -2;
                    asView.setLayoutParams(layoutParams2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            }
            ViewParent parent2 = asView.getParent();
            ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup != null) {
                viewGroup.removeView(asView);
            }
        } else {
            CustomDataPlaceholderSpan customDataPlaceholderSpan = this;
            ICustomDataWidget widget = this.dataHandler.getWidget(frameLayout, textView, text, customDataPlaceholderSpan, this.payload);
            this.size = widget.bindData(textView, text, customDataPlaceholderSpan, getSpanWidth(text), this.payload);
            printLog("span calc new__: " + this.size.getWidth() + ", " + this.size.getHeight(), textView.getText(), this.startIndex);
            asView = widget.asView();
            asView.setLayoutParams(new FrameLayout.LayoutParams(this.size.getWidth(), -2));
            asView.setVisibility(4);
            this.widget = widget;
            CustomDataLynxWidgetExt.INSTANCE.recycleWidget(frameLayout2, this.startIndex, this.endIndex, getDataType(), getDataValue(), valueId, getDataTag(), widget);
        }
        frameLayout.addView(asView);
    }

    private final boolean isUseCacheWidget() {
        return ICustomDataHandlerKt.isMarkdownLynxDataType(getDataType()) || Intrinsics.areEqual(getDataType(), ICustomDataHandlerKt.TYPE_APPLET) || Intrinsics.areEqual(getDataType(), ICustomDataHandlerKt.TYPE_SEARCH_REFERENCE);
    }

    private final String getValueId() {
        if (Intrinsics.areEqual(getDataType(), ICustomDataHandlerKt.TYPE_SEARCH_REFERENCE)) {
            int indexOf$default = StringsKt.indexOf$default(getDataValueId(), BundleUtil.UNDERLINE_TAG, 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                return getDataValueId();
            }
            StringBuilder sb = new StringBuilder();
            String dataValueId = getDataValueId();
            int i = indexOf$default + 1;
            if (dataValueId == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = dataValueId.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return sb.append(substring).append(this.startIndex).toString();
        }
        return getDataValueId();
    }
}
