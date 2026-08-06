package com.edu.onetex.latex;

import android.util.Log;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.edu.onetex.html.HtmlNodeCustomViewGenerator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LateXEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002<=B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0007J\u0006\u0010#\u001a\u00020\u001aJ\u0011\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0082 J\u0013\u0010'\u001a\u0004\u0018\u00010 2\u0006\u0010(\u001a\u00020 H\u0082 J\t\u0010)\u001a\u00020\u001aH\u0082 J\u001d\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010%\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010-H\u0082 J\u0011\u0010.\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bH\u0082 J \u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u000203H\u0007J \u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020 2\u0006\u0010(\u001a\u00020 2\u0006\u00106\u001a\u00020\u0004H\u0007J\u0006\u00107\u001a\u00020\u001aJ\u000e\u00108\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016J\u000e\u00109\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0018J\u000e\u0010:\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010;\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/edu/onetex/latex/LaTeXEngine;", "", "()V", "<set-?>", "", "asyncParse", "getAsyncParse", "()Z", "setAsyncParse$onetex_release", "(Z)V", "configuration", "Lcom/edu/onetex/latex/OneTexConfiguration;", "getConfiguration", "()Lcom/edu/onetex/latex/OneTexConfiguration;", "setConfiguration", "(Lcom/edu/onetex/latex/OneTexConfiguration;)V", "debugMode", "getDebugMode", "setDebugMode", "isInitialized", "loggers", "", "Lcom/edu/onetex/latex/LaTeXEngine$IParseLogger;", "onParseErrorListeners", "Lcom/edu/onetex/latex/LaTeXEngine$OnParseErrorListener;", "addLogger", "", "logger", "addOnParseErrorListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "canParseLaTeX", "latex", "", "getSpeechText", "latexContent", ReportUtil.Event.EVENT_INIT, "nCanParseLaTeX", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "nGetSpeechText", "content", "nInit", "nParseHtml", "", "customViewGenerator", "Lcom/edu/onetex/html/HtmlNodeCustomViewGenerator;", "nSetConfig", "onParseError", "parseContent", "errorMsg", "errorCode", "", "onReceiveLog", "tag", "isError", "release", "removeLogger", "removeOnParseErrorListener", "setAsyncParse", "setConfig", "IParseLogger", "OnParseErrorListener", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class LaTeXEngine {
    private static volatile boolean asyncParse;
    private static OneTexConfiguration configuration;
    private static boolean debugMode;
    private static volatile boolean isInitialized;
    public static final LaTeXEngine INSTANCE = new LaTeXEngine();
    private static final List<OnParseErrorListener> onParseErrorListeners = new ArrayList();
    private static final List<IParseLogger> loggers = new ArrayList();

    /* compiled from: LateXEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/edu/onetex/latex/LaTeXEngine$IParseLogger;", "", "onLogError", "", "tag", "", "content", "onLogInfo", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface IParseLogger {
        void onLogError(String tag, String content);

        void onLogInfo(String tag, String content);
    }

    /* compiled from: LateXEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/edu/onetex/latex/LaTeXEngine$OnParseErrorListener;", "", "onParseError", "", "parseContent", "", "errorMsg", "errorCode", "", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface OnParseErrorListener {
        void onParseError(String parseContent, String errorMsg, int errorCode);
    }

    private final native boolean nCanParseLaTeX(LaTeXParam latexParam);

    private final native String nGetSpeechText(String content);

    private final native void nInit();

    private final native long[] nParseHtml(LaTeXParam latexParam, HtmlNodeCustomViewGenerator customViewGenerator);

    private final native void nSetConfig(OneTexConfiguration configuration2);

    private LaTeXEngine() {
    }

    public final boolean getDebugMode() {
        return debugMode;
    }

    public final void setDebugMode(boolean z) {
        debugMode = z;
    }

    public final boolean isInitialized() {
        return isInitialized;
    }

    public final boolean getAsyncParse() {
        return asyncParse;
    }

    public final void setAsyncParse$onetex_release(boolean z) {
        asyncParse = z;
    }

    public final OneTexConfiguration getConfiguration() {
        return configuration;
    }

    public final void setConfiguration(OneTexConfiguration oneTexConfiguration) {
        configuration = oneTexConfiguration;
    }

    public final void init() {
        nInit();
        isInitialized = true;
    }

    public final void setAsyncParse(boolean asyncParse2) {
        asyncParse = asyncParse2;
    }

    public final void setConfig(OneTexConfiguration configuration2) {
        Intrinsics.checkNotNullParameter(configuration2, "configuration");
        configuration = configuration2;
        nSetConfig(configuration2);
    }

    public final boolean canParseLaTeX(String latex) {
        Intrinsics.checkNotNullParameter(latex, "latex");
        return nCanParseLaTeX(new LaTeXParam(latex, new TexSize(100.0f, 1), new TexSize(20.0f, 1), 0.0f, 0, 0.0d, null, 0, 0, false, false, null, false, 8184, null));
    }

    @JvmStatic
    public static final String getSpeechText(String latexContent) {
        Intrinsics.checkNotNullParameter(latexContent, "latexContent");
        String nGetSpeechText = INSTANCE.nGetSpeechText(latexContent);
        return nGetSpeechText != null ? nGetSpeechText : "";
    }

    public final synchronized void release() {
        isInitialized = false;
    }

    public final void addOnParseErrorListener(OnParseErrorListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        List<OnParseErrorListener> list = onParseErrorListeners;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    public final void removeOnParseErrorListener(OnParseErrorListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        onParseErrorListeners.remove(listener);
    }

    @JvmStatic
    public static final void onParseError(String parseContent, String errorMsg, int errorCode) {
        Intrinsics.checkNotNullParameter(parseContent, "parseContent");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Log.i("LaTeXEngine", "onParseError = " + parseContent + ", errorMsg = " + errorMsg + ", errorCode = " + errorCode);
        Iterator<OnParseErrorListener> it = onParseErrorListeners.iterator();
        while (it.hasNext()) {
            it.next().onParseError(parseContent, errorMsg, errorCode);
        }
    }

    public final void addLogger(IParseLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        List<IParseLogger> list = loggers;
        if (list.contains(logger)) {
            return;
        }
        list.add(logger);
    }

    public final void removeLogger(IParseLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        loggers.remove(logger);
    }

    @JvmStatic
    public static final void onReceiveLog(String tag, String content, boolean isError) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(content, "content");
        for (IParseLogger iParseLogger : loggers) {
            if (isError) {
                iParseLogger.onLogInfo(tag, content);
            } else {
                iParseLogger.onLogInfo(tag, content);
            }
        }
    }
}
