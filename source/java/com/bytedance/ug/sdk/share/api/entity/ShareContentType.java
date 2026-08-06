package com.bytedance.ug.sdk.share.api.entity;

/* loaded from: classes4.dex */
public enum ShareContentType {
    H5("h5"),
    TEXT("text"),
    IMAGE("image"),
    TEXT_IMAGE("text_image"),
    VIDEO("video"),
    FILE("file"),
    MINI_APP("miniapp"),
    AUDIO("music"),
    SUPER_GROUP("share_group"),
    ALL("all");

    private final String mTypeName;

    ShareContentType(String str) {
        this.mTypeName = str;
    }

    public String getTypeName() {
        return this.mTypeName;
    }
}
