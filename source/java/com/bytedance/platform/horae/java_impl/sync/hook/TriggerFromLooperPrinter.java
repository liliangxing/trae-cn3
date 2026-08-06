package com.bytedance.platform.horae.java_impl.sync.hook;

import android.os.Looper;
import android.util.Printer;
import com.bytedance.platform.horae.common.DoubleReflectHelper;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class TriggerFromLooperPrinter extends OnHookItem implements Printer {
    private static final char END = '<';
    private Printer mOriginPrinter;

    public TriggerFromLooperPrinter(OnHookPointTrigger onHookPointTrigger) {
        super("TriggerFromLooperPrinter", onHookPointTrigger);
    }

    @Override // com.bytedance.platform.horae.java_impl.sync.hook.OnHookItem
    public void onHook() {
        try {
            Field field = DoubleReflectHelper.getField(Looper.class, "mLogging");
            this.mOriginPrinter = (Printer) field.get(Looper.getMainLooper());
            field.set(Looper.getMainLooper(), this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (str.charAt(0) == '<' && this.mOnHookPointTrigger != null) {
            this.mOnHookPointTrigger.onHookPointTrigger(this.mChanel);
        }
        Printer printer = this.mOriginPrinter;
        if (printer != null) {
            printer.println(str);
        }
    }
}
