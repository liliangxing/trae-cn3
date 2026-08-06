package com.bytedance.timon.clipboard.suite.cert;

import com.bytedance.bpea.basics.Cert;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmptyCert.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/cert/EmptyCert;", "", "()V", "EMPTY_TOKEN", "", "genEmptyCert", "Lcom/bytedance/bpea/basics/Cert;", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class EmptyCert {
    private static final String EMPTY_TOKEN = "bpea-pasteboard_empty_cert";
    public static final EmptyCert INSTANCE = new EmptyCert();

    private EmptyCert() {
    }

    public final Cert genEmptyCert() {
        Object newProxyInstance = Proxy.newProxyInstance(Cert.class.getClassLoader(), new Class[]{Cert.class}, new InvocationHandler() { // from class: com.bytedance.timon.clipboard.suite.cert.EmptyCert$genEmptyCert$1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object proxy, Method method, Object[] args) {
                if (Intrinsics.areEqual(method != null ? method.getName() : null, "certToken")) {
                    return "bpea-pasteboard_empty_cert";
                }
                return null;
            }
        });
        if (newProxyInstance != null) {
            return (Cert) newProxyInstance;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.bpea.basics.Cert");
    }
}
