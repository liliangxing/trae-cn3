package com.larus.business.markdown.impl.common;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.larus.business.markdown.api.common.FlowMarkdownReuseDrawablePool;
import com.larus.business.markdown.api.common.ReuseDrawablePoolNew;
import com.larus.business.markdown.api.depend.IMarkdownConfig;
import com.larus.business.markdown.api.depend.LinkResolverWithStyle;
import com.larus.business.markdown.impl.common.utils.MarkdownSettings;
import com.larus.business.markdown.impl.markwon.ASTModifier;
import com.lynx.tasm.DefaultLogicExecutor;
import io.noties.markwon.inject.IInjectParser;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkdownConfigManager.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u00020!2\b\u00102\u001a\u0004\u0018\u00010\u0019JS\u00103\u001a\u00020!2K\u00104\u001aG\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110 ¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020!0\u001dJ\u000e\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020%R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cRR\u0010\"\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0018\u00010\u001d2 \u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\"\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0018\u001a\u0004\u0018\u00010%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\b\u001a\u0004\b+\u0010,¨\u0006:"}, d2 = {"Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "", "()V", "astModifier", "Lcom/larus/business/markdown/impl/markwon/ASTModifier;", "getAstModifier", "()Lcom/larus/business/markdown/impl/markwon/ASTModifier;", "astModifier$delegate", "Lkotlin/Lazy;", "drawableLruPool", "Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "getDrawableLruPool", "()Lcom/larus/business/markdown/api/common/FlowMarkdownReuseDrawablePool;", "drawableLruPool$delegate", "drawablePool", "Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "getDrawablePool", "()Lcom/larus/business/markdown/api/common/ReuseDrawablePoolNew;", "drawablePool$delegate", "imageSize", "Landroid/graphics/Rect;", "getImageSize", "()Landroid/graphics/Rect;", "imageSize$delegate", "<set-?>", "Lio/noties/markwon/inject/IInjectParser;", "injectMarkdownParser", "getInjectMarkdownParser", "()Lio/noties/markwon/inject/IInjectParser;", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "", "markdownLinkResolver", "getMarkdownLinkResolver", "()Lkotlin/jvm/functions/Function3;", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "markdownLinkResolverV2", "getMarkdownLinkResolverV2", "()Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "settings", "Lcom/larus/business/markdown/impl/common/utils/MarkdownSettings;", WebViewContainer.EVENT_getSettings, "()Lcom/larus/business/markdown/impl/common/utils/MarkdownSettings;", "settings$delegate", ReportUtil.Event.EVENT_INIT, "config", "Lcom/larus/business/markdown/api/depend/IMarkdownConfig;", "registerInjectMarkdownParser", "injectParser", "registerLinkResolver", "resolver", "Lkotlin/ParameterName;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "view", "link", "isFromWiki", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkdownConfigManager {
    private IInjectParser injectMarkdownParser;
    private Function3<? super View, ? super String, ? super Boolean, Unit> markdownLinkResolver;
    private LinkResolverWithStyle markdownLinkResolverV2;

    /* renamed from: settings$delegate, reason: from kotlin metadata */
    private final Lazy settings = LazyKt.lazy(new Function0<MarkdownSettings>() { // from class: com.larus.business.markdown.impl.common.MarkdownConfigManager$settings$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MarkdownSettings m2821invoke() {
            return new MarkdownSettings();
        }
    });

    /* renamed from: drawablePool$delegate, reason: from kotlin metadata */
    private final Lazy drawablePool = LazyKt.lazy(new Function0<ReuseDrawablePoolNew>() { // from class: com.larus.business.markdown.impl.common.MarkdownConfigManager$drawablePool$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ReuseDrawablePoolNew m2819invoke() {
            return new ReuseDrawablePoolNew();
        }
    });

    /* renamed from: drawableLruPool$delegate, reason: from kotlin metadata */
    private final Lazy drawableLruPool = LazyKt.lazy(new Function0<FlowMarkdownReuseDrawablePool>() { // from class: com.larus.business.markdown.impl.common.MarkdownConfigManager$drawableLruPool$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FlowMarkdownReuseDrawablePool m2818invoke() {
            return new FlowMarkdownReuseDrawablePool(MarkdownConfigManager.this.getSettings().markdownDrawableLruCacheSize());
        }
    });

    /* renamed from: imageSize$delegate, reason: from kotlin metadata */
    private final Lazy imageSize = LazyKt.lazy(new Function0<Rect>() { // from class: com.larus.business.markdown.impl.common.MarkdownConfigManager$imageSize$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Rect m2820invoke() {
            return new Rect();
        }
    });

    /* renamed from: astModifier$delegate, reason: from kotlin metadata */
    private final Lazy astModifier = LazyKt.lazy(new Function0<ASTModifier>() { // from class: com.larus.business.markdown.impl.common.MarkdownConfigManager$astModifier$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ASTModifier m2817invoke() {
            return new ASTModifier();
        }
    });

    public final MarkdownSettings getSettings() {
        return (MarkdownSettings) this.settings.getValue();
    }

    public final Function3<View, String, Boolean, Unit> getMarkdownLinkResolver() {
        return this.markdownLinkResolver;
    }

    public final LinkResolverWithStyle getMarkdownLinkResolverV2() {
        return this.markdownLinkResolverV2;
    }

    public final ReuseDrawablePoolNew getDrawablePool() {
        return (ReuseDrawablePoolNew) this.drawablePool.getValue();
    }

    public final FlowMarkdownReuseDrawablePool getDrawableLruPool() {
        return (FlowMarkdownReuseDrawablePool) this.drawableLruPool.getValue();
    }

    public final Rect getImageSize() {
        return (Rect) this.imageSize.getValue();
    }

    public final ASTModifier getAstModifier() {
        return (ASTModifier) this.astModifier.getValue();
    }

    public final IInjectParser getInjectMarkdownParser() {
        return this.injectMarkdownParser;
    }

    public final void init(IMarkdownConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        getSettings().init(config.getMarkdownSettings());
        getAstModifier().setEnable(getSettings().isMarkdownStreamOptimized());
        getAstModifier().setLatexOptEnable(getSettings().latexGlobalConfig().getEnableMarkdownLatexOpt());
    }

    public final void registerLinkResolver(Function3<? super View, ? super String, ? super Boolean, Unit> resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        this.markdownLinkResolver = resolver;
    }

    public final void registerLinkResolver(LinkResolverWithStyle resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        this.markdownLinkResolverV2 = resolver;
    }

    public final void registerInjectMarkdownParser(IInjectParser injectParser) {
        this.injectMarkdownParser = injectParser;
    }
}
