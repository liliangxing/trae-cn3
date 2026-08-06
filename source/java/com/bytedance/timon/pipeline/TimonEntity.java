package com.bytedance.timon.pipeline;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: TimonEntity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u001c\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u0014\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0006H\u0086\bJ\u0016\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005J\u001a\u0010\u0016\u001a\u0002H\u0011\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\u0012R%\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/timon/pipeline/TimonEntity;", "", "()V", "components", "", "Lkotlin/reflect/KClass;", "Lcom/bytedance/timon/pipeline/TimonComponent;", "getComponents", "()Ljava/util/Map;", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "assignComponent", "", "component", "getComponent", "T", "()Lcom/bytedance/timon/pipeline/TimonComponent;", "hasComponent", "", "clazz", "requireComponent", "Companion", "pipeline_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TimonEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<KClass<? extends TimonComponent>, TimonComponent> components;
    private final ReentrantReadWriteLock lock;

    private TimonEntity() {
        this.components = new LinkedHashMap();
        this.lock = new ReentrantReadWriteLock();
    }

    public /* synthetic */ TimonEntity(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: TimonEntity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/timon/pipeline/TimonEntity$Companion;", "", "()V", "obtain", "Lcom/bytedance/timon/pipeline/TimonEntity;", "pipeline_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TimonEntity obtain() {
            return new TimonEntity(null);
        }
    }

    public final Map<KClass<? extends TimonComponent>, TimonComponent> getComponents() {
        return this.components;
    }

    public final ReentrantReadWriteLock getLock() {
        return this.lock;
    }

    public final void assignComponent(TimonComponent component) {
        Intrinsics.checkParameterIsNotNull(component, "component");
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            this.components.put(Reflection.getOrCreateKotlinClass(component.getClass()), component);
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final /* synthetic */ <T extends TimonComponent> T getComponent() {
        ReentrantReadWriteLock.ReadLock readLock = getLock().readLock();
        readLock.lock();
        try {
            Map<KClass<? extends TimonComponent>, TimonComponent> components = getComponents();
            Intrinsics.reifiedOperationMarker(4, "T");
            TimonComponent timonComponent = components.get(Reflection.getOrCreateKotlinClass(TimonComponent.class));
            Intrinsics.reifiedOperationMarker(2, "T");
            return (T) timonComponent;
        } finally {
            InlineMarker.finallyStart(1);
            readLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    public final /* synthetic */ <T extends TimonComponent> T requireComponent() {
        ReentrantReadWriteLock.ReadLock readLock = getLock().readLock();
        readLock.lock();
        try {
            Map<KClass<? extends TimonComponent>, TimonComponent> components = getComponents();
            Intrinsics.reifiedOperationMarker(4, "T");
            TimonComponent timonComponent = components.get(Reflection.getOrCreateKotlinClass(TimonComponent.class));
            Intrinsics.reifiedOperationMarker(1, "T");
            return (T) timonComponent;
        } finally {
            InlineMarker.finallyStart(1);
            readLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    public final /* synthetic */ <T extends TimonComponent> boolean hasComponent() {
        ReentrantReadWriteLock.ReadLock readLock = getLock().readLock();
        readLock.lock();
        try {
            Map<KClass<? extends TimonComponent>, TimonComponent> components = getComponents();
            Intrinsics.reifiedOperationMarker(4, "T");
            return components.containsKey(Reflection.getOrCreateKotlinClass(TimonComponent.class));
        } finally {
            InlineMarker.finallyStart(1);
            readLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    public final boolean hasComponent(KClass<? extends TimonComponent> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        ReentrantReadWriteLock.ReadLock readLock = this.lock.readLock();
        readLock.lock();
        try {
            return this.components.containsKey(clazz);
        } finally {
            readLock.unlock();
        }
    }
}
