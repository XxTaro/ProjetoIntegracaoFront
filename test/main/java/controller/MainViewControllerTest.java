package main.java.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.testfx.framework.junit.ApplicationTest;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeView;

public class MainViewControllerTest extends ApplicationTest {

	private MainViewController mvc;

    @Before
    public void initTest() {
        mvc = spy(MainViewController.class);
        
        mvc.tpModel = new TitledPane();
        mvc.tpLine = new TitledPane();
        mvc.cbbLine = new ComboBox();
        mvc.treeModel = new TreeView();
    }
	
    @After
    public void finishTest() {
        mvc = null;

    }
	
	//TESTES FUNÇÕES
	
	@Test
	public void testEnableModel() {
		PowerMockito.doNothing().when(mvc).setupTreeModel();
		mvc.cbbLine.getSelectionModel().select("a");
		mvc.enableModel(null);
		verify(mvc, times(1)).setupTreeModel();
	}
	
	@Test
	public void testEnableModel1() {
		PowerMockito.doNothing().when(mvc).setupTreeModel();
		mvc.tpModel.setDisable(true);
		mvc.cbbLine.getSelectionModel().select("a");
		mvc.enableModel(null);
		assertEquals(false, mvc.tpModel.isDisable());
	}
	
	@Test
	public void testInitialize() {
		PowerMockito.doNothing().when(mvc).setupCbbLine();
		mvc.initialize();
		verify(mvc, times(1)).setupCbbLine();
	}
	
	@Test
	public void testInitialize1() {
		PowerMockito.doNothing().when(mvc).setupCbbLine();
		mvc.tpModel.setDisable(false);
		mvc.initialize();
		assertEquals(true, mvc.tpModel.isDisable());
	}
	
	@Test
	public void testResetSelection() {
		PowerMockito.doNothing().when(mvc).initialize();
		mvc.resetSelection(null);
		verify(mvc, times(1)).initialize();
	}
	
	@Test
	public void testResetSelection1() {
		PowerMockito.doNothing().when(mvc).initialize();
		mvc.tpLine.setExpanded(true);
		mvc.resetSelection(null);
		assertEquals(false, mvc.tpLine.isExpanded());
	}
	
	@Test
	public void testResetSelection3() {
		PowerMockito.doNothing().when(mvc).initialize();
		mvc.tpModel.setExpanded(true);
		mvc.resetSelection(null);
		assertEquals(false, mvc.tpModel.isExpanded());
	}
	
	@Test
	public void testResetSelection4() {
		PowerMockito.doNothing().when(mvc).initialize();
		mvc.cbbLine.getSelectionModel().select("a");;
		mvc.resetSelection(null);
		assertEquals(true, mvc.cbbLine.getSelectionModel().isEmpty());
	}
	
	@Test
	public void testSetupCbbLine() {
		mvc.setupCbbLine();
		assertEquals(false, mvc.listLinha.isEmpty());
	}
	
	@Test
	public void testSetupCbbLine2() {
		mvc.setupCbbLine();
		assertEquals(false, mvc.cbbLine.getItems().isEmpty());
	}
	
	@Test
	public void testSetupCbbLine3() {
		mvc.setupCbbLine();
		assertEquals(true, mvc.listCat.isEmpty());
	}
	
	@Test
	public void testSetupTreeModelCbb() {
		mvc.cbbLine.getSelectionModel().select("Ares");
		mvc.setupTreeModel();
		assertEquals("Ares", mvc.treeModel.getRoot().getValue());
	}
	
	@Test
	public void testSetupTreeModelCbb2() {
		mvc.cbbLine.getSelectionModel().select("Zeus");
		mvc.setupTreeModel();
		assertEquals("Zeus", mvc.treeModel.getRoot().getValue());
	}
	
	@Test
	public void testSetupTreeModelCat() {
		PowerMockito.doNothing().when(mvc).setupCbbLine();
		mvc.cbbLine.getSelectionModel().select("Ares");
		mvc.setupTreeModel();
		assertEquals(false, mvc.listCat.isEmpty());
	}
	
	@Test
	public void testSetupTreeModelCat2() {
		PowerMockito.doNothing().when(mvc).setupCbbLine();
		mvc.cbbLine.getSelectionModel().select("Ares");
		mvc.setupTreeModel();
		assertEquals(2, mvc.listCat.size());
	}
	
	@Test
	public void testSetupTreeModelCat3() {
		PowerMockito.doNothing().when(mvc).setupCbbLine();
		mvc.cbbLine.getSelectionModel().select("Zeus");
		mvc.setupTreeModel();
		assertEquals(false, mvc.listCat.isEmpty());
	}

