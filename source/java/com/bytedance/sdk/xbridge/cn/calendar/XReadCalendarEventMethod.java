package com.bytedance.sdk.xbridge.cn.calendar;

import android.app.Activity;
import android.content.ContentResolver;
import bolts.Continuation;
import bolts.Task;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.calendar.AbsXReadCalendarEventMethodIDL;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.CalendarReadReducer;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.CalendarEventRecord;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XReadCalendarEventMethod.kt */
@XBridgeMethod(name = "x.readCalendarEvent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J&\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/XReadCalendarEventMethod;", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXReadCalendarEventMethodIDL;", "()V", "TAG", "", "getCalendarDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCalendarDepend;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXReadCalendarEventMethodIDL$XReadCalendarEventParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXReadCalendarEventMethodIDL$XReadCalendarEventResultModel;", "readAction", "contentResolver", "Landroid/content/ContentResolver;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XReadCalendarEventMethod extends AbsXReadCalendarEventMethodIDL {
    private final String TAG = "[XReadCalendarEventMethod]";

    private final IHostCalendarDepend getCalendarDependInstance() {
        return XBaseRuntime.INSTANCE.getHostCalendarDepend();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void readAction(final AbsXReadCalendarEventMethodIDL.XReadCalendarEventParamModel params, final CompletionBlock<AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel> callback, final ContentResolver contentResolver) {
        Task.callInBackground(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XReadCalendarEventMethod$readAction$1
            @Override // java.util.concurrent.Callable
            public final AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel call() {
                return CalendarReadReducer.INSTANCE.readCalendar(AbsXReadCalendarEventMethodIDL.XReadCalendarEventParamModel.this, contentResolver);
            }
        }).continueWith(new Continuation() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XReadCalendarEventMethod$readAction$2
            public /* bridge */ /* synthetic */ Object then(Task task) {
                m896then((Task<AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel>) task);
                return Unit.INSTANCE;
            }

            /* renamed from: then, reason: collision with other method in class */
            public final void m896then(Task<AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel> task) {
                if (task.isFaulted()) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, CalendarErrorCode.NotFound.getValue(), "read calendar with a failure operation. error msg = " + task.getError().getMessage(), null, 4, null);
                    return;
                }
                AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel xReadCalendarEventResultModel = (AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel) task.getResult();
                if (xReadCalendarEventResultModel == null) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, CalendarErrorCode.NotFound.getValue(), "read calendar but got a null.", null, 4, null);
                } else {
                    callback.onSuccess(xReadCalendarEventResultModel, "read success");
                }
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, final AbsXReadCalendarEventMethodIDL.XReadCalendarEventParamModel params, final CompletionBlock<AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            XBridge.log("try to obtain context, but got a null.");
            CompletionBlock.DefaultImpls.onFailure$default(callback, CalendarErrorCode.Failed.getValue(), "try to obtain context, but got a null.", null, 4, null);
            return;
        }
        if (params.getIdentifier().length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "identifier can not be empty.", null, 4, null);
        }
        final ContentResolver contentResolver = ownerActivity.getContentResolver();
        if (contentResolver == null) {
            XBridge.log("try to obtain contentResolver, but got a null");
            CompletionBlock.DefaultImpls.onFailure$default(callback, CalendarErrorCode.Failed.getValue(), "try to obtain contentResolver, but got a null", null, 4, null);
            return;
        }
        if (getCalendarDependInstance() != null) {
            IHostCalendarDepend calendarDependInstance = getCalendarDependInstance();
            CalendarEventRecord readEvent = calendarDependInstance != null ? calendarDependInstance.readEvent(bridgeContext, params.getIdentifier()) : null;
            HybridLogger.i$default(HybridLogger.INSTANCE, this.TAG, "getCalendarDependInstance()?.readEvent...", (Map) null, (LoggerContext) null, 12, (Object) null);
            if (readEvent != null) {
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel.class));
                AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel xReadCalendarEventResultModel = (AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel) createXModel;
                Integer alarmMinutes = readEvent.getAlarmMinutes();
                xReadCalendarEventResultModel.setAlarmOffset(Integer.valueOf((alarmMinutes != null ? alarmMinutes.intValue() : 0) * 60000));
                xReadCalendarEventResultModel.setStartDate(Long.valueOf(readEvent.getStartTime()));
                xReadCalendarEventResultModel.setEndDate(Long.valueOf(readEvent.getEndTime()));
                xReadCalendarEventResultModel.setTitle(readEvent.getTitle());
                xReadCalendarEventResultModel.setNotes(readEvent.getDescription());
                xReadCalendarEventResultModel.setLocation(readEvent.getLocation());
                xReadCalendarEventResultModel.setUrl(readEvent.getAppUrl());
                callback.onSuccess((XBaseResultModel) createXModel, "read success");
                return;
            }
            CompletionBlock.DefaultImpls.onFailure$default(callback, CalendarErrorCode.NotFound.getValue(), "read calendar but got a null.", null, 4, null);
            return;
        }
        IHostPermissionDepend permissionDependInstance = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
        if (permissionDependInstance != null) {
            Activity activity = ownerActivity;
            if (permissionDependInstance.isPermissionAllGranted(activity, "android.permission.READ_CALENDAR")) {
                readAction(params, callback, contentResolver);
                return;
            }
            Activity activity2 = XBridgeMethodHelper.INSTANCE.getActivity(activity);
            if (activity2 != null) {
                permissionDependInstance.requestPermission(activity2, bridgeContext, getName(), new String[]{"android.permission.READ_CALENDAR"}, new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XReadCalendarEventMethod$handle$2$1$1
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                    public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        if (allGranted) {
                            XReadCalendarEventMethod xReadCalendarEventMethod = XReadCalendarEventMethod.this;
                            AbsXReadCalendarEventMethodIDL.XReadCalendarEventParamModel xReadCalendarEventParamModel = params;
                            CompletionBlock<AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel> completionBlock = callback;
                            ContentResolver contentResolver2 = contentResolver;
                            Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                            xReadCalendarEventMethod.readAction(xReadCalendarEventParamModel, completionBlock, contentResolver2);
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
