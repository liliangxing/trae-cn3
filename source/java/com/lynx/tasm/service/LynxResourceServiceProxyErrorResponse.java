package com.lynx.tasm.service;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
class LynxResourceServiceProxyErrorResponse implements ILynxResourceServiceResponse {
    private Integer mErrorCode;
    private String mErrorMessage;

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

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse, com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    public Object getImage() {
        return null;
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

    LynxResourceServiceProxyErrorResponse(Integer num, String str) {
        this.mErrorCode = num;
        this.mErrorMessage = str;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse, com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    public Boolean isSucceed() {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public Boolean isCache() {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    /* renamed from: getVersion */
    public Long mo7756getVersion() {
        return 0L;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public Boolean isCanceled() {
        return true;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public Boolean isPreloaded() {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public Boolean isRequestReused() {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public Map<String, Long> getPerformanceInfo() {
        return new HashMap();
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public String getErrorInfoString() {
        return this.mErrorMessage;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    /* renamed from: getErrorCode */
    public Integer mo7753getErrorCode() {
        return this.mErrorCode;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public Boolean getHasBeenPaused() {
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxResourceServiceResponse
    public Boolean getIsDataTypeEmpty() {
        return true;
    }
}
