package com.squareup.wire;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import java.io.IOException;

/* loaded from: classes7.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    protected abstract E fromValue(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public EnumAdapter(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public final int encodedSize(E e) {
        return ProtoWriter.varint32Size(e.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public final void encode(ProtoWriter protoWriter, E e) throws IOException {
        protoWriter.writeVarint32(e.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader protoReader) throws IOException {
        int readVarint32 = protoReader.readVarint32();
        E fromValue = fromValue(readVarint32);
        if (fromValue != null) {
            return fromValue;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, this.javaType);
    }
}
