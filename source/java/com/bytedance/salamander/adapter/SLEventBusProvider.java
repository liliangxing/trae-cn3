package com.bytedance.salamander.adapter;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: FoundationEventbusInterface.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001Jd\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042D\u0010\u0005\u001a@\u00122\u00120\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0007j\u0011`\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006j\u0002`\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001H&J,\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001H&J4\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0007j\u0002`\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001H&J$\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/salamander/adapter/SLEventBusProvider;", "", "addObserverUsingBlock", SchemaConstants.INNER_PARAM_EVENT_NAME, "", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "", "Lcom/bytedance/salamander/adapter/SLEventUserInfo;", "Lkotlin/ParameterName;", "name", "userInfo", "", "Lcom/bytedance/salamander/adapter/SLEventCallback;", "sender", "addObserverUsingFunction", "observer", "callbackName", "postNotification", "removeObserver", "removeObserverForName", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface SLEventBusProvider {
    Object addObserverUsingBlock(String eventName, Function1<? super Map<String, Object>, Unit> callback, Object sender);

    void addObserverUsingFunction(String eventName, Object observer, String callbackName, Object sender);

    void postNotification(String eventName, Map<String, Object> userInfo, Object sender);

    void removeObserver(Object observer);

    void removeObserverForName(String eventName, Object observer, Object sender);

    /* compiled from: FoundationEventbusInterface.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object addObserverUsingBlock$default(SLEventBusProvider sLEventBusProvider, String str, Function1 function1, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addObserverUsingBlock");
            }
            if ((i & 4) != 0) {
                obj = null;
            }
            return sLEventBusProvider.addObserverUsingBlock(str, function1, obj);
        }

        public static /* synthetic */ void addObserverUsingFunction$default(SLEventBusProvider sLEventBusProvider, String str, Object obj, String str2, Object obj2, int i, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addObserverUsingFunction");
            }
            if ((i & 8) != 0) {
                obj2 = null;
            }
            sLEventBusProvider.addObserverUsingFunction(str, obj, str2, obj2);
        }

        public static /* synthetic */ void removeObserverForName$default(SLEventBusProvider sLEventBusProvider, String str, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeObserverForName");
            }
            if ((i & 4) != 0) {
                obj2 = null;
            }
            sLEventBusProvider.removeObserverForName(str, obj, obj2);
        }

        public static /* synthetic */ void postNotification$default(SLEventBusProvider sLEventBusProvider, String str, Map map, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postNotification");
            }
            if ((i & 4) != 0) {
                obj = null;
            }
            sLEventBusProvider.postNotification(str, map, obj);
        }
    }
}
