package com.bytedance.bdinstall.util;

import java.util.UUID;

/* loaded from: classes3.dex */
public class RequestIdGenerator {
    private static Singleton<String> requestIdSingleTon = createReqIdSingleton();

    private static Singleton<String> createReqIdSingleton() {
        return new Singleton<String>() { // from class: com.bytedance.bdinstall.util.RequestIdGenerator.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.bdinstall.util.Singleton
            public String create(Object... objArr) {
                return UUID.randomUUID().toString();
            }
        };
    }

    public static String getRequestId() {
        return requestIdSingleTon.get(new Object[0]);
    }

    public static void clearReqId() {
        requestIdSingleTon = createReqIdSingleton();
    }
}
