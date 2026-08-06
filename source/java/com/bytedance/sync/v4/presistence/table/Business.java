package com.bytedance.sync.v4.presistence.table;

import com.bytedance.sync.v4.protocal.Bucket;
import com.bytedance.sync.v4.protocal.ConsumeType;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class Business {
    public Bucket bucket;
    public ConsumeType consumeType;
    public int id;

    public String toString() {
        return "Business{id=" + this.id + ", consumeType=" + this.consumeType + ", bucket=" + this.bucket + AbstractJsonLexerKt.END_OBJ;
    }
}
