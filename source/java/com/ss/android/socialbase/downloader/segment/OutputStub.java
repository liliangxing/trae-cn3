package com.ss.android.socialbase.downloader.segment;

import java.io.IOException;

/* loaded from: classes7.dex */
class OutputStub implements IOutput {
    private final IOutput output;
    private final IOutput target;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputStub(IOutput iOutput, IOutput iOutput2) {
        this.output = iOutput;
        this.target = iOutput2;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(Buffer buffer) throws IOException {
        buffer.output = this.target;
        this.output.write(buffer);
    }
}
