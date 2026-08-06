package com.bytedance.mt.protector;

/* loaded from: classes4.dex */
public enum ProtectorType {
    PATTERN("PATTERN_PROTECT_THROWABLE"),
    JSON("JSON_PROTECT_THROWABLE"),
    CAST_NUMBER("CAST_NUMBER_PROTECT_THROWABLE"),
    CAST_COLOR("CAST_COLOR_PROTECT_THROWABLE"),
    EQUALS("EQUALS_PROTECT_THROWABLE"),
    ENUM("ENUM_PROTECT_THROWABLE"),
    URI("URI_PROTECT_THROWABLE"),
    COLLECTIONS("COLLECTION_PROTECT_THROWABLE");

    private String name;

    ProtectorType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
