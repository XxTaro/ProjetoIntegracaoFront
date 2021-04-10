package main.java.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import main.java.controller.ConnectionApi;

@SuppressWarnings("unused")
public class MainViewController {
	
	ConnectionApi apiController = new ConnectionApi();
	
    @FXML
    private ComboBox<String> cbbLine;
    
    @FXML
    private TitledPane tpModel;
    
    @FXML
    private TitledPane tpLine;

    @FXML
    private TreeView<String> treeModel;

    @FXML
    void enableModel(ActionEvent event) {
    	if(cbbLine.getSelectionModel().getSelectedItem() != null) {
    		setupTreeModel();
    		tpModel.setDisable(false);
    	}
    }

    @FXML
    private void initialize() {
    	setupCbbLine();
    	tpModel.setDisable(true);
    }
    
    @FXML
    void resetSelection(ActionEvent event) {
    	initialize();
    	tpLine.setExpanded(false);
    	tpModel.setExpanded(false);
    	cbbLine.getSelectionModel().clearSelection();
    }
    
    List<LineModelEntity> listLineModel = apiController.APIGet();
	ArrayList<String> listLinha = new ArrayList<String>();
    
    private void setupCbbLine(){
    	for(LineModelEntity listLine : listLineModel) {
    		if(!listLinha.contains(listLine.getLinha())) {
    			listLinha.add(listLine.getLinha());
    		}
    	}
    	
    	cbbLine.setItems(FXCollections.observableArrayList(listLinha));
    }
    
    private void setupTreeModel() {
    	ArrayList<String> listCat = new ArrayList<String>();
    	
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
    }
}
