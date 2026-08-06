package com.vivo.push.util;

import java.util.concurrent.ThreadFactory;

/* compiled from: ConcurrentUtils.java */
/* loaded from: classes7.dex */
final class h implements ThreadFactory {
    final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.a);
        thread.setDaemon(true);
        return thread;
    }
}
