package com.larus.business.markdown.api.depend;

import com.larus.business.markdown.api.citation.ICitationHandler;
import com.larus.business.markdown.api.extplugin.code.ICustomCodeHandler;
import com.larus.business.markdown.api.extplugin.html.HtmlCssStyle;
import com.larus.business.markdown.api.extplugin.image.ICustomImgHandler;
import com.larus.business.markdown.api.model.SyntaxErrorCoverConfig;
import com.larus.business.markdown.api.model.latex.LatexGlobalConfig;
import io.noties.markwon.html.IPrintLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IMarkdownSettings.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016¨\u0006#"}, d2 = {"Lcom/larus/business/markdown/api/depend/IMarkdownSettings;", "", "clearDrawablePoolAfterRender", "", "enableCMarkParser", "enableHtmlNameEntityOptimize", "enableNewCodeStyle", "enableOptimizeWidgetCompare", "getAutoLinkMaxLimit", "", "()Ljava/lang/Integer;", "getCitationHandler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "getCustomCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "getCustomDataHandlers", "", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "getCustomImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "getHtmlStyleClass", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "getPrintLog", "Lio/noties/markwon/html/IPrintLog;", "getSyntaxErrorCoverConfig", "Lcom/larus/business/markdown/api/model/SyntaxErrorCoverConfig;", "isMarkdownListBlockOptimized", "isMarkdownStreamOptimized", "isMarkdownStringStreamOptimized", "latexGlobalConfig", "Lcom/larus/business/markdown/api/model/latex/LatexGlobalConfig;", "markdownDrawableLruCacheSize", "removeSynchronized", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IMarkdownSettings {
    boolean clearDrawablePoolAfterRender();

    boolean enableCMarkParser();

    boolean enableHtmlNameEntityOptimize();

    boolean enableNewCodeStyle();

    boolean enableOptimizeWidgetCompare();

    Integer getAutoLinkMaxLimit();

    ICitationHandler getCitationHandler();

    ICustomCodeHandler getCustomCodeHandler();

    List<ICustomDataHandler> getCustomDataHandlers();

    ICustomImgHandler getCustomImgHandler();

    Map<String, HtmlCssStyle> getHtmlStyleClass();

    IPrintLog getPrintLog();

    SyntaxErrorCoverConfig getSyntaxErrorCoverConfig();

    boolean isMarkdownListBlockOptimized();

    boolean isMarkdownStreamOptimized();

    boolean isMarkdownStringStreamOptimized();

    LatexGlobalConfig latexGlobalConfig();

    int markdownDrawableLruCacheSize();

    boolean removeSynchronized();

    /* compiled from: IMarkdownSettings.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DefaultImpls {
        public static boolean clearDrawablePoolAfterRender(IMarkdownSettings iMarkdownSettings) {
            return false;
        }

        public static boolean enableCMarkParser(IMarkdownSettings iMarkdownSettings) {
            return false;
        }

        public static boolean enableHtmlNameEntityOptimize(IMarkdownSettings iMarkdownSettings) {
            return false;
        }

        public static boolean enableNewCodeStyle(IMarkdownSettings iMarkdownSettings) {
            return false;
        }

        public static boolean enableOptimizeWidgetCompare(IMarkdownSettings iMarkdownSettings) {
            return false;
        }

        public static Integer getAutoLinkMaxLimit(IMarkdownSettings iMarkdownSettings) {
            return null;
        }

        public static ICitationHandler getCitationHandler(IMarkdownSettings iMarkdownSettings) {
            return null;
        }

        public static ICustomCodeHandler getCustomCodeHandler(IMarkdownSettings iMarkdownSettings) {
            return null;
        }

        public static List<ICustomDataHandler> getCustomDataHandlers(IMarkdownSettings iMarkdownSettings) {
            return null;
        }

        public static ICustomImgHandler getCustomImgHandler(IMarkdownSettings iMarkdownSettings) {
            return null;
        }

        public static Map<String, HtmlCssStyle> getHtmlStyleClass(IMarkdownSettings iMarkdownSettings) {
            return null;
        }

        public static boolean isMarkdownListBlockOptimized(IMarkdownSettings iMarkdownSettings) {
            return false;
        }

        public static boolean isMarkdownStreamOptimized(IMarkdownSettings iMarkdownSettings) {
            return false;
        }

        public static boolean isMarkdownStringStreamOptimized(IMarkdownSettings iMarkdownSettings) {
            return false;
        }

        public static int markdownDrawableLruCacheSize(IMarkdownSettings iMarkdownSettings) {
            return 20;
        }

        public static boolean removeSynchronized(IMarkdownSettings iMarkdownSettings) {
            return false;
        }

        public static LatexGlobalConfig latexGlobalConfig(IMarkdownSettings iMarkdownSettings) {
            return new LatexGlobalConfig(0, false, null, false, false, false, null, null, false, false, false, false, 0, 8191, null);
        }

        public static SyntaxErrorCoverConfig getSyntaxErrorCoverConfig(IMarkdownSettings iMarkdownSettings) {
            return new SyntaxErrorCoverConfig(false, 1, null);
        }
    }
}
