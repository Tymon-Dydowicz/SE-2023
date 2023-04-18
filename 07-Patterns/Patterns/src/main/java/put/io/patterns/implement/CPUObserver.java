package put.io.patterns.implement;

public class CPUObserver extends Observer{
    public CPUObserver(SystemMonitor sys) {
        super(sys);
    }

    @Override
    public void printOut(){
        System.out.println(String.format("CPU Load: %2.2f%%", this.getState().getCpu()));
        System.out.println(String.format("CPU temperature: %.2f C", this.getState().getCpuTemp()));
        if (this.getState().getCpuTemp() > 60.00){
            System.out.println("> Increasing cooling of the CPU...");
        }
    }
}
