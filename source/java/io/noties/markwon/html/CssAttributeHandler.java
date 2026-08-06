package io.noties.markwon.html;

import android.graphics.Color;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.extplugin.html.HtmlCssStyle;
import com.larus.business.markdown.api.extplugin.html.HtmlCssStyleTheme;
import com.larus.business.markdown.impl.common.utils.MarkdownUnitExtKt;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.span.SpanCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CssAttributeHandler.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J-\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/noties/markwon/html/CssAttributeHandler;", "", "()V", "LOG_TAG", "", "getSpans", "", "tag", "Lio/noties/markwon/html/HtmlTag;", "htmlCssStyleMap", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "darkMode", "", "(Lio/noties/markwon/html/HtmlTag;Ljava/util/Map;Z)[Ljava/lang/Object;", "getStyleSpan", "Landroid/text/style/StyleSpan;", "bold", "italic", "joinSpans", "spans", "cssSpans", "(Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "parseCssColor", "", RemoteMessageConst.Notification.COLOR, "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CssAttributeHandler {
    public static final CssAttributeHandler INSTANCE = new CssAttributeHandler();
    private static final String LOG_TAG = "MD_CSS";

    private CssAttributeHandler() {
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x025f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00a2 A[Catch: all -> 0x014d, TRY_LEAVE, TryCatch #3 {all -> 0x014d, blocks: (B:31:0x008b, B:33:0x0092, B:93:0x00a2), top: B:30:0x008b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object[] getSpans(HtmlTag tag, Map<String, HtmlCssStyle> htmlCssStyleMap, boolean darkMode) {
        HtmlCssStyle htmlCssStyle;
        HtmlCssStyleTheme lightTheme;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Object obj;
        IMarkdownLogger markdownLoggerDelegate;
        Object obj2;
        IMarkdownLogger markdownLoggerDelegate2;
        boolean z;
        Object[] array;
        Integer intOrNull;
        Integer intOrNull2;
        String str6;
        boolean z2;
        String fontWeight;
        HtmlCssStyle htmlCssStyle2;
        Intrinsics.checkNotNullParameter(tag, "tag");
        String str7 = tag.attributes().get("style");
        String str8 = tag.attributes().get("class");
        StyleSpan styleSpan = null;
        if (darkMode) {
            if (htmlCssStyleMap != null && (htmlCssStyle2 = htmlCssStyleMap.get(str8)) != null) {
                lightTheme = htmlCssStyle2.getDarkTheme();
            }
            lightTheme = null;
        } else {
            if (htmlCssStyleMap != null && (htmlCssStyle = htmlCssStyleMap.get(str8)) != null) {
                lightTheme = htmlCssStyle.getLightTheme();
            }
            lightTheme = null;
        }
        String str9 = str7;
        if ((str9 == null || str9.length() == 0) && lightTheme == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (lightTheme == null || (str = lightTheme.getColor()) == null) {
            str = null;
        }
        if (lightTheme == null || (str2 = lightTheme.getBackgroundColor()) == null) {
            str2 = null;
        }
        if (lightTheme == null || (str3 = lightTheme.getFontStyle()) == null) {
            str3 = null;
        }
        String str10 = (lightTheme == null || (fontWeight = lightTheme.getFontWeight()) == null) ? null : fontWeight;
        try {
            Result.Companion companion = Result.Companion;
            str6 = str7;
        } catch (Throwable th) {
            th = th;
            str4 = null;
            str5 = null;
        }
        if (str6 != null && str6.length() != 0) {
            z2 = false;
            if (z2) {
                str4 = null;
                str5 = null;
                for (CssProperty cssProperty : CssInlineStyleParser.create().parse(str7)) {
                    try {
                        String key = cssProperty.key();
                        Intrinsics.checkNotNullExpressionValue(key, "property.key()");
                        String value = cssProperty.value();
                        Intrinsics.checkNotNullExpressionValue(value, "property.value()");
                        String replace$default = StringsKt.replace$default(value, "!important", "", false, 4, (Object) null);
                        if (replace$default == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        String obj3 = StringsKt.trim(replace$default).toString();
                        switch (key.hashCode()) {
                            case -1923578189:
                                if (!key.equals("font-style")) {
                                    break;
                                } else {
                                    str3 = obj3;
                                    continue;
                                }
                            case -1586082113:
                                if (!key.equals("font-size")) {
                                    break;
                                } else {
                                    str4 = obj3;
                                    continue;
                                }
                            case -1221029593:
                                if (key.equals(AnimationConstant.PROP_STR_HEIGHT)) {
                                    break;
                                } else {
                                    break;
                                }
                            case -1215680224:
                                if (key.equals("line-height")) {
                                    break;
                                } else {
                                    break;
                                }
                            case 94842723:
                                if (!key.equals(RemoteMessageConst.Notification.COLOR)) {
                                    break;
                                } else {
                                    str = obj3;
                                    continue;
                                }
                            case 598800822:
                                if (!key.equals("font-weight")) {
                                    break;
                                } else {
                                    str10 = obj3;
                                    continue;
                                }
                            case 605322756:
                                if (!key.equals(AnimationConstant.PROP_STR_BACKGROUND_COLOR)) {
                                    break;
                                } else {
                                    str2 = obj3;
                                    continue;
                                }
                            default:
                                continue;
                        }
                        str5 = obj3;
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                        if (str != null) {
                        }
                        if (str2 != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str3 != null) {
                        }
                        if (str10 != null) {
                        }
                        if (str5 != null) {
                        }
                        array = arrayList.toArray(new Object[0]);
                        if (array != null) {
                        }
                    }
                }
            } else {
                str4 = null;
                str5 = null;
            }
            Result.constructor-impl(Unit.INSTANCE);
            if (str != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(Boolean.valueOf(arrayList.add(new ForegroundColorSpan(INSTANCE.parseCssColor(str)))));
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th3));
                }
                Throwable th4 = Result.exceptionOrNull-impl(obj);
                if (th4 != null && (markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate()) != null) {
                    markdownLoggerDelegate.mo2529e(LOG_TAG, "unsupported color: " + th4);
                }
                Result.box-impl(obj);
            }
            if (str2 != null) {
                try {
                    Result.Companion companion5 = Result.Companion;
                    obj2 = Result.constructor-impl(Boolean.valueOf(arrayList.add(SpanCompat.INSTANCE.newLineBackgroundSpan(INSTANCE.parseCssColor(str2)))));
                } catch (Throwable th5) {
                    Result.Companion companion6 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th5));
                }
                Throwable th6 = Result.exceptionOrNull-impl(obj2);
                if (th6 != null && (markdownLoggerDelegate2 = IMarkdownLoggerKt.getMarkdownLoggerDelegate()) != null) {
                    markdownLoggerDelegate2.mo2529e(LOG_TAG, "unsupported color: " + th6);
                }
                Result.box-impl(obj2);
            }
            if (str4 != null && (intOrNull2 = StringsKt.toIntOrNull(StringsKt.substringBefore(str4, "px", str4))) != null) {
                arrayList.add(new AbsoluteSizeSpan(intOrNull2.intValue(), true));
            }
            if (str3 != null) {
                z = Intrinsics.areEqual(str3, "italic");
                styleSpan = INSTANCE.getStyleSpan(false, z);
                if (styleSpan != null) {
                    arrayList.add(styleSpan);
                }
            } else {
                z = false;
            }
            if (str10 != null) {
                boolean areEqual = Intrinsics.areEqual(str10, "bold");
                if (styleSpan != null) {
                    arrayList.remove(styleSpan);
                }
                StyleSpan styleSpan2 = INSTANCE.getStyleSpan(areEqual, z);
                if (styleSpan2 != null) {
                    arrayList.add(styleSpan2);
                }
            }
            if (str5 != null && (intOrNull = StringsKt.toIntOrNull(StringsKt.substringBefore(str5, "px", str5))) != null && intOrNull.intValue() > 0) {
                arrayList.add(SpanCompat.INSTANCE.newLineHeightSpan(MarkdownUnitExtKt.dp2px(intOrNull)));
            }
            array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        z2 = true;
        if (z2) {
        }
        Result.constructor-impl(Unit.INSTANCE);
        if (str != null) {
        }
        if (str2 != null) {
        }
        if (str4 != null) {
            arrayList.add(new AbsoluteSizeSpan(intOrNull2.intValue(), true));
        }
        if (str3 != null) {
        }
        if (str10 != null) {
        }
        if (str5 != null) {
            arrayList.add(SpanCompat.INSTANCE.newLineHeightSpan(MarkdownUnitExtKt.dp2px(intOrNull)));
        }
        array = arrayList.toArray(new Object[0]);
        if (array != null) {
        }
    }

    private final StyleSpan getStyleSpan(boolean bold, boolean italic) {
        return new StyleSpan((bold && italic) ? 3 : bold ? 1 : italic ? 2 : 0);
    }

    private final int parseCssColor(String color) {
        int length = color.length();
        if (length == 7) {
            return Color.parseColor(color);
        }
        if (length != 9) {
            throw new IllegalArgumentException("Unknown color");
        }
        if (color != null) {
            String substring = color.substring(1, 7);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (color != null) {
                String substring2 = color.substring(7, 9);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return Color.parseColor("#" + substring2 + substring);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final Object[] joinSpans(Object spans, Object[] cssSpans) {
        if (spans == null && cssSpans == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (cssSpans != null) {
            Iterator it = ArraysKt.filterNotNull(cssSpans).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        if (spans instanceof Object[]) {
            Iterator it2 = ArraysKt.filterNotNull((Object[]) spans).iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
        } else if (spans != null) {
            arrayList.add(spans);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        if (array != null) {
            return array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
