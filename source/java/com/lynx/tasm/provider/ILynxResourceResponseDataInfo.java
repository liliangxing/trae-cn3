package com.lynx.tasm.provider;

import java.io.InputStream;

/* loaded from: classes7.dex */
public interface ILynxResourceResponseDataInfo {
    String getDataType();

    String getFilePath();

    String getFrom();

    Object getImage();

    Boolean isSucceed();

    byte[] provideBytes();

    InputStream provideInputStream();
}
