public class DBConnection {

    private static DBConnection instance;

    private DBConnection(){
        System.out.println("Establishing the DB connection");
    }

    public static DBConnection getInstance(){
        if(instance == null){
            synchronized (DBConnection.class){
                if(instance == null){
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    public Integer fetchFromDB(Integer key){
        System.out.println("Fetching the data from DB for the key: " + key);
        int randomNumber = (int) (Math.random() * 100);
        System.out.println("DB value: " + randomNumber + " for the key: " + key);
        return randomNumber;
    }
}
