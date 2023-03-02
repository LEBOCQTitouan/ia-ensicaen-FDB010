package fr.ensicaen.lv223.model.environment.construction.environment;

import fr.ensicaen.lv223.model.environment.construction.WaterPipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class NetworkPipe {
    public static HashMap<Integer, List<WaterPipe>> mapWaterPipe = new HashMap<Integer,List<WaterPipe>>();
    private int nbNetwork;
    public NetworkPipe(){}

    public void addNetWork(List<WaterPipe> lstWater ){
        mapWaterPipe.put(++this.nbNetwork,lstWater);
    }
    public static List<WaterPipe> getNetwork(int key){
        return mapWaterPipe.get(key);
    }

    public static void replaceNetwork(int key,List<WaterPipe> newValue){
        mapWaterPipe.replace(key,mapWaterPipe.get(key),newValue);
    }

    public static int getNbNetworks(){
        return mapWaterPipe.keySet().size();
    }

    public static Set<Integer> getKeys(){
        return mapWaterPipe.keySet();
    }

}
