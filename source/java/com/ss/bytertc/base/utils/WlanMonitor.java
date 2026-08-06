package com.ss.bytertc.base.utils;

/* loaded from: classes7.dex */
public final class WlanMonitor {
    public static ConnectionInfo[] getConnectionInfos() {
        return null;
    }

    public static int getFrequency() {
        return 0;
    }

    public static InterfaceInfo[] getInterfaceInfos() {
        return null;
    }

    public static ScanResultInfo[] getScanResultInfos() {
        return null;
    }

    public static int getSignalQuality() {
        return 0;
    }

    /* loaded from: classes7.dex */
    public static class ConnectionInfo {
        private String ifName;
        private int noise;
        private int rssi;
        private int rxRate;
        private int txRate;

        public ConnectionInfo(String aIfName, int iRssi, int iNoise, int iTxRate, int iRxRate) {
            this.ifName = aIfName;
            this.rssi = iRssi;
            this.noise = iNoise;
            this.txRate = iTxRate;
            this.rxRate = iRxRate;
        }

        public String getIfName() {
            return this.ifName;
        }

        public int getRssi() {
            return this.rssi;
        }

        public int getNoise() {
            return this.noise;
        }

        public int getTxRate() {
            return this.txRate;
        }

        public int getRxRate() {
            return this.rxRate;
        }
    }

    /* loaded from: classes7.dex */
    public static class InterfaceInfo {
        private int channelWidth;
        private int channleNum;
        private int frequency;
        private String ifName;
        private int phyMode;
        private boolean state;

        public InterfaceInfo(String aIfName, boolean bState, int iFrequency, int iPhyMode, int ichannelNum, int ichannelWidth) {
            this.ifName = aIfName;
            this.state = bState;
            this.frequency = iFrequency;
            this.phyMode = iPhyMode;
            this.channleNum = ichannelNum;
            this.channelWidth = ichannelWidth;
        }

        public String getIfName() {
            return this.ifName;
        }

        public boolean getState() {
            return this.state;
        }

        public int getFrequency() {
            return this.frequency;
        }

        public int getPhyMode() {
            return this.phyMode;
        }

        public int getChannleNum() {
            return this.channleNum;
        }

        public int getChannelWidth() {
            return this.channelWidth;
        }
    }

    /* loaded from: classes7.dex */
    public static class ScanResultInfo {
        private int channelWidth;
        private int channleNum;
        private int frequency;
        private int noise;
        private int rssi;

        public ScanResultInfo(int iFrequency, int ichannelNum, int ichannelWidth, int iRssi, int iNoise) {
            this.frequency = iFrequency;
            this.channleNum = ichannelNum;
            this.channelWidth = ichannelWidth;
            this.rssi = iRssi;
            this.noise = iNoise;
        }

        public int getFrequency() {
            return this.frequency;
        }

        public int getChannleNum() {
            return this.channleNum;
        }

        public int getChannelWidth() {
            return this.channelWidth;
        }

        public int getRssi() {
            return this.rssi;
        }

        public int getNoise() {
            return this.noise;
        }
    }
}
