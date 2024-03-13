import repositories.UsersRepository;

public class UsersController {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepository();
        usersRepository.create("Norma", "Puspitasari");
    }
}