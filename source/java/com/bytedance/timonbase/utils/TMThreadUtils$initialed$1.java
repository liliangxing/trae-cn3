package com.bytedance.timonbase.utils;

import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: TMThreadUtils.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final /* synthetic */ class TMThreadUtils$initialed$1 extends MutablePropertyReference0 {
    TMThreadUtils$initialed$1(TMThreadUtils tMThreadUtils) {
        super(tMThreadUtils);
    }

    public String getName() {
        return "ioExecutor";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(TMThreadUtils.class);
    }

    public String getSignature() {
        return "getIoExecutor()Ljava/util/concurrent/ExecutorService;";
    }

    public Object get() {
        return ((TMThreadUtils) this.receiver).getIoExecutor();
    }

    public void set(Object obj) {
        ((TMThreadUtils) this.receiver).setIoExecutor((ExecutorService) obj);
    }
}
