package put.io.patterns.implement;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import java.util.ArrayList;

public class SystemMonitor {

    private SystemInfo si;

    private HardwareAbstractionLayer hal;

    private OperatingSystem os;

    private SystemState lastSystemState = null;
    private ArrayList<Observer> observers = new ArrayList<Observer>();


    public SystemMonitor(){
        si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();

    }

    public void probe(){

        // Get current state of the system resources
        double cpuLoad = hal.getProcessor().getSystemCpuLoad()*100;
        double cpuTemp = hal.getSensors().getCpuTemperature();
        double memory = hal.getMemory().getAvailable() / 1000000;
        int usbDevices = hal.getUsbDevices(false).length;

        lastSystemState = new SystemState(cpuLoad, cpuTemp, memory, usbDevices);
        notifyObservers();
    }

    public SystemState getLastSystemState() {
        return lastSystemState;
    }

    private void notifyObservers(){
        for (Observer observer : this.observers) {
            observer.update();
        }
    }
    public void addObserver(Observer observer){
        this.observers.add(observer);
    }
    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }
}
