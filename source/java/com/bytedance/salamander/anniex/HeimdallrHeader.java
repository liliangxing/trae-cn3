package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* compiled from: AnniexMonitorEventTypingsBaseHeimdaller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0018\u0010\u0011\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u0018\u0010\u0014\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u0018\u0010\u0017\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u0018\u0010\u001a\u001a\u00020\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u00020!X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010\rR\u0018\u0010)\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010\r¨\u0006,"}, d2 = {"Lcom/bytedance/salamander/anniex/HeimdallrHeader;", "", "aid", "", "getAid", "()I", "setAid", "(I)V", "app_version", "", "getApp_version", "()Ljava/lang/String;", "setApp_version", "(Ljava/lang/String;)V", "channel", "getChannel", "setChannel", "device_brand", "getDevice_brand", "setDevice_brand", "device_id", "getDevice_id", "setDevice_id", "device_model", "getDevice_model", "setDevice_model", "network_type", "Lcom/bytedance/salamander/anniex/NetworkType;", "getNetwork_type", "()Lcom/bytedance/salamander/anniex/NetworkType;", "setNetwork_type", "(Lcom/bytedance/salamander/anniex/NetworkType;)V", "os", "Lcom/bytedance/salamander/anniex/OsType;", "getOs", "()Lcom/bytedance/salamander/anniex/OsType;", "setOs", "(Lcom/bytedance/salamander/anniex/OsType;)V", "os_version", "getOs_version", "setOs_version", "update_version_code", "getUpdate_version_code", "setUpdate_version_code", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface HeimdallrHeader {
    int getAid();

    String getApp_version();

    String getChannel();

    String getDevice_brand();

    String getDevice_id();

    String getDevice_model();

    NetworkType getNetwork_type();

    OsType getOs();

    String getOs_version();

    String getUpdate_version_code();

    void setAid(int i);

    void setApp_version(String str);

    void setChannel(String str);

    void setDevice_brand(String str);

    void setDevice_id(String str);

    void setDevice_model(String str);

    void setNetwork_type(NetworkType networkType);

    void setOs(OsType osType);

    void setOs_version(String str);

    void setUpdate_version_code(String str);
}
