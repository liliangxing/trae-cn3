package com.bytedance.trae.utils.logger;

import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.bytedance.ug.sdk.share.api.entity.ShareConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FormatLogBuilder.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\u00002\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J+\u0010\u0012\u001a\u00020\u00002#\u0010\u0013\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017J+\u0010\u0018\u001a\u00020\u00002#\u0010\u0013\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0002\b\u0017J\u001c\u0010\u0018\u001a\u00020\u00002\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001aJ.\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fJ\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\"\u001a\u00020\u00072\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u001aH\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;", "", "logger", "Lcom/bytedance/trae/utils/logger/Logger;", "level", "Lcom/bytedance/trae/utils/logger/LogLevel;", "what", "", "<init>", "(Lcom/bytedance/trae/utils/logger/Logger;Lcom/bytedance/trae/utils/logger/LogLevel;Ljava/lang/String;)V", "parameter", "Lcom/bytedance/trae/utils/logger/LogParameter;", "linkID", "", "eventType", "whereInfo", "who", EventConstants.PARAM_SOURCE, "params2", "block", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "params", "Lcom/bytedance/trae/utils/logger/LogKey;", "", IFrontierMonitor.KEY_LOG, "file", "function", ShareConstant.LINE, "", "stackTraceIndex", "formatStructuredLog", "formatParams", "sanitize", "input", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FlowFormatLogBuilder {
    private final LogLevel level;
    private final Logger logger;
    private LogParameter parameter;

    public FlowFormatLogBuilder(Logger logger, LogLevel logLevel, String str) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(logLevel, "level");
        Intrinsics.checkNotNullParameter(str, "what");
        this.logger = logger;
        this.level = logLevel;
        this.parameter = new LogParameter(str, null, null, null, null, null, null, 126, null);
    }

    public final FlowFormatLogBuilder linkID(List<String> linkID) {
        this.parameter.setLinkID(linkID);
        return this;
    }

    public final FlowFormatLogBuilder eventType(String eventType) {
        this.parameter.setEventType(eventType);
        return this;
    }

    public final FlowFormatLogBuilder whereInfo(String whereInfo) {
        this.parameter.setWhereInfo(whereInfo);
        return this;
    }

    public final FlowFormatLogBuilder who(String who) {
        this.parameter.setWho(who);
        return this;
    }

    public final FlowFormatLogBuilder source(String source) {
        this.parameter.setSource(source);
        return this;
    }

    public final FlowFormatLogBuilder params2(Function1<? super Map<String, Object>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        block.invoke(linkedHashMap);
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(TuplesKt.to(new LogKey((String) entry.getKey()), entry.getValue()));
        }
        return params(MapsKt.toMap(arrayList));
    }

    public final FlowFormatLogBuilder params(Function1<? super Map<LogKey, Object>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        block.invoke(linkedHashMap);
        return params(linkedHashMap);
    }

    public final FlowFormatLogBuilder params(Map<LogKey, ? extends Object> params) {
        if (params == null) {
            return this;
        }
        if (this.parameter.getParams() == null) {
            this.parameter.setParams(new HashMap(params));
        } else {
            Map<LogKey, Object> params2 = this.parameter.getParams();
            Intrinsics.checkNotNull(params2);
            params2.putAll(params);
        }
        return this;
    }

    public static /* synthetic */ void log$default(FlowFormatLogBuilder flowFormatLogBuilder, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            i = -1;
        }
        if ((i3 & 8) != 0) {
            i2 = 4;
        }
        flowFormatLogBuilder.log(str, str2, i, i2);
    }

    public final void log(String file, String function, int line, int stackTraceIndex) {
        String methodName;
        String fileName;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(function, "function");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace.length >= stackTraceIndex + 1 ? stackTrace[stackTraceIndex] : null;
        String str = (stackTraceElement == null || (fileName = stackTraceElement.getFileName()) == null) ? file : fileName;
        String str2 = (stackTraceElement == null || (methodName = stackTraceElement.getMethodName()) == null) ? function : methodName;
        if (stackTraceElement != null) {
            line = stackTraceElement.getLineNumber();
        }
        this.logger.log(this.level, formatStructuredLog(this.parameter), str, str2, line);
    }

    private final String formatStructuredLog(LogParameter parameter) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("<What=" + sanitize(parameter.getWhat()) + '>');
        Map<LogKey, Object> params = parameter.getParams();
        if (params != null) {
            if (!(!params.isEmpty())) {
                params = null;
            }
            if (params != null) {
                arrayList.add("<Params=" + formatParams(params) + '>');
            }
        }
        String who = parameter.getWho();
        if (who != null) {
            arrayList.add("<Who=" + sanitize(who) + '>');
        }
        String whereInfo = parameter.getWhereInfo();
        if (whereInfo != null) {
            arrayList.add("<Where=" + sanitize(whereInfo) + '>');
        }
        String eventType = parameter.getEventType();
        if (eventType != null) {
            arrayList.add("<EventType=" + sanitize(eventType) + '>');
        }
        List<String> linkID = parameter.getLinkID();
        if (linkID != null) {
            List<String> list = linkID.isEmpty() ^ true ? linkID : null;
            if (list != null) {
                arrayList.add("<LinkID=" + CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.utils.logger.FlowFormatLogBuilder$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        CharSequence formatStructuredLog$lambda$8$lambda$7;
                        formatStructuredLog$lambda$8$lambda$7 = FlowFormatLogBuilder.formatStructuredLog$lambda$8$lambda$7(FlowFormatLogBuilder.this, (String) obj);
                        return formatStructuredLog$lambda$8$lambda$7;
                    }
                }, 30, (Object) null) + '>');
            }
        }
        String source = parameter.getSource();
        if (source != null) {
            arrayList.add("<Source=" + sanitize(source) + '>');
        }
        return CollectionsKt.joinToString$default(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence formatStructuredLog$lambda$8$lambda$7(FlowFormatLogBuilder flowFormatLogBuilder, String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return "{" + flowFormatLogBuilder.sanitize(str) + '}';
    }

    private final String sanitize(String input) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(input, "<", "", false, 4, (Object) null), ">", "", false, 4, (Object) null), "\"", "\\\"", false, 4, (Object) null);
    }

    private final String formatParams(Map<LogKey, ? extends Object> params) {
        String obj;
        ArrayList arrayList = new ArrayList(params.size());
        for (Map.Entry<LogKey, ? extends Object> entry : params.entrySet()) {
            LogKey key = entry.getKey();
            Object value = entry.getValue();
            String str = "\"" + sanitize(key.getRawValue()) + '\"';
            if (value instanceof String) {
                obj = "\"" + sanitize((String) value) + '\"';
            } else {
                obj = value instanceof Number ? value.toString() : "\"" + sanitize(value.toString()) + '\"';
            }
            arrayList.add(str + ':' + obj);
        }
        return "{" + CollectionsKt.joinToString$default(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + '}';
    }
}
