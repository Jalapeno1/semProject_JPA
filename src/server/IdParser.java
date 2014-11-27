package Server;

public class IdParser { 
    
    public int parseID(String json){
        System.out.println("in parser");
        System.out.println(json);
        String line1[] = json.split("\"id\":");
        String scanRes = line1[2];
        System.out.println(line1[2]);
        String id[] = scanRes.split(",\"");
        String finalID = id[1];
        System.out.println(id[1]);
        return Integer.parseInt(finalID); 
    }
}
