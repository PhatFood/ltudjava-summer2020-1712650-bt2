import controller.LoginController;
import controller.LopController;
import model.csvReader;
import model.dao.TaiKhoanDAO;
import model.enteties.TaiKhoan;
import view.Login;
import view.LopView;

public class Main {

    public static void main(String[] args) {

        Login view = new Login();
        LoginController a = new LoginController(view);
        a.showLoginView();

    }
}
