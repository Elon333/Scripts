package scripts.combat;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Ending;
import org.tribot.script.interfaces.Painting;
import org.tribot.script.interfaces.Starting;

import scripts.combat.data.Node;
import scripts.combat.data.Utils2;
import scripts.combat.data.Vars;
import scripts.combat.gui.GUI;
import scripts.combat.gui.GuiFXML;
import scripts.combat.paint.Paint;

import scripts.combat.tasks.Bank;
import scripts.combat.tasks.Fight;
import scripts.combat.tasks.Travel;
import scripts.dax_api.api_lib.DaxWalker;
import scripts.dax_api.api_lib.models.DaxCredentials;
import scripts.dax_api.api_lib.models.DaxCredentialsProvider;
import scripts.utilty.AntiBan;
import scripts.utilty.Timer;

@ScriptManifest(authors = { "ELON" }, category = "combat", name = "Elon aio combat")
public class Main extends Script implements Starting, Ending, Painting {

	private List<Node> combatNodes = Arrays.asList(new Bank(), new Travel(), new Fight());

	private Timer safteyTimer = new Timer(General.random(480000, 600000));

	private GUI gui;
	private URL css;



	@Override
	public void onStart() {
		DaxWalker.setCredentials(new DaxCredentialsProvider() {
			@Override
			public DaxCredentials getDaxCredentials() {
				return new DaxCredentials("sub_DPjXXzL5DeSiPf", "PUBLIC-KEY");
			}
		});
		AntiBan.create();
		Vars.get().startTime = Timing.currentTimeMillis();
	}



	@Override
	public void run() {
		Utils2.createFolder();

		css = Utils2.createCssFile();
		gui = new GUI(GuiFXML.get, css);

		gui.show();

		while (gui.isOpen()) {
			sleep(500);
		}

        Utils2.recordExp();
		
		while (Vars.get().script && safteyTimer.isRunning()) {

			for (final Node node : combatNodes) {

				if (Vars.get().script && node.validate()) {

					Utils2.recordExp();

					if (Vars.get().nodeName != node.getName()) {
						safteyTimer.reset();
						General.println(node.getName());
					}

					Vars.get().nodeName = node.getName();

					node.execute();

					if (Utils2.checkExp())
						safteyTimer.reset();

					if (!safteyTimer.isRunning()) {
						General.println("Script Timed Out");
						Vars.get().script = false;
					}
				}
				General.sleep(20, 40);
			}
		}
	}



	@Override
	public void onEnd() {
		AntiBan.destroy();
		if (gui != null && gui.isOpen())
			gui.close();
		println("Thanks for using Elon AIO Combat! Please leave feedback on the fourms.");
	}



	@Override
	public void onPaint(Graphics g) {
		Paint.paint(g);
	}



	
}