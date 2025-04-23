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

    public long fetchFromDB(Integer key){
        System.out.println("Fetching the data from DB for the key: " + key);
        long currentTimeInMilliSecond = System.currentTimeMillis();
        System.out.println("DB value: " + currentTimeInMilliSecond + " for the key: " + key);
        return currentTimeInMilliSecond;
    }
}
