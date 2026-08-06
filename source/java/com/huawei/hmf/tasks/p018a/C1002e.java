package com.huawei.hmf.tasks.p018a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* renamed from: com.huawei.hmf.tasks.a.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1002e<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {

    /* renamed from: a */
    public final Object f900a = new Object();

    /* renamed from: b */
    public final int f901b;

    /* renamed from: c */
    public final C1006i<Void> f902c;

    /* renamed from: d */
    public int f903d;

    /* renamed from: e */
    public Exception f904e;

    /* renamed from: f */
    public boolean f905f;

    public C1002e(int i, C1006i<Void> c1006i) {
        this.f901b = i;
        this.f902c = c1006i;
    }

    /* renamed from: a */
    public final void m854a() {
        if (this.f903d >= this.f901b) {
            if (this.f904e != null) {
                this.f902c.m858a(new ExecutionException("a task failed", this.f904e));
            } else if (this.f905f) {
                this.f902c.m860a();
            } else {
                this.f902c.m859a((C1006i<Void>) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public void onCanceled() {
        synchronized (this.f900a) {
            this.f903d++;
            this.f905f = true;
            m854a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        synchronized (this.f900a) {
            this.f903d++;
            this.f904e = exc;
            m854a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public void onSuccess(TResult tresult) {
        synchronized (this.f900a) {
            this.f903d++;
            m854a();
        }
    }
}
