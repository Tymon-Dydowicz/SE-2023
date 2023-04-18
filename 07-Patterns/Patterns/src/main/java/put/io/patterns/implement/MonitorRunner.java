package put.io.patterns.implement;

public class MonitorRunner {

    public static void main(String args[]){
        SystemMonitor monitor = new SystemMonitor();
        Observer cpuobserver = new CPUObserver(monitor);
        Observer memobserver = new MemoryObserver(monitor);
        Observer usbobserver = new USBObserver(monitor);
        monitor.addObserver(cpuobserver);
        monitor.addObserver(memobserver);
        monitor.addObserver(usbobserver);

        while (true) {

            monitor.probe();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
