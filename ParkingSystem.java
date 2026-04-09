import java.util.*;

class ParkingSystem {
    int capacity = 10;
    String[] slots = new String[capacity];
    HashMap<String, Integer> map = new HashMap<>();
    Queue<String> waitingQueue = new LinkedList<>();
    
    // Graph representation for BFS
    List<List<Integer>> graph = new ArrayList<>();
    
    // Constructor - builds the graph
    ParkingSystem() {
        // Initialize graph with 10 nodes (parking slots)
        for (int i = 0; i < capacity; i++) {
            slots[i] = null;
            graph.add(new ArrayList<>());
        }
        
        // Create connections between adjacent slots (edges)
        // Slot 0 connected to 1, Slot 1 connected to 0 and 2, etc.
        for (int i = 0; i < capacity - 1; i++) {
            graph.get(i).add(i + 1);
            graph.get(i + 1).add(i);
        }
    }
    
    // BFS Algorithm to find nearest free parking slot
    private int findNearestSlot() {
        boolean[] visited = new boolean[capacity];
        Queue<Integer> queue = new LinkedList<>();
        
        // Entrance is at middle slot (slot 4 or 5)
        int entrance = capacity / 2;
        
        queue.add(entrance);
        visited[entrance] = true;
        
        System.out.println("🔍 BFS Searching from entrance at slot " + entrance);
        
        while (!queue.isEmpty()) {
            int currentSlot = queue.poll();
            
            // Check if this slot is free
            if (slots[currentSlot] == null) {
                System.out.println("✅ BFS found nearest free slot: " + currentSlot);
                return currentSlot;
            }
            
            // Add all connected (neighboring) slots to queue
            for (int neighbor : graph.get(currentSlot)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        System.out.println("❌ No free slots found!");
        return -1; // No free slot found
    }
    
    // Park a car using BFS to find nearest slot
    public String parkCar(String carNumber) {
        if (map.containsKey(carNumber)) {
            return "❌ Car " + carNumber + " already parked!";
        }
        
        // Use BFS to find nearest free slot
        int slot = findNearestSlot();
        
        if (slot != -1) {
            slots[slot] = carNumber;
            map.put(carNumber, slot);
            return "✅ Car " + carNumber + " parked at slot " + slot + " (Nearest using BFS)";
        }
        
        // If parking is full, add to waiting queue
        waitingQueue.add(carNumber);
        return "⚠️ Parking Full! Car " + carNumber + " added to waiting queue. Position: " + waitingQueue.size();
    }
    
    // Remove a parked car
    public String removeCar(String carNumber) {
        if (!map.containsKey(carNumber)) {
            return "❌ Car " + carNumber + " not found!";
        }
        
        int slot = map.get(carNumber);
        slots[slot] = null;
        map.remove(carNumber);
        
        // If there are cars waiting, assign the next one to this slot
        if (!waitingQueue.isEmpty()) {
            String nextCar = waitingQueue.poll();
            int newSlot = findNearestSlot();
            if (newSlot != -1) {
                slots[newSlot] = nextCar;
                map.put(nextCar, newSlot);
                return "✅ Car " + carNumber + " removed from slot " + slot + "\n🚗 Waiting car " + nextCar + " parked at slot " + newSlot + " (BFS)";
            }
        }
        
        return "✅ Car " + carNumber + " removed from slot " + slot;
    }
    
    // Display current parking status
    public String display() {
        StringBuilder result = new StringBuilder();
        result.append("========== PARKING STATUS ==========\n");
        
        for (int i = 0; i < capacity; i++) {
            String status = (slots[i] == null) ? "FREE" : slots[i];
            result.append("Slot ").append(String.format("%2d", i)).append(": ").append(status);
            
            // Mark entrance
            if (i == capacity / 2) {
                result.append(" ← ENTRANCE");
            }
            result.append("\n");
        }
        
        result.append("\n========== WAITING QUEUE ==========\n");
        if (waitingQueue.isEmpty()) {
            result.append("Empty\n");
        } else {
            int pos = 1;
            for (String car : waitingQueue) {
                result.append(pos++).append(". ").append(car).append("\n");
            }
        }
        
        return result.toString();
    }
}