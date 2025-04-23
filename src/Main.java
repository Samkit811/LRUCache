public class Main {
    public static void main(String[] args) {

        DBConnection dbConnection = DBConnection.getInstance();

        L1Cache l1Cache = new L1Cache(5, dbConnection);

        for(int i = 0; i < 5; i++){
            Integer value = l1Cache.search(i);
            System.out.println("Getting value: " + value + " for the key: " + i);
        }

        System.out.println("---- After adding Element -----");

        Integer value = l1Cache.search(0);
        System.out.println("Getting value: " + value + " for the key: " + 0);

        value = l1Cache.search(10);
        System.out.println("Getting value: " + value + " for the key: " + 10);
    }
}