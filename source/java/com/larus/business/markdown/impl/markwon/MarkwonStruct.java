package com.larus.business.markdown.impl.markwon;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.business.markdown.api.common.FlowMarkdownReuseDrawablePool;
import com.larus.business.markdown.api.common.ReuseDrawablePoolNew;
import com.larus.business.markdown.api.depend.ICustomDataHandler;
import com.larus.business.markdown.api.depend.LinkResolverWithStyle;
import com.larus.business.markdown.api.extplugin.code.ICustomCodeHandler;
import com.larus.business.markdown.api.extplugin.html.HtmlCssStyle;
import com.larus.business.markdown.api.extplugin.image.IImagePlugin;
import com.larus.business.markdown.api.extplugin.image.IImagePluginKt;
import com.larus.business.markdown.api.extplugin.latex.ILatexPlugin;
import com.larus.business.markdown.api.extplugin.latex.ILatexPluginKt;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import com.larus.business.markdown.api.model.IMarkwonStruct;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.latex.LatexGlobalConfig;
import com.larus.business.markdown.api.model.latex.LatexSingleConfig;
import com.larus.business.markdown.impl.C1327R;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import com.larus.business.markdown.impl.common.PluginManager;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.business.markdown.impl.common.utils.MarkdownSettings;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.ReplacementCodePlugin;
import com.larus.business.markdown.impl.markwon.phone.PhoneNumberLinkPlugin;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.Markwon;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.core.CorePlugin2;
import io.noties.markwon.ext.drawable.ReuseAsyncDrawablePlugin;
import io.noties.markwon.ext.strikethrough.StrikethroughPlugin;
import io.noties.markwon.ext.tables.TableOptions;
import io.noties.markwon.ext.tables.TablePlugin2;
import io.noties.markwon.ext.tables.TableTheme;
import io.noties.markwon.ext.tables.TableTheme2;
import io.noties.markwon.ext.tasklist.TaskListPlugin;
import io.noties.markwon.html.CustomHtmlPlugin;
import io.noties.markwon.html.HtmlPlugin;
import io.noties.markwon.html.MarkwonSettings;
import io.noties.markwon.html.TagHandler;
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;
import io.noties.markwon.maybe.MaybePlugin;
import io.noties.markwon.scrollable.ScrollBarTheme;
import io.noties.markwon.syntax.GrammarLocatorDef;
import io.noties.markwon.syntax.Prism4jThemeDefault;
import io.noties.markwon.syntax.SyntaxHighlightPlugin;
import io.noties.prism4j.Prism4j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* compiled from: MarkwonExt.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010!R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010%\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020(\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0018\u001a\u0004\b)\u0010*R\u001d\u0010,\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0018\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0018\u001a\u0004\b3\u00104R\u0014\u00106\u001a\u000207X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/MarkwonStruct;", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "context", "Landroid/content/Context;", "markdownConfigManager", "Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "loading", "", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "maxContentWidth", "", "payload", "", "", "", "(Landroid/content/Context;Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;ZLcom/larus/business/markdown/api/model/CustomMarkDownInfo;Ljava/lang/Integer;Ljava/util/Map;)V", "getCustomMarkDownInfo", "()Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "drawableLruPool", "Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "getDrawableLruPool", "()Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "drawableLruPool$delegate", "Lkotlin/Lazy;", "drawablePool", "Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "getDrawablePool", "()Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "drawablePool$delegate", "imageSize", "Landroid/graphics/Rect;", "getImageSize", "()Landroid/graphics/Rect;", "imageSize$delegate", "getLoading", "()Z", "markdownLinkResolver", "Lkotlin/Function3;", "Landroid/view/View;", "", "getMarkdownLinkResolver", "()Lkotlin/jvm/functions/Function3;", "markdownLinkResolver$delegate", "markdownLinkResolverV2", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "getMarkdownLinkResolverV2", "()Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "markdownLinkResolverV2$delegate", "markdownSettings", "Lcom/larus/business/markdown/impl/common/utils/MarkdownSettings;", "getMarkdownSettings", "()Lcom/larus/business/markdown/impl/common/utils/MarkdownSettings;", "markdownSettings$delegate", "markwon", "Lio/noties/markwon/Markwon;", "getMarkwon", "()Lio/noties/markwon/Markwon;", "getMaxContentWidth", "()Ljava/lang/Integer;", "setMaxContentWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPayload", "()Ljava/util/Map;", "setPayload", "(Ljava/util/Map;)V", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkwonStruct implements IMarkwonStruct {
    private final Context context;
    private final CustomMarkDownInfo customMarkDownInfo;

    /* renamed from: drawableLruPool$delegate, reason: from kotlin metadata */
    private final Lazy drawableLruPool;

    /* renamed from: drawablePool$delegate, reason: from kotlin metadata */
    private final Lazy drawablePool;

    /* renamed from: imageSize$delegate, reason: from kotlin metadata */
    private final Lazy imageSize;
    private final boolean loading;
    private final MarkdownConfigManager markdownConfigManager;

    /* renamed from: markdownLinkResolver$delegate, reason: from kotlin metadata */
    private final Lazy markdownLinkResolver;

    /* renamed from: markdownLinkResolverV2$delegate, reason: from kotlin metadata */
    private final Lazy markdownLinkResolverV2;

    /* renamed from: markdownSettings$delegate, reason: from kotlin metadata */
    private final Lazy markdownSettings;
    private final Markwon markwon;
    private Integer maxContentWidth;
    private Map<String, ? extends Object> payload;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03fb A[LOOP:0: B:89:0x03f5->B:91:0x03fb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0423  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MarkwonStruct(Context context, MarkdownConfigManager markdownConfigManager, boolean z, CustomMarkDownInfo customMarkDownInfo, Integer num, Map<String, ? extends Object> map) {
        Integer maxContentWidth;
        float dp_16;
        Markwon.Builder usePlugin;
        ILatexPlugin latexPluginDelegate;
        DefaultConstructorMarker defaultConstructorMarker;
        int i;
        Boolean darkMode;
        boolean z2;
        Iterator<T> it;
        CodeBlockConfig codeBlockConfig;
        List<AbstractMarkwonPlugin> customListPlugin;
        Integer tableTextColor;
        Integer topRoundCornerRadius;
        Integer bottomRoundCornerRadius;
        Integer cellHorizontalPadding;
        Integer cellVerticalPadding;
        Integer cellMaxWidth;
        Integer tableBorderWidth;
        Integer tableHeaderRowBackgroundColor;
        Integer tableOddRowBackgroundColor;
        Integer tableBorderColor;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(markdownConfigManager, "markdownConfigManager");
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        this.context = context;
        this.markdownConfigManager = markdownConfigManager;
        this.loading = z;
        this.customMarkDownInfo = customMarkDownInfo;
        this.maxContentWidth = num;
        this.payload = map;
        this.markdownSettings = LazyKt.lazy(new Function0<MarkdownSettings>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markdownSettings$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MarkdownSettings m2884invoke() {
                MarkdownConfigManager markdownConfigManager2;
                markdownConfigManager2 = MarkwonStruct.this.markdownConfigManager;
                return markdownConfigManager2.getSettings();
            }
        });
        this.drawablePool = LazyKt.lazy(new Function0<ReuseDrawablePoolNew>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$drawablePool$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ReuseDrawablePoolNew m2880invoke() {
                MarkdownConfigManager markdownConfigManager2;
                markdownConfigManager2 = MarkwonStruct.this.markdownConfigManager;
                return markdownConfigManager2.getDrawablePool();
            }
        });
        this.drawableLruPool = LazyKt.lazy(new Function0<FlowMarkdownReuseDrawablePool>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$drawableLruPool$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final FlowMarkdownReuseDrawablePool m2879invoke() {
                MarkdownConfigManager markdownConfigManager2;
                markdownConfigManager2 = MarkwonStruct.this.markdownConfigManager;
                return markdownConfigManager2.getDrawableLruPool();
            }
        });
        this.imageSize = LazyKt.lazy(new Function0<Rect>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$imageSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Rect m2881invoke() {
                MarkdownConfigManager markdownConfigManager2;
                markdownConfigManager2 = MarkwonStruct.this.markdownConfigManager;
                return markdownConfigManager2.getImageSize();
            }
        });
        this.markdownLinkResolver = LazyKt.lazy(new Function0<Function3<? super View, ? super String, ? super Boolean, ? extends Unit>>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markdownLinkResolver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Function3<View, String, Boolean, Unit> invoke() {
                MarkdownConfigManager markdownConfigManager2;
                markdownConfigManager2 = MarkwonStruct.this.markdownConfigManager;
                return markdownConfigManager2.getMarkdownLinkResolver();
            }
        });
        this.markdownLinkResolverV2 = LazyKt.lazy(new Function0<LinkResolverWithStyle>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markdownLinkResolverV2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final LinkResolverWithStyle m2883invoke() {
                MarkdownConfigManager markdownConfigManager2;
                markdownConfigManager2 = MarkwonStruct.this.markdownConfigManager;
                return markdownConfigManager2.getMarkdownLinkResolverV2();
            }
        });
        Markwon.Builder usePlugin2 = Markwon.builderNoCore(context).injectParser(markdownConfigManager.getInjectMarkdownParser()).usePlugin(new AbstractMarkwonPlugin() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markwon$1
            @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
            public void afterRender(TextView textView, Node node, MarkwonVisitor visitor) {
                CharSequence text;
                Intrinsics.checkNotNullParameter(node, "node");
                Intrinsics.checkNotNullParameter(visitor, "visitor");
                RenderProps renderProps = visitor.renderProps();
                MarkwonStruct markwonStruct = MarkwonStruct.this;
                if (textView != null && (text = textView.getText()) != null) {
                    renderProps.set(MarkwonExtKt.getPROP_MD_REUSE_CHAR_SEQUENCE(), text);
                }
                Integer maxContentWidth2 = markwonStruct.getMaxContentWidth();
                if (maxContentWidth2 != null) {
                    renderProps.set(MarkwonExtKt.getPROP_MAX_CONTENT_WIDTH(), Integer.valueOf(maxContentWidth2.intValue()));
                }
                Map<String, Object> payload = markwonStruct.getPayload();
                if (payload != null) {
                    renderProps.set(MarkwonExtKt.getPROP_PAYLOAD(), payload);
                }
            }

            @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
            public void afterRender(CharSequence reuseCharSequence, Node node, MarkwonVisitor visitor) {
                Intrinsics.checkNotNullParameter(node, "node");
                Intrinsics.checkNotNullParameter(visitor, "visitor");
                RenderProps renderProps = visitor.renderProps();
                MarkwonStruct markwonStruct = MarkwonStruct.this;
                if (reuseCharSequence != null) {
                    renderProps.set(MarkwonExtKt.getPROP_MD_REUSE_CHAR_SEQUENCE(), reuseCharSequence);
                }
                Integer maxContentWidth2 = markwonStruct.getMaxContentWidth();
                if (maxContentWidth2 != null) {
                    renderProps.set(MarkwonExtKt.getPROP_MAX_CONTENT_WIDTH(), Integer.valueOf(maxContentWidth2.intValue()));
                }
                Map<String, Object> payload = markwonStruct.getPayload();
                if (payload != null) {
                    renderProps.set(MarkwonExtKt.getPROP_PAYLOAD(), payload);
                }
            }
        }).usePlugin(new CorePlugin2());
        IImagePlugin imagePluginDelegate = IImagePluginKt.getImagePluginDelegate();
        if (imagePluginDelegate != null) {
            usePlugin2.usePlugin((MarkwonPlugin) new ReuseAsyncDrawablePlugin(getDrawablePool(), getMarkdownSettings().clearDrawablePoolAfterRender()));
            usePlugin2.usePlugin(imagePluginDelegate.getPlugin(getCustomMarkDownInfo().getImgBgColor(), getCustomMarkDownInfo().getImgCornerRadius(), getMaxContentWidth(), getCustomMarkDownInfo().getMinImgWidthHeight(), getImageSize(), getMarkdownSettings().getCustomImgHandler(), getPayload()));
        }
        TableTheme.Builder builder = new TableTheme.Builder();
        TableConfig tableConfig = getCustomMarkDownInfo().getTableConfig();
        TableTheme.Builder tableBorderColor2 = builder.tableBorderColor((tableConfig == null || (tableBorderColor = tableConfig.getTableBorderColor()) == null) ? ContextCompat.getColor(context, C1327R.color.neutral_transparent_2) : tableBorderColor.intValue());
        TableConfig tableConfig2 = getCustomMarkDownInfo().getTableConfig();
        TableTheme.Builder tableOddRowBackgroundColor2 = tableBorderColor2.tableOddRowBackgroundColor((tableConfig2 == null || (tableOddRowBackgroundColor = tableConfig2.getTableOddRowBackgroundColor()) == null) ? ContextCompat.getColor(context, C1327R.color.neutral_transparent_2) : tableOddRowBackgroundColor.intValue());
        TableConfig tableConfig3 = getCustomMarkDownInfo().getTableConfig();
        TableTheme.Builder tableHeaderRowBackgroundColor2 = tableOddRowBackgroundColor2.tableHeaderRowBackgroundColor((tableConfig3 == null || (tableHeaderRowBackgroundColor = tableConfig3.getTableHeaderRowBackgroundColor()) == null) ? ContextCompat.getColor(context, R.color.transparent) : tableHeaderRowBackgroundColor.intValue());
        TableConfig tableConfig4 = getCustomMarkDownInfo().getTableConfig();
        TableTheme.Builder tableBorderWidth2 = tableHeaderRowBackgroundColor2.tableBorderWidth((tableConfig4 == null || (tableBorderWidth = tableConfig4.getTableBorderWidth()) == null) ? MarkdownDimensExtKt.getDp_1() : tableBorderWidth.intValue());
        TableConfig tableConfig5 = getCustomMarkDownInfo().getTableConfig();
        int intValue = ((tableConfig5 == null || (maxContentWidth = tableConfig5.getTableWidth()) == null) && (maxContentWidth = getMaxContentWidth()) == null) ? 0 : maxContentWidth.intValue();
        TableConfig tableConfig6 = getCustomMarkDownInfo().getTableConfig();
        int dp_180 = (tableConfig6 == null || (cellMaxWidth = tableConfig6.getCellMaxWidth()) == null) ? MarkdownDimensExtKt.getDp_180() : cellMaxWidth.intValue();
        TableConfig tableConfig7 = getCustomMarkDownInfo().getTableConfig();
        int dp_12 = (tableConfig7 == null || (cellVerticalPadding = tableConfig7.getCellVerticalPadding()) == null) ? MarkdownDimensExtKt.getDp_12() : cellVerticalPadding.intValue();
        TableConfig tableConfig8 = getCustomMarkDownInfo().getTableConfig();
        int dp_162 = (tableConfig8 == null || (cellHorizontalPadding = tableConfig8.getCellHorizontalPadding()) == null) ? MarkdownDimensExtKt.getDp_16() : cellHorizontalPadding.intValue();
        TableConfig tableConfig9 = getCustomMarkDownInfo().getTableConfig();
        float dp_4 = (tableConfig9 == null || (bottomRoundCornerRadius = tableConfig9.getBottomRoundCornerRadius()) == null) ? MarkdownDimensExtKt.getDp_4() : bottomRoundCornerRadius.intValue();
        TableConfig tableConfig10 = getCustomMarkDownInfo().getTableConfig();
        float dp_42 = (tableConfig10 == null || (topRoundCornerRadius = tableConfig10.getTopRoundCornerRadius()) == null) ? MarkdownDimensExtKt.getDp_4() : topRoundCornerRadius.intValue();
        TableConfig tableConfig11 = getCustomMarkDownInfo().getTableConfig();
        if (tableConfig11 != null && (r2 = tableConfig11.getTableTextSize()) != null) {
            Float tableTextSize = (tableTextSize.floatValue() > ((float) 0) ? 1 : (tableTextSize.floatValue() == ((float) 0) ? 0 : -1)) > 0 ? tableTextSize : null;
            if (tableTextSize != null) {
                dp_16 = tableTextSize.floatValue();
                float f = dp_16;
                TableConfig tableConfig12 = getCustomMarkDownInfo().getTableConfig();
                int color = (tableConfig12 != null || (tableTextColor = tableConfig12.getTableTextColor()) == null) ? ContextCompat.getColor(context, C1327R.color.neutral_100) : tableTextColor.intValue();
                TableForegroundProvider tableForegroundProvider = new TableForegroundProvider();
                TableConfig tableConfig13 = getCustomMarkDownInfo().getTableConfig();
                boolean enableTableWidthMatchParent = tableConfig13 == null ? tableConfig13.getEnableTableWidthMatchParent() : false;
                Intrinsics.checkNotNullExpressionValue(tableBorderWidth2, "tableBorderWidth(customM….tableBorderWidth?: dp_1)");
                TableTheme2 tableTheme2 = new TableTheme2(tableBorderWidth2, intValue, 0, dp_180, dp_12, dp_162, 0, f, 0.0f, dp_4, dp_42, color, enableTableWidthMatchParent, tableForegroundProvider, 1, 320, (DefaultConstructorMarker) null);
                ScrollBarTheme scrollBarTheme = new ScrollBarTheme(MarkdownDimensExtKt.getDp_120(), MarkdownDimensExtKt.getDp_4(), 0.0f, ContextCompat.getColor(context, C1327R.color.neutral_50));
                TableConfig tableConfig14 = getCustomMarkDownInfo().getTableConfig();
                Markwon.Builder usePlugin3 = usePlugin2.usePlugin((MarkwonPlugin) new TablePlugin2(tableTheme2, scrollBarTheme, new TableOptions(tableConfig14 == null ? tableConfig14.getCopyExcelStyle() : false)));
                PluginManager pluginManager = PluginManager.INSTANCE;
                Boolean allowParentInterceptTouchWhenOverScroll = getCustomMarkDownInfo().getAllowParentInterceptTouchWhenOverScroll();
                usePlugin = usePlugin3.usePlugin((MarkwonPlugin) pluginManager.getMovementMethodPluginInstance(context, allowParentInterceptTouchWhenOverScroll == null ? allowParentInterceptTouchWhenOverScroll.booleanValue() : false)).usePlugin(new IgnoreMentionLinkifyPlugin(getMarkdownSettings().getAutoLinkMaxLimit(), getCustomMarkDownInfo().getLinkHandler(), ContextCompat.getColor(context, C1327R.color.primary_50), getMarkdownSettings().getPrintLog())).usePlugin(new PhoneNumberLinkPlugin(getCustomMarkDownInfo().getPhoneNumberConfig(), new Function0<Boolean>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markwon$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Boolean m2887invoke() {
                        return Boolean.valueOf(MarkwonStruct.this.getLoading());
                    }
                })).usePlugin(MarkwonInlineParserPlugin.create());
                if (getMarkdownSettings().latexGlobalConfig().isDisableLatex() || (latexPluginDelegate = ILatexPluginKt.getLatexPluginDelegate()) == null) {
                    defaultConstructorMarker = null;
                    i = 0;
                } else {
                    LatexGlobalConfig latexGlobalConfig = getMarkdownSettings().latexGlobalConfig();
                    LatexSingleConfig latexSingleConfig = getCustomMarkDownInfo().getLatexSingleConfig();
                    Integer maxContentWidth2 = getMaxContentWidth();
                    defaultConstructorMarker = null;
                    i = 0;
                    usePlugin.usePlugin(latexPluginDelegate.getPlugin(context, latexGlobalConfig, latexSingleConfig, maxContentWidth2 == null ? maxContentWidth2.intValue() : 0, getDrawablePool(), getDrawableLruPool(), getMarkdownSettings().clearDrawablePoolAfterRender()));
                }
                MarkwonSettings.INSTANCE.setEnableHtmlNameEntityOptimize(getMarkdownSettings().enableHtmlNameEntityOptimize());
                CustomHtmlPlugin.Companion companion = CustomHtmlPlugin.INSTANCE;
                List<ICustomDataHandler> customDataHandlers = getMarkdownSettings().getCustomDataHandlers();
                Map<String, HtmlCssStyle> htmlStyleClass = getMarkdownSettings().getHtmlStyleClass();
                htmlStyleClass = htmlStyleClass == null ? MapsKt.emptyMap() : htmlStyleClass;
                darkMode = getCustomMarkDownInfo().getDarkMode();
                if (darkMode != null) {
                    z2 = darkMode.booleanValue();
                } else {
                    z2 = (context.getResources().getConfiguration().uiMode & 48) == 32 ? true : i;
                }
                HtmlPlugin create = companion.create(customDataHandlers, htmlStyleClass, z2, getMarkdownSettings().getPrintLog());
                create.allowNonClosedTags(getCustomMarkDownInfo().getAllowNonClosedTags());
                it = getCustomMarkDownInfo().getHtmlTagHandlerList().iterator();
                while (it.hasNext()) {
                    create.addHandler((TagHandler) it.next());
                }
                Unit unit = Unit.INSTANCE;
                Markwon.Builder usePlugin4 = usePlugin.usePlugin(create);
                codeBlockConfig = getCustomMarkDownInfo().getCodeBlockConfig();
                if (((codeBlockConfig != null || codeBlockConfig.getEnableSyntaxHighlight()) ? i : 1) == 0) {
                    usePlugin4.usePlugin((MarkwonPlugin) SyntaxHighlightPlugin.create(new Prism4j(new GrammarLocatorDef()), Prism4jThemeDefault.create(i), "c"));
                }
                Markwon.Builder usePlugin5 = usePlugin4.usePlugin((MarkwonPlugin) StrikethroughPlugin.create()).usePlugin((MarkwonPlugin) TaskListPlugin.create(ContextCompat.getColor(this.context, C1327R.color.primary_50), ContextCompat.getColor(this.context, C1327R.color.primary_50), ContextCompat.getColor(this.context, C1327R.color.flow_static_white)));
                if (getLoading()) {
                    usePlugin5.usePlugin((MarkwonPlugin) new MaybePlugin(i, i, 3, defaultConstructorMarker));
                }
                Markwon.Builder usePlugin6 = usePlugin5.usePlugin(new MarkwonStruct$markwon$10(this));
                customListPlugin = getCustomMarkDownInfo().getCustomListPlugin();
                if (customListPlugin != null) {
                    usePlugin6.usePlugins(customListPlugin);
                }
                if (getMarkdownSettings().enableNewCodeStyle()) {
                    CodeBlockConfig codeBlockConfig2 = getCustomMarkDownInfo().getCodeBlockConfig();
                    if ((codeBlockConfig2 != null ? Intrinsics.areEqual(codeBlockConfig2.getDisableReplacementSpan(), true) : i) == 0) {
                        CustomMarkDownInfo customMarkDownInfo2 = getCustomMarkDownInfo();
                        Context context2 = this.context;
                        Function0<Map<String, ? extends Object>> function0 = new Function0<Map<String, ? extends Object>>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markwon$11$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            public final Map<String, Object> invoke() {
                                return MarkwonStruct.this.getPayload();
                            }
                        };
                        ICustomCodeHandler customCodeHandler = getMarkdownSettings().getCustomCodeHandler();
                        Integer maxContentWidth3 = getMaxContentWidth();
                        usePlugin6.usePlugin(new ReplacementCodePlugin(customMarkDownInfo2, context2, function0, customCodeHandler, maxContentWidth3 != null ? maxContentWidth3.intValue() : i, new Function0<Boolean>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markwon$11$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Boolean m2886invoke() {
                                return Boolean.valueOf(!MarkwonStruct.this.getLoading());
                            }
                        }));
                    }
                }
                Markwon build = usePlugin6.build();
                Intrinsics.checkNotNullExpressionValue(build, "builderNoCore(context)\n …       }\n        .build()");
                this.markwon = build;
            }
        }
        dp_16 = MarkdownDimensExtKt.getDp_16();
        float f2 = dp_16;
        TableConfig tableConfig122 = getCustomMarkDownInfo().getTableConfig();
        int color2 = (tableConfig122 != null || (tableTextColor = tableConfig122.getTableTextColor()) == null) ? ContextCompat.getColor(context, C1327R.color.neutral_100) : tableTextColor.intValue();
        TableForegroundProvider tableForegroundProvider2 = new TableForegroundProvider();
        TableConfig tableConfig132 = getCustomMarkDownInfo().getTableConfig();
        if (tableConfig132 == null) {
        }
        Intrinsics.checkNotNullExpressionValue(tableBorderWidth2, "tableBorderWidth(customM….tableBorderWidth?: dp_1)");
        TableTheme2 tableTheme22 = new TableTheme2(tableBorderWidth2, intValue, 0, dp_180, dp_12, dp_162, 0, f2, 0.0f, dp_4, dp_42, color2, enableTableWidthMatchParent, tableForegroundProvider2, 1, 320, (DefaultConstructorMarker) null);
        ScrollBarTheme scrollBarTheme2 = new ScrollBarTheme(MarkdownDimensExtKt.getDp_120(), MarkdownDimensExtKt.getDp_4(), 0.0f, ContextCompat.getColor(context, C1327R.color.neutral_50));
        TableConfig tableConfig142 = getCustomMarkDownInfo().getTableConfig();
        Markwon.Builder usePlugin32 = usePlugin2.usePlugin((MarkwonPlugin) new TablePlugin2(tableTheme22, scrollBarTheme2, new TableOptions(tableConfig142 == null ? tableConfig142.getCopyExcelStyle() : false)));
        PluginManager pluginManager2 = PluginManager.INSTANCE;
        Boolean allowParentInterceptTouchWhenOverScroll2 = getCustomMarkDownInfo().getAllowParentInterceptTouchWhenOverScroll();
        usePlugin = usePlugin32.usePlugin((MarkwonPlugin) pluginManager2.getMovementMethodPluginInstance(context, allowParentInterceptTouchWhenOverScroll2 == null ? allowParentInterceptTouchWhenOverScroll2.booleanValue() : false)).usePlugin(new IgnoreMentionLinkifyPlugin(getMarkdownSettings().getAutoLinkMaxLimit(), getCustomMarkDownInfo().getLinkHandler(), ContextCompat.getColor(context, C1327R.color.primary_50), getMarkdownSettings().getPrintLog())).usePlugin(new PhoneNumberLinkPlugin(getCustomMarkDownInfo().getPhoneNumberConfig(), new Function0<Boolean>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonStruct$markwon$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m2887invoke() {
                return Boolean.valueOf(MarkwonStruct.this.getLoading());
            }
        })).usePlugin(MarkwonInlineParserPlugin.create());
        if (getMarkdownSettings().latexGlobalConfig().isDisableLatex()) {
            LatexGlobalConfig latexGlobalConfig2 = getMarkdownSettings().latexGlobalConfig();
            LatexSingleConfig latexSingleConfig2 = getCustomMarkDownInfo().getLatexSingleConfig();
            Integer maxContentWidth22 = getMaxContentWidth();
            defaultConstructorMarker = null;
            i = 0;
            usePlugin.usePlugin(latexPluginDelegate.getPlugin(context, latexGlobalConfig2, latexSingleConfig2, maxContentWidth22 == null ? maxContentWidth22.intValue() : 0, getDrawablePool(), getDrawableLruPool(), getMarkdownSettings().clearDrawablePoolAfterRender()));
            MarkwonSettings.INSTANCE.setEnableHtmlNameEntityOptimize(getMarkdownSettings().enableHtmlNameEntityOptimize());
            CustomHtmlPlugin.Companion companion2 = CustomHtmlPlugin.INSTANCE;
            List<ICustomDataHandler> customDataHandlers2 = getMarkdownSettings().getCustomDataHandlers();
            Map<String, HtmlCssStyle> htmlStyleClass2 = getMarkdownSettings().getHtmlStyleClass();
            if (htmlStyleClass2 == null) {
            }
            darkMode = getCustomMarkDownInfo().getDarkMode();
            if (darkMode != null) {
            }
            HtmlPlugin create2 = companion2.create(customDataHandlers2, htmlStyleClass2, z2, getMarkdownSettings().getPrintLog());
            create2.allowNonClosedTags(getCustomMarkDownInfo().getAllowNonClosedTags());
            it = getCustomMarkDownInfo().getHtmlTagHandlerList().iterator();
            while (it.hasNext()) {
            }
            Unit unit2 = Unit.INSTANCE;
            Markwon.Builder usePlugin42 = usePlugin.usePlugin(create2);
            codeBlockConfig = getCustomMarkDownInfo().getCodeBlockConfig();
            if (((codeBlockConfig != null || codeBlockConfig.getEnableSyntaxHighlight()) ? i : 1) == 0) {
            }
            Markwon.Builder usePlugin52 = usePlugin42.usePlugin((MarkwonPlugin) StrikethroughPlugin.create()).usePlugin((MarkwonPlugin) TaskListPlugin.create(ContextCompat.getColor(this.context, C1327R.color.primary_50), ContextCompat.getColor(this.context, C1327R.color.primary_50), ContextCompat.getColor(this.context, C1327R.color.flow_static_white)));
            if (getLoading()) {
            }
            Markwon.Builder usePlugin62 = usePlugin52.usePlugin(new MarkwonStruct$markwon$10(this));
            customListPlugin = getCustomMarkDownInfo().getCustomListPlugin();
            if (customListPlugin != null) {
            }
            if (getMarkdownSettings().enableNewCodeStyle()) {
            }
            Markwon build2 = usePlugin62.build();
            Intrinsics.checkNotNullExpressionValue(build2, "builderNoCore(context)\n …       }\n        .build()");
            this.markwon = build2;
        }
        defaultConstructorMarker = null;
        i = 0;
        MarkwonSettings.INSTANCE.setEnableHtmlNameEntityOptimize(getMarkdownSettings().enableHtmlNameEntityOptimize());
        CustomHtmlPlugin.Companion companion22 = CustomHtmlPlugin.INSTANCE;
        List<ICustomDataHandler> customDataHandlers22 = getMarkdownSettings().getCustomDataHandlers();
        Map<String, HtmlCssStyle> htmlStyleClass22 = getMarkdownSettings().getHtmlStyleClass();
        if (htmlStyleClass22 == null) {
        }
        darkMode = getCustomMarkDownInfo().getDarkMode();
        if (darkMode != null) {
        }
        HtmlPlugin create22 = companion22.create(customDataHandlers22, htmlStyleClass22, z2, getMarkdownSettings().getPrintLog());
        create22.allowNonClosedTags(getCustomMarkDownInfo().getAllowNonClosedTags());
        it = getCustomMarkDownInfo().getHtmlTagHandlerList().iterator();
        while (it.hasNext()) {
        }
        Unit unit22 = Unit.INSTANCE;
        Markwon.Builder usePlugin422 = usePlugin.usePlugin(create22);
        codeBlockConfig = getCustomMarkDownInfo().getCodeBlockConfig();
        if (((codeBlockConfig != null || codeBlockConfig.getEnableSyntaxHighlight()) ? i : 1) == 0) {
        }
        Markwon.Builder usePlugin522 = usePlugin422.usePlugin((MarkwonPlugin) StrikethroughPlugin.create()).usePlugin((MarkwonPlugin) TaskListPlugin.create(ContextCompat.getColor(this.context, C1327R.color.primary_50), ContextCompat.getColor(this.context, C1327R.color.primary_50), ContextCompat.getColor(this.context, C1327R.color.flow_static_white)));
        if (getLoading()) {
        }
        Markwon.Builder usePlugin622 = usePlugin522.usePlugin(new MarkwonStruct$markwon$10(this));
        customListPlugin = getCustomMarkDownInfo().getCustomListPlugin();
        if (customListPlugin != null) {
        }
        if (getMarkdownSettings().enableNewCodeStyle()) {
        }
        Markwon build22 = usePlugin622.build();
        Intrinsics.checkNotNullExpressionValue(build22, "builderNoCore(context)\n …       }\n        .build()");
        this.markwon = build22;
    }

    @Override // com.larus.business.markdown.api.model.IMarkwonStruct
    public boolean getLoading() {
        return this.loading;
    }

    @Override // com.larus.business.markdown.api.model.IMarkwonStruct
    public CustomMarkDownInfo getCustomMarkDownInfo() {
        return this.customMarkDownInfo;
    }

    @Override // com.larus.business.markdown.api.model.IMarkwonStruct
    public Integer getMaxContentWidth() {
        return this.maxContentWidth;
    }

    @Override // com.larus.business.markdown.api.model.IMarkwonStruct
    public void setMaxContentWidth(Integer num) {
        this.maxContentWidth = num;
    }

    @Override // com.larus.business.markdown.api.model.IMarkwonStruct
    public Map<String, Object> getPayload() {
        return this.payload;
    }

    @Override // com.larus.business.markdown.api.model.IMarkwonStruct
    public void setPayload(Map<String, ? extends Object> map) {
        this.payload = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MarkdownSettings getMarkdownSettings() {
        return (MarkdownSettings) this.markdownSettings.getValue();
    }

    private final ReuseDrawablePoolNew getDrawablePool() {
        return (ReuseDrawablePoolNew) this.drawablePool.getValue();
    }

    private final FlowMarkdownReuseDrawablePool getDrawableLruPool() {
        return (FlowMarkdownReuseDrawablePool) this.drawableLruPool.getValue();
    }

    private final Rect getImageSize() {
        return (Rect) this.imageSize.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function3<View, String, Boolean, Unit> getMarkdownLinkResolver() {
        return (Function3) this.markdownLinkResolver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinkResolverWithStyle getMarkdownLinkResolverV2() {
        return (LinkResolverWithStyle) this.markdownLinkResolverV2.getValue();
    }

    @Override // com.larus.business.markdown.api.model.IMarkwonStruct
    public Markwon getMarkwon() {
        return this.markwon;
    }
}
