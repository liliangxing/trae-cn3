package com.vivo.push.restructure.request;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b;
import com.vivo.push.util.C1393t;

/* compiled from: CommandRequest.java */
/* renamed from: com.vivo.push.restructure.request.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1347b<I extends InterfaceC1342b, O extends InterfaceC1342b> {

    /* renamed from: a */
    private AbstractC1339a<I, O> f614a;

    /* renamed from: b */
    private InterfaceC1348c<O> f615b;

    /* renamed from: c */
    private long f616c;

    private C1347b(AbstractC1339a<I, O> abstractC1339a) {
        this.f616c = 5000L;
        this.f614a = abstractC1339a;
        if (abstractC1339a == null) {
            C1393t.m1037a(AVMDLDataLoader.KeyIsLiveLoaderEnable, "Command object is null, please construct command first");
        }
    }

    private C1347b(AbstractC1339a<I, O> abstractC1339a, InterfaceC1348c<O> interfaceC1348c) {
        this(abstractC1339a);
        this.f615b = interfaceC1348c;
    }

    public C1347b(AbstractC1339a<I, O> abstractC1339a, InterfaceC1348c<O> interfaceC1348c, long j) {
        this(abstractC1339a, interfaceC1348c);
        this.f616c = j;
    }

    /* renamed from: a */
    public final AbstractC1339a m897a() {
        return this.f614a;
    }

    /* renamed from: b */
    public final InterfaceC1348c m898b() {
        return this.f615b;
    }

    /* renamed from: c */
    public final long m899c() {
        return this.f616c;
    }
}
