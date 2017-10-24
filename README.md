# Repository_pattern

This repository is on how implement the repository pattern with multiple data sources on Android.

Before starting I assume you are already familiar with android development son I wont explain the basis on create a project, module, activities, etc. If you are not familiar with android development there are many great resources to lear online like Udacity.

What is the Repository pattern for?

The repository pattern is useful to hide the data source from which the application is getting the information. For example we could have different data sources depending on internet connection or if the application has online/offline modes.

Now I will explane the different classes an packages from the project.

First, the repository pattern was created n an android library so it could be easer to understand as it is separated from the rest of the example application simulating an SDK provided by a third party.

The entrance point for this sample SDK is the ExampleApi interface which have two methods

```
public interface ExampleApi {

    void loginUser(String username, String password, UserLoginCallback userLoginCallback);

    void getProfile(String userName, GetUserProfileCallback getUserProfileCallback);
}

```

Those methods are implemented in the class ExampleApi, an will provide the data for our application.

```

public class ExampleApiImpl implements ExampleApi {

    private static ExampleApi sExampleApi;

    private ExampleApiImpl() {
        //only exists ti defeat instantiation
    }

    public static ExampleApi getInstance() {

        if(sExampleApi == null) {
            sExampleApi = new ExampleApiImpl();
        }

        return sExampleApi;

    }

    @Override
    public void loginUser(String username, String password, UserLoginCallback userLoginCallback) {
        DataRepository.getInstance().loginUser(username, password, userLoginCallback);
    }

    @Override
    public void getProfile(String userName, GetUserProfileCallback getUserProfileCallback) {

        DataRepository.getInstance().getUserProfile(userName, getUserProfileCallback);
    }
}
```

As we can see in the implementation the methods use a DataRepository which is the one that make the actual call to the method in the selected data source.

```
public class DataRepository implements Repository{

    private static Repository sRepository;

    private DataRepository(){
        //only to defeat instantiation
    }

    public static Repository getInstance() {

        if(sRepository == null) {
            sRepository = new DataRepository();
        }
        return  sRepository;
    }

    @Override
    public void loginUser(String userName, String password, UserLoginCallback userLoginCallback) {
        DataSource dataSource = DataSourceFactory.create();
        dataSource.loginUser(userName, password, userLoginCallback);
    }

    @Override
    public void getUserProfile(String username, GetUserProfileCallback userProfileCallback) {
        DataSource dataSource = DataSourceFactory.create();
        dataSource.getUserProfile(username, userProfileCallback);

    }
}
```

Now, the data source is not chosen by the calling method, it is chosen by a factory class that implements the logic to decide which data source will be used.

```
public class DataSourceFactory {

    private static CloudDataSource sCloudDataSource;

    private static LocalDataSource sLocalDataSource;

    private static int chooseDataSource() {
        int min = 1;
        int max = 2;

        Random r = new Random();
        int i1 = r.nextInt(max - min + 1) + min;

        return i1;
    }

    public static DataSource create() {

        int dataSource = chooseDataSource();

        if(dataSource == 1) {

            if(sCloudDataSource == null) {
                sCloudDataSource = new CloudDataSource();
            }

            return sCloudDataSource;

        } else {
            if(sLocalDataSource == null) {
                sLocalDataSource = new LocalDataSource();
            }
            return sLocalDataSource;
        }

    }
}
```

In this example the use a random function to decide which data source to use, but we could one data source in case we don't have internet connection and another when we do have the connection. This is accomplished using a single interface that is implemented by the multiple data sources.

```
public interface DataSource {

    void loginUser(String userName, String password, UserLoginCallback userLoginCallback);

    void getUserProfile(String username, GetUserProfileCallback userProfileCallback);
}
```
