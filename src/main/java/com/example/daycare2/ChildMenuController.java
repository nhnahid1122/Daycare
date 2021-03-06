package com.example.daycare2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ChildMenuController implements Initializable {
    public ChildMenuController(){}
    //childMenu Attributes

    @FXML
    private Button addToWaitingListBtn;
    @FXML
    private Button backBtn;
    @FXML
    private Button seeTheChildListBtn;
    @FXML
    private Button seeTheWaitingListBtn;
    @FXML
    private Button parentalINfoBtn;

    // Parental Info attributes
    @FXML
    protected Button addParentInfoBtn;
    @FXML
    protected Button parentalBackBtn;
    @FXML
    protected Button seeParentInfoBtn;

    // add parental info attributes
    @FXML
    private TextField parentalInfoAddressTxtFld;
    @FXML
    private Button parentalInfoCanclBtn;
    @FXML
    private Button parentalInfoEnterBtn;
    @FXML
    private TextField parentalInfoFirstNameTxtFld;
    @FXML
    private TextField parentalInfoLastNameTxtFld;
    @FXML
    private TextField parentalInfoPhoneTxtFld;

    //Add to childrenList attributes

    @FXML
    private Button csCanclBtn;
    @FXML
    private Label csLable;
    @FXML
    private Button csEnterBtn;
    @FXML
    private DatePicker dateOfBirthTxtFld;
    @FXML
    private TextField firstNameTxtFld;
    @FXML
    private TextField guardianIdTxtFld;
    @FXML
    private TextField lastNameTxtFld;

    // Add to waiting list attributes

    @FXML
    private TextField fathersNameTextField;
    @FXML
    private TextField mothersNameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField contactNrTextField;
    @FXML
    private Button addingCanclBtn;
    @FXML
    private Button addingEnterBtn;



    // See child Attributes
    @FXML
    private TableView<User> tblview;
    @FXML
    private TableColumn<User,String> idClmn;
    @FXML
    private TableColumn<User,String> fnClmn;
    @FXML
    private TableColumn<User,String> lnClmn;
    @FXML
    private TableColumn<User,String> bdClmn;
    @FXML
    private TableColumn<User,String> giClmn;





    @FXML
    public void addChildToDatabase(){}
    @FXML
    public void seeChildDatabase(){}
    @FXML
    public void addWaitingList(){}
    @FXML
    public void seeTheWaitingList(){}


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//  --------------Children menu button actions------------------------------------------------
        try {
//----------------- Children menu list: 1 > Add new child data to database -------------------------------


//----------------- Children menu list: 2 > Add to waiting list -------------------------------
        addToWaitingListBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Utils.changeScene3("adding.fxml","Add Menu");
//                    Utils.changeScene(event,"adding.fxml","Add to waiting list menu");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
//----------------- Children menu list: 3 > see the children list -------------------------------

        seeTheChildListBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Utils.changeScene(event,"seeTheChildrenList.fxml", "See the children menu");
                } catch ( IOException e) {
                    e.printStackTrace();
                }
            }
        });

//---------------- Children menu list: 4 > See the waiting list ------------------------------------------
                seeTheWaitingListBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            Utils.changeScene3("adding.fxml","Add Menu");
                            //Utils.changeScene(event,"seeTheWaitingList.fxml","Waiting List");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
//----------------- Children menu list: 5 > Parental Info ------------------------------------------

        parentalINfoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Utils.changeScene(event,"seeTheParentalInfo.fxml", "Parental Info menu");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


//----------------- Children menu back button to main menu-----------------------------------------

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Utils.changeScene(event, "menu.fxml", "Main menu");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        } catch (Exception e) {
            e.printStackTrace();
        }

//-------------------------- add child to children list ----------------------------------------------------
        try {
            csLable.setText("");

            csEnterBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {


                    try {
                        Utils.addChildToList("children",firstNameTxtFld.getText(), lastNameTxtFld.getText(), dateOfBirthTxtFld.getValue(),"");


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    firstNameTxtFld.setText("");
                    lastNameTxtFld.setText("");
                    //dateOfBirthTxtFld.setValue(LocalDate.parse(""));
                    guardianIdTxtFld.setText(" ");
                    csLable.setText("Added");
                    csLable.setTextFill(Color.BLUE);
                    try {
                        Utils.changeScene3("addParentalInfo.fxml", "Add parent info");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }catch (NullPointerException e){
            e.printStackTrace();
        }

        try {
            csCanclBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        Utils.changeScene(event, "childrenMenu.fxml", "Children Menu");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        // add to waiting list button actions
//        try {
//            addingEnterBtn.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    try {
//                        Utils.addChildToList("waiting_list", waitingListFirstNameTxtFld.getText(), waitingListLastNameTxtFld.getText(),
//                                waitingListDateOfBirthTxtFld.getValue(), waitingListGuardianIdTxtFld.getText());
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            });
//
//            addingCanclBtn.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    try {
//                        Utils.changeScene(event, "childrenMenu.fxml", " Children Menu");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



//----------- Parental info menu list: 1 > add parental info --------------------------------------------------
//        try {
//            addParentInfoBtn.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    try {
//                        Utils.changeScene(event, "addParentalInfo.fxml", " Add parent info menu");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });

//----------- Parental info menu list: 2 > see parental info --------------------------------------------------
//            try {
//                seeParentInfoBtn.setOnAction(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//                        try {
//                            Utils.changeScene(event, "seeTheParentalInfo.fxml", "parent info");
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            } catch (Exception e) {
//                e.printStackTrace();
//            }


//----------- Parental info back button to children menu------- --------------------------------------------
//            parentalBackBtn.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    try {
//                        Utils.changeScene(event, "childrenMenu.fxml", " Children menu");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//----------------------------------Add parental info ----------------------------------------------------------
//        try {
//            parentalInfoEnterBtn.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    try {
//                        Utils.addParentalInfo(parentalInfoFirstNameTxtFld.getText(),parentalInfoLastNameTxtFld.getText(),
//                                parentalInfoPhoneTxtFld.getText(),parentalInfoAddressTxtFld.getText());
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            parentalInfoCanclBtn.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    try {
//                        Utils.changeScene(event, "parentalInfo.fxml","Parental Info menu");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }




}

