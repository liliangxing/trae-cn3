package com.larus.business.markdown.impl.common.utils;

import com.bytedance.webx.seclink.util.ReportUtil;
import com.larus.business.markdown.api.citation.ICitationHandler;
import com.larus.business.markdown.api.depend.ICustomDataHandler;
import com.larus.business.markdown.api.depend.IMarkdownSettings;
import com.larus.business.markdown.api.extplugin.code.ICustomCodeHandler;
import com.larus.business.markdown.api.extplugin.html.HtmlCssStyle;
import com.larus.business.markdown.api.extplugin.image.ICustomImgHandler;
import com.larus.business.markdown.api.model.SyntaxErrorCoverConfig;
import com.larus.business.markdown.api.model.latex.LatexGlobalConfig;
import io.noties.markwon.html.IPrintLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: MarkdownSettings.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u0005H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/business/markdown/impl/common/utils/MarkdownSettings;", "Lcom/larus/business/markdown/api/depend/IMarkdownSettings;", "()V", "markdownSettings", "clearDrawablePoolAfterRender", "", "enableCMarkParser", "enableHtmlNameEntityOptimize", "enableNewCodeStyle", "enableOptimizeWidgetCompare", "getAutoLinkMaxLimit", "", "()Ljava/lang/Integer;", "getCitationHandler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "getCustomCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "getCustomDataHandlers", "", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "getCustomImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "getHtmlStyleClass", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "getPrintLog", "Lio/noties/markwon/html/IPrintLog;", "getSyntaxErrorCoverConfig", "Lcom/larus/business/markdown/api/model/SyntaxErrorCoverConfig;", ReportUtil.Event.EVENT_INIT, "", "isMarkdownListBlockOptimized", "isMarkdownStreamOptimized", "isMarkdownStringStreamOptimized", "latexGlobalConfig", "Lcom/larus/business/markdown/api/model/latex/LatexGlobalConfig;", "markdownDrawableLruCacheSize", "removeSynchronized", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkdownSettings implements IMarkdownSettings {
    private IMarkdownSettings markdownSettings;

    public final void init(IMarkdownSettings markdownSettings) {
        this.markdownSettings = markdownSettings;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public LatexGlobalConfig latexGlobalConfig() {
        LatexGlobalConfig latexGlobalConfig;
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        return (iMarkdownSettings == null || (latexGlobalConfig = iMarkdownSettings.latexGlobalConfig()) == null) ? new LatexGlobalConfig(0, false, null, false, false, false, null, null, false, false, false, false, 0, 8191, null) : latexGlobalConfig;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public boolean isMarkdownStreamOptimized() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.isMarkdownStreamOptimized();
        }
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public boolean isMarkdownStringStreamOptimized() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.isMarkdownStringStreamOptimized();
        }
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public boolean enableHtmlNameEntityOptimize() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.enableHtmlNameEntityOptimize();
        }
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public int markdownDrawableLruCacheSize() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.markdownDrawableLruCacheSize();
        }
        return 20;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public List<ICustomDataHandler> getCustomDataHandlers() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.getCustomDataHandlers();
        }
        return null;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public IPrintLog getPrintLog() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.getPrintLog();
        }
        return null;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public ICustomImgHandler getCustomImgHandler() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.getCustomImgHandler();
        }
        return null;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public Integer getAutoLinkMaxLimit() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.getAutoLinkMaxLimit();
        }
        return null;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public boolean isMarkdownListBlockOptimized() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.isMarkdownListBlockOptimized();
        }
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public ICitationHandler getCitationHandler() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.getCitationHandler();
        }
        return null;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public boolean clearDrawablePoolAfterRender() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.clearDrawablePoolAfterRender();
        }
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public boolean removeSynchronized() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.removeSynchronized();
        }
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public boolean enableCMarkParser() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.enableCMarkParser();
        }
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public Map<String, HtmlCssStyle> getHtmlStyleClass() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.getHtmlStyleClass();
        }
        return null;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public ICustomCodeHandler getCustomCodeHandler() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.getCustomCodeHandler();
        }
        return null;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public boolean enableNewCodeStyle() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.enableNewCodeStyle();
        }
        return false;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public SyntaxErrorCoverConfig getSyntaxErrorCoverConfig() {
        SyntaxErrorCoverConfig syntaxErrorCoverConfig;
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        return (iMarkdownSettings == null || (syntaxErrorCoverConfig = iMarkdownSettings.getSyntaxErrorCoverConfig()) == null) ? new SyntaxErrorCoverConfig(false, 1, null) : syntaxErrorCoverConfig;
    }

    @Override // com.larus.business.markdown.api.depend.IMarkdownSettings
    public boolean enableOptimizeWidgetCompare() {
        IMarkdownSettings iMarkdownSettings = this.markdownSettings;
        if (iMarkdownSettings != null) {
            return iMarkdownSettings.enableOptimizeWidgetCompare();
        }
        return false;
    }
}
