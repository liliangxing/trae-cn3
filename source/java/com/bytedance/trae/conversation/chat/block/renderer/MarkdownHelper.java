package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefRenderer;
import com.bytedance.trae.multilanguage.R;
import com.larus.business.markdown.api.MarkdownService;
import com.larus.business.markdown.api.customlink.ICustomLinkHandler;
import com.larus.business.markdown.api.model.BgListItemConfig;
import com.larus.business.markdown.api.model.BlockQuoteConfig;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.CodeCopySpanClickListener;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import com.larus.business.markdown.api.model.ICodeCopyInfoSpan;
import com.larus.business.markdown.api.model.ListConfig;
import com.larus.business.markdown.api.model.ListStyle;
import com.larus.business.markdown.api.model.ListSymbolStrategy;
import com.larus.business.markdown.api.model.MarkdownContent;
import com.larus.business.markdown.api.model.OrderedSymbol;
import com.larus.business.markdown.api.model.PhoneNumberConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import com.larus.business.markdown.api.model.TitleStyle;
import com.larus.business.markdown.api.model.UnorderedSymbol;
import com.larus.business.markdown.api.model.latex.LatexSingleConfig;
import io.noties.markwon.core.spans.ListMarginInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkdownHelper.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ,\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ.\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;", "", "<init>", "()V", "setMarkdownContentWithRef", "", "view", "Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;", "text", "", "finished", "", "listBulletStyle", "Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;", "setMarkdownContent", "createMarkdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "ListBulletStyle", "DiscListSymbolStrategy", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MarkdownHelper {
    public static final MarkdownHelper INSTANCE = new MarkdownHelper();

    /* compiled from: MarkdownHelper.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ListBulletStyle.values().length];
            try {
                iArr[ListBulletStyle.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ListBulletStyle.TEXT_COLOR_DISC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MarkdownHelper() {
    }

    public static /* synthetic */ void setMarkdownContentWithRef$default(MarkdownHelper markdownHelper, SimpleMarkdownTextView simpleMarkdownTextView, String str, boolean z, ListBulletStyle listBulletStyle, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            listBulletStyle = ListBulletStyle.DEFAULT;
        }
        markdownHelper.setMarkdownContentWithRef(simpleMarkdownTextView, str, z, listBulletStyle);
    }

    public final void setMarkdownContentWithRef(SimpleMarkdownTextView view, String text, boolean finished, ListBulletStyle listBulletStyle) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(listBulletStyle, "listBulletStyle");
        if (view == null) {
            return;
        }
        TraeRefRenderer.StripResult stripBeforeMarkdown = TraeRefRenderer.INSTANCE.stripBeforeMarkdown(text);
        String safeText = stripBeforeMarkdown.getSafeText();
        view.setRefStripResult(stripBeforeMarkdown);
        view.setMarkdown(createMarkdownContent(view, safeText, finished, listBulletStyle));
    }

    public static /* synthetic */ void setMarkdownContent$default(MarkdownHelper markdownHelper, SimpleMarkdownTextView simpleMarkdownTextView, String str, boolean z, ListBulletStyle listBulletStyle, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            listBulletStyle = ListBulletStyle.DEFAULT;
        }
        markdownHelper.setMarkdownContent(simpleMarkdownTextView, str, z, listBulletStyle);
    }

    public final void setMarkdownContent(SimpleMarkdownTextView view, String text, boolean finished, ListBulletStyle listBulletStyle) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(listBulletStyle, "listBulletStyle");
        if (view == null) {
            return;
        }
        TraeRefRenderer.StripResult stripBeforeMarkdown = TraeRefRenderer.INSTANCE.stripBeforeMarkdown(text);
        String safeText = stripBeforeMarkdown.getSafeText();
        view.setRefStripResult(stripBeforeMarkdown);
        view.setMarkdown(createMarkdownContent(view, safeText, finished, listBulletStyle));
    }

    public static /* synthetic */ MarkdownContent createMarkdownContent$default(MarkdownHelper markdownHelper, SimpleMarkdownTextView simpleMarkdownTextView, String str, boolean z, ListBulletStyle listBulletStyle, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            listBulletStyle = ListBulletStyle.DEFAULT;
        }
        return markdownHelper.createMarkdownContent(simpleMarkdownTextView, str, z, listBulletStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final MarkdownContent createMarkdownContent(SimpleMarkdownTextView view, String text, boolean finished, ListBulletStyle listBulletStyle) {
        int i;
        ListConfig listConfig;
        int i2;
        MarkdownContent markdownContent;
        ListStyle listStyle;
        MarkdownContent markdownContent2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(listBulletStyle, "listBulletStyle");
        if (view == 0) {
            return null;
        }
        Context context = view.getContext();
        float f = context.getResources().getDisplayMetrics().density;
        int i3 = (int) (16 * f);
        int i4 = context.getResources().getDisplayMetrics().widthPixels - (i3 * 2);
        view.setMarkdownWidth(i4);
        int i5 = (int) (1 * f);
        float f2 = 2 * f;
        int i6 = (int) f2;
        float f3 = 4 * f;
        int i7 = (int) (8 * f);
        float f4 = 15 * f;
        int color = ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1);
        int i8 = WhenMappings.$EnumSwitchMapping$0[listBulletStyle.ordinal()];
        if (i8 == 1) {
            i = 1;
            listConfig = null;
        } else {
            if (i8 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = 1;
            listConfig = new ListConfig((Integer) null, Integer.valueOf(ContextCompat.getColor(context, C0591R.color.trae_text_text_default)), 1, (DefaultConstructorMarker) null);
        }
        int i9 = WhenMappings.$EnumSwitchMapping$0[listBulletStyle.ordinal()];
        if (i9 == i) {
            i2 = i3;
            markdownContent = null;
            listStyle = null;
        } else {
            if (i9 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = i3;
            markdownContent = null;
            listStyle = new ListStyle(DiscListSymbolStrategy.INSTANCE, false, 2, (DefaultConstructorMarker) null);
        }
        view.setInlineCodeStyle(color, f3, 0.0f, f2);
        MarkdownHelper$createMarkdownContent$inlineCodePlugin$1 markdownHelper$createMarkdownContent$inlineCodePlugin$1 = new MarkdownHelper$createMarkdownContent$inlineCodePlugin$1();
        MarkdownService service = MarkdownService.Companion.getService();
        if (service != null) {
            ThematicBreakConfig thematicBreakConfig = new ThematicBreakConfig(Integer.valueOf((int) (f * 0.5d)), Integer.valueOf(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l2)));
            markdownContent2 = MarkdownService.DefaultImpls.createMarkdownContent$default(service, view, text, finished, new CustomMarkDownInfo(0, (Integer) null, (List) null, (String) null, false, false, (Integer) null, 0, 0, (Float) null, 0.0f, Float.valueOf(1.6f), 0, 0, (BgListItemConfig) null, Integer.valueOf(i7), Integer.valueOf(i6), (Function1) null, (Function1) null, new BlockQuoteConfig(true, Integer.valueOf(i6), Integer.valueOf(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l2)), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary)), Integer.valueOf(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary)), Integer.valueOf(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary))), thematicBreakConfig, new CodeBlockConfig(Integer.valueOf(i7), Integer.valueOf(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1)), true, Integer.valueOf(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1)), 0, (Integer) null, false, (String) null, false, true, TitleStyle.LARGE, true, Integer.valueOf(color), Integer.valueOf(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1)), (Integer) null, (Integer) null, false, false, (Integer) null, false, (Integer) null, (Integer) null, (Integer) null, false, (Boolean) null, false, false, 134201776, (DefaultConstructorMarker) null), new TableConfig(false, 0, Float.valueOf(f4), Integer.valueOf(i5), Integer.valueOf(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1)), (Integer) null, Integer.valueOf(i7), Integer.valueOf(i7), Integer.valueOf(i4), (Integer) null, Integer.valueOf(i2), Integer.valueOf(i7), (String) null, (Integer) null, false, false, false, false, (TitleStyle) null, 0, Integer.valueOf(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1)), 520739, (DefaultConstructorMarker) null), (PhoneNumberConfig) null, (ListMarginInfo) null, CollectionsKt.listOf(markdownHelper$createMarkdownContent$inlineCodePlugin$1), listConfig, (Integer) null, listStyle, (Boolean) null, true, (Boolean) null, (LatexSingleConfig) null, false, (Map) null, (ICustomLinkHandler) null, false, -1450805249, 31, (DefaultConstructorMarker) null), (Map) null, 16, (Object) null);
        } else {
            markdownContent2 = markdownContent;
        }
        if (markdownContent2 != null) {
            markdownContent2.setCodeCopySpanClickListener((View) view, new CodeCopySpanClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper$createMarkdownContent$1
                public void onClick(MarkdownContent markdownContent3, View view2, ICodeCopyInfoSpan span) {
                    Intrinsics.checkNotNullParameter(markdownContent3, "markdownContent");
                    Intrinsics.checkNotNullParameter(view2, "view");
                    Intrinsics.checkNotNullParameter(span, "span");
                    Context context2 = view2.getContext();
                    if (context2 == null) {
                        return;
                    }
                    Object systemService = context2.getSystemService("clipboard");
                    ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
                    if (clipboardManager == null) {
                        return;
                    }
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("code", span.getCode()));
                    Toast.makeText(context2, R.string.trae_conversation_copied, 0).show();
                }
            });
        }
        return markdownContent2;
    }

    /* compiled from: MarkdownHelper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "TEXT_COLOR_DISC", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ListBulletStyle extends Enum<ListBulletStyle> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ListBulletStyle[] $VALUES;
        public static final ListBulletStyle DEFAULT = new ListBulletStyle("DEFAULT", 0);
        public static final ListBulletStyle TEXT_COLOR_DISC = new ListBulletStyle("TEXT_COLOR_DISC", 1);

        private static final /* synthetic */ ListBulletStyle[] $values() {
            return new ListBulletStyle[]{DEFAULT, TEXT_COLOR_DISC};
        }

        public static EnumEntries<ListBulletStyle> getEntries() {
            return $ENTRIES;
        }

        private ListBulletStyle(String str, int i) {
            super(str, i);
        }

        static {
            ListBulletStyle[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ListBulletStyle valueOf(String str) {
            return (ListBulletStyle) Enum.valueOf(ListBulletStyle.class, str);
        }

        public static ListBulletStyle[] values() {
            return (ListBulletStyle[]) $VALUES.clone();
        }
    }

    /* compiled from: MarkdownHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$DiscListSymbolStrategy;", "Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "<init>", "()V", "unorderedSymbol", "Lcom/larus/business/markdown/api/model/UnorderedSymbol;", "level", "", "orderedSymbol", "Lcom/larus/business/markdown/api/model/OrderedSymbol;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DiscListSymbolStrategy implements ListSymbolStrategy {
        public static final DiscListSymbolStrategy INSTANCE = new DiscListSymbolStrategy();

        private DiscListSymbolStrategy() {
        }

        public UnorderedSymbol unorderedSymbol(int level) {
            return UnorderedSymbol.DISC;
        }

        public OrderedSymbol orderedSymbol(int level) {
            return OrderedSymbol.DECIMAL;
        }
    }
}
