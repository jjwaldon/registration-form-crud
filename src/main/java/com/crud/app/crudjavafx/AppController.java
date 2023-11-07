package com.crud.app.crudjavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.sql.*;
import java.util.logging.*;
import javafx.collections.*;
import javafx.scene.control.TableRow;

public class AppController implements Initializable
{

    @FXML
    private Label labFirst;
    @FXML
    private Label labSecond;
    @FXML
    private Label labPhone;

    @FXML
    private TableView<UniModel> table;
    @FXML
    TableColumn<UniModel, String> idColumn;
    @FXML
    TableColumn<UniModel, String> firstColumn;
    @FXML
    TableColumn<UniModel, String> secondColumn;
    @FXML
    TableColumn<UniModel, String> phoneColumn;
    @FXML
    private TextField textFirst;
    @FXML
    private TextField textSecond;
    @FXML
    private TextField textPhone;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;

    @FXML
    void Add(ActionEvent event)
    {


    }

    @FXML
    void Update(ActionEvent event)
    {


    }

    @FXML
    void Delete(ActionEvent event)
    {


    }

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;



    public void tableShow()
    {

        Connect();
        ObservableList<UniModel> uni = FXCollections.observableArrayList();
        try
        {

            pst = con.prepareStatement("select id,firstname,secondname,phone from stud.lecturers");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    UniModel st = new UniModel();
                    st.setId(rs.getString("id"));
                    st.setFirstName(rs.getString("firstName"));
                    st.setSecondName(rs.getString("secondName"));
                    st.setPhone(rs.getString("Phone"));
                    uni.add(st);
                }
            }
            table.setItems(uni);
            idColumn.setCellValueFactory(f -> f.getValue().idProperty());
            firstColumn.setCellValueFactory(f -> f.getValue().FirstnameProperty());
            secondColumn.setCellValueFactory(f -> f.getValue().secondNameProperty());
            phoneColumn.setCellValueFactory(f -> f.getValue().phoneProperty());

        }

        catch (SQLException ex)
        {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setRowFactory( tv -> {
            TableRow<UniModel> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  table.getSelectionModel().getSelectedIndex();

                    id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).idProperty()));
                    textFirst.setText(table.getItems().get(myIndex).getFirstName());
                    textSecond.setText(table.getItems().get(myIndex).getSecondName());
                    textPhone.setText(table.getItems().get(myIndex).getPhone());



                }
            });
            return myRow;
        });


    }



    public void Connect()
    {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/university","postgres","menel");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        tableShow();
    }

}
