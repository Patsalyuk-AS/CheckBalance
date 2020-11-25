//надежность банкомата от 0 до 1000 (0 - наихудший показатель)

package com.github.patsalyukas.device;

public class ReliabilityOfSelfServiceDevice implements Reliability {

    public static final int MIN_RELIABILITY = 0;
    public static final int MAX_RELIABILITY = 1000;

    private int reliability;

    public ReliabilityOfSelfServiceDevice(int reliability) {
        if (reliability < MIN_RELIABILITY) {
            throw new IllegalArgumentException("Min value is " + MIN_RELIABILITY + ".");
        } else if (reliability > MAX_RELIABILITY) {
            throw new IllegalArgumentException("Max value is " + MAX_RELIABILITY + ".");
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
