package com.bytedance.geckox.lock;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResLockManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/geckox/lock/ResLockManager;", "", "()V", "resLockMap", "", "", "Lcom/bytedance/geckox/lock/GeckoReadWriteLock;", "initLock", "channelPath", "readLock", "", "readTryLock", "readUnlock", "", "writeTryLock", "writeUnlock", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ResLockManager {
    public static final ResLockManager INSTANCE = new ResLockManager();
    private static final Map<String, GeckoReadWriteLock> resLockMap = new LinkedHashMap();

    private ResLockManager() {
    }

    public final boolean readTryLock(String channelPath) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(channelPath, "channelPath");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(INSTANCE.initLock(channelPath).readTryLock()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean readLock(String channelPath) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(channelPath, "channelPath");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(INSTANCE.initLock(channelPath).readLock()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final void readUnlock(String channelPath) {
        Intrinsics.checkParameterIsNotNull(channelPath, "channelPath");
        try {
            Result.Companion companion = Result.Companion;
            INSTANCE.initLock(channelPath).readUnlock();
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final boolean writeTryLock(String channelPath) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(channelPath, "channelPath");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(INSTANCE.initLock(channelPath).writeTryLock()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final void writeUnlock(String channelPath) {
        Intrinsics.checkParameterIsNotNull(channelPath, "channelPath");
        try {
            Result.Companion companion = Result.Companion;
            INSTANCE.initLock(channelPath).writeUnlock();
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final GeckoReadWriteLock initLock(String channelPath) {
        GeckoReadWriteLock geckoReadWriteLock;
        Map<String, GeckoReadWriteLock> map = resLockMap;
        synchronized (map) {
            geckoReadWriteLock = map.get(channelPath);
            if (geckoReadWriteLock == null) {
                geckoReadWriteLock = new GeckoReadWriteLock();
                map.put(channelPath, geckoReadWriteLock);
            }
        }
        return geckoReadWriteLock;
    }
}
