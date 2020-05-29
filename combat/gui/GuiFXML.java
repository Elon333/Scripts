package scripts.combat.gui;

public class GuiFXML {

public static String get = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
		"\r\n" + 
		"<?import com.jfoenix.controls.JFXRadioButton?>\r\n" + 
		"<?import javafx.scene.control.Button?>\r\n" + 
		"<?import javafx.scene.control.CheckBox?>\r\n" + 
		"<?import javafx.scene.control.Label?>\r\n" + 
		"<?import javafx.scene.control.TextArea?>\r\n" + 
		"<?import javafx.scene.control.TextField?>\r\n" + 
		"<?import javafx.scene.effect.InnerShadow?>\r\n" + 
		"<?import javafx.scene.effect.Light.Distant?>\r\n" + 
		"<?import javafx.scene.effect.Lighting?>\r\n" + 
		"<?import javafx.scene.effect.Shadow?>\r\n" + 
		"<?import javafx.scene.image.ImageView?>\r\n" + 
		"<?import javafx.scene.layout.AnchorPane?>\r\n" + 
		"<?import javafx.scene.layout.Pane?>\r\n" + 
		"<?import javafx.scene.shape.Rectangle?>\r\n" + 
		"<?import javafx.scene.text.Font?>\r\n" + 
		"\r\n" + 
		"<AnchorPane fx:id=\"rootPane\" prefHeight=\"445.0\" prefWidth=\"646.0\" xmlns=\"http://javafx.com/javafx/8.0.171\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"scripts.combat.gui.GUIController\">\r\n" + 
		"   <children>\r\n" + 
		"      <AnchorPane id=\"sidePage\" fx:id=\"sidePane\" layoutY=\"-1.0\" prefHeight=\"445.0\" prefWidth=\"65.0\" style=\"-fx-background-color: #202225;\">\r\n" + 
		"         <children>\r\n" + 
		"            <ImageView fx:id=\"miscImage\" fitHeight=\"48.0\" fitWidth=\"48.0\" layoutX=\"10.0\" layoutY=\"150.0\" pickOnBounds=\"true\" preserveRatio=\"true\">\r\n" + 
		"               <effect>\r\n" + 
		"                  <InnerShadow />\r\n" + 
		"               </effect></ImageView>\r\n" + 
		"            <ImageView fx:id=\"inventoryButtonImage\" fitHeight=\"54.0\" fitWidth=\"54.0\" layoutX=\"6.0\" layoutY=\"78.0\" pickOnBounds=\"true\" preserveRatio=\"true\">\r\n" + 
		"               <effect>\r\n" + 
		"                  <InnerShadow />\r\n" + 
		"               </effect></ImageView>\r\n" + 
		"            <ImageView fx:id=\"mainImage\" fitHeight=\"50.0\" fitWidth=\"50.0\" layoutX=\"8.0\" layoutY=\"10.0\" pickOnBounds=\"true\" preserveRatio=\"true\">\r\n" + 
		"               <effect>\r\n" + 
		"                  <InnerShadow />\r\n" + 
		"               </effect></ImageView>\r\n" + 
		"            <JFXRadioButton id=\"mainButton\" fx:id=\"mainButton\" layoutX=\"8.0\" layoutY=\"7.0\" onAction=\"#bringMainPageToFront\" opacity=\"0.0\" prefHeight=\"50.0\" prefWidth=\"50.0\" text=\"Main\" textFill=\"#fcf9f9\" />\r\n" + 
		"            <JFXRadioButton id=\"questButton\" fx:id=\"inventoryButton\" layoutX=\"4.0\" layoutY=\"71.0\" onAction=\"#bringInventoryPaneToFront\" opacity=\"0.0\" prefHeight=\"60.0\" prefWidth=\"60.0\" text=\"inv\" textFill=\"#fcf9f9\" />\r\n" + 
		"            <JFXRadioButton id=\"miscButton\" fx:id=\"miscButton\" layoutX=\"5.0\" layoutY=\"144.0\" onAction=\"#bringMiscPageToFront\" opacity=\"0.0\" prefHeight=\"55.0\" prefWidth=\"57.0\" text=\"Misc\" textFill=\"#fcf9f9\" />\r\n" + 
		"         </children></AnchorPane>\r\n" + 
		"      <AnchorPane fx:id=\"mainAnchorPane\" layoutX=\"65.0\" prefHeight=\"444.0\" prefWidth=\"599.0\">\r\n" + 
		"         <children>\r\n" + 
		"            <AnchorPane fx:id=\"bottomPane\" layoutY=\"389.0\" prefHeight=\"55.0\" prefWidth=\"599.0\" style=\"-fx-background-color: #2F3136;\">\r\n" + 
		"               <children>\r\n" + 
		"                  <Label fx:id=\"title1\" layoutX=\"369.0\" layoutY=\"15.0\" text=\"SUPPORT:\" textFill=\"WHITE\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"19.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                     <effect>\r\n" + 
		"                        <Lighting>\r\n" + 
		"                           <bumpInput>\r\n" + 
		"                              <Shadow />\r\n" + 
		"                           </bumpInput>\r\n" + 
		"                           <light>\r\n" + 
		"                              <Light.Distant />\r\n" + 
		"                           </light>\r\n" + 
		"                        </Lighting>\r\n" + 
		"                     </effect>\r\n" + 
		"                  </Label>\r\n" + 
		"                  <ImageView fx:id=\"smallStartImage\" fitHeight=\"38.0\" fitWidth=\"49.0\" layoutX=\"37.0\" layoutY=\"10.0\" pickOnBounds=\"true\" preserveRatio=\"true\" />\r\n" + 
		"                  <ImageView fx:id=\"tribotImage\" fitHeight=\"36.0\" fitWidth=\"36.0\" layoutX=\"540.0\" layoutY=\"9.0\" pickOnBounds=\"true\" preserveRatio=\"true\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect></ImageView>\r\n" + 
		"                  <ImageView fx:id=\"discordImage\" fitHeight=\"38.0\" fitWidth=\"54.0\" layoutX=\"479.0\" layoutY=\"9.0\" pickOnBounds=\"true\" preserveRatio=\"true\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect></ImageView>\r\n" + 
		"                  <Button fx:id=\"tribotButton\" layoutX=\"534.0\" layoutY=\"9.0\" mnemonicParsing=\"false\" onAction=\"#tribotButtonPressed\" opacity=\"0.2\" prefHeight=\"36.0\" prefWidth=\"48.0\" style=\"-fx-background-color: #202225;\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect></Button>\r\n" + 
		"                  <Button fx:id=\"discordButton\" layoutX=\"473.0\" layoutY=\"9.0\" mnemonicParsing=\"false\" onAction=\"#tribotButtonPressed\" opacity=\"0.21\" prefHeight=\"38.0\" prefWidth=\"50.0\" style=\"-fx-background-color: #202225;\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect></Button>\r\n" + 
		"                  <Button fx:id=\"smallPlayButton\" layoutX=\"31.0\" layoutY=\"10.0\" mnemonicParsing=\"false\" onAction=\"#start\" opacity=\"0.2\" prefHeight=\"38.0\" prefWidth=\"50.0\" style=\"-fx-background-color: #202225;\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect></Button>\r\n" + 
		"               </children></AnchorPane>\r\n" + 
		"            <Pane fx:id=\"inventoryPane\" prefHeight=\"393.0\" prefWidth=\"600.0\" styleClass=\"root\">\r\n" + 
		"               <children>\r\n" + 
		"                  <Button fx:id=\"getInventoryButton\" layoutX=\"11.0\" layoutY=\"337.0\" mnemonicParsing=\"false\" onAction=\"#getInventory\" prefHeight=\"50.0\" prefWidth=\"154.0\" style=\"-fx-background-color: #202225;\" text=\"Get Inventoy\" textFill=\"#616161\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Button>\r\n" + 
		"                  <Button fx:id=\"removeInventoryButton\" layoutX=\"177.0\" layoutY=\"336.0\" mnemonicParsing=\"false\" onAction=\"#removeInventory\" prefHeight=\"50.0\" prefWidth=\"154.0\" style=\"-fx-background-color: #202225;\" text=\"Remove Inventory\" textFill=\"#616161\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Button>\r\n" + 
		"                  <Label fx:id=\"inventoryLabel\" layoutX=\"91.0\" layoutY=\"-1.0\" text=\"INVENTORY\" textFill=\"WHITE\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font size=\"22.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Label>\r\n" + 
		"                  <TextField fx:id=\"invItemField\" editable=\"false\" layoutX=\"101.0\" layoutY=\"134.0\" opacity=\"0.0\" />\r\n" + 
		"                  <TextField fx:id=\"amountTextField\" editable=\"false\" layoutX=\"101.0\" layoutY=\"159.0\" opacity=\"0.0\" />\r\n" + 
		"                  <Label fx:id=\"lootLabel\" layoutX=\"346.0\" layoutY=\"13.0\" text=\"ITEMS TO LOOT\" textFill=\"WHITE\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font size=\"22.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Label>\r\n" + 
		"                  <TextArea fx:id=\"lootTextArea\" layoutX=\"293.0\" layoutY=\"47.0\" prefHeight=\"191.0\" prefWidth=\"274.0\" />\r\n" + 
		"                  <Button fx:id=\"addItemButton\" layoutX=\"289.0\" layoutY=\"246.0\" mnemonicParsing=\"false\" onAction=\"#addItemToLootList\" prefHeight=\"38.0\" prefWidth=\"105.0\" style=\"-fx-background-color: #202225;\" text=\"Add Item\" textFill=\"#616161\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Button>\r\n" + 
		"                  <TextField fx:id=\"lootTextField\" layoutX=\"399.0\" layoutY=\"246.0\" prefHeight=\"38.0\" prefWidth=\"173.0\" style=\"-fx-background-color: #616161; -fx-border-color: black;\" text=\"Case Sensitive\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect>\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </TextField>\r\n" + 
		"                  <Rectangle fx:id=\"lootTextAreaBorder\" arcHeight=\"5.0\" arcWidth=\"5.0\" fill=\"#1f93ff00\" height=\"200.0\" layoutX=\"288.0\" layoutY=\"43.0\" stroke=\"BLACK\" strokeType=\"INSIDE\" strokeWidth=\"6.0\" width=\"283.0\" />\r\n" + 
		"                  <ImageView fx:id=\"inventoryImage\" fitHeight=\"318.0\" fitWidth=\"242.0\" layoutX=\"42.0\" layoutY=\"22.0\" pickOnBounds=\"true\" preserveRatio=\"true\" />\r\n" + 
		"                  <ImageView fx:id=\"insideInventoryImage\" fitHeight=\"243.0\" fitWidth=\"175.0\" layoutX=\"67.0\" layoutY=\"58.0\" pickOnBounds=\"true\" preserveRatio=\"true\" />\r\n" + 
		"               </children>\r\n" + 
		"            </Pane>\r\n" + 
		"            <Pane id=\"mainPane\" fx:id=\"mainPane\" prefHeight=\"393.0\" prefWidth=\"599.0\" styleClass=\"root\">\r\n" + 
		"               <children>\r\n" + 
		"                  <Label fx:id=\"title\" layoutX=\"110.0\" layoutY=\"6.0\" text=\"ELON AIO COMBAT\" textFill=\"WHITE\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold Italic\" size=\"40.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                     <effect>\r\n" + 
		"                        <Lighting>\r\n" + 
		"                           <bumpInput>\r\n" + 
		"                              <Shadow />\r\n" + 
		"                           </bumpInput>\r\n" + 
		"                           <light>\r\n" + 
		"                              <Light.Distant />\r\n" + 
		"                           </light>\r\n" + 
		"                        </Lighting>\r\n" + 
		"                     </effect>\r\n" + 
		"                  </Label>\r\n" + 
		"                  <Button id=\"loadButton\" fx:id=\"loadButton\" layoutX=\"286.0\" layoutY=\"336.0\" mnemonicParsing=\"false\" onAction=\"#load\" prefHeight=\"27.0\" prefWidth=\"283.0\" style=\"-fx-background-color: #202225;\" text=\"LOAD\" textFill=\"#616161\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect>\r\n" + 
		"                  </Button>\r\n" + 
		"                  <Button fx:id=\"startButton\" layoutX=\"21.0\" layoutY=\"304.0\" mnemonicParsing=\"false\" onAction=\"#start\" prefHeight=\"64.0\" prefWidth=\"242.0\" style=\"-fx-background-color: #202225;\" text=\"START\" textFill=\"#616161\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"20.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect>\r\n" + 
		"                  </Button>\r\n" + 
		"                  <Button fx:id=\"saveButton\" layoutX=\"286.0\" layoutY=\"304.0\" mnemonicParsing=\"false\" onAction=\"#save\" prefHeight=\"27.0\" prefWidth=\"120.0\" style=\"-fx-background-color: #202225;\" text=\"SAVE\" textFill=\"#616161\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"12.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect>\r\n" + 
		"                  </Button>\r\n" + 
		"                  <TextField fx:id=\"saveTextField\" layoutX=\"412.0\" layoutY=\"304.0\" prefHeight=\"27.0\" prefWidth=\"155.0\" style=\"-fx-background-color: #616161; -fx-border-color: black;\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect></TextField>\r\n" + 
		"                  <TextField fx:id=\"targetTextField\" layoutX=\"31.0\" layoutY=\"141.0\" prefHeight=\"42.0\" prefWidth=\"216.0\" style=\"-fx-background-color: #616161; -fx-border-color: black;\" text=\"Case Sensitive\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect>\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </TextField>\r\n" + 
		"                  <Label fx:id=\"targetLabel\" layoutX=\"90.0\" layoutY=\"108.0\" text=\"TARGET\" textFill=\"#110d0d\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font size=\"26.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Label>\r\n" + 
		"                  <Label fx:id=\"combatAreaLabel\" layoutX=\"360.0\" layoutY=\"108.0\" text=\"COMBAT AREA\" textFill=\"#110d0d\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font size=\"26.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Label>\r\n" + 
		"                  <TextField fx:id=\"combatAreaTextField\" layoutX=\"340.0\" layoutY=\"141.0\" prefHeight=\"42.0\" prefWidth=\"216.0\" style=\"-fx-background-color: #616161; -fx-border-color: black;\" text=\"Click Area Button\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect>\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </TextField>\r\n" + 
		"                  <Button fx:id=\"AreaButton\" layoutX=\"342.0\" layoutY=\"192.0\" mnemonicParsing=\"false\" onAction=\"#areaButtonPressed\" prefHeight=\"30.0\" prefWidth=\"216.0\" style=\"-fx-background-color: #202225;\" text=\"AREA BUTTON\" textFill=\"#616161\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect>\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Button>\r\n" + 
		"               </children>\r\n" + 
		"            </Pane>\r\n" + 
		"            <Pane id=\"misc_pane\" fx:id=\"miscPane\" prefHeight=\"393.0\" prefWidth=\"599.0\" styleClass=\"root\">\r\n" + 
		"               <children>\r\n" + 
		"                  <Label fx:id=\"eatAtTitle\" layoutX=\"108.0\" layoutY=\"42.0\" text=\"EAT AT\" textFill=\"WHITE\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"20.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Label>\r\n" + 
		"                  <CheckBox fx:id=\"disableDelayCheckBox\" layoutX=\"14.0\" layoutY=\"173.0\" mnemonicParsing=\"false\" text=\"Disable ABC2 Delay\" textFill=\"WHITE\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"18.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </CheckBox>\r\n" + 
		"                  <ImageView fx:id=\"eatAtImage\" fitHeight=\"58.0\" fitWidth=\"65.0\" layoutX=\"14.0\" layoutY=\"28.0\" pickOnBounds=\"true\" preserveRatio=\"true\" />\r\n" + 
		"                  <TextField fx:id=\"eatAtField\" layoutX=\"193.0\" layoutY=\"36.0\" prefHeight=\"42.0\" prefWidth=\"65.0\" style=\"-fx-background-color: #616161; -fx-border-color: black;\" text=\"45\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect>\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </TextField>\r\n" + 
		"                  <Label fx:id=\"percentTitle\" layoutX=\"237.0\" layoutY=\"47.0\" text=\"\\%\" textFill=\"WHITE\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Label>         \r\n" + 
		"               </children>\r\n" + 
		"            </Pane>\r\n" + 
		"         </children></AnchorPane>\r\n" + 
		"   </children>\r\n" + 
		"</AnchorPane>";


public static String getStyleSheet = ".root {\r\n" + 
		"    -fx-background-image:url(https://i.imgur.com/67OkR2B.png);\r\n" + 
		"-fx-control-inner-background: rgb(20, 20, 20);\r\n" + 
		"}\r\n" + 
		".circleCheckBox > .box{\r\n" + 
		"	-fx-padding: 30px;\r\n" + 
		"}\r\n" + 
		".text-area .content {\r\n" + 
		"    -fx-background-color:  #616161;\r\n" + 
		"}";





}
