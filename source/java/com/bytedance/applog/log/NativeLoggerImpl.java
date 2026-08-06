package com.bytedance.applog.log;

import android.util.Log;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NativeLoggerImpl extends LoggerImpl {
    private String tag;

    public NativeLoggerImpl() {
        this.tag = "NativeLoggerImpl";
    }

    public NativeLoggerImpl(String str) {
        this.tag = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.log.AbstractAppLogLogger
    public void process(int i, int i2, List<String> list, Throwable th, String str, Object... objArr) {
        LogInfo build = LogInfo.builder().category(i).level(i2).thread(Thread.currentThread().getName()).throwable(th).tags(getTags(list)).message(format(str, objArr)).build();
        int level = build.getLevel();
        if (level == 0) {
            Log.v(this.tag, build.toMessage(), build.getThrowable());
            return;
        }
        if (level == 2) {
            Log.i(this.tag, build.toMessage(), build.getThrowable());
            return;
        }
        if (level == 3) {
            Log.w(this.tag, build.toMessage(), build.getThrowable());
        } else if (level == 4 || level == 5) {
            Log.e(this.tag, build.toMessage(), build.getThrowable());
        } else {
            Log.d(this.tag, build.toMessage(), build.getThrowable());
        }
    }
}
