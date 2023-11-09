package com.crud.app.crudjavafx;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.sql.*;
import javafx.collections.*;
import javafx.scene.control.TableRow;

public class AppController implements Initializable
{
    @FXML
    public Button buttonDelete;
    @FXML
    public Button buttonUpdate;
    @FXML
    public Button buttonAdd;
    @FXML
    public Label labPhone;
    @FXML
    public Label labFirst;
    @FXML
    public Label labSecond;
    Connection connect = conn.Connect();
    PreparedStatement pst;
    int myIndex;
    int id;
    static DatabaseConnector conn = new DatabaseConnector();

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
    private TextField textId;
    @FXML
    void Add()
    {

        String id, fname,sname,phone;
        id = textId.getText();
        fname = textFirst.getText();
        sname = textSecond.getText();
        phone = textPhone.getText();
        try
        {
            pst = connect.prepareStatement("insert into stud.lecturers(id, firstName,secondName,Phone)values(?,?,?,?)");
            pst.setInt(1, Integer.parseInt(id));
            pst.setString(2, fname);
            pst.setString(3, sname);
            pst.setString(4, phone);
            pst.executeUpdate();

            Alert notify = new Alert(Alert.AlertType.INFORMATION);
            notify.setTitle("University Form");
            notify.setHeaderText("Lecturer Registration");
            notify.setContentText("Operation Successful");
            notify.showAndWait();
            tableShow();
            textId.setText("");
            textFirst.setText("");
            textSecond.setText("");
            textPhone.setText("");
            textId.requestFocus();
        }
        catch (SQLException ex)
        {
            Alert fatal = new Alert(Alert.AlertType.ERROR);
            fatal.setTitle("University Form");
            fatal.setHeaderText("Add Error");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String exception = sw.toString();
            fatal.setContentText(exception);
        }
    }

    @FXML
    void Update()
    {
        String id, fname,sname,phone;

        myIndex = table.getSelectionModel().getSelectedIndex();
        id = textId.getText();
        fname =  textFirst.getText();
        sname = textSecond.getText();
        phone = textPhone.getText();
        try
        {
            pst = connect.prepareStatement("update stud.lecturers set firstName = ?,secondName = ? ,Phone = ? where id = ? ");

            pst.setString(1, fname);
            pst.setString(2, sname);
            pst.setString(3, phone);
            pst.setInt(4, Integer.parseInt(id));
            pst.executeUpdate();
            Alert update = new Alert(Alert.AlertType.INFORMATION);
            update.setTitle("University Form");
            update.setHeaderText("Lecturer Registration");
            update.setContentText("Operation Successful");
            update.showAndWait();
            tableShow();
        }
        catch (SQLException ex)
        {
            Alert fatal = new Alert(Alert.AlertType.ERROR);
            fatal.setTitle("University Form");
            fatal.setHeaderText("Update Error");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String exception = sw.toString();
            fatal.setContentText(exception);
        }

    }

    @FXML
    void Delete()
    {
        myIndex = table.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

        try
        {
            pst = connect.prepareStatement("delete from stud.lecturers where id = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();

            Alert del = new Alert(Alert.AlertType.INFORMATION);
            del.setTitle("University Form");
            del.setHeaderText("Lecturer Registration");
            del.setContentText("Operation Successful");
            del.showAndWait();
            tableShow();
        }
        catch (SQLException ex)
        {
            Alert fatal = new Alert(Alert.AlertType.ERROR);
            fatal.setTitle("University Form");
            fatal.setHeaderText("Delete Error");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String exception = sw.toString();
            fatal.setContentText(exception);
        }

    }


    public void tableShow()
    {

        conn.Connect();
        ObservableList<UniModel> uni = FXCollections.observableArrayList();
        try
        {

            pst = connect.prepareStatement("select id,firstname,secondname,phone from stud.lecturers order by id");
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
            Alert fatal = new Alert(Alert.AlertType.ERROR);
            fatal.setTitle("University Form");
            fatal.setHeaderText("Data Load Error");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String exception = sw.toString();
            fatal.setContentText(exception);
        }
        table.setRowFactory( tv -> {
            TableRow<UniModel> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    try
                    {
                        myIndex = table.getSelectionModel().getSelectedIndex();

                        textId.setText(table.getItems().get(myIndex).getId());
                        textFirst.setText(table.getItems().get(myIndex).getFirstName());
                        textSecond.setText(table.getItems().get(myIndex).getSecondName());
                        textPhone.setText(table.getItems().get(myIndex).getPhone());
                    }
                    catch(IndexOutOfBoundsException ex)
                    {
                        Alert fatal = new Alert(Alert.AlertType.ERROR);
                        fatal.setTitle("University Form");
                        fatal.setHeaderText("Selection Error");
                        StringWriter sw = new StringWriter();
                        PrintWriter pw = new PrintWriter(sw);
                        ex.printStackTrace(pw);
                        String exception = sw.toString();
                        fatal.setContentText(exception);
                        ex.printStackTrace();
                    }

                }
            });
            return myRow;
        });


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn.Connect();
        tableShow();
    }

}
