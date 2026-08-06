package com.bytedance.mt.protector.logger;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;

/* compiled from: ILogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\b\"\u0004\u0018\u00010\u0001H&¢\u0006\u0002\u0010\tJ5\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\b\"\u0004\u0018\u00010\u0001H&¢\u0006\u0002\u0010\tJ5\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\b\"\u0004\u0018\u00010\u0001H&¢\u0006\u0002\u0010\tJ?\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\b\"\u0004\u0018\u00010\u0001H&¢\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&J5\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\b\"\u0004\u0018\u00010\u0001H&¢\u0006\u0002\u0010\tJ5\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\b\"\u0004\u0018\u00010\u0001H&¢\u0006\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/mt/protector/logger/ILogger;", "", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "", "tag", "", "msg", "obj", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", RXScreenCaptureService.KEY_INDEX, "printErrStackTrace", "tr", "", "format", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "printJson", "headString", BaseSwitches.V, "w", "protector_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public interface ILogger {
    void d(String tag, String msg, Object... obj);

    void e(String tag, String msg, Object... obj);

    void i(String tag, String msg, Object... obj);

    void printErrStackTrace(String tag, Throwable tr, String format, Object... obj);

    void printJson(String tag, String msg, String headString);

    void v(String tag, String msg, Object... obj);

    void w(String tag, String msg, Object... obj);
}
