package com.bytedance.iesgurd.loader;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.net.NetResponse;
import com.bytedance.geckox.net.TTNetImpl;
import com.bytedance.geckox.utils.FileUtils;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.iesgurd.IESGurdKit;
import com.bytedance.iesgurd.IESGurdResData;
import com.bytedance.iesgurd.IESGurdResError;
import com.bytedance.iesgurd.IESGurdResFrom;
import com.bytedance.iesgurd.IESGurdResParams;
import com.bytedance.iesgurd.core.BlockType;
import com.bytedance.iesgurd.core.ResCdnCode;
import com.bytedance.iesgurd.core.ResOfflineCode;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.meta.PrepareMetaPackage;
import com.bytedance.iesgurd.meta.UltraUpdateResource;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.iesgurd.update.UpdateQueue;
import com.bytedance.notification.Constants;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.retrofit2.client.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ResLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u001c\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0006\u0010#\u001a\u00020\u0007J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0007J\b\u0010(\u001a\u00020\u0006H\u0002J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u0012H\u0002J \u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u0002002\u0006\u0010!\u001a\u00020\u0006H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/iesgurd/loader/ResLoader;", "", "params", "Lcom/bytedance/iesgurd/IESGurdResParams;", "callback", "Lkotlin/Function1;", "Lcom/bytedance/iesgurd/IESGurdResData;", "", "(Lcom/bytedance/iesgurd/IESGurdResParams;Lkotlin/jvm/functions/Function1;)V", "accessKey", "", "accessTime", "", SchemaConstants.QUERY_KEY_BUNDLE, "channel", "failedTimes", "", "handleAccess", "", "id", "metaDataPair", "Lkotlin/Pair;", "resource", "Lcom/bytedance/iesgurd/meta/UltraUpdateResource;", "startTime", Constants.NOTIFICATION_TAG, "addCommonEventData", "json", "Lorg/json/JSONObject;", "error", "Lcom/bytedance/iesgurd/IESGurdResError;", "downloadWithIndex", "index", "data", "excuteCallback", "getData", "getOfflineData", "needData", "getPath", "getPathIgnoreAccess", "getResPath", "handleAccessActions", "type", "loadUltraUpdateResource", "needHandleAccess", "uploadEventAfterCdn", "url", "response", "Lcom/bytedance/geckox/net/NetResponse;", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ResLoader {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Long> channelAccessTime = new ConcurrentHashMap();
    private final String accessKey;
    private final long accessTime;
    private final String bundle;
    private final Function1<IESGurdResData, Unit> callback;
    private final String channel;
    private int failedTimes;
    private boolean handleAccess;
    private long id;
    private Pair<Boolean, Long> metaDataPair;
    private final IESGurdResParams params;
    private UltraUpdateResource resource;
    private long startTime;
    private final String tag;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[BlockType.LAZY_UPDATE.ordinal()] = 1;
            iArr[BlockType.CLEAN_BLOCKLIST.ordinal()] = 2;
            iArr[BlockType.LOW_STORAGE.ordinal()] = 3;
            iArr[BlockType.OCCASION_UPDATE.ordinal()] = 4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResLoader(IESGurdResParams iESGurdResParams, Function1<? super IESGurdResData, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(iESGurdResParams, "params");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        this.params = iESGurdResParams;
        this.callback = function1;
        this.tag = iESGurdResParams.getTag();
        this.accessKey = iESGurdResParams.getAccessKey();
        this.channel = iESGurdResParams.getChannel();
        this.bundle = iESGurdResParams.getBundle();
        this.accessTime = System.currentTimeMillis();
    }

    /* compiled from: ResLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/iesgurd/loader/ResLoader$Companion;", "", "()V", "channelAccessTime", "", "", "", "resetForTest", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void resetForTest() {
            ResLoader.channelAccessTime.clear();
        }
    }

    public final void getPath() {
        GeckoLogger.d("getPath: " + this.params);
        IESGurdResData resPath = getResPath();
        IESGurdResError error = resPath.getError();
        if (error == null || error.getOfflineCode() != ResOfflineCode.INVALID_PARAMS.getType()) {
            handleAccessActions("getPath", resPath);
        }
        excuteCallback(resPath);
    }

    public final void getPathIgnoreAccess() {
        GeckoLogger.d("getPathIgnoreAccess: " + this.params);
        excuteCallback(getResPath());
    }

    private final IESGurdResData getResPath() {
        if (!(this.tag.length() == 0)) {
            if (!(this.accessKey.length() == 0)) {
                if (!(this.channel.length() == 0)) {
                    if (!(this.bundle.length() == 0)) {
                        IESGurdResData offlineData = getOfflineData(false);
                        IESGurdResError error = offlineData.getError();
                        if (error == null) {
                            return offlineData;
                        }
                        if (this.params.getOnlyOffline()) {
                            error.setCdnCode(ResCdnCode.ONLY_OFFLINE.getType());
                            error.setCdnMessage("only offline");
                            return offlineData;
                        }
                        if (!loadUltraUpdateResource(error)) {
                            return offlineData;
                        }
                        UltraUpdateResource ultraUpdateResource = this.resource;
                        if (ultraUpdateResource == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("resource");
                        }
                        return new IESGurdResData(error, IESGurdResFrom.OFFLINE_FROM_CDN, this.id, ultraUpdateResource.getUrl(0, this.channel, this.bundle), null, 16, null);
                    }
                }
            }
        }
        return new IESGurdResData(new IESGurdResError(ResOfflineCode.INVALID_PARAMS.getType(), "invalid params: " + this.tag + '-' + this.accessKey + '-' + this.channel + '-' + this.bundle, 0, null, 12, null), null, 0L, null, null, 30, null);
    }

    private final void excuteCallback(IESGurdResData data) {
        GeckoLogger.d("ResLoader excuteCallback: " + this.params + ", " + data);
        this.callback.invoke(data);
    }

    public final void getData() {
        GeckoLogger.d("getData: " + this.params);
        if (!(this.tag.length() == 0)) {
            if (!(this.accessKey.length() == 0)) {
                if (!(this.channel.length() == 0)) {
                    if (!(this.bundle.length() == 0)) {
                        final IESGurdResData offlineData = getOfflineData(true);
                        IESGurdResError error = offlineData.getError();
                        if (error == null) {
                            handleAccessActions("getData", offlineData);
                            excuteCallback(offlineData);
                            return;
                        }
                        if (this.params.getOnlyOffline()) {
                            error.setCdnCode(ResCdnCode.ONLY_OFFLINE.getType());
                            error.setCdnMessage("only offline");
                            excuteCallback(offlineData);
                            return;
                        } else {
                            if (!loadUltraUpdateResource(error)) {
                                handleAccessActions("getData", offlineData);
                                excuteCallback(offlineData);
                                return;
                            }
                            boolean needHandleAccess = needHandleAccess();
                            this.handleAccess = needHandleAccess;
                            if (needHandleAccess) {
                                GeckoExecutors.INSTANCE.getAccessExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.loader.ResLoader$getData$1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        String str;
                                        String str2;
                                        long j;
                                        long j2;
                                        ResLoader resLoader = ResLoader.this;
                                        AccessManager accessManager = AccessManager.INSTANCE;
                                        str = ResLoader.this.accessKey;
                                        str2 = ResLoader.this.channel;
                                        j = ResLoader.this.id;
                                        j2 = ResLoader.this.accessTime;
                                        resLoader.metaDataPair = accessManager.runAccessActions(str, str2, j, 0L, j2);
                                    }
                                });
                            }
                            this.startTime = System.currentTimeMillis();
                            if (this.params.getGetCdnSync()) {
                                downloadWithIndex(0, offlineData);
                                return;
                            } else {
                                GeckoExecutors.INSTANCE.runInBackground(new Function0<Unit>() { // from class: com.bytedance.iesgurd.loader.ResLoader$getData$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m642invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: collision with other method in class */
                                    public final void m642invoke() {
                                        ResLoader.this.downloadWithIndex(0, offlineData);
                                    }
                                });
                                return;
                            }
                        }
                    }
                }
            }
        }
        excuteCallback(new IESGurdResData(new IESGurdResError(ResOfflineCode.INVALID_PARAMS.getType(), "invalid params: " + this.tag + '-' + this.accessKey + '-' + this.channel + '-' + this.bundle, 0, null, 12, null), null, 0L, null, null, 30, null));
    }

    private final IESGurdResData getOfflineData(boolean needData) {
        String rootDir = this.params.getRootDir();
        if (rootDir == null) {
            GeckoGlobalManager inst = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
            rootDir = (String) inst.getAccessKeyDirs().get(this.accessKey);
            String str = rootDir;
            if (str == null || str.length() == 0) {
                return new IESGurdResData(new IESGurdResError(ResOfflineCode.ACCESS_KEY_DIR_NOT_REGISTER.getType(), "accesskey dir not register", 0, null, 12, null), null, 0L, null, null, 30, null);
            }
        }
        ChannelMeta meta = ChannelMetaManager.INSTANCE.getMeta(this.accessKey, this.channel);
        Long id = meta != null ? meta.getId() : null;
        if (id == null) {
            PrepareMeta updateMeta = PrepareMetaManager.INSTANCE.getUpdateMeta(this.accessKey, this.channel);
            if (updateMeta == null) {
                return new IESGurdResData(new IESGurdResError(ResOfflineCode.NO_PREPARE_META.getType(), "prepare meta not exists", 0, null, 12, null), null, 0L, null, null, 30, null);
            }
            BlockType blockType = updateMeta.getBlockType();
            if (blockType != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[blockType.ordinal()];
                if (i == 1) {
                    return new IESGurdResData(new IESGurdResError(ResOfflineCode.BLOCK_BY_ON_DEMAND.getType(), "block by on demand", 0, null, 12, null), null, 0L, null, null, 30, null);
                }
                if (i == 2) {
                    return new IESGurdResData(new IESGurdResError(ResOfflineCode.BLOCK_BY_CLEAN_BLOCK_LIST.getType(), "block by clean blocklist", 0, null, 12, null), null, 0L, null, null, 30, null);
                }
                if (i == 3) {
                    return new IESGurdResData(new IESGurdResError(ResOfflineCode.BLOCK_BY_LOW_STORAGE.getType(), "block by low storage", 0, null, 12, null), null, 0L, null, null, 30, null);
                }
                if (i == 4) {
                    return new IESGurdResData(new IESGurdResError(ResOfflineCode.BLOCK_BY_OCCASION_UPDATE.getType(), "block by occasion update", 0, null, 12, null), null, 0L, null, null, 30, null);
                }
            }
            if (UpdateQueue.INSTANCE.checkIsUpdating(this.accessKey, this.channel)) {
                return new IESGurdResData(new IESGurdResError(ResOfflineCode.UPDATING.getType(), "updating", 0, null, 12, null), null, 0L, null, null, 30, null);
            }
            return new IESGurdResData(new IESGurdResError(ResOfflineCode.WAIT_UPDATE.getType(), "wait update", 0, null, 12, null), null, 0L, null, null, 30, null);
        }
        if (meta.getForbidden()) {
            return new IESGurdResData(new IESGurdResError(ResOfflineCode.VERSION_IS_FORBIDDEN.getType(), "local version is forbidden: " + id, 0, null, 12, null), null, 0L, null, null, 30, null);
        }
        File file = new File(rootDir + '/' + this.accessKey + '/' + this.channel + '/' + id);
        if (!file.exists()) {
            return new IESGurdResData(new IESGurdResError(ResOfflineCode.NO_VERSION_FILE.getType(), "version dir not exists: " + id, 0, null, 12, null), null, 0L, null, null, 30, null);
        }
        if (needData && GkFSUtils.INSTANCE.isEnable()) {
            File file2 = new File(file, "res/" + GkFSUtils.INSTANCE.convertBundlePath(this.accessKey, this.channel, this.bundle));
            if (file2.exists()) {
                IESGurdResData iESGurdResData = new IESGurdResData(null, IESGurdResFrom.OFFLINE, id.longValue(), file2.getAbsolutePath(), null, 16, null);
                if (needData) {
                    iESGurdResData.setData((InputStream) new GkFSFileInputStream(file2));
                }
                return iESGurdResData;
            }
        }
        File file3 = new File(file, "res/" + this.bundle);
        if (!file3.exists()) {
            return new IESGurdResData(new IESGurdResError(ResOfflineCode.NO_BUNDLE_FILE.getType(), "bundle file not exists: " + id + '-' + this.bundle, 0, null, 12, null), null, 0L, null, null, 30, null);
        }
        AppSettingsManager inst2 = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst2, "AppSettingsManager.inst()");
        if (inst2.isCheckFileBrokenNew()) {
            try {
                FileUtils.INSTANCE.checkLynxFileBroken(file3);
            } catch (Throwable unused) {
                FileUtils.INSTANCE.uploadFileBrokenEvent(this.accessKey, this.channel, file3, this.bundle);
                IESGurdKit.INSTANCE.cleanCache(this.accessKey, this.channel);
                return new IESGurdResData(new IESGurdResError(ResOfflineCode.CHECK_FILE_BROKEN.getType(), "file was broken", 0, null, 12, null), null, 0L, null, null, 30, null);
            }
        }
        IESGurdResData iESGurdResData2 = new IESGurdResData(null, IESGurdResFrom.OFFLINE, id.longValue(), file3.getAbsolutePath(), null, 16, null);
        if (needData) {
            iESGurdResData2.setData(new FileInputStream(file3));
        }
        return iESGurdResData2;
    }

    private final boolean loadUltraUpdateResource(IESGurdResError error) {
        PrepareMeta updateMeta = PrepareMetaManager.INSTANCE.getUpdateMeta(this.accessKey, this.channel);
        if (updateMeta == null) {
            error.setCdnCode(ResCdnCode.NO_PREPARE_META.getType());
            error.setCdnMessage("prepare meta not exists");
            return false;
        }
        PrepareMetaPackage fullPackage = updateMeta.getFullPackage();
        UltraUpdateResource ultraUpdateResource = fullPackage != null ? fullPackage.getUltraUpdateResource() : null;
        if (ultraUpdateResource == null) {
            error.setCdnCode(ResCdnCode.ULTRA_RESOURCE_IS_NULL.getType());
            error.setCdnMessage("ultra resource is null");
            return false;
        }
        if (!(ultraUpdateResource.getSchema().length() == 0) && !ultraUpdateResource.getDomains().isEmpty()) {
            if (!(ultraUpdateResource.getResourcePrefix().length() == 0)) {
                this.resource = ultraUpdateResource;
                this.id = updateMeta.getVersion();
                return true;
            }
        }
        error.setCdnCode(ResCdnCode.ULTRA_RESOURCE_ERROR.getType());
        error.setCdnMessage("ultra resource data error: " + ultraUpdateResource);
        return false;
    }

    private final boolean needHandleAccess() {
        String str = this.accessKey + '@' + this.channel;
        Map<String, Long> map = channelAccessTime;
        Long l = map.get(str);
        if (l != null && this.accessTime - l.longValue() < BytePatchException.ErrorCode.paramsError) {
            return false;
        }
        map.put(str, Long.valueOf(this.accessTime));
        return true;
    }

    private final void handleAccessActions(final String type, final IESGurdResData data) {
        if (needHandleAccess()) {
            GeckoExecutors.INSTANCE.getAccessExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.loader.ResLoader$handleAccessActions$1
                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    String str2;
                    long j;
                    String str3;
                    String str4;
                    long id = data.getResFrom() == IESGurdResFrom.OFFLINE ? data.getId() : 0L;
                    AccessManager accessManager = AccessManager.INSTANCE;
                    str = ResLoader.this.accessKey;
                    str2 = ResLoader.this.channel;
                    long id2 = data.getId();
                    j = ResLoader.this.accessTime;
                    Pair<Boolean, Long> runAccessActions = accessManager.runAccessActions(str, str2, id2, id, j);
                    AccessManager accessManager2 = AccessManager.INSTANCE;
                    str3 = ResLoader.this.accessKey;
                    str4 = ResLoader.this.channel;
                    JSONObject uploadData = accessManager2.getUploadData(str3, str4, Long.valueOf(data.getId()), type, runAccessActions);
                    if (uploadData != null) {
                        ResLoader.this.addCommonEventData(uploadData, data.getError());
                        uploadData.put("res_from", data.getResFrom().name());
                        if (data.getResFrom() == IESGurdResFrom.OFFLINE_FROM_CDN) {
                            uploadData.put("offline_from_cdn_url", data.getPath());
                        }
                        UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_resource_access_stats", uploadData);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadWithIndex(int index, IESGurdResData data) {
        UltraUpdateResource ultraUpdateResource = this.resource;
        if (ultraUpdateResource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resource");
        }
        String url = ultraUpdateResource.getUrl(index, this.channel, this.bundle);
        GeckoLogger.d("offline_from_cdn，get url: " + url);
        NetResponse netResponse = TTNetImpl.INSTANCE.get(url);
        int code = netResponse.getCode();
        if (200 <= code && 299 >= code) {
            Response res = netResponse.getRes();
            if ((res != null ? res.getBody() : null) != null) {
                IESGurdResData iESGurdResData = new IESGurdResData(data.getError(), IESGurdResFrom.OFFLINE_FROM_CDN, this.id, url, netResponse.getRes().getBody().mo349in());
                uploadEventAfterCdn(url, netResponse, iESGurdResData);
                excuteCallback(iESGurdResData);
                return;
            }
        }
        if (!ArraysKt.contains(new Integer[]{Integer.valueOf(PatchException.ERR_INSTALL_PARSE_IO), 404, 412}, Integer.valueOf(netResponse.getCode()))) {
            UltraUpdateResource ultraUpdateResource2 = this.resource;
            if (ultraUpdateResource2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resource");
            }
            if (index < ultraUpdateResource2.getDomains().size() - 1) {
                GeckoLogger.w("offline_from_cdn，get url failed: " + url + ", " + netResponse.getCode() + ", " + netResponse.getMessage());
                this.failedTimes++;
                downloadWithIndex(index + 1, data);
                return;
            }
        }
        GeckoLogger.w("offline_from_cdn，all url failed: " + url + ", " + netResponse.getCode() + ", " + netResponse.getMessage());
        IESGurdResError error = data.getError();
        if (error == null) {
            Intrinsics.throwNpe();
        }
        error.setCdnCode(netResponse.getCode());
        data.getError().setCdnMessage(netResponse.getMessage());
        uploadEventAfterCdn(url, netResponse, data);
        excuteCallback(data);
    }

    private final void uploadEventAfterCdn(final String url, final NetResponse response, final IESGurdResData data) {
        if (this.handleAccess) {
            GeckoExecutors.INSTANCE.getAccessExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.loader.ResLoader$uploadEventAfterCdn$1
                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    String str2;
                    Pair<Boolean, Long> pair;
                    long j;
                    int i;
                    AccessManager accessManager = AccessManager.INSTANCE;
                    str = ResLoader.this.accessKey;
                    str2 = ResLoader.this.channel;
                    Long valueOf = Long.valueOf(data.getId());
                    pair = ResLoader.this.metaDataPair;
                    if (pair == null) {
                        Intrinsics.throwNpe();
                    }
                    JSONObject uploadData = accessManager.getUploadData(str, str2, valueOf, "getData", pair);
                    if (uploadData != null) {
                        ResLoader.this.addCommonEventData(uploadData, data.getError());
                        uploadData.put("res_from", data.getResFrom().name());
                        uploadData.put("offline_from_cdn_url", url);
                        uploadData.put("offline_from_cdn_http_status", response.getCode());
                        long currentTimeMillis = System.currentTimeMillis();
                        j = ResLoader.this.startTime;
                        uploadData.put("offline_from_cdn_duration", currentTimeMillis - j);
                        i = ResLoader.this.failedTimes;
                        uploadData.put("offline_from_cdn_failed_times", i);
                        UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_resource_access_stats", uploadData);
                    }
                }
            });
        }
    }

    static /* synthetic */ void addCommonEventData$default(ResLoader resLoader, JSONObject jSONObject, IESGurdResError iESGurdResError, int i, Object obj) {
        if ((i & 2) != 0) {
            iESGurdResError = null;
        }
        resLoader.addCommonEventData(jSONObject, iESGurdResError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addCommonEventData(JSONObject json, IESGurdResError error) {
        json.put(Constants.NOTIFICATION_TAG, this.tag);
        json.put(SchemaConstants.QUERY_KEY_BUNDLE, this.bundle);
        if (error != null) {
            json.put("offline_error_code", error.getOfflineCode());
            json.put("offline_error_message", error.getOfflineMessage());
            if (error.getCdnCode() != 0) {
                json.put("cdn_error_code", error.getCdnCode());
            }
            if (error.getCdnMessage() != null) {
                json.put("cdn_error_message", error.getCdnMessage());
            }
        }
    }
}
