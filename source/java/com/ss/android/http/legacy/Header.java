package com.ss.android.http.legacy;

@Deprecated
/* loaded from: classes7.dex */
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
