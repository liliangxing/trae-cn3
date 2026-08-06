package com.bytedance.iesgurd.model;

import android.util.Pair;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GeckoStore;
import com.bytedance.iesgurd.core.RegisterManager;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestBodyUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 #2\u00020\u0001:\u0002#$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110\u000e0\u000eJ$\u0010\u0016\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110\u00180\u00170\u0006J\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017J*\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 J\b\u0010!\u001a\u00020\u001bH\u0002J\u0006\u0010\"\u001a\u00020\u001bR*\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u000e0\u000e8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodyUpdate;", "Lcom/bytedance/iesgurd/model/RequestBodyBase;", "reqType", "Lcom/bytedance/iesgurd/core/ReqType;", "(Lcom/bytedance/iesgurd/core/ReqType;)V", "deployments", "", "", "Lcom/bytedance/iesgurd/model/DeploymentsData;", "getDeployments", "()Ljava/util/Map;", "setDeployments", "(Ljava/util/Map;)V", "local", "", "Lcom/bytedance/iesgurd/model/RequestBodyUpdate$LocalData;", "getLocalVersion", "", "accessKey", "channel", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "getLocalVersions", "getRequestMap", "", "Landroid/util/Pair;", "getSortedDeployments", "initCustom", "", "accessKeys", "params", "Lcom/bytedance/geckox/GeckoUpdateParams;", "oldParams", "Lcom/bytedance/geckox/OptionCheckUpdateParams;", "initLocalVersion", "initLocalVersionByDeployments", "Companion", "LocalData", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RequestBodyUpdate extends RequestBodyBase {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<String, Boolean> checkDirFinish = new ConcurrentHashMap<>();

    @SerializedName("deployments")
    private Map<String, DeploymentsData> deployments;

    @SerializedName("local")
    private final Map<String, Map<String, LocalData>> local;

    /* compiled from: RequestBodyUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodyUpdate$Companion;", "", "()V", "checkDirFinish", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "resetForTest", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void resetForTest() {
            RequestBodyUpdate.checkDirFinish.clear();
        }
    }

    public final Map<String, DeploymentsData> getDeployments() {
        return this.deployments;
    }

    public final void setDeployments(Map<String, DeploymentsData> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this.deployments = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequestBodyUpdate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodyUpdate$LocalData;", "", "()V", "availableMetaId", "", "getAvailableMetaId", "()Ljava/lang/Long;", "setAvailableMetaId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "forbidden", "", "getForbidden", "()Ljava/lang/Integer;", "setForbidden", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "hashVersion", "", "getHashVersion", "()Ljava/lang/String;", "setHashVersion", "(Ljava/lang/String;)V", "prepareMetaId", "getPrepareMetaId", "setPrepareMetaId", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class LocalData {

        @SerializedName("available_meta_id")
        private Long availableMetaId;

        @SerializedName("forbidden")
        private Integer forbidden;

        @SerializedName("hash_version")
        private String hashVersion = "";

        @SerializedName("prepare_meta_id")
        private Long prepareMetaId;

        public final Long getAvailableMetaId() {
            return this.availableMetaId;
        }

        public final void setAvailableMetaId(Long l) {
            this.availableMetaId = l;
        }

        public final Long getPrepareMetaId() {
            return this.prepareMetaId;
        }

        public final void setPrepareMetaId(Long l) {
            this.prepareMetaId = l;
        }

        public final String getHashVersion() {
            return this.hashVersion;
        }

        public final void setHashVersion(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.hashVersion = str;
        }

        public final Integer getForbidden() {
            return this.forbidden;
        }

        public final void setForbidden(Integer num) {
            this.forbidden = num;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestBodyUpdate(ReqType reqType) {
        super(reqType);
        Intrinsics.checkParameterIsNotNull(reqType, "reqType");
        this.deployments = new HashMap();
        this.local = new HashMap();
        if (reqType != ReqType.BYTESYNC) {
            initLocalVersion();
        }
    }

    public final void initLocalVersionByDeployments() {
        List<String> channels;
        boolean z;
        List<String> noLocalAks = GeckoStore.INSTANCE.getNoLocalAks();
        for (String str : this.deployments.keySet()) {
            if (noLocalAks == null || !noLocalAks.contains(str)) {
                HashMap hashMap = new HashMap();
                DeploymentsData deploymentsData = this.deployments.get(str);
                if (deploymentsData != null && (channels = deploymentsData.getChannels()) != null) {
                    for (String str2 : channels) {
                        LocalData localData = new LocalData();
                        PrepareMeta updateMeta = PrepareMetaManager.INSTANCE.getUpdateMeta(str, str2);
                        if (updateMeta != null) {
                            localData.setPrepareMetaId(Long.valueOf(updateMeta.getVersion()));
                            localData.setHashVersion(updateMeta.getHashVersion());
                            z = true;
                        } else {
                            z = false;
                        }
                        ChannelMeta meta = ChannelMetaManager.INSTANCE.getMeta(str, str2);
                        if ((meta != null ? meta.getId() : null) != null) {
                            localData.setAvailableMetaId(meta.getId());
                            if (meta.getForbidden()) {
                                localData.setForbidden(1);
                            }
                            z = true;
                        }
                        if (z) {
                            hashMap.put(str2, localData);
                        }
                    }
                }
                if (!hashMap.isEmpty()) {
                    this.local.put(str, hashMap);
                }
            }
        }
    }

    private final void initLocalVersion() {
        boolean z;
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        Map accessKeyDirs = inst.getAccessKeyDirs();
        List<String> noLocalAks = GeckoStore.INSTANCE.getNoLocalAks();
        for (String str : accessKeyDirs.keySet()) {
            if (noLocalAks == null || !noLocalAks.contains(str)) {
                HashMap hashMap = new HashMap();
                PrepareMetaManager prepareMetaManager = PrepareMetaManager.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(str, "accessKey");
                Map<String, PrepareMeta> metas = prepareMetaManager.getMetas(str);
                if (metas != null) {
                    for (Map.Entry<String, PrepareMeta> entry : metas.entrySet()) {
                        LocalData localData = new LocalData();
                        localData.setPrepareMetaId(Long.valueOf(entry.getValue().getVersion()));
                        localData.setHashVersion(entry.getValue().getHashVersion());
                        hashMap.put(entry.getKey(), localData);
                    }
                }
                ConcurrentHashMap<String, Boolean> concurrentHashMap = checkDirFinish;
                if (!Intrinsics.areEqual(concurrentHashMap.get(str), true)) {
                    concurrentHashMap.put(str, true);
                    z = true;
                } else {
                    z = false;
                }
                File file = new File((String) accessKeyDirs.get(str), str);
                Map<String, ChannelMeta> metas2 = ChannelMetaManager.INSTANCE.getMetas(str);
                if (metas2 != null) {
                    for (Map.Entry<String, ChannelMeta> entry2 : metas2.entrySet()) {
                        String key = entry2.getKey();
                        Long id = entry2.getValue().getId();
                        if (id != null) {
                            long longValue = id.longValue();
                            if (z && !new File(new File(file, key), String.valueOf(longValue)).exists()) {
                                UploadStatistic.INSTANCE.uploadEvent(EventSubType.META_CHECK_DIR_ERROR, str, key, entry2.toString());
                                ChannelMetaManager.INSTANCE.removeChannel(str, key);
                            } else {
                                LocalData localData2 = hashMap.get(key);
                                if (localData2 == null) {
                                    localData2 = new LocalData();
                                    hashMap.put(key, localData2);
                                }
                                localData2.setAvailableMetaId(Long.valueOf(longValue));
                                if (entry2.getValue().getForbidden()) {
                                    localData2.setForbidden(1);
                                }
                            }
                        }
                    }
                }
                if (!hashMap.isEmpty()) {
                    this.local.put(str, hashMap);
                }
            }
        }
    }

    public final Long getLocalVersion(String accessKey, String channel) {
        LocalData localData;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Map<String, LocalData> map = this.local.get(accessKey);
        if (map == null || (localData = map.get(channel)) == null) {
            return null;
        }
        return localData.getAvailableMetaId();
    }

    public final void initCustom(List<String> accessKeys) {
        Intrinsics.checkParameterIsNotNull(accessKeys, "accessKeys");
        initCustom$default(this, accessKeys, null, null, 4, null);
    }

    public final void initCustom() {
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        initCustom$default(this, CollectionsKt.toList(inst.getAccessKeyDirs().keySet()), null, null, 4, null);
    }

    public static /* synthetic */ void initCustom$default(RequestBodyUpdate requestBodyUpdate, List list, GeckoUpdateParams geckoUpdateParams, OptionCheckUpdateParams optionCheckUpdateParams, int i, Object obj) {
        if ((i & 4) != 0) {
            optionCheckUpdateParams = null;
        }
        requestBodyUpdate.initCustom(list, geckoUpdateParams, optionCheckUpdateParams);
    }

    public final void initCustom(List<String> accessKeys, GeckoUpdateParams params, OptionCheckUpdateParams oldParams) {
        Map customParam;
        Map map;
        Map customParams;
        Intrinsics.checkParameterIsNotNull(accessKeys, "accessKeys");
        Map<String, ConcurrentHashMap<String, String>> customParams2 = RegisterManager.INSTANCE.getCustomParams();
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
        for (String str : accessKeys) {
            HashMap hashMap = new HashMap();
            ConcurrentHashMap<String, String> concurrentHashMap = customParams2.get(str);
            if (concurrentHashMap != null) {
                for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            CharSequence charSequence = (CharSequence) hashMap.get("business_version");
            if ((charSequence == null || charSequence.length() == 0) && globalConfig != null) {
                String appVersion = globalConfig.getAppVersion();
                Intrinsics.checkExpressionValueIsNotNull(appVersion, "globalConfig.appVersion");
                hashMap.put("business_version", appVersion);
            }
            if (Intrinsics.areEqual(str, params != null ? params.getAccessKey() : null) && (customParams = params.getCustomParams()) != null) {
                hashMap.putAll(customParams);
            }
            if (oldParams != null && (customParam = oldParams.getCustomParam()) != null && (map = (Map) customParam.get(str)) != null) {
                for (Map.Entry entry2 : map.entrySet()) {
                    Object key = entry2.getKey();
                    Intrinsics.checkExpressionValueIsNotNull(key, "it.key");
                    hashMap.put(key, entry2.getValue().toString());
                }
            }
            getCustom().put(str, hashMap);
        }
    }

    public final String getSortedDeployments() {
        StringBuilder sb = new StringBuilder();
        for (String str : CollectionsKt.sorted(this.deployments.keySet())) {
            StringBuilder append = new StringBuilder().append(str).append('-');
            DeploymentsData deploymentsData = this.deployments.get(str);
            sb.append(append.append(deploymentsData != null ? deploymentsData.getSortString() : null).toString());
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return sb2;
    }

    public final Map<String, List<Pair<String, Long>>> getRequestMap() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Map<String, LocalData>> entry : this.local.entrySet()) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, LocalData> entry2 : entry.getValue().entrySet()) {
                Long availableMetaId = entry2.getValue().getAvailableMetaId();
                if (availableMetaId != null) {
                    arrayList.add(new Pair(entry2.getKey(), Long.valueOf(availableMetaId.longValue())));
                }
            }
            hashMap.put(entry.getKey(), CollectionsKt.toList(arrayList));
        }
        return MapsKt.toMap(hashMap);
    }

    public final Map<String, Map<String, Long>> getLocalVersions() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Map<String, LocalData>> entry : this.local.entrySet()) {
            hashMap.put(entry.getKey(), new HashMap());
            for (Map.Entry<String, LocalData> entry2 : entry.getValue().entrySet()) {
                Long availableMetaId = entry2.getValue().getAvailableMetaId();
                if (availableMetaId != null) {
                    long longValue = availableMetaId.longValue();
                    Object obj = hashMap.get(entry.getKey());
                    if (obj == null) {
                        Intrinsics.throwNpe();
                    }
                    ((Map) obj).put(entry2.getKey(), Long.valueOf(longValue));
                }
            }
        }
        return hashMap;
    }
}
