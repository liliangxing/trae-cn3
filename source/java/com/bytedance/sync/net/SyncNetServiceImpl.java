package com.bytedance.sync.net;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.interfaze.IRequestTagHeaderProvider;
import com.bytedance.sync.interfaze.ISyncNetService;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.model.SubscribeResponse;
import com.bytedance.sync.model.Topic;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.intf.IHttpMsgProcessor;
import com.bytedance.sync.p005v4.intf.IMsgConverter;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.bytedance.sync.p005v4.ttnet.SyncNetworkClient;
import com.bytedance.sync.p005v4.ttnet.SyncNonMainProcessNetworkClient;
import com.bytedance.sync.p005v4.utils.ProtocolUtils;
import com.bytedance.sync.p005v4.utils.ToolUtils;
import com.bytedance.sync.settings.SyncSettings;
import com.bytedance.sync.user.AccountEventSynchronizer;
import com.google.gson.Gson;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: SyncNetServiceImpl.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J6\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J6\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0014\u0010\"\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/sync/net/SyncNetServiceImpl;", "Lcom/bytedance/sync/interfaze/ISyncNetService;", "mContext", "Landroid/content/Context;", "mHttpMsgProcessor", "Lcom/bytedance/sync/v4/intf/IHttpMsgProcessor;", "(Landroid/content/Context;Lcom/bytedance/sync/v4/intf/IHttpMsgProcessor;)V", "mGson", "Lcom/google/gson/Gson;", "getMGson", "()Lcom/google/gson/Gson;", "mGson$delegate", "Lkotlin/Lazy;", "pipelineUrl", "Landroid/net/Uri;", "getPipelineUrl", "()Landroid/net/Uri;", "subscribeTopicUrl", "getSubscribeTopicUrl", "unsubscribeTopicUrl", "getUnsubscribeTopicUrl", "monitorNonMainProcessHttpFrequency", "", ApiRequest.METHOD_POST, "", IWeixinService.ResponseConstants.URL, "msg", "Lcom/bytedance/sync/v4/protocal/BsyncProtocol;", "useGzip", "", "contentType", "forceRequest", "dataArray", "", "sendPipeline", "subscribeTopic", "Lcom/bytedance/sync/model/SubscribeResponse;", "topic", "Lcom/bytedance/sync/model/Topic;", "unsubscribeTopic", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SyncNetServiceImpl implements ISyncNetService {
    private final Context mContext;

    /* renamed from: mGson$delegate, reason: from kotlin metadata */
    private final Lazy mGson;
    private final IHttpMsgProcessor mHttpMsgProcessor;

    public SyncNetServiceImpl(Context context, IHttpMsgProcessor iHttpMsgProcessor) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(iHttpMsgProcessor, "mHttpMsgProcessor");
        this.mContext = context;
        this.mHttpMsgProcessor = iHttpMsgProcessor;
        this.mGson = LazyKt.lazy(new Function0<Gson>() { // from class: com.bytedance.sync.net.SyncNetServiceImpl$mGson$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Gson m927invoke() {
                return new Gson();
            }
        });
    }

    private final Gson getMGson() {
        return (Gson) this.mGson.getValue();
    }

    @Override // com.bytedance.sync.interfaze.ISyncNetService
    public BsyncProtocol sendPipeline(BsyncProtocol msg) {
        try {
            Uri pipelineUrl = getPipelineUrl();
            return ((IMsgConverter) UgBusFramework.getService(IMsgConverter.class)).convertToProtocol(Base64.decode(post(pipelineUrl.toString(), msg, SyncSettings.inst(this.mContext).getSettings().enableCompress(), "application/octet-stream", false), 0));
        } catch (Throwable th) {
            LogUtils.m186e(Log.getStackTraceString(th));
            return null;
        }
    }

    @Override // com.bytedance.sync.interfaze.ISyncNetService
    public SubscribeResponse subscribeTopic(Topic topic) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Uri subscribeTopicUrl = getSubscribeTopicUrl();
        String json = getMGson().toJson(topic);
        String uri = subscribeTopicUrl.toString();
        Intrinsics.checkNotNullExpressionValue(json, "json");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return (SubscribeResponse) getMGson().fromJson(post(uri, bytes, false, "application/json; charset=utf-8", true), SubscribeResponse.class);
    }

    @Override // com.bytedance.sync.interfaze.ISyncNetService
    public SubscribeResponse unsubscribeTopic(Topic topic) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Uri unsubscribeTopicUrl = getUnsubscribeTopicUrl();
        String json = getMGson().toJson(topic);
        String uri = unsubscribeTopicUrl.toString();
        Intrinsics.checkNotNullExpressionValue(json, "json");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return (SubscribeResponse) getMGson().fromJson(post(uri, bytes, false, "application/json; charset=utf-8", true), SubscribeResponse.class);
    }

    private final Uri getSubscribeTopicUrl() {
        AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
        Configuration config = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config();
        Uri build = Uri.parse(config.host).buildUpon().appendPath("v2/bytesync/api/subscribe").appendQueryParameter("device_id", deviceInfo.did).appendQueryParameter(Constant.KEY_AID, config.aid).appendQueryParameter("platform", "0").build();
        Intrinsics.checkNotNullExpressionValue(build, "parse(config.host).build…(\"platform\", \"0\").build()");
        return build;
    }

    private final Uri getUnsubscribeTopicUrl() {
        AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
        Configuration config = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config();
        Uri build = Uri.parse(config.host).buildUpon().appendPath("v2/bytesync/api/unsubscribe").appendQueryParameter("device_id", deviceInfo.did).appendQueryParameter(Constant.KEY_AID, config.aid).appendQueryParameter("platform", "0").build();
        Intrinsics.checkNotNullExpressionValue(build, "parse(config.host).build…(\"platform\", \"0\").build()");
        return build;
    }

    private final Uri getPipelineUrl() {
        AccountEventSynchronizer.DeviceInfo deviceInfo = ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo();
        Configuration config = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config();
        Uri build = Uri.parse(config.host).buildUpon().appendPath("v2/bytesync/api/pipeline").appendQueryParameter("device_id", deviceInfo.did).appendQueryParameter(Constant.KEY_AID, config.aid).appendQueryParameter("platform", "0").build();
        Intrinsics.checkNotNullExpressionValue(build, "parse(config.host).build…(\"platform\", \"0\").build()");
        return build;
    }

    private final String post(String url, byte[] dataArray, boolean useGzip, String contentType, boolean forceRequest) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (useGzip) {
            try {
                byte[] compressWithgzip = NetworkClient.compressWithgzip(dataArray);
                if (compressWithgzip != null) {
                    if (!(compressWithgzip.length == 0)) {
                        linkedHashMap.put("Content-Encoding", "gzip");
                        dataArray = compressWithgzip;
                    }
                }
            } catch (Exception e) {
                throw new CommonHttpException(0, e.getMessage());
            }
        }
        if (!StringUtils.isEmpty(contentType)) {
            linkedHashMap.put("Content-Type", contentType);
        }
        NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
        reqContext.addCommonParams = false;
        try {
            Pair<String, String> requestTagHeader = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config().iRequestTagHeaderProvider.getRequestTagHeader(false, false);
            if (requestTagHeader != null) {
                Object obj = requestTagHeader.first;
                Intrinsics.checkNotNullExpressionValue(obj, "first");
                Object obj2 = requestTagHeader.second;
                Intrinsics.checkNotNullExpressionValue(obj2, "second");
                linkedHashMap.put(obj, obj2);
            }
        } catch (Throwable th) {
            LogUtils.m186e(Intrinsics.stringPlus("iRequestTagHeaderProvider err: ", th));
        }
        return NetworkClient.getDefault().post(url, dataArray, linkedHashMap, reqContext);
    }

    private final String post(String url, BsyncProtocol msg, boolean useGzip, String contentType, boolean forceRequest) {
        byte[] convertToBytes = ((IMsgConverter) UgBusFramework.getService(IMsgConverter.class)).convertToBytes(msg);
        if (convertToBytes == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = true;
        if (useGzip) {
            try {
                byte[] compressWithgzip = NetworkClient.compressWithgzip(convertToBytes);
                if (compressWithgzip != null) {
                    if (!(compressWithgzip.length == 0)) {
                        int length = convertToBytes.length;
                        int length2 = compressWithgzip.length;
                        Integer protocolMsgType = ProtocolUtils.INSTANCE.protocolMsgType(msg);
                        SyncMonitor.monitorCompressRatio(length, length2, protocolMsgType == null ? -1 : protocolMsgType.intValue());
                        linkedHashMap.put("Accept-Encoding", "gzip");
                        linkedHashMap.put("Content-Encoding", "gzip");
                        convertToBytes = compressWithgzip;
                    }
                }
            } catch (Exception e) {
                throw new CommonHttpException(0, e.getMessage());
            }
        }
        if (!StringUtils.isEmpty(contentType)) {
            linkedHashMap.put("Content-Type", contentType);
        }
        NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
        reqContext.addCommonParams = false;
        try {
            IRequestTagHeaderProvider iRequestTagHeaderProvider = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config().iRequestTagHeaderProvider;
            if (forceRequest) {
                z = false;
            }
            Pair<String, String> requestTagHeader = iRequestTagHeaderProvider.getRequestTagHeader(z, false);
            if (requestTagHeader != null) {
                Object obj = requestTagHeader.first;
                Intrinsics.checkNotNullExpressionValue(obj, "first");
                Object obj2 = requestTagHeader.second;
                Intrinsics.checkNotNullExpressionValue(obj2, "second");
                linkedHashMap.put(obj, obj2);
            }
        } catch (Throwable th) {
            LogUtils.m186e(Intrinsics.stringPlus("iRequestTagHeaderProvider err: ", th));
        }
        try {
            if (((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config().enableMultiProcess && !ToolUtils.isMainProcess(this.mContext)) {
                monitorNonMainProcessHttpFrequency();
                SyncNonMainProcessNetworkClient.RespResult postV2 = SyncNonMainProcessNetworkClient.postV2(url, convertToBytes, linkedHashMap, reqContext);
                return this.mHttpMsgProcessor.process(postV2.headers, postV2.body);
            }
            return this.mHttpMsgProcessor.process(SyncNetworkClient.post(url, convertToBytes, linkedHashMap, reqContext));
        } catch (Throwable th2) {
            LogUtils.m186e(Intrinsics.stringPlus("sync net service impl post err: ", th2));
            return NetworkClient.getDefault().post(url, convertToBytes, linkedHashMap, reqContext);
        }
    }

    private final void monitorNonMainProcessHttpFrequency() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("http_count", 1);
            SyncMonitor.monitor("sync_sdk_non_main_process_http_frequency", null, jSONObject, null);
        } catch (Throwable unused) {
        }
    }
}