	@Test
	public void testSetupTreeModelCat4() {
		PowerMockito.doNothing().when(mvc).setupCbbLine();
		mvc.cbbLine.getSelectionModel().select("Zeus");
		mvc.setupTreeModel();
		assertEquals(2, mvc.listCat.size());
	}
	
	@Test
	public void testSetupTreeModelCat5() {
		mvc.cbbLine.getSelectionModel().select("Ares");
		mvc.setupTreeModel();
		assertEquals("TB", mvc.treeModel.getRoot().getChildren().get(0).getValue());
	}
	
	@Test
	public void testSetupTreeModelCat6() {
		mvc.cbbLine.getSelectionModel().select("Ares");
		mvc.setupTreeModel();
		assertEquals("THS", mvc.treeModel.getRoot().getChildren().get(1).getValue());
	}
	
	@Test
	public void testSetupTreeModelCat7() {
		mvc.cbbLine.getSelectionModel().select("Zeus");
		mvc.setupTreeModel();
		assertEquals("Direto", mvc.treeModel.getRoot().getChildren().get(0).getValue());
	}
	
	@Test
	public void testSetupTreeModelCat8() {
		mvc.cbbLine.getSelectionModel().select("Zeus");
		mvc.setupTreeModel();
		assertEquals("Indireto", mvc.treeModel.getRoot().getChildren().get(1).getValue());
	}
	
	@Test
	public void testSetupTreeModelMod() {
		mvc.cbbLine.getSelectionModel().select("Ares");
		mvc.setupTreeModel();
		assertEquals("Ares 7021", mvc.treeModel.getRoot().getChildren().get(0).getChildren().get(0).getValue());
	}
	
	@Test
	public void testSetupTreeModelMod2() {
		mvc.cbbLine.getSelectionModel().select("Ares");
		mvc.setupTreeModel();
		assertEquals("Ares 7031", mvc.treeModel.getRoot().getChildren().get(0).getChildren().get(1).getValue());
	}
	
	@Test
	public void testSetupTreeModelMod3() {
		mvc.cbbLine.getSelectionModel().select("Ares");
		mvc.setupTreeModel();
		assertEquals("Ares 7023", mvc.treeModel.getRoot().getChildren().get(0).getChildren().get(2).getValue());
	}
	
	@Test
	public void testSetupTreeModelMod4() {
		mvc.cbbLine.getSelectionModel().select("Ares");
		mvc.setupTreeModel();
		assertEquals("Ares 8021", mvc.treeModel.getRoot().getChildren().get(1).getChildren().get(0).getValue());
	}
	
	@Test
	public void testSetupTreeModelMod5() {
		mvc.cbbLine.getSelectionModel().select("Ares");
		mvc.setupTreeModel();
		assertEquals("Ares 8031", mvc.treeModel.getRoot().getChildren().get(1).getChildren().get(1).getValue());
	}
	
	@Test
	public void testSetupTreeModelMod6() {
		mvc.cbbLine.getSelectionModel().select("Ares");
		mvc.setupTreeModel();
		assertEquals("Ares 8023", mvc.treeModel.getRoot().getChildren().get(1).getChildren().get(2).getValue());
	}
	
	@Test
	public void testSetupTreeModelMod7() {
		mvc.cbbLine.getSelectionModel().select("Zeus");
		mvc.setupTreeModel();
		assertEquals("Zeus 8021", mvc.treeModel.getRoot().getChildren().get(0).getChildren().get(0).getValue());
	}
	
	@Test
	public void testSetupTreeModelMod8() {
		mvc.cbbLine.getSelectionModel().select("Zeus");
		mvc.setupTreeModel();
		assertEquals("Zeus 8031", mvc.treeModel.getRoot().getChildren().get(0).getChildren().get(1).getValue());
	}
	
	@Test
	public void testSetupTreeModelMod9() {
		mvc.cbbLine.getSelectionModel().select("Zeus");
		mvc.setupTreeModel();
		assertEquals("Zeus 8023", mvc.treeModel.getRoot().getChildren().get(0).getChildren().get(2).getValue());
	}
	
	@Test
	public void testSetupTreeModelMod10() {
		mvc.cbbLine.getSelectionModel().select("Zeus");
		mvc.setupTreeModel();
		assertEquals("Zeus 8023-2,5", mvc.treeModel.getRoot().getChildren().get(1).getChildren().get(0).getValue());
	}
	
	@Test
	public void testSetupTreeModelSetupCbbLine() {
		mvc.setupTreeModel();
		verify(mvc, times(1)).setupCbbLine();
	}
	
}
