
package persistence;

/**
 *
 * @author Rian Alves
 */
public class RestauranteDAO {

    private static final RestauranteDAO INSTANCE = new RestauranteDAO();

    public static RestauranteDAO getINSTANCE() {
        return INSTANCE;
    }

}
