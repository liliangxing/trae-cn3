package com.bytedance.iesgurd.request;

import android.util.Pair;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.gson.GsonUtil;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.listener.ListenerManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.net.RequestExecutor;
import com.bytedance.geckox.net.Response;
import com.bytedance.geckox.policy.probe.ProbeManager;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.geckox.utils.UIHandler;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.clean.CleanManager;
import com.bytedance.iesgurd.core.BlockType;
import com.bytedance.iesgurd.core.ReportNode;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.exception.ExceptionWithCode;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.model.DeploymentsData;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.model.ResponseBodyUpdate;
import com.bytedance.iesgurd.statistic.model.StatisticUpdateData;
import com.bytedance.iesgurd.update.UpdateQueue;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: UpdateRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\fH\u0002J\u0018\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0002J\n\u0010)\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J\b\u0010,\u001a\u00020\u0010H\u0002J\b\u0010-\u001a\u00020$H\u0002J\b\u0010.\u001a\u00020$H\u0002J\b\u0010/\u001a\u00020$H\u0002J\b\u00100\u001a\u00020$H\u0002J\b\u00101\u001a\u00020$H\u0002J\b\u00102\u001a\u00020$H\u0002J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u000205H\u0002J\u0006\u00106\u001a\u00020$J\u0006\u00107\u001a\u00020$R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/iesgurd/request/UpdateRequest;", "", "requestBody", "Lcom/bytedance/iesgurd/model/RequestBodyUpdate;", "(Lcom/bytedance/iesgurd/model/RequestBodyUpdate;)V", "params", "Lcom/bytedance/geckox/GeckoUpdateParams;", "(Lcom/bytedance/iesgurd/model/RequestBodyUpdate;Lcom/bytedance/geckox/GeckoUpdateParams;)V", "mListener", "Lcom/bytedance/geckox/listener/GeckoUpdateListener;", "needUpdateMetas", "", "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "prepareMetas", "", "probe", "", "getProbe", "()Ljava/lang/String;", "setProbe", "(Ljava/lang/String;)V", "reqType", "Lcom/bytedance/iesgurd/core/ReqType;", "requestPolicyManager", "Lcom/bytedance/iesgurd/request/RequestPolicyManager;", "responseBody", "Lcom/bytedance/iesgurd/model/ResponseBodyUpdate;", "retry", "", "getRetry", "()Z", "setRetry", "(Z)V", "statisticData", "Lcom/bytedance/iesgurd/statistic/model/StatisticUpdateData;", "addToDownloadIfNeeded", "", IPiaCacheProvider.CacheConfig.FIELD_META, "checkNeedUpdateWithCallback", "accessKey", "channel", "checkResponse", "doRequest", "execute", "getUrl", "handleResources", "initColdStartOperations", "initCustomRequestMonitorData", "initCustomUpdateOperations", "initSelf", "initUpdateOperations", "onFailed", "t", "", "reStart", TraeAuthManager.STAGE_START, "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UpdateRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function2<? super ReqType, ? super List<PrepareMeta>, Unit> requestFinishCallback;
    private static Function3<? super ReqType, ? super List<PrepareMeta>, ? super Long, Unit> startDownloadCallback;
    private GeckoUpdateListener mListener;
    private final List<PrepareMeta> needUpdateMetas;
    private final GeckoUpdateParams params;
    private List<PrepareMeta> prepareMetas;
    private String probe;
    private ReqType reqType;
    private final RequestBodyUpdate requestBody;
    private final RequestPolicyManager requestPolicyManager;
    private ResponseBodyUpdate responseBody;
    private boolean retry;
    private final StatisticUpdateData statisticData;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReqType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ReqType.QUEUE.ordinal()] = 1;
            iArr[ReqType.REGISTER_LATE.ordinal()] = 2;
            iArr[ReqType.PROBE.ordinal()] = 3;
            iArr[ReqType.POLLING.ordinal()] = 4;
        }
    }

    /* compiled from: UpdateRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR:\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/iesgurd/request/UpdateRequest$Companion;", "", "()V", "requestFinishCallback", "Lkotlin/Function2;", "Lcom/bytedance/iesgurd/core/ReqType;", "", "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "", "getRequestFinishCallback", "()Lkotlin/jvm/functions/Function2;", "setRequestFinishCallback", "(Lkotlin/jvm/functions/Function2;)V", "startDownloadCallback", "Lkotlin/Function3;", "", "getStartDownloadCallback", "()Lkotlin/jvm/functions/Function3;", "setStartDownloadCallback", "(Lkotlin/jvm/functions/Function3;)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function2<ReqType, List<PrepareMeta>, Unit> getRequestFinishCallback() {
            return UpdateRequest.requestFinishCallback;
        }

        public final void setRequestFinishCallback(Function2<? super ReqType, ? super List<PrepareMeta>, Unit> function2) {
            UpdateRequest.requestFinishCallback = function2;
        }

        public final Function3<ReqType, List<PrepareMeta>, Long, Unit> getStartDownloadCallback() {
            return UpdateRequest.startDownloadCallback;
        }

        public final void setStartDownloadCallback(Function3<? super ReqType, ? super List<PrepareMeta>, ? super Long, Unit> function3) {
            UpdateRequest.startDownloadCallback = function3;
        }
    }

    public UpdateRequest(RequestBodyUpdate requestBodyUpdate, GeckoUpdateParams geckoUpdateParams) {
        Intrinsics.checkParameterIsNotNull(requestBodyUpdate, "requestBody");
        Intrinsics.checkParameterIsNotNull(geckoUpdateParams, "params");
        this.requestBody = requestBodyUpdate;
        this.params = geckoUpdateParams;
        this.requestPolicyManager = new RequestPolicyManager();
        this.statisticData = new StatisticUpdateData();
        this.reqType = ReqType.NORMAL;
        this.prepareMetas = new ArrayList();
        this.needUpdateMetas = new ArrayList();
    }

    public static final /* synthetic */ ResponseBodyUpdate access$getResponseBody$p(UpdateRequest updateRequest) {
        ResponseBodyUpdate responseBodyUpdate = updateRequest.responseBody;
        if (responseBodyUpdate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("responseBody");
        }
        return responseBodyUpdate;
    }

    public final String getProbe() {
        return this.probe;
    }

    public final void setProbe(String str) {
        this.probe = str;
    }

    public final boolean getRetry() {
        return this.retry;
    }

    public final void setRetry(boolean z) {
        this.retry = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UpdateRequest(RequestBodyUpdate requestBodyUpdate) {
        this(requestBodyUpdate, new GeckoUpdateParams("gecko_backup", (String) null, (List) null, (String) null, false, (IESGurdUpdatePriority) null, (Function1) null, (Function1) null, false, (Map) null, 1022, (DefaultConstructorMarker) null));
        Intrinsics.checkParameterIsNotNull(requestBodyUpdate, "requestBody");
    }

    public final void reStart() {
        GeckoExecutors.INSTANCE.getCheckUpdateExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.request.UpdateRequest$reStart$1
            @Override // java.lang.Runnable
            public final void run() {
                RequestBodyUpdate requestBodyUpdate;
                GeckoUpdateParams geckoUpdateParams;
                RequestBodyUpdate requestBodyUpdate2;
                GeckoLogger.d("update request retry start");
                requestBodyUpdate = UpdateRequest.this.requestBody;
                geckoUpdateParams = UpdateRequest.this.params;
                UpdateRequest updateRequest = new UpdateRequest(requestBodyUpdate, geckoUpdateParams);
                updateRequest.setRetry(true);
                requestBodyUpdate2 = UpdateRequest.this.requestBody;
                requestBodyUpdate2.getReqInfo().setRetry(true);
                if (UpdateRequest.this.getProbe() != null) {
                    updateRequest.setProbe(UpdateRequest.this.getProbe());
                }
                updateRequest.execute();
            }
        });
    }

    public final void start() {
        GeckoExecutors.INSTANCE.getCheckUpdateExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.request.UpdateRequest$start$1
            @Override // java.lang.Runnable
            public final void run() {
                UpdateRequest.this.execute();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void execute() {
        initSelf();
        initCustomRequestMonitorData();
        boolean z = true;
        try {
            this.requestPolicyManager.prepareRequest();
            try {
                doRequest();
                String checkResponse = checkResponse();
                if (checkResponse != null) {
                    onFailed(new Exception(checkResponse));
                    return;
                }
                handleResources();
                initUpdateOperations();
                if (this.reqType == ReqType.NORMAL && this.mListener != null) {
                    Map<String, List<Pair<String, Long>>> requestMap = this.requestBody.getRequestMap();
                    HashMap hashMap = new HashMap();
                    for (PrepareMeta prepareMeta : this.needUpdateMetas) {
                        String accessKey = prepareMeta.getAccessKey();
                        ArrayList arrayList = (List) hashMap.get(accessKey);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(prepareMeta.getPack());
                        hashMap.put(accessKey, arrayList);
                    }
                    GeckoUpdateListener geckoUpdateListener = this.mListener;
                    if (geckoUpdateListener == null) {
                        Intrinsics.throwNpe();
                    }
                    geckoUpdateListener.onCheckServerVersionSuccess(requestMap, hashMap);
                }
                if (!this.needUpdateMetas.isEmpty()) {
                    final Function3<? super ReqType, ? super List<PrepareMeta>, ? super Long, Unit> function3 = startDownloadCallback;
                    if (function3 != null) {
                        UIHandler.INSTANCE.runOnUIThread(new Function0<Unit>() { // from class: com.bytedance.iesgurd.request.UpdateRequest$execute$$inlined$let$lambda$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m643invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m643invoke() {
                                ReqType reqType;
                                List list;
                                Function3 function32 = function3;
                                reqType = this.reqType;
                                list = this.needUpdateMetas;
                                function32.invoke(reqType, list, 0L);
                            }
                        });
                    }
                    if (this.params.getCallbackResult() != null) {
                        Iterator<T> it = this.needUpdateMetas.iterator();
                        while (it.hasNext()) {
                            this.params.addUpdateChannel$geckox_noasanRelease(((PrepareMeta) it.next()).getChannel());
                        }
                    }
                    UpdateQueue.INSTANCE.add(this.needUpdateMetas, this.params);
                    return;
                }
                if (this.params.getCallbackResult() != null) {
                    String group = this.params.getGroup();
                    if (group == null || group.length() == 0) {
                        return;
                    }
                    List channels = this.params.getChannels();
                    if (channels != null && !channels.isEmpty()) {
                        z = false;
                    }
                    if (z) {
                        this.params.onFailed$geckox_noasanRelease("no channel need update");
                    }
                }
            } catch (Throwable th) {
                this.requestPolicyManager.requestFail();
                onFailed(th);
            }
        } catch (ExceptionWithCode e) {
            this.statisticData.setErrCode(e.getCode());
            this.statisticData.setIntercept(1);
            onFailed(e);
        }
    }

    private final void initSelf() {
        this.mListener = this.params.getListener$geckox_noasanRelease();
        this.reqType = this.requestBody.getReqType();
        GeckoLogger.d("start check update request " + this.reqType);
        this.requestBody.getReqInfo().setTag(this.params.getTag());
        String sortedDeployments = this.requestBody.getSortedDeployments();
        this.requestPolicyManager.setExceptionRequestPolicy(new ExceptionRequestPolicy(this.reqType));
        this.requestPolicyManager.setRetryRequestPolicy(new RetryRequestPolicy(this.retry, this.params.getEnableRetry$geckox_noasanRelease(), sortedDeployments, this));
        if (this.reqType == ReqType.NORMAL) {
            this.requestPolicyManager.setThrottleRequestPolicy(new ThrottleRequestPolicy(this.params.getEnableThrottle$geckox_noasanRelease(), sortedDeployments));
        }
        this.statisticData.setRetry(this.retry);
        this.statisticData.setReqType(this.reqType);
        this.statisticData.setOptionParams(this.params);
        String str = this.probe;
        if (str != null) {
            this.statisticData.setProbeHeader(str);
        }
    }

    private final void initCustomRequestMonitorData() {
        if (this.reqType != ReqType.NORMAL) {
            return;
        }
        Iterator<String> it = this.requestBody.getDeployments().keySet().iterator();
        if (it.hasNext()) {
            String next = it.next();
            this.statisticData.setAccessKey(next);
            DeploymentsData deploymentsData = this.requestBody.getDeployments().get(next);
            if (deploymentsData == null) {
                Intrinsics.throwNpe();
            }
            DeploymentsData deploymentsData2 = deploymentsData;
            List<String> channels = deploymentsData2.getChannels();
            if (!(channels == null || channels.isEmpty())) {
                this.statisticData.setChannels(String.valueOf(deploymentsData2.getChannels()));
            }
            List<String> groups = deploymentsData2.getGroups();
            if (!(groups == null || groups.isEmpty())) {
                this.statisticData.setGroupName(String.valueOf(deploymentsData2.getGroups()));
            }
            Map<String, String> map = this.requestBody.getCustom().get(next);
            if (map == null) {
                Intrinsics.throwNpe();
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("check update, ak: %s, channels:%s, groupName:%s, business_version:%s", Arrays.copyOf(new Object[]{next, this.statisticData.getChannels(), this.statisticData.getGroupName(), map.get("business_version")}, 4));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            GeckoLogger.d(format);
        }
    }

    private final void doRequest() {
        final String url = getUrl();
        boolean z = this.reqType != ReqType.NORMAL;
        GeckoLogger.INSTANCE.d$geckox_noasanRelease(ReportNode.CHECK_UPDATE_REQUEST, "check update start, tag: " + this.params.getTag() + ", retry: " + this.retry + ", reqType: " + this.reqType + ", " + url);
        new RequestExecutor(this.requestBody, url, z, this.probe, new Function1<Response, Unit>() { // from class: com.bytedance.iesgurd.request.UpdateRequest$doRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Response response) {
                StatisticUpdateData statisticUpdateData;
                StatisticUpdateData statisticUpdateData2;
                StatisticUpdateData statisticUpdateData3;
                StatisticUpdateData statisticUpdateData4;
                RequestPolicyManager requestPolicyManager;
                Intrinsics.checkParameterIsNotNull(response, "it");
                statisticUpdateData = UpdateRequest.this.statisticData;
                statisticUpdateData.setHttpStatus(response.code);
                statisticUpdateData2 = UpdateRequest.this.statisticData;
                statisticUpdateData2.setErrorMsg(response.msg);
                statisticUpdateData3 = UpdateRequest.this.statisticData;
                statisticUpdateData3.setLogId(RequestExecutor.Companion.getLogId(response));
                GeckoLogger geckoLogger = GeckoLogger.INSTANCE;
                ReportNode reportNode = ReportNode.CHECK_UPDATE_RESPONSE;
                StringBuilder sb = new StringBuilder("response,logId: ");
                statisticUpdateData4 = UpdateRequest.this.statisticData;
                geckoLogger.d$geckox_noasanRelease(reportNode, sb.append(statisticUpdateData4.getLogId()).toString());
                if (response.code == 200) {
                    requestPolicyManager = UpdateRequest.this.requestPolicyManager;
                    requestPolicyManager.requestSuccess();
                    try {
                        UpdateRequest updateRequest = UpdateRequest.this;
                        Object fromJson = GsonUtil.Companion.inst().gson().fromJson(response.body, ResponseBodyUpdate.class);
                        Intrinsics.checkExpressionValueIsNotNull(fromJson, "GsonUtil.inst().gson().f…seBodyUpdate::class.java)");
                        updateRequest.responseBody = (ResponseBodyUpdate) fromJson;
                        return;
                    } catch (Exception e) {
                        throw new Throwable("json parse failed, url: " + url + ", msg: " + e.getMessage() + ", content: " + response.body);
                    }
                }
                throw new Throwable("check update error, url: " + url + ", code: " + response.code + ", msg: " + response.msg);
            }
        }).run();
    }

    private final String getUrl() {
        String str;
        this.statisticData.setApiVersion("update_v7_custom");
        if (this.reqType == ReqType.POLLING) {
            this.statisticData.setApiVersion("update_v7_polling");
            str = "/gkx/api/resource/v7/polling";
        } else if (this.reqType == ReqType.QUEUE || this.reqType == ReqType.REGISTER_LATE) {
            this.statisticData.setApiVersion("update_v7_coldstart");
            str = "/gkx/api/resource/v7/coldstart";
        } else {
            str = "/gkx/api/resource/v7/custom";
        }
        StringBuilder sb = new StringBuilder("https://");
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
        Intrinsics.checkExpressionValueIsNotNull(globalConfig, "GeckoGlobalManager.inst().globalConfig");
        return sb.append(globalConfig.getHost()).append(str).toString();
    }

    private final String checkResponse() {
        ResponseBodyUpdate responseBodyUpdate = this.responseBody;
        if (responseBodyUpdate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("responseBody");
        }
        int status = responseBodyUpdate.getStatus();
        if (status != 0) {
            this.statisticData.setErrCode(status);
            return "check update failed, status error: " + status;
        }
        ResponseBodyUpdate responseBodyUpdate2 = this.responseBody;
        if (responseBodyUpdate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("responseBody");
        }
        if (responseBodyUpdate2.getData() == null) {
            return "check update failed, data is null";
        }
        ResponseBodyUpdate responseBodyUpdate3 = this.responseBody;
        if (responseBodyUpdate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("responseBody");
        }
        ResponseBodyUpdate.ResponseBodyData data = responseBodyUpdate3.getData();
        if (data == null) {
            Intrinsics.throwNpe();
        }
        if (data.getResources() == null) {
            return "check update failed, resources is null";
        }
        this.statisticData.upload();
        if (this.statisticData.getProbeHeader() != null) {
            String str = "http_status: " + this.statisticData.getHttpStatus() + ", err_code:" + this.statisticData.getErrCode() + ", err_msg:" + this.statisticData.getErrorMsg();
            ProbeManager probeManager = ProbeManager.INSTANCE;
            String probeHeader = this.statisticData.getProbeHeader();
            if (probeHeader == null) {
                Intrinsics.throwNpe();
            }
            probeManager.uploadProbeEvent("request_finish", probeHeader, str);
        }
        CleanManager.INSTANCE.handleCleanTasks(data.getCleanTasks());
        List mutableList = CollectionsKt.toMutableList(data.getResources());
        for (int size = mutableList.size() - 1; size >= 0; size--) {
            PrepareMeta prepareMeta = (PrepareMeta) mutableList.get(size);
            String checkValid = prepareMeta.checkValid();
            if (checkValid != null) {
                String str2 = "server data error: " + checkValid;
                GeckoLogger.w(str2);
                ListenerManager.INSTANCE.callUpdateFailed(this.mListener, new UpdatePackage(prepareMeta.getAccessKey(), prepareMeta.getChannel(), 0L, 4, (DefaultConstructorMarker) null), new Exception(str2));
                this.params.onUpdateFailed$geckox_noasanRelease(prepareMeta.getChannel(), str2);
                mutableList.remove(size);
            }
        }
        this.prepareMetas = CollectionsKt.toList(mutableList);
        return null;
    }

    private final void handleResources() {
        for (PrepareMeta prepareMeta : this.prepareMetas) {
            String accessKey = prepareMeta.getAccessKey();
            String channel = prepareMeta.getChannel();
            if (prepareMeta.getFullPackage() != null) {
                prepareMeta.setLogId(this.statisticData.getLogId());
                prepareMeta.setApiVersion(this.statisticData.getApiVersion());
                prepareMeta.setRetry(this.statisticData.getIsRetry());
                Long localVersion = this.requestBody.getLocalVersion(accessKey, channel);
                if (localVersion != null) {
                    prepareMeta.setLocalVersion(localVersion.longValue());
                }
                prepareMeta.initByRequest(this.reqType);
                PrepareMetaManager.INSTANCE.addMeta(accessKey, channel, prepareMeta);
            }
        }
        final Function2<? super ReqType, ? super List<PrepareMeta>, Unit> function2 = requestFinishCallback;
        if (function2 != null) {
            UIHandler.INSTANCE.runOnUIThread(new Function0<Unit>() { // from class: com.bytedance.iesgurd.request.UpdateRequest$handleResources$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m644invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m644invoke() {
                    ReqType reqType;
                    List list;
                    Function2 function22 = function2;
                    reqType = this.reqType;
                    list = this.prepareMetas;
                    function22.invoke(reqType, list);
                }
            });
        }
    }

    private final void initUpdateOperations() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.reqType.ordinal()];
        if (i == 1 || i == 2) {
            initColdStartOperations();
            return;
        }
        if (i == 3) {
            Iterator<T> it = this.prepareMetas.iterator();
            while (it.hasNext()) {
                addToDownloadIfNeeded((PrepareMeta) it.next());
            }
        } else {
            if (i != 4) {
                initCustomUpdateOperations();
                return;
            }
            Iterator<T> it2 = this.requestBody.getCustom().keySet().iterator();
            while (it2.hasNext()) {
                Map<String, PrepareMeta> metas = PrepareMetaManager.INSTANCE.getMetas((String) it2.next());
                if (metas != null) {
                    Iterator<Map.Entry<String, PrepareMeta>> it3 = metas.entrySet().iterator();
                    while (it3.hasNext()) {
                        addToDownloadIfNeeded(it3.next().getValue());
                    }
                }
            }
        }
    }

    private final void initColdStartOperations() {
        HashMap hashMap = new HashMap();
        for (PrepareMeta prepareMeta : this.prepareMetas) {
            long downloadDelay = prepareMeta.getDownloadDelay();
            if (downloadDelay <= 0) {
                downloadDelay = 3;
            }
            ArrayList arrayList = (List) hashMap.get(Long.valueOf(downloadDelay));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Long.valueOf(downloadDelay), arrayList);
            }
            arrayList.add(prepareMeta);
        }
        for (final Map.Entry entry : hashMap.entrySet()) {
            final long longValue = ((Number) entry.getKey()).longValue();
            GeckoExecutors.INSTANCE.getDelayHandler().postDelayed(new Runnable() { // from class: com.bytedance.iesgurd.request.UpdateRequest$initColdStartOperations$$inlined$forEach$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    ReqType reqType;
                    GeckoUpdateParams geckoUpdateParams;
                    ReqType reqType2;
                    ReqType reqType3;
                    GeckoGlobalManager inst = GeckoGlobalManager.inst();
                    Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
                    if (!inst.isGeckoEnable()) {
                        StringBuilder append = new StringBuilder("gecko disable, cold start cancel: ").append(longValue).append(", ");
                        reqType3 = this.reqType;
                        GeckoLogger.d(append.append(reqType3).toString());
                        return;
                    }
                    StringBuilder append2 = new StringBuilder("cold start delay update begin: ").append(longValue).append(", ");
                    reqType = this.reqType;
                    GeckoLogger.d(append2.append(reqType).toString());
                    final ArrayList arrayList2 = new ArrayList();
                    for (PrepareMeta prepareMeta2 : (Iterable) entry.getValue()) {
                        ChannelMeta meta = ChannelMetaManager.INSTANCE.getMeta(prepareMeta2.getAccessKey(), prepareMeta2.getChannel());
                        Long id = meta != null ? meta.getId() : null;
                        long version = prepareMeta2.getVersion();
                        if (id == null || id.longValue() != version) {
                            reqType2 = this.reqType;
                            prepareMeta2.setReqType(reqType2);
                            PrepareMeta.updateBlockType$default(prepareMeta2, false, 1, null);
                            if (prepareMeta2.getBlockType() == null) {
                                arrayList2.add(prepareMeta2);
                            }
                        }
                    }
                    final Function3<ReqType, List<PrepareMeta>, Long, Unit> startDownloadCallback2 = UpdateRequest.INSTANCE.getStartDownloadCallback();
                    if (startDownloadCallback2 != null) {
                        UIHandler.INSTANCE.runOnUIThread(new Function0<Unit>() { // from class: com.bytedance.iesgurd.request.UpdateRequest$initColdStartOperations$$inlined$forEach$lambda$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m645invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m645invoke() {
                                ReqType reqType4;
                                Function3 function3 = startDownloadCallback2;
                                reqType4 = this.reqType;
                                function3.invoke(reqType4, arrayList2, Long.valueOf(longValue));
                            }
                        });
                    }
                    if (!arrayList2.isEmpty()) {
                        UpdateQueue updateQueue = UpdateQueue.INSTANCE;
                        geckoUpdateParams = this.params;
                        updateQueue.add(arrayList2, geckoUpdateParams);
                    }
                }
            }, longValue * 1000);
        }
    }

    private final void initCustomUpdateOperations() {
        for (Map.Entry<String, DeploymentsData> entry : this.requestBody.getDeployments().entrySet()) {
            DeploymentsData value = entry.getValue();
            List<String> channels = value.getChannels();
            if (channels != null) {
                Iterator<T> it = channels.iterator();
                while (it.hasNext()) {
                    checkNeedUpdateWithCallback(entry.getKey(), (String) it.next());
                }
            }
            List<String> groups = value.getGroups();
            if (groups != null) {
                for (String str : groups) {
                    Map<String, PrepareMeta> metas = PrepareMetaManager.INSTANCE.getMetas(entry.getKey());
                    if (metas != null) {
                        Iterator<Map.Entry<String, PrepareMeta>> it2 = metas.entrySet().iterator();
                        while (it2.hasNext()) {
                            PrepareMeta value2 = it2.next().getValue();
                            List<String> groups2 = value2.getGroups();
                            if (groups2 != null && groups2.contains(str)) {
                                addToDownloadIfNeeded(value2);
                            }
                        }
                    }
                }
            }
        }
    }

    private final void addToDownloadIfNeeded(PrepareMeta meta) {
        meta.setReqType(this.reqType);
        PrepareMeta.updateBlockType$default(meta, false, 1, null);
        if (meta.getBlockType() == null) {
            this.needUpdateMetas.add(meta);
        }
    }

    private final void checkNeedUpdateWithCallback(String accessKey, String channel) {
        PrepareMeta updateMeta = PrepareMetaManager.INSTANCE.getUpdateMeta(accessKey, channel);
        if (updateMeta != null) {
            addToDownloadIfNeeded(updateMeta);
        }
        if (this.reqType != ReqType.NORMAL) {
            return;
        }
        Function1 callbackResult = this.params.getCallbackResult();
        if (this.mListener == null && callbackResult == null) {
            return;
        }
        if (updateMeta == null) {
            ChannelMeta meta = ChannelMetaManager.INSTANCE.getMeta(accessKey, channel);
            Long id = meta != null ? meta.getId() : null;
            if (id == null) {
                ListenerManager.INSTANCE.callUpdateFailed(this.mListener, new UpdatePackage(accessKey, channel, 0L, 4, (DefaultConstructorMarker) null), new Exception("no local version and no remote version"));
                this.params.onUpdateFailed$geckox_noasanRelease(channel, "no local version and no remote version");
                return;
            } else {
                ListenerManager.INSTANCE.callVersionExist(this.mListener, accessKey, channel, id.longValue());
                this.params.onUpdateSuccess$geckox_noasanRelease(channel, id.longValue());
                return;
            }
        }
        BlockType blockType = updateMeta.getBlockType();
        if (blockType != null) {
            ListenerManager.INSTANCE.callUpdateFailed(this.mListener, updateMeta.getPack(), new Exception("update blocked: " + blockType));
            this.params.onUpdateFailed$geckox_noasanRelease(channel, "update blocked: " + blockType);
        }
    }

    private final void onFailed(Throwable t) {
        String message = t.getMessage();
        if (message == null) {
            message = "";
        }
        GeckoLogger.w(message);
        this.statisticData.setErrorMsg(t.getMessage());
        this.statisticData.upload();
        final Function2<? super ReqType, ? super List<PrepareMeta>, Unit> function2 = requestFinishCallback;
        if (function2 != null) {
            UIHandler.INSTANCE.runOnUIThread(new Function0<Unit>() { // from class: com.bytedance.iesgurd.request.UpdateRequest$onFailed$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m646invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m646invoke() {
                    ReqType reqType;
                    Function2 function22 = function2;
                    reqType = this.reqType;
                    function22.invoke(reqType, (Object) null);
                }
            });
        }
        if (this.reqType == ReqType.NORMAL) {
            GeckoUpdateListener geckoUpdateListener = this.mListener;
            if (geckoUpdateListener != null) {
                geckoUpdateListener.onCheckServerVersionFail((Map) null, t);
            }
            GeckoUpdateParams geckoUpdateParams = this.params;
            String message2 = t.getMessage();
            geckoUpdateParams.onFailed$geckox_noasanRelease(message2 != null ? message2 : "");
        }
    }
}
