package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.content.res.Configuration;
import androidx.core.content.ContextCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import io.noties.markwon.Prop;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MarkwonExt.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a)\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0012\u001a\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015\u001aA\u0010\u0016\u001a\u00020\u0017*\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n¢\u0006\u0002\u0010\u001f\u001aA\u0010 \u001a\u00020\u0017*\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n¢\u0006\u0002\u0010\u001f\"\u001f\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00070\u00070\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0005\"/\u0010\t\u001a \u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003 \u0003*\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\n0\n0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0005¨\u0006!"}, d2 = {"PROP_MAX_CONTENT_WIDTH", "Lio/noties/markwon/Prop;", "", "kotlin.jvm.PlatformType", "getPROP_MAX_CONTENT_WIDTH", "()Lio/noties/markwon/Prop;", "PROP_MD_REUSE_CHAR_SEQUENCE", "", "getPROP_MD_REUSE_CHAR_SEQUENCE", "PROP_PAYLOAD", "", "getPROP_PAYLOAD", "getSpecifyModeColor", RemoteMessageConst.Notification.COLOR, "originContext", "Landroid/content/Context;", "specifyDarkMode", "", "(ILandroid/content/Context;Ljava/lang/Boolean;)I", "isLastCharacterChinese", "input", "", "createMarkwonStruct", "Lcom/larus/business/markdown/impl/markwon/MarkwonStruct;", "markdownConfigManager", "Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "maxContentWidth", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "payload", "", "(Landroid/content/Context;Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;Ljava/lang/Integer;Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;Ljava/util/Map;)Lcom/larus/business/markdown/impl/markwon/MarkwonStruct;", "createStreamMarkwonStruct", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkwonExtKt {
    private static final Prop<Integer> PROP_MAX_CONTENT_WIDTH;
    private static final Prop<CharSequence> PROP_MD_REUSE_CHAR_SEQUENCE;
    private static final Prop<Map<?, ?>> PROP_PAYLOAD;

    static {
        Prop<Integer> m2587of = Prop.m2587of(Integer.TYPE, "max_content_width");
        Intrinsics.checkNotNullExpressionValue(m2587of, "of(Int::class.java, \"max_content_width\")");
        PROP_MAX_CONTENT_WIDTH = m2587of;
        Prop<CharSequence> m2587of2 = Prop.m2587of(CharSequence.class, "md-reuse-char-sequence");
        Intrinsics.checkNotNullExpressionValue(m2587of2, "of(CharSequence::class.j…\"md-reuse-char-sequence\")");
        PROP_MD_REUSE_CHAR_SEQUENCE = m2587of2;
        Prop<Map<?, ?>> m2587of3 = Prop.m2587of(Map.class, "md-payload");
        Intrinsics.checkNotNullExpressionValue(m2587of3, "of(Map::class.java, \"md-payload\")");
        PROP_PAYLOAD = m2587of3;
    }

    public static final Prop<Integer> getPROP_MAX_CONTENT_WIDTH() {
        return PROP_MAX_CONTENT_WIDTH;
    }

    public static final Prop<CharSequence> getPROP_MD_REUSE_CHAR_SEQUENCE() {
        return PROP_MD_REUSE_CHAR_SEQUENCE;
    }

    public static final Prop<Map<?, ?>> getPROP_PAYLOAD() {
        return PROP_PAYLOAD;
    }

    private static final int getSpecifyModeColor(int i, Context context, Boolean bool) {
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            configuration.uiMode = (configuration.uiMode & (-49)) | (booleanValue ? 32 : 16);
            if (booleanValue != ((context.getResources().getConfiguration().uiMode & 48) == 32)) {
                context = context.createConfigurationContext(configuration);
            }
            return ContextCompat.getColor(context, i);
        }
        return ContextCompat.getColor(context, i);
    }

    public static /* synthetic */ MarkwonStruct createMarkwonStruct$default(Context context, MarkdownConfigManager markdownConfigManager, Integer num, CustomMarkDownInfo customMarkDownInfo, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return createMarkwonStruct(context, markdownConfigManager, num, customMarkDownInfo, map);
    }

    public static final MarkwonStruct createMarkwonStruct(Context context, MarkdownConfigManager markdownConfigManager, Integer num, CustomMarkDownInfo customMarkDownInfo, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(markdownConfigManager, "markdownConfigManager");
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        return new MarkwonStruct(context, markdownConfigManager, false, customMarkDownInfo, num, map);
    }

    public static /* synthetic */ MarkwonStruct createStreamMarkwonStruct$default(Context context, MarkdownConfigManager markdownConfigManager, Integer num, CustomMarkDownInfo customMarkDownInfo, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return createStreamMarkwonStruct(context, markdownConfigManager, num, customMarkDownInfo, map);
    }

    public static final MarkwonStruct createStreamMarkwonStruct(Context context, MarkdownConfigManager markdownConfigManager, Integer num, CustomMarkDownInfo customMarkDownInfo, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(markdownConfigManager, "markdownConfigManager");
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        return new MarkwonStruct(context, markdownConfigManager, true, customMarkDownInfo, num, map);
    }

    public static final boolean isLastCharacterChinese(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        String str2 = str;
        if (str2.length() == 0) {
            return false;
        }
        char last = StringsKt.last(str2);
        if (19968 <= last && last < 40960) {
            return true;
        }
        if (13312 <= last && last < 19904) {
            return true;
        }
        return 0 <= last && last < 42720;
    }
}
