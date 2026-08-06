package com.bytedance.applog.priority;

import com.bytedance.common.process.cross.CrossProcessDatabaseHelper;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Log.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ-\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ3\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applog/priority/PriorityCallbackLogger;", "Lcom/bytedance/applog/priority/Logger;", "priorityCallback", "Lcom/bytedance/applog/priority/PriorityCallback;", "(Lcom/bytedance/applog/priority/PriorityCallback;)V", "getPriorityCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "err", "", "formater", "", CrossProcessDatabaseHelper.COL_ARGS, "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "info", "log", "level", "", "(ILjava/lang/String;[Ljava/lang/Object;)V", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PriorityCallbackLogger implements Logger {
    private final PriorityCallback priorityCallback;

    public PriorityCallbackLogger(PriorityCallback priorityCallback) {
        Intrinsics.checkNotNullParameter(priorityCallback, "priorityCallback");
        this.priorityCallback = priorityCallback;
    }

    public final PriorityCallback getPriorityCallback() {
        return this.priorityCallback;
    }

    @Override // com.bytedance.applog.priority.Logger
    public void info(String formater, Object... args) {
        Intrinsics.checkNotNullParameter(formater, "formater");
        Intrinsics.checkNotNullParameter(args, CrossProcessDatabaseHelper.COL_ARGS);
        log(2, formater, Arrays.copyOf(args, args.length));
    }

    @Override // com.bytedance.applog.priority.Logger
    public void err(String formater, Object... args) {
        Intrinsics.checkNotNullParameter(formater, "formater");
        Intrinsics.checkNotNullParameter(args, CrossProcessDatabaseHelper.COL_ARGS);
        log(4, formater, Arrays.copyOf(args, args.length));
    }

    public final void log(int level, String formater, Object... args) {
        Intrinsics.checkNotNullParameter(formater, "formater");
        Intrinsics.checkNotNullParameter(args, CrossProcessDatabaseHelper.COL_ARGS);
        List split$default = StringsKt.split$default(formater, new String[]{"{}"}, false, 0, 6, (Object) null);
        List list = ArraysKt.toList(args);
        int size = list.size();
        int size2 = split$default.size();
        String str = "";
        for (int i = 0; i < size2; i++) {
            str = str + ((String) split$default.get(i));
            if (size > i) {
                str = str + list.get(i);
            }
        }
        this.priorityCallback.printLog(level, str);
    }
}
