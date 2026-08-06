package com.bytedance.platform.horae.java_impl;

import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Message;
import com.bytedance.platform.horae.common.DoubleReflectHelper;
import com.bytedance.platform.horae.common.Logger;
import com.bytedance.platform.horae.java_impl.sync.SyncServiceTrackMonitor;
import java.lang.reflect.Field;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class ServiceFollowBean {
    public static final int BIND_SERVICE = 121;
    public static final int CREATE_SERVICE = 114;
    public static final int DUMP_SERVICE = 123;
    public static final int RECEIVER = 113;
    public static final int SERVICE_ARGS = 115;
    public static final int STOP_SERVICE = 116;
    public static final int UNBIND_SERVICE = 122;
    private static Field mFieldBindServiceDataToken;
    private static Field mFieldCreateServiceDataToken;
    private static Field mFieldCreateServiceInfo;
    private static Field mFieldDumpComponentInfoToken;
    private static Field mFieldServiceArgsDataToken;
    private static Field mFieldUnBindServiceDataToken;
    private static Field mIntentFieldInReceiver;
    private int mHandleFlag;
    public String mServiceName;
    private String mThreadName = Thread.currentThread().getName();
    private long mTimeStamp;
    public String mToken;
    private int mWhat;

    public ServiceFollowBean(String str, int i, long j, String str2, int i2) {
        this.mServiceName = str;
        this.mWhat = i;
        this.mTimeStamp = j;
        this.mToken = str2;
        this.mHandleFlag = i2;
    }

    public static ServiceFollowBean fetchServiceName(Message message) {
        try {
            switch (message.what) {
                case 113:
                    Object obj = message.obj;
                    if (mIntentFieldInReceiver == null) {
                        mIntentFieldInReceiver = DoubleReflectHelper.getField(obj.getClass(), "intent");
                    }
                    Intent intent = (Intent) mIntentFieldInReceiver.get(obj);
                    if (intent != null) {
                        Logger.e("c_receiver", intent.getComponent().getClassName());
                        return new ServiceFollowBean(intent.getComponent().getClassName(), message.what, System.currentTimeMillis(), "null", 0);
                    }
                    break;
                case 114:
                    if (mFieldCreateServiceInfo == null) {
                        mFieldCreateServiceInfo = DoubleReflectHelper.getField(message.obj.getClass(), "info");
                    }
                    if (mFieldCreateServiceDataToken == null) {
                        mFieldCreateServiceDataToken = DoubleReflectHelper.getField(message.obj.getClass(), "token");
                    }
                    ServiceInfo serviceInfo = (ServiceInfo) mFieldCreateServiceInfo.get(message.obj);
                    return new ServiceFollowBean(serviceInfo != null ? serviceInfo.name : null, message.what, System.currentTimeMillis(), mFieldCreateServiceDataToken.get(message.obj).toString(), message.arg2);
                case 115:
                    if (mFieldServiceArgsDataToken == null) {
                        mFieldServiceArgsDataToken = DoubleReflectHelper.getField(message.obj.getClass(), "token");
                    }
                    IBinder iBinder = (IBinder) mFieldServiceArgsDataToken.get(message.obj);
                    if (iBinder != null) {
                        return new ServiceFollowBean(SyncServiceTrackMonitor.getInstance().getServiceComponentName(iBinder), message.what, System.currentTimeMillis(), iBinder.toString(), message.arg2);
                    }
                    break;
                case 116:
                    return new ServiceFollowBean(SyncServiceTrackMonitor.getInstance().getServiceComponentName((IBinder) message.obj), message.what, System.currentTimeMillis(), message.obj.toString(), message.arg2);
                case 117:
                case 118:
                case 119:
                case 120:
                default:
                    throw new IllegalArgumentException("message.what = " + message.what + " is not excepted!");
                case 121:
                    if (mFieldBindServiceDataToken == null) {
                        mFieldBindServiceDataToken = DoubleReflectHelper.getField(message.obj.getClass(), "token");
                    }
                    IBinder iBinder2 = (IBinder) mFieldBindServiceDataToken.get(message.obj);
                    if (iBinder2 != null) {
                        return new ServiceFollowBean(SyncServiceTrackMonitor.getInstance().getServiceComponentName(iBinder2), message.what, System.currentTimeMillis(), iBinder2.toString(), message.arg2);
                    }
                    break;
                case 122:
                    if (mFieldUnBindServiceDataToken == null) {
                        mFieldUnBindServiceDataToken = DoubleReflectHelper.getField(message.obj.getClass(), "token");
                    }
                    IBinder iBinder3 = (IBinder) mFieldUnBindServiceDataToken.get(message.obj);
                    if (iBinder3 != null) {
                        return new ServiceFollowBean(SyncServiceTrackMonitor.getInstance().getServiceComponentName(iBinder3), message.what, System.currentTimeMillis(), iBinder3.toString(), message.arg2);
                    }
                    break;
                case 123:
                    if (mFieldDumpComponentInfoToken == null) {
                        mFieldDumpComponentInfoToken = DoubleReflectHelper.getField(message.obj.getClass(), "token");
                    }
                    IBinder iBinder4 = (IBinder) mFieldDumpComponentInfoToken.get(message.obj);
                    if (iBinder4 != null) {
                        return new ServiceFollowBean(SyncServiceTrackMonitor.getInstance().getServiceComponentName(iBinder4), message.what, System.currentTimeMillis(), iBinder4.toString(), message.arg2);
                    }
                    break;
            }
        } catch (Throwable unused) {
        }
        return new ServiceFollowBean("unknow", message.what, System.currentTimeMillis(), "unknow", message.arg2);
    }

    public String toString() {
        String str;
        int i = this.mHandleFlag;
        if (i == 0) {
            str = "Not_Followed";
        } else if (i == 9527) {
            str = "System";
        } else {
            str = i == 9528 ? "Schedule" : "Error:" + this.mHandleFlag;
        }
        return "ServiceFollowBean{mServiceName='" + this.mServiceName + "', mWhat=" + this.mWhat + ", mTimeStamp=" + this.mTimeStamp + ", mToken='" + this.mToken + "', mThreadName='" + this.mThreadName + "', mHandleFlag=" + str + AbstractJsonLexerKt.END_OBJ;
    }
}
