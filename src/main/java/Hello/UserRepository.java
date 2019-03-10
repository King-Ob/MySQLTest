package Hello;



import org.springframework.data.repository.CrudRepository;

public class UserRepository {


    public interface UserRepositry extends CrudRepository<User, Integer>{

}

}
