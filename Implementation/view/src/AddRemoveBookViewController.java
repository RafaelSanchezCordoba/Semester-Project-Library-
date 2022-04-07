import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class AddRemoveBookViewController
{

  private ViewHandler viewHandler;
  private Region root;
  private AddRemoveBookViewModel viewModel;
  @FXML private TextField tittleTextField;
  @FXML private TextField publisherTextField;
  @FXML private TextField authorTextField;
  @FXML private TextField isbnTextField;
  @FXML private TextField yearTextField;
  @FXML private TextField genreTextField;
  @FXML private TextField editionTextField;
  @FXML private TextField searchTextField;
  @FXML private ListView bookListView;
  @FXML private Label errorLabel;



  public void init(ViewHandler viewHandler, AddRemoveBookViewModel viewModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel=viewModel;
    this.root = root;
    //include all the bind from viewModel
  }

  @FXML
  public void logOutButtonPressed()
  {
    viewHandler.closeView();
  }

  @FXML
  public void searchButtonPressed()
  {
    viewModel.search();
  }

  @FXML
  public void addBookButtonPressed()
  {
    viewModel.addBook();
  }

  @FXML
  public void removeBookButtonPressed()
  {
    viewModel.removeBook();
  }

  @FXML
  public void homeMenuButtonPressed()
  {
    viewHandler.openView("home");
  }

  @FXML
  public void bookMenuButtonPressed()
  {

  }

  @FXML
  public void magazinesMenuButtonPressed()
  {

  }
}
