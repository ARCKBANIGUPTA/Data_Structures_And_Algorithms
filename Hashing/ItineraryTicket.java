import java.util.HashMap;
import java.util.HashSet;

public class ItineraryTicket {
    
    public static String findStart(HashMap<String,String> tickets){
        HashMap<String,String> revtickets = new HashMap<>();
        for(String t : tickets.keySet()){
            revtickets.put(tickets.get(t),t);
        }
        for(String key : tickets.keySet()){
            if(!revtickets.containsKey(key)){
                return key;//starting point
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> ticket = new HashMap<>();
        ticket.put("Chennai", "Bengaluru");
        ticket.put("Mumbai","Delhi");
        ticket.put("Goa","Chennai");
        ticket.put("Delhi","Goa");
        String start = findStart(ticket);
        System.out.print(start);
        for(String t : ticket.keySet()){
            System.out.print("->"+ticket.get(start));
            start= ticket.get(start);
        }
        System.out.println();
    }   
}
