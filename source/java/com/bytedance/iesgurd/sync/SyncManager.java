package com.bytedance.iesgurd.sync;

import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.gson.GsonUtil;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.clean.CleanManager;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.DeploymentsData;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.UpdateRequest;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.platform.godzilla.common.Constant;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SyncManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/iesgurd/sync/SyncManager;", "", "()V", "handleMessage", "", "data", "", "handleMessageCheckUpdate", "message", "Lcom/bytedance/iesgurd/sync/SyncMsgModel;", "handleMessageClean", "uploadEvent", "model", "isHandle", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SyncManager {
    public static final SyncManager INSTANCE = new SyncManager();

    private SyncManager() {
    }

    public final void handleMessage(byte[] data) {
        if (data != null && GlobalManager.INSTANCE.getInited().get()) {
            try {
                Charset forName = Charset.forName(Constant.CHARSET_UTF_8);
                Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charsetName)");
                String str = new String(data, forName);
                GeckoLogger.d("[sync]handle message: ".concat(str));
                SyncMsgModel syncMsgModel = (SyncMsgModel) GsonUtil.Companion.inst().gson().fromJson(str, SyncMsgModel.class);
                if (syncMsgModel.getTimestamp() < GlobalManager.INSTANCE.getInitTime()) {
                    GeckoLogger.d("[sync]return because messageTime < initTime");
                    Intrinsics.checkExpressionValueIsNotNull(syncMsgModel, "message");
                    uploadEvent(syncMsgModel, false);
                    return;
                }
                int msgType = syncMsgModel.getMsgType();
                if (msgType == 1) {
                    Intrinsics.checkExpressionValueIsNotNull(syncMsgModel, "message");
                    handleMessageCheckUpdate(syncMsgModel);
                } else if (msgType == 2) {
                    Intrinsics.checkExpressionValueIsNotNull(syncMsgModel, "message");
                    handleMessageClean(syncMsgModel);
                } else {
                    GeckoLogger.d("[sync]unexpected message type: " + syncMsgModel.getMsgType());
                }
            } catch (Exception e) {
                GeckoLogger.d("[sync]message exception: " + e.getMessage());
            }
        }
    }

    private final void handleMessageCheckUpdate(SyncMsgModel message) {
        SyncUpdateModel checkUpdateInfo;
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        if (!inst.isGeckoEnable()) {
            GeckoLogger.d("[sync]return because gecko disable");
            uploadEvent(message, false);
            return;
        }
        SyncDataModel data = message.getData();
        Map<String, SyncChannelModel> config = (data == null || (checkUpdateInfo = data.getCheckUpdateInfo()) == null) ? null : checkUpdateInfo.getConfig();
        if (config == null || config.isEmpty()) {
            GeckoLogger.d("[sync]return because config error");
            uploadEvent(message, false);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, SyncChannelModel> entry : config.entrySet()) {
            String key = entry.getKey();
            GeckoGlobalManager inst2 = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst2, "GeckoGlobalManager.inst()");
            if (!inst2.getAccessKeyDirs().containsKey(key)) {
                GeckoLogger.d("[sync]" + key + " not register");
            } else {
                List<String> channels = entry.getValue().getChannels();
                if (channels == null || channels.isEmpty()) {
                    GeckoLogger.d("[sync]" + key + " config is empty");
                } else {
                    linkedHashMap.put(key, new DeploymentsData(null, entry.getValue().getChannels()));
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            GeckoLogger.d("[sync]return because deployments is empty");
            uploadEvent(message, false);
            return;
        }
        GeckoLogger.d("[sync]handle check update message");
        uploadEvent(message, true);
        RequestBodyUpdate requestBodyUpdate = new RequestBodyUpdate(ReqType.BYTESYNC);
        requestBodyUpdate.setDeployments(linkedHashMap);
        requestBodyUpdate.initCustom(CollectionsKt.toList(linkedHashMap.keySet()));
        requestBodyUpdate.getReqInfo().setSyncTaskId(message.getSyncTaskId());
        requestBodyUpdate.initLocalVersionByDeployments();
        GeckoUpdateParams geckoUpdateParams = new GeckoUpdateParams("", (String) null, (List) null, (String) null, false, IESGurdUpdatePriority.HIGH, (Function1) null, (Function1) null, false, (Map) null, 990, (DefaultConstructorMarker) null);
        geckoUpdateParams.setEnableThrottle$geckox_noasanRelease(false);
        new UpdateRequest(requestBodyUpdate, geckoUpdateParams).start();
    }

    private final void handleMessageClean(SyncMsgModel message) {
        SyncDataModel data = message.getData();
        Map<String, SyncCleanModel> cleanInfo = data != null ? data.getCleanInfo() : null;
        if (cleanInfo == null || cleanInfo.isEmpty()) {
            GeckoLogger.d("[sync]return because clean info error");
            uploadEvent(message, false);
        } else {
            GeckoLogger.d("[sync]handle sync message");
            uploadEvent(message, true);
            CleanManager.INSTANCE.cleanByPush(cleanInfo);
        }
    }

    private final void uploadEvent(SyncMsgModel model, boolean isHandle) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sync_task_id", model.getSyncTaskId());
            jSONObject.put("sync_task_type", model.getMsgType());
            jSONObject.put("sync_stats_type", isHandle ? 1 : 2);
            obj = Result.constructor-impl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isSuccess-impl(obj)) {
            UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_bytesync_stats", (JSONObject) obj);
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            GeckoLogger.d("upload sync event failed: " + model.getSyncTaskId() + ", " + model.getMsgType() + ", " + isHandle);
        }
    }
}
