package com.larus.business.markdown.impl.markwon.customdata;

import android.text.Spanned;
import com.larus.business.markdown.api.depend.ICustomDataHandler;
import com.larus.business.markdown.api.depend.ICustomDataHandlerKt;
import com.larus.business.markdown.api.widget.IMarkdownWidgetHandlerKt;
import com.larus.business.markdown.impl.markwon.MarkwonExtKt;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.html.HtmlEmptyTagReplacement;
import io.noties.markwon.html.HtmlTag;
import io.noties.markwon.html.MarkwonHtmlRenderer;
import io.noties.markwon.html.TagHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomDataTagHandler.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003H\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/customdata/CustomDataTagHandler;", "Lio/noties/markwon/html/TagHandler;", "handlerList", "", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "(Ljava/util/List;)V", "handle", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "renderer", "Lio/noties/markwon/html/MarkwonHtmlRenderer;", "tag", "Lio/noties/markwon/html/HtmlTag;", "replaceTag", "", "emptyReplacement", "Lio/noties/markwon/html/HtmlEmptyTagReplacement;", "supportedTags", "", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomDataTagHandler extends TagHandler {
    public static final String ALT_ATTRIBUTE = "alt";
    public static final String EXTRA_ATTRIBUTE = "extra";
    public static final String TYPE_ATTRIBUTE = "type";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String VALUE_ID_ATTRIBUTE = "value_id";
    private final List<ICustomDataHandler> handlerList;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomDataTagHandler(List<? extends ICustomDataHandler> list) {
        this.handlerList = list;
    }

    @Override // io.noties.markwon.html.TagHandler
    public List<String> supportedTags() {
        return CollectionsKt.listOf(new String[]{IMarkdownWidgetHandlerKt.DATA_BLOCK_TAG, IMarkdownWidgetHandlerKt.DATA_INLINE_TAG, IMarkdownWidgetHandlerKt.DATA_INLINE_NO_MARGIN_TAG, IMarkdownWidgetHandlerKt.DATA_BLOCK_FULL_TAG});
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x013b, code lost:
    
        if (r9 != null) goto L73;
     */
    @Override // io.noties.markwon.html.TagHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(MarkwonVisitor visitor, MarkwonHtmlRenderer renderer, HtmlTag tag) {
        Object obj;
        CustomDataPlaceholderSpan customDataPlaceholderSpan;
        Integer num;
        CustomDataPlaceholderSpan customDataPlaceholderSpan2;
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(tag, "tag");
        String str = tag.attributes().get("type");
        if (str == null) {
            return;
        }
        String str2 = tag.attributes().get(VALUE_ATTRIBUTE);
        String str3 = str2 == null ? "" : str2;
        String str4 = tag.attributes().get(VALUE_ID_ATTRIBUTE);
        String str5 = str4 == null ? "" : str4;
        String str6 = tag.attributes().get(EXTRA_ATTRIBUTE);
        Integer num2 = (Integer) visitor.renderProps().get(MarkwonExtKt.getPROP_MAX_CONTENT_WIDTH());
        if (num2 == null) {
            return;
        }
        int intValue = num2.intValue();
        Object obj2 = visitor.renderProps().get(MarkwonExtKt.getPROP_PAYLOAD());
        Map<String, ? extends Object> map = obj2 instanceof Map ? (Map) obj2 : null;
        CharSequence charSequence = (CharSequence) visitor.renderProps().get(MarkwonExtKt.getPROP_MD_REUSE_CHAR_SEQUENCE());
        List<ICustomDataHandler> list = this.handlerList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((ICustomDataHandler) obj).accept(str)) {
                        break;
                    }
                }
            }
            ICustomDataHandler iCustomDataHandler = (ICustomDataHandler) obj;
            if (iCustomDataHandler != null) {
                Spanned spanned = charSequence instanceof Spanned ? (Spanned) charSequence : null;
                if (spanned != null) {
                    CustomDataPlaceholderSpan[] customDataPlaceholderSpanArr = (CustomDataPlaceholderSpan[]) spanned.getSpans(tag.start(), tag.end(), CustomDataPlaceholderSpan.class);
                    if (customDataPlaceholderSpanArr != null) {
                        int length = customDataPlaceholderSpanArr.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                customDataPlaceholderSpan2 = null;
                                break;
                            }
                            customDataPlaceholderSpan2 = customDataPlaceholderSpanArr[i];
                            if (Intrinsics.areEqual(customDataPlaceholderSpan2.getDataType(), str) && Intrinsics.areEqual(customDataPlaceholderSpan2.getDataValue(), str3) && Intrinsics.areEqual(customDataPlaceholderSpan2.getDataValueId(), str5) && customDataPlaceholderSpan2.getStartIndex() == tag.start() && customDataPlaceholderSpan2.getEndIndex() == tag.end() && !customDataPlaceholderSpan2.getNeedRefresh() && Intrinsics.areEqual(customDataPlaceholderSpan2.getDataTag(), tag.name())) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (customDataPlaceholderSpan2 != null) {
                            customDataPlaceholderSpan2.updateConfig(intValue, map);
                            customDataPlaceholderSpan = customDataPlaceholderSpan2;
                        }
                    }
                    customDataPlaceholderSpan = null;
                }
                String name = tag.name();
                Intrinsics.checkNotNullExpressionValue(name, "tag.name()");
                customDataPlaceholderSpan = new CustomDataPlaceholderSpan(str, str3, str5, str6, name, tag.start(), tag.end(), intValue, iCustomDataHandler, map, Intrinsics.areEqual(tag.name(), IMarkdownWidgetHandlerKt.DATA_INLINE_NO_MARGIN_TAG) || Intrinsics.areEqual(str, ICustomDataHandlerKt.TYPE_FLOW_CREATION), false, AnimationConstant.PROP_BOTTOM, null);
                SpannableBuilder.setSpans(visitor.builder(), customDataPlaceholderSpan, tag.start(), tag.end());
                HashMap<String, Integer> hashMap = CoreProps.RENDER_NODE_INFO.get(visitor.renderProps());
                if (hashMap == null || (num = hashMap.get(str)) == null) {
                    num = 0;
                }
                int intValue2 = num.intValue() + 1;
                if (hashMap != null) {
                    hashMap.put(str, Integer.valueOf(intValue2));
                }
            }
        }
    }

    @Override // io.noties.markwon.html.TagHandler
    public CharSequence replaceTag(HtmlTag tag, HtmlEmptyTagReplacement emptyReplacement) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(emptyReplacement, "emptyReplacement");
        String str = tag.attributes().get(ALT_ATTRIBUTE);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            str = emptyReplacement.replace(tag);
        }
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            str = " ";
        }
        return str;
    }
}
