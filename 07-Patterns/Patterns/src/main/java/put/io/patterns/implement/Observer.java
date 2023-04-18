package put.io.patterns.implement;

public class Observer {
    private SystemMonitor system;
    private SystemState state = null;
    public Observer(SystemMonitor sys){
        this.system = sys;
    }
    public void update(){
        this.state = system.getLastSystemState();
        this.printOut();
    }

    public SystemState getState(){
        return this.state;
    }

    public void printOut(){
    }
}