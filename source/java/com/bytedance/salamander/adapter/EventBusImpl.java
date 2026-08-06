package com.bytedance.salamander.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: eventbus.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J`\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00102D\u0010\u0015\u001a@\u00122\u00120\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\fj\u0011`\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0016j\u0002`\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J*\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J&\u0010!\u001a\u0018\u0012\f\u0012\n #*\u0004\u0018\u00010\u00100\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\"2\u0006\u0010$\u001a\u00020%H\u0002J \u0010&\u001a\u00020%2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\fj\u0002`\u0017H\u0002J2\u0010(\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00102\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\fj\u0002`\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\"\u0010*\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR4\u0010\u000b\u001a(\u0012\u0004\u0012\u00020\r\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u000f0\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/salamander/adapter/EventBusImpl;", "Lcom/bytedance/salamander/adapter/SLEventBusProvider;", "()V", "context", "Landroid/content/Context;", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "getLocalBroadcastManager", "()Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "localBroadcastManager$delegate", "Lkotlin/Lazy;", "receiversMap", "", "", "", "Lkotlin/Triple;", "", "", "Landroid/content/BroadcastReceiver;", "addObserverUsingBlock", SchemaConstants.INNER_PARAM_EVENT_NAME, "callback", "Lkotlin/Function1;", "Lcom/bytedance/salamander/adapter/SLEventUserInfo;", "Lkotlin/ParameterName;", "name", "userInfo", "", "Lcom/bytedance/salamander/adapter/SLEventCallback;", "sender", "addObserverUsingFunction", "observer", "callbackName", "bundleToMap", "", "kotlin.jvm.PlatformType", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "mapToBundle", "map", "postNotification", "removeObserver", "removeObserverForName", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EventBusImpl implements SLEventBusProvider {
    private final Context context = Salamander.INSTANCE.getApplication();
    private final Map<Object, List<Triple<String, Integer, BroadcastReceiver>>> receiversMap = new LinkedHashMap();

    /* renamed from: localBroadcastManager$delegate, reason: from kotlin metadata */
    private final Lazy localBroadcastManager = LazyKt.lazy(new Function0<LocalBroadcastManager>() { // from class: com.bytedance.salamander.adapter.EventBusImpl$localBroadcastManager$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LocalBroadcastManager m836invoke() {
            Context context;
            context = EventBusImpl.this.context;
            if (context != null) {
                return LocalBroadcastManager.getInstance(context);
            }
            return null;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalBroadcastManager getLocalBroadcastManager() {
        return (LocalBroadcastManager) this.localBroadcastManager.getValue();
    }

    @Override // com.bytedance.salamander.adapter.SLEventBusProvider
    public Object addObserverUsingBlock(final String eventName, final Function1<? super Map<String, Object>, Unit> callback, Object sender) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Integer valueOf = sender != null ? Integer.valueOf(System.identityHashCode(sender)) : null;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.bytedance.salamander.adapter.EventBusImpl$addObserverUsingBlock$receiver$1
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
            
                r2 = r4.bundleToMap(r2);
             */
            @Override // android.content.BroadcastReceiver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onReceive(Context context, Intent intent) {
                Map emptyMap;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual(intent.getAction(), eventName)) {
                    int intExtra = intent.getIntExtra("_sender_hash", -1);
                    Integer num = valueOf;
                    if (num == null || (num != null && intExtra == num.intValue())) {
                        Bundle extras = intent.getExtras();
                        if (extras == null || emptyMap == null) {
                            emptyMap = MapsKt.emptyMap();
                        }
                        Function1<Map<String, Object>, Unit> function1 = callback;
                        Intrinsics.checkNotNull(emptyMap, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>{ com.bytedance.salamander.adapter.FoundationEventbusInterfaceKt.SLEventUserInfo }");
                        function1.invoke(TypeIntrinsics.asMutableMap(emptyMap));
                    }
                }
            }
        };
        LocalBroadcastManager localBroadcastManager = getLocalBroadcastManager();
        if (localBroadcastManager != null) {
            localBroadcastManager.registerReceiver(broadcastReceiver, new IntentFilter(eventName));
        }
        if (sender == null) {
            sender = broadcastReceiver;
        }
        Map<Object, List<Triple<String, Integer, BroadcastReceiver>>> map = this.receiversMap;
        ArrayList arrayList = map.get(sender);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(sender, arrayList);
        }
        arrayList.add(new Triple<>(eventName, valueOf, broadcastReceiver));
        return sender;
    }

    @Override // com.bytedance.salamander.adapter.SLEventBusProvider
    public void addObserverUsingFunction(final String eventName, final Object observer, final String callbackName, Object sender) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(callbackName, "callbackName");
        Integer valueOf = sender != null ? Integer.valueOf(System.identityHashCode(sender)) : null;
        final Integer num = valueOf;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.bytedance.salamander.adapter.EventBusImpl$addObserverUsingFunction$receiver$1
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
            
                r7 = r5.bundleToMap(r7);
             */
            @Override // android.content.BroadcastReceiver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onReceive(Context context, Intent intent) {
                Map emptyMap;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual(intent.getAction(), eventName)) {
                    int intExtra = intent.getIntExtra("_sender_hash", -1);
                    Integer num2 = num;
                    if (num2 == null || (num2 != null && intExtra == num2.intValue())) {
                        try {
                            Method method = observer.getClass().getMethod(callbackName, Map.class);
                            Bundle extras = intent.getExtras();
                            if (extras == null || emptyMap == null) {
                                emptyMap = MapsKt.emptyMap();
                            }
                            method.invoke(observer, emptyMap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        LocalBroadcastManager localBroadcastManager = getLocalBroadcastManager();
        if (localBroadcastManager != null) {
            localBroadcastManager.registerReceiver(broadcastReceiver, new IntentFilter(eventName));
        }
        Map<Object, List<Triple<String, Integer, BroadcastReceiver>>> map = this.receiversMap;
        ArrayList arrayList = map.get(observer);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(observer, arrayList);
        }
        arrayList.add(new Triple<>(eventName, valueOf, broadcastReceiver));
    }

    @Override // com.bytedance.salamander.adapter.SLEventBusProvider
    public void removeObserverForName(final String eventName, Object observer, Object sender) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(observer, "observer");
        final Integer valueOf = sender != null ? Integer.valueOf(System.identityHashCode(sender)) : null;
        if (sender != null) {
            observer = sender;
        }
        List<Triple<String, Integer, BroadcastReceiver>> list = this.receiversMap.get(observer);
        if (list != null) {
            CollectionsKt.removeAll(list, new Function1<Triple<? extends String, ? extends Integer, ? extends BroadcastReceiver>, Boolean>() { // from class: com.bytedance.salamander.adapter.EventBusImpl$removeObserverForName$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Boolean invoke(Triple<String, Integer, ? extends BroadcastReceiver> triple) {
                    boolean z;
                    LocalBroadcastManager localBroadcastManager;
                    Intrinsics.checkNotNullParameter(triple, "<name for destructuring parameter 0>");
                    String str = (String) triple.component1();
                    Integer num = (Integer) triple.component2();
                    BroadcastReceiver broadcastReceiver = (BroadcastReceiver) triple.component3();
                    if (Intrinsics.areEqual(str, eventName) && Intrinsics.areEqual(num, valueOf)) {
                        localBroadcastManager = this.getLocalBroadcastManager();
                        if (localBroadcastManager != null) {
                            localBroadcastManager.unregisterReceiver(broadcastReceiver);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            });
        }
    }

    @Override // com.bytedance.salamander.adapter.SLEventBusProvider
    public void removeObserver(Object observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        List<Triple<String, Integer, BroadcastReceiver>> remove = this.receiversMap.remove(observer);
        if (remove != null) {
            Iterator<T> it = remove.iterator();
            while (it.hasNext()) {
                BroadcastReceiver broadcastReceiver = (BroadcastReceiver) ((Triple) it.next()).component3();
                LocalBroadcastManager localBroadcastManager = getLocalBroadcastManager();
                if (localBroadcastManager != null) {
                    localBroadcastManager.unregisterReceiver(broadcastReceiver);
                }
            }
        }
    }

    @Override // com.bytedance.salamander.adapter.SLEventBusProvider
    public void postNotification(String eventName, Map<String, Object> userInfo, Object sender) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intent intent = new Intent(eventName);
        if (sender != null) {
            intent.putExtra("_sender_hash", System.identityHashCode(sender));
        }
        intent.putExtras(mapToBundle(userInfo));
        LocalBroadcastManager localBroadcastManager = getLocalBroadcastManager();
        if (localBroadcastManager != null) {
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> bundleToMap(Bundle bundle) {
        Set<String> keySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
        Set<String> set = keySet;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set, 10)), 16));
        for (String str : set) {
            Pair pair = TuplesKt.to(str, bundle.get(str));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    private final Bundle mapToBundle(Map<String, Object> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                bundle.putString(key, (String) value);
            } else if (value instanceof Integer) {
                bundle.putInt(key, ((Number) value).intValue());
            } else if (value instanceof Boolean) {
                bundle.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Long) {
                bundle.putLong(key, ((Number) value).longValue());
            } else if (value instanceof Float) {
                bundle.putFloat(key, ((Number) value).floatValue());
            } else if (value instanceof Double) {
                bundle.putDouble(key, ((Number) value).doubleValue());
            } else if (value instanceof Bundle) {
                bundle.putBundle(key, (Bundle) value);
            } else {
                bundle.putString(key, value.toString());
            }
        }
        return bundle;
    }
}
