package scripts.firemaking.gui;

public class GuiFXML {

public static String get = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
		"\r\n" + 
		"<?import javafx.scene.control.Button?>\r\n" + 
		"<?import javafx.scene.control.ComboBox?>\r\n" + 
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
		"<?import javafx.scene.text.Font?>\r\n" + 
		"\r\n" + 
		"<AnchorPane fx:id=\"rootPane\" prefHeight=\"445.0\" prefWidth=\"580.0\" xmlns=\"http://javafx.com/javafx/8.0.171\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"scripts.firemaking.gui.GUIController\">\r\n" + 
		"   <children>\r\n" + 
		"      <AnchorPane fx:id=\"mainAnchorPane\" prefHeight=\"444.0\" prefWidth=\"603.0\">\r\n" + 
		"         <children>\r\n" + 
		"            <AnchorPane fx:id=\"bottomPane\" layoutY=\"389.0\" prefHeight=\"55.0\" prefWidth=\"599.0\" style=\"-fx-background-color: #2F3136;\">\r\n" + 
		"               <children>\r\n" + 
		"                  <Label fx:id=\"supportLabel\" layoutX=\"369.0\" layoutY=\"15.0\" text=\"SUPPORT:\" textFill=\"WHITE\">\r\n" + 
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
		"                  <Button fx:id=\"discordButton\" layoutX=\"473.0\" layoutY=\"9.0\" mnemonicParsing=\"false\" onAction=\"#discordButtonPressed\" opacity=\"0.21\" prefHeight=\"38.0\" prefWidth=\"50.0\" style=\"-fx-background-color: #202225;\">\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect></Button>\r\n" + 
		"                  <Label fx:id=\"infoLabel\" layoutX=\"16.0\" layoutY=\"18.0\" text=\"Automatically Burns best log in Logs To Burn List\" textFill=\"WHITE\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Label>\r\n" + 
		"               </children></AnchorPane>\r\n" + 
		"            <Pane id=\"mainPane\" fx:id=\"mainPane\" prefHeight=\"393.0\" prefWidth=\"599.0\" styleClass=\"root\">\r\n" + 
		"               <children>\r\n" + 
		"                  <Label fx:id=\"title\" layoutX=\"152.0\" layoutY=\"4.0\" text=\"Elon FireMaking\" textFill=\"#eb7507\">\r\n" + 
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
		"                     </effect>\r\n" + 
		"                  </TextField>\r\n" + 
		"                  <ComboBox fx:id=\"logComboBox\" layoutX=\"47.0\" layoutY=\"144.0\" prefWidth=\"150.0\" />\r\n" + 
		"                  <Label fx:id=\"logLabel\" layoutX=\"88.0\" layoutY=\"111.0\" text=\"LOGS\" textFill=\"#111010\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"24.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Label>\r\n" + 
		"                  <Label fx:id=\"logListLabel\" layoutX=\"300.0\" layoutY=\"76.0\" text=\"LOGS TO BURN LIST\" textFill=\"#030303\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"24.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                  </Label>\r\n" + 
		"                  <TextArea fx:id=\"logTextArea\" editable=\"false\" layoutX=\"256.0\" layoutY=\"109.0\" prefHeight=\"174.0\" prefWidth=\"318.0\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"14.0\" />\r\n" + 
		"                     </font></TextArea>\r\n" + 
		"                  <Button fx:id=\"addLogButton\" layoutX=\"44.0\" layoutY=\"175.0\" mnemonicParsing=\"false\" onAction=\"#addLogToLogList\" prefHeight=\"32.0\" prefWidth=\"155.0\" style=\"-fx-background-color: #202225;\" text=\"Add Log To List\" textFill=\"#219a0b\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect>\r\n" + 
		"                  </Button>\r\n" + 
		"                  <Button fx:id=\"clearListButton\" layoutX=\"45.0\" layoutY=\"217.0\" mnemonicParsing=\"false\" onAction=\"#clearLogList\" prefHeight=\"32.0\" prefWidth=\"155.0\" style=\"-fx-background-color: #202225;\" text=\"Clear List\" textFill=\"#c30606\">\r\n" + 
		"                     <font>\r\n" + 
		"                        <Font name=\"System Bold\" size=\"14.0\" />\r\n" + 
		"                     </font>\r\n" + 
		"                     <effect>\r\n" + 
		"                        <InnerShadow />\r\n" + 
		"                     </effect>\r\n" + 
		"                  </Button>\r\n" + 
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
