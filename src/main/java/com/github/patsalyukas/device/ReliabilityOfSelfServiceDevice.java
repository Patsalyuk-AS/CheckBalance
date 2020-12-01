//надежность банкомата от 0 до 1000 (0 - наихудший показатель)

package com.github.patsalyukas.device;

public class ReliabilityOfSelfServiceDevice implements Reliability {

    private int reliability;

    public ReliabilityOfSelfServiceDevice(int reliability) {
        if (reliability < 0) {
            this.reliability = 0;
        } else if (reliability > 1000) {
            this.reliability = 1000;
        } else {
            this.reliability = reliability;
        }
    }

    @Override
    public DeviceStatus checkDeviceStatus() {
        int chance = (int) (Math.random() * ++reliability);
        return (chance == 0 ? DeviceStatus.BAD : DeviceStatus.OK);
    }
}
