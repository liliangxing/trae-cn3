package io.noties.markwon.ext.onetex;

import android.graphics.drawable.Drawable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LatexConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u000223B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0011\u0010\u001b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\bR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\bR\u0011\u0010\"\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010$\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\bR\u0011\u0010&\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\bR\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\b¨\u00064"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexConfig;", "", "builder", "Lio/noties/markwon/ext/onetex/LatexConfig$Builder;", "(Lio/noties/markwon/ext/onetex/LatexConfig$Builder;)V", "blocksEnabled", "", "getBlocksEnabled", "()Z", "blocksLegacy", "getBlocksLegacy", "customizedLatexPattern", "", "getCustomizedLatexPattern", "()Ljava/lang/String;", "errorHandler", "Lio/noties/markwon/ext/onetex/LatexConfig$ErrorHandler;", "getErrorHandler", "()Lio/noties/markwon/ext/onetex/LatexConfig$ErrorHandler;", "executorService", "Ljava/util/concurrent/ExecutorService;", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "inlinesEnabled", "getInlinesEnabled", "inlinesSingleDollarEnabled", "getInlinesSingleDollarEnabled", "isDisableLatexSplit", "latexBitmapCacheSize", "", "getLatexBitmapCacheSize", "()I", "latexFallbackEnable", "getLatexFallbackEnable", "latexMaxWidth", "getLatexMaxWidth", "latexSplitOptimize", "getLatexSplitOptimize", "supportNewCommand", "getSupportNewCommand", "theme", "Lio/noties/markwon/ext/onetex/LatexMathTheme;", "getTheme", "()Lio/noties/markwon/ext/onetex/LatexMathTheme;", "unSupportLatexCommandList", "", "getUnSupportLatexCommandList", "()Ljava/util/List;", "useLatexBitmapCache", "getUseLatexBitmapCache", "Builder", "ErrorHandler", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LatexConfig {
    private final boolean blocksEnabled;
    private final boolean blocksLegacy;
    private final String customizedLatexPattern;
    private final ErrorHandler errorHandler;
    private final ExecutorService executorService;
    private final boolean inlinesEnabled;
    private final boolean inlinesSingleDollarEnabled;
    private final boolean isDisableLatexSplit;
    private final int latexBitmapCacheSize;
    private final boolean latexFallbackEnable;
    private final int latexMaxWidth;
    private final boolean latexSplitOptimize;
    private final boolean supportNewCommand;
    private final LatexMathTheme theme;
    private final List<String> unSupportLatexCommandList;
    private final boolean useLatexBitmapCache;

    /* compiled from: LatexConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexConfig$ErrorHandler;", "", "handleError", "Landroid/graphics/drawable/Drawable;", "latex", "", "error", "", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ErrorHandler {
        Drawable handleError(String latex, Throwable error);
    }

    public LatexConfig(Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        this.theme = builder.getTheme();
        this.blocksEnabled = builder.getBlocksEnabled();
        this.blocksLegacy = builder.getBlocksLegacy();
        this.inlinesEnabled = builder.getInlinesEnabled();
        this.inlinesSingleDollarEnabled = builder.getInlinesSingleDollarEnabled();
        this.errorHandler = builder.getErrorHandler();
        ThreadPoolExecutor executorService = builder.getExecutorService();
        this.executorService = executorService == null ? LaTexHelper.INSTANCE.getExecutor$markwon_ext_onetex_release() : executorService;
        this.isDisableLatexSplit = builder.getIsDisableLatexSplit();
        this.latexFallbackEnable = builder.getLatexFallbackEnable();
        this.unSupportLatexCommandList = builder.getUnSupportLatexCommandList$markwon_ext_onetex_release();
        this.customizedLatexPattern = builder.getCustomizedLatexPattern();
        this.latexMaxWidth = builder.getLatexMaxWidth();
        this.latexSplitOptimize = builder.getLatexSplitOptimize();
        this.supportNewCommand = builder.getSupportNewCommand();
        this.useLatexBitmapCache = builder.getUseLatexBitmapCache();
        this.latexBitmapCacheSize = builder.getLatexBitmapCacheSize();
    }

    public final LatexMathTheme getTheme() {
        return this.theme;
    }

    public final boolean getBlocksEnabled() {
        return this.blocksEnabled;
    }

    public final boolean getBlocksLegacy() {
        return this.blocksLegacy;
    }

    public final boolean getInlinesEnabled() {
        return this.inlinesEnabled;
    }

    public final boolean getInlinesSingleDollarEnabled() {
        return this.inlinesSingleDollarEnabled;
    }

    public final ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    public final ExecutorService getExecutorService() {
        return this.executorService;
    }

    /* renamed from: isDisableLatexSplit, reason: from getter */
    public final boolean getIsDisableLatexSplit() {
        return this.isDisableLatexSplit;
    }

    public final boolean getLatexFallbackEnable() {
        return this.latexFallbackEnable;
    }

    public final List<String> getUnSupportLatexCommandList() {
        return this.unSupportLatexCommandList;
    }

    public final String getCustomizedLatexPattern() {
        return this.customizedLatexPattern;
    }

    public final int getLatexMaxWidth() {
        return this.latexMaxWidth;
    }

    public final boolean getLatexSplitOptimize() {
        return this.latexSplitOptimize;
    }

    public final boolean getSupportNewCommand() {
        return this.supportNewCommand;
    }

    public final boolean getUseLatexBitmapCache() {
        return this.useLatexBitmapCache;
    }

    public final int getLatexBitmapCacheSize() {
        return this.latexBitmapCacheSize;
    }

    /* compiled from: LatexConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010F\u001a\u00020GJ\u0016\u0010H\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u0016\u0010I\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020*J\u000e\u0010J\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010K\u001a\u00020\u00002\b\u0010L\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010M\u001a\u00020\u00002\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010>J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0006J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001a\u0010#\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\nR\u001a\u0010&\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010\nR\u001a\u0010)\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\b\"\u0004\b1\u0010\nR\u001a\u00102\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R\u001a\u00105\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\nR\u001a\u00108\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\b\"\u0004\b:\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R \u0010=\u001a\b\u0012\u0004\u0012\u00020\u000f0>X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\b\"\u0004\bE\u0010\n¨\u0006R"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexConfig$Builder;", "", "theme", "Lio/noties/markwon/ext/onetex/LatexMathTheme;", "(Lio/noties/markwon/ext/onetex/LatexMathTheme;)V", "blocksEnabled", "", "getBlocksEnabled$markwon_ext_onetex_release", "()Z", "setBlocksEnabled$markwon_ext_onetex_release", "(Z)V", "blocksLegacy", "getBlocksLegacy$markwon_ext_onetex_release", "setBlocksLegacy$markwon_ext_onetex_release", "customizedLatexPattern", "", "getCustomizedLatexPattern$markwon_ext_onetex_release", "()Ljava/lang/String;", "setCustomizedLatexPattern$markwon_ext_onetex_release", "(Ljava/lang/String;)V", "errorHandler", "Lio/noties/markwon/ext/onetex/LatexConfig$ErrorHandler;", "getErrorHandler$markwon_ext_onetex_release", "()Lio/noties/markwon/ext/onetex/LatexConfig$ErrorHandler;", "setErrorHandler$markwon_ext_onetex_release", "(Lio/noties/markwon/ext/onetex/LatexConfig$ErrorHandler;)V", "executorService", "Ljava/util/concurrent/ExecutorService;", "getExecutorService$markwon_ext_onetex_release", "()Ljava/util/concurrent/ExecutorService;", "setExecutorService$markwon_ext_onetex_release", "(Ljava/util/concurrent/ExecutorService;)V", "inlinesEnabled", "getInlinesEnabled$markwon_ext_onetex_release", "setInlinesEnabled$markwon_ext_onetex_release", "inlinesSingleDollarEnabled", "getInlinesSingleDollarEnabled$markwon_ext_onetex_release", "setInlinesSingleDollarEnabled$markwon_ext_onetex_release", "isDisableLatexSplit", "isDisableLatexSplit$markwon_ext_onetex_release", "setDisableLatexSplit$markwon_ext_onetex_release", "latexBitmapCacheSize", "", "getLatexBitmapCacheSize$markwon_ext_onetex_release", "()I", "setLatexBitmapCacheSize$markwon_ext_onetex_release", "(I)V", "latexFallbackEnable", "getLatexFallbackEnable$markwon_ext_onetex_release", "setLatexFallbackEnable$markwon_ext_onetex_release", "latexMaxWidth", "getLatexMaxWidth$markwon_ext_onetex_release", "setLatexMaxWidth$markwon_ext_onetex_release", "latexSplitOptimize", "getLatexSplitOptimize$markwon_ext_onetex_release", "setLatexSplitOptimize$markwon_ext_onetex_release", "supportNewCommand", "getSupportNewCommand$markwon_ext_onetex_release", "setSupportNewCommand$markwon_ext_onetex_release", "getTheme", "()Lio/noties/markwon/ext/onetex/LatexMathTheme;", "unSupportLatexCommandList", "", "getUnSupportLatexCommandList$markwon_ext_onetex_release", "()Ljava/util/List;", "setUnSupportLatexCommandList$markwon_ext_onetex_release", "(Ljava/util/List;)V", "useLatexBitmapCache", "getUseLatexBitmapCache$markwon_ext_onetex_release", "setUseLatexBitmapCache$markwon_ext_onetex_release", "build", "Lio/noties/markwon/ext/onetex/LatexConfig;", "configLatexBitmapCache", "configLatexSplitOptimize", "enableSupportNewCommand", "getCustomizedLatexPattern", "pattern", "getUnSupportLatexCommandList", "unSupportCommandList", "inlinesSingleDollarEnable", "enable", "isLatexFallbackEnable", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Builder {
        private boolean blocksEnabled;
        private boolean blocksLegacy;
        private String customizedLatexPattern;
        private ErrorHandler errorHandler;
        private ExecutorService executorService;
        private boolean inlinesEnabled;
        private boolean inlinesSingleDollarEnabled;
        private boolean isDisableLatexSplit;
        private int latexBitmapCacheSize;
        private boolean latexFallbackEnable;
        private int latexMaxWidth;
        private boolean latexSplitOptimize;
        private boolean supportNewCommand;
        private final LatexMathTheme theme;
        private List<String> unSupportLatexCommandList;
        private boolean useLatexBitmapCache;

        public Builder(LatexMathTheme latexMathTheme) {
            Intrinsics.checkParameterIsNotNull(latexMathTheme, "theme");
            this.theme = latexMathTheme;
            this.blocksEnabled = true;
            this.inlinesSingleDollarEnabled = true;
            this.unSupportLatexCommandList = CollectionsKt.emptyList();
            this.latexBitmapCacheSize = 5000;
        }

        public final LatexMathTheme getTheme() {
            return this.theme;
        }

        /* renamed from: getBlocksEnabled$markwon_ext_onetex_release, reason: from getter */
        public final boolean getBlocksEnabled() {
            return this.blocksEnabled;
        }

        public final void setBlocksEnabled$markwon_ext_onetex_release(boolean z) {
            this.blocksEnabled = z;
        }

        /* renamed from: getBlocksLegacy$markwon_ext_onetex_release, reason: from getter */
        public final boolean getBlocksLegacy() {
            return this.blocksLegacy;
        }

        public final void setBlocksLegacy$markwon_ext_onetex_release(boolean z) {
            this.blocksLegacy = z;
        }

        /* renamed from: getInlinesEnabled$markwon_ext_onetex_release, reason: from getter */
        public final boolean getInlinesEnabled() {
            return this.inlinesEnabled;
        }

        public final void setInlinesEnabled$markwon_ext_onetex_release(boolean z) {
            this.inlinesEnabled = z;
        }

        /* renamed from: getErrorHandler$markwon_ext_onetex_release, reason: from getter */
        public final ErrorHandler getErrorHandler() {
            return this.errorHandler;
        }

        public final void setErrorHandler$markwon_ext_onetex_release(ErrorHandler errorHandler) {
            this.errorHandler = errorHandler;
        }

        /* renamed from: getExecutorService$markwon_ext_onetex_release, reason: from getter */
        public final ExecutorService getExecutorService() {
            return this.executorService;
        }

        public final void setExecutorService$markwon_ext_onetex_release(ExecutorService executorService) {
            this.executorService = executorService;
        }

        /* renamed from: getInlinesSingleDollarEnabled$markwon_ext_onetex_release, reason: from getter */
        public final boolean getInlinesSingleDollarEnabled() {
            return this.inlinesSingleDollarEnabled;
        }

        public final void setInlinesSingleDollarEnabled$markwon_ext_onetex_release(boolean z) {
            this.inlinesSingleDollarEnabled = z;
        }

        /* renamed from: isDisableLatexSplit$markwon_ext_onetex_release, reason: from getter */
        public final boolean getIsDisableLatexSplit() {
            return this.isDisableLatexSplit;
        }

        public final void setDisableLatexSplit$markwon_ext_onetex_release(boolean z) {
            this.isDisableLatexSplit = z;
        }

        /* renamed from: getLatexFallbackEnable$markwon_ext_onetex_release, reason: from getter */
        public final boolean getLatexFallbackEnable() {
            return this.latexFallbackEnable;
        }

        public final void setLatexFallbackEnable$markwon_ext_onetex_release(boolean z) {
            this.latexFallbackEnable = z;
        }

        public final List<String> getUnSupportLatexCommandList$markwon_ext_onetex_release() {
            return this.unSupportLatexCommandList;
        }

        public final void setUnSupportLatexCommandList$markwon_ext_onetex_release(List<String> list) {
            Intrinsics.checkParameterIsNotNull(list, "<set-?>");
            this.unSupportLatexCommandList = list;
        }

        /* renamed from: getCustomizedLatexPattern$markwon_ext_onetex_release, reason: from getter */
        public final String getCustomizedLatexPattern() {
            return this.customizedLatexPattern;
        }

        public final void setCustomizedLatexPattern$markwon_ext_onetex_release(String str) {
            this.customizedLatexPattern = str;
        }

        /* renamed from: getLatexMaxWidth$markwon_ext_onetex_release, reason: from getter */
        public final int getLatexMaxWidth() {
            return this.latexMaxWidth;
        }

        public final void setLatexMaxWidth$markwon_ext_onetex_release(int i) {
            this.latexMaxWidth = i;
        }

        /* renamed from: getSupportNewCommand$markwon_ext_onetex_release, reason: from getter */
        public final boolean getSupportNewCommand() {
            return this.supportNewCommand;
        }

        public final void setSupportNewCommand$markwon_ext_onetex_release(boolean z) {
            this.supportNewCommand = z;
        }

        /* renamed from: getLatexSplitOptimize$markwon_ext_onetex_release, reason: from getter */
        public final boolean getLatexSplitOptimize() {
            return this.latexSplitOptimize;
        }

        public final void setLatexSplitOptimize$markwon_ext_onetex_release(boolean z) {
            this.latexSplitOptimize = z;
        }

        /* renamed from: getUseLatexBitmapCache$markwon_ext_onetex_release, reason: from getter */
        public final boolean getUseLatexBitmapCache() {
            return this.useLatexBitmapCache;
        }

        public final void setUseLatexBitmapCache$markwon_ext_onetex_release(boolean z) {
            this.useLatexBitmapCache = z;
        }

        /* renamed from: getLatexBitmapCacheSize$markwon_ext_onetex_release, reason: from getter */
        public final int getLatexBitmapCacheSize() {
            return this.latexBitmapCacheSize;
        }

        public final void setLatexBitmapCacheSize$markwon_ext_onetex_release(int i) {
            this.latexBitmapCacheSize = i;
        }

        public final Builder blocksEnabled(boolean blocksEnabled) {
            this.blocksEnabled = blocksEnabled;
            return this;
        }

        public final Builder blocksLegacy(boolean blocksLegacy) {
            this.blocksLegacy = blocksLegacy;
            return this;
        }

        public final Builder inlinesEnabled(boolean inlinesEnabled) {
            this.inlinesEnabled = inlinesEnabled;
            return this;
        }

        public final Builder inlinesSingleDollarEnable(boolean enable) {
            this.inlinesSingleDollarEnabled = enable;
            return this;
        }

        public final Builder errorHandler(ErrorHandler errorHandler) {
            this.errorHandler = errorHandler;
            return this;
        }

        public final Builder executorService(ExecutorService executorService) {
            Intrinsics.checkParameterIsNotNull(executorService, "executorService");
            this.executorService = executorService;
            return this;
        }

        public final Builder isDisableLatexSplit(boolean isDisableLatexSplit) {
            this.isDisableLatexSplit = isDisableLatexSplit;
            return this;
        }

        public final Builder getUnSupportLatexCommandList(List<String> unSupportCommandList) {
            if (unSupportCommandList == null) {
                unSupportCommandList = CollectionsKt.emptyList();
            }
            this.unSupportLatexCommandList = unSupportCommandList;
            return this;
        }

        public final Builder isLatexFallbackEnable(boolean latexFallbackEnable) {
            this.latexFallbackEnable = latexFallbackEnable;
            return this;
        }

        public final Builder getCustomizedLatexPattern(String pattern) {
            this.customizedLatexPattern = pattern;
            return this;
        }

        public final Builder configLatexSplitOptimize(boolean latexSplitOptimize, int latexMaxWidth) {
            this.latexSplitOptimize = latexSplitOptimize;
            this.latexMaxWidth = latexMaxWidth;
            return this;
        }

        public final Builder enableSupportNewCommand(boolean supportNewCommand) {
            this.supportNewCommand = supportNewCommand;
            return this;
        }

        public final Builder configLatexBitmapCache(boolean useLatexBitmapCache, int latexBitmapCacheSize) {
            this.useLatexBitmapCache = useLatexBitmapCache;
            this.latexBitmapCacheSize = latexBitmapCacheSize;
            return this;
        }

        public final LatexConfig build() {
            return new LatexConfig(this);
        }
    }
}
