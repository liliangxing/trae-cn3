package com.bytedance.forest.model;

import com.bytedance.apm.alog.AlogMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Response.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001OBA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003JE\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J'\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020\u00002\u0012\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u0002090D\"\u000209¢\u0006\u0002\u0010EJ \u0010F\u001a\u00020\u00112\u0006\u00108\u001a\u0002092\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u0003H\u0002J\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\u0011HÖ\u0001J\u001e\u0010M\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u0003J\b\u0010N\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\u001a\u0010\u0018\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR\u001a\u0010!\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001a\u0010$\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000b\"\u0004\b&\u0010\rR\u001a\u0010'\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010\rR\u001a\u0010,\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u0010\rR\u001a\u00103\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0013\"\u0004\b5\u0010\u0015¨\u0006P"}, d2 = {"Lcom/bytedance/forest/model/ErrorInfo;", "", "memoryError", "", "geckoError", "builtinError", "cdnError", "pipelineError", "postProcessError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuiltinError", "()Ljava/lang/String;", "setBuiltinError", "(Ljava/lang/String;)V", "getCdnError", "setCdnError", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "getGeckoError", "setGeckoError", "geckoErrorCode", "getGeckoErrorCode", "setGeckoErrorCode", "gecko_cdn_library_read_error_code", "getGecko_cdn_library_read_error_code", "setGecko_cdn_library_read_error_code", "gecko_cdn_library_read_error_msg", "getGecko_cdn_library_read_error_msg", "setGecko_cdn_library_read_error_msg", "gecko_library_read_error_code", "getGecko_library_read_error_code", "setGecko_library_read_error_code", "gecko_library_read_error_msg", "getGecko_library_read_error_msg", "setGecko_library_read_error_msg", "httpStatusCode", "getHttpStatusCode", "setHttpStatusCode", "getMemoryError", "setMemoryError", "netLibraryErrorCode", "getNetLibraryErrorCode", "setNetLibraryErrorCode", "getPipelineError", "setPipelineError", "getPostProcessError", "setPostProcessError", "postProcessorErrorCode", "getPostProcessorErrorCode", "setPostProcessorErrorCode", "clearError", "", "type", "Lcom/bytedance/forest/model/ErrorInfo$Type;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "copyFrom", "src", "expects", "", "(Lcom/bytedance/forest/model/ErrorInfo;[Lcom/bytedance/forest/model/ErrorInfo$Type;)V", "encodeError", AlogMonitor.ALOG_RESULT_CODE, "message", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "setError", "toString", "Type", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class ErrorInfo {
    private String builtinError;
    private String cdnError;
    private int errorCode;
    private String geckoError;
    private int geckoErrorCode;
    private int gecko_cdn_library_read_error_code;
    private String gecko_cdn_library_read_error_msg;
    private int gecko_library_read_error_code;
    private String gecko_library_read_error_msg;
    private int httpStatusCode;
    private String memoryError;
    private int netLibraryErrorCode;
    private String pipelineError;
    private String postProcessError;
    private int postProcessorErrorCode;

    /* compiled from: Response.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/forest/model/ErrorInfo$Type;", "", "(Ljava/lang/String;I)V", "Pipeline", "Memory", "Gecko", "Builtin", "CDN", "PostProcess", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum Type {
        Pipeline,
        Memory,
        Gecko,
        Builtin,
        CDN,
        PostProcess
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Type.Memory.ordinal()] = 1;
            iArr[Type.Gecko.ordinal()] = 2;
            iArr[Type.Builtin.ordinal()] = 3;
            iArr[Type.CDN.ordinal()] = 4;
            iArr[Type.PostProcess.ordinal()] = 5;
        }
    }

    public ErrorInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ErrorInfo copy$default(ErrorInfo errorInfo, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorInfo.memoryError;
        }
        if ((i & 2) != 0) {
            str2 = errorInfo.geckoError;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = errorInfo.builtinError;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = errorInfo.cdnError;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = errorInfo.pipelineError;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = errorInfo.postProcessError;
        }
        return errorInfo.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMemoryError() {
        return this.memoryError;
    }

    /* renamed from: component2, reason: from getter */
    public final String getGeckoError() {
        return this.geckoError;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBuiltinError() {
        return this.builtinError;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCdnError() {
        return this.cdnError;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPipelineError() {
        return this.pipelineError;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPostProcessError() {
        return this.postProcessError;
    }

    public final ErrorInfo copy(String memoryError, String geckoError, String builtinError, String cdnError, String pipelineError, String postProcessError) {
        Intrinsics.checkParameterIsNotNull(memoryError, "memoryError");
        Intrinsics.checkParameterIsNotNull(geckoError, "geckoError");
        Intrinsics.checkParameterIsNotNull(builtinError, "builtinError");
        Intrinsics.checkParameterIsNotNull(cdnError, "cdnError");
        Intrinsics.checkParameterIsNotNull(pipelineError, "pipelineError");
        Intrinsics.checkParameterIsNotNull(postProcessError, "postProcessError");
        return new ErrorInfo(memoryError, geckoError, builtinError, cdnError, pipelineError, postProcessError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorInfo)) {
            return false;
        }
        ErrorInfo errorInfo = (ErrorInfo) other;
        return Intrinsics.areEqual(this.memoryError, errorInfo.memoryError) && Intrinsics.areEqual(this.geckoError, errorInfo.geckoError) && Intrinsics.areEqual(this.builtinError, errorInfo.builtinError) && Intrinsics.areEqual(this.cdnError, errorInfo.cdnError) && Intrinsics.areEqual(this.pipelineError, errorInfo.pipelineError) && Intrinsics.areEqual(this.postProcessError, errorInfo.postProcessError);
    }

    public int hashCode() {
        String str = this.memoryError;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.geckoError;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.builtinError;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.cdnError;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.pipelineError;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.postProcessError;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public ErrorInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkParameterIsNotNull(str, "memoryError");
        Intrinsics.checkParameterIsNotNull(str2, "geckoError");
        Intrinsics.checkParameterIsNotNull(str3, "builtinError");
        Intrinsics.checkParameterIsNotNull(str4, "cdnError");
        Intrinsics.checkParameterIsNotNull(str5, "pipelineError");
        Intrinsics.checkParameterIsNotNull(str6, "postProcessError");
        this.memoryError = str;
        this.geckoError = str2;
        this.builtinError = str3;
        this.cdnError = str4;
        this.pipelineError = str5;
        this.postProcessError = str6;
        this.gecko_library_read_error_msg = "";
        this.gecko_cdn_library_read_error_msg = "";
    }

    public final String getMemoryError() {
        return this.memoryError;
    }

    public final void setMemoryError(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.memoryError = str;
    }

    public final String getGeckoError() {
        return this.geckoError;
    }

    public final void setGeckoError(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.geckoError = str;
    }

    public final String getBuiltinError() {
        return this.builtinError;
    }

    public final void setBuiltinError(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.builtinError = str;
    }

    public final String getCdnError() {
        return this.cdnError;
    }

    public final void setCdnError(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.cdnError = str;
    }

    public final String getPipelineError() {
        return this.pipelineError;
    }

    public final void setPipelineError(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.pipelineError = str;
    }

    public /* synthetic */ ErrorInfo(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6);
    }

    public final String getPostProcessError() {
        return this.postProcessError;
    }

    public final void setPostProcessError(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.postProcessError = str;
    }

    public final void copyFrom(ErrorInfo src, Type... expects) {
        Intrinsics.checkParameterIsNotNull(src, "src");
        Intrinsics.checkParameterIsNotNull(expects, "expects");
        this.errorCode = src.errorCode;
        this.geckoErrorCode = src.geckoErrorCode;
        this.netLibraryErrorCode = src.netLibraryErrorCode;
        this.httpStatusCode = src.httpStatusCode;
        this.postProcessorErrorCode = src.postProcessorErrorCode;
        this.memoryError = src.memoryError;
        this.geckoError = src.geckoError;
        this.builtinError = src.builtinError;
        this.cdnError = src.cdnError;
        this.postProcessError = src.pipelineError;
        this.postProcessError = src.postProcessError;
        for (Type type : expects) {
            clearError(type);
        }
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final int getGeckoErrorCode() {
        return this.geckoErrorCode;
    }

    public final void setGeckoErrorCode(int i) {
        this.geckoErrorCode = i;
    }

    public final int getNetLibraryErrorCode() {
        return this.netLibraryErrorCode;
    }

    public final void setNetLibraryErrorCode(int i) {
        this.netLibraryErrorCode = i;
    }

    public final int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public final void setHttpStatusCode(int i) {
        this.httpStatusCode = i;
    }

    public final int getGecko_library_read_error_code() {
        return this.gecko_library_read_error_code;
    }

    public final void setGecko_library_read_error_code(int i) {
        this.gecko_library_read_error_code = i;
    }

    public final String getGecko_library_read_error_msg() {
        return this.gecko_library_read_error_msg;
    }

    public final void setGecko_library_read_error_msg(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.gecko_library_read_error_msg = str;
    }

    public final int getGecko_cdn_library_read_error_code() {
        return this.gecko_cdn_library_read_error_code;
    }

    public final void setGecko_cdn_library_read_error_code(int i) {
        this.gecko_cdn_library_read_error_code = i;
    }

    public final String getGecko_cdn_library_read_error_msg() {
        return this.gecko_cdn_library_read_error_msg;
    }

    public final void setGecko_cdn_library_read_error_msg(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.gecko_cdn_library_read_error_msg = str;
    }

    public final int getPostProcessorErrorCode() {
        return this.postProcessorErrorCode;
    }

    public final void setPostProcessorErrorCode(int i) {
        this.postProcessorErrorCode = i;
    }

    private final void clearError(Type type) {
        int encodeError = encodeError(type, 1, "");
        int i = this.errorCode;
        int i2 = encodeError * 10;
        this.errorCode = ((i / i2) * i2) + (i % encodeError);
    }

    public final void setError(Type type, int code, String message) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(message, "message");
        this.errorCode += encodeError(type, code, message);
    }

    private final int encodeError(Type type, int code, String message) {
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            this.memoryError = message;
            return code * 10;
        }
        if (i == 2) {
            this.geckoErrorCode = code;
            this.geckoError = message;
            return code * 100;
        }
        if (i == 3) {
            this.builtinError = message;
            return code * 1000;
        }
        if (i == 4) {
            this.cdnError = message;
            return code * 10000;
        }
        if (i == 5) {
            this.postProcessError = message;
            return code * 100000;
        }
        this.pipelineError = message;
        return code;
    }

    public String toString() {
        String str = StringsKt.isBlank(this.pipelineError) ^ true ? "pipelineError:" + this.pipelineError + ' ' : "";
        if (!StringsKt.isBlank(this.memoryError)) {
            str = str + "memoryError:" + this.memoryError + ' ';
        }
        if (!StringsKt.isBlank(this.geckoError)) {
            str = str + "geckoError:" + this.geckoError + ' ';
        }
        if (!StringsKt.isBlank(this.builtinError)) {
            str = str + "builtinError:" + this.builtinError + ' ';
        }
        if (!StringsKt.isBlank(this.cdnError)) {
            str = str + "cdnError:" + this.cdnError + ' ';
        }
        return StringsKt.isBlank(this.postProcessError) ^ true ? str + "postProcessError:" + this.postProcessError : str;
    }
}
