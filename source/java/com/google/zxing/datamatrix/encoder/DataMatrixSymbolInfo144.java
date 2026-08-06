package com.google.zxing.datamatrix.encoder;

import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes6.dex */
final class DataMatrixSymbolInfo144 extends SymbolInfo {
    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? 156 : 155;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getInterleavedBlockCount() {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataMatrixSymbolInfo144() {
        super(false, 1558, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME, 22, 22, 36, -1, 62);
    }
}
