package com.bytedance.android.monitorV2.dataprocessor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher;
import com.bytedance.android.monitorV2.executor.HybridMonitorSingleExecutor;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypedDataDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u000fJ\u001a\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0002J\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J\u0016\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010\n\u001a.\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b0\u0006j\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher;", "", "()V", "TAG", "", "mTypedDataHandlers", "Ljava/util/HashMap;", "Lcom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher$DataType;", "Lcom/bytedance/android/monitorV2/dataprocessor/IDataHandler;", "Lkotlin/collections/HashMap;", "mTypedPendingDataList", "", "mainHandler", "Landroid/os/Handler;", "pendingState", "", "enqueue", "", "dataType", "rawObject", "async", "enqueueInternal", "handleInternal", "notifyAllEvents", "removeDataHandler", "setDataHandler", "dataProcessor", "DataType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TypedDataDispatcher {
    private final String TAG = "DataProcessorManager";
    private boolean pendingState = true;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private HashMap<DataType, IDataHandler> mTypedDataHandlers = new HashMap<>();
    private HashMap<DataType, List<Object>> mTypedPendingDataList = new HashMap<>();

    /* compiled from: TypedDataDispatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher$DataType;", "", "(Ljava/lang/String;I)V", "WEB_VIEW", "LYNX_VIEW", "REPORT_DATA", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum DataType {
        WEB_VIEW,
        LYNX_VIEW,
        REPORT_DATA
    }

    public final void setDataHandler(DataType dataType, IDataHandler dataProcessor) {
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        Intrinsics.checkNotNullParameter(dataProcessor, "dataProcessor");
        this.mTypedDataHandlers.put(dataType, dataProcessor);
    }

    public final void removeDataHandler(DataType dataType) {
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        this.mTypedDataHandlers.remove(dataType);
    }

    public static /* synthetic */ void enqueue$default(TypedDataDispatcher typedDataDispatcher, DataType dataType, Object obj, boolean z, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = true;
        }
        typedDataDispatcher.enqueue(dataType, obj, z);
    }

    public final void enqueue(final DataType dataType, final Object rawObject, boolean async) {
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        if (async) {
            HybridMonitorSingleExecutor.INSTANCE.execute(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher$enqueue$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m326invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m326invoke() {
                    TypedDataDispatcher.this.enqueueInternal(dataType, rawObject);
                }
            });
        } else {
            enqueueInternal(dataType, rawObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueInternal(DataType dataType, Object rawObject) {
        if (rawObject == null) {
            return;
        }
        if (this.pendingState) {
            List<Object> list = this.mTypedPendingDataList.get(dataType);
            if (list != null) {
                list.add(rawObject);
            } else {
                this.mTypedPendingDataList.put(dataType, CollectionsKt.arrayListOf(new Object[]{rawObject}));
            }
            List<Object> list2 = this.mTypedPendingDataList.get(dataType);
            if (list2 == null || list2.size() <= 1000) {
                return;
            }
            notifyAllEvents();
            MonitorLog.m27e(this.TAG, dataType + " pending list is too large! current size has more than 1000");
            return;
        }
        handleInternal(dataType, rawObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleInternal(DataType dataType, Object rawObject) {
        if (!this.mTypedDataHandlers.containsKey(dataType)) {
            throw new UnsupportedOperationException("not found processor");
        }
        IDataHandler iDataHandler = this.mTypedDataHandlers.get(dataType);
        Intrinsics.checkNotNull(iDataHandler);
        iDataHandler.onDataDispatch(rawObject);
    }

    public final void notifyAllEvents() {
        HybridMonitorSingleExecutor.INSTANCE.execute(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher$notifyAllEvents$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m327invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m327invoke() {
                HashMap hashMap;
                HashMap hashMap2;
                TypedDataDispatcher.this.pendingState = false;
                hashMap = TypedDataDispatcher.this.mTypedPendingDataList;
                Set<Map.Entry> entrySet = hashMap.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "mTypedPendingDataList.entries");
                TypedDataDispatcher typedDataDispatcher = TypedDataDispatcher.this;
                for (Map.Entry entry : entrySet) {
                    List list = (List) entry.getValue();
                    if (list != null) {
                        Intrinsics.checkNotNullExpressionValue(list, "value");
                        for (Object obj : list) {
                            Object key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            typedDataDispatcher.handleInternal((TypedDataDispatcher.DataType) key, obj);
                        }
                    }
                }
                hashMap2 = TypedDataDispatcher.this.mTypedPendingDataList;
                hashMap2.clear();
            }
        });
    }
}
