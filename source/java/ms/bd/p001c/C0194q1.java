package ms.bd.p001c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: ms.bd.c.q1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0194q1 extends View {

    /* renamed from: a */
    public final /* synthetic */ C0199r1 f322a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0194q1(C0199r1 c0199r1, Context context) {
        super(context);
        this.f322a = c0199r1;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        long eventTime = motionEvent.getEventTime();
        C0214u1 c0214u1 = this.f322a.f369g;
        long j = c0214u1.f406d;
        c0214u1.f405c = j != 0 ? eventTime - j : 0L;
        c0214u1.f406d = eventTime;
        c0214u1.f407e.f398a = motionEvent.getX();
        this.f322a.f369g.f407e.f399b = motionEvent.getY();
        this.f322a.f369g.f404b++;
        return true;
    }
}
