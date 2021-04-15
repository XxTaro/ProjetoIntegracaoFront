package main.java.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import main.java.controller.ConnectionApi;

@SuppressWarnings("unused")
public class MainViewController {
	
	ConnectionApi apiController = new ConnectionApi();
	
    @FXML
    public ComboBox<String> cbbLine;
    
    @FXML
    public TitledPane tpModel;
    
    @FXML
    public TitledPane tpLine;

    @FXML
    public TreeView<String> treeModel;
    
    @FXML
    public TextField tf1;

    @FXML
    public TextField tf2;

    @FXML
    public TextField tf3;


    @FXML
    public void enableModel(ActionEvent event) {
    	if(cbbLine.getSelectionModel().getSelectedItem() != null) {
    		setupTreeModel();
    		tpModel.setDisable(false);
    	}
    }

    @FXML
    public void initialize() {
    	setupCbbLine();
    	tpModel.setDisable(true);
    }
    
    @FXML
    public void resetSelection(ActionEvent event) {
    	initialize();
    	tpLine.setExpanded(false);
    	tpModel.setExpanded(false);
    	cbbLine.getSelectionModel().clearSelection();
    }
    
    List<LineModelEntity> listLineModel = apiController.APIGet();
	ArrayList<String> listLinha = new ArrayList<String>();
	
    
    public void setupCbbLine(){
    	for(LineModelEntity listLine : listLineModel) {
    		if(!listLinha.contains(listLine.getLinha())) {
    			listLinha.add(listLine.getLinha());
    		}
    	}
    	
    	cbbLine.setItems(FXCollections.observableArrayList(listLinha));
    	listCat.clear();
    }
    
    ArrayList<String> listCat = new ArrayList<String>();
    public void setupTreeModel() {
    	
		TreeItem<String> root = new TreeItem<String>(cbbLine.getSelectionModel().getSelectedItem());
		treeModel.setRoot(root);
		
		for(LineModelEntity listLine : listLineModel) {
			if(listLine.getLinha().equals(cbbLine.getSelectionModel().getSelectedItem()) && !listCat.contains(listLine.getCategoria())) {
				listCat.add(listLine.getCategoria());
			}
		}
		
		for(String listCatg : listCat) {
			TreeItem<String> rootCat = new TreeItem<String>(listCatg);
			root.getChildren().add(rootCat);
			
			for(LineModelEntity listModel : listLineModel) {
				if(listModel.getCategoria().equals(listCatg)) {
					TreeItem<String> rootModel = new TreeItem<String>(listModel.toString()); 
					rootCat.getChildren().add(rootModel);
				}
			}
		}
		setupCbbLine();
    }

    @FXML
    public void tf1action(ActionEvent event) {
    	if(!tf2.getText().isEmpty()) {
    		int somatf = soma(tf1.getText(),tf2.getText());
    		tf3.setText(Integer.toString(somatf));
    	}
    	else{
    		tf3.setText(tf1.getText());
    	}
    }
    
   
    @FXML
    public void tf2action(ActionEvent event) {
    	if(!tf1.getText().isEmpty()) {
    		int somatf = soma(tf1.getText(),tf2.getText());
    		tf3.setText(Integer.toString(somatf));
    	}
    	else{
    		tf3.setText(tf2.getText());
    	}
    }
    
    int soma(String a, String b) {
    	return Integer.parseInt(a)+Integer.parseInt(b);
    }

}
