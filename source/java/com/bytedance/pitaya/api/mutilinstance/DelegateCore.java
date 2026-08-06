package com.bytedance.pitaya.api.mutilinstance;

import android.content.Context;
import com.bytedance.pitaya.api.IPitayaCore;
import com.bytedance.pitaya.api.PTYMessageHandler;
import com.bytedance.pitaya.api.PTYNormalCallback;
import com.bytedance.pitaya.api.PTYPackageCallback;
import com.bytedance.pitaya.api.PTYSetupCallback;
import com.bytedance.pitaya.api.PTYTaskResultCallback;
import com.bytedance.pitaya.api.bean.PTYCleanStrategy;
import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYErrorCode;
import com.bytedance.pitaya.api.bean.PTYNativeTaskConfig;
import com.bytedance.pitaya.api.bean.PTYNativeTaskData;
import com.bytedance.pitaya.api.bean.PTYRequestConfig;
import com.bytedance.pitaya.api.bean.PTYSetupInfo;
import com.bytedance.pitaya.api.bean.PTYTaskConfig;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.bytedance.pitaya.inner.thridpart.DelegateCoreEventReport;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegateCore.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020\rH\u0016J\u0018\u0010.\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\nH\u0016J\u0018\u00101\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0011H\u0016J\b\u00103\u001a\u00020\rH\u0016J\u0010\u00104\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0003H\u0016J\u0010\u00105\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0003H\u0016J\u0010\u00106\u001a\u00020\r2\u0006\u00100\u001a\u00020\u0003H\u0016J\u0010\u00107\u001a\u00020\r2\u0006\u00100\u001a\u00020\u0003H\u0016J$\u00108\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010;\u001a\u00020\rH\u0016J*\u0010<\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00032\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\nH\u0016J*\u0010B\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00032\b\u0010=\u001a\u0004\u0018\u00010C2\u0006\u0010?\u001a\u00020D2\u0006\u0010A\u001a\u00020\nH\u0016J0\u0010E\u001a\u0002HF\"\u0004\b\u0000\u0010F2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002HF0\f2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HF0\fH\u0082\b¢\u0006\u0002\u0010IJ\"\u0010J\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\u0006\u0010K\u001a\u00020L2\b\u0010$\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\u0003H\u0016J\u0010\u0010P\u001a\u00020\r2\u0006\u0010O\u001a\u00020\u0003H\u0016J\u0010\u0010Q\u001a\u00020\r2\u0006\u0010O\u001a\u00020\u0003H\u0016J\b\u0010R\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u0014*\u0004\u0018\u00010\u001e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/bytedance/pitaya/api/mutilinstance/DelegateCore;", "Lcom/bytedance/pitaya/api/IPitayaCore;", CommonConstants.KEY_AID, "", "(Ljava/lang/String;)V", "getAid", "()Ljava/lang/String;", "setAid", "appLogTaskCallback", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/pitaya/api/PTYTaskResultCallback;", "cleanAction", "Lkotlin/Function0;", "", "hostNotReadyError", "Lcom/bytedance/pitaya/api/bean/PTYError;", "messageHandlers", "Lcom/bytedance/pitaya/api/PTYMessageHandler;", "rLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;", "kotlin.jvm.PlatformType", "value", "realCore", "getRealCore$pitayacore_release", "()Lcom/bytedance/pitaya/api/IPitayaCore;", "setRealCore$pitayacore_release", "(Lcom/bytedance/pitaya/api/IPitayaCore;)V", "rwLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "wLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;", "cleanStorage", "context", "Landroid/content/Context;", "strategy", "Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;", "callback", "Lcom/bytedance/pitaya/api/PTYNormalCallback;", "downloadPackage", "businessName", "packageCallback", "Lcom/bytedance/pitaya/api/PTYPackageCallback;", "isPreloadReady", "", "isReady", "preDownloadAllPackage", "queryPackage", "registerApplogRunEventCallback", "business", "registerMessageHandler", "handler", "releaseAllEngines", "releaseEngine", "releaseNativeEngine", "removeApplogRunEventCallback", "removeMessageHandler", "requestUpdate", "requestConfig", "Lcom/bytedance/pitaya/api/bean/PTYRequestConfig;", "requestUpdateAll", "runNativeTask", "input", "Lcom/bytedance/pitaya/api/bean/PTYNativeTaskData;", "taskConfig", "Lcom/bytedance/pitaya/api/bean/PTYNativeTaskConfig;", "resultCallback", "runTask", "Lcom/bytedance/pitaya/api/bean/PTYTaskData;", "Lcom/bytedance/pitaya/api/bean/PTYTaskConfig;", "safeCall", "T", "noNullBlock", "nullBlock", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "setup", "ptySetupInfo", "Lcom/bytedance/pitaya/api/bean/PTYSetupInfo;", "Lcom/bytedance/pitaya/api/PTYSetupCallback;", "socketLogError", "content", "socketLogInfo", "socketLogWarn", "stopAllDownloadTask", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DelegateCore implements IPitayaCore {
    private String aid;
    private final ConcurrentHashMap<String, PTYTaskResultCallback> appLogTaskCallback;
    private Function0<Unit> cleanAction;
    private final PTYError hostNotReadyError;
    private final ConcurrentHashMap<String, PTYMessageHandler> messageHandlers;
    private final ReentrantReadWriteLock.ReadLock rLock;
    private volatile IPitayaCore realCore;
    private final ReentrantReadWriteLock rwLock;
    private final ReentrantReadWriteLock.WriteLock wLock;

    public DelegateCore(String str) {
        Intrinsics.checkNotNullParameter(str, CommonConstants.KEY_AID);
        this.aid = str;
        this.messageHandlers = new ConcurrentHashMap<>();
        this.appLogTaskCallback = new ConcurrentHashMap<>();
        this.hostNotReadyError = new PTYError("Multi-Instance", PTYErrorCode.PITAYA_IMPL_NOT_READY.getCode(), PTYErrorCode.PITAYA_IMPL_NOT_READY.getCode(), "Method invoked before host setup!", null);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.rwLock = reentrantReadWriteLock;
        this.rLock = reentrantReadWriteLock.readLock();
        this.wLock = reentrantReadWriteLock.writeLock();
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public String getAid() {
        return this.aid;
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void setAid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aid = str;
    }

    /* renamed from: getRealCore$pitayacore_release, reason: from getter */
    public final IPitayaCore getRealCore() {
        return this.realCore;
    }

    public final void setRealCore$pitayacore_release(IPitayaCore iPitayaCore) {
        this.wLock.lock();
        if (iPitayaCore != null) {
            try {
                if (this.realCore == null) {
                    this.realCore = iPitayaCore;
                    this.wLock.unlock();
                    for (Map.Entry<String, PTYMessageHandler> entry : this.messageHandlers.entrySet()) {
                        IPitayaCore iPitayaCore2 = this.realCore;
                        if (iPitayaCore2 != null) {
                            iPitayaCore2.registerMessageHandler(entry.getKey(), entry.getValue());
                        }
                    }
                    for (Map.Entry<String, PTYTaskResultCallback> entry2 : this.appLogTaskCallback.entrySet()) {
                        IPitayaCore iPitayaCore3 = this.realCore;
                        if (iPitayaCore3 != null) {
                            iPitayaCore3.registerApplogRunEventCallback(entry2.getKey(), entry2.getValue());
                        }
                    }
                    this.messageHandlers.clear();
                    this.appLogTaskCallback.clear();
                    Function0<Unit> function0 = this.cleanAction;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            } finally {
                this.wLock.unlock();
            }
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void setup(Context context, PTYSetupInfo ptySetupInfo, PTYSetupCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ptySetupInfo, "ptySetupInfo");
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.setup(context, ptySetupInfo, callback);
        } else if (callback != null) {
            callback.onResult(false, this.hostNotReadyError);
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public boolean isReady() {
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            return iPitayaCore.isReady();
        }
        return false;
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public boolean isPreloadReady() {
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            return iPitayaCore.isPreloadReady();
        }
        return false;
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void requestUpdateAll() {
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.requestUpdateAll();
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void requestUpdate(String businessName, PTYRequestConfig requestConfig, PTYPackageCallback packageCallback) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.requestUpdate(businessName, requestConfig, packageCallback);
        } else if (packageCallback != null) {
            packageCallback.onResult(false, this.hostNotReadyError, null);
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void downloadPackage(String businessName, PTYPackageCallback packageCallback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(packageCallback, "packageCallback");
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.downloadPackage(businessName, packageCallback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            packageCallback.onResult(false, this.hostNotReadyError, null);
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void preDownloadAllPackage() {
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.preDownloadAllPackage();
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void stopAllDownloadTask() {
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.stopAllDownloadTask();
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void queryPackage(String businessName, PTYPackageCallback packageCallback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(packageCallback, "packageCallback");
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.queryPackage(businessName, packageCallback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            packageCallback.onResult(false, this.hostNotReadyError, null);
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void runTask(String businessName, PTYTaskData input, PTYTaskConfig taskConfig, PTYTaskResultCallback resultCallback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.runTask(businessName, input, taskConfig, resultCallback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            DelegateCoreEventReport.INSTANCE.notReadyCall$pitayacore_release(getAid(), businessName);
            resultCallback.onResult(false, this.hostNotReadyError, null, null);
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void runNativeTask(String businessName, PTYNativeTaskData input, PTYNativeTaskConfig taskConfig, PTYTaskResultCallback resultCallback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.runNativeTask(businessName, input, taskConfig, resultCallback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            DelegateCoreEventReport.INSTANCE.notReadyCall$pitayacore_release(getAid(), businessName);
            resultCallback.onResult(false, this.hostNotReadyError, null, null);
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void releaseNativeEngine(String businessName) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.releaseNativeEngine(businessName);
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void releaseEngine(String businessName) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.releaseEngine(businessName);
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void releaseAllEngines() {
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.releaseAllEngines();
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void socketLogInfo(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.socketLogInfo(content);
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void socketLogWarn(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.socketLogWarn(content);
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void socketLogError(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        IPitayaCore iPitayaCore = this.realCore;
        if (iPitayaCore != null) {
            iPitayaCore.socketLogError(content);
        }
    }

    private final <T> T safeCall(Function0<? extends T> noNullBlock, Function0<? extends T> nullBlock) {
        T t;
        this.rLock.lock();
        try {
            if (this.realCore != null) {
                t = (T) noNullBlock.invoke();
            } else {
                t = (T) nullBlock.invoke();
            }
            return t;
        } finally {
            InlineMarker.finallyStart(1);
            this.rLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }

    @Override // com.bytedance.pitaya.api.IPitayaCore
    public void cleanStorage(Context context, PTYCleanStrategy strategy, PTYNormalCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.rLock.lock();
        try {
            if (this.realCore != null) {
                IPitayaCore iPitayaCore = this.realCore;
                if (iPitayaCore != null) {
                    iPitayaCore.cleanStorage(context, strategy, callback);
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                callback.onResult(false, this.hostNotReadyError);
                Unit unit2 = Unit.INSTANCE;
            }
        } finally {
            this.rLock.unlock();
        }
    }

    @Override // com.bytedance.pitaya.api.PitayaFE
    public void registerApplogRunEventCallback(String business, PTYTaskResultCallback callback) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.rLock.lock();
        try {
            if (this.realCore != null) {
                IPitayaCore iPitayaCore = this.realCore;
                Intrinsics.checkNotNull(iPitayaCore);
                iPitayaCore.registerApplogRunEventCallback(business, callback);
                Unit unit = Unit.INSTANCE;
            } else {
                this.appLogTaskCallback.put(business, callback);
                Unit unit2 = Unit.INSTANCE;
            }
        } finally {
            this.rLock.unlock();
        }
    }

    @Override // com.bytedance.pitaya.api.PitayaFE
    public void removeApplogRunEventCallback(String business) {
        Intrinsics.checkNotNullParameter(business, "business");
        this.rLock.lock();
        try {
            if (this.realCore != null) {
                IPitayaCore iPitayaCore = this.realCore;
                Intrinsics.checkNotNull(iPitayaCore);
                iPitayaCore.removeApplogRunEventCallback(business);
                Unit unit = Unit.INSTANCE;
            } else {
                this.appLogTaskCallback.remove(business);
            }
        } finally {
            this.rLock.unlock();
        }
    }

    @Override // com.bytedance.pitaya.api.PitayaFE
    public void registerMessageHandler(String businessName, PTYMessageHandler handler) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.rLock.lock();
        try {
            if (this.realCore != null) {
                IPitayaCore iPitayaCore = this.realCore;
                Intrinsics.checkNotNull(iPitayaCore);
                iPitayaCore.registerMessageHandler(businessName, handler);
                Unit unit = Unit.INSTANCE;
            } else {
                this.messageHandlers.put(businessName, handler);
                Unit unit2 = Unit.INSTANCE;
            }
        } finally {
            this.rLock.unlock();
        }
    }

    @Override // com.bytedance.pitaya.api.PitayaFE
    public void removeMessageHandler(String business) {
        Intrinsics.checkNotNullParameter(business, "business");
        this.rLock.lock();
        try {
            if (this.realCore != null) {
                IPitayaCore iPitayaCore = this.realCore;
                Intrinsics.checkNotNull(iPitayaCore);
                iPitayaCore.removeMessageHandler(business);
                Unit unit = Unit.INSTANCE;
            } else {
                this.messageHandlers.remove(business);
            }
        } finally {
            this.rLock.unlock();
        }
    }
}
