package ms.bd.c;

import android.view.MotionEvent;
import android.view.Window;
import androidx.appcompat.view.WindowCallbackWrapper;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public final class w extends WindowCallbackWrapper {
    public int a;

    public w(Window.Callback callback) {
        super(callback);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i = this.a;
        this.a = i + 1;
        if (i % 4 == 0) {
            s0 s0Var = new s0(motionEvent.getDeviceId(), (int) motionEvent.getX(), (int) motionEvent.getY());
            ArrayList arrayList = s2.c;
            if (arrayList.size() == 300) {
                arrayList.remove(299);
            }
            arrayList.add(0, s0Var);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
