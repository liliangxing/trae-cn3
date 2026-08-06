package com.bytedance.lynx.service.resource;

import com.lynx.tasm.service.ILynxResourceServiceResponse;
import java.io.File;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxResourceServiceErrorResponse.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/lynx/service/resource/LynxResourceServiceErrorResponse;", "Lcom/lynx/tasm/service/ILynxResourceServiceResponse;", "errorCode", "", "errorMessage", "", "(ILjava/lang/String;)V", "getCharset", "getDataType", "getErrorCode", "getErrorInfoString", "getFilePath", "getFrom", "getHasBeenPaused", "", "getImage", "", "getIsDataTypeEmpty", "getOriginFrom", "getPerformanceInfo", "", "", "getSourceType", "getSuccessFetcher", "getVersion", "isCache", "isCanceled", "isPreloaded", "isRequestReused", "isSucceed", "provideBytes", "", "provideFile", "Ljava/io/File;", "provideInputStream", "Ljava/io/InputStream;", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxResourceServiceErrorResponse implements ILynxResourceServiceResponse {
    private final int errorCode;
    private final String errorMessage;

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public String getCharset() {
        return null;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse, com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    public String getDataType() {
        return null;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse, com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    public String getFilePath() {
        return null;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse, com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    public String getFrom() {
        return null;
    }

    /* renamed from: getHasBeenPaused, reason: collision with other method in class */
    public boolean m7754getHasBeenPaused() {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse, com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    public Object getImage() {
        return null;
    }

    /* renamed from: getIsDataTypeEmpty, reason: collision with other method in class */
    public boolean m7755getIsDataTypeEmpty() {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public String getOriginFrom() {
        return "";
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public String getSourceType() {
        return "";
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public String getSuccessFetcher() {
        return "";
    }

    public long getVersion() {
        return 0L;
    }

    /* renamed from: isCache, reason: collision with other method in class */
    public boolean m7757isCache() {
        return false;
    }

    /* renamed from: isCanceled, reason: collision with other method in class */
    public boolean m7758isCanceled() {
        return false;
    }

    /* renamed from: isPreloaded, reason: collision with other method in class */
    public boolean m7759isPreloaded() {
        return false;
    }

    /* renamed from: isRequestReused, reason: collision with other method in class */
    public boolean m7760isRequestReused() {
        return false;
    }

    /* renamed from: isSucceed, reason: collision with other method in class */
    public boolean m7761isSucceed() {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse, com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    public byte[] provideBytes() {
        return null;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public File provideFile() {
        return null;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse, com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    public InputStream provideInputStream() {
        return null;
    }

    public LynxResourceServiceErrorResponse(int i, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.errorCode = i;
        this.errorMessage = errorMessage;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    /* renamed from: getErrorCode, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Integer mo7753getErrorCode() {
        return Integer.valueOf(getErrorCode());
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public /* bridge */ /* synthetic */ Boolean getHasBeenPaused() {
        return Boolean.valueOf(m7754getHasBeenPaused());
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public /* bridge */ /* synthetic */ Boolean getIsDataTypeEmpty() {
        return Boolean.valueOf(m7755getIsDataTypeEmpty());
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    /* renamed from: getVersion, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Long mo7756getVersion() {
        return Long.valueOf(getVersion());
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public /* bridge */ /* synthetic */ Boolean isCache() {
        return Boolean.valueOf(m7757isCache());
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public /* bridge */ /* synthetic */ Boolean isCanceled() {
        return Boolean.valueOf(m7758isCanceled());
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public /* bridge */ /* synthetic */ Boolean isPreloaded() {
        return Boolean.valueOf(m7759isPreloaded());
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public /* bridge */ /* synthetic */ Boolean isRequestReused() {
        return Boolean.valueOf(m7760isRequestReused());
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse, com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    public /* bridge */ /* synthetic */ Boolean isSucceed() {
        return Boolean.valueOf(m7761isSucceed());
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public Map<String, Long> getPerformanceInfo() {
        return new LinkedHashMap();
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    /* renamed from: getErrorInfoString, reason: from getter */
    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
