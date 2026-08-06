package com.lynx.tasm.service;

import com.lynx.tasm.provider.ILynxResourceResponseDataInfo;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes7.dex */
public interface ILynxResourceServiceResponse extends ILynxResourceResponseDataInfo {
    String getCharset();

    @Override // com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    String getDataType();

    /* renamed from: getErrorCode */
    Integer mo7753getErrorCode();

    String getErrorInfoString();

    @Override // com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    String getFilePath();

    @Override // com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    String getFrom();

    Boolean getHasBeenPaused();

    @Override // com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    Object getImage();

    Boolean getIsDataTypeEmpty();

    String getOriginFrom();

    Map<String, Long> getPerformanceInfo();

    String getSourceType();

    String getSuccessFetcher();

    /* renamed from: getVersion */
    Long mo7756getVersion();

    Boolean isCache();

    Boolean isCanceled();

    Boolean isPreloaded();

    Boolean isRequestReused();

    @Override // com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    Boolean isSucceed();

    @Override // com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    byte[] provideBytes();

    File provideFile();

    @Override // com.lynx.tasm.provider.ILynxResourceResponseDataInfo
    InputStream provideInputStream();
}
