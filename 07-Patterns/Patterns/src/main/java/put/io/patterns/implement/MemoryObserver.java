package put.io.patterns.implement;

public class MemoryObserver extends Observer{
    public MemoryObserver(SystemMonitor sys) {
        super(sys);
    }

    @Override
    public void printOut(){
        System.out.println(String.format("Available memory: %.2f MB", this.getState().getAvailableMemory()));
        if (this.getState().getCpuTemp() > 60.00){
            System.out.println("> Increasing cooling of the CPU...");
        }
    }
}
