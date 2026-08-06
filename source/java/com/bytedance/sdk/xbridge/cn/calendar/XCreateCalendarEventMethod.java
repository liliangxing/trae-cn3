package com.bytedance.sdk.xbridge.cn.calendar;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CalendarContract;
import bolts.Continuation;
import bolts.Task;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.calendar.AbsXCreateCalendarEventMethodIDL;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.CalendarCreateReducer;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.CalendarUpdateReducer;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.CalendarEventRecord;
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
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XCreateCalendarEventMethod.kt */
@XBridgeMethod(name = "x.createCalendarEvent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002J&\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J&\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J&\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/XCreateCalendarEventMethod;", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL;", "()V", "TAG", "", "createAction", "", "params", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL$XCreateCalendarEventParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL$XCreateCalendarEventResultModel;", "contentResolver", "Landroid/content/ContentResolver;", "dispatchAction", "getCalendarDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCalendarDepend;", "handle", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "isExistEvent", "", "updateAction", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XCreateCalendarEventMethod extends AbsXCreateCalendarEventMethodIDL {
    private final String TAG = "[XCreateCalendarEventMethod]";

    private final IHostCalendarDepend getCalendarDependInstance() {
        return XBaseRuntime.INSTANCE.getHostCalendarDepend();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchAction(final AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventParamModel params, final CompletionBlock<AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventResultModel> callback, final ContentResolver contentResolver) {
        Task.callInBackground(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XCreateCalendarEventMethod$dispatchAction$1
            @Override // java.util.concurrent.Callable
            public final Boolean call() {
                boolean isExistEvent;
                isExistEvent = XCreateCalendarEventMethod.this.isExistEvent(params, contentResolver);
                return Boolean.valueOf(isExistEvent);
            }
        }).continueWith(new Continuation() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XCreateCalendarEventMethod$dispatchAction$2
            public /* bridge */ /* synthetic */ Object then(Task task) {
                m893then((Task<Boolean>) task);
                return Unit.INSTANCE;
            }

            /* renamed from: then, reason: collision with other method in class */
            public final void m893then(Task<Boolean> task) {
                if (task.isFaulted()) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "read calender failed. id = " + params.getIdentifier() + " , error msg = " + task.getError().getMessage(), null, 4, null);
                    return;
                }
                Boolean bool = (Boolean) task.getResult();
                if (Intrinsics.areEqual(bool, true)) {
                    this.updateAction(params, callback, contentResolver);
                } else if (Intrinsics.areEqual(bool, false)) {
                    this.createAction(params, callback, contentResolver);
                }
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isExistEvent(AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventParamModel params, ContentResolver contentResolver) {
        Cursor query = contentResolver.query(CalendarContract.Events.CONTENT_URI, new String[]{ReducerConstants.EVENT_ID_COLUMN}, "sync_data1=?", new String[]{params.getIdentifier()}, null);
        if (query == null) {
            return false;
        }
        Cursor cursor = query;
        try {
            boolean z = cursor.getCount() > 0;
            CloseableKt.closeFinally(cursor, (Throwable) null);
            return z;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createAction(final AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventParamModel params, final CompletionBlock<AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventResultModel> callback, final ContentResolver contentResolver) {
        Task.callInBackground(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XCreateCalendarEventMethod$createAction$1
            @Override // java.util.concurrent.Callable
            public final CalendarErrorCode call() {
                return CalendarCreateReducer.INSTANCE.createCalendar(AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventParamModel.this, contentResolver);
            }
        }).continueWith(new Continuation() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XCreateCalendarEventMethod$createAction$2
            public /* bridge */ /* synthetic */ Object then(Task task) {
                m892then((Task<CalendarErrorCode>) task);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: then, reason: collision with other method in class */
            public final void m892then(Task<CalendarErrorCode> task) {
                if (task.isFaulted()) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, CalendarErrorCode.Unknown.getValue(), "create calendar failed with unknown error, error msg = " + task.getError().getMessage(), null, 4, null);
                    return;
                }
                CalendarErrorCode calendarErrorCode = (CalendarErrorCode) task.getResult();
                if (calendarErrorCode == CalendarErrorCode.Success) {
                    callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventResultModel.class)), "create calendar success!");
                } else {
                    XBridge.log("create calendar failed!");
                    CompletionBlock.DefaultImpls.onFailure$default(callback, calendarErrorCode.getValue(), "create calendar failed!", null, 4, null);
                }
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAction(final AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventParamModel params, final CompletionBlock<AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventResultModel> callback, final ContentResolver contentResolver) {
        Task.callInBackground(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XCreateCalendarEventMethod$updateAction$1
            @Override // java.util.concurrent.Callable
            public final CalendarErrorCode call() {
                return CalendarUpdateReducer.INSTANCE.updateCalendar(AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventParamModel.this, contentResolver);
            }
        }).continueWith(new Continuation() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XCreateCalendarEventMethod$updateAction$2
            public /* bridge */ /* synthetic */ Object then(Task task) {
                m894then((Task<CalendarErrorCode>) task);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: then, reason: collision with other method in class */
            public final void m894then(Task<CalendarErrorCode> task) {
                if (task.isFaulted()) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, CalendarErrorCode.Failed.getValue(), "delete calendar event failed. error msg = " + task.getError().getMessage() + ", request id = " + params.getIdentifier(), null, 4, null);
                    return;
                }
                CalendarErrorCode calendarErrorCode = (CalendarErrorCode) task.getResult();
                if (calendarErrorCode.getValue() == CalendarErrorCode.Success.getValue()) {
                    callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventResultModel.class)), "update success");
                } else {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, calendarErrorCode.getValue(), "update failed.", null, 4, null);
                }
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0161  */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(IBDXBridgeContext bridgeContext, final AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventParamModel params, final CompletionBlock<AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventResultModel> callback) {
        boolean z;
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
        if (!Intrinsics.areEqual(params.getRepeatCount(), -1) && !Intrinsics.areEqual(params.getRepeatInterval(), -1)) {
            if (params.getRepeatFrequency().length() > 0) {
                z = true;
                if (getCalendarDependInstance() == null) {
                    String title = params.getTitle();
                    String str = title == null ? "" : title;
                    String notes = params.getNotes();
                    String str2 = notes == null ? "" : notes;
                    long longValue = params.getStartDate().longValue();
                    long longValue2 = params.getEndDate().longValue();
                    Number alarmOffset = params.getAlarmOffset();
                    if (alarmOffset == null) {
                        alarmOffset = (Number) 0;
                    }
                    Integer valueOf = Integer.valueOf(alarmOffset.intValue() / 60000);
                    String identifier = params.getIdentifier();
                    String url = params.getUrl();
                    String str3 = url == null ? "" : url;
                    String location = params.getLocation();
                    String str4 = location == null ? "" : location;
                    Boolean allDay = params.getAllDay();
                    CalendarEventRecord calendarEventRecord = new CalendarEventRecord(str, str2, longValue, longValue2, valueOf, identifier, str3, str4, allDay != null ? allDay.booleanValue() : false, z, CollectionsKt.emptyList(), params.getRepeatFrequency(), Integer.valueOf(params.getRepeatInterval().intValue()), Integer.valueOf(params.getRepeatCount().intValue()));
                    IHostCalendarEventCallback iHostCalendarEventCallback = new IHostCalendarEventCallback() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XCreateCalendarEventMethod$handle$calendarEventCallback$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarEventCallback
                        public void onResult(boolean success, int errCode, String msg) {
                            Intrinsics.checkNotNullParameter(msg, "msg");
                            if (success) {
                                callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventResultModel.class)), "create calendar success!");
                            } else {
                                CompletionBlock.DefaultImpls.onFailure$default(callback, errCode, msg, null, 4, null);
                            }
                        }
                    };
                    HybridLogger.i$default(HybridLogger.INSTANCE, this.TAG, "getCalendarDependInstance()?.insertOrUpdate...", (Map) null, (LoggerContext) null, 12, (Object) null);
                    IHostCalendarDepend calendarDependInstance = getCalendarDependInstance();
                    if (calendarDependInstance != null) {
                        calendarDependInstance.insertOrUpdate(bridgeContext, calendarEventRecord, iHostCalendarEventCallback);
                        return;
                    }
                    return;
                }
                String[] strArr = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
                IHostPermissionDepend permissionDependInstance = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
                if (permissionDependInstance != null) {
                    Activity activity = ownerActivity;
                    if (permissionDependInstance.isPermissionAllGranted(activity, (String[]) Arrays.copyOf(strArr, 2))) {
                        dispatchAction(params, callback, contentResolver);
                        return;
                    }
                    Activity activity2 = XBridgeMethodHelper.INSTANCE.getActivity(activity);
                    if (activity2 != null) {
                        permissionDependInstance.requestPermission(activity2, bridgeContext, getName(), (String[]) Arrays.copyOf(strArr, 2), new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.calendar.XCreateCalendarEventMethod$handle$1$1$1
                            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                            public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                                Intrinsics.checkNotNullParameter(result, "result");
                                if (allGranted) {
                                    XCreateCalendarEventMethod xCreateCalendarEventMethod = XCreateCalendarEventMethod.this;
                                    AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventParamModel xCreateCalendarEventParamModel = params;
                                    CompletionBlock<AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventResultModel> completionBlock = callback;
                                    ContentResolver contentResolver2 = contentResolver;
                                    Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                                    xCreateCalendarEventMethod.dispatchAction(xCreateCalendarEventParamModel, completionBlock, contentResolver2);
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
                        return;
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (getCalendarDependInstance() == null) {
        }
    }
}
