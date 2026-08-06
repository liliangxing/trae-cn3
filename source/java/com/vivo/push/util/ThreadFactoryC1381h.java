package com.vivo.push.util;

import java.util.concurrent.ThreadFactory;

/* compiled from: ConcurrentUtils.java */
/* renamed from: com.vivo.push.util.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class ThreadFactoryC1381h implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ String f693a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadFactoryC1381h(String str) {
        this.f693a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.f693a);
        thread.setDaemon(true);
        return thread;
    }
}
