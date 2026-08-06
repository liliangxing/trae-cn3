package ms.bd.p001c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mobsec.metasec.ml.MSManager;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import okio.Utf8;

/* renamed from: ms.bd.c.n1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class HandlerC0179n1 extends Handler {

    /* renamed from: a */
    public MSManager f262a;

    /* renamed from: b */
    public final /* synthetic */ C0189p1 f263b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0179n1(C0189p1 c0189p1, Looper looper) {
        super(looper);
        this.f263b = c0189p1;
    }

    /* renamed from: a */
    public final void m152a() {
        if (this.f262a == null) {
            this.f262a = MSManagerUtils.get(this.f263b.f305c);
        }
        this.f262a.report((String) AbstractC0190p2.m166a(16777217, 0, 0L, "90910e", new byte[]{36, 59, 92, 64, 48, 102, Utf8.REPLACEMENT_BYTE, 2}));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i;
        super.handleMessage(message);
        int i2 = message.what;
        if (i2 == 0) {
            this.f263b.f308f.post(new RunnableC0169l1(this));
            this.f263b.f303a.m181c();
            long j = this.f263b.f304b.f432d;
            Message message2 = new Message();
            message2.what = 1;
            sendMessageDelayed(message2, j);
            return;
        }
        if (i2 == 1) {
            this.f263b.f308f.post(new RunnableC0174m1(this));
            C0219v1 c0219v1 = this.f263b.f304b;
            if (c0219v1.f434f && (i = c0219v1.f430b) == c0219v1.f429a) {
                Message message3 = new Message();
                message3.what = 2;
                sendMessageDelayed(message3, i);
                return;
            } else {
                long j2 = c0219v1.f430b;
                Message message4 = new Message();
                message4.what = 0;
                sendMessageDelayed(message4, j2);
                return;
            }
        }
        if (i2 == 2) {
            this.f263b.f303a.m181c();
            long j3 = this.f263b.f304b.f430b;
            Message message5 = new Message();
            message5.what = 2;
            sendMessageDelayed(message5, j3);
            return;
        }
        if (i2 == 3) {
            m152a();
            long j4 = this.f263b.f304b.f431c;
            Message message6 = new Message();
            message6.what = 3;
            sendMessageDelayed(message6, j4);
            return;
        }
        if (i2 != 4) {
            return;
        }
        m152a();
        this.f263b.f303a.m179a(true);
        this.f263b.f307e.removeCallbacks(null);
        this.f263b.f310h.countDown();
    }
}
