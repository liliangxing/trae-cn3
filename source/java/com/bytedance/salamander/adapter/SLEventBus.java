package com.bytedance.salamander.adapter;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FoundationEventbus.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\b\u0016¢\u0006\u0002\u0010\u0002Jd\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00072D\u0010\b\u001a@\u00122\u00120\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\nj\u0011`\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0016J,\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0016J4\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\nj\u0002`\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0001H\u0016J$\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/salamander/adapter/SLEventBus;", "", "()V", "mProvider", "Lcom/bytedance/salamander/adapter/EventBusImpl;", "addObserverUsingBlock", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "callback", "Lkotlin/Function1;", "", "Lcom/bytedance/salamander/adapter/SLEventUserInfo;", "Lkotlin/ParameterName;", "name", "userInfo", "", "Lcom/bytedance/salamander/adapter/SLEventCallback;", "sender", "addObserverUsingFunction", "observer", "callbackName", "postNotification", "removeObserver", "removeObserverForName", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SLEventBus {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static SLEventBus instance;
    private EventBusImpl mProvider = new EventBusImpl();

    public static /* synthetic */ Object addObserverUsingBlock$default(SLEventBus sLEventBus, String str, Function1 function1, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addObserverUsingBlock");
        }
        if ((i & 4) != 0) {
            obj = null;
        }
        return sLEventBus.addObserverUsingBlock(str, function1, obj);
    }

    public Object addObserverUsingBlock(String eventName, Function1<? super Map<String, Object>, Unit> callback, Object sender) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (eventName.length() <= 0) {
            return null;
        }
        return this.mProvider.addObserverUsingBlock(eventName, callback, sender);
    }

    public static /* synthetic */ void addObserverUsingFunction$default(SLEventBus sLEventBus, String str, Object obj, String str2, Object obj2, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addObserverUsingFunction");
        }
        if ((i & 8) != 0) {
            obj2 = null;
        }
        sLEventBus.addObserverUsingFunction(str, obj, str2, obj2);
    }

    public void addObserverUsingFunction(String eventName, Object observer, String callbackName, Object sender) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(callbackName, "callbackName");
        if (eventName.length() <= 0) {
            return;
        }
        this.mProvider.addObserverUsingFunction(eventName, observer, callbackName, sender);
    }

    public static /* synthetic */ void removeObserverForName$default(SLEventBus sLEventBus, String str, Object obj, Object obj2, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeObserverForName");
        }
        if ((i & 4) != 0) {
            obj2 = null;
        }
        sLEventBus.removeObserverForName(str, obj, obj2);
    }

    public void removeObserverForName(String eventName, Object observer, Object sender) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (eventName.length() <= 0) {
            return;
        }
        this.mProvider.removeObserverForName(eventName, observer, sender);
    }

    public void removeObserver(Object observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mProvider.removeObserver(observer);
    }

    public static /* synthetic */ void postNotification$default(SLEventBus sLEventBus, String str, Map map, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postNotification");
        }
        if ((i & 4) != 0) {
            obj = null;
        }
        sLEventBus.postNotification(str, map, obj);
    }

    public void postNotification(String eventName, Map<String, Object> userInfo, Object sender) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        if (eventName.length() <= 0) {
            return;
        }
        this.mProvider.postNotification(eventName, userInfo, sender);
    }

    /* compiled from: FoundationEventbus.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/salamander/adapter/SLEventBus$Companion;", "", "()V", "instance", "Lcom/bytedance/salamander/adapter/SLEventBus;", "getInstance", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public SLEventBus getInstance() {
            if (SLEventBus.instance == null) {
                Companion companion = SLEventBus.INSTANCE;
                SLEventBus.instance = new SLEventBus();
            }
            SLEventBus sLEventBus = SLEventBus.instance;
            Intrinsics.checkNotNull(sLEventBus);
            return sLEventBus;
        }
    }
}
