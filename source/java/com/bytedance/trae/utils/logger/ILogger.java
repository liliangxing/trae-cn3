package com.bytedance.trae.utils.logger;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.crash.dumper.Scraps;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: ILogger.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0003H&J(\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014H&J4\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\"\b\u0002\u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017H&J8\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014H&J\u001a\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0007H&J$\u0010!\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0007H&¨\u0006\""}, d2 = {"Lcom/bytedance/trae/utils/logger/ILogger;", "", "isDebug", "", BaseSwitches.V, "", "tag", "", "msg", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, RXScreenCaptureService.KEY_INDEX, "w", "tr", "", "e", "getDirPath", "isInitSuccess", "uploadAllLog", "scene", Scraps.INNER_UNIT, "Lkotlin/Function1;", "uploadAllLogV2", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function3;", "", "uploadALog", "startTime", "", "endTime", "perfTraceLog", "perfSceneTraceStart", "sceneName", "uniqId", "perfTSceneTraceEnd", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ILogger {
    void d(String tag, String msg);

    void e(String tag, String msg);

    void e(String tag, String msg, Throwable tr);

    String getDirPath();

    void i(String tag, String msg);

    boolean isDebug();

    boolean isInitSuccess();

    void perfSceneTraceStart(String tag, String sceneName, String uniqId);

    void perfTSceneTraceEnd(String tag, String sceneName, String uniqId);

    void perfTraceLog(String tag, String msg);

    void uploadALog(String scene, long startTime, long endTime, Function1<? super Boolean, Unit> unit);

    void uploadAllLog(String scene, Function1<? super Boolean, Unit> unit);

    void uploadAllLogV2(String scene, Function3<? super Boolean, ? super Integer, ? super String, Unit> callback);

    void v(String tag, String msg);

    void w(String tag, String msg);

    void w(String tag, String msg, Throwable tr);

    void w(String tag, Throwable tr);

    /* compiled from: ILogger.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void uploadAllLog$default(ILogger iLogger, String str, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadAllLog");
            }
            if ((i & 2) != 0) {
                function1 = null;
            }
            iLogger.uploadAllLog(str, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void uploadAllLogV2$default(ILogger iLogger, String str, Function3 function3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadAllLogV2");
            }
            if ((i & 2) != 0) {
                function3 = null;
            }
            iLogger.uploadAllLogV2(str, function3);
        }

        public static /* synthetic */ void uploadALog$default(ILogger iLogger, String str, long j, long j2, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadALog");
            }
            if ((i & 8) != 0) {
                function1 = null;
            }
            iLogger.uploadALog(str, j, j2, function1);
        }
    }
}
