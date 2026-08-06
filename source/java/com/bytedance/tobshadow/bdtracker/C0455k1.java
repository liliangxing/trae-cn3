package com.bytedance.tobshadow.bdtracker;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/tobshadow/applog/exposure/task/ThrottleCheckExposureStrategy;", "Lcom/bytedance/tobshadow/applog/exposure/task/BaseCheckExposureStrategy;", "checkTask", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "isCheckFinish", "", "check", "", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* renamed from: com.bytedance.tobshadow.bdtracker.k1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0455k1 extends AbstractC0441i1 {

    /* renamed from: b */
    public volatile boolean f713b;

    /* renamed from: c */
    public final Runnable f714c;

    /* renamed from: com.bytedance.tobshadow.bdtracker.k1$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0455k1.this.f714c.run();
            C0455k1.this.f713b = true;
        }
    }

    public C0455k1(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "checkTask");
        this.f714c = runnable;
        this.f713b = true;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0441i1
    /* renamed from: a */
    public void mo457a() {
        if (this.f713b) {
            this.f713b = false;
            this.f660a.removeCallbacks(this.f714c);
            this.f660a.postDelayed(new a(), 500L);
        }
    }
}
