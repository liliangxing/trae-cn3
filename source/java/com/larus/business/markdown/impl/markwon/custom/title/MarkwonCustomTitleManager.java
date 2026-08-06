package com.larus.business.markdown.impl.markwon.custom.title;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.business.markdown.api.FullScreenDetailType;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.TitleStyle;
import com.larus.business.markdown.impl.C1327R;
import com.larus.business.markdown.impl.common.utils.MarkdownUnitExtKt;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockSpanInfoKt;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.HorizontalLineSpan;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.codeblock.CodeCopyInfoSpan;
import io.noties.markwon.core.spans.codeblock.CustomDynamicDrawableSpan;
import io.noties.markwon.core.spans.codeblock.SpacePaddingSpan;
import io.noties.markwon.core.spans.codeblock.TitleMiddleSpacePaddingSpan;
import io.noties.markwon.ext.tables.TableTitle;
import io.noties.markwon.scrollable.HorizontalScrollable;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* compiled from: MarkwonCustomTitleManager.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eJ6\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006 "}, d2 = {"Lcom/larus/business/markdown/impl/markwon/custom/title/MarkwonCustomTitleManager;", "", "()V", "marginCodeLastButtonToEndAdjuster", "", "getMarginCodeLastButtonToEndAdjuster", "()I", "marginCodeLastButtonToEndAdjuster$delegate", "Lkotlin/Lazy;", "getCodeBlockTitleStyleConfig", "Lcom/larus/business/markdown/impl/markwon/custom/title/CodeBlockTitleStyleConfig;", "titleStyle", "Lcom/larus/business/markdown/api/model/TitleStyle;", "isTableContentStreamingFinished", "", "node", "Lio/noties/markwon/ext/tables/TableTitle;", "visitCodeBlock", "", "contentMaxWidth", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "info", "", "code", "Lorg/commonmark/node/Node;", "context", "Landroid/content/Context;", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "isFinished", "visitTableTitle", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkwonCustomTitleManager {
    public static final MarkwonCustomTitleManager INSTANCE = new MarkwonCustomTitleManager();

    /* renamed from: marginCodeLastButtonToEndAdjuster$delegate, reason: from kotlin metadata */
    private static final Lazy marginCodeLastButtonToEndAdjuster = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.markwon.custom.title.MarkwonCustomTitleManager$marginCodeLastButtonToEndAdjuster$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m2896invoke() {
            return Integer.valueOf(MarkdownUnitExtKt.dp2px((Number) 5));
        }
    });

    /* compiled from: MarkwonCustomTitleManager.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TitleStyle.values().length];
            try {
                iArr[TitleStyle.LARGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TitleStyle.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MarkwonCustomTitleManager() {
    }

    private final int getMarginCodeLastButtonToEndAdjuster() {
        return ((Number) marginCodeLastButtonToEndAdjuster.getValue()).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x018f A[Catch: Exception -> 0x01f2, TRY_LEAVE, TryCatch #8 {Exception -> 0x01f2, blocks: (B:102:0x0158, B:105:0x016a, B:107:0x018f, B:137:0x0279, B:138:0x0284, B:142:0x02b2, B:144:0x02b8, B:145:0x02be, B:150:0x02d1, B:151:0x02d7, B:154:0x02e1, B:156:0x033c, B:158:0x0342, B:160:0x0348, B:162:0x034e), top: B:101:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0211 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02b8 A[Catch: Exception -> 0x01f2, TryCatch #8 {Exception -> 0x01f2, blocks: (B:102:0x0158, B:105:0x016a, B:107:0x018f, B:137:0x0279, B:138:0x0284, B:142:0x02b2, B:144:0x02b8, B:145:0x02be, B:150:0x02d1, B:151:0x02d7, B:154:0x02e1, B:156:0x033c, B:158:0x0342, B:160:0x0348, B:162:0x034e), top: B:101:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02d1 A[Catch: Exception -> 0x01f2, TRY_ENTER, TryCatch #8 {Exception -> 0x01f2, blocks: (B:102:0x0158, B:105:0x016a, B:107:0x018f, B:137:0x0279, B:138:0x0284, B:142:0x02b2, B:144:0x02b8, B:145:0x02be, B:150:0x02d1, B:151:0x02d7, B:154:0x02e1, B:156:0x033c, B:158:0x0342, B:160:0x0348, B:162:0x034e), top: B:101:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x033c A[Catch: Exception -> 0x01f2, TryCatch #8 {Exception -> 0x01f2, blocks: (B:102:0x0158, B:105:0x016a, B:107:0x018f, B:137:0x0279, B:138:0x0284, B:142:0x02b2, B:144:0x02b8, B:145:0x02be, B:150:0x02d1, B:151:0x02d7, B:154:0x02e1, B:156:0x033c, B:158:0x0342, B:160:0x0348, B:162:0x034e), top: B:101:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010b A[Catch: Exception -> 0x0398, TRY_LEAVE, TryCatch #6 {Exception -> 0x0398, blocks: (B:77:0x009a, B:79:0x00c6, B:80:0x00cc, B:82:0x00d8, B:83:0x00df, B:85:0x00ee, B:90:0x00fb, B:94:0x010b), top: B:76:0x009a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void visitCodeBlock(int contentMaxWidth, MarkwonVisitor visitor, String info, String code, Node node, Context context, CustomMarkDownInfo customMarkDownInfo, boolean isFinished) {
        String str;
        int i;
        String str2;
        TitleStyle titleStyle;
        boolean z;
        SpannableStringBuilder spannableStringBuilder;
        int i2;
        int i3;
        boolean z2;
        char c;
        SpannableStringBuilder spannableStringBuilder2;
        String str3;
        boolean z3;
        CodeBlockConfig codeBlockConfig;
        boolean z4;
        boolean z5;
        CodeBlockConfig codeBlockConfig2;
        CodeBlockConfig codeBlockConfig3;
        Integer titleBottomLineColor;
        int length;
        int i4;
        CodeBlockConfig codeBlockConfig4;
        int length2;
        CodeBlockConfig codeBlockConfig5;
        CodeBlockConfig codeBlockConfig6;
        CodeBlockConfig codeBlockConfig7;
        MarkwonVisitor markwonVisitor;
        int i5;
        Integer codeContentSize;
        String str4;
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        if (Intrinsics.areEqual(info, DefaultMarkdownCodeView.MARKDOWN_CODE_STD_OUT)) {
            return;
        }
        String str5 = code;
        boolean z6 = false;
        if (str5.length() == 0) {
            return;
        }
        visitor.blockStart(node);
        int length3 = visitor.length();
        boolean z7 = isFinished || node.next != null;
        CodeBlockConfig codeBlockConfig8 = customMarkDownInfo.getCodeBlockConfig();
        if (codeBlockConfig8 != null && codeBlockConfig8.getEnableCodeHeader()) {
            try {
                CodeBlockConfig codeBlockConfig9 = customMarkDownInfo.getCodeBlockConfig();
                boolean enableCodeCopyButton = codeBlockConfig9 != null ? codeBlockConfig9.getEnableCodeCopyButton() : true;
                if (!enableCodeCopyButton || (codeBlockConfig4 = customMarkDownInfo.getCodeBlockConfig()) == null || (str2 = codeBlockConfig4.getCodeCopyTitle()) == null) {
                    str2 = "";
                }
                CodeBlockConfig codeBlockConfig10 = customMarkDownInfo.getCodeBlockConfig();
                if (codeBlockConfig10 != null) {
                    titleStyle = codeBlockConfig10.getTitleStyle();
                    i = length3;
                } else {
                    i = length3;
                    titleStyle = null;
                }
                try {
                    CodeBlockTitleStyleConfig codeBlockTitleStyleConfig = getCodeBlockTitleStyleConfig(titleStyle);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(info + "\r " + str2);
                    int titleVerticalPadding = codeBlockTitleStyleConfig.getTitleVerticalPadding();
                    CodeBlockConfig codeBlockConfig11 = customMarkDownInfo.getCodeBlockConfig();
                    int codeTitleSize = codeBlockConfig11 != null ? codeBlockConfig11.getCodeTitleSize() : 0;
                    int copyButtonPaddingEnd = codeBlockTitleStyleConfig.getCopyButtonPaddingEnd() + codeBlockTitleStyleConfig.getCopyButtonPaddingStart();
                    int length4 = (info != null ? info.length() : 0) + 2;
                    int length5 = length4 + str2.length();
                    CodeBlockConfig codeBlockConfig12 = customMarkDownInfo.getCodeBlockConfig();
                    try {
                        try {
                            if (codeBlockConfig12 != null && codeBlockConfig12.getEnablePreviewButton()) {
                                if (info != null ? StringsKt.startsWith$default(info, "html", false, 2, (Object) null) : false) {
                                    z = true;
                                    if (z) {
                                        spannableStringBuilder = spannableStringBuilder3;
                                        i2 = codeTitleSize;
                                        i3 = titleVerticalPadding;
                                        str = " ";
                                        z2 = z7;
                                        c = 17;
                                    } else {
                                        int i6 = C1327R.drawable.preview_button_large;
                                        int previewButtonPaddingEnd = codeBlockTitleStyleConfig.getPreviewButtonPaddingEnd();
                                        int previewButtonPaddingStart = codeBlockTitleStyleConfig.getPreviewButtonPaddingStart();
                                        try {
                                            spannableStringBuilder3.insert(spannableStringBuilder3.length(), (CharSequence) " ");
                                            length = spannableStringBuilder3.length();
                                            i4 = length - 1;
                                            Drawable drawable = ContextCompat.getDrawable(context, i6);
                                            copyButtonPaddingEnd += (drawable != null ? drawable.getIntrinsicWidth() : 0) + previewButtonPaddingEnd + previewButtonPaddingStart;
                                            i2 = codeTitleSize;
                                            i3 = titleVerticalPadding;
                                            str = " ";
                                            z2 = z7;
                                        } catch (Exception e) {
                                            e = e;
                                            str = " ";
                                            z6 = false;
                                            Log.e("MarkwonExt", "visitCodeBlock error:" + e.getLocalizedMessage());
                                            length2 = visitor.length();
                                            codeBlockConfig5 = customMarkDownInfo.getCodeBlockConfig();
                                            if (!((codeBlockConfig5 == null && codeBlockConfig5.getEnableLineNumber()) ? true : z6)) {
                                            }
                                            visitor.ensureNewLine();
                                            visitor.builder().append((char) 160);
                                            visitor.renderProps().set(CoreProps.CODE_BLOCK_INFO, info);
                                            visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_START_INDEX(), Integer.valueOf(i));
                                            visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_END_INDEX(), Integer.valueOf(visitor.length()));
                                            codeBlockConfig6 = customMarkDownInfo.getCodeBlockConfig();
                                            if (codeBlockConfig6 != null) {
                                                visitor.builder().setSpan(new AbsoluteSizeSpan(codeContentSize.intValue()), length2, visitor.length(), 17);
                                            }
                                            codeBlockConfig7 = customMarkDownInfo.getCodeBlockConfig();
                                            if ((codeBlockConfig7 == null && codeBlockConfig7.getEnableScroll()) ? true : z6) {
                                            }
                                            markwonVisitor.setSpansForNodeOptional((MarkwonVisitor) node, i5);
                                            markwonVisitor.blockEnd(node);
                                        }
                                        try {
                                            spannableStringBuilder = spannableStringBuilder3;
                                            spannableStringBuilder.setSpan(new CustomDynamicDrawableSpan(context, i6, titleVerticalPadding, previewButtonPaddingEnd, previewButtonPaddingStart, 1, z2), i4, length, 33);
                                            c = 17;
                                            spannableStringBuilder.setSpan(new FullScreenDetailInfoSpan(info == null ? "" : info, code, code, FullScreenDetailType.CODE_BLOCK, z2, true), i4, length, 17);
                                        } catch (Exception e2) {
                                            e = e2;
                                            z6 = false;
                                            Log.e("MarkwonExt", "visitCodeBlock error:" + e.getLocalizedMessage());
                                            length2 = visitor.length();
                                            codeBlockConfig5 = customMarkDownInfo.getCodeBlockConfig();
                                            if (!((codeBlockConfig5 == null && codeBlockConfig5.getEnableLineNumber()) ? true : z6)) {
                                            }
                                            visitor.ensureNewLine();
                                            visitor.builder().append((char) 160);
                                            visitor.renderProps().set(CoreProps.CODE_BLOCK_INFO, info);
                                            visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_START_INDEX(), Integer.valueOf(i));
                                            visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_END_INDEX(), Integer.valueOf(visitor.length()));
                                            codeBlockConfig6 = customMarkDownInfo.getCodeBlockConfig();
                                            if (codeBlockConfig6 != null) {
                                            }
                                            codeBlockConfig7 = customMarkDownInfo.getCodeBlockConfig();
                                            if ((codeBlockConfig7 == null && codeBlockConfig7.getEnableScroll()) ? true : z6) {
                                            }
                                            markwonVisitor.setSpansForNodeOptional((MarkwonVisitor) node, i5);
                                            markwonVisitor.blockEnd(node);
                                        }
                                    }
                                    if (enableCodeCopyButton) {
                                        spannableStringBuilder2 = spannableStringBuilder;
                                        str3 = str;
                                        z3 = z2;
                                    } else {
                                        int copyButton = codeBlockTitleStyleConfig.getCopyButton();
                                        int copyButtonPaddingEnd2 = codeBlockTitleStyleConfig.getCopyButtonPaddingEnd();
                                        int copyButtonPaddingStart = codeBlockTitleStyleConfig.getCopyButtonPaddingStart();
                                        str3 = str;
                                        try {
                                            spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) str3);
                                            int length6 = spannableStringBuilder.length();
                                            int i7 = length6 - 1;
                                            Drawable drawable2 = ContextCompat.getDrawable(context, copyButton);
                                            copyButtonPaddingEnd += (drawable2 != null ? drawable2.getIntrinsicWidth() : 0) + copyButtonPaddingEnd2 + copyButtonPaddingStart;
                                            spannableStringBuilder2 = spannableStringBuilder;
                                            spannableStringBuilder2.setSpan(new CustomDynamicDrawableSpan(context, copyButton, i3, copyButtonPaddingEnd2, copyButtonPaddingStart, 1, z2), i7, length6, 33);
                                            z3 = z2;
                                            try {
                                                spannableStringBuilder2.setSpan(new CodeCopyInfoSpan(info == null ? "" : info, code, z3, false), i7, length6, 17);
                                            } catch (Exception e3) {
                                                e = e3;
                                                z6 = false;
                                                str = str3;
                                                Log.e("MarkwonExt", "visitCodeBlock error:" + e.getLocalizedMessage());
                                                length2 = visitor.length();
                                                codeBlockConfig5 = customMarkDownInfo.getCodeBlockConfig();
                                                if (!((codeBlockConfig5 == null && codeBlockConfig5.getEnableLineNumber()) ? true : z6)) {
                                                }
                                                visitor.ensureNewLine();
                                                visitor.builder().append((char) 160);
                                                visitor.renderProps().set(CoreProps.CODE_BLOCK_INFO, info);
                                                visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_START_INDEX(), Integer.valueOf(i));
                                                visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_END_INDEX(), Integer.valueOf(visitor.length()));
                                                codeBlockConfig6 = customMarkDownInfo.getCodeBlockConfig();
                                                if (codeBlockConfig6 != null) {
                                                }
                                                codeBlockConfig7 = customMarkDownInfo.getCodeBlockConfig();
                                                if ((codeBlockConfig7 == null && codeBlockConfig7.getEnableScroll()) ? true : z6) {
                                                }
                                                markwonVisitor.setSpansForNodeOptional((MarkwonVisitor) node, i5);
                                                markwonVisitor.blockEnd(node);
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            str = str3;
                                            z6 = false;
                                            Log.e("MarkwonExt", "visitCodeBlock error:" + e.getLocalizedMessage());
                                            length2 = visitor.length();
                                            codeBlockConfig5 = customMarkDownInfo.getCodeBlockConfig();
                                            if (!((codeBlockConfig5 == null && codeBlockConfig5.getEnableLineNumber()) ? true : z6)) {
                                            }
                                            visitor.ensureNewLine();
                                            visitor.builder().append((char) 160);
                                            visitor.renderProps().set(CoreProps.CODE_BLOCK_INFO, info);
                                            visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_START_INDEX(), Integer.valueOf(i));
                                            visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_END_INDEX(), Integer.valueOf(visitor.length()));
                                            codeBlockConfig6 = customMarkDownInfo.getCodeBlockConfig();
                                            if (codeBlockConfig6 != null) {
                                            }
                                            codeBlockConfig7 = customMarkDownInfo.getCodeBlockConfig();
                                            if ((codeBlockConfig7 == null && codeBlockConfig7.getEnableScroll()) ? true : z6) {
                                            }
                                            markwonVisitor.setSpansForNodeOptional((MarkwonVisitor) node, i5);
                                            markwonVisitor.blockEnd(node);
                                        }
                                    }
                                    Integer fullScreenButton = codeBlockTitleStyleConfig.getFullScreenButton();
                                    codeBlockConfig = customMarkDownInfo.getCodeBlockConfig();
                                    if (codeBlockConfig != null && codeBlockConfig.getEnableCodeFullScreenButton()) {
                                        z4 = true;
                                        if (z4 || fullScreenButton == null) {
                                            str = str3;
                                        } else {
                                            spannableStringBuilder2.insert(spannableStringBuilder2.length(), (CharSequence) str3);
                                            int length7 = spannableStringBuilder2.length();
                                            int i8 = length7 - 1;
                                            int fullScreenButtonPaddingEnd = codeBlockTitleStyleConfig.getFullScreenButtonPaddingEnd();
                                            int fullScreenButtonPaddingStart = codeBlockTitleStyleConfig.getFullScreenButtonPaddingStart();
                                            Drawable drawable3 = ContextCompat.getDrawable(context, fullScreenButton.intValue());
                                            copyButtonPaddingEnd += (drawable3 != null ? drawable3.getIntrinsicWidth() : 0) + fullScreenButtonPaddingEnd + fullScreenButtonPaddingStart;
                                            boolean z8 = z3;
                                            spannableStringBuilder2.setSpan(new CustomDynamicDrawableSpan(context, fullScreenButton.intValue(), i3, fullScreenButtonPaddingEnd, fullScreenButtonPaddingStart, 1, z3), i8, length7, 33);
                                            str = str3;
                                            spannableStringBuilder2.setSpan(new FullScreenDetailInfoSpan(info == null ? "" : info, code, code, FullScreenDetailType.CODE_BLOCK, z8, false, 32, null), i8, length7, 17);
                                        }
                                        spannableStringBuilder2.insert(spannableStringBuilder2.length(), (CharSequence) "\r\n");
                                        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, C1327R.color.neutral_70)), 0, spannableStringBuilder2.length(), 17);
                                        spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(i2, true), 0, spannableStringBuilder2.length(), 17);
                                        int titlePaddingEnd = codeBlockTitleStyleConfig.getTitlePaddingEnd();
                                        int length8 = info == null ? info.length() : 0;
                                        int i9 = length8 + 1;
                                        SpannableStringBuilder spannableStringBuilder4 = spannableStringBuilder2;
                                        Pair[] pairArr = new Pair[2];
                                        z5 = false;
                                        z5 = false;
                                        pairArr[0] = new Pair(0, Integer.valueOf(info == null ? info.length() : 0));
                                        pairArr[1] = new Pair(Integer.valueOf(length4), Integer.valueOf(length5));
                                        spannableStringBuilder2.setSpan(new TitleMiddleSpacePaddingSpan(spannableStringBuilder4, contentMaxWidth, CollectionsKt.listOf(pairArr), ((visitor.configuration().theme().getCodeBlockMargin() + titlePaddingEnd) + copyButtonPaddingEnd) - getMarginCodeLastButtonToEndAdjuster(), i3), length8, i9, 33);
                                        int length9 = spannableStringBuilder2.length() - 2;
                                        spannableStringBuilder2.setSpan(new SpacePaddingSpan(titlePaddingEnd, i3), length9, length9 + 1, 33);
                                        visitor.builder().append((CharSequence) spannableStringBuilder2);
                                        codeBlockConfig2 = customMarkDownInfo.getCodeBlockConfig();
                                        if (codeBlockConfig2 != null || !codeBlockConfig2.getEnableTitleBottomLine() || (codeBlockConfig3 = customMarkDownInfo.getCodeBlockConfig()) == null || (titleBottomLineColor = codeBlockConfig3.getTitleBottomLineColor()) == null) {
                                            z6 = false;
                                        } else {
                                            int intValue = titleBottomLineColor.intValue();
                                            SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder("\r\n");
                                            z6 = false;
                                            try {
                                                spannableStringBuilder5.setSpan(new HorizontalLineSpan(context, visitor.configuration().theme().getCodeBlockMargin(), MarkdownUnitExtKt.dp2px((Number) 1), intValue), 0, spannableStringBuilder5.length(), 17);
                                                visitor.builder().append((CharSequence) spannableStringBuilder5);
                                            } catch (Exception e5) {
                                                e = e5;
                                                Log.e("MarkwonExt", "visitCodeBlock error:" + e.getLocalizedMessage());
                                                length2 = visitor.length();
                                                codeBlockConfig5 = customMarkDownInfo.getCodeBlockConfig();
                                                if (!((codeBlockConfig5 == null && codeBlockConfig5.getEnableLineNumber()) ? true : z6)) {
                                                }
                                                visitor.ensureNewLine();
                                                visitor.builder().append((char) 160);
                                                visitor.renderProps().set(CoreProps.CODE_BLOCK_INFO, info);
                                                visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_START_INDEX(), Integer.valueOf(i));
                                                visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_END_INDEX(), Integer.valueOf(visitor.length()));
                                                codeBlockConfig6 = customMarkDownInfo.getCodeBlockConfig();
                                                if (codeBlockConfig6 != null) {
                                                }
                                                codeBlockConfig7 = customMarkDownInfo.getCodeBlockConfig();
                                                if ((codeBlockConfig7 == null && codeBlockConfig7.getEnableScroll()) ? true : z6) {
                                                }
                                                markwonVisitor.setSpansForNodeOptional((MarkwonVisitor) node, i5);
                                                markwonVisitor.blockEnd(node);
                                            }
                                        }
                                    }
                                    z4 = false;
                                    if (z4) {
                                    }
                                    str = str3;
                                    spannableStringBuilder2.insert(spannableStringBuilder2.length(), (CharSequence) "\r\n");
                                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, C1327R.color.neutral_70)), 0, spannableStringBuilder2.length(), 17);
                                    spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(i2, true), 0, spannableStringBuilder2.length(), 17);
                                    int titlePaddingEnd2 = codeBlockTitleStyleConfig.getTitlePaddingEnd();
                                    if (info == null) {
                                    }
                                    int i92 = length8 + 1;
                                    SpannableStringBuilder spannableStringBuilder42 = spannableStringBuilder2;
                                    Pair[] pairArr2 = new Pair[2];
                                    z5 = false;
                                    z5 = false;
                                    pairArr2[0] = new Pair(0, Integer.valueOf(info == null ? info.length() : 0));
                                    pairArr2[1] = new Pair(Integer.valueOf(length4), Integer.valueOf(length5));
                                    spannableStringBuilder2.setSpan(new TitleMiddleSpacePaddingSpan(spannableStringBuilder42, contentMaxWidth, CollectionsKt.listOf(pairArr2), ((visitor.configuration().theme().getCodeBlockMargin() + titlePaddingEnd2) + copyButtonPaddingEnd) - getMarginCodeLastButtonToEndAdjuster(), i3), length8, i92, 33);
                                    int length92 = spannableStringBuilder2.length() - 2;
                                    spannableStringBuilder2.setSpan(new SpacePaddingSpan(titlePaddingEnd2, i3), length92, length92 + 1, 33);
                                    visitor.builder().append((CharSequence) spannableStringBuilder2);
                                    codeBlockConfig2 = customMarkDownInfo.getCodeBlockConfig();
                                    if (codeBlockConfig2 != null) {
                                    }
                                    z6 = false;
                                }
                            }
                            if (codeBlockConfig != null) {
                                z4 = true;
                                if (z4) {
                                }
                                str = str3;
                                spannableStringBuilder2.insert(spannableStringBuilder2.length(), (CharSequence) "\r\n");
                                spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, C1327R.color.neutral_70)), 0, spannableStringBuilder2.length(), 17);
                                spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(i2, true), 0, spannableStringBuilder2.length(), 17);
                                int titlePaddingEnd22 = codeBlockTitleStyleConfig.getTitlePaddingEnd();
                                if (info == null) {
                                }
                                int i922 = length8 + 1;
                                SpannableStringBuilder spannableStringBuilder422 = spannableStringBuilder2;
                                Pair[] pairArr22 = new Pair[2];
                                z5 = false;
                                z5 = false;
                                pairArr22[0] = new Pair(0, Integer.valueOf(info == null ? info.length() : 0));
                                pairArr22[1] = new Pair(Integer.valueOf(length4), Integer.valueOf(length5));
                                spannableStringBuilder2.setSpan(new TitleMiddleSpacePaddingSpan(spannableStringBuilder422, contentMaxWidth, CollectionsKt.listOf(pairArr22), ((visitor.configuration().theme().getCodeBlockMargin() + titlePaddingEnd22) + copyButtonPaddingEnd) - getMarginCodeLastButtonToEndAdjuster(), i3), length8, i922, 33);
                                int length922 = spannableStringBuilder2.length() - 2;
                                spannableStringBuilder2.setSpan(new SpacePaddingSpan(titlePaddingEnd22, i3), length922, length922 + 1, 33);
                                visitor.builder().append((CharSequence) spannableStringBuilder2);
                                codeBlockConfig2 = customMarkDownInfo.getCodeBlockConfig();
                                if (codeBlockConfig2 != null) {
                                }
                                z6 = false;
                            }
                            z5 = false;
                            pairArr22[0] = new Pair(0, Integer.valueOf(info == null ? info.length() : 0));
                            pairArr22[1] = new Pair(Integer.valueOf(length4), Integer.valueOf(length5));
                            spannableStringBuilder2.setSpan(new TitleMiddleSpacePaddingSpan(spannableStringBuilder422, contentMaxWidth, CollectionsKt.listOf(pairArr22), ((visitor.configuration().theme().getCodeBlockMargin() + titlePaddingEnd22) + copyButtonPaddingEnd) - getMarginCodeLastButtonToEndAdjuster(), i3), length8, i922, 33);
                            int length9222 = spannableStringBuilder2.length() - 2;
                            spannableStringBuilder2.setSpan(new SpacePaddingSpan(titlePaddingEnd22, i3), length9222, length9222 + 1, 33);
                            visitor.builder().append((CharSequence) spannableStringBuilder2);
                            codeBlockConfig2 = customMarkDownInfo.getCodeBlockConfig();
                            if (codeBlockConfig2 != null) {
                            }
                            z6 = false;
                        } catch (Exception e6) {
                            e = e6;
                            z6 = z5;
                        }
                        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, C1327R.color.neutral_70)), 0, spannableStringBuilder2.length(), 17);
                        spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(i2, true), 0, spannableStringBuilder2.length(), 17);
                        int titlePaddingEnd222 = codeBlockTitleStyleConfig.getTitlePaddingEnd();
                        if (info == null) {
                        }
                        int i9222 = length8 + 1;
                        SpannableStringBuilder spannableStringBuilder4222 = spannableStringBuilder2;
                        Pair[] pairArr222 = new Pair[2];
                        z5 = false;
                    } catch (Exception e7) {
                        e = e7;
                        z6 = false;
                    }
                    z = false;
                    if (z) {
                    }
                    if (enableCodeCopyButton) {
                    }
                    Integer fullScreenButton2 = codeBlockTitleStyleConfig.getFullScreenButton();
                    codeBlockConfig = customMarkDownInfo.getCodeBlockConfig();
                    z4 = false;
                    if (z4) {
                    }
                    str = str3;
                    spannableStringBuilder2.insert(spannableStringBuilder2.length(), (CharSequence) "\r\n");
                } catch (Exception e8) {
                    e = e8;
                    str = " ";
                }
            } catch (Exception e9) {
                e = e9;
                str = " ";
                i = length3;
            }
        } else {
            str = " ";
            i = length3;
        }
        length2 = visitor.length();
        codeBlockConfig5 = customMarkDownInfo.getCodeBlockConfig();
        if (!((codeBlockConfig5 == null && codeBlockConfig5.getEnableLineNumber()) ? true : z6)) {
            StringBuilder sb = new StringBuilder();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<String> split$default = StringsKt.split$default(str5, new String[]{"\n"}, false, 0, 6, (Object) null);
            int i10 = 1;
            for (String str6 : split$default) {
                if (str6.length() > 0 ? true : z6) {
                    str4 = str;
                    sb.append(str4);
                    linkedHashMap.put(Integer.valueOf(sb.length() - 1), Integer.valueOf(i10));
                    sb.append(str6);
                    sb.append("\n");
                    i10++;
                } else {
                    str4 = str;
                }
                str = str4;
            }
            visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_MAX_LINE(), Integer.valueOf(split$default.size()));
            visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_LINE_NUMBER_MAP(), linkedHashMap);
            visitor.builder().append(visitor.configuration().syntaxHighlight().highlight(info, sb.toString()));
        } else {
            visitor.builder().append(visitor.configuration().syntaxHighlight().highlight(info, code));
        }
        visitor.ensureNewLine();
        visitor.builder().append((char) 160);
        visitor.renderProps().set(CoreProps.CODE_BLOCK_INFO, info);
        visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_START_INDEX(), Integer.valueOf(i));
        visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_END_INDEX(), Integer.valueOf(visitor.length()));
        codeBlockConfig6 = customMarkDownInfo.getCodeBlockConfig();
        if (codeBlockConfig6 != null && (codeContentSize = codeBlockConfig6.getCodeContentSize()) != null) {
            visitor.builder().setSpan(new AbsoluteSizeSpan(codeContentSize.intValue()), length2, visitor.length(), 17);
        }
        codeBlockConfig7 = customMarkDownInfo.getCodeBlockConfig();
        if ((codeBlockConfig7 == null && codeBlockConfig7.getEnableScroll()) ? true : z6) {
            markwonVisitor = visitor;
            i5 = i;
        } else {
            HorizontalScrollable horizontalScrollable = new HorizontalScrollable(0.0f);
            visitor.renderProps().set(CodeBlockSpanInfoKt.getCODE_BLOCK_SCROLLABLE(), horizontalScrollable);
            markwonVisitor = visitor;
            i5 = i;
            markwonVisitor.setSpans(i5, horizontalScrollable);
        }
        markwonVisitor.setSpansForNodeOptional((MarkwonVisitor) node, i5);
        markwonVisitor.blockEnd(node);
    }

    public final void visitTableTitle(Context context, int contentMaxWidth, MarkwonVisitor visitor, TableTitle node, CustomMarkDownInfo customMarkDownInfo, boolean isFinished) {
        String literal;
        String str;
        int i;
        SpannableStringBuilder spannableStringBuilder;
        String str2;
        int i2;
        char c;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        TableConfig tableConfig = customMarkDownInfo.getTableConfig();
        if (tableConfig == null) {
            return;
        }
        boolean z = isFinished || isTableContentStreamingFinished(node);
        try {
            if (tableConfig.getEnableTableHeader()) {
                int length = visitor.length();
                CodeBlockTitleStyleConfig codeBlockTitleStyleConfig = getCodeBlockTitleStyleConfig(TitleStyle.LARGE);
                String tableTitle = tableConfig.getTableTitle();
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(tableTitle + '\r');
                int titleVerticalPadding = codeBlockTitleStyleConfig.getTitleVerticalPadding();
                Integer tableTitleSize = tableConfig.getTableTitleSize();
                int intValue = tableTitleSize != null ? tableTitleSize.intValue() : 0;
                boolean enableCopyButton = tableConfig.getEnableCopyButton();
                TableConfig tableConfig2 = customMarkDownInfo.getTableConfig();
                if (tableConfig2 != null && tableConfig2.getCopyExcelStyle()) {
                    literal = node.getExcelLiteral();
                } else {
                    literal = node.getLiteral();
                }
                String str3 = literal;
                if (enableCopyButton) {
                    spannableStringBuilder2.insert(spannableStringBuilder2.length(), (CharSequence) " ");
                    int copyButton = codeBlockTitleStyleConfig.getCopyButton();
                    int copyButtonPaddingEnd = codeBlockTitleStyleConfig.getCopyButtonPaddingEnd();
                    int copyButtonPaddingStart = codeBlockTitleStyleConfig.getCopyButtonPaddingStart();
                    int length2 = spannableStringBuilder2.length();
                    int i5 = length2 - 1;
                    Drawable drawable = ContextCompat.getDrawable(context, copyButton);
                    i4 = (drawable != null ? drawable.getIntrinsicWidth() : 0) + copyButtonPaddingEnd + copyButtonPaddingStart;
                    i = intValue;
                    spannableStringBuilder = spannableStringBuilder2;
                    str2 = tableTitle;
                    i2 = length;
                    i3 = 33;
                    spannableStringBuilder.setSpan(new CustomDynamicDrawableSpan(context, copyButton, titleVerticalPadding, copyButtonPaddingEnd, copyButtonPaddingStart, 1, z), i5, length2, 33);
                    str = str3;
                    c = 17;
                    spannableStringBuilder.setSpan(new CodeCopyInfoSpan(node.getInfo(), str, z, false), i5, length2, 17);
                } else {
                    str = str3;
                    i = intValue;
                    spannableStringBuilder = spannableStringBuilder2;
                    str2 = tableTitle;
                    i2 = length;
                    c = 17;
                    i3 = 33;
                    i4 = 0;
                }
                int i6 = C1327R.drawable.markdown_download_button;
                spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) " ");
                int length3 = spannableStringBuilder.length();
                int i7 = length3 - 1;
                int downloadButtonPaddingEnd = codeBlockTitleStyleConfig.getDownloadButtonPaddingEnd();
                int downloadButtonPaddingStart = codeBlockTitleStyleConfig.getDownloadButtonPaddingStart();
                Drawable drawable2 = ContextCompat.getDrawable(context, i6);
                int intrinsicWidth = i4 + (drawable2 != null ? drawable2.getIntrinsicWidth() : 0) + downloadButtonPaddingEnd + downloadButtonPaddingStart;
                int i8 = i3;
                spannableStringBuilder.setSpan(new CustomDynamicDrawableSpan(context, i6, titleVerticalPadding, downloadButtonPaddingEnd, downloadButtonPaddingStart, 1, z), i7, length3, i8);
                spannableStringBuilder.setSpan(new CodeCopyInfoSpan(node.getInfo(), str, z, true), i7, length3, 17);
                boolean enableFullScreenButton = tableConfig.getEnableFullScreenButton();
                Integer fullScreenButton = codeBlockTitleStyleConfig.getFullScreenButton();
                if (enableFullScreenButton && fullScreenButton != null) {
                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) " ");
                    int length4 = spannableStringBuilder.length();
                    int i9 = length4 - 1;
                    int fullScreenButtonPaddingEnd = codeBlockTitleStyleConfig.getFullScreenButtonPaddingEnd();
                    int fullScreenButtonPaddingStart = codeBlockTitleStyleConfig.getFullScreenButtonPaddingStart();
                    Drawable drawable3 = ContextCompat.getDrawable(context, fullScreenButton.intValue());
                    int intrinsicWidth2 = intrinsicWidth + (drawable3 != null ? drawable3.getIntrinsicWidth() : 0) + fullScreenButtonPaddingEnd + fullScreenButtonPaddingStart;
                    spannableStringBuilder.setSpan(new CustomDynamicDrawableSpan(context, fullScreenButton.intValue(), titleVerticalPadding, fullScreenButtonPaddingEnd, fullScreenButtonPaddingStart, 1, z), i9, length4, i8);
                    spannableStringBuilder.setSpan(new FullScreenDetailInfoSpan(node.getInfo(), node.getLiteral(), str, FullScreenDetailType.TABLE_BLOCK, z, false, 32, null), i9, length4, 17);
                    intrinsicWidth = intrinsicWidth2;
                }
                spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) "\r\n");
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, C1327R.color.neutral_70)), 0, spannableStringBuilder.length(), 17);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i, true), 0, spannableStringBuilder.length(), 17);
                int titlePaddingEnd = codeBlockTitleStyleConfig.getTitlePaddingEnd();
                int length5 = str2.length();
                spannableStringBuilder.setSpan(new TitleMiddleSpacePaddingSpan(spannableStringBuilder, contentMaxWidth, CollectionsKt.listOf(new Pair(0, Integer.valueOf(str2.length()))), titlePaddingEnd + visitor.configuration().theme().getCodeBlockMargin() + intrinsicWidth, titleVerticalPadding), length5, length5 + 1, i8);
                visitor.builder().append((CharSequence) spannableStringBuilder);
                visitor.renderProps().set(TableTitleSpanKt.getTABLE_TITLE_START_INDEX(), Integer.valueOf(i2));
                visitor.renderProps().set(TableTitleSpanKt.getTABLE_TITLE_END_INDEX(), Integer.valueOf(visitor.length()));
                visitor.setSpansForNodeOptional((MarkwonVisitor) node, i2);
            }
        } catch (Exception e) {
            Log.e("MarkwonExt", "visitTableTitle error:" + e.getLocalizedMessage());
        }
    }

    private final boolean isTableContentStreamingFinished(TableTitle node) {
        Node node2;
        Node node3;
        Node node4 = ((CustomNode) node).parent;
        Node node5 = (node4 == null || (node3 = node4.next) == null) ? null : node3.lastChild;
        boolean z = true;
        while (node5 != null) {
            if (node5.next != null) {
                node5 = null;
                z = false;
            }
            node5 = node5 != null ? node5.parent : null;
        }
        if (((CustomNode) node).parent.next != null) {
            Node node6 = ((CustomNode) node).parent;
            Node node7 = (node6 == null || (node2 = node6.next) == null) ? null : node2.lastChild;
            Text text = node7 instanceof Text ? (Text) node7 : null;
            if (!Intrinsics.areEqual(text != null ? text.getLiteral() : null, HiAnalyticsConstant.REPORT_VAL_SEPARATOR) || !z) {
                return true;
            }
        }
        return false;
    }

    private final CodeBlockTitleStyleConfig getCodeBlockTitleStyleConfig(TitleStyle titleStyle) {
        int i = titleStyle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[titleStyle.ordinal()];
        if (i != -1) {
            if (i == 1) {
                int dp2px = MarkdownUnitExtKt.dp2px((Number) 9);
                int i2 = C1327R.drawable.copy_button_large;
                int i3 = C1327R.drawable.fullscreen_button_large;
                return new CodeBlockTitleStyleConfig(dp2px, i2, Integer.valueOf(i3), MarkdownUnitExtKt.dp2px((Number) 7), MarkdownUnitExtKt.dp2px((Number) 7), MarkdownUnitExtKt.dp2px((Number) 7), MarkdownUnitExtKt.dp2px((Number) 7), MarkdownUnitExtKt.dp2px((Number) 7), MarkdownUnitExtKt.dp2px((Number) 7), MarkdownUnitExtKt.dp2px((Number) 7), MarkdownUnitExtKt.dp2px((Number) 7), MarkdownUnitExtKt.dp2px((Number) 8));
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return new CodeBlockTitleStyleConfig(MarkdownUnitExtKt.dp2px((Number) 6), C1327R.drawable.copy_button, null, 0, 0, MarkdownUnitExtKt.dp2px((Number) 4), 0, 0, 0, 0, 0, MarkdownUnitExtKt.dp2px((Number) 12));
    }
}
