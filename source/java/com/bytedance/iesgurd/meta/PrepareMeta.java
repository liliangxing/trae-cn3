package com.bytedance.iesgurd.meta;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.buffer.Buffer;
import com.bytedance.geckox.debug.GeckoKitDebug;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.Resources;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.policy.meta.MetaDataManager;
import com.bytedance.geckox.strategy.OccasionManager;
import com.bytedance.geckox.utils.ChannelState;
import com.bytedance.iesgurd.core.BlockType;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.iesgurd.strategy.StorageManager;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrepareMeta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0007\u0010\u009d\u0001\u001a\u00020\fJ\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0004J\u0007\u0010\u009f\u0001\u001a\u00020*J\b\u0010 \u0001\u001a\u00030¡\u0001J\u0010\u0010¢\u0001\u001a\u00030¡\u00012\u0006\u0010s\u001a\u00020SJ\t\u0010£\u0001\u001a\u00020\fH\u0002J\u0014\u0010¤\u0001\u001a\u00030¡\u00012\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0002J\t\u0010§\u0001\u001a\u00020\u0004H\u0016J\u0013\u0010¨\u0001\u001a\u00030¡\u00012\t\b\u0002\u0010©\u0001\u001a\u00020\fJ\n\u0010ª\u0001\u001a\u00030¡\u0001H\u0002J\b\u0010«\u0001\u001a\u00030¡\u0001J\n\u0010¬\u0001\u001a\u00030¡\u0001H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\nR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020#8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R \u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\b\"\u0004\b2\u0010\nR&\u00103\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\b\"\u0004\b;\u0010\nR\u001e\u0010=\u001a\u00020\f2\u0006\u0010<\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u000eR\u001e\u0010?\u001a\u00020\f2\u0006\u0010<\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u000eR\u001a\u0010A\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000e\"\u0004\bC\u0010\u0010R\u001a\u0010D\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010\u0010R\u001a\u0010F\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u000e\"\u0004\bG\u0010\u0010R\u001a\u0010H\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010%\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010%\"\u0004\bN\u0010KR\u001c\u0010O\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\b\"\u0004\bQ\u0010\nR\u000e\u0010R\u001a\u00020SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010T\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u000eR\u001a\u0010V\u001a\u00020WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0012\u0010\\\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010]\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010^\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010_\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010`\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u000e\"\u0004\bc\u0010\u0010R\u0010\u0010d\u001a\u00020W8\u0002X\u0083D¢\u0006\u0002\n\u0000R\u0012\u0010e\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010f\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010g\u001a\u00020hX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR \u0010m\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010,\"\u0004\bo\u0010.R\u001c\u0010p\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\b\"\u0004\br\u0010\nR\u001a\u0010s\u001a\u00020SX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0010\u0010x\u001a\u00020\u00048\u0002X\u0083D¢\u0006\u0002\n\u0000R\u001c\u0010y\u001a\u0004\u0018\u00010zX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001c\u0010\u007f\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010%\"\u0005\b\u0081\u0001\u0010KR\u001d\u0010\u0082\u0001\u001a\u00020#X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010%\"\u0005\b\u0084\u0001\u0010KR\"\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001d\u0010\u008b\u0001\u001a\u00020WX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010Y\"\u0005\b\u008d\u0001\u0010[R(\u0010\u008f\u0001\u001a\u00020\f2\u0007\u0010\u008e\u0001\u001a\u00020\f@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u000e\"\u0005\b\u0091\u0001\u0010\u0010R\u001d\u0010\u0092\u0001\u001a\u00020\u001dX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u001f\"\u0005\b\u0094\u0001\u0010!R\u0018\u0010\u0095\u0001\u001a\u00020\f8\u0006X\u0087D¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010\u000eR!\u0010\u0097\u0001\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u000e\"\u0005\b\u0099\u0001\u0010\u0010R\u001f\u0010\u009a\u0001\u001a\u00020#8FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010%\"\u0005\b\u009c\u0001\u0010K¨\u0006\u00ad\u0001"}, d2 = {"Lcom/bytedance/iesgurd/meta/PrepareMeta;", "", "()V", "accessKey", "", "channel", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "alwaysOnDemand", "", "getAlwaysOnDemand", "()Z", "setAlwaysOnDemand", "(Z)V", "apiVersion", "getApiVersion", "setApiVersion", "blockType", "Lcom/bytedance/iesgurd/core/BlockType;", "getBlockType", "()Lcom/bytedance/iesgurd/core/BlockType;", "setBlockType", "(Lcom/bytedance/iesgurd/core/BlockType;)V", "getChannel", "setChannel", "destDir", "Ljava/io/File;", "getDestDir", "()Ljava/io/File;", "setDestDir", "(Ljava/io/File;)V", "downloadDelay", "", "getDownloadDelay", "()J", "downloadFile", "getDownloadFile", "setDownloadFile", "fullPackage", "Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;", "getFullPackage", "()Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;", "setFullPackage", "(Lcom/bytedance/iesgurd/meta/PrepareMetaPackage;)V", "fullPatchStr", "groupName", "getGroupName", "setGroupName", "groups", "", "getGroups", "()Ljava/util/List;", "setGroups", "(Ljava/util/List;)V", "hashVersion", "getHashVersion", "setHashVersion", "<set-?>", "ignoreBlockList", "getIgnoreBlockList", "ignoreStorage", "getIgnoreStorage", "inQueue", "getInQueue", "setInQueue", "isRetry", "setRetry", "isSingleFile", "setSingleFile", "localVersion", "getLocalVersion", "setLocalVersion", "(J)V", "localVersionOld", "getLocalVersionOld", "setLocalVersionOld", "logId", "getLogId", "setLogId", "metaReqType", "Lcom/bytedance/iesgurd/core/ReqType;", "needAppLog", "getNeedAppLog", "notUsePatchReason", "", "getNotUsePatchReason", "()I", "setNotUsePatchReason", "(I)V", "odlCDNReceivedBytes", "odlDuration", "odlFallbackReason", "odlP2PReceivedBytes", "odlUseUrl", "onDemand", "getOnDemand", "setOnDemand", "onDemandEnum", "originCDNDuration", "originCDNReceivedBytes", "pack", "Lcom/bytedance/geckox/model/UpdatePackage;", "getPack", "()Lcom/bytedance/geckox/model/UpdatePackage;", "setPack", "(Lcom/bytedance/geckox/model/UpdatePackage;)V", "patch", "getPatch", "setPatch", "preTriggerChannel", "getPreTriggerChannel", "setPreTriggerChannel", "reqType", "getReqType", "()Lcom/bytedance/iesgurd/core/ReqType;", "setReqType", "(Lcom/bytedance/iesgurd/core/ReqType;)V", "resourceType", "statisticModel", "Lcom/bytedance/iesgurd/meta/UpdateStatisticModel;", "getStatisticModel", "()Lcom/bytedance/iesgurd/meta/UpdateStatisticModel;", "setStatisticModel", "(Lcom/bytedance/iesgurd/meta/UpdateStatisticModel;)V", "timeAddQueue", "getTimeAddQueue", "setTimeAddQueue", "timeUpdateStart", "getTimeUpdateStart", "setTimeUpdateStart", "updateBuffer", "Lcom/bytedance/geckox/buffer/Buffer;", "getUpdateBuffer", "()Lcom/bytedance/geckox/buffer/Buffer;", "setUpdateBuffer", "(Lcom/bytedance/geckox/buffer/Buffer;)V", "updatePriority", "getUpdatePriority", "setUpdatePriority", "value", "updateWithPatch", "getUpdateWithPatch", "setUpdateWithPatch", "updatingDir", "getUpdatingDir", "setUpdatingDir", "usePcdn", "getUsePcdn", "useZstd", "getUseZstd", "setUseZstd", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "getVersion", "setVersion", "checkOnDemandWhenUpdate", "checkValid", "getPackage", "ignoreBlocks", "", "initByRequest", "isOccasionUpdate", "putCommonData", "jsonObject", "Lorg/json/JSONObject;", "toString", "updateBlockType", "needLog", "updateOnDemandBySettings", "upload", "uploadPrepareMeta", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrepareMeta {

    @SerializedName("access_key")
    private String accessKey;
    private boolean alwaysOnDemand;
    private String apiVersion;
    private BlockType blockType;

    @SerializedName("channel_name")
    private String channel;
    public File destDir;

    @SerializedName("download_delay")
    private final long downloadDelay;
    public File downloadFile;

    @SerializedName("package")
    private PrepareMetaPackage fullPackage;
    private String fullPatchStr;

    @SerializedName("group_name")
    private String groupName;

    @SerializedName("groups")
    private List<String> groups;

    @SerializedName("hash_version")
    private String hashVersion;
    private boolean ignoreBlockList;
    private boolean ignoreStorage;
    private boolean inQueue;
    private boolean isRetry;
    private boolean isSingleFile;
    private long localVersion;
    private long localVersionOld;
    private String logId;
    private ReqType metaReqType;

    @SerializedName("need_app_log")
    private final boolean needAppLog;
    private int notUsePatchReason;
    public long odlCDNReceivedBytes;
    public long odlDuration;
    public String odlFallbackReason;
    public long odlP2PReceivedBytes;
    public String odlUseUrl;
    private boolean onDemand;

    @SerializedName("on_demand")
    private final int onDemandEnum;
    public long originCDNDuration;
    public long originCDNReceivedBytes;
    public UpdatePackage pack;

    @SerializedName("patch")
    private PrepareMetaPackage patch;
    private String preTriggerChannel;
    private ReqType reqType;

    @SerializedName("resource_type")
    private final String resourceType;
    private UpdateStatisticModel statisticModel;
    private long timeAddQueue;
    private long timeUpdateStart;
    private Buffer updateBuffer;
    private int updatePriority;
    private boolean updateWithPatch;
    public File updatingDir;

    @SerializedName("use_pcdn")
    private final boolean usePcdn;

    @SerializedName("use_zstd")
    private boolean useZstd;
    private long version;

    public final PrepareMetaPackage getFullPackage() {
        return this.fullPackage;
    }

    public final void setFullPackage(PrepareMetaPackage prepareMetaPackage) {
        this.fullPackage = prepareMetaPackage;
    }

    public final PrepareMetaPackage getPatch() {
        return this.patch;
    }

    public final void setPatch(PrepareMetaPackage prepareMetaPackage) {
        this.patch = prepareMetaPackage;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final void setAccessKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.accessKey = str;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.channel = str;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final void setGroupName(String str) {
        this.groupName = str;
    }

    public final long getDownloadDelay() {
        return this.downloadDelay;
    }

    public final boolean getUseZstd() {
        return this.useZstd;
    }

    public final void setUseZstd(boolean z) {
        this.useZstd = z;
    }

    public final boolean getUsePcdn() {
        return this.usePcdn;
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public final void setGroups(List<String> list) {
        this.groups = list;
    }

    public final boolean getNeedAppLog() {
        return this.needAppLog;
    }

    public final String getHashVersion() {
        return this.hashVersion;
    }

    public final void setHashVersion(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.hashVersion = str;
    }

    public final boolean getOnDemand() {
        return this.onDemand;
    }

    public final void setOnDemand(boolean z) {
        this.onDemand = z;
    }

    public final boolean getAlwaysOnDemand() {
        return this.alwaysOnDemand;
    }

    public final void setAlwaysOnDemand(boolean z) {
        this.alwaysOnDemand = z;
    }

    public final void setVersion(long j) {
        this.version = j;
    }

    public final long getVersion() {
        PrepareMetaPackage prepareMetaPackage = this.fullPackage;
        return prepareMetaPackage != null ? prepareMetaPackage.getId() : this.version;
    }

    public final ReqType getReqType() {
        return this.reqType;
    }

    public final void setReqType(ReqType reqType) {
        Intrinsics.checkParameterIsNotNull(reqType, "<set-?>");
        this.reqType = reqType;
    }

    public final int getUpdatePriority() {
        return this.updatePriority;
    }

    public final void setUpdatePriority(int i) {
        this.updatePriority = i;
    }

    public final BlockType getBlockType() {
        return this.blockType;
    }

    public final void setBlockType(BlockType blockType) {
        this.blockType = blockType;
    }

    /* renamed from: isSingleFile, reason: from getter */
    public final boolean getIsSingleFile() {
        return this.isSingleFile;
    }

    public final void setSingleFile(boolean z) {
        this.isSingleFile = z;
    }

    public final boolean getIgnoreStorage() {
        return this.ignoreStorage;
    }

    public final boolean getIgnoreBlockList() {
        return this.ignoreBlockList;
    }

    public final long getLocalVersion() {
        return this.localVersion;
    }

    public final void setLocalVersion(long j) {
        this.localVersion = j;
    }

    public final long getLocalVersionOld() {
        return this.localVersionOld;
    }

    public final void setLocalVersionOld(long j) {
        this.localVersionOld = j;
    }

    public final boolean getUpdateWithPatch() {
        return this.updateWithPatch;
    }

    public final void setUpdateWithPatch(boolean z) {
        this.fullPatchStr = z ? "patch" : "full";
        this.updateWithPatch = z;
    }

    public final int getNotUsePatchReason() {
        return this.notUsePatchReason;
    }

    public final void setNotUsePatchReason(int i) {
        this.notUsePatchReason = i;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final void setLogId(String str) {
        this.logId = str;
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final void setApiVersion(String str) {
        this.apiVersion = str;
    }

    /* renamed from: isRetry, reason: from getter */
    public final boolean getIsRetry() {
        return this.isRetry;
    }

    public final void setRetry(boolean z) {
        this.isRetry = z;
    }

    public final UpdateStatisticModel getStatisticModel() {
        return this.statisticModel;
    }

    public final void setStatisticModel(UpdateStatisticModel updateStatisticModel) {
        this.statisticModel = updateStatisticModel;
    }

    public final Buffer getUpdateBuffer() {
        return this.updateBuffer;
    }

    public final void setUpdateBuffer(Buffer buffer) {
        this.updateBuffer = buffer;
    }

    public final File getDestDir() {
        File file = this.destDir;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destDir");
        }
        return file;
    }

    public final void setDestDir(File file) {
        Intrinsics.checkParameterIsNotNull(file, "<set-?>");
        this.destDir = file;
    }

    public final File getUpdatingDir() {
        File file = this.updatingDir;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("updatingDir");
        }
        return file;
    }

    public final void setUpdatingDir(File file) {
        Intrinsics.checkParameterIsNotNull(file, "<set-?>");
        this.updatingDir = file;
    }

    public final File getDownloadFile() {
        File file = this.downloadFile;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadFile");
        }
        return file;
    }

    public final void setDownloadFile(File file) {
        Intrinsics.checkParameterIsNotNull(file, "<set-?>");
        this.downloadFile = file;
    }

    public final long getTimeAddQueue() {
        return this.timeAddQueue;
    }

    public final void setTimeAddQueue(long j) {
        this.timeAddQueue = j;
    }

    public final long getTimeUpdateStart() {
        return this.timeUpdateStart;
    }

    public final void setTimeUpdateStart(long j) {
        this.timeUpdateStart = j;
    }

    public final boolean getInQueue() {
        return this.inQueue;
    }

    public final void setInQueue(boolean z) {
        this.inQueue = z;
    }

    public final String getPreTriggerChannel() {
        return this.preTriggerChannel;
    }

    public final void setPreTriggerChannel(String str) {
        this.preTriggerChannel = str;
    }

    public final UpdatePackage getPack() {
        UpdatePackage updatePackage = this.pack;
        if (updatePackage == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pack");
        }
        return updatePackage;
    }

    public final void setPack(UpdatePackage updatePackage) {
        Intrinsics.checkParameterIsNotNull(updatePackage, "<set-?>");
        this.pack = updatePackage;
    }

    public final void ignoreBlocks() {
        this.ignoreStorage = true;
        this.ignoreBlockList = true;
    }

    public PrepareMeta() {
        this.accessKey = "";
        this.channel = "";
        this.resourceType = "";
        this.useZstd = true;
        this.hashVersion = "";
        this.metaReqType = ReqType.NONE;
        this.reqType = ReqType.NONE;
        this.updatePriority = -1;
        this.fullPatchStr = "full";
        this.odlUseUrl = "";
        this.odlDuration = -1L;
        this.odlP2PReceivedBytes = -1L;
        this.odlCDNReceivedBytes = -1L;
        this.originCDNDuration = -1L;
        this.originCDNReceivedBytes = -1L;
    }

    public PrepareMeta(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "accessKey");
        Intrinsics.checkParameterIsNotNull(str2, "channel");
        this.accessKey = "";
        this.channel = "";
        this.resourceType = "";
        this.useZstd = true;
        this.hashVersion = "";
        this.metaReqType = ReqType.NONE;
        this.reqType = ReqType.NONE;
        this.updatePriority = -1;
        this.fullPatchStr = "full";
        this.odlUseUrl = "";
        this.odlDuration = -1L;
        this.odlP2PReceivedBytes = -1L;
        this.odlCDNReceivedBytes = -1L;
        this.originCDNDuration = -1L;
        this.originCDNReceivedBytes = -1L;
        this.channel = str2;
        this.accessKey = str;
        this.pack = new UpdatePackage(str, str2, 0L, 4, (DefaultConstructorMarker) null);
    }

    public final PrepareMetaPackage getPackage() {
        PrepareMetaPackage prepareMetaPackage;
        if (!this.updateWithPatch ? (prepareMetaPackage = this.fullPackage) == null : (prepareMetaPackage = this.patch) == null) {
            Intrinsics.throwNpe();
        }
        return prepareMetaPackage;
    }

    public String toString() {
        return this.accessKey + '-' + this.channel + '-' + getVersion() + '-' + this.fullPatchStr;
    }

    private final void updateOnDemandBySettings() {
        Resources resources;
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        AppSettingsManager.IGeckoAppSettings geckoAppSettings = inst.getGeckoAppSettings();
        if (geckoAppSettings != null) {
            Intrinsics.checkExpressionValueIsNotNull(geckoAppSettings, "AppSettingsManager.inst(…eckoAppSettings ?: return");
            if (geckoAppSettings.getOnDemandPolicy() == 0) {
                return;
            }
            Map onDemandList = geckoAppSettings.getOnDemandList();
            if ((onDemandList == null || onDemandList.isEmpty()) || (resources = (Resources) geckoAppSettings.getOnDemandList().get(this.accessKey)) == null) {
                return;
            }
            if (!(resources.getChannels() == null && resources.getGroups() == null) && resources.isHit$geckox_noasanRelease(this.groups, this.channel)) {
                if (geckoAppSettings.getOnDemandPolicy() == 1) {
                    this.onDemand = true;
                } else if (geckoAppSettings.getOnDemandPolicy() == 2) {
                    this.onDemand = true;
                    this.alwaysOnDemand = true;
                }
            }
        }
    }

    public final String checkValid() {
        String str = this.accessKey;
        if (!(str == null || str.length() == 0)) {
            String str2 = this.channel;
            if (!(str2 == null || str2.length() == 0) && getVersion() > 0) {
                PrepareMetaPackage prepareMetaPackage = this.fullPackage;
                if (prepareMetaPackage != null && !prepareMetaPackage.checkValid()) {
                    return String.valueOf(this.fullPackage);
                }
                PrepareMetaPackage prepareMetaPackage2 = this.patch;
                if (prepareMetaPackage2 == null || prepareMetaPackage2.checkValid()) {
                    return null;
                }
                return String.valueOf(this.patch);
            }
        }
        return toString();
    }

    public final void initByRequest(ReqType reqType) {
        Intrinsics.checkParameterIsNotNull(reqType, "reqType");
        this.pack = new UpdatePackage(this.accessKey, this.channel, getVersion());
        this.reqType = reqType;
        this.metaReqType = reqType;
        this.isSingleFile = Intrinsics.areEqual(this.resourceType, "UNCOMPRESSED_SINGLE_FILE");
        int i = this.onDemandEnum;
        if (i == 1) {
            this.onDemand = true;
        } else if (i == 2) {
            this.onDemand = true;
            this.alwaysOnDemand = true;
        }
        if (this.needAppLog || GeckoKitDebug.INSTANCE.isUnitTest()) {
            updateBlockType(false);
            uploadPrepareMeta();
        }
        StringBuilder append = new StringBuilder("prepare_meta: ").append(this.accessKey).append('-').append(this.channel).append('-').append(getVersion()).append('-').append(this.groups).append('-').append(this.blockType).append('-');
        PrepareMetaPackage prepareMetaPackage = this.patch;
        GeckoLogger.d(append.append(prepareMetaPackage != null ? Long.valueOf(prepareMetaPackage.getId()) : null).append("-delay:").append(this.downloadDelay).append("-onDemandEnum:").append(this.onDemandEnum).append("-onDemand:").append(this.onDemand).append("-alwaysOnDemand:").append(this.alwaysOnDemand).append(']').toString());
    }

    public final boolean checkOnDemandWhenUpdate() {
        updateOnDemandBySettings();
        if (!this.onDemand) {
            return false;
        }
        String str = this.accessKey;
        String str2 = this.channel;
        if (this.alwaysOnDemand || !ChannelState.INSTANCE.isChannelUsed(str, str2)) {
            return true;
        }
        GeckoLogger.d(str + '-' + str2 + " used, do update");
        return false;
    }

    public static /* synthetic */ void updateBlockType$default(PrepareMeta prepareMeta, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        prepareMeta.updateBlockType(z);
    }

    public final void updateBlockType(boolean needLog) {
        BlockType blockType = this.blockType;
        this.blockType = null;
        if (checkOnDemandWhenUpdate()) {
            this.blockType = BlockType.LAZY_UPDATE;
        } else if (MetaDataManager.INSTANCE.filterMetaDataUpdate$geckox_noasanRelease(this)) {
            this.blockType = BlockType.CLEAN_BLOCKLIST;
        } else if (isOccasionUpdate()) {
            this.blockType = BlockType.OCCASION_UPDATE;
        } else if (!StorageManager.INSTANCE.checkNeedUpdate(this)) {
            this.blockType = BlockType.LOW_STORAGE;
        } else if (MetaDataManager.INSTANCE.filterMetaDataUpdate(this.accessKey, this.channel, this.groups)) {
            this.blockType = BlockType.CLEAN_BLOCKLIST;
        }
        if (!needLog || this.blockType == blockType) {
            return;
        }
        GeckoLogger.d(this.accessKey + '_' + this.channel + " block type from " + blockType + " to " + this.blockType);
    }

    private final boolean isOccasionUpdate() {
        if (this.reqType == ReqType.POLLING || this.reqType == ReqType.QUEUE) {
            return OccasionManager.INSTANCE.isOccasionUpdate(this);
        }
        return false;
    }

    public final void upload() {
        JSONObject jSONObject = new JSONObject();
        putCommonData(jSONObject);
        jSONObject.put("time_update_start", this.timeUpdateStart);
        jSONObject.put("dur_wait_download", this.timeUpdateStart - this.timeAddQueue);
        jSONObject.put("meta_req_type", this.metaReqType.getType());
        long j = this.localVersionOld;
        if (j != 0) {
            jSONObject.put("local_version_old", j);
        }
        int i = this.notUsePatchReason;
        if (i != 0) {
            jSONObject.put("not_use_patch_reason", i);
        }
        if (this.updateWithPatch) {
            PrepareMetaPackage prepareMetaPackage = this.patch;
            jSONObject.put("package_size", prepareMetaPackage != null ? Long.valueOf(prepareMetaPackage.getLength()) : null);
        } else {
            PrepareMetaPackage prepareMetaPackage2 = this.fullPackage;
            jSONObject.put("package_size", prepareMetaPackage2 != null ? Long.valueOf(prepareMetaPackage2.getLength()) : null);
        }
        UpdateStatisticModel updateStatisticModel = this.statisticModel;
        if (updateStatisticModel != null) {
            updateStatisticModel.putDataToJson(jSONObject);
        }
        String str = this.preTriggerChannel;
        if (str != null) {
            jSONObject.put("pre_trigger_channel", str);
        }
        if (this.isRetry) {
            jSONObject.put("is_retry", 1);
        }
        if (this.usePcdn) {
            jSONObject.put("should_use_odl", 1);
            String str2 = this.odlFallbackReason;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("odl_fallback_reason", str2);
            jSONObject.put("odl_use_url", this.odlUseUrl);
            jSONObject.put("odl_duration", this.odlDuration);
            jSONObject.put("odl_p2p_received_bytes", this.odlP2PReceivedBytes);
            jSONObject.put("odl_cdn_received_bytes", this.odlCDNReceivedBytes);
            jSONObject.put("origin_cdn_duration", this.originCDNDuration);
            jSONObject.put("origin_cdn_received_bytes", this.originCDNReceivedBytes);
        }
        UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_update_aggr_stats", jSONObject);
    }

    private final void uploadPrepareMeta() {
        UltraUpdateResource ultraUpdateResource;
        JSONObject jSONObject = new JSONObject();
        putCommonData(jSONObject);
        if (this.usePcdn) {
            jSONObject.put("use_pcdn", 1);
        }
        PrepareMetaPackage prepareMetaPackage = this.fullPackage;
        if (prepareMetaPackage != null && (ultraUpdateResource = prepareMetaPackage.getUltraUpdateResource()) != null) {
            jSONObject.put("ultra_update_resource", ultraUpdateResource.toString());
        }
        UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_prepare_meta_stats", jSONObject);
    }

    private final void putCommonData(JSONObject jsonObject) {
        jsonObject.put("access_key", this.accessKey);
        jsonObject.put("channel", this.channel);
        jsonObject.put("req_type", this.reqType.getType());
        jsonObject.put("id", getVersion());
        jsonObject.put("is_zstd", this.useZstd ? 1 : 0);
        jsonObject.put("api_version", this.apiVersion);
        jsonObject.put("update_priority", this.updatePriority);
        jsonObject.put("hash_version", this.hashVersion);
        boolean z = true;
        if (this.isSingleFile) {
            jsonObject.put("is_single_file", 1);
        }
        String str = this.groupName;
        if (str != null) {
            jsonObject.put("group_name", str);
        }
        String str2 = this.logId;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (!z) {
            jsonObject.put("x_tt_logid", this.logId);
        }
        long j = this.localVersion;
        if (j != 0) {
            jsonObject.put("local_version", j);
        }
        PrepareMetaPackage prepareMetaPackage = this.patch;
        if (prepareMetaPackage != null) {
            if (prepareMetaPackage == null) {
                Intrinsics.throwNpe();
            }
            jsonObject.put("patch_id", prepareMetaPackage.getId());
        }
        BlockType blockType = this.blockType;
        if (blockType != null) {
            jsonObject.put("block_type", blockType.getType());
        }
        long j2 = this.downloadDelay;
        if (j2 > 0) {
            jsonObject.put("download_delay", j2);
        }
        List<String> list = this.groups;
        if (list != null) {
            jsonObject.put("groups", list.toString());
        }
    }
}
