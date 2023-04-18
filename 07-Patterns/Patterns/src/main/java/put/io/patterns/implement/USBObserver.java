package put.io.patterns.implement;

public class USBObserver extends Observer{
    private int lastNumberOfUSBDevices = 0;
    public USBObserver(SystemMonitor sys) {
        super(sys);
    }

    @Override
    public void printOut(){
        int num = this.getState().getUsbDevices();
        if (num != this.lastNumberOfUSBDevices){
            System.out.println(String.format("USB devices: %d", num));
            this.lastNumberOfUSBDevices = num;
        }
    }
}
