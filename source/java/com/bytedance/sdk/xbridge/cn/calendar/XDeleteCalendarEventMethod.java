package com.bytedance.sdk.xbridge.cn.calendar;

import android.app.Activity;
import android.content.ContentResolver;
import bolts.Continuation;
import bolts.Task;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.calendar.AbsXDeleteCalendarEventMethodIDL;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.CalendarRemoveReducer;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarEventCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XDeleteCalendarEventMethod.kt */
@XBridgeMethod(name = "x.deleteCalendarEvent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/XDeleteCalendarEventMethod;", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXDeleteCalendarEventMethodIDL;", "()V", "TAG", "", "deleteAction", "", "params", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXDeleteCalendarEventMethodIDL$XDeleteCalendarEventParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXDeleteCalendarEventMethodIDL$XDeleteCalendarEventResultModel;", "contentResolver", "Landroid/content/ContentResolver;", "getCalendarDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCalendarDepend;", "handle", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XDeleteCalendarEventMethod extends AbsXDeleteCalendarEventMethodIDL {
    private final String TAG = "[XDeleteCalendarEventMethod]";

    private final IHostCalendarDepend getCalendarDependInstance() {
        return XBaseRuntime.INSTANCE.getHostCalendarDepend();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteAction(final AbsXDeleteCalendarEventMethodIDL.XDeleteCalendarEventParamModel params, final CompletionBlock<AbsXDeleteCalendarEventMethodIDL.XDeleteCalendarEventResultModel> callback, final ContentResolver contentResolver) {
        Task.callInBackground(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XDeleteCalendarEventMethod$deleteAction$1
            @Override // java.util.concurrent.Callable
            public final CalendarErrorCode call() {
                return CalendarRemoveReducer.INSTANCE.deleteCalendar(AbsXDeleteCalendarEventMethodIDL.XDeleteCalendarEventParamModel.this, contentResolver);
            }
        }).continueWith(new Continuation() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XDeleteCalendarEventMethod$deleteAction$2
            public /* bridge */ /* synthetic */ Object then(Task task) {
                m895then((Task<CalendarErrorCode>) task);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: then, reason: collision with other method in class */
            public final void m895then(Task<CalendarErrorCode> task) {
                if (task.isFaulted()) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "delete calendar with unknown failure. id = " + params.getIdentifier() + " , error msg = " + task.getError().getMessage(), null, 4, null);
                    return;
                }
                CalendarErrorCode calendarErrorCode = (CalendarErrorCode) task.getResult();
                if (calendarErrorCode.getValue() == CalendarErrorCode.Success.getValue()) {
                    callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXDeleteCalendarEventMethodIDL.XDeleteCalendarEventResultModel.class)), "delete Success");
                } else {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, calendarErrorCode.getValue(), "delete failed.", null, 4, null);
                }
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, final AbsXDeleteCalendarEventMethodIDL.XDeleteCalendarEventParamModel params, final CompletionBlock<AbsXDeleteCalendarEventMethodIDL.XDeleteCalendarEventResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            XBridge.log("try to obtain context, but got a null.");
            CompletionBlock.DefaultImpls.onFailure$default(callback, CalendarErrorCode.Failed.getValue(), "try to obtain context, but got a null.", null, 4, null);
            return;
        }
        final ContentResolver contentResolver = ownerActivity.getContentResolver();
        if (contentResolver == null) {
            XBridge.log("try to obtain contentResolver, but got a null");
            CompletionBlock.DefaultImpls.onFailure$default(callback, CalendarErrorCode.Failed.getValue(), "try to obtain contentResolver, but got a null", null, 4, null);
            return;
        }
        if (params.getIdentifier().length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "identifier can not be empty.", null, 4, null);
        }
        if (getCalendarDependInstance() != null) {
            HybridLogger.i$default(HybridLogger.INSTANCE, this.TAG, "getCalendarDependInstance()?.deleteEvent...", (Map) null, (LoggerContext) null, 12, (Object) null);
            IHostCalendarDepend calendarDependInstance = getCalendarDependInstance();
            if (calendarDependInstance != null) {
                calendarDependInstance.deleteEvent(bridgeContext, params.getIdentifier(), new IHostCalendarEventCallback() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XDeleteCalendarEventMethod$handle$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarEventCallback
                    public void onResult(boolean success, int errCode, String msg) {
                        Intrinsics.checkNotNullParameter(msg, "msg");
                        if (success) {
                            callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXDeleteCalendarEventMethodIDL.XDeleteCalendarEventResultModel.class)), "delete Success");
                        } else {
                            CompletionBlock.DefaultImpls.onFailure$default(callback, errCode, msg, null, 4, null);
                        }
                    }
                });
                return;
            }
            return;
        }
        String[] strArr = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        IHostPermissionDepend permissionDependInstance = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
        if (permissionDependInstance != null) {
            Activity activity = ownerActivity;
            if (permissionDependInstance.isPermissionAllGranted(activity, (String[]) Arrays.copyOf(strArr, 2))) {
                deleteAction(params, callback, contentResolver);
                return;
            }
            Activity activity2 = XBridgeMethodHelper.INSTANCE.getActivity(activity);
            if (activity2 != null) {
                permissionDependInstance.requestPermission(activity2, bridgeContext, getName(), (String[]) Arrays.copyOf(strArr, 2), new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XDeleteCalendarEventMethod$handle$2$1$1
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                    public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        if (allGranted) {
                            XDeleteCalendarEventMethod xDeleteCalendarEventMethod = XDeleteCalendarEventMethod.this;
                            AbsXDeleteCalendarEventMethodIDL.XDeleteCalendarEventParamModel xDeleteCalendarEventParamModel = params;
                            CompletionBlock<AbsXDeleteCalendarEventMethodIDL.XDeleteCalendarEventResultModel> completionBlock = callback;
                            ContentResolver contentResolver2 = contentResolver;
                            Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                            xDeleteCalendarEventMethod.deleteAction(xDeleteCalendarEventParamModel, completionBlock, contentResolver2);
                            return;
                        }
                        if (!hasRejectedPermission(result)) {
                            XBridge.log("user denied permission");
                            CompletionBlock.DefaultImpls.onFailure$default(callback, CalendarErrorCode.UserDenied.getValue(), "user denied permission", null, 4, null);
                        } else {
                            XBridge.log("user rejected permission");
                            CompletionBlock.DefaultImpls.onFailure$default(callback, CalendarErrorCode.UserRejected.getValue(), "user rejected permission", null, 4, null);
                        }
                    }

                    public final boolean hasRejectedPermission(Map<String, ? extends PermissionState> result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        Iterator<T> it = result.values().iterator();
                        while (it.hasNext()) {
                            if (((PermissionState) it.next()) == PermissionState.REJECTED) {
                                return true;
                            }
                        }
                        return false;
                    }
                });
            }
        }
    }
}
