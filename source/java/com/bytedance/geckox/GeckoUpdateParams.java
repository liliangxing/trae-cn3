package com.bytedance.geckox;

import com.bytedance.applog.server.Api;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.iesgurd.IESGurdUpdateChannelInfo;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.IESGurdUpdateProgressInfo;
import com.bytedance.iesgurd.IESGurdUpdateResultInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoUpdateParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u009f\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0015\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u0003H\u0000¢\u0006\u0002\b8J\u0015\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u0003H\u0000¢\u0006\u0002\b;J\u001d\u0010<\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003H\u0000¢\u0006\u0002\b=J\u0018\u0010>\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@H\u0002J%\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EH\u0000¢\u0006\u0002\bGJ\u001d\u0010H\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u00032\u0006\u0010I\u001a\u00020EH\u0000¢\u0006\u0002\bJR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\"\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0017¨\u0006K"}, d2 = {"Lcom/bytedance/geckox/GeckoUpdateParams;", "", Api.COL_TAG, "", "accessKey", "channels", "", "group", "onDemand", "", "priority", "Lcom/bytedance/iesgurd/IESGurdUpdatePriority;", "callbackResult", "Lkotlin/Function1;", "Lcom/bytedance/iesgurd/IESGurdUpdateResultInfo;", "", "callbackProgress", "Lcom/bytedance/iesgurd/IESGurdUpdateProgressInfo;", "enableDownloadRetry", "customParams", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLcom/bytedance/iesgurd/IESGurdUpdatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;)V", "getAccessKey", "()Ljava/lang/String;", "getCallbackProgress", "()Lkotlin/jvm/functions/Function1;", "getCallbackResult", "channelFinish", "", "getChannels", "()Ljava/util/List;", "getCustomParams", "()Ljava/util/Map;", "getEnableDownloadRetry", "()Z", "enableRetry", "getEnableRetry$geckox_noasanRelease", "setEnableRetry$geckox_noasanRelease", "(Z)V", "enableThrottle", "getEnableThrottle$geckox_noasanRelease", "setEnableThrottle$geckox_noasanRelease", "getGroup", "listener", "Lcom/bytedance/geckox/listener/GeckoUpdateListener;", "getListener$geckox_noasanRelease", "()Lcom/bytedance/geckox/listener/GeckoUpdateListener;", "setListener$geckox_noasanRelease", "(Lcom/bytedance/geckox/listener/GeckoUpdateListener;)V", "getOnDemand", "getPriority", "()Lcom/bytedance/iesgurd/IESGurdUpdatePriority;", "result", "getTag", "addUpdateChannel", "channel", "addUpdateChannel$geckox_noasanRelease", "onFailed", "errorMessage", "onFailed$geckox_noasanRelease", "onUpdateFailed", "onUpdateFailed$geckox_noasanRelease", "onUpdateFinish", "info", "Lcom/bytedance/iesgurd/IESGurdUpdateChannelInfo;", "onUpdateProgress", "pack", "Lcom/bytedance/geckox/model/UpdatePackage;", "totalSize", "", "currentSize", "onUpdateProgress$geckox_noasanRelease", "onUpdateSuccess", "version", "onUpdateSuccess$geckox_noasanRelease", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoUpdateParams {
    private final String accessKey;
    private final Function1<IESGurdUpdateProgressInfo, Unit> callbackProgress;
    private final Function1<IESGurdUpdateResultInfo, Unit> callbackResult;
    private Map<String, Boolean> channelFinish;
    private final List<String> channels;
    private final Map<String, String> customParams;
    private final boolean enableDownloadRetry;
    private boolean enableRetry;
    private boolean enableThrottle;
    private final String group;
    private GeckoUpdateListener listener;
    private final boolean onDemand;
    private final IESGurdUpdatePriority priority;
    private IESGurdUpdateResultInfo result;
    private final String tag;

    public GeckoUpdateParams(String str) {
        this(str, null, null, null, false, null, null, null, false, null, 1022, null);
    }

    public GeckoUpdateParams(String str, String str2) {
        this(str, str2, null, null, false, null, null, null, false, null, 1020, null);
    }

    public GeckoUpdateParams(String str, String str2, List<String> list) {
        this(str, str2, list, null, false, null, null, null, false, null, 1016, null);
    }

    public GeckoUpdateParams(String str, String str2, List<String> list, String str3) {
        this(str, str2, list, str3, false, null, null, null, false, null, 1008, null);
    }

    public GeckoUpdateParams(String str, String str2, List<String> list, String str3, boolean z) {
        this(str, str2, list, str3, z, null, null, null, false, null, 992, null);
    }

    public GeckoUpdateParams(String str, String str2, List<String> list, String str3, boolean z, IESGurdUpdatePriority iESGurdUpdatePriority) {
        this(str, str2, list, str3, z, iESGurdUpdatePriority, null, null, false, null, 960, null);
    }

    public GeckoUpdateParams(String str, String str2, List<String> list, String str3, boolean z, IESGurdUpdatePriority iESGurdUpdatePriority, Function1<? super IESGurdUpdateResultInfo, Unit> function1) {
        this(str, str2, list, str3, z, iESGurdUpdatePriority, function1, null, false, null, 896, null);
    }

    public GeckoUpdateParams(String str, String str2, List<String> list, String str3, boolean z, IESGurdUpdatePriority iESGurdUpdatePriority, Function1<? super IESGurdUpdateResultInfo, Unit> function1, Function1<? super IESGurdUpdateProgressInfo, Unit> function12) {
        this(str, str2, list, str3, z, iESGurdUpdatePriority, function1, function12, false, null, 768, null);
    }

    public GeckoUpdateParams(String str, String str2, List<String> list, String str3, boolean z, IESGurdUpdatePriority iESGurdUpdatePriority, Function1<? super IESGurdUpdateResultInfo, Unit> function1, Function1<? super IESGurdUpdateProgressInfo, Unit> function12, boolean z2) {
        this(str, str2, list, str3, z, iESGurdUpdatePriority, function1, function12, z2, null, 512, null);
    }

    public GeckoUpdateParams(String str, String str2, List<String> list, String str3, boolean z, IESGurdUpdatePriority iESGurdUpdatePriority, Function1<? super IESGurdUpdateResultInfo, Unit> function1, Function1<? super IESGurdUpdateProgressInfo, Unit> function12, boolean z2, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, Api.COL_TAG);
        Intrinsics.checkParameterIsNotNull(iESGurdUpdatePriority, "priority");
        this.tag = str;
        this.accessKey = str2;
        this.channels = list;
        this.group = str3;
        this.onDemand = z;
        this.priority = iESGurdUpdatePriority;
        this.callbackResult = function1;
        this.callbackProgress = function12;
        this.enableDownloadRetry = z2;
        this.customParams = map;
        this.enableThrottle = true;
        this.enableRetry = true;
        if (function1 != null) {
            this.result = new IESGurdUpdateResultInfo();
            this.channelFinish = new LinkedHashMap();
            if (list != null) {
                for (String str4 : list) {
                    Map<String, Boolean> map2 = this.channelFinish;
                    if (map2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
                    }
                    map2.put(str4, false);
                }
            }
        }
    }

    public final String getTag() {
        return this.tag;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ GeckoUpdateParams(String str, String str2, List list, String str3, boolean z, IESGurdUpdatePriority iESGurdUpdatePriority, Function1 function1, Function1 function12, boolean z2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r1, r3, r4, r5, r6, r7, r8, r9, r2);
        String str4;
        List list2;
        String str5;
        Function1 function13;
        Function1 function14;
        Map map2 = null;
        if ((i & 2) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i & 4) != 0) {
            list2 = null;
        } else {
            list2 = list;
        }
        if ((i & 8) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        boolean z3 = (i & 16) != 0 ? false : z;
        IESGurdUpdatePriority iESGurdUpdatePriority2 = (i & 32) != 0 ? IESGurdUpdatePriority.MIDDLE : iESGurdUpdatePriority;
        if ((i & 64) != 0) {
            function13 = null;
        } else {
            function13 = function1;
        }
        if ((i & 128) != 0) {
            function14 = null;
        } else {
            function14 = function12;
        }
        boolean z4 = (i & 256) != 0 ? true : z2;
        if ((i & 512) != 0) {
        } else {
            map2 = map;
        }
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final List<String> getChannels() {
        return this.channels;
    }

    public final String getGroup() {
        return this.group;
    }

    public final boolean getOnDemand() {
        return this.onDemand;
    }

    public final IESGurdUpdatePriority getPriority() {
        return this.priority;
    }

    public final Function1<IESGurdUpdateResultInfo, Unit> getCallbackResult() {
        return this.callbackResult;
    }

    public final Function1<IESGurdUpdateProgressInfo, Unit> getCallbackProgress() {
        return this.callbackProgress;
    }

    public final boolean getEnableDownloadRetry() {
        return this.enableDownloadRetry;
    }

    public final Map<String, String> getCustomParams() {
        return this.customParams;
    }

    /* renamed from: getEnableThrottle$geckox_noasanRelease, reason: from getter */
    public final boolean getEnableThrottle() {
        return this.enableThrottle;
    }

    public final void setEnableThrottle$geckox_noasanRelease(boolean z) {
        this.enableThrottle = z;
    }

    /* renamed from: getEnableRetry$geckox_noasanRelease, reason: from getter */
    public final boolean getEnableRetry() {
        return this.enableRetry;
    }

    public final void setEnableRetry$geckox_noasanRelease(boolean z) {
        this.enableRetry = z;
    }

    /* renamed from: getListener$geckox_noasanRelease, reason: from getter */
    public final GeckoUpdateListener getListener() {
        return this.listener;
    }

    public final void setListener$geckox_noasanRelease(GeckoUpdateListener geckoUpdateListener) {
        this.listener = geckoUpdateListener;
    }

    public final void onFailed$geckox_noasanRelease(String errorMessage) {
        Intrinsics.checkParameterIsNotNull(errorMessage, "errorMessage");
        if (this.callbackResult == null) {
            return;
        }
        GeckoLogger.m296d(this.tag + '-' + this.accessKey + " update failed: " + errorMessage);
        IESGurdUpdateResultInfo iESGurdUpdateResultInfo = this.result;
        if (iESGurdUpdateResultInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        }
        iESGurdUpdateResultInfo.setSuccess(false);
        IESGurdUpdateResultInfo iESGurdUpdateResultInfo2 = this.result;
        if (iESGurdUpdateResultInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        }
        iESGurdUpdateResultInfo2.setErrorMessage(errorMessage);
        Function1<IESGurdUpdateResultInfo, Unit> function1 = this.callbackResult;
        if (function1 == null) {
            Intrinsics.throwNpe();
        }
        IESGurdUpdateResultInfo iESGurdUpdateResultInfo3 = this.result;
        if (iESGurdUpdateResultInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        }
        function1.invoke(iESGurdUpdateResultInfo3);
    }

    public final void addUpdateChannel$geckox_noasanRelease(String channel) {
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (this.callbackResult == null) {
            return;
        }
        Map<String, Boolean> map = this.channelFinish;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
        }
        map.put(channel, false);
    }

    public final void onUpdateSuccess$geckox_noasanRelease(String channel, long version) {
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (this.callbackResult == null) {
            return;
        }
        onUpdateFinish(channel, new IESGurdUpdateChannelInfo(true, version, (String) null));
    }

    public final void onUpdateFailed$geckox_noasanRelease(String channel, String errorMessage) {
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(errorMessage, "errorMessage");
        if (this.callbackResult == null) {
            return;
        }
        onUpdateFinish(channel, new IESGurdUpdateChannelInfo(false, 0L, errorMessage));
    }

    public final void onUpdateProgress$geckox_noasanRelease(final UpdatePackage pack, final long totalSize, final long currentSize) {
        Intrinsics.checkParameterIsNotNull(pack, "pack");
        if (this.callbackProgress == null && this.listener == null) {
            return;
        }
        GeckoExecutors.INSTANCE.getCallbackExecutor().execute(new Runnable() { // from class: com.bytedance.geckox.GeckoUpdateParams$onUpdateProgress$1
            @Override // java.lang.Runnable
            public final void run() {
                Function1<IESGurdUpdateProgressInfo, Unit> callbackProgress = GeckoUpdateParams.this.getCallbackProgress();
                if (callbackProgress != null) {
                    callbackProgress.invoke(new IESGurdUpdateProgressInfo(pack.getAccessKey(), pack.getChannel(), totalSize, currentSize));
                }
                GeckoUpdateListener listener = GeckoUpdateParams.this.getListener();
                if (listener != null) {
                    try {
                        listener.onDownloadProgress(pack, totalSize, currentSize);
                    } catch (Throwable th) {
                        GeckoLogger.m300w("onDownloadProgress exception: " + th.getMessage());
                    }
                }
            }
        });
    }

    private final void onUpdateFinish(String channel, IESGurdUpdateChannelInfo info) {
        Map<String, Boolean> map = this.channelFinish;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
        }
        if (Intrinsics.areEqual(map.get(channel), true)) {
            StringBuilder append = new StringBuilder("onUpdateFinish repeat: ").append(channel).append(", ");
            IESGurdUpdateResultInfo iESGurdUpdateResultInfo = this.result;
            if (iESGurdUpdateResultInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("result");
            }
            GeckoLogger.m300w(append.append((IESGurdUpdateChannelInfo) iESGurdUpdateResultInfo.getChannelInfos().get(channel)).toString());
            return;
        }
        Map<String, Boolean> map2 = this.channelFinish;
        if (map2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
        }
        map2.put(channel, true);
        if (!info.getSuccess()) {
            IESGurdUpdateResultInfo iESGurdUpdateResultInfo2 = this.result;
            if (iESGurdUpdateResultInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("result");
            }
            iESGurdUpdateResultInfo2.setSuccess(false);
        }
        IESGurdUpdateResultInfo iESGurdUpdateResultInfo3 = this.result;
        if (iESGurdUpdateResultInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        }
        iESGurdUpdateResultInfo3.setVersion(info.getVersion());
        IESGurdUpdateResultInfo iESGurdUpdateResultInfo4 = this.result;
        if (iESGurdUpdateResultInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        }
        iESGurdUpdateResultInfo4.setErrorMessage(info.getErrorMessage());
        IESGurdUpdateResultInfo iESGurdUpdateResultInfo5 = this.result;
        if (iESGurdUpdateResultInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        }
        iESGurdUpdateResultInfo5.getChannelInfos().put(channel, info);
        Map<String, Boolean> map3 = this.channelFinish;
        if (map3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelFinish");
        }
        Iterator<Map.Entry<String, Boolean>> it = map3.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().booleanValue()) {
                return;
            }
        }
        Function1<IESGurdUpdateResultInfo, Unit> function1 = this.callbackResult;
        if (function1 == null) {
            Intrinsics.throwNpe();
        }
        IESGurdUpdateResultInfo iESGurdUpdateResultInfo6 = this.result;
        if (iESGurdUpdateResultInfo6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("result");
        }
        function1.invoke(iESGurdUpdateResultInfo6);
    }
}
