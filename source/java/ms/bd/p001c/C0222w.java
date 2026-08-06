package ms.bd.p001c;

import android.view.MotionEvent;
import android.view.Window;
import androidx.appcompat.view.WindowCallbackWrapper;
import java.util.ArrayList;

/* renamed from: ms.bd.c.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0222w extends WindowCallbackWrapper {

    /* renamed from: a */
    public int f443a;

    public C0222w(Window.Callback callback) {
        super(callback);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i = this.f443a;
        this.f443a = i + 1;
        if (i % 4 == 0) {
            C0203s0 c0203s0 = new C0203s0(motionEvent.getDeviceId(), (int) motionEvent.getX(), (int) motionEvent.getY());
            ArrayList arrayList = AbstractC0205s2.f396c;
            if (arrayList.size() == 300) {
                arrayList.remove(299);
            }
            arrayList.add(0, c0203s0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
