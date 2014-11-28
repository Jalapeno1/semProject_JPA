package facades;

import model.UserDetails;

public interface facadeInterface {

    public String getUserAsJson(String username);

    public UserDetails addUserFromGson(String json);

    public UserDetails deleteUser(String userName);

}
