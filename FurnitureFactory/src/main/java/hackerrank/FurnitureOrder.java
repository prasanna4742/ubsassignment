package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {

    Map<Furniture, Integer> furnitureItemToOrderMap;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        furnitureItemToOrderMap = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {

        furnitureItemToOrderMap.put(type, furnitureItemToOrderMap.getOrDefault(type, 0)+furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        //Ideally we should return interface Map and not the implementation like HashMap, but since this is given as a problem statement
        //not changing the method signature.
        return (HashMap<Furniture, Integer>)furnitureItemToOrderMap;
    }

    public float getTotalOrderCost() {
        
        return (float) furnitureItemToOrderMap.entrySet()
            .stream().mapToDouble(x -> (x.getKey().cost()*x.getValue()))
            .sum();

    }

    public int getTypeCount(Furniture type) {                
        return furnitureItemToOrderMap.getOrDefault(type,0);
    }

    public float getTypeCost(Furniture type) {
        return (float)(furnitureItemToOrderMap.getOrDefault(type, 0)*type.cost());   
    }

    public int getTotalOrderQuantity() {
        return furnitureItemToOrderMap.values().stream().mapToInt(Integer::intValue).sum();
    }
}