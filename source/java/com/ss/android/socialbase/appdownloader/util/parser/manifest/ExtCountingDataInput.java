package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import java.io.DataInput;
import java.io.IOException;
import java.util.logging.Logger;

/* loaded from: classes7.dex */
public class ExtCountingDataInput extends ExtDataInput {
    private static final Logger LOGGER = Logger.getLogger(ExtCountingDataInput.class.getName());
    private final CountingInputStream mCountIn;

    public ExtCountingDataInput(LittleEndianDataInputStream littleEndianDataInputStream) {
        this(new CountingInputStream(littleEndianDataInputStream));
    }

    public ExtCountingDataInput(CountingInputStream countingInputStream) {
        super((DataInput) new LittleEndianDataInputStream(countingInputStream));
        this.mCountIn = countingInputStream;
    }

    public int position() {
        return this.mCountIn.getCount();
    }

    public int remaining() throws IOException {
        return this.mCountIn.available();
    }

    public long skip(int i) throws IOException {
        return this.mCountIn.skip(i);
    }

    public int[] readSafeIntArray(int i, long j) throws IOException {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            if (position() >= j) {
                LOGGER.warning(String.format("Bad string block: string entry is at %d, past end at %d", Integer.valueOf(position()), Long.valueOf(j)));
                return iArr;
            }
            iArr[i2] = readInt();
        }
        return iArr;
    }
}
