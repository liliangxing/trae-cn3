package com.bytedance.ies.bullet.preloadv2.cache;

import com.bytedance.ies.bullet.preloadv2.utils.PreloadHelper;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.io.File;
import java.util.Observable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PreloadItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B+\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010^\u001a\u00020\nH\u0016J\b\u0010_\u001a\u00020\nH\u0016J\b\u0010`\u001a\u00020aH\u0016J\b\u0010b\u001a\u00020\u0006H\u0002J\u0018\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020\u001c2\b\u0010e\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u001a\u0010(\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001a\u0010+\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R\u001c\u0010.\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010#\"\u0004\b0\u0010%R\u001a\u00101\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001aR\u001c\u00104\u001a\u00020\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010#\"\u0004\b6\u0010%R\u001a\u00107\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R\u001c\u0010:\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010#\"\u0004\b<\u0010%R\u001a\u0010=\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0014\"\u0004\bH\u0010\u0016R\u001b\u0010I\u001a\u00020J8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bK\u0010LR\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010R\"\u0004\bW\u0010TR\u001a\u0010X\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0014\"\u0004\bZ\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0011\"\u0004\b\\\u0010]¨\u0006f"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadItem;", "Ljava/util/Observable;", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "url", "", "type", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "enableMemory", "", IPiaCacheProvider.CacheConfig.FIELD_EXPIRE, "", "(Ljava/lang/String;Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;ZJ)V", "cacheKey", "defaultType", "getDefaultType", "()Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "downloadTimeout", "getDownloadTimeout", "()J", "setDownloadTimeout", "(J)V", "getEnableMemory", "()Z", "setEnableMemory", "(Z)V", "errCode", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadErrorCode;", "getErrCode", "()Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadErrorCode;", "setErrCode", "(Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadErrorCode;)V", "errMessage", "getErrMessage", "()Ljava/lang/String;", "setErrMessage", "(Ljava/lang/String;)V", "getExpire", "setExpire", "expireEnd", "getExpireEnd", "setExpireEnd", "expireStart", "getExpireStart", "setExpireStart", "filePath", "getFilePath", "setFilePath", "highPriority", "getHighPriority", "setHighPriority", "key", "getKey", "setKey", "memoryDuration", "getMemoryDuration", "setMemoryDuration", "redirectPath", "getRedirectPath", "setRedirectPath", "resUrl", "getResUrl", "setResUrl", "resourceInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "getResourceInfo", "()Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "setResourceInfo", "(Lcom/bytedance/ies/bullet/service/base/ResourceInfo;)V", "rlDuration", "getRlDuration", "setRlDuration", "size", "", "getSize", "()I", "size$delegate", "Lkotlin/Lazy;", "taskConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "getTaskConfig", "()Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "setTaskConfig", "(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;)V", "taskConfigForKey", "getTaskConfigForKey", "setTaskConfigForKey", "totalDuration", "getTotalDuration", "setTotalDuration", "getType", "setType", "(Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;)V", "checkFileExists", "checkValid", "clearMemory", "", "generateKey", "markError", "errorCode", "errorMessage", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PreloadItem extends Observable {
    private String cacheKey;
    private final PreloadResourceType defaultType;
    private long downloadTimeout;
    private boolean enableMemory;
    private PreloadErrorCode errCode;
    private String errMessage;
    private long expire;
    private long expireEnd;
    private long expireStart;
    private String filePath;
    private boolean highPriority;
    private String key;
    private long memoryDuration;
    private String redirectPath;
    private String resUrl;
    private ResourceInfo resourceInfo;
    private long rlDuration;

    /* renamed from: size$delegate, reason: from kotlin metadata */
    private final Lazy size;
    private TaskConfig taskConfig;
    private TaskConfig taskConfigForKey;
    private long totalDuration;
    private PreloadResourceType type;

    public void clearMemory() {
    }

    public PreloadResourceType getDefaultType() {
        return this.defaultType;
    }

    public final String getResUrl() {
        return this.resUrl;
    }

    public final void setResUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resUrl = str;
    }

    public final PreloadResourceType getType() {
        return this.type;
    }

    public final void setType(PreloadResourceType preloadResourceType) {
        Intrinsics.checkNotNullParameter(preloadResourceType, "<set-?>");
        this.type = preloadResourceType;
    }

    public final boolean getEnableMemory() {
        return this.enableMemory;
    }

    public final void setEnableMemory(boolean z) {
        this.enableMemory = z;
    }

    public final boolean getHighPriority() {
        return this.highPriority;
    }

    public final void setHighPriority(boolean z) {
        this.highPriority = z;
    }

    public final long getExpire() {
        return this.expire;
    }

    public final void setExpire(long j) {
        this.expire = j;
    }

    public final long getExpireStart() {
        return this.expireStart;
    }

    public final void setExpireStart(long j) {
        this.expireStart = j;
    }

    public final long getExpireEnd() {
        return this.expireEnd;
    }

    public final void setExpireEnd(long j) {
        this.expireEnd = j;
    }

    public final long getDownloadTimeout() {
        return this.downloadTimeout;
    }

    public final void setDownloadTimeout(long j) {
        this.downloadTimeout = j;
    }

    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final String getKey() {
        return generateKey();
    }

    public final TaskConfig getTaskConfig() {
        return this.taskConfig;
    }

    public final void setTaskConfig(TaskConfig taskConfig) {
        this.taskConfig = taskConfig;
    }

    public final TaskConfig getTaskConfigForKey() {
        return this.taskConfigForKey;
    }

    public final void setTaskConfigForKey(TaskConfig taskConfig) {
        this.taskConfigForKey = taskConfig;
    }

    public final ResourceInfo getResourceInfo() {
        return this.resourceInfo;
    }

    public final void setResourceInfo(ResourceInfo resourceInfo) {
        this.resourceInfo = resourceInfo;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final void setFilePath(String str) {
        this.filePath = str;
    }

    public final String getRedirectPath() {
        return this.redirectPath;
    }

    public final void setRedirectPath(String str) {
        this.redirectPath = str;
    }

    public PreloadItem(JSONObject jSONObject) {
        PreloadResourceType preloadResourceType;
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        this.defaultType = PreloadResourceType.Any;
        this.enableMemory = true;
        this.expire = PreloadItemKt.DEFAULT_EXPIRE_TIME;
        this.key = "";
        this.size = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.ies.bullet.preloadv2.cache.PreloadItem$size$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m543invoke() {
                String filePath = PreloadItem.this.getFilePath();
                return Integer.valueOf(filePath != null ? (int) new File(filePath).length() : 0);
            }
        });
        this.errCode = PreloadErrorCode.None;
        String optString = jSONObject.optString("url");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"url\")");
        this.resUrl = optString;
        String optString2 = jSONObject.optString("type");
        if (Intrinsics.areEqual(optString2, PreloadResourceType.Template.getTag())) {
            preloadResourceType = PreloadResourceType.Template;
        } else if (Intrinsics.areEqual(optString2, PreloadResourceType.Image.getTag())) {
            preloadResourceType = PreloadResourceType.Image;
        } else if (Intrinsics.areEqual(optString2, PreloadResourceType.Font.getTag())) {
            preloadResourceType = PreloadResourceType.Font;
        } else if (Intrinsics.areEqual(optString2, PreloadResourceType.ExternalJs.getTag())) {
            preloadResourceType = PreloadResourceType.ExternalJs;
        } else if (Intrinsics.areEqual(optString2, PreloadResourceType.DynamicComponent.getTag())) {
            preloadResourceType = PreloadResourceType.DynamicComponent;
        } else if (Intrinsics.areEqual(optString2, PreloadResourceType.Lottie.getTag())) {
            preloadResourceType = PreloadResourceType.Lottie;
        } else {
            preloadResourceType = Intrinsics.areEqual(optString2, PreloadResourceType.Video.getTag()) ? PreloadResourceType.Video : PreloadResourceType.Any;
        }
        this.type = preloadResourceType;
        this.enableMemory = jSONObject.optBoolean("enableMemory", preloadResourceType != PreloadResourceType.Image);
        this.highPriority = jSONObject.optBoolean("highPriority", false);
        this.expire = jSONObject.optLong(IPiaCacheProvider.CacheConfig.FIELD_EXPIRE, PreloadItemKt.DEFAULT_EXPIRE_TIME);
        this.expireStart = jSONObject.optLong("expire_start", 0L);
        this.expireEnd = jSONObject.optLong("expire_end", 0L);
        this.downloadTimeout = jSONObject.optLong("download_timeout", 0L);
    }

    public PreloadItem(String str, PreloadResourceType preloadResourceType, boolean z, long j) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(preloadResourceType, "type");
        this.defaultType = PreloadResourceType.Any;
        this.enableMemory = true;
        this.expire = PreloadItemKt.DEFAULT_EXPIRE_TIME;
        this.key = "";
        this.size = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.ies.bullet.preloadv2.cache.PreloadItem$size$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m543invoke() {
                String filePath = PreloadItem.this.getFilePath();
                return Integer.valueOf(filePath != null ? (int) new File(filePath).length() : 0);
            }
        });
        this.errCode = PreloadErrorCode.None;
        this.resUrl = str;
        this.type = preloadResourceType;
        this.enableMemory = z;
        this.expire = j;
    }

    public /* synthetic */ PreloadItem(String str, PreloadResourceType preloadResourceType, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, preloadResourceType, (i & 4) != 0 ? true : z, (i & 8) != 0 ? PreloadItemKt.DEFAULT_EXPIRE_TIME : j);
    }

    private final String generateKey() {
        String str = this.cacheKey;
        if (str != null) {
            return str;
        }
        String generateKey = PreloadHelper.INSTANCE.generateKey(this.taskConfigForKey, this.resourceInfo, this.resUrl);
        if (this.taskConfig != null && this.resourceInfo != null) {
            this.cacheKey = generateKey;
        }
        return generateKey;
    }

    public int getSize() {
        return ((Number) this.size.getValue()).intValue();
    }

    public boolean checkValid() {
        if (getDefaultType() != PreloadResourceType.Any && this.type != getDefaultType()) {
            return false;
        }
        if (this.expireStart <= 0 || System.currentTimeMillis() >= this.expireStart) {
            return this.expireEnd <= 0 || System.currentTimeMillis() <= this.expireEnd;
        }
        return false;
    }

    public boolean checkFileExists() {
        ResourceInfo resourceInfo = this.resourceInfo;
        if (resourceInfo == null || this.filePath == null) {
            return false;
        }
        if ((resourceInfo != null ? resourceInfo.getType() : null) != ResourceType.DISK) {
            return true;
        }
        try {
            return new File(this.filePath).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final void setTotalDuration(long j) {
        this.totalDuration = j;
    }

    public final long getRlDuration() {
        return this.rlDuration;
    }

    public final void setRlDuration(long j) {
        this.rlDuration = j;
    }

    public final long getMemoryDuration() {
        return this.memoryDuration;
    }

    public final void setMemoryDuration(long j) {
        this.memoryDuration = j;
    }

    public final PreloadErrorCode getErrCode() {
        return this.errCode;
    }

    public final void setErrCode(PreloadErrorCode preloadErrorCode) {
        Intrinsics.checkNotNullParameter(preloadErrorCode, "<set-?>");
        this.errCode = preloadErrorCode;
    }

    public final String getErrMessage() {
        return this.errMessage;
    }

    public final void setErrMessage(String str) {
        this.errMessage = str;
    }

    public final PreloadItem markError(PreloadErrorCode errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.errCode = errorCode;
        this.errMessage = errorMessage;
        return this;
    }
}
