package com.bytedance.monitor.collector.service;

import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class ServiceFollowBean {
    public static final int BIND_SERVICE = 121;
    public static final int CREATE_SERVICE = 114;
    public static final int DUMP_SERVICE = 123;
    public static final int SERVICE_ARGS = 115;
    public static final int STOP_SERVICE = 116;
    public static final int UNBIND_SERVICE = 122;
    private static Field mFieldBindServiceDataToken;
    private static Field mFieldCreateServiceDataToken;
    private static Field mFieldCreateServiceInfo;
    private static Field mFieldDumpComponentInfoToken;
    private static Field mFieldServiceArgsDataToken;
    private static Field mFieldUnBindServiceDataToken;
    public String mServiceName;
    public String mThreadName;
    public long mTimeStamp;
    public String mToken;
    public int mWhat;

    public ServiceFollowBean() {
    }

    public ServiceFollowBean(String str, int i, long j, String str2) {
        this.mServiceName = str;
        this.mWhat = i;
        this.mTimeStamp = j;
        this.mToken = str2;
        this.mThreadName = Thread.currentThread().getName();
    }

    public static ServiceFollowBean fetchServiceName(Message message) {
        try {
            switch (message.what) {
                case 114:
                    if (mFieldCreateServiceInfo == null) {
                        mFieldCreateServiceInfo = DoubleReflectHelper.getField(message.obj.getClass(), "info");
                    }
                    if (mFieldCreateServiceDataToken == null) {
                        mFieldCreateServiceDataToken = DoubleReflectHelper.getField(message.obj.getClass(), "token");
                    }
                    ServiceInfo serviceInfo = (ServiceInfo) mFieldCreateServiceInfo.get(message.obj);
                    return new ServiceFollowBean(serviceInfo != null ? serviceInfo.name : null, message.what, System.currentTimeMillis(), mFieldCreateServiceDataToken.get(message.obj).toString());
                case 115:
                    if (mFieldServiceArgsDataToken == null) {
                        mFieldServiceArgsDataToken = DoubleReflectHelper.getField(message.obj.getClass(), "token");
                    }
                    IBinder iBinder = (IBinder) mFieldServiceArgsDataToken.get(message.obj);
                    if (iBinder != null) {
                        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(iBinder), message.what, System.currentTimeMillis(), iBinder.toString());
                    }
                    break;
                case 116:
                    return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName((IBinder) message.obj), message.what, System.currentTimeMillis(), message.obj.toString());
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
                        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(iBinder2), message.what, System.currentTimeMillis(), iBinder2.toString());
                    }
                    break;
                case 122:
                    if (mFieldUnBindServiceDataToken == null) {
                        mFieldUnBindServiceDataToken = DoubleReflectHelper.getField(message.obj.getClass(), "token");
                    }
                    IBinder iBinder3 = (IBinder) mFieldUnBindServiceDataToken.get(message.obj);
                    if (iBinder3 != null) {
                        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(iBinder3), message.what, System.currentTimeMillis(), iBinder3.toString());
                    }
                    break;
                case 123:
                    if (mFieldDumpComponentInfoToken == null) {
                        mFieldDumpComponentInfoToken = DoubleReflectHelper.getField(message.obj.getClass(), "token");
                    }
                    IBinder iBinder4 = (IBinder) mFieldDumpComponentInfoToken.get(message.obj);
                    if (iBinder4 != null) {
                        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(iBinder4), message.what, System.currentTimeMillis(), iBinder4.toString());
                    }
                    break;
            }
        } catch (Throwable unused) {
        }
        return new ServiceFollowBean("unknow", message.what, System.currentTimeMillis(), "unknow");
    }

    public String toString() {
        return "ServiceFollowBean{mServiceName='" + this.mServiceName + "', mWhat=" + this.mWhat + ", mTimeStamp=" + this.mTimeStamp + ", mToken='" + this.mToken + "', mThreadName='" + this.mThreadName + "'}";
    }
}
